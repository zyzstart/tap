; RVA 0x16a03cc, file offset 0x16a03cc, conservative end 0x16a04e8
; SHA256 234b06e03a9ec8a30481c19df574d26e40f4c12e6fb34753bed6f1ce60c41047
; All aliases at this entry: A3BattleCore.SkillDamageHelper$$DoCalcDamageWithFourEle :: void A3BattleCore_SkillDamageHelper__DoCalcDamageWithFourEle (A3BattleCore_SkillDamageHelper_o* __this, A3BattleCore_ActorEntity_o* sourceActor, A3BattleCore_ActorEntity_o* targetActor, A3BattleCore_HitInfo_o* hitInfo, A3BattleCore_DamageInfo_o* info, int32_t type, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
016a03cc  f657bda9  stp      x22, x21, [sp, #-0x30]!
016a03d0  f44f01a9  stp      x20, x19, [sp, #0x10]
016a03d4  fd7b02a9  stp      x29, x30, [sp, #0x20]
016a03d8  fd830091  add      x29, sp, #0x20
016a03dc  f503052a  mov      w21, w5
016a03e0  f30304aa  mov      x19, x4
016a03e4  f40303aa  mov      x20, x3
016a03e8  f60302aa  mov      x22, x2
016a03ec  760000b5  cbnz     x22, #0x16a03f8
016a03f0  e0031faa  mov      x0, xzr
016a03f4  ce2cda97  bl       #0xd2b72c ; unresolved symbol
016a03f8  e00316aa  mov      x0, x22
016a03fc  e1031faa  mov      x1, xzr
016a0400  9baf0294  bl       #0x174c26c ; A3BattleCore.ActorEntity$$get_BuffMgr
016a0404  f60300aa  mov      x22, x0
016a0408  560000b5  cbnz     x22, #0x16a0410
016a040c  c82cda97  bl       #0xd2b72c ; unresolved symbol
016a0410  e00316aa  mov      x0, x22
016a0414  e1031faa  mov      x1, xzr
016a0418  3df7fd97  bl       #0x161e10c ; A3BattleCore.BuffManger$$CanBeDamaged
016a041c  f603002a  mov      w22, w0
016a0420  f30400b4  cbz      x19, #0x16a04bc
016a0424  36050036  tbz      w22, #0, #0x16a04c8
016a0428  764640f9  ldr      x22, [x19, #0x88]
016a042c  760000b5  cbnz     x22, #0x16a0438
016a0430  e0031faa  mov      x0, xzr
016a0434  be2cda97  bl       #0xd2b72c ; unresolved symbol
016a0438  c81a40b9  ldr      w8, [x22, #0x18]
016a043c  1f01156b  cmp      w8, w21
016a0440  b57e4093  sxtw     x21, w21
016a0444  a8000054  b.hi     #0x16a0458
016a0448  f22fda97  bl       #0xd2c410 ; unresolved symbol
016a044c  e1031faa  mov      x1, xzr
016a0450  e2031faa  mov      x2, xzr
016a0454  922cda97  bl       #0xd2b69c ; unresolved symbol
016a0458  c80a158b  add      x8, x22, x21, lsl #2
016a045c  082140b9  ldr      w8, [x8, #0x20]
016a0460  681200b9  str      w8, [x19, #0x10]
016a0464  740000b5  cbnz     x20, #0x16a0470
016a0468  e0031faa  mov      x0, xzr
016a046c  b02cda97  bl       #0xd2b72c ; unresolved symbol
016a0470  941240f9  ldr      x20, [x20, #0x20]
016a0474  740000b5  cbnz     x20, #0x16a0480
016a0478  e0031faa  mov      x0, xzr
016a047c  ac2cda97  bl       #0xd2b72c ; unresolved symbol
016a0480  e00314aa  mov      x0, x20
016a0484  e1031faa  mov      x1, xzr
016a0488  57c10294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
016a048c  f40300aa  mov      x20, x0
016a0490  540000b5  cbnz     x20, #0x16a0498
016a0494  a62cda97  bl       #0xd2b72c ; unresolved symbol
016a0498  e00314aa  mov      x0, x20
016a049c  e1031faa  mov      x1, xzr
016a04a0  a6d90294  bl       #0x1756b38 ; A3BattleCore.ActorData$$get_HP
016a04a4  1f040071  cmp      w0, #1
016a04a8  4b010054  b.lt     #0x16a04d0
016a04ac  681240b9  ldr      w8, [x19, #0x10]
016a04b0  1f00086b  cmp      w0, w8
016a04b4  e8c79f1a  cset     w8, le
016a04b8  07000014  b        #0x16a04d4
016a04bc  e0031faa  mov      x0, xzr
016a04c0  9b2cda97  bl       #0xd2b72c ; unresolved symbol
016a04c4  36fb0737  tbnz     w22, #0, #0x16a0428
016a04c8  7f1200b9  str      wzr, [x19, #0x10]
016a04cc  03000014  b        #0x16a04d8
016a04d0  e8031f2a  mov      w8, wzr
016a04d4  68720039  strb     w8, [x19, #0x1c]
016a04d8  fd7b42a9  ldp      x29, x30, [sp, #0x20]
016a04dc  f44f41a9  ldp      x20, x19, [sp, #0x10]
016a04e0  f657c3a8  ldp      x22, x21, [sp], #0x30
016a04e4  c0035fd6  ret      
