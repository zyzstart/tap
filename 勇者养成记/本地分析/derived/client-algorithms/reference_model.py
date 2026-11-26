"""Host-only static reconstruction; see report and test-results.json. No target execution."""
MASK32=(1<<32)-1
MASK64=(1<<64)-1
ONE=1<<32
def s64(x):
    x &= MASK64
    return x-(1<<64) if x>>63 else x

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
