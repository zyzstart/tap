; RVA 0x1ed49e4, file offset 0x1ed49e4, conservative end 0x1ed4a34
; SHA256 33ae855ce3fed13d90e889efadcaa9d11d2c08a4eb781903a1a488c7f99ba90d
; All aliases at this entry: BattleCore.FP$$get_SinLut :: System_Int64_array* BattleCore_FP__get_SinLut (const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed49e4  f30f1ef8  str      x19, [sp, #-0x20]!
01ed49e8  fd7b01a9  stp      x29, x30, [sp, #0x10]
01ed49ec  fd430091  add      x29, sp, #0x10
01ed49f0  93830090  adrp     x19, #0x2f44000
01ed49f4  68167f39  ldrb     w8, [x19, #0xfc5]
01ed49f8  e8000037  tbnz     w8, #0, #0x1ed4a14
01ed49fc  886e00b0  adrp     x8, #0x2ca5000
01ed4a00  087541f9  ldr      x8, [x8, #0x2e8]
01ed4a04  000140b9  ldr      w0, [x8]
01ed4a08  48c1b897  bl       #0xd04f28 ; unresolved symbol
01ed4a0c  e8030032  mov      w8, #1
01ed4a10  68163f39  strb     w8, [x19, #0xfc5]
01ed4a14  286d00d0  adrp     x8, #0x2c7a000
01ed4a18  080945f9  ldr      x8, [x8, #0xa10]
01ed4a1c  fd7b41a9  ldp      x29, x30, [sp, #0x10]
01ed4a20  080140f9  ldr      x8, [x8]
01ed4a24  085d40f9  ldr      x8, [x8, #0xb8]
01ed4a28  000140f9  ldr      x0, [x8]
01ed4a2c  f30742f8  ldr      x19, [sp], #0x20
01ed4a30  c0035fd6  ret      
