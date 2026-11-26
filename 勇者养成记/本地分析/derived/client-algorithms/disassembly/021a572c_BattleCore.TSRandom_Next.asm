; RVA 0x21a572c, file offset 0x21a572c, conservative end 0x21a5868
; SHA256 ef12612ea654335171471f5f0d085e637c948eb2b4918f11f5b50d3a72eb9aca
; All aliases at this entry: BattleCore.TSRandom$$Next :: BattleCore_FP_o BattleCore_TSRandom__Next (BattleCore_TSRandom_o* __this, BattleCore_FP_o min, BattleCore_FP_o max, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
021a572c  f70f1cf8  str      x23, [sp, #-0x40]!
021a5730  f65701a9  stp      x22, x21, [sp, #0x10]
021a5734  f44f02a9  stp      x20, x19, [sp, #0x20]
021a5738  fd7b03a9  stp      x29, x30, [sp, #0x30]
021a573c  fdc30091  add      x29, sp, #0x30
021a5740  166d00b0  adrp     x22, #0x2f46000
021a5744  c88e5f39  ldrb     w8, [x22, #0x7e3]
021a5748  f40302aa  mov      x20, x2
021a574c  f30301aa  mov      x19, x1
021a5750  f50300aa  mov      x21, x0
021a5754  e8000037  tbnz     w8, #0, #0x21a5770
021a5758  685700d0  adrp     x8, #0x2c93000
021a575c  08a146f9  ldr      x8, [x8, #0xd40]
021a5760  000140b9  ldr      w0, [x8]
021a5764  f17dad97  bl       #0xd04f28 ; unresolved symbol
021a5768  e8030032  mov      w8, #1
021a576c  c88e1f39  strb     w8, [x22, #0x7e3]
021a5770  d7580090  adrp     x23, #0x2cbd000
021a5774  f7de47f9  ldr      x23, [x23, #0xfb8]
021a5778  e00240f9  ldr      x0, [x23]
021a577c  089c4439  ldrb     w8, [x0, #0x127]
021a5780  88000836  tbz      w8, #1, #0x21a5790
021a5784  08d840b9  ldr      w8, [x0, #0xd8]
021a5788  48000035  cbnz     w8, #0x21a5790
021a578c  77baad97  bl       #0xd14168 ; unresolved symbol
021a5790  e00313aa  mov      x0, x19
021a5794  e10314aa  mov      x1, x20
021a5798  e2031faa  mov      x2, xzr
021a579c  27bbf497  bl       #0x1ed4438 ; BattleCore.FP$$op_Equality
021a57a0  e0000036  tbz      w0, #0, #0x21a57bc
021a57a4  e00313aa  mov      x0, x19
021a57a8  fd7b43a9  ldp      x29, x30, [sp, #0x30]
021a57ac  f44f42a9  ldp      x20, x19, [sp, #0x20]
021a57b0  f65741a9  ldp      x22, x21, [sp, #0x10]
021a57b4  f70744f8  ldr      x23, [sp], #0x40
021a57b8  c0035fd6  ret      
021a57bc  e00240f9  ldr      x0, [x23]
021a57c0  089c4439  ldrb     w8, [x0, #0x127]
021a57c4  88000836  tbz      w8, #1, #0x21a57d4
021a57c8  08d840b9  ldr      w8, [x0, #0xd8]
021a57cc  48000035  cbnz     w8, #0x21a57d4
021a57d0  66baad97  bl       #0xd14168 ; unresolved symbol
021a57d4  e00313aa  mov      x0, x19
021a57d8  e10314aa  mov      x1, x20
021a57dc  e2031faa  mov      x2, xzr
021a57e0  1cbbf497  bl       #0x1ed4450 ; BattleCore.FP$$op_GreaterThan
021a57e4  1f000072  tst      w0, #1
021a57e8  e00315aa  mov      x0, x21
021a57ec  7612949a  csel     x22, x19, x20, ne
021a57f0  9312939a  csel     x19, x20, x19, ne
021a57f4  1d000094  bl       #0x21a5868 ; BattleCore.TSRandom$$NextFP
021a57f8  e80240f9  ldr      x8, [x23]
021a57fc  f40300aa  mov      x20, x0
021a5800  099d4439  ldrb     w9, [x8, #0x127]
021a5804  a9000836  tbz      w9, #1, #0x21a5818
021a5808  09d940b9  ldr      w9, [x8, #0xd8]
021a580c  69000035  cbnz     w9, #0x21a5818
021a5810  e00308aa  mov      x0, x8
021a5814  55baad97  bl       #0xd14168 ; unresolved symbol
021a5818  e00316aa  mov      x0, x22
021a581c  e10313aa  mov      x1, x19
021a5820  e2031faa  mov      x2, xzr
021a5824  fbb9f497  bl       #0x1ed4010 ; BattleCore.FP$$op_Subtraction
021a5828  e80240f9  ldr      x8, [x23]
021a582c  e2031faa  mov      x2, xzr
021a5830  085d40f9  ldr      x8, [x8, #0xb8]
021a5834  010140f9  ldr      x1, [x8]
021a5838  c7b9f497  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
021a583c  e10300aa  mov      x1, x0
021a5840  e00314aa  mov      x0, x20
021a5844  e2031faa  mov      x2, xzr
021a5848  f8b9f497  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
021a584c  e10313aa  mov      x1, x19
021a5850  fd7b43a9  ldp      x29, x30, [sp, #0x30]
021a5854  f44f42a9  ldp      x20, x19, [sp, #0x20]
021a5858  f65741a9  ldp      x22, x21, [sp, #0x10]
021a585c  e2031faa  mov      x2, xzr
021a5860  f70744f8  ldr      x23, [sp], #0x40
021a5864  bcb9f417  b        #0x1ed3f54 ; BattleCore.FP$$op_Addition
