; RVA 0x1ed4438, file offset 0x1ed4438, conservative end 0x1ed4444
; SHA256 db44cd7cecaf2c83fd2f7f754032a917aa8a50c48145317dd2d77904f5f5f503
; All aliases at this entry: BattleCore.FP$$op_Equality :: bool BattleCore_FP__op_Equality (BattleCore_FP_o x, BattleCore_FP_o y, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed4438  1f0001eb  cmp      x0, x1
01ed443c  e0179f1a  cset     w0, eq
01ed4440  c0035fd6  ret      
