; RVA 0x21a56b8, file offset 0x21a56b8, conservative end 0x21a56c0
; SHA256 e46803c14f46ba6c6f7f7a3dae6761e968bfa96c9f81ee5f0eb4dc5d83bc22ec
; All aliases at this entry: BattleCore.TSRandom$$get_MaxRandomInt :: int32_t BattleCore_TSRandom__get_MaxRandomInt (const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
021a56b8  e07b0032  mov      w0, #0x7fffffff
021a56bc  c0035fd6  ret      
