; RVA 0x17535e8, file offset 0x17535e8, conservative end 0x1753648
; SHA256 8026e653fff68d5f4c0588dfd38a697b42ab8483d697fdd59e52653293acd036
; All aliases at this entry: A3BattleCore.ActorAttrImpactData$$CanMerge :: bool A3BattleCore_ActorAttrImpactData__CanMerge (A3BattleCore_ActorAttrImpactData_o* __this, A3BattleCore_ActorAttrImpactData_o* other, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
017535e8  f50f1df8  str      x21, [sp, #-0x30]!
017535ec  f44f01a9  stp      x20, x19, [sp, #0x10]
017535f0  fd7b02a9  stp      x29, x30, [sp, #0x20]
017535f4  fd830091  add      x29, sp, #0x20
017535f8  f30300aa  mov      x19, x0
017535fc  751a40b9  ldr      w21, [x19, #0x18]
01753600  f40301aa  mov      x20, x1
01753604  740000b5  cbnz     x20, #0x1753610
01753608  e0031faa  mov      x0, xzr
0175360c  4860d797  bl       #0xd2b72c ; unresolved symbol
01753610  881a40b9  ldr      w8, [x20, #0x18]
01753614  bf02086b  cmp      w21, w8
01753618  e1000054  b.ne     #0x1753634
0175361c  681e40b9  ldr      w8, [x19, #0x1c]
01753620  891e40b9  ldr      w9, [x20, #0x1c]
01753624  1f01096b  cmp      w8, w9
01753628  61000054  b.ne     #0x1753634
0175362c  e0030032  mov      w0, #1
01753630  02000014  b        #0x1753638
01753634  e0031f2a  mov      w0, wzr
01753638  fd7b42a9  ldp      x29, x30, [sp, #0x20]
0175363c  f44f41a9  ldp      x20, x19, [sp, #0x10]
01753640  f50743f8  ldr      x21, [sp], #0x30
01753644  c0035fd6  ret      
