; RVA 0x1ed4468, file offset 0x1ed4468, conservative end 0x1ed4474
; SHA256 f5a9e533829b2aae17c4a723381deceabebec05a5098ea067faf05a48851c743
; All aliases at this entry: BattleCore.FP$$op_GreaterThanOrEqual :: bool BattleCore_FP__op_GreaterThanOrEqual (BattleCore_FP_o x, BattleCore_FP_o y, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed4468  1f0001eb  cmp      x0, x1
01ed446c  e0b79f1a  cset     w0, ge
01ed4470  c0035fd6  ret      
