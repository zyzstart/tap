"""Offline APK evidence extraction. Does not install or execute sample code."""
from pathlib import Path, PurePosixPath
import argparse, zipfile, hashlib, json, csv, collections, datetime, sys
ROOT = Path(__file__).resolve().parents[1]
def sha256(path):
    h=hashlib.sha256()
    with path.open('rb') as f:
        for b in iter(lambda:f.read(1024*1024), b''): h.update(b)
    return h.hexdigest()
def main():
    ap=argparse.ArgumentParser(); ap.add_argument('apk',type=Path); args=ap.parse_args()
    apk=args.apk.resolve()
    for d in ['inventory','unpacked','derived','reports','logs','tools']: (ROOT/d).mkdir(parents=True,exist_ok=True)
    rows=[]; totals=collections.defaultdict(lambda:[0,0]); exts=collections.defaultdict(lambda:[0,0])
    seen=set()
    with zipfile.ZipFile(apk) as z:
        for i in z.infolist():
            folded=i.filename.casefold()
            if folded in seen: raise ValueError('Duplicate/case-colliding ZIP path: '+i.filename)
            seen.add(folded)
            p=PurePosixPath(i.filename)
            raw_name=getattr(i,'orig_filename',i.filename)
            if p.is_absolute() or '..' in p.parts or '\\' in raw_name or '\x00' in raw_name or any(':' in part for part in p.parts): raise ValueError('Unsafe path: '+raw_name)
            if i.is_dir(): continue
            target=ROOT/'unpacked'/Path(*p.parts); target.parent.mkdir(parents=True,exist_ok=True)
            if not target.resolve().is_relative_to((ROOT/'unpacked').resolve()): raise ValueError('Resolved path escapes archive: '+i.filename)
            exists=target.exists()
            if exists and (not target.is_file() or target.stat().st_size!=i.file_size): raise ValueError('Refusing existing conflicting output: '+i.filename)
            h=hashlib.sha256()
            if exists:
                with z.open(i) as src:
                    for b in iter(lambda:src.read(1024*1024), b''): h.update(b)
                if sha256(target)!=h.hexdigest(): raise ValueError('Refusing existing different bytes: '+i.filename)
            else:
                with z.open(i) as src, target.open('xb') as dst:
                    for b in iter(lambda:src.read(1024*1024), b''): h.update(b);dst.write(b)
            ext=p.suffix.lower() or '(none)'; group='/'.join(p.parts[:2]) if len(p.parts)>1 else '(root)'
            totals[group][0]+=1;totals[group][1]+=i.file_size;exts[ext][0]+=1;exts[ext][1]+=i.file_size
            rows.append({'path':i.filename,'size':i.file_size,'compressed_size':i.compress_size,'crc32':f'{i.CRC:08x}','sha256':h.hexdigest(),'extension':ext})
    with (ROOT/'inventory/apk-files.csv').open('w',encoding='utf-8-sig',newline='') as f:
        w=csv.DictWriter(f,fieldnames=list(rows[0]));w.writeheader();w.writerows(rows)
    info={'analysis_time':datetime.datetime.now().astimezone().isoformat(),'source_apk':str(apk),'apk_size':apk.stat().st_size,'apk_sha256':sha256(apk),'file_count':len(rows),'uncompressed_size':sum(r['size'] for r in rows),'groups':dict(totals),'extensions':dict(exts),'largest_files':sorted(rows,key=lambda r:r['size'],reverse=True)[:30],'policy':'Offline static analysis only; original APK retained; sample not executed; no service contacted'}
    (ROOT/'inventory/apk-summary.json').write_text(json.dumps(info,ensure_ascii=False,indent=2),encoding='utf-8')
    (ROOT/'inventory/source.sha256').write_text(info['apk_sha256']+'  '+apk.name+'\n',encoding='utf-8')
    print(json.dumps({k:info[k] for k in ['apk_sha256','file_count','uncompressed_size']},indent=2),flush=True)
if __name__=='__main__': main()
