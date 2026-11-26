; RVA 0x16a01c8, file offset 0x16a01c8, conservative end 0x16a0314
; SHA256 a1b90ffc6e0fb3aeac1d27cde759100d7dffeafb4a5f635f3e4ed95a868714ab
; All aliases at this entry: A3BattleCore.SkillDamageHelper$$DoCalcDamageWithFiveEle :: void A3BattleCore_SkillDamageHelper__DoCalcDamageWithFiveEle (A3BattleCore_SkillDamageHelper_o* __this, A3BattleCore_ActorEntity_o* sourceActor, A3BattleCore_ActorEntity_o* targetActor, A3BattleCore_HitInfo_o* hitInfo, A3BattleCore_DamageInfo_o* info, bool hasDefend, BattleCore_FP_o damageRatio, BattleCore_FP_o damageAdditive, BattleCore_FP_o fiveEleDamageRatio, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
016a01c8  f657bda9  stp      x22, x21, [sp, #-0x30]!
016a01cc  f44f01a9  stp      x20, x19, [sp, #0x10]
016a01d0  fd7b02a9  stp      x29, x30, [sp, #0x20]
016a01d4  fd830091  add      x29, sp, #0x20
016a01d8  f6c400f0  adrp     x22, #0x2f3f000
016a01dc  c80a7c39  ldrb     w8, [x22, #0xf02]
016a01e0  f30304aa  mov      x19, x4
016a01e4  f40303aa  mov      x20, x3
016a01e8  f50302aa  mov      x21, x2
016a01ec  e8000037  tbnz     w8, #0, #0x16a0208
016a01f0  88b100b0  adrp     x8, #0x2cd1000
016a01f4  08f941f9  ldr      x8, [x8, #0x3f0]
016a01f8  000140b9  ldr      w0, [x8]
016a01fc  4b93d997  bl       #0xd04f28 ; unresolved symbol
016a0200  e8030032  mov      w8, #1
016a0204  c80a3c39  strb     w8, [x22, #0xf02]
016a0208  750000b5  cbnz     x21, #0x16a0214
016a020c  e0031faa  mov      x0, xzr
016a0210  472dda97  bl       #0xd2b72c ; unresolved symbol
016a0214  e00315aa  mov      x0, x21
016a0218  e1031faa  mov      x1, xzr
016a021c  14b00294  bl       #0x174c26c ; A3BattleCore.ActorEntity$$get_BuffMgr
016a0220  f50300aa  mov      x21, x0
016a0224  550000b5  cbnz     x21, #0x16a022c
016a0228  412dda97  bl       #0xd2b72c ; unresolved symbol
016a022c  e00315aa  mov      x0, x21
016a0230  e1031faa  mov      x1, xzr
016a0234  b6f7fd97  bl       #0x161e10c ; A3BattleCore.BuffManger$$CanBeDamaged
016a0238  f503002a  mov      w21, w0
016a023c  730500b4  cbz      x19, #0x16a02e8
016a0240  b5050036  tbz      w21, #0, #0x16a02f4
016a0244  e8b000b0  adrp     x8, #0x2cbd000
016a0248  08dd47f9  ldr      x8, [x8, #0xfb8]
016a024c  b50b40f9  ldr      x21, [x29, #0x10]
016a0250  767640b9  ldr      w22, [x19, #0x74]
016a0254  000140f9  ldr      x0, [x8]
016a0258  089c4439  ldrb     w8, [x0, #0x127]
016a025c  88000836  tbz      w8, #1, #0x16a026c
016a0260  08d840b9  ldr      w8, [x0, #0xd8]
016a0264  48000035  cbnz     w8, #0x16a026c
016a0268  c0cfd997  bl       #0xd14168 ; unresolved symbol
016a026c  e003162a  mov      w0, w22
016a0270  e1031faa  mov      x1, xzr
016a0274  4fd02094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
016a0278  e10315aa  mov      x1, x21
016a027c  e2031faa  mov      x2, xzr
016a0280  6acf2094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
016a0284  e1031faa  mov      x1, xzr
016a0288  ebd12094  bl       #0x1ed4a34 ; BattleCore.FP$$op_Explicit
016a028c  601200b9  str      w0, [x19, #0x10]
016a0290  740000b5  cbnz     x20, #0x16a029c
016a0294  e0031faa  mov      x0, xzr
016a0298  252dda97  bl       #0xd2b72c ; unresolved symbol
016a029c  941240f9  ldr      x20, [x20, #0x20]
016a02a0  740000b5  cbnz     x20, #0x16a02ac
016a02a4  e0031faa  mov      x0, xzr
016a02a8  212dda97  bl       #0xd2b72c ; unresolved symbol
016a02ac  e00314aa  mov      x0, x20
016a02b0  e1031faa  mov      x1, xzr
016a02b4  ccc10294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
016a02b8  f40300aa  mov      x20, x0
016a02bc  540000b5  cbnz     x20, #0x16a02c4
016a02c0  1b2dda97  bl       #0xd2b72c ; unresolved symbol
016a02c4  e00314aa  mov      x0, x20
016a02c8  e1031faa  mov      x1, xzr
016a02cc  1bda0294  bl       #0x1756b38 ; A3BattleCore.ActorData$$get_HP
016a02d0  1f040071  cmp      w0, #1
016a02d4  4b010054  b.lt     #0x16a02fc
016a02d8  681240b9  ldr      w8, [x19, #0x10]
016a02dc  1f00086b  cmp      w0, w8
016a02e0  e8c79f1a  cset     w8, le
016a02e4  07000014  b        #0x16a0300
016a02e8  e0031faa  mov      x0, xzr
016a02ec  102dda97  bl       #0xd2b72c ; unresolved symbol
016a02f0  b5fa0737  tbnz     w21, #0, #0x16a0244
016a02f4  7f1200b9  str      wzr, [x19, #0x10]
016a02f8  03000014  b        #0x16a0304
016a02fc  e8031f2a  mov      w8, wzr
016a0300  68720039  strb     w8, [x19, #0x1c]
016a0304  fd7b42a9  ldp      x29, x30, [sp, #0x20]
016a0308  f44f41a9  ldp      x20, x19, [sp, #0x10]
016a030c  f657c3a8  ldp      x22, x21, [sp], #0x30
016a0310  c0035fd6  ret      
