"""Read-only integrity checks; writes verification manifests only. No sample execution."""
from pathlib import Path
import hashlib,csv,json,datetime,zipfile
ROOT=Path(__file__).resolve().parents[1]
def sha(p):
 h=hashlib.sha256()
 with p.open('rb') as f:
  for b in iter(lambda:f.read(1024*1024),b''):h.update(b)
 return h.hexdigest()
def main():
 summary=json.loads((ROOT/'inventory/apk-summary.json').read_text(encoding='utf-8'));apk=Path(summary['source_apk']);fail=[];checked=0
 with (ROOT/'inventory/apk-files.csv').open(encoding='utf-8-sig',newline='') as f:
  rows=list(csv.DictReader(f))
 for row in rows:
  p=ROOT/'unpacked'/row['path'];checked+=1
  if not p.is_file():fail.append({'path':row['path'],'reason':'missing'})
  elif p.stat().st_size!=int(row['size']):fail.append({'path':row['path'],'reason':'size'})
  elif sha(p)!=row['sha256']:fail.append({'path':row['path'],'reason':'sha256'})
 actual_raw=sum(1 for p in (ROOT/'unpacked').rglob('*') if p.is_file())
 if actual_raw!=len(rows):fail.append({'path':'unpacked/','reason':'Unexpected raw file count','actual':actual_raw,'expected':len(rows)})
 apk_current=sha(apk);derived=[]
 for p in sorted((ROOT/'derived').rglob('*')):
  if p.is_file():derived.append({'path':p.relative_to(ROOT).as_posix(),'size':p.stat().st_size,'sha256':sha(p)})
 with (ROOT/'inventory/derived-files.csv').open('w',encoding='utf-8-sig',newline='') as f:
  w=csv.DictWriter(f,fieldnames=['path','size','sha256']);w.writeheader();w.writerows(derived)
 support=[]
 candidates=[ROOT/'README.md']+[p for folder in ['tools','reports'] for p in (ROOT/folder).rglob('*') if p.is_file() and '__pycache__' not in p.parts]
 candidates += [p for p in (ROOT/'inventory').glob('*') if p.is_file() and p.name not in ['derived-files.csv','support-files.csv','verification.json']]
 for p in sorted(candidates):
  if p.is_file():support.append({'path':p.relative_to(ROOT).as_posix(),'size':p.stat().st_size,'sha256':sha(p)})
 with (ROOT/'inventory/support-files.csv').open('w',encoding='utf-8-sig',newline='') as f:
  w=csv.DictWriter(f,fieldnames=['path','size','sha256']);w.writeheader();w.writerows(support)
 checks={'support_file_count':len(support),'support_total_bytes':sum(x['size'] for x in support),'manifest_scope':'unpacked files against extraction baseline; derived outputs and tools/reports/README/inventory as current SHA-256 snapshots. Logs and __pycache__ excluded.','time':datetime.datetime.now().astimezone().isoformat(),'source_apk_sha256_expected':summary['apk_sha256'],'source_apk_sha256_current':apk_current,'original_apk_unchanged':apk_current==summary['apk_sha256'],'zip_entry_count':len(rows),'extracted_files_checked':checked,'extracted_hash_pass':checked-len(fail),'extracted_hash_failures':fail,'derived_file_count':len(derived),'derived_total_bytes':sum(x['size'] for x in derived),'sample_executed':False,'game_server_contacted':False,'limitations':['Static archive integrity is not a runtime or standalone-playability test.','Tool executable/package downloads are not APK game resource downloads.','DummyDll and dump.cs contain recovered type information, not original C# method implementations.']}
 (ROOT/'inventory/verification.json').write_text(json.dumps(checks,ensure_ascii=False,indent=2),encoding='utf-8')
 print(json.dumps(checks,ensure_ascii=False,indent=2),flush=True)
 if fail or apk_current!=summary['apk_sha256']:raise SystemExit(1)
if __name__=='__main__':main()
