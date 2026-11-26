; RVA 0x1ed53c8, file offset 0x1ed53c8, conservative end 0x1ed542c
; SHA256 dccc286e0bc549b3602071a2d0d89a79a3b7249e851d02a3e4e3ab9dcc74a3b5
; All aliases at this entry: BattleCore.FP$$ToInt :: int32_t BattleCore_FP__ToInt (BattleCore_FP_o value, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed53c8  f44fbea9  stp      x20, x19, [sp, #-0x20]!
01ed53cc  fd7b01a9  stp      x29, x30, [sp, #0x10]
01ed53d0  fd430091  add      x29, sp, #0x10
01ed53d4  748300f0  adrp     x20, #0x2f44000
01ed53d8  88067f39  ldrb     w8, [x20, #0xfc1]
01ed53dc  f30300aa  mov      x19, x0
01ed53e0  e8000037  tbnz     w8, #0, #0x1ed53fc
01ed53e4  887200d0  adrp     x8, #0x2d27000
01ed53e8  08c144f9  ldr      x8, [x8, #0x980]
01ed53ec  000140b9  ldr      w0, [x8]
01ed53f0  cebeb897  bl       #0xd04f28 ; unresolved symbol
01ed53f4  e8030032  mov      w8, #1
01ed53f8  88063f39  strb     w8, [x20, #0xfc1]
01ed53fc  486f0090  adrp     x8, #0x2cbd000
01ed5400  08dd47f9  ldr      x8, [x8, #0xfb8]
01ed5404  000140f9  ldr      x0, [x8]
01ed5408  089c4439  ldrb     w8, [x0, #0x127]
01ed540c  88000836  tbz      w8, #1, #0x1ed541c
01ed5410  08d840b9  ldr      w8, [x0, #0xd8]
01ed5414  48000035  cbnz     w8, #0x1ed541c
01ed5418  54fbb897  bl       #0xd14168 ; unresolved symbol
01ed541c  fd7b41a9  ldp      x29, x30, [sp, #0x10]
01ed5420  60fe60d3  lsr      x0, x19, #0x20
01ed5424  f44fc2a8  ldp      x20, x19, [sp], #0x20
01ed5428  c0035fd6  ret      
