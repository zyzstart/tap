; RVA 0x1ed3f5c, file offset 0x1ed3f5c, conservative end 0x1ed4010
; SHA256 4874c495d8d0c63748be5281b408e0e4b665348e7f72dc4a88aeb82351d5612a
; All aliases at this entry: BattleCore.FP$$Round :: BattleCore_FP_o BattleCore_FP__Round (BattleCore_FP_o value, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed3f5c  f657bda9  stp      x22, x21, [sp, #-0x30]!
01ed3f60  f44f01a9  stp      x20, x19, [sp, #0x10]
01ed3f64  fd7b02a9  stp      x29, x30, [sp, #0x20]
01ed3f68  fd830091  add      x29, sp, #0x20
01ed3f6c  938300b0  adrp     x19, #0x2f44000
01ed3f70  68ce7e39  ldrb     w8, [x19, #0xfb3]
01ed3f74  f40300aa  mov      x20, x0
01ed3f78  e8000037  tbnz     w8, #0, #0x1ed3f94
01ed3f7c  e87100b0  adrp     x8, #0x2d10000
01ed3f80  083142f9  ldr      x8, [x8, #0x460]
01ed3f84  000140b9  ldr      w0, [x8]
01ed3f88  e8c3b897  bl       #0xd04f28 ; unresolved symbol
01ed3f8c  e8030032  mov      w8, #1
01ed3f90  68ce3e39  strb     w8, [x19, #0xfb3]
01ed3f94  556f00d0  adrp     x21, #0x2cbd000
01ed3f98  b5de47f9  ldr      x21, [x21, #0xfb8]
01ed3f9c  967e4092  and      x22, x20, #0xffffffff
01ed3fa0  a00240f9  ldr      x0, [x21]
01ed3fa4  089c4439  ldrb     w8, [x0, #0x127]
01ed3fa8  88000836  tbz      w8, #1, #0x1ed3fb8
01ed3fac  08d840b9  ldr      w8, [x0, #0xd8]
01ed3fb0  48000035  cbnz     w8, #0x1ed3fb8
01ed3fb4  6d00b997  bl       #0xd14168 ; unresolved symbol
01ed3fb8  c8fe5fd3  lsr      x8, x22, #0x1f
01ed3fbc  937e6092  and      x19, x20, #0xffffffff00000000
01ed3fc0  e80100b4  cbz      x8, #0x1ed3ffc
01ed3fc4  e8030132  mov      w8, #-0xffffffff80000000
01ed3fc8  df0208eb  cmp      x22, x8
01ed3fcc  41000054  b.ne     #0x1ed3fd4
01ed3fd0  740100b6  tbz      x20, #0x20, #0x1ed3ffc
01ed3fd4  a00240f9  ldr      x0, [x21]
01ed3fd8  089c4439  ldrb     w8, [x0, #0x127]
01ed3fdc  a8000836  tbz      w8, #1, #0x1ed3ff0
01ed3fe0  08d840b9  ldr      w8, [x0, #0xd8]
01ed3fe4  68000035  cbnz     w8, #0x1ed3ff0
01ed3fe8  6000b997  bl       #0xd14168 ; unresolved symbol
01ed3fec  a00240f9  ldr      x0, [x21]
01ed3ff0  085c40f9  ldr      x8, [x0, #0xb8]
01ed3ff4  080d40f9  ldr      x8, [x8, #0x18]
01ed3ff8  1301138b  add      x19, x8, x19
01ed3ffc  e00313aa  mov      x0, x19
01ed4000  fd7b42a9  ldp      x29, x30, [sp, #0x20]
01ed4004  f44f41a9  ldp      x20, x19, [sp, #0x10]
01ed4008  f657c3a8  ldp      x22, x21, [sp], #0x30
01ed400c  c0035fd6  ret      
