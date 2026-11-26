; RVA 0x1752d58, file offset 0x1752d58, conservative end 0x1752de8
; SHA256 12c7139261dd90162476e580a306a38aa57afa649eacafee6a9986b1f5af17ba
; All aliases at this entry: A3BattleCore.ActorAttrData$$AddAttrElem :: void A3BattleCore_ActorAttrData__AddAttrElem (A3BattleCore_ActorAttrData_o* __this, uint32_t attrID, BattleCore_FP_o val, int32_t type, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01752d58  f70f1cf8  str      x23, [sp, #-0x40]!
01752d5c  f65701a9  stp      x22, x21, [sp, #0x10]
01752d60  f44f02a9  stp      x20, x19, [sp, #0x20]
01752d64  fd7b03a9  stp      x29, x30, [sp, #0x30]
01752d68  fdc30091  add      x29, sp, #0x30
01752d6c  77bf00d0  adrp     x23, #0x2f40000
01752d70  e8ae5639  ldrb     w8, [x23, #0x5ab]
01752d74  f403032a  mov      w20, w3
01752d78  f30302aa  mov      x19, x2
01752d7c  f503012a  mov      w21, w1
01752d80  f60300aa  mov      x22, x0
01752d84  e8000037  tbnz     w8, #0, #0x1752da0
01752d88  a8ad00b0  adrp     x8, #0x2d07000
01752d8c  08d546f9  ldr      x8, [x8, #0xda8]
01752d90  000140b9  ldr      w0, [x8]
01752d94  65c8d697  bl       #0xd04f28 ; unresolved symbol
01752d98  e8030032  mov      w8, #1
01752d9c  e8ae1639  strb     w8, [x23, #0x5ab]
01752da0  e8aa00b0  adrp     x8, #0x2caf000
01752da4  08b143f9  ldr      x8, [x8, #0x760]
01752da8  000140f9  ldr      x0, [x8]
01752dac  f396d797  bl       #0xd38978 ; unresolved symbol
01752db0  f70300aa  mov      x23, x0
01752db4  04ffff97  bl       #0x17529c4 ; A3BattleCore.ActorAttrImpactData$$.ctor
01752db8  770000b5  cbnz     x23, #0x1752dc4
01752dbc  e0031faa  mov      x0, xzr
01752dc0  5b62d797  bl       #0xd2b72c ; unresolved symbol
01752dc4  f4560329  stp      w20, w21, [x23, #0x18]
01752dc8  f31200f9  str      x19, [x23, #0x20]
01752dcc  e00316aa  mov      x0, x22
01752dd0  fd7b43a9  ldp      x29, x30, [sp, #0x30]
01752dd4  f44f42a9  ldp      x20, x19, [sp, #0x20]
01752dd8  f65741a9  ldp      x22, x21, [sp, #0x10]
01752ddc  e10317aa  mov      x1, x23
01752de0  f70744f8  ldr      x23, [sp], #0x40
01752de4  0bf8ff17  b        #0x1750e10 ; A3BattleCore.ActorAttrData$$CalImpact
