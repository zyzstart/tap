; RVA 0x1ed4444, file offset 0x1ed4444, conservative end 0x1ed4450
; SHA256 c7db8563070b29131fe55a3f98573b828d387b98434d7b4c2d91002d16c22fd6
; All aliases at this entry: BattleCore.FP$$op_Inequality :: bool BattleCore_FP__op_Inequality (BattleCore_FP_o x, BattleCore_FP_o y, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed4444  1f0001eb  cmp      x0, x1
01ed4448  e0079f1a  cset     w0, ne
01ed444c  c0035fd6  ret      
