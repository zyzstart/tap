; RVA 0x16a0bf4, file offset 0x16a0bf4, conservative end 0x16a0c60
; SHA256 ec9bbf5a79d2b1c315294c0f41a42ee4b49e13948807c84d3f7a57f1faf95b2a
; All aliases at this entry: A3BattleCore.SkillDamageHelper$$.cctor :: void A3BattleCore_SkillDamageHelper___cctor (const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
016a0bf4  f30f1ef8  str      x19, [sp, #-0x20]!
016a0bf8  fd7b01a9  stp      x29, x30, [sp, #0x10]
016a0bfc  fd430091  add      x29, sp, #0x10
016a0c00  f3c400f0  adrp     x19, #0x2f3f000
016a0c04  68227c39  ldrb     w8, [x19, #0xf08]
016a0c08  e8000037  tbnz     w8, #0, #0x16a0c24
016a0c0c  48b100f0  adrp     x8, #0x2ccb000
016a0c10  082146f9  ldr      x8, [x8, #0xc40]
016a0c14  000140b9  ldr      w0, [x8]
016a0c18  c490d997  bl       #0xd04f28 ; unresolved symbol
016a0c1c  e8030032  mov      w8, #1
016a0c20  68223c39  strb     w8, [x19, #0xf08]
016a0c24  28b100d0  adrp     x8, #0x2cc6000
016a0c28  080943f9  ldr      x8, [x8, #0x610]
016a0c2c  000140f9  ldr      x0, [x8]
016a0c30  525fda97  bl       #0xd38978 ; unresolved symbol
016a0c34  e1031faa  mov      x1, xzr
016a0c38  f30300aa  mov      x19, x0
016a0c3c  45ca0294  bl       #0x1753550 ; A3BattleCore.ActorAttrData$$.ctor
016a0c40  28b10090  adrp     x8, #0x2cc4000
016a0c44  08f946f9  ldr      x8, [x8, #0xdf0]
016a0c48  080140f9  ldr      x8, [x8]
016a0c4c  085d40f9  ldr      x8, [x8, #0xb8]
016a0c50  130100f9  str      x19, [x8]
016a0c54  fd7b41a9  ldp      x29, x30, [sp, #0x10]
016a0c58  f30742f8  ldr      x19, [sp], #0x20
016a0c5c  c0035fd6  ret      
