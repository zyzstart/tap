"""Small reproducibility/safety fixtures. Does not touch the real APK or extracted data."""
from pathlib import Path
import importlib.util,zipfile,sys,contextlib,io,json
ROOT=Path(__file__).resolve().parents[1]
spec=importlib.util.spec_from_file_location('extractor',ROOT/'tools/extract_apk.py');m=importlib.util.module_from_spec(spec);spec.loader.exec_module(m)
fixtures=ROOT/'tools/selftest';fixtures.mkdir(exist_ok=True);results=[]
def run(name,entries,expected=None,rerun=False,modify=False):
 d=fixtures/name;d.mkdir(exist_ok=True);apk=d/'sample.zip'
 with zipfile.ZipFile(apk,'w') as z:
  for n,b in entries:
   info=zipfile.ZipInfo();info.filename=n;info.orig_filename=n;z.writestr(info,b)
 m.ROOT=d/'archive';sys.argv=['extract_apk.py',str(apk)]
 try:
  with contextlib.redirect_stdout(io.StringIO()):
   m.main()
   if modify:(m.ROOT/'unpacked/assets/test.txt').write_bytes(b'changed')
   if rerun or modify:m.main()
  ok=expected is None;error=''
 except ValueError as e:ok=expected is not None and expected in str(e);error=str(e)
 results.append({'test':name,'pass':ok,'expected_error':expected,'actual_error':error})
run('valid-and-resume',[('assets/test.txt',b'original')],rerun=True)
run('refuse-conflict',[('assets/test.txt',b'original')],expected='Refusing existing',modify=True)
run('path-traversal',[('../outside.txt',b'bad')],expected='Unsafe path')
run('case-collision',[('A.txt',b'a'),('a.txt',b'b')],expected='case-colliding')
run('backslash-path',[('assets\\bad.txt',b'bad')],expected='Unsafe path')
(ROOT/'logs/extraction-selftest.json').write_text(json.dumps(results,ensure_ascii=False,indent=2),encoding='utf-8');print(json.dumps(results,indent=2))
if not all(x['pass'] for x in results):raise SystemExit(1)
