; RVA 0x1753404, file offset 0x1753404, conservative end 0x1753550
; SHA256 1530de097ce3c9097d025429bf2dce8e9a509a590194e3c1b1587012e3ab00bc
; All aliases at this entry: A3BattleCore.ActorAttrData$$Destroy :: void A3BattleCore_ActorAttrData__Destroy (A3BattleCore_ActorAttrData_o* __this, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01753404  ff0302d1  sub      sp, sp, #0x80
01753408  fa6703a9  stp      x26, x25, [sp, #0x30]
0175340c  f85f04a9  stp      x24, x23, [sp, #0x40]
01753410  f65705a9  stp      x22, x21, [sp, #0x50]
01753414  f44f06a9  stp      x20, x19, [sp, #0x60]
01753418  fd7b07a9  stp      x29, x30, [sp, #0x70]
0175341c  fdc30191  add      x29, sp, #0x70
01753420  74bf00b0  adrp     x20, #0x2f40000
01753424  88b65639  ldrb     w8, [x20, #0x5ad]
01753428  f30300aa  mov      x19, x0
0175342c  e8000037  tbnz     w8, #0, #0x1753448
01753430  08ac0090  adrp     x8, #0x2cd3000
01753434  081943f9  ldr      x8, [x8, #0x630]
01753438  000140b9  ldr      w0, [x8]
0175343c  bbc6d697  bl       #0xd04f28 ; unresolved symbol
01753440  e8030032  mov      w8, #1
01753444  88b61639  strb     w8, [x20, #0x5ad]
01753448  00e4006f  movi     v0.2d, #0000000000000000
0175344c  ff7f00a9  stp      xzr, xzr, [sp]
01753450  e08300ad  stp      q0, q0, [sp, #0x10]
01753454  747e41f9  ldr      x20, [x19, #0x2f8]
01753458  740000b5  cbnz     x20, #0x1753464
0175345c  e0031faa  mov      x0, xzr
01753460  b360d797  bl       #0xd2b72c ; unresolved symbol
01753464  48ae00f0  adrp     x8, #0x2d1e000
01753468  087547f9  ldr      x8, [x8, #0xee8]
0175346c  e00314aa  mov      x0, x20
01753470  010140f9  ldr      x1, [x8]
01753474  e8430091  add      x8, sp, #0x10
01753478  00f12194  bl       #0x1fcf878 ; System.Collections.Generic.Dictionary<int, ActorAttrImpactMgr>$$GetEnumerator | System.Collections.Generic.Dictionary<int, AccoundLoginInfo>$$GetEnumerator | System.Collections.Generic.Dictionary<int, AdventureTabItem>$$GetEnumerator | System.Collections.Generic.Dictionary<int, AdventureUIPageBase>$$GetEnumerator | System.Collections.Generic.Dictionary<int, BootyBaseShowData>$$GetEnumerator | System.Collections.Generic.Dictionary<int, ChapterGroupInfo>$$GetEnumerator | System.Collections.Generic.Dictionary<int, ChapterInfo>$$GetEnumerator | System.Collections.Generic.Dictionary<int, ComposeTabItem>$$GetEnumerator | System.Collections.Generic.Dictionary<int, CurrencyDisplayBlockItem>$$GetEnumerator | System.Collections.Generic.Dictionary<int, EventListEntry>$$GetEnumerator | System.Collections.Generic.Dictionary<int, FBActBean>$$GetEnumerator | System.Collections.Generic.Dictionary<int, HorseMainUIPageBase>$$GetEnumerator | System.Collections.Generic.Dictionary<int, LevelEventHandleBase>$$GetEnumerator | System.Collections.Generic.Dictionary<int, MHZBGenieData>$$GetEnumerator | System.Collections.Generic.Dictionary<int, MHZBGuardBeastData>$$GetEnumerator | System.Collections.Generic.Dictionary<int, MHZBSlotData>$$GetEnumerator | System.Collections.Generic.Dictionary<int, SacredBeastUIPageBase>$$GetEnumerator | System.Collections.Generic.Dictionary<int, ServerAreaData>$$GetEnumerator | System.Collections.Generic.Dictionary<int, SummonUIPageBase>$$GetEnumerator | System.Collections.Generic.Dictionary<int, SwitchTabItem>$$GetEnumerator | System.Collections.Generic.Dictionary<int, UIClipEffectBufferData>$$GetEnumerator | System.Collections.Generic.Dictionary<int, WingMainUIPageBase>$$GetEnumerator | System.Collections.Generic.Dictionary<int, WuXingLingElemData>$$GetEnumerator | System.Collections.Generic.Dictionary<int, DodImage>$$GetEnumerator | System.Collections.Generic.Dictionary<int, AttrDataConfig>$$GetEnumerator | System.Collections.Generic.Dictionary<int, ChatFrameConfig>$$GetEnumerator | System.Collections.Generic.Dictionary<int, GoodsConfig>$$GetEnumerator | System.Collections.Generic.Dictionary<int, HeadFrameConfig>$$GetEnumerator | System.Collections.Generic.Dictionary<int, HuntMonsterConfig>$$GetEnumerator | System.Collections.Generic.Dictionary<int, ResAttrImpactData>$$GetEnumerator | System.Collections.Generic.Dictionary<int, List<EventRegInfo>>$$GetEnumerator | System.Collections.Generic.Dictionary<int, List<ShopGroupItemBase>>$$GetEnumerator | System.Collections.Generic.Dictionary<int, List<CSFestLianXuChargeCfgEntry>>$$GetEnumerator | System.Collections.Generic.Dictionary<int, List<CSIslandGiftCellCfgEntry>>$$GetEnumerator | System.Collections.Generic.Dictionary<int, List<CSLianXuChargeActCfgEntry>>$$GetEnumerator | System.Collections.Generic.Dictionary<int, PointerEventData>$$GetEnumerator | System.Collections.Generic.Dictionary<int, TerrainUtility.TerrainMap>$$GetEnumerator | System.Collections.Generic.Dictionary<int, CSActiveAwardConfigEntry>$$GetEnumerator | System.Collections.Generic.Dictionary<int, CSBootyAwardItem>$$GetEnumerator | System.Collections.Generic.Dictionary<int, CSBootyAwardList>$$GetEnumerator | System.Collections.Generic.Dictionary<int, CSCarnivalTaskCfgEntry>$$GetEnumerator | System.Collections.Generic.Dictionary<int, CSGrowFundAwardDataEntry>$$GetEnumerator | System.Collections.Generic.Dictionary<int, CSHarvestAccChargeConfig>$$GetEnumerator | System.Collections.Generic.Dictionary<int, CSHarvestAltarMarketCfgEntry>$$GetEnumerator | System.Collections.Generic.Dictionary<int, CSJHFoolsUnlockEntry>$$GetEnumerator | System.Collections.Generic.Dictionary<int, CSSingleChargeConfigEntry>$$GetEnumerator | System.Collections.Generic.Dictionary<int, CSSuperFundAwardDataEntry>$$GetEnumerator | System.Collections.Generic.Dictionary<int, object>$$GetEnumerator
0175347c  56ae00f0  adrp     x22, #0x2d1e000
01753480  d60245f9  ldr      x22, [x22, #0xa00]
01753484  e0430091  add      x0, sp, #0x10
01753488  c10240f9  ldr      x1, [x22]
0175348c  8092fd97  bl       #0x16b7e8c ; unresolved symbol
01753490  00040036  tbz      w0, #0, #0x1753510
01753494  b7a900f0  adrp     x23, #0x2c8a000
01753498  b8ab00f0  adrp     x24, #0x2cca000
0175349c  99ac0090  adrp     x25, #0x2ce3000
017534a0  5aaa0090  adrp     x26, #0x2c9b000
017534a4  f71a43f9  ldr      x23, [x23, #0x630]
017534a8  189f44f9  ldr      x24, [x24, #0x938]
017534ac  398346f9  ldr      x25, [x25, #0xd00]
017534b0  5a3f47f9  ldr      x26, [x26, #0xe78]
017534b4  e00240f9  ldr      x0, [x23]
017534b8  31470294  bl       #0x17e517c ; A3BattleCore.FSingleton<BattleLevelConfigMgr>$$get_Instance | A3BattleCore.FSingleton<BeastTideCollectItemCfgMgr>$$get_Instance | A3BattleCore.FSingleton<BeastTideConfigMgr>$$get_Instance | A3BattleCore.FSingleton<BianShenCfgMgr>$$get_Instance | A3BattleCore.FSingleton<BootyCfgMgr>$$get_Instance | A3BattleCore.FSingleton<BuffConfigMgr>$$get_Instance | A3BattleCore.FSingleton<ElementTeamCfgMgr>$$get_Instance | A3BattleCore.FSingleton<FDataPool<CSRelaySyncOneFrameData>>$$get_Instance | A3BattleCore.FSingleton<FMemPoolMgr>$$get_Instance | A3BattleCore.FSingleton<FMemPool<ActorAttrData>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<ActorAttrImpactMgr>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdBianShen>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdGmRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdMoveRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdReRandomSkillRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdReliveRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdSelectRandomSkill>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdSetWorldBossHP>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdSkillRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdSummonPetRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BattleCmdYuanShenSkillRun>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<BufferItem>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<EntityVisualEventNode>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<EventRegInfo>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<FlyBullet>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<GridIndexNode>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<LightChainBullet>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<LightChainNode>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<RayBullet>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<ShootPointBullet>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<SkillPlayData>>$$get_Instance | A3BattleCore.FSingleton<FMemPool<SkillRepeatTranslateHandle.MoveData>>$$get_Instance | A3BattleCore.FSingleton<ForeverConfigMgr>$$get_Instance | A3BattleCore.FSingleton<GuardBlitzConfigMgr>$$get_Instance | A3BattleCore.FSingleton<HellLevelCfgMgr>$$get_Instance | A3BattleCore.FSingleton<HorseCfgMgr>$$get_Instance | A3BattleCore.FSingleton<IslandAdventureCfgMgr>$$get_Instance | A3BattleCore.FSingleton<ItemConfigMgr>$$get_Instance | A3BattleCore.FSingleton<LevelCfgMgr>$$get_Instance | A3BattleCore.FSingleton<LongHunConfigMgr>$$get_Instance | A3BattleCore.FSingleton<MHZBConfigMgr>$$get_Instance | A3BattleCore.FSingleton<MiJingConfigMgr>$$get_Instance | A3BattleCore.FSingleton<ModelConfigMgr>$$get_Instance | A3BattleCore.FSingleton<MonsterCfgMgr>$$get_Instance | A3BattleCore.FSingleton<ParamConfigMgr>$$get_Instance | A3BattleCore.FSingleton<PengPengTuTengCfgMgr>$$get_Instance | A3BattleCore.FSingleton<PetCfgMgr>$$get_Instance | A3BattleCore.FSingleton<PvpConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SacredBeastConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SacredEquipCfgMgr>$$get_Instance | A3BattleCore.FSingleton<SkillConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SkillDispConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SpiritConfigMgr>$$get_Instance | A3BattleCore.FSingleton<SummonConfigMgr>$$get_Instance | A3BattleCore.FSingleton<TanSheConfigMgr>$$get_Instance | A3BattleCore.FSingleton<ToughnessConfigMgr>$$get_Instance | A3BattleCore.FSingleton<XianYuanConfigMgr>$$get_Instance | A3BattleCore.FSingleton<object>$$get_Instance
017534bc  010340f9  ldr      x1, [x24]
017534c0  f40300aa  mov      x20, x0
017534c4  e0430091  add      x0, sp, #0x10
017534c8  dc92fd97  bl       #0x16b8038 ; unresolved symbol
017534cc  280340f9  ldr      x8, [x25]
017534d0  e00700a9  stp      x0, x1, [sp]
017534d4  e0030091  mov      x0, sp
017534d8  e10308aa  mov      x1, x8
017534dc  67561794  bl       #0x1d28e78 ; unresolved symbol
017534e0  f50300aa  mov      x21, x0
017534e4  740000b5  cbnz     x20, #0x17534f0
017534e8  e0031faa  mov      x0, xzr
017534ec  9060d797  bl       #0xd2b72c ; unresolved symbol
017534f0  420340f9  ldr      x2, [x26]
017534f4  e00314aa  mov      x0, x20
017534f8  e10315aa  mov      x1, x21
017534fc  78450294  bl       #0x17e4adc ; A3BattleCore.FMemPool<ActorAttrData>$$Free | A3BattleCore.FMemPool<ActorAttrImpactMgr>$$Free | A3BattleCore.FMemPool<BufferItem>$$Free | A3BattleCore.FMemPool<EntityVisualEventNode>$$Free | A3BattleCore.FMemPool<EventRegInfo>$$Free | A3BattleCore.FMemPool<FlyBullet>$$Free | A3BattleCore.FMemPool<GridIndexNode>$$Free | A3BattleCore.FMemPool<LightChainBullet>$$Free | A3BattleCore.FMemPool<LightChainNode>$$Free | A3BattleCore.FMemPool<RayBullet>$$Free | A3BattleCore.FMemPool<ShootPointBullet>$$Free | A3BattleCore.FMemPool<SkillPlayData>$$Free | A3BattleCore.FMemPool<SkillRepeatTranslateHandle.MoveData>$$Free | A3BattleCore.FMemPool<object>$$Free
01753500  c10240f9  ldr      x1, [x22]
01753504  e0430091  add      x0, sp, #0x10
01753508  6192fd97  bl       #0x16b7e8c ; unresolved symbol
0175350c  40fd0737  tbnz     w0, #0, #0x17534b4
01753510  737e41f9  ldr      x19, [x19, #0x2f8]
01753514  730000b5  cbnz     x19, #0x1753520
01753518  e0031faa  mov      x0, xzr
0175351c  8460d797  bl       #0xd2b72c ; unresolved symbol
01753520  48ac0090  adrp     x8, #0x2cdb000
01753524  089543f9  ldr      x8, [x8, #0x728]
01753528  e00313aa  mov      x0, x19
0175352c  010140f9  ldr      x1, [x8]
01753530  c4ea2194  bl       #0x1fce040 ; System.Collections.Generic.Dictionary<int, ActorAttrImpactMgr>$$Clear | System.Collections.Generic.Dictionary<int, BufferItem>$$Clear | System.Collections.Generic.Dictionary<int, LevelColliderData>$$Clear | System.Collections.Generic.Dictionary<int, LevelPPTTOneWaveMonsterData>$$Clear | System.Collections.Generic.Dictionary<int, AccoundLoginInfo>$$Clear | System.Collections.Generic.Dictionary<int, FBActBean>$$Clear | System.Collections.Generic.Dictionary<int, MHZBGenieData>$$Clear | System.Collections.Generic.Dictionary<int, MHZBGuardBeastData>$$Clear | System.Collections.Generic.Dictionary<int, MHZBSlotData>$$Clear | System.Collections.Generic.Dictionary<int, NeedDownloadPackageInfo>$$Clear | System.Collections.Generic.Dictionary<int, RedNodeDataMgr.RedData>$$Clear | System.Collections.Generic.Dictionary<int, SacredBeastUIPageBase>$$Clear | System.Collections.Generic.Dictionary<int, ServerAreaData>$$Clear | System.Collections.Generic.Dictionary<int, SwitchTabItem>$$Clear | System.Collections.Generic.Dictionary<int, TextConfigItem>$$Clear | System.Collections.Generic.Dictionary<int, WenZhangEntity>$$Clear | System.Collections.Generic.Dictionary<int, WuXingLingElemData>$$Clear | System.Collections.Generic.Dictionary<int, ResAttrImpactData>$$Clear | System.Collections.Generic.Dictionary<int, Animation>$$Clear | System.Collections.Generic.Dictionary<int, List<LevelGuardBlitzMonsterData>>$$Clear | System.Collections.Generic.Dictionary<int, List<LevelMonsterData>>$$Clear | System.Collections.Generic.Dictionary<int, List<LevelYJSCMonsterData>>$$Clear | System.Collections.Generic.Dictionary<int, List<int>>$$Clear | System.Collections.Generic.Dictionary<int, List<CSBootyAwardItem>>$$Clear | System.Collections.Generic.Dictionary<int, List<CSFestLianXuChargeCfgEntry>>$$Clear | System.Collections.Generic.Dictionary<int, List<CSIslandGiftCellCfgEntry>>$$Clear | System.Collections.Generic.Dictionary<int, List<CSJHExchangeShopCommodityCfg>>$$Clear | System.Collections.Generic.Dictionary<int, List<CSLianXuChargeActCfgEntry>>$$Clear | System.Collections.Generic.Dictionary<int, List<CSStageEntry>>$$Clear | System.Collections.Generic.Dictionary<int, List<CSTaskConfigEntry>>$$Clear | System.Collections.Generic.Dictionary<int, List<CSTaskEntry>>$$Clear | System.Collections.Generic.Dictionary<int, object>$$Clear | System.Collections.Generic.Dictionary<int, PointerEventData>$$Clear | System.Collections.Generic.Dictionary<int, TerrainUtility.TerrainMap>$$Clear | System.Collections.Generic.Dictionary<int, Sprite>$$Clear | System.Collections.Generic.Dictionary<int, CSActiveAwardConfigEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSAdConfigEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSAdTypeDataEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSBlissLotteryCfgEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSBootyAwardList>$$Clear | System.Collections.Generic.Dictionary<int, CSCarnivalTaskCfgEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSCumuConsumeActAwardRecord>$$Clear | System.Collections.Generic.Dictionary<int, CSFestCumuConsumeActAwardRecord>$$Clear | System.Collections.Generic.Dictionary<int, CSGroupBuyingShowCfgEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSGrowFundAwardDataEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSHarvestAccChargeConfig>$$Clear | System.Collections.Generic.Dictionary<int, CSHarvestAltarMarketCfgEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSHarvestAltarMarketGoodsEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSJHExchangeShopCommodityEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSJHExchangeShopFloosEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSJHFoolsUnlockEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSJiangHuAdventureParamCfg>$$Clear | System.Collections.Generic.Dictionary<int, CSNYAChapterBattleEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSSacredBeastEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSSealEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSSingleAwardEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSSingleChargeConfigEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSSingleChargeGoodEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSSoulEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSSuperFundAwardDataEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSTCLoginEntry>$$Clear | System.Collections.Generic.Dictionary<int, CSWechatInviteShowCfgEntry>$$Clear
01753534  fd7b47a9  ldp      x29, x30, [sp, #0x70]
01753538  f44f46a9  ldp      x20, x19, [sp, #0x60]
0175353c  f65745a9  ldp      x22, x21, [sp, #0x50]
01753540  f85f44a9  ldp      x24, x23, [sp, #0x40]
01753544  fa6743a9  ldp      x26, x25, [sp, #0x30]
01753548  ff030291  add      sp, sp, #0x80
0175354c  c0035fd6  ret      
