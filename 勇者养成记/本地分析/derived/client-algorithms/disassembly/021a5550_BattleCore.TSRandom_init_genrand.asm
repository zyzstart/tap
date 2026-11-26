; RVA 0x21a5550, file offset 0x21a5550, conservative end 0x21a56b8
; SHA256 ee647663b4133f576c3cb8e3533549c3f7a5380aa3f16c2f376cd7f67cca3ddb
; All aliases at this entry: BattleCore.TSRandom$$init_genrand :: void BattleCore_TSRandom__init_genrand (BattleCore_TSRandom_o* __this, uint32_t s, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
021a5550  f90f1bf8  str      x25, [sp, #-0x50]!
021a5554  f85f01a9  stp      x24, x23, [sp, #0x10]
021a5558  f65702a9  stp      x22, x21, [sp, #0x20]
021a555c  f44f03a9  stp      x20, x19, [sp, #0x30]
021a5560  fd7b04a9  stp      x29, x30, [sp, #0x40]
021a5564  fd030191  add      x29, sp, #0x40
021a5568  f30300aa  mov      x19, x0
021a556c  750e40f9  ldr      x21, [x19, #0x18]
021a5570  f403012a  mov      w20, w1
021a5574  750000b5  cbnz     x21, #0x21a5580
021a5578  e0031faa  mov      x0, xzr
021a557c  6c18ae97  bl       #0xd2b72c ; unresolved symbol
021a5580  a81a40b9  ldr      w8, [x21, #0x18]
021a5584  a8000035  cbnz     w8, #0x21a5598
021a5588  a21bae97  bl       #0xd2c410 ; unresolved symbol
021a558c  e1031faa  mov      x1, xzr
021a5590  e2031faa  mov      x2, xzr
021a5594  4218ae97  bl       #0xd2b69c ; unresolved symbol
021a5598  b42200b9  str      w20, [x21, #0x20]
021a559c  b42c9152  mov      w20, #0x8965
021a55a0  f6030032  mov      w22, #1
021a55a4  f480ad72  movk     w20, #0x6c07, lsl #16
021a55a8  762200b9  str      w22, [x19, #0x20]
021a55ac  750e40f9  ldr      x21, [x19, #0x18]
021a55b0  750000b5  cbnz     x21, #0x21a55bc
021a55b4  e0031faa  mov      x0, xzr
021a55b8  5d18ae97  bl       #0xd2b72c ; unresolved symbol
021a55bc  a81a40b9  ldr      w8, [x21, #0x18]
021a55c0  c9060051  sub      w9, w22, #1
021a55c4  377d4093  sxtw     x23, w9
021a55c8  3f01086b  cmp      w9, w8
021a55cc  a3000054  b.lo     #0x21a55e0
021a55d0  901bae97  bl       #0xd2c410 ; unresolved symbol
021a55d4  e1031faa  mov      x1, xzr
021a55d8  e2031faa  mov      x2, xzr
021a55dc  3018ae97  bl       #0xd2b69c ; unresolved symbol
021a55e0  a80a178b  add      x8, x21, x23, lsl #2
021a55e4  780e40f9  ldr      x24, [x19, #0x18]
021a55e8  172140b9  ldr      w23, [x8, #0x20]
021a55ec  792240b9  ldr      w25, [x19, #0x20]
021a55f0  780000b5  cbnz     x24, #0x21a55fc
021a55f4  e0031faa  mov      x0, xzr
021a55f8  4d18ae97  bl       #0xd2b72c ; unresolved symbol
021a55fc  081b40b9  ldr      w8, [x24, #0x18]
021a5600  29070051  sub      w9, w25, #1
021a5604  397d4093  sxtw     x25, w9
021a5608  3f01086b  cmp      w9, w8
021a560c  a3000054  b.lo     #0x21a5620
021a5610  801bae97  bl       #0xd2c410 ; unresolved symbol
021a5614  e1031faa  mov      x1, xzr
021a5618  e2031faa  mov      x2, xzr
021a561c  2018ae97  bl       #0xd2b69c ; unresolved symbol
021a5620  080b198b  add      x8, x24, x25, lsl #2
021a5624  082140b9  ldr      w8, [x8, #0x20]
021a5628  a91a40b9  ldr      w9, [x21, #0x18]
021a562c  6a2240b9  ldr      w10, [x19, #0x20]
021a5630  d87e4093  sxtw     x24, w22
021a5634  e87a484a  eor      w8, w23, w8, lsr #30
021a5638  df02096b  cmp      w22, w9
021a563c  1629141b  madd     w22, w8, w20, w10
021a5640  a3000054  b.lo     #0x21a5654
021a5644  731bae97  bl       #0xd2c410 ; unresolved symbol
021a5648  e1031faa  mov      x1, xzr
021a564c  e2031faa  mov      x2, xzr
021a5650  1318ae97  bl       #0xd2b69c ; unresolved symbol
021a5654  a80a188b  add      x8, x21, x24, lsl #2
021a5658  162100b9  str      w22, [x8, #0x20]
021a565c  750e40f9  ldr      x21, [x19, #0x18]
021a5660  762240b9  ldr      w22, [x19, #0x20]
021a5664  750000b5  cbnz     x21, #0x21a5670
021a5668  e0031faa  mov      x0, xzr
021a566c  3018ae97  bl       #0xd2b72c ; unresolved symbol
021a5670  a81a40b9  ldr      w8, [x21, #0x18]
021a5674  df02086b  cmp      w22, w8
021a5678  a3000054  b.lo     #0x21a568c
021a567c  651bae97  bl       #0xd2c410 ; unresolved symbol
021a5680  e1031faa  mov      x1, xzr
021a5684  e2031faa  mov      x2, xzr
021a5688  0518ae97  bl       #0xd2b69c ; unresolved symbol
021a568c  682240b9  ldr      w8, [x19, #0x20]
021a5690  16050011  add      w22, w8, #1
021a5694  dfc20971  cmp      w22, #0x270
021a5698  762200b9  str      w22, [x19, #0x20]
021a569c  8bf8ff54  b.lt     #0x21a55ac
021a56a0  fd7b44a9  ldp      x29, x30, [sp, #0x40]
021a56a4  f44f43a9  ldp      x20, x19, [sp, #0x30]
021a56a8  f65742a9  ldp      x22, x21, [sp, #0x20]
021a56ac  f85f41a9  ldp      x24, x23, [sp, #0x10]
021a56b0  f90745f8  ldr      x25, [sp], #0x50
021a56b4  c0035fd6  ret      
