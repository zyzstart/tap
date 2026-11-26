; RVA 0x17539b0, file offset 0x17539b0, conservative end 0x1753a30
; SHA256 56255a7fb20c31b6becee793047f75d94cce03bb3af567cf85ad346b2fda1fbf
; All aliases at this entry: A3BattleCore.ActorAttrImpactMgr$$AddAttrImpact :: void A3BattleCore_ActorAttrImpactMgr__AddAttrImpact (A3BattleCore_ActorAttrImpactMgr_o* __this, BattleCore_ResAttrImpactData_o* resData, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
017539b0  f50f1df8  str      x21, [sp, #-0x30]!
017539b4  f44f01a9  stp      x20, x19, [sp, #0x10]
017539b8  fd7b02a9  stp      x29, x30, [sp, #0x20]
017539bc  fd830091  add      x29, sp, #0x20
017539c0  75bf00b0  adrp     x21, #0x2f40000
017539c4  a8da5639  ldrb     w8, [x21, #0x5b6]
017539c8  f30301aa  mov      x19, x1
017539cc  f40300aa  mov      x20, x0
017539d0  e8000037  tbnz     w8, #0, #0x17539ec
017539d4  48ae00d0  adrp     x8, #0x2d1d000
017539d8  08c144f9  ldr      x8, [x8, #0x980]
017539dc  000140b9  ldr      w0, [x8]
017539e0  52c5d697  bl       #0xd04f28 ; unresolved symbol
017539e4  e8030032  mov      w8, #1
017539e8  a8da1639  strb     w8, [x21, #0x5b6]
017539ec  55ab00d0  adrp     x21, #0x2cbd000
017539f0  b5de47f9  ldr      x21, [x21, #0xfb8]
017539f4  a00240f9  ldr      x0, [x21]
017539f8  089c4439  ldrb     w8, [x0, #0x127]
017539fc  a8000836  tbz      w8, #1, #0x1753a10
01753a00  08d840b9  ldr      w8, [x0, #0xd8]
01753a04  68000035  cbnz     w8, #0x1753a10
01753a08  d801d797  bl       #0xd14168 ; unresolved symbol
01753a0c  a00240f9  ldr      x0, [x21]
01753a10  085c40f9  ldr      x8, [x0, #0xb8]
01753a14  e00314aa  mov      x0, x20
01753a18  e10313aa  mov      x1, x19
01753a1c  fd7b42a9  ldp      x29, x30, [sp, #0x20]
01753a20  021940f9  ldr      x2, [x8, #0x30]
01753a24  f44f41a9  ldp      x20, x19, [sp, #0x10]
01753a28  f50743f8  ldr      x21, [sp], #0x30
01753a2c  01000014  b        #0x1753a30 ; A3BattleCore.ActorAttrImpactMgr$$AddAttrImpact
