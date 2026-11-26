; RVA 0x16a0314, file offset 0x16a0314, conservative end 0x16a03cc
; SHA256 bb79c44fb4dcfa72c8f564909b2bcaefffc055f4d0336d16604c1072c6fd93f1
; All aliases at this entry: A3BattleCore.SkillDamageHelper$$TestRate :: bool A3BattleCore_SkillDamageHelper__TestRate (A3BattleCore_SkillDamageHelper_o* __this, BattleCore_FP_o val, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
016a0314  f657bda9  stp      x22, x21, [sp, #-0x30]!
016a0318  f44f01a9  stp      x20, x19, [sp, #0x10]
016a031c  fd7b02a9  stp      x29, x30, [sp, #0x20]
016a0320  fd830091  add      x29, sp, #0x20
016a0324  f5c400f0  adrp     x21, #0x2f3f000
016a0328  a8127c39  ldrb     w8, [x21, #0xf04]
016a032c  f30301aa  mov      x19, x1
016a0330  f40300aa  mov      x20, x0
016a0334  e8000037  tbnz     w8, #0, #0x16a0350
016a0338  a8b10090  adrp     x8, #0x2cd4000
016a033c  081d42f9  ldr      x8, [x8, #0x438]
016a0340  000140b9  ldr      w0, [x8]
016a0344  f992d997  bl       #0xd04f28 ; unresolved symbol
016a0348  e8030032  mov      w8, #1
016a034c  a8123c39  strb     w8, [x21, #0xf04]
016a0350  940a40f9  ldr      x20, [x20, #0x10]
016a0354  740000b5  cbnz     x20, #0x16a0360
016a0358  e0031faa  mov      x0, xzr
016a035c  f42cda97  bl       #0xd2b72c ; unresolved symbol
016a0360  f5b000b0  adrp     x21, #0x2cbd000
016a0364  b5de47f9  ldr      x21, [x21, #0xfb8]
016a0368  941e40f9  ldr      x20, [x20, #0x38]
016a036c  a00240f9  ldr      x0, [x21]
016a0370  089c4439  ldrb     w8, [x0, #0x127]
016a0374  a8000836  tbz      w8, #1, #0x16a0388
016a0378  08d840b9  ldr      w8, [x0, #0xd8]
016a037c  68000035  cbnz     w8, #0x16a0388
016a0380  7acfd997  bl       #0xd14168 ; unresolved symbol
016a0384  a00240f9  ldr      x0, [x21]
016a0388  085c40f9  ldr      x8, [x0, #0xb8]
016a038c  151940f9  ldr      x21, [x8, #0x30]
016a0390  160d40f9  ldr      x22, [x8, #0x18]
016a0394  740000b5  cbnz     x20, #0x16a03a0
016a0398  e0031faa  mov      x0, xzr
016a039c  e42cda97  bl       #0xd2b72c ; unresolved symbol
016a03a0  e00314aa  mov      x0, x20
016a03a4  e10315aa  mov      x1, x21
016a03a8  e20316aa  mov      x2, x22
016a03ac  e3031faa  mov      x3, xzr
016a03b0  df142c94  bl       #0x21a572c ; BattleCore.TSRandom$$Next
016a03b4  e10313aa  mov      x1, x19
016a03b8  fd7b42a9  ldp      x29, x30, [sp, #0x20]
016a03bc  f44f41a9  ldp      x20, x19, [sp, #0x10]
016a03c0  e2031faa  mov      x2, xzr
016a03c4  f657c3a8  ldp      x22, x21, [sp], #0x30
016a03c8  25d02014  b        #0x1ed445c ; BattleCore.FP$$op_LessThan
