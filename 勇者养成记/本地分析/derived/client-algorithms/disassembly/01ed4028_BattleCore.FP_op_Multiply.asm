; RVA 0x1ed4028, file offset 0x1ed4028, conservative end 0x1ed40b4
; SHA256 1f272b6376b22cdbcf0ca36ffc77aa4e1cceec90e0d0dd65f0d32e211c533e6e
; All aliases at this entry: BattleCore.FP$$op_Multiply :: BattleCore_FP_o BattleCore_FP__op_Multiply (BattleCore_FP_o x, BattleCore_FP_o y, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed4028  f50f1df8  str      x21, [sp, #-0x30]!
01ed402c  f44f01a9  stp      x20, x19, [sp, #0x10]
01ed4030  fd7b02a9  stp      x29, x30, [sp, #0x20]
01ed4034  fd830091  add      x29, sp, #0x20
01ed4038  95830090  adrp     x21, #0x2f44000
01ed403c  a8d27e39  ldrb     w8, [x21, #0xfb4]
01ed4040  f30301aa  mov      x19, x1
01ed4044  f40300aa  mov      x20, x0
01ed4048  e8000037  tbnz     w8, #0, #0x1ed4064
01ed404c  287100f0  adrp     x8, #0x2cfb000
01ed4050  08f147f9  ldr      x8, [x8, #0xfe0]
01ed4054  000140b9  ldr      w0, [x8]
01ed4058  b4c3b897  bl       #0xd04f28 ; unresolved symbol
01ed405c  e8030032  mov      w8, #1
01ed4060  a8d23e39  strb     w8, [x21, #0xfb4]
01ed4064  486f00b0  adrp     x8, #0x2cbd000
01ed4068  08dd47f9  ldr      x8, [x8, #0xfb8]
01ed406c  000140f9  ldr      x0, [x8]
01ed4070  089c4439  ldrb     w8, [x0, #0x127]
01ed4074  88000836  tbz      w8, #1, #0x1ed4084
01ed4078  08d840b9  ldr      w8, [x0, #0xd8]
01ed407c  48000035  cbnz     w8, #0x1ed4084
01ed4080  3a00b997  bl       #0xd14168 ; unresolved symbol
01ed4084  887e4092  and      x8, x20, #0xffffffff
01ed4088  697e4092  and      x9, x19, #0xffffffff
01ed408c  6afe6093  asr      x10, x19, #0x20
01ed4090  297d089b  mul      x9, x9, x8
01ed4094  487d089b  mul      x8, x10, x8
01ed4098  8afe6093  asr      x10, x20, #0x20
01ed409c  0881498b  add      x8, x8, x9, lsr #32
01ed40a0  60220a9b  madd     x0, x19, x10, x8
01ed40a4  fd7b42a9  ldp      x29, x30, [sp, #0x20]
01ed40a8  f44f41a9  ldp      x20, x19, [sp, #0x10]
01ed40ac  f50743f8  ldr      x21, [sp], #0x30
01ed40b0  c0035fd6  ret      
