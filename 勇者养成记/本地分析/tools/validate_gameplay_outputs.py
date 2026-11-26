"""Verify new offline tables/evidence/catalog and run host-only regression tests."""
from pathlib import Path
import collections, csv, hashlib, importlib, importlib.util, json, struct, sys, time, types, unittest
import decode_resbin_extended as d
import recover_wire_layouts as w
import recover_recursive_variants as r
ROOT=Path(__file__).resolve().parents[1]
NATIVE={'decoded-validated-static','decoded-validated-native-recursive'}

def load(path):return json.loads((ROOT/path).read_text(encoding='utf-8-sig'))
def require(ok,message):
    if not ok:raise AssertionError(message)
def canonical(value):return json.loads(json.dumps(value,ensure_ascii=False))
def verify_csv(path,rows,cell):
    with (ROOT/path).open(encoding='utf-8-sig',newline='') as f:actual=list(csv.DictReader(f))
    require(len(actual)==len(rows),'CSV row count '+path)
    for i,(row,out) in enumerate(zip(rows,actual)):
        require({k:str(cell(v)) for k,v in row.items()}==out,'CSV cell mismatch '+path+' row '+str(i))

def verify_algorithms():
    """Re-decode archived bytes from the ELF and test the emitted, not just generator, model."""
    import capstone
    a=importlib.import_module('recover_client_algorithms')
    base=ROOT/'derived/client-algorithms';provenance=load('derived/client-algorithms/provenance.json')
    require(hashlib.sha256(Path(a.__file__).read_bytes()).hexdigest()==provenance['script_sha256'],'Algorithm generator source hash')
    for item in provenance['inputs']:
        raw=(ROOT/item['path']).read_bytes()
        require(len(raw)==item['bytes'] and hashlib.sha256(raw).hexdigest()==item['sha256'],'Algorithm input hash '+item['path'])
    require(capstone.__version__==provenance['capstone_version'],'Algorithm disassembler version drift')
    elf=a.ELF(ROOT/'unpacked/lib/arm64-v8a/libil2cpp.so')
    require(elf.segments==provenance['elf_load_segments'],'Algorithm ELF segments')
    entries=load('derived/client-algorithms/index.json');saved=load('derived/client-algorithms/instructions.json')
    require(len(entries)==provenance['selected_unique_entries']==len({x['rva'] for x in entries}),'Algorithm entry coverage')
    require(set(saved)=={hex(x['rva']) for x in entries},'Algorithm instruction entry coverage')
    md=capstone.Cs(capstone.CS_ARCH_ARM64,capstone.CS_MODE_LITTLE_ENDIAN);md.detail=True
    expected_edges=[];instruction_count=0
    for entry in entries:
        start=entry['rva'];end=entry['conservative_end'];raw=elf.read(start,end-start)
        require(elf.offset(start)==entry['file_offset'] and len(raw)==entry['size_upper_bound'],'Algorithm native range '+hex(start))
        require(raw==(base/entry['native_bytes']).read_bytes() and hashlib.sha256(raw).hexdigest()==entry['sha256'],'Algorithm native bytes '+hex(start))
        instructions=list(md.disasm(raw,start));records=[{'address':i.address,'bytes':i.bytes.hex(),'mnemonic':i.mnemonic,'operands':i.op_str} for i in instructions]
        require(records==saved[hex(start)] and sum(i.size for i in instructions)==entry['decoded_bytes'],'Algorithm disassembly drift '+hex(start))
        lines=(base/entry['disassembly']).read_text(encoding='utf-8').splitlines()[5:]
        require(len(lines)==len(instructions) and all(line.startswith(f'{i.address:08x}  {i.bytes.hex():8s}  {i.mnemonic:8s} {i.op_str}') for line,i in zip(lines,instructions)),'Algorithm readable disassembly '+hex(start))
        instruction_count+=len(instructions)
        for i in instructions:
            if i.mnemonic in ('bl','b') and i.operands and i.operands[0].type==capstone.arm64.ARM64_OP_IMM:
                target=i.operands[0].imm
                if i.mnemonic=='bl' or not start<=target<end:expected_edges.append((start,i.address,'direct_call' if i.mnemonic=='bl' else 'outbound_branch',target,None))
            elif i.mnemonic in ('blr','br'):expected_edges.append((start,i.address,'indirect_unresolved',None,i.op_str))
    edges=load('derived/client-algorithms/call-graph.json')
    require(expected_edges==[(x['caller'],x['site'],x['kind'],x.get('target'),x.get('operand')) for x in edges],'Algorithm call/branch edge drift')
    jump_entries=0
    for table in load('derived/client-algorithms/damage-dispatch-tables.json')+[load('derived/client-algorithms/magic-jump-table.json')]:
        start=int(table['table_rva'],16);raw=bytes.fromhex(table['raw_hex'])
        require(elf.read(start,len(raw))==raw and len(raw)==len(table['entries'])*4,'Algorithm jump-table bytes')
        for entry,(relative,) in zip(table['entries'],struct.iter_unpack('<i',raw)):
            require(relative==entry['signed_relative'] and start+relative==int(entry['branch_rva'],16),'Algorithm relative jump target')
            jump_entries+=1
    for block in load('derived/client-algorithms/supporting-basic-blocks.json'):
        start=int(block['rva'],16);raw=bytes.fromhex(block['raw_hex'])
        require(elf.read(start,len(raw))==raw,'Algorithm supporting block bytes')
        require([{'rva':hex(i.address),'bytes':i.bytes.hex(),'mnemonic':i.mnemonic,'operands':i.op_str} for i in md.disasm(raw,start)]==block['instructions'],'Algorithm supporting block disassembly')
    generator=Path(a.__file__).read_text(encoding='utf-8')
    model=generator.split('# BEGIN HOST REFERENCE MODEL -- generated reference_model.py copies this block verbatim.\n',1)[1].split('# END HOST REFERENCE MODEL',1)[0]
    expected='"""Host-only static reconstruction; see report and test-results.json. No target execution."""\nMASK32=(1<<32)-1\nMASK64=(1<<64)-1\nONE=1<<32\ndef s64(x):\n    x &= MASK64\n    return x-(1<<64) if x>>63 else x\n\n'+model
    require((base/'reference_model.py').read_text(encoding='utf-8')==expected,'Emitted reference model source drift')
    spec=importlib.util.spec_from_file_location('archived_gameplay_reference_model',base/'reference_model.py');emitted=importlib.util.module_from_spec(spec);spec.loader.exec_module(emitted)
    source_result=a.run_reference_tests()
    emitted_result=types.FunctionType(a.run_reference_tests.__code__,{**vars(a),**vars(emitted)})()
    require(source_result==emitted_result==load('derived/client-algorithms/test-results.json'),'Archived/emitted model tests drift')
    require(source_result['status']=='passed' and all(x['passed'] for x in source_result['checks']),'Algorithm host tests failed')
    return {'algorithm_entries_redecoded':len(entries),'algorithm_instructions_redecoded':instruction_count,'algorithm_call_graph_records':len(edges),'algorithm_call_graph_kinds':dict(collections.Counter(x['kind'] for x in edges)),'algorithm_jump_table_entries_checked':jump_entries,'algorithm_host_check_count':source_result['check_count'],'algorithm_emitted_model_check_count':emitted_result['check_count'],'algorithm_test_scope':source_result['test_scope']}


def run():
    started=time.monotonic();errors=[];stats={}
    try:
        baseline=load('derived/config-decoded/resbin-index.json')
        source_map={(x['bundle'],x['path_id']):x for x in baseline}
        schemas={p.stem:json.loads(p.read_text(encoding='utf-8')) for p in (ROOT/'derived/config-extended/schemas').glob('*.json')}
        meta,enums,readers=d.load_metadata();native=d.Native();analyzer=d.NativeAnalyzer(native,meta,enums,readers)
        # Re-run bounded instruction analysis from the unchanged ARM64 SO, not from saved evidence JSON.
        for name,schema in schemas.items():
            fresh=analyzer.analyze(tuple(name.split('.',1)))
            require(canonical(fresh)==schema,'Native schema/evidence drift '+name)
        stats['native_schemas_reanalyzed']=len(schemas)
        ext=load('derived/config-extended/resbin-index.json');codec=d.Codec(schemas)
        accepted=[x for x in ext if x['status']=='decoded-validated-native-recursive']
        for field in ('decoded_json','decoded_csv'):
            require(len({x[field] for x in accepted})==len(accepted),'Duplicate extended output identity '+field)
        tables=records=csv_records=0
        for item in ext:
            raw=(ROOT/item['export']).read_bytes()
            require(hashlib.sha256(raw).hexdigest()==item['sha256'],'Source hash '+item['name'])
            if item['status']!='decoded-validated-native-recursive':
                rejected=False
                try:codec.decode(raw,item['schema'])
                except d.DecodeError:rejected=True
                require(rejected,'Archived reject unexpectedly decodes '+item['name'])
                continue
            header,fresh,checks=codec.decode(raw,item['schema']);doc=load(item['decoded_json'])
            require(fresh==doc['records'],'Archived row drift '+item['name'])
            require(doc['source']==item,'Archived source drift '+item['name'])
            require(checks==item['validation'],'Validation evidence drift '+item['name'])
            require(len(fresh)==item['decoded_record_count'],'Record count '+item['name'])
            verify_csv(item['decoded_csv'],fresh,d.safe_csv_cell)
            tables+=1;records+=len(fresh);csv_records+=len(fresh)
        stats.update(extended_tables_roundtripped=tables,extended_records_roundtripped=records,extended_rejects_reproduced=len(ext)-tables)
        candidate_tables=candidate_records=0
        for item in load('derived/config-layout-recovery/layout-index.json'):
            if item['status']!=w.STATUS:continue
            raw=(ROOT/item['export']).read_bytes();require(hashlib.sha256(raw).hexdigest()==item['sha256'],'Candidate hash '+item['name'])
            count=w.check_header(raw);src=load(item['companion_json']);fields=src['source']['schema']['fields']
            companion_raw=(ROOT/src['source']['export']).read_bytes()
            require(hashlib.sha256(companion_raw).hexdigest()==item['companion_sha256']==src['source']['sha256'],'Candidate companion source hash '+item['name'])
            rows=w.decode(raw,item['fields'],count);encoded=w.encode(rows,item['fields'])
            require(encoded==raw[20:] and len(rows)==count,'Candidate payload '+item['name'])
            doc=load(item['decoded_json'])
            require(rows==doc['records'],'Candidate row drift '+item['name'])
            require(doc['source']==item,'Candidate source identity drift '+item['name'])
            checks=w.compare(rows,item['fields'],src['records'],fields)
            require(checks==item['named_value_checks'],'Candidate companion values '+item['name'])
            verify_csv(item['decoded_csv'],rows,w.csv_safe)
            candidate_tables+=1;candidate_records+=len(rows);csv_records+=len(rows)
        for item in load('derived/config-layout-recovery-recursive/layout-index.json'):
            if item['status']!=r.STATUS:continue
            raw=(ROOT/item['export']).read_bytes();require(hashlib.sha256(raw).hexdigest()==item['sha256'],'Recursive candidate hash '+item['name'])
            target=r.transfer(schemas,'_resbin_fp_' in item['bundle']);header,rows,checks=d.Codec(target).decode(raw,item['companion_schema'])
            doc=load(item['decoded_json'])
            require(rows==doc['records'],'Recursive candidate row drift '+item['name'])
            require(doc['source']==item,'Recursive candidate source identity drift '+item['name'])
            source=load(item['companion_json'])
            companion_raw=(ROOT/source['source']['export']).read_bytes()
            require(hashlib.sha256(companion_raw).hexdigest()==item['companion_sha256']==source['source']['sha256'],'Recursive companion source hash '+item['name'])
            require(r.check_values(rows,source['records'],schemas,target,item['companion_schema'])==item['named_value_checks'],'Recursive named-leaf drift '+item['name'])
            verify_csv(item['decoded_csv'],rows,d.safe_csv_cell)
            candidate_tables+=1;candidate_records+=len(rows);csv_records+=len(rows)
        stats.update(companion_candidate_tables_roundtripped=candidate_tables,companion_candidate_records_roundtripped=candidate_records,new_csv_records_checked=csv_records)
        catalog=load('derived/gameplay-catalog/catalog.json');tables=catalog['tables'];summary=catalog['summary']
        require(len(tables)==len(baseline)==len({(x['bundle'],x['path_id']) for x in tables}),'Catalog identity coverage')
        require({(x['bundle'],x['path_id']) for x in tables}==set(source_map),'Catalog source keys')
        require(dict(collections.Counter(x['status'] for x in tables))==summary['status_counts'],'Catalog status counts')
        nr=sum(x.get('decoded_record_count',0) for x in tables if x['status'] in NATIVE)
        nt=sum(x['status'] in NATIVE for x in tables)
        require(nt==summary['native_backed_tables'] and nr==summary['native_backed_records'],'Catalog native totals')
        require(summary['companion_candidate_tables']==candidate_tables and summary['companion_candidate_records']==candidate_records,'Catalog candidate totals')
        current=[x for x in tables if x['status'] in NATIVE|{w.STATUS}]
        for field in ('decoded_json','decoded_csv'):
            require(len({x[field] for x in current})==len(current),'Catalog duplicate current output path '+field)
        for item in tables:
            origin=source_map[(item['bundle'],item['path_id'])]
            require(item['sha256']==origin['sha256'] and item['export']==origin['export'],'Catalog source provenance '+item['name'])
            require(item['path_id_decimal']==str(item['path_id']),'Catalog path_id precision mirror '+item['name'])
            if 'decoded_json' in item:
                require(len(load(item['decoded_json'])['records'])==item['decoded_record_count'],'Catalog linked count '+item['name'])
        with (ROOT/'derived/gameplay-catalog/tables.csv').open(encoding='utf-8-sig',newline='') as f:reader=csv.DictReader(f);csv_keys=reader.fieldnames;actual=list(reader)
        require(actual==[{k:str(d.safe_csv_cell(t.get(k,''))) for k in csv_keys} for t in tables],'Catalog CSV source identity/precision drift')
        stats.update(catalog_source_tables=len(tables),total_native_backed_tables=nt,total_native_backed_records=nr,current_indexed_outputs_with_unique_paths=len(current))
        suite=unittest.defaultTestLoader.loadTestsFromNames(['test_resbin_extended','test_wire_layouts','test_recursive_variants','test_gameplay_query'])
        result=unittest.TextTestRunner(stream=sys.stdout,verbosity=1).run(suite)
        require(result.wasSuccessful(),'Host unittest suite failed')
        stats['host_unittest_count']=result.testsRun
        stats.update(verify_algorithms())
    except Exception as exc:
        errors.append(type(exc).__name__+': '+str(exc))
    out={'status':'passed' if not errors else 'failed',**stats,'elapsed_seconds':round(time.monotonic()-started,3),'errors':errors,'sample_executed':False,'game_native_executed':False,'game_server_contacted':False,'limits':['Static successful-path native layout analysis and host-only reference tests; not full runtime/native equivalence.','Companion-derived layouts stay candidates even with exact value/byte agreement.','Baseline flat280-table validation is performed separately by validate_outputs.py.']}
    (ROOT/'inventory/gameplay-validation.json').write_text(json.dumps(out,ensure_ascii=False,indent=2)+'\n',encoding='utf-8')
    print(json.dumps(out,ensure_ascii=False,indent=2),flush=True)
    return out

if __name__=='__main__':raise SystemExit(0 if run()['status']=='passed' else 1)
