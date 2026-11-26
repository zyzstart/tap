; RVA 0x1ed5248, file offset 0x1ed5248, conservative end 0x1ed52ec
; SHA256 2c6bb907c002df5581860e302b654f374dc09d01e4ccb7fd79e66ea8e3e8e548
; All aliases at this entry: BattleCore.FP$$op_Explicit :: BattleCore_FP_o BattleCore_FP__op_Explicit (System_Decimal_o value, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed5248  ff0301d1  sub      sp, sp, #0x40
01ed524c  f50b00f9  str      x21, [sp, #0x10]
01ed5250  f44f02a9  stp      x20, x19, [sp, #0x20]
01ed5254  fd7b03a9  stp      x29, x30, [sp, #0x30]
01ed5258  fdc30091  add      x29, sp, #0x30
01ed525c  758300f0  adrp     x21, #0x2f44000
01ed5260  a8fa7e39  ldrb     w8, [x21, #0xfbe]
01ed5264  f30301aa  mov      x19, x1
01ed5268  f40300aa  mov      x20, x0
01ed526c  e8000037  tbnz     w8, #0, #0x1ed5288
01ed5270  886f0090  adrp     x8, #0x2cc5000
01ed5274  082945f9  ldr      x8, [x8, #0xa50]
01ed5278  000140b9  ldr      w0, [x8]
01ed527c  2bbfb897  bl       #0xd04f28 ; unresolved symbol
01ed5280  e8030032  mov      w8, #1
01ed5284  a8fa3e39  strb     w8, [x21, #0xfbe]
01ed5288  e0030091  mov      x0, sp
01ed528c  e10360b2  mov      x1, #0x100000000
01ed5290  e2031faa  mov      x2, xzr
01ed5294  ff7f00a9  stp      xzr, xzr, [sp]
01ed5298  0a8bf997  bl       #0x1d37ec0 ; unresolved symbol
01ed529c  c87100d0  adrp     x8, #0x2d0f000
01ed52a0  088143f9  ldr      x8, [x8, #0x700]
01ed52a4  000140f9  ldr      x0, [x8]
01ed52a8  089c4439  ldrb     w8, [x0, #0x127]
01ed52ac  88000836  tbz      w8, #1, #0x1ed52bc
01ed52b0  08d840b9  ldr      w8, [x0, #0xd8]
01ed52b4  48000035  cbnz     w8, #0x1ed52bc
01ed52b8  acfbb897  bl       #0xd14168 ; unresolved symbol
01ed52bc  e20f40a9  ldp      x2, x3, [sp]
01ed52c0  e00314aa  mov      x0, x20
01ed52c4  e10313aa  mov      x1, x19
01ed52c8  e4031faa  mov      x4, xzr
01ed52cc  6a97f997  bl       #0x1d3b074 ; System.Decimal$$op_Multiply
01ed52d0  e2031faa  mov      x2, xzr
01ed52d4  9998f997  bl       #0x1d3b538 ; System.Decimal$$op_Explicit
01ed52d8  fd7b43a9  ldp      x29, x30, [sp, #0x30]
01ed52dc  f44f42a9  ldp      x20, x19, [sp, #0x20]
01ed52e0  f50b40f9  ldr      x21, [sp, #0x10]
01ed52e4  ff030191  add      sp, sp, #0x40
01ed52e8  c0035fd6  ret      
