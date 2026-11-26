; RVA 0x1ed3ed0, file offset 0x1ed3ed0, conservative end 0x1ed3ed8
; SHA256 f90c5d3ceba0c889bc3eba5631df159441685d53393518f38c1f16cd6a293c09
; All aliases at this entry: BattleCore.FP$$Floor :: BattleCore_FP_o BattleCore_FP__Floor (BattleCore_FP_o value, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed3ed0  007c6092  and      x0, x0, #0xffffffff00000000
01ed3ed4  c0035fd6  ret      
