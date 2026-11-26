; RVA 0x1753908, file offset 0x1753908, conservative end 0x17539b0
; SHA256 065292031b7eee34dc785d6bbbb26e08f48e775c85b098582c65dfbe415dae9f
; All aliases at this entry: A3BattleCore.ActorAttrImpactMgr$$AddAttrImpact :: void A3BattleCore_ActorAttrImpactMgr__AddAttrImpact (A3BattleCore_ActorAttrImpactMgr_o* __this, int32_t dataType, int32_t addType, BattleCore_FP_o val, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01753908  f70f1cf8  str      x23, [sp, #-0x40]!
0175390c  f65701a9  stp      x22, x21, [sp, #0x10]
01753910  f44f02a9  stp      x20, x19, [sp, #0x20]
01753914  fd7b03a9  stp      x29, x30, [sp, #0x30]
01753918  fdc30091  add      x29, sp, #0x30
0175391c  77bf00b0  adrp     x23, #0x2f40000
01753920  e8d65639  ldrb     w8, [x23, #0x5b5]
01753924  f30303aa  mov      x19, x3
01753928  f503022a  mov      w21, w2
0175392c  f403012a  mov      w20, w1
01753930  f60300aa  mov      x22, x0
01753934  e8000037  tbnz     w8, #0, #0x1753950
01753938  a8ad00d0  adrp     x8, #0x2d09000
0175393c  082940f9  ldr      x8, [x8, #0x50]
01753940  000140b9  ldr      w0, [x8]
01753944  79c5d697  bl       #0xd04f28 ; unresolved symbol
01753948  e8030032  mov      w8, #1
0175394c  e8d61639  strb     w8, [x23, #0x5b5]
01753950  74020034  cbz      w20, #0x175399c
01753954  e8aa0090  adrp     x8, #0x2caf000
01753958  08b143f9  ldr      x8, [x8, #0x760]
0175395c  000140f9  ldr      x0, [x8]
01753960  0694d797  bl       #0xd38978 ; unresolved symbol
01753964  f70300aa  mov      x23, x0
01753968  17fcff97  bl       #0x17529c4 ; A3BattleCore.ActorAttrImpactData$$.ctor
0175396c  770000b5  cbnz     x23, #0x1753978
01753970  e0031faa  mov      x0, xzr
01753974  6e5fd797  bl       #0xd2b72c ; unresolved symbol
01753978  f5520329  stp      w21, w20, [x23, #0x18]
0175397c  f31200f9  str      x19, [x23, #0x20]
01753980  e00316aa  mov      x0, x22
01753984  fd7b43a9  ldp      x29, x30, [sp, #0x30]
01753988  f44f42a9  ldp      x20, x19, [sp, #0x20]
0175398c  f65741a9  ldp      x22, x21, [sp, #0x10]
01753990  e10317aa  mov      x1, x23
01753994  f70744f8  ldr      x23, [sp], #0x40
01753998  2cfcff17  b        #0x1752a48 ; A3BattleCore.ActorAttrImpactMgr$$MergeAttrImpact
0175399c  fd7b43a9  ldp      x29, x30, [sp, #0x30]
017539a0  f44f42a9  ldp      x20, x19, [sp, #0x20]
017539a4  f65741a9  ldp      x22, x21, [sp, #0x10]
017539a8  f70744f8  ldr      x23, [sp], #0x40
017539ac  c0035fd6  ret      
