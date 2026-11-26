; RVA 0x1ed54a8, file offset 0x1ed54a8, conservative end 0x1ed5550
; SHA256 0624b5c2ce163736dbdf38a6625c68bcd9a0b4c9b72f8334165702e0b90272a3
; All aliases at this entry: BattleCore.FP$$Equals_body_via_thunk :: inferred concrete unboxed entry from add x0,#0x10; b immediate
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed54a8  f50f1df8  str      x21, [sp, #-0x30]!
01ed54ac  f44f01a9  stp      x20, x19, [sp, #0x10]
01ed54b0  fd7b02a9  stp      x29, x30, [sp, #0x20]
01ed54b4  fd830091  add      x29, sp, #0x20
01ed54b8  758300f0  adrp     x21, #0x2f44000
01ed54bc  a80e7f39  ldrb     w8, [x21, #0xfc3]
01ed54c0  f40301aa  mov      x20, x1
01ed54c4  f30300aa  mov      x19, x0
01ed54c8  e8000037  tbnz     w8, #0, #0x1ed54e4
01ed54cc  e86d00f0  adrp     x8, #0x2c94000
01ed54d0  08d546f9  ldr      x8, [x8, #0xda8]
01ed54d4  000140b9  ldr      w0, [x8]
01ed54d8  94beb897  bl       #0xd04f28 ; unresolved symbol
01ed54dc  e8030032  mov      w8, #1
01ed54e0  a80e3f39  strb     w8, [x21, #0xfc3]
01ed54e4  f40000b4  cbz      x20, #0x1ed5500
01ed54e8  486f0090  adrp     x8, #0x2cbd000
01ed54ec  08dd47f9  ldr      x8, [x8, #0xfb8]
01ed54f0  890240f9  ldr      x9, [x20]
01ed54f4  080140f9  ldr      x8, [x8]
01ed54f8  3f0108eb  cmp      x9, x8
01ed54fc  60000054  b.eq     #0x1ed5508
01ed5500  e0031f2a  mov      w0, wzr
01ed5504  07000014  b        #0x1ed5520
01ed5508  e00314aa  mov      x0, x20
01ed550c  428eb997  bl       #0xd38e14 ; unresolved symbol
01ed5510  080040f9  ldr      x8, [x0]
01ed5514  690240f9  ldr      x9, [x19]
01ed5518  1f0109eb  cmp      x8, x9
01ed551c  e0179f1a  cset     w0, eq
01ed5520  fd7b42a9  ldp      x29, x30, [sp, #0x20]
01ed5524  f44f41a9  ldp      x20, x19, [sp, #0x10]
01ed5528  f50743f8  ldr      x21, [sp], #0x30
01ed552c  c0035fd6  ret      
01ed5530  e1031faa  mov      x1, xzr
01ed5534  12b7f817  b        #0x1d0317c ; unresolved symbol
01ed5538  080040f9  ldr      x8, [x0]
01ed553c  1f0101eb  cmp      x8, x1
01ed5540  e0179f1a  cset     w0, eq
01ed5544  c0035fd6  ret      
01ed5548  e2031faa  mov      x2, xzr
01ed554c  0fb7f817  b        #0x1d03188 ; unresolved symbol
