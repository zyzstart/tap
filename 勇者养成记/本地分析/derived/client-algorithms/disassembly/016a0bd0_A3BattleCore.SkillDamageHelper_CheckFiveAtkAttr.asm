; RVA 0x16a0bd0, file offset 0x16a0bd0, conservative end 0x16a0bf4
; SHA256 1eb332bd3f9868df1d61c5b213705cfd2b925474f396dcc8b4021c7fdf19b803
; All aliases at this entry: A3BattleCore.SkillDamageHelper$$CheckFiveAtkAttr :: bool A3BattleCore_SkillDamageHelper__CheckFiveAtkAttr (A3BattleCore_SkillDamageHelper_o* __this, int32_t dataType, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
016a0bd0  28c00051  sub      w8, w1, #0x30
016a0bd4  1f0d0071  cmp      w8, #3
016a0bd8  62000054  b.hs     #0x16a0be4
016a0bdc  e0030032  mov      w0, #1
016a0be0  c0035fd6  ret      
016a0be4  28cc0051  sub      w8, w1, #0x33
016a0be8  1f090071  cmp      w8, #2
016a0bec  e0279f1a  cset     w0, lo
016a0bf0  c0035fd6  ret      
