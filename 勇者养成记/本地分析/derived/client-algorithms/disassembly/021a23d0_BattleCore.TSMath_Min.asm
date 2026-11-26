; RVA 0x21a23d0, file offset 0x21a23d0, conservative end 0x21a2454
; SHA256 7243d8252389bab44a37d888cf9a48289b98e4314bc756d28cedcf6b75977f9d
; All aliases at this entry: BattleCore.TSMath$$Min :: BattleCore_FP_o BattleCore_TSMath__Min (BattleCore_FP_o val1, BattleCore_FP_o val2, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
021a23d0  f50f1df8  str      x21, [sp, #-0x30]!
021a23d4  f44f01a9  stp      x20, x19, [sp, #0x10]
021a23d8  fd7b02a9  stp      x29, x30, [sp, #0x20]
021a23dc  fd830091  add      x29, sp, #0x20
021a23e0  356d0090  adrp     x21, #0x2f46000
021a23e4  a8fe5e39  ldrb     w8, [x21, #0x7bf]
021a23e8  f30301aa  mov      x19, x1
021a23ec  f40300aa  mov      x20, x0
021a23f0  e8000037  tbnz     w8, #0, #0x21a240c
021a23f4  68570090  adrp     x8, #0x2c8e000
021a23f8  084144f9  ldr      x8, [x8, #0x880]
021a23fc  000140b9  ldr      w0, [x8]
021a2400  ca8aad97  bl       #0xd04f28 ; unresolved symbol
021a2404  e8030032  mov      w8, #1
021a2408  a8fe1e39  strb     w8, [x21, #0x7bf]
021a240c  c85800f0  adrp     x8, #0x2cbd000
021a2410  08dd47f9  ldr      x8, [x8, #0xfb8]
021a2414  000140f9  ldr      x0, [x8]
021a2418  089c4439  ldrb     w8, [x0, #0x127]
021a241c  88000836  tbz      w8, #1, #0x21a242c
021a2420  08d840b9  ldr      w8, [x0, #0xd8]
021a2424  48000035  cbnz     w8, #0x21a242c
021a2428  50c7ad97  bl       #0xd14168 ; unresolved symbol
021a242c  e00314aa  mov      x0, x20
021a2430  e10313aa  mov      x1, x19
021a2434  e2031faa  mov      x2, xzr
021a2438  09c8f497  bl       #0x1ed445c ; BattleCore.FP$$op_LessThan
021a243c  1f000072  tst      w0, #1
021a2440  8012939a  csel     x0, x20, x19, ne
021a2444  fd7b42a9  ldp      x29, x30, [sp, #0x20]
021a2448  f44f41a9  ldp      x20, x19, [sp, #0x10]
021a244c  f50743f8  ldr      x21, [sp], #0x30
021a2450  c0035fd6  ret      
