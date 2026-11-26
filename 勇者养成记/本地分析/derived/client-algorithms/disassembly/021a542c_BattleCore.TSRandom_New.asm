; RVA 0x21a542c, file offset 0x21a542c, conservative end 0x21a548c
; SHA256 95eade0ac6ae0c5c58d83576b0d90497bcfdf3fe06c55f702de6b061de8418f0
; All aliases at this entry: BattleCore.TSRandom$$New :: BattleCore_TSRandom_o* BattleCore_TSRandom__New (int32_t seed, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
021a542c  f44fbea9  stp      x20, x19, [sp, #-0x20]!
021a5430  fd7b01a9  stp      x29, x30, [sp, #0x10]
021a5434  fd430091  add      x29, sp, #0x10
021a5438  146d00b0  adrp     x20, #0x2f46000
021a543c  88865f39  ldrb     w8, [x20, #0x7e1]
021a5440  f303002a  mov      w19, w0
021a5444  e8000037  tbnz     w8, #0, #0x21a5460
021a5448  48560090  adrp     x8, #0x2c6d000
021a544c  08ed47f9  ldr      x8, [x8, #0xfd8]
021a5450  000140b9  ldr      w0, [x8]
021a5454  b57ead97  bl       #0xd04f28 ; unresolved symbol
021a5458  e8030032  mov      w8, #1
021a545c  88861f39  strb     w8, [x20, #0x7e1]
021a5460  685800b0  adrp     x8, #0x2cb2000
021a5464  08ed41f9  ldr      x8, [x8, #0x3d8]
021a5468  000140f9  ldr      x0, [x8]
021a546c  434dae97  bl       #0xd38978 ; unresolved symbol
021a5470  e103132a  mov      w1, w19
021a5474  f40300aa  mov      x20, x0
021a5478  05000094  bl       #0x21a548c ; BattleCore.TSRandom$$.ctor
021a547c  fd7b41a9  ldp      x29, x30, [sp, #0x10]
021a5480  e00314aa  mov      x0, x20
021a5484  f44fc2a8  ldp      x20, x19, [sp], #0x20
021a5488  c0035fd6  ret      
