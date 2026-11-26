#!/usr/bin/env python3
"""Offline ARM64 IL2CPP evidence emitter + host-only reference models.
Never loads/executes APK native code. Requires local capstone; standard-library ELF.
Run from archive parent: python -B 本地分析/tools/recover_client_algorithms.py
"""
from __future__ import annotations
import argparse, bisect, hashlib, json, re, struct, sys
from pathlib import Path

MASK32=(1<<32)-1
MASK64=(1<<64)-1
ONE=1<<32

def sha(data): return hashlib.sha256(data).hexdigest()
def jwrite(p,obj): p.write_text(json.dumps(obj,ensure_ascii=False,indent=2)+'\n',encoding='utf-8')
def s64(x):
    x &= MASK64
    return x-(1<<64) if x>>63 else x

class ELF:
    def __init__(self,path):
        self.data=path.read_bytes()
        if self.data[:6]!=b'\x7fELF\x02\x01': raise ValueError('expected ELF64 little endian')
        h=struct.unpack_from('<HHIQQQIHHHHHH',self.data,16)
        if h[1]!=183: raise ValueError('expected AArch64')
        self.segments=[]
        for i in range(h[9]):
            t,flags,off,va,pa,filesz,memsz,align=struct.unpack_from('<IIQQQQQQ',self.data,h[4]+i*h[8])
            if t==1: self.segments.append(dict(type=t,flags=flags,offset=off,vaddr=va,filesz=filesz,memsz=memsz))
    def segment(self,va):
        hits=[s for s in self.segments if s['vaddr']<=va<s['vaddr']+s['filesz']]
        if len(hits)!=1: raise ValueError(f'unmapped/ambiguous file-backed RVA {va:x}')
        return hits[0]
    def offset(self,va):
        s=self.segment(va)
        return s['offset']+va-s['vaddr']
    def read(self,va,size):
        s=self.segment(va)
        if va+size>s['vaddr']+s['filesz']: raise ValueError('read crosses file-backed segment')
        p=self.offset(va)
        return self.data[p:p+size]

def main():
    ap=argparse.ArgumentParser(description=__doc__)
    ap.add_argument('--archive',type=Path,default=Path(__file__).resolve().parents[1])
    ap.add_argument('--test-only',action='store_true',help='run host reference tests without loading native input or Capstone')
    args=ap.parse_args()
    a=args.archive.resolve(); out=a/'derived/client-algorithms'; out.mkdir(parents=True,exist_ok=True)
    if args.test_only:
        result=run_reference_tests();jwrite(out/'test-results.json',result)
        print(json.dumps(result,ensure_ascii=False));return
    sys.path.insert(0,str(a/'tools/python-packages'))
    import capstone
    script_path=a/'derived/il2cpp/arm64-v8a/script.json'
    dump_path=a/'derived/il2cpp/arm64-v8a/dump.cs'
    native_path=a/'unpacked/lib/arm64-v8a/libil2cpp.so'
    script=json.loads(script_path.read_text(encoding='utf-8-sig'))
    elf=ELF(native_path)
    byaddr={}
    for m in script['ScriptMethod']:
        byaddr.setdefault(m['Address'],[]).append(m)
    # script.json can expose adjustor thunks instead of the concrete struct instance body.
    # Supplement ALL dump starts, not only desired methods, before computing upper bounds.
    ns=''; typ=''; pending=None
    for lineno,line in enumerate(dump_path.read_text(encoding='utf-8-sig').splitlines(),1):
        if line.startswith('// Namespace:'): ns=line.split(':',1)[1].strip()
        if '// TypeDefIndex:' in line:
            mt=re.search(r'\b(?:class|struct|enum|interface)\s+([^\s:]+)',line)
            typ=((ns+'.') if ns else '')+mt.group(1) if mt else ''
        mr=re.match(r'\s*// RVA: (0x[0-9A-Fa-f]+) Offset:',line)
        if mr: pending=int(mr.group(1),16);continue
        if pending is not None and '(' in line and line.strip().endswith('{ }'):
            name=line.split('(',1)[0].split()[-1]
            entry={'Address':pending,'Name':typ+'$$'+name,'Signature':line.strip(),'dump_source_line':lineno,'symbol_source':'dump.cs declared RVA (may be adjustor thunk)'}
            entries=byaddr.setdefault(pending,[])
            if not any(m['Name']==entry['Name'] for m in entries): entries.append(entry)
            pending=None
    # Resolve short boxed-struct adjustor thunks, preserving the original RVA and origin.
    md_thunk=capstone.Cs(capstone.CS_ARCH_ARM64,capstone.CS_MODE_LITTLE_ENDIAN)
    for addr,aliases in list(byaddr.items()):
        if not any(m['Name'].startswith('BattleCore.FP$$') for m in aliases): continue
        try: ti=list(md_thunk.disasm(elf.read(addr,8),addr))
        except ValueError: continue
        if len(ti)==2 and ti[0].mnemonic=='add' and ti[0].op_str=='x0, x0, #0x10' and ti[1].mnemonic=='b':
            target=int(ti[1].op_str.removeprefix('#'),16)
            if target not in byaddr:
                byaddr[target]=[dict(Address=target,Name=aliases[0]['Name']+'_body_via_thunk',Signature='inferred concrete unboxed entry from add x0,#0x10; b immediate',adjustor_thunk=addr)]
    # Include ALL method starts, including generic aliases; bound is not inferred from name order.
    starts=sorted(x for x in byaddr if any(s['flags']&1 and s['vaddr']<=x<s['vaddr']+s['filesz'] for s in elf.segments))
    prefixes=('A3BattleCore.SkillDamageHelper$$','BattleCore.FP$$','BattleCore.TSRandom$$','A3BattleCore.ActorAttrData$$','A3BattleCore.ActorAttrImpactData$$','A3BattleCore.ActorAttrImpactMgr$$')
    selected=sorted(x for x in starts if x in (0x219efc0,0x21a23d0) or any(m['Name'].startswith(prefixes) for m in byaddr[x]))
    dis=out/'disassembly';dis.mkdir(exist_ok=True)
    rawdir=out/'native-bytes';rawdir.mkdir(exist_ok=True)
    md=capstone.Cs(capstone.CS_ARCH_ARM64,capstone.CS_MODE_LITTLE_ENDIAN);md.detail=True
    index=[];edges=[];allinstructions={}
    for start in selected:
        seg=elf.segment(start); k=bisect.bisect_right(starts,start)
        end=min(starts[k] if k<len(starts) else start+0x10000,seg['vaddr']+seg['filesz'],start+0x10000)
        data=elf.read(start,end-start)
        slug=f'{start:08x}_'+re.sub('[^A-Za-z0-9_.-]+','_',byaddr[start][0]['Name'])
        ins=list(md.disasm(data,start)); decoded=sum(i.size for i in ins)
        lines=[f'; RVA 0x{start:x}, file offset 0x{elf.offset(start):x}, conservative end 0x{end:x}',f'; SHA256 {sha(data)}',f'; All aliases at this entry: '+ ' | '.join(m['Name']+' :: '+m.get('Signature','') for m in byaddr[start]),'; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.', '; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.']
        records=[]
        for i in ins:
            rec={'address':i.address,'bytes':i.bytes.hex(),'mnemonic':i.mnemonic,'operands':i.op_str};records.append(rec)
            annotation=''
            if i.mnemonic in ('bl','b') and i.operands and i.operands[0].type==capstone.arm64.ARM64_OP_IMM:
                target=i.operands[0].imm; names=[m['Name'] for m in byaddr.get(target,[])]
                annotation=' ; '+(' | '.join(names) if names else 'unresolved symbol') if not start<=target<end or names else ''
                if i.mnemonic=='bl' or not start<=target<end:
                    edges.append({'caller':start,'site':i.address,'kind':'direct_call' if i.mnemonic=='bl' else 'outbound_branch','target':target,'target_aliases':names})
            elif i.mnemonic in ('blr','br'):
                edges.append({'caller':start,'site':i.address,'kind':'indirect_unresolved','operand':i.op_str})
            lines.append(f'{i.address:08x}  {i.bytes.hex():8s}  {i.mnemonic:8s} {i.op_str}{annotation}')
        (dis/(slug+'.asm')).write_text('\n'.join(lines)+'\n',encoding='utf-8')
        (rawdir/(slug+'.bin')).write_bytes(data)
        allinstructions[f'0x{start:x}']=records
        index.append({'rva':start,'rva_hex':hex(start),'file_offset':elf.offset(start),'conservative_end':end,'size_upper_bound':len(data),'decoded_bytes':decoded,'sha256':sha(data),'symbols':byaddr[start],'disassembly':'disassembly/'+slug+'.asm','native_bytes':'native-bytes/'+slug+'.bin','bounds_confidence':'upper-bound-only; may include padding/unindexed helpers; may truncate shared implementation'})
    jwrite(out/'index.json',index); jwrite(out/'instructions.json',allinstructions);jwrite(out/'call-graph.json',edges)
    (out/'call-graph.dot').write_text('digraph calls {\n'+ '\n'.join(f'"0x{e["caller"]:x}" -> "0x{e["target"]:x}" [label="0x{e["site"]:x} {e["kind"]}"];' for e in edges if 'target' in e)+'\n}\n',encoding='utf-8')
    damage_edges=[e for e in edges if any(m['Name'].startswith('A3BattleCore.SkillDamageHelper$$') for m in byaddr[e['caller']])]
    jwrite(out/'damage-call-sites.json',damage_edges)
    trace=[]
    for e in damage_edges:
        aliases=e.get('target_aliases',[])
        if any(n.startswith(('A3BattleCore.','BattleCore.TSMath$$')) for n in aliases) or e['kind']=='indirect_unresolved':
            trace.append(f"{byaddr[e['caller']][0]['Name']} @0x{e['site']:x} -> "+ (' | '.join(aliases) or e.get('operand','unresolved')))
    (out/'damage-business-calls.txt').write_text('\n'.join(trace)+'\n',encoding='utf-8')
    table=struct.unpack('<4i',elf.read(0x239fdb8,16))
    jwrite(out/'magic-jump-table.json',{'table_rva':'0x239fdb8','raw_hex':elf.read(0x239fdb8,16).hex(),'entries':[{'magicType':i+1,'signed_relative':n,'branch_rva':hex(0x239fdb8+n),'attr_offset':hex(0xc8+8*i)} for i,n in enumerate(table)]})
    dispatches=[]
    for base,count,label in ((0x239fd0c,22,'CalWeaponDamage SkillAttrDamageType 1..22'),(0x239fdc8,4,'DoCalcWeaponDamage weaponType 1..4')):
        raw=elf.read(base,count*4); offsets=struct.unpack('<'+str(count)+'i',raw)
        dispatches.append({'table_rva':hex(base),'meaning':label,'raw_hex':raw.hex(),'entries':[{'case':i+1,'signed_relative':v,'branch_rva':hex(base+v)} for i,v in enumerate(offsets)]})
    jwrite(out/'damage-dispatch-tables.json',dispatches)
    side=elf.read(0x21a8640,8)
    jwrite(out/'supporting-basic-blocks.json',[{'rva':'0x21a8640','referenced_by':'TSMath.Max 0x219f004','raw_hex':side.hex(),'instructions':[{'rva':hex(i.address),'bytes':i.bytes.hex(),'mnemonic':i.mnemonic,'operands':i.op_str} for i in md.disasm(side,0x21a8640)],'scope':'explicit eight-byte out-of-line initialization continuation; not a claimed function extent'}])
    result=run_reference_tests();jwrite(out/'test-results.json',result)
    text=Path(__file__).read_text(encoding='utf-8');model=text.split('# BEGIN HOST REFERENCE MODEL -- generated reference_model.py copies this block verbatim.\n',1)[1].split('# END HOST REFERENCE MODEL',1)[0]
    (out/'reference_model.py').write_text('"""Host-only static reconstruction; see report and test-results.json. No target execution."""\nMASK32=(1<<32)-1\nMASK64=(1<<64)-1\nONE=1<<32\ndef s64(x):\n    x &= MASK64\n    return x-(1<<64) if x>>63 else x\n\n'+model,encoding='utf-8')
    jwrite(out/'provenance.json',{'script_sha256':sha(Path(__file__).read_bytes()),'inputs':[{'path':str(p.relative_to(a)),'sha256':sha(p.read_bytes()),'bytes':p.stat().st_size} for p in (native_path,dump_path,script_path)],'capstone_version':capstone.__version__,'elf_load_segments':elf.segments,'selected_unique_entries':len(index),'alias_entries':sum(len(i['symbols'])>1 for i in index),'bound_method':'next distinct known executable entry from script.json / dump.cs / resolved adjustor targets within PT_LOAD; segment end / 64 KiB cap; NO claimed exact function sizes','execution':'host Python only; native input read as data'})
    print(json.dumps({'out':str(out),'entries':len(index),'calls':len(edges),'capstone':capstone.__version__},ensure_ascii=False))

# BEGIN HOST REFERENCE MODEL -- generated reference_model.py copies this block verbatim.
def s32(x):
    x &= MASK32
    return x-(1<<32) if x>>31 else x

def fp_add(x,y): return s64(x+y)
def fp_sub(x,y): return s64(x-y)
def fp_int(x): return s64(s32(x)<<32)
def fp_floor(x): return s64(s64(x)&~MASK32)
def fp_to_int(x): return s32((x&MASK64)>>32)
def fp_mul(x,y): return s64((s64(x)*s64(y))>>32)
def fp_mul_limb(x,y):
    x=s64(x);y=s64(y)
    return s64(y*(x>>32)+(y>>32)*(x&MASK32)+(((x&MASK32)*(y&MASK32))>>32))
def fp_round(x):
    x=s64(x); f=x&MASK32; base=fp_floor(x)
    return base if f<ONE//2 or (f==ONE//2 and not (x&ONE)) else fp_add(base,ONE)

def fp_div(x,y):
    """Instruction-shaped unsigned long division; not a native execution oracle.
    Saturation is MaxValue/MinValue raw (0x7ffffffffffffffe, 0x8000000000000002), NOT Infinity.
    Ordinary finite quotient rounding is nearest with half away from zero.
    Exceptional/raw overflow behavior follows U64 masks literally.
    """
    x=s64(x); y=s64(y); neg=(x^y)<0
    pinf=(1<<63)-2; ninf=-(1<<63)+2
    if y==0: return pinf if x>0 else ninf if x<0 else 0
    rem=abs(x)&MASK64; div=abs(y)&MASK64; bitpos=33
    while not (div&15):
        old=bitpos;div >>=4;bitpos-=4
        if old<8: break
    qsum=0
    while bitpos>=0 and rem:
        shift=min(64-rem.bit_length(),bitpos)
        rem=(rem<<shift)&MASK64;bitpos-=shift
        q=rem//div
        if q & (~(MASK64>>(bitpos&63))&MASK64): return ninf if neg else pinf
        qsum=(qsum+((q<<(bitpos&63))&MASK64))&MASK64
        bitpos-=1
        if bitpos<0: break
        rem=((rem-q*div)<<1)&MASK64
    value=((qsum+1)&MASK64)>>1
    return s64(-value if neg else value)

def nextfp_from_u32(word):
    return fp_div(fp_int((word&MASK32)>>1),fp_int(0x7fffffff))
def range_fp_from_unit(lo,hi,u):
    lo=s64(lo);hi=s64(hi)
    if lo==hi:return lo
    if lo>hi:lo,hi=hi,lo
    return fp_add(fp_mul(u,fp_add(fp_sub(hi,lo),1)),lo)
def test_rate_from_u32(word,val):
    return range_fp_from_unit(0,ONE,nextfp_from_u32(word))<s64(val)

def arm_sdiv32(n,d):
    n=s32(n);d=s32(d)
    if d==0:return 0
    return s32((-1 if (n<0)^(d<0) else 1)*(abs(n)//abs(d)))
def range_int_from_u32(word,lo,hi):
    lo=s32(lo);hi=s32(hi)
    if lo>hi:lo,hi=hi,lo
    width=s32(hi-lo);r=(word&MASK32)>>1
    return s32(r-arm_sdiv32(r,width)*width+lo)

class TSRandomReference:
    """MT19937 as reconstructed from ARM64 init_genrand/genrand_int32."""
    def __init__(self,seed=5489): self.seed(seed);self.draws=0
    def seed(self,seed):
        self.mt=[seed&MASK32]+[0]*623
        for i in range(1,624):
            p=self.mt[i-1];self.mt[i]=(1812433253*(p^(p>>30))+i)&MASK32
        self.index=624
    def uint32(self):
        if self.index>=624:
            if self.index==625:self.seed(5489)
            for i in range(624):
                y=(self.mt[i]&0x80000000)|(self.mt[(i+1)%624]&0x7fffffff)
                self.mt[i]=(self.mt[(i+397)%624]^(y>>1)^(0x9908b0df if y&1 else 0))&MASK32
            self.index=0
        y=self.mt[self.index];self.index+=1;self.draws+=1
        y^=y>>11;y^=(y<<7)&0x9d2c5680;y^=(y<<15)&0xefc60000;y^=y>>18
        return y&MASK32
    def next_fp(self):return nextfp_from_u32(self.uint32())
    def range_fp(self,lo,hi):
        if s64(lo)==s64(hi):return s64(lo)
        return range_fp_from_unit(lo,hi,self.next_fp())
    def range_int(self,lo,hi):return range_int_from_u32(self.uint32(),lo,hi)
    def test_rate(self,val):return self.range_fp(0,ONE)<s64(val)

def attr_cal_add(base,add_type,value):
    if add_type==1:return fp_add(base,value)
    if add_type in (2,3):return fp_add(base,fp_mul(base,value))
    return s64(base)
def attr_merge_value(current,incoming,add_type,data_type):
    total=fp_add(current,incoming)
    # Exact reject-update gate, NOT clamping to -1.
    return s64(current) if data_type==16 and add_type in (2,3) and total<=-ONE else total

def five_damage(existing_five_int,ratio,can_be_damaged=True):
    return fp_to_int(fp_mul(fp_int(existing_five_int),ratio)) if can_be_damaged else 0

def buff_damage_nonheal(input_int,bullet_reduce,bullet_reduce_ratio):
    raw=fp_sub(fp_mul(fp_int(input_int),fp_sub(ONE,bullet_reduce_ratio)),bullet_reduce)
    return fp_to_int(max(raw,0))

def quantize_int32_fp(raw):
    """Explicit long -> implicit int overload: floor, low 32 bits, then Q32.32."""
    return fp_int(fp_to_int(raw))

def weapon_crit_stage(base,crit_multi,triggered):
    return quantize_int32_fp(fp_mul(base,fp_add(ONE,crit_multi))) if triggered else s64(base)

def four_element_stage(atk,defense,add_ratio,crit_multi,world_scalar=ONE,existing=0,triggered=True,crit=False):
    """One confirmed elemental channel AFTER RNG decisions; crit_multi must follow native load.
    Chaos native 0x169ed34 loads OceanCritAtkMulti (+0x2d8), NOT ChaosCritAtkMulti.
    Returns flag-before-world-scaling and wrapping int32 accumulated damage.
    """
    if not triggered:return False,s32(existing)
    if crit:atk=fp_mul(atk,fp_add(ONE,crit_multi))
    candidate=fp_mul(max(fp_sub(atk,defense),0),add_ratio)
    if candidate<=0:return False,s32(existing)
    return True,s32(existing+fp_to_int(fp_mul(candidate,world_scalar)))

def weapon_confirmed_tail(base,ratio=ONE,skill_scalar=ONE,additive=0,weapon_bonus=0,hit_add=0,
                          min_ratio=0,has_defend=True,reduce_ratio=0,flat_reduce=0,
                          through_ratio=0,through=0,source_level=0,target_level=0,
                          block=False,block_value=0,five_attacks=(),five_defenses=(),
                          five_ratio=ONE,existing_five=0,world_scalar=ONE,elements=(0,0,0,0)):
    """0x169f24c..0x169fbfc only; excludes object preparation, RNG, callbacks, outer HurtAddRatio.
    base is already buff-adjusted and (if triggered) integer-quantized after ordinary crit.
    All FP arguments are signed raw integers. five arrays MUST use native evaluation order.
    """
    d=fp_add(fp_mul(fp_mul(base,ratio),skill_scalar),additive)
    d=fp_add(fp_add(d,weapon_bonus),hit_add)
    minimum=fp_mul(d,min_ratio)
    if has_defend:
        effective_ratio=max(fp_sub(reduce_ratio,through_ratio),0)
        effective_flat=max(fp_sub(flat_reduce,through),0)
        d=quantize_int32_fp(fp_mul(d,fp_sub(ONE,effective_ratio)))
        d=fp_add(fp_sub(d,effective_flat),max(fp_sub(source_level,target_level),0))
    d=max(d,minimum)
    if block:d=fp_sub(d,fp_mul(d,block_value))
    d=max(d,0);physical=d
    five=0
    for a,b in zip(five_attacks,five_defenses):five=fp_add(five,max(fp_sub(a,b),0))
    five=fp_mul(five,five_ratio)
    accumulated=s32(existing_five+fp_to_int(five)) if five>0 else s32(existing_five)
    d=fp_mul(fp_add(d,fp_int(accumulated)),world_scalar)
    element_sum=s32(sum(s32(x) for x in elements))
    d=fp_add(d,fp_int(element_sum))
    return {'minimum_raw':minimum,'physical_raw':physical,'five_raw':five,
            'five_int':accumulated,'element_sum_int':element_sum,'final_raw':d,'damage_int':fp_to_int(d)}

def percent_damage_stage(max_hp,ratio,additive=0,has_defend=True,reduce_ratio=0,flat_reduce=0):
    d=fp_add(quantize_int32_fp(fp_mul(fp_int(max_hp),ratio)),additive)
    if has_defend:d=fp_sub(quantize_int32_fp(fp_mul(d,fp_sub(ONE,reduce_ratio))),flat_reduce)
    return d,fp_to_int(d)

def hurt_add_postprocess(damage,hurt_add_ratio):
    return fp_to_int(fp_mul(fp_int(damage),fp_add(ONE,hurt_add_ratio))) if s32(damage)>=1 and hurt_add_ratio>0 else s32(damage)
# END HOST REFERENCE MODEL

def run_reference_tests():
    checks=[];vectors={}
    def check(name,got,want):
        if got!=want:raise AssertionError(f'{name}: got {got!r}, wanted {want!r}')
        checks.append({'name':name,'passed':True})
    cases=[(ONE//2,0),(3*ONE//2,2*ONE),(-ONE//2,0),(-3*ONE//2,-2*ONE),(-ONE//2-1,-ONE),((1<<63)-1,-(1<<63))]
    vectors['round']=[{'raw':x,'expected_raw':y} for x,y in cases]
    for x,y in cases:check(f'round_{x}',fp_round(x),y)
    for x,y in [(-1,-1),(-ONE//2,-1),(-ONE-1,-2),(ONE-1,0)]:check(f'floor_int_{x}',fp_to_int(x),y)
    check('add_wrap',fp_add((1<<63)-1,1),-(1<<63))
    check('multiply_wrap',fp_mul(1<<62,2*ONE),-(1<<63))
    check('multiply_negative_fraction_floor',fp_mul(-1,ONE//2),-1)
    import random
    rr=random.Random(20250321)
    for i in range(4096):
        x=s64(rr.getrandbits(64));y=s64(rr.getrandbits(64))
        if fp_mul(x,y)!=fp_mul_limb(x,y):raise AssertionError(f'mul limb mismatch {i}')
    checks.append({'name':'4096_mul_limb_vs_unbounded_product','passed':True})
    for i in range(4096):
        x=rr.randrange(-(1<<46),1<<46);y=rr.randrange(1<<25,1<<47)
        sign=-1 if x<0 else 1
        exact=sign*((abs(x)*ONE*2+y)//(2*y))
        if fp_div(x,y)!=exact:raise AssertionError(f'div rational mismatch {i}: {x},{y}')
    checks.append({'name':'4096_div_native_shaped_vs_rational_nearest','passed':True})
    for x,y,w in [(1,2*ONE,1),(-1,2*ONE,-1),(ONE,0,(1<<63)-2),(-ONE,0,-(1<<63)+2),(0,0,0),((1<<63)-1,1,(1<<63)-2)]:
        check(f'div_{x}_{y}',fp_div(x,y),w)
    standard=[3499211612,581869302,3890346734,3586334585,545404204,4161255391,3922919429,949333985,2715962298,1323567403]
    rng=TSRandomReference(5489);check('MT19937_standard_seed5489_first10',[rng.uint32() for _ in range(10)],standard)
    # Independent standard-library MT twist/temper state oracle, bypassing Python's different seeding.
    for seed in [0,1,5489,-1,0x80000000]:
        rng=TSRandomReference(seed);oracle=random.Random();oracle.setstate((3,tuple(rng.mt)+(624,),None))
        check(f'MT_twist_cross_3blocks_{seed}',[rng.uint32() for _ in range(1875)],[oracle.getrandbits(32) for _ in range(1875)])
    vectors['mt_seed5489_first10']=standard
    endpoint=[{'word':w,'nextfp_raw':nextfp_from_u32(w),'unit_range_raw':range_fp_from_unit(0,ONE,nextfp_from_u32(w)),'test_rate_one':test_rate_from_u32(w,ONE)} for w in [0,1,2,0x7ffffffe,0xfffffffc,0xfffffffe,0xffffffff]]
    vectors['rng_endpoints']=endpoint
    check('nextfp_zero',nextfp_from_u32(0),0)
    check('nextfp_max',nextfp_from_u32(MASK32),ONE)
    check('range_endpoint_one_plus_precision',range_fp_from_unit(0,ONE,nextfp_from_u32(MASK32)),ONE+1)
    check('TestRate_one_endpoint_false',test_rate_from_u32(MASK32,ONE),False)
    check('TestRate_one_plus_precision_endpoint_false',test_rate_from_u32(MASK32,ONE+1),False)
    check('TestRate_above_endpoint_true',test_rate_from_u32(MASK32,ONE+2),True)
    check('TestRate_zero_sample_strictly_false',test_rate_from_u32(0,0),False)
    rng=TSRandomReference(1);check('fp_equal_returns',rng.range_fp(7,7),7);check('fp_equal_no_draw',rng.draws,0)
    check('int_equal_arm_machine_behavior',range_int_from_u32(20,7,7),17)
    check('int_reversed_bounds',range_int_from_u32(20,20,5),15)
    check('relative_attr',attr_cal_add(100*ONE,2,ONE//2),150*ONE)
    check('multiply_attr_same_local_operation',attr_cal_add(100*ONE,3,ONE//2),150*ONE)
    check('merge_reject_not_clamp',attr_merge_value(-ONE//2,-ONE//2,2,16),-ONE//2)
    check('merge_unrestricted_other_attr',attr_merge_value(-ONE//2,-ONE//2,2,17),-ONE)
    check('five_damage_floor',five_damage(7,ONE//2),3)
    check('five_damage_invulnerable',five_damage(7,ONE,False),0)
    check('buff_reduction',buff_damage_nonheal(100,10*ONE,ONE//4),65)
    check('buff_nonnegative_clamp',buff_damage_nonheal(1,10*ONE,0),0)
    check('crit_quantizes_before_later_multipliers',weapon_crit_stage(7*ONE//2,ONE//2,True),5*ONE)
    check('crit_false_preserves_fraction',weapon_crit_stage(7*ONE//2,ONE//2,False),7*ONE//2)
    check('element_crit_no_early_int_quantization',four_element_stage(7*ONE//2,ONE//2,ONE//2,ONE//2,3*ONE//2,crit=True),(True,3))
    check('element_flag_before_world_scale',four_element_stage(ONE,0,ONE,0,0),(True,0))
    check('element_accumulation_wrap32',four_element_stage(ONE,0,ONE,0,existing=0x7fffffff),(True,-0x80000000))
    trace=weapon_confirmed_tail(101*ONE,ratio=3*ONE//2,skill_scalar=5*ONE//4,additive=5*ONE//2,
        weapon_bonus=13*ONE//4,hit_add=33*ONE//8,min_ratio=ONE//4,
        reduce_ratio=ONE//4,flat_reduce=11*ONE//2,through_ratio=ONE//8,through=5*ONE//4,
        source_level=6*ONE,target_level=2*ONE,block=True,block_value=ONE//4,
        five_attacks=(10*ONE,),five_defenses=(0,),five_ratio=ONE//2,world_scalar=3*ONE//2,elements=(1,2,3,4))
    # Hand-derived dyadic arithmetic: 199.25 -> floor(174.34375)-4.25+4 = 173.75;
    # block .25 ->130.3125; (physical+5)*1.5+10=212.96875.
    check('weapon_tail_minimum',trace['minimum_raw'],797*ONE//16)
    check('weapon_tail_defense_then_block',trace['physical_raw'],2085*ONE//16)
    check('weapon_tail_final_order',trace['final_raw'],6815*ONE//32)
    check('weapon_tail_stored_integer',trace['damage_int'],212)
    vectors['weapon_tail_dyadic_trace']=trace
    check('minimum_precedes_block',weapon_confirmed_tail(100*ONE,min_ratio=ONE//2,flat_reduce=1000*ONE,block=True,block_value=ONE//2)['damage_int'],25)
    check('final_aggregation_has_no_clamp',weapon_confirmed_tail(0,existing_five=-2)['damage_int'],-2)
    check('element_sum_wraps_before_FP',weapon_confirmed_tail(0,elements=(0x7fffffff,1,0,0))['damage_int'],-0x80000000)
    check('percent_no_lower_clamp',percent_damage_stage(10,ONE//2,flat_reduce=10*ONE),(-5*ONE,-5))
    check('percent_intermediate_integer_floor',percent_damage_stage(7,ONE//2,ONE//2,True,ONE//4,ONE//4),(7*ONE//4,1))
    check('outer_hurt_add_uses_stored_integer',hurt_add_postprocess(3,ONE//2),4)
    check('outer_hurt_add_nonpositive_skipped',hurt_add_postprocess(-3,ONE),-3)
    return {'status':'passed','native_executed':False,'test_scope':'host-only static-instruction-derived reference models; not native differential execution','checks':checks,'check_count':len(checks),'vectors':vectors,'not_covered':['full weapon damage dispatcher/business callbacks/configuration (confirmed arithmetic stages only)','ARMv7 equivalence','runtime object/null/IL2CPP initialization semantics','all exceptional FP raw bit patterns']}

if __name__=='__main__': main()
