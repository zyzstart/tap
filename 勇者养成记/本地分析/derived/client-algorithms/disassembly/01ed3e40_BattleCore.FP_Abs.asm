; RVA 0x1ed3e40, file offset 0x1ed3e40, conservative end 0x1ed3ec4
; SHA256 d04e28ddd31c5fb63b6bfc2a93894f37fc78e539793ec8994e1ccf0c33236fdf
; All aliases at this entry: BattleCore.FP$$Abs :: BattleCore_FP_o BattleCore_FP__Abs (BattleCore_FP_o value, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed3e40  f44fbea9  stp      x20, x19, [sp, #-0x20]!
01ed3e44  fd7b01a9  stp      x29, x30, [sp, #0x10]
01ed3e48  fd430091  add      x29, sp, #0x10
01ed3e4c  948300b0  adrp     x20, #0x2f44000
01ed3e50  88c67e39  ldrb     w8, [x20, #0xfb1]
01ed3e54  f30300aa  mov      x19, x0
01ed3e58  e8000037  tbnz     w8, #0, #0x1ed3e74
01ed3e5c  08700090  adrp     x8, #0x2cd3000
01ed3e60  089943f9  ldr      x8, [x8, #0x730]
01ed3e64  000140b9  ldr      w0, [x8]
01ed3e68  30c4b897  bl       #0xd04f28 ; unresolved symbol
01ed3e6c  e8030032  mov      w8, #1
01ed3e70  88c63e39  strb     w8, [x20, #0xfb1]
01ed3e74  e80341b2  mov      x8, #-0x8000000000000000
01ed3e78  7f0208eb  cmp      x19, x8
01ed3e7c  a1010054  b.ne     #0x1ed3eb0
01ed3e80  536f00d0  adrp     x19, #0x2cbd000
01ed3e84  73de47f9  ldr      x19, [x19, #0xfb8]
01ed3e88  600240f9  ldr      x0, [x19]
01ed3e8c  089c4439  ldrb     w8, [x0, #0x127]
01ed3e90  a8000836  tbz      w8, #1, #0x1ed3ea4
01ed3e94  08d840b9  ldr      w8, [x0, #0xd8]
01ed3e98  68000035  cbnz     w8, #0x1ed3ea4
01ed3e9c  b300b997  bl       #0xd14168 ; unresolved symbol
01ed3ea0  600240f9  ldr      x0, [x19]
01ed3ea4  085c40f9  ldr      x8, [x0, #0xb8]
01ed3ea8  000540f9  ldr      x0, [x8, #8]
01ed3eac  03000014  b        #0x1ed3eb8
01ed3eb0  68fe938b  add      x8, x19, x19, asr #63
01ed3eb4  00fd93ca  eor      x0, x8, x19, asr #63
01ed3eb8  fd7b41a9  ldp      x29, x30, [sp, #0x10]
01ed3ebc  f44fc2a8  ldp      x20, x19, [sp], #0x20
01ed3ec0  c0035fd6  ret      
