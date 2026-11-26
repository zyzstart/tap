; RVA 0x1ed4188, file offset 0x1ed4188, conservative end 0x1ed43b0
; SHA256 a52d70efffa9193a49fdc46de5ecb6f07ba65a8aa96c3ca682d9afe17542231a
; All aliases at this entry: BattleCore.FP$$Div :: BattleCore_FP_o BattleCore_FP__Div (BattleCore_FP_o x, BattleCore_FP_o y, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01ed4188  fa67bba9  stp      x26, x25, [sp, #-0x50]!
01ed418c  f85f01a9  stp      x24, x23, [sp, #0x10]
01ed4190  f65702a9  stp      x22, x21, [sp, #0x20]
01ed4194  f44f03a9  stp      x20, x19, [sp, #0x30]
01ed4198  fd7b04a9  stp      x29, x30, [sp, #0x40]
01ed419c  fd030191  add      x29, sp, #0x40
01ed41a0  95830090  adrp     x21, #0x2f44000
01ed41a4  a8da7e39  ldrb     w8, [x21, #0xfb6]
01ed41a8  f40301aa  mov      x20, x1
01ed41ac  f30300aa  mov      x19, x0
01ed41b0  e8000037  tbnz     w8, #0, #0x1ed41cc
01ed41b4  a87100b0  adrp     x8, #0x2d09000
01ed41b8  082944f9  ldr      x8, [x8, #0x850]
01ed41bc  000140b9  ldr      w0, [x8]
01ed41c0  5ac3b897  bl       #0xd04f28 ; unresolved symbol
01ed41c4  e8030032  mov      w8, #1
01ed41c8  a8da3e39  strb     w8, [x21, #0xfb6]
01ed41cc  7f0200f1  cmp      x19, #0
01ed41d0  740800b4  cbz      x20, #0x1ed42dc
01ed41d4  765693da  cneg     x22, x19, mi
01ed41d8  9f0200f1  cmp      x20, #0
01ed41dc  955694da  cneg     x21, x20, mi
01ed41e0  38048052  mov      w24, #0x21
01ed41e4  a80e4092  and      x8, x21, #0xf
01ed41e8  280100b5  cbnz     x8, #0x1ed420c
01ed41ec  e80315aa  mov      x8, x21
01ed41f0  15fd44d3  lsr      x21, x8, #4
01ed41f4  1f230071  cmp      w24, #8
01ed41f8  18130051  sub      w24, w24, #4
01ed41fc  8b000054  b.lt     #0x1ed420c
01ed4200  091d44d3  ubfx     x9, x8, #4, #4
01ed4204  e80315aa  mov      x8, x21
01ed4208  49ffffb4  cbz      x9, #0x1ed41f0
01ed420c  e8031faa  mov      x8, xzr
01ed4210  f805f837  tbnz     w24, #0x1f, #0x1ed42cc
01ed4214  d60500b4  cbz      x22, #0x1ed42cc
01ed4218  576f00b0  adrp     x23, #0x2cbd000
01ed421c  f7de47f9  ldr      x23, [x23, #0xfb8]
01ed4220  f9031faa  mov      x25, xzr
01ed4224  1a008092  mov      x26, #-1
01ed4228  e00240f9  ldr      x0, [x23]
01ed422c  089c4439  ldrb     w8, [x0, #0x127]
01ed4230  88000836  tbz      w8, #1, #0x1ed4240
01ed4234  08d840b9  ldr      w8, [x0, #0xd8]
01ed4238  48000035  cbnz     w8, #0x1ed4240
01ed423c  cbffb897  bl       #0xd14168 ; unresolved symbol
01ed4240  c8fe7cd3  lsr      x8, x22, #0x3c
01ed4244  a80000b4  cbz      x8, #0x1ed4258
01ed4248  e8031f2a  mov      w8, wzr
01ed424c  e90316aa  mov      x9, x22
01ed4250  2901f8b6  tbz      x9, #0x3f, #0x1ed4274
01ed4254  0b000014  b        #0x1ed4280
01ed4258  ea0316aa  mov      x10, x22
01ed425c  49ed7cd3  lsl      x9, x10, #4
01ed4260  4bed78d3  ubfx     x11, x10, #0x38, #4
01ed4264  08110011  add      w8, w8, #4
01ed4268  ea0309aa  mov      x10, x9
01ed426c  8bffffb4  cbz      x11, #0x1ed425c
01ed4270  8900f8b7  tbnz     x9, #0x3f, #0x1ed4280
01ed4274  29f97fd3  lsl      x9, x9, #1
01ed4278  08050011  add      w8, w8, #1
01ed427c  c9ffffb6  tbz      x9, #0x3f, #0x1ed4274
01ed4280  1f01186b  cmp      w8, w24
01ed4284  08c3881a  csel     w8, w24, w8, gt
01ed4288  09150012  and      w9, w8, #0x3f
01ed428c  0a03084b  sub      w10, w24, w8
01ed4290  c822c99a  lsl      x8, x22, x9
01ed4294  4b150012  and      w11, w10, #0x3f
01ed4298  0909d59a  udiv     x9, x8, x21
01ed429c  4c27cb9a  lsr      x12, x26, x11
01ed42a0  2c012c8a  bic      x12, x9, x12
01ed42a4  2c0300b5  cbnz     x12, #0x1ed4308
01ed42a8  2b21cb9a  lsl      x11, x9, x11
01ed42ac  58050051  sub      w24, w10, #1
01ed42b0  7901198b  add      x25, x11, x25
01ed42b4  9800f837  tbnz     w24, #0x1f, #0x1ed42c4
01ed42b8  28a1159b  msub     x8, x9, x21, x8
01ed42bc  16f97fd3  lsl      x22, x8, #1
01ed42c0  56fbffb5  cbnz     x22, #0x1ed4228
01ed42c4  28070091  add      x8, x25, #1
01ed42c8  08fd41d3  lsr      x8, x8, #1
01ed42cc  890213ca  eor      x9, x20, x19
01ed42d0  3f0100f1  cmp      x9, #0
01ed42d4  00a588da  cneg     x0, x8, lt
01ed42d8  30000014  b        #0x1ed4398
01ed42dc  ed020054  b.le     #0x1ed4338
01ed42e0  536f00b0  adrp     x19, #0x2cbd000
01ed42e4  73de47f9  ldr      x19, [x19, #0xfb8]
01ed42e8  600240f9  ldr      x0, [x19]
01ed42ec  089c4439  ldrb     w8, [x0, #0x127]
01ed42f0  e8010836  tbz      w8, #1, #0x1ed432c
01ed42f4  08d840b9  ldr      w8, [x0, #0xd8]
01ed42f8  a8010035  cbnz     w8, #0x1ed432c
01ed42fc  9bffb897  bl       #0xd14168 ; unresolved symbol
01ed4300  600240f9  ldr      x0, [x19]
01ed4304  0a000014  b        #0x1ed432c
01ed4308  e00240f9  ldr      x0, [x23]
01ed430c  890213ca  eor      x9, x20, x19
01ed4310  084c4279  ldrh     w8, [x0, #0x126]
01ed4314  8902f8b7  tbnz     x9, #0x3f, #0x1ed4364
01ed4318  a8004836  tbz      w8, #9, #0x1ed432c
01ed431c  08d840b9  ldr      w8, [x0, #0xd8]
01ed4320  68000035  cbnz     w8, #0x1ed432c
01ed4324  91ffb897  bl       #0xd14168 ; unresolved symbol
01ed4328  e00240f9  ldr      x0, [x23]
01ed432c  085c40f9  ldr      x8, [x0, #0xb8]
01ed4330  000540f9  ldr      x0, [x8, #8]
01ed4334  19000014  b        #0x1ed4398
01ed4338  546f00b0  adrp     x20, #0x2cbd000
01ed433c  94de47f9  ldr      x20, [x20, #0xfb8]
01ed4340  800240f9  ldr      x0, [x20]
01ed4344  084c4279  ldrh     w8, [x0, #0x126]
01ed4348  b301f8b7  tbnz     x19, #0x3f, #0x1ed437c
01ed434c  88004836  tbz      w8, #9, #0x1ed435c
01ed4350  08d840b9  ldr      w8, [x0, #0xd8]
01ed4354  48000035  cbnz     w8, #0x1ed435c
01ed4358  84ffb897  bl       #0xd14168 ; unresolved symbol
01ed435c  e0031faa  mov      x0, xzr
01ed4360  0e000014  b        #0x1ed4398
01ed4364  68014836  tbz      w8, #9, #0x1ed4390
01ed4368  08d840b9  ldr      w8, [x0, #0xd8]
01ed436c  28010035  cbnz     w8, #0x1ed4390
01ed4370  7effb897  bl       #0xd14168 ; unresolved symbol
01ed4374  e00240f9  ldr      x0, [x23]
01ed4378  06000014  b        #0x1ed4390
01ed437c  a8004836  tbz      w8, #9, #0x1ed4390
01ed4380  08d840b9  ldr      w8, [x0, #0xd8]
01ed4384  68000035  cbnz     w8, #0x1ed4390
01ed4388  78ffb897  bl       #0xd14168 ; unresolved symbol
01ed438c  800240f9  ldr      x0, [x20]
01ed4390  085c40f9  ldr      x8, [x0, #0xb8]
01ed4394  000940f9  ldr      x0, [x8, #0x10]
01ed4398  fd7b44a9  ldp      x29, x30, [sp, #0x40]
01ed439c  f44f43a9  ldp      x20, x19, [sp, #0x30]
01ed43a0  f65742a9  ldp      x22, x21, [sp, #0x20]
01ed43a4  f85f41a9  ldp      x24, x23, [sp, #0x10]
01ed43a8  fa67c5a8  ldp      x26, x25, [sp], #0x50
01ed43ac  c0035fd6  ret      
