; RVA 0x1ed4908, file offset 0x1ed4908, conservative end 0x1ed49e4
; SHA256 3e25adad15b9bdff3f499a0504375032aa21b4456db902a9afe9cd2b291f72f0
; All aliases at this entry: BattleCore.FP$$ClampSinValue :: int64_t BattleCore_FP__ClampSinValue (int64_t angle, bool* flipHorizontal, bool* flipVertical, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed4908  a80a88d2  mov      x8, #0x4055
01ed490c  88f6a4f2  movk     x8, #0x27b4, lsl #16
01ed4910  e836d8f2  movk     x8, #0xc1b7, lsl #32
01ed4914  882feaf2  movk     x8, #0x517c, lsl #48
01ed4918  29a29ad2  mov      x9, #0xd511
01ed491c  087c489b  smulh    x8, x0, x8
01ed4920  c90fa9f2  movk     x9, #0x487e, lsl #16
01ed4924  0afd6193  asr      x10, x8, #0x21
01ed4928  c900c0f2  movk     x9, #6, lsl #32
01ed492c  48fd488b  add      x8, x10, x8, lsr #63
01ed4930  0a518dd2  mov      x10, #0x6a88
01ed4934  ea87a4f2  movk     x10, #0x243f, lsl #16
01ed4938  0881099b  msub     x8, x8, x9, x0
01ed493c  1f0000f1  cmp      x0, #0
01ed4940  6a00c0f2  movk     x10, #3, lsl #32
01ed4944  eb508d92  mov      x11, #-0x6a88
01ed4948  0901098b  add      x9, x8, x9
01ed494c  0b78bbf2  movk     x11, #0xdbc0, lsl #16
01ed4950  08a1899a  csel     x8, x8, x9, ge
01ed4954  490500d1  sub      x9, x10, #1
01ed4958  8bffdff2  movk     x11, #0xfffc, lsl #32
01ed495c  1f0109eb  cmp      x8, x9
01ed4960  ec0328aa  mvn      x12, x8
01ed4964  e9d79f1a  cset     w9, gt
01ed4968  9f010beb  cmp      x12, x11
01ed496c  49000039  strb     w9, [x2]
01ed4970  296091d2  mov      x9, #0x8b01
01ed4974  6bd188da  csinv    x11, x11, x8, le
01ed4978  a9d2bcf2  movk     x9, #0xe695, lsl #16
01ed497c  0b010b8b  add      x11, x8, x11
01ed4980  c906d3f2  movk     x9, #0x9836, lsl #32
01ed4984  6b010a8b  add      x11, x11, x10
01ed4988  e945e1f2  movk     x9, #0xa2f, lsl #48
01ed498c  6cfd43d3  lsr      x12, x11, #3
01ed4990  897dc99b  umulh    x9, x12, x9
01ed4994  29fd5ad3  lsr      x9, x9, #0x1a
01ed4998  6ca896d2  mov      x12, #0xb543
01ed499c  29ad0a9b  msub     x9, x9, x10, x11
01ed49a0  ec43b2f2  movk     x12, #0x921f, lsl #16
01ed49a4  6aa89692  mov      x10, #-0xb544
01ed49a8  29010bcb  sub      x9, x9, x11
01ed49ac  8ba896d2  mov      x11, #0xb544
01ed49b0  2c00c0f2  movk     x12, #1, lsl #32
01ed49b4  0abcadf2  movk     x10, #0x6de0, lsl #16
01ed49b8  eb43b2f2  movk     x11, #0x921f, lsl #16
01ed49bc  0801098b  add      x8, x8, x9
01ed49c0  caffdff2  movk     x10, #0xfffe, lsl #32
01ed49c4  2b00c0f2  movk     x11, #1, lsl #32
01ed49c8  1f010ceb  cmp      x8, x12
01ed49cc  09010a8b  add      x9, x8, x10
01ed49d0  ead79f1a  cset     w10, gt
01ed49d4  1f010beb  cmp      x8, x11
01ed49d8  00b1899a  csel     x0, x8, x9, lt
01ed49dc  2a000039  strb     w10, [x1]
01ed49e0  c0035fd6  ret      
