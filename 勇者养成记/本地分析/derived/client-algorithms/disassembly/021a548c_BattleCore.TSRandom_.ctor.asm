; RVA 0x21a548c, file offset 0x21a548c, conservative end 0x21a5550
; SHA256 068446d83cd6ae94ed78185897557c02e50333b35e6beb74f01abbf2b02443b5
; All aliases at this entry: BattleCore.TSRandom$$.ctor :: void BattleCore_TSRandom___ctor (BattleCore_TSRandom_o* __this, int32_t seed, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
021a548c  f657bda9  stp      x22, x21, [sp, #-0x30]!
021a5490  f44f01a9  stp      x20, x19, [sp, #0x10]
021a5494  fd7b02a9  stp      x29, x30, [sp, #0x20]
021a5498  fd830091  add      x29, sp, #0x20
021a549c  156d00b0  adrp     x21, #0x2f46000
021a54a0  a88a5f39  ldrb     w8, [x21, #0x7e2]
021a54a4  f303012a  mov      w19, w1
021a54a8  f40300aa  mov      x20, x0
021a54ac  e8000037  tbnz     w8, #0, #0x21a54c8
021a54b0  285700f0  adrp     x8, #0x2c8c000
021a54b4  084147f9  ldr      x8, [x8, #0xe80]
021a54b8  000140b9  ldr      w0, [x8]
021a54bc  9b7ead97  bl       #0xd04f28 ; unresolved symbol
021a54c0  e8030032  mov      w8, #1
021a54c4  a88a1f39  strb     w8, [x21, #0x7e2]
021a54c8  d6570090  adrp     x22, #0x2c9d000
021a54cc  d65a43f9  ldr      x22, [x22, #0x6b0]
021a54d0  e1031f32  mov      w1, #2
021a54d4  c00240f9  ldr      x0, [x22]
021a54d8  2863ae97  bl       #0xd3e178 ; unresolved symbol
021a54dc  f50300aa  mov      x21, x0
021a54e0  550000b5  cbnz     x21, #0x21a54e8
021a54e4  9218ae97  bl       #0xd2b72c ; unresolved symbol
021a54e8  a81a40b9  ldr      w8, [x21, #0x18]
021a54ec  1f050071  cmp      w8, #1
021a54f0  a8000054  b.hi     #0x21a5504
021a54f4  c71bae97  bl       #0xd2c410 ; unresolved symbol
021a54f8  e1031faa  mov      x1, xzr
021a54fc  e2031faa  mov      x2, xzr
021a5500  6718ae97  bl       #0xd2b69c ; unresolved symbol
021a5504  e81b9652  mov      w8, #0xb0df
021a5508  0821b372  movk     w8, #0x9908, lsl #16
021a550c  a82600b9  str      w8, [x21, #0x24]
021a5510  950a00f9  str      x21, [x20, #0x10]
021a5514  c00240f9  ldr      x0, [x22]
021a5518  014e8052  mov      w1, #0x270
021a551c  1763ae97  bl       #0xd3e178 ; unresolved symbol
021a5520  800e00f9  str      x0, [x20, #0x18]
021a5524  284e8052  mov      w8, #0x271
021a5528  e00314aa  mov      x0, x20
021a552c  e1031faa  mov      x1, xzr
021a5530  882200b9  str      w8, [x20, #0x20]
021a5534  1e9ee197  bl       #0x1a0cdac ; System.Object$$.ctor
021a5538  e00314aa  mov      x0, x20
021a553c  e103132a  mov      w1, w19
021a5540  fd7b42a9  ldp      x29, x30, [sp, #0x20]
021a5544  f44f41a9  ldp      x20, x19, [sp, #0x10]
021a5548  f657c3a8  ldp      x22, x21, [sp], #0x30
021a554c  01000014  b        #0x21a5550 ; BattleCore.TSRandom$$init_genrand
