; RVA 0x1ed40d8, file offset 0x1ed40d8, conservative end 0x1ed4114
; SHA256 fae2b7b699e756b86049fecd1f621059f587d17337380827d1a85a22005c7013
; All aliases at this entry: BattleCore.FP$$CountLeadingZeroes :: int32_t BattleCore_FP__CountLeadingZeroes (uint64_t x, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed40d8  e80300aa  mov      x8, x0
01ed40dc  e0031f2a  mov      w0, wzr
01ed40e0  09fd7cd3  lsr      x9, x8, #0x3c
01ed40e4  e90000b5  cbnz     x9, #0x1ed4100
01ed40e8  e90308aa  mov      x9, x8
01ed40ec  28ed7cd3  lsl      x8, x9, #4
01ed40f0  2aed78d3  ubfx     x10, x9, #0x38, #4
01ed40f4  00100011  add      w0, w0, #4
01ed40f8  e90308aa  mov      x9, x8
01ed40fc  8affffb4  cbz      x10, #0x1ed40ec
01ed4100  8800f8b7  tbnz     x8, #0x3f, #0x1ed4110
01ed4104  08f97fd3  lsl      x8, x8, #1
01ed4108  00040011  add      w0, w0, #1
01ed410c  c8ffffb6  tbz      x8, #0x3f, #0x1ed4104
01ed4110  c0035fd6  ret      
