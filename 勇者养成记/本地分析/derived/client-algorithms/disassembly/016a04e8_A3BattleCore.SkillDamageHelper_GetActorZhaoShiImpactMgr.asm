; RVA 0x16a04e8, file offset 0x16a04e8, conservative end 0x16a064c
; SHA256 78e91249feba6d33c1c6b0810106cad3b8ae6d3f8d0c62db5f6f8065219e9847
; All aliases at this entry: A3BattleCore.SkillDamageHelper$$GetActorZhaoShiImpactMgr :: A3BattleCore_ActorAttrImpactMgr_o* A3BattleCore_SkillDamageHelper__GetActorZhaoShiImpactMgr (A3BattleCore_SkillDamageHelper_o* __this, A3BattleCore_ActorEntity_o* sourceActor, uint32_t skillId, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
016a04e8  f85fbca9  stp      x24, x23, [sp, #-0x40]!
016a04ec  f65701a9  stp      x22, x21, [sp, #0x10]
016a04f0  f44f02a9  stp      x20, x19, [sp, #0x20]
016a04f4  fd7b03a9  stp      x29, x30, [sp, #0x30]
016a04f8  fdc30091  add      x29, sp, #0x30
016a04fc  f40301aa  mov      x20, x1
016a0500  f303022a  mov      w19, w2
016a0504  e00314aa  mov      x0, x20
016a0508  e1031faa  mov      x1, xzr
016a050c  e2031faa  mov      x2, xzr
016a0510  0ab60294  bl       #0x174dd38 ; A3BattleCore.ActorEntity$$op_Equality
016a0514  a0050037  tbnz     w0, #0, #0x16a05c8
016a0518  740000b5  cbnz     x20, #0x16a0524
016a051c  e0031faa  mov      x0, xzr
016a0520  832cda97  bl       #0xd2b72c ; unresolved symbol
016a0524  880240f9  ldr      x8, [x20]
016a0528  e00314aa  mov      x0, x20
016a052c  098559a9  ldp      x9, x1, [x8, #0x198]
016a0530  20013fd6  blr      x9
016a0534  1f040071  cmp      w0, #1
016a0538  81040054  b.ne     #0x16a05c8
016a053c  e00314aa  mov      x0, x20
016a0540  e1031faa  mov      x1, xzr
016a0544  b4bf0294  bl       #0x1750414 ; A3BattleCore.ActorEntity$$get_CreateData
016a0548  f40300aa  mov      x20, x0
016a054c  540000b5  cbnz     x20, #0x16a0554
016a0550  772cda97  bl       #0xd2b72c ; unresolved symbol
016a0554  940e40f9  ldr      x20, [x20, #0x18]
016a0558  740000b5  cbnz     x20, #0x16a0564
016a055c  e0031faa  mov      x0, xzr
016a0560  732cda97  bl       #0xd2b72c ; unresolved symbol
016a0564  956240f9  ldr      x21, [x20, #0xc0]
016a0568  f6031f2a  mov      w22, wzr
016a056c  11000014  b        #0x16a05b0
016a0570  df02086b  cmp      w22, w8
016a0574  d77e4093  sxtw     x23, w22
016a0578  a3000054  b.lo     #0x16a058c
016a057c  a52fda97  bl       #0xd2c410 ; unresolved symbol
016a0580  e1031faa  mov      x1, xzr
016a0584  e2031faa  mov      x2, xzr
016a0588  452cda97  bl       #0xd2b69c ; unresolved symbol
016a058c  b70e178b  add      x23, x21, x23, lsl #3
016a0590  f80e42f8  ldr      x24, [x23, #0x20]!
016a0594  780000b5  cbnz     x24, #0x16a05a0
016a0598  e0031faa  mov      x0, xzr
016a059c  642cda97  bl       #0xd2b72c ; unresolved symbol
016a05a0  081b40b9  ldr      w8, [x24, #0x18]
016a05a4  1f01136b  cmp      w8, w19
016a05a8  c0010054  b.eq     #0x16a05e0
016a05ac  d6060011  add      w22, w22, #1
016a05b0  750000b5  cbnz     x21, #0x16a05bc
016a05b4  e0031faa  mov      x0, xzr
016a05b8  5d2cda97  bl       #0xd2b72c ; unresolved symbol
016a05bc  a81a40b9  ldr      w8, [x21, #0x18]
016a05c0  df02086b  cmp      w22, w8
016a05c4  6bfdff54  b.lt     #0x16a0570
016a05c8  fd7b43a9  ldp      x29, x30, [sp, #0x30]
016a05cc  f44f42a9  ldp      x20, x19, [sp, #0x20]
016a05d0  f65741a9  ldp      x22, x21, [sp, #0x10]
016a05d4  e0031faa  mov      x0, xzr
016a05d8  f85fc4a8  ldp      x24, x23, [sp], #0x40
016a05dc  c0035fd6  ret      
016a05e0  740000b5  cbnz     x20, #0x16a05ec
016a05e4  e0031faa  mov      x0, xzr
016a05e8  512cda97  bl       #0xd2b72c ; unresolved symbol
016a05ec  a81a40b9  ldr      w8, [x21, #0x18]
016a05f0  933e40f9  ldr      x19, [x20, #0x78]
016a05f4  df02086b  cmp      w22, w8
016a05f8  a3000054  b.lo     #0x16a060c
016a05fc  852fda97  bl       #0xd2c410 ; unresolved symbol
016a0600  e1031faa  mov      x1, xzr
016a0604  e2031faa  mov      x2, xzr
016a0608  252cda97  bl       #0xd2b69c ; unresolved symbol
016a060c  f40240f9  ldr      x20, [x23]
016a0610  740000b5  cbnz     x20, #0x16a061c
016a0614  e0031faa  mov      x0, xzr
016a0618  452cda97  bl       #0xd2b72c ; unresolved symbol
016a061c  941240b9  ldr      w20, [x20, #0x10]
016a0620  730000b5  cbnz     x19, #0x16a062c
016a0624  e0031faa  mov      x0, xzr
016a0628  412cda97  bl       #0xd2b72c ; unresolved symbol
016a062c  e00313aa  mov      x0, x19
016a0630  e103142a  mov      w1, w20
016a0634  fd7b43a9  ldp      x29, x30, [sp, #0x30]
016a0638  f44f42a9  ldp      x20, x19, [sp, #0x20]
016a063c  f65741a9  ldp      x22, x21, [sp, #0x10]
016a0640  e2031faa  mov      x2, xzr
016a0644  f85fc4a8  ldp      x24, x23, [sp], #0x40
016a0648  a2c90214  b        #0x1752cd0 ; A3BattleCore.ActorAttrData$$GetZhaoShiSkillImpactMgr
