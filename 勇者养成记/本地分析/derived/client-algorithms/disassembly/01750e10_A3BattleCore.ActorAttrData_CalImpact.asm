; RVA 0x1750e10, file offset 0x1750e10, conservative end 0x1751758
; SHA256 e4e3ce8c106412490354ef91dbe1a7d48992a01f7a91e93debf3f8f00b8cf748
; All aliases at this entry: A3BattleCore.ActorAttrData$$CalImpact :: void A3BattleCore_ActorAttrData__CalImpact (A3BattleCore_ActorAttrData_o* __this, A3BattleCore_ActorAttrImpactData_o* impact, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01750e10  f50f1df8  str      x21, [sp, #-0x30]!
01750e14  f44f01a9  stp      x20, x19, [sp, #0x10]
01750e18  fd7b02a9  stp      x29, x30, [sp, #0x20]
01750e1c  fd830091  add      x29, sp, #0x20
01750e20  95bf0090  adrp     x21, #0x2f40000
01750e24  a8925639  ldrb     w8, [x21, #0x5a4]
01750e28  f40301aa  mov      x20, x1
01750e2c  f30300aa  mov      x19, x0
01750e30  e8000037  tbnz     w8, #0, #0x1750e4c
01750e34  88ad00f0  adrp     x8, #0x2d03000
01750e38  081d40f9  ldr      x8, [x8, #0x38]
01750e3c  000140b9  ldr      w0, [x8]
01750e40  3ad0d697  bl       #0xd04f28 ; unresolved symbol
01750e44  e8030032  mov      w8, #1
01750e48  a8921639  strb     w8, [x21, #0x5a4]
01750e4c  ff0700f9  str      xzr, [sp, #8]
01750e50  740000b5  cbnz     x20, #0x1750e5c
01750e54  e0031faa  mov      x0, xzr
01750e58  356ad797  bl       #0xd2b72c ; unresolved symbol
01750e5c  881e40b9  ldr      w8, [x20, #0x1c]
01750e60  08050051  sub      w8, w8, #1
01750e64  1f810171  cmp      w8, #0x60
01750e68  08470054  b.hi     #0x1751748
01750e6c  89620090  adrp     x9, #0x23a0000
01750e70  29110791  add      x9, x9, #0x1c4
01750e74  2879a8b8  ldrsw    x8, [x9, x8, lsl #2]
01750e78  0801098b  add      x8, x8, x9
01750e7c  00011fd6  br       x8
01750e80  68ab00b0  adrp     x8, #0x2cbd000
01750e84  08dd47f9  ldr      x8, [x8, #0xfb8]
01750e88  751240b9  ldr      w21, [x19, #0x10]
01750e8c  000140f9  ldr      x0, [x8]
01750e90  089c4439  ldrb     w8, [x0, #0x127]
01750e94  88000836  tbz      w8, #1, #0x1750ea4
01750e98  08d840b9  ldr      w8, [x0, #0xd8]
01750e9c  48000035  cbnz     w8, #0x1750ea4
01750ea0  b20cd797  bl       #0xd14168 ; unresolved symbol
01750ea4  e003152a  mov      w0, w21
01750ea8  e1031faa  mov      x1, xzr
01750eac  410d1e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01750eb0  e10300aa  mov      x1, x0
01750eb4  e00314aa  mov      x0, x20
01750eb8  28020094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01750ebc  e00700f9  str      x0, [sp, #8]
01750ec0  e0230091  add      x0, sp, #8
01750ec4  e1031faa  mov      x1, xzr
01750ec8  26111e94  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
01750ecc  601200b9  str      w0, [x19, #0x10]
01750ed0  1e020014  b        #0x1751748
01750ed4  610e40f9  ldr      x1, [x19, #0x18]
01750ed8  e00314aa  mov      x0, x20
01750edc  1f020094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01750ee0  600e00f9  str      x0, [x19, #0x18]
01750ee4  19020014  b        #0x1751748
01750ee8  611240f9  ldr      x1, [x19, #0x20]
01750eec  e00314aa  mov      x0, x20
01750ef0  1a020094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01750ef4  601200f9  str      x0, [x19, #0x20]
01750ef8  14020014  b        #0x1751748
01750efc  611640f9  ldr      x1, [x19, #0x28]
01750f00  e00314aa  mov      x0, x20
01750f04  15020094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01750f08  601600f9  str      x0, [x19, #0x28]
01750f0c  0f020014  b        #0x1751748
01750f10  612240f9  ldr      x1, [x19, #0x40]
01750f14  e00314aa  mov      x0, x20
01750f18  10020094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01750f1c  611a40f9  ldr      x1, [x19, #0x30]
01750f20  602200f9  str      x0, [x19, #0x40]
01750f24  08000014  b        #0x1750f44
01750f28  612640f9  ldr      x1, [x19, #0x48]
01750f2c  e00314aa  mov      x0, x20
01750f30  0a020094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01750f34  611e40f9  ldr      x1, [x19, #0x38]
01750f38  602600f9  str      x0, [x19, #0x48]
01750f3c  07000014  b        #0x1750f58
01750f40  611a40f9  ldr      x1, [x19, #0x30]
01750f44  e00314aa  mov      x0, x20
01750f48  04020094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01750f4c  601a00f9  str      x0, [x19, #0x30]
01750f50  fe010014  b        #0x1751748
01750f54  611e40f9  ldr      x1, [x19, #0x38]
01750f58  e00314aa  mov      x0, x20
01750f5c  ff010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01750f60  601e00f9  str      x0, [x19, #0x38]
01750f64  f9010014  b        #0x1751748
01750f68  612240f9  ldr      x1, [x19, #0x40]
01750f6c  e00314aa  mov      x0, x20
01750f70  fa010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01750f74  602200f9  str      x0, [x19, #0x40]
01750f78  f4010014  b        #0x1751748
01750f7c  612640f9  ldr      x1, [x19, #0x48]
01750f80  e00314aa  mov      x0, x20
01750f84  f5010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01750f88  602600f9  str      x0, [x19, #0x48]
01750f8c  ef010014  b        #0x1751748
01750f90  612a40f9  ldr      x1, [x19, #0x50]
01750f94  e00314aa  mov      x0, x20
01750f98  f0010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01750f9c  602a00f9  str      x0, [x19, #0x50]
01750fa0  ea010014  b        #0x1751748
01750fa4  612e40f9  ldr      x1, [x19, #0x58]
01750fa8  e00314aa  mov      x0, x20
01750fac  eb010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01750fb0  602e00f9  str      x0, [x19, #0x58]
01750fb4  e5010014  b        #0x1751748
01750fb8  613240f9  ldr      x1, [x19, #0x60]
01750fbc  e00314aa  mov      x0, x20
01750fc0  e6010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01750fc4  603200f9  str      x0, [x19, #0x60]
01750fc8  e0010014  b        #0x1751748
01750fcc  613640f9  ldr      x1, [x19, #0x68]
01750fd0  e00314aa  mov      x0, x20
01750fd4  e1010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01750fd8  603600f9  str      x0, [x19, #0x68]
01750fdc  db010014  b        #0x1751748
01750fe0  613a40f9  ldr      x1, [x19, #0x70]
01750fe4  e00314aa  mov      x0, x20
01750fe8  dc010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01750fec  603a00f9  str      x0, [x19, #0x70]
01750ff0  d6010014  b        #0x1751748
01750ff4  613e40f9  ldr      x1, [x19, #0x78]
01750ff8  e00314aa  mov      x0, x20
01750ffc  d7010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751000  603e00f9  str      x0, [x19, #0x78]
01751004  d1010014  b        #0x1751748
01751008  614240f9  ldr      x1, [x19, #0x80]
0175100c  e00314aa  mov      x0, x20
01751010  d2010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751014  604200f9  str      x0, [x19, #0x80]
01751018  cc010014  b        #0x1751748
0175101c  614640f9  ldr      x1, [x19, #0x88]
01751020  e00314aa  mov      x0, x20
01751024  cd010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751028  604600f9  str      x0, [x19, #0x88]
0175102c  c7010014  b        #0x1751748
01751030  615a40f9  ldr      x1, [x19, #0xb0]
01751034  e00314aa  mov      x0, x20
01751038  c8010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
0175103c  605a00f9  str      x0, [x19, #0xb0]
01751040  c2010014  b        #0x1751748
01751044  615e40f9  ldr      x1, [x19, #0xb8]
01751048  e00314aa  mov      x0, x20
0175104c  c3010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751050  605e00f9  str      x0, [x19, #0xb8]
01751054  bd010014  b        #0x1751748
01751058  616240f9  ldr      x1, [x19, #0xc0]
0175105c  e00314aa  mov      x0, x20
01751060  be010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751064  606200f9  str      x0, [x19, #0xc0]
01751068  b8010014  b        #0x1751748
0175106c  615640f9  ldr      x1, [x19, #0xa8]
01751070  e00314aa  mov      x0, x20
01751074  b9010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751078  605600f9  str      x0, [x19, #0xa8]
0175107c  b3010014  b        #0x1751748
01751080  614a40f9  ldr      x1, [x19, #0x90]
01751084  e00314aa  mov      x0, x20
01751088  b4010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
0175108c  604a00f9  str      x0, [x19, #0x90]
01751090  ae010014  b        #0x1751748
01751094  614e40f9  ldr      x1, [x19, #0x98]
01751098  e00314aa  mov      x0, x20
0175109c  af010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017510a0  604e00f9  str      x0, [x19, #0x98]
017510a4  a9010014  b        #0x1751748
017510a8  615240f9  ldr      x1, [x19, #0xa0]
017510ac  e00314aa  mov      x0, x20
017510b0  aa010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017510b4  605200f9  str      x0, [x19, #0xa0]
017510b8  a4010014  b        #0x1751748
017510bc  616640f9  ldr      x1, [x19, #0xc8]
017510c0  e00314aa  mov      x0, x20
017510c4  a5010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017510c8  606600f9  str      x0, [x19, #0xc8]
017510cc  9f010014  b        #0x1751748
017510d0  616a40f9  ldr      x1, [x19, #0xd0]
017510d4  e00314aa  mov      x0, x20
017510d8  a0010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017510dc  606a00f9  str      x0, [x19, #0xd0]
017510e0  9a010014  b        #0x1751748
017510e4  616e40f9  ldr      x1, [x19, #0xd8]
017510e8  e00314aa  mov      x0, x20
017510ec  9b010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017510f0  606e00f9  str      x0, [x19, #0xd8]
017510f4  95010014  b        #0x1751748
017510f8  617240f9  ldr      x1, [x19, #0xe0]
017510fc  e00314aa  mov      x0, x20
01751100  96010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751104  607200f9  str      x0, [x19, #0xe0]
01751108  90010014  b        #0x1751748
0175110c  617640f9  ldr      x1, [x19, #0xe8]
01751110  e00314aa  mov      x0, x20
01751114  91010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751118  607600f9  str      x0, [x19, #0xe8]
0175111c  8b010014  b        #0x1751748
01751120  617a40f9  ldr      x1, [x19, #0xf0]
01751124  e00314aa  mov      x0, x20
01751128  8c010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
0175112c  607a00f9  str      x0, [x19, #0xf0]
01751130  86010014  b        #0x1751748
01751134  617e40f9  ldr      x1, [x19, #0xf8]
01751138  e00314aa  mov      x0, x20
0175113c  87010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751140  607e00f9  str      x0, [x19, #0xf8]
01751144  81010014  b        #0x1751748
01751148  618240f9  ldr      x1, [x19, #0x100]
0175114c  e00314aa  mov      x0, x20
01751150  82010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751154  608200f9  str      x0, [x19, #0x100]
01751158  7c010014  b        #0x1751748
0175115c  618640f9  ldr      x1, [x19, #0x108]
01751160  e00314aa  mov      x0, x20
01751164  7d010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751168  608600f9  str      x0, [x19, #0x108]
0175116c  77010014  b        #0x1751748
01751170  618a40f9  ldr      x1, [x19, #0x110]
01751174  e00314aa  mov      x0, x20
01751178  78010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
0175117c  608a00f9  str      x0, [x19, #0x110]
01751180  72010014  b        #0x1751748
01751184  618e40f9  ldr      x1, [x19, #0x118]
01751188  e00314aa  mov      x0, x20
0175118c  73010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751190  608e00f9  str      x0, [x19, #0x118]
01751194  6d010014  b        #0x1751748
01751198  619240f9  ldr      x1, [x19, #0x120]
0175119c  e00314aa  mov      x0, x20
017511a0  6e010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017511a4  609200f9  str      x0, [x19, #0x120]
017511a8  68010014  b        #0x1751748
017511ac  619a40f9  ldr      x1, [x19, #0x130]
017511b0  e00314aa  mov      x0, x20
017511b4  69010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017511b8  609a00f9  str      x0, [x19, #0x130]
017511bc  63010014  b        #0x1751748
017511c0  619640f9  ldr      x1, [x19, #0x128]
017511c4  e00314aa  mov      x0, x20
017511c8  64010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017511cc  609600f9  str      x0, [x19, #0x128]
017511d0  5e010014  b        #0x1751748
017511d4  68ab0090  adrp     x8, #0x2cbd000
017511d8  08dd47f9  ldr      x8, [x8, #0xfb8]
017511dc  753a41b9  ldr      w21, [x19, #0x138]
017511e0  000140f9  ldr      x0, [x8]
017511e4  089c4439  ldrb     w8, [x0, #0x127]
017511e8  88000836  tbz      w8, #1, #0x17511f8
017511ec  08d840b9  ldr      w8, [x0, #0xd8]
017511f0  48000035  cbnz     w8, #0x17511f8
017511f4  dd0bd797  bl       #0xd14168 ; unresolved symbol
017511f8  e003152a  mov      w0, w21
017511fc  e1031faa  mov      x1, xzr
01751200  6c0c1e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01751204  e10300aa  mov      x1, x0
01751208  e00314aa  mov      x0, x20
0175120c  53010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751210  e1031faa  mov      x1, xzr
01751214  080e1e94  bl       #0x1ed4a34 ; BattleCore.FP$$op_Explicit
01751218  603a01b9  str      w0, [x19, #0x138]
0175121c  4b010014  b        #0x1751748
01751220  61a240f9  ldr      x1, [x19, #0x140]
01751224  e00314aa  mov      x0, x20
01751228  4c010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
0175122c  60a200f9  str      x0, [x19, #0x140]
01751230  46010014  b        #0x1751748
01751234  61a640f9  ldr      x1, [x19, #0x148]
01751238  e00314aa  mov      x0, x20
0175123c  47010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751240  60a600f9  str      x0, [x19, #0x148]
01751244  41010014  b        #0x1751748
01751248  61aa40f9  ldr      x1, [x19, #0x150]
0175124c  e00314aa  mov      x0, x20
01751250  42010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751254  60aa00f9  str      x0, [x19, #0x150]
01751258  3c010014  b        #0x1751748
0175125c  61ae40f9  ldr      x1, [x19, #0x158]
01751260  e00314aa  mov      x0, x20
01751264  3d010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751268  60ae00f9  str      x0, [x19, #0x158]
0175126c  37010014  b        #0x1751748
01751270  61b240f9  ldr      x1, [x19, #0x160]
01751274  e00314aa  mov      x0, x20
01751278  38010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
0175127c  60b200f9  str      x0, [x19, #0x160]
01751280  32010014  b        #0x1751748
01751284  61b640f9  ldr      x1, [x19, #0x168]
01751288  e00314aa  mov      x0, x20
0175128c  33010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751290  60b600f9  str      x0, [x19, #0x168]
01751294  2d010014  b        #0x1751748
01751298  61ba40f9  ldr      x1, [x19, #0x170]
0175129c  e00314aa  mov      x0, x20
017512a0  2e010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017512a4  60ba00f9  str      x0, [x19, #0x170]
017512a8  28010014  b        #0x1751748
017512ac  61be40f9  ldr      x1, [x19, #0x178]
017512b0  e00314aa  mov      x0, x20
017512b4  29010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017512b8  60be00f9  str      x0, [x19, #0x178]
017512bc  23010014  b        #0x1751748
017512c0  61c240f9  ldr      x1, [x19, #0x180]
017512c4  e00314aa  mov      x0, x20
017512c8  24010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017512cc  60c200f9  str      x0, [x19, #0x180]
017512d0  1e010014  b        #0x1751748
017512d4  61c640f9  ldr      x1, [x19, #0x188]
017512d8  e00314aa  mov      x0, x20
017512dc  1f010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017512e0  60c600f9  str      x0, [x19, #0x188]
017512e4  19010014  b        #0x1751748
017512e8  61ca40f9  ldr      x1, [x19, #0x190]
017512ec  28000014  b        #0x175138c
017512f0  61ce40f9  ldr      x1, [x19, #0x198]
017512f4  e00314aa  mov      x0, x20
017512f8  18010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017512fc  60ce00f9  str      x0, [x19, #0x198]
01751300  12010014  b        #0x1751748
01751304  61d240f9  ldr      x1, [x19, #0x1a0]
01751308  e00314aa  mov      x0, x20
0175130c  13010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751310  60d200f9  str      x0, [x19, #0x1a0]
01751314  0d010014  b        #0x1751748
01751318  61d640f9  ldr      x1, [x19, #0x1a8]
0175131c  e00314aa  mov      x0, x20
01751320  0e010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751324  60d600f9  str      x0, [x19, #0x1a8]
01751328  08010014  b        #0x1751748
0175132c  61da40f9  ldr      x1, [x19, #0x1b0]
01751330  e00314aa  mov      x0, x20
01751334  09010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751338  60da00f9  str      x0, [x19, #0x1b0]
0175133c  03010014  b        #0x1751748
01751340  61de40f9  ldr      x1, [x19, #0x1b8]
01751344  27000014  b        #0x17513e0
01751348  61ba40f9  ldr      x1, [x19, #0x170]
0175134c  e00314aa  mov      x0, x20
01751350  02010094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751354  61be40f9  ldr      x1, [x19, #0x178]
01751358  60ba00f9  str      x0, [x19, #0x170]
0175135c  e00314aa  mov      x0, x20
01751360  fe000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751364  61c240f9  ldr      x1, [x19, #0x180]
01751368  60be00f9  str      x0, [x19, #0x178]
0175136c  e00314aa  mov      x0, x20
01751370  fa000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751374  61c640f9  ldr      x1, [x19, #0x188]
01751378  60c200f9  str      x0, [x19, #0x180]
0175137c  e00314aa  mov      x0, x20
01751380  f6000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751384  61ca40f9  ldr      x1, [x19, #0x190]
01751388  60c600f9  str      x0, [x19, #0x188]
0175138c  e00314aa  mov      x0, x20
01751390  f2000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751394  60ca00f9  str      x0, [x19, #0x190]
01751398  ec000014  b        #0x1751748
0175139c  61ce40f9  ldr      x1, [x19, #0x198]
017513a0  e00314aa  mov      x0, x20
017513a4  ed000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017513a8  61d240f9  ldr      x1, [x19, #0x1a0]
017513ac  60ce00f9  str      x0, [x19, #0x198]
017513b0  e00314aa  mov      x0, x20
017513b4  e9000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017513b8  61d640f9  ldr      x1, [x19, #0x1a8]
017513bc  60d200f9  str      x0, [x19, #0x1a0]
017513c0  e00314aa  mov      x0, x20
017513c4  e5000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017513c8  61da40f9  ldr      x1, [x19, #0x1b0]
017513cc  60d600f9  str      x0, [x19, #0x1a8]
017513d0  e00314aa  mov      x0, x20
017513d4  e1000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017513d8  61de40f9  ldr      x1, [x19, #0x1b8]
017513dc  60da00f9  str      x0, [x19, #0x1b0]
017513e0  e00314aa  mov      x0, x20
017513e4  dd000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017513e8  60de00f9  str      x0, [x19, #0x1b8]
017513ec  d7000014  b        #0x1751748
017513f0  61e240f9  ldr      x1, [x19, #0x1c0]
017513f4  e00314aa  mov      x0, x20
017513f8  d8000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017513fc  60e200f9  str      x0, [x19, #0x1c0]
01751400  d2000014  b        #0x1751748
01751404  68ab0090  adrp     x8, #0x2cbd000
01751408  08dd47f9  ldr      x8, [x8, #0xfb8]
0175140c  75ca41b9  ldr      w21, [x19, #0x1c8]
01751410  000140f9  ldr      x0, [x8]
01751414  089c4439  ldrb     w8, [x0, #0x127]
01751418  88000836  tbz      w8, #1, #0x1751428
0175141c  08d840b9  ldr      w8, [x0, #0xd8]
01751420  48000035  cbnz     w8, #0x1751428
01751424  510bd797  bl       #0xd14168 ; unresolved symbol
01751428  e003152a  mov      w0, w21
0175142c  e1031faa  mov      x1, xzr
01751430  e00b1e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01751434  e10300aa  mov      x1, x0
01751438  e00314aa  mov      x0, x20
0175143c  c7000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751440  e00700f9  str      x0, [sp, #8]
01751444  e0230091  add      x0, sp, #8
01751448  e1031faa  mov      x1, xzr
0175144c  c50f1e94  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
01751450  60ca01b9  str      w0, [x19, #0x1c8]
01751454  bd000014  b        #0x1751748
01751458  61ea40f9  ldr      x1, [x19, #0x1d0]
0175145c  e00314aa  mov      x0, x20
01751460  be000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751464  60ea00f9  str      x0, [x19, #0x1d0]
01751468  b8000014  b        #0x1751748
0175146c  61ee40f9  ldr      x1, [x19, #0x1d8]
01751470  e00314aa  mov      x0, x20
01751474  b9000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751478  60ee00f9  str      x0, [x19, #0x1d8]
0175147c  b3000014  b        #0x1751748
01751480  61f240f9  ldr      x1, [x19, #0x1e0]
01751484  e00314aa  mov      x0, x20
01751488  b4000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
0175148c  60f200f9  str      x0, [x19, #0x1e0]
01751490  ae000014  b        #0x1751748
01751494  61f640f9  ldr      x1, [x19, #0x1e8]
01751498  e00314aa  mov      x0, x20
0175149c  af000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017514a0  60f600f9  str      x0, [x19, #0x1e8]
017514a4  a9000014  b        #0x1751748
017514a8  61fa40f9  ldr      x1, [x19, #0x1f0]
017514ac  e00314aa  mov      x0, x20
017514b0  aa000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017514b4  60fa00f9  str      x0, [x19, #0x1f0]
017514b8  a4000014  b        #0x1751748
017514bc  61fe40f9  ldr      x1, [x19, #0x1f8]
017514c0  e00314aa  mov      x0, x20
017514c4  a5000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017514c8  60fe00f9  str      x0, [x19, #0x1f8]
017514cc  9f000014  b        #0x1751748
017514d0  610241f9  ldr      x1, [x19, #0x200]
017514d4  e00314aa  mov      x0, x20
017514d8  a0000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017514dc  600201f9  str      x0, [x19, #0x200]
017514e0  9a000014  b        #0x1751748
017514e4  610641f9  ldr      x1, [x19, #0x208]
017514e8  e00314aa  mov      x0, x20
017514ec  9b000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017514f0  600601f9  str      x0, [x19, #0x208]
017514f4  95000014  b        #0x1751748
017514f8  610a41f9  ldr      x1, [x19, #0x210]
017514fc  e00314aa  mov      x0, x20
01751500  96000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751504  600a01f9  str      x0, [x19, #0x210]
01751508  90000014  b        #0x1751748
0175150c  610e41f9  ldr      x1, [x19, #0x218]
01751510  e00314aa  mov      x0, x20
01751514  91000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751518  600e01f9  str      x0, [x19, #0x218]
0175151c  8b000014  b        #0x1751748
01751520  611241f9  ldr      x1, [x19, #0x220]
01751524  e00314aa  mov      x0, x20
01751528  8c000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
0175152c  601201f9  str      x0, [x19, #0x220]
01751530  86000014  b        #0x1751748
01751534  611641f9  ldr      x1, [x19, #0x228]
01751538  e00314aa  mov      x0, x20
0175153c  87000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751540  601601f9  str      x0, [x19, #0x228]
01751544  81000014  b        #0x1751748
01751548  611a41f9  ldr      x1, [x19, #0x230]
0175154c  e00314aa  mov      x0, x20
01751550  82000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751554  601a01f9  str      x0, [x19, #0x230]
01751558  7c000014  b        #0x1751748
0175155c  611e41f9  ldr      x1, [x19, #0x238]
01751560  27000014  b        #0x17515fc
01751564  612241f9  ldr      x1, [x19, #0x240]
01751568  e00314aa  mov      x0, x20
0175156c  7b000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751570  602201f9  str      x0, [x19, #0x240]
01751574  75000014  b        #0x1751748
01751578  612641f9  ldr      x1, [x19, #0x248]
0175157c  e00314aa  mov      x0, x20
01751580  76000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751584  602601f9  str      x0, [x19, #0x248]
01751588  70000014  b        #0x1751748
0175158c  612a41f9  ldr      x1, [x19, #0x250]
01751590  e00314aa  mov      x0, x20
01751594  71000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751598  602a01f9  str      x0, [x19, #0x250]
0175159c  6b000014  b        #0x1751748
017515a0  612e41f9  ldr      x1, [x19, #0x258]
017515a4  e00314aa  mov      x0, x20
017515a8  6c000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017515ac  602e01f9  str      x0, [x19, #0x258]
017515b0  66000014  b        #0x1751748
017515b4  613241f9  ldr      x1, [x19, #0x260]
017515b8  e00314aa  mov      x0, x20
017515bc  67000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017515c0  603201f9  str      x0, [x19, #0x260]
017515c4  61000014  b        #0x1751748
017515c8  61ee40f9  ldr      x1, [x19, #0x1d8]
017515cc  e00314aa  mov      x0, x20
017515d0  62000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017515d4  61fe40f9  ldr      x1, [x19, #0x1f8]
017515d8  60ee00f9  str      x0, [x19, #0x1d8]
017515dc  e00314aa  mov      x0, x20
017515e0  5e000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017515e4  610e41f9  ldr      x1, [x19, #0x218]
017515e8  60fe00f9  str      x0, [x19, #0x1f8]
017515ec  e00314aa  mov      x0, x20
017515f0  5a000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017515f4  611e41f9  ldr      x1, [x19, #0x238]
017515f8  600e01f9  str      x0, [x19, #0x218]
017515fc  e00314aa  mov      x0, x20
01751600  56000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751604  601e01f9  str      x0, [x19, #0x238]
01751608  50000014  b        #0x1751748
0175160c  613a41f9  ldr      x1, [x19, #0x270]
01751610  e00314aa  mov      x0, x20
01751614  51000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751618  603a01f9  str      x0, [x19, #0x270]
0175161c  4b000014  b        #0x1751748
01751620  613e41f9  ldr      x1, [x19, #0x278]
01751624  e00314aa  mov      x0, x20
01751628  4c000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
0175162c  603e01f9  str      x0, [x19, #0x278]
01751630  46000014  b        #0x1751748
01751634  614241f9  ldr      x1, [x19, #0x280]
01751638  e00314aa  mov      x0, x20
0175163c  47000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751640  604201f9  str      x0, [x19, #0x280]
01751644  41000014  b        #0x1751748
01751648  614641f9  ldr      x1, [x19, #0x288]
0175164c  e00314aa  mov      x0, x20
01751650  42000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751654  604601f9  str      x0, [x19, #0x288]
01751658  3c000014  b        #0x1751748
0175165c  614a41f9  ldr      x1, [x19, #0x290]
01751660  e00314aa  mov      x0, x20
01751664  3d000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751668  604a01f9  str      x0, [x19, #0x290]
0175166c  37000014  b        #0x1751748
01751670  614e41f9  ldr      x1, [x19, #0x298]
01751674  e00314aa  mov      x0, x20
01751678  38000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
0175167c  604e01f9  str      x0, [x19, #0x298]
01751680  32000014  b        #0x1751748
01751684  615241f9  ldr      x1, [x19, #0x2a0]
01751688  e00314aa  mov      x0, x20
0175168c  33000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751690  605201f9  str      x0, [x19, #0x2a0]
01751694  2d000014  b        #0x1751748
01751698  615641f9  ldr      x1, [x19, #0x2a8]
0175169c  e00314aa  mov      x0, x20
017516a0  2e000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017516a4  605601f9  str      x0, [x19, #0x2a8]
017516a8  28000014  b        #0x1751748
017516ac  615a41f9  ldr      x1, [x19, #0x2b0]
017516b0  e00314aa  mov      x0, x20
017516b4  29000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017516b8  605a01f9  str      x0, [x19, #0x2b0]
017516bc  23000014  b        #0x1751748
017516c0  615e41f9  ldr      x1, [x19, #0x2b8]
017516c4  e00314aa  mov      x0, x20
017516c8  24000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017516cc  605e01f9  str      x0, [x19, #0x2b8]
017516d0  1e000014  b        #0x1751748
017516d4  616241f9  ldr      x1, [x19, #0x2c0]
017516d8  e00314aa  mov      x0, x20
017516dc  1f000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017516e0  606201f9  str      x0, [x19, #0x2c0]
017516e4  19000014  b        #0x1751748
017516e8  616641f9  ldr      x1, [x19, #0x2c8]
017516ec  e00314aa  mov      x0, x20
017516f0  1a000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
017516f4  606601f9  str      x0, [x19, #0x2c8]
017516f8  14000014  b        #0x1751748
017516fc  616a41f9  ldr      x1, [x19, #0x2d0]
01751700  e00314aa  mov      x0, x20
01751704  15000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751708  606a01f9  str      x0, [x19, #0x2d0]
0175170c  0f000014  b        #0x1751748
01751710  616e41f9  ldr      x1, [x19, #0x2d8]
01751714  e00314aa  mov      x0, x20
01751718  10000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
0175171c  606e01f9  str      x0, [x19, #0x2d8]
01751720  0a000014  b        #0x1751748
01751724  617241f9  ldr      x1, [x19, #0x2e0]
01751728  e00314aa  mov      x0, x20
0175172c  0b000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751730  607201f9  str      x0, [x19, #0x2e0]
01751734  05000014  b        #0x1751748
01751738  617641f9  ldr      x1, [x19, #0x2e8]
0175173c  e00314aa  mov      x0, x20
01751740  06000094  bl       #0x1751758 ; A3BattleCore.ActorAttrImpactData$$CalAddVal
01751744  607601f9  str      x0, [x19, #0x2e8]
01751748  fd7b42a9  ldp      x29, x30, [sp, #0x20]
0175174c  f44f41a9  ldp      x20, x19, [sp, #0x10]
01751750  f50743f8  ldr      x21, [sp], #0x30
01751754  c0035fd6  ret      
