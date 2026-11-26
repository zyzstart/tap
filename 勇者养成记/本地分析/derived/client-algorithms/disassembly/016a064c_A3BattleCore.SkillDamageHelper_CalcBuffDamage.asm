; RVA 0x16a064c, file offset 0x16a064c, conservative end 0x16a0940
; SHA256 9ee9983b514b86e2ff0a15671891ce33a76d580e3f00e8e4b18933273d22a3d4
; All aliases at this entry: A3BattleCore.SkillDamageHelper$$CalcBuffDamage :: void A3BattleCore_SkillDamageHelper__CalcBuffDamage (A3BattleCore_SkillDamageHelper_o* __this, A3BattleCore_ActorEntity_o* target, int32_t impactType, int32_t* resultDamage, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
016a064c  ff4301d1  sub      sp, sp, #0x50
016a0650  f85f01a9  stp      x24, x23, [sp, #0x10]
016a0654  f65702a9  stp      x22, x21, [sp, #0x20]
016a0658  f44f03a9  stp      x20, x19, [sp, #0x30]
016a065c  fd7b04a9  stp      x29, x30, [sp, #0x40]
016a0660  fd030191  add      x29, sp, #0x40
016a0664  f5c400f0  adrp     x21, #0x2f3f000
016a0668  a80e7c39  ldrb     w8, [x21, #0xf03]
016a066c  f30303aa  mov      x19, x3
016a0670  f703022a  mov      w23, w2
016a0674  f40301aa  mov      x20, x1
016a0678  e8000037  tbnz     w8, #0, #0x16a0694
016a067c  08b400d0  adrp     x8, #0x2d22000
016a0680  080d43f9  ldr      x8, [x8, #0x618]
016a0684  000140b9  ldr      w0, [x8]
016a0688  2892d997  bl       #0xd04f28 ; unresolved symbol
016a068c  e8030032  mov      w8, #1
016a0690  a80e3c39  strb     w8, [x21, #0xf03]
016a0694  f8b000b0  adrp     x24, #0x2cbd000
016a0698  18df47f9  ldr      x24, [x24, #0xfb8]
016a069c  ff0700f9  str      xzr, [sp, #8]
016a06a0  750240b9  ldr      w21, [x19]
016a06a4  000340f9  ldr      x0, [x24]
016a06a8  089c4439  ldrb     w8, [x0, #0x127]
016a06ac  88000836  tbz      w8, #1, #0x16a06bc
016a06b0  08d840b9  ldr      w8, [x0, #0xd8]
016a06b4  48000035  cbnz     w8, #0x16a06bc
016a06b8  acced997  bl       #0xd14168 ; unresolved symbol
016a06bc  e003152a  mov      w0, w21
016a06c0  e1031faa  mov      x1, xzr
016a06c4  3bcf2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
016a06c8  f50300aa  mov      x21, x0
016a06cc  f50700f9  str      x21, [sp, #8]
016a06d0  740000b5  cbnz     x20, #0x16a06dc
016a06d4  e0031faa  mov      x0, xzr
016a06d8  152cda97  bl       #0xd2b72c ; unresolved symbol
016a06dc  e00314aa  mov      x0, x20
016a06e0  e1031faa  mov      x1, xzr
016a06e4  c0c00294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
016a06e8  f60300aa  mov      x22, x0
016a06ec  560000b5  cbnz     x22, #0x16a06f4
016a06f0  0f2cda97  bl       #0xd2b72c ; unresolved symbol
016a06f4  e00316aa  mov      x0, x22
016a06f8  e1031faa  mov      x1, xzr
016a06fc  bec00294  bl       #0x17509f4 ; A3BattleCore.ActorData$$get_AttrData
016a0700  f60300aa  mov      x22, x0
016a0704  560000b5  cbnz     x22, #0x16a070c
016a0708  092cda97  bl       #0xd2b72c ; unresolved symbol
016a070c  ff120071  cmp      w23, #4
016a0710  210b0054  b.ne     #0x16a0874
016a0714  000340f9  ldr      x0, [x24]
016a0718  d77640f9  ldr      x23, [x22, #0xe8]
016a071c  089c4439  ldrb     w8, [x0, #0x127]
016a0720  88000836  tbz      w8, #1, #0x16a0730
016a0724  08d840b9  ldr      w8, [x0, #0xd8]
016a0728  48000035  cbnz     w8, #0x16a0730
016a072c  8fced997  bl       #0xd14168 ; unresolved symbol
016a0730  e0031f2a  mov      w0, wzr
016a0734  e1031faa  mov      x1, xzr
016a0738  1ecf2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
016a073c  e10300aa  mov      x1, x0
016a0740  e00317aa  mov      x0, x23
016a0744  e2031faa  mov      x2, xzr
016a0748  42cf2094  bl       #0x1ed4450 ; BattleCore.FP$$op_GreaterThan
016a074c  c0020036  tbz      w0, #0, #0x16a07a4
016a0750  000340f9  ldr      x0, [x24]
016a0754  d77640f9  ldr      x23, [x22, #0xe8]
016a0758  089c4439  ldrb     w8, [x0, #0x127]
016a075c  88000836  tbz      w8, #1, #0x16a076c
016a0760  08d840b9  ldr      w8, [x0, #0xd8]
016a0764  48000035  cbnz     w8, #0x16a076c
016a0768  80ced997  bl       #0xd14168 ; unresolved symbol
016a076c  e00315aa  mov      x0, x21
016a0770  e10317aa  mov      x1, x23
016a0774  e2031faa  mov      x2, xzr
016a0778  2cce2094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
016a077c  e1031faa  mov      x1, xzr
016a0780  add02094  bl       #0x1ed4a34 ; BattleCore.FP$$op_Explicit
016a0784  e1031faa  mov      x1, xzr
016a0788  0acf2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
016a078c  e10300aa  mov      x1, x0
016a0790  e00315aa  mov      x0, x21
016a0794  e2031faa  mov      x2, xzr
016a0798  efcd2094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
016a079c  f50300aa  mov      x21, x0
016a07a0  f50700f9  str      x21, [sp, #8]
016a07a4  000340f9  ldr      x0, [x24]
016a07a8  d77a40f9  ldr      x23, [x22, #0xf0]
016a07ac  089c4439  ldrb     w8, [x0, #0x127]
016a07b0  88000836  tbz      w8, #1, #0x16a07c0
016a07b4  08d840b9  ldr      w8, [x0, #0xd8]
016a07b8  48000035  cbnz     w8, #0x16a07c0
016a07bc  6bced997  bl       #0xd14168 ; unresolved symbol
016a07c0  e00317aa  mov      x0, x23
016a07c4  e1031faa  mov      x1, xzr
016a07c8  9bd02094  bl       #0x1ed4a34 ; BattleCore.FP$$op_Explicit
016a07cc  e1031faa  mov      x1, xzr
016a07d0  f8ce2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
016a07d4  e10300aa  mov      x1, x0
016a07d8  e00315aa  mov      x0, x21
016a07dc  e2031faa  mov      x2, xzr
016a07e0  ddcd2094  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
016a07e4  f50300aa  mov      x21, x0
016a07e8  f50700f9  str      x21, [sp, #8]
016a07ec  d61240b9  ldr      w22, [x22, #0x10]
016a07f0  740000b5  cbnz     x20, #0x16a07fc
016a07f4  e0031faa  mov      x0, xzr
016a07f8  cd2bda97  bl       #0xd2b72c ; unresolved symbol
016a07fc  e00314aa  mov      x0, x20
016a0800  e1031faa  mov      x1, xzr
016a0804  78c00294  bl       #0x17509e4 ; A3BattleCore.ActorEntity$$get_ActorData
016a0808  f40300aa  mov      x20, x0
016a080c  540000b5  cbnz     x20, #0x16a0814
016a0810  c72bda97  bl       #0xd2b72c ; unresolved symbol
016a0814  e00314aa  mov      x0, x20
016a0818  e1031faa  mov      x1, xzr
016a081c  c7d80294  bl       #0x1756b38 ; A3BattleCore.ActorData$$get_HP
016a0820  c002004b  sub      w0, w22, w0
016a0824  e1031faa  mov      x1, xzr
016a0828  e2ce2094  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
016a082c  28b200f0  adrp     x8, #0x2ce7000
016a0830  086942f9  ldr      x8, [x8, #0x4d0]
016a0834  f40300aa  mov      x20, x0
016a0838  080140f9  ldr      x8, [x8]
016a083c  099d4439  ldrb     w9, [x8, #0x127]
016a0840  a9000836  tbz      w9, #1, #0x16a0854
016a0844  09d940b9  ldr      w9, [x8, #0xd8]
016a0848  69000035  cbnz     w9, #0x16a0854
016a084c  e00308aa  mov      x0, x8
016a0850  46ced997  bl       #0xd14168 ; unresolved symbol
016a0854  e00315aa  mov      x0, x21
016a0858  e10314aa  mov      x1, x20
016a085c  e2031faa  mov      x2, xzr
016a0860  dc062c94  bl       #0x21a23d0 ; BattleCore.TSMath$$Min
016a0864  e1031faa  mov      x1, xzr
016a0868  e00700f9  str      x0, [sp, #8]
016a086c  d3ce2094  bl       #0x1ed43b8 ; BattleCore.FP$$op_UnaryNegation
016a0870  29000014  b        #0x16a0914
016a0874  d42240f9  ldr      x20, [x22, #0x40]
016a0878  760000b5  cbnz     x22, #0x16a0884
016a087c  e0031faa  mov      x0, xzr
016a0880  ab2bda97  bl       #0xd2b72c ; unresolved symbol
016a0884  000340f9  ldr      x0, [x24]
016a0888  d62640f9  ldr      x22, [x22, #0x48]
016a088c  089c4439  ldrb     w8, [x0, #0x127]
016a0890  a8000836  tbz      w8, #1, #0x16a08a4
016a0894  08d840b9  ldr      w8, [x0, #0xd8]
016a0898  68000035  cbnz     w8, #0x16a08a4
016a089c  33ced997  bl       #0xd14168 ; unresolved symbol
016a08a0  000340f9  ldr      x0, [x24]
016a08a4  085c40f9  ldr      x8, [x0, #0xb8]
016a08a8  e10316aa  mov      x1, x22
016a08ac  e2031faa  mov      x2, xzr
016a08b0  000d40f9  ldr      x0, [x8, #0x18]
016a08b4  d7cd2094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
016a08b8  e10300aa  mov      x1, x0
016a08bc  e00315aa  mov      x0, x21
016a08c0  e2031faa  mov      x2, xzr
016a08c4  d9cd2094  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
016a08c8  e10314aa  mov      x1, x20
016a08cc  e2031faa  mov      x2, xzr
016a08d0  d0cd2094  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
016a08d4  080340f9  ldr      x8, [x24]
016a08d8  e00700f9  str      x0, [sp, #8]
016a08dc  e2031faa  mov      x2, xzr
016a08e0  085d40f9  ldr      x8, [x8, #0xb8]
016a08e4  011940f9  ldr      x1, [x8, #0x30]
016a08e8  ddce2094  bl       #0x1ed445c ; BattleCore.FP$$op_LessThan
016a08ec  60010036  tbz      w0, #0, #0x16a0918
016a08f0  000340f9  ldr      x0, [x24]
016a08f4  089c4439  ldrb     w8, [x0, #0x127]
016a08f8  a8000836  tbz      w8, #1, #0x16a090c
016a08fc  08d840b9  ldr      w8, [x0, #0xd8]
016a0900  68000035  cbnz     w8, #0x16a090c
016a0904  19ced997  bl       #0xd14168 ; unresolved symbol
016a0908  000340f9  ldr      x0, [x24]
016a090c  085c40f9  ldr      x8, [x0, #0xb8]
016a0910  001940f9  ldr      x0, [x8, #0x30]
016a0914  e00700f9  str      x0, [sp, #8]
016a0918  e0230091  add      x0, sp, #8
016a091c  e1031faa  mov      x1, xzr
016a0920  90d22094  bl       #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
016a0924  600200b9  str      w0, [x19]
016a0928  fd7b44a9  ldp      x29, x30, [sp, #0x40]
016a092c  f44f43a9  ldp      x20, x19, [sp, #0x30]
016a0930  f65742a9  ldp      x22, x21, [sp, #0x20]
016a0934  f85f41a9  ldp      x24, x23, [sp, #0x10]
016a0938  ff430191  add      sp, sp, #0x50
016a093c  c0035fd6  ret      
