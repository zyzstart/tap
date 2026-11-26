"""Extract ELF and IL2CPP metadata evidence without loading native code."""
from pathlib import Path
import sys,struct,json,csv,re,collections
ROOT=Path(__file__).resolve().parents[1]
sys.path.insert(0,str(ROOT/'tools/python-packages'))
from elftools.elf.elffile import ELFFile
OUT=ROOT/'derived/native';OUT.mkdir(parents=True,exist_ok=True)
def csvwrite(name,rows,fields):
 with (OUT/name).open('w',encoding='utf-8-sig',newline='') as f:
  w=csv.DictWriter(f,fieldnames=fields);w.writeheader();w.writerows(rows)
rows=[];urlrows=[]
for p in sorted((ROOT/'unpacked/lib').glob('*/*.so')):
 with p.open('rb') as f:
  e=ELFFile(f);dyn=e.get_section_by_name('.dynamic');needed=[]
  if dyn:
   needed=[t.needed for t in dyn.iter_tags() if t.entry.d_tag=='DT_NEEDED']
  sym=e.get_section_by_name('.dynsym');symbols=[]
  if sym:
   for s in sym.iter_symbols():
    if s.name: symbols.append({'name':s.name,'address':hex(s.entry.st_value),'size':s.entry.st_size,'type':s.entry.st_info.type,'section':str(s.entry.st_shndx)})
  dest=OUT/p.parent.name;dest.mkdir(exist_ok=True)
  (dest/(p.name+'.symbols.json')).write_text(json.dumps(symbols,ensure_ascii=False,indent=2),encoding='utf-8')
  rows.append({'path':p.relative_to(ROOT/'unpacked').as_posix(),'machine':e.header.e_machine,'bits':e.elfclass,'size':p.stat().st_size,'symbol_count':len(symbols),'needed':needed})
 data=p.read_bytes()
 for m in re.finditer(rb'(?:https?|wss?)://[^\x00-\x20<>"\x7f-\xff]{4,500}',data):
  urlrows.append({'source':p.relative_to(ROOT/'unpacked').as_posix(),'offset':hex(m.start()),'url':m.group().decode('ascii','replace')})
 if p.parent.name=='arm64-v8a' and p.name in ['libil2cpp.so','libdod_hot_il2cpp.so','libxlua.so','libunity.so']:
  strings=[{'offset':hex(m.start()),'value':m.group().decode('utf-8','replace')} for m in re.finditer(rb'[\x20-\x7e]{6,}',data)]
  csvwrite(p.name+'.ascii-strings.csv',strings,['offset','value'])
(OUT/'elf-summary.json').write_text(json.dumps(rows,ensure_ascii=False,indent=2),encoding='utf-8')
csvwrite('native-urls.csv',urlrows,['source','offset','url'])
p=ROOT/'unpacked/assets/bin/Data/Managed/Metadata/global-metadata.dat';data=p.read_bytes()
magic,version,literal_off,literal_size,literal_data_off,literal_data_size,string_off,string_size=struct.unpack_from('<8I',data)
summary={'magic':hex(magic),'version':version,'string_literal_offset':literal_off,'string_literal_size':literal_size,'literal_data_offset':literal_data_off,'literal_data_size':literal_data_size,'string_heap_offset':string_off,'string_heap_size':string_size}
strings=[]
for offset in range(literal_off,literal_off+literal_size,8):
 length,index=struct.unpack_from('<II',data,offset)
 if index+length>literal_data_size:continue
 value=data[literal_data_off+index:literal_data_off+index+length].decode('utf-8','replace')
 strings.append({'index':(offset-literal_off)//8,'offset':hex(literal_data_off+index),'length':length,'value':value})
csvwrite('metadata-string-literals.csv',strings,['index','offset','length','value'])
heap=[];start=string_off
while start<string_off+string_size:
 end=data.find(b'\x00',start,string_off+string_size)
 if end<0:break
 value=data[start:end].decode('utf-8','replace')
 if value:heap.append({'index':start-string_off,'offset':hex(start),'value':value})
 start=end+1
csvwrite('metadata-string-heap.csv',heap,['index','offset','value'])
summary.update(literal_count=len(strings),heap_string_count=len(heap))
(OUT/'metadata-summary.json').write_text(json.dumps(summary,indent=2),encoding='utf-8')
print(json.dumps({'elf_files':len(rows),'native_url_occurrences':len(urlrows),'metadata':summary},indent=2),flush=True)
