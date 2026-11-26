; RVA 0x1ed4450, file offset 0x1ed4450, conservative end 0x1ed445c
; SHA256 234285a55818a142f3483747f109d63940a365cc437aa56125e92890486bc585
; All aliases at this entry: BattleCore.FP$$op_GreaterThan :: bool BattleCore_FP__op_GreaterThan (BattleCore_FP_o x, BattleCore_FP_o y, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed4450  1f0001eb  cmp      x0, x1
01ed4454  e0d79f1a  cset     w0, gt
01ed4458  c0035fd6  ret      
