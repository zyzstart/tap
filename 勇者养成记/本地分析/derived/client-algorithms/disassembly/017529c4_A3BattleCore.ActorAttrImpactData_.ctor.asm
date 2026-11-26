; RVA 0x17529c4, file offset 0x17529c4, conservative end 0x1752a3c
; SHA256 a60e7651169c595e3ba8e7ad60872f37315553f1e6d5ad91a4999b754fcf64a0
; All aliases at this entry: A3BattleCore.ActorAttrImpactData$$.ctor :: void A3BattleCore_ActorAttrImpactData___ctor (A3BattleCore_ActorAttrImpactData_o* __this, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
017529c4  f44fbea9  stp      x20, x19, [sp, #-0x20]!
017529c8  fd7b01a9  stp      x29, x30, [sp, #0x10]
017529cc  fd430091  add      x29, sp, #0x10
017529d0  74bf00d0  adrp     x20, #0x2f40000
017529d4  88ca5639  ldrb     w8, [x20, #0x5b2]
017529d8  f30300aa  mov      x19, x0
017529dc  e8000037  tbnz     w8, #0, #0x17529f8
017529e0  c8aa00b0  adrp     x8, #0x2cab000
017529e4  084d44f9  ldr      x8, [x8, #0x898]
017529e8  000140b9  ldr      w0, [x8]
017529ec  4fc9d697  bl       #0xd04f28 ; unresolved symbol
017529f0  e8030032  mov      w8, #1
017529f4  88ca1639  strb     w8, [x20, #0x5b2]
017529f8  54ab00f0  adrp     x20, #0x2cbd000
017529fc  94de47f9  ldr      x20, [x20, #0xfb8]
01752a00  800240f9  ldr      x0, [x20]
01752a04  089c4439  ldrb     w8, [x0, #0x127]
01752a08  a8000836  tbz      w8, #1, #0x1752a1c
01752a0c  08d840b9  ldr      w8, [x0, #0xd8]
01752a10  68000035  cbnz     w8, #0x1752a1c
01752a14  d505d797  bl       #0xd14168 ; unresolved symbol
01752a18  800240f9  ldr      x0, [x20]
01752a1c  085c40f9  ldr      x8, [x0, #0xb8]
01752a20  e00313aa  mov      x0, x19
01752a24  e1031faa  mov      x1, xzr
01752a28  081940f9  ldr      x8, [x8, #0x30]
01752a2c  681200f9  str      x8, [x19, #0x20]
01752a30  fd7b41a9  ldp      x29, x30, [sp, #0x10]
01752a34  f44fc2a8  ldp      x20, x19, [sp], #0x20
01752a38  dde80a14  b        #0x1a0cdac ; System.Object$$.ctor
