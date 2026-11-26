; RVA 0x1ed4114, file offset 0x1ed4114, conservative end 0x1ed4188
; SHA256 61c14a79297a4a55df6ebdad02f970cd9ae9610e5a36967bdc474a4b24b629bc
; All aliases at this entry: BattleCore.FP$$op_Division :: BattleCore_FP_o BattleCore_FP__op_Division (BattleCore_FP_o x, BattleCore_FP_o y, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed4114  f50f1df8  str      x21, [sp, #-0x30]!
01ed4118  f44f01a9  stp      x20, x19, [sp, #0x10]
01ed411c  fd7b02a9  stp      x29, x30, [sp, #0x20]
01ed4120  fd830091  add      x29, sp, #0x20
01ed4124  95830090  adrp     x21, #0x2f44000
01ed4128  a8d67e39  ldrb     w8, [x21, #0xfb5]
01ed412c  f30301aa  mov      x19, x1
01ed4130  f40300aa  mov      x20, x0
01ed4134  e8000037  tbnz     w8, #0, #0x1ed4150
01ed4138  686f00d0  adrp     x8, #0x2cc2000
01ed413c  088942f9  ldr      x8, [x8, #0x510]
01ed4140  000140b9  ldr      w0, [x8]
01ed4144  79c3b897  bl       #0xd04f28 ; unresolved symbol
01ed4148  e8030032  mov      w8, #1
01ed414c  a8d63e39  strb     w8, [x21, #0xfb5]
01ed4150  486f00b0  adrp     x8, #0x2cbd000
01ed4154  08dd47f9  ldr      x8, [x8, #0xfb8]
01ed4158  000140f9  ldr      x0, [x8]
01ed415c  089c4439  ldrb     w8, [x0, #0x127]
01ed4160  88000836  tbz      w8, #1, #0x1ed4170
01ed4164  08d840b9  ldr      w8, [x0, #0xd8]
01ed4168  48000035  cbnz     w8, #0x1ed4170
01ed416c  ffffb897  bl       #0xd14168 ; unresolved symbol
01ed4170  e00314aa  mov      x0, x20
01ed4174  e10313aa  mov      x1, x19
01ed4178  fd7b42a9  ldp      x29, x30, [sp, #0x20]
01ed417c  f44f41a9  ldp      x20, x19, [sp, #0x10]
01ed4180  f50743f8  ldr      x21, [sp], #0x30
01ed4184  01000014  b        #0x1ed4188 ; BattleCore.FP$$Div
