; RVA 0xcf0018, file offset 0xcf0018, conservative end 0xcf0020
; SHA256 130bb85eae45d20b7cb285ce369b577dd6d4567281ec2d3eee3329c3fc129b0c
; All aliases at this entry: BattleCore.FP$$AsFloat :: float BattleCore_FP__AsFloat (BattleCore_FP_o __this, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
00cf0018  00400091  add      x0, x0, #0x10
00cf001c  b4944714  b        #0x1ed52ec ; BattleCore.FP$$AsFloat_body_via_thunk
