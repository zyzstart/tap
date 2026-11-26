; RVA 0x169c134, file offset 0x169c134, conservative end 0x169c160
; SHA256 18b8d4a57549009ac3a05c6fce7c27e6519eb9808096d217560bc4f10ca18588
; All aliases at this entry: A3BattleCore.SkillDamageHelper$$.ctor :: void A3BattleCore_SkillDamageHelper___ctor (A3BattleCore_SkillDamageHelper_o* __this, A3BattleCore_BattleContext_o* context, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
0169c134  f44fbea9  stp      x20, x19, [sp, #-0x20]!
0169c138  fd7b01a9  stp      x29, x30, [sp, #0x10]
0169c13c  fd430091  add      x29, sp, #0x10
0169c140  f30301aa  mov      x19, x1
0169c144  e1031faa  mov      x1, xzr
0169c148  f40300aa  mov      x20, x0
0169c14c  18c30d94  bl       #0x1a0cdac ; System.Object$$.ctor
0169c150  930a00f9  str      x19, [x20, #0x10]
0169c154  fd7b41a9  ldp      x29, x30, [sp, #0x10]
0169c158  f44fc2a8  ldp      x20, x19, [sp], #0x20
0169c15c  c0035fd6  ret      
