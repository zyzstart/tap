; RVA 0x1ed4480, file offset 0x1ed4480, conservative end 0x1ed45b8
; SHA256 2a30997a722e5f10011b100b43c1042ec750383dd70f3fdb20c7c17100bd6dfe
; All aliases at this entry: BattleCore.FP$$Sqrt :: BattleCore_FP_o BattleCore_FP__Sqrt (BattleCore_FP_o x, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed4480  f44fbea9  stp      x20, x19, [sp, #-0x20]!
01ed4484  fd7b01a9  stp      x29, x30, [sp, #0x10]
01ed4488  fd430091  add      x29, sp, #0x10
01ed448c  94830090  adrp     x20, #0x2f44000
01ed4490  88e27e39  ldrb     w8, [x20, #0xfb8]
01ed4494  f30300aa  mov      x19, x0
01ed4498  e8000037  tbnz     w8, #0, #0x1ed44b4
01ed449c  886d00f0  adrp     x8, #0x2c87000
01ed44a0  08b541f9  ldr      x8, [x8, #0x368]
01ed44a4  000140b9  ldr      w0, [x8]
01ed44a8  a0c2b897  bl       #0xd04f28 ; unresolved symbol
01ed44ac  e8030032  mov      w8, #1
01ed44b0  88e23e39  strb     w8, [x20, #0xfb8]
01ed44b4  b305f8b7  tbnz     x19, #0x3f, #0x1ed4568
01ed44b8  68feb38a  bic      x8, x19, x19, asr #63
01ed44bc  e90342b2  mov      x9, #0x4000000000000000
01ed44c0  ec0309aa  mov      x12, x9
01ed44c4  9f0108eb  cmp      x12, x8
01ed44c8  89fd42d3  lsr      x9, x12, #2
01ed44cc  a8ffff54  b.hi     #0x1ed44c0
01ed44d0  e9031faa  mov      x9, xzr
01ed44d4  eb031f2a  mov      w11, wzr
01ed44d8  ea8361b2  mov      x10, #-0xffffffff80000000
01ed44dc  0f000014  b        #0x1ed4518
01ed44e0  0bfd60d3  lsr      x11, x8, #0x20
01ed44e4  2b0100b4  cbz      x11, #0x1ed4508
01ed44e8  ec030132  mov      w12, #-0xffffffff80000000
01ed44ec  0801094b  sub      w8, w8, w9
01ed44f0  2c7d60b3  bfi      x12, x9, #0x20, #0x20
01ed44f4  eb030032  mov      w11, #1
01ed44f8  4881088b  add      x8, x10, x8, lsl #32
01ed44fc  e9030caa  mov      x9, x12
01ed4500  ec030232  mov      w12, #0x40000000
01ed4504  05000014  b        #0x1ed4518
01ed4508  087d60d3  lsl      x8, x8, #0x20
01ed450c  297d60d3  lsl      x9, x9, #0x20
01ed4510  eb030032  mov      w11, #1
01ed4514  ec030232  mov      w12, #0x40000000
01ed4518  4c0100b4  cbz      x12, #0x1ed4540
01ed451c  2d010c8b  add      x13, x9, x12
01ed4520  0d010deb  subs     x13, x8, x13
01ed4524  62000054  b.hs     #0x1ed4530
01ed4528  29fd41d3  lsr      x9, x9, #1
01ed452c  03000014  b        #0x1ed4538
01ed4530  8905498b  add      x9, x12, x9, lsr #1
01ed4534  e8030daa  mov      x8, x13
01ed4538  8cfd42d3  lsr      x12, x12, #2
01ed453c  f7ffff17  b        #0x1ed4518
01ed4540  0bfdff34  cbz      w11, #0x1ed44e0
01ed4544  6b050011  add      w11, w11, #1
01ed4548  7f090071  cmp      w11, #2
01ed454c  ec031faa  mov      x12, xzr
01ed4550  41feff54  b.ne     #0x1ed4518
01ed4554  fd7b41a9  ldp      x29, x30, [sp, #0x10]
01ed4558  1f0109eb  cmp      x8, x9
01ed455c  2095899a  cinc     x0, x9, hi
01ed4560  f44fc2a8  ldp      x20, x19, [sp], #0x20
01ed4564  c0035fd6  ret      
01ed4568  487000b0  adrp     x8, #0x2cdd000
01ed456c  087547f9  ldr      x8, [x8, #0xee8]
01ed4570  000140f9  ldr      x0, [x8]
01ed4574  0191b997  bl       #0xd38978 ; unresolved symbol
01ed4578  086e00f0  adrp     x8, #0x2c97000
01ed457c  896d00d0  adrp     x9, #0x2c86000
01ed4580  084140f9  ldr      x8, [x8, #0x80]
01ed4584  290943f9  ldr      x9, [x9, #0x610]
01ed4588  e3031faa  mov      x3, xzr
01ed458c  f30300aa  mov      x19, x0
01ed4590  010140f9  ldr      x1, [x8]
01ed4594  220140f9  ldr      x2, [x9]
01ed4598  46e6ef97  bl       #0x1acdeb0 ; System.ArgumentOutOfRangeException$$.ctor
01ed459c  087000f0  adrp     x8, #0x2cd7000
01ed45a0  08d546f9  ldr      x8, [x8, #0xda8]
01ed45a4  e00313aa  mov      x0, x19
01ed45a8  e1031faa  mov      x1, xzr
01ed45ac  020140f9  ldr      x2, [x8]
01ed45b0  3b5cb997  bl       #0xd2b69c ; unresolved symbol
01ed45b4  ca2aba97  bl       #0xd5f0dc ; unresolved symbol
