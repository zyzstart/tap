; RVA 0x21a5974, file offset 0x21a5974, conservative end 0x21a5a24
; SHA256 789f2528ec02809c6fdc82eac18c7e808735d531b6c6ca8649a1143ed4616107
; All aliases at this entry: BattleCore.TSRandom$$RandomInsideCircle :: BattleCore_TSVector2_o BattleCore_TSRandom__RandomInsideCircle (BattleCore_TSRandom_o* __this, BattleCore_FP_o radius, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
021a5974  f50f1df8  str      x21, [sp, #-0x30]!
021a5978  f44f01a9  stp      x20, x19, [sp, #0x10]
021a597c  fd7b02a9  stp      x29, x30, [sp, #0x20]
021a5980  fd830091  add      x29, sp, #0x20
021a5984  156d00b0  adrp     x21, #0x2f46000
021a5988  a8965f39  ldrb     w8, [x21, #0x7e5]
021a598c  f30301aa  mov      x19, x1
021a5990  f40300aa  mov      x20, x0
021a5994  e8000037  tbnz     w8, #0, #0x21a59b0
021a5998  885a00d0  adrp     x8, #0x2cf7000
021a599c  081542f9  ldr      x8, [x8, #0x428]
021a59a0  000140b9  ldr      w0, [x8]
021a59a4  617dad97  bl       #0xd04f28 ; unresolved symbol
021a59a8  e8030032  mov      w8, #1
021a59ac  a8961f39  strb     w8, [x21, #0x7e5]
021a59b0  c8580090  adrp     x8, #0x2cbd000
021a59b4  08dd47f9  ldr      x8, [x8, #0xfb8]
021a59b8  000140f9  ldr      x0, [x8]
021a59bc  089c4439  ldrb     w8, [x0, #0x127]
021a59c0  88000836  tbz      w8, #1, #0x21a59d0
021a59c4  08d840b9  ldr      w8, [x0, #0xd8]
021a59c8  48000035  cbnz     w8, #0x21a59d0
021a59cc  e7b9ad97  bl       #0xd14168 ; unresolved symbol
021a59d0  e00313aa  mov      x0, x19
021a59d4  e1031faa  mov      x1, xzr
021a59d8  78baf497  bl       #0x1ed43b8 ; BattleCore.FP$$op_UnaryNegation
021a59dc  e10300aa  mov      x1, x0
021a59e0  e00314aa  mov      x0, x20
021a59e4  e20313aa  mov      x2, x19
021a59e8  51ffff97  bl       #0x21a572c ; BattleCore.TSRandom$$Next
021a59ec  f50300aa  mov      x21, x0
021a59f0  e00313aa  mov      x0, x19
021a59f4  e1031faa  mov      x1, xzr
021a59f8  70baf497  bl       #0x1ed43b8 ; BattleCore.FP$$op_UnaryNegation
021a59fc  e10300aa  mov      x1, x0
021a5a00  e00314aa  mov      x0, x20
021a5a04  e20313aa  mov      x2, x19
021a5a08  49ffff97  bl       #0x21a572c ; BattleCore.TSRandom$$Next
021a5a0c  fd7b42a9  ldp      x29, x30, [sp, #0x20]
021a5a10  f44f41a9  ldp      x20, x19, [sp, #0x10]
021a5a14  e10300aa  mov      x1, x0
021a5a18  e00315aa  mov      x0, x21
021a5a1c  f50743f8  ldr      x21, [sp], #0x30
021a5a20  c0035fd6  ret      
