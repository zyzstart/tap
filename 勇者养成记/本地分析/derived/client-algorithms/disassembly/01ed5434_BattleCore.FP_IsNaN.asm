; RVA 0x1ed5434, file offset 0x1ed5434, conservative end 0x1ed54a8
; SHA256 d23a6fe8519f328260659f2d77c1deefc4e72936a6572557a63c50925d2d08cb
; All aliases at this entry: BattleCore.FP$$IsNaN :: bool BattleCore_FP__IsNaN (BattleCore_FP_o value, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed5434  f44fbea9  stp      x20, x19, [sp, #-0x20]!
01ed5438  fd7b01a9  stp      x29, x30, [sp, #0x10]
01ed543c  fd430091  add      x29, sp, #0x10
01ed5440  748300f0  adrp     x20, #0x2f44000
01ed5444  880a7f39  ldrb     w8, [x20, #0xfc2]
01ed5448  f30300aa  mov      x19, x0
01ed544c  e8000037  tbnz     w8, #0, #0x1ed5468
01ed5450  a86d0090  adrp     x8, #0x2c89000
01ed5454  080d44f9  ldr      x8, [x8, #0x818]
01ed5458  000140b9  ldr      w0, [x8]
01ed545c  b3beb897  bl       #0xd04f28 ; unresolved symbol
01ed5460  e8030032  mov      w8, #1
01ed5464  880a3f39  strb     w8, [x20, #0xfc2]
01ed5468  546f0090  adrp     x20, #0x2cbd000
01ed546c  94de47f9  ldr      x20, [x20, #0xfb8]
01ed5470  800240f9  ldr      x0, [x20]
01ed5474  089c4439  ldrb     w8, [x0, #0x127]
01ed5478  a8000836  tbz      w8, #1, #0x1ed548c
01ed547c  08d840b9  ldr      w8, [x0, #0xd8]
01ed5480  68000035  cbnz     w8, #0x1ed548c
01ed5484  39fbb897  bl       #0xd14168 ; unresolved symbol
01ed5488  800240f9  ldr      x0, [x20]
01ed548c  085c40f9  ldr      x8, [x0, #0xb8]
01ed5490  fd7b41a9  ldp      x29, x30, [sp, #0x10]
01ed5494  082540f9  ldr      x8, [x8, #0x48]
01ed5498  1f0113eb  cmp      x8, x19
01ed549c  e0179f1a  cset     w0, eq
01ed54a0  f44fc2a8  ldp      x20, x19, [sp], #0x20
01ed54a4  c0035fd6  ret      
