; RVA 0x1ed445c, file offset 0x1ed445c, conservative end 0x1ed4468
; SHA256 82e66055e550730a047f1a020db2ec83799b9728ed8181b40a93c2952a7a4071
; All aliases at this entry: BattleCore.FP$$op_LessThan :: bool BattleCore_FP__op_LessThan (BattleCore_FP_o x, BattleCore_FP_o y, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed445c  1f0001eb  cmp      x0, x1
01ed4460  e0a79f1a  cset     w0, lt
01ed4464  c0035fd6  ret      
