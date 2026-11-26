; RVA 0x1ed4474, file offset 0x1ed4474, conservative end 0x1ed4480
; SHA256 89e148e3b28d7cd96cddd0e3c5021b4d48a59954b41b60c72b62b30c62c2592d
; All aliases at this entry: BattleCore.FP$$op_LessThanOrEqual :: bool BattleCore_FP__op_LessThanOrEqual (BattleCore_FP_o x, BattleCore_FP_o y, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed4474  1f0001eb  cmp      x0, x1
01ed4478  e0c79f1a  cset     w0, le
01ed447c  c0035fd6  ret      
