; RVA 0x1ed3ec4, file offset 0x1ed3ec4, conservative end 0x1ed3ed0
; SHA256 d104209b9d20c26fab42952a3375780761b7e33509654f59645e5db60c12619e
; All aliases at this entry: BattleCore.FP$$FastAbs :: BattleCore_FP_o BattleCore_FP__FastAbs (BattleCore_FP_o value, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed3ec4  08fc808b  add      x8, x0, x0, asr #63
01ed3ec8  00fd80ca  eor      x0, x8, x0, asr #63
01ed3ecc  c0035fd6  ret      
