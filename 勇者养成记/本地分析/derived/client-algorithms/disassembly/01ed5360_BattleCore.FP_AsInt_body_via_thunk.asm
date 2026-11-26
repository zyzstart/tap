; RVA 0x1ed5360, file offset 0x1ed5360, conservative end 0x1ed53c8
; SHA256 410f174cd3e994066ffe21f03c5c8d7dd4ba0ea3402d6770a3c1f1e9f93a3f6e
; All aliases at this entry: BattleCore.FP$$AsInt_body_via_thunk :: inferred concrete unboxed entry from add x0,#0x10; b immediate
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed5360  f44fbea9  stp      x20, x19, [sp, #-0x20]!
01ed5364  fd7b01a9  stp      x29, x30, [sp, #0x10]
01ed5368  fd430091  add      x29, sp, #0x10
01ed536c  748300f0  adrp     x20, #0x2f44000
01ed5370  88027f39  ldrb     w8, [x20, #0xfc0]
01ed5374  f30300aa  mov      x19, x0
01ed5378  e8000037  tbnz     w8, #0, #0x1ed5394
01ed537c  e87100d0  adrp     x8, #0x2d13000
01ed5380  081d44f9  ldr      x8, [x8, #0x838]
01ed5384  000140b9  ldr      w0, [x8]
01ed5388  e8beb897  bl       #0xd04f28 ; unresolved symbol
01ed538c  e8030032  mov      w8, #1
01ed5390  88023f39  strb     w8, [x20, #0xfc0]
01ed5394  486f0090  adrp     x8, #0x2cbd000
01ed5398  08dd47f9  ldr      x8, [x8, #0xfb8]
01ed539c  730240f9  ldr      x19, [x19]
01ed53a0  000140f9  ldr      x0, [x8]
01ed53a4  089c4439  ldrb     w8, [x0, #0x127]
01ed53a8  88000836  tbz      w8, #1, #0x1ed53b8
01ed53ac  08d840b9  ldr      w8, [x0, #0xd8]
01ed53b0  48000035  cbnz     w8, #0x1ed53b8
01ed53b4  6dfbb897  bl       #0xd14168 ; unresolved symbol
01ed53b8  fd7b41a9  ldp      x29, x30, [sp, #0x10]
01ed53bc  60fe60d3  lsr      x0, x19, #0x20
01ed53c0  f44fc2a8  ldp      x20, x19, [sp], #0x20
01ed53c4  c0035fd6  ret      
