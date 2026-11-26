; RVA 0x169fdb0, file offset 0x169fdb0, conservative end 0x16a00e4
; SHA256 4a968f30f747f43a96af019038c0e1d719cb54ab3af95cf42e43f3d774d34fd3
; All aliases at this entry: A3BattleCore.SkillDamageHelper$$DoCalcWeaponDamageWithPercent :: void A3BattleCore_SkillDamageHelper__DoCalcWeaponDamageWithPercent (A3BattleCore_SkillDamageHelper_o* __this, A3BattleCore_ActorEntity_o* sourceActor, A3BattleCore_ActorEntity_o* targetActor, A3BattleCore_HitInfo_o* hitInfo, A3BattleCore_DamageInfo_o* info, bool hasDefend, BattleCore_FP_o damageRatio, BattleCore_FP_o damageAdditive, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
0169fdb0  fb0f1af8  str      x27, [sp, #-0x60]!
0169fdb4  fa6701a9  stp      x26, x25, [sp, #0x10]
0169fdb8  f85f02a9  stp      x24, x23, [sp, #0x20]
0169fdbc  f65703a9  stp      x22, x21, [sp, #0x30]
0169fdc0  f44f04a9  stp      x20, x19, [sp, #0x40]
0169fdc4  fd7b05a9  stp      x29, x30, [sp, #0x50]
0169fdc8  fd430191  add      x29, sp, #0x50
0169fdcc  1ac50090  adrp     x26, #0x2f3f000
0169fdd0  48077c39  ldrb     w8, [x26, #0xf01]
0169fdd4  f60307aa  mov      x22, x7
0169fdd8  f70306aa  mov      x23, x6
0169fddc  f503052a  mov      w21, w5
0169fde0  f30304aa  mov      x19, x4
0169fde4  f40303aa  mov      x20, x3
0169fde8  f90302aa  mov      x25, x2
0169fdec  f80301aa  mov      x24, x1
0169fdf0  e8000037  tbnz     w8, #0, #0x169fe0c
0169fdf4  08b200b0  adrp     x8, #0x2ce0000
0169fdf8  087d45f9  ldr      x8, [x8, #0xaf8]
0169fdfc  000140b9  ldr      w0, [x8]
0169fe00  4a94d997  bl       #0xd04f28 ; unresolved symbol
0169fe04  e8030032  mov      w8, #1
0169fe08  48073c39  strb     w8, [x26, #0xf01]
0169fe0c  ff0700f9  str      xzr, [sp, #8]
0169fe10  790000b5  cbnz     x25, #0x169fe1c
0169fe14  e0031faa  mov      x0, xzr
0169fe18  452eda97  bl       #0xd2b72c ; unresolved symbol
0169fe1c  e00319aa  mov      x0, x25
0169fe20  e1031faa  mov      x1, xzr
0169fe24  12b10294  bl       #0x174c26c ; A3BattleCore.ActorEntity$$get_BuffMgr
0169fe28  fa0300aa  mov      x26, x0
0169fe2c  5a0000b5  cbnz     x26, #0x169fe34
0169fe30  3f2eda97  bl       #0xd2b72c ; unresolved symbol
0169fe34  e0031aaa  mov      x0, x26
0169fe38  e1031faa  mov      x1, xzr
0169fe3c  b4f8fd97  bl       #0x161e10c ; A3BattleCore.BuffManger$$CanBeDamaged
0169fe40  60130036  tbz      w0, #0, #0x16a00ac
0169fe44  3ab100b0  adrp     x26, #0x2cc4000
0169fe48  5afb46f9  ldr      x26, [x26, #0xdf0]
0169fe4c  400340f9  ldr      x0, [x26]
0169fe50  089c4439  ldrb     w8, [x0, #0x127]
0169fe54  a8000836  tbz      w8, #1, #0x169fe68
0169fe58  08d840b9  ldr      w8, [x0, #0xd8]
0169fe5c  68000035  cbnz     w8, #0x169fe68
0169fe60  c2d0d997  bl       #0xd14168 ; unresolved symbol
0169fe64  400340f9  ldr      x0, [x26]
0169fe68  085c40f9  ldr      x8, [x0, #0xb8]
0169fe6c  1a0140f9  ldr      x26, [x8]
0169fe70  790000b5  cbnz     x25, #0x169fe7c
0169fe74  e0031faa  mov      x0, xzr
0169fe78  2d2eda97  bl       #0xd2b72c ; unresolved symbol
0169fe7c  e00319aa  mov      x0, x25
0169fe80  e1031faa  mov      x1, xzr
0169fe84  d8c20294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169fe88  f90300aa  mov      x25, x0
0169fe8c  590000b5  cbnz     x25, #0x169fe94
0169fe90  272eda97  bl       #0xd2b72c ; unresolved symbol
0169fe94  e00319aa  mov      x0, x25
0169fe98  e1031faa  mov      x1, xzr
0169fe9c  d6c20294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169fea0  f90300aa  mov      x25, x0
0169fea4  780000b5  cbnz     x24, #0x169feb0
0169fea8  e0031faa  mov      x0, xzr
0169feac  202eda97  bl       #0xd2b72c ; unresolved symbol
0169feb0  e00318aa  mov      x0, x24
0169feb4  e1031faa  mov      x1, xzr
0169feb8  cbc20294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
0169febc  fb0300aa  mov      x27, x0
0169fec0  5b0000b5  cbnz     x27, #0x169fec8
0169fec4  1a2eda97  bl       #0xd2b72c ; unresolved symbol
0169fec8  e0031baa  mov      x0, x27
0169fecc  e1031faa  mov      x1, xzr
0169fed0  c9c20294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
0169fed4  fb0300aa  mov      x27, x0
0169fed8  7a0000b5  cbnz     x26, #0x169fee4
0169fedc  e0031faa  mov      x0, xzr
0169fee0  132eda97  bl       #0xd2b72c ; unresolved symbol
0169fee4  e0031aaa  mov      x0, x26
0169fee8  e1031baa  mov      x1, x27
0169feec  e2031faa  mov      x2, xzr
0169fef0  53c60294  bl       #0x175183c ; A3BattleCore.ActorAttrData$$Set
0169fef4  740000b5  cbnz     x20, #0x169ff00
0169fef8  e0031faa  mov      x0, xzr
0169fefc  0c2eda97  bl       #0xd2b72c ; unresolved symbol
0169ff00  821240b9  ldr      w2, [x20, #0x10]
0169ff04  e10318aa  mov      x1, x24
0169ff08  78010094  bl       #0x16a04e8 ; A3BattleCore.SkillDamageHelper$$GetActorZhaoShiImpactMgr
0169ff0c  800000b4  cbz      x0, #0x169ff1c
0169ff10  e1031aaa  mov      x1, x26
0169ff14  e2031faa  mov      x2, xzr
0169ff18  3bcf0294  bl       #0x1753c04 ; A3BattleCore.ActorAttrImpactMgr$$RefreshFinalAttr
0169ff1c  790000b5  cbnz     x25, #0x169ff28
0169ff20  e0031faa  mov      x0, xzr
0169ff24  022eda97  bl       #0xd2b72c ; unresolved symbol
0169ff28  fab000d0  adrp     x26, #0x2cbd000
0169ff2c  5adf47f9  ldr      x26, [x26, #0xfb8]
0169ff30  381340b9  ldr      w24, [x25, #0x10]
0169ff34  400340f9  ldr      x0, [x26]
0169ff38  089c4439  ldrb     w8, [x0, #0x127]
0169ff3c  88000836  tbz      w8, #1, #0x169ff4c
0169ff40  08d840b9  ldr      w8, [x0, #0xd8]
0169ff44  48000035  cbnz     w8, #0x169ff4c
0169ff48  88d0d997  bl       #0xd14168 ; unresolved symbol
0169ff4c  e003182a  mov      w0, w24
0169ff50  e1031faa  mov      x1, xzr
0169ff54  17d12094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169ff58  e10317aa  mov      x1, x23
0169ff5c  e2031faa  mov      x2, xzr
0169ff60  32d02094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169ff64  e1031faa  mov      x1, xzr
0169ff68  b3d22094  bl       #0x1ed4a34 ; BattleCore.FP$$op_Explicit
0169ff6c  e1031faa  mov      x1, xzr
0169ff70  10d12094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169ff74  e10316aa  mov      x1, x22
0169ff78  e2031faa  mov      x2, xzr
0169ff7c  f6cf2094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
0169ff80  f60300aa  mov      x22, x0
0169ff84  f60700f9  str      x22, [sp, #8]
0169ff88  882a40b9  ldr      w8, [x20, #0x28]
0169ff8c  29c30091  add      x9, x25, #0x30
0169ff90  2ae30091  add      x10, x25, #0x38
0169ff94  2b030191  add      x11, x25, #0x40
0169ff98  2c230191  add      x12, x25, #0x48
0169ff9c  1f050071  cmp      w8, #1
0169ffa0  48018c9a  csel     x8, x10, x12, eq
0169ffa4  29018b9a  csel     x9, x9, x11, eq
0169ffa8  75030036  tbz      w21, #0, #0x16a0014
0169ffac  400340f9  ldr      x0, [x26]
0169ffb0  350140f9  ldr      x21, [x9]
0169ffb4  170140f9  ldr      x23, [x8]
0169ffb8  099c4439  ldrb     w9, [x0, #0x127]
0169ffbc  89000836  tbz      w9, #1, #0x169ffcc
0169ffc0  08d840b9  ldr      w8, [x0, #0xd8]
0169ffc4  48000035  cbnz     w8, #0x169ffcc
0169ffc8  68d0d997  bl       #0xd14168 ; unresolved symbol
0169ffcc  e0030032  mov      w0, #1
0169ffd0  e1031faa  mov      x1, xzr
0169ffd4  f7d02094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0169ffd8  e10317aa  mov      x1, x23
0169ffdc  e2031faa  mov      x2, xzr
0169ffe0  0cd02094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
0169ffe4  e10300aa  mov      x1, x0
0169ffe8  e00316aa  mov      x0, x22
0169ffec  e2031faa  mov      x2, xzr
0169fff0  0ed02094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
0169fff4  e1031faa  mov      x1, xzr
0169fff8  8fd22094  bl       #0x1ed4a34 ; BattleCore.FP$$op_Explicit
0169fffc  e1031faa  mov      x1, xzr
016a0000  ecd02094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
016a0004  e10315aa  mov      x1, x21
016a0008  e2031faa  mov      x2, xzr
016a000c  01d02094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
016a0010  e00700f9  str      x0, [sp, #8]
016a0014  e0230091  add      x0, sp, #8
016a0018  e1031faa  mov      x1, xzr
016a001c  d1d42094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
016a0020  f503002a  mov      w21, w0
016a0024  730000b5  cbnz     x19, #0x16a0030
016a0028  e0031faa  mov      x0, xzr
016a002c  c02dda97  bl       #0xd2b72c ; unresolved symbol
016a0030  751200b9  str      w21, [x19, #0x10]
016a0034  941240f9  ldr      x20, [x20, #0x20]
016a0038  740000b5  cbnz     x20, #0x16a0044
016a003c  e0031faa  mov      x0, xzr
016a0040  bb2dda97  bl       #0xd2b72c ; unresolved symbol
016a0044  e00314aa  mov      x0, x20
016a0048  e1031faa  mov      x1, xzr
016a004c  66c20294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
016a0050  f40300aa  mov      x20, x0
016a0054  540000b5  cbnz     x20, #0x16a005c
016a0058  b52dda97  bl       #0xd2b72c ; unresolved symbol
016a005c  e00314aa  mov      x0, x20
016a0060  e1031faa  mov      x1, xzr
016a0064  b5da0294  bl       #0x1756b38 ; A3BattleCore.ActorData$$get_HP
016a0068  f403002a  mov      w20, w0
016a006c  9f060071  cmp      w20, #1
016a0070  8b020054  b.lt     #0x16a00c0
016a0074  400340f9  ldr      x0, [x26]
016a0078  089c4439  ldrb     w8, [x0, #0x127]
016a007c  88000836  tbz      w8, #1, #0x16a008c
016a0080  08d840b9  ldr      w8, [x0, #0xd8]
016a0084  48000035  cbnz     w8, #0x16a008c
016a0088  38d0d997  bl       #0xd14168 ; unresolved symbol
016a008c  e003142a  mov      w0, w20
016a0090  e1031faa  mov      x1, xzr
016a0094  c7d02094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
016a0098  e10740f9  ldr      x1, [sp, #8]
016a009c  e2031faa  mov      x2, xzr
016a00a0  f5d02094  bl       #0x1ed4474 ; BattleCore.FP$$op_LessThanOrEqual
016a00a4  08000012  and      w8, w0, #1
016a00a8  07000014  b        #0x16a00c4
016a00ac  730000b5  cbnz     x19, #0x16a00b8
016a00b0  e0031faa  mov      x0, xzr
016a00b4  9e2dda97  bl       #0xd2b72c ; unresolved symbol
016a00b8  7f1200b9  str      wzr, [x19, #0x10]
016a00bc  03000014  b        #0x16a00c8
016a00c0  e8031f2a  mov      w8, wzr
016a00c4  68720039  strb     w8, [x19, #0x1c]
016a00c8  fd7b45a9  ldp      x29, x30, [sp, #0x50]
016a00cc  f44f44a9  ldp      x20, x19, [sp, #0x40]
016a00d0  f65743a9  ldp      x22, x21, [sp, #0x30]
016a00d4  f85f42a9  ldp      x24, x23, [sp, #0x20]
016a00d8  fa6741a9  ldp      x26, x25, [sp, #0x10]
016a00dc  fb0746f8  ldr      x27, [sp], #0x60
016a00e0  c0035fd6  ret      
