; RVA 0xcf003c, file offset 0xcf003c, conservative end 0xcf004c
; SHA256 7aa8fd94a920909345fe943c74e2858b46b35aefa1467d284f8809fba95d0a5b
; All aliases at this entry: BattleCore.FP$$Equals :: bool BattleCore_FP__Equals (BattleCore_FP_o __this, BattleCore_FP_o other, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
00cf003c  080840f9  ldr      x8, [x0, #0x10]
00cf0040  1f0101eb  cmp      x8, x1
00cf0044  e0179f1a  cset     w0, eq
00cf0048  c0035fd6  ret      
