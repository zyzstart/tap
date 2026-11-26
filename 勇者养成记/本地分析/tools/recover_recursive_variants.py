"""Companion-constrained recursive FLOAT/FP layout transfer, NOT native target proof.
Uses fixed array shapes from a native-backed companion; verifies ALL named leaf values,
counts, strict bounds/UTF8, exact EOF and full byte roundtrip. No APK/native execution.
"""
from pathlib import Path
import collections, copy, hashlib, json, struct
import decode_resbin_extended as d
ROOT=d.ROOT
OUT=ROOT/'derived/config-layout-recovery-recursive'
STATUS='cross-variant-layout-candidate'

def transfer(schemas,target_fp):
    result=copy.deepcopy(schemas)
    for schema in result.values():
        for field in schema['layout']:
            old='float' if target_fp else 'FP';new='FP' if target_fp else 'float'
            if field['wire_type']==old:
                field['wire_type']=new
                field['type']=new+('[]' if field['kind']=='array' else '')
        # Original native analysis is provenance of the COMPANION ONLY, never target proof.
        schema['native_analysis_applies_to']='companion-input-only; target uses transferred hypothetical float width'
    return result

def check_values(rows,source_rows,source_schemas,target_schemas,name):
    if len(rows)!=len(source_rows):raise ValueError('companion count differs')
    checks=collections.Counter()
    def compare_obj(row,src,source_name):
        target_fields={f['name']:f for f in target_schemas[source_name]['layout']}
        for sf in source_schemas[source_name]['layout']:
            tf=target_fields[sf['name']];a=src[d.field_key(sf)];b=row[d.field_key(tf)]
            av=a if sf['kind']=='array' else [a];bv=b if tf['kind']=='array' else [b]
            if len(av)!=len(bv):raise ValueError('companion fixed count differs')
            for a,b in zip(av,bv):
                if 'nested_schema' in sf:
                    compare_obj(b,a,sf['nested_schema']);continue
                if sf['wire_type']=='FP' and tf['wire_type']=='float':
                    ok=struct.pack('>f',a/(1<<32))==struct.pack('>f',b);kind='FP_to_float32_projection'
                elif sf['wire_type']=='float' and tf['wire_type']=='FP':
                    ok=struct.pack('>f',a)==struct.pack('>f',b/(1<<32));kind='float32_to_FP_projection'
                else:ok=sf['wire_type']==tf['wire_type'] and a==b;kind='exact_named_value'
                if not ok:raise ValueError('companion mismatch '+source_name+'.'+sf['name'])
                checks[kind]+=1
    for row,src in zip(rows,source_rows):compare_obj(row,src,name)
    return dict(checks)

def run():
    OUT.mkdir(parents=True,exist_ok=True)
    original_schemas={p.stem:json.loads(p.read_text(encoding='utf-8')) for p in (ROOT/'derived/config-extended/schemas').glob('*.json')}
    baseline=json.loads((ROOT/'derived/config-decoded/resbin-index.json').read_text(encoding='utf-8'))
    extended=json.loads((ROOT/'derived/config-extended/resbin-index.json').read_text(encoding='utf-8'))
    results=[]
    for item in extended:
        if item['status']!='payload-rejected':continue
        entry={k:item[k] for k in ['bundle','path_id','name','sha256','export','schema']}
        entry['status']='unresolved-variant-layout'; entry['native_reject_reason']=item['reason']
        companion=[x for x in baseline+extended if x['name']==item['name'] and x['bundle']!=item['bundle'] and x['status'] in ('decoded-validated-static','decoded-validated-native-recursive')]
        if len(companion)!=1 or companion[0]['status']!='decoded-validated-native-recursive':
            entry['reason']='No unique recursively decoded companion';results.append(entry);continue
        src=companion[0];name=src['schema']
        if hashlib.sha256((ROOT/src['export']).read_bytes()).hexdigest()!=src['sha256']:raise ValueError('companion source hash mismatch')
        srcdoc=json.loads((ROOT/src['decoded_json']).read_text(encoding='utf-8'))
        raw=(ROOT/item['export']).read_bytes()
        if hashlib.sha256(raw).hexdigest()!=item['sha256']:raise ValueError('source hash mismatch')
        try:
            schemas=transfer(original_schemas,'_resbin_fp_' in item['bundle'])
            codec=d.Codec(schemas);header,rows,validation=codec.decode(raw,name)
            checks=check_values(rows,srcdoc['records'],original_schemas,schemas,name)
            entry.update(status=STATUS,header=header,decoded_record_count=len(rows),validation=validation,named_value_checks=checks,companion_schema=name,companion_json=src['decoded_json'],companion_sha256=src['sha256'])
            folder=OUT/('fp' if '_resbin_fp_' in item['bundle'] else 'nonfp');folder.mkdir(exist_ok=True)
            dest=folder/(item['name']+'.json');csvdest=dest.with_suffix('.csv')
            entry['decoded_json']=dest.relative_to(ROOT).as_posix();entry['decoded_csv']=csvdest.relative_to(ROOT).as_posix()
            dest.write_text(json.dumps({'source':entry,'limits':['Companion-derived recursive shape plus float32/FP width transfer hypothesis, not target native unpack proof.','All named leaf values must match companion exactly or via bit-exact float32 projection; no semantic guessing or epsilon tolerance.','No sample/native execution or game-server contact.'],'records':rows},ensure_ascii=False,indent=2,allow_nan=False),encoding='utf-8')
            import csv
            with csvdest.open('w',encoding='utf-8-sig',newline='') as f:
                writer=csv.DictWriter(f,fieldnames=list(rows[0]) if rows else [])
                writer.writeheader();writer.writerows({k:d.safe_csv_cell(v) for k,v in row.items()} for row in rows)
        except (ValueError,KeyError,struct.error,OverflowError) as exc:
            entry['reason']=type(exc).__name__+': '+str(exc)
        results.append(entry)
    summary={'attempted_table_count':len(results),'candidate_table_count':sum(x['status']==STATUS for x in results),'candidate_record_count':sum(x.get('decoded_record_count',0) for x in results),'status_counts':dict(collections.Counter(x['status'] for x in results)),'not_in_native_verified_total':True,'limits':['Recursive shape transferred from native-backed companion, not the target native implementation.','Only exact named leaf agreement / bit-exact float32 projection accepted; no missing/unknown field inference.']}
    d.write_json(OUT/'layout-index.json',results);d.write_json(OUT/'layout-summary.json',summary)
    print(json.dumps(summary,ensure_ascii=False,indent=2))

if __name__=='__main__':run()
