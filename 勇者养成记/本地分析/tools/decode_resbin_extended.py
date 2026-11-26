"""Offline evidence-gated recursive resbin decoder. Never executes APK/native code.

All output is confined to derived/config-extended. See --help for static inspection.
"""
from __future__ import annotations
import argparse
import bisect
import collections
import csv
import hashlib
import json
import math
import os
from pathlib import Path
import re
import struct
import sys
import zlib

ROOT = Path(__file__).resolve().parents[1]
OUT = ROOT / 'derived/config-extended'
sys.path.insert(0, str(ROOT / 'tools/python-packages'))
PRIMITIVES = {
    'byte': ('B', 'readUInt8'), 'short': ('h', 'readInt16'),
    'ushort': ('H', 'readUInt16'), 'int': ('i', 'readInt32'),
    'uint': ('I', 'readUInt32'), 'long': ('q', 'readInt64'),
    'ulong': ('Q', 'readUInt64'), 'float': ('f', 'readFloat'),
    'FP': ('q', 'readInt64'), 'string': (None, 'readString'),
}


def load_metadata():
    text = (ROOT / 'derived/il2cpp/arm64-v8a/dump.cs').read_text(encoding='utf-8-sig')
    schemas, enums = {}, {}
    for match in re.finditer(r'^// Namespace: ([^\n]*)\n((?:(?!^// Namespace: ).*\n)*)', text, re.M):
        ns, block = match.groups()
        ns = ns.strip()
        if ns not in ('ResDef', 'BattleCore'):
            continue
        cm = re.search(r'^\w+(?: \w+)* class (\w+) : (?:BProtoBaseStruct|ProtoBaseStruct) ', block, re.M)
        em = re.search(r'^\w+ enum (\w+) ', block, re.M)
        if em:
            underlying = re.search(r'public (\w+) value__;', block)
            enums[(ns, em[1])] = {'namespace': ns, 'name': em[1], 'underlying': underlying[1] if underlying else None,
                'values': {n: int(v) for n, v in re.findall(r'public const \w+ (\w+) = (-?\d+);', block)}}
        if not cm:
            continue
        fields = re.findall(r'^\s*public ([\w<>\[\].]+) (\w+); // (0x[0-9A-F]+)', block.split('// Methods')[0], re.M)
        unpack = re.search(r'// RVA: (0x[0-9A-F]+)[^\n]*\n\s*public [^\n]* unpack\(', block)
        if unpack and fields:
            schemas[(ns, cm[1])] = {'namespace': ns, 'name': cm[1],
                'fields': [{'type': t, 'name': n, 'object_offset': int(o, 16)} for t, n, o in fields],
                'unpack_va': int(unpack[1], 16), 'dump_line': text.count('\n', 0, match.start()) + 1}
    rb = re.search(r'^public class PbReadBuf .*?^}', text, re.M | re.S)[0]
    readers = {int(a, 16): n for a, n in re.findall(r'// RVA: (0x[0-9A-F]+)[^\n]*\n\s*public PbError.ErrorType (read\w+)\(out \w+ dest(?:, int maxStrSize)?\)', rb)}
    return schemas, enums, readers


class Native:
    def __init__(self):
        import capstone
        self.cs = capstone.Cs(capstone.CS_ARCH_ARM64, capstone.CS_MODE_ARM)
        self.cs.detail = True
        self.binary = (ROOT / 'unpacked/lib/arm64-v8a/libil2cpp.so').read_bytes()
        if self.binary[:5] != b'\x7fELF\x02':
            raise ValueError('Expected ELF64')
        phoff = struct.unpack_from('<Q', self.binary, 32)[0]
        entsize, count = struct.unpack_from('<HH', self.binary, 54)
        self.segments = []
        for i in range(count):
            typ, _, off, va, _, size, _, _ = struct.unpack_from('<IIQQQQQQ', self.binary, phoff+i*entsize)
            if typ == 1:
                self.segments.append((va, va+size, off))
        script = json.loads((ROOT / 'derived/il2cpp/arm64-v8a/script.json').read_text(encoding='utf-8'))
        self.names = collections.defaultdict(list)
        for method in script['ScriptMethod']:
            self.names[method['Address']].append(method['Name'])
        self.addresses = sorted(self.names)

    def offset(self, va):
        for a, b, off in self.segments:
            if a <= va < b:
                return va-a+off
        raise ValueError('Unmapped VA ' + hex(va))

    def instructions(self, va):
        i = bisect.bisect_right(self.addresses, va)
        end = self.addresses[i] if i < len(self.addresses) else va + 65536
        if end-va > 65536:
            raise ValueError('Native method exceeds 64KB analysis limit')
        off = self.offset(va)
        result = list(self.cs.disasm(self.binary[off:off+end-va], va))
        if not result or result[-1].address+4 != end:
            raise ValueError('Incomplete disassembly')
        return result

    def disassembly(self, va):
        lines = []
        for ins in self.instructions(va):
            note = ''
            if ins.mnemonic in ('bl', 'b') and ins.operands:
                note = ' ; ' + ' | '.join(self.names.get(ins.operands[0].imm, []))
            lines.append(f'{ins.address:#x}: {ins.mnemonic:9} {ins.op_str}{note}')
        return '\n'.join(lines)


class EvidenceError(ValueError):
    pass


class NativeAnalyzer:
    """Constrained static successful-path interpreter, NOT native execution.

    Loop counters are concrete instruction immediates. Buffer contents stay symbolic;
    a data-dependent loop/branch cannot be resolved and rejects the candidate.
    Null and managed-array bounds paths are allowed only as stated assumptions.
    """
    MAX_STEPS = 200000
    MAX_EVENTS = 16384
    MAX_ARRAY = 4096

    def __init__(self, native, schemas, enums, readers):
        self.native, self.schemas, self.enums, self.readers = native, schemas, enums, readers
        self.by_va = {s['unpack_va']: key for key, s in schemas.items()}
        self.cache, self.failures = {}, {}

    @staticmethod
    def add(a, b):
        if isinstance(a, int) and isinstance(b, int):
            return a+b
        if isinstance(a, tuple) and isinstance(b, int):
            if a[0] in ('self', 'stack', 'buffer'):
                return (a[0], a[1]+b)
            if a[0] == 'field':
                return ('arrayptr', a[1], b)
            if a[0] == 'arrayptr':
                return (a[0], a[1], a[2]+b)
        if isinstance(a, int) and isinstance(b, tuple):
            return NativeAnalyzer.add(b, a)
        return None

    def trace(self, schema):
        import capstone.arm64 as arm
        instructions = self.native.instructions(schema['unpack_va'])
        code = {i.address: i for i in instructions}
        fields = {f['object_offset']: f for f in schema['fields']}
        regs = {'x0': ('self', 0), 'x1': ('buffer', 0), 'x2': 1,
                'x3': ('stack_arg', 0), 'sp': ('stack', 0)}
        memory, memory_widths, events, branches, writes = {}, {}, [], [], []
        reader_widths = {reader: (8 if fmt is None else struct.calcsize(fmt))
                         for fmt, reader in PRIMITIVES.values()}
        last_cmp = None

        def regname(reg):
            name = self.native.cs.reg_name(reg)
            if name.startswith('w') and name[1:].isdigit():
                return 'x'+name[1:]
            return {'wsp': 'sp', 'wzr': 'xzr', 'fp': 'x29', 'lr': 'x30'}.get(name, name)

        def narrow_w(value):
            if isinstance(value, int):
                return value & 0xffffffff
            if isinstance(value, tuple):
                if value[0] == 'arraylen':
                    return value  # Managed array length is an actual uint32 load.
                if value[0] == 'read_result' and reader_widths.get(events[value[1]].get('reader'), 8) <= 4:
                    return value  # Exact-width scalar, never a pointer provenance token.
                raise EvidenceError('Symbolic pointer/value truncated through W register')
            return value

        def getreg(reg):
            name = regname(reg)
            value = 0 if name == 'xzr' else regs.get(name)
            return narrow_w(value) if self.native.cs.reg_name(reg).startswith('w') else value

        def putreg(reg, value):
            name = regname(reg)
            if name == 'xzr':
                return
            if self.native.cs.reg_name(reg).startswith('w'):
                value = narrow_w(value)
            elif isinstance(value, int):
                value &= 0xffffffffffffffff
            regs[name] = value

        def operand(op):
            if op.ext or (op.shift.type and op.shift.type != arm.ARM64_SFT_LSL):
                raise EvidenceError('Unsupported native operand extension/shift')
            if op.type == arm.ARM64_OP_IMM:
                value = op.imm
            elif op.type == arm.ARM64_OP_REG:
                value = getreg(op.reg)
            else:
                return None
            if op.shift.value:
                if not isinstance(value, int) or op.shift.type != arm.ARM64_SFT_LSL:
                    return None
                value <<= op.shift.value
            return value

        def memaddr(op):
            if op.type != arm.ARM64_OP_MEM or op.ext or (op.shift.type and op.shift.type != arm.ARM64_SFT_LSL):
                raise EvidenceError('Unsupported native memory addressing mode')
            value = self.add(getreg(op.mem.base), op.mem.disp)
            if op.mem.index:
                idx = getreg(op.mem.index)
                if not isinstance(idx, int):
                    return None
                if op.shift.value:
                    idx <<= op.shift.value
                value = self.add(value, idx)
            return value

        def memory_region(address):
            if isinstance(address, tuple) and address[0] in ('self', 'stack', 'buffer'):
                return address[0], address[1]
            if isinstance(address, tuple) and address[0] == 'arrayptr':
                return ('arrayptr', address[1]), address[2]
            return None

        def store_memory(address, value, width):
            region = memory_region(address)
            if region is None or width not in (1, 2, 4, 8):
                raise EvidenceError('Unsupported native memory store destination/width')
            # An overlapping write invalidates the entire old symbolic value.
            for old in list(memory):
                previous = memory_region(old)
                if previous and previous[0] == region[0] and previous[1] < region[1]+width and region[1] < previous[1]+memory_widths[old]:
                    del memory[old]
                    del memory_widths[old]
            if isinstance(value, int):
                value &= (1 << (8*width))-1
            memory[address], memory_widths[address] = value, width

        def load(address, width):
            if address in memory:
                if memory_widths[address] != width:
                    raise EvidenceError('Native memory load width mismatch')
                return memory[address]
            if isinstance(address, tuple):
                if address[0] == 'self':
                    f = fields.get(address[1])
                    if f and (f['type'].endswith('[]') or (schema['namespace'], f['type']) in self.schemas):
                        if width != 8:
                            raise EvidenceError('Reference field load is not full pointer width')
                        return ('field', address[1])
                if address[0] == 'arrayptr':
                    off, indexbyte = address[1:]
                    if indexbyte == 0x18 and width == 4:
                        return ('arraylen', off)
                    if indexbyte >= 0x20 and (indexbyte-0x20) % 8 == 0 and width == 8:
                        return ('element', off, (indexbyte-0x20)//8)
                if address[0] == 'field':
                    return None
            return None

        def nonzero(value):
            if isinstance(value, int):
                return value != 0
            if isinstance(value, tuple) and value[0] in ('self', 'field', 'element', 'arrayptr', 'buffer', 'stack', 'stack_arg'):
                return True
            raise EvidenceError('Data-dependent/unknown CBZ condition')

        pc, steps = schema['unpack_va'], 0
        while True:
            steps += 1
            if steps > self.MAX_STEPS or len(events) > self.MAX_EVENTS:
                raise EvidenceError('Static trace step/event limit')
            ins = code.get(pc)
            if ins is None:
                raise EvidenceError('Control flow leaves recovered method without known tail call: '+hex(pc))
            op, ops = ins.mnemonic, ins.operands
            nextpc = pc+4
            if op in ('bl', 'b') and ops and ops[0].type == arm.ARM64_OP_IMM:
                target = ops[0].imm
                if op == 'b' and target in code:
                    nextpc = target
                else:
                    event = {'instruction_va': hex(pc), 'target_va': hex(target),
                             'target_names': self.native.names.get(target, []), 'opcode': op.upper()}
                    if target in self.readers:
                        if regs.get('x0') != ('buffer', 0):
                            raise EvidenceError('Reader receiver not original buffer at '+hex(pc))
                        event.update(kind='reader', reader=self.readers[target], destination=regs.get('x1'))
                        if self.readers[target] == 'readString':
                            maximum = regs.get('x2')
                            if not isinstance(maximum, int) or not 1 <= maximum <= 1000000:
                                raise EvidenceError('String maxStrSize unresolved')
                            event['max_string_size'] = maximum
                        dest = regs.get('x1')
                        if dest is None:
                            raise EvidenceError('Unknown reader destination at '+hex(pc))
                        store_memory(dest, ('read_result', len(events)), reader_widths.get(self.readers[target], 0))
                    elif target in self.by_va:
                        if regs.get('x1') != ('buffer', 0):
                            raise EvidenceError('Nested buffer provenance mismatch at '+hex(pc))
                        event.update(kind='nested', nested_schema='.'.join(self.by_va[target]),
                                     destination=regs.get('x0'), cut_version=regs.get('x2'))
                        if regs.get('x2') != 1:
                            raise EvidenceError('Nested cut version not statically 1 at '+hex(pc))
                    else:
                        raise EvidenceError('Unknown reachable call '+hex(target)+' at '+hex(pc))
                    events.append(event)
                    # AAPCS64 call clobbers; reader/nested success is a path predicate.
                    for r in list(regs):
                        if r.startswith('x') and r[1:].isdigit() and (int(r[1:]) <= 18 or r == 'x30'):
                            regs.pop(r)
                    regs['x0'] = 0
                    last_cmp = None
                    if op == 'b':
                        break
            elif op in ('cbz', 'cbnz'):
                value = operand(ops[0])
                if isinstance(value, tuple) and value[0] == 'arraylen':
                    take = op == 'cbnz'
                    branches.append({'instruction_va': hex(pc), 'kind': 'managed-array-nonempty-assumption', 'array_field_offset': value[1], 'index': 0})
                else:
                    take = nonzero(value) == (op == 'cbnz')
                if take:
                    nextpc = ops[1].imm
            elif op.startswith('b.'):
                if last_cmp is None:
                    raise EvidenceError('Unknown flags at '+hex(pc))
                a, b, width, cmp_pc = last_cmp
                cond = op[2:]
                if isinstance(a, int) and isinstance(b, int):
                    mask = (1 << width)-1
                    au, bu = a & mask, b & mask
                    sign = 1 << (width-1)
                    av, bv = (au ^ sign)-sign, (bu ^ sign)-sign
                    decisions = {'lt': av < bv, 'le': av <= bv, 'gt': av > bv, 'ge': av >= bv,
                                 'lo': au < bu, 'hs': au >= bu, 'hi': au > bu, 'ls': au <= bu,
                                 'eq': au == bu, 'ne': au != bu}
                    if cond not in decisions:
                        raise EvidenceError('Unsupported comparison condition '+cond)
                    take = decisions[cond]
                elif isinstance(a, int) and 0 <= a <= self.MAX_ARRAY and isinstance(b, tuple) and b[0] == 'arraylen' and cond in ('lo', 'hs'):
                    # Generated managed bounds check: only successful valid-array branch.
                    take = cond == 'lo'
                    branches.append({'instruction_va': hex(pc), 'cmp_va': hex(cmp_pc),
                                     'kind': 'managed-array-valid-bounds-assumption', 'array_field_offset': b[1], 'index': a})
                else:
                    raise EvidenceError('Data-dependent/unknown branch at '+hex(pc)+': '+repr((a, b)))
                if ops[0].imm <= pc:
                    branches.append({'instruction_va': hex(pc), 'target_va': hex(ops[0].imm),
                                     'kind': 'concrete-loop-test', 'left': a, 'right': b, 'condition': cond, 'taken': take})
                if take:
                    nextpc = ops[0].imm
            elif op == 'ret':
                if regs.get('x0') != 0:
                    raise EvidenceError('Successful return not proven')
                break
            elif op == 'mov':
                putreg(ops[0].reg, operand(ops[1]))
            elif op in ('add', 'sub'):
                b = operand(ops[2])
                if op == 'sub':
                    b = -b if isinstance(b, int) else None
                putreg(ops[0].reg, self.add(operand(ops[1]), b))
            elif op == 'cmp':
                width = 32 if self.native.cs.reg_name(ops[0].reg).startswith('w') else 64
                last_cmp = (operand(ops[0]), operand(ops[1]), width, pc)
            elif op in ('ldr', 'ldur', 'ldrb', 'ldrh', 'ldp', 'str', 'stur', 'strb', 'strh', 'stp'):
                pair = op in ('ldp', 'stp')
                memidx = 2 if pair else 1
                address = memaddr(ops[memidx])
                width = 1 if op.endswith('b') else 2 if op.endswith('h') else 8 if self.native.cs.reg_name(ops[0].reg).startswith('x') else 4
                for i in range(2 if pair else 1):
                    addr = self.add(address, i*width)
                    if op.startswith('ld'):
                        putreg(ops[i].reg, load(addr, width))
                    else:
                        value = operand(ops[i])
                        if not isinstance(addr, tuple) or addr[0] not in ('stack', 'self'):
                            raise EvidenceError('Unmodeled native store side effect at '+hex(pc))
                        if addr[0] == 'self':
                            if not isinstance(value, tuple) or value[0] != 'read_result':
                                raise EvidenceError('Unproven native object store at '+hex(pc))
                            source = events[value[1]]
                            if source['destination'][0] != 'stack' or reader_widths.get(source.get('reader')) != width:
                                raise EvidenceError('Native read-result store provenance/width mismatch')
                            writes.append({'instruction_va': hex(pc), 'object_offset': addr[1], 'event_index': value[1], 'store_width': width})
                        store_memory(addr, value, width)
                if ins.writeback:
                    base = ops[memidx].mem.base
                    if len(ops) > memidx+1:
                        putreg(base, self.add(getreg(base), operand(ops[memidx+1])))
                    else:
                        putreg(base, address)
            elif op == 'nop':
                pass
            else:
                raise EvidenceError('Unsupported instruction '+op+' '+ins.op_str+' at '+hex(pc))
            pc = nextpc
        # Resolve stack-temporary enum reads only through a native read->load->store chain.
        for w in writes:
            event = events[w['event_index']]
            if event['destination'][0] != 'stack':
                raise EvidenceError('Unexpected nonstack read/store alias')
            event['temporary_destination'] = event['destination']
            event['destination'] = ('self', w['object_offset'])
            event['enum_store_evidence'] = w
        return events, branches, steps

    def loop_evidence(self, schema, branches):
        instructions = self.native.instructions(schema['unpack_va'])
        def record(ins):
            return {'instruction_va': hex(ins.address), 'bytes': bytes(ins.bytes).hex(),
                    'mnemonic': ins.mnemonic, 'operands': ins.op_str}
        grouped = collections.defaultdict(list)
        for branch in branches:
            if branch['kind'] == 'concrete-loop-test':
                grouped[branch['instruction_va']].append(branch)
        loops = []
        for branch_va, tests in grouped.items():
            end = int(branch_va, 16)
            start = int(tests[0]['target_va'], 16)
            body = [i for i in instructions if start <= i.address <= end]
            # Exact preheader instructions, not inferred metadata or payload-derived size.
            before = [i for i in instructions if i.address < start]
            boundary = max((j+1 for j, ins in enumerate(before) if ins.mnemonic in ('bl', 'b')), default=0)
            preheader = before[boundary:]
            loops.append({'backedge_va': branch_va, 'body_start_va': hex(start),
                          'body': [record(i) for i in body], 'preheader_initialization': [record(i) for i in preheader],
                          'index_stride_updates': [record(i) for i in body if i.mnemonic in ('add', 'sub') and len(i.operands) >= 2 and i.operands[0].type == 1 and i.operands[1].type == 1 and i.operands[0].reg == i.operands[1].reg],
                          'compare_instructions': [record(i) for i in body if i.mnemonic == 'cmp'],
                          'concrete_tests_in_order': tests, 'trip_count': len(tests)})
        return loops

    def analyze(self, key, depth=0):
        if key in self.cache:
            return self.cache[key]
        if key in self.failures:
            raise EvidenceError(self.failures[key])
        if depth > 24:
            raise EvidenceError('Native schema recursion limit')
        schema = self.schemas[key]
        try:
            events, branches, steps = self.trace(schema)
            remaining = list(events)
            layout = []
            for field in schema['fields']:
                off, typ = field['object_offset'], field['type']
                array = typ.endswith('[]')
                base = typ[:-2] if array else typ
                matching = []
                while remaining:
                    dest = remaining[0]['destination']
                    if (not array and dest in (('self', off), ('field', off))) or (array and dest and dest[0] in ('arrayptr', 'element') and dest[1] == off):
                        matching.append(remaining.pop(0))
                    else:
                        break
                if not matching or (not array and len(matching) != 1):
                    raise EvidenceError('Missing/ambiguous native events for '+field['name'])
                if len(matching) > self.MAX_ARRAY:
                    raise EvidenceError('Array exceeds tool limit')
                primitive = PRIMITIVES.get(base)
                enum = self.enums.get((key[0], base))
                if primitive is None and enum:
                    # Reader wire width comes from calls, not enum metadata storage.
                    first_reader = matching[0].get('reader')
                    candidates = [t for t, p in PRIMITIVES.items() if p[1] == first_reader and t not in ('FP', 'string', 'float')]
                    if len(candidates) != 1:
                        raise EvidenceError('Enum wire reader unresolved')
                    wire_type = candidates[0]
                    primitive = PRIMITIVES[wire_type]
                else:
                    wire_type = base
                entry = {**field, 'wire_type': wire_type, 'kind': 'array' if array else 'scalar',
                         'count': len(matching) if array else 1, 'count_encoding': 'none-native-fixed' if array else None,
                         'native_calls': matching}
                if primitive:
                    if any(e['kind'] != 'reader' or e['reader'] != primitive[1] for e in matching):
                        raise EvidenceError('Native reader/type mismatch '+field['name'])
                    if array:
                        size = 8 if base == 'string' else struct.calcsize(primitive[0])
                        if [e['destination'] for e in matching] != [('arrayptr', off, 0x20+i*size) for i in range(len(matching))]:
                            raise EvidenceError('Noncontiguous/native array stride mismatch '+field['name'])
                    if base == 'string':
                        entry['max_string_size'] = min(e['max_string_size'] for e in matching)
                    if enum:
                        entry['enum'] = enum
                else:
                    nested_key = (key[0], base)
                    if nested_key not in self.schemas:
                        raise EvidenceError('No matching nested schema '+'.'.join(nested_key))
                    if any(e['kind'] != 'nested' or e['nested_schema'] != '.'.join(nested_key) for e in matching):
                        raise EvidenceError('Native nested callee/type mismatch '+field['name'])
                    if array and [e['destination'] for e in matching] != [('element', off, i) for i in range(len(matching))]:
                        raise EvidenceError('Noncontiguous native nested array indices '+field['name'])
                    self.analyze(nested_key, depth+1)
                    entry['nested_schema'] = '.'.join(nested_key)
                layout.append(entry)
            if remaining:
                raise EvidenceError('Unmatched native buffer-consuming events')
            result = {**schema, 'layout': layout,
                      'native_evidence': {'method_start_va': hex(schema['unpack_va']),
                                          'instruction_steps': steps, 'event_count': len(events),
                                          'branch_evidence': branches,
                                          'loops': self.loop_evidence(schema, branches),
                                          'instruction_sha256': hashlib.sha256(b''.join(bytes(i.bytes) for i in self.native.instructions(schema['unpack_va']))).hexdigest(),
                                          'gate': 'concrete-success-path; all sequential readers/nested callees; full field/destination/stride matching',
                                          'assumptions': ['non-null input buffer and created nested objects/arrays', 'managed array bounds valid', 'AAPCS64 callee-saved register preservation', 'reader and nested call success; version 1 only']}}
            self.cache[key] = result
            return result
        except EvidenceError as exc:
            self.failures[key] = str(exc)
            raise


MAX_DEPTH = 24
MAX_COUNT = 2_000_000
MAX_NODES = 10_000_000
MAX_FILE_SIZE = 256 * 1024 * 1024
MAX_STRING_SIZE = 1_000_000


class DecodeError(ValueError):
    pass


def field_key(field):
    return field['name'] + ('__raw_int64' if field['type'].removesuffix('[]') == 'FP' else '')


def check_header(data):
    if not 20 <= len(data) <= MAX_FILE_SIZE:
        raise DecodeError('File size outside bounded header/file limits')
    tag, size, version, count, crc = struct.unpack_from('>5I', data)
    actual = zlib.crc32(data[20:]) ^ 0xffffffff
    if tag != 0x2def or size != len(data) or version != 1 or crc != actual:
        raise DecodeError('Header tag/size/version/inverted-CRC mismatch')
    if count > MAX_COUNT:
        raise DecodeError('Header record count exceeds tool bound')
    return {'tag': hex(tag), 'file_size': size, 'version': version, 'record_count': count,
            'stored_crc32': f'{crc:08x}', 'computed_inverted_crc32': f'{actual:08x}'}


class Codec:
    def __init__(self, schemas):
        self.schemas = schemas
        self.min_sizes = {}

    def minimum_size(self, name, depth=0):
        if depth > MAX_DEPTH:
            raise DecodeError('Minimum-size recursion limit')
        if name in self.min_sizes:
            return self.min_sizes[name]
        size = 0
        for field in self.schemas[name]['layout']:
            count = field['count']
            if not isinstance(count, int) or not 1 <= count <= NativeAnalyzer.MAX_ARRAY:
                raise DecodeError('Invalid fixed native count')
            if 'nested_schema' in field:
                itemsize = self.minimum_size(field['nested_schema'], depth+1)
            elif field['wire_type'] == 'string':
                itemsize = 5
            elif field['wire_type'] in PRIMITIVES:
                itemsize = struct.calcsize(PRIMITIVES[field['wire_type']][0])
            else:
                raise DecodeError('Unknown wire type')
            size += count*itemsize
        if size <= 0:
            raise DecodeError('Empty layout')
        self.min_sizes[name] = size
        return size

    def decode(self, data, name):
        header = check_header(data)
        if header['record_count'] * self.minimum_size(name) > len(data)-20:
            raise DecodeError('Count * minimum record size exceeds payload')
        pos, nodes = 20, 0
        def consume(n):
            nonlocal pos
            if n < 0 or pos+n > len(data):
                raise DecodeError('Truncated value at '+str(pos))
            start = pos
            pos += n
            return data[start:pos]
        def decode_object(schema_name, depth):
            nonlocal nodes
            if depth > MAX_DEPTH:
                raise DecodeError('Nested depth limit')
            obj = {}
            for field in self.schemas[schema_name]['layout']:
                count = field['count']
                if not 1 <= count <= NativeAnalyzer.MAX_ARRAY:
                    raise DecodeError('Array count bound')
                values = []
                for _ in range(count):
                    nodes += 1
                    if nodes > MAX_NODES:
                        raise DecodeError('Total decoded node bound')
                    if 'nested_schema' in field:
                        value = decode_object(field['nested_schema'], depth+1)
                    elif field['wire_type'] == 'string':
                        length = struct.unpack('>i', consume(4))[0]
                        if not 1 <= length <= min(field.get('max_string_size', MAX_STRING_SIZE), MAX_STRING_SIZE):
                            raise DecodeError('String length outside native/tool bounds')
                        raw = consume(length)
                        if raw[-1:] != b'\x00':
                            raise DecodeError('Nonzero reserved string terminal byte')
                        try:
                            value = raw[:-1].decode('utf-8', errors='strict')
                        except UnicodeDecodeError as exc:
                            raise DecodeError('Invalid strict UTF-8') from exc
                    else:
                        fmt = PRIMITIVES[field['wire_type']][0]
                        value = struct.unpack('>'+fmt, consume(struct.calcsize(fmt)))[0]
                        if isinstance(value, float) and not math.isfinite(value):
                            raise DecodeError('Non-finite float rejected')
                    values.append(value)
                value = values if field['kind'] == 'array' else values[0]
                key = field_key(field)
                obj[key] = value
                if field['wire_type'] in ('FP', 'long', 'ulong'):
                    # JSON number tokens remain exact decimal integers. Mirrors protect JS/Excel consumers.
                    obj[key+'__decimal'] = [str(x) for x in values] if field['kind'] == 'array' else str(value)
            return obj
        rows = []
        for i in range(header['record_count']):
            start = pos
            row = {'_record_index': i, '_byte_offset': pos}
            row.update(decode_object(name, 0))
            row['_byte_length'] = pos-start
            rows.append(row)
        if pos != len(data):
            raise DecodeError(f'Trailing bytes: {len(data)-pos}')
        if len(rows) != header['record_count']:
            raise DecodeError('Decoded record count mismatch')
        payload = self.encode_payload(rows, name)
        encoded = struct.pack('>5I', 0x2def, 20+len(payload), 1, len(rows),
                              zlib.crc32(payload) ^ 0xffffffff) + payload
        if encoded != data:
            raise DecodeError('Full re-encode mismatch')
        return header, rows, {'header_verified': True, 'count_verified': True, 'exact_eof': True,
            'full_reencode_equal': True, 'full_reencode_sha256': hashlib.sha256(encoded).hexdigest(),
            'decoded_node_count': nodes, 'payload_bytes': len(data)-20}

    def encode_payload(self, rows, name):
        parts, nodes = [], 0
        if len(rows) > MAX_COUNT:
            raise DecodeError('Reencode record limit')
        def encode_object(obj, schema_name, depth):
            nonlocal nodes
            if depth > MAX_DEPTH:
                raise DecodeError('Reencode depth limit')
            for field in self.schemas[schema_name]['layout']:
                key = field_key(field)
                value = obj[key]
                values = value if field['kind'] == 'array' else [value]
                if not isinstance(values, list) or len(values) != field['count']:
                    raise DecodeError('Native fixed-array length mismatch')
                if not 1 <= len(values) <= NativeAnalyzer.MAX_ARRAY:
                    raise DecodeError('Reencode array count bound')
                for value in values:
                    nodes += 1
                    if nodes > MAX_NODES:
                        raise DecodeError('Reencode node limit')
                    if 'nested_schema' in field:
                        encode_object(value, field['nested_schema'], depth+1)
                    elif field['wire_type'] == 'string':
                        if not isinstance(value, str):
                            raise DecodeError('String type mismatch')
                        raw = value.encode('utf-8')+b'\x00'
                        if not 1 <= len(raw) <= min(field.get('max_string_size', MAX_STRING_SIZE), MAX_STRING_SIZE):
                            raise DecodeError('Reencode string bound')
                        parts.append(struct.pack('>i', len(raw))+raw)
                    else:
                        fmt = PRIMITIVES[field['wire_type']][0]
                        if fmt == 'f':
                            if not isinstance(value, (int, float)) or not math.isfinite(value):
                                raise DecodeError('Nonfinite/invalid float in reencode')
                        elif not isinstance(value, int) or isinstance(value, bool):
                            raise DecodeError('Integer type mismatch')
                        try:
                            parts.append(struct.pack('>'+fmt, value))
                        except (struct.error, OverflowError) as exc:
                            raise DecodeError('Numeric out-of-range') from exc
                if field['wire_type'] in ('FP', 'long', 'ulong'):
                    decimal = [str(x) for x in values] if field['kind'] == 'array' else str(values[0])
                    if obj.get(key+'__decimal') != decimal:
                        raise DecodeError('Integer decimal precision mirror mismatch')
        for row in rows:
            encode_object(row, name, 0)
        return b''.join(parts)


def safe_csv_cell(value):
    if isinstance(value, (dict, list)):
        return json.dumps(value, ensure_ascii=False, separators=(',', ':'), allow_nan=False)
    if isinstance(value, str):
        # Strip all leading whitespace/control chars for detection; preserve original text in JSON.
        candidate = re.sub(r'^[\s\x00\ufeff]*', '', value)
        if candidate.startswith(('=', '+', '-', '@')) or value.startswith(('\t', '\r', '\n')):
            return "'"+value
        if re.fullmatch(r'[0-9]+', candidate):
            numeric = candidate.lstrip('0') or '0'
            if len(numeric) > 16 or (len(numeric) == 16 and numeric > '9007199254740991'):
                return "'"+value
    # Spreadsheet numeric cells cannot safely hold 64-bit integers. Quote by apostrophe, not float.
    if isinstance(value, int) and abs(value) > 2**53-1:
        return "'"+str(value)
    return value


def write_json(path, value):
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(json.dumps(value, ensure_ascii=False, indent=2, allow_nan=False)+'\n', encoding='utf-8')


def source_identity(item):
    return item['bundle'], item['path_id'], item['sha256']


def plan_output_paths(targets):
    """Schema identity is not asset identity; plan before any file can be overwritten."""
    groups = collections.Counter((x['schema']['namespace'].casefold(), x['name'].casefold()) for x in targets)
    paths, occupied = {}, set()
    for item in targets:
        identity = source_identity(item)
        if identity in paths:
            raise ValueError('Duplicate source asset identity in target index')
        namespace, name = item['schema']['namespace'], item['name']
        if groups[(namespace.casefold(), name.casefold())] > 1:
            digest = hashlib.sha256(json.dumps(identity, ensure_ascii=False, separators=(',', ':')).encode('utf-8')).hexdigest()
            name += '__source_'+digest[:16]
        dest = OUT / namespace / (name+'.json')
        for path in (dest, dest.with_suffix('.csv')):
            normalized = str(path.resolve()).casefold()
            if normalized in occupied:
                raise ValueError('Output identity/path collision: '+str(path))
            occupied.add(normalized)
        paths[identity] = dest
    return paths


def validate_output_provenance(results):
    """Check every final artifact after all writes, including byte-identical sources."""
    paths, checked = set(), 0
    for entry in results:
        if entry['status'] != 'decoded-validated-native-recursive':
            continue
        for field in ('decoded_json', 'decoded_csv'):
            path = (ROOT / entry[field]).resolve()
            normalized = str(path).casefold()
            if normalized in paths:
                raise ValueError('Duplicate final output path: '+str(path))
            paths.add(normalized)
            if not path.is_file():
                raise ValueError('Missing final output: '+str(path))
        doc = json.loads((ROOT / entry['decoded_json']).read_text(encoding='utf-8'))
        if doc.get('source') != entry or source_identity(doc['source']) != source_identity(entry):
            raise ValueError('Final JSON source provenance differs from index: '+entry['decoded_json'])
        checked += 1
    return {'decoded_tables_checked': checked, 'unique_output_paths': True,
            'full_source_entry_equal': True, 'bundle_path_id_sha256_equal': True}


def main():
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument('--inspect', nargs='+', help='Print static native disassembly of Namespace.Type or hexadecimal VA')
    args = ap.parse_args()
    schemas, enums, readers = load_metadata()
    native = Native()
    if args.inspect:
        for name in args.inspect:
            va = int(name, 16) if name.startswith('0x') else schemas[tuple(name.split('.', 1))]['unpack_va']
            print('\n###', name, hex(va))
            print(native.disassembly(va))
        return
    analyzer = NativeAnalyzer(native, schemas, enums, readers)
    baseline = json.loads((ROOT / 'derived/config-decoded/resbin-index.json').read_text(encoding='utf-8'))
    targets = [x for x in baseline if x.get('reason', '').startswith('Unsupported arrays/nested/enum fields:')]
    output_paths = plan_output_paths(targets)
    results = []
    OUT.mkdir(parents=True, exist_ok=True)
    for item in targets:
        key = (item['schema']['namespace'], item['name'])
        entry = {k: item[k] for k in ('bundle', 'path_id', 'name', 'sha256', 'export')}
        entry.update(schema='.'.join(key), path_id_decimal=str(item['path_id']),
                     legacy_status=item['status'], legacy_reason=item['reason'])
        entry['status'] = 'native-layout-rejected'
        try:
            result = analyzer.analyze(key)
            entry['status'] = 'payload-rejected'
            data = (ROOT / item['export']).read_bytes()
            if hashlib.sha256(data).hexdigest() != item['sha256']:
                raise DecodeError('Source asset SHA256 differs from legacy index')
            codec = Codec({'.'.join(k): v for k, v in analyzer.cache.items()})
            header = check_header(data)
            minimum_record_size = codec.minimum_size('.'.join(key))
            entry.update(header=header, native_layout_verified=True,
                         schema_file=(OUT / 'schemas' / ('.'.join(key)+'.json')).relative_to(ROOT).as_posix(),
                         minimum_record_size=minimum_record_size,
                         min_expected_payload_bytes=minimum_record_size*header['record_count'],
                         actual_payload_bytes=len(data)-20)
            header, rows, checks = codec.decode(data, '.'.join(key))
            dest = output_paths[source_identity(item)]
            csvdest = dest.with_suffix('.csv')
            entry.update(status='decoded-validated-native-recursive', header=header,
                         decoded_record_count=len(rows), validation=checks,
                         arrays=[{'field': f['name'], 'count': f['count'], 'count_encoding': f['count_encoding']} for f in result['layout'] if f['kind'] == 'array'],
                         schema_file=(OUT / 'schemas' / ('.'.join(key)+'.json')).relative_to(ROOT).as_posix(),
                         decoded_json=dest.relative_to(ROOT).as_posix(), decoded_csv=csvdest.relative_to(ROOT).as_posix())
            write_json(dest, {'source': entry, 'precision': 'Exact JSON integer number tokens, with decimal-string mirrors for every int64/uint64/FP. FP is raw signed int64; no scaling.', 'records': rows})
            if rows:
                with csvdest.open('w', encoding='utf-8-sig', newline='') as f:
                    writer = csv.DictWriter(f, fieldnames=list(rows[0]), quoting=csv.QUOTE_MINIMAL)
                    writer.writeheader()
                    writer.writerows({k: safe_csv_cell(v) for k, v in row.items()} for row in rows)
            else:
                csvdest.write_text('', encoding='utf-8-sig')
        except (EvidenceError, DecodeError, UnicodeError, struct.error) as exc:
            entry['reason'] = type(exc).__name__+': '+str(exc)
        results.append(entry)
    provenance_validation = validate_output_provenance(results)
    for key, schema in analyzer.cache.items():
        write_json(OUT / 'schemas' / ('.'.join(key)+'.json'), schema)
        path = OUT / 'native' / ('.'.join(key)+'.asm.txt')
        path.parent.mkdir(parents=True, exist_ok=True)
        path.write_text(native.disassembly(schema['unpack_va'])+'\n', encoding='utf-8')
    for va, name in {**readers, 0x21f651c: 'constructor_default', 0x21f654c: 'constructor_buffer', 0x21f6594: 'set_buffer'}.items():
        path = OUT / 'native' / ('PbReadBuf.'+name+'.asm.txt')
        path.parent.mkdir(parents=True, exist_ok=True)
        path.write_text(native.disassembly(va)+'\n', encoding='utf-8')
    write_json(OUT / 'native-analysis.json', {'tables': results, 'schemas': {'.'.join(k): v for k, v in analyzer.cache.items()}, 'rejected_schemas': {'.'.join(k): v for k, v in analyzer.failures.items()}})
    write_json(OUT / 'resbin-index.json', results)
    write_json(OUT / 'rejects.json', [x for x in results if x['status'] != 'decoded-validated-native-recursive'])
    write_json(OUT / 'schema-index.json', {'.'.join(k): {'schema_file': (OUT / 'schemas' / ('.'.join(k)+'.json')).relative_to(ROOT).as_posix(), 'native_disassembly': (OUT / 'native' / ('.'.join(k)+'.asm.txt')).relative_to(ROOT).as_posix(), 'unpack_va': hex(v['unpack_va'])} for k, v in analyzer.cache.items()})
    summary = {'target_tables': len(targets), 'status_counts': dict(collections.Counter(x['status'] for x in results)),
        'decoded_table_count': sum(x['status'] == 'decoded-validated-native-recursive' for x in results),
        'decoded_record_count': sum(x.get('decoded_record_count', 0) for x in results),
        'reject_reasons': dict(collections.Counter(x.get('reason') for x in results if 'reason' in x)),
        'schemas_analyzed': len(analyzer.cache),
        'output_provenance_validation': provenance_validation,
        'source_disambiguated_output_count': sum('__source_' in x.get('decoded_json', '') for x in results),
        'unindexed_legacy_outputs_policy': 'Unindexed artifacts from older runs are not current deliverables; use resbin-index.json only. Source-collision legacy unsuffixed files are preserved, not deleted.',
        'native_array_field_count': sum(f['kind'] == 'array' for v in analyzer.cache.values() for f in v['layout']),
        'native_nested_field_count': sum('nested_schema' in f for v in analyzer.cache.values() for f in v['layout']),
        'native_fp_field_count': sum(f['wire_type'] == 'FP' for v in analyzer.cache.values() for f in v['layout']),
        'native_enum_field_count': sum('enum' in f for v in analyzer.cache.values() for f in v['layout']),
        'legacy_baseline': {'index': 'derived/config-decoded/resbin-index.json', 'index_sha256': hashlib.sha256((ROOT / 'derived/config-decoded/resbin-index.json').read_bytes()).hexdigest(), 'table_count': len(baseline), 'decoded_table_count': sum(x['status'] == 'decoded-validated-static' for x in baseline), 'decoded_record_count': sum(x.get('decoded_record_count', 0) for x in baseline), 'unchanged': True},
        'source_sha256': {'libil2cpp.so': hashlib.sha256(native.binary).hexdigest(), 'dump.cs': hashlib.sha256((ROOT / 'derived/il2cpp/arm64-v8a/dump.cs').read_bytes()).hexdigest(), 'script.json': hashlib.sha256((ROOT / 'derived/il2cpp/arm64-v8a/script.json').read_bytes()).hexdigest()},
        'bounds': {'max_depth': MAX_DEPTH, 'max_record_count': MAX_COUNT, 'max_nodes_per_table': MAX_NODES, 'max_fixed_array': NativeAnalyzer.MAX_ARRAY, 'max_string_bytes': MAX_STRING_SIZE, 'max_file_bytes': MAX_FILE_SIZE, 'max_native_steps': NativeAnalyzer.MAX_STEPS, 'max_native_events': NativeAnalyzer.MAX_EVENTS},
        'limits': ['Static success-path model, not execution or complete runtime equivalence proof.', 'Assumes created nonnull nested objects/arrays, valid managed bounds, AAPCS64 callee preservation and cutVer=1.', 'Unknown native instructions/calls/data-dependent paths fail closed; only exact sequential overloads and exact nested targets accepted.', 'Array counts have no wire prefix when count_encoding=none-native-fixed; loop trip counts/strides are recovered from concrete ARM64 instructions.', 'Big-endian is supported by reader initialization IsNetEndian=1 and native NetworkToHostOrder calls; runtime endian branches and UTF8 virtual method are not formally proved.', 'Native readString consumes signed int32 length, validates 0<length<=maxStrSize, decodes length-1 bytes and advances length; it does not explicitly check terminal zero. This tool strictly requires terminal zero and valid UTF-8, a conservative subset.', 'No enum range filtering: enums retain raw numeric values, since unknown/flag values may be valid. Enum wire reader width requires native reader evidence.', 'FP raw signed int64 is never normalized; exact integer number tokens and decimal-string precision mirrors are emitted. JavaScript consumers must use decimal mirrors or lossless parsing.', 'CSV nested cells are compact JSON; formula-like/control-leading scalar strings and unsafe spreadsheet integers are apostrophe-prefixed; JSON preserves source values.', 'Only the 174 baseline arrays/nested/enum rejects are targeted. Baseline missing-schema/layout rejects are left for separate recovery; duplicate namespace variants are distinct source tables.']}
    write_json(OUT / 'resbin-summary.json', summary)
    print(json.dumps(summary, ensure_ascii=False, indent=2))


if __name__ == '__main__':
    main()
