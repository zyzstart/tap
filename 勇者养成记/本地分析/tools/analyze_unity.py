"""Static Unity bundle inventory and text/config extraction. Never loads game code."""
from pathlib import Path
import sys,json,csv,collections,hashlib,re,argparse,gc,time
ROOT=Path(__file__).resolve().parents[1]
sys.path.insert(0,str(ROOT/'tools/python-packages'))
import UnityPy
OUT=ROOT/'derived/unity'
def safe(v): return re.sub(r'[^\w.\-\u4e00-\u9fff]+','_',str(v))[:180] or 'unnamed'
def normalize(v):
 if isinstance(v,bytes):return {'bytes_hex':v.hex()}
 if isinstance(v,dict):return {str(k):normalize(x) for k,x in v.items()}
 if isinstance(v,(list,tuple)):return [normalize(x) for x in v]
 return v

def main():
 ap=argparse.ArgumentParser();ap.add_argument('--limit',type=int,default=0);args=ap.parse_args()
 for d in ['text','typetrees','previews']: (OUT/d).mkdir(parents=True,exist_ok=True)
 bundles=sorted((ROOT/'unpacked/assets/ab').glob('*.ab'))
 if args.limit:bundles=bundles[:args.limit]
 index=[];objects=[];textindex=[];errors=[];types=collections.Counter();versions=collections.Counter();previewcount=0;start=time.time()
 for idx,p in enumerate(bundles):
  rel=p.relative_to(ROOT/'unpacked').as_posix();counts=collections.Counter()
  try:
   env=UnityPy.load(str(p));container={}
   try:
    for k,v in env.container.items():container[v.path_id]=k
   except Exception as e:errors.append({'source':rel,'stage':'container','error':str(e)})
   for obj in env.objects:
    typ=obj.type.name;types[typ]+=1;counts[typ]+=1;version=getattr(obj.assets_file,'unity_version','unknown');versions[str(version)]+=1
    sourcepath=container.get(obj.path_id,'');name='';export=''
    try:
     if typ=='TextAsset':
      data=obj.read();name=data.m_Name;payload=data.m_Script
      if isinstance(payload,str):payload=payload.encode('utf-8','surrogateescape')
      dest=OUT/'text'/safe(p.stem)/(safe(name)+f'__{obj.path_id}.bin');dest.parent.mkdir(parents=True,exist_ok=True);dest.write_bytes(payload)
      try:
       txt=payload.decode('utf-8')
       if '\x00' not in txt and sum(c.isprintable() or c in '\t\n\r' for c in txt)/max(len(txt),1)>.92:
        textdest=dest.with_suffix('.txt');textdest.write_text(txt,encoding='utf-8');export=textdest.relative_to(ROOT).as_posix();fmt='utf8-text'
       else:fmt='binary'
      except UnicodeDecodeError:fmt='binary'
      textindex.append({'bundle':rel,'path_id':obj.path_id,'container_path':sourcepath,'name':name,'size':len(payload),'sha256':hashlib.sha256(payload).hexdigest(),'format':fmt,'head_hex':payload[:32].hex(),'export':dest.relative_to(ROOT).as_posix(),'readable_export':export})
      if not export:export=dest.relative_to(ROOT).as_posix()
     elif typ=='MonoBehaviour' and any(x in p.name for x in ['config','scene','manifest']):
      tree=obj.read_typetree();name=tree.get('m_Name','');dest=OUT/'typetrees'/safe(p.stem)/(safe(name)+f'__{obj.path_id}.json');dest.parent.mkdir(parents=True,exist_ok=True);dest.write_text(json.dumps(normalize(tree),ensure_ascii=False,indent=2),encoding='utf-8');export=dest.relative_to(ROOT).as_posix()
     elif typ in ['Texture2D','Sprite'] and previewcount<40 and any(x in p.name for x in ['assets_uiraw_yshome.','assets_uiraw_ysicon_equipment.','assets_uiraw_ysicon-props.','assets_uiraw_yskapai_head.','assets_uiraw_yszjbsx.']):
      data=obj.read();name=data.m_Name;im=data.image
      if im.width>=48 and im.height>=48:
       im.thumbnail((1024,1024));dest=OUT/'previews'/(safe(p.stem)+'__'+safe(name)+f'__{obj.path_id}.png');im.save(dest);export=dest.relative_to(ROOT).as_posix();previewcount+=1
    except Exception as e:errors.append({'source':rel,'path_id':obj.path_id,'type':typ,'stage':'object_export','error':str(e)[:1000]})
    objects.append({'bundle':rel,'path_id':obj.path_id,'type':typ,'container_path':sourcepath,'name':name,'export':export})
   index.append({'bundle':rel,'size':p.stat().st_size,'objects':sum(counts.values()),'types':dict(counts),'status':'parsed'})
  except Exception as e:
   errors.append({'source':rel,'stage':'bundle_load','error':str(e)[:1500]});index.append({'bundle':rel,'size':p.stat().st_size,'status':'failed'})
  if (idx+1)%100==0: print(f'{idx+1}/{len(bundles)} bundles; objects={sum(types.values())}; text={len(textindex)}; errors={len(errors)}',flush=True);gc.collect()
 for filename,data in [('bundle-index.json',index),('textasset-index.json',textindex),('export-errors.json',errors)]: (OUT/filename).write_text(json.dumps(data,ensure_ascii=False,indent=2),encoding='utf-8')
 with (OUT/'object-index.csv').open('w',encoding='utf-8-sig',newline='') as f:
  w=csv.DictWriter(f,fieldnames=['bundle','path_id','type','container_path','name','export']);w.writeheader();w.writerows(objects)
 summary={'bundle_count':len(bundles),'parsed':sum(x['status']=='parsed' for x in index),'failed':sum(x['status']=='failed' for x in index),'object_count':sum(types.values()),'types':dict(types),'object_unity_versions':dict(versions),'textasset_count':len(textindex),'readable_text_count':sum(x['format']=='utf8-text' for x in textindex),'preview_count':previewcount,'export_error_count':len(errors),'elapsed_seconds':round(time.time()-start,1),'UnityPy_version':getattr(UnityPy,'__version__','unknown')}
 (OUT/'unity-summary.json').write_text(json.dumps(summary,ensure_ascii=False,indent=2),encoding='utf-8');print(json.dumps(summary,ensure_ascii=False,indent=2),flush=True)
if __name__=='__main__':main()
