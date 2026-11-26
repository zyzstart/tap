; RVA 0x16a00e4, file offset 0x16a00e4, conservative end 0x16a01c8
; SHA256 5d1a164412be4351daebd0fe9d630c376ef1c5a3c2c8e66f084e8e8bef56754a
; All aliases at this entry: A3BattleCore.SkillDamageHelper$$GetFiveEleMiniDamage :: BattleCore_FP_o A3BattleCore_SkillDamageHelper__GetFiveEleMiniDamage (BattleCore_FP_o curFiveEleDamage, BattleCore_FP_o checkFiveEleDamage, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
016a00e4  f50f1df8  str      x21, [sp, #-0x30]!
016a00e8  f44f01a9  stp      x20, x19, [sp, #0x10]
016a00ec  fd7b02a9  stp      x29, x30, [sp, #0x20]
016a00f0  fd830091  add      x29, sp, #0x20
016a00f4  f5c400f0  adrp     x21, #0x2f3f000
016a00f8  a81e7c39  ldrb     w8, [x21, #0xf07]
016a00fc  f30301aa  mov      x19, x1
016a0100  f40300aa  mov      x20, x0
016a0104  e8000037  tbnz     w8, #0, #0x16a0120
016a0108  a8b200f0  adrp     x8, #0x2cf7000
016a010c  08b147f9  ldr      x8, [x8, #0xf60]
016a0110  000140b9  ldr      w0, [x8]
016a0114  8593d997  bl       #0xd04f28 ; unresolved symbol
016a0118  e8030032  mov      w8, #1
016a011c  a81e3c39  strb     w8, [x21, #0xf07]
016a0120  68af00f0  adrp     x8, #0x2c8f000
016a0124  087941f9  ldr      x8, [x8, #0x2f0]
016a0128  000140f9  ldr      x0, [x8]
016a012c  14140594  bl       #0x17e517c ; A3BattleCore.FSingleton<BattleLevelConfigMgr>$$get_Instance | A3BattleCore.FSingleton<BeastTideCollectItemCfgMgr>$$get_Instance | A3BattleCore.FSingleton<BeastTideConfigMgr>$$get_Instance | A3BattleCore.FSingleton<BianShenCfgMgr>$$get_Instance | A3BattleCore.FSingleton<BootyCfgMgr>$$get_Instance | A3BattleCore.FSingleton<BuffConfigMgr>$$get_Instance | A3BattleCore.FSingleton<ElementTeamCfgMgr>$$get_Instance | A3BattleCore.FSingleton<FDataPool<CSRelaySyncOneFrameData>>$$get_Instance | A3BattleCore.FSingleton<FMemPoolMgr>$$get_Instance | A3BattleCore.FSingleton<FMemPool<ActorAttrData>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<ActorAttrImpactMgr>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdBianShen>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdGmRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdMoveRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdReRandomSkillRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdReliveRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdSelectRandomSkill>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdSetWorldBossHP>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdSkillRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdSummonPetRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdYuanShenSkillRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BufferItem>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<EntityVisualEventNode>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<EventRegInfo>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<FlyBullet>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<GridIndexNode>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<LightChainBullet>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<LightChainNode>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<RayBullet>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<ShootPointBullet>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<SkillPlayData>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<SkillRepeatTranslateHandle.MoveData>>$$get_Instance | A3BattleCore.FSingleton<ForeverConfigMgr>$$get_Instance | A3BattleCore.FSingleton<GuardBlitzConfigMgr>$$get_Instance | A3BattleCore.FSingleton<HellLevelCfgMgr>$$get_Instance | A3BattleCore.FSingleton<HorseCfgMgr>$$get_Instance | A3BattleCore.FSingleton<IslandAdventureCfgMgr>$$get_Instance | A3BattleCore.FSingleton<ItemConfigMgr>$$get_Instance | A3BattleCore.FSingleton<LevelCfgMgr>$$get_Instance | A3BattleCore.FSingleton<LongHunConfigMgr>$$get_Instance | A3BattleCore.FSingleton<MHZBConfigMgr>$$get_Instance | A3BattleCore.FSingleton<MiJingConfigMgr>$$get_Instance | A3BattleCore.FSingleton<ModelConfigMgr>$$get_Instance | A3BattleCore.FSingleton<MonsterCfgMgr>$$get_Instance | A3BattleCore.FSingleton<ParamConfigMgr>$$get_Instance | A3BattleCore.FSingleton<PengPengTuTengCfgMgr>$$get_Instance | A3BattleCore.FSingleton<PetCfgMgr>$$get_Instance | A3BattleCore.FSingleton<PvpConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SacredBeastConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SacredEquipCfgMgr>$$get_Instance | A3BattleCore.FSingleton<SkillConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SkillDispConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SpiritConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SummonConfigMgr>$$get_Instance | A3BattleCore.FSingleton<TanSheConfigMgr>$$get_Instance | A3BattleCore.FSingleton<ToughnessConfigMgr>$$get_Instance | A3BattleCore.FSingleton<XianYuanConfigMgr>$$get_Instance | A3BattleCore.FSingleton<object>$$get_Instance
016a0130  f50300aa  mov      x21, x0
016a0134  550000b5  cbnz     x21, #0x16a013c
016a0138  7d2dda97  bl       #0xd2b72c ; unresolved symbol
016a013c  e10b1b32  mov      w1, #0xe0
016a0140  e00315aa  mov      x0, x21
016a0144  e2031faa  mov      x2, xzr
016a0148  75e0fc97  bl       #0x15d831c ; A3BattleCore.ParamConfigMgr$$GetFloatParam
016a014c  e8b000b0  adrp     x8, #0x2cbd000
016a0150  08dd47f9  ldr      x8, [x8, #0xfb8]
016a0154  f50300aa  mov      x21, x0
016a0158  080140f9  ldr      x8, [x8]
016a015c  099d4439  ldrb     w9, [x8, #0x127]
016a0160  a9000836  tbz      w9, #1, #0x16a0174
016a0164  09d940b9  ldr      w9, [x8, #0xd8]
016a0168  69000035  cbnz     w9, #0x16a0174
016a016c  e00308aa  mov      x0, x8
016a0170  fecfd997  bl       #0xd14168 ; unresolved symbol
016a0174  e00314aa  mov      x0, x20
016a0178  e10315aa  mov      x1, x21
016a017c  e2031faa  mov      x2, xzr
016a0180  aacf2094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
016a0184  28b200f0  adrp     x8, #0x2ce7000
016a0188  086942f9  ldr      x8, [x8, #0x4d0]
016a018c  f40300aa  mov      x20, x0
016a0190  080140f9  ldr      x8, [x8]
016a0194  099d4439  ldrb     w9, [x8, #0x127]
016a0198  a9000836  tbz      w9, #1, #0x16a01ac
016a019c  09d940b9  ldr      w9, [x8, #0xd8]
016a01a0  69000035  cbnz     w9, #0x16a01ac
016a01a4  e00308aa  mov      x0, x8
016a01a8  f0cfd997  bl       #0xd14168 ; unresolved symbol
016a01ac  e00313aa  mov      x0, x19
016a01b0  e10314aa  mov      x1, x20
016a01b4  fd7b42a9  ldp      x29, x30, [sp, #0x20]
016a01b8  f44f41a9  ldp      x20, x19, [sp, #0x10]
016a01bc  e2031faa  mov      x2, xzr
016a01c0  f50743f8  ldr      x21, [sp], #0x30
016a01c4  7ffb2b14  b        #0x219efc0 ; BattleCore.TSMath$$Max
