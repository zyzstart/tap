; RVA 0x169c160, file offset 0x169c160, conservative end 0x169e2d0
; SHA256 adc8ff899dd36640efbb3910ee060e9f54fc8a599f68101ba9883acb3daa3073
; All aliases at this entry: A3BattleCore.SkillDamageHelper$$CalWeaponDamage :: void A3BattleCore_SkillDamageHelper__CalWeaponDamage (A3BattleCore_SkillDamageHelper_o* __this, A3BattleCore_HitInfo_o* hitInfo, A3BattleCore_DamageInfo_o* info, BattleCore_FP_o ratio, BattleCore_SkillAttrDamageData_o* damageAttr, BattleCore_FP_o fiveEleDamageRatio, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
0169c160  ff8302d1  sub      sp, sp, #0xa0
0169c164  fc6f04a9  stp      x28, x27, [sp, #0x40]
0169c168  fa6705a9  stp      x26, x25, [sp, #0x50]
0169c16c  f85f06a9  stp      x24, x23, [sp, #0x60]
0169c170  f65707a9  stp      x22, x21, [sp, #0x70]
0169c174  f44f08a9  stp      x20, x19, [sp, #0x80]
0169c178  fd7b09a9  stp      x29, x30, [sp, #0x90]
0169c17c  fd430291  add      x29, sp, #0x90
0169c180  19c500f0  adrp     x25, #0x2f3f000
0169c184  28ff7b39  ldrb     w8, [x25, #0xeff]
0169c188  f50305aa  mov      x21, x5
0169c18c  f60304aa  mov      x22, x4
0169c190  f80303aa  mov      x24, x3
0169c194  f30302aa  mov      x19, x2
0169c198  f40301aa  mov      x20, x1
0169c19c  f70300aa  mov      x23, x0
0169c1a0  e8000037  tbnz     w8, #0, #0x169c1bc
0169c1a4  e8b200d0  adrp     x8, #0x2cfa000
0169c1a8  087d40f9  ldr      x8, [x8, #0xf8]
0169c1ac  000140b9  ldr      w0, [x8]
0169c1b0  5ea3d997  bl       #0xd04f28 ; unresolved symbol
0169c1b4  e8030032  mov      w8, #1
0169c1b8  28ff3b39  strb     w8, [x25, #0xeff]
0169c1bc  ff7f03a9  stp      xzr, xzr, [sp, #0x30]
0169c1c0  730000b5  cbnz     x19, #0x169c1cc
0169c1c4  e0031faa  mov      x0, xzr
0169c1c8  593dda97  bl       #0xd2b72c ; unresolved symbol
0169c1cc  e00313aa  mov      x0, x19
0169c1d0  e1031faa  mov      x1, xzr
0169c1d4  9706fe97  bl       #0x161dc30 ; A3BattleCore.DamageInfo$$Reset
0169c1d8  940000b4  cbz      x20, #0x169c1e8
0169c1dc  fc0314aa  mov      x28, x20
0169c1e0  9a0f42f8  ldr      x26, [x28, #0x20]!
0169c1e4  07000014  b        #0x169c200
0169c1e8  e0031faa  mov      x0, xzr
0169c1ec  503dda97  bl       #0xd2b72c ; unresolved symbol
0169c1f0  fc031b32  mov      w28, #0x20
0169c1f4  9a0340f9  ldr      x26, [x28]
0169c1f8  e0031faa  mov      x0, xzr
0169c1fc  4c3dda97  bl       #0xd2b72c ; unresolved symbol
0169c200  990e40f9  ldr      x25, [x20, #0x18]
0169c204  e1031faa  mov      x1, xzr
0169c208  e2031faa  mov      x2, xzr
0169c20c  e00319aa  mov      x0, x25
0169c210  cac60294  bl       #0x174dd38 ; A3BattleCore.ActorEntity$$op_Equality
0169c214  c0150037  tbnz     w0, #0, #0x169c4cc
0169c218  e0031aaa  mov      x0, x26
0169c21c  e1031faa  mov      x1, xzr
0169c220  e2031faa  mov      x2, xzr
0169c224  c5c60294  bl       #0x174dd38 ; A3BattleCore.ActorEntity$$op_Equality
0169c228  20150037  tbnz     w0, #0, #0x169c4cc
0169c22c  760000b5  cbnz     x22, #0x169c238
0169c230  e0031faa  mov      x0, xzr
0169c234  3e3dda97  bl       #0xd2b72c ; unresolved symbol
0169c238  db1240b9  ldr      w27, [x22, #0x10]
0169c23c  931500b4  cbz      x19, #0x169c4ec
0169c240  fa0313aa  mov      x26, x19
0169c244  5b0f02b8  str      w27, [x26, #0x20]!
0169c248  7b040034  cbz      w27, #0x169c2d4
0169c24c  790000b5  cbnz     x25, #0x169c258
0169c250  e0031faa  mov      x0, xzr
0169c254  363dda97  bl       #0xd2b72c ; unresolved symbol
0169c258  e00319aa  mov      x0, x25
0169c25c  e1031faa  mov      x1, xzr
0169c260  e1d10294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169c264  f90300aa  mov      x25, x0
0169c268  590000b5  cbnz     x25, #0x169c270
0169c26c  303dda97  bl       #0xd2b72c ; unresolved symbol
0169c270  e00319aa  mov      x0, x25
0169c274  e1031faa  mov      x1, xzr
0169c278  dfd10294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169c27c  f90300aa  mov      x25, x0
0169c280  730000b5  cbnz     x19, #0x169c28c
0169c284  e0031faa  mov      x0, xzr
0169c288  293dda97  bl       #0xd2b72c ; unresolved symbol
0169c28c  420340b9  ldr      w2, [x26]
0169c290  e10319aa  mov      x1, x25
0169c294  0f080094  bl       #0x169e2d0 ; A3BattleCore.SkillDamageHelper$$GetMagicRatio
0169c298  08b100b0  adrp     x8, #0x2cbd000
0169c29c  08dd47f9  ldr      x8, [x8, #0xfb8]
0169c2a0  f90300aa  mov      x25, x0
0169c2a4  080140f9  ldr      x8, [x8]
0169c2a8  099d4439  ldrb     w9, [x8, #0x127]
0169c2ac  a9000836  tbz      w9, #1, #0x169c2c0
0169c2b0  09d940b9  ldr      w9, [x8, #0xd8]
0169c2b4  69000035  cbnz     w9, #0x169c2c0
0169c2b8  e00308aa  mov      x0, x8
0169c2bc  abdfd997  bl       #0xd14168 ; unresolved symbol
0169c2c0  e00318aa  mov      x0, x24
0169c2c4  e10319aa  mov      x1, x25
0169c2c8  e2031faa  mov      x2, xzr
0169c2cc  57df2094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169c2d0  f80300aa  mov      x24, x0
0169c2d4  c81640b9  ldr      w8, [x22, #0x14]
0169c2d8  08050051  sub      w8, w8, #1
0169c2dc  1f550071  cmp      w8, #0x15
0169c2e0  c8060054  b.hi     #0x169c3b8
0169c2e4  096800f0  adrp     x9, #0x239f000
0169c2e8  29313491  add      x9, x9, #0xd0c
0169c2ec  2879a8b8  ldrsw    x8, [x9, x8, lsl #2]
0169c2f0  0801098b  add      x8, x8, x9
0169c2f4  00011fd6  br       x8
0169c2f8  88b20090  adrp     x8, #0x2cec000
0169c2fc  080544f9  ldr      x8, [x8, #0x808]
0169c300  e1030032  mov      w1, #1
0169c304  000140f9  ldr      x0, [x8]
0169c308  9c87da97  bl       #0xd3e178 ; unresolved symbol
0169c30c  29b000b0  adrp     x9, #0x2ca1000
0169c310  c81640b9  ldr      w8, [x22, #0x14]
0169c314  294141f9  ldr      x9, [x9, #0x280]
0169c318  f40300aa  mov      x20, x0
0169c31c  e1b30091  add      x1, sp, #0x2c
0169c320  e82f00b9  str      w8, [sp, #0x2c]
0169c324  200140f9  ldr      x0, [x9]
0169c328  6d71da97  bl       #0xd388dc ; unresolved symbol
0169c32c  f50300aa  mov      x21, x0
0169c330  740000b5  cbnz     x20, #0x169c33c
0169c334  e0031faa  mov      x0, xzr
0169c338  fd3cda97  bl       #0xd2b72c ; unresolved symbol
0169c33c  550100b4  cbz      x21, #0x169c364
0169c340  880240f9  ldr      x8, [x20]
0169c344  e00315aa  mov      x0, x21
0169c348  012140f9  ldr      x1, [x8, #0x40]
0169c34c  3272da97  bl       #0xd38c14 ; unresolved symbol
0169c350  a00000b5  cbnz     x0, #0x169c364
0169c354  bd41da97  bl       #0xd2ca48 ; unresolved symbol
0169c358  e1031faa  mov      x1, xzr
0169c35c  e2031faa  mov      x2, xzr
0169c360  cf3cda97  bl       #0xd2b69c ; unresolved symbol
0169c364  881a40b9  ldr      w8, [x20, #0x18]
0169c368  a8000035  cbnz     w8, #0x169c37c
0169c36c  2940da97  bl       #0xd2c410 ; unresolved symbol
0169c370  e1031faa  mov      x1, xzr
0169c374  e2031faa  mov      x2, xzr
0169c378  c93cda97  bl       #0xd2b69c ; unresolved symbol
0169c37c  951200f9  str      x21, [x20, #0x20]
0169c380  68b200b0  adrp     x8, #0x2ce9000
0169c384  082542f9  ldr      x8, [x8, #0x448]
0169c388  000140f9  ldr      x0, [x8]
0169c38c  089c4439  ldrb     w8, [x0, #0x127]
0169c390  88000836  tbz      w8, #1, #0x169c3a0
0169c394  08d840b9  ldr      w8, [x0, #0xd8]
0169c398  48000035  cbnz     w8, #0x169c3a0
0169c39c  73dfd997  bl       #0xd14168 ; unresolved symbol
0169c3a0  68b10090  adrp     x8, #0x2cc8000
0169c3a4  088943f9  ldr      x8, [x8, #0x710]
0169c3a8  e10314aa  mov      x1, x20
0169c3ac  e2031faa  mov      x2, xzr
0169c3b0  000140f9  ldr      x0, [x8]
0169c3b4  10622d94  bl       #0x21f4bf4 ; DodGame.BLogger$$EditorFatal
0169c3b8  730000b5  cbnz     x19, #0x169c3c4
0169c3bc  e0031faa  mov      x0, xzr
0169c3c0  db3cda97  bl       #0xd2b72c ; unresolved symbol
0169c3c4  681240b9  ldr      w8, [x19, #0x10]
0169c3c8  1f050071  cmp      w8, #1
0169c3cc  0b080054  b.lt     #0x169c4cc
0169c3d0  800340f9  ldr      x0, [x28]
0169c3d4  e1031faa  mov      x1, xzr
0169c3d8  e2031faa  mov      x2, xzr
0169c3dc  08c10294  bl       #0x174c7fc ; A3BattleCore.ActorEntity$$op_Inequality
0169c3e0  60070036  tbz      w0, #0, #0x169c4cc
0169c3e4  940340f9  ldr      x20, [x28]
0169c3e8  740000b5  cbnz     x20, #0x169c3f4
0169c3ec  e0031faa  mov      x0, xzr
0169c3f0  cf3cda97  bl       #0xd2b72c ; unresolved symbol
0169c3f4  e00314aa  mov      x0, x20
0169c3f8  e1031faa  mov      x1, xzr
0169c3fc  7ad10294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169c400  f40300aa  mov      x20, x0
0169c404  540000b5  cbnz     x20, #0x169c40c
0169c408  c93cda97  bl       #0xd2b72c ; unresolved symbol
0169c40c  e00314aa  mov      x0, x20
0169c410  e1031faa  mov      x1, xzr
0169c414  78d10294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169c418  f40300aa  mov      x20, x0
0169c41c  540000b5  cbnz     x20, #0x169c424
0169c420  c33cda97  bl       #0xd2b72c ; unresolved symbol
0169c424  15b100b0  adrp     x21, #0x2cbd000
0169c428  b5de47f9  ldr      x21, [x21, #0xfb8]
0169c42c  94aa40f9  ldr      x20, [x20, #0x150]
0169c430  a00240f9  ldr      x0, [x21]
0169c434  089c4439  ldrb     w8, [x0, #0x127]
0169c438  a8000836  tbz      w8, #1, #0x169c44c
0169c43c  08d840b9  ldr      w8, [x0, #0xd8]
0169c440  68000035  cbnz     w8, #0x169c44c
0169c444  49dfd997  bl       #0xd14168 ; unresolved symbol
0169c448  a00240f9  ldr      x0, [x21]
0169c44c  085c40f9  ldr      x8, [x0, #0xb8]
0169c450  e00314aa  mov      x0, x20
0169c454  e2031faa  mov      x2, xzr
0169c458  011940f9  ldr      x1, [x8, #0x30]
0169c45c  fddf2094  bl       #0x1ed4450 ; BattleCore.FP$$op_GreaterThan
0169c460  60030036  tbz      w0, #0, #0x169c4cc
0169c464  a00240f9  ldr      x0, [x21]
0169c468  089c4439  ldrb     w8, [x0, #0x127]
0169c46c  a8000836  tbz      w8, #1, #0x169c480
0169c470  08d840b9  ldr      w8, [x0, #0xd8]
0169c474  68000035  cbnz     w8, #0x169c480
0169c478  3cdfd997  bl       #0xd14168 ; unresolved symbol
0169c47c  a00240f9  ldr      x0, [x21]
0169c480  085c40f9  ldr      x8, [x0, #0xb8]
0169c484  e00314aa  mov      x0, x20
0169c488  e2031faa  mov      x2, xzr
0169c48c  010d40f9  ldr      x1, [x8, #0x18]
0169c490  b1de2094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169c494  681240b9  ldr      w8, [x19, #0x10]
0169c498  f40300aa  mov      x20, x0
0169c49c  e1031faa  mov      x1, xzr
0169c4a0  e003082a  mov      w0, w8
0169c4a4  c3df2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169c4a8  e10300aa  mov      x1, x0
0169c4ac  e00314aa  mov      x0, x20
0169c4b0  e2031faa  mov      x2, xzr
0169c4b4  ddde2094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169c4b8  e01b00f9  str      x0, [sp, #0x30]
0169c4bc  e0c30091  add      x0, sp, #0x30
0169c4c0  e1031faa  mov      x1, xzr
0169c4c4  a7e32094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169c4c8  601200b9  str      w0, [x19, #0x10]
0169c4cc  fd7b49a9  ldp      x29, x30, [sp, #0x90]
0169c4d0  f44f48a9  ldp      x20, x19, [sp, #0x80]
0169c4d4  f65747a9  ldp      x22, x21, [sp, #0x70]
0169c4d8  f85f46a9  ldp      x24, x23, [sp, #0x60]
0169c4dc  fa6745a9  ldp      x26, x25, [sp, #0x50]
0169c4e0  fc6f44a9  ldp      x28, x27, [sp, #0x40]
0169c4e4  ff830291  add      sp, sp, #0xa0
0169c4e8  c0035fd6  ret      
0169c4ec  e0031faa  mov      x0, xzr
0169c4f0  8f3cda97  bl       #0xd2b72c ; unresolved symbol
0169c4f4  fa031b32  mov      w26, #0x20
0169c4f8  e0031faa  mov      x0, xzr
0169c4fc  5b0300b9  str      w27, [x26]
0169c500  8b3cda97  bl       #0xd2b72c ; unresolved symbol
0169c504  5b0340b9  ldr      w27, [x26]
0169c508  3beaff35  cbnz     w27, #0x169c24c
0169c50c  72ffff17  b        #0x169c2d4
0169c510  08b100b0  adrp     x8, #0x2cbd000
0169c514  08dd47f9  ldr      x8, [x8, #0xfb8]
0169c518  d90e40f9  ldr      x25, [x22, #0x18]
0169c51c  000140f9  ldr      x0, [x8]
0169c520  089c4439  ldrb     w8, [x0, #0x127]
0169c524  88000836  tbz      w8, #1, #0x169c534
0169c528  08d840b9  ldr      w8, [x0, #0xd8]
0169c52c  48000035  cbnz     w8, #0x169c534
0169c530  0edfd997  bl       #0xd14168 ; unresolved symbol
0169c534  e00318aa  mov      x0, x24
0169c538  e10319aa  mov      x1, x25
0169c53c  e2031faa  mov      x2, xzr
0169c540  bade2094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169c544  c81240f9  ldr      x8, [x22, #0x20]
0169c548  980e40f9  ldr      x24, [x20, #0x18]
0169c54c  990340f9  ldr      x25, [x28]
0169c550  f60300aa  mov      x22, x0
0169c554  e00308aa  mov      x0, x8
0169c558  e1031faa  mov      x1, xzr
0169c55c  36e12094  bl       #0x1ed4a34 ; BattleCore.FP$$op_Explicit
0169c560  e1031faa  mov      x1, xzr
0169c564  93df2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169c568  e70300aa  mov      x7, x0
0169c56c  e5030032  mov      w5, #1
0169c570  e00317aa  mov      x0, x23
0169c574  e10318aa  mov      x1, x24
0169c578  e20319aa  mov      x2, x25
0169c57c  e30314aa  mov      x3, x20
0169c580  e40313aa  mov      x4, x19
0169c584  f50300f9  str      x21, [sp]
0169c588  1f000014  b        #0x169c604
0169c58c  08b100b0  adrp     x8, #0x2cbd000
0169c590  08dd47f9  ldr      x8, [x8, #0xfb8]
0169c594  d90e40f9  ldr      x25, [x22, #0x18]
0169c598  000140f9  ldr      x0, [x8]
0169c59c  089c4439  ldrb     w8, [x0, #0x127]
0169c5a0  88000836  tbz      w8, #1, #0x169c5b0
0169c5a4  08d840b9  ldr      w8, [x0, #0xd8]
0169c5a8  48000035  cbnz     w8, #0x169c5b0
0169c5ac  efded997  bl       #0xd14168 ; unresolved symbol
0169c5b0  e00318aa  mov      x0, x24
0169c5b4  e10319aa  mov      x1, x25
0169c5b8  e2031faa  mov      x2, xzr
0169c5bc  9bde2094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169c5c0  c81240f9  ldr      x8, [x22, #0x20]
0169c5c4  980e40f9  ldr      x24, [x20, #0x18]
0169c5c8  990340f9  ldr      x25, [x28]
0169c5cc  f60300aa  mov      x22, x0
0169c5d0  e00308aa  mov      x0, x8
0169c5d4  e1031faa  mov      x1, xzr
0169c5d8  17e12094  bl       #0x1ed4a34 ; BattleCore.FP$$op_Explicit
0169c5dc  e1031faa  mov      x1, xzr
0169c5e0  74df2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169c5e4  e70300aa  mov      x7, x0
0169c5e8  f50300f9  str      x21, [sp]
0169c5ec  e00317aa  mov      x0, x23
0169c5f0  e10318aa  mov      x1, x24
0169c5f4  e20319aa  mov      x2, x25
0169c5f8  e30314aa  mov      x3, x20
0169c5fc  e40313aa  mov      x4, x19
0169c600  e5031f2a  mov      w5, wzr
0169c604  e60316aa  mov      x6, x22
0169c608  6d070094  bl       #0x169e3bc ; A3BattleCore.SkillDamageHelper$$DoCalcWeaponDamage
0169c60c  d3edffb5  cbnz     x19, #0x169c3c4
0169c610  6bffff17  b        #0x169c3bc
0169c614  08b100b0  adrp     x8, #0x2cbd000
0169c618  08dd47f9  ldr      x8, [x8, #0xfb8]
0169c61c  9a0e40f9  ldr      x26, [x20, #0x18]
0169c620  990340f9  ldr      x25, [x28]
0169c624  d61240f9  ldr      x22, [x22, #0x20]
0169c628  000140f9  ldr      x0, [x8]
0169c62c  089c4439  ldrb     w8, [x0, #0x127]
0169c630  88000836  tbz      w8, #1, #0x169c640
0169c634  08d840b9  ldr      w8, [x0, #0xd8]
0169c638  48000035  cbnz     w8, #0x169c640
0169c63c  cbded997  bl       #0xd14168 ; unresolved symbol
0169c640  e00316aa  mov      x0, x22
0169c644  e1031faa  mov      x1, xzr
0169c648  fbe02094  bl       #0x1ed4a34 ; BattleCore.FP$$op_Explicit
0169c64c  e1031faa  mov      x1, xzr
0169c650  58df2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169c654  e70300aa  mov      x7, x0
0169c658  e00317aa  mov      x0, x23
0169c65c  e1031aaa  mov      x1, x26
0169c660  e20319aa  mov      x2, x25
0169c664  e30314aa  mov      x3, x20
0169c668  e40313aa  mov      x4, x19
0169c66c  e5031f2a  mov      w5, wzr
0169c670  e60318aa  mov      x6, x24
0169c674  2c030014  b        #0x169d324
0169c678  08b100b0  adrp     x8, #0x2cbd000
0169c67c  08dd47f9  ldr      x8, [x8, #0xfb8]
0169c680  990e40f9  ldr      x25, [x20, #0x18]
0169c684  950340f9  ldr      x21, [x28]
0169c688  d61240f9  ldr      x22, [x22, #0x20]
0169c68c  000140f9  ldr      x0, [x8]
0169c690  089c4439  ldrb     w8, [x0, #0x127]
0169c694  88000836  tbz      w8, #1, #0x169c6a4
0169c698  08d840b9  ldr      w8, [x0, #0xd8]
0169c69c  48000035  cbnz     w8, #0x169c6a4
0169c6a0  b2ded997  bl       #0xd14168 ; unresolved symbol
0169c6a4  e00316aa  mov      x0, x22
0169c6a8  e1031faa  mov      x1, xzr
0169c6ac  e2e02094  bl       #0x1ed4a34 ; BattleCore.FP$$op_Explicit
0169c6b0  e1031faa  mov      x1, xzr
0169c6b4  3fdf2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169c6b8  e70300aa  mov      x7, x0
0169c6bc  e00317aa  mov      x0, x23
0169c6c0  e10319aa  mov      x1, x25
0169c6c4  e20315aa  mov      x2, x21
0169c6c8  e30314aa  mov      x3, x20
0169c6cc  e40313aa  mov      x4, x19
0169c6d0  e5031f2a  mov      w5, wzr
0169c6d4  e60318aa  mov      x6, x24
0169c6d8  b60d0094  bl       #0x169fdb0 ; A3BattleCore.SkillDamageHelper$$DoCalcWeaponDamageWithPercent
0169c6dc  53e7ffb5  cbnz     x19, #0x169c3c4
0169c6e0  37ffff17  b        #0x169c3bc
0169c6e4  08b100b0  adrp     x8, #0x2cbd000
0169c6e8  08dd47f9  ldr      x8, [x8, #0xfb8]
0169c6ec  000140f9  ldr      x0, [x8]
0169c6f0  089c4439  ldrb     w8, [x0, #0x127]
0169c6f4  88000836  tbz      w8, #1, #0x169c704
0169c6f8  08d840b9  ldr      w8, [x0, #0xd8]
0169c6fc  48000035  cbnz     w8, #0x169c704
0169c700  9aded997  bl       #0xd14168 ; unresolved symbol
0169c704  e0031f2a  mov      w0, wzr
0169c708  e1031faa  mov      x1, xzr
0169c70c  29df2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169c710  f90300aa  mov      x25, x0
0169c714  e0031f2a  mov      w0, wzr
0169c718  e1031faa  mov      x1, xzr
0169c71c  25df2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169c720  da1240f9  ldr      x26, [x22, #0x20]
0169c724  fb0300aa  mov      x27, x0
0169c728  c0a20091  add      x0, x22, #0x28
0169c72c  e1031faa  mov      x1, xzr
0169c730  0ce32094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169c734  08d40051  sub      w8, w0, #0x35
0169c738  1f190071  cmp      w8, #6
0169c73c  e8570054  b.hi     #0x169d238
0169c740  096800f0  adrp     x9, #0x239f000
0169c744  29713691  add      x9, x9, #0xd9c
0169c748  2879a8b8  ldrsw    x8, [x9, x8, lsl #2]
0169c74c  0801098b  add      x8, x8, x9
0169c750  00011fd6  br       x8
0169c754  990340f9  ldr      x25, [x28]
0169c758  790000b5  cbnz     x25, #0x169c764
0169c75c  e0031faa  mov      x0, xzr
0169c760  f33bda97  bl       #0xd2b72c ; unresolved symbol
0169c764  e00319aa  mov      x0, x25
0169c768  e1031faa  mov      x1, xzr
0169c76c  9ed00294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169c770  f90300aa  mov      x25, x0
0169c774  590000b5  cbnz     x25, #0x169c77c
0169c778  ed3bda97  bl       #0xd2b72c ; unresolved symbol
0169c77c  e00319aa  mov      x0, x25
0169c780  e1031faa  mov      x1, xzr
0169c784  9cd00294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169c788  f90300aa  mov      x25, x0
0169c78c  590000b5  cbnz     x25, #0x169c794
0169c790  e73bda97  bl       #0xd2b72c ; unresolved symbol
0169c794  9b0e40f9  ldr      x27, [x20, #0x18]
0169c798  39cf40f9  ldr      x25, [x25, #0x198]
0169c79c  7b0000b5  cbnz     x27, #0x169c7a8
0169c7a0  e0031faa  mov      x0, xzr
0169c7a4  e23bda97  bl       #0xd2b72c ; unresolved symbol
0169c7a8  e0031baa  mov      x0, x27
0169c7ac  e1031faa  mov      x1, xzr
0169c7b0  8dd00294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169c7b4  fb0300aa  mov      x27, x0
0169c7b8  5b0000b5  cbnz     x27, #0x169c7c0
0169c7bc  dc3bda97  bl       #0xd2b72c ; unresolved symbol
0169c7c0  e0031baa  mov      x0, x27
0169c7c4  e1031faa  mov      x1, xzr
0169c7c8  8bd00294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169c7cc  fb0300aa  mov      x27, x0
0169c7d0  5b0000b5  cbnz     x27, #0x169c7d8
0169c7d4  d63bda97  bl       #0xd2b72c ; unresolved symbol
0169c7d8  7bbb40f9  ldr      x27, [x27, #0x170]
0169c7dc  535300b5  cbnz     x19, #0x169d244
0169c7e0  97020014  b        #0x169d23c
0169c7e4  1ab100b0  adrp     x26, #0x2cbd000
0169c7e8  5adf47f9  ldr      x26, [x26, #0xfb8]
0169c7ec  400340f9  ldr      x0, [x26]
0169c7f0  089c4439  ldrb     w8, [x0, #0x127]
0169c7f4  88000836  tbz      w8, #1, #0x169c804
0169c7f8  08d840b9  ldr      w8, [x0, #0xd8]
0169c7fc  48000035  cbnz     w8, #0x169c804
0169c800  5aded997  bl       #0xd14168 ; unresolved symbol
0169c804  e0031f2a  mov      w0, wzr
0169c808  e1031faa  mov      x1, xzr
0169c80c  e9de2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169c810  f70300aa  mov      x23, x0
0169c814  e0031f2a  mov      w0, wzr
0169c818  e1031faa  mov      x1, xzr
0169c81c  e5de2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169c820  d81240f9  ldr      x24, [x22, #0x20]
0169c824  f90300aa  mov      x25, x0
0169c828  c0a20091  add      x0, x22, #0x28
0169c82c  e1031faa  mov      x1, xzr
0169c830  cce22094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169c834  08d40051  sub      w8, w0, #0x35
0169c838  1f190071  cmp      w8, #6
0169c83c  88840054  b.hi     #0x169d8cc
0169c840  096800f0  adrp     x9, #0x239f000
0169c844  29013691  add      x9, x9, #0xd80
0169c848  2879a8b8  ldrsw    x8, [x9, x8, lsl #2]
0169c84c  0801098b  add      x8, x8, x9
0169c850  00011fd6  br       x8
0169c854  970340f9  ldr      x23, [x28]
0169c858  770000b5  cbnz     x23, #0x169c864
0169c85c  e0031faa  mov      x0, xzr
0169c860  b33bda97  bl       #0xd2b72c ; unresolved symbol
0169c864  e00317aa  mov      x0, x23
0169c868  e1031faa  mov      x1, xzr
0169c86c  5ed00294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169c870  f70300aa  mov      x23, x0
0169c874  570000b5  cbnz     x23, #0x169c87c
0169c878  ad3bda97  bl       #0xd2b72c ; unresolved symbol
0169c87c  e00317aa  mov      x0, x23
0169c880  e1031faa  mov      x1, xzr
0169c884  5cd00294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169c888  f70300aa  mov      x23, x0
0169c88c  570000b5  cbnz     x23, #0x169c894
0169c890  a73bda97  bl       #0xd2b72c ; unresolved symbol
0169c894  990e40f9  ldr      x25, [x20, #0x18]
0169c898  f7ce40f9  ldr      x23, [x23, #0x198]
0169c89c  790000b5  cbnz     x25, #0x169c8a8
0169c8a0  e0031faa  mov      x0, xzr
0169c8a4  a23bda97  bl       #0xd2b72c ; unresolved symbol
0169c8a8  e00319aa  mov      x0, x25
0169c8ac  e1031faa  mov      x1, xzr
0169c8b0  4dd00294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169c8b4  f90300aa  mov      x25, x0
0169c8b8  590000b5  cbnz     x25, #0x169c8c0
0169c8bc  9c3bda97  bl       #0xd2b72c ; unresolved symbol
0169c8c0  e00319aa  mov      x0, x25
0169c8c4  e1031faa  mov      x1, xzr
0169c8c8  4bd00294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169c8cc  f90300aa  mov      x25, x0
0169c8d0  590000b5  cbnz     x25, #0x169c8d8
0169c8d4  963bda97  bl       #0xd2b72c ; unresolved symbol
0169c8d8  39bb40f9  ldr      x25, [x25, #0x170]
0169c8dc  fc030014  b        #0x169d8cc
0169c8e0  1bb100b0  adrp     x27, #0x2cbd000
0169c8e4  7bdf47f9  ldr      x27, [x27, #0xfb8]
0169c8e8  600340f9  ldr      x0, [x27]
0169c8ec  089c4439  ldrb     w8, [x0, #0x127]
0169c8f0  88000836  tbz      w8, #1, #0x169c900
0169c8f4  08d840b9  ldr      w8, [x0, #0xd8]
0169c8f8  48000035  cbnz     w8, #0x169c900
0169c8fc  1bded997  bl       #0xd14168 ; unresolved symbol
0169c900  e0031f2a  mov      w0, wzr
0169c904  e1031faa  mov      x1, xzr
0169c908  aade2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169c90c  d71240f9  ldr      x23, [x22, #0x20]
0169c910  f80300aa  mov      x24, x0
0169c914  e0031f2a  mov      w0, wzr
0169c918  e1031faa  mov      x1, xzr
0169c91c  a5de2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169c920  f90300aa  mov      x25, x0
0169c924  c0a20091  add      x0, x22, #0x28
0169c928  e1031faa  mov      x1, xzr
0169c92c  8de22094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169c930  08d40051  sub      w8, w0, #0x35
0169c934  1f190071  cmp      w8, #6
0169c938  88ad0054  b.hi     #0x169dee8
0169c93c  096800f0  adrp     x9, #0x239f000
0169c940  29913591  add      x9, x9, #0xd64
0169c944  2879a8b8  ldrsw    x8, [x9, x8, lsl #2]
0169c948  0801098b  add      x8, x8, x9
0169c94c  00011fd6  br       x8
0169c950  980340f9  ldr      x24, [x28]
0169c954  780000b5  cbnz     x24, #0x169c960
0169c958  e0031faa  mov      x0, xzr
0169c95c  743bda97  bl       #0xd2b72c ; unresolved symbol
0169c960  e00318aa  mov      x0, x24
0169c964  e1031faa  mov      x1, xzr
0169c968  1fd00294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169c96c  f80300aa  mov      x24, x0
0169c970  580000b5  cbnz     x24, #0x169c978
0169c974  6e3bda97  bl       #0xd2b72c ; unresolved symbol
0169c978  e00318aa  mov      x0, x24
0169c97c  e1031faa  mov      x1, xzr
0169c980  1dd00294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169c984  f80300aa  mov      x24, x0
0169c988  580000b5  cbnz     x24, #0x169c990
0169c98c  683bda97  bl       #0xd2b72c ; unresolved symbol
0169c990  990e40f9  ldr      x25, [x20, #0x18]
0169c994  18cf40f9  ldr      x24, [x24, #0x198]
0169c998  790000b5  cbnz     x25, #0x169c9a4
0169c99c  e0031faa  mov      x0, xzr
0169c9a0  633bda97  bl       #0xd2b72c ; unresolved symbol
0169c9a4  e00319aa  mov      x0, x25
0169c9a8  e1031faa  mov      x1, xzr
0169c9ac  0ed00294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169c9b0  f90300aa  mov      x25, x0
0169c9b4  590000b5  cbnz     x25, #0x169c9bc
0169c9b8  5d3bda97  bl       #0xd2b72c ; unresolved symbol
0169c9bc  e00319aa  mov      x0, x25
0169c9c0  e1031faa  mov      x1, xzr
0169c9c4  0cd00294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169c9c8  f90300aa  mov      x25, x0
0169c9cc  590000b5  cbnz     x25, #0x169c9d4
0169c9d0  573bda97  bl       #0xd2b72c ; unresolved symbol
0169c9d4  39bb40f9  ldr      x25, [x25, #0x170]
0169c9d8  f3a800b5  cbnz     x19, #0x169def4
0169c9dc  44050014  b        #0x169deec
0169c9e0  18b100b0  adrp     x24, #0x2cbd000
0169c9e4  18df47f9  ldr      x24, [x24, #0xfb8]
0169c9e8  000340f9  ldr      x0, [x24]
0169c9ec  089c4439  ldrb     w8, [x0, #0x127]
0169c9f0  88000836  tbz      w8, #1, #0x169ca00
0169c9f4  08d840b9  ldr      w8, [x0, #0xd8]
0169c9f8  48000035  cbnz     w8, #0x169ca00
0169c9fc  dbddd997  bl       #0xd14168 ; unresolved symbol
0169ca00  e0031f2a  mov      w0, wzr
0169ca04  e1031faa  mov      x1, xzr
0169ca08  6ade2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169ca0c  e01300f9  str      x0, [sp, #0x20]
0169ca10  e0031f2a  mov      w0, wzr
0169ca14  e1031faa  mov      x1, xzr
0169ca18  66de2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169ca1c  e00f00f9  str      x0, [sp, #0x18]
0169ca20  e0031f2a  mov      w0, wzr
0169ca24  e1031faa  mov      x1, xzr
0169ca28  62de2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169ca2c  f90300aa  mov      x25, x0
0169ca30  e0031f2a  mov      w0, wzr
0169ca34  e1031faa  mov      x1, xzr
0169ca38  5ede2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169ca3c  080340f9  ldr      x8, [x24]
0169ca40  c90e40f9  ldr      x9, [x22, #0x18]
0169ca44  f50300aa  mov      x21, x0
0169ca48  c0a20091  add      x0, x22, #0x28
0169ca4c  085d40f9  ldr      x8, [x8, #0xb8]
0169ca50  e90b00f9  str      x9, [sp, #0x10]
0169ca54  da1240f9  ldr      x26, [x22, #0x20]
0169ca58  e1031faa  mov      x1, xzr
0169ca5c  1b0d40f9  ldr      x27, [x8, #0x18]
0169ca60  40e22094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169ca64  960e40f9  ldr      x22, [x20, #0x18]
0169ca68  f803002a  mov      w24, w0
0169ca6c  760000b5  cbnz     x22, #0x169ca78
0169ca70  e0031faa  mov      x0, xzr
0169ca74  2e3bda97  bl       #0xd2b72c ; unresolved symbol
0169ca78  e00316aa  mov      x0, x22
0169ca7c  e1031faa  mov      x1, xzr
0169ca80  d9cf0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169ca84  f60300aa  mov      x22, x0
0169ca88  560000b5  cbnz     x22, #0x169ca90
0169ca8c  283bda97  bl       #0xd2b72c ; unresolved symbol
0169ca90  e00316aa  mov      x0, x22
0169ca94  e1031faa  mov      x1, xzr
0169ca98  d7cf0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169ca9c  1f0f0171  cmp      w24, #0x43
0169caa0  f60300aa  mov      x22, x0
0169caa4  0d040054  b.le     #0x169cb24
0169caa8  1f1f0171  cmp      w24, #0x47
0169caac  20080054  b.eq     #0x169cbb0
0169cab0  1f2f0171  cmp      w24, #0x4b
0169cab4  61070054  b.ne     #0x169cba0
0169cab8  950340f9  ldr      x21, [x28]
0169cabc  f8031aaa  mov      x24, x26
0169cac0  750000b5  cbnz     x21, #0x169cacc
0169cac4  e0031faa  mov      x0, xzr
0169cac8  193bda97  bl       #0xd2b72c ; unresolved symbol
0169cacc  e00315aa  mov      x0, x21
0169cad0  e1031faa  mov      x1, xzr
0169cad4  c4cf0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169cad8  1ab100b0  adrp     x26, #0x2cbd000
0169cadc  5adf47f9  ldr      x26, [x26, #0xfb8]
0169cae0  f50300aa  mov      x21, x0
0169cae4  550000b5  cbnz     x21, #0x169caec
0169cae8  113bda97  bl       #0xd2b72c ; unresolved symbol
0169caec  e00315aa  mov      x0, x21
0169caf0  e1031faa  mov      x1, xzr
0169caf4  c0cf0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169caf8  f50300aa  mov      x21, x0
0169cafc  550000b5  cbnz     x21, #0x169cb04
0169cb00  0b3bda97  bl       #0xd2b72c ; unresolved symbol
0169cb04  a82241f9  ldr      x8, [x21, #0x240]
0169cb08  e80f00f9  str      x8, [sp, #0x18]
0169cb0c  56a800b4  cbz      x22, #0x169e014
0169cb10  d57241f9  ldr      x21, [x22, #0x2e0]
0169cb14  c81e41f9  ldr      x8, [x22, #0x238]
0169cb18  f90315aa  mov      x25, x21
0169cb1c  e81300f9  str      x8, [sp, #0x20]
0169cb20  4b050014  b        #0x169e04c
0169cb24  1fff0071  cmp      w24, #0x3f
0169cb28  a0070054  b.eq     #0x169cc1c
0169cb2c  1f0f0171  cmp      w24, #0x43
0169cb30  81030054  b.ne     #0x169cba0
0169cb34  950340f9  ldr      x21, [x28]
0169cb38  f8031aaa  mov      x24, x26
0169cb3c  750000b5  cbnz     x21, #0x169cb48
0169cb40  e0031faa  mov      x0, xzr
0169cb44  fa3ada97  bl       #0xd2b72c ; unresolved symbol
0169cb48  e00315aa  mov      x0, x21
0169cb4c  e1031faa  mov      x1, xzr
0169cb50  a5cf0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169cb54  1ab100b0  adrp     x26, #0x2cbd000
0169cb58  5adf47f9  ldr      x26, [x26, #0xfb8]
0169cb5c  f50300aa  mov      x21, x0
0169cb60  550000b5  cbnz     x21, #0x169cb68
0169cb64  f23ada97  bl       #0xd2b72c ; unresolved symbol
0169cb68  e00315aa  mov      x0, x21
0169cb6c  e1031faa  mov      x1, xzr
0169cb70  a1cf0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169cb74  f50300aa  mov      x21, x0
0169cb78  550000b5  cbnz     x21, #0x169cb80
0169cb7c  ec3ada97  bl       #0xd2b72c ; unresolved symbol
0169cb80  a80241f9  ldr      x8, [x21, #0x200]
0169cb84  e80f00f9  str      x8, [sp, #0x18]
0169cb88  96a600b4  cbz      x22, #0x169e058
0169cb8c  c8fe40f9  ldr      x8, [x22, #0x1f8]
0169cb90  e81300f9  str      x8, [sp, #0x20]
0169cb94  d96241f9  ldr      x25, [x22, #0x2c0]
0169cb98  d56641f9  ldr      x21, [x22, #0x2c8]
0169cb9c  3e050014  b        #0x169e094
0169cba0  f8031aaa  mov      x24, x26
0169cba4  1ab100b0  adrp     x26, #0x2cbd000
0169cba8  5adf47f9  ldr      x26, [x26, #0xfb8]
0169cbac  5f050014  b        #0x169e128
0169cbb0  950340f9  ldr      x21, [x28]
0169cbb4  750000b5  cbnz     x21, #0x169cbc0
0169cbb8  e0031faa  mov      x0, xzr
0169cbbc  dc3ada97  bl       #0xd2b72c ; unresolved symbol
0169cbc0  e00315aa  mov      x0, x21
0169cbc4  e1031faa  mov      x1, xzr
0169cbc8  87cf0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169cbcc  f50300aa  mov      x21, x0
0169cbd0  f8031aaa  mov      x24, x26
0169cbd4  550000b5  cbnz     x21, #0x169cbdc
0169cbd8  d53ada97  bl       #0xd2b72c ; unresolved symbol
0169cbdc  e00315aa  mov      x0, x21
0169cbe0  e1031faa  mov      x1, xzr
0169cbe4  84cf0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169cbe8  1ab100b0  adrp     x26, #0x2cbd000
0169cbec  5adf47f9  ldr      x26, [x26, #0xfb8]
0169cbf0  f50300aa  mov      x21, x0
0169cbf4  550000b5  cbnz     x21, #0x169cbfc
0169cbf8  cd3ada97  bl       #0xd2b72c ; unresolved symbol
0169cbfc  a81241f9  ldr      x8, [x21, #0x220]
0169cc00  e80f00f9  str      x8, [sp, #0x18]
0169cc04  f6a400b4  cbz      x22, #0x169e0a0
0169cc08  c80e41f9  ldr      x8, [x22, #0x218]
0169cc0c  e81300f9  str      x8, [sp, #0x20]
0169cc10  d96a41f9  ldr      x25, [x22, #0x2d0]
0169cc14  d56e41f9  ldr      x21, [x22, #0x2d8]
0169cc18  31050014  b        #0x169e0dc
0169cc1c  950340f9  ldr      x21, [x28]
0169cc20  750000b5  cbnz     x21, #0x169cc2c
0169cc24  e0031faa  mov      x0, xzr
0169cc28  c13ada97  bl       #0xd2b72c ; unresolved symbol
0169cc2c  e00315aa  mov      x0, x21
0169cc30  e1031faa  mov      x1, xzr
0169cc34  6ccf0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169cc38  f50300aa  mov      x21, x0
0169cc3c  f8031aaa  mov      x24, x26
0169cc40  550000b5  cbnz     x21, #0x169cc48
0169cc44  ba3ada97  bl       #0xd2b72c ; unresolved symbol
0169cc48  e00315aa  mov      x0, x21
0169cc4c  e1031faa  mov      x1, xzr
0169cc50  69cf0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169cc54  1ab100b0  adrp     x26, #0x2cbd000
0169cc58  5adf47f9  ldr      x26, [x26, #0xfb8]
0169cc5c  f50300aa  mov      x21, x0
0169cc60  550000b5  cbnz     x21, #0x169cc68
0169cc64  b23ada97  bl       #0xd2b72c ; unresolved symbol
0169cc68  a8f240f9  ldr      x8, [x21, #0x1e0]
0169cc6c  e80f00f9  str      x8, [sp, #0x18]
0169cc70  d6a300b4  cbz      x22, #0x169e0e8
0169cc74  c8ee40f9  ldr      x8, [x22, #0x1d8]
0169cc78  e81300f9  str      x8, [sp, #0x20]
0169cc7c  d95a41f9  ldr      x25, [x22, #0x2b0]
0169cc80  d55e41f9  ldr      x21, [x22, #0x2b8]
0169cc84  28050014  b        #0x169e124
0169cc88  990340f9  ldr      x25, [x28]
0169cc8c  790000b5  cbnz     x25, #0x169cc98
0169cc90  e0031faa  mov      x0, xzr
0169cc94  a63ada97  bl       #0xd2b72c ; unresolved symbol
0169cc98  e00319aa  mov      x0, x25
0169cc9c  e1031faa  mov      x1, xzr
0169cca0  51cf0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169cca4  f90300aa  mov      x25, x0
0169cca8  590000b5  cbnz     x25, #0x169ccb0
0169ccac  a03ada97  bl       #0xd2b72c ; unresolved symbol
0169ccb0  e00319aa  mov      x0, x25
0169ccb4  e1031faa  mov      x1, xzr
0169ccb8  4fcf0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169ccbc  f90300aa  mov      x25, x0
0169ccc0  590000b5  cbnz     x25, #0x169ccc8
0169ccc4  9a3ada97  bl       #0xd2b72c ; unresolved symbol
0169ccc8  9b0e40f9  ldr      x27, [x20, #0x18]
0169cccc  39d340f9  ldr      x25, [x25, #0x1a0]
0169ccd0  7b0000b5  cbnz     x27, #0x169ccdc
0169ccd4  e0031faa  mov      x0, xzr
0169ccd8  953ada97  bl       #0xd2b72c ; unresolved symbol
0169ccdc  e0031baa  mov      x0, x27
0169cce0  e1031faa  mov      x1, xzr
0169cce4  40cf0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169cce8  fb0300aa  mov      x27, x0
0169ccec  5b0000b5  cbnz     x27, #0x169ccf4
0169ccf0  8f3ada97  bl       #0xd2b72c ; unresolved symbol
0169ccf4  e0031baa  mov      x0, x27
0169ccf8  e1031faa  mov      x1, xzr
0169ccfc  3ecf0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169cd00  fb0300aa  mov      x27, x0
0169cd04  5b0000b5  cbnz     x27, #0x169cd0c
0169cd08  893ada97  bl       #0xd2b72c ; unresolved symbol
0169cd0c  7bbf40f9  ldr      x27, [x27, #0x178]
0169cd10  b32900b5  cbnz     x19, #0x169d244
0169cd14  4a010014  b        #0x169d23c
0169cd18  990340f9  ldr      x25, [x28]
0169cd1c  790000b5  cbnz     x25, #0x169cd28
0169cd20  e0031faa  mov      x0, xzr
0169cd24  823ada97  bl       #0xd2b72c ; unresolved symbol
0169cd28  e00319aa  mov      x0, x25
0169cd2c  e1031faa  mov      x1, xzr
0169cd30  2dcf0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169cd34  f90300aa  mov      x25, x0
0169cd38  590000b5  cbnz     x25, #0x169cd40
0169cd3c  7c3ada97  bl       #0xd2b72c ; unresolved symbol
0169cd40  e00319aa  mov      x0, x25
0169cd44  e1031faa  mov      x1, xzr
0169cd48  2bcf0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169cd4c  f90300aa  mov      x25, x0
0169cd50  590000b5  cbnz     x25, #0x169cd58
0169cd54  763ada97  bl       #0xd2b72c ; unresolved symbol
0169cd58  9b0e40f9  ldr      x27, [x20, #0x18]
0169cd5c  39d740f9  ldr      x25, [x25, #0x1a8]
0169cd60  7b0000b5  cbnz     x27, #0x169cd6c
0169cd64  e0031faa  mov      x0, xzr
0169cd68  713ada97  bl       #0xd2b72c ; unresolved symbol
0169cd6c  e0031baa  mov      x0, x27
0169cd70  e1031faa  mov      x1, xzr
0169cd74  1ccf0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169cd78  fb0300aa  mov      x27, x0
0169cd7c  5b0000b5  cbnz     x27, #0x169cd84
0169cd80  6b3ada97  bl       #0xd2b72c ; unresolved symbol
0169cd84  e0031baa  mov      x0, x27
0169cd88  e1031faa  mov      x1, xzr
0169cd8c  1acf0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169cd90  fb0300aa  mov      x27, x0
0169cd94  5b0000b5  cbnz     x27, #0x169cd9c
0169cd98  653ada97  bl       #0xd2b72c ; unresolved symbol
0169cd9c  7bc340f9  ldr      x27, [x27, #0x180]
0169cda0  332500b5  cbnz     x19, #0x169d244
0169cda4  26010014  b        #0x169d23c
0169cda8  990340f9  ldr      x25, [x28]
0169cdac  790000b5  cbnz     x25, #0x169cdb8
0169cdb0  e0031faa  mov      x0, xzr
0169cdb4  5e3ada97  bl       #0xd2b72c ; unresolved symbol
0169cdb8  e00319aa  mov      x0, x25
0169cdbc  e1031faa  mov      x1, xzr
0169cdc0  09cf0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169cdc4  f90300aa  mov      x25, x0
0169cdc8  590000b5  cbnz     x25, #0x169cdd0
0169cdcc  583ada97  bl       #0xd2b72c ; unresolved symbol
0169cdd0  e00319aa  mov      x0, x25
0169cdd4  e1031faa  mov      x1, xzr
0169cdd8  07cf0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169cddc  f90300aa  mov      x25, x0
0169cde0  590000b5  cbnz     x25, #0x169cde8
0169cde4  523ada97  bl       #0xd2b72c ; unresolved symbol
0169cde8  9b0e40f9  ldr      x27, [x20, #0x18]
0169cdec  39db40f9  ldr      x25, [x25, #0x1b0]
0169cdf0  7b0000b5  cbnz     x27, #0x169cdfc
0169cdf4  e0031faa  mov      x0, xzr
0169cdf8  4d3ada97  bl       #0xd2b72c ; unresolved symbol
0169cdfc  e0031baa  mov      x0, x27
0169ce00  e1031faa  mov      x1, xzr
0169ce04  f8ce0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169ce08  fb0300aa  mov      x27, x0
0169ce0c  5b0000b5  cbnz     x27, #0x169ce14
0169ce10  473ada97  bl       #0xd2b72c ; unresolved symbol
0169ce14  e0031baa  mov      x0, x27
0169ce18  e1031faa  mov      x1, xzr
0169ce1c  f6ce0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169ce20  fb0300aa  mov      x27, x0
0169ce24  5b0000b5  cbnz     x27, #0x169ce2c
0169ce28  413ada97  bl       #0xd2b72c ; unresolved symbol
0169ce2c  7bc740f9  ldr      x27, [x27, #0x188]
0169ce30  b32000b5  cbnz     x19, #0x169d244
0169ce34  02010014  b        #0x169d23c
0169ce38  990340f9  ldr      x25, [x28]
0169ce3c  790000b5  cbnz     x25, #0x169ce48
0169ce40  e0031faa  mov      x0, xzr
0169ce44  3a3ada97  bl       #0xd2b72c ; unresolved symbol
0169ce48  e00319aa  mov      x0, x25
0169ce4c  e1031faa  mov      x1, xzr
0169ce50  e5ce0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169ce54  f90300aa  mov      x25, x0
0169ce58  590000b5  cbnz     x25, #0x169ce60
0169ce5c  343ada97  bl       #0xd2b72c ; unresolved symbol
0169ce60  e00319aa  mov      x0, x25
0169ce64  e1031faa  mov      x1, xzr
0169ce68  e3ce0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169ce6c  f90300aa  mov      x25, x0
0169ce70  590000b5  cbnz     x25, #0x169ce78
0169ce74  2e3ada97  bl       #0xd2b72c ; unresolved symbol
0169ce78  9b0e40f9  ldr      x27, [x20, #0x18]
0169ce7c  39df40f9  ldr      x25, [x25, #0x1b8]
0169ce80  7b0000b5  cbnz     x27, #0x169ce8c
0169ce84  e0031faa  mov      x0, xzr
0169ce88  293ada97  bl       #0xd2b72c ; unresolved symbol
0169ce8c  e0031baa  mov      x0, x27
0169ce90  e1031faa  mov      x1, xzr
0169ce94  d4ce0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169ce98  fb0300aa  mov      x27, x0
0169ce9c  5b0000b5  cbnz     x27, #0x169cea4
0169cea0  233ada97  bl       #0xd2b72c ; unresolved symbol
0169cea4  e0031baa  mov      x0, x27
0169cea8  e1031faa  mov      x1, xzr
0169ceac  d2ce0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169ceb0  fb0300aa  mov      x27, x0
0169ceb4  5b0000b5  cbnz     x27, #0x169cebc
0169ceb8  1d3ada97  bl       #0xd2b72c ; unresolved symbol
0169cebc  7bcb40f9  ldr      x27, [x27, #0x190]
0169cec0  331c00b5  cbnz     x19, #0x169d244
0169cec4  de000014  b        #0x169d23c
0169cec8  990340f9  ldr      x25, [x28]
0169cecc  790000b5  cbnz     x25, #0x169ced8
0169ced0  e0031faa  mov      x0, xzr
0169ced4  163ada97  bl       #0xd2b72c ; unresolved symbol
0169ced8  e00319aa  mov      x0, x25
0169cedc  e1031faa  mov      x1, xzr
0169cee0  c1ce0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169cee4  f90300aa  mov      x25, x0
0169cee8  590000b5  cbnz     x25, #0x169cef0
0169ceec  103ada97  bl       #0xd2b72c ; unresolved symbol
0169cef0  e00319aa  mov      x0, x25
0169cef4  e1031faa  mov      x1, xzr
0169cef8  bfce0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169cefc  f90300aa  mov      x25, x0
0169cf00  590000b5  cbnz     x25, #0x169cf08
0169cf04  0a3ada97  bl       #0xd2b72c ; unresolved symbol
0169cf08  9a0340f9  ldr      x26, [x28]
0169cf0c  39cf40f9  ldr      x25, [x25, #0x198]
0169cf10  7a0000b5  cbnz     x26, #0x169cf1c
0169cf14  e0031faa  mov      x0, xzr
0169cf18  053ada97  bl       #0xd2b72c ; unresolved symbol
0169cf1c  e0031aaa  mov      x0, x26
0169cf20  e1031faa  mov      x1, xzr
0169cf24  b0ce0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169cf28  fa0300aa  mov      x26, x0
0169cf2c  5a0000b5  cbnz     x26, #0x169cf34
0169cf30  ff39da97  bl       #0xd2b72c ; unresolved symbol
0169cf34  e0031aaa  mov      x0, x26
0169cf38  e1031faa  mov      x1, xzr
0169cf3c  aece0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169cf40  fa0300aa  mov      x26, x0
0169cf44  5a0000b5  cbnz     x26, #0x169cf4c
0169cf48  f939da97  bl       #0xd2b72c ; unresolved symbol
0169cf4c  08b100b0  adrp     x8, #0x2cbd000
0169cf50  08dd47f9  ldr      x8, [x8, #0xfb8]
0169cf54  5ad340f9  ldr      x26, [x26, #0x1a0]
0169cf58  000140f9  ldr      x0, [x8]
0169cf5c  089c4439  ldrb     w8, [x0, #0x127]
0169cf60  88000836  tbz      w8, #1, #0x169cf70
0169cf64  08d840b9  ldr      w8, [x0, #0xd8]
0169cf68  48000035  cbnz     w8, #0x169cf70
0169cf6c  7fdcd997  bl       #0xd14168 ; unresolved symbol
0169cf70  e00319aa  mov      x0, x25
0169cf74  e1031aaa  mov      x1, x26
0169cf78  e2031faa  mov      x2, xzr
0169cf7c  f6db2094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169cf80  9a0340f9  ldr      x26, [x28]
0169cf84  f90300aa  mov      x25, x0
0169cf88  7a0000b5  cbnz     x26, #0x169cf94
0169cf8c  e0031faa  mov      x0, xzr
0169cf90  e739da97  bl       #0xd2b72c ; unresolved symbol
0169cf94  e0031aaa  mov      x0, x26
0169cf98  e1031faa  mov      x1, xzr
0169cf9c  92ce0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169cfa0  fa0300aa  mov      x26, x0
0169cfa4  5a0000b5  cbnz     x26, #0x169cfac
0169cfa8  e139da97  bl       #0xd2b72c ; unresolved symbol
0169cfac  e0031aaa  mov      x0, x26
0169cfb0  e1031faa  mov      x1, xzr
0169cfb4  90ce0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169cfb8  fa0300aa  mov      x26, x0
0169cfbc  5a0000b5  cbnz     x26, #0x169cfc4
0169cfc0  db39da97  bl       #0xd2b72c ; unresolved symbol
0169cfc4  41d740f9  ldr      x1, [x26, #0x1a8]
0169cfc8  e00319aa  mov      x0, x25
0169cfcc  e2031faa  mov      x2, xzr
0169cfd0  e1db2094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169cfd4  9a0340f9  ldr      x26, [x28]
0169cfd8  f90300aa  mov      x25, x0
0169cfdc  7a0000b5  cbnz     x26, #0x169cfe8
0169cfe0  e0031faa  mov      x0, xzr
0169cfe4  d239da97  bl       #0xd2b72c ; unresolved symbol
0169cfe8  e0031aaa  mov      x0, x26
0169cfec  e1031faa  mov      x1, xzr
0169cff0  7dce0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169cff4  fa0300aa  mov      x26, x0
0169cff8  5a0000b5  cbnz     x26, #0x169d000
0169cffc  cc39da97  bl       #0xd2b72c ; unresolved symbol
0169d000  e0031aaa  mov      x0, x26
0169d004  e1031faa  mov      x1, xzr
0169d008  7bce0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d00c  fa0300aa  mov      x26, x0
0169d010  5a0000b5  cbnz     x26, #0x169d018
0169d014  c639da97  bl       #0xd2b72c ; unresolved symbol
0169d018  41db40f9  ldr      x1, [x26, #0x1b0]
0169d01c  e00319aa  mov      x0, x25
0169d020  e2031faa  mov      x2, xzr
0169d024  ccdb2094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169d028  9a0340f9  ldr      x26, [x28]
0169d02c  f90300aa  mov      x25, x0
0169d030  7a0000b5  cbnz     x26, #0x169d03c
0169d034  e0031faa  mov      x0, xzr
0169d038  bd39da97  bl       #0xd2b72c ; unresolved symbol
0169d03c  e0031aaa  mov      x0, x26
0169d040  e1031faa  mov      x1, xzr
0169d044  68ce0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d048  fa0300aa  mov      x26, x0
0169d04c  5a0000b5  cbnz     x26, #0x169d054
0169d050  b739da97  bl       #0xd2b72c ; unresolved symbol
0169d054  e0031aaa  mov      x0, x26
0169d058  e1031faa  mov      x1, xzr
0169d05c  66ce0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d060  fa0300aa  mov      x26, x0
0169d064  5a0000b5  cbnz     x26, #0x169d06c
0169d068  b139da97  bl       #0xd2b72c ; unresolved symbol
0169d06c  41df40f9  ldr      x1, [x26, #0x1b8]
0169d070  e00319aa  mov      x0, x25
0169d074  e2031faa  mov      x2, xzr
0169d078  b7db2094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169d07c  9a0e40f9  ldr      x26, [x20, #0x18]
0169d080  f90300aa  mov      x25, x0
0169d084  7a0000b5  cbnz     x26, #0x169d090
0169d088  e0031faa  mov      x0, xzr
0169d08c  a839da97  bl       #0xd2b72c ; unresolved symbol
0169d090  e0031aaa  mov      x0, x26
0169d094  e1031faa  mov      x1, xzr
0169d098  53ce0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d09c  fa0300aa  mov      x26, x0
0169d0a0  5a0000b5  cbnz     x26, #0x169d0a8
0169d0a4  a239da97  bl       #0xd2b72c ; unresolved symbol
0169d0a8  e0031aaa  mov      x0, x26
0169d0ac  e1031faa  mov      x1, xzr
0169d0b0  51ce0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d0b4  fa0300aa  mov      x26, x0
0169d0b8  5a0000b5  cbnz     x26, #0x169d0c0
0169d0bc  9c39da97  bl       #0xd2b72c ; unresolved symbol
0169d0c0  9b0e40f9  ldr      x27, [x20, #0x18]
0169d0c4  5abb40f9  ldr      x26, [x26, #0x170]
0169d0c8  7b0000b5  cbnz     x27, #0x169d0d4
0169d0cc  e0031faa  mov      x0, xzr
0169d0d0  9739da97  bl       #0xd2b72c ; unresolved symbol
0169d0d4  e0031baa  mov      x0, x27
0169d0d8  e1031faa  mov      x1, xzr
0169d0dc  42ce0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d0e0  fb0300aa  mov      x27, x0
0169d0e4  5b0000b5  cbnz     x27, #0x169d0ec
0169d0e8  9139da97  bl       #0xd2b72c ; unresolved symbol
0169d0ec  e0031baa  mov      x0, x27
0169d0f0  e1031faa  mov      x1, xzr
0169d0f4  40ce0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d0f8  fb0300aa  mov      x27, x0
0169d0fc  5b0000b5  cbnz     x27, #0x169d104
0169d100  8b39da97  bl       #0xd2b72c ; unresolved symbol
0169d104  61bf40f9  ldr      x1, [x27, #0x178]
0169d108  e0031aaa  mov      x0, x26
0169d10c  e2031faa  mov      x2, xzr
0169d110  91db2094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169d114  9b0e40f9  ldr      x27, [x20, #0x18]
0169d118  fa0300aa  mov      x26, x0
0169d11c  7b0000b5  cbnz     x27, #0x169d128
0169d120  e0031faa  mov      x0, xzr
0169d124  8239da97  bl       #0xd2b72c ; unresolved symbol
0169d128  e0031baa  mov      x0, x27
0169d12c  e1031faa  mov      x1, xzr
0169d130  2dce0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d134  fb0300aa  mov      x27, x0
0169d138  5b0000b5  cbnz     x27, #0x169d140
0169d13c  7c39da97  bl       #0xd2b72c ; unresolved symbol
0169d140  e0031baa  mov      x0, x27
0169d144  e1031faa  mov      x1, xzr
0169d148  2bce0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d14c  fb0300aa  mov      x27, x0
0169d150  5b0000b5  cbnz     x27, #0x169d158
0169d154  7639da97  bl       #0xd2b72c ; unresolved symbol
0169d158  61c340f9  ldr      x1, [x27, #0x180]
0169d15c  e0031aaa  mov      x0, x26
0169d160  e2031faa  mov      x2, xzr
0169d164  7cdb2094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169d168  9b0e40f9  ldr      x27, [x20, #0x18]
0169d16c  fa0300aa  mov      x26, x0
0169d170  7b0000b5  cbnz     x27, #0x169d17c
0169d174  e0031faa  mov      x0, xzr
0169d178  6d39da97  bl       #0xd2b72c ; unresolved symbol
0169d17c  e0031baa  mov      x0, x27
0169d180  e1031faa  mov      x1, xzr
0169d184  18ce0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d188  fb0300aa  mov      x27, x0
0169d18c  5b0000b5  cbnz     x27, #0x169d194
0169d190  6739da97  bl       #0xd2b72c ; unresolved symbol
0169d194  e0031baa  mov      x0, x27
0169d198  e1031faa  mov      x1, xzr
0169d19c  16ce0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d1a0  fb0300aa  mov      x27, x0
0169d1a4  5b0000b5  cbnz     x27, #0x169d1ac
0169d1a8  6139da97  bl       #0xd2b72c ; unresolved symbol
0169d1ac  61c740f9  ldr      x1, [x27, #0x188]
0169d1b0  e0031aaa  mov      x0, x26
0169d1b4  e2031faa  mov      x2, xzr
0169d1b8  67db2094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169d1bc  9b0e40f9  ldr      x27, [x20, #0x18]
0169d1c0  fa0300aa  mov      x26, x0
0169d1c4  7b0000b5  cbnz     x27, #0x169d1d0
0169d1c8  e0031faa  mov      x0, xzr
0169d1cc  5839da97  bl       #0xd2b72c ; unresolved symbol
0169d1d0  e0031baa  mov      x0, x27
0169d1d4  e1031faa  mov      x1, xzr
0169d1d8  03ce0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d1dc  fb0300aa  mov      x27, x0
0169d1e0  5b0000b5  cbnz     x27, #0x169d1e8
0169d1e4  5239da97  bl       #0xd2b72c ; unresolved symbol
0169d1e8  e0031baa  mov      x0, x27
0169d1ec  e1031faa  mov      x1, xzr
0169d1f0  01ce0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d1f4  fb0300aa  mov      x27, x0
0169d1f8  5b0000b5  cbnz     x27, #0x169d200
0169d1fc  4c39da97  bl       #0xd2b72c ; unresolved symbol
0169d200  61cb40f9  ldr      x1, [x27, #0x190]
0169d204  e0031aaa  mov      x0, x26
0169d208  e2031faa  mov      x2, xzr
0169d20c  52db2094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169d210  da1240f9  ldr      x26, [x22, #0x20]
0169d214  fb0300aa  mov      x27, x0
0169d218  a0008052  mov      w0, #5
0169d21c  e1031faa  mov      x1, xzr
0169d220  64dc2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169d224  e10300aa  mov      x1, x0
0169d228  e0031aaa  mov      x0, x26
0169d22c  e2031faa  mov      x2, xzr
0169d230  7edb2094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169d234  fa0300aa  mov      x26, x0
0169d238  730000b5  cbnz     x19, #0x169d244
0169d23c  e0031faa  mov      x0, xzr
0169d240  3b39da97  bl       #0xd2b72c ; unresolved symbol
0169d244  e8030032  mov      w8, #1
0169d248  68c20139  strb     w8, [x19, #0x70]
0169d24c  08b10090  adrp     x8, #0x2cbd000
0169d250  08dd47f9  ldr      x8, [x8, #0xfb8]
0169d254  000140f9  ldr      x0, [x8]
0169d258  089c4439  ldrb     w8, [x0, #0x127]
0169d25c  88000836  tbz      w8, #1, #0x169d26c
0169d260  08d840b9  ldr      w8, [x0, #0xd8]
0169d264  48000035  cbnz     w8, #0x169d26c
0169d268  c0dbd997  bl       #0xd14168 ; unresolved symbol
0169d26c  e0031aaa  mov      x0, x26
0169d270  e10319aa  mov      x1, x25
0169d274  e2031faa  mov      x2, xzr
0169d278  66db2094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169d27c  e01b00f9  str      x0, [sp, #0x30]
0169d280  e0c30091  add      x0, sp, #0x30
0169d284  e1031faa  mov      x1, xzr
0169d288  36e02094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169d28c  e1031faa  mov      x1, xzr
0169d290  48dc2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169d294  28b100f0  adrp     x8, #0x2cc4000
0169d298  08f946f9  ldr      x8, [x8, #0xdf0]
0169d29c  f90300aa  mov      x25, x0
0169d2a0  080140f9  ldr      x8, [x8]
0169d2a4  099d4439  ldrb     w9, [x8, #0x127]
0169d2a8  a9000836  tbz      w9, #1, #0x169d2bc
0169d2ac  09d940b9  ldr      w9, [x8, #0xd8]
0169d2b0  69000035  cbnz     w9, #0x169d2bc
0169d2b4  e00308aa  mov      x0, x8
0169d2b8  acdbd997  bl       #0xd14168 ; unresolved symbol
0169d2bc  e0031baa  mov      x0, x27
0169d2c0  e10319aa  mov      x1, x25
0169d2c4  880b0094  bl       #0x16a00e4 ; A3BattleCore.SkillDamageHelper$$GetFiveEleMiniDamage
0169d2c8  e01b00f9  str      x0, [sp, #0x30]
0169d2cc  e0c30091  add      x0, sp, #0x30
0169d2d0  e1031faa  mov      x1, xzr
0169d2d4  23e02094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169d2d8  607600b9  str      w0, [x19, #0x74]
0169d2dc  c10e40f9  ldr      x1, [x22, #0x18]
0169d2e0  e00318aa  mov      x0, x24
0169d2e4  e2031faa  mov      x2, xzr
0169d2e8  50db2094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169d2ec  960e40f9  ldr      x22, [x20, #0x18]
0169d2f0  980340f9  ldr      x24, [x28]
0169d2f4  f90300aa  mov      x25, x0
0169d2f8  e0031f2a  mov      w0, wzr
0169d2fc  e1031faa  mov      x1, xzr
0169d300  2cdc2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169d304  e70300aa  mov      x7, x0
0169d308  e5030032  mov      w5, #1
0169d30c  e00317aa  mov      x0, x23
0169d310  e10316aa  mov      x1, x22
0169d314  e20318aa  mov      x2, x24
0169d318  e30314aa  mov      x3, x20
0169d31c  e40313aa  mov      x4, x19
0169d320  e60319aa  mov      x6, x25
0169d324  f50300f9  str      x21, [sp]
0169d328  25040094  bl       #0x169e3bc ; A3BattleCore.SkillDamageHelper$$DoCalcWeaponDamage
0169d32c  d384ffb5  cbnz     x19, #0x169c3c4
0169d330  23fcff17  b        #0x169c3bc
0169d334  970340f9  ldr      x23, [x28]
0169d338  770000b5  cbnz     x23, #0x169d344
0169d33c  e0031faa  mov      x0, xzr
0169d340  fb38da97  bl       #0xd2b72c ; unresolved symbol
0169d344  e00317aa  mov      x0, x23
0169d348  e1031faa  mov      x1, xzr
0169d34c  a6cd0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d350  f70300aa  mov      x23, x0
0169d354  570000b5  cbnz     x23, #0x169d35c
0169d358  f538da97  bl       #0xd2b72c ; unresolved symbol
0169d35c  e00317aa  mov      x0, x23
0169d360  e1031faa  mov      x1, xzr
0169d364  a4cd0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d368  f70300aa  mov      x23, x0
0169d36c  570000b5  cbnz     x23, #0x169d374
0169d370  ef38da97  bl       #0xd2b72c ; unresolved symbol
0169d374  990e40f9  ldr      x25, [x20, #0x18]
0169d378  f7d240f9  ldr      x23, [x23, #0x1a0]
0169d37c  790000b5  cbnz     x25, #0x169d388
0169d380  e0031faa  mov      x0, xzr
0169d384  ea38da97  bl       #0xd2b72c ; unresolved symbol
0169d388  e00319aa  mov      x0, x25
0169d38c  e1031faa  mov      x1, xzr
0169d390  95cd0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d394  f90300aa  mov      x25, x0
0169d398  590000b5  cbnz     x25, #0x169d3a0
0169d39c  e438da97  bl       #0xd2b72c ; unresolved symbol
0169d3a0  e00319aa  mov      x0, x25
0169d3a4  e1031faa  mov      x1, xzr
0169d3a8  93cd0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d3ac  f90300aa  mov      x25, x0
0169d3b0  590000b5  cbnz     x25, #0x169d3b8
0169d3b4  de38da97  bl       #0xd2b72c ; unresolved symbol
0169d3b8  39bf40f9  ldr      x25, [x25, #0x178]
0169d3bc  44010014  b        #0x169d8cc
0169d3c0  970340f9  ldr      x23, [x28]
0169d3c4  770000b5  cbnz     x23, #0x169d3d0
0169d3c8  e0031faa  mov      x0, xzr
0169d3cc  d838da97  bl       #0xd2b72c ; unresolved symbol
0169d3d0  e00317aa  mov      x0, x23
0169d3d4  e1031faa  mov      x1, xzr
0169d3d8  83cd0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d3dc  f70300aa  mov      x23, x0
0169d3e0  570000b5  cbnz     x23, #0x169d3e8
0169d3e4  d238da97  bl       #0xd2b72c ; unresolved symbol
0169d3e8  e00317aa  mov      x0, x23
0169d3ec  e1031faa  mov      x1, xzr
0169d3f0  81cd0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d3f4  f70300aa  mov      x23, x0
0169d3f8  570000b5  cbnz     x23, #0x169d400
0169d3fc  cc38da97  bl       #0xd2b72c ; unresolved symbol
0169d400  990e40f9  ldr      x25, [x20, #0x18]
0169d404  f7d640f9  ldr      x23, [x23, #0x1a8]
0169d408  790000b5  cbnz     x25, #0x169d414
0169d40c  e0031faa  mov      x0, xzr
0169d410  c738da97  bl       #0xd2b72c ; unresolved symbol
0169d414  e00319aa  mov      x0, x25
0169d418  e1031faa  mov      x1, xzr
0169d41c  72cd0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d420  f90300aa  mov      x25, x0
0169d424  590000b5  cbnz     x25, #0x169d42c
0169d428  c138da97  bl       #0xd2b72c ; unresolved symbol
0169d42c  e00319aa  mov      x0, x25
0169d430  e1031faa  mov      x1, xzr
0169d434  70cd0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d438  f90300aa  mov      x25, x0
0169d43c  590000b5  cbnz     x25, #0x169d444
0169d440  bb38da97  bl       #0xd2b72c ; unresolved symbol
0169d444  39c340f9  ldr      x25, [x25, #0x180]
0169d448  21010014  b        #0x169d8cc
0169d44c  970340f9  ldr      x23, [x28]
0169d450  770000b5  cbnz     x23, #0x169d45c
0169d454  e0031faa  mov      x0, xzr
0169d458  b538da97  bl       #0xd2b72c ; unresolved symbol
0169d45c  e00317aa  mov      x0, x23
0169d460  e1031faa  mov      x1, xzr
0169d464  60cd0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d468  f70300aa  mov      x23, x0
0169d46c  570000b5  cbnz     x23, #0x169d474
0169d470  af38da97  bl       #0xd2b72c ; unresolved symbol
0169d474  e00317aa  mov      x0, x23
0169d478  e1031faa  mov      x1, xzr
0169d47c  5ecd0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d480  f70300aa  mov      x23, x0
0169d484  570000b5  cbnz     x23, #0x169d48c
0169d488  a938da97  bl       #0xd2b72c ; unresolved symbol
0169d48c  990e40f9  ldr      x25, [x20, #0x18]
0169d490  f7da40f9  ldr      x23, [x23, #0x1b0]
0169d494  790000b5  cbnz     x25, #0x169d4a0
0169d498  e0031faa  mov      x0, xzr
0169d49c  a438da97  bl       #0xd2b72c ; unresolved symbol
0169d4a0  e00319aa  mov      x0, x25
0169d4a4  e1031faa  mov      x1, xzr
0169d4a8  4fcd0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d4ac  f90300aa  mov      x25, x0
0169d4b0  590000b5  cbnz     x25, #0x169d4b8
0169d4b4  9e38da97  bl       #0xd2b72c ; unresolved symbol
0169d4b8  e00319aa  mov      x0, x25
0169d4bc  e1031faa  mov      x1, xzr
0169d4c0  4dcd0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d4c4  f90300aa  mov      x25, x0
0169d4c8  590000b5  cbnz     x25, #0x169d4d0
0169d4cc  9838da97  bl       #0xd2b72c ; unresolved symbol
0169d4d0  39c740f9  ldr      x25, [x25, #0x188]
0169d4d4  fe000014  b        #0x169d8cc
0169d4d8  970340f9  ldr      x23, [x28]
0169d4dc  770000b5  cbnz     x23, #0x169d4e8
0169d4e0  e0031faa  mov      x0, xzr
0169d4e4  9238da97  bl       #0xd2b72c ; unresolved symbol
0169d4e8  e00317aa  mov      x0, x23
0169d4ec  e1031faa  mov      x1, xzr
0169d4f0  3dcd0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d4f4  f70300aa  mov      x23, x0
0169d4f8  570000b5  cbnz     x23, #0x169d500
0169d4fc  8c38da97  bl       #0xd2b72c ; unresolved symbol
0169d500  e00317aa  mov      x0, x23
0169d504  e1031faa  mov      x1, xzr
0169d508  3bcd0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d50c  f70300aa  mov      x23, x0
0169d510  570000b5  cbnz     x23, #0x169d518
0169d514  8638da97  bl       #0xd2b72c ; unresolved symbol
0169d518  990e40f9  ldr      x25, [x20, #0x18]
0169d51c  f7de40f9  ldr      x23, [x23, #0x1b8]
0169d520  790000b5  cbnz     x25, #0x169d52c
0169d524  e0031faa  mov      x0, xzr
0169d528  8138da97  bl       #0xd2b72c ; unresolved symbol
0169d52c  e00319aa  mov      x0, x25
0169d530  e1031faa  mov      x1, xzr
0169d534  2ccd0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d538  f90300aa  mov      x25, x0
0169d53c  590000b5  cbnz     x25, #0x169d544
0169d540  7b38da97  bl       #0xd2b72c ; unresolved symbol
0169d544  e00319aa  mov      x0, x25
0169d548  e1031faa  mov      x1, xzr
0169d54c  2acd0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d550  f90300aa  mov      x25, x0
0169d554  590000b5  cbnz     x25, #0x169d55c
0169d558  7538da97  bl       #0xd2b72c ; unresolved symbol
0169d55c  39cb40f9  ldr      x25, [x25, #0x190]
0169d560  db000014  b        #0x169d8cc
0169d564  970340f9  ldr      x23, [x28]
0169d568  770000b5  cbnz     x23, #0x169d574
0169d56c  e0031faa  mov      x0, xzr
0169d570  6f38da97  bl       #0xd2b72c ; unresolved symbol
0169d574  e00317aa  mov      x0, x23
0169d578  e1031faa  mov      x1, xzr
0169d57c  1acd0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d580  f70300aa  mov      x23, x0
0169d584  570000b5  cbnz     x23, #0x169d58c
0169d588  6938da97  bl       #0xd2b72c ; unresolved symbol
0169d58c  e00317aa  mov      x0, x23
0169d590  e1031faa  mov      x1, xzr
0169d594  18cd0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d598  f70300aa  mov      x23, x0
0169d59c  570000b5  cbnz     x23, #0x169d5a4
0169d5a0  6338da97  bl       #0xd2b72c ; unresolved symbol
0169d5a4  980340f9  ldr      x24, [x28]
0169d5a8  f7ce40f9  ldr      x23, [x23, #0x198]
0169d5ac  780000b5  cbnz     x24, #0x169d5b8
0169d5b0  e0031faa  mov      x0, xzr
0169d5b4  5e38da97  bl       #0xd2b72c ; unresolved symbol
0169d5b8  e00318aa  mov      x0, x24
0169d5bc  e1031faa  mov      x1, xzr
0169d5c0  09cd0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d5c4  f80300aa  mov      x24, x0
0169d5c8  580000b5  cbnz     x24, #0x169d5d0
0169d5cc  5838da97  bl       #0xd2b72c ; unresolved symbol
0169d5d0  e00318aa  mov      x0, x24
0169d5d4  e1031faa  mov      x1, xzr
0169d5d8  07cd0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d5dc  f80300aa  mov      x24, x0
0169d5e0  580000b5  cbnz     x24, #0x169d5e8
0169d5e4  5238da97  bl       #0xd2b72c ; unresolved symbol
0169d5e8  400340f9  ldr      x0, [x26]
0169d5ec  18d340f9  ldr      x24, [x24, #0x1a0]
0169d5f0  089c4439  ldrb     w8, [x0, #0x127]
0169d5f4  88000836  tbz      w8, #1, #0x169d604
0169d5f8  08d840b9  ldr      w8, [x0, #0xd8]
0169d5fc  48000035  cbnz     w8, #0x169d604
0169d600  dadad997  bl       #0xd14168 ; unresolved symbol
0169d604  e00317aa  mov      x0, x23
0169d608  e10318aa  mov      x1, x24
0169d60c  e2031faa  mov      x2, xzr
0169d610  51da2094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169d614  980340f9  ldr      x24, [x28]
0169d618  f70300aa  mov      x23, x0
0169d61c  780000b5  cbnz     x24, #0x169d628
0169d620  e0031faa  mov      x0, xzr
0169d624  4238da97  bl       #0xd2b72c ; unresolved symbol
0169d628  e00318aa  mov      x0, x24
0169d62c  e1031faa  mov      x1, xzr
0169d630  edcc0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d634  f80300aa  mov      x24, x0
0169d638  580000b5  cbnz     x24, #0x169d640
0169d63c  3c38da97  bl       #0xd2b72c ; unresolved symbol
0169d640  e00318aa  mov      x0, x24
0169d644  e1031faa  mov      x1, xzr
0169d648  ebcc0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d64c  f80300aa  mov      x24, x0
0169d650  580000b5  cbnz     x24, #0x169d658
0169d654  3638da97  bl       #0xd2b72c ; unresolved symbol
0169d658  01d740f9  ldr      x1, [x24, #0x1a8]
0169d65c  e00317aa  mov      x0, x23
0169d660  e2031faa  mov      x2, xzr
0169d664  3cda2094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169d668  980340f9  ldr      x24, [x28]
0169d66c  f70300aa  mov      x23, x0
0169d670  780000b5  cbnz     x24, #0x169d67c
0169d674  e0031faa  mov      x0, xzr
0169d678  2d38da97  bl       #0xd2b72c ; unresolved symbol
0169d67c  e00318aa  mov      x0, x24
0169d680  e1031faa  mov      x1, xzr
0169d684  d8cc0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d688  f80300aa  mov      x24, x0
0169d68c  580000b5  cbnz     x24, #0x169d694
0169d690  2738da97  bl       #0xd2b72c ; unresolved symbol
0169d694  e00318aa  mov      x0, x24
0169d698  e1031faa  mov      x1, xzr
0169d69c  d6cc0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d6a0  f80300aa  mov      x24, x0
0169d6a4  580000b5  cbnz     x24, #0x169d6ac
0169d6a8  2138da97  bl       #0xd2b72c ; unresolved symbol
0169d6ac  01db40f9  ldr      x1, [x24, #0x1b0]
0169d6b0  e00317aa  mov      x0, x23
0169d6b4  e2031faa  mov      x2, xzr
0169d6b8  27da2094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169d6bc  980340f9  ldr      x24, [x28]
0169d6c0  f70300aa  mov      x23, x0
0169d6c4  780000b5  cbnz     x24, #0x169d6d0
0169d6c8  e0031faa  mov      x0, xzr
0169d6cc  1838da97  bl       #0xd2b72c ; unresolved symbol
0169d6d0  e00318aa  mov      x0, x24
0169d6d4  e1031faa  mov      x1, xzr
0169d6d8  c3cc0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d6dc  f80300aa  mov      x24, x0
0169d6e0  580000b5  cbnz     x24, #0x169d6e8
0169d6e4  1238da97  bl       #0xd2b72c ; unresolved symbol
0169d6e8  e00318aa  mov      x0, x24
0169d6ec  e1031faa  mov      x1, xzr
0169d6f0  c1cc0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d6f4  f80300aa  mov      x24, x0
0169d6f8  580000b5  cbnz     x24, #0x169d700
0169d6fc  0c38da97  bl       #0xd2b72c ; unresolved symbol
0169d700  01df40f9  ldr      x1, [x24, #0x1b8]
0169d704  e00317aa  mov      x0, x23
0169d708  e2031faa  mov      x2, xzr
0169d70c  12da2094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169d710  980e40f9  ldr      x24, [x20, #0x18]
0169d714  f70300aa  mov      x23, x0
0169d718  780000b5  cbnz     x24, #0x169d724
0169d71c  e0031faa  mov      x0, xzr
0169d720  0338da97  bl       #0xd2b72c ; unresolved symbol
0169d724  e00318aa  mov      x0, x24
0169d728  e1031faa  mov      x1, xzr
0169d72c  aecc0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d730  f80300aa  mov      x24, x0
0169d734  580000b5  cbnz     x24, #0x169d73c
0169d738  fd37da97  bl       #0xd2b72c ; unresolved symbol
0169d73c  e00318aa  mov      x0, x24
0169d740  e1031faa  mov      x1, xzr
0169d744  accc0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d748  f80300aa  mov      x24, x0
0169d74c  580000b5  cbnz     x24, #0x169d754
0169d750  f737da97  bl       #0xd2b72c ; unresolved symbol
0169d754  990e40f9  ldr      x25, [x20, #0x18]
0169d758  18bb40f9  ldr      x24, [x24, #0x170]
0169d75c  790000b5  cbnz     x25, #0x169d768
0169d760  e0031faa  mov      x0, xzr
0169d764  f237da97  bl       #0xd2b72c ; unresolved symbol
0169d768  e00319aa  mov      x0, x25
0169d76c  e1031faa  mov      x1, xzr
0169d770  9dcc0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d774  f90300aa  mov      x25, x0
0169d778  590000b5  cbnz     x25, #0x169d780
0169d77c  ec37da97  bl       #0xd2b72c ; unresolved symbol
0169d780  e00319aa  mov      x0, x25
0169d784  e1031faa  mov      x1, xzr
0169d788  9bcc0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d78c  f90300aa  mov      x25, x0
0169d790  590000b5  cbnz     x25, #0x169d798
0169d794  e637da97  bl       #0xd2b72c ; unresolved symbol
0169d798  21bf40f9  ldr      x1, [x25, #0x178]
0169d79c  e00318aa  mov      x0, x24
0169d7a0  e2031faa  mov      x2, xzr
0169d7a4  ecd92094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169d7a8  990e40f9  ldr      x25, [x20, #0x18]
0169d7ac  f80300aa  mov      x24, x0
0169d7b0  790000b5  cbnz     x25, #0x169d7bc
0169d7b4  e0031faa  mov      x0, xzr
0169d7b8  dd37da97  bl       #0xd2b72c ; unresolved symbol
0169d7bc  e00319aa  mov      x0, x25
0169d7c0  e1031faa  mov      x1, xzr
0169d7c4  88cc0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d7c8  f90300aa  mov      x25, x0
0169d7cc  590000b5  cbnz     x25, #0x169d7d4
0169d7d0  d737da97  bl       #0xd2b72c ; unresolved symbol
0169d7d4  e00319aa  mov      x0, x25
0169d7d8  e1031faa  mov      x1, xzr
0169d7dc  86cc0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d7e0  f90300aa  mov      x25, x0
0169d7e4  590000b5  cbnz     x25, #0x169d7ec
0169d7e8  d137da97  bl       #0xd2b72c ; unresolved symbol
0169d7ec  21c340f9  ldr      x1, [x25, #0x180]
0169d7f0  e00318aa  mov      x0, x24
0169d7f4  e2031faa  mov      x2, xzr
0169d7f8  d7d92094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169d7fc  990e40f9  ldr      x25, [x20, #0x18]
0169d800  f80300aa  mov      x24, x0
0169d804  790000b5  cbnz     x25, #0x169d810
0169d808  e0031faa  mov      x0, xzr
0169d80c  c837da97  bl       #0xd2b72c ; unresolved symbol
0169d810  e00319aa  mov      x0, x25
0169d814  e1031faa  mov      x1, xzr
0169d818  73cc0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d81c  f90300aa  mov      x25, x0
0169d820  590000b5  cbnz     x25, #0x169d828
0169d824  c237da97  bl       #0xd2b72c ; unresolved symbol
0169d828  e00319aa  mov      x0, x25
0169d82c  e1031faa  mov      x1, xzr
0169d830  71cc0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d834  f90300aa  mov      x25, x0
0169d838  590000b5  cbnz     x25, #0x169d840
0169d83c  bc37da97  bl       #0xd2b72c ; unresolved symbol
0169d840  21c740f9  ldr      x1, [x25, #0x188]
0169d844  e00318aa  mov      x0, x24
0169d848  e2031faa  mov      x2, xzr
0169d84c  c2d92094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169d850  990e40f9  ldr      x25, [x20, #0x18]
0169d854  f80300aa  mov      x24, x0
0169d858  790000b5  cbnz     x25, #0x169d864
0169d85c  e0031faa  mov      x0, xzr
0169d860  b337da97  bl       #0xd2b72c ; unresolved symbol
0169d864  e00319aa  mov      x0, x25
0169d868  e1031faa  mov      x1, xzr
0169d86c  5ecc0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d870  f90300aa  mov      x25, x0
0169d874  590000b5  cbnz     x25, #0x169d87c
0169d878  ad37da97  bl       #0xd2b72c ; unresolved symbol
0169d87c  e00319aa  mov      x0, x25
0169d880  e1031faa  mov      x1, xzr
0169d884  5ccc0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d888  f90300aa  mov      x25, x0
0169d88c  590000b5  cbnz     x25, #0x169d894
0169d890  a737da97  bl       #0xd2b72c ; unresolved symbol
0169d894  21cb40f9  ldr      x1, [x25, #0x190]
0169d898  e00318aa  mov      x0, x24
0169d89c  e2031faa  mov      x2, xzr
0169d8a0  add92094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169d8a4  d81240f9  ldr      x24, [x22, #0x20]
0169d8a8  f90300aa  mov      x25, x0
0169d8ac  a0008052  mov      w0, #5
0169d8b0  e1031faa  mov      x1, xzr
0169d8b4  bfda2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169d8b8  e10300aa  mov      x1, x0
0169d8bc  e00318aa  mov      x0, x24
0169d8c0  e2031faa  mov      x2, xzr
0169d8c4  d9d92094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169d8c8  f80300aa  mov      x24, x0
0169d8cc  400340f9  ldr      x0, [x26]
0169d8d0  d60e40f9  ldr      x22, [x22, #0x18]
0169d8d4  089c4439  ldrb     w8, [x0, #0x127]
0169d8d8  88000836  tbz      w8, #1, #0x169d8e8
0169d8dc  08d840b9  ldr      w8, [x0, #0xd8]
0169d8e0  48000035  cbnz     w8, #0x169d8e8
0169d8e4  21dad997  bl       #0xd14168 ; unresolved symbol
0169d8e8  e00319aa  mov      x0, x25
0169d8ec  e10316aa  mov      x1, x22
0169d8f0  e2031faa  mov      x2, xzr
0169d8f4  cdd92094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169d8f8  e10318aa  mov      x1, x24
0169d8fc  e2031faa  mov      x2, xzr
0169d900  95d92094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169d904  e10317aa  mov      x1, x23
0169d908  e2031faa  mov      x2, xzr
0169d90c  c1d92094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169d910  e01b00f9  str      x0, [sp, #0x30]
0169d914  e0c30091  add      x0, sp, #0x30
0169d918  e1031faa  mov      x1, xzr
0169d91c  91de2094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169d920  f603002a  mov      w22, w0
0169d924  730000b5  cbnz     x19, #0x169d930
0169d928  e0031faa  mov      x0, xzr
0169d92c  8037da97  bl       #0xd2b72c ; unresolved symbol
0169d930  e8030032  mov      w8, #1
0169d934  e003162a  mov      w0, w22
0169d938  68c20139  strb     w8, [x19, #0x70]
0169d93c  96010014  b        #0x169df94
0169d940  980340f9  ldr      x24, [x28]
0169d944  780000b5  cbnz     x24, #0x169d950
0169d948  e0031faa  mov      x0, xzr
0169d94c  7837da97  bl       #0xd2b72c ; unresolved symbol
0169d950  e00318aa  mov      x0, x24
0169d954  e1031faa  mov      x1, xzr
0169d958  23cc0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d95c  f80300aa  mov      x24, x0
0169d960  580000b5  cbnz     x24, #0x169d968
0169d964  7237da97  bl       #0xd2b72c ; unresolved symbol
0169d968  e00318aa  mov      x0, x24
0169d96c  e1031faa  mov      x1, xzr
0169d970  21cc0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d974  f80300aa  mov      x24, x0
0169d978  580000b5  cbnz     x24, #0x169d980
0169d97c  6c37da97  bl       #0xd2b72c ; unresolved symbol
0169d980  990e40f9  ldr      x25, [x20, #0x18]
0169d984  18d340f9  ldr      x24, [x24, #0x1a0]
0169d988  790000b5  cbnz     x25, #0x169d994
0169d98c  e0031faa  mov      x0, xzr
0169d990  6737da97  bl       #0xd2b72c ; unresolved symbol
0169d994  e00319aa  mov      x0, x25
0169d998  e1031faa  mov      x1, xzr
0169d99c  12cc0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d9a0  f90300aa  mov      x25, x0
0169d9a4  590000b5  cbnz     x25, #0x169d9ac
0169d9a8  6137da97  bl       #0xd2b72c ; unresolved symbol
0169d9ac  e00319aa  mov      x0, x25
0169d9b0  e1031faa  mov      x1, xzr
0169d9b4  10cc0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169d9b8  f90300aa  mov      x25, x0
0169d9bc  590000b5  cbnz     x25, #0x169d9c4
0169d9c0  5b37da97  bl       #0xd2b72c ; unresolved symbol
0169d9c4  39bf40f9  ldr      x25, [x25, #0x178]
0169d9c8  732900b5  cbnz     x19, #0x169def4
0169d9cc  48010014  b        #0x169deec
0169d9d0  980340f9  ldr      x24, [x28]
0169d9d4  780000b5  cbnz     x24, #0x169d9e0
0169d9d8  e0031faa  mov      x0, xzr
0169d9dc  5437da97  bl       #0xd2b72c ; unresolved symbol
0169d9e0  e00318aa  mov      x0, x24
0169d9e4  e1031faa  mov      x1, xzr
0169d9e8  ffcb0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169d9ec  f80300aa  mov      x24, x0
0169d9f0  580000b5  cbnz     x24, #0x169d9f8
0169d9f4  4e37da97  bl       #0xd2b72c ; unresolved symbol
0169d9f8  e00318aa  mov      x0, x24
0169d9fc  e1031faa  mov      x1, xzr
0169da00  fdcb0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169da04  f80300aa  mov      x24, x0
0169da08  580000b5  cbnz     x24, #0x169da10
0169da0c  4837da97  bl       #0xd2b72c ; unresolved symbol
0169da10  990e40f9  ldr      x25, [x20, #0x18]
0169da14  18d740f9  ldr      x24, [x24, #0x1a8]
0169da18  790000b5  cbnz     x25, #0x169da24
0169da1c  e0031faa  mov      x0, xzr
0169da20  4337da97  bl       #0xd2b72c ; unresolved symbol
0169da24  e00319aa  mov      x0, x25
0169da28  e1031faa  mov      x1, xzr
0169da2c  eecb0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169da30  f90300aa  mov      x25, x0
0169da34  590000b5  cbnz     x25, #0x169da3c
0169da38  3d37da97  bl       #0xd2b72c ; unresolved symbol
0169da3c  e00319aa  mov      x0, x25
0169da40  e1031faa  mov      x1, xzr
0169da44  eccb0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169da48  f90300aa  mov      x25, x0
0169da4c  590000b5  cbnz     x25, #0x169da54
0169da50  3737da97  bl       #0xd2b72c ; unresolved symbol
0169da54  39c340f9  ldr      x25, [x25, #0x180]
0169da58  f32400b5  cbnz     x19, #0x169def4
0169da5c  24010014  b        #0x169deec
0169da60  980340f9  ldr      x24, [x28]
0169da64  780000b5  cbnz     x24, #0x169da70
0169da68  e0031faa  mov      x0, xzr
0169da6c  3037da97  bl       #0xd2b72c ; unresolved symbol
0169da70  e00318aa  mov      x0, x24
0169da74  e1031faa  mov      x1, xzr
0169da78  dbcb0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169da7c  f80300aa  mov      x24, x0
0169da80  580000b5  cbnz     x24, #0x169da88
0169da84  2a37da97  bl       #0xd2b72c ; unresolved symbol
0169da88  e00318aa  mov      x0, x24
0169da8c  e1031faa  mov      x1, xzr
0169da90  d9cb0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169da94  f80300aa  mov      x24, x0
0169da98  580000b5  cbnz     x24, #0x169daa0
0169da9c  2437da97  bl       #0xd2b72c ; unresolved symbol
0169daa0  990e40f9  ldr      x25, [x20, #0x18]
0169daa4  18db40f9  ldr      x24, [x24, #0x1b0]
0169daa8  790000b5  cbnz     x25, #0x169dab4
0169daac  e0031faa  mov      x0, xzr
0169dab0  1f37da97  bl       #0xd2b72c ; unresolved symbol
0169dab4  e00319aa  mov      x0, x25
0169dab8  e1031faa  mov      x1, xzr
0169dabc  cacb0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169dac0  f90300aa  mov      x25, x0
0169dac4  590000b5  cbnz     x25, #0x169dacc
0169dac8  1937da97  bl       #0xd2b72c ; unresolved symbol
0169dacc  e00319aa  mov      x0, x25
0169dad0  e1031faa  mov      x1, xzr
0169dad4  c8cb0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169dad8  f90300aa  mov      x25, x0
0169dadc  590000b5  cbnz     x25, #0x169dae4
0169dae0  1337da97  bl       #0xd2b72c ; unresolved symbol
0169dae4  39c740f9  ldr      x25, [x25, #0x188]
0169dae8  732000b5  cbnz     x19, #0x169def4
0169daec  00010014  b        #0x169deec
0169daf0  980340f9  ldr      x24, [x28]
0169daf4  780000b5  cbnz     x24, #0x169db00
0169daf8  e0031faa  mov      x0, xzr
0169dafc  0c37da97  bl       #0xd2b72c ; unresolved symbol
0169db00  e00318aa  mov      x0, x24
0169db04  e1031faa  mov      x1, xzr
0169db08  b7cb0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169db0c  f80300aa  mov      x24, x0
0169db10  580000b5  cbnz     x24, #0x169db18
0169db14  0637da97  bl       #0xd2b72c ; unresolved symbol
0169db18  e00318aa  mov      x0, x24
0169db1c  e1031faa  mov      x1, xzr
0169db20  b5cb0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169db24  f80300aa  mov      x24, x0
0169db28  580000b5  cbnz     x24, #0x169db30
0169db2c  0037da97  bl       #0xd2b72c ; unresolved symbol
0169db30  990e40f9  ldr      x25, [x20, #0x18]
0169db34  18df40f9  ldr      x24, [x24, #0x1b8]
0169db38  790000b5  cbnz     x25, #0x169db44
0169db3c  e0031faa  mov      x0, xzr
0169db40  fb36da97  bl       #0xd2b72c ; unresolved symbol
0169db44  e00319aa  mov      x0, x25
0169db48  e1031faa  mov      x1, xzr
0169db4c  a6cb0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169db50  f90300aa  mov      x25, x0
0169db54  590000b5  cbnz     x25, #0x169db5c
0169db58  f536da97  bl       #0xd2b72c ; unresolved symbol
0169db5c  e00319aa  mov      x0, x25
0169db60  e1031faa  mov      x1, xzr
0169db64  a4cb0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169db68  f90300aa  mov      x25, x0
0169db6c  590000b5  cbnz     x25, #0x169db74
0169db70  ef36da97  bl       #0xd2b72c ; unresolved symbol
0169db74  39cb40f9  ldr      x25, [x25, #0x190]
0169db78  f31b00b5  cbnz     x19, #0x169def4
0169db7c  dc000014  b        #0x169deec
0169db80  970340f9  ldr      x23, [x28]
0169db84  770000b5  cbnz     x23, #0x169db90
0169db88  e0031faa  mov      x0, xzr
0169db8c  e836da97  bl       #0xd2b72c ; unresolved symbol
0169db90  e00317aa  mov      x0, x23
0169db94  e1031faa  mov      x1, xzr
0169db98  93cb0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169db9c  f70300aa  mov      x23, x0
0169dba0  570000b5  cbnz     x23, #0x169dba8
0169dba4  e236da97  bl       #0xd2b72c ; unresolved symbol
0169dba8  e00317aa  mov      x0, x23
0169dbac  e1031faa  mov      x1, xzr
0169dbb0  91cb0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169dbb4  f70300aa  mov      x23, x0
0169dbb8  570000b5  cbnz     x23, #0x169dbc0
0169dbbc  dc36da97  bl       #0xd2b72c ; unresolved symbol
0169dbc0  980340f9  ldr      x24, [x28]
0169dbc4  f7ce40f9  ldr      x23, [x23, #0x198]
0169dbc8  780000b5  cbnz     x24, #0x169dbd4
0169dbcc  e0031faa  mov      x0, xzr
0169dbd0  d736da97  bl       #0xd2b72c ; unresolved symbol
0169dbd4  e00318aa  mov      x0, x24
0169dbd8  e1031faa  mov      x1, xzr
0169dbdc  82cb0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169dbe0  f80300aa  mov      x24, x0
0169dbe4  580000b5  cbnz     x24, #0x169dbec
0169dbe8  d136da97  bl       #0xd2b72c ; unresolved symbol
0169dbec  e00318aa  mov      x0, x24
0169dbf0  e1031faa  mov      x1, xzr
0169dbf4  80cb0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169dbf8  f80300aa  mov      x24, x0
0169dbfc  580000b5  cbnz     x24, #0x169dc04
0169dc00  cb36da97  bl       #0xd2b72c ; unresolved symbol
0169dc04  600340f9  ldr      x0, [x27]
0169dc08  18d340f9  ldr      x24, [x24, #0x1a0]
0169dc0c  089c4439  ldrb     w8, [x0, #0x127]
0169dc10  88000836  tbz      w8, #1, #0x169dc20
0169dc14  08d840b9  ldr      w8, [x0, #0xd8]
0169dc18  48000035  cbnz     w8, #0x169dc20
0169dc1c  53d9d997  bl       #0xd14168 ; unresolved symbol
0169dc20  e00317aa  mov      x0, x23
0169dc24  e10318aa  mov      x1, x24
0169dc28  e2031faa  mov      x2, xzr
0169dc2c  cad82094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169dc30  980340f9  ldr      x24, [x28]
0169dc34  f70300aa  mov      x23, x0
0169dc38  780000b5  cbnz     x24, #0x169dc44
0169dc3c  e0031faa  mov      x0, xzr
0169dc40  bb36da97  bl       #0xd2b72c ; unresolved symbol
0169dc44  e00318aa  mov      x0, x24
0169dc48  e1031faa  mov      x1, xzr
0169dc4c  66cb0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169dc50  f80300aa  mov      x24, x0
0169dc54  580000b5  cbnz     x24, #0x169dc5c
0169dc58  b536da97  bl       #0xd2b72c ; unresolved symbol
0169dc5c  e00318aa  mov      x0, x24
0169dc60  e1031faa  mov      x1, xzr
0169dc64  64cb0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169dc68  f80300aa  mov      x24, x0
0169dc6c  580000b5  cbnz     x24, #0x169dc74
0169dc70  af36da97  bl       #0xd2b72c ; unresolved symbol
0169dc74  01d740f9  ldr      x1, [x24, #0x1a8]
0169dc78  e00317aa  mov      x0, x23
0169dc7c  e2031faa  mov      x2, xzr
0169dc80  b5d82094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169dc84  980340f9  ldr      x24, [x28]
0169dc88  f70300aa  mov      x23, x0
0169dc8c  780000b5  cbnz     x24, #0x169dc98
0169dc90  e0031faa  mov      x0, xzr
0169dc94  a636da97  bl       #0xd2b72c ; unresolved symbol
0169dc98  e00318aa  mov      x0, x24
0169dc9c  e1031faa  mov      x1, xzr
0169dca0  51cb0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169dca4  f80300aa  mov      x24, x0
0169dca8  580000b5  cbnz     x24, #0x169dcb0
0169dcac  a036da97  bl       #0xd2b72c ; unresolved symbol
0169dcb0  e00318aa  mov      x0, x24
0169dcb4  e1031faa  mov      x1, xzr
0169dcb8  4fcb0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169dcbc  f80300aa  mov      x24, x0
0169dcc0  580000b5  cbnz     x24, #0x169dcc8
0169dcc4  9a36da97  bl       #0xd2b72c ; unresolved symbol
0169dcc8  01db40f9  ldr      x1, [x24, #0x1b0]
0169dccc  e00317aa  mov      x0, x23
0169dcd0  e2031faa  mov      x2, xzr
0169dcd4  a0d82094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169dcd8  980340f9  ldr      x24, [x28]
0169dcdc  f70300aa  mov      x23, x0
0169dce0  780000b5  cbnz     x24, #0x169dcec
0169dce4  e0031faa  mov      x0, xzr
0169dce8  9136da97  bl       #0xd2b72c ; unresolved symbol
0169dcec  e00318aa  mov      x0, x24
0169dcf0  e1031faa  mov      x1, xzr
0169dcf4  3ccb0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169dcf8  f80300aa  mov      x24, x0
0169dcfc  580000b5  cbnz     x24, #0x169dd04
0169dd00  8b36da97  bl       #0xd2b72c ; unresolved symbol
0169dd04  e00318aa  mov      x0, x24
0169dd08  e1031faa  mov      x1, xzr
0169dd0c  3acb0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169dd10  f80300aa  mov      x24, x0
0169dd14  580000b5  cbnz     x24, #0x169dd1c
0169dd18  8536da97  bl       #0xd2b72c ; unresolved symbol
0169dd1c  01df40f9  ldr      x1, [x24, #0x1b8]
0169dd20  e00317aa  mov      x0, x23
0169dd24  e2031faa  mov      x2, xzr
0169dd28  8bd82094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169dd2c  d71240f9  ldr      x23, [x22, #0x20]
0169dd30  f80300aa  mov      x24, x0
0169dd34  a0008052  mov      w0, #5
0169dd38  e1031faa  mov      x1, xzr
0169dd3c  9dd92094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169dd40  e10300aa  mov      x1, x0
0169dd44  e00317aa  mov      x0, x23
0169dd48  e2031faa  mov      x2, xzr
0169dd4c  b7d82094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169dd50  990e40f9  ldr      x25, [x20, #0x18]
0169dd54  f70300aa  mov      x23, x0
0169dd58  790000b5  cbnz     x25, #0x169dd64
0169dd5c  e0031faa  mov      x0, xzr
0169dd60  7336da97  bl       #0xd2b72c ; unresolved symbol
0169dd64  e00319aa  mov      x0, x25
0169dd68  e1031faa  mov      x1, xzr
0169dd6c  1ecb0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169dd70  f90300aa  mov      x25, x0
0169dd74  590000b5  cbnz     x25, #0x169dd7c
0169dd78  6d36da97  bl       #0xd2b72c ; unresolved symbol
0169dd7c  e00319aa  mov      x0, x25
0169dd80  e1031faa  mov      x1, xzr
0169dd84  1ccb0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169dd88  f90300aa  mov      x25, x0
0169dd8c  590000b5  cbnz     x25, #0x169dd94
0169dd90  6736da97  bl       #0xd2b72c ; unresolved symbol
0169dd94  9a0e40f9  ldr      x26, [x20, #0x18]
0169dd98  39bb40f9  ldr      x25, [x25, #0x170]
0169dd9c  7a0000b5  cbnz     x26, #0x169dda8
0169dda0  e0031faa  mov      x0, xzr
0169dda4  6236da97  bl       #0xd2b72c ; unresolved symbol
0169dda8  e0031aaa  mov      x0, x26
0169ddac  e1031faa  mov      x1, xzr
0169ddb0  0dcb0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169ddb4  fa0300aa  mov      x26, x0
0169ddb8  5a0000b5  cbnz     x26, #0x169ddc0
0169ddbc  5c36da97  bl       #0xd2b72c ; unresolved symbol
0169ddc0  e0031aaa  mov      x0, x26
0169ddc4  e1031faa  mov      x1, xzr
0169ddc8  0bcb0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169ddcc  fa0300aa  mov      x26, x0
0169ddd0  5a0000b5  cbnz     x26, #0x169ddd8
0169ddd4  5636da97  bl       #0xd2b72c ; unresolved symbol
0169ddd8  41bf40f9  ldr      x1, [x26, #0x178]
0169dddc  e00319aa  mov      x0, x25
0169dde0  e2031faa  mov      x2, xzr
0169dde4  5cd82094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169dde8  9a0e40f9  ldr      x26, [x20, #0x18]
0169ddec  f90300aa  mov      x25, x0
0169ddf0  7a0000b5  cbnz     x26, #0x169ddfc
0169ddf4  e0031faa  mov      x0, xzr
0169ddf8  4d36da97  bl       #0xd2b72c ; unresolved symbol
0169ddfc  e0031aaa  mov      x0, x26
0169de00  e1031faa  mov      x1, xzr
0169de04  f8ca0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169de08  fa0300aa  mov      x26, x0
0169de0c  5a0000b5  cbnz     x26, #0x169de14
0169de10  4736da97  bl       #0xd2b72c ; unresolved symbol
0169de14  e0031aaa  mov      x0, x26
0169de18  e1031faa  mov      x1, xzr
0169de1c  f6ca0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169de20  fa0300aa  mov      x26, x0
0169de24  5a0000b5  cbnz     x26, #0x169de2c
0169de28  4136da97  bl       #0xd2b72c ; unresolved symbol
0169de2c  41c340f9  ldr      x1, [x26, #0x180]
0169de30  e00319aa  mov      x0, x25
0169de34  e2031faa  mov      x2, xzr
0169de38  47d82094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169de3c  9a0e40f9  ldr      x26, [x20, #0x18]
0169de40  f90300aa  mov      x25, x0
0169de44  7a0000b5  cbnz     x26, #0x169de50
0169de48  e0031faa  mov      x0, xzr
0169de4c  3836da97  bl       #0xd2b72c ; unresolved symbol
0169de50  e0031aaa  mov      x0, x26
0169de54  e1031faa  mov      x1, xzr
0169de58  e3ca0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169de5c  fa0300aa  mov      x26, x0
0169de60  5a0000b5  cbnz     x26, #0x169de68
0169de64  3236da97  bl       #0xd2b72c ; unresolved symbol
0169de68  e0031aaa  mov      x0, x26
0169de6c  e1031faa  mov      x1, xzr
0169de70  e1ca0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169de74  fa0300aa  mov      x26, x0
0169de78  5a0000b5  cbnz     x26, #0x169de80
0169de7c  2c36da97  bl       #0xd2b72c ; unresolved symbol
0169de80  41c740f9  ldr      x1, [x26, #0x188]
0169de84  e00319aa  mov      x0, x25
0169de88  e2031faa  mov      x2, xzr
0169de8c  32d82094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169de90  9a0e40f9  ldr      x26, [x20, #0x18]
0169de94  f90300aa  mov      x25, x0
0169de98  7a0000b5  cbnz     x26, #0x169dea4
0169de9c  e0031faa  mov      x0, xzr
0169dea0  2336da97  bl       #0xd2b72c ; unresolved symbol
0169dea4  e0031aaa  mov      x0, x26
0169dea8  e1031faa  mov      x1, xzr
0169deac  ceca0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169deb0  fa0300aa  mov      x26, x0
0169deb4  5a0000b5  cbnz     x26, #0x169debc
0169deb8  1d36da97  bl       #0xd2b72c ; unresolved symbol
0169debc  e0031aaa  mov      x0, x26
0169dec0  e1031faa  mov      x1, xzr
0169dec4  ccca0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169dec8  fa0300aa  mov      x26, x0
0169decc  5a0000b5  cbnz     x26, #0x169ded4
0169ded0  1736da97  bl       #0xd2b72c ; unresolved symbol
0169ded4  41cb40f9  ldr      x1, [x26, #0x190]
0169ded8  e00319aa  mov      x0, x25
0169dedc  e2031faa  mov      x2, xzr
0169dee0  1dd82094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169dee4  f90300aa  mov      x25, x0
0169dee8  730000b5  cbnz     x19, #0x169def4
0169deec  e0031faa  mov      x0, xzr
0169def0  0f36da97  bl       #0xd2b72c ; unresolved symbol
0169def4  e8030032  mov      w8, #1
0169def8  68c20139  strb     w8, [x19, #0x70]
0169defc  9a0e40f9  ldr      x26, [x20, #0x18]
0169df00  7a0000b5  cbnz     x26, #0x169df0c
0169df04  e0031faa  mov      x0, xzr
0169df08  0936da97  bl       #0xd2b72c ; unresolved symbol
0169df0c  e0031aaa  mov      x0, x26
0169df10  e1031faa  mov      x1, xzr
0169df14  b4ca0294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169df18  fa0300aa  mov      x26, x0
0169df1c  5a0000b5  cbnz     x26, #0x169df24
0169df20  0336da97  bl       #0xd2b72c ; unresolved symbol
0169df24  e0031aaa  mov      x0, x26
0169df28  e1031faa  mov      x1, xzr
0169df2c  b2ca0294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169df30  fa0300aa  mov      x26, x0
0169df34  5a0000b5  cbnz     x26, #0x169df3c
0169df38  fd35da97  bl       #0xd2b72c ; unresolved symbol
0169df3c  600340f9  ldr      x0, [x27]
0169df40  5a0f40f9  ldr      x26, [x26, #0x18]
0169df44  d60e40f9  ldr      x22, [x22, #0x18]
0169df48  089c4439  ldrb     w8, [x0, #0x127]
0169df4c  88000836  tbz      w8, #1, #0x169df5c
0169df50  08d840b9  ldr      w8, [x0, #0xd8]
0169df54  48000035  cbnz     w8, #0x169df5c
0169df58  84d8d997  bl       #0xd14168 ; unresolved symbol
0169df5c  e0031aaa  mov      x0, x26
0169df60  e10316aa  mov      x1, x22
0169df64  e2031faa  mov      x2, xzr
0169df68  30d82094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169df6c  e10317aa  mov      x1, x23
0169df70  e2031faa  mov      x2, xzr
0169df74  f8d72094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169df78  e10318aa  mov      x1, x24
0169df7c  e2031faa  mov      x2, xzr
0169df80  24d82094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169df84  e01b00f9  str      x0, [sp, #0x30]
0169df88  e0c30091  add      x0, sp, #0x30
0169df8c  e1031faa  mov      x1, xzr
0169df90  f4dc2094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169df94  e1031faa  mov      x1, xzr
0169df98  06d92094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169df9c  28b100f0  adrp     x8, #0x2cc4000
0169dfa0  08f946f9  ldr      x8, [x8, #0xdf0]
0169dfa4  f60300aa  mov      x22, x0
0169dfa8  080140f9  ldr      x8, [x8]
0169dfac  099d4439  ldrb     w9, [x8, #0x127]
0169dfb0  a9000836  tbz      w9, #1, #0x169dfc4
0169dfb4  09d940b9  ldr      w9, [x8, #0xd8]
0169dfb8  69000035  cbnz     w9, #0x169dfc4
0169dfbc  e00308aa  mov      x0, x8
0169dfc0  6ad8d997  bl       #0xd14168 ; unresolved symbol
0169dfc4  e00319aa  mov      x0, x25
0169dfc8  e10316aa  mov      x1, x22
0169dfcc  46080094  bl       #0x16a00e4 ; A3BattleCore.SkillDamageHelper$$GetFiveEleMiniDamage
0169dfd0  e01b00f9  str      x0, [sp, #0x30]
0169dfd4  e0c30091  add      x0, sp, #0x30
0169dfd8  e1031faa  mov      x1, xzr
0169dfdc  e1dc2094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169dfe0  607600b9  str      w0, [x19, #0x74]
0169dfe4  960340f9  ldr      x22, [x28]
0169dfe8  e0031f2a  mov      w0, wzr
0169dfec  e1031faa  mov      x1, xzr
0169dff0  f0d82094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169dff4  e20316aa  mov      x2, x22
0169dff8  e30314aa  mov      x3, x20
0169dffc  e40313aa  mov      x4, x19
0169e000  e5031f2a  mov      w5, wzr
0169e004  f50300f9  str      x21, [sp]
0169e008  70080094  bl       #0x16a01c8 ; A3BattleCore.SkillDamageHelper$$DoCalcDamageWithFiveEle
0169e00c  d31dffb5  cbnz     x19, #0x169c3c4
0169e010  ebf8ff17  b        #0x169c3bc
0169e014  e0031faa  mov      x0, xzr
0169e018  c535da97  bl       #0xd2b72c ; unresolved symbol
0169e01c  08478052  mov      w8, #0x238
0169e020  080140f9  ldr      x8, [x8]
0169e024  e0031faa  mov      x0, xzr
0169e028  e81300f9  str      x8, [sp, #0x20]
0169e02c  c035da97  bl       #0xd2b72c ; unresolved symbol
0169e030  155c8052  mov      w21, #0x2e0
0169e034  b90240f9  ldr      x25, [x21]
0169e038  e0031faa  mov      x0, xzr
0169e03c  bc35da97  bl       #0xd2b72c ; unresolved symbol
0169e040  b50240f9  ldr      x21, [x21]
0169e044  e0031faa  mov      x0, xzr
0169e048  b935da97  bl       #0xd2b72c ; unresolved symbol
0169e04c  db2641f9  ldr      x27, [x22, #0x248]
0169e050  f6070032  mov      w22, #3
0169e054  36000014  b        #0x169e12c
0169e058  e0031faa  mov      x0, xzr
0169e05c  b435da97  bl       #0xd2b72c ; unresolved symbol
0169e060  e8171d32  mov      w8, #0x1f8
0169e064  080140f9  ldr      x8, [x8]
0169e068  e0031faa  mov      x0, xzr
0169e06c  e81300f9  str      x8, [sp, #0x20]
0169e070  af35da97  bl       #0xd2b72c ; unresolved symbol
0169e074  08588052  mov      w8, #0x2c0
0169e078  190140f9  ldr      x25, [x8]
0169e07c  e0031faa  mov      x0, xzr
0169e080  ab35da97  bl       #0xd2b72c ; unresolved symbol
0169e084  08598052  mov      w8, #0x2c8
0169e088  150140f9  ldr      x21, [x8]
0169e08c  e0031faa  mov      x0, xzr
0169e090  a735da97  bl       #0xd2b72c ; unresolved symbol
0169e094  db0641f9  ldr      x27, [x22, #0x208]
0169e098  f6030032  mov      w22, #1
0169e09c  24000014  b        #0x169e12c
0169e0a0  e0031faa  mov      x0, xzr
0169e0a4  a235da97  bl       #0xd2b72c ; unresolved symbol
0169e0a8  08438052  mov      w8, #0x218
0169e0ac  080140f9  ldr      x8, [x8]
0169e0b0  e0031faa  mov      x0, xzr
0169e0b4  e81300f9  str      x8, [sp, #0x20]
0169e0b8  9d35da97  bl       #0xd2b72c ; unresolved symbol
0169e0bc  085a8052  mov      w8, #0x2d0
0169e0c0  190140f9  ldr      x25, [x8]
0169e0c4  e0031faa  mov      x0, xzr
0169e0c8  9935da97  bl       #0xd2b72c ; unresolved symbol
0169e0cc  085b8052  mov      w8, #0x2d8
0169e0d0  150140f9  ldr      x21, [x8]
0169e0d4  e0031faa  mov      x0, xzr
0169e0d8  9535da97  bl       #0xd2b72c ; unresolved symbol
0169e0dc  db1641f9  ldr      x27, [x22, #0x228]
0169e0e0  f6031f32  mov      w22, #2
0169e0e4  12000014  b        #0x169e12c
0169e0e8  e0031faa  mov      x0, xzr
0169e0ec  9035da97  bl       #0xd2b72c ; unresolved symbol
0169e0f0  083b8052  mov      w8, #0x1d8
0169e0f4  080140f9  ldr      x8, [x8]
0169e0f8  e0031faa  mov      x0, xzr
0169e0fc  e81300f9  str      x8, [sp, #0x20]
0169e100  8b35da97  bl       #0xd2b72c ; unresolved symbol
0169e104  08568052  mov      w8, #0x2b0
0169e108  190140f9  ldr      x25, [x8]
0169e10c  e0031faa  mov      x0, xzr
0169e110  8735da97  bl       #0xd2b72c ; unresolved symbol
0169e114  08578052  mov      w8, #0x2b8
0169e118  150140f9  ldr      x21, [x8]
0169e11c  e0031faa  mov      x0, xzr
0169e120  8335da97  bl       #0xd2b72c ; unresolved symbol
0169e124  dbf640f9  ldr      x27, [x22, #0x1e8]
0169e128  f6031f2a  mov      w22, wzr
0169e12c  e00317aa  mov      x0, x23
0169e130  e10319aa  mov      x1, x25
0169e134  78080094  bl       #0x16a0314 ; A3BattleCore.SkillDamageHelper$$TestRate
0169e138  600c0036  tbz      w0, #0, #0x169e2c4
0169e13c  400340f9  ldr      x0, [x26]
0169e140  f71340f9  ldr      x23, [sp, #0x20]
0169e144  089c4439  ldrb     w8, [x0, #0x127]
0169e148  88000836  tbz      w8, #1, #0x169e158
0169e14c  08d840b9  ldr      w8, [x0, #0xd8]
0169e150  48000035  cbnz     w8, #0x169e158
0169e154  05d8d997  bl       #0xd14168 ; unresolved symbol
0169e158  e0030032  mov      w0, #1
0169e15c  e1031faa  mov      x1, xzr
0169e160  94d82094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169e164  e10315aa  mov      x1, x21
0169e168  e2031faa  mov      x2, xzr
0169e16c  7ad72094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169e170  e10300aa  mov      x1, x0
0169e174  e00317aa  mov      x0, x23
0169e178  e2031faa  mov      x2, xzr
0169e17c  abd72094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169e180  f70300aa  mov      x23, x0
0169e184  730000b5  cbnz     x19, #0x169e190
0169e188  e0031faa  mov      x0, xzr
0169e18c  6835da97  bl       #0xd2b72c ; unresolved symbol
0169e190  e8030032  mov      w8, #1
0169e194  68e20139  strb     w8, [x19, #0x78]
0169e198  400340f9  ldr      x0, [x26]
0169e19c  089c4439  ldrb     w8, [x0, #0x127]
0169e1a0  a8000836  tbz      w8, #1, #0x169e1b4
0169e1a4  08d840b9  ldr      w8, [x0, #0xd8]
0169e1a8  68000035  cbnz     w8, #0x169e1b4
0169e1ac  efd7d997  bl       #0xd14168 ; unresolved symbol
0169e1b0  400340f9  ldr      x0, [x26]
0169e1b4  085c40f9  ldr      x8, [x0, #0xb8]
0169e1b8  e10b40f9  ldr      x1, [sp, #0x10]
0169e1bc  e00317aa  mov      x0, x23
0169e1c0  e2031faa  mov      x2, xzr
0169e1c4  151940f9  ldr      x21, [x8, #0x30]
0169e1c8  98d72094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169e1cc  e10f40f9  ldr      x1, [sp, #0x18]
0169e1d0  e2031faa  mov      x2, xzr
0169e1d4  8fd72094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169e1d8  48b200b0  adrp     x8, #0x2ce7000
0169e1dc  086942f9  ldr      x8, [x8, #0x4d0]
0169e1e0  f70300aa  mov      x23, x0
0169e1e4  080140f9  ldr      x8, [x8]
0169e1e8  099d4439  ldrb     w9, [x8, #0x127]
0169e1ec  a9000836  tbz      w9, #1, #0x169e200
0169e1f0  09d940b9  ldr      w9, [x8, #0xd8]
0169e1f4  69000035  cbnz     w9, #0x169e200
0169e1f8  e00308aa  mov      x0, x8
0169e1fc  dbd7d997  bl       #0xd14168 ; unresolved symbol
0169e200  e00315aa  mov      x0, x21
0169e204  e10317aa  mov      x1, x23
0169e208  e2031faa  mov      x2, xzr
0169e20c  6d032c94  bl       #0x219efc0 ; BattleCore.TSMath$$Max
0169e210  e1031baa  mov      x1, x27
0169e214  e2031faa  mov      x2, xzr
0169e218  84d72094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169e21c  e10318aa  mov      x1, x24
0169e220  e2031faa  mov      x2, xzr
0169e224  4cd72094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169e228  e01f00f9  str      x0, [sp, #0x38]
0169e22c  754240f9  ldr      x21, [x19, #0x80]
0169e230  750000b5  cbnz     x21, #0x169e23c
0169e234  e0031faa  mov      x0, xzr
0169e238  3d35da97  bl       #0xd2b72c ; unresolved symbol
0169e23c  a81a40b9  ldr      w8, [x21, #0x18]
0169e240  df02086b  cmp      w22, w8
0169e244  a3000054  b.lo     #0x169e258
0169e248  7238da97  bl       #0xd2c410 ; unresolved symbol
0169e24c  e1031faa  mov      x1, xzr
0169e250  e2031faa  mov      x2, xzr
0169e254  1235da97  bl       #0xd2b69c ; unresolved symbol
0169e258  a802168b  add      x8, x21, x22
0169e25c  e9030032  mov      w9, #1
0169e260  09810039  strb     w9, [x8, #0x20]
0169e264  774640f9  ldr      x23, [x19, #0x88]
0169e268  e0e30091  add      x0, sp, #0x38
0169e26c  e1031faa  mov      x1, xzr
0169e270  3cdc2094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169e274  f503002a  mov      w21, w0
0169e278  770000b5  cbnz     x23, #0x169e284
0169e27c  e0031faa  mov      x0, xzr
0169e280  2b35da97  bl       #0xd2b72c ; unresolved symbol
0169e284  e81a40b9  ldr      w8, [x23, #0x18]
0169e288  df02086b  cmp      w22, w8
0169e28c  a3000054  b.lo     #0x169e2a0
0169e290  6038da97  bl       #0xd2c410 ; unresolved symbol
0169e294  e1031faa  mov      x1, xzr
0169e298  e2031faa  mov      x2, xzr
0169e29c  0035da97  bl       #0xd2b69c ; unresolved symbol
0169e2a0  e80a168b  add      x8, x23, x22, lsl #2
0169e2a4  152100b9  str      w21, [x8, #0x20]
0169e2a8  820340f9  ldr      x2, [x28]
0169e2ac  e30314aa  mov      x3, x20
0169e2b0  e40313aa  mov      x4, x19
0169e2b4  e503162a  mov      w5, w22
0169e2b8  45080094  bl       #0x16a03cc ; A3BattleCore.SkillDamageHelper$$DoCalcDamageWithFourEle
0169e2bc  5308ffb5  cbnz     x19, #0x169c3c4
0169e2c0  3ff8ff17  b        #0x169c3bc
0169e2c4  f71340f9  ldr      x23, [sp, #0x20]
0169e2c8  53f6ffb5  cbnz     x19, #0x169e190
0169e2cc  afffff17  b        #0x169e188
