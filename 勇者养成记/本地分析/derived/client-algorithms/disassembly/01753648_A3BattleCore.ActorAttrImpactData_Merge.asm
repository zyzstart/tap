; RVA 0x1753648, file offset 0x1753648, conservative end 0x1753768
; SHA256 9226a11f4b782c445558805c611ac91148cc0d41c71c131a8993b4efa0f1472c
; All aliases at this entry: A3BattleCore.ActorAttrImpactData$$Merge :: void A3BattleCore_ActorAttrImpactData__Merge (A3BattleCore_ActorAttrImpactData_o* __this, A3BattleCore_ActorAttrImpactData_o* other, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01753648  f70f1cf8  str      x23, [sp, #-0x40]!
0175364c  f65701a9  stp      x22, x21, [sp, #0x10]
01753650  f44f02a9  stp      x20, x19, [sp, #0x20]
01753654  fd7b03a9  stp      x29, x30, [sp, #0x30]
01753658  fdc30091  add      x29, sp, #0x30
0175365c  75bf00b0  adrp     x21, #0x2f40000
01753660  a8c25639  ldrb     w8, [x21, #0x5b0]
01753664  f40301aa  mov      x20, x1
01753668  f30300aa  mov      x19, x0
0175366c  e8000037  tbnz     w8, #0, #0x1753688
01753670  08ad00f0  adrp     x8, #0x2cf6000
01753674  08d944f9  ldr      x8, [x8, #0x9b0]
01753678  000140b9  ldr      w0, [x8]
0175367c  2bc6d697  bl       #0xd04f28 ; unresolved symbol
01753680  e8030032  mov      w8, #1
01753684  a8c21639  strb     w8, [x21, #0x5b0]
01753688  740000b5  cbnz     x20, #0x1753694
0175368c  e0031faa  mov      x0, xzr
01753690  2760d797  bl       #0xd2b72c ; unresolved symbol
01753694  881e40b9  ldr      w8, [x20, #0x1c]
01753698  1f410071  cmp      w8, #0x10
0175369c  e1030054  b.ne     #0x1753718
017536a0  881a40b9  ldr      w8, [x20, #0x18]
017536a4  08791f12  and      w8, w8, #0xfffffffe
017536a8  1f090071  cmp      w8, #2
017536ac  61030054  b.ne     #0x1753718
017536b0  57ab00d0  adrp     x23, #0x2cbd000
017536b4  f7de47f9  ldr      x23, [x23, #0xfb8]
017536b8  751240f9  ldr      x21, [x19, #0x20]
017536bc  961240f9  ldr      x22, [x20, #0x20]
017536c0  e00240f9  ldr      x0, [x23]
017536c4  089c4439  ldrb     w8, [x0, #0x127]
017536c8  88000836  tbz      w8, #1, #0x17536d8
017536cc  08d840b9  ldr      w8, [x0, #0xd8]
017536d0  48000035  cbnz     w8, #0x17536d8
017536d4  a502d797  bl       #0xd14168 ; unresolved symbol
017536d8  e00315aa  mov      x0, x21
017536dc  e10316aa  mov      x1, x22
017536e0  e2031faa  mov      x2, xzr
017536e4  1c021e94  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
017536e8  e80240f9  ldr      x8, [x23]
017536ec  f50300aa  mov      x21, x0
017536f0  e1031faa  mov      x1, xzr
017536f4  085d40f9  ldr      x8, [x8, #0xb8]
017536f8  080d40f9  ldr      x8, [x8, #0x18]
017536fc  e00308aa  mov      x0, x8
01753700  2e031e94  bl       #0x1ed43b8 ; BattleCore.FP$$op_UnaryNegation
01753704  e10300aa  mov      x1, x0
01753708  e00315aa  mov      x0, x21
0175370c  e2031faa  mov      x2, xzr
01753710  59031e94  bl       #0x1ed4474 ; BattleCore.FP$$op_LessThanOrEqual
01753714  00020037  tbnz     w0, #0, #0x1753754
01753718  48ab00d0  adrp     x8, #0x2cbd000
0175371c  08dd47f9  ldr      x8, [x8, #0xfb8]
01753720  751240f9  ldr      x21, [x19, #0x20]
01753724  941240f9  ldr      x20, [x20, #0x20]
01753728  000140f9  ldr      x0, [x8]
0175372c  089c4439  ldrb     w8, [x0, #0x127]
01753730  88000836  tbz      w8, #1, #0x1753740
01753734  08d840b9  ldr      w8, [x0, #0xd8]
01753738  48000035  cbnz     w8, #0x1753740
0175373c  8b02d797  bl       #0xd14168 ; unresolved symbol
01753740  e00315aa  mov      x0, x21
01753744  e10314aa  mov      x1, x20
01753748  e2031faa  mov      x2, xzr
0175374c  02021e94  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
01753750  601200f9  str      x0, [x19, #0x20]
01753754  fd7b43a9  ldp      x29, x30, [sp, #0x30]
01753758  f44f42a9  ldp      x20, x19, [sp, #0x20]
0175375c  f65741a9  ldp      x22, x21, [sp, #0x10]
01753760  f70744f8  ldr      x23, [sp], #0x40
01753764  c0035fd6  ret      
