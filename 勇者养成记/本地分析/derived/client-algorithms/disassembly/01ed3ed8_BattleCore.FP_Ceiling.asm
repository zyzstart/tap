; RVA 0x1ed3ed8, file offset 0x1ed3ed8, conservative end 0x1ed3f54
; SHA256 bb77b52d00e0630837addb647cbe12c3cba62a5748c9ed4929f56065ce791a93
; All aliases at this entry: BattleCore.FP$$Ceiling :: BattleCore_FP_o BattleCore_FP__Ceiling (BattleCore_FP_o value, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed3ed8  f44fbea9  stp      x20, x19, [sp, #-0x20]!
01ed3edc  fd7b01a9  stp      x29, x30, [sp, #0x10]
01ed3ee0  fd430091  add      x29, sp, #0x10
01ed3ee4  948300b0  adrp     x20, #0x2f44000
01ed3ee8  88ca7e39  ldrb     w8, [x20, #0xfb2]
01ed3eec  f30300aa  mov      x19, x0
01ed3ef0  e8000037  tbnz     w8, #0, #0x1ed3f0c
01ed3ef4  286e00f0  adrp     x8, #0x2c9a000
01ed3ef8  08fd47f9  ldr      x8, [x8, #0xff8]
01ed3efc  000140b9  ldr      w0, [x8]
01ed3f00  0ac4b897  bl       #0xd04f28 ; unresolved symbol
01ed3f04  e8030032  mov      w8, #1
01ed3f08  88ca3e39  strb     w8, [x20, #0xfb2]
01ed3f0c  d3010034  cbz      w19, #0x1ed3f44
01ed3f10  546f00d0  adrp     x20, #0x2cbd000
01ed3f14  94de47f9  ldr      x20, [x20, #0xfb8]
01ed3f18  800240f9  ldr      x0, [x20]
01ed3f1c  089c4439  ldrb     w8, [x0, #0x127]
01ed3f20  a8000836  tbz      w8, #1, #0x1ed3f34
01ed3f24  08d840b9  ldr      w8, [x0, #0xd8]
01ed3f28  68000035  cbnz     w8, #0x1ed3f34
01ed3f2c  8f00b997  bl       #0xd14168 ; unresolved symbol
01ed3f30  800240f9  ldr      x0, [x20]
01ed3f34  085c40f9  ldr      x8, [x0, #0xb8]
01ed3f38  697e6092  and      x9, x19, #0xffffffff00000000
01ed3f3c  080d40f9  ldr      x8, [x8, #0x18]
01ed3f40  1301098b  add      x19, x8, x9
01ed3f44  fd7b41a9  ldp      x29, x30, [sp, #0x10]
01ed3f48  e00313aa  mov      x0, x19
01ed3f4c  f44fc2a8  ldp      x20, x19, [sp], #0x20
01ed3f50  c0035fd6  ret      
