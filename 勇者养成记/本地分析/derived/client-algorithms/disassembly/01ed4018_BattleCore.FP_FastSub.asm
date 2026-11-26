; RVA 0x1ed4018, file offset 0x1ed4018, conservative end 0x1ed4028
; SHA256 54286cf6705cfc11c6c2f8433a9caea17b96c12595e50e96bbe6d964c4b79810
; All aliases at this entry: BattleCore.FP$$FastSub :: BattleCore_FP_o BattleCore_FP__FastSub (BattleCore_FP_o x, BattleCore_FP_o y, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed4018  000001cb  sub      x0, x0, x1
01ed401c  c0035fd6  ret      
01ed4020  010000f9  str      x1, [x0]
01ed4024  c0035fd6  ret      
