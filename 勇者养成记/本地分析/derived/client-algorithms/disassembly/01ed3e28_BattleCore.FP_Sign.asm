; RVA 0x1ed3e28, file offset 0x1ed3e28, conservative end 0x1ed3e40
; SHA256 6a96f361faed7702d41edd05edf01dfa19905d2ad0f4b60c3ac6493f64b6d069
; All aliases at this entry: BattleCore.FP$$Sign :: int32_t BattleCore_FP__Sign (BattleCore_FP_o value, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed3e28  8000f8b7  tbnz     x0, #0x3f, #0x1ed3e38
01ed3e2c  1f0000f1  cmp      x0, #0
01ed3e30  e0079f1a  cset     w0, ne
01ed3e34  c0035fd6  ret      
01ed3e38  00008012  mov      w0, #-1
01ed3e3c  c0035fd6  ret      
