; RVA 0xcf0060, file offset 0xcf0060, conservative end 0xcf0068
; SHA256 dfb556a413c8bda5332942d0202e8d5f1e52f45158aec3676294cf11ad5909cb
; All aliases at this entry: BattleCore.FP$$get_RawValue :: int64_t BattleCore_FP__get_RawValue (BattleCore_FP_o __this, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
00cf0060  000840f9  ldr      x0, [x0, #0x10]
00cf0064  c0035fd6  ret      
