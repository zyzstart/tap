; RVA 0x1753768, file offset 0x1753768, conservative end 0x1753804
; SHA256 f2b0ce7cf29791cd3d31c349cf62177ef94f36899d8c098dcaeef5148ee8991e
; All aliases at this entry: A3BattleCore.ActorAttrImpactData$$Clone :: A3BattleCore_ActorAttrImpactData_o* A3BattleCore_ActorAttrImpactData__Clone (A3BattleCore_ActorAttrImpactData_o* __this, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01753768  f70f1cf8  str      x23, [sp, #-0x40]!
0175376c  f65701a9  stp      x22, x21, [sp, #0x10]
01753770  f44f02a9  stp      x20, x19, [sp, #0x20]
01753774  fd7b03a9  stp      x29, x30, [sp, #0x30]
01753778  fdc30091  add      x29, sp, #0x30
0175377c  74bf00b0  adrp     x20, #0x2f40000
01753780  88c65639  ldrb     w8, [x20, #0x5b1]
01753784  f30300aa  mov      x19, x0
01753788  e8000037  tbnz     w8, #0, #0x17537a4
0175378c  88a900d0  adrp     x8, #0x2c85000
01753790  08dd46f9  ldr      x8, [x8, #0xdb8]
01753794  000140b9  ldr      w0, [x8]
01753798  e4c5d697  bl       #0xd04f28 ; unresolved symbol
0175379c  e8030032  mov      w8, #1
017537a0  88c61639  strb     w8, [x20, #0x5b1]
017537a4  e8aa0090  adrp     x8, #0x2caf000
017537a8  08b143f9  ldr      x8, [x8, #0x760]
017537ac  000140f9  ldr      x0, [x8]
017537b0  7294d797  bl       #0xd38978 ; unresolved symbol
017537b4  f40300aa  mov      x20, x0
017537b8  83fcff97  bl       #0x17529c4 ; A3BattleCore.ActorAttrImpactData$$.ctor
017537bc  775a4329  ldp      w23, w22, [x19, #0x18]
017537c0  751240f9  ldr      x21, [x19, #0x20]
017537c4  740000b5  cbnz     x20, #0x17537d0
017537c8  e0031faa  mov      x0, xzr
017537cc  d85fd797  bl       #0xd2b72c ; unresolved symbol
017537d0  975a0329  stp      w23, w22, [x20, #0x18]
017537d4  951200f9  str      x21, [x20, #0x20]
017537d8  732a40b9  ldr      w19, [x19, #0x28]
017537dc  740000b5  cbnz     x20, #0x17537e8
017537e0  e0031faa  mov      x0, xzr
017537e4  d25fd797  bl       #0xd2b72c ; unresolved symbol
017537e8  932a00b9  str      w19, [x20, #0x28]
017537ec  e00314aa  mov      x0, x20
017537f0  fd7b43a9  ldp      x29, x30, [sp, #0x30]
017537f4  f44f42a9  ldp      x20, x19, [sp, #0x20]
017537f8  f65741a9  ldp      x22, x21, [sp, #0x10]
017537fc  f70744f8  ldr      x23, [sp], #0x40
01753800  c0035fd6  ret      
