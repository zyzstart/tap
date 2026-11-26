; RVA 0x1ed43b8, file offset 0x1ed43b8, conservative end 0x1ed4438
; SHA256 a8b977708bb106e498e0655c57e292e425eb51123d4bd97b5134fd1458fd908b
; All aliases at this entry: BattleCore.FP$$op_UnaryNegation :: BattleCore_FP_o BattleCore_FP__op_UnaryNegation (BattleCore_FP_o x, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed43b8  f44fbea9  stp      x20, x19, [sp, #-0x20]!
01ed43bc  fd7b01a9  stp      x29, x30, [sp, #0x10]
01ed43c0  fd430091  add      x29, sp, #0x10
01ed43c4  94830090  adrp     x20, #0x2f44000
01ed43c8  88de7e39  ldrb     w8, [x20, #0xfb7]
01ed43cc  f30300aa  mov      x19, x0
01ed43d0  e8000037  tbnz     w8, #0, #0x1ed43ec
01ed43d4  68720090  adrp     x8, #0x2d20000
01ed43d8  083945f9  ldr      x8, [x8, #0xa70]
01ed43dc  000140b9  ldr      w0, [x8]
01ed43e0  d2c2b897  bl       #0xd04f28 ; unresolved symbol
01ed43e4  e8030032  mov      w8, #1
01ed43e8  88de3e39  strb     w8, [x20, #0xfb7]
01ed43ec  e80341b2  mov      x8, #-0x8000000000000000
01ed43f0  7f0208eb  cmp      x19, x8
01ed43f4  a1010054  b.ne     #0x1ed4428
01ed43f8  536f00b0  adrp     x19, #0x2cbd000
01ed43fc  73de47f9  ldr      x19, [x19, #0xfb8]
01ed4400  600240f9  ldr      x0, [x19]
01ed4404  089c4439  ldrb     w8, [x0, #0x127]
01ed4408  a8000836  tbz      w8, #1, #0x1ed441c
01ed440c  08d840b9  ldr      w8, [x0, #0xd8]
01ed4410  68000035  cbnz     w8, #0x1ed441c
01ed4414  55ffb897  bl       #0xd14168 ; unresolved symbol
01ed4418  600240f9  ldr      x0, [x19]
01ed441c  085c40f9  ldr      x8, [x0, #0xb8]
01ed4420  000540f9  ldr      x0, [x8, #8]
01ed4424  02000014  b        #0x1ed442c
01ed4428  e00313cb  neg      x0, x19
01ed442c  fd7b41a9  ldp      x29, x30, [sp, #0x10]
01ed4430  f44fc2a8  ldp      x20, x19, [sp], #0x20
01ed4434  c0035fd6  ret      
