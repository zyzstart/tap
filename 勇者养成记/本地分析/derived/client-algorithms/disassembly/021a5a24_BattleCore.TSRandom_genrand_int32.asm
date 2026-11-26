; RVA 0x21a5a24, file offset 0x21a5a24, conservative end 0x21a5e3c
; SHA256 7ce8063eb6b82522777989007be48f7a277f1f80dece878a28eafe7e2cd57c5e
; All aliases at this entry: BattleCore.TSRandom$$genrand_int32 :: uint32_t BattleCore_TSRandom__genrand_int32 (BattleCore_TSRandom_o* __this, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
021a5a24  fc6fbaa9  stp      x28, x27, [sp, #-0x60]!
021a5a28  fa6701a9  stp      x26, x25, [sp, #0x10]
021a5a2c  f85f02a9  stp      x24, x23, [sp, #0x20]
021a5a30  f65703a9  stp      x22, x21, [sp, #0x30]
021a5a34  f44f04a9  stp      x20, x19, [sp, #0x40]
021a5a38  fd7b05a9  stp      x29, x30, [sp, #0x50]
021a5a3c  fd430191  add      x29, sp, #0x50
021a5a40  f30300aa  mov      x19, x0
021a5a44  752240b9  ldr      w21, [x19, #0x20]
021a5a48  bfbe0971  cmp      w21, #0x26f
021a5a4c  8d1b0054  b.le     #0x21a5dbc
021a5a50  bfc60971  cmp      w21, #0x271
021a5a54  81000054  b.ne     #0x21a5a64
021a5a58  21ae8252  mov      w1, #0x1571
021a5a5c  e00313aa  mov      x0, x19
021a5a60  bcfeff97  bl       #0x21a5550 ; BattleCore.TSRandom$$init_genrand
021a5a64  f4031faa  mov      x20, xzr
021a5a68  750e40f9  ldr      x21, [x19, #0x18]
021a5a6c  750000b5  cbnz     x21, #0x21a5a78
021a5a70  e0031faa  mov      x0, xzr
021a5a74  2e17ae97  bl       #0xd2b72c ; unresolved symbol
021a5a78  a81a40b9  ldr      w8, [x21, #0x18]
021a5a7c  9f0208eb  cmp      x20, x8
021a5a80  a3000054  b.lo     #0x21a5a94
021a5a84  631aae97  bl       #0xd2c410 ; unresolved symbol
021a5a88  e1031faa  mov      x1, xzr
021a5a8c  e2031faa  mov      x2, xzr
021a5a90  0317ae97  bl       #0xd2b69c ; unresolved symbol
021a5a94  a80a148b  add      x8, x21, x20, lsl #2
021a5a98  750e40f9  ldr      x21, [x19, #0x18]
021a5a9c  162140b9  ldr      w22, [x8, #0x20]
021a5aa0  750000b5  cbnz     x21, #0x21a5aac
021a5aa4  e0031faa  mov      x0, xzr
021a5aa8  2117ae97  bl       #0xd2b72c ; unresolved symbol
021a5aac  a81a40b9  ldr      w8, [x21, #0x18]
021a5ab0  97060091  add      x23, x20, #1
021a5ab4  ff0208eb  cmp      x23, x8
021a5ab8  a3000054  b.lo     #0x21a5acc
021a5abc  551aae97  bl       #0xd2c410 ; unresolved symbol
021a5ac0  e1031faa  mov      x1, xzr
021a5ac4  e2031faa  mov      x2, xzr
021a5ac8  f516ae97  bl       #0xd2b69c ; unresolved symbol
021a5acc  a80a148b  add      x8, x21, x20, lsl #2
021a5ad0  750e40f9  ldr      x21, [x19, #0x18]
021a5ad4  182540b9  ldr      w24, [x8, #0x24]
021a5ad8  750000b5  cbnz     x21, #0x21a5ae4
021a5adc  e0031faa  mov      x0, xzr
021a5ae0  1317ae97  bl       #0xd2b72c ; unresolved symbol
021a5ae4  a81a40b9  ldr      w8, [x21, #0x18]
021a5ae8  f7320691  add      x23, x23, #0x18c
021a5aec  ff0208eb  cmp      x23, x8
021a5af0  a3000054  b.lo     #0x21a5b04
021a5af4  471aae97  bl       #0xd2c410 ; unresolved symbol
021a5af8  e1031faa  mov      x1, xzr
021a5afc  e2031faa  mov      x2, xzr
021a5b00  e716ae97  bl       #0xd2b69c ; unresolved symbol
021a5b04  a80a148b  add      x8, x21, x20, lsl #2
021a5b08  7a0a40f9  ldr      x26, [x19, #0x10]
021a5b0c  195546b9  ldr      w25, [x8, #0x654]
021a5b10  d6020112  and      w22, w22, #0x80000000
021a5b14  1b771f12  and      w27, w24, #0x7ffffffe
021a5b18  7a0000b5  cbnz     x26, #0x21a5b24
021a5b1c  e0031faa  mov      x0, xzr
021a5b20  0317ae97  bl       #0xd2b72c ; unresolved symbol
021a5b24  481b40b9  ldr      w8, [x26, #0x18]
021a5b28  18030012  and      w24, w24, #1
021a5b2c  7603162a  orr      w22, w27, w22
021a5b30  1f03086b  cmp      w24, w8
021a5b34  a3000054  b.lo     #0x21a5b48
021a5b38  361aae97  bl       #0xd2c410 ; unresolved symbol
021a5b3c  e1031faa  mov      x1, xzr
021a5b40  e2031faa  mov      x2, xzr
021a5b44  d616ae97  bl       #0xd2b69c ; unresolved symbol
021a5b48  480b188b  add      x8, x26, x24, lsl #2
021a5b4c  a91a40b9  ldr      w9, [x21, #0x18]
021a5b50  082140b9  ldr      w8, [x8, #0x20]
021a5b54  2a07564a  eor      w10, w25, w22, lsr #1
021a5b58  f73606d1  sub      x23, x23, #0x18d
021a5b5c  ff0209eb  cmp      x23, x9
021a5b60  5601084a  eor      w22, w10, w8
021a5b64  a3000054  b.lo     #0x21a5b78
021a5b68  2a1aae97  bl       #0xd2c410 ; unresolved symbol
021a5b6c  e1031faa  mov      x1, xzr
021a5b70  e2031faa  mov      x2, xzr
021a5b74  ca16ae97  bl       #0xd2b69c ; unresolved symbol
021a5b78  a80a148b  add      x8, x21, x20, lsl #2
021a5b7c  f4060091  add      x20, x23, #1
021a5b80  9f8e03f1  cmp      x20, #0xe3
021a5b84  162100b9  str      w22, [x8, #0x20]
021a5b88  01f7ff54  b.ne     #0x21a5a68
021a5b8c  f4031f2a  mov      w20, wzr
021a5b90  48000014  b        #0x21a5cb0
021a5b94  c81a40b9  ldr      w8, [x22, #0x18]
021a5b98  157f4093  sxtw     x21, w24
021a5b9c  1f03086b  cmp      w24, w8
021a5ba0  a3000054  b.lo     #0x21a5bb4
021a5ba4  1b1aae97  bl       #0xd2c410 ; unresolved symbol
021a5ba8  e1031faa  mov      x1, xzr
021a5bac  e2031faa  mov      x2, xzr
021a5bb0  bb16ae97  bl       #0xd2b69c ; unresolved symbol
021a5bb4  c80a158b  add      x8, x22, x21, lsl #2
021a5bb8  760e40f9  ldr      x22, [x19, #0x18]
021a5bbc  172140b9  ldr      w23, [x8, #0x20]
021a5bc0  760000b5  cbnz     x22, #0x21a5bcc
021a5bc4  e0031faa  mov      x0, xzr
021a5bc8  d916ae97  bl       #0xd2b72c ; unresolved symbol
021a5bcc  c81a40b9  ldr      w8, [x22, #0x18]
021a5bd0  89920311  add      w9, w20, #0xe4
021a5bd4  18070011  add      w24, w24, #1
021a5bd8  397d4093  sxtw     x25, w9
021a5bdc  1f03086b  cmp      w24, w8
021a5be0  a3000054  b.lo     #0x21a5bf4
021a5be4  0b1aae97  bl       #0xd2c410 ; unresolved symbol
021a5be8  e1031faa  mov      x1, xzr
021a5bec  e2031faa  mov      x2, xzr
021a5bf0  ab16ae97  bl       #0xd2b69c ; unresolved symbol
021a5bf4  c80a198b  add      x8, x22, x25, lsl #2
021a5bf8  760e40f9  ldr      x22, [x19, #0x18]
021a5bfc  192140b9  ldr      w25, [x8, #0x20]
021a5c00  760000b5  cbnz     x22, #0x21a5c0c
021a5c04  e0031faa  mov      x0, xzr
021a5c08  c916ae97  bl       #0xd2b72c ; unresolved symbol
021a5c0c  c81a40b9  ldr      w8, [x22, #0x18]
021a5c10  18930351  sub      w24, w24, #0xe4
021a5c14  9a7e4093  sxtw     x26, w20
021a5c18  1f03086b  cmp      w24, w8
021a5c1c  a3000054  b.lo     #0x21a5c30
021a5c20  fc19ae97  bl       #0xd2c410 ; unresolved symbol
021a5c24  e1031faa  mov      x1, xzr
021a5c28  e2031faa  mov      x2, xzr
021a5c2c  9c16ae97  bl       #0xd2b69c ; unresolved symbol
021a5c30  c80a1a8b  add      x8, x22, x26, lsl #2
021a5c34  7b0a40f9  ldr      x27, [x19, #0x10]
021a5c38  1a2140b9  ldr      w26, [x8, #0x20]
021a5c3c  f7020112  and      w23, w23, #0x80000000
021a5c40  3c771f12  and      w28, w25, #0x7ffffffe
021a5c44  7b0000b5  cbnz     x27, #0x21a5c50
021a5c48  e0031faa  mov      x0, xzr
021a5c4c  b816ae97  bl       #0xd2b72c ; unresolved symbol
021a5c50  681b40b9  ldr      w8, [x27, #0x18]
021a5c54  39030012  and      w25, w25, #1
021a5c58  9703172a  orr      w23, w28, w23
021a5c5c  3f03086b  cmp      w25, w8
021a5c60  a3000054  b.lo     #0x21a5c74
021a5c64  eb19ae97  bl       #0xd2c410 ; unresolved symbol
021a5c68  e1031faa  mov      x1, xzr
021a5c6c  e2031faa  mov      x2, xzr
021a5c70  8b16ae97  bl       #0xd2b69c ; unresolved symbol
021a5c74  680b198b  add      x8, x27, x25, lsl #2
021a5c78  c91a40b9  ldr      w9, [x22, #0x18]
021a5c7c  082140b9  ldr      w8, [x8, #0x20]
021a5c80  4a07574a  eor      w10, w26, w23, lsr #1
021a5c84  0b8f0311  add      w11, w24, #0xe3
021a5c88  7f01096b  cmp      w11, w9
021a5c8c  5701084a  eor      w23, w10, w8
021a5c90  a3000054  b.lo     #0x21a5ca4
021a5c94  df19ae97  bl       #0xd2c410 ; unresolved symbol
021a5c98  e1031faa  mov      x1, xzr
021a5c9c  e2031faa  mov      x2, xzr
021a5ca0  7f16ae97  bl       #0xd2b69c ; unresolved symbol
021a5ca4  c80a158b  add      x8, x22, x21, lsl #2
021a5ca8  94060011  add      w20, w20, #1
021a5cac  172100b9  str      w23, [x8, #0x20]
021a5cb0  760e40f9  ldr      x22, [x19, #0x18]
021a5cb4  988e0311  add      w24, w20, #0xe3
021a5cb8  760000b5  cbnz     x22, #0x21a5cc4
021a5cbc  e0031faa  mov      x0, xzr
021a5cc0  9b16ae97  bl       #0xd2b72c ; unresolved symbol
021a5cc4  1fbf0971  cmp      w24, #0x26f
021a5cc8  6bf6ff54  b.lt     #0x21a5b94
021a5ccc  c81a40b9  ldr      w8, [x22, #0x18]
021a5cd0  1fbd0971  cmp      w8, #0x26f
021a5cd4  a8000054  b.hi     #0x21a5ce8
021a5cd8  ce19ae97  bl       #0xd2c410 ; unresolved symbol
021a5cdc  e1031faa  mov      x1, xzr
021a5ce0  e2031faa  mov      x2, xzr
021a5ce4  6e16ae97  bl       #0xd2b69c ; unresolved symbol
021a5ce8  770e40f9  ldr      x23, [x19, #0x18]
021a5cec  d5de49b9  ldr      w21, [x22, #0x9dc]
021a5cf0  770000b5  cbnz     x23, #0x21a5cfc
021a5cf4  e0031faa  mov      x0, xzr
021a5cf8  8d16ae97  bl       #0xd2b72c ; unresolved symbol
021a5cfc  e81a40b9  ldr      w8, [x23, #0x18]
021a5d00  a8000035  cbnz     w8, #0x21a5d14
021a5d04  c319ae97  bl       #0xd2c410 ; unresolved symbol
021a5d08  e1031faa  mov      x1, xzr
021a5d0c  e2031faa  mov      x2, xzr
021a5d10  6316ae97  bl       #0xd2b69c ; unresolved symbol
021a5d14  740e40f9  ldr      x20, [x19, #0x18]
021a5d18  f62240b9  ldr      w22, [x23, #0x20]
021a5d1c  740000b5  cbnz     x20, #0x21a5d28
021a5d20  e0031faa  mov      x0, xzr
021a5d24  8216ae97  bl       #0xd2b72c ; unresolved symbol
021a5d28  881a40b9  ldr      w8, [x20, #0x18]
021a5d2c  1f310671  cmp      w8, #0x18c
021a5d30  a8000054  b.hi     #0x21a5d44
021a5d34  b719ae97  bl       #0xd2c410 ; unresolved symbol
021a5d38  e1031faa  mov      x1, xzr
021a5d3c  e2031faa  mov      x2, xzr
021a5d40  5716ae97  bl       #0xd2b69c ; unresolved symbol
021a5d44  780a40f9  ldr      x24, [x19, #0x10]
021a5d48  975246b9  ldr      w23, [x20, #0x650]
021a5d4c  b5020112  and      w21, w21, #0x80000000
021a5d50  d9761f12  and      w25, w22, #0x7ffffffe
021a5d54  780000b5  cbnz     x24, #0x21a5d60
021a5d58  e0031faa  mov      x0, xzr
021a5d5c  7416ae97  bl       #0xd2b72c ; unresolved symbol
021a5d60  081b40b9  ldr      w8, [x24, #0x18]
021a5d64  d6020012  and      w22, w22, #1
021a5d68  3503152a  orr      w21, w25, w21
021a5d6c  df02086b  cmp      w22, w8
021a5d70  a3000054  b.lo     #0x21a5d84
021a5d74  a719ae97  bl       #0xd2c410 ; unresolved symbol
021a5d78  e1031faa  mov      x1, xzr
021a5d7c  e2031faa  mov      x2, xzr
021a5d80  4716ae97  bl       #0xd2b69c ; unresolved symbol
021a5d84  080b168b  add      x8, x24, x22, lsl #2
021a5d88  891a40b9  ldr      w9, [x20, #0x18]
021a5d8c  082140b9  ldr      w8, [x8, #0x20]
021a5d90  ea06554a  eor      w10, w23, w21, lsr #1
021a5d94  3fbd0971  cmp      w9, #0x26f
021a5d98  5601084a  eor      w22, w10, w8
021a5d9c  a8000054  b.hi     #0x21a5db0
021a5da0  9c19ae97  bl       #0xd2c410 ; unresolved symbol
021a5da4  e1031faa  mov      x1, xzr
021a5da8  e2031faa  mov      x2, xzr
021a5dac  3c16ae97  bl       #0xd2b69c ; unresolved symbol
021a5db0  f5031f2a  mov      w21, wzr
021a5db4  96de09b9  str      w22, [x20, #0x9dc]
021a5db8  7f2200b9  str      wzr, [x19, #0x20]
021a5dbc  740e40f9  ldr      x20, [x19, #0x18]
021a5dc0  a8060011  add      w8, w21, #1
021a5dc4  682200b9  str      w8, [x19, #0x20]
021a5dc8  740000b5  cbnz     x20, #0x21a5dd4
021a5dcc  e0031faa  mov      x0, xzr
021a5dd0  5716ae97  bl       #0xd2b72c ; unresolved symbol
021a5dd4  881a40b9  ldr      w8, [x20, #0x18]
021a5dd8  b37e4093  sxtw     x19, w21
021a5ddc  bf02086b  cmp      w21, w8
021a5de0  a3000054  b.lo     #0x21a5df4
021a5de4  8b19ae97  bl       #0xd2c410 ; unresolved symbol
021a5de8  e1031faa  mov      x1, xzr
021a5dec  e2031faa  mov      x2, xzr
021a5df0  2b16ae97  bl       #0xd2b69c ; unresolved symbol
021a5df4  880a138b  add      x8, x20, x19, lsl #2
021a5df8  082140b9  ldr      w8, [x8, #0x20]
021a5dfc  09d08a52  mov      w9, #0x5680
021a5e00  89a5b372  movk     w9, #0x9d2c, lsl #16
021a5e04  fd7b45a9  ldp      x29, x30, [sp, #0x50]
021a5e08  082d484a  eor      w8, w8, w8, lsr #11
021a5e0c  291d080a  and      w9, w9, w8, lsl #7
021a5e10  2801084a  eor      w8, w9, w8
021a5e14  c9f8bd52  mov      w9, #-0x103a0000
021a5e18  f44f44a9  ldp      x20, x19, [sp, #0x40]
021a5e1c  f65743a9  ldp      x22, x21, [sp, #0x30]
021a5e20  f85f42a9  ldp      x24, x23, [sp, #0x20]
021a5e24  fa6741a9  ldp      x26, x25, [sp, #0x10]
021a5e28  293d080a  and      w9, w9, w8, lsl #15
021a5e2c  2801084a  eor      w8, w9, w8
021a5e30  0049484a  eor      w0, w8, w8, lsr #18
021a5e34  fc6fc6a8  ldp      x28, x27, [sp], #0x60
021a5e38  c0035fd6  ret      
