; RVA 0x21a56d8, file offset 0x21a56d8, conservative end 0x21a56f0
; SHA256 7eedb98dfc4825f06f6e726eb7521118ce997ffc02165d4837eefe1a21146066
; All aliases at this entry: BattleCore.TSRandom$$genrand_int31 :: int32_t BattleCore_TSRandom__genrand_int31 (BattleCore_TSRandom_o* __this, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
021a56d8  fd7bbfa9  stp      x29, x30, [sp, #-0x10]!
021a56dc  fd030091  mov      x29, sp
021a56e0  d1000094  bl       #0x21a5a24 ; BattleCore.TSRandom$$genrand_int32
021a56e4  007c0153  lsr      w0, w0, #1
021a56e8  fd7bc1a8  ldp      x29, x30, [sp], #0x10
021a56ec  c0035fd6  ret      
