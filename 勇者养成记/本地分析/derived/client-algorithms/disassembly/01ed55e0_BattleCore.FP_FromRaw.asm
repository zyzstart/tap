; RVA 0x1ed55e0, file offset 0x1ed55e0, conservative end 0x1ed55f0
; SHA256 17914c746c8c314a2ec89cf463795f26201a2a35556d95043cf6e25fd9721166
; All aliases at this entry: BattleCore.FP$$FromRaw :: BattleCore_FP_o BattleCore_FP__FromRaw (int64_t rawValue, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed55e0  c0035fd6  ret      
01ed55e4  287c60d3  lsl      x8, x1, #0x20
01ed55e8  080000f9  str      x8, [x0]
01ed55ec  c0035fd6  ret      
