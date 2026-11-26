; RVA 0x1ed4ac4, file offset 0x1ed4ac4, conservative end 0x1ed4d94
; SHA256 f41709ea61f956b3263761634eb7bb538badfc7da3ab37e0a06bb65179730580
; All aliases at this entry: BattleCore.FP$$Atan :: BattleCore_FP_o BattleCore_FP__Atan (BattleCore_FP_o z, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed4ac4  ff0302d1  sub      sp, sp, #0x80
01ed4ac8  fc6f02a9  stp      x28, x27, [sp, #0x20]
01ed4acc  fa6703a9  stp      x26, x25, [sp, #0x30]
01ed4ad0  f85f04a9  stp      x24, x23, [sp, #0x40]
01ed4ad4  f65705a9  stp      x22, x21, [sp, #0x50]
01ed4ad8  f44f06a9  stp      x20, x19, [sp, #0x60]
01ed4adc  fd7b07a9  stp      x29, x30, [sp, #0x70]
01ed4ae0  fdc30191  add      x29, sp, #0x70
01ed4ae4  93830090  adrp     x19, #0x2f44000
01ed4ae8  68ee7e39  ldrb     w8, [x19, #0xfbb]
01ed4aec  f40300aa  mov      x20, x0
01ed4af0  e8000037  tbnz     w8, #0, #0x1ed4b0c
01ed4af4  e86c00d0  adrp     x8, #0x2c72000
01ed4af8  081147f9  ldr      x8, [x8, #0xe20]
01ed4afc  000140b9  ldr      w0, [x8]
01ed4b00  0ac1b897  bl       #0xd04f28 ; unresolved symbol
01ed4b04  e8030032  mov      w8, #1
01ed4b08  68ee3e39  strb     w8, [x19, #0xfbb]
01ed4b0c  340400b4  cbz      x20, #0x1ed4b90
01ed4b10  f50314aa  mov      x21, x20
01ed4b14  9401f8b6  tbz      x20, #0x3f, #0x1ed4b44
01ed4b18  486f00b0  adrp     x8, #0x2cbd000
01ed4b1c  08dd47f9  ldr      x8, [x8, #0xfb8]
01ed4b20  000140f9  ldr      x0, [x8]
01ed4b24  089c4439  ldrb     w8, [x0, #0x127]
01ed4b28  88000836  tbz      w8, #1, #0x1ed4b38
01ed4b2c  08d840b9  ldr      w8, [x0, #0xd8]
01ed4b30  48000035  cbnz     w8, #0x1ed4b38
01ed4b34  8dfdb897  bl       #0xd14168 ; unresolved symbol
01ed4b38  e00314aa  mov      x0, x20
01ed4b3c  1ffeff97  bl       #0x1ed43b8 ; BattleCore.FP$$op_UnaryNegation
01ed4b40  f50300aa  mov      x21, x0
01ed4b44  536f00b0  adrp     x19, #0x2cbd000
01ed4b48  73de47f9  ldr      x19, [x19, #0xfb8]
01ed4b4c  680240f9  ldr      x8, [x19]
01ed4b50  099d4439  ldrb     w9, [x8, #0x127]
01ed4b54  c9000836  tbz      w9, #1, #0x1ed4b6c
01ed4b58  09d940b9  ldr      w9, [x8, #0xd8]
01ed4b5c  89000035  cbnz     w9, #0x1ed4b6c
01ed4b60  e00308aa  mov      x0, x8
01ed4b64  81fdb897  bl       #0xd14168 ; unresolved symbol
01ed4b68  680240f9  ldr      x8, [x19]
01ed4b6c  095d40f9  ldr      x9, [x8, #0xb8]
01ed4b70  2a0d40f9  ldr      x10, [x9, #0x18]
01ed4b74  bf020aeb  cmp      x21, x10
01ed4b78  ead700a9  stp      x10, x21, [sp, #8]
01ed4b7c  ad030054  b.le     #0x1ed4bf0
01ed4b80  099d4439  ldrb     w9, [x8, #0x127]
01ed4b84  e9010837  tbnz     w9, #1, #0x1ed4bc0
01ed4b88  e0030aaa  mov      x0, x10
01ed4b8c  15000014  b        #0x1ed4be0
01ed4b90  536f00b0  adrp     x19, #0x2cbd000
01ed4b94  73de47f9  ldr      x19, [x19, #0xfb8]
01ed4b98  600240f9  ldr      x0, [x19]
01ed4b9c  089c4439  ldrb     w8, [x0, #0x127]
01ed4ba0  a8000836  tbz      w8, #1, #0x1ed4bb4
01ed4ba4  08d840b9  ldr      w8, [x0, #0xd8]
01ed4ba8  68000035  cbnz     w8, #0x1ed4bb4
01ed4bac  6ffdb897  bl       #0xd14168 ; unresolved symbol
01ed4bb0  600240f9  ldr      x0, [x19]
01ed4bb4  085c40f9  ldr      x8, [x0, #0xb8]
01ed4bb8  141940f9  ldr      x20, [x8, #0x30]
01ed4bbc  5c000014  b        #0x1ed4d2c
01ed4bc0  09d940b9  ldr      w9, [x8, #0xd8]
01ed4bc4  e0030aaa  mov      x0, x10
01ed4bc8  c9000035  cbnz     w9, #0x1ed4be0
01ed4bcc  e00308aa  mov      x0, x8
01ed4bd0  66fdb897  bl       #0xd14168 ; unresolved symbol
01ed4bd4  680240f9  ldr      x8, [x19]
01ed4bd8  085d40f9  ldr      x8, [x8, #0xb8]
01ed4bdc  000d40f9  ldr      x0, [x8, #0x18]
01ed4be0  e10315aa  mov      x1, x21
01ed4be4  4cfdff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed4be8  680240f9  ldr      x8, [x19]
01ed4bec  f50300aa  mov      x21, x0
01ed4bf0  099d4439  ldrb     w9, [x8, #0x127]
01ed4bf4  f40f00f9  str      x20, [sp, #0x18]
01ed4bf8  c9000836  tbz      w9, #1, #0x1ed4c10
01ed4bfc  09d940b9  ldr      w9, [x8, #0xd8]
01ed4c00  89000035  cbnz     w9, #0x1ed4c10
01ed4c04  e00308aa  mov      x0, x8
01ed4c08  58fdb897  bl       #0xd14168 ; unresolved symbol
01ed4c0c  680240f9  ldr      x8, [x19]
01ed4c10  085d40f9  ldr      x8, [x8, #0xb8]
01ed4c14  e00315aa  mov      x0, x21
01ed4c18  e10315aa  mov      x1, x21
01ed4c1c  160d40f9  ldr      x22, [x8, #0x18]
01ed4c20  02fdff97  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
01ed4c24  e1035fb2  mov      x1, #0x200000000
01ed4c28  f70300aa  mov      x23, x0
01ed4c2c  fffcff97  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
01ed4c30  680240f9  ldr      x8, [x19]
01ed4c34  f80300aa  mov      x24, x0
01ed4c38  e1035fb2  mov      x1, #0x200000000
01ed4c3c  085d40f9  ldr      x8, [x8, #0xb8]
01ed4c40  080d40f9  ldr      x8, [x8, #0x18]
01ed4c44  1701178b  add      x23, x8, x23
01ed4c48  e00317aa  mov      x0, x23
01ed4c4c  f7fcff97  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
01ed4c50  f90300aa  mov      x25, x0
01ed4c54  e10760b2  mov      x1, #0x300000000
01ed4c58  e00317aa  mov      x0, x23
01ed4c5c  f3fcff97  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
01ed4c60  fa0300aa  mov      x26, x0
01ed4c64  f4030032  mov      w20, #1
01ed4c68  fb0318aa  mov      x27, x24
01ed4c6c  fc0316aa  mov      x28, x22
01ed4c70  600240f9  ldr      x0, [x19]
01ed4c74  089c4439  ldrb     w8, [x0, #0x127]
01ed4c78  88000836  tbz      w8, #1, #0x1ed4c88
01ed4c7c  08d840b9  ldr      w8, [x0, #0xd8]
01ed4c80  48000035  cbnz     w8, #0x1ed4c88
01ed4c84  39fdb897  bl       #0xd14168 ; unresolved symbol
01ed4c88  e0031baa  mov      x0, x27
01ed4c8c  e1031aaa  mov      x1, x26
01ed4c90  21fdff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed4c94  e10300aa  mov      x1, x0
01ed4c98  e0031caa  mov      x0, x28
01ed4c9c  e3fcff97  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
01ed4ca0  fc0300aa  mov      x28, x0
01ed4ca4  9603168b  add      x22, x28, x22
01ed4ca8  dc0000b4  cbz      x28, #0x1ed4cc0
01ed4cac  94060011  add      w20, w20, #1
01ed4cb0  5a03198b  add      x26, x26, x25
01ed4cb4  9f760071  cmp      w20, #0x1d
01ed4cb8  7b03188b  add      x27, x27, x24
01ed4cbc  abfdff54  b.lt     #0x1ed4c70
01ed4cc0  600240f9  ldr      x0, [x19]
01ed4cc4  089c4439  ldrb     w8, [x0, #0x127]
01ed4cc8  88000836  tbz      w8, #1, #0x1ed4cd8
01ed4ccc  08d840b9  ldr      w8, [x0, #0xd8]
01ed4cd0  48000035  cbnz     w8, #0x1ed4cd8
01ed4cd4  25fdb897  bl       #0xd14168 ; unresolved symbol
01ed4cd8  e00316aa  mov      x0, x22
01ed4cdc  e10315aa  mov      x1, x21
01ed4ce0  d2fcff97  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
01ed4ce4  e10317aa  mov      x1, x23
01ed4ce8  0bfdff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed4cec  e9a340a9  ldp      x9, x8, [sp, #8]
01ed4cf0  f40300aa  mov      x20, x0
01ed4cf4  1f0109eb  cmp      x8, x9
01ed4cf8  6d010054  b.le     #0x1ed4d24
01ed4cfc  600240f9  ldr      x0, [x19]
01ed4d00  089c4439  ldrb     w8, [x0, #0x127]
01ed4d04  a8000836  tbz      w8, #1, #0x1ed4d18
01ed4d08  08d840b9  ldr      w8, [x0, #0xd8]
01ed4d0c  68000035  cbnz     w8, #0x1ed4d18
01ed4d10  16fdb897  bl       #0xd14168 ; unresolved symbol
01ed4d14  600240f9  ldr      x0, [x19]
01ed4d18  085c40f9  ldr      x8, [x0, #0xb8]
01ed4d1c  085540f9  ldr      x8, [x8, #0xa8]
01ed4d20  140114cb  sub      x20, x8, x20
01ed4d24  e80f40f9  ldr      x8, [sp, #0x18]
01ed4d28  4801f8b7  tbnz     x8, #0x3f, #0x1ed4d50
01ed4d2c  e00314aa  mov      x0, x20
01ed4d30  fd7b47a9  ldp      x29, x30, [sp, #0x70]
01ed4d34  f44f46a9  ldp      x20, x19, [sp, #0x60]
01ed4d38  f65745a9  ldp      x22, x21, [sp, #0x50]
01ed4d3c  f85f44a9  ldp      x24, x23, [sp, #0x40]
01ed4d40  fa6743a9  ldp      x26, x25, [sp, #0x30]
01ed4d44  fc6f42a9  ldp      x28, x27, [sp, #0x20]
01ed4d48  ff030291  add      sp, sp, #0x80
01ed4d4c  c0035fd6  ret      
01ed4d50  600240f9  ldr      x0, [x19]
01ed4d54  089c4439  ldrb     w8, [x0, #0x127]
01ed4d58  88000836  tbz      w8, #1, #0x1ed4d68
01ed4d5c  08d840b9  ldr      w8, [x0, #0xd8]
01ed4d60  48000035  cbnz     w8, #0x1ed4d68
01ed4d64  01fdb897  bl       #0xd14168 ; unresolved symbol
01ed4d68  e00314aa  mov      x0, x20
01ed4d6c  fd7b47a9  ldp      x29, x30, [sp, #0x70]
01ed4d70  f44f46a9  ldp      x20, x19, [sp, #0x60]
01ed4d74  f65745a9  ldp      x22, x21, [sp, #0x50]
01ed4d78  f85f44a9  ldp      x24, x23, [sp, #0x40]
01ed4d7c  fa6743a9  ldp      x26, x25, [sp, #0x30]
01ed4d80  fc6f42a9  ldp      x28, x27, [sp, #0x20]
01ed4d84  ff030291  add      sp, sp, #0x80
01ed4d88  8cfdff17  b        #0x1ed43b8 ; BattleCore.FP$$op_UnaryNegation
01ed4d8c  000040f9  ldr      x0, [x0]
01ed4d90  c0035fd6  ret      
