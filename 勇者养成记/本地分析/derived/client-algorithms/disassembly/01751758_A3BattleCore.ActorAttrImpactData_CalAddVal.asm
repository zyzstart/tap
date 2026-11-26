; RVA 0x1751758, file offset 0x1751758, conservative end 0x175183c
; SHA256 b755bcf5cf90ed8c1053a9010bc7c3aa27c3a71f76f2e6c3685407cec88721e2
; All aliases at this entry: A3BattleCore.ActorAttrImpactData$$CalAddVal :: BattleCore_FP_o A3BattleCore_ActorAttrImpactData__CalAddVal (A3BattleCore_ActorAttrImpactData_o* __this, BattleCore_FP_o baseVal, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01751758  f50f1df8  str      x21, [sp, #-0x30]!
0175175c  f44f01a9  stp      x20, x19, [sp, #0x10]
01751760  fd7b02a9  stp      x29, x30, [sp, #0x20]
01751764  fd830091  add      x29, sp, #0x20
01751768  75bf00f0  adrp     x21, #0x2f40000
0175176c  a8be5639  ldrb     w8, [x21, #0x5af]
01751770  f30301aa  mov      x19, x1
01751774  f40300aa  mov      x20, x0
01751778  e8000037  tbnz     w8, #0, #0x1751794
0175177c  28aa00f0  adrp     x8, #0x2c98000
01751780  085147f9  ldr      x8, [x8, #0xea0]
01751784  000140b9  ldr      w0, [x8]
01751788  e8cdd697  bl       #0xd04f28 ; unresolved symbol
0175178c  e8030032  mov      w8, #1
01751790  a8be1639  strb     w8, [x21, #0x5af]
01751794  881a40b9  ldr      w8, [x20, #0x18]
01751798  09090051  sub      w9, w8, #2
0175179c  3f090071  cmp      w9, #2
017517a0  c2020054  b.hs     #0x17517f8
017517a4  68ab0090  adrp     x8, #0x2cbd000
017517a8  08dd47f9  ldr      x8, [x8, #0xfb8]
017517ac  941240f9  ldr      x20, [x20, #0x20]
017517b0  000140f9  ldr      x0, [x8]
017517b4  089c4439  ldrb     w8, [x0, #0x127]
017517b8  88000836  tbz      w8, #1, #0x17517c8
017517bc  08d840b9  ldr      w8, [x0, #0xd8]
017517c0  48000035  cbnz     w8, #0x17517c8
017517c4  690ad797  bl       #0xd14168 ; unresolved symbol
017517c8  e00313aa  mov      x0, x19
017517cc  e10314aa  mov      x1, x20
017517d0  e2031faa  mov      x2, xzr
017517d4  150a1e94  bl       #0x1ed4028 ; BattleCore.FP$$op_Multiply
017517d8  f40300aa  mov      x20, x0
017517dc  e00313aa  mov      x0, x19
017517e0  e10314aa  mov      x1, x20
017517e4  fd7b42a9  ldp      x29, x30, [sp, #0x20]
017517e8  f44f41a9  ldp      x20, x19, [sp, #0x10]
017517ec  e2031faa  mov      x2, xzr
017517f0  f50743f8  ldr      x21, [sp], #0x30
017517f4  d8091e14  b        #0x1ed3f54 ; BattleCore.FP$$op_Addition
017517f8  1f050071  cmp      w8, #1
017517fc  61010054  b.ne     #0x1751828
01751800  68ab0090  adrp     x8, #0x2cbd000
01751804  08dd47f9  ldr      x8, [x8, #0xfb8]
01751808  941240f9  ldr      x20, [x20, #0x20]
0175180c  000140f9  ldr      x0, [x8]
01751810  089c4439  ldrb     w8, [x0, #0x127]
01751814  48fe0f36  tbz      w8, #1, #0x17517dc
01751818  08d840b9  ldr      w8, [x0, #0xd8]
0175181c  08feff35  cbnz     w8, #0x17517dc
01751820  520ad797  bl       #0xd14168 ; unresolved symbol
01751824  eeffff17  b        #0x17517dc
01751828  e00313aa  mov      x0, x19
0175182c  fd7b42a9  ldp      x29, x30, [sp, #0x20]
01751830  f44f41a9  ldp      x20, x19, [sp, #0x10]
01751834  f50743f8  ldr      x21, [sp], #0x30
01751838  c0035fd6  ret      
