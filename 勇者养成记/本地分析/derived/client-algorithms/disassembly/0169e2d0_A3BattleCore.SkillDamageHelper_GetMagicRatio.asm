; RVA 0x169e2d0, file offset 0x169e2d0, conservative end 0x169e3bc
; SHA256 37bb83167e02a07d42754e066f9211949056bab0d4ab00d5649ee474ab27451c
; All aliases at this entry: A3BattleCore.SkillDamageHelper$$GetMagicRatio :: BattleCore_FP_o A3BattleCore_SkillDamageHelper__GetMagicRatio (A3BattleCore_SkillDamageHelper_o* __this, A3BattleCore_ActorAttrData_o* attrData, int32_t magicType, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
0169e2d0  f50f1df8  str      x21, [sp, #-0x30]!
0169e2d4  f44f01a9  stp      x20, x19, [sp, #0x10]
0169e2d8  fd7b02a9  stp      x29, x30, [sp, #0x20]
0169e2dc  fd830091  add      x29, sp, #0x20
0169e2e0  15c500b0  adrp     x21, #0x2f3f000
0169e2e4  a8167c39  ldrb     w8, [x21, #0xf05]
0169e2e8  f403022a  mov      w20, w2
0169e2ec  f30301aa  mov      x19, x1
0169e2f0  e8000037  tbnz     w8, #0, #0x169e30c
0169e2f4  48b200b0  adrp     x8, #0x2ce7000
0169e2f8  088144f9  ldr      x8, [x8, #0x900]
0169e2fc  000140b9  ldr      w0, [x8]
0169e300  0a9bd997  bl       #0xd04f28 ; unresolved symbol
0169e304  e8030032  mov      w8, #1
0169e308  a8163c39  strb     w8, [x21, #0xf05]
0169e30c  88060051  sub      w8, w20, #1
0169e310  1f0d0071  cmp      w8, #3
0169e314  68010054  b.hi     #0x169e340
0169e318  096800b0  adrp     x9, #0x239f000
0169e31c  29e13691  add      x9, x9, #0xdb8
0169e320  2879a8b8  ldrsw    x8, [x9, x8, lsl #2]
0169e324  0801098b  add      x8, x8, x9
0169e328  00011fd6  br       x8
0169e32c  730000b5  cbnz     x19, #0x169e338
0169e330  e0031faa  mov      x0, xzr
0169e334  fe34da97  bl       #0xd2b72c ; unresolved symbol
0169e338  68220391  add      x8, x19, #0xc8
0169e33c  1b000014  b        #0x169e3a8
0169e340  f3b000f0  adrp     x19, #0x2cbd000
0169e344  73de47f9  ldr      x19, [x19, #0xfb8]
0169e348  600240f9  ldr      x0, [x19]
0169e34c  089c4439  ldrb     w8, [x0, #0x127]
0169e350  a8000836  tbz      w8, #1, #0x169e364
0169e354  08d840b9  ldr      w8, [x0, #0xd8]
0169e358  68000035  cbnz     w8, #0x169e364
0169e35c  83d7d997  bl       #0xd14168 ; unresolved symbol
0169e360  600240f9  ldr      x0, [x19]
0169e364  085c40f9  ldr      x8, [x0, #0xb8]
0169e368  08610091  add      x8, x8, #0x18
0169e36c  0f000014  b        #0x169e3a8
0169e370  730000b5  cbnz     x19, #0x169e37c
0169e374  e0031faa  mov      x0, xzr
0169e378  ed34da97  bl       #0xd2b72c ; unresolved symbol
0169e37c  68420391  add      x8, x19, #0xd0
0169e380  0a000014  b        #0x169e3a8
0169e384  730000b5  cbnz     x19, #0x169e390
0169e388  e0031faa  mov      x0, xzr
0169e38c  e834da97  bl       #0xd2b72c ; unresolved symbol
0169e390  68620391  add      x8, x19, #0xd8
0169e394  05000014  b        #0x169e3a8
0169e398  730000b5  cbnz     x19, #0x169e3a4
0169e39c  e0031faa  mov      x0, xzr
0169e3a0  e334da97  bl       #0xd2b72c ; unresolved symbol
0169e3a4  68820391  add      x8, x19, #0xe0
0169e3a8  000140f9  ldr      x0, [x8]
0169e3ac  fd7b42a9  ldp      x29, x30, [sp, #0x20]
0169e3b0  f44f41a9  ldp      x20, x19, [sp, #0x10]
0169e3b4  f50743f8  ldr      x21, [sp], #0x30
0169e3b8  c0035fd6  ret      
