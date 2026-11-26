"""Offline regression and adversarial gates for decode_resbin_extended.

No APK/native code is executed; Capstone only disassembles ELF bytes.
"""
import copy
import json
import math
import struct
import sys
import tempfile
import unittest
import zlib
from pathlib import Path
from unittest.mock import patch

import decode_resbin_extended as m


def fixture_file(payload, count=1, version=1, tag=0x2def):
    return struct.pack('>5I', tag, 20+len(payload), version, count,
                       zlib.crc32(payload) ^ 0xffffffff) + payload


def scalar(name, typ, **extra):
    return dict(name=name, type=typ, wire_type=typ, kind='scalar', count=1, **extra)


def array(name, typ, count, **extra):
    return dict(name=name, type=typ+'[]', wire_type=typ, kind='array', count=count,
                count_encoding='none-native-fixed', **extra)


class CodecTests(unittest.TestCase):
    def setUp(self):
        self.schemas = {
            'T.Inner': {'layout': [scalar('AttrType', 'short'), scalar('Value', 'FP')]},
            'T.Outer': {'layout': [scalar('ID', 'uint'), scalar('Name', 'string', max_string_size=64),
                                    array('Params', 'int', 3),
                                    array('Attrs', 'Inner', 2, nested_schema='T.Inner')]}}
        self.codec = m.Codec(self.schemas)
        self.row = {'ID': 7, 'Name': '=1+1', 'Params': [1, -2, 3],
                    'Attrs': [{'AttrType': 4, 'Value__raw_int64': -(2**63),
                               'Value__raw_int64__decimal': str(-(2**63))},
                              {'AttrType': 5, 'Value__raw_int64': 2**63-1,
                               'Value__raw_int64__decimal': str(2**63-1)}]}
        self.payload = self.codec.encode_payload([self.row], 'T.Outer')
        self.data = fixture_file(self.payload)

    def test_nested_array_exact_roundtrip(self):
        h, rows, checks = self.codec.decode(self.data, 'T.Outer')
        self.assertEqual(h['record_count'], 1)
        self.assertTrue(checks['full_reencode_equal'])
        self.assertEqual(rows[0]['Attrs'], self.row['Attrs'])
        self.assertEqual(self.codec.encode_payload(rows, 'T.Outer'), self.payload)
        self.assertEqual(rows[0]['_byte_offset'], 20)
        self.assertEqual(rows[0]['_byte_length'], len(self.payload))

    def test_int64_json_lexical_and_decimal_precision(self):
        _, rows, _ = self.codec.decode(self.data, 'T.Outer')
        text = json.dumps(rows)
        self.assertIn('9223372036854775807', text)
        self.assertIn('-9223372036854775808', text)
        self.assertEqual(json.loads(text)[0]['Attrs'], self.row['Attrs'])

    def test_no_count_prefix(self):
        # ID + (length + UTF8 + reserved NUL), followed immediately by int32 elements.
        array_start = 4+4+len(self.row['Name'].encode())+1
        self.assertEqual(self.payload[array_start:array_start+12], struct.pack('>3i', 1, -2, 3))

    def test_truncated_header(self):
        with self.assertRaises(m.DecodeError):
            self.codec.decode(self.data[:19], 'T.Outer')

    def test_truncated_payload(self):
        with self.assertRaises(m.DecodeError):
            self.codec.decode(fixture_file(self.payload[:-1]), 'T.Outer')

    def test_wrong_crc(self):
        data = bytearray(self.data)
        data[-1] ^= 1
        with self.assertRaises(m.DecodeError):
            self.codec.decode(bytes(data), 'T.Outer')

    def test_wrong_header_tag_and_version(self):
        for kwargs in [{'tag': 1}, {'version': 2}]:
            with self.subTest(kwargs=kwargs), self.assertRaises(m.DecodeError):
                self.codec.decode(fixture_file(self.payload, **kwargs), 'T.Outer')

    def test_excessive_count(self):
        with self.assertRaises(m.DecodeError):
            self.codec.decode(fixture_file(self.payload, count=m.MAX_COUNT+1), 'T.Outer')

    def test_count_minimum_size_gate(self):
        with self.assertRaisesRegex(m.DecodeError, 'minimum record size'):
            self.codec.decode(fixture_file(self.payload, count=100), 'T.Outer')

    def test_count_zero_with_data_and_trailing_payload(self):
        for data in [fixture_file(self.payload, count=0), fixture_file(self.payload+b'junk')]:
            with self.assertRaisesRegex(m.DecodeError, 'Trailing bytes'):
                self.codec.decode(data, 'T.Outer')

    def test_native_string_max(self):
        # Valid length encoding but exceeds the exact caller's native maxStrSize.
        data = fixture_file(struct.pack('>Ii', 7, 65)+b'x'*64+b'\0'+self.payload[13:])
        with self.assertRaisesRegex(m.DecodeError, 'String length'):
            self.codec.decode(data, 'T.Outer')

    def test_string_negative_length(self):
        for length in [-1, 0, 2**31-1]:
            data = fixture_file(self.payload[:4]+struct.pack('>i', length)+self.payload[8:])
            with self.subTest(length=length), self.assertRaises(m.DecodeError):
                self.codec.decode(data, 'T.Outer')

    def test_bad_string_terminal_and_invalid_utf8(self):
        for replacement in [b'xxxxX', b'\xffxxx\0']:
            data = fixture_file(self.payload[:8]+replacement+self.payload[13:])
            with self.subTest(replacement=replacement), self.assertRaises(m.DecodeError):
                self.codec.decode(data, 'T.Outer')

    def test_short_array_reencode(self):
        row = copy.deepcopy(self.row)
        row['Params'].pop()
        with self.assertRaisesRegex(m.DecodeError, 'fixed-array length'):
            self.codec.encode_payload([row], 'T.Outer')

    def test_wrong_layout_count_rejected(self):
        bad = copy.deepcopy(self.schemas)
        bad['T.Outer']['layout'][2]['count'] = 2
        with self.assertRaises(m.DecodeError):
            m.Codec(bad).decode(self.data, 'T.Outer')

    def test_precision_mirror_tamper(self):
        row = copy.deepcopy(self.row)
        row['Attrs'][0]['Value__raw_int64__decimal'] = '0'
        with self.assertRaisesRegex(m.DecodeError, 'precision mirror mismatch'):
            self.codec.encode_payload([row], 'T.Outer')

    def test_integer_range_and_bool(self):
        for value in [2**32, -1, True]:
            row = copy.deepcopy(self.row)
            row['ID'] = value
            with self.subTest(value=value), self.assertRaises(m.DecodeError):
                self.codec.encode_payload([row], 'T.Outer')

    def test_float_nonfinite_and_signed_zero(self):
        codec = m.Codec({'T.F': {'layout': [scalar('F', 'float')]}})
        for value in [math.inf, -math.inf, math.nan]:
            with self.subTest(value=value), self.assertRaises(m.DecodeError):
                codec.decode(fixture_file(struct.pack('>f', value)), 'T.F')
        raw = fixture_file(struct.pack('>f', -0.0))
        _, rows, _ = codec.decode(raw, 'T.F')
        self.assertEqual(math.copysign(1.0, rows[0]['F']), -1.0)

    def test_node_depth_and_array_limits(self):
        with patch.object(m, 'MAX_NODES', 3), self.assertRaises(m.DecodeError):
            self.codec.decode(self.data, 'T.Outer')
        with patch.object(m, 'MAX_DEPTH', 0), self.assertRaises(m.DecodeError):
            self.codec.decode(self.data, 'T.Outer')
        bad = copy.deepcopy(self.schemas)
        bad['T.Outer']['layout'][2]['count'] = m.NativeAnalyzer.MAX_ARRAY+1
        with self.assertRaises(m.DecodeError):
            m.Codec(bad).decode(self.data, 'T.Outer')

    def test_csv_safety_and_nested_preservation(self):
        for value in ['=1+1', ' +cmd', '-foo', '@SUM(1)', '\ttext', '\rtext', '\ntext', '\ufeff=1', '\u2000=1', ' \ufeff =1', '9223372036854775807']:
            self.assertEqual(m.safe_csv_cell(value), "'"+value)
        self.assertEqual(m.safe_csv_cell('正常字符串'), '正常字符串')
        self.assertEqual(m.safe_csv_cell(2**63-1), "'9223372036854775807")
        cell = m.safe_csv_cell({'text': '=1+1', 'a': [1, 2]})
        self.assertEqual(json.loads(cell), {'text': '=1+1', 'a': [1, 2]})

    def test_unknown_enum_numeric_is_preserved(self):
        schema = {'T.E': {'layout': [scalar('State', 'int', enum={'values': {'Known': 1}})]}}
        _, rows, _ = m.Codec(schema).decode(fixture_file(struct.pack('>i', 99)), 'T.E')
        self.assertEqual(rows[0]['State'], 99)


class NativeEvidenceTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.schemas, cls.enums, cls.readers = m.load_metadata()
        cls.native = m.Native()
        cls.analyzer = m.NativeAnalyzer(cls.native, cls.schemas, cls.enums, cls.readers)

    def test_priority_fixed_counts_and_nested_field_names(self):
        expected = {
            ('ResDef', 'BootyConfig'): {'ItemParam': 3},
            ('BattleCore', 'BootyConfig'): {'ItemParam': 3},
            ('ResDef', 'EquipConfig'): {'ImpactData': 4, 'OpenHoleList': 6},
            ('ResDef', 'EquipUpLevelConfig'): {'ImpactData': 3},
            ('ResDef', 'SkillBaseConfg'): {'AttrDamageData': 2, 'BuffID': 4},
            ('BattleCore', 'SkillBaseConfg'): {'AttrDamageData': 2, 'BuffID': 4}}
        for key, counts in expected.items():
            with self.subTest(key=key):
                schema = self.analyzer.analyze(key)
                fields = {f['name']: f for f in schema['layout']}
                for name, count in counts.items():
                    self.assertEqual(fields[name]['count'], count)
                    self.assertEqual(fields[name]['count_encoding'], 'none-native-fixed')
                loops = schema['native_evidence']['loops']
                self.assertEqual(sorted(x['trip_count'] for x in loops), sorted(counts.values()))
                for loop in loops:
                    self.assertTrue(loop['preheader_initialization'])
                    self.assertTrue(loop['index_stride_updates'])
                    self.assertTrue(loop['compare_instructions'])
                    self.assertFalse(loop['concrete_tests_in_order'][-1]['taken'])
        nested = self.analyzer.analyze(('ResDef', 'ResAttrImpactData'))
        self.assertEqual([f['name'] for f in nested['layout']], ['DataType', 'AddType', 'Value'])

    def test_enum_width_requires_actual_native_reader(self):
        # Controlled metadata fixture on genuine BootyID native readUInt32 instructions.
        # No real target field is an enum; do not count this as recovered game enum data.
        schemas, enums = copy.deepcopy(self.schemas), copy.deepcopy(self.enums)
        schemas[('ResDef', 'BootyConfig')]['fields'][0]['type'] = 'WireState'
        enums[('ResDef', 'WireState')] = {'namespace': 'ResDef', 'name': 'WireState',
                                         'underlying': 'uint', 'values': {'Known': 1}}
        analyzer = m.NativeAnalyzer(self.native, schemas, enums, self.readers)
        field = analyzer.analyze(('ResDef', 'BootyConfig'))['layout'][0]
        self.assertEqual(field['wire_type'], 'uint')
        self.assertEqual(field['native_calls'][0]['reader'], 'readUInt32')
        self.assertEqual(field['enum']['values'], {'Known': 1})
        readers = dict(self.readers)
        readers.pop(0x21f6908)
        with self.assertRaises(m.EvidenceError):
            m.NativeAnalyzer(self.native, schemas, enums, readers).analyze(('ResDef', 'BootyConfig'))

    def mutated_native(self, va, word):
        native = copy.copy(self.native)
        def instructions(start):
            return [next(self.native.cs.disasm(struct.pack('<I', word), i.address)) if i.address == va else i
                    for i in self.native.instructions(start)]
        native.instructions = instructions
        return native

    def test_audit_w_register_pointer_truncation_rejected(self):
        va = 0x1e8947c
        original = struct.unpack_from('<I', self.native.binary, self.native.offset(va))[0]
        native = self.mutated_native(va, original & ~(1 << 31))  # MOV W19,W1, not MOV X19,X1.
        with self.assertRaisesRegex(m.EvidenceError, 'truncated through W register'):
            m.NativeAnalyzer(native, self.schemas, self.enums, self.readers).analyze(('ResDef', 'ResAttrLvImpactData'))

    def test_audit_opaque_buffer_store_rejected(self):
        # STR XZR,[X19,#0x10] would corrupt the reader object before its next call.
        native = self.mutated_native(0x1e89498, 0xf9000a7f)
        with self.assertRaisesRegex(m.EvidenceError, 'Unmodeled native store side effect'):
            m.NativeAnalyzer(native, self.schemas, self.enums, self.readers).analyze(('ResDef', 'ResAttrLvImpactData'))

    def test_wrong_field_order_fails_closed(self):
        schemas = copy.deepcopy(self.schemas)
        fields = schemas[('ResDef', 'BootyConfig')]['fields']
        fields[0], fields[1] = fields[1], fields[0]
        with self.assertRaises(m.EvidenceError):
            m.NativeAnalyzer(self.native, schemas, self.enums, self.readers).analyze(('ResDef', 'BootyConfig'))

    def test_wrong_offset_fails_closed(self):
        schemas = copy.deepcopy(self.schemas)
        schemas[('ResDef', 'BootyConfig')]['fields'][0]['object_offset'] += 4
        with self.assertRaises(m.EvidenceError):
            m.NativeAnalyzer(self.native, schemas, self.enums, self.readers).analyze(('ResDef', 'BootyConfig'))

    def test_wrong_array_reader_fails_closed(self):
        schemas = copy.deepcopy(self.schemas)
        next(f for f in schemas[('ResDef', 'BootyConfig')]['fields'] if f['name'] == 'ItemParam')['type'] = 'uint[]'
        with self.assertRaises(m.EvidenceError):
            m.NativeAnalyzer(self.native, schemas, self.enums, self.readers).analyze(('ResDef', 'BootyConfig'))

    def test_unknown_call_fails_closed(self):
        readers = dict(self.readers)
        readers.pop(0x21f67d0)
        with self.assertRaisesRegex(m.EvidenceError, 'Unknown reachable call'):
            m.NativeAnalyzer(self.native, self.schemas, self.enums, readers).analyze(('ResDef', 'BootyConfig'))

    def test_wrong_nested_target_fails_closed(self):
        schemas = copy.deepcopy(self.schemas)
        next(f for f in schemas[('ResDef', 'EquipConfig')]['fields'] if f['name'] == 'ImpactData')['type'] = 'ResAttrImpactData[]'
        with self.assertRaises(m.EvidenceError):
            m.NativeAnalyzer(self.native, schemas, self.enums, self.readers).analyze(('ResDef', 'EquipConfig'))

    def test_unknown_opcode_and_data_condition_fail_closed(self):
        import capstone
        for machine in [bytes.fromhex('00001fd6'), bytes.fromhex('800200b4000000b9c0035fd6')]:
            # BR X0, or CBZ X0 followed by an unsupported store path.
            native = copy.copy(self.native)
            native.instructions = lambda va, machine=machine: list(self.native.cs.disasm(machine, va))
            with self.subTest(machine=machine.hex()), self.assertRaises(m.EvidenceError):
                m.NativeAnalyzer(native, self.schemas, self.enums, self.readers).analyze(('ResDef', 'BootyConfig'))

    def test_real_priority_payloads_match_native_layouts(self):
        index = json.loads((m.ROOT/'derived/config-decoded/resbin-index.json').read_text(encoding='utf-8'))
        counts = {'SkillBaseConfg': 9568, 'EquipConfig': 2161, 'EquipUpLevelConfig': 3306, 'BootyConfig': 37525}
        for item in index:
            if item['name'] not in counts or not item.get('reason', '').startswith('Unsupported arrays/nested/enum fields:'):
                continue
            key = (item['schema']['namespace'], item['name'])
            with self.subTest(key=key):
                self.analyzer.analyze(key)
                codec = m.Codec({'.'.join(k): v for k, v in self.analyzer.cache.items()})
                _, rows, checks = codec.decode((m.ROOT/item['export']).read_bytes(), '.'.join(key))
                self.assertEqual(len(rows), counts[item['name']])
                self.assertTrue(checks['exact_eof'])
                self.assertTrue(checks['full_reencode_equal'])


class OutputIdentityTests(unittest.TestCase):
    def test_asset_collision_paths_are_unique_stable_and_keep_noncollision_paths(self):
        a = {'bundle': 'nonfp.bytes.ab', 'path_id': 1, 'sha256': 'a'*64,
             'schema': {'namespace': 'BattleCore'}, 'name': 'SameType'}
        b = {**a, 'bundle': 'fp.bytes.ab', 'path_id': 2}  # Same schema AND byte hash; distinct assets.
        c = {**a, 'bundle': 'core.bytes.ab', 'path_id': 3, 'name': 'CoreType'}
        paths = m.plan_output_paths([a, b, c])
        self.assertEqual(len(set(paths.values())), 3)
        self.assertIn('__source_', paths[m.source_identity(a)].name)
        self.assertIn('__source_', paths[m.source_identity(b)].name)
        self.assertEqual(paths[m.source_identity(c)], m.OUT/'BattleCore/CoreType.json')
        self.assertEqual(paths, m.plan_output_paths([c, b, a]))
        with self.assertRaisesRegex(ValueError, 'Duplicate source asset identity'):
            m.plan_output_paths([a, copy.deepcopy(a)])

    def test_provenance_gate_rejects_swapped_source_and_duplicate_paths(self):
        with tempfile.TemporaryDirectory(dir=m.OUT) as directory, patch.object(m, 'ROOT', Path(directory)):
            entries = [{'status': 'decoded-validated-native-recursive', 'bundle': name+'.ab',
                        'path_id': i, 'sha256': 'a'*64, 'decoded_json': name+'.json',
                        'decoded_csv': name+'.csv'} for i, name in enumerate(('a', 'b'))]
            for entry in entries:
                m.write_json(m.ROOT/entry['decoded_json'], {'source': entry, 'records': []})
                (m.ROOT/entry['decoded_csv']).write_text('', encoding='utf-8')
            self.assertEqual(m.validate_output_provenance(entries)['decoded_tables_checked'], 2)
            # Byte hash is equal, but the source identity may never be substituted.
            m.write_json(m.ROOT/entries[0]['decoded_json'], {'source': entries[1], 'records': []})
            with self.assertRaisesRegex(ValueError, 'source provenance differs'):
                m.validate_output_provenance(entries)
            m.write_json(m.ROOT/entries[0]['decoded_json'], {'source': entries[0], 'records': []})
            entries[1]['decoded_json'] = entries[0]['decoded_json']
            with self.assertRaisesRegex(ValueError, 'Duplicate final output path'):
                m.validate_output_provenance(entries)

    def test_all_164_exported_sources_match_index_with_unique_paths(self):
        index = json.loads((m.OUT/'resbin-index.json').read_text(encoding='utf-8'))
        checks = m.validate_output_provenance(index)
        self.assertEqual(checks['decoded_tables_checked'], 164)
        self.assertTrue(checks['unique_output_paths'])
        self.assertTrue(checks['full_source_entry_equal'])


if __name__ == '__main__':
    unittest.main(testRunner=unittest.TextTestRunner(stream=sys.stdout, verbosity=2))
