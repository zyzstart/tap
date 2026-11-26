; RVA 0x1ed5550, file offset 0x1ed5550, conservative end 0x1ed55e0
; SHA256 aec87bd9f0d2e72584091230b4dfdb4d04bd57d6c942c3d931a92537737b27d9
; All aliases at this entry: BattleCore.FP$$ToString_body_via_thunk :: inferred concrete unboxed entry from add x0,#0x10; b immediate
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed5550  ffc300d1  sub      sp, sp, #0x30
01ed5554  f44f01a9  stp      x20, x19, [sp, #0x10]
01ed5558  fd7b02a9  stp      x29, x30, [sp, #0x20]
01ed555c  fd830091  add      x29, sp, #0x20
01ed5560  748300f0  adrp     x20, #0x2f44000
01ed5564  88127f39  ldrb     w8, [x20, #0xfc4]
01ed5568  f30300aa  mov      x19, x0
01ed556c  e8000037  tbnz     w8, #0, #0x1ed5588
01ed5570  a86f00f0  adrp     x8, #0x2ccc000
01ed5574  08c147f9  ldr      x8, [x8, #0xf80]
01ed5578  000140b9  ldr      w0, [x8]
01ed557c  6bbeb897  bl       #0xd04f28 ; unresolved symbol
01ed5580  e8030032  mov      w8, #1
01ed5584  88123f39  strb     w8, [x20, #0xfc4]
01ed5588  486f0090  adrp     x8, #0x2cbd000
01ed558c  08dd47f9  ldr      x8, [x8, #0xfb8]
01ed5590  ff0f00b9  str      wzr, [sp, #0xc]
01ed5594  730240f9  ldr      x19, [x19]
01ed5598  000140f9  ldr      x0, [x8]
01ed559c  089c4439  ldrb     w8, [x0, #0x127]
01ed55a0  88000836  tbz      w8, #1, #0x1ed55b0
01ed55a4  08d840b9  ldr      w8, [x0, #0xd8]
01ed55a8  48000035  cbnz     w8, #0x1ed55b0
01ed55ac  effab897  bl       #0xd14168 ; unresolved symbol
01ed55b0  e8260090  adrp     x8, #0x23b1000
01ed55b4  006d44bd  ldr      s0, [x8, #0x46c]
01ed55b8  6102229e  scvtf    s1, x19
01ed55bc  e0330091  add      x0, sp, #0xc
01ed55c0  e1031faa  mov      x1, xzr
01ed55c4  2008201e  fmul     s0, s1, s0
01ed55c8  e00f00bd  str      s0, [sp, #0xc]
01ed55cc  8d4bf397  bl       #0x1ba8400 ; unresolved symbol
01ed55d0  fd7b42a9  ldp      x29, x30, [sp, #0x20]
01ed55d4  f44f41a9  ldp      x20, x19, [sp, #0x10]
01ed55d8  ffc30091  add      sp, sp, #0x30
01ed55dc  c0035fd6  ret      
