; RVA 0x219efc0, file offset 0x219efc0, conservative end 0x219f060
; SHA256 0d4a4e1b72368f91f281b91494d1c50b80e59d6822ea19071bcf8fa429db7ca1
; All aliases at this entry: BattleCore.TSMath$$Max :: BattleCore_FP_o BattleCore_TSMath__Max (BattleCore_FP_o val1, BattleCore_FP_o val2, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
0219efc0  f50f1df8  str      x21, [sp, #-0x30]!
0219efc4  f44f01a9  stp      x20, x19, [sp, #0x10]
0219efc8  fd7b02a9  stp      x29, x30, [sp, #0x20]
0219efcc  fd830091  add      x29, sp, #0x20
0219efd0  556d0090  adrp     x21, #0x2f46000
0219efd4  a8fa5e39  ldrb     w8, [x21, #0x7be]
0219efd8  f30301aa  mov      x19, x1
0219efdc  f40300aa  mov      x20, x0
0219efe0  e8000037  tbnz     w8, #0, #0x219effc
0219efe4  485c00f0  adrp     x8, #0x2d29000
0219efe8  08cd41f9  ldr      x8, [x8, #0x398]
0219efec  000140b9  ldr      w0, [x8]
0219eff0  ce97ad97  bl       #0xd04f28 ; unresolved symbol
0219eff4  e8030032  mov      w8, #1
0219eff8  a8fa1e39  strb     w8, [x21, #0x7be]
0219effc  e85800f0  adrp     x8, #0x2cbd000
0219f000  08dd47f9  ldr      x8, [x8, #0xfb8]
0219f004  8f250014  b        #0x21a8640 ; unresolved symbol
0219f008  089c4439  ldrb     w8, [x0, #0x127]
0219f00c  88000836  tbz      w8, #1, #0x219f01c
0219f010  08d840b9  ldr      w8, [x0, #0xd8]
0219f014  48000035  cbnz     w8, #0x219f01c
0219f018  54d4ad97  bl       #0xd14168 ; unresolved symbol
0219f01c  e00314aa  mov      x0, x20
0219f020  e10313aa  mov      x1, x19
0219f024  e2031faa  mov      x2, xzr
0219f028  0ad5f497  bl       #0x1ed4450 ; BattleCore.FP$$op_GreaterThan
0219f02c  1f000072  tst      w0, #1
0219f030  8012939a  csel     x0, x20, x19, ne
0219f034  fd7b42a9  ldp      x29, x30, [sp, #0x20]
0219f038  f44f41a9  ldp      x20, x19, [sp, #0x10]
0219f03c  f50743f8  ldr      x21, [sp], #0x30
0219f040  c0035fd6  ret      
0219f044  08400091  add      x8, x0, #0x10
0219f048  010800a9  stp      x1, x2, [x0]
0219f04c  e00308aa  mov      x0, x8
0219f050  e10303aa  mov      x1, x3
0219f054  e20304aa  mov      x2, x4
0219f058  e3031faa  mov      x3, xzr
0219f05c  2cdef417  b        #0x1ed690c ; unresolved symbol
