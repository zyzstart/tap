; RVA 0x1ed45b8, file offset 0x1ed45b8, conservative end 0x1ed4908
; SHA256 73360ac1fc3dda83083ab19d4ed4dbb8ad2634e4f99d255b2c824c51c307dd42
; All aliases at this entry: BattleCore.FP$$Sin :: BattleCore_FP_o BattleCore_FP__Sin (BattleCore_FP_o x, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed45b8  fb0f1af8  str      x27, [sp, #-0x60]!
01ed45bc  fa6701a9  stp      x26, x25, [sp, #0x10]
01ed45c0  f85f02a9  stp      x24, x23, [sp, #0x20]
01ed45c4  f65703a9  stp      x22, x21, [sp, #0x30]
01ed45c8  f44f04a9  stp      x20, x19, [sp, #0x40]
01ed45cc  fd7b05a9  stp      x29, x30, [sp, #0x50]
01ed45d0  fd430191  add      x29, sp, #0x50
01ed45d4  94830090  adrp     x20, #0x2f44000
01ed45d8  88e67e39  ldrb     w8, [x20, #0xfb9]
01ed45dc  f30300aa  mov      x19, x0
01ed45e0  e8000037  tbnz     w8, #0, #0x1ed45fc
01ed45e4  087000b0  adrp     x8, #0x2cd5000
01ed45e8  08dd47f9  ldr      x8, [x8, #0xfb8]
01ed45ec  000140b9  ldr      w0, [x8]
01ed45f0  4ec2b897  bl       #0xd04f28 ; unresolved symbol
01ed45f4  e8030032  mov      w8, #1
01ed45f8  88e63e39  strb     w8, [x20, #0xfb9]
01ed45fc  546f00b0  adrp     x20, #0x2cbd000
01ed4600  94de47f9  ldr      x20, [x20, #0xfb8]
01ed4604  15518dd2  mov      x21, #0x6a88
01ed4608  36a29ad2  mov      x22, #0xd511
01ed460c  f7508d92  mov      x23, #-0x6a88
01ed4610  800240f9  ldr      x0, [x20]
01ed4614  f587a4f2  movk     x21, #0x243f, lsl #16
01ed4618  d60fa9f2  movk     x22, #0x487e, lsl #16
01ed461c  1778bbf2  movk     x23, #0xdbc0, lsl #16
01ed4620  089c4439  ldrb     w8, [x0, #0x127]
01ed4624  7500c0f2  movk     x21, #3, lsl #32
01ed4628  d600c0f2  movk     x22, #6, lsl #32
01ed462c  97ffdff2  movk     x23, #0xfffc, lsl #32
01ed4630  a8000836  tbz      w8, #1, #0x1ed4644
01ed4634  08d840b9  ldr      w8, [x0, #0xd8]
01ed4638  68000035  cbnz     w8, #0x1ed4644
01ed463c  cbfeb897  bl       #0xd14168 ; unresolved symbol
01ed4640  800240f9  ldr      x0, [x20]
01ed4644  680ed69a  sdiv     x8, x19, x22
01ed4648  08cd169b  msub     x8, x8, x22, x19
01ed464c  7f0200f1  cmp      x19, #0
01ed4650  0c01168b  add      x12, x8, x22
01ed4654  16a18c9a  csel     x22, x8, x12, ge
01ed4658  e80336aa  mvn      x8, x22
01ed465c  1f0117eb  cmp      x8, x23
01ed4660  0b5c40f9  ldr      x11, [x0, #0xb8]
01ed4664  cc02158b  add      x12, x22, x21
01ed4668  e8d296da  csinv    x8, x23, x22, le
01ed466c  8801088b  add      x8, x12, x8
01ed4670  0c09d59a  udiv     x12, x8, x21
01ed4674  69a89692  mov      x9, #-0xb544
01ed4678  8aa896d2  mov      x10, #0xb544
01ed467c  8ca1159b  msub     x12, x12, x21, x8
01ed4680  09bcadf2  movk     x9, #0x6de0, lsl #16
01ed4684  ea43b2f2  movk     x10, #0x921f, lsl #16
01ed4688  6b6d40f9  ldr      x11, [x11, #0xd8]
01ed468c  880108cb  sub      x8, x12, x8
01ed4690  c9ffdff2  movk     x9, #0xfffe, lsl #32
01ed4694  2a00c0f2  movk     x10, #1, lsl #32
01ed4698  1901168b  add      x25, x8, x22
01ed469c  2803098b  add      x8, x25, x9
01ed46a0  3f030aeb  cmp      x25, x10
01ed46a4  28b3889a  csel     x8, x25, x8, lt
01ed46a8  6d7d4092  and      x13, x11, #0xffffffff
01ed46ac  6cfd6093  asr      x12, x11, #0x20
01ed46b0  097d4092  and      x9, x8, #0xffffffff
01ed46b4  aa7d099b  mul      x10, x13, x9
01ed46b8  897d099b  mul      x9, x12, x9
01ed46bc  08fd6093  asr      x8, x8, #0x20
01ed46c0  29814a8b  add      x9, x9, x10, lsr #32
01ed46c4  6025089b  madd     x0, x11, x8, x9
01ed46c8  25feff97  bl       #0x1ed3f5c ; BattleCore.FP$$Round
01ed46cc  97830090  adrp     x23, #0x2f44000
01ed46d0  e8167f39  ldrb     w8, [x23, #0xfc5]
01ed46d4  f30300aa  mov      x19, x0
01ed46d8  e8000037  tbnz     w8, #0, #0x1ed46f4
01ed46dc  886e00b0  adrp     x8, #0x2ca5000
01ed46e0  087541f9  ldr      x8, [x8, #0x2e8]
01ed46e4  000140b9  ldr      w0, [x8]
01ed46e8  10c2b897  bl       #0xd04f28 ; unresolved symbol
01ed46ec  e8030032  mov      w8, #1
01ed46f0  e8163f39  strb     w8, [x23, #0xfc5]
01ed46f4  386d00d0  adrp     x24, #0x2c7a000
01ed46f8  180b45f9  ldr      x24, [x24, #0xa10]
01ed46fc  800240f9  ldr      x0, [x20]
01ed4700  69a896d2  mov      x9, #0xb543
01ed4704  e943b2f2  movk     x9, #0x921f, lsl #16
01ed4708  080340f9  ldr      x8, [x24]
01ed470c  2900c0f2  movk     x9, #1, lsl #32
01ed4710  3f0309eb  cmp      x25, x9
01ed4714  085d40f9  ldr      x8, [x8, #0xb8]
01ed4718  1a0140f9  ldr      x26, [x8]
01ed471c  084c4279  ldrh     w8, [x0, #0x126]
01ed4720  0c010054  b.gt     #0x1ed4740
01ed4724  88004836  tbz      w8, #9, #0x1ed4734
01ed4728  08d840b9  ldr      w8, [x0, #0xd8]
01ed472c  48000035  cbnz     w8, #0x1ed4734
01ed4730  8efeb897  bl       #0xd14168 ; unresolved symbol
01ed4734  7bfe60d3  lsr      x27, x19, #0x20
01ed4738  7a0300b5  cbnz     x26, #0x1ed47a4
01ed473c  18000014  b        #0x1ed479c
01ed4740  88014836  tbz      w8, #9, #0x1ed4770
01ed4744  08d840b9  ldr      w8, [x0, #0xd8]
01ed4748  48010035  cbnz     w8, #0x1ed4770
01ed474c  87feb897  bl       #0xd14168 ; unresolved symbol
01ed4750  e8167f39  ldrb     w8, [x23, #0xfc5]
01ed4754  e8000037  tbnz     w8, #0, #0x1ed4770
01ed4758  886e00b0  adrp     x8, #0x2ca5000
01ed475c  087541f9  ldr      x8, [x8, #0x2e8]
01ed4760  000140b9  ldr      w0, [x8]
01ed4764  f1c1b897  bl       #0xd04f28 ; unresolved symbol
01ed4768  e8030032  mov      w8, #1
01ed476c  e8163f39  strb     w8, [x23, #0xfc5]
01ed4770  080340f9  ldr      x8, [x24]
01ed4774  085d40f9  ldr      x8, [x8, #0xb8]
01ed4778  1b0140f9  ldr      x27, [x8]
01ed477c  7b0000b5  cbnz     x27, #0x1ed4788
01ed4780  e0031faa  mov      x0, xzr
01ed4784  ea5bb997  bl       #0xd2b72c ; unresolved symbol
01ed4788  681b40b9  ldr      w8, [x27, #0x18]
01ed478c  69fe60d3  lsr      x9, x19, #0x20
01ed4790  e903292a  mvn      w9, w9
01ed4794  3b01080b  add      w27, w9, w8
01ed4798  7a0000b5  cbnz     x26, #0x1ed47a4
01ed479c  e0031faa  mov      x0, xzr
01ed47a0  e35bb997  bl       #0xd2b72c ; unresolved symbol
01ed47a4  481b40b9  ldr      w8, [x26, #0x18]
01ed47a8  7f03086b  cmp      w27, w8
01ed47ac  7b7f4093  sxtw     x27, w27
01ed47b0  a3000054  b.lo     #0x1ed47c4
01ed47b4  175fb997  bl       #0xd2c410 ; unresolved symbol
01ed47b8  e1031faa  mov      x1, xzr
01ed47bc  e2031faa  mov      x2, xzr
01ed47c0  b75bb997  bl       #0xd2b69c ; unresolved symbol
01ed47c4  800240f9  ldr      x0, [x20]
01ed47c8  480f1b8b  add      x8, x26, x27, lsl #3
01ed47cc  1a1140f9  ldr      x26, [x8, #0x20]
01ed47d0  099c4439  ldrb     w9, [x0, #0x127]
01ed47d4  89000836  tbz      w9, #1, #0x1ed47e4
01ed47d8  08d840b9  ldr      w8, [x0, #0xd8]
01ed47dc  48000035  cbnz     w8, #0x1ed47e4
01ed47e0  62feb897  bl       #0xd14168 ; unresolved symbol
01ed47e4  e8167f39  ldrb     w8, [x23, #0xfc5]
01ed47e8  e8000037  tbnz     w8, #0, #0x1ed4804
01ed47ec  886e00b0  adrp     x8, #0x2ca5000
01ed47f0  087541f9  ldr      x8, [x8, #0x2e8]
01ed47f4  000140b9  ldr      w0, [x8]
01ed47f8  ccc1b897  bl       #0xd04f28 ; unresolved symbol
01ed47fc  e8030032  mov      w8, #1
01ed4800  e8163f39  strb     w8, [x23, #0xfc5]
01ed4804  080340f9  ldr      x8, [x24]
01ed4808  800240f9  ldr      x0, [x20]
01ed480c  69a896d2  mov      x9, #0xb543
01ed4810  e943b2f2  movk     x9, #0x921f, lsl #16
01ed4814  085d40f9  ldr      x8, [x8, #0xb8]
01ed4818  2900c0f2  movk     x9, #1, lsl #32
01ed481c  3f0309eb  cmp      x25, x9
01ed4820  1b0140f9  ldr      x27, [x8]
01ed4824  084c4279  ldrh     w8, [x0, #0x126]
01ed4828  0c010054  b.gt     #0x1ed4848
01ed482c  88004836  tbz      w8, #9, #0x1ed483c
01ed4830  08d840b9  ldr      w8, [x0, #0xd8]
01ed4834  48000035  cbnz     w8, #0x1ed483c
01ed4838  4cfeb897  bl       #0xd14168 ; unresolved symbol
01ed483c  73fe60d3  lsr      x19, x19, #0x20
01ed4840  7b0300b5  cbnz     x27, #0x1ed48ac
01ed4844  18000014  b        #0x1ed48a4
01ed4848  88014836  tbz      w8, #9, #0x1ed4878
01ed484c  08d840b9  ldr      w8, [x0, #0xd8]
01ed4850  48010035  cbnz     w8, #0x1ed4878
01ed4854  45feb897  bl       #0xd14168 ; unresolved symbol
01ed4858  e8167f39  ldrb     w8, [x23, #0xfc5]
01ed485c  e8000037  tbnz     w8, #0, #0x1ed4878
01ed4860  886e00b0  adrp     x8, #0x2ca5000
01ed4864  087541f9  ldr      x8, [x8, #0x2e8]
01ed4868  000140b9  ldr      w0, [x8]
01ed486c  afc1b897  bl       #0xd04f28 ; unresolved symbol
01ed4870  e8030032  mov      w8, #1
01ed4874  e8163f39  strb     w8, [x23, #0xfc5]
01ed4878  080340f9  ldr      x8, [x24]
01ed487c  085d40f9  ldr      x8, [x8, #0xb8]
01ed4880  170140f9  ldr      x23, [x8]
01ed4884  770000b5  cbnz     x23, #0x1ed4890
01ed4888  e0031faa  mov      x0, xzr
01ed488c  a85bb997  bl       #0xd2b72c ; unresolved symbol
01ed4890  e81a40b9  ldr      w8, [x23, #0x18]
01ed4894  69fe60d3  lsr      x9, x19, #0x20
01ed4898  e903292a  mvn      w9, w9
01ed489c  3301080b  add      w19, w9, w8
01ed48a0  7b0000b5  cbnz     x27, #0x1ed48ac
01ed48a4  e0031faa  mov      x0, xzr
01ed48a8  a15bb997  bl       #0xd2b72c ; unresolved symbol
01ed48ac  681b40b9  ldr      w8, [x27, #0x18]
01ed48b0  7f02086b  cmp      w19, w8
01ed48b4  a3000054  b.lo     #0x1ed48c8
01ed48b8  d65eb997  bl       #0xd2c410 ; unresolved symbol
01ed48bc  e1031faa  mov      x1, xzr
01ed48c0  e2031faa  mov      x2, xzr
01ed48c4  765bb997  bl       #0xd2b69c ; unresolved symbol
01ed48c8  800240f9  ldr      x0, [x20]
01ed48cc  b30600d1  sub      x19, x21, #1
01ed48d0  089c4439  ldrb     w8, [x0, #0x127]
01ed48d4  88000836  tbz      w8, #1, #0x1ed48e4
01ed48d8  08d840b9  ldr      w8, [x0, #0xd8]
01ed48dc  48000035  cbnz     w8, #0x1ed48e4
01ed48e0  22feb897  bl       #0xd14168 ; unresolved symbol
01ed48e4  df0213eb  cmp      x22, x19
01ed48e8  40d79ada  cneg     x0, x26, gt
01ed48ec  fd7b45a9  ldp      x29, x30, [sp, #0x50]
01ed48f0  f44f44a9  ldp      x20, x19, [sp, #0x40]
01ed48f4  f65743a9  ldp      x22, x21, [sp, #0x30]
01ed48f8  f85f42a9  ldp      x24, x23, [sp, #0x20]
01ed48fc  fa6741a9  ldp      x26, x25, [sp, #0x10]
01ed4900  fb0746f8  ldr      x27, [sp], #0x60
01ed4904  c0035fd6  ret      
