; RVA 0xcf0058, file offset 0xcf0058, conservative end 0xcf0060
; SHA256 682b440a7d0b4c7629f2ddd037eb93023d6d1d0ccb4f44731cdb68fb493f85f5
; All aliases at this entry: BattleCore.FP$$ToString :: System_String_o* BattleCore_FP__ToString (BattleCore_FP_o __this, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
00cf0058  00400091  add      x0, x0, #0x10
00cf005c  3d954714  b        #0x1ed5550 ; BattleCore.FP$$ToString_body_via_thunk
