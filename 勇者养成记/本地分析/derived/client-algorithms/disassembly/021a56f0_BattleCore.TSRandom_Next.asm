; RVA 0x21a56f0, file offset 0x21a56f0, conservative end 0x21a572c
; SHA256 b164eb83f6930a44650fd62bd5e4470d5fb4296414ba2e1e4acdb05f7d1ada99
; All aliases at this entry: BattleCore.TSRandom$$Next :: int32_t BattleCore_TSRandom__Next (BattleCore_TSRandom_o* __this, int32_t minValue, int32_t maxValue, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
021a56f0  f44fbea9  stp      x20, x19, [sp, #-0x20]!
021a56f4  fd7b01a9  stp      x29, x30, [sp, #0x10]
021a56f8  fd430091  add      x29, sp, #0x10
021a56fc  3f00026b  cmp      w1, w2
021a5700  28c0821a  csel     w8, w1, w2, gt
021a5704  53c0811a  csel     w19, w2, w1, gt
021a5708  1401134b  sub      w20, w8, w19
021a570c  c6000094  bl       #0x21a5a24 ; BattleCore.TSRandom$$genrand_int32
021a5710  087c0153  lsr      w8, w0, #1
021a5714  fd7b41a9  ldp      x29, x30, [sp, #0x10]
021a5718  090dd41a  sdiv     w9, w8, w20
021a571c  28a1141b  msub     w8, w9, w20, w8
021a5720  0001130b  add      w0, w8, w19
021a5724  f44fc2a8  ldp      x20, x19, [sp], #0x20
021a5728  c0035fd6  ret      
