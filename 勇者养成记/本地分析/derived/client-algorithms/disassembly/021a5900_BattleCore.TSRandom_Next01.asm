; RVA 0x21a5900, file offset 0x21a5900, conservative end 0x21a5974
; SHA256 cb6da321b4c814e143d72b8eab181f619cf743b6908316f56ab2ab524d807432
; All aliases at this entry: BattleCore.TSRandom$$Next01 :: BattleCore_FP_o BattleCore_TSRandom__Next01 (BattleCore_TSRandom_o* __this, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
021a5900  f44fbea9  stp      x20, x19, [sp, #-0x20]!
021a5904  fd7b01a9  stp      x29, x30, [sp, #0x10]
021a5908  fd430091  add      x29, sp, #0x10
021a590c  146d00b0  adrp     x20, #0x2f46000
021a5910  88925f39  ldrb     w8, [x20, #0x7e4]
021a5914  f30300aa  mov      x19, x0
021a5918  e8000037  tbnz     w8, #0, #0x21a5934
021a591c  a85a0090  adrp     x8, #0x2cf9000
021a5920  08c144f9  ldr      x8, [x8, #0x980]
021a5924  000140b9  ldr      w0, [x8]
021a5928  807dad97  bl       #0xd04f28 ; unresolved symbol
021a592c  e8030032  mov      w8, #1
021a5930  88921f39  strb     w8, [x20, #0x7e4]
021a5934  d4580090  adrp     x20, #0x2cbd000
021a5938  94de47f9  ldr      x20, [x20, #0xfb8]
021a593c  800240f9  ldr      x0, [x20]
021a5940  089c4439  ldrb     w8, [x0, #0x127]
021a5944  a8000836  tbz      w8, #1, #0x21a5958
021a5948  08d840b9  ldr      w8, [x0, #0xd8]
021a594c  68000035  cbnz     w8, #0x21a5958
021a5950  06baad97  bl       #0xd14168 ; unresolved symbol
021a5954  800240f9  ldr      x0, [x20]
021a5958  085c40f9  ldr      x8, [x0, #0xb8]
021a595c  fd7b41a9  ldp      x29, x30, [sp, #0x10]
021a5960  e00313aa  mov      x0, x19
021a5964  011940f9  ldr      x1, [x8, #0x30]
021a5968  020d40f9  ldr      x2, [x8, #0x18]
021a596c  f44fc2a8  ldp      x20, x19, [sp], #0x20
021a5970  6fffff17  b        #0x21a572c ; BattleCore.TSRandom$$Next
