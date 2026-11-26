; RVA 0xcf0070, file offset 0xcf0070, conservative end 0xcf007c
; SHA256 fb2463b0ed8de21dc6c80558cd0be3bc60a532f2d3ddf3648dbb808e9358932b
; All aliases at this entry: BattleCore.FP$$.ctor :: void BattleCore_FP___ctor (BattleCore_FP_o __this, int32_t value, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
00cf0070  287c60d3  lsl      x8, x1, #0x20
00cf0074  080800f9  str      x8, [x0, #0x10]
00cf0078  c0035fd6  ret      
