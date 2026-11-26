; RVA 0x1752de8, file offset 0x1752de8, conservative end 0x1753404
; SHA256 194d75ae40cd70856b509ba0a6fac725f365a25b3e93fe5b9f09797453133d77
; All aliases at this entry: A3BattleCore.ActorAttrData$$InitFromPool :: void A3BattleCore_ActorAttrData__InitFromPool (A3BattleCore_ActorAttrData_o* __this, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01752de8  f44fbea9  stp      x20, x19, [sp, #-0x20]!
01752dec  fd7b01a9  stp      x29, x30, [sp, #0x10]
01752df0  fd430091  add      x29, sp, #0x10
01752df4  74bf00d0  adrp     x20, #0x2f40000
01752df8  88b25639  ldrb     w8, [x20, #0x5ac]
01752dfc  f30300aa  mov      x19, x0
01752e00  e8000037  tbnz     w8, #0, #0x1752e1c
01752e04  28ab00f0  adrp     x8, #0x2cb9000
01752e08  080d47f9  ldr      x8, [x8, #0xe18]
01752e0c  000140b9  ldr      w0, [x8]
01752e10  46c8d697  bl       #0xd04f28 ; unresolved symbol
01752e14  e8030032  mov      w8, #1
01752e18  88b21639  strb     w8, [x20, #0x5ac]
01752e1c  7f1200b9  str      wzr, [x19, #0x10]
01752e20  48ab00f0  adrp     x8, #0x2cbd000
01752e24  08dd47f9  ldr      x8, [x8, #0xfb8]
01752e28  000140f9  ldr      x0, [x8]
01752e2c  089c4439  ldrb     w8, [x0, #0x127]
01752e30  88000836  tbz      w8, #1, #0x1752e40
01752e34  08d840b9  ldr      w8, [x0, #0xd8]
01752e38  48000035  cbnz     w8, #0x1752e40
01752e3c  cb04d797  bl       #0xd14168 ; unresolved symbol
01752e40  e0031f2a  mov      w0, wzr
01752e44  e1031faa  mov      x1, xzr
01752e48  5a051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752e4c  600e00f9  str      x0, [x19, #0x18]
01752e50  e0031f2a  mov      w0, wzr
01752e54  e1031faa  mov      x1, xzr
01752e58  56051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752e5c  601200f9  str      x0, [x19, #0x20]
01752e60  e0031f2a  mov      w0, wzr
01752e64  e1031faa  mov      x1, xzr
01752e68  52051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752e6c  601600f9  str      x0, [x19, #0x28]
01752e70  e0031f2a  mov      w0, wzr
01752e74  e1031faa  mov      x1, xzr
01752e78  4e051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752e7c  601a00f9  str      x0, [x19, #0x30]
01752e80  e0031f2a  mov      w0, wzr
01752e84  e1031faa  mov      x1, xzr
01752e88  4a051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752e8c  601e00f9  str      x0, [x19, #0x38]
01752e90  e0031f2a  mov      w0, wzr
01752e94  e1031faa  mov      x1, xzr
01752e98  46051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752e9c  602200f9  str      x0, [x19, #0x40]
01752ea0  e0031f2a  mov      w0, wzr
01752ea4  e1031faa  mov      x1, xzr
01752ea8  42051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752eac  602600f9  str      x0, [x19, #0x48]
01752eb0  e0031f2a  mov      w0, wzr
01752eb4  e1031faa  mov      x1, xzr
01752eb8  3e051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752ebc  602a00f9  str      x0, [x19, #0x50]
01752ec0  e0031f2a  mov      w0, wzr
01752ec4  e1031faa  mov      x1, xzr
01752ec8  3a051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752ecc  602e00f9  str      x0, [x19, #0x58]
01752ed0  e0031f2a  mov      w0, wzr
01752ed4  e1031faa  mov      x1, xzr
01752ed8  36051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752edc  603200f9  str      x0, [x19, #0x60]
01752ee0  e0031f2a  mov      w0, wzr
01752ee4  e1031faa  mov      x1, xzr
01752ee8  32051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752eec  603600f9  str      x0, [x19, #0x68]
01752ef0  e0031f2a  mov      w0, wzr
01752ef4  e1031faa  mov      x1, xzr
01752ef8  2e051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752efc  603a00f9  str      x0, [x19, #0x70]
01752f00  e0031f2a  mov      w0, wzr
01752f04  e1031faa  mov      x1, xzr
01752f08  2a051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752f0c  603e00f9  str      x0, [x19, #0x78]
01752f10  e0031f2a  mov      w0, wzr
01752f14  e1031faa  mov      x1, xzr
01752f18  26051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752f1c  604200f9  str      x0, [x19, #0x80]
01752f20  e0031f2a  mov      w0, wzr
01752f24  e1031faa  mov      x1, xzr
01752f28  22051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752f2c  604600f9  str      x0, [x19, #0x88]
01752f30  e0031f2a  mov      w0, wzr
01752f34  e1031faa  mov      x1, xzr
01752f38  1e051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752f3c  604a00f9  str      x0, [x19, #0x90]
01752f40  e0031f2a  mov      w0, wzr
01752f44  e1031faa  mov      x1, xzr
01752f48  1a051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752f4c  604e00f9  str      x0, [x19, #0x98]
01752f50  e0031f2a  mov      w0, wzr
01752f54  e1031faa  mov      x1, xzr
01752f58  16051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752f5c  605200f9  str      x0, [x19, #0xa0]
01752f60  e0031f2a  mov      w0, wzr
01752f64  e1031faa  mov      x1, xzr
01752f68  12051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752f6c  605600f9  str      x0, [x19, #0xa8]
01752f70  e0031f2a  mov      w0, wzr
01752f74  e1031faa  mov      x1, xzr
01752f78  0e051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752f7c  605a00f9  str      x0, [x19, #0xb0]
01752f80  e0031f2a  mov      w0, wzr
01752f84  e1031faa  mov      x1, xzr
01752f88  0a051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752f8c  605e00f9  str      x0, [x19, #0xb8]
01752f90  e0031f2a  mov      w0, wzr
01752f94  e1031faa  mov      x1, xzr
01752f98  06051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752f9c  606200f9  str      x0, [x19, #0xc0]
01752fa0  e0031f2a  mov      w0, wzr
01752fa4  e1031faa  mov      x1, xzr
01752fa8  02051e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752fac  606600f9  str      x0, [x19, #0xc8]
01752fb0  e0031f2a  mov      w0, wzr
01752fb4  e1031faa  mov      x1, xzr
01752fb8  fe041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752fbc  606a00f9  str      x0, [x19, #0xd0]
01752fc0  e0031f2a  mov      w0, wzr
01752fc4  e1031faa  mov      x1, xzr
01752fc8  fa041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752fcc  606e00f9  str      x0, [x19, #0xd8]
01752fd0  e0031f2a  mov      w0, wzr
01752fd4  e1031faa  mov      x1, xzr
01752fd8  f6041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752fdc  607200f9  str      x0, [x19, #0xe0]
01752fe0  e0031f2a  mov      w0, wzr
01752fe4  e1031faa  mov      x1, xzr
01752fe8  f2041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752fec  607600f9  str      x0, [x19, #0xe8]
01752ff0  e0031f2a  mov      w0, wzr
01752ff4  e1031faa  mov      x1, xzr
01752ff8  ee041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01752ffc  607a00f9  str      x0, [x19, #0xf0]
01753000  e0031f2a  mov      w0, wzr
01753004  e1031faa  mov      x1, xzr
01753008  ea041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0175300c  607e00f9  str      x0, [x19, #0xf8]
01753010  e0031f2a  mov      w0, wzr
01753014  e1031faa  mov      x1, xzr
01753018  e6041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0175301c  608200f9  str      x0, [x19, #0x100]
01753020  e0031f2a  mov      w0, wzr
01753024  e1031faa  mov      x1, xzr
01753028  e2041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0175302c  608600f9  str      x0, [x19, #0x108]
01753030  e0031f2a  mov      w0, wzr
01753034  e1031faa  mov      x1, xzr
01753038  de041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0175303c  608a00f9  str      x0, [x19, #0x110]
01753040  e0031f2a  mov      w0, wzr
01753044  e1031faa  mov      x1, xzr
01753048  da041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0175304c  608e00f9  str      x0, [x19, #0x118]
01753050  e0031f2a  mov      w0, wzr
01753054  e1031faa  mov      x1, xzr
01753058  d6041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0175305c  609200f9  str      x0, [x19, #0x120]
01753060  e0031f2a  mov      w0, wzr
01753064  e1031faa  mov      x1, xzr
01753068  d2041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0175306c  609600f9  str      x0, [x19, #0x128]
01753070  e0031f2a  mov      w0, wzr
01753074  e1031faa  mov      x1, xzr
01753078  ce041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
0175307c  609a00f9  str      x0, [x19, #0x130]
01753080  e0031f2a  mov      w0, wzr
01753084  e1031faa  mov      x1, xzr
01753088  7f3a01b9  str      wzr, [x19, #0x138]
0175308c  c9041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753090  60a200f9  str      x0, [x19, #0x140]
01753094  e0031f2a  mov      w0, wzr
01753098  e1031faa  mov      x1, xzr
0175309c  c5041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017530a0  60a600f9  str      x0, [x19, #0x148]
017530a4  e0031f2a  mov      w0, wzr
017530a8  e1031faa  mov      x1, xzr
017530ac  c1041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017530b0  60aa00f9  str      x0, [x19, #0x150]
017530b4  e0031f2a  mov      w0, wzr
017530b8  e1031faa  mov      x1, xzr
017530bc  bd041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017530c0  60ae00f9  str      x0, [x19, #0x158]
017530c4  e0031f2a  mov      w0, wzr
017530c8  e1031faa  mov      x1, xzr
017530cc  b9041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017530d0  60b200f9  str      x0, [x19, #0x160]
017530d4  e0031f2a  mov      w0, wzr
017530d8  e1031faa  mov      x1, xzr
017530dc  b5041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017530e0  60b600f9  str      x0, [x19, #0x168]
017530e4  e0031f2a  mov      w0, wzr
017530e8  e1031faa  mov      x1, xzr
017530ec  b1041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017530f0  60ba00f9  str      x0, [x19, #0x170]
017530f4  e0031f2a  mov      w0, wzr
017530f8  e1031faa  mov      x1, xzr
017530fc  ad041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753100  60be00f9  str      x0, [x19, #0x178]
01753104  e0031f2a  mov      w0, wzr
01753108  e1031faa  mov      x1, xzr
0175310c  a9041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753110  60c200f9  str      x0, [x19, #0x180]
01753114  e0031f2a  mov      w0, wzr
01753118  e1031faa  mov      x1, xzr
0175311c  a5041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753120  60c600f9  str      x0, [x19, #0x188]
01753124  e0031f2a  mov      w0, wzr
01753128  e1031faa  mov      x1, xzr
0175312c  a1041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753130  60ca00f9  str      x0, [x19, #0x190]
01753134  e0031f2a  mov      w0, wzr
01753138  e1031faa  mov      x1, xzr
0175313c  9d041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753140  60ce00f9  str      x0, [x19, #0x198]
01753144  e0031f2a  mov      w0, wzr
01753148  e1031faa  mov      x1, xzr
0175314c  99041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753150  60d200f9  str      x0, [x19, #0x1a0]
01753154  e0031f2a  mov      w0, wzr
01753158  e1031faa  mov      x1, xzr
0175315c  95041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753160  60d600f9  str      x0, [x19, #0x1a8]
01753164  e0031f2a  mov      w0, wzr
01753168  e1031faa  mov      x1, xzr
0175316c  91041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753170  60da00f9  str      x0, [x19, #0x1b0]
01753174  e0031f2a  mov      w0, wzr
01753178  e1031faa  mov      x1, xzr
0175317c  8d041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753180  60de00f9  str      x0, [x19, #0x1b8]
01753184  e0031f2a  mov      w0, wzr
01753188  e1031faa  mov      x1, xzr
0175318c  89041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753190  60e200f9  str      x0, [x19, #0x1c0]
01753194  e0031f2a  mov      w0, wzr
01753198  e1031faa  mov      x1, xzr
0175319c  7fca01b9  str      wzr, [x19, #0x1c8]
017531a0  84041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017531a4  60ea00f9  str      x0, [x19, #0x1d0]
017531a8  e0031f2a  mov      w0, wzr
017531ac  e1031faa  mov      x1, xzr
017531b0  80041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017531b4  60ee00f9  str      x0, [x19, #0x1d8]
017531b8  e0031f2a  mov      w0, wzr
017531bc  e1031faa  mov      x1, xzr
017531c0  7c041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017531c4  60f200f9  str      x0, [x19, #0x1e0]
017531c8  e0031f2a  mov      w0, wzr
017531cc  e1031faa  mov      x1, xzr
017531d0  78041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017531d4  60f600f9  str      x0, [x19, #0x1e8]
017531d8  e0031f2a  mov      w0, wzr
017531dc  e1031faa  mov      x1, xzr
017531e0  74041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017531e4  60fa00f9  str      x0, [x19, #0x1f0]
017531e8  e0031f2a  mov      w0, wzr
017531ec  e1031faa  mov      x1, xzr
017531f0  70041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017531f4  60fe00f9  str      x0, [x19, #0x1f8]
017531f8  e0031f2a  mov      w0, wzr
017531fc  e1031faa  mov      x1, xzr
01753200  6c041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753204  600201f9  str      x0, [x19, #0x200]
01753208  e0031f2a  mov      w0, wzr
0175320c  e1031faa  mov      x1, xzr
01753210  68041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753214  600601f9  str      x0, [x19, #0x208]
01753218  e0031f2a  mov      w0, wzr
0175321c  e1031faa  mov      x1, xzr
01753220  64041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753224  600a01f9  str      x0, [x19, #0x210]
01753228  e0031f2a  mov      w0, wzr
0175322c  e1031faa  mov      x1, xzr
01753230  60041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753234  600e01f9  str      x0, [x19, #0x218]
01753238  e0031f2a  mov      w0, wzr
0175323c  e1031faa  mov      x1, xzr
01753240  5c041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753244  601201f9  str      x0, [x19, #0x220]
01753248  e0031f2a  mov      w0, wzr
0175324c  e1031faa  mov      x1, xzr
01753250  58041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753254  601601f9  str      x0, [x19, #0x228]
01753258  e0031f2a  mov      w0, wzr
0175325c  e1031faa  mov      x1, xzr
01753260  54041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753264  601a01f9  str      x0, [x19, #0x230]
01753268  e0031f2a  mov      w0, wzr
0175326c  e1031faa  mov      x1, xzr
01753270  50041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753274  601e01f9  str      x0, [x19, #0x238]
01753278  e0031f2a  mov      w0, wzr
0175327c  e1031faa  mov      x1, xzr
01753280  4c041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753284  602201f9  str      x0, [x19, #0x240]
01753288  e0031f2a  mov      w0, wzr
0175328c  e1031faa  mov      x1, xzr
01753290  48041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753294  602601f9  str      x0, [x19, #0x248]
01753298  e0031f2a  mov      w0, wzr
0175329c  e1031faa  mov      x1, xzr
017532a0  44041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017532a4  602a01f9  str      x0, [x19, #0x250]
017532a8  e0031f2a  mov      w0, wzr
017532ac  e1031faa  mov      x1, xzr
017532b0  40041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017532b4  602e01f9  str      x0, [x19, #0x258]
017532b8  e0031f2a  mov      w0, wzr
017532bc  e1031faa  mov      x1, xzr
017532c0  3c041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017532c4  603201f9  str      x0, [x19, #0x260]
017532c8  e0031f2a  mov      w0, wzr
017532cc  e1031faa  mov      x1, xzr
017532d0  38041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017532d4  603601f9  str      x0, [x19, #0x268]
017532d8  e0031f2a  mov      w0, wzr
017532dc  e1031faa  mov      x1, xzr
017532e0  34041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017532e4  603a01f9  str      x0, [x19, #0x270]
017532e8  e0031f2a  mov      w0, wzr
017532ec  e1031faa  mov      x1, xzr
017532f0  30041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017532f4  603e01f9  str      x0, [x19, #0x278]
017532f8  e0031f2a  mov      w0, wzr
017532fc  e1031faa  mov      x1, xzr
01753300  2c041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753304  604201f9  str      x0, [x19, #0x280]
01753308  e0031f2a  mov      w0, wzr
0175330c  e1031faa  mov      x1, xzr
01753310  28041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753314  604601f9  str      x0, [x19, #0x288]
01753318  e0031f2a  mov      w0, wzr
0175331c  e1031faa  mov      x1, xzr
01753320  24041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753324  604a01f9  str      x0, [x19, #0x290]
01753328  e0031f2a  mov      w0, wzr
0175332c  e1031faa  mov      x1, xzr
01753330  20041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753334  604e01f9  str      x0, [x19, #0x298]
01753338  e0031f2a  mov      w0, wzr
0175333c  e1031faa  mov      x1, xzr
01753340  1c041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753344  605201f9  str      x0, [x19, #0x2a0]
01753348  e0031f2a  mov      w0, wzr
0175334c  e1031faa  mov      x1, xzr
01753350  18041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753354  605601f9  str      x0, [x19, #0x2a8]
01753358  e0031f2a  mov      w0, wzr
0175335c  e1031faa  mov      x1, xzr
01753360  14041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753364  605a01f9  str      x0, [x19, #0x2b0]
01753368  e0031f2a  mov      w0, wzr
0175336c  e1031faa  mov      x1, xzr
01753370  10041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753374  605e01f9  str      x0, [x19, #0x2b8]
01753378  e0031f2a  mov      w0, wzr
0175337c  e1031faa  mov      x1, xzr
01753380  0c041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753384  606201f9  str      x0, [x19, #0x2c0]
01753388  e0031f2a  mov      w0, wzr
0175338c  e1031faa  mov      x1, xzr
01753390  08041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
01753394  606601f9  str      x0, [x19, #0x2c8]
01753398  e0031f2a  mov      w0, wzr
0175339c  e1031faa  mov      x1, xzr
017533a0  04041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017533a4  606a01f9  str      x0, [x19, #0x2d0]
017533a8  e0031f2a  mov      w0, wzr
017533ac  e1031faa  mov      x1, xzr
017533b0  00041e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017533b4  606e01f9  str      x0, [x19, #0x2d8]
017533b8  e0031f2a  mov      w0, wzr
017533bc  e1031faa  mov      x1, xzr
017533c0  fc031e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017533c4  607201f9  str      x0, [x19, #0x2e0]
017533c8  e0031f2a  mov      w0, wzr
017533cc  e1031faa  mov      x1, xzr
017533d0  f8031e94  bl       #0x1ed43b0 ; BattleCore.FP$$op_Implicit
017533d4  747a41f9  ldr      x20, [x19, #0x2f0]
017533d8  607601f9  str      x0, [x19, #0x2e8]
017533dc  740000b5  cbnz     x20, #0x17533e8
017533e0  e0031faa  mov      x0, xzr
017533e4  d260d797  bl       #0xd2b72c ; unresolved symbol
017533e8  08ac0090  adrp     x8, #0x2cd3000
017533ec  084542f9  ldr      x8, [x8, #0x488]
017533f0  fd7b41a9  ldp      x29, x30, [sp, #0x10]
017533f4  e00314aa  mov      x0, x20
017533f8  010140f9  ldr      x1, [x8]
017533fc  f44fc2a8  ldp      x20, x19, [sp], #0x20
01753400  d8a42714  b        #0x213c760 ; System.Collections.Generic.List<ActorAttrImpactData>$$Clear | System.Collections.Generic.List<ActorAttrImpactMgr>$$Clear | System.Collections.Generic.List<ActorEntity>$$Clear | System.Collections.Generic.List<ActorEntityCmpt>$$Clear | System.Collections.Generic.List<AutoReliveTimerData>$$Clear | System.Collections.Generic.List<BattleCmdRun>$$Clear | System.Collections.Generic.List<BattlePvpPlayerInfo>$$Clear | System.Collections.Generic.List<BattleSystem>$$Clear | System.Collections.Generic.List<BeastTideCollectItemEntity>$$Clear | System.Collections.Generic.List<BuffRecordData>$$Clear | System.Collections.Generic.List<BufferItem>$$Clear | System.Collections.Generic.List<Bullet>$$Clear | System.Collections.Generic.List<CollectItemEntity>$$Clear | System.Collections.Generic.List<EntityVisualEventNode>$$Clear | System.Collections.Generic.List<EventRegInfo>$$Clear | System.Collections.Generic.List<FTimer>$$Clear | System.Collections.Generic.List<InputCmdDataPlayerSet>$$Clear | System.Collections.Generic.List<InputCmdFrameData>$$Clear | System.Collections.Generic.List<IslandAdvItemData>$$Clear | System.Collections.Generic.List<IslandAdvItemPosData>$$Clear | System.Collections.Generic.List<LevelCollectItemMgr.CollectItemWaveInfo>$$Clear | System.Collections.Generic.List<LevelDropParam>$$Clear | System.Collections.Generic.List<LevelGuardBlitzMonsterData>$$Clear | System.Collections.Generic.List<LevelItemEntity>$$Clear | System.Collections.Generic.List<LevelPPTTOneWaveCtrl>$$Clear | System.Collections.Generic.List<LightChainNode>$$Clear | System.Collections.Generic.List<MergeItemInfo>$$Clear | System.Collections.Generic.List<MiJingBossBuffData>$$Clear | System.Collections.Generic.List<MonsterBuffData>$$Clear | System.Collections.Generic.List<MoveAgentList>$$Clear | System.Collections.Generic.List<PlayerCollectItemRecore>$$Clear | System.Collections.Generic.List<PlayerSummonElemData>$$Clear | System.Collections.Generic.List<SacredEquipEntry>$$Clear | System.Collections.Generic.List<ShadowActionData>$$Clear | System.Collections.Generic.List<ShadowSkillEntry>$$Clear | System.Collections.Generic.List<ShootPointTargetData>$$Clear | System.Collections.Generic.List<SkillElementHandle>$$Clear | System.Collections.Generic.List<SkillElementRepeatHandle>$$Clear | System.Collections.Generic.List<SkillPlayData>$$Clear | System.Collections.Generic.List<SkillRepeatPlayData>$$Clear | System.Collections.Generic.List<SkillRepeatTranslateHandle.MoveData>$$Clear | System.Collections.Generic.List<SkillShootTargetData>$$Clear | System.Collections.Generic.List<ZhaoShiBattleAttrData>$$Clear | System.Collections.Generic.List<ActorAttrImpactData>$$Clear | System.Collections.Generic.List<ActorCmpt>$$Clear | System.Collections.Generic.List<ActorEffectModel.TrailRendererData>$$Clear | System.Collections.Generic.List<AdTreasureLayerItem.StepData>$$Clear | System.Collections.Generic.List<ArrowScoreItem>$$Clear | System.Collections.Generic.List<AstrologyDrawPageUI.StepData>$$Clear | System.Collections.Generic.List<BaseAudioPlayData>$$Clear | System.Collections.Generic.List<BaseBehaviourSingleton>$$Clear | System.Collections.Generic.List<BattleMainPvpRankItem>$$Clear | System.Collections.Generic.List<BattlePvpPlayer>$$Clear | System.Collections.Generic.List<BattleRunData>$$Clear | System.Collections.Generic.List<BianShenInfo>$$Clear | System.Collections.Generic.List<BootyObjData>$$Clear | System.Collections.Generic.List<BuffShowItemData>$$Clear | System.Collections.Generic.List<BuffVisualItem>$$Clear | System.Collections.Generic.List<CardEntry>$$Clear | System.Collections.Generic.List<ChannelMiniGameMainUIItem>$$Clear | System.Collections.Generic.List<ChannelNameData>$$Clear | System.Collections.Generic.List<ChnlMnGmRwdItem>$$Clear | System.Collections.Generic.List<CmOptionalAddItem>$$Clear | System.Collections.Generic.List<CmOptionalPreviewItem>$$Clear | System.Collections.Generic.List<CommonUIAnimationItem>$$Clear | System.Collections.Generic.List<ContactsData>$$Clear | System.Collections.Generic.List<CostRankData>$$Clear | System.Collections.Generic.List<CurrencyItem>$$Clear | System.Collections.Generic.List<DiamondGiftData>$$Clear | System.Collections.Generic.List<DiamondGiftDiyEntry>$$Clear | System.Collections.Generic.List<DiamondGoodsData>$$Clear | System.Collections.Generic.List<DownloadInfo>$$Clear | System.Collections.Generic.List<EditorAbDirPackConfigItem>$$Clear | System.Collections.Generic.List<ElvesInfo>$$Clear | System.Collections.Generic.List<EquipItem>$$Clear | System.Collections.Generic.List<EventRegInfo>$$Clear | System.Collections.Generic.List<FaBaoHunLingInfo>$$Clear | System.Collections.Generic.List<FaBaoInfo>$$Clear | System.Collections.Generic.List<FaBaoWakeSkillEquipItem>$$Clear | System.Collections.Generic.List<FashionInfo>$$Clear | System.Collections.Generic.List<GiftBagData>$$Clear | System.Collections.Generic.List<GoodsInfo>$$Clear | System.Collections.Generic.List<HarvestOfferingUI.StepData>$$Clear | System.Collections.Generic.List<HolidayLimitConsumeEntry>$$Clear | System.Collections.Generic.List<HuntInfoItem>$$Clear | System.Collections.Generic.List<ILineRenderController>$$Clear | System.Collections.Generic.List<IslandGiftAwardItem>$$Clear | System.Collections.Generic.List<IslandGiftUI.StepData>$$Clear | System.Collections.Generic.List<JingMaiItem>$$Clear | System.Collections.Generic.List<JingMaiLine>$$Clear | System.Collections.Generic.List<LYXFSpecialObject>$$Clear | System.Collections.Generic.List<LightChainNodeVisual>$$Clear | System.Collections.Generic.List<LimitChargeEntry>$$Clear | System.Collections.Generic.List<LingChiItem>$$Clear | System.Collections.Generic.List<LongHunInfo>$$Clear | System.Collections.Generic.List<LordInfoData>$$Clear | System.Collections.Generic.List<LvYinXfFootBall>$$Clear | System.Collections.Generic.List<MHZBSlotData>$$Clear | System.Collections.Generic.List<MazePos>$$Clear | System.Collections.Generic.List<MsgHandleDataToRmv>$$Clear | System.Collections.Generic.List<MysticalTreasureMainUI.StepData>$$Clear | System.Collections.Generic.List<PersonalGiftData>$$Clear | System.Collections.Generic.List<PersonalGiftDiyEntry>$$Clear | System.Collections.Generic.List<PetItemInfo>$$Clear | System.Collections.Generic.List<PetSkillChooseItem>$$Clear | System.Collections.Generic.List<PlayerHeadItemParam>$$Clear | System.Collections.Generic.List<PvpMatchPlayerData>$$Clear | System.Collections.Generic.List<QunyingChapterData>$$Clear | System.Collections.Generic.List<RankData>$$Clear | System.Collections.Generic.List<RedDotNode>$$Clear | System.Collections.Generic.List<SacredBeastWidget>$$Clear | System.Collections.Generic.List<SacredEquipData>$$Clear | System.Collections.Generic.List<SeriesData>$$Clear | System.Collections.Generic.List<SevenSignItem>$$Clear | System.Collections.Generic.List<SingleChargeItem>$$Clear | System.Collections.Generic.List<SkillHandleVisual>$$Clear | System.Collections.Generic.List<SpiritInfo>$$Clear | System.Collections.Generic.List<SpringActivitySignItem>$$Clear | System.Collections.Generic.List<SummonInfo>$$Clear | System.Collections.Generic.List<SuperRewardItem>$$Clear | System.Collections.Generic.List<TeammateData>$$Clear | System.Collections.Generic.List<TerrPetInfo>$$Clear | System.Collections.Generic.List<TerritoryResInfo>$$Clear | System.Collections.Generic.List<TianFuInfo>$$Clear | System.Collections.Generic.List<TianGongInfo>$$Clear | System.Collections.Generic.List<TowerLayer>$$Clear | System.Collections.Generic.List<TreasureItem>$$Clear | System.Collections.Generic.List<UIEffectGo>$$Clear | System.Collections.Generic.List<UIWindow>$$Clear | System.Collections.Generic.List<UIWindowBase>$$Clear | System.Collections.Generic.List<UpLvNeedData>$$Clear | System.Collections.Generic.List<WenZhangGMItem>$$Clear | System.Collections.Generic.List<WheelStepData>$$Clear | System.Collections.Generic.List<WindowMsgRecord>$$Clear | System.Collections.Generic.List<WorldInfo>$$Clear | System.Collections.Generic.List<WuXueInfo>$$Clear | System.Collections.Generic.List<YongPanLayerItem.StepData>$$Clear | System.Collections.Generic.List<BeastTideCollectItemPoolConfig>$$Clear | System.Collections.Generic.List<BeastTideSkillConfig>$$Clear | System.Collections.Generic.List<BeastTideSpawnPosConfig>$$Clear | System.Collections.Generic.List<BootyConfig>$$Clear | System.Collections.Generic.List<CSRelayRoomPlayerInfo>$$Clear | System.Collections.Generic.List<ForeverBornPosConfig>$$Clear | System.Collections.Generic.List<ForeverMonsterLibraryConfig>$$Clear | System.Collections.Generic.List<GuardBlitzBornPosConfig>$$Clear | System.Collections.Generic.List<MiJingBornPosConfig>$$Clear | System.Collections.Generic.List<MiJingMonsterLibraryConfig>$$Clear | System.Collections.Generic.List<Body>$$Clear | System.Collections.Generic.List<RandomSkillConfig>$$Clear | System.Collections.Generic.List<ChatData>$$Clear | System.Collections.Generic.List<AssetBundleInfo>$$Clear | System.Collections.Generic.List<AssetBundleRule>$$Clear | System.Collections.Generic.List<AssetPreloadResWebGLItem>$$Clear | System.Collections.Generic.List<DelayDestroyGo>$$Clear | System.Collections.Generic.List<DodLinkText>$$Clear | System.Collections.Generic.List<DodText>$$Clear | System.Collections.Generic.List<LoopListViewItem>$$Clear | System.Collections.Generic.List<VisualEntityCmptDebugKeyInfo>$$Clear | System.Collections.Generic.List<DynamicBone.Particle>$$Clear | System.Collections.Generic.List<DynamicBone>$$Clear | System.Collections.Generic.List<DynamicBoneCollider>$$Clear | System.Collections.Generic.List<EffectBenchmarkResult>$$Clear | System.Collections.Generic.List<EventDelegate>$$Clear | System.Collections.Generic.List<IMMessage>$$Clear | System.Collections.Generic.List<BootyConfig>$$Clear | System.Collections.Generic.List<EquipConfig>$$Clear | System.Collections.Generic.List<MultiplayerExpressionConfig>$$Clear | System.Collections.Generic.List<PowerBoostGuide>$$Clear | System.Collections.Generic.List<RankConfig>$$Clear | System.Collections.Generic.List<ResAttrImpactData>$$Clear | System.Collections.Generic.List<SummonBaseConfig>$$Clear | System.Collections.Generic.List<SkillEffectInfo>$$Clear | System.Collections.Generic.List<Animation>$$Clear | System.Collections.Generic.List<Attachment>$$Clear | System.Collections.Generic.List<Bone>$$Clear | System.Collections.Generic.List<SkeletonJson.LinkedMesh>$$Clear | System.Collections.Generic.List<Slot>$$Clear | System.Collections.Generic.List<SkeletonUtilityBone>$$Clear | System.Collections.Generic.List<SkeletonUtilityConstraint>$$Clear | System.Collections.Generic.List<object>$$Clear | System.Collections.Generic.List<string>$$Clear | System.Collections.Generic.List<Animator>$$Clear | System.Collections.Generic.List<BoxCollider>$$Clear | System.Collections.Generic.List<EventTrigger.Entry>$$Clear | System.Collections.Generic.List<IEventSystemHandler>$$Clear | System.Collections.Generic.List<BaseInvokableCall>$$Clear | System.Collections.Generic.List<ISubsystem>$$Clear | System.Collections.Generic.List<ISubsystemDescriptorImpl>$$Clear | System.Collections.Generic.List<GameObject>$$Clear | System.Collections.Generic.List<Material>$$Clear | System.Collections.Generic.List<ParticleSystem>$$Clear | System.Collections.Generic.List<RectTransform>$$Clear | System.Collections.Generic.List<Texture2D>$$Clear | System.Collections.Generic.List<Transform>$$Clear | System.Collections.Generic.List<Dropdown.DropdownItem>$$Clear | System.Collections.Generic.List<Dropdown.OptionData>$$Clear | System.Collections.Generic.List<Graphic>$$Clear | System.Collections.Generic.List<Image>$$Clear | System.Collections.Generic.List<RectMask2D>$$Clear | System.Collections.Generic.List<StencilMaterial.MatEntry>$$Clear | System.Collections.Generic.List<VerticalText.DodLineInfo>$$Clear | System.Collections.Generic.List<CSActivityOpenEntry>$$Clear | System.Collections.Generic.List<CSAdVideoProgressAwardCfgEntry>$$Clear | System.Collections.Generic.List<CSAstrologyCreditDataEntry>$$Clear | System.Collections.Generic.List<CSAstrologyDrawnRecordEntry>$$Clear | System.Collections.Generic.List<CSAstrologyTaskDataEntry>$$Clear | System.Collections.Generic.List<CSBeastTideChapterData>$$Clear | System.Collections.Generic.List<CSBianShenEntry>$$Clear | System.Collections.Generic.List<CSBlissExchangeCfgEntry>$$Clear | System.Collections.Generic.List<CSBlissExchangeDataEntry>$$Clear | System.Collections.Generic.List<CSBlissLotteryCfgEntry>$$Clear | System.Collections.Generic.List<CSBlissParamCfgEntry>$$Clear | System.Collections.Generic.List<CSBootyAwardItem>$$Clear | System.Collections.Generic.List<CSBootyAwardList>$$Clear | System.Collections.Generic.List<CSBroadcastNotifyRes>$$Clear | System.Collections.Generic.List<CSCaveTreasureGiftDataEntry>$$Clear | System.Collections.Generic.List<CSCaveTreasurePoolDataEntry>$$Clear | System.Collections.Generic.List<CSCaveTreasureTaskDataEntry>$$Clear | System.Collections.Generic.List<CSConsumeRankActBootyEntry>$$Clear | System.Collections.Generic.List<CSCumuChargeActEntry>$$Clear | System.Collections.Generic.List<CSCumuGiftEntryCfg>$$Clear | System.Collections.Generic.List<CSDailyTaskProgressAward>$$Clear | System.Collections.Generic.List<CSDanYaoComposeEntry>$$Clear | System.Collections.Generic.List<CSDanYaoUseEntry>$$Clear | System.Collections.Generic.List<CSDuoBaoActCellDataEntry>$$Clear | System.Collections.Generic.List<CSDuoBaoActCfgEntry>$$Clear | System.Collections.Generic.List<CSEachAwardEntry>$$Clear | System.Collections.Generic.List<CSElementTowerEntry>$$Clear | System.Collections.Generic.List<CSElfEntry>$$Clear | System.Collections.Generic.List<CSElfHelpEntry>$$Clear | System.Collections.Generic.List<CSElfPlaceEntry>$$Clear | System.Collections.Generic.List<CSFaBaoEntry>$$Clear | System.Collections.Generic.List<CSFaBaoSpiritEntry>$$Clear | System.Collections.Generic.List<CSFestCumuChargeActEntry>$$Clear | System.Collections.Generic.List<CSFestLevelLimitGiftCfgEntry>$$Clear | System.Collections.Generic.List<CSFestivalExchangeCfgEntry>$$Clear | System.Collections.Generic.List<CSFestivalJiziCfgEntry>$$Clear | System.Collections.Generic.List<CSFestivalSignActCfgEntry>$$Clear | System.Collections.Generic.List<CSFinChapterRewardEntry>$$Clear | System.Collections.Generic.List<CSFreeBuyActCfgEntry>$$Clear | System.Collections.Generic.List<CSFreeBuyActDataEntry>$$Clear | System.Collections.Generic.List<CSGlobalTimeLuckActDataEntry>$$Clear | System.Collections.Generic.List<CSGlobalXianJunActDataEntry>$$Clear | System.Collections.Generic.List<CSGrowFundAwardCfgEntry>$$Clear | System.Collections.Generic.List<CSIslandAdventureFinAwardCfg>$$Clear | System.Collections.Generic.List<CSIslandAdventureScoreAwardCfg>$$Clear | System.Collections.Generic.List<CSJHSingleChargeConfigEntry>$$Clear | System.Collections.Generic.List<CSJHSingleChargeGoodEntry>$$Clear | System.Collections.Generic.List<CSJiangHuActBootyEntry>$$Clear | System.Collections.Generic.List<CSJiangHuActCellEntry>$$Clear | System.Collections.Generic.List<CSJiangHuActConsumeEntry>$$Clear | System.Collections.Generic.List<CSJingMaiEntry>$$Clear | System.Collections.Generic.List<CSLevelLimitGiftCfgEntry>$$Clear | System.Collections.Generic.List<CSLianXieEntry>$$Clear | System.Collections.Generic.List<CSLingChiFiveEleEntry>$$Clear | System.Collections.Generic.List<CSMHZBMatchPlayerEntry>$$Clear | System.Collections.Generic.List<CSMailListData>$$Clear | System.Collections.Generic.List<CSMenPaiEventEntry>$$Clear | System.Collections.Generic.List<CSMenPaiNpcEntry>$$Clear | System.Collections.Generic.List<CSMenPaiQiYuEntry>$$Clear | System.Collections.Generic.List<CSMiJingRankAwardEntry>$$Clear | System.Collections.Generic.List<CSMiJingScoreAwardEntry>$$Clear | System.Collections.Generic.List<CSMiniGameChapterCfg>$$Clear | System.Collections.Generic.List<CSMiniGameChapterData>$$Clear | System.Collections.Generic.List<CSMiniGameProgressAwardCfg>$$Clear | System.Collections.Generic.List<CSMiniGameStageCfg>$$Clear | System.Collections.Generic.List<CSMultiItemComposeEntry>$$Clear | System.Collections.Generic.List<CSNYALoginEntry>$$Clear | System.Collections.Generic.List<CSNYAShopCfgEntry>$$Clear | System.Collections.Generic.List<CSNYAShopEntry>$$Clear | System.Collections.Generic.List<CSNewLianXuChargeActCfgEntry>$$Clear | System.Collections.Generic.List<CSOneShopItemData>$$Clear | System.Collections.Generic.List<CSPPTTFinChapterAwardEntry>$$Clear | System.Collections.Generic.List<CSPPTTScoreAwardEntry>$$Clear | System.Collections.Generic.List<CSPvpAwardDailyBattleCfgEntry>$$Clear | System.Collections.Generic.List<CSPvpAwardDailyBattleDataEntry>$$Clear | System.Collections.Generic.List<CSPvpAwardDivisionCfgEntry>$$Clear | System.Collections.Generic.List<CSPvpAwardSeasonBattleCfgEntry>$$Clear | System.Collections.Generic.List<CSQiHunEntry>$$Clear | System.Collections.Generic.List<CSQiYuanEntry>$$Clear | System.Collections.Generic.List<CSRiceFullCumuBoxDataEntry>$$Clear | System.Collections.Generic.List<CSRiceFullDayDataEntry>$$Clear | System.Collections.Generic.List<CSRoleBaseMiniShowData>$$Clear | System.Collections.Generic.List<CSSeniorLianXuChargeCfgEntry>$$Clear | System.Collections.Generic.List<CSShuangXiuRecordEntry>$$Clear | System.Collections.Generic.List<CSSignActAwardDataEntry>$$Clear | System.Collections.Generic.List<CSSingleChargeConfigEntry>$$Clear | System.Collections.Generic.List<CSSpiritFormatEntry>$$Clear | System.Collections.Generic.List<CSSpiritSkillEntry>$$Clear | System.Collections.Generic.List<CSSpiritSkillSlotEntry>$$Clear | System.Collections.Generic.List<CSSummonAwakeEntry>$$Clear | System.Collections.Generic.List<CSSummonSkillEntry>$$Clear | System.Collections.Generic.List<CSSuperFundAwardCfgEntry>$$Clear | System.Collections.Generic.List<CSSuperMonthCardBootyCfg>$$Clear | System.Collections.Generic.List<CSSysPrivilegeCardEntry>$$Clear | System.Collections.Generic.List<CSTCExchangeAwardCfgEntry>$$Clear | System.Collections.Generic.List<CSTCGiftEntry>$$Clear | System.Collections.Generic.List<CSTCLoginEntry>$$Clear | System.Collections.Generic.List<CSTCLotteryCfgEntry>$$Clear | System.Collections.Generic.List<CSTCMilestoneEntry>$$Clear | System.Collections.Generic.List<CSTCParamCfg>$$Clear | System.Collections.Generic.List<CSTCTaskCfgEntry>$$Clear | System.Collections.Generic.List<CSTCTaskEntry>$$Clear | System.Collections.Generic.List<CSTerritoryDailyTaskEntry>$$Clear | System.Collections.Generic.List<CSTerritoryLogEntry>$$Clear | System.Collections.Generic.List<CSTerritoryPetEntry>$$Clear | System.Collections.Generic.List<CSTerritoryVisitEntry>$$Clear | System.Collections.Generic.List<CSTianTianChargeActCfgEntry>$$Clear | System.Collections.Generic.List<CSTimeLuckActBaseCfgEntry>$$Clear | System.Collections.Generic.List<CSTimeLuckLotteryTypeCfgEntry>$$Clear | System.Collections.Generic.List<CSTimeLuckProgressCfgEntry>$$Clear | System.Collections.Generic.List<CSWechatInviteDailyTaskCfgEntry>$$Clear | System.Collections.Generic.List<CSWechatInviteInviteCfgEntry>$$Clear | System.Collections.Generic.List<CSWorldBossDataEntry>$$Clear | System.Collections.Generic.List<CSWuXingDungeonGiftData>$$Clear | System.Collections.Generic.List<CSWxInviteFinChapterCfgEntry>$$Clear | System.Collections.Generic.List<CSXiaKeXingConfigEntry>$$Clear | System.Collections.Generic.List<CSXianJieActScoreRewardCfgEntry>$$Clear | System.Collections.Generic.List<CSXianJieActSignDataEntry>$$Clear | System.Collections.Generic.List<CSXianJieActTaskCfgEntry>$$Clear | System.Collections.Generic.List<CSXianYuanGlobalDataEntry>$$Clear | System.Collections.Generic.List<CSXinChunJiziCfgEntry>$$Clear | System.Collections.Generic.List<CSXinChunLimitGiftCfgEntry>$$Clear | System.Collections.Generic.List<CSXinChunWeekCardCfgEntry>$$Clear | System.Collections.Generic.List<CSZhaoCaiActRecordEntry>$$Clear | System.Collections.Generic.List<CsCustomBossGlobalRecord>$$Clear | System.Collections.Generic.List<CsDuoBaoPlayerRecordEntry>$$Clear | System.Collections.Generic.List<CsDuoBaoRecordEntry>$$Clear | System.Collections.Generic.List<LeagueApplyEntry>$$Clear | System.Collections.Generic.List<LeagueMazeEventEntry>$$Clear | System.Collections.Generic.List<LeagueMazeLogEntry>$$Clear | System.Collections.Generic.List<LeagueMazeRoomData>$$Clear | System.Collections.Generic.List<LeagueMemberEntry>$$Clear | System.Collections.Generic.List<LeagueShowData>$$Clear | System.Collections.Generic.List<SummonDsphFriendEntry>$$Clear | System.Collections.Generic.List<SummonDsphLogEntry>$$Clear | System.Collections.Generic.List<SummonDsphOccupyEntry>$$Clear
