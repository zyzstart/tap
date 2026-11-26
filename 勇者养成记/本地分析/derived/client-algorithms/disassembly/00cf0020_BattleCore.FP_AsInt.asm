; RVA 0xcf0020, file offset 0xcf0020, conservative end 0xcf0028
; SHA256 133420d908e1e97e3bc35b8122ee5707097996ca33115ad7286c6cbd6c2ce5b0
; All aliases at this entry: BattleCore.FP$$AsInt :: int32_t BattleCore_FP__AsInt (BattleCore_FP_o __this, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
00cf0020  00400091  add      x0, x0, #0x10
00cf0024  cf944714  b        #0x1ed5360 ; BattleCore.FP$$AsInt_body_via_thunk
