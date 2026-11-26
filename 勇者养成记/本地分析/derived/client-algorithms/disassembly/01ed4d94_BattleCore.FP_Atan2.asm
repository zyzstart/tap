; RVA 0x1ed4d94, file offset 0x1ed4d94, conservative end 0x1ed5094
; SHA256 976b54f2e723b71cbaa236f8726a545eff8f8d5c81be26e13f6e47469795b584
; All aliases at this entry: BattleCore.FP$$Atan2 :: BattleCore_FP_o BattleCore_FP__Atan2 (BattleCore_FP_o y, BattleCore_FP_o x, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed4d94  f85fbca9  stp      x24, x23, [sp, #-0x40]!
01ed4d98  f65701a9  stp      x22, x21, [sp, #0x10]
01ed4d9c  f44f02a9  stp      x20, x19, [sp, #0x20]
01ed4da0  fd7b03a9  stp      x29, x30, [sp, #0x30]
01ed4da4  fdc30091  add      x29, sp, #0x30
01ed4da8  95830090  adrp     x21, #0x2f44000
01ed4dac  a8f27e39  ldrb     w8, [x21, #0xfbc]
01ed4db0  f40301aa  mov      x20, x1
01ed4db4  f30300aa  mov      x19, x0
01ed4db8  e8000037  tbnz     w8, #0, #0x1ed4dd4
01ed4dbc  e86c0090  adrp     x8, #0x2c70000
01ed4dc0  08f544f9  ldr      x8, [x8, #0x9e8]
01ed4dc4  000140b9  ldr      w0, [x8]
01ed4dc8  58c0b897  bl       #0xd04f28 ; unresolved symbol
01ed4dcc  e8030032  mov      w8, #1
01ed4dd0  a8f23e39  strb     w8, [x21, #0xfbc]
01ed4dd4  b40600b4  cbz      x20, #0x1ed4ea8
01ed4dd8  576f00b0  adrp     x23, #0x2cbd000
01ed4ddc  f7de47f9  ldr      x23, [x23, #0xfb8]
01ed4de0  e00240f9  ldr      x0, [x23]
01ed4de4  089c4439  ldrb     w8, [x0, #0x127]
01ed4de8  88000836  tbz      w8, #1, #0x1ed4df8
01ed4dec  08d840b9  ldr      w8, [x0, #0xd8]
01ed4df0  48000035  cbnz     w8, #0x1ed4df8
01ed4df4  ddfcb897  bl       #0xd14168 ; unresolved symbol
01ed4df8  e00313aa  mov      x0, x19
01ed4dfc  e10314aa  mov      x1, x20
01ed4e00  c5fcff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed4e04  e80240f9  ldr      x8, [x23]
01ed4e08  f50300aa  mov      x21, x0
01ed4e0c  e10b5eb2  mov      x1, #0x1c00000000
01ed4e10  085d40f9  ldr      x8, [x8, #0xb8]
01ed4e14  082d40f9  ldr      x8, [x8, #0x58]
01ed4e18  e00308aa  mov      x0, x8
01ed4e1c  83fcff97  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
01ed4e20  e80240f9  ldr      x8, [x23]
01ed4e24  e10315aa  mov      x1, x21
01ed4e28  f60300aa  mov      x22, x0
01ed4e2c  085d40f9  ldr      x8, [x8, #0xb8]
01ed4e30  180d40f9  ldr      x24, [x8, #0x18]
01ed4e34  7dfcff97  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
01ed4e38  e10315aa  mov      x1, x21
01ed4e3c  7bfcff97  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
01ed4e40  e80300aa  mov      x8, x0
01ed4e44  e00240f9  ldr      x0, [x23]
01ed4e48  0801188b  add      x8, x8, x24
01ed4e4c  095c40f9  ldr      x9, [x0, #0xb8]
01ed4e50  0a4c4279  ldrh     w10, [x0, #0x126]
01ed4e54  2b0540f9  ldr      x11, [x9, #8]
01ed4e58  1f010beb  cmp      x8, x11
01ed4e5c  21040054  b.ne     #0x1ed4ee0
01ed4e60  ea004836  tbz      w10, #9, #0x1ed4e7c
01ed4e64  08d840b9  ldr      w8, [x0, #0xd8]
01ed4e68  a8000035  cbnz     w8, #0x1ed4e7c
01ed4e6c  bffcb897  bl       #0xd14168 ; unresolved symbol
01ed4e70  e00240f9  ldr      x0, [x23]
01ed4e74  095c40f9  ldr      x9, [x0, #0xb8]
01ed4e78  0a4c4279  ldrh     w10, [x0, #0x126]
01ed4e7c  281940f9  ldr      x8, [x9, #0x30]
01ed4e80  1f0113eb  cmp      x8, x19
01ed4e84  2d080054  b.le     #0x1ed4f88
01ed4e88  ca004836  tbz      w10, #9, #0x1ed4ea0
01ed4e8c  08d840b9  ldr      w8, [x0, #0xd8]
01ed4e90  88000035  cbnz     w8, #0x1ed4ea0
01ed4e94  b5fcb897  bl       #0xd14168 ; unresolved symbol
01ed4e98  e80240f9  ldr      x8, [x23]
01ed4e9c  095d40f9  ldr      x9, [x8, #0xb8]
01ed4ea0  205540f9  ldr      x0, [x9, #0xa8]
01ed4ea4  61000014  b        #0x1ed5028
01ed4ea8  7f0600f1  cmp      x19, #1
01ed4eac  6b0a0054  b.lt     #0x1ed4ff8
01ed4eb0  536f00b0  adrp     x19, #0x2cbd000
01ed4eb4  73de47f9  ldr      x19, [x19, #0xfb8]
01ed4eb8  600240f9  ldr      x0, [x19]
01ed4ebc  089c4439  ldrb     w8, [x0, #0x127]
01ed4ec0  a8000836  tbz      w8, #1, #0x1ed4ed4
01ed4ec4  08d840b9  ldr      w8, [x0, #0xd8]
01ed4ec8  68000035  cbnz     w8, #0x1ed4ed4
01ed4ecc  a7fcb897  bl       #0xd14168 ; unresolved symbol
01ed4ed0  600240f9  ldr      x0, [x19]
01ed4ed4  085c40f9  ldr      x8, [x0, #0xb8]
01ed4ed8  155540f9  ldr      x21, [x8, #0xa8]
01ed4edc  68000014  b        #0x1ed507c
01ed4ee0  8a004836  tbz      w10, #9, #0x1ed4ef0
01ed4ee4  08d840b9  ldr      w8, [x0, #0xd8]
01ed4ee8  48000035  cbnz     w8, #0x1ed4ef0
01ed4eec  9ffcb897  bl       #0xd14168 ; unresolved symbol
01ed4ef0  e00315aa  mov      x0, x21
01ed4ef4  d3fbff97  bl       #0x1ed3e40 ; BattleCore.FP$$Abs
01ed4ef8  e80240f9  ldr      x8, [x23]
01ed4efc  095d40f9  ldr      x9, [x8, #0xb8]
01ed4f00  0a4d4279  ldrh     w10, [x8, #0x126]
01ed4f04  380d40f9  ldr      x24, [x9, #0x18]
01ed4f08  1f0018eb  cmp      x0, x24
01ed4f0c  ea040054  b.ge     #0x1ed4fa8
01ed4f10  0a014836  tbz      w10, #9, #0x1ed4f30
01ed4f14  09d940b9  ldr      w9, [x8, #0xd8]
01ed4f18  c9000035  cbnz     w9, #0x1ed4f30
01ed4f1c  e00308aa  mov      x0, x8
01ed4f20  92fcb897  bl       #0xd14168 ; unresolved symbol
01ed4f24  e80240f9  ldr      x8, [x23]
01ed4f28  085d40f9  ldr      x8, [x8, #0xb8]
01ed4f2c  180d40f9  ldr      x24, [x8, #0x18]
01ed4f30  e00316aa  mov      x0, x22
01ed4f34  e10315aa  mov      x1, x21
01ed4f38  3cfcff97  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
01ed4f3c  e10315aa  mov      x1, x21
01ed4f40  3afcff97  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
01ed4f44  0100188b  add      x1, x0, x24
01ed4f48  e00315aa  mov      x0, x21
01ed4f4c  72fcff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed4f50  f50300aa  mov      x21, x0
01ed4f54  5409f8b6  tbz      x20, #0x3f, #0x1ed507c
01ed4f58  e00240f9  ldr      x0, [x23]
01ed4f5c  084c4279  ldrh     w8, [x0, #0x126]
01ed4f60  f307f8b7  tbnz     x19, #0x3f, #0x1ed505c
01ed4f64  a8004836  tbz      w8, #9, #0x1ed4f78
01ed4f68  08d840b9  ldr      w8, [x0, #0xd8]
01ed4f6c  68000035  cbnz     w8, #0x1ed4f78
01ed4f70  7efcb897  bl       #0xd14168 ; unresolved symbol
01ed4f74  e00240f9  ldr      x0, [x23]
01ed4f78  085c40f9  ldr      x8, [x0, #0xb8]
01ed4f7c  085140f9  ldr      x8, [x8, #0xa0]
01ed4f80  1501158b  add      x21, x8, x21
01ed4f84  3e000014  b        #0x1ed507c
01ed4f88  ca004836  tbz      w10, #9, #0x1ed4fa0
01ed4f8c  08d840b9  ldr      w8, [x0, #0xd8]
01ed4f90  88000035  cbnz     w8, #0x1ed4fa0
01ed4f94  75fcb897  bl       #0xd14168 ; unresolved symbol
01ed4f98  e80240f9  ldr      x8, [x23]
01ed4f9c  095d40f9  ldr      x9, [x8, #0xb8]
01ed4fa0  355540f9  ldr      x21, [x9, #0xa8]
01ed4fa4  36000014  b        #0x1ed507c
01ed4fa8  ea004836  tbz      w10, #9, #0x1ed4fc4
01ed4fac  0ad940b9  ldr      w10, [x8, #0xd8]
01ed4fb0  aa000035  cbnz     w10, #0x1ed4fc4
01ed4fb4  e00308aa  mov      x0, x8
01ed4fb8  6cfcb897  bl       #0xd14168 ; unresolved symbol
01ed4fbc  e80240f9  ldr      x8, [x23]
01ed4fc0  095d40f9  ldr      x9, [x8, #0xb8]
01ed4fc4  345540f9  ldr      x20, [x9, #0xa8]
01ed4fc8  e00315aa  mov      x0, x21
01ed4fcc  e10315aa  mov      x1, x21
01ed4fd0  16fcff97  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
01ed4fd4  0100168b  add      x1, x0, x22
01ed4fd8  e00315aa  mov      x0, x21
01ed4fdc  4efcff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed4fe0  950200cb  sub      x21, x20, x0
01ed4fe4  d304f8b6  tbz      x19, #0x3f, #0x1ed507c
01ed4fe8  e00240f9  ldr      x0, [x23]
01ed4fec  089c4439  ldrb     w8, [x0, #0x127]
01ed4ff0  88030837  tbnz     w8, #1, #0x1ed5060
01ed4ff4  1f000014  b        #0x1ed5070
01ed4ff8  546f00b0  adrp     x20, #0x2cbd000
01ed4ffc  94de47f9  ldr      x20, [x20, #0xfb8]
01ed5000  4f520014  b        #0x1ee993c ; unresolved symbol
01ed5004  084c4279  ldrh     w8, [x0, #0x126]
01ed5008  b30100b4  cbz      x19, #0x1ed503c
01ed500c  a8004836  tbz      w8, #9, #0x1ed5020
01ed5010  08d840b9  ldr      w8, [x0, #0xd8]
01ed5014  68000035  cbnz     w8, #0x1ed5020
01ed5018  54fcb897  bl       #0xd14168 ; unresolved symbol
01ed501c  800240f9  ldr      x0, [x20]
01ed5020  085c40f9  ldr      x8, [x0, #0xb8]
01ed5024  005540f9  ldr      x0, [x8, #0xa8]
01ed5028  fd7b43a9  ldp      x29, x30, [sp, #0x30]
01ed502c  f44f42a9  ldp      x20, x19, [sp, #0x20]
01ed5030  f65741a9  ldp      x22, x21, [sp, #0x10]
01ed5034  f85fc4a8  ldp      x24, x23, [sp], #0x40
01ed5038  e0fcff17  b        #0x1ed43b8 ; BattleCore.FP$$op_UnaryNegation
01ed503c  a8004836  tbz      w8, #9, #0x1ed5050
01ed5040  08d840b9  ldr      w8, [x0, #0xd8]
01ed5044  68000035  cbnz     w8, #0x1ed5050
01ed5048  48fcb897  bl       #0xd14168 ; unresolved symbol
01ed504c  800240f9  ldr      x0, [x20]
01ed5050  085c40f9  ldr      x8, [x0, #0xb8]
01ed5054  151940f9  ldr      x21, [x8, #0x30]
01ed5058  09000014  b        #0x1ed507c
01ed505c  a8004836  tbz      w8, #9, #0x1ed5070
01ed5060  08d840b9  ldr      w8, [x0, #0xd8]
01ed5064  68000035  cbnz     w8, #0x1ed5070
01ed5068  40fcb897  bl       #0xd14168 ; unresolved symbol
01ed506c  e00240f9  ldr      x0, [x23]
01ed5070  085c40f9  ldr      x8, [x0, #0xb8]
01ed5074  085140f9  ldr      x8, [x8, #0xa0]
01ed5078  b50208cb  sub      x21, x21, x8
01ed507c  e00315aa  mov      x0, x21
01ed5080  fd7b43a9  ldp      x29, x30, [sp, #0x30]
01ed5084  f44f42a9  ldp      x20, x19, [sp, #0x20]
01ed5088  f65741a9  ldp      x22, x21, [sp, #0x10]
01ed508c  f85fc4a8  ldp      x24, x23, [sp], #0x40
01ed5090  c0035fd6  ret      
