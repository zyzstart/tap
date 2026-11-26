; RVA 0x17525cc, file offset 0x17525cc, conservative end 0x1752804
; SHA256 6e24a5c66e1793f844fb22c9f1a68dfb6c847f6f57d9525c1da391757e129ea3
; All aliases at this entry: A3BattleCore.ActorAttrData$$GetAttrValue :: BattleCore_FP_o A3BattleCore_ActorAttrData__GetAttrValue (A3BattleCore_ActorAttrData_o* __this, int32_t type, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
017525cc  f50f1df8  str      x21, [sp, #-0x30]!
017525d0  f44f01a9  stp      x20, x19, [sp, #0x10]
017525d4  fd7b02a9  stp      x29, x30, [sp, #0x20]
017525d8  fd830091  add      x29, sp, #0x20
017525dc  75bf00d0  adrp     x21, #0x2f40000
017525e0  a89a5639  ldrb     w8, [x21, #0x5a6]
017525e4  f403012a  mov      w20, w1
017525e8  f30300aa  mov      x19, x0
017525ec  e8000037  tbnz     w8, #0, #0x1752608
017525f0  28aa00d0  adrp     x8, #0x2c98000
017525f4  088143f9  ldr      x8, [x8, #0x700]
017525f8  000140b9  ldr      w0, [x8]
017525fc  4bcad697  bl       #0xd04f28 ; unresolved symbol
01752600  e8030032  mov      w8, #1
01752604  a89a1639  strb     w8, [x21, #0x5a6]
01752608  55ab00f0  adrp     x21, #0x2cbd000
0175260c  b5de47f9  ldr      x21, [x21, #0xfb8]
01752610  a80240f9  ldr      x8, [x21]
01752614  099d4439  ldrb     w9, [x8, #0x127]
01752618  c9000836  tbz      w9, #1, #0x1752630
0175261c  09d940b9  ldr      w9, [x8, #0xd8]
01752620  89000035  cbnz     w9, #0x1752630
01752624  e00308aa  mov      x0, x8
01752628  d006d797  bl       #0xd14168 ; unresolved symbol
0175262c  a80240f9  ldr      x8, [x21]
01752630  095d40f9  ldr      x9, [x8, #0xb8]
01752634  201940f9  ldr      x0, [x9, #0x30]
01752638  89060051  sub      w9, w20, #1
0175263c  3f810171  cmp      w9, #0x60
01752640  a80d0054  b.hi     #0x17527f4
01752644  6a6200d0  adrp     x10, #0x23a0000
01752648  4a311391  add      x10, x10, #0x4cc
0175264c  4979a9b8  ldrsw    x9, [x10, x9, lsl #2]
01752650  29010a8b  add      x9, x9, x10
01752654  20011fd6  br       x9
01752658  099d4439  ldrb     w9, [x8, #0x127]
0175265c  731240b9  ldr      w19, [x19, #0x10]
01752660  a9000836  tbz      w9, #1, #0x1752674
01752664  09d940b9  ldr      w9, [x8, #0xd8]
01752668  69000035  cbnz     w9, #0x1752674
0175266c  e00308aa  mov      x0, x8
01752670  be06d797  bl       #0xd14168 ; unresolved symbol
01752674  e003132a  mov      w0, w19
01752678  e1031faa  mov      x1, xzr
0175267c  4d071e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752680  a80240f9  ldr      x8, [x21]
01752684  fd7b42a9  ldp      x29, x30, [sp, #0x20]
01752688  f44f41a9  ldp      x20, x19, [sp, #0x10]
0175268c  e2031faa  mov      x2, xzr
01752690  085d40f9  ldr      x8, [x8, #0xb8]
01752694  010d40f9  ldr      x1, [x8, #0x18]
01752698  f50743f8  ldr      x21, [sp], #0x30
0175269c  63061e14  b        #0x1ed4028 ; BattleCore.FP$$op_Multiply
017526a0  600e40f9  ldr      x0, [x19, #0x18]
017526a4  54000014  b        #0x17527f4
017526a8  601240f9  ldr      x0, [x19, #0x20]
017526ac  52000014  b        #0x17527f4
017526b0  601640f9  ldr      x0, [x19, #0x28]
017526b4  50000014  b        #0x17527f4
017526b8  601a40f9  ldr      x0, [x19, #0x30]
017526bc  4e000014  b        #0x17527f4
017526c0  601e40f9  ldr      x0, [x19, #0x38]
017526c4  4c000014  b        #0x17527f4
017526c8  602240f9  ldr      x0, [x19, #0x40]
017526cc  4a000014  b        #0x17527f4
017526d0  602640f9  ldr      x0, [x19, #0x48]
017526d4  48000014  b        #0x17527f4
017526d8  602a40f9  ldr      x0, [x19, #0x50]
017526dc  46000014  b        #0x17527f4
017526e0  602e40f9  ldr      x0, [x19, #0x58]
017526e4  44000014  b        #0x17527f4
017526e8  603240f9  ldr      x0, [x19, #0x60]
017526ec  42000014  b        #0x17527f4
017526f0  603640f9  ldr      x0, [x19, #0x68]
017526f4  40000014  b        #0x17527f4
017526f8  603a40f9  ldr      x0, [x19, #0x70]
017526fc  3e000014  b        #0x17527f4
01752700  603e40f9  ldr      x0, [x19, #0x78]
01752704  3c000014  b        #0x17527f4
01752708  604240f9  ldr      x0, [x19, #0x80]
0175270c  3a000014  b        #0x17527f4
01752710  604640f9  ldr      x0, [x19, #0x88]
01752714  38000014  b        #0x17527f4
01752718  605a40f9  ldr      x0, [x19, #0xb0]
0175271c  36000014  b        #0x17527f4
01752720  605e40f9  ldr      x0, [x19, #0xb8]
01752724  34000014  b        #0x17527f4
01752728  606240f9  ldr      x0, [x19, #0xc0]
0175272c  32000014  b        #0x17527f4
01752730  605640f9  ldr      x0, [x19, #0xa8]
01752734  30000014  b        #0x17527f4
01752738  604a40f9  ldr      x0, [x19, #0x90]
0175273c  2e000014  b        #0x17527f4
01752740  604e40f9  ldr      x0, [x19, #0x98]
01752744  2c000014  b        #0x17527f4
01752748  605240f9  ldr      x0, [x19, #0xa0]
0175274c  2a000014  b        #0x17527f4
01752750  606640f9  ldr      x0, [x19, #0xc8]
01752754  28000014  b        #0x17527f4
01752758  606a40f9  ldr      x0, [x19, #0xd0]
0175275c  26000014  b        #0x17527f4
01752760  606e40f9  ldr      x0, [x19, #0xd8]
01752764  24000014  b        #0x17527f4
01752768  607240f9  ldr      x0, [x19, #0xe0]
0175276c  22000014  b        #0x17527f4
01752770  607640f9  ldr      x0, [x19, #0xe8]
01752774  20000014  b        #0x17527f4
01752778  607a40f9  ldr      x0, [x19, #0xf0]
0175277c  1e000014  b        #0x17527f4
01752780  607e40f9  ldr      x0, [x19, #0xf8]
01752784  1c000014  b        #0x17527f4
01752788  608240f9  ldr      x0, [x19, #0x100]
0175278c  1a000014  b        #0x17527f4
01752790  608640f9  ldr      x0, [x19, #0x108]
01752794  18000014  b        #0x17527f4
01752798  604a41f9  ldr      x0, [x19, #0x290]
0175279c  16000014  b        #0x17527f4
017527a0  604e41f9  ldr      x0, [x19, #0x298]
017527a4  14000014  b        #0x17527f4
017527a8  605241f9  ldr      x0, [x19, #0x2a0]
017527ac  12000014  b        #0x17527f4
017527b0  605641f9  ldr      x0, [x19, #0x2a8]
017527b4  10000014  b        #0x17527f4
017527b8  605a41f9  ldr      x0, [x19, #0x2b0]
017527bc  0e000014  b        #0x17527f4
017527c0  605e41f9  ldr      x0, [x19, #0x2b8]
017527c4  0c000014  b        #0x17527f4
017527c8  606241f9  ldr      x0, [x19, #0x2c0]
017527cc  0a000014  b        #0x17527f4
017527d0  606641f9  ldr      x0, [x19, #0x2c8]
017527d4  08000014  b        #0x17527f4
017527d8  606a41f9  ldr      x0, [x19, #0x2d0]
017527dc  06000014  b        #0x17527f4
017527e0  606e41f9  ldr      x0, [x19, #0x2d8]
017527e4  04000014  b        #0x17527f4
017527e8  607241f9  ldr      x0, [x19, #0x2e0]
017527ec  02000014  b        #0x17527f4
017527f0  607641f9  ldr      x0, [x19, #0x2e8]
017527f4  fd7b42a9  ldp      x29, x30, [sp, #0x20]
017527f8  f44f41a9  ldp      x20, x19, [sp, #0x10]
017527fc  f50743f8  ldr      x21, [sp], #0x30
01752800  c0035fd6  ret      
