; RVA 0x1ed40b4, file offset 0x1ed40b4, conservative end 0x1ed40d8
; SHA256 82b798e580d84ce73c0203e41a98fa315025fcf924fcbf68c5c04acc4e010953
; All aliases at this entry: BattleCore.FP$$FastMul :: BattleCore_FP_o BattleCore_FP__FastMul (BattleCore_FP_o x, BattleCore_FP_o y, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed40b4  087c4092  and      x8, x0, #0xffffffff
01ed40b8  297c4092  and      x9, x1, #0xffffffff
01ed40bc  2afc6093  asr      x10, x1, #0x20
01ed40c0  297d089b  mul      x9, x9, x8
01ed40c4  487d089b  mul      x8, x10, x8
01ed40c8  0afc6093  asr      x10, x0, #0x20
01ed40cc  0881498b  add      x8, x8, x9, lsr #32
01ed40d0  20200a9b  madd     x0, x1, x10, x8
01ed40d4  c0035fd6  ret      
