"""Conservative static resbin decoding: primitive/string schemas only, with strict bounds,
header/CRC/count/EOF checks and matching ARM64 direct reader-call order. No game execution.
Unsupported arrays/nested types remain raw. FP values remain signed raw int64, not normalized.
"""
from pathlib import Path
import json,re,struct,zlib,csv,bisect,collections,math
ROOT=Path(__file__).resolve().parents[1];OUT=ROOT/'derived/config-decoded'
PRIMITIVES={'byte':('B','readUInt8'),'short':('h','readInt16'),'ushort':('H','readUInt16'),'int':('i','readInt32'),'uint':('I','readUInt32'),'long':('q','readInt64'),'ulong':('Q','readUInt64'),'float':('f','readFloat'),'FP':('q','readInt64'),'string':(None,'readString')}
def decode(data,schema,count):
 rows=[];pos=20
 for i in range(count):
  start=pos;row={'_record_index':i,'_byte_offset':pos}
  for f in schema['fields']:
   typ,name=f['type'],f['name'];fmt=PRIMITIVES[typ][0]
   if fmt:
    size=struct.calcsize('>'+fmt)
    if pos+size>len(data):raise ValueError('Truncated field '+name)
    val=struct.unpack_from('>'+fmt,data,pos)[0];pos+=size
    if isinstance(val,float) and not math.isfinite(val):raise ValueError('Non-finite float '+name)
   else:
    if pos+4>len(data):raise ValueError('Truncated string length')
    size=struct.unpack_from('>i',data,pos)[0];pos+=4
    if size<1 or size>1000000 or pos+size>len(data):raise ValueError('Invalid string length '+str(size))
    raw=data[pos:pos+size];pos+=size
    if raw[-1:]!=b'\x00':raise ValueError('Expected string terminator')
    val=raw[:-1].decode('utf-8')
   row[name+'__raw_int64' if typ=='FP' else name]=val
  row['_byte_length']=pos-start;rows.append(row)
 if pos!=len(data):raise ValueError(f'Trailing bytes: {len(data)-pos}')
 return rows
def main():
 OUT.mkdir(parents=True,exist_ok=True)
 text=(ROOT/'derived/il2cpp/arm64-v8a/dump.cs').read_text(encoding='utf-8-sig')
 schemas={}
 for match in re.finditer(r'^// Namespace: ([^\n]*)\n((?:(?!^// Namespace: ).*\n)*)',text,re.M):
  ns,block=match.groups();ns=ns.strip();cm=re.search(r'^\w+(?: \w+)* class (\w+) : (?:BProtoBaseStruct|ProtoBaseStruct) ',block,re.M)
  if not cm or ns not in ['BattleCore','ResDef']:continue
  fields=re.findall(r'^\s*public ([\w<>\[\].]+) (\w+); // (0x[0-9A-F]+)',block.split('// Methods')[0],re.M)
  public_lines=re.findall(r'^\s*public .*; // 0x',block.split('// Methods')[0],re.M)
  if len(fields)!=len(public_lines):continue
  unpack=re.search(r'// RVA: (0x[0-9A-F]+)[^\n]*\n\s*public [^\n]* unpack\(',block)
  if fields and unpack:schemas[(ns,cm.group(1))]={'namespace':ns,'name':cm.group(1),'fields':[{'type':t,'name':n,'object_offset':int(o,16)} for t,n,o in fields],'unpack_va':int(unpack.group(1),16),'dump_line':text.count('\n',0,match.start())+1}
 methods=json.loads((ROOT/'derived/il2cpp/arm64-v8a/script.json').read_text(encoding='utf-8'))['ScriptMethod'];names={}
 for m in methods:names.setdefault(m['Address'],[]).append(m['Name'])
 rb=re.search(r'^public class PbReadBuf .*?^}',text,re.M|re.S).group(0)
 sequential={int(a,16):n for a,n in re.findall(r'// RVA: (0x[0-9A-F]+)[^\n]*\n\s*public PbError.ErrorType (read\w+)\(out \w+ dest(?:, int maxStrSize)?\)',rb)}
 addrs=sorted(names);binary=(ROOT/'unpacked/lib/arm64-v8a/libil2cpp.so').read_bytes();phoff=struct.unpack_from('<Q',binary,32)[0];entsize,num=struct.unpack_from('<HH',binary,54);segments=[]
 for i in range(num):
  typ,flags,off,va,pa,filesz,memsz,align=struct.unpack_from('<IIQQQQQQ',binary,phoff+i*entsize)
  if typ==1:segments.append((va,va+filesz,off))
 def offset(va):
  for start,end,off in segments:
   if start<=va<end:return va-start+off
  raise ValueError('VA not mapped')
 def reader_calls(start):
  i=bisect.bisect_right(addrs,start);end=min(addrs[i] if i<len(addrs) else start+16384,start+16384)
  words={pc:struct.unpack_from('<I',binary,offset(pc))[0] for pc in range(start,end,4)};states={start:{0:('self',0),1:('buffer',0)}};queue=collections.deque([start]);edges={}
  def signed(v,bits):return v-(1<<bits) if v&(1<<(bits-1)) else v
  while queue:
   pc=queue.popleft();ins=words[pc];regs=dict(states[pc]);rd=ins&31;succ=[pc+4]
   if ins&0xfc000000 in (0x94000000,0x14000000):
    target=pc+signed(ins&0x3ffffff,26)*4
    if ins&0xfc000000==0x94000000:
     for reg in [*range(19),30]:regs.pop(reg,None)
    else:succ=[target]
   elif ins&0x7e000000 in (0x34000000,0x36000000):
    bits=14 if ins&0x7e000000==0x36000000 else 19;succ.append(pc+signed((ins>>5)&((1<<bits)-1),bits)*4)
   elif ins&0xff000010==0x54000000:succ.append(pc+signed((ins>>5)&0x7ffff,19)*4)
   elif ins&0xfffffc1f in (0xd65f0000,0xd61f0000):succ=[] # RET / BR
   elif ins&0xfffffc1f==0xd63f0000:
    for reg in [*range(19),30]:regs.pop(reg,None) # BLR
   elif ins&0xffe0ffe0==0xaa0003e0:
    src=(ins>>16)&31
    if src in regs:regs[rd]=regs[src]
    else:regs.pop(rd,None)
   elif ins&0xff000000==0x91000000:
    src=(ins>>5)&31;imm=((ins>>10)&4095)<<(12 if (ins>>22)&1 else 0)
    if src in regs:regs[rd]=(regs[src][0],regs[src][1]+imm)
    else:regs.pop(rd,None)
   else:
    regs.pop(rd,None) # Conservative loss on other potential GPR writes.
    if ins&0x3a400000==0x28400000:regs.pop((ins>>10)&31,None)
   regs.pop(31,None) # Do not conflate MOV XZR with ADD SP; SP provenance is not modeled.
   # Pre/post-index load/store instructions may overwrite their base register.
   if ins&0x3b200000==0x38000000 and (ins>>10)&3 in (1,3):regs.pop((ins>>5)&31,None)
   if ins&0x3a000000==0x28000000 and (ins>>23)&3 in (1,3):regs.pop((ins>>5)&31,None)
   edges[pc]=[n for n in succ if n in words]
   for nxt in edges[pc]:
    old=states.get(nxt);merged=dict(regs) if old is None else {r:v for r,v in old.items() if regs.get(r)==v}
    if old is None or old!=merged:states[nxt]=merged;queue.append(nxt)
  calls=[]
  for pc,ins in words.items():
   if pc not in states or ins&0xfc000000 not in (0x94000000,0x14000000):continue
   target=pc+signed(ins&0x3ffffff,26)*4
   for n in names.get(target,[]):
    if n.startswith('ProtoBase.PbReadBuf$$read'):
     dest=states[pc].get(1);calls.append({'instruction_va':hex(pc),'target_va':hex(target),'opcode':'BL' if ins&0xfc000000==0x94000000 else 'B-tail','reader':n.split('$$')[1],'destination_object_offset':dest[1] if dest and dest[0]=='self' else None,'receiver_is_entry_buffer':states[pc].get(0)==('buffer',0),'sequential_overload_verified':sequential.get(target)==n.split('$$')[1]});break
  nodes=sorted(states);pred={n:[] for n in nodes}
  for pc,succ in edges.items():
   for nxt in succ:pred[nxt].append(pc)
  indegree={n:len(pred[n]) for n in nodes};pending=collections.deque(n for n in nodes if not indegree[n]);visited=0
  while pending:
   pc=pending.popleft();visited+=1
   for nxt in edges[pc]:
    indegree[nxt]-=1
    if not indegree[nxt]:pending.append(nxt)
  bits={n:1<<i for i,n in enumerate(nodes)};allbits=(1<<len(nodes))-1;dom={n:(bits[n] if n==start else allbits) for n in nodes};changed=True
  while changed:
   changed=False
   for n in nodes:
    if n==start:continue
    value=allbits
    for p in pred[n]:value&=dom[p]
    value|=bits[n]
    if value!=dom[n]:dom[n]=value;changed=True
  callnodes=[int(c['instruction_va'],16) for c in calls]
  checks={'local_cfg_acyclic':visited==len(nodes),'reader_order_dominates':all(bool(dom[b]&bits[a]) for a,b in zip(callnodes,callnodes[1:])),'scan_not_capped':end-start<16384,'callee_saved_register_assumption':'AAPCS64; callees not independently proved'}
  return calls,checks
 index=[]
 assets=json.loads((ROOT/'derived/unity/textasset-index.json').read_text(encoding='utf-8'))
 for asset in assets:
  if '_resbin_' not in asset['bundle']:continue
  data=(ROOT/asset['export']).read_bytes();item={k:asset[k] for k in ['bundle','path_id','name','sha256','export']};item['status']='header-unverified'
  try:
   if len(data)<20:raise ValueError('Too short for header')
   tag,size,ver,count,crc=struct.unpack_from('>5I',data);actual=zlib.crc32(data[20:])^0xffffffff
   item['header']={'tag':hex(tag),'file_size':size,'version':ver,'record_count':count,'stored_crc32':f'{crc:08x}','computed_inverted_crc32':f'{actual:08x}'}
   if tag!=0x2def or size!=len(data) or crc!=actual:raise ValueError('Header or CRC mismatch')
   item['status']='raw-header-verified';ns='BattleCore' if '_resbin_fp_' in asset['bundle'] else 'ResDef';schema=schemas.get((ns,asset['name']))
   item['schema_selection']='Namespace preference from fp bundle prefix'
   if not schema:
    candidates=[s for (n,k),s in schemas.items() if k==asset['name']]
    if len(candidates)==1:schema=candidates[0];item['schema_selection']='Unique exact class name across supported namespaces, verified against readers and payload'
   if not schema:item['reason']='No unambiguous matching namespace/name schema';index.append(item);continue
   item['schema']=schema;ns=schema['namespace'];unsupported=[f for f in schema['fields'] if f['type'] not in PRIMITIVES]
   if unsupported:item['reason']='Unsupported arrays/nested/enum fields: '+', '.join(f['type']+' '+f['name'] for f in unsupported);index.append(item);continue
   calls,checks=reader_calls(schema['unpack_va']);item['unpack_reader_calls']=calls;item['native_analysis_checks']=checks;expected=[PRIMITIVES[f['type']][1] for f in schema['fields']]
   if not all(checks[k] for k in ['local_cfg_acyclic','reader_order_dominates','scan_not_capped']) or not all(c['receiver_is_entry_buffer'] and c['sequential_overload_verified'] for c in calls):item['reason']='Local CFG, receiver provenance or sequential-overload gate not satisfied';index.append(item);continue
   if [c['reader'] for c in calls]!=expected:item['reason']='Reader-call order does not match schema; needs control-flow review';index.append(item);continue
   if [c['destination_object_offset'] for c in calls]!=[f['object_offset'] for f in schema['fields']]:item['reason']='Reader destination object offsets could not be conservatively matched to metadata fields';index.append(item);continue
   rows=decode(data,schema,count);item['decoded_record_count']=len(rows);item['status']='decoded-validated-static';folder=OUT/ns;folder.mkdir(exist_ok=True)
   suffix='__nonfp' if item['schema_selection'].startswith('Unique') and '_resbin_fp_' not in asset['bundle'] else ''
   dest=folder/(asset['name']+suffix+'.json');csvdest=dest.with_suffix('.csv')
   dest.write_text(json.dumps({'source':item,'validation':'Big-endian header/size/inverted payload CRC; reader-call sequence and destination object offsets (bounded local-branch CFG, conservative MOV/ADD register tracking and ABI clobbers); record count; UTF-8 string terminators; exact EOF. Not full control-flow or runtime verification. FP columns are raw int64.','records':rows},ensure_ascii=False,indent=2,allow_nan=False),encoding='utf-8')
   if rows:
    with csvdest.open('w',encoding='utf-8-sig',newline='') as f:
     w=csv.DictWriter(f,fieldnames=list(rows[0]));w.writeheader();w.writerows({k:("'"+v if isinstance(v,str) and v.lstrip().startswith(('=','+','-','@')) else v) for k,v in row.items()} for row in rows)
   item['decoded_json']=dest.relative_to(ROOT).as_posix();item['decoded_csv']=csvdest.relative_to(ROOT).as_posix() if rows else ''
  except Exception as e:item['reason']=type(e).__name__+': '+str(e)
  index.append(item)
 (OUT/'resbin-index.json').write_text(json.dumps(index,ensure_ascii=False,indent=2),encoding='utf-8')
 counts=collections.Counter(i['status'] for i in index);summary={'table_count':len(index),'status_counts':dict(counts),'decoded_record_count':sum(i.get('decoded_record_count',0) for i in index),'header_verified_count':sum('header' in i and i['header']['stored_crc32']==i['header']['computed_inverted_crc32'] and i['header']['tag']=='0x2def' and i['header']['file_size']==(ROOT/i['export']).stat().st_size for i in index),'limits':['No arrays, nested objects or enum guesses.','No game execution and no effective live configuration claim.','Bounded direct CFG gates are not unpack equivalence proof; unknown callees may mutate the buffer; AAPCS64 preservation is assumed.','Payload big-endian model is consistent with static reader evidence and string lengths; roundtrip alone does not establish runtime endianness.','String maxStrSize and embedded-NUL runtime semantics are not recovered; 1 MB is a tool acceptance limit.','FP remains signed raw int64; no scaling assumption.','CSV spreadsheet-formula-like string cells are prefixed with an apostrophe; JSON preserves original strings.']}
 (OUT/'resbin-summary.json').write_text(json.dumps(summary,ensure_ascii=False,indent=2),encoding='utf-8');print(json.dumps(summary,ensure_ascii=False,indent=2))
if __name__=='__main__':main()
