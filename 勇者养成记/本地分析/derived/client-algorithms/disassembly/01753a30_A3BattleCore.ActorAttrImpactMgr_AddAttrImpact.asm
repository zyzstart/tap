; RVA 0x1753a30, file offset 0x1753a30, conservative end 0x1753b34
; SHA256 a8430c0f679bd5ac23d931a48954b6b654dbb439fc0b2f46625672505caaa117
; All aliases at this entry: A3BattleCore.ActorAttrImpactMgr$$AddAttrImpact :: void A3BattleCore_ActorAttrImpactMgr__AddAttrImpact (A3BattleCore_ActorAttrImpactMgr_o* __this, BattleCore_ResAttrImpactData_o* resData, BattleCore_FP_o additveVal, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01753a30  f70f1cf8  str      x23, [sp, #-0x40]!
01753a34  f65701a9  stp      x22, x21, [sp, #0x10]
01753a38  f44f02a9  stp      x20, x19, [sp, #0x20]
01753a3c  fd7b03a9  stp      x29, x30, [sp, #0x30]
01753a40  fdc30091  add      x29, sp, #0x30
01753a44  76bf00b0  adrp     x22, #0x2f40000
01753a48  c8de5639  ldrb     w8, [x22, #0x5b7]
01753a4c  f40302aa  mov      x20, x2
01753a50  f50301aa  mov      x21, x1
01753a54  f30300aa  mov      x19, x0
01753a58  e8000037  tbnz     w8, #0, #0x1753a74
01753a5c  68ae0090  adrp     x8, #0x2d1f000
01753a60  082545f9  ldr      x8, [x8, #0xa48]
01753a64  000140b9  ldr      w0, [x8]
01753a68  30c5d697  bl       #0xd04f28 ; unresolved symbol
01753a6c  e8030032  mov      w8, #1
01753a70  c8de1639  strb     w8, [x22, #0x5b7]
01753a74  750000b5  cbnz     x21, #0x1753a80
01753a78  e0031faa  mov      x0, xzr
01753a7c  2c5fd797  bl       #0xd2b72c ; unresolved symbol
01753a80  a8224079  ldrh     w8, [x21, #0x10]
01753a84  28020034  cbz      w8, #0x1753ac8
01753a88  57ab00d0  adrp     x23, #0x2cbd000
01753a8c  f7de47f9  ldr      x23, [x23, #0xfb8]
01753a90  b60e40f9  ldr      x22, [x21, #0x18]
01753a94  e00240f9  ldr      x0, [x23]
01753a98  089c4439  ldrb     w8, [x0, #0x127]
01753a9c  a8000836  tbz      w8, #1, #0x1753ab0
01753aa0  08d840b9  ldr      w8, [x0, #0xd8]
01753aa4  68000035  cbnz     w8, #0x1753ab0
01753aa8  b001d797  bl       #0xd14168 ; unresolved symbol
01753aac  e00240f9  ldr      x0, [x23]
01753ab0  085c40f9  ldr      x8, [x0, #0xb8]
01753ab4  e00316aa  mov      x0, x22
01753ab8  e2031faa  mov      x2, xzr
01753abc  011940f9  ldr      x1, [x8, #0x30]
01753ac0  5e021e94  bl       #0x1ed4438 ; BattleCore.FP$$op_Equality
01753ac4  c0000036  tbz      w0, #0, #0x1753adc
01753ac8  fd7b43a9  ldp      x29, x30, [sp, #0x30]
01753acc  f44f42a9  ldp      x20, x19, [sp, #0x20]
01753ad0  f65741a9  ldp      x22, x21, [sp, #0x10]
01753ad4  f70744f8  ldr      x23, [sp], #0x40
01753ad8  c0035fd6  ret      
01753adc  e00240f9  ldr      x0, [x23]
01753ae0  b722c079  ldrsh    w23, [x21, #0x10]
01753ae4  b64a4039  ldrb     w22, [x21, #0x12]
01753ae8  b50e40f9  ldr      x21, [x21, #0x18]
01753aec  089c4439  ldrb     w8, [x0, #0x127]
01753af0  88000836  tbz      w8, #1, #0x1753b00
01753af4  08d840b9  ldr      w8, [x0, #0xd8]
01753af8  48000035  cbnz     w8, #0x1753b00
01753afc  9b01d797  bl       #0xd14168 ; unresolved symbol
01753b00  e00315aa  mov      x0, x21
01753b04  e10314aa  mov      x1, x20
01753b08  e2031faa  mov      x2, xzr
01753b0c  12011e94  bl       #0x1ed3f54 ; BattleCore.FP$$op_Addition
01753b10  e30300aa  mov      x3, x0
01753b14  e00313aa  mov      x0, x19
01753b18  e203162a  mov      w2, w22
01753b1c  fd7b43a9  ldp      x29, x30, [sp, #0x30]
01753b20  f44f42a9  ldp      x20, x19, [sp, #0x20]
01753b24  f65741a9  ldp      x22, x21, [sp, #0x10]
01753b28  e103172a  mov      w1, w23
01753b2c  f70744f8  ldr      x23, [sp], #0x40
01753b30  76ffff17  b        #0x1753908 ; A3BattleCore.ActorAttrImpactMgr$$AddAttrImpact
