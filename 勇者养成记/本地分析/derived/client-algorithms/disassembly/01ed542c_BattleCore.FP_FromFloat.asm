; RVA 0x1ed542c, file offset 0x1ed542c, conservative end 0x1ed5434
; SHA256 97a2e77890bd3a4eb7563aab676087193b4751eff4f429a86c572dfbd3d40372
; All aliases at this entry: BattleCore.FP$$FromFloat :: BattleCore_FP_o BattleCore_FP__FromFloat (float value, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed542c  0080189e  fcvtzs   x0, s0, #0x20
01ed5430  c0035fd6  ret      
