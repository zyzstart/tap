"""Validate archived static outputs; re-encode every decoded config row without executing sample code."""
from pathlib import Path
import ast, csv, hashlib, importlib.util, json, re, struct, sys, zlib
ROOT = Path(__file__).resolve().parents[1]
errors = []
def check(ok, message):
    if not ok: errors.append(message)
def load(path): return json.loads((ROOT / path).read_text(encoding='utf-8-sig'))
def main():
    u = load('derived/unity/unity-summary.json')
    bundles = load('derived/unity/bundle-index.json')
    check(len(bundles) == u['bundle_count'] == 3942, 'bundle count')
    check(all(x['status'] == 'parsed' for x in bundles), 'bundle parse status')
    check(sum(x['objects'] for x in bundles) == u['object_count'], 'bundle object sum')
    with (ROOT/'derived/unity/object-index.csv').open(encoding='utf-8-sig', newline='') as f:
        count = sum(1 for _ in csv.DictReader(f))
    object_count=count
    check(object_count == u['object_count'], 'object CSV count')
    texts = load('derived/unity/textasset-index.json')
    check(len(texts) == u['textasset_count'], 'TextAsset count')
    for t in texts:
        b = (ROOT/t['export']).read_bytes()
        check(len(b) == t['size'] and hashlib.sha256(b).hexdigest() == t['sha256'], 'TextAsset hash: '+t['export'])
    index = load('derived/config-decoded/resbin-index.json')
    summary = load('derived/config-decoded/resbin-summary.json')
    check(len(index) == summary['table_count'] == 545, 'resbin table count')
    validated = records = raw_headers = formula_cells = 0
    formats = {'byte':'B','short':'h','ushort':'H','int':'i','uint':'I','long':'q','ulong':'Q','float':'f','FP':'q'}
    indexed = set()
    for item in index:
        raw = (ROOT/item['export']).read_bytes()
        tag, length, version, count, crc = struct.unpack_from('>5I', raw)
        good = tag == 0x2def and length == len(raw) and crc == (zlib.crc32(raw[20:])^0xffffffff)
        check(good, 'header/CRC: '+item['export'])
        raw_headers += bool(good)
        if item['status'] != 'decoded-validated-static': continue
        decoded = load(item['decoded_json']); fields = item['schema']['fields']; rows = decoded['records']
        check(len(rows) == count == item['decoded_record_count'], 'record count: '+item['name'])
        check([c['destination_object_offset'] for c in item['unpack_reader_calls']] == [f['object_offset'] for f in fields], 'native field offsets: '+item['name'])
        check(all(c.get('receiver_is_entry_buffer') and c.get('sequential_overload_verified') for c in item['unpack_reader_calls']), 'native receiver/overload gates: '+item['name'])
        check(all(item.get('native_analysis_checks',{}).get(k) for k in ['local_cfg_acyclic','reader_order_dominates','scan_not_capped']), 'native local CFG gates: '+item['name'])
        encoded = bytearray(); pos = 20
        for i, row in enumerate(rows):
            check(row['_record_index'] == i and row['_byte_offset'] == pos, 'row origin: '+item['name'])
            start = len(encoded)
            for field in fields:
                typ = field['type']; key = field['name'] + ('__raw_int64' if typ == 'FP' else '')
                value = row[key]
                if typ == 'string':
                    data = value.encode('utf-8') + b'\0'
                    encoded.extend(struct.pack('>i', len(data))); encoded.extend(data)
                    formula_cells += bool(value.lstrip().startswith(('=', '+', '-', '@')))
                else: encoded.extend(struct.pack('>'+formats[typ], value))
            size = len(encoded)-start
            check(row['_byte_length'] == size, 'row size: '+item['name'])
            pos += size
        check(bytes(encoded) == raw[20:], 'binary roundtrip: '+item['name'])
        csvpath = ROOT/item['decoded_csv']; indexed.add((ROOT/item['decoded_json']).resolve())
        if rows:
            indexed.add(csvpath.resolve())
            with csvpath.open(encoding='utf-8-sig', newline='') as f: csvrows = list(csv.DictReader(f))
            check(len(csvrows) == len(rows), 'CSV count: '+item['name'])
            check(all({k:("'"+v if isinstance(v,str) and v.lstrip().startswith(('=','+','-','@')) else str(v)) for k,v in row.items()} == out for row,out in zip(rows,csvrows)), 'CSV values: '+item['name'])
        validated += 1; records += len(rows)
    check(raw_headers == summary['header_verified_count'], 'header summary count')
    check(validated == summary['status_counts'].get('decoded-validated-static',0), 'decoded summary count')
    check(records == summary['decoded_record_count'], 'decoded summary records')
    unindexed = [str(p.relative_to(ROOT)) for folder in ['ResDef','BattleCore'] for p in (ROOT/'derived/config-decoded'/folder).glob('*') if p.is_file() and p.resolve() not in indexed]
    check(not unindexed, 'unindexed config outputs: '+str(unindexed))
    from validate_gameplay_outputs import run as validate_gameplay
    gameplay=validate_gameplay()
    check(gameplay['status']=='passed','gameplay validation: '+str(gameplay['errors']))
    syntax_files = list((ROOT/'tools').glob('*.py'))
    for p in syntax_files: ast.parse(p.read_text(encoding='utf-8-sig'), filename=str(p))
    spec = importlib.util.spec_from_file_location('archive_resbin_decoder', ROOT/'tools/decode_resbin.py')
    decoder = importlib.util.module_from_spec(spec);spec.loader.exec_module(decoder)
    schema = {'fields':[{'type':'uint','name':'ID'},{'type':'string','name':'Text'},{'type':'FP','name':'Value'}]}
    payload = struct.pack('>Ii',7,7)+'勇者'.encode('utf-8')+b'\0'+struct.pack('>q',-4294967296)
    result = decoder.decode(b'\0'*20+payload,schema,1)
    check(result[0]['ID']==7 and result[0]['Text']=='勇者' and result[0]['Value__raw_int64']==-4294967296,'primitive decoder fixture')
    negative_tests = [b'\0'*20+payload[:-1],b'\0'*20+payload+b'X',b'\0'*20+struct.pack('>Ii',7,-1),b'\0'*20+struct.pack('>Ii',7,0),b'\0'*20+struct.pack('>Ii',7,2)+b'A!'+struct.pack('>q',0),b'\0'*20+struct.pack('>Ii',7,2)+b'\xff\0'+struct.pack('>q',0)]
    for i,data in enumerate(negative_tests):
        rejected=False
        try: decoder.decode(data,schema,1)
        except (ValueError,struct.error,UnicodeDecodeError): rejected=True
        check(rejected,'negative decoder fixture '+str(i))
    doc_links=0
    for doc in [ROOT/'README.md', *(ROOT/'reports').glob('*.md')]:
        if not doc.exists():continue
        for target in re.findall(r'\]\(<([^>]+)>\)',doc.read_text(encoding='utf-8')):
            if re.match(r'^(?:https?|mailto):',target):continue
            plain=target.split('#',1)[0]
            if plain:
                p=Path(plain)
                if not p.is_absolute(): p=doc.parent/p
                check(p.exists(),'broken doc link: '+str(doc.relative_to(ROOT))+' -> '+target)
                doc_links += 1
    out={'status':'passed' if not errors else 'failed','unity_bundles':len(bundles),'unity_objects':object_count,'textasset_hashes_checked':len(texts),'resbin_headers_checked':raw_headers,'decoded_tables_roundtripped':validated+gameplay.get('extended_tables_roundtripped',0),'decoded_records_roundtripped':records+gameplay.get('extended_records_roundtripped',0),'baseline_flat_tables_roundtripped':validated,'baseline_flat_records_roundtripped':records,'companion_candidate_tables_roundtripped':gameplay.get('companion_candidate_tables_roundtripped',0),'companion_candidate_records_roundtripped':gameplay.get('companion_candidate_records_roundtripped',0),'gameplay_validation_status':gameplay['status'],'csv_formula_like_string_cells':formula_cells,'python_scripts_ast_checked':len(syntax_files),'decoder_positive_fixtures':1,'decoder_negative_fixtures':len(negative_tests),'document_links_checked':doc_links,'errors':errors,'limits':['Static artifact and encoding consistency only; no game execution or runtime validation.','JSON preserves source strings; formula-like CSV string cells are apostrophe-prefixed. Import int64/uint64 columns as text to preserve precision.']}
    (ROOT/'inventory/output-validation.json').write_text(json.dumps(out,ensure_ascii=False,indent=2),encoding='utf-8')
    print(json.dumps(out,ensure_ascii=False,indent=2));return 0 if not errors else 1
if __name__=='__main__': sys.exit(main())
