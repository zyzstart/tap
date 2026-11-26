; RVA 0x1ed55f0, file offset 0x1ed55f0, conservative end 0x1ed591c
; SHA256 fe778c97b66621efd171279962a7312609d8006534865e09d6d945494a623978
; All aliases at this entry: BattleCore.FP$$.cctor :: void BattleCore_FP___cctor (const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed55f0  ff0301d1  sub      sp, sp, #0x40
01ed55f4  f31300f9  str      x19, [sp, #0x20]
01ed55f8  fd7b03a9  stp      x29, x30, [sp, #0x30]
01ed55fc  fdc30091  add      x29, sp, #0x30
01ed5600  738300f0  adrp     x19, #0x2f44000
01ed5604  681a7f39  ldrb     w8, [x19, #0xfc6]
01ed5608  e8000037  tbnz     w8, #0, #0x1ed5624
01ed560c  687100d0  adrp     x8, #0x2d03000
01ed5610  08fd40f9  ldr      x8, [x8, #0x1f8]
01ed5614  000140b9  ldr      w0, [x8]
01ed5618  44beb897  bl       #0xd04f28 ; unresolved symbol
01ed561c  e8030032  mov      w8, #1
01ed5620  681a3f39  strb     w8, [x19, #0xfc6]
01ed5624  536f0090  adrp     x19, #0x2cbd000
01ed5628  73de47f9  ldr      x19, [x19, #0xfb8]
01ed562c  e9030032  mov      w9, #1
01ed5630  eaf77fb2  mov      x10, #0x7ffffffffffffffe
01ed5634  4101c0d2  mov      x1, #0xa00000000
01ed5638  680240f9  ldr      x8, [x19]
01ed563c  085d40f9  ldr      x8, [x8, #0xb8]
01ed5640  090100f9  str      x9, [x8]
01ed5644  680240f9  ldr      x8, [x19]
01ed5648  095d40f9  ldr      x9, [x8, #0xb8]
01ed564c  2a0500f9  str      x10, [x9, #8]
01ed5650  095d40f9  ldr      x9, [x8, #0xb8]
01ed5654  4a0080d2  mov      x10, #2
01ed5658  0a00f0f2  movk     x10, #0x8000, lsl #48
01ed565c  2a0900f9  str      x10, [x9, #0x10]
01ed5660  095d40f9  ldr      x9, [x8, #0xb8]
01ed5664  ea0360b2  mov      x10, #0x100000000
01ed5668  2a0d00f9  str      x10, [x9, #0x18]
01ed566c  095d40f9  ldr      x9, [x8, #0xb8]
01ed5670  4a01c0d2  mov      x10, #0xa00000000
01ed5674  2a1100f9  str      x10, [x9, #0x20]
01ed5678  095d40f9  ldr      x9, [x8, #0xb8]
01ed567c  ea030132  mov      w10, #-0xffffffff80000000
01ed5680  2a1500f9  str      x10, [x9, #0x28]
01ed5684  095d40f9  ldr      x9, [x8, #0xb8]
01ed5688  eafb40b2  mov      x10, #0x7fffffffffffffff
01ed568c  3f1900f9  str      xzr, [x9, #0x30]
01ed5690  095d40f9  ldr      x9, [x8, #0xb8]
01ed5694  2a1d00f9  str      x10, [x9, #0x38]
01ed5698  095d40f9  ldr      x9, [x8, #0xb8]
01ed569c  ea0741b2  mov      x10, #-0x7fffffffffffffff
01ed56a0  2a2100f9  str      x10, [x9, #0x40]
01ed56a4  095d40f9  ldr      x9, [x8, #0xb8]
01ed56a8  ea0341b2  mov      x10, #-0x8000000000000000
01ed56ac  2a2500f9  str      x10, [x9, #0x48]
01ed56b0  085d40f9  ldr      x8, [x8, #0xb8]
01ed56b4  000d40f9  ldr      x0, [x8, #0x18]
01ed56b8  97faff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed56bc  680240f9  ldr      x8, [x19]
01ed56c0  810cc0d2  mov      x1, #0x6400000000
01ed56c4  095d40f9  ldr      x9, [x8, #0xb8]
01ed56c8  202900f9  str      x0, [x9, #0x50]
01ed56cc  085d40f9  ldr      x8, [x8, #0xb8]
01ed56d0  000d40f9  ldr      x0, [x8, #0x18]
01ed56d4  90faff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed56d8  680240f9  ldr      x8, [x19]
01ed56dc  017dc0d2  mov      x1, #0x3e800000000
01ed56e0  095d40f9  ldr      x9, [x8, #0xb8]
01ed56e4  202d00f9  str      x0, [x9, #0x58]
01ed56e8  085d40f9  ldr      x8, [x8, #0xb8]
01ed56ec  000d40f9  ldr      x0, [x8, #0x18]
01ed56f0  89faff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed56f4  680240f9  ldr      x8, [x19]
01ed56f8  01e2c4d2  mov      x1, #0x271000000000
01ed56fc  095d40f9  ldr      x9, [x8, #0xb8]
01ed5700  203100f9  str      x0, [x9, #0x60]
01ed5704  085d40f9  ldr      x8, [x8, #0xb8]
01ed5708  000d40f9  ldr      x0, [x8, #0x18]
01ed570c  82faff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed5710  680240f9  ldr      x8, [x19]
01ed5714  01d4d0d2  mov      x1, #0x86a000000000
01ed5718  2100e0f2  movk     x1, #1, lsl #48
01ed571c  095d40f9  ldr      x9, [x8, #0xb8]
01ed5720  203500f9  str      x0, [x9, #0x68]
01ed5724  085d40f9  ldr      x8, [x8, #0xb8]
01ed5728  000d40f9  ldr      x0, [x8, #0x18]
01ed572c  7afaff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed5730  680240f9  ldr      x8, [x19]
01ed5734  0148c8d2  mov      x1, #0x424000000000
01ed5738  e101e0f2  movk     x1, #0xf, lsl #48
01ed573c  095d40f9  ldr      x9, [x8, #0xb8]
01ed5740  203900f9  str      x0, [x9, #0x70]
01ed5744  085d40f9  ldr      x8, [x8, #0xb8]
01ed5748  000d40f9  ldr      x0, [x8, #0x18]
01ed574c  72faff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed5750  680240f9  ldr      x8, [x19]
01ed5754  01d0d2d2  mov      x1, #0x968000000000
01ed5758  0113e0f2  movk     x1, #0x98, lsl #48
01ed575c  095d40f9  ldr      x9, [x8, #0xb8]
01ed5760  203d00f9  str      x0, [x9, #0x78]
01ed5764  085d40f9  ldr      x8, [x8, #0xb8]
01ed5768  000d40f9  ldr      x0, [x8, #0x18]
01ed576c  6afaff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed5770  680240f9  ldr      x8, [x19]
01ed5774  0120dcd2  mov      x1, #0xe10000000000
01ed5778  a1bee0f2  movk     x1, #0x5f5, lsl #48
01ed577c  095d40f9  ldr      x9, [x8, #0xb8]
01ed5780  204100f9  str      x0, [x9, #0x80]
01ed5784  085d40f9  ldr      x8, [x8, #0xb8]
01ed5788  000d40f9  ldr      x0, [x8, #0x18]
01ed578c  62faff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed5790  680240f9  ldr      x8, [x19]
01ed5794  0140d9d2  mov      x1, #0xca0000000000
01ed5798  4173e7f2  movk     x1, #0x3b9a, lsl #48
01ed579c  095d40f9  ldr      x9, [x8, #0xb8]
01ed57a0  204500f9  str      x0, [x9, #0x88]
01ed57a4  085d40f9  ldr      x8, [x8, #0xb8]
01ed57a8  000d40f9  ldr      x0, [x8, #0x18]
01ed57ac  5afaff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed57b0  680240f9  ldr      x8, [x19]
01ed57b4  61808552  mov      w1, #0x2c03
01ed57b8  a2c89a52  mov      w2, #0xd645
01ed57bc  e3ec9f52  mov      w3, #0xff67
01ed57c0  095d40f9  ldr      x9, [x8, #0xb8]
01ed57c4  8112bc72  movk     w1, #0xe094, lsl #16
01ed57c8  22fca172  movk     w2, #0xfe1, lsl #16
01ed57cc  0349a172  movk     w3, #0xa48, lsl #16
01ed57d0  204900f9  str      x0, [x9, #0x90]
01ed57d4  095d40f9  ldr      x9, [x8, #0xb8]
01ed57d8  e0430091  add      x0, sp, #0x10
01ed57dc  e50b1e32  mov      w5, #0x1c
01ed57e0  e4031f2a  mov      w4, wzr
01ed57e4  2a3140f9  ldr      x10, [x9, #0x60]
01ed57e8  e6031faa  mov      x6, xzr
01ed57ec  2a4d00f9  str      x10, [x9, #0x98]
01ed57f0  095d40f9  ldr      x9, [x8, #0xb8]
01ed57f4  0a518dd2  mov      x10, #0x6a88
01ed57f8  ea87a4f2  movk     x10, #0x243f, lsl #16
01ed57fc  6a00c0f2  movk     x10, #3, lsl #32
01ed5800  2a5100f9  str      x10, [x9, #0xa0]
01ed5804  095d40f9  ldr      x9, [x8, #0xb8]
01ed5808  8aa896d2  mov      x10, #0xb544
01ed580c  ea43b2f2  movk     x10, #0x921f, lsl #16
01ed5810  2a00c0f2  movk     x10, #1, lsl #32
01ed5814  2a5500f9  str      x10, [x9, #0xa8]
01ed5818  085d40f9  ldr      x8, [x8, #0xb8]
01ed581c  29a29ad2  mov      x9, #0xd511
01ed5820  c90fa9f2  movk     x9, #0x487e, lsl #16
01ed5824  c900c0f2  movk     x9, #6, lsl #32
01ed5828  095900f9  str      x9, [x8, #0xb0]
01ed582c  ff7f01a9  stp      xzr, xzr, [sp, #0x10]
01ed5830  5b89f997  bl       #0x1d37d9c ; unresolved symbol
01ed5834  e00741a9  ldp      x0, x1, [sp, #0x10]
01ed5838  84feff97  bl       #0x1ed5248 ; BattleCore.FP$$op_Explicit
01ed583c  680240f9  ldr      x8, [x19]
01ed5840  e1008b52  mov      w1, #0x5807
01ed5844  62919552  mov      w2, #0xac8b
01ed5848  c3d99f52  mov      w3, #0xfece
01ed584c  085d40f9  ldr      x8, [x8, #0xb8]
01ed5850  0125b872  movk     w1, #0xc128, lsl #16
01ed5854  62f8a372  movk     w2, #0x1fc3, lsl #16
01ed5858  2392a272  movk     w3, #0x1491, lsl #16
01ed585c  005d00f9  str      x0, [x8, #0xb8]
01ed5860  e0030091  mov      x0, sp
01ed5864  e50b1e32  mov      w5, #0x1c
01ed5868  e4031f2a  mov      w4, wzr
01ed586c  e6031faa  mov      x6, xzr
01ed5870  ff7f00a9  stp      xzr, xzr, [sp]
01ed5874  4a89f997  bl       #0x1d37d9c ; unresolved symbol
01ed5878  e00740a9  ldp      x0, x1, [sp]
01ed587c  73feff97  bl       #0x1ed5248 ; BattleCore.FP$$op_Explicit
01ed5880  680240f9  ldr      x8, [x19]
01ed5884  8116c0d2  mov      x1, #0xb400000000
01ed5888  095d40f9  ldr      x9, [x8, #0xb8]
01ed588c  206100f9  str      x0, [x9, #0xc0]
01ed5890  085d40f9  ldr      x8, [x8, #0xb8]
01ed5894  005140f9  ldr      x0, [x8, #0xa0]
01ed5898  1ffaff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed589c  680240f9  ldr      x8, [x19]
01ed58a0  095d40f9  ldr      x9, [x8, #0xb8]
01ed58a4  206500f9  str      x0, [x9, #0xc8]
01ed58a8  085d40f9  ldr      x8, [x8, #0xb8]
01ed58ac  8016c0d2  mov      x0, #0xb400000000
01ed58b0  015140f9  ldr      x1, [x8, #0xa0]
01ed58b4  18faff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed58b8  680240f9  ldr      x8, [x19]
01ed58bc  095d40f9  ldr      x9, [x8, #0xb8]
01ed58c0  206900f9  str      x0, [x9, #0xd0]
01ed58c4  085d40f9  ldr      x8, [x8, #0xb8]
01ed58c8  c087c4d2  mov      x0, #0x243e00000000
01ed58cc  6000e0f2  movk     x0, #3, lsl #48
01ed58d0  015540f9  ldr      x1, [x8, #0xa8]
01ed58d4  10faff97  bl       #0x1ed4114 ; BattleCore.FP$$op_Division
01ed58d8  680240f9  ldr      x8, [x19]
01ed58dc  ea1360b2  mov      x10, #0x1f00000000
01ed58e0  095d40f9  ldr      x9, [x8, #0xb8]
01ed58e4  206d00f9  str      x0, [x9, #0xd8]
01ed58e8  095d40f9  ldr      x9, [x8, #0xb8]
01ed58ec  2a7100f9  str      x10, [x9, #0xe0]
01ed58f0  095d40f9  ldr      x9, [x8, #0xb8]
01ed58f4  ea6b5bb2  mov      x10, #-0x2000000000
01ed58f8  2a7500f9  str      x10, [x9, #0xe8]
01ed58fc  085d40f9  ldr      x8, [x8, #0xb8]
01ed5900  e9fe8252  mov      w9, #0x17f7
01ed5904  492eb672  movk     w9, #0xb172, lsl #16
01ed5908  097900f9  str      x9, [x8, #0xf0]
01ed590c  fd7b43a9  ldp      x29, x30, [sp, #0x30]
01ed5910  f31340f9  ldr      x19, [sp, #0x20]
01ed5914  ff030191  add      sp, sp, #0x40
01ed5918  c0035fd6  ret      
