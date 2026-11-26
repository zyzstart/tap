"""Static ARM64 B/BL xrefs for selected parsers. Not full disassembly/control flow."""
from pathlib import Path
import json,struct,bisect,csv
ROOT=Path(__file__).resolve().parents[1]
OUT=ROOT/'derived/native';OUT.mkdir(parents=True,exist_ok=True)
b=(ROOT/'unpacked/lib/arm64-v8a/libil2cpp.so').read_bytes()
assert b[:5]==b'\x7fELF\x02'
phoff=struct.unpack_from('<Q',b,32)[0];entsize,num=struct.unpack_from('<HH',b,54)
segments=[]
for i in range(num):
 typ,flags,off,va,pa,filesz,memsz,align=struct.unpack_from('<IIQQQQQQ',b,phoff+i*entsize)
 if typ==1:segments.append((va,va+filesz,off))
def offset(va):
 for start,end,off in segments:
  if start<=va<end:return va-start+off
 raise ValueError(hex(va))
methods=json.loads((ROOT/'derived/il2cpp/arm64-v8a/script.json').read_text(encoding='utf-8'))['ScriptMethod']
address_names={}
for m in methods:address_names.setdefault(m['Address'],[]).append(m['Name'])
addresses=sorted(address_names);rows=[]
select=['BResBinUtil$$ParseHead','ResBinUtil$$ParseHead','CSharpTextConfig$$unpack','CSharpColorConfig$$unpack','BattleCore.LevelBaseConfig$$unpack','BattleCore.LongHunSkillConfig$$unpack','PbReadBuf$$readString','PbReadBuf$$readInt32','PbReadBuf$$readInt16']
for m in methods:
 if not any(x in m['Name'] for x in select):continue
 a=m['Address'];i=bisect.bisect_right(addresses,a);end=min(addresses[i] if i<len(addresses) else a+4096,a+4096)
 for pc in range(a,end,4):
  ins=struct.unpack_from('<I',b,offset(pc))[0]
  if ins&0xfc000000 in [0x94000000,0x14000000]:
   imm=ins&0x3ffffff
   if imm&(1<<25):imm-=1<<26
   target=pc+imm*4
   rows.append({'caller':m['Name'],'caller_start':hex(a),'instruction_va':hex(pc),'file_offset':hex(offset(pc)),'instruction_hex':f'{ins:08x}','opcode':'BL' if ins&0xfc000000==0x94000000 else 'B','target_va':hex(target),'target_name':' | '.join(address_names.get(target,[])),'boundary_rule':'next recovered method address, capped at 4096 bytes'})
with (OUT/'parser-direct-calls.csv').open('w',encoding='utf-8-sig',newline='') as f:
 w=csv.DictWriter(f,fieldnames=list(rows[0]) if rows else ['caller']);w.writeheader();w.writerows(rows)
print(json.dumps({'selected_methods':sorted(set(r['caller'] for r in rows)),'direct_branches':len(rows),'limitations':'Only direct B/BL decoded; no virtual calls, control-flow or argument dataflow verification. No native code execution.'},ensure_ascii=False,indent=2))
