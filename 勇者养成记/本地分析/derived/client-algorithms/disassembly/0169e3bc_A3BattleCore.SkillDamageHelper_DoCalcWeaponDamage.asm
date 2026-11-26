; RVA 0x169e3bc, file offset 0x169e3bc, conservative end 0x169fdb0
; SHA256 12f4d18ccd67970c91d30cb16c8fab14b378552c11700916ac53e120eed620b9
; All aliases at this entry: A3BattleCore.SkillDamageHelper$$DoCalcWeaponDamage :: void A3BattleCore_SkillDamageHelper__DoCalcWeaponDamage (A3BattleCore_SkillDamageHelper_o* __this, A3BattleCore_ActorEntity_o* sourceActor, A3BattleCore_ActorEntity_o* targetActor, A3BattleCore_HitInfo_o* hitInfo, A3BattleCore_DamageInfo_o* info, bool hasDefend, BattleCore_FP_o damageRatio, BattleCore_FP_o damageAdditive, BattleCore_FP_o fiveEleDamageRatio, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
0169e3bc  ff4303d1  sub      sp, sp, #0xd0
0169e3c0  fc6f07a9  stp      x28, x27, [sp, #0x70]
0169e3c4  fa6708a9  stp      x26, x25, [sp, #0x80]
0169e3c8  f85f09a9  stp      x24, x23, [sp, #0x90]
0169e3cc  f6570aa9  stp      x22, x21, [sp, #0xa0]
0169e3d0  f44f0ba9  stp      x20, x19, [sp, #0xb0]
0169e3d4  fd7b0ca9  stp      x29, x30, [sp, #0xc0]
0169e3d8  fd030391  add      x29, sp, #0xc0
0169e3dc  14c500b0  adrp     x20, #0x2f3f000
0169e3e0  88027c39  ldrb     w8, [x20, #0xf00]
0169e3e4  f90307aa  mov      x25, x7
0169e3e8  fb0306aa  mov      x27, x6
0169e3ec  f803052a  mov      w24, w5
0169e3f0  f30304aa  mov      x19, x4
0169e3f4  fc0303aa  mov      x28, x3
0169e3f8  f50302aa  mov      x21, x2
0169e3fc  f60301aa  mov      x22, x1
0169e400  fa0300aa  mov      x26, x0
0169e404  e8000037  tbnz     w8, #0, #0x169e420
0169e408  68af00f0  adrp     x8, #0x2c8d000
0169e40c  08a940f9  ldr      x8, [x8, #0x150]
0169e410  000140b9  ldr      w0, [x8]
0169e414  c59ad997  bl       #0xd04f28 ; unresolved symbol
0169e418  e8030032  mov      w8, #1
0169e41c  88023c39  strb     w8, [x20, #0xf00]
0169e420  e00315aa  mov      x0, x21
0169e424  e1031faa  mov      x1, xzr
0169e428  e2031faa  mov      x2, xzr
0169e42c  ffff05a9  stp      xzr, xzr, [sp, #0x58]
0169e430  ffff04a9  stp      xzr, xzr, [sp, #0x48]
0169e434  ffff03a9  stp      xzr, xzr, [sp, #0x38]
0169e438  ff1b00f9  str      xzr, [sp, #0x30]
0169e43c  f0b80294  bl       #0x174c7fc ; A3BattleCore.ActorEntity$$op_Inequality
0169e440  a0020036  tbz      w0, #0, #0x169e494
0169e444  750000b5  cbnz     x21, #0x169e450
0169e448  e0031faa  mov      x0, xzr
0169e44c  b834da97  bl       #0xd2b72c ; unresolved symbol
0169e450  e00315aa  mov      x0, x21
0169e454  e1031faa  mov      x1, xzr
0169e458  85b70294  bl       #0x174c26c ; A3BattleCore.ActorEntity$$get_BuffMgr
0169e45c  c00100b4  cbz      x0, #0x169e494
0169e460  750000b5  cbnz     x21, #0x169e46c
0169e464  e0031faa  mov      x0, xzr
0169e468  b134da97  bl       #0xd2b72c ; unresolved symbol
0169e46c  e00315aa  mov      x0, x21
0169e470  e1031faa  mov      x1, xzr
0169e474  7eb70294  bl       #0x174c26c ; A3BattleCore.ActorEntity$$get_BuffMgr
0169e478  f70300aa  mov      x23, x0
0169e47c  570000b5  cbnz     x23, #0x169e484
0169e480  ab34da97  bl       #0xd2b72c ; unresolved symbol
0169e484  e00317aa  mov      x0, x23
0169e488  e1031faa  mov      x1, xzr
0169e48c  20fffd97  bl       #0x161e10c ; A3BattleCore.BuffManger$$CanBeDamaged
0169e490  60140036  tbz      w0, #0, #0x169e71c
0169e494  540b40f9  ldr      x20, [x26, #0x10]
0169e498  740000b5  cbnz     x20, #0x169e4a4
0169e49c  e0031faa  mov      x0, xzr
0169e4a0  a334da97  bl       #0xd2b72c ; unresolved symbol
0169e4a4  88b24239  ldrb     w8, [x20, #0xac]
0169e4a8  c8040034  cbz      w8, #0x169e540
0169e4ac  760000b5  cbnz     x22, #0x169e4b8
0169e4b0  e0031faa  mov      x0, xzr
0169e4b4  9e34da97  bl       #0xd2b72c ; unresolved symbol
0169e4b8  e00316aa  mov      x0, x22
0169e4bc  e1031faa  mov      x1, xzr
0169e4c0  49c90294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169e4c4  f40300aa  mov      x20, x0
0169e4c8  540000b5  cbnz     x20, #0x169e4d0
0169e4cc  9834da97  bl       #0xd2b72c ; unresolved symbol
0169e4d0  e00314aa  mov      x0, x20
0169e4d4  e1031faa  mov      x1, xzr
0169e4d8  47c90294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169e4dc  f40300aa  mov      x20, x0
0169e4e0  540000b5  cbnz     x20, #0x169e4e8
0169e4e4  9234da97  bl       #0xd2b72c ; unresolved symbol
0169e4e8  48b200b0  adrp     x8, #0x2ce7000
0169e4ec  086942f9  ldr      x8, [x8, #0x4d0]
0169e4f0  940e40f9  ldr      x20, [x20, #0x18]
0169e4f4  000140f9  ldr      x0, [x8]
0169e4f8  089c4439  ldrb     w8, [x0, #0x127]
0169e4fc  88000836  tbz      w8, #1, #0x169e50c
0169e500  08d840b9  ldr      w8, [x0, #0xd8]
0169e504  48000035  cbnz     w8, #0x169e50c
0169e508  18d7d997  bl       #0xd14168 ; unresolved symbol
0169e50c  e00314aa  mov      x0, x20
0169e510  e1031faa  mov      x1, xzr
0169e514  ab102c94  bl       #0x21a27c0 ; BattleCore.TSMath$$Floor
0169e518  e02b00f9  str      x0, [sp, #0x50]
0169e51c  e0430191  add      x0, sp, #0x50
0169e520  e1031faa  mov      x1, xzr
0169e524  8fdb2094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169e528  f403002a  mov      w20, w0
0169e52c  730000b5  cbnz     x19, #0x169e538
0169e530  e0031faa  mov      x0, xzr
0169e534  7e34da97  bl       #0xd2b72c ; unresolved symbol
0169e538  741200b9  str      w20, [x19, #0x10]
0169e53c  97030014  b        #0x169f398
0169e540  34b100d0  adrp     x20, #0x2cc4000
0169e544  94fa46f9  ldr      x20, [x20, #0xdf0]
0169e548  800240f9  ldr      x0, [x20]
0169e54c  089c4439  ldrb     w8, [x0, #0x127]
0169e550  a8000836  tbz      w8, #1, #0x169e564
0169e554  08d840b9  ldr      w8, [x0, #0xd8]
0169e558  68000035  cbnz     w8, #0x169e564
0169e55c  03d7d997  bl       #0xd14168 ; unresolved symbol
0169e560  800240f9  ldr      x0, [x20]
0169e564  f80f00b9  str      w24, [sp, #0xc]
0169e568  085c40f9  ldr      x8, [x0, #0xb8]
0169e56c  170140f9  ldr      x23, [x8]
0169e570  750000b5  cbnz     x21, #0x169e57c
0169e574  e0031faa  mov      x0, xzr
0169e578  6d34da97  bl       #0xd2b72c ; unresolved symbol
0169e57c  e00315aa  mov      x0, x21
0169e580  e1031faa  mov      x1, xzr
0169e584  18c90294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169e588  f80300aa  mov      x24, x0
0169e58c  580000b5  cbnz     x24, #0x169e594
0169e590  6734da97  bl       #0xd2b72c ; unresolved symbol
0169e594  e00318aa  mov      x0, x24
0169e598  e1031faa  mov      x1, xzr
0169e59c  f90f00f9  str      x25, [sp, #0x18]
0169e5a0  15c90294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169e5a4  f80300aa  mov      x24, x0
0169e5a8  760000b5  cbnz     x22, #0x169e5b4
0169e5ac  e0031faa  mov      x0, xzr
0169e5b0  5f34da97  bl       #0xd2b72c ; unresolved symbol
0169e5b4  e00316aa  mov      x0, x22
0169e5b8  e1031faa  mov      x1, xzr
0169e5bc  0ac90294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169e5c0  f90300aa  mov      x25, x0
0169e5c4  590000b5  cbnz     x25, #0x169e5cc
0169e5c8  5934da97  bl       #0xd2b72c ; unresolved symbol
0169e5cc  e00319aa  mov      x0, x25
0169e5d0  e1031faa  mov      x1, xzr
0169e5d4  08c90294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169e5d8  f90300aa  mov      x25, x0
0169e5dc  770000b5  cbnz     x23, #0x169e5e8
0169e5e0  e0031faa  mov      x0, xzr
0169e5e4  5234da97  bl       #0xd2b72c ; unresolved symbol
0169e5e8  e00317aa  mov      x0, x23
0169e5ec  e10319aa  mov      x1, x25
0169e5f0  e2031faa  mov      x2, xzr
0169e5f4  92cc0294  bl       #0x175183c ; A3BattleCore.ActorAttrData$$Set
0169e5f8  7c0000b5  cbnz     x28, #0x169e604
0169e5fc  e0031faa  mov      x0, xzr
0169e600  4b34da97  bl       #0xd2b72c ; unresolved symbol
0169e604  821340b9  ldr      w2, [x28, #0x10]
0169e608  e10316aa  mov      x1, x22
0169e60c  b7070094  bl       #0x16a04e8 ; A3BattleCore.SkillDamageHelper$$GetActorZhaoShiImpactMgr
0169e610  800000b4  cbz      x0, #0x169e620
0169e614  e10317aa  mov      x1, x23
0169e618  e2031faa  mov      x2, xzr
0169e61c  7ad50294  bl       #0x1753c04 ; A3BattleCore.ActorAttrImpactMgr$$RefreshFinalAttr
0169e620  fb0b00f9  str      x27, [sp, #0x10]
0169e624  780000b5  cbnz     x24, #0x169e630
0169e628  e0031faa  mov      x0, xzr
0169e62c  4034da97  bl       #0xd2b72c ; unresolved symbol
0169e630  1b3b40f9  ldr      x27, [x24, #0x70]
0169e634  770000b5  cbnz     x23, #0x169e640
0169e638  e0031faa  mov      x0, xzr
0169e63c  3c34da97  bl       #0xd2b72c ; unresolved symbol
0169e640  f4b000f0  adrp     x20, #0x2cbd000
0169e644  94de47f9  ldr      x20, [x20, #0xfb8]
0169e648  f95640f9  ldr      x25, [x23, #0xa8]
0169e64c  800240f9  ldr      x0, [x20]
0169e650  089c4439  ldrb     w8, [x0, #0x127]
0169e654  88000836  tbz      w8, #1, #0x169e664
0169e658  08d840b9  ldr      w8, [x0, #0xd8]
0169e65c  48000035  cbnz     w8, #0x169e664
0169e660  c2d6d997  bl       #0xd14168 ; unresolved symbol
0169e664  e0031baa  mov      x0, x27
0169e668  e10319aa  mov      x1, x25
0169e66c  e2031faa  mov      x2, xzr
0169e670  68d62094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169e674  e10300aa  mov      x1, x0
0169e678  e0031aaa  mov      x0, x26
0169e67c  26070094  bl       #0x16a0314 ; A3BattleCore.SkillDamageHelper$$TestRate
0169e680  e0000036  tbz      w0, #0, #0x169e69c
0169e684  730000b5  cbnz     x19, #0x169e690
0169e688  e0031faa  mov      x0, xzr
0169e68c  2834da97  bl       #0xd2b72c ; unresolved symbol
0169e690  e8030032  mov      w8, #1
0169e694  68660039  strb     w8, [x19, #0x19]
0169e698  40030014  b        #0x169f398
0169e69c  800240f9  ldr      x0, [x20]
0169e6a0  089c4439  ldrb     w8, [x0, #0x127]
0169e6a4  a8000836  tbz      w8, #1, #0x169e6b8
0169e6a8  08d840b9  ldr      w8, [x0, #0xd8]
0169e6ac  68000035  cbnz     w8, #0x169e6b8
0169e6b0  aed6d997  bl       #0xd14168 ; unresolved symbol
0169e6b4  800240f9  ldr      x0, [x20]
0169e6b8  085c40f9  ldr      x8, [x0, #0xb8]
0169e6bc  540b40f9  ldr      x20, [x26, #0x10]
0169e6c0  080d40f9  ldr      x8, [x8, #0x18]
0169e6c4  e81300f9  str      x8, [sp, #0x20]
0169e6c8  740000b5  cbnz     x20, #0x169e6d4
0169e6cc  e0031faa  mov      x0, xzr
0169e6d0  1734da97  bl       #0xd2b72c ; unresolved symbol
0169e6d4  88be4239  ldrb     w8, [x20, #0xaf]
0169e6d8  68020034  cbz      w8, #0x169e724
0169e6dc  f4b000f0  adrp     x20, #0x2cbd000
0169e6e0  94de47f9  ldr      x20, [x20, #0xfb8]
0169e6e4  800240f9  ldr      x0, [x20]
0169e6e8  089c4439  ldrb     w8, [x0, #0x127]
0169e6ec  a8000836  tbz      w8, #1, #0x169e700
0169e6f0  08d840b9  ldr      w8, [x0, #0xd8]
0169e6f4  68000035  cbnz     w8, #0x169e700
0169e6f8  9cd6d997  bl       #0xd14168 ; unresolved symbol
0169e6fc  800240f9  ldr      x0, [x20]
0169e700  085c40f9  ldr      x8, [x0, #0xb8]
0169e704  e13e41f9  ldr      x1, [x23, #0x278]
0169e708  e2031faa  mov      x2, xzr
0169e70c  000d40f9  ldr      x0, [x8, #0x18]
0169e710  11d62094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169e714  e01300f9  str      x0, [sp, #0x20]
0169e718  05000014  b        #0x169e72c
0169e71c  d36300b5  cbnz     x19, #0x169f394
0169e720  1b030014  b        #0x169f38c
0169e724  f4b000f0  adrp     x20, #0x2cbd000
0169e728  94de47f9  ldr      x20, [x20, #0xfb8]
0169e72c  e1ea40f9  ldr      x1, [x23, #0x1d0]
0169e730  e0031aaa  mov      x0, x26
0169e734  f8060094  bl       #0x16a0314 ; A3BattleCore.SkillDamageHelper$$TestRate
0169e738  fc1700f9  str      x28, [sp, #0x28]
0169e73c  c00e0036  tbz      w0, #0, #0x169e914
0169e740  e15a41f9  ldr      x1, [x23, #0x2b0]
0169e744  fbee40f9  ldr      x27, [x23, #0x1d8]
0169e748  e0031aaa  mov      x0, x26
0169e74c  f2060094  bl       #0x16a0314 ; A3BattleCore.SkillDamageHelper$$TestRate
0169e750  40020036  tbz      w0, #0, #0x169e798
0169e754  800240f9  ldr      x0, [x20]
0169e758  089c4439  ldrb     w8, [x0, #0x127]
0169e75c  88000836  tbz      w8, #1, #0x169e76c
0169e760  08d840b9  ldr      w8, [x0, #0xd8]
0169e764  48000035  cbnz     w8, #0x169e76c
0169e768  80d6d997  bl       #0xd14168 ; unresolved symbol
0169e76c  e0030032  mov      w0, #1
0169e770  e1031faa  mov      x1, xzr
0169e774  0fd72094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169e778  e15e41f9  ldr      x1, [x23, #0x2b8]
0169e77c  e2031faa  mov      x2, xzr
0169e780  f5d52094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169e784  e10300aa  mov      x1, x0
0169e788  e0031baa  mov      x0, x27
0169e78c  e2031faa  mov      x2, xzr
0169e790  26d62094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169e794  fb0300aa  mov      x27, x0
0169e798  800240f9  ldr      x0, [x20]
0169e79c  19f340f9  ldr      x25, [x24, #0x1e0]
0169e7a0  fcf640f9  ldr      x28, [x23, #0x1e8]
0169e7a4  089c4439  ldrb     w8, [x0, #0x127]
0169e7a8  88000836  tbz      w8, #1, #0x169e7b8
0169e7ac  08d840b9  ldr      w8, [x0, #0xd8]
0169e7b0  48000035  cbnz     w8, #0x169e7b8
0169e7b4  6dd6d997  bl       #0xd14168 ; unresolved symbol
0169e7b8  e0031baa  mov      x0, x27
0169e7bc  e10319aa  mov      x1, x25
0169e7c0  e2031faa  mov      x2, xzr
0169e7c4  13d62094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169e7c8  48b200b0  adrp     x8, #0x2ce7000
0169e7cc  890240f9  ldr      x9, [x20]
0169e7d0  086942f9  ldr      x8, [x8, #0x4d0]
0169e7d4  fb0300aa  mov      x27, x0
0169e7d8  295d40f9  ldr      x9, [x9, #0xb8]
0169e7dc  080140f9  ldr      x8, [x8]
0169e7e0  391940f9  ldr      x25, [x9, #0x30]
0169e7e4  0a9d4439  ldrb     w10, [x8, #0x127]
0169e7e8  aa000836  tbz      w10, #1, #0x169e7fc
0169e7ec  09d940b9  ldr      w9, [x8, #0xd8]
0169e7f0  69000035  cbnz     w9, #0x169e7fc
0169e7f4  e00308aa  mov      x0, x8
0169e7f8  5cd6d997  bl       #0xd14168 ; unresolved symbol
0169e7fc  e0031baa  mov      x0, x27
0169e800  e10319aa  mov      x1, x25
0169e804  e2031faa  mov      x2, xzr
0169e808  ee012c94  bl       #0x219efc0 ; BattleCore.TSMath$$Max
0169e80c  e1031caa  mov      x1, x28
0169e810  e2031faa  mov      x2, xzr
0169e814  05d62094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169e818  880240f9  ldr      x8, [x20]
0169e81c  e02700f9  str      x0, [sp, #0x48]
0169e820  e2031faa  mov      x2, xzr
0169e824  085d40f9  ldr      x8, [x8, #0xb8]
0169e828  011940f9  ldr      x1, [x8, #0x30]
0169e82c  09d72094  bl       #0x1ed4450 ; BattleCore.FP$$op_GreaterThan
0169e830  fc1740f9  ldr      x28, [sp, #0x28]
0169e834  00070036  tbz      w0, #0, #0x169e914
0169e838  930000b4  cbz      x19, #0x169e848
0169e83c  e8030032  mov      w8, #1
0169e840  68e20139  strb     w8, [x19, #0x78]
0169e844  08000014  b        #0x169e864
0169e848  e0031faa  mov      x0, xzr
0169e84c  b833da97  bl       #0xd2b72c ; unresolved symbol
0169e850  e80f1d32  mov      w8, #0x78
0169e854  e9030032  mov      w9, #1
0169e858  e0031faa  mov      x0, xzr
0169e85c  09010039  strb     w9, [x8]
0169e860  b333da97  bl       #0xd2b72c ; unresolved symbol
0169e864  744240f9  ldr      x20, [x19, #0x80]
0169e868  740000b5  cbnz     x20, #0x169e874
0169e86c  e0031faa  mov      x0, xzr
0169e870  af33da97  bl       #0xd2b72c ; unresolved symbol
0169e874  881a40b9  ldr      w8, [x20, #0x18]
0169e878  a8000035  cbnz     w8, #0x169e88c
0169e87c  e536da97  bl       #0xd2c410 ; unresolved symbol
0169e880  e1031faa  mov      x1, xzr
0169e884  e2031faa  mov      x2, xzr
0169e888  8533da97  bl       #0xd2b69c ; unresolved symbol
0169e88c  e8030032  mov      w8, #1
0169e890  88820039  strb     w8, [x20, #0x20]
0169e894  e8b000f0  adrp     x8, #0x2cbd000
0169e898  08dd47f9  ldr      x8, [x8, #0xfb8]
0169e89c  f92740f9  ldr      x25, [sp, #0x48]
0169e8a0  000140f9  ldr      x0, [x8]
0169e8a4  089c4439  ldrb     w8, [x0, #0x127]
0169e8a8  88000836  tbz      w8, #1, #0x169e8b8
0169e8ac  08d840b9  ldr      w8, [x0, #0xd8]
0169e8b0  48000035  cbnz     w8, #0x169e8b8
0169e8b4  2dd6d997  bl       #0xd14168 ; unresolved symbol
0169e8b8  e11340f9  ldr      x1, [sp, #0x20]
0169e8bc  e00319aa  mov      x0, x25
0169e8c0  e2031faa  mov      x2, xzr
0169e8c4  d9d52094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169e8c8  e02700f9  str      x0, [sp, #0x48]
0169e8cc  744640f9  ldr      x20, [x19, #0x88]
0169e8d0  740000b5  cbnz     x20, #0x169e8dc
0169e8d4  e0031faa  mov      x0, xzr
0169e8d8  9533da97  bl       #0xd2b72c ; unresolved symbol
0169e8dc  881a40b9  ldr      w8, [x20, #0x18]
0169e8e0  a8000035  cbnz     w8, #0x169e8f4
0169e8e4  cb36da97  bl       #0xd2c410 ; unresolved symbol
0169e8e8  e1031faa  mov      x1, xzr
0169e8ec  e2031faa  mov      x2, xzr
0169e8f0  6b33da97  bl       #0xd2b69c ; unresolved symbol
0169e8f4  992240b9  ldr      w25, [x20, #0x20]
0169e8f8  e0230191  add      x0, sp, #0x48
0169e8fc  e1031faa  mov      x1, xzr
0169e900  98da2094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169e904  0800190b  add      w8, w0, w25
0169e908  882200b9  str      w8, [x20, #0x20]
0169e90c  f4b000f0  adrp     x20, #0x2cbd000
0169e910  94de47f9  ldr      x20, [x20, #0xfb8]
0169e914  e1fa40f9  ldr      x1, [x23, #0x1f0]
0169e918  e0031aaa  mov      x0, x26
0169e91c  7e060094  bl       #0x16a0314 ; A3BattleCore.SkillDamageHelper$$TestRate
0169e920  000f0036  tbz      w0, #0, #0x169eb00
0169e924  e16241f9  ldr      x1, [x23, #0x2c0]
0169e928  fbfe40f9  ldr      x27, [x23, #0x1f8]
0169e92c  e0031aaa  mov      x0, x26
0169e930  79060094  bl       #0x16a0314 ; A3BattleCore.SkillDamageHelper$$TestRate
0169e934  40020036  tbz      w0, #0, #0x169e97c
0169e938  800240f9  ldr      x0, [x20]
0169e93c  089c4439  ldrb     w8, [x0, #0x127]
0169e940  88000836  tbz      w8, #1, #0x169e950
0169e944  08d840b9  ldr      w8, [x0, #0xd8]
0169e948  48000035  cbnz     w8, #0x169e950
0169e94c  07d6d997  bl       #0xd14168 ; unresolved symbol
0169e950  e0030032  mov      w0, #1
0169e954  e1031faa  mov      x1, xzr
0169e958  96d62094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169e95c  e16641f9  ldr      x1, [x23, #0x2c8]
0169e960  e2031faa  mov      x2, xzr
0169e964  7cd52094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169e968  e10300aa  mov      x1, x0
0169e96c  e0031baa  mov      x0, x27
0169e970  e2031faa  mov      x2, xzr
0169e974  add52094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169e978  fb0300aa  mov      x27, x0
0169e97c  800240f9  ldr      x0, [x20]
0169e980  190341f9  ldr      x25, [x24, #0x200]
0169e984  fc0641f9  ldr      x28, [x23, #0x208]
0169e988  089c4439  ldrb     w8, [x0, #0x127]
0169e98c  88000836  tbz      w8, #1, #0x169e99c
0169e990  08d840b9  ldr      w8, [x0, #0xd8]
0169e994  48000035  cbnz     w8, #0x169e99c
0169e998  f4d5d997  bl       #0xd14168 ; unresolved symbol
0169e99c  e0031baa  mov      x0, x27
0169e9a0  e10319aa  mov      x1, x25
0169e9a4  e2031faa  mov      x2, xzr
0169e9a8  9ad52094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169e9ac  48b200b0  adrp     x8, #0x2ce7000
0169e9b0  890240f9  ldr      x9, [x20]
0169e9b4  086942f9  ldr      x8, [x8, #0x4d0]
0169e9b8  fb0300aa  mov      x27, x0
0169e9bc  295d40f9  ldr      x9, [x9, #0xb8]
0169e9c0  080140f9  ldr      x8, [x8]
0169e9c4  391940f9  ldr      x25, [x9, #0x30]
0169e9c8  0a9d4439  ldrb     w10, [x8, #0x127]
0169e9cc  aa000836  tbz      w10, #1, #0x169e9e0
0169e9d0  09d940b9  ldr      w9, [x8, #0xd8]
0169e9d4  69000035  cbnz     w9, #0x169e9e0
0169e9d8  e00308aa  mov      x0, x8
0169e9dc  e3d5d997  bl       #0xd14168 ; unresolved symbol
0169e9e0  e0031baa  mov      x0, x27
0169e9e4  e10319aa  mov      x1, x25
0169e9e8  e2031faa  mov      x2, xzr
0169e9ec  75012c94  bl       #0x219efc0 ; BattleCore.TSMath$$Max
0169e9f0  e1031caa  mov      x1, x28
0169e9f4  e2031faa  mov      x2, xzr
0169e9f8  8cd52094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169e9fc  880240f9  ldr      x8, [x20]
0169ea00  e02300f9  str      x0, [sp, #0x40]
0169ea04  e2031faa  mov      x2, xzr
0169ea08  085d40f9  ldr      x8, [x8, #0xb8]
0169ea0c  011940f9  ldr      x1, [x8, #0x30]
0169ea10  90d62094  bl       #0x1ed4450 ; BattleCore.FP$$op_GreaterThan
0169ea14  fc1740f9  ldr      x28, [sp, #0x28]
0169ea18  40070036  tbz      w0, #0, #0x169eb00
0169ea1c  930000b4  cbz      x19, #0x169ea2c
0169ea20  e8030032  mov      w8, #1
0169ea24  68e20139  strb     w8, [x19, #0x78]
0169ea28  08000014  b        #0x169ea48
0169ea2c  e0031faa  mov      x0, xzr
0169ea30  3f33da97  bl       #0xd2b72c ; unresolved symbol
0169ea34  e80f1d32  mov      w8, #0x78
0169ea38  e9030032  mov      w9, #1
0169ea3c  e0031faa  mov      x0, xzr
0169ea40  09010039  strb     w9, [x8]
0169ea44  3a33da97  bl       #0xd2b72c ; unresolved symbol
0169ea48  744240f9  ldr      x20, [x19, #0x80]
0169ea4c  740000b5  cbnz     x20, #0x169ea58
0169ea50  e0031faa  mov      x0, xzr
0169ea54  3633da97  bl       #0xd2b72c ; unresolved symbol
0169ea58  881a40b9  ldr      w8, [x20, #0x18]
0169ea5c  1f050071  cmp      w8, #1
0169ea60  a8000054  b.hi     #0x169ea74
0169ea64  6b36da97  bl       #0xd2c410 ; unresolved symbol
0169ea68  e1031faa  mov      x1, xzr
0169ea6c  e2031faa  mov      x2, xzr
0169ea70  0b33da97  bl       #0xd2b69c ; unresolved symbol
0169ea74  e8030032  mov      w8, #1
0169ea78  88860039  strb     w8, [x20, #0x21]
0169ea7c  e8b000f0  adrp     x8, #0x2cbd000
0169ea80  08dd47f9  ldr      x8, [x8, #0xfb8]
0169ea84  f92340f9  ldr      x25, [sp, #0x40]
0169ea88  000140f9  ldr      x0, [x8]
0169ea8c  089c4439  ldrb     w8, [x0, #0x127]
0169ea90  88000836  tbz      w8, #1, #0x169eaa0
0169ea94  08d840b9  ldr      w8, [x0, #0xd8]
0169ea98  48000035  cbnz     w8, #0x169eaa0
0169ea9c  b3d5d997  bl       #0xd14168 ; unresolved symbol
0169eaa0  e11340f9  ldr      x1, [sp, #0x20]
0169eaa4  e00319aa  mov      x0, x25
0169eaa8  e2031faa  mov      x2, xzr
0169eaac  5fd52094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169eab0  e02300f9  str      x0, [sp, #0x40]
0169eab4  744640f9  ldr      x20, [x19, #0x88]
0169eab8  740000b5  cbnz     x20, #0x169eac4
0169eabc  e0031faa  mov      x0, xzr
0169eac0  1b33da97  bl       #0xd2b72c ; unresolved symbol
0169eac4  881a40b9  ldr      w8, [x20, #0x18]
0169eac8  1f050071  cmp      w8, #1
0169eacc  a8000054  b.hi     #0x169eae0
0169ead0  5036da97  bl       #0xd2c410 ; unresolved symbol
0169ead4  e1031faa  mov      x1, xzr
0169ead8  e2031faa  mov      x2, xzr
0169eadc  f032da97  bl       #0xd2b69c ; unresolved symbol
0169eae0  992640b9  ldr      w25, [x20, #0x24]
0169eae4  e0030191  add      x0, sp, #0x40
0169eae8  e1031faa  mov      x1, xzr
0169eaec  1dda2094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169eaf0  0800190b  add      w8, w0, w25
0169eaf4  882600b9  str      w8, [x20, #0x24]
0169eaf8  f4b000f0  adrp     x20, #0x2cbd000
0169eafc  94de47f9  ldr      x20, [x20, #0xfb8]
0169eb00  e10a41f9  ldr      x1, [x23, #0x210]
0169eb04  e0031aaa  mov      x0, x26
0169eb08  03060094  bl       #0x16a0314 ; A3BattleCore.SkillDamageHelper$$TestRate
0169eb0c  000f0036  tbz      w0, #0, #0x169ecec
0169eb10  e16a41f9  ldr      x1, [x23, #0x2d0]
0169eb14  fb0e41f9  ldr      x27, [x23, #0x218]
0169eb18  e0031aaa  mov      x0, x26
0169eb1c  fe050094  bl       #0x16a0314 ; A3BattleCore.SkillDamageHelper$$TestRate
0169eb20  40020036  tbz      w0, #0, #0x169eb68
0169eb24  800240f9  ldr      x0, [x20]
0169eb28  089c4439  ldrb     w8, [x0, #0x127]
0169eb2c  88000836  tbz      w8, #1, #0x169eb3c
0169eb30  08d840b9  ldr      w8, [x0, #0xd8]
0169eb34  48000035  cbnz     w8, #0x169eb3c
0169eb38  8cd5d997  bl       #0xd14168 ; unresolved symbol
0169eb3c  e0030032  mov      w0, #1
0169eb40  e1031faa  mov      x1, xzr
0169eb44  1bd62094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169eb48  e16e41f9  ldr      x1, [x23, #0x2d8]
0169eb4c  e2031faa  mov      x2, xzr
0169eb50  01d52094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169eb54  e10300aa  mov      x1, x0
0169eb58  e0031baa  mov      x0, x27
0169eb5c  e2031faa  mov      x2, xzr
0169eb60  32d52094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169eb64  fb0300aa  mov      x27, x0
0169eb68  800240f9  ldr      x0, [x20]
0169eb6c  191341f9  ldr      x25, [x24, #0x220]
0169eb70  fc1641f9  ldr      x28, [x23, #0x228]
0169eb74  089c4439  ldrb     w8, [x0, #0x127]
0169eb78  88000836  tbz      w8, #1, #0x169eb88
0169eb7c  08d840b9  ldr      w8, [x0, #0xd8]
0169eb80  48000035  cbnz     w8, #0x169eb88
0169eb84  79d5d997  bl       #0xd14168 ; unresolved symbol
0169eb88  e0031baa  mov      x0, x27
0169eb8c  e10319aa  mov      x1, x25
0169eb90  e2031faa  mov      x2, xzr
0169eb94  1fd52094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169eb98  48b200b0  adrp     x8, #0x2ce7000
0169eb9c  890240f9  ldr      x9, [x20]
0169eba0  086942f9  ldr      x8, [x8, #0x4d0]
0169eba4  fb0300aa  mov      x27, x0
0169eba8  295d40f9  ldr      x9, [x9, #0xb8]
0169ebac  080140f9  ldr      x8, [x8]
0169ebb0  391940f9  ldr      x25, [x9, #0x30]
0169ebb4  0a9d4439  ldrb     w10, [x8, #0x127]
0169ebb8  aa000836  tbz      w10, #1, #0x169ebcc
0169ebbc  09d940b9  ldr      w9, [x8, #0xd8]
0169ebc0  69000035  cbnz     w9, #0x169ebcc
0169ebc4  e00308aa  mov      x0, x8
0169ebc8  68d5d997  bl       #0xd14168 ; unresolved symbol
0169ebcc  e0031baa  mov      x0, x27
0169ebd0  e10319aa  mov      x1, x25
0169ebd4  e2031faa  mov      x2, xzr
0169ebd8  fa002c94  bl       #0x219efc0 ; BattleCore.TSMath$$Max
0169ebdc  e1031caa  mov      x1, x28
0169ebe0  e2031faa  mov      x2, xzr
0169ebe4  11d52094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169ebe8  880240f9  ldr      x8, [x20]
0169ebec  e01f00f9  str      x0, [sp, #0x38]
0169ebf0  e2031faa  mov      x2, xzr
0169ebf4  085d40f9  ldr      x8, [x8, #0xb8]
0169ebf8  011940f9  ldr      x1, [x8, #0x30]
0169ebfc  15d62094  bl       #0x1ed4450 ; BattleCore.FP$$op_GreaterThan
0169ec00  fc1740f9  ldr      x28, [sp, #0x28]
0169ec04  40070036  tbz      w0, #0, #0x169ecec
0169ec08  930000b4  cbz      x19, #0x169ec18
0169ec0c  e8030032  mov      w8, #1
0169ec10  68e20139  strb     w8, [x19, #0x78]
0169ec14  08000014  b        #0x169ec34
0169ec18  e0031faa  mov      x0, xzr
0169ec1c  c432da97  bl       #0xd2b72c ; unresolved symbol
0169ec20  e80f1d32  mov      w8, #0x78
0169ec24  e9030032  mov      w9, #1
0169ec28  e0031faa  mov      x0, xzr
0169ec2c  09010039  strb     w9, [x8]
0169ec30  bf32da97  bl       #0xd2b72c ; unresolved symbol
0169ec34  744240f9  ldr      x20, [x19, #0x80]
0169ec38  740000b5  cbnz     x20, #0x169ec44
0169ec3c  e0031faa  mov      x0, xzr
0169ec40  bb32da97  bl       #0xd2b72c ; unresolved symbol
0169ec44  881a40b9  ldr      w8, [x20, #0x18]
0169ec48  1f090071  cmp      w8, #2
0169ec4c  a8000054  b.hi     #0x169ec60
0169ec50  f035da97  bl       #0xd2c410 ; unresolved symbol
0169ec54  e1031faa  mov      x1, xzr
0169ec58  e2031faa  mov      x2, xzr
0169ec5c  9032da97  bl       #0xd2b69c ; unresolved symbol
0169ec60  e8030032  mov      w8, #1
0169ec64  888a0039  strb     w8, [x20, #0x22]
0169ec68  e8b000f0  adrp     x8, #0x2cbd000
0169ec6c  08dd47f9  ldr      x8, [x8, #0xfb8]
0169ec70  f91f40f9  ldr      x25, [sp, #0x38]
0169ec74  000140f9  ldr      x0, [x8]
0169ec78  089c4439  ldrb     w8, [x0, #0x127]
0169ec7c  88000836  tbz      w8, #1, #0x169ec8c
0169ec80  08d840b9  ldr      w8, [x0, #0xd8]
0169ec84  48000035  cbnz     w8, #0x169ec8c
0169ec88  38d5d997  bl       #0xd14168 ; unresolved symbol
0169ec8c  e11340f9  ldr      x1, [sp, #0x20]
0169ec90  e00319aa  mov      x0, x25
0169ec94  e2031faa  mov      x2, xzr
0169ec98  e4d42094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169ec9c  e01f00f9  str      x0, [sp, #0x38]
0169eca0  744640f9  ldr      x20, [x19, #0x88]
0169eca4  740000b5  cbnz     x20, #0x169ecb0
0169eca8  e0031faa  mov      x0, xzr
0169ecac  a032da97  bl       #0xd2b72c ; unresolved symbol
0169ecb0  881a40b9  ldr      w8, [x20, #0x18]
0169ecb4  1f090071  cmp      w8, #2
0169ecb8  a8000054  b.hi     #0x169eccc
0169ecbc  d535da97  bl       #0xd2c410 ; unresolved symbol
0169ecc0  e1031faa  mov      x1, xzr
0169ecc4  e2031faa  mov      x2, xzr
0169ecc8  7532da97  bl       #0xd2b69c ; unresolved symbol
0169eccc  992a40b9  ldr      w25, [x20, #0x28]
0169ecd0  e0e30091  add      x0, sp, #0x38
0169ecd4  e1031faa  mov      x1, xzr
0169ecd8  a2d92094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169ecdc  0800190b  add      w8, w0, w25
0169ece0  882a00b9  str      w8, [x20, #0x28]
0169ece4  f4b000f0  adrp     x20, #0x2cbd000
0169ece8  94de47f9  ldr      x20, [x20, #0xfb8]
0169ecec  e11a41f9  ldr      x1, [x23, #0x230]
0169ecf0  e0031aaa  mov      x0, x26
0169ecf4  88050094  bl       #0x16a0314 ; A3BattleCore.SkillDamageHelper$$TestRate
0169ecf8  000f0036  tbz      w0, #0, #0x169eed8
0169ecfc  e17241f9  ldr      x1, [x23, #0x2e0]
0169ed00  fb1e41f9  ldr      x27, [x23, #0x238]
0169ed04  e0031aaa  mov      x0, x26
0169ed08  83050094  bl       #0x16a0314 ; A3BattleCore.SkillDamageHelper$$TestRate
0169ed0c  40020036  tbz      w0, #0, #0x169ed54
0169ed10  800240f9  ldr      x0, [x20]
0169ed14  089c4439  ldrb     w8, [x0, #0x127]
0169ed18  88000836  tbz      w8, #1, #0x169ed28
0169ed1c  08d840b9  ldr      w8, [x0, #0xd8]
0169ed20  48000035  cbnz     w8, #0x169ed28
0169ed24  11d5d997  bl       #0xd14168 ; unresolved symbol
0169ed28  e0030032  mov      w0, #1
0169ed2c  e1031faa  mov      x1, xzr
0169ed30  a0d52094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169ed34  e16e41f9  ldr      x1, [x23, #0x2d8]
0169ed38  e2031faa  mov      x2, xzr
0169ed3c  86d42094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169ed40  e10300aa  mov      x1, x0
0169ed44  e0031baa  mov      x0, x27
0169ed48  e2031faa  mov      x2, xzr
0169ed4c  b7d42094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169ed50  fb0300aa  mov      x27, x0
0169ed54  800240f9  ldr      x0, [x20]
0169ed58  192341f9  ldr      x25, [x24, #0x240]
0169ed5c  fc2641f9  ldr      x28, [x23, #0x248]
0169ed60  089c4439  ldrb     w8, [x0, #0x127]
0169ed64  88000836  tbz      w8, #1, #0x169ed74
0169ed68  08d840b9  ldr      w8, [x0, #0xd8]
0169ed6c  48000035  cbnz     w8, #0x169ed74
0169ed70  fed4d997  bl       #0xd14168 ; unresolved symbol
0169ed74  e0031baa  mov      x0, x27
0169ed78  e10319aa  mov      x1, x25
0169ed7c  e2031faa  mov      x2, xzr
0169ed80  a4d42094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169ed84  48b200b0  adrp     x8, #0x2ce7000
0169ed88  890240f9  ldr      x9, [x20]
0169ed8c  086942f9  ldr      x8, [x8, #0x4d0]
0169ed90  fb0300aa  mov      x27, x0
0169ed94  295d40f9  ldr      x9, [x9, #0xb8]
0169ed98  080140f9  ldr      x8, [x8]
0169ed9c  391940f9  ldr      x25, [x9, #0x30]
0169eda0  0a9d4439  ldrb     w10, [x8, #0x127]
0169eda4  aa000836  tbz      w10, #1, #0x169edb8
0169eda8  09d940b9  ldr      w9, [x8, #0xd8]
0169edac  69000035  cbnz     w9, #0x169edb8
0169edb0  e00308aa  mov      x0, x8
0169edb4  edd4d997  bl       #0xd14168 ; unresolved symbol
0169edb8  e0031baa  mov      x0, x27
0169edbc  e10319aa  mov      x1, x25
0169edc0  e2031faa  mov      x2, xzr
0169edc4  7f002c94  bl       #0x219efc0 ; BattleCore.TSMath$$Max
0169edc8  e1031caa  mov      x1, x28
0169edcc  e2031faa  mov      x2, xzr
0169edd0  96d42094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169edd4  880240f9  ldr      x8, [x20]
0169edd8  e01b00f9  str      x0, [sp, #0x30]
0169eddc  e2031faa  mov      x2, xzr
0169ede0  085d40f9  ldr      x8, [x8, #0xb8]
0169ede4  011940f9  ldr      x1, [x8, #0x30]
0169ede8  9ad52094  bl       #0x1ed4450 ; BattleCore.FP$$op_GreaterThan
0169edec  fc1740f9  ldr      x28, [sp, #0x28]
0169edf0  40070036  tbz      w0, #0, #0x169eed8
0169edf4  930000b4  cbz      x19, #0x169ee04
0169edf8  e8030032  mov      w8, #1
0169edfc  68e20139  strb     w8, [x19, #0x78]
0169ee00  08000014  b        #0x169ee20
0169ee04  e0031faa  mov      x0, xzr
0169ee08  4932da97  bl       #0xd2b72c ; unresolved symbol
0169ee0c  e80f1d32  mov      w8, #0x78
0169ee10  e9030032  mov      w9, #1
0169ee14  e0031faa  mov      x0, xzr
0169ee18  09010039  strb     w9, [x8]
0169ee1c  4432da97  bl       #0xd2b72c ; unresolved symbol
0169ee20  744240f9  ldr      x20, [x19, #0x80]
0169ee24  740000b5  cbnz     x20, #0x169ee30
0169ee28  e0031faa  mov      x0, xzr
0169ee2c  4032da97  bl       #0xd2b72c ; unresolved symbol
0169ee30  881a40b9  ldr      w8, [x20, #0x18]
0169ee34  1f0d0071  cmp      w8, #3
0169ee38  a8000054  b.hi     #0x169ee4c
0169ee3c  7535da97  bl       #0xd2c410 ; unresolved symbol
0169ee40  e1031faa  mov      x1, xzr
0169ee44  e2031faa  mov      x2, xzr
0169ee48  1532da97  bl       #0xd2b69c ; unresolved symbol
0169ee4c  e8030032  mov      w8, #1
0169ee50  888e0039  strb     w8, [x20, #0x23]
0169ee54  e8b000f0  adrp     x8, #0x2cbd000
0169ee58  08dd47f9  ldr      x8, [x8, #0xfb8]
0169ee5c  f91b40f9  ldr      x25, [sp, #0x30]
0169ee60  000140f9  ldr      x0, [x8]
0169ee64  089c4439  ldrb     w8, [x0, #0x127]
0169ee68  88000836  tbz      w8, #1, #0x169ee78
0169ee6c  08d840b9  ldr      w8, [x0, #0xd8]
0169ee70  48000035  cbnz     w8, #0x169ee78
0169ee74  bdd4d997  bl       #0xd14168 ; unresolved symbol
0169ee78  e11340f9  ldr      x1, [sp, #0x20]
0169ee7c  e00319aa  mov      x0, x25
0169ee80  e2031faa  mov      x2, xzr
0169ee84  69d42094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169ee88  e01b00f9  str      x0, [sp, #0x30]
0169ee8c  744640f9  ldr      x20, [x19, #0x88]
0169ee90  740000b5  cbnz     x20, #0x169ee9c
0169ee94  e0031faa  mov      x0, xzr
0169ee98  2532da97  bl       #0xd2b72c ; unresolved symbol
0169ee9c  881a40b9  ldr      w8, [x20, #0x18]
0169eea0  1f0d0071  cmp      w8, #3
0169eea4  a8000054  b.hi     #0x169eeb8
0169eea8  5a35da97  bl       #0xd2c410 ; unresolved symbol
0169eeac  e1031faa  mov      x1, xzr
0169eeb0  e2031faa  mov      x2, xzr
0169eeb4  fa31da97  bl       #0xd2b69c ; unresolved symbol
0169eeb8  992e40b9  ldr      w25, [x20, #0x2c]
0169eebc  e0c30091  add      x0, sp, #0x30
0169eec0  e1031faa  mov      x1, xzr
0169eec4  27d92094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169eec8  0800190b  add      w8, w0, w25
0169eecc  882e00b9  str      w8, [x20, #0x2c]
0169eed0  f4b000f0  adrp     x20, #0x2cbd000
0169eed4  94de47f9  ldr      x20, [x20, #0xfb8]
0169eed8  991340f9  ldr      x25, [x28, #0x20]
0169eedc  fb4a40f9  ldr      x27, [x23, #0x90]
0169eee0  790000b5  cbnz     x25, #0x169eeec
0169eee4  e0031faa  mov      x0, xzr
0169eee8  1132da97  bl       #0xd2b72c ; unresolved symbol
0169eeec  280340f9  ldr      x8, [x25]
0169eef0  e00319aa  mov      x0, x25
0169eef4  091d41f9  ldr      x9, [x8, #0x238]
0169eef8  012141f9  ldr      x1, [x8, #0x240]
0169eefc  20013fd6  blr      x9
0169ef00  60030037  tbnz     w0, #0, #0x169ef6c
0169ef04  e0031aaa  mov      x0, x26
0169ef08  e1031baa  mov      x1, x27
0169ef0c  02050094  bl       #0x16a0314 ; A3BattleCore.SkillDamageHelper$$TestRate
0169ef10  e0020036  tbz      w0, #0, #0x169ef6c
0169ef14  990f40f9  ldr      x25, [x28, #0x18]
0169ef18  790000b5  cbnz     x25, #0x169ef24
0169ef1c  e0031faa  mov      x0, xzr
0169ef20  0332da97  bl       #0xd2b72c ; unresolved symbol
0169ef24  e00319aa  mov      x0, x25
0169ef28  e1031faa  mov      x1, xzr
0169ef2c  a33cfb97  bl       #0x156e1b8 ; A3BattleCore.Entity$$get_Context
0169ef30  f90300aa  mov      x25, x0
0169ef34  590000b5  cbnz     x25, #0x169ef3c
0169ef38  fd31da97  bl       #0xd2b72c ; unresolved symbol
0169ef3c  28bf4239  ldrb     w8, [x25, #0xaf]
0169ef40  48210034  cbz      w8, #0x169f368
0169ef44  991340f9  ldr      x25, [x28, #0x20]
0169ef48  790000b5  cbnz     x25, #0x169ef54
0169ef4c  e0031faa  mov      x0, xzr
0169ef50  f731da97  bl       #0xd2b72c ; unresolved symbol
0169ef54  280340f9  ldr      x8, [x25]
0169ef58  e00319aa  mov      x0, x25
0169ef5c  094541f9  ldr      x9, [x8, #0x288]
0169ef60  014941f9  ldr      x1, [x8, #0x290]
0169ef64  20013fd6  blr      x9
0169ef68  00200036  tbz      w0, #0, #0x169f368
0169ef6c  fb0e40f9  ldr      x27, [x23, #0x18]
0169ef70  fb3300f9  str      x27, [sp, #0x60]
0169ef74  760000b5  cbnz     x22, #0x169ef80
0169ef78  e0031faa  mov      x0, xzr
0169ef7c  ec31da97  bl       #0xd2b72c ; unresolved symbol
0169ef80  e00316aa  mov      x0, x22
0169ef84  e1031faa  mov      x1, xzr
0169ef88  b9b40294  bl       #0x174c26c ; A3BattleCore.ActorEntity$$get_BuffMgr
0169ef8c  f90300aa  mov      x25, x0
0169ef90  590000b5  cbnz     x25, #0x169ef98
0169ef94  e631da97  bl       #0xd2b72c ; unresolved symbol
0169ef98  e00319aa  mov      x0, x25
0169ef9c  e10315aa  mov      x1, x21
0169efa0  e2031faa  mov      x2, xzr
0169efa4  6611fe97  bl       #0x162353c ; A3BattleCore.BuffManger$$ProcessAtkVal
0169efa8  880240f9  ldr      x8, [x20]
0169efac  f903002a  mov      w25, w0
0169efb0  099d4439  ldrb     w9, [x8, #0x127]
0169efb4  a9000836  tbz      w9, #1, #0x169efc8
0169efb8  09d940b9  ldr      w9, [x8, #0xd8]
0169efbc  69000035  cbnz     w9, #0x169efc8
0169efc0  e00308aa  mov      x0, x8
0169efc4  69d4d997  bl       #0xd14168 ; unresolved symbol
0169efc8  e003192a  mov      w0, w25
0169efcc  e1031faa  mov      x1, xzr
0169efd0  f8d42094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169efd4  e10300aa  mov      x1, x0
0169efd8  e0031baa  mov      x0, x27
0169efdc  e2031faa  mov      x2, xzr
0169efe0  ddd32094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169efe4  e03300f9  str      x0, [sp, #0x60]
0169efe8  760000b5  cbnz     x22, #0x169eff4
0169efec  e0031faa  mov      x0, xzr
0169eff0  cf31da97  bl       #0xd2b72c ; unresolved symbol
0169eff4  e00316aa  mov      x0, x22
0169eff8  e1031faa  mov      x1, xzr
0169effc  7ac60294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169f000  f90300aa  mov      x25, x0
0169f004  590000b5  cbnz     x25, #0x169f00c
0169f008  c931da97  bl       #0xd2b72c ; unresolved symbol
0169f00c  e00319aa  mov      x0, x25
0169f010  e1031faa  mov      x1, xzr
0169f014  78c60294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169f018  f90300aa  mov      x25, x0
0169f01c  590000b5  cbnz     x25, #0x169f024
0169f020  c331da97  bl       #0xd2b72c ; unresolved symbol
0169f024  880240f9  ldr      x8, [x20]
0169f028  200f40f9  ldr      x0, [x25, #0x18]
0169f02c  e2031faa  mov      x2, xzr
0169f030  085d40f9  ldr      x8, [x8, #0xb8]
0169f034  011940f9  ldr      x1, [x8, #0x30]
0169f038  09d52094  bl       #0x1ed445c ; BattleCore.FP$$op_LessThan
0169f03c  a0000036  tbz      w0, #0, #0x169f050
0169f040  d31900b4  cbz      x19, #0x169f378
0169f044  e8030032  mov      w8, #1
0169f048  68420239  strb     w8, [x19, #0x90]
0169f04c  d2000014  b        #0x169f394
0169f050  fb1240f9  ldr      x27, [x23, #0x20]
0169f054  760000b5  cbnz     x22, #0x169f060
0169f058  e0031faa  mov      x0, xzr
0169f05c  b431da97  bl       #0xd2b72c ; unresolved symbol
0169f060  e00316aa  mov      x0, x22
0169f064  e1031faa  mov      x1, xzr
0169f068  81b40294  bl       #0x174c26c ; A3BattleCore.ActorEntity$$get_BuffMgr
0169f06c  f90300aa  mov      x25, x0
0169f070  590000b5  cbnz     x25, #0x169f078
0169f074  ae31da97  bl       #0xd2b72c ; unresolved symbol
0169f078  e00319aa  mov      x0, x25
0169f07c  e10315aa  mov      x1, x21
0169f080  e2031faa  mov      x2, xzr
0169f084  5412fe97  bl       #0x16239d4 ; A3BattleCore.BuffManger$$ProcessCritRatio
0169f088  880240f9  ldr      x8, [x20]
0169f08c  f90300aa  mov      x25, x0
0169f090  099d4439  ldrb     w9, [x8, #0x127]
0169f094  a9000836  tbz      w9, #1, #0x169f0a8
0169f098  09d940b9  ldr      w9, [x8, #0xd8]
0169f09c  69000035  cbnz     w9, #0x169f0a8
0169f0a0  e00308aa  mov      x0, x8
0169f0a4  31d4d997  bl       #0xd14168 ; unresolved symbol
0169f0a8  e0031baa  mov      x0, x27
0169f0ac  e10319aa  mov      x1, x25
0169f0b0  e2031faa  mov      x2, xzr
0169f0b4  a8d32094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169f0b8  e10300aa  mov      x1, x0
0169f0bc  e0031aaa  mov      x0, x26
0169f0c0  95040094  bl       #0x16a0314 ; A3BattleCore.SkillDamageHelper$$TestRate
0169f0c4  00040036  tbz      w0, #0, #0x169f144
0169f0c8  800240f9  ldr      x0, [x20]
0169f0cc  fc1640f9  ldr      x28, [x23, #0x28]
0169f0d0  fb3340f9  ldr      x27, [sp, #0x60]
0169f0d4  089c4439  ldrb     w8, [x0, #0x127]
0169f0d8  88000836  tbz      w8, #1, #0x169f0e8
0169f0dc  08d840b9  ldr      w8, [x0, #0xd8]
0169f0e0  48000035  cbnz     w8, #0x169f0e8
0169f0e4  21d4d997  bl       #0xd14168 ; unresolved symbol
0169f0e8  e0030032  mov      w0, #1
0169f0ec  e1031faa  mov      x1, xzr
0169f0f0  f4030032  mov      w20, #1
0169f0f4  afd42094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169f0f8  e1031caa  mov      x1, x28
0169f0fc  e2031faa  mov      x2, xzr
0169f100  95d32094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169f104  e10300aa  mov      x1, x0
0169f108  e0031baa  mov      x0, x27
0169f10c  e2031faa  mov      x2, xzr
0169f110  c6d32094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169f114  e1031faa  mov      x1, xzr
0169f118  47d62094  bl       #0x1ed4a34 ; BattleCore.FP$$op_Explicit
0169f11c  e1031faa  mov      x1, xzr
0169f120  a4d42094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169f124  e03300f9  str      x0, [sp, #0x60]
0169f128  730000b5  cbnz     x19, #0x169f134
0169f12c  e0031faa  mov      x0, xzr
0169f130  7f31da97  bl       #0xd2b72c ; unresolved symbol
0169f134  74620039  strb     w20, [x19, #0x18]
0169f138  f4b000d0  adrp     x20, #0x2cbd000
0169f13c  fc1740f9  ldr      x28, [sp, #0x28]
0169f140  94de47f9  ldr      x20, [x20, #0xfb8]
0169f144  28af0090  adrp     x8, #0x2c83000
0169f148  082946f9  ldr      x8, [x8, #0xc50]
0169f14c  000140f9  ldr      x0, [x8]
0169f150  0b180594  bl       #0x17e517c ; A3BattleCore.FSingleton<BattleLevelConfigMgr>$$get_Instance | A3BattleCore.FSingleton<BeastTideCollectItemCfgMgr>$$get_Instance | A3BattleCore.FSingleton<BeastTideConfigMgr>$$get_Instance | A3BattleCore.FSingleton<BianShenCfgMgr>$$get_Instance | A3BattleCore.FSingleton<BootyCfgMgr>$$get_Instance | A3BattleCore.FSingleton<BuffConfigMgr>$$get_Instance | A3BattleCore.FSingleton<ElementTeamCfgMgr>$$get_Instance | A3BattleCore.FSingleton<FDataPool<CSRelaySyncOneFrameData>>$$get_Instance | A3BattleCore.FSingleton<FMemPoolMgr>$$get_Instance | A3BattleCore.FSingleton<FMemPool<ActorAttrData>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<ActorAttrImpactMgr>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdBianShen>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdGmRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdMoveRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdReRandomSkillRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdReliveRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdSelectRandomSkill>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdSetWorldBossHP>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdSkillRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdSummonPetRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdYuanShenSkillRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BufferItem>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<EntityVisualEventNode>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<EventRegInfo>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<FlyBullet>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<GridIndexNode>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<LightChainBullet>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<LightChainNode>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<RayBullet>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<ShootPointBullet>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<SkillPlayData>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<SkillRepeatTranslateHandle.MoveData>>$$get_Instance | A3BattleCore.FSingleton<ForeverConfigMgr>$$get_Instance | A3BattleCore.FSingleton<GuardBlitzConfigMgr>$$get_Instance | A3BattleCore.FSingleton<HellLevelCfgMgr>$$get_Instance | A3BattleCore.FSingleton<HorseCfgMgr>$$get_Instance | A3BattleCore.FSingleton<IslandAdventureCfgMgr>$$get_Instance | A3BattleCore.FSingleton<ItemConfigMgr>$$get_Instance | A3BattleCore.FSingleton<LevelCfgMgr>$$get_Instance | A3BattleCore.FSingleton<LongHunConfigMgr>$$get_Instance | A3BattleCore.FSingleton<MHZBConfigMgr>$$get_Instance | A3BattleCore.FSingleton<MiJingConfigMgr>$$get_Instance | A3BattleCore.FSingleton<ModelConfigMgr>$$get_Instance | A3BattleCore.FSingleton<MonsterCfgMgr>$$get_Instance | A3BattleCore.FSingleton<ParamConfigMgr>$$get_Instance | A3BattleCore.FSingleton<PengPengTuTengCfgMgr>$$get_Instance | A3BattleCore.FSingleton<PetCfgMgr>$$get_Instance | A3BattleCore.FSingleton<PvpConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SacredBeastConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SacredEquipCfgMgr>$$get_Instance | A3BattleCore.FSingleton<SkillConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SkillDispConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SpiritConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SummonConfigMgr>$$get_Instance | A3BattleCore.FSingleton<TanSheConfigMgr>$$get_Instance | A3BattleCore.FSingleton<ToughnessConfigMgr>$$get_Instance | A3BattleCore.FSingleton<XianYuanConfigMgr>$$get_Instance | A3BattleCore.FSingleton<object>$$get_Instance
0169f154  991340b9  ldr      w25, [x28, #0x10]
0169f158  fb0300aa  mov      x27, x0
0169f15c  5b0000b5  cbnz     x27, #0x169f164
0169f160  7331da97  bl       #0xd2b72c ; unresolved symbol
0169f164  e0031baa  mov      x0, x27
0169f168  e103192a  mov      w1, w25
0169f16c  a9f1ff97  bl       #0x169b810 ; A3BattleCore.SkillConfigMgr$$GetSkillBaseConfig
0169f170  880240f9  ldr      x8, [x20]
0169f174  fc0300aa  mov      x28, x0
0169f178  099d4439  ldrb     w9, [x8, #0x127]
0169f17c  c9000836  tbz      w9, #1, #0x169f194
0169f180  09d940b9  ldr      w9, [x8, #0xd8]
0169f184  89000035  cbnz     w9, #0x169f194
0169f188  e00308aa  mov      x0, x8
0169f18c  f7d3d997  bl       #0xd14168 ; unresolved symbol
0169f190  880240f9  ldr      x8, [x20]
0169f194  095d40f9  ldr      x9, [x8, #0xb8]
0169f198  3b0d40f9  ldr      x27, [x9, #0x18]
0169f19c  9c0400b4  cbz      x28, #0x169f22c
0169f1a0  8a2340b9  ldr      w10, [x28, #0x20]
0169f1a4  4a040034  cbz      w10, #0x169f22c
0169f1a8  0a9d4439  ldrb     w10, [x8, #0x127]
0169f1ac  fc2e41f9  ldr      x28, [x23, #0x258]
0169f1b0  ea000836  tbz      w10, #1, #0x169f1cc
0169f1b4  0ad940b9  ldr      w10, [x8, #0xd8]
0169f1b8  aa000035  cbnz     w10, #0x169f1cc
0169f1bc  e00308aa  mov      x0, x8
0169f1c0  ead3d997  bl       #0xd14168 ; unresolved symbol
0169f1c4  880240f9  ldr      x8, [x20]
0169f1c8  095d40f9  ldr      x9, [x8, #0xb8]
0169f1cc  211940f9  ldr      x1, [x9, #0x30]
0169f1d0  e0031caa  mov      x0, x28
0169f1d4  e2031faa  mov      x2, xzr
0169f1d8  9ed42094  bl       #0x1ed4450 ; BattleCore.FP$$op_GreaterThan
0169f1dc  80020036  tbz      w0, #0, #0x169f22c
0169f1e0  800240f9  ldr      x0, [x20]
0169f1e4  fc1740f9  ldr      x28, [sp, #0x28]
0169f1e8  089c4439  ldrb     w8, [x0, #0x127]
0169f1ec  88000836  tbz      w8, #1, #0x169f1fc
0169f1f0  08d840b9  ldr      w8, [x0, #0xd8]
0169f1f4  48000035  cbnz     w8, #0x169f1fc
0169f1f8  dcd3d997  bl       #0xd14168 ; unresolved symbol
0169f1fc  e0030032  mov      w0, #1
0169f200  e1031faa  mov      x1, xzr
0169f204  6bd42094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169f208  e12e41f9  ldr      x1, [x23, #0x258]
0169f20c  e2031faa  mov      x2, xzr
0169f210  51d32094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169f214  e10300aa  mov      x1, x0
0169f218  e0031baa  mov      x0, x27
0169f21c  e2031faa  mov      x2, xzr
0169f220  82d32094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169f224  fb0300aa  mov      x27, x0
0169f228  02000014  b        #0x169f230
0169f22c  fc1740f9  ldr      x28, [sp, #0x28]
0169f230  800240f9  ldr      x0, [x20]
0169f234  f93340f9  ldr      x25, [sp, #0x60]
0169f238  089c4439  ldrb     w8, [x0, #0x127]
0169f23c  88000836  tbz      w8, #1, #0x169f24c
0169f240  08d840b9  ldr      w8, [x0, #0xd8]
0169f244  48000035  cbnz     w8, #0x169f24c
0169f248  c8d3d997  bl       #0xd14168 ; unresolved symbol
0169f24c  e10b40f9  ldr      x1, [sp, #0x10]
0169f250  e00319aa  mov      x0, x25
0169f254  e2031faa  mov      x2, xzr
0169f258  74d32094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169f25c  e1031baa  mov      x1, x27
0169f260  e2031faa  mov      x2, xzr
0169f264  71d32094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169f268  e10f40f9  ldr      x1, [sp, #0x18]
0169f26c  e2031faa  mov      x2, xzr
0169f270  39d32094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169f274  e03300f9  str      x0, [sp, #0x60]
0169f278  990f40f9  ldr      x25, [x28, #0x18]
0169f27c  790000b5  cbnz     x25, #0x169f288
0169f280  e0031faa  mov      x0, xzr
0169f284  2a31da97  bl       #0xd2b72c ; unresolved symbol
0169f288  280340f9  ldr      x8, [x25]
0169f28c  e00319aa  mov      x0, x25
0169f290  098559a9  ldp      x9, x1, [x8, #0x198]
0169f294  20013fd6  blr      x9
0169f298  1f040071  cmp      w0, #1
0169f29c  c1150054  b.ne     #0x169f554
0169f2a0  d60800b4  cbz      x22, #0x169f3b8
0169f2a4  34b000f0  adrp     x20, #0x2ca6000
0169f2a8  940e41f9  ldr      x20, [x20, #0x218]
0169f2ac  c80240f9  ldr      x8, [x22]
0169f2b0  810240f9  ldr      x1, [x20]
0169f2b4  0a814439  ldrb     w10, [x8, #0x120]
0169f2b8  29804439  ldrb     w9, [x1, #0x120]
0169f2bc  5f01096b  cmp      w10, w9
0169f2c0  c3000054  b.lo     #0x169f2d8
0169f2c4  0a6540f9  ldr      x10, [x8, #0xc8]
0169f2c8  490d098b  add      x9, x10, x9, lsl #3
0169f2cc  29815ff8  ldur     x9, [x9, #-8]
0169f2d0  3f0101eb  cmp      x9, x1
0169f2d4  a0010054  b.eq     #0x169f308
0169f2d8  002140f9  ldr      x0, [x8, #0x40]
0169f2dc  a86301d1  sub      x8, x29, #0x58
0169f2e0  44f7da97  bl       #0xd5cff0 ; unresolved symbol
0169f2e4  a0835af8  ldur     x0, [x29, #-0x58]
0169f2e8  3d34da97  bl       #0xd2c3dc ; unresolved symbol
0169f2ec  e1031faa  mov      x1, xzr
0169f2f0  e2031faa  mov      x2, xzr
0169f2f4  ea30da97  bl       #0xd2b69c ; unresolved symbol
0169f2f8  a06301d1  sub      x0, x29, #0x58
0169f2fc  7517db97  bl       #0xd650d0 ; unresolved symbol
0169f300  e0031faa  mov      x0, xzr
0169f304  0a31da97  bl       #0xd2b72c ; unresolved symbol
0169f308  c80240f9  ldr      x8, [x22]
0169f30c  810240f9  ldr      x1, [x20]
0169f310  0a814439  ldrb     w10, [x8, #0x120]
0169f314  29804439  ldrb     w9, [x1, #0x120]
0169f318  5f01096b  cmp      w10, w9
0169f31c  c3000054  b.lo     #0x169f334
0169f320  0a6540f9  ldr      x10, [x8, #0xc8]
0169f324  490d098b  add      x9, x10, x9, lsl #3
0169f328  29815ff8  ldur     x9, [x9, #-8]
0169f32c  3f0101eb  cmp      x9, x1
0169f330  e0510054  b.eq     #0x169fd6c
0169f334  002140f9  ldr      x0, [x8, #0x40]
0169f338  a86301d1  sub      x8, x29, #0x58
0169f33c  2df7da97  bl       #0xd5cff0 ; unresolved symbol
0169f340  a0835af8  ldur     x0, [x29, #-0x58]
0169f344  2634da97  bl       #0xd2c3dc ; unresolved symbol
0169f348  e1031faa  mov      x1, xzr
0169f34c  e2031faa  mov      x2, xzr
0169f350  d330da97  bl       #0xd2b69c ; unresolved symbol
0169f354  f4b000d0  adrp     x20, #0x2cbd000
0169f358  94de47f9  ldr      x20, [x20, #0xfb8]
0169f35c  a06301d1  sub      x0, x29, #0x58
0169f360  5c17db97  bl       #0xd650d0 ; unresolved symbol
0169f364  17000014  b        #0x169f3c0
0169f368  f30400b4  cbz      x19, #0x169f404
0169f36c  e8030032  mov      w8, #1
0169f370  686a0039  strb     w8, [x19, #0x1a]
0169f374  2b000014  b        #0x169f420
0169f378  e0031faa  mov      x0, xzr
0169f37c  ec30da97  bl       #0xd2b72c ; unresolved symbol
0169f380  08128052  mov      w8, #0x90
0169f384  e9030032  mov      w9, #1
0169f388  09010039  strb     w9, [x8]
0169f38c  e0031faa  mov      x0, xzr
0169f390  e730da97  bl       #0xd2b72c ; unresolved symbol
0169f394  7f1200b9  str      wzr, [x19, #0x10]
0169f398  fd7b4ca9  ldp      x29, x30, [sp, #0xc0]
0169f39c  f44f4ba9  ldp      x20, x19, [sp, #0xb0]
0169f3a0  f6574aa9  ldp      x22, x21, [sp, #0xa0]
0169f3a4  f85f49a9  ldp      x24, x23, [sp, #0x90]
0169f3a8  fa6748a9  ldp      x26, x25, [sp, #0x80]
0169f3ac  fc6f47a9  ldp      x28, x27, [sp, #0x70]
0169f3b0  ff430391  add      sp, sp, #0xd0
0169f3b4  c0035fd6  ret      
0169f3b8  e0031faa  mov      x0, xzr
0169f3bc  dc30da97  bl       #0xd2b72c ; unresolved symbol
0169f3c0  e0031faa  mov      x0, xzr
0169f3c4  e1031faa  mov      x1, xzr
0169f3c8  1af7fc97  bl       #0x15dd030 ; A3BattleCore.PlayerEntity$$get_m_weaponType
0169f3cc  08040051  sub      w8, w0, #1
0169f3d0  1f0d0071  cmp      w8, #3
0169f3d4  080c0054  b.hi     #0x169f554
0169f3d8  09680090  adrp     x9, #0x239f000
0169f3dc  29213791  add      x9, x9, #0xdc8
0169f3e0  2879a8b8  ldrsw    x8, [x9, x8, lsl #2]
0169f3e4  0801098b  add      x8, x8, x9
0169f3e8  00011fd6  br       x8
0169f3ec  800240f9  ldr      x0, [x20]
0169f3f0  f93340f9  ldr      x25, [sp, #0x60]
0169f3f4  fb2a40f9  ldr      x27, [x23, #0x50]
0169f3f8  089c4439  ldrb     w8, [x0, #0x127]
0169f3fc  c8090837  tbnz     w8, #1, #0x169f534
0169f400  50000014  b        #0x169f540
0169f404  e0031faa  mov      x0, xzr
0169f408  c930da97  bl       #0xd2b72c ; unresolved symbol
0169f40c  48038052  mov      w8, #0x1a
0169f410  e9030032  mov      w9, #1
0169f414  e0031faa  mov      x0, xzr
0169f418  09010039  strb     w9, [x8]
0169f41c  c430da97  bl       #0xd2b72c ; unresolved symbol
0169f420  e8030032  mov      w8, #1
0169f424  68720039  strb     w8, [x19, #0x1c]
0169f428  951340f9  ldr      x21, [x28, #0x20]
0169f42c  750000b5  cbnz     x21, #0x169f438
0169f430  e0031faa  mov      x0, xzr
0169f434  be30da97  bl       #0xd2b72c ; unresolved symbol
0169f438  e00315aa  mov      x0, x21
0169f43c  e1031faa  mov      x1, xzr
0169f440  69c50294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169f444  f50300aa  mov      x21, x0
0169f448  550000b5  cbnz     x21, #0x169f450
0169f44c  b830da97  bl       #0xd2b72c ; unresolved symbol
0169f450  e00315aa  mov      x0, x21
0169f454  e1031faa  mov      x1, xzr
0169f458  b8dd0294  bl       #0x1756b38 ; A3BattleCore.ActorData$$get_HP
0169f45c  961340f9  ldr      x22, [x28, #0x20]
0169f460  f503002a  mov      w21, w0
0169f464  760000b5  cbnz     x22, #0x169f470
0169f468  e0031faa  mov      x0, xzr
0169f46c  b030da97  bl       #0xd2b72c ; unresolved symbol
0169f470  e00316aa  mov      x0, x22
0169f474  e1031faa  mov      x1, xzr
0169f478  5bc50294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169f47c  f60300aa  mov      x22, x0
0169f480  560000b5  cbnz     x22, #0x169f488
0169f484  aa30da97  bl       #0xd2b72c ; unresolved symbol
0169f488  e00316aa  mov      x0, x22
0169f48c  e1031faa  mov      x1, xzr
0169f490  59c50294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169f494  f60300aa  mov      x22, x0
0169f498  560000b5  cbnz     x22, #0x169f4a0
0169f49c  a430da97  bl       #0xd2b72c ; unresolved symbol
0169f4a0  941340f9  ldr      x20, [x28, #0x20]
0169f4a4  d61240b9  ldr      w22, [x22, #0x10]
0169f4a8  740000b5  cbnz     x20, #0x169f4b4
0169f4ac  e0031faa  mov      x0, xzr
0169f4b0  9f30da97  bl       #0xd2b72c ; unresolved symbol
0169f4b4  e00314aa  mov      x0, x20
0169f4b8  e1031faa  mov      x1, xzr
0169f4bc  4ac50294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169f4c0  f40300aa  mov      x20, x0
0169f4c4  540000b5  cbnz     x20, #0x169f4cc
0169f4c8  9930da97  bl       #0xd2b72c ; unresolved symbol
0169f4cc  e00314aa  mov      x0, x20
0169f4d0  e1031faa  mov      x1, xzr
0169f4d4  a0dd0294  bl       #0x1756b54 ; A3BattleCore.ActorData$$get_HpCount
0169f4d8  1f040071  cmp      w0, #1
0169f4dc  08c49f1a  csinc    w8, w0, wzr, gt
0169f4e0  08050051  sub      w8, w8, #1
0169f4e4  0855161b  madd     w8, w8, w22, w21
0169f4e8  681200b9  str      w8, [x19, #0x10]
0169f4ec  abffff17  b        #0x169f398
0169f4f0  800240f9  ldr      x0, [x20]
0169f4f4  f93340f9  ldr      x25, [sp, #0x60]
0169f4f8  fb3240f9  ldr      x27, [x23, #0x60]
0169f4fc  089c4439  ldrb     w8, [x0, #0x127]
0169f500  a8010837  tbnz     w8, #1, #0x169f534
0169f504  0f000014  b        #0x169f540
0169f508  800240f9  ldr      x0, [x20]
0169f50c  f93340f9  ldr      x25, [sp, #0x60]
0169f510  fb3640f9  ldr      x27, [x23, #0x68]
0169f514  089c4439  ldrb     w8, [x0, #0x127]
0169f518  e8000837  tbnz     w8, #1, #0x169f534
0169f51c  09000014  b        #0x169f540
0169f520  800240f9  ldr      x0, [x20]
0169f524  f93340f9  ldr      x25, [sp, #0x60]
0169f528  fb2e40f9  ldr      x27, [x23, #0x58]
0169f52c  089c4439  ldrb     w8, [x0, #0x127]
0169f530  88000836  tbz      w8, #1, #0x169f540
0169f534  08d840b9  ldr      w8, [x0, #0xd8]
0169f538  48000035  cbnz     w8, #0x169f540
0169f53c  0bd3d997  bl       #0xd14168 ; unresolved symbol
0169f540  e00319aa  mov      x0, x25
0169f544  e1031baa  mov      x1, x27
0169f548  e2031faa  mov      x2, xzr
0169f54c  82d22094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169f550  e03300f9  str      x0, [sp, #0x60]
0169f554  882b40b9  ldr      w8, [x28, #0x28]
0169f558  08010034  cbz      w8, #0x169f578
0169f55c  1f050071  cmp      w8, #1
0169f560  61010054  b.ne     #0x169f58c
0169f564  081b40f9  ldr      x8, [x24, #0x30]
0169f568  f94e40f9  ldr      x25, [x23, #0x98]
0169f56c  e80f00f9  str      x8, [sp, #0x18]
0169f570  1b1f40f9  ldr      x27, [x24, #0x38]
0169f574  18000014  b        #0x169f5d4
0169f578  082340f9  ldr      x8, [x24, #0x40]
0169f57c  f95240f9  ldr      x25, [x23, #0xa0]
0169f580  e80f00f9  str      x8, [sp, #0x18]
0169f584  1b2740f9  ldr      x27, [x24, #0x48]
0169f588  13000014  b        #0x169f5d4
0169f58c  800240f9  ldr      x0, [x20]
0169f590  089c4439  ldrb     w8, [x0, #0x127]
0169f594  88000836  tbz      w8, #1, #0x169f5a4
0169f598  08d840b9  ldr      w8, [x0, #0xd8]
0169f59c  48000035  cbnz     w8, #0x169f5a4
0169f5a0  f2d2d997  bl       #0xd14168 ; unresolved symbol
0169f5a4  e0031f2a  mov      w0, wzr
0169f5a8  e1031faa  mov      x1, xzr
0169f5ac  81d32094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169f5b0  f90300aa  mov      x25, x0
0169f5b4  e0031f2a  mov      w0, wzr
0169f5b8  e1031faa  mov      x1, xzr
0169f5bc  7dd32094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169f5c0  fb0300aa  mov      x27, x0
0169f5c4  e0031f2a  mov      w0, wzr
0169f5c8  e1031faa  mov      x1, xzr
0169f5cc  79d32094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169f5d0  e00f00f9  str      x0, [sp, #0x18]
0169f5d4  800240f9  ldr      x0, [x20]
0169f5d8  fc3340f9  ldr      x28, [sp, #0x60]
0169f5dc  089c4439  ldrb     w8, [x0, #0x127]
0169f5e0  88000836  tbz      w8, #1, #0x169f5f0
0169f5e4  08d840b9  ldr      w8, [x0, #0xd8]
0169f5e8  48000035  cbnz     w8, #0x169f5f0
0169f5ec  dfd2d997  bl       #0xd14168 ; unresolved symbol
0169f5f0  e0031caa  mov      x0, x28
0169f5f4  e10319aa  mov      x1, x25
0169f5f8  e2031faa  mov      x2, xzr
0169f5fc  56d22094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169f600  88af0090  adrp     x8, #0x2c8f000
0169f604  087941f9  ldr      x8, [x8, #0x2f0]
0169f608  e03300f9  str      x0, [sp, #0x60]
0169f60c  080140f9  ldr      x8, [x8]
0169f610  e00308aa  mov      x0, x8
0169f614  da160594  bl       #0x17e517c ; A3BattleCore.FSingleton<BattleLevelConfigMgr>$$get_Instance | A3BattleCore.FSingleton<BeastTideCollectItemCfgMgr>$$get_Instance | A3BattleCore.FSingleton<BeastTideConfigMgr>$$get_Instance | A3BattleCore.FSingleton<BianShenCfgMgr>$$get_Instance | A3BattleCore.FSingleton<BootyCfgMgr>$$get_Instance | A3BattleCore.FSingleton<BuffConfigMgr>$$get_Instance | A3BattleCore.FSingleton<ElementTeamCfgMgr>$$get_Instance | A3BattleCore.FSingleton<FDataPool<CSRelaySyncOneFrameData>>$$get_Instance | A3BattleCore.FSingleton<FMemPoolMgr>$$get_Instance | A3BattleCore.FSingleton<FMemPool<ActorAttrData>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<ActorAttrImpactMgr>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdBianShen>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdGmRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdMoveRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdReRandomSkillRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdReliveRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdSelectRandomSkill>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdSetWorldBossHP>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdSkillRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdSummonPetRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdYuanShenSkillRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BufferItem>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<EntityVisualEventNode>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<EventRegInfo>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<FlyBullet>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<GridIndexNode>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<LightChainBullet>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<LightChainNode>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<RayBullet>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<ShootPointBullet>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<SkillPlayData>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<SkillRepeatTranslateHandle.MoveData>>$$get_Instance | A3BattleCore.FSingleton<ForeverConfigMgr>$$get_Instance | A3BattleCore.FSingleton<GuardBlitzConfigMgr>$$get_Instance | A3BattleCore.FSingleton<HellLevelCfgMgr>$$get_Instance | A3BattleCore.FSingleton<HorseCfgMgr>$$get_Instance | A3BattleCore.FSingleton<IslandAdventureCfgMgr>$$get_Instance | A3BattleCore.FSingleton<ItemConfigMgr>$$get_Instance | A3BattleCore.FSingleton<LevelCfgMgr>$$get_Instance | A3BattleCore.FSingleton<LongHunConfigMgr>$$get_Instance | A3BattleCore.FSingleton<MHZBConfigMgr>$$get_Instance | A3BattleCore.FSingleton<MiJingConfigMgr>$$get_Instance | A3BattleCore.FSingleton<ModelConfigMgr>$$get_Instance | A3BattleCore.FSingleton<MonsterCfgMgr>$$get_Instance | A3BattleCore.FSingleton<ParamConfigMgr>$$get_Instance | A3BattleCore.FSingleton<PengPengTuTengCfgMgr>$$get_Instance | A3BattleCore.FSingleton<PetCfgMgr>$$get_Instance | A3BattleCore.FSingleton<PvpConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SacredBeastConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SacredEquipCfgMgr>$$get_Instance | A3BattleCore.FSingleton<SkillConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SkillDispConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SpiritConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SummonConfigMgr>$$get_Instance | A3BattleCore.FSingleton<TanSheConfigMgr>$$get_Instance | A3BattleCore.FSingleton<ToughnessConfigMgr>$$get_Instance | A3BattleCore.FSingleton<XianYuanConfigMgr>$$get_Instance | A3BattleCore.FSingleton<object>$$get_Instance
0169f618  f90300aa  mov      x25, x0
0169f61c  590000b5  cbnz     x25, #0x169f624
0169f620  4330da97  bl       #0xd2b72c ; unresolved symbol
0169f624  e1130032  mov      w1, #0x1f
0169f628  e00319aa  mov      x0, x25
0169f62c  e2031faa  mov      x2, xzr
0169f630  3be3fc97  bl       #0x15d831c ; A3BattleCore.ParamConfigMgr$$GetFloatParam
0169f634  e83340f9  ldr      x8, [sp, #0x60]
0169f638  e10300aa  mov      x1, x0
0169f63c  e2031faa  mov      x2, xzr
0169f640  e00308aa  mov      x0, x8
0169f644  79d22094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169f648  e80f40b9  ldr      w8, [sp, #0xc]
0169f64c  f90300aa  mov      x25, x0
0169f650  c80a0036  tbz      w8, #0, #0x169f7a8
0169f654  800240f9  ldr      x0, [x20]
0169f658  fcb240f9  ldr      x28, [x23, #0x160]
0169f65c  089c4439  ldrb     w8, [x0, #0x127]
0169f660  88000836  tbz      w8, #1, #0x169f670
0169f664  08d840b9  ldr      w8, [x0, #0xd8]
0169f668  48000035  cbnz     w8, #0x169f670
0169f66c  bfd2d997  bl       #0xd14168 ; unresolved symbol
0169f670  e0031baa  mov      x0, x27
0169f674  e1031caa  mov      x1, x28
0169f678  e2031faa  mov      x2, xzr
0169f67c  f90b00f9  str      x25, [sp, #0x10]
0169f680  64d22094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169f684  fb0300aa  mov      x27, x0
0169f688  e0031f2a  mov      w0, wzr
0169f68c  e1031faa  mov      x1, xzr
0169f690  48d32094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169f694  48b20090  adrp     x8, #0x2ce7000
0169f698  086942f9  ldr      x8, [x8, #0x4d0]
0169f69c  fc0300aa  mov      x28, x0
0169f6a0  080140f9  ldr      x8, [x8]
0169f6a4  099d4439  ldrb     w9, [x8, #0x127]
0169f6a8  a9000836  tbz      w9, #1, #0x169f6bc
0169f6ac  09d940b9  ldr      w9, [x8, #0xd8]
0169f6b0  69000035  cbnz     w9, #0x169f6bc
0169f6b4  e00308aa  mov      x0, x8
0169f6b8  acd2d997  bl       #0xd14168 ; unresolved symbol
0169f6bc  e0031baa  mov      x0, x27
0169f6c0  e1031caa  mov      x1, x28
0169f6c4  e2031faa  mov      x2, xzr
0169f6c8  3efe2b94  bl       #0x219efc0 ; BattleCore.TSMath$$Max
0169f6cc  e1ae40f9  ldr      x1, [x23, #0x158]
0169f6d0  fb0300aa  mov      x27, x0
0169f6d4  e00f40f9  ldr      x0, [sp, #0x18]
0169f6d8  e2031faa  mov      x2, xzr
0169f6dc  4dd22094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169f6e0  fc0300aa  mov      x28, x0
0169f6e4  e0031f2a  mov      w0, wzr
0169f6e8  e1031faa  mov      x1, xzr
0169f6ec  31d32094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169f6f0  e10300aa  mov      x1, x0
0169f6f4  e0031caa  mov      x0, x28
0169f6f8  e2031faa  mov      x2, xzr
0169f6fc  31fe2b94  bl       #0x219efc0 ; BattleCore.TSMath$$Max
0169f700  e8b640f9  ldr      x8, [x23, #0x168]
0169f704  01b740f9  ldr      x1, [x24, #0x168]
0169f708  fc0300aa  mov      x28, x0
0169f70c  e2031faa  mov      x2, xzr
0169f710  e00308aa  mov      x0, x8
0169f714  3fd22094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169f718  f93340f9  ldr      x25, [sp, #0x60]
0169f71c  f40300aa  mov      x20, x0
0169f720  e0030032  mov      w0, #1
0169f724  e1031faa  mov      x1, xzr
0169f728  22d32094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169f72c  e1031baa  mov      x1, x27
0169f730  e2031faa  mov      x2, xzr
0169f734  37d22094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169f738  e10300aa  mov      x1, x0
0169f73c  e00319aa  mov      x0, x25
0169f740  e2031faa  mov      x2, xzr
0169f744  39d22094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169f748  e1031faa  mov      x1, xzr
0169f74c  bad42094  bl       #0x1ed4a34 ; BattleCore.FP$$op_Explicit
0169f750  e1031faa  mov      x1, xzr
0169f754  17d32094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169f758  e1031caa  mov      x1, x28
0169f75c  e2031faa  mov      x2, xzr
0169f760  2cd22094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169f764  f90300aa  mov      x25, x0
0169f768  e0031f2a  mov      w0, wzr
0169f76c  e1031faa  mov      x1, xzr
0169f770  10d32094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169f774  e10300aa  mov      x1, x0
0169f778  e00314aa  mov      x0, x20
0169f77c  e2031faa  mov      x2, xzr
0169f780  10fe2b94  bl       #0x219efc0 ; BattleCore.TSMath$$Max
0169f784  e10300aa  mov      x1, x0
0169f788  e00319aa  mov      x0, x25
0169f78c  e2031faa  mov      x2, xzr
0169f790  f1d12094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169f794  fc1740f9  ldr      x28, [sp, #0x28]
0169f798  f90b40f9  ldr      x25, [sp, #0x10]
0169f79c  fb0300aa  mov      x27, x0
0169f7a0  fb3300f9  str      x27, [sp, #0x60]
0169f7a4  03000014  b        #0x169f7b0
0169f7a8  fb3340f9  ldr      x27, [sp, #0x60]
0169f7ac  fc1740f9  ldr      x28, [sp, #0x28]
0169f7b0  54b20090  adrp     x20, #0x2ce7000
0169f7b4  946a42f9  ldr      x20, [x20, #0x4d0]
0169f7b8  800240f9  ldr      x0, [x20]
0169f7bc  089c4439  ldrb     w8, [x0, #0x127]
0169f7c0  88000836  tbz      w8, #1, #0x169f7d0
0169f7c4  08d840b9  ldr      w8, [x0, #0xd8]
0169f7c8  48000035  cbnz     w8, #0x169f7d0
0169f7cc  67d2d997  bl       #0xd14168 ; unresolved symbol
0169f7d0  e0031baa  mov      x0, x27
0169f7d4  e10319aa  mov      x1, x25
0169f7d8  e2031faa  mov      x2, xzr
0169f7dc  f9fd2b94  bl       #0x219efc0 ; BattleCore.TSMath$$Max
0169f7e0  e03300f9  str      x0, [sp, #0x60]
0169f7e4  019b40f9  ldr      x1, [x24, #0x130]
0169f7e8  e0031aaa  mov      x0, x26
0169f7ec  ca020094  bl       #0x16a0314 ; A3BattleCore.SkillDamageHelper$$TestRate
0169f7f0  40050036  tbz      w0, #0, #0x169f898
0169f7f4  730000b5  cbnz     x19, #0x169f800
0169f7f8  e0031faa  mov      x0, xzr
0169f7fc  cc2fda97  bl       #0xd2b72c ; unresolved symbol
0169f800  e8030032  mov      w8, #1
0169f804  686e0039  strb     w8, [x19, #0x1b]
0169f808  e8b000d0  adrp     x8, #0x2cbd000
0169f80c  08dd47f9  ldr      x8, [x8, #0xfb8]
0169f810  f93340f9  ldr      x25, [sp, #0x60]
0169f814  1a9740f9  ldr      x26, [x24, #0x128]
0169f818  000140f9  ldr      x0, [x8]
0169f81c  089c4439  ldrb     w8, [x0, #0x127]
0169f820  88000836  tbz      w8, #1, #0x169f830
0169f824  08d840b9  ldr      w8, [x0, #0xd8]
0169f828  48000035  cbnz     w8, #0x169f830
0169f82c  4fd2d997  bl       #0xd14168 ; unresolved symbol
0169f830  e00319aa  mov      x0, x25
0169f834  e1031aaa  mov      x1, x26
0169f838  e2031faa  mov      x2, xzr
0169f83c  fbd12094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169f840  e10300aa  mov      x1, x0
0169f844  e00319aa  mov      x0, x25
0169f848  e2031faa  mov      x2, xzr
0169f84c  f1d12094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169f850  e8b000d0  adrp     x8, #0x2cbd000
0169f854  08dd47f9  ldr      x8, [x8, #0xfb8]
0169f858  f90300aa  mov      x25, x0
0169f85c  f93300f9  str      x25, [sp, #0x60]
0169f860  800240f9  ldr      x0, [x20]
0169f864  080140f9  ldr      x8, [x8]
0169f868  099c4439  ldrb     w9, [x0, #0x127]
0169f86c  085d40f9  ldr      x8, [x8, #0xb8]
0169f870  1a1940f9  ldr      x26, [x8, #0x30]
0169f874  89000836  tbz      w9, #1, #0x169f884
0169f878  08d840b9  ldr      w8, [x0, #0xd8]
0169f87c  48000035  cbnz     w8, #0x169f884
0169f880  3ad2d997  bl       #0xd14168 ; unresolved symbol
0169f884  e00319aa  mov      x0, x25
0169f888  e1031aaa  mov      x1, x26
0169f88c  e2031faa  mov      x2, xzr
0169f890  ccfd2b94  bl       #0x219efc0 ; BattleCore.TSMath$$Max
0169f894  e03300f9  str      x0, [sp, #0x60]
0169f898  e8b000d0  adrp     x8, #0x2cbd000
0169f89c  08dd47f9  ldr      x8, [x8, #0xfb8]
0169f8a0  b90b40f9  ldr      x25, [x29, #0x10]
0169f8a4  faba40f9  ldr      x26, [x23, #0x170]
0169f8a8  1bcf40f9  ldr      x27, [x24, #0x198]
0169f8ac  000140f9  ldr      x0, [x8]
0169f8b0  089c4439  ldrb     w8, [x0, #0x127]
0169f8b4  88000836  tbz      w8, #1, #0x169f8c4
0169f8b8  08d840b9  ldr      w8, [x0, #0xd8]
0169f8bc  48000035  cbnz     w8, #0x169f8c4
0169f8c0  2ad2d997  bl       #0xd14168 ; unresolved symbol
0169f8c4  e0031aaa  mov      x0, x26
0169f8c8  e1031baa  mov      x1, x27
0169f8cc  e2031faa  mov      x2, xzr
0169f8d0  d0d12094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169f8d4  e8b000d0  adrp     x8, #0x2cbd000
0169f8d8  08dd47f9  ldr      x8, [x8, #0xfb8]
0169f8dc  fb0300aa  mov      x27, x0
0169f8e0  090140f9  ldr      x9, [x8]
0169f8e4  880240f9  ldr      x8, [x20]
0169f8e8  295d40f9  ldr      x9, [x9, #0xb8]
0169f8ec  0a9d4439  ldrb     w10, [x8, #0x127]
0169f8f0  3a1940f9  ldr      x26, [x9, #0x30]
0169f8f4  aa000836  tbz      w10, #1, #0x169f908
0169f8f8  09d940b9  ldr      w9, [x8, #0xd8]
0169f8fc  69000035  cbnz     w9, #0x169f908
0169f900  e00308aa  mov      x0, x8
0169f904  19d2d997  bl       #0xd14168 ; unresolved symbol
0169f908  e0031baa  mov      x0, x27
0169f90c  e1031aaa  mov      x1, x26
0169f910  e2031faa  mov      x2, xzr
0169f914  abfd2b94  bl       #0x219efc0 ; BattleCore.TSMath$$Max
0169f918  e8be40f9  ldr      x8, [x23, #0x178]
0169f91c  01d340f9  ldr      x1, [x24, #0x1a0]
0169f920  f40300aa  mov      x20, x0
0169f924  e2031faa  mov      x2, xzr
0169f928  e00308aa  mov      x0, x8
0169f92c  b9d12094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169f930  fab000d0  adrp     x26, #0x2cbd000
0169f934  5adf47f9  ldr      x26, [x26, #0xfb8]
0169f938  e2031faa  mov      x2, xzr
0169f93c  480340f9  ldr      x8, [x26]
0169f940  085d40f9  ldr      x8, [x8, #0xb8]
0169f944  011940f9  ldr      x1, [x8, #0x30]
0169f948  9efd2b94  bl       #0x219efc0 ; BattleCore.TSMath$$Max
0169f94c  e10300aa  mov      x1, x0
0169f950  e00314aa  mov      x0, x20
0169f954  e2031faa  mov      x2, xzr
0169f958  7fd12094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169f95c  e8c640f9  ldr      x8, [x23, #0x188]
0169f960  01db40f9  ldr      x1, [x24, #0x1b0]
0169f964  f40300aa  mov      x20, x0
0169f968  e2031faa  mov      x2, xzr
0169f96c  e00308aa  mov      x0, x8
0169f970  a8d12094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169f974  480340f9  ldr      x8, [x26]
0169f978  e2031faa  mov      x2, xzr
0169f97c  085d40f9  ldr      x8, [x8, #0xb8]
0169f980  011940f9  ldr      x1, [x8, #0x30]
0169f984  8ffd2b94  bl       #0x219efc0 ; BattleCore.TSMath$$Max
0169f988  e10300aa  mov      x1, x0
0169f98c  e00314aa  mov      x0, x20
0169f990  e2031faa  mov      x2, xzr
0169f994  70d12094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169f998  e8c240f9  ldr      x8, [x23, #0x180]
0169f99c  01d740f9  ldr      x1, [x24, #0x1a8]
0169f9a0  f40300aa  mov      x20, x0
0169f9a4  e2031faa  mov      x2, xzr
0169f9a8  e00308aa  mov      x0, x8
0169f9ac  99d12094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169f9b0  480340f9  ldr      x8, [x26]
0169f9b4  e2031faa  mov      x2, xzr
0169f9b8  085d40f9  ldr      x8, [x8, #0xb8]
0169f9bc  011940f9  ldr      x1, [x8, #0x30]
0169f9c0  80fd2b94  bl       #0x219efc0 ; BattleCore.TSMath$$Max
0169f9c4  e10300aa  mov      x1, x0
0169f9c8  e00314aa  mov      x0, x20
0169f9cc  e2031faa  mov      x2, xzr
0169f9d0  61d12094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169f9d4  e8ca40f9  ldr      x8, [x23, #0x190]
0169f9d8  01df40f9  ldr      x1, [x24, #0x1b8]
0169f9dc  f40300aa  mov      x20, x0
0169f9e0  e2031faa  mov      x2, xzr
0169f9e4  e00308aa  mov      x0, x8
0169f9e8  8ad12094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169f9ec  480340f9  ldr      x8, [x26]
0169f9f0  e2031faa  mov      x2, xzr
0169f9f4  085d40f9  ldr      x8, [x8, #0xb8]
0169f9f8  011940f9  ldr      x1, [x8, #0x30]
0169f9fc  71fd2b94  bl       #0x219efc0 ; BattleCore.TSMath$$Max
0169fa00  e10300aa  mov      x1, x0
0169fa04  e00314aa  mov      x0, x20
0169fa08  e2031faa  mov      x2, xzr
0169fa0c  52d12094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169fa10  e10319aa  mov      x1, x25
0169fa14  e2031faa  mov      x2, xzr
0169fa18  84d12094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169fa1c  480340f9  ldr      x8, [x26]
0169fa20  e02f00f9  str      x0, [sp, #0x58]
0169fa24  e2031faa  mov      x2, xzr
0169fa28  085d40f9  ldr      x8, [x8, #0xb8]
0169fa2c  011940f9  ldr      x1, [x8, #0x30]
0169fa30  88d22094  bl       #0x1ed4450 ; BattleCore.FP$$op_GreaterThan
0169fa34  c0030036  tbz      w0, #0, #0x169faac
0169fa38  530100b4  cbz      x19, #0x169fa60
0169fa3c  f40313aa  mov      x20, x19
0169fa40  984e47b8  ldr      w24, [x20, #0x74]!
0169fa44  e8030032  mov      w8, #1
0169fa48  e0630191  add      x0, sp, #0x58
0169fa4c  e1031faa  mov      x1, xzr
0169fa50  88c21f38  sturb    w8, [x20, #-4]
0169fa54  43d62094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169fa58  f703002a  mov      w23, w0
0169fa5c  10000014  b        #0x169fa9c
0169fa60  e0031faa  mov      x0, xzr
0169fa64  322fda97  bl       #0xd2b72c ; unresolved symbol
0169fa68  e80b1c32  mov      w8, #0x70
0169fa6c  e9030032  mov      w9, #1
0169fa70  e0031faa  mov      x0, xzr
0169fa74  09010039  strb     w9, [x8]
0169fa78  2d2fda97  bl       #0xd2b72c ; unresolved symbol
0169fa7c  940e8052  mov      w20, #0x74
0169fa80  980240b9  ldr      w24, [x20]
0169fa84  e0630191  add      x0, sp, #0x58
0169fa88  e1031faa  mov      x1, xzr
0169fa8c  35d62094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169fa90  f703002a  mov      w23, w0
0169fa94  e0031faa  mov      x0, xzr
0169fa98  252fda97  bl       #0xd2b72c ; unresolved symbol
0169fa9c  0803170b  add      w8, w24, w23
0169faa0  880200b9  str      w8, [x20]
0169faa4  fab000d0  adrp     x26, #0x2cbd000
0169faa8  5adf47f9  ldr      x26, [x26, #0xfb8]
0169faac  f73340f9  ldr      x23, [sp, #0x60]
0169fab0  730000b5  cbnz     x19, #0x169fabc
0169fab4  e0031faa  mov      x0, xzr
0169fab8  1d2fda97  bl       #0xd2b72c ; unresolved symbol
0169fabc  400340f9  ldr      x0, [x26]
0169fac0  787640b9  ldr      w24, [x19, #0x74]
0169fac4  089c4439  ldrb     w8, [x0, #0x127]
0169fac8  88000836  tbz      w8, #1, #0x169fad8
0169facc  08d840b9  ldr      w8, [x0, #0xd8]
0169fad0  48000035  cbnz     w8, #0x169fad8
0169fad4  a5d1d997  bl       #0xd14168 ; unresolved symbol
0169fad8  e003182a  mov      w0, w24
0169fadc  e1031faa  mov      x1, xzr
0169fae0  34d22094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169fae4  e10300aa  mov      x1, x0
0169fae8  e00317aa  mov      x0, x23
0169faec  e2031faa  mov      x2, xzr
0169faf0  19d12094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169faf4  e11340f9  ldr      x1, [sp, #0x20]
0169faf8  e2031faa  mov      x2, xzr
0169fafc  e03300f9  str      x0, [sp, #0x60]
0169fb00  4ad12094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169fb04  e03300f9  str      x0, [sp, #0x60]
0169fb08  774640f9  ldr      x23, [x19, #0x88]
0169fb0c  770000b5  cbnz     x23, #0x169fb18
0169fb10  e0031faa  mov      x0, xzr
0169fb14  062fda97  bl       #0xd2b72c ; unresolved symbol
0169fb18  e81a40b9  ldr      w8, [x23, #0x18]
0169fb1c  a8000035  cbnz     w8, #0x169fb30
0169fb20  3c32da97  bl       #0xd2c410 ; unresolved symbol
0169fb24  e1031faa  mov      x1, xzr
0169fb28  e2031faa  mov      x2, xzr
0169fb2c  dc2eda97  bl       #0xd2b69c ; unresolved symbol
0169fb30  744640f9  ldr      x20, [x19, #0x88]
0169fb34  f72240b9  ldr      w23, [x23, #0x20]
0169fb38  740000b5  cbnz     x20, #0x169fb44
0169fb3c  e0031faa  mov      x0, xzr
0169fb40  fb2eda97  bl       #0xd2b72c ; unresolved symbol
0169fb44  881a40b9  ldr      w8, [x20, #0x18]
0169fb48  1f050071  cmp      w8, #1
0169fb4c  a8000054  b.hi     #0x169fb60
0169fb50  3032da97  bl       #0xd2c410 ; unresolved symbol
0169fb54  e1031faa  mov      x1, xzr
0169fb58  e2031faa  mov      x2, xzr
0169fb5c  d02eda97  bl       #0xd2b69c ; unresolved symbol
0169fb60  794640f9  ldr      x25, [x19, #0x88]
0169fb64  982640b9  ldr      w24, [x20, #0x24]
0169fb68  790000b5  cbnz     x25, #0x169fb74
0169fb6c  e0031faa  mov      x0, xzr
0169fb70  ef2eda97  bl       #0xd2b72c ; unresolved symbol
0169fb74  281b40b9  ldr      w8, [x25, #0x18]
0169fb78  1f090071  cmp      w8, #2
0169fb7c  a8000054  b.hi     #0x169fb90
0169fb80  2432da97  bl       #0xd2c410 ; unresolved symbol
0169fb84  e1031faa  mov      x1, xzr
0169fb88  e2031faa  mov      x2, xzr
0169fb8c  c42eda97  bl       #0xd2b69c ; unresolved symbol
0169fb90  744640f9  ldr      x20, [x19, #0x88]
0169fb94  392b40b9  ldr      w25, [x25, #0x28]
0169fb98  740000b5  cbnz     x20, #0x169fba4
0169fb9c  e0031faa  mov      x0, xzr
0169fba0  e32eda97  bl       #0xd2b72c ; unresolved symbol
0169fba4  881a40b9  ldr      w8, [x20, #0x18]
0169fba8  1f0d0071  cmp      w8, #3
0169fbac  a8000054  b.hi     #0x169fbc0
0169fbb0  1832da97  bl       #0xd2c410 ; unresolved symbol
0169fbb4  e1031faa  mov      x1, xzr
0169fbb8  e2031faa  mov      x2, xzr
0169fbbc  b82eda97  bl       #0xd2b69c ; unresolved symbol
0169fbc0  882e40b9  ldr      w8, [x20, #0x2c]
0169fbc4  f43340f9  ldr      x20, [sp, #0x60]
0169fbc8  0903170b  add      w9, w24, w23
0169fbcc  2901190b  add      w9, w9, w25
0169fbd0  2001080b  add      w0, w9, w8
0169fbd4  e1031faa  mov      x1, xzr
0169fbd8  f6d12094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169fbdc  e10300aa  mov      x1, x0
0169fbe0  e00314aa  mov      x0, x20
0169fbe4  e2031faa  mov      x2, xzr
0169fbe8  dbd02094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169fbec  e03300f9  str      x0, [sp, #0x60]
0169fbf0  e0830191  add      x0, sp, #0x60
0169fbf4  e1031faa  mov      x1, xzr
0169fbf8  dad52094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
0169fbfc  601200b9  str      w0, [x19, #0x10]
0169fc00  760000b5  cbnz     x22, #0x169fc0c
0169fc04  e0031faa  mov      x0, xzr
0169fc08  c92eda97  bl       #0xd2b72c ; unresolved symbol
0169fc0c  e00316aa  mov      x0, x22
0169fc10  e1031faa  mov      x1, xzr
0169fc14  96b10294  bl       #0x174c26c ; A3BattleCore.ActorEntity$$get_BuffMgr
0169fc18  f4b000d0  adrp     x20, #0x2cbd000
0169fc1c  94de47f9  ldr      x20, [x20, #0xfb8]
0169fc20  f60300aa  mov      x22, x0
0169fc24  560000b5  cbnz     x22, #0x169fc2c
0169fc28  c12eda97  bl       #0xd2b72c ; unresolved symbol
0169fc2c  e00316aa  mov      x0, x22
0169fc30  e10315aa  mov      x1, x21
0169fc34  e20313aa  mov      x2, x19
0169fc38  e3031faa  mov      x3, xzr
0169fc3c  1d0dfe97  bl       #0x16230b0 ; A3BattleCore.BuffManger$$ProcessCauseDeath
0169fc40  951340f9  ldr      x21, [x28, #0x20]
0169fc44  f603002a  mov      w22, w0
0169fc48  750000b5  cbnz     x21, #0x169fc54
0169fc4c  e0031faa  mov      x0, xzr
0169fc50  b72eda97  bl       #0xd2b72c ; unresolved symbol
0169fc54  e00315aa  mov      x0, x21
0169fc58  e1031faa  mov      x1, xzr
0169fc5c  62c30294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169fc60  f50300aa  mov      x21, x0
0169fc64  550000b5  cbnz     x21, #0x169fc6c
0169fc68  b12eda97  bl       #0xd2b72c ; unresolved symbol
0169fc6c  e00315aa  mov      x0, x21
0169fc70  e1031faa  mov      x1, xzr
0169fc74  b1db0294  bl       #0x1756b38 ; A3BattleCore.ActorData$$get_HP
0169fc78  f503002a  mov      w21, w0
0169fc7c  36050036  tbz      w22, #0, #0x169fd20
0169fc80  e8030032  mov      w8, #1
0169fc84  68720039  strb     w8, [x19, #0x1c]
0169fc88  961340f9  ldr      x22, [x28, #0x20]
0169fc8c  760000b5  cbnz     x22, #0x169fc98
0169fc90  e0031faa  mov      x0, xzr
0169fc94  a62eda97  bl       #0xd2b72c ; unresolved symbol
0169fc98  e00316aa  mov      x0, x22
0169fc9c  e1031faa  mov      x1, xzr
0169fca0  51c30294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169fca4  f60300aa  mov      x22, x0
0169fca8  560000b5  cbnz     x22, #0x169fcb0
0169fcac  a02eda97  bl       #0xd2b72c ; unresolved symbol
0169fcb0  e00316aa  mov      x0, x22
0169fcb4  e1031faa  mov      x1, xzr
0169fcb8  4fc30294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169fcbc  f60300aa  mov      x22, x0
0169fcc0  560000b5  cbnz     x22, #0x169fcc8
0169fcc4  9a2eda97  bl       #0xd2b72c ; unresolved symbol
0169fcc8  941340f9  ldr      x20, [x28, #0x20]
0169fccc  d61240b9  ldr      w22, [x22, #0x10]
0169fcd0  740000b5  cbnz     x20, #0x169fcdc
0169fcd4  e0031faa  mov      x0, xzr
0169fcd8  952eda97  bl       #0xd2b72c ; unresolved symbol
0169fcdc  e00314aa  mov      x0, x20
0169fce0  e1031faa  mov      x1, xzr
0169fce4  40c30294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169fce8  f40300aa  mov      x20, x0
0169fcec  540000b5  cbnz     x20, #0x169fcf4
0169fcf0  8f2eda97  bl       #0xd2b72c ; unresolved symbol
0169fcf4  e00314aa  mov      x0, x20
0169fcf8  e1031faa  mov      x1, xzr
0169fcfc  96db0294  bl       #0x1756b54 ; A3BattleCore.ActorData$$get_HpCount
0169fd00  1f040071  cmp      w0, #1
0169fd04  09c49f1a  csinc    w9, w0, wzr, gt
0169fd08  29050051  sub      w9, w9, #1
0169fd0c  e8030032  mov      w8, #1
0169fd10  2955161b  madd     w9, w9, w22, w21
0169fd14  691200b9  str      w9, [x19, #0x10]
0169fd18  68a20039  strb     w8, [x19, #0x28]
0169fd1c  9ffdff17  b        #0x169f398
0169fd20  bf060071  cmp      w21, #1
0169fd24  eb010054  b.lt     #0x169fd60
0169fd28  800240f9  ldr      x0, [x20]
0169fd2c  089c4439  ldrb     w8, [x0, #0x127]
0169fd30  88000836  tbz      w8, #1, #0x169fd40
0169fd34  08d840b9  ldr      w8, [x0, #0xd8]
0169fd38  48000035  cbnz     w8, #0x169fd40
0169fd3c  0bd1d997  bl       #0xd14168 ; unresolved symbol
0169fd40  e003152a  mov      w0, w21
0169fd44  e1031faa  mov      x1, xzr
0169fd48  9ad12094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169fd4c  e13340f9  ldr      x1, [sp, #0x60]
0169fd50  e2031faa  mov      x2, xzr
0169fd54  c8d12094  bl       #0x1ed4474 ; BattleCore.FP$$op_LessThanOrEqual
0169fd58  08000012  and      w8, w0, #1
0169fd5c  02000014  b        #0x169fd64
0169fd60  e8031f2a  mov      w8, wzr
0169fd64  68720039  strb     w8, [x19, #0x1c]
0169fd68  8cfdff17  b        #0x169f398
0169fd6c  f4b000d0  adrp     x20, #0x2cbd000
0169fd70  94de47f9  ldr      x20, [x20, #0xfb8]
0169fd74  e00316aa  mov      x0, x22
0169fd78  93fdff17  b        #0x169f3c4
0169fd7c  01000014  b        #0x169fd80
0169fd80  f30300aa  mov      x19, x0
0169fd84  a06301d1  sub      x0, x29, #0x58
0169fd88  d214db97  bl       #0xd650d0 ; unresolved symbol
0169fd8c  06000014  b        #0x169fda4
0169fd90  eeb5d797  bl       #0xc8d548 ; unresolved symbol
0169fd94  01000014  b        #0x169fd98
0169fd98  f30300aa  mov      x19, x0
0169fd9c  a06301d1  sub      x0, x29, #0x58
0169fda0  cc14db97  bl       #0xd650d0 ; unresolved symbol
0169fda4  e00313aa  mov      x0, x19
0169fda8  c2f3d597  bl       #0xc1ccb0 ; unresolved symbol
0169fdac  e7b5d797  bl       #0xc8d548 ; unresolved symbol
