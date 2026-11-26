; RVA 0x1ed4a3c, file offset 0x1ed4a3c, conservative end 0x1ed4ac4
; SHA256 f99854e9efc45f39c2e5f556589f0b828ecfbee77d56ed05d3bb4905c282de0a
; All aliases at this entry: BattleCore.FP$$Cos :: BattleCore_FP_o BattleCore_FP__Cos (BattleCore_FP_o x, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed4a3c  f44fbea9  stp      x20, x19, [sp, #-0x20]!
01ed4a40  fd7b01a9  stp      x29, x30, [sp, #0x10]
01ed4a44  fd430091  add      x29, sp, #0x10
01ed4a48  94830090  adrp     x20, #0x2f44000
01ed4a4c  88ea7e39  ldrb     w8, [x20, #0xfba]
01ed4a50  f30300aa  mov      x19, x0
01ed4a54  e8000037  tbnz     w8, #0, #0x1ed4a70
01ed4a58  287000f0  adrp     x8, #0x2cdb000
01ed4a5c  08b546f9  ldr      x8, [x8, #0xd68]
01ed4a60  000140b9  ldr      w0, [x8]
01ed4a64  31c1b897  bl       #0xd04f28 ; unresolved symbol
01ed4a68  e8030032  mov      w8, #1
01ed4a6c  88ea3e39  strb     w8, [x20, #0xfba]
01ed4a70  486f00b0  adrp     x8, #0x2cbd000
01ed4a74  08dd47f9  ldr      x8, [x8, #0xfb8]
01ed4a78  89a896d2  mov      x9, #0xb544
01ed4a7c  6af98392  mov      x10, #-0x1fcc
01ed4a80  e943b2f2  movk     x9, #0x921f, lsl #16
01ed4a84  000140f9  ldr      x0, [x8]
01ed4a88  0a34a9f2  movk     x10, #0x49a0, lsl #16
01ed4a8c  7f0200f1  cmp      x19, #0
01ed4a90  2900c0f2  movk     x9, #1, lsl #32
01ed4a94  089c4439  ldrb     w8, [x0, #0x127]
01ed4a98  6affdff2  movk     x10, #0xfffb, lsl #32
01ed4a9c  49c1899a  csel     x9, x10, x9, gt
01ed4aa0  3301138b  add      x19, x9, x19
01ed4aa4  88000836  tbz      w8, #1, #0x1ed4ab4
01ed4aa8  08d840b9  ldr      w8, [x0, #0xd8]
01ed4aac  48000035  cbnz     w8, #0x1ed4ab4
01ed4ab0  aefdb897  bl       #0xd14168 ; unresolved symbol
01ed4ab4  fd7b41a9  ldp      x29, x30, [sp, #0x10]
01ed4ab8  e00313aa  mov      x0, x19
01ed4abc  f44fc2a8  ldp      x20, x19, [sp], #0x20
01ed4ac0  befeff17  b        #0x1ed45b8 ; BattleCore.FP$$Sin
