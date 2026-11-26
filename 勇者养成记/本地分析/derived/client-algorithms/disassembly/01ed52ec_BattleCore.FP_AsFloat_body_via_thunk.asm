; RVA 0x1ed52ec, file offset 0x1ed52ec, conservative end 0x1ed5360
; SHA256 05cb7be97606e51620bad363c97bed9a61a2bed29684831cdbc218ee5ef6961f
; All aliases at this entry: BattleCore.FP$$AsFloat_body_via_thunk :: inferred concrete unboxed entry from add x0,#0x10; b immediate
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed52ec  f44fbea9  stp      x20, x19, [sp, #-0x20]!
01ed52f0  fd7b01a9  stp      x29, x30, [sp, #0x10]
01ed52f4  fd430091  add      x29, sp, #0x10
01ed52f8  748300f0  adrp     x20, #0x2f44000
01ed52fc  88fe7e39  ldrb     w8, [x20, #0xfbf]
01ed5300  f30300aa  mov      x19, x0
01ed5304  e8000037  tbnz     w8, #0, #0x1ed5320
01ed5308  a86d00b0  adrp     x8, #0x2c8a000
01ed530c  084d40f9  ldr      x8, [x8, #0x98]
01ed5310  000140b9  ldr      w0, [x8]
01ed5314  05bfb897  bl       #0xd04f28 ; unresolved symbol
01ed5318  e8030032  mov      w8, #1
01ed531c  88fe3e39  strb     w8, [x20, #0xfbf]
01ed5320  486f0090  adrp     x8, #0x2cbd000
01ed5324  08dd47f9  ldr      x8, [x8, #0xfb8]
01ed5328  730240f9  ldr      x19, [x19]
01ed532c  000140f9  ldr      x0, [x8]
01ed5330  089c4439  ldrb     w8, [x0, #0x127]
01ed5334  88000836  tbz      w8, #1, #0x1ed5344
01ed5338  08d840b9  ldr      w8, [x0, #0xd8]
01ed533c  48000035  cbnz     w8, #0x1ed5344
01ed5340  8afbb897  bl       #0xd14168 ; unresolved symbol
01ed5344  e8260090  adrp     x8, #0x23b1000
01ed5348  006d44bd  ldr      s0, [x8, #0x46c]
01ed534c  fd7b41a9  ldp      x29, x30, [sp, #0x10]
01ed5350  6102229e  scvtf    s1, x19
01ed5354  2008201e  fmul     s0, s1, s0
01ed5358  f44fc2a8  ldp      x20, x19, [sp], #0x20
01ed535c  c0035fd6  ret      
