"""Cross-variant wire-layout candidates; never promote them to native-unpack-verified.
Read only APK-derived bytes. Companion native-backed rows constrain every named value.
Unknown tail strings / 4-byte fields stay explicitly unnamed. Exact roundtrip is necessary,
not proof that this build actually loads the variant. FP projection uses Q32.32 only as a
cross-variant consistency test, not an assertion about gameplay units.
"""
from pathlib import Path
import collections, csv, hashlib, json, math, struct, zlib
from decode_resbin_extended import safe_csv_cell as csv_safe
ROOT = Path(__file__).resolve().parents[1]
OUT = ROOT / 'derived/config-layout-recovery'
FORMATS = {'byte':'B','short':'h','ushort':'H','int':'i','uint':'I','long':'q','ulong':'Q','float':'f','FP':'q'}
STATUS = 'cross-variant-layout-candidate'

def key(field):
    return field['name'] + ('__raw_int64' if field['type']=='FP' else '')

def check_header(raw):
    if len(raw)<20: raise ValueError('short header')
    tag, size, ver, count, crc = struct.unpack_from('>5I', raw)
    if tag!=0x2def or size!=len(raw) or ver!=1 or count>1_000_000 or crc!=(zlib.crc32(raw[20:])^0xffffffff):
        raise ValueError('header/size/CRC')
    return count

def decode(raw, fields, count):
    rows=[]; pos=20
    if count>1_000_000: raise ValueError('record limit')
    for i in range(count):
        row={'_record_index':i, '_byte_offset':pos}; start=pos
        for f in fields:
            typ=f['type']; name=key(f)
            if typ=='opaque4':
                if pos+4>len(raw): raise ValueError('truncated opaque field')
                row[name]=raw[pos:pos+4].hex(); pos+=4
            elif typ=='string':
                if pos+4>len(raw): raise ValueError('truncated string length')
                n=struct.unpack_from('>i',raw,pos)[0]; pos+=4
                if not 1<=n<=1_000_000 or pos+n>len(raw): raise ValueError('string bounds')
                b=raw[pos:pos+n];pos+=n
                if b[-1:]!=b'\0': raise ValueError('string terminator')
                row[name]=b[:-1].decode('utf-8',errors='strict')
            else:
                fmt='>'+FORMATS[typ]; n=struct.calcsize(fmt)
                if pos+n>len(raw): raise ValueError('truncated '+name)
                v=struct.unpack_from(fmt,raw,pos)[0];pos+=n
                if isinstance(v,float) and not math.isfinite(v): raise ValueError('nonfinite float')
                row[name]=v
        row['_byte_length']=pos-start; rows.append(row)
    if pos!=len(raw): raise ValueError('trailing bytes '+str(len(raw)-pos))
    return rows

def encode(rows,fields):
    b=bytearray()
    for row in rows:
        for f in fields:
            v=row[key(f)]; typ=f['type']
            if typ=='opaque4': b.extend(bytes.fromhex(v))
            elif typ=='string':
                s=v.encode('utf-8')+b'\0';b.extend(struct.pack('>i',len(s)));b.extend(s)
            else: b.extend(struct.pack('>'+FORMATS[typ],v))
    return bytes(b)

def compare(rows,fields,source_rows,source_fields):
    if len(rows)!=len(source_rows):raise ValueError('companion count differs')
    dest={f['name']:f for f in fields}; checks=collections.Counter()
    for row,source in zip(rows,source_rows):
        for sf in source_fields:
            if sf['name'] not in dest:raise ValueError('named source field omitted')
            df=dest[sf['name']];a=source[key(sf)];b=row[key(df)]
            if sf['type']=='FP' and df['type']=='float':
                ok=struct.pack('>f',a/(1<<32))==struct.pack('>f',b)
                kind='FP_to_float32_projection'
            elif sf['type']=='float' and df['type']=='FP':
                ok=struct.pack('>f',a)==struct.pack('>f',b/(1<<32))
                kind='float32_to_FP_projection'
            else:
                ok=sf['type']==df['type'] and a==b;kind='exact_named_value'
            if not ok:raise ValueError('companion value mismatch at row '+str(row['_record_index'])+' field '+sf['name'])
            checks[kind]+=1
    return dict(checks)

def candidates(source_fields,target_fp):
    fields=[dict(f) for f in source_fields]
    for f in fields:
        if target_fp and f['type']=='float': f['type']='FP'
        elif not target_fp and f['type']=='FP': f['type']='float'
    yield 'same-order-with-float-FP-transfer',fields
    # Strings here are deliberately NOT assigned a gameplay field name.
    yield 'same-order-plus-unnamed-tail-string',fields+[{'name':'_unmapped_tail_utf8_0','type':'string'}]
    # A single added four-byte cell is retained as opaque bytes, not guessed int/enum.
    for i in range(len(fields)+1):
        yield 'single-opaque4-insertion-at-'+str(i),fields[:i]+[{'name':'_unmapped_4bytes_0','type':'opaque4'}]+fields[i:]

def run():
    OUT.mkdir(parents=True,exist_ok=True)
    legacy=json.loads((ROOT/'derived/config-decoded/resbin-index.json').read_text(encoding='utf-8'))
    index=[]
    for item in legacy:
        if not item.get('reason','').startswith(('ValueError','UnicodeDecodeError')):continue
        out={k:item[k] for k in ['bundle','path_id','name','sha256','export','header']}
        out['status']='unresolved-variant-layout';out['legacy_reason']=item['reason']
        sib=[x for x in legacy if x['name']==item['name'] and x['bundle']!=item['bundle'] and x['status']=='decoded-validated-static']
        if len(sib)!=1:
            out['reason']='No unique native-backed companion';index.append(out);continue
        src=sib[0]; source=json.loads((ROOT/src['decoded_json']).read_text(encoding='utf-8'))
        raw=(ROOT/item['export']).read_bytes(); count=check_header(raw)
        if hashlib.sha256(raw).hexdigest()!=item['sha256']:raise ValueError('Source SHA256 mismatch')
        if hashlib.sha256((ROOT/src['export']).read_bytes()).hexdigest()!=src['sha256']:raise ValueError('Companion SHA256 mismatch')
        if len(source['records'])!=count:
            out['reason']='Companion count differs; no row correspondence assumed';index.append(out);continue
        accepted=[];rejections=[]
        for label,fields in candidates(src['schema']['fields'],'_resbin_fp_' in item['bundle']):
            try:
                rows=decode(raw,fields,count)
                checks=compare(rows,fields,source['records'],src['schema']['fields'])
                if encode(rows,fields)!=raw[20:]:raise ValueError('roundtrip mismatch')
                accepted.append((label,fields,rows,checks))
            except (ValueError,struct.error,OverflowError,UnicodeDecodeError) as e:
                rejections.append({'candidate':label,'reason':str(e)})
        # Distinct hypotheses that yield exactly the same schema are deduplicated only.
        unique={json.dumps(x[1],sort_keys=True):x for x in accepted}
        if len(unique)!=1:
            out['reason']='No unique fully companion-matched layout; matches='+str(len(unique));out['candidate_rejections']=rejections
            index.append(out);continue
        label,fields,rows,checks=next(iter(unique.values()))
        out.update(status=STATUS,layout_rule=label,fields=fields,companion_json=src['decoded_json'],companion_export=src['export'],companion_sha256=src['sha256'],named_value_checks=checks,decoded_record_count=len(rows),payload_roundtrip_sha256=hashlib.sha256(encode(rows,fields)).hexdigest())
        folder=OUT/('fp' if '_resbin_fp_' in item['bundle'] else 'nonfp');folder.mkdir(exist_ok=True)
        dest=folder/(item['name']+'.json'); csvdest=dest.with_suffix('.csv')
        out['decoded_json']=dest.relative_to(ROOT).as_posix();out['decoded_csv']=csvdest.relative_to(ROOT).as_posix()
        dest.write_text(json.dumps({'source':out,'limits':['Cross-variant hypothesis constrained by every companion named value, not the exact target unpack function.','Unnamed cells retain bytes/text only; no claimed gameplay meaning.','Q32.32 projection is a consistency check, not a statement of field units.','No sample execution or game-server contact.'],'records':rows},ensure_ascii=False,indent=2,allow_nan=False),encoding='utf-8')
        if rows:
            with csvdest.open('w',encoding='utf-8-sig',newline='') as f:
                writer=csv.DictWriter(f,fieldnames=list(rows[0]));writer.writeheader()
                writer.writerows({k:csv_safe(v) for k,v in row.items()} for row in rows)
        index.append(out)
    summary={'candidate_table_count':sum(x['status']==STATUS for x in index),'candidate_record_count':sum(x.get('decoded_record_count',0) for x in index),'attempted_table_count':len(index),'status_counts':dict(collections.Counter(x['status'] for x in index)),'not_in_native_verified_total':True,'limits':['Companion row/value identity plus strict CRC/count/EOF/UTF8/roundtrip, not a native target-variant implementation proof.','Unknown string/opaque columns intentionally unnamed. Failed/ambiguous layouts are not exported.']}
    (OUT/'layout-index.json').write_text(json.dumps(index,ensure_ascii=False,indent=2),encoding='utf-8')
    (OUT/'layout-summary.json').write_text(json.dumps(summary,ensure_ascii=False,indent=2),encoding='utf-8')
    print(json.dumps(summary,ensure_ascii=False,indent=2))

if __name__=='__main__':run()
