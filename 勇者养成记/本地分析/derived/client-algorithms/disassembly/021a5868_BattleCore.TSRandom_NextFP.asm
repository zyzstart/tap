; RVA 0x21a5868, file offset 0x21a5868, conservative end 0x21a5900
; SHA256 de075fd2d0201706844fa7738e94d600c5c504bf5201d1704e68a8100fb5779a
; All aliases at this entry: BattleCore.TSRandom$$NextFP :: BattleCore_FP_o BattleCore_TSRandom__NextFP (BattleCore_TSRandom_o* __this, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
021a5868  f44fbea9  stp      x20, x19, [sp, #-0x20]!
021a586c  fd7b01a9  stp      x29, x30, [sp, #0x10]
021a5870  fd430091  add      x29, sp, #0x10
021a5874  146d00b0  adrp     x20, #0x2f46000
021a5878  889a5f39  ldrb     w8, [x20, #0x7e6]
021a587c  f30300aa  mov      x19, x0
021a5880  e8000037  tbnz     w8, #0, #0x21a589c
021a5884  c85600d0  adrp     x8, #0x2c7f000
021a5888  080545f9  ldr      x8, [x8, #0xa08]
021a588c  000140b9  ldr      w0, [x8]
021a5890  a67dad97  bl       #0xd04f28 ; unresolved symbol
021a5894  e8030032  mov      w8, #1
021a5898  889a1f39  strb     w8, [x20, #0x7e6]
021a589c  e00313aa  mov      x0, x19
021a58a0  61000094  bl       #0x21a5a24 ; BattleCore.TSRandom$$genrand_int32
021a58a4  c8580090  adrp     x8, #0x2cbd000
021a58a8  08dd47f9  ldr      x8, [x8, #0xfb8]
021a58ac  137c0153  lsr      w19, w0, #1
021a58b0  080140f9  ldr      x8, [x8]
021a58b4  099d4439  ldrb     w9, [x8, #0x127]
021a58b8  a9000836  tbz      w9, #1, #0x21a58cc
021a58bc  09d940b9  ldr      w9, [x8, #0xd8]
021a58c0  69000035  cbnz     w9, #0x21a58cc
021a58c4  e00308aa  mov      x0, x8
021a58c8  28baad97  bl       #0xd14168 ; unresolved symbol
021a58cc  e003132a  mov      w0, w19
021a58d0  e1031faa  mov      x1, xzr
021a58d4  b7baf497  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
021a58d8  f30300aa  mov      x19, x0
021a58dc  e07b0032  mov      w0, #0x7fffffff
021a58e0  e1031faa  mov      x1, xzr
021a58e4  b3baf497  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
021a58e8  fd7b41a9  ldp      x29, x30, [sp, #0x10]
021a58ec  e10300aa  mov      x1, x0
021a58f0  e00313aa  mov      x0, x19
021a58f4  e2031faa  mov      x2, xzr
021a58f8  f44fc2a8  ldp      x20, x19, [sp], #0x20
021a58fc  06baf417  b        #0x1ed4114 ; BattleCore.FP$$op_Division
