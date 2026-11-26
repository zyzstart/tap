; RVA 0x21a56c0, file offset 0x21a56c0, conservative end 0x21a56d8
; SHA256 0884854c8961c359ba786e889e4c94140b7ece9cb860e45c0f5f978a890dbe2a
; All aliases at this entry: BattleCore.TSRandom$$Next :: int32_t BattleCore_TSRandom__Next (BattleCore_TSRandom_o* __this, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
021a56c0  fd7bbfa9  stp      x29, x30, [sp, #-0x10]!
021a56c4  fd030091  mov      x29, sp
021a56c8  d7000094  bl       #0x21a5a24 ; BattleCore.TSRandom$$genrand_int32
021a56cc  007c0153  lsr      w0, w0, #1
021a56d0  fd7bc1a8  ldp      x29, x30, [sp], #0x10
021a56d4  c0035fd6  ret      
