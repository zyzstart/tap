; RVA 0x1ed5234, file offset 0x1ed5234, conservative end 0x1ed5248
; SHA256 055385145529da567c0581f2c5adf91cc46b9f0dc7b4bc4459391fb55dd1e350
; All aliases at this entry: BattleCore.FP$$op_Explicit :: float BattleCore_FP__op_Explicit (BattleCore_FP_o value, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed5234  e8260090  adrp     x8, #0x23b1000
01ed5238  006d44bd  ldr      s0, [x8, #0x46c]
01ed523c  0100229e  scvtf    s1, x0
01ed5240  2008201e  fmul     s0, s1, s0
01ed5244  c0035fd6  ret      
