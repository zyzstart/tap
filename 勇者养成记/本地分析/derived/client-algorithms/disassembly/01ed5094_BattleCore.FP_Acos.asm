; RVA 0x1ed5094, file offset 0x1ed5094, conservative end 0x1ed522c
; SHA256 c2e30b4fec230acaf803ee6729f4ed447446e03ba1079303c6232b13f01d6f3f
; All aliases at this entry: BattleCore.FP$$Acos :: BattleCore_FP_o BattleCore_FP__Acos (BattleCore_FP_o x, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed5094  f50f1df8  str      x21, [sp, #-0x30]!
01ed5098  f44f01a9  stp      x20, x19, [sp, #0x10]
01ed509c  fd7b02a9  stp      x29, x30, [sp, #0x20]
01ed50a0  fd830091  add      x29, sp, #0x20
01ed50a4  748300f0  adrp     x20, #0x2f44000
01ed50a8  88f67e39  ldrb     w8, [x20, #0xfbd]
01ed50ac  f30300aa  mov      x19, x0
01ed50b0  e8000037  tbnz     w8, #0, #0x1ed50cc
01ed50b4  c8700090  adrp     x8, #0x2ced000
01ed50b8  08b940f9  ldr      x8, [x8, #0x170]
01ed50bc  000140b9  ldr      w0, [x8]
01ed50c0  9abfb897  bl       #0xd04f28 ; unresolved symbol
01ed50c4  e8030032  mov      w8, #1
01ed50c8  88f63e39  strb     w8, [x20, #0xfbd]
01ed50cc  556f0090  adrp     x21, #0x2cbd000
01ed50d0  b5de47f9  ldr      x21, [x21, #0xfb8]
01ed50d4  a00240f9  ldr      x0, [x21]
01ed50d8  089c4439  ldrb     w8, [x0, #0x127]
01ed50dc  a8000836  tbz      w8, #1, #0x1ed50f0
01ed50e0  08d840b9  ldr      w8, [x0, #0xd8]
01ed50e4  68000035  cbnz     w8, #0x1ed50f0
01ed50e8  20fcb897  bl       #0xd14168 ; unresolved symbol
01ed50ec  a00240f9  ldr      x0, [x21]
01ed50f0  085c40f9  ldr      x8, [x0, #0xb8]
01ed50f4  000d40f9  ldr      x0, [x8, #0x18]
01ed50f8  b0fcff97  bl       #0x1ed43b8 ; BattleCore.FP$$op_UnaryNegation
01ed50fc  1f0013eb  cmp      x0, x19
01ed5100  8d010054  b.le     #0x1ed5130
01ed5104  a00240f9  ldr      x0, [x21]
01ed5108  089c4439  ldrb     w8, [x0, #0x127]
01ed510c  a8000836  tbz      w8, #1, #0x1ed5120
01ed5110  08d840b9  ldr      w8, [x0, #0xd8]
01ed5114  68000035  cbnz     w8, #0x1ed5120
01ed5118  14fcb897  bl       #0xd14168 ; unresolved symbol
01ed511c  a00240f9  ldr      x0, [x21]
01ed5120  085c40f9  ldr      x8, [x0, #0xb8]
01ed5124  000d40f9  ldr      x0, [x8, #0x18]
01ed5128  a4fcff97  bl       #0x1ed43b8 ; BattleCore.FP$$op_UnaryNegation
01ed512c  f30300aa  mov      x19, x0
01ed5130  a00240f9  ldr      x0, [x21]
01ed5134  089c4439  ldrb     w8, [x0, #0x127]
01ed5138  a8000836  tbz      w8, #1, #0x1ed514c
01ed513c  08d840b9  ldr      w8, [x0, #0xd8]
01ed5140  68000035  cbnz     w8, #0x1ed514c
01ed5144  09fcb897  bl       #0xd14168 ; unresolved symbol
01ed5148  a00240f9  ldr      x0, [x21]
01ed514c  085c40f9  ldr      x8, [x0, #0xb8]
01ed5150  080d40f9  ldr      x8, [x8, #0x18]
01ed5154  7f0208eb  cmp      x19, x8
01ed5158  cd000054  b.le     #0x1ed5170
01ed515c  099c4439  ldrb     w9, [x0, #0x127]
01ed5160  69000836  tbz      w9, #1, #0x1ed516c
01ed5164  09d840b9  ldr      w9, [x0, #0xd8]
01ed5168  89050034  cbz      w9, #0x1ed5218
01ed516c  f30308aa  mov      x19, x8
01ed5170  084c4279  ldrh     w8, [x0, #0x126]
01ed5174  b30300b4  cbz      x19, #0x1ed51e8
01ed5178  a8004836  tbz      w8, #9, #0x1ed518c
01ed517c  08d840b9  ldr      w8, [x0, #0xd8]
01ed5180  68000035  cbnz     w8, #0x1ed518c
01ed5184  f9fbb897  bl       #0xd14168 ; unresolved symbol
01ed5188  a00240f9  ldr      x0, [x21]
01ed518c  085c40f9  ldr      x8, [x0, #0xb8]
01ed5190  e00313aa  mov      x0, x19
01ed5194  e10313aa  mov      x1, x19
01ed5198  140d40f9  ldr      x20, [x8, #0x18]
01ed519c  a3fbff97  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
01ed51a0  800200cb  sub      x0, x20, x0
01ed51a4  b7fcff97  bl       #0x1ed4480 ; BattleCore.FP$$Sqrt
01ed51a8  e10313aa  mov      x1, x19
01ed51ac  dafbff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed51b0  45feff97  bl       #0x1ed4ac4 ; BattleCore.FP$$Atan
01ed51b4  f40300aa  mov      x20, x0
01ed51b8  7302f8b6  tbz      x19, #0x3f, #0x1ed5204
01ed51bc  a00240f9  ldr      x0, [x21]
01ed51c0  089c4439  ldrb     w8, [x0, #0x127]
01ed51c4  a8000836  tbz      w8, #1, #0x1ed51d8
01ed51c8  08d840b9  ldr      w8, [x0, #0xd8]
01ed51cc  68000035  cbnz     w8, #0x1ed51d8
01ed51d0  e6fbb897  bl       #0xd14168 ; unresolved symbol
01ed51d4  a00240f9  ldr      x0, [x21]
01ed51d8  085c40f9  ldr      x8, [x0, #0xb8]
01ed51dc  085140f9  ldr      x8, [x8, #0xa0]
01ed51e0  1401148b  add      x20, x8, x20
01ed51e4  08000014  b        #0x1ed5204
01ed51e8  a8004836  tbz      w8, #9, #0x1ed51fc
01ed51ec  08d840b9  ldr      w8, [x0, #0xd8]
01ed51f0  68000035  cbnz     w8, #0x1ed51fc
01ed51f4  ddfbb897  bl       #0xd14168 ; unresolved symbol
01ed51f8  a00240f9  ldr      x0, [x21]
01ed51fc  085c40f9  ldr      x8, [x0, #0xb8]
01ed5200  145540f9  ldr      x20, [x8, #0xa8]
01ed5204  e00314aa  mov      x0, x20
01ed5208  fd7b42a9  ldp      x29, x30, [sp, #0x20]
01ed520c  f44f41a9  ldp      x20, x19, [sp, #0x10]
01ed5210  f50743f8  ldr      x21, [sp], #0x30
01ed5214  c0035fd6  ret      
01ed5218  d4fbb897  bl       #0xd14168 ; unresolved symbol
01ed521c  a00240f9  ldr      x0, [x21]
01ed5220  085c40f9  ldr      x8, [x0, #0xb8]
01ed5224  130d40f9  ldr      x19, [x8, #0x18]
01ed5228  d2ffff17  b        #0x1ed5170
