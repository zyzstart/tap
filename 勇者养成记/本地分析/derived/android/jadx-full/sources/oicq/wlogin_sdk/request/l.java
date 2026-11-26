package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class l extends oicq.wlogin_sdk.request.oicq_request {
    public static int I;
    public static byte[] J = new byte[0];
    public static byte[] K = new byte[0];
    public static byte[] L = new byte[0];

    public l(oicq.wlogin_sdk.request.t tVar, android.content.Context context) {
        this.t = 2064;
        this.u = 9;
        this.v = "wtlogin.login";
        this.x = tVar;
        tVar.m = 0;
        this.f1686a = context;
    }

    public int a(long j, long j2, long j3, int i, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int i3, int i4, long[] jArr, int i5, long j4, int i6, int i7, int i8, int i9, byte[] bArr4, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        int iA;
        oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo2 = wUserSigInfo;
        int i10 = oicq.wlogin_sdk.request.t.w;
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(this.x.h);
        byte[] bArr5 = oicq.wlogin_sdk.tools.util.get_rand_16byte(oicq.wlogin_sdk.request.t.B);
        async_contextVarB._tgtgt_key = bArr5;
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var = async_contextVarB._t104;
        if (tlv_t104Var == null) {
            tlv_t104Var = new oicq.wlogin_sdk.tlv_type.tlv_t104();
        }
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var2 = tlv_t104Var;
        int i11 = 0;
        while (true) {
            int i12 = i11;
            byte[] bArr6 = bArr5;
            a(j3, a(j, j2, i10, j3, i, bArr, bArr2, bArr3, bArr6, i2, null, null, i3, i4, jArr, i5, j4, i6, i7, i8, i9, bArr4, tlv_t104Var2.get_data(), oicq.wlogin_sdk.request.t.E, wUserSigInfo2._domains, wUserSigInfo), this.y);
            iA = a(java.lang.String.valueOf(this.x.f), false, wUserSigInfo);
            if (iA != 0) {
                break;
            }
            iA = b();
            oicq.wlogin_sdk.tools.util.LOGI("retry num:" + i12 + " ret:" + iA, "" + j3);
            if (iA != 180) {
                break;
            }
            i11 = i12 + 1;
            if (i12 >= 1) {
                break;
            }
            wUserSigInfo2 = wUserSigInfo;
            bArr5 = bArr6;
        }
        return iA;
    }

    public int a(long j, long j2, long j3, int i, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int i3, long[] jArr, int i4, long j4, int i5, int i6, int i7, int i8, byte[] bArr4, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        int iA;
        oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo2 = wUserSigInfo;
        int i9 = oicq.wlogin_sdk.request.t.w;
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var = oicq.wlogin_sdk.request.t.b(this.x.h)._t104;
        if (tlv_t104Var == null) {
            tlv_t104Var = new oicq.wlogin_sdk.tlv_type.tlv_t104();
        }
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var2 = tlv_t104Var;
        byte[] bArrC = c(bArr2);
        if (bArrC == null) {
            return oicq.wlogin_sdk.tools.util.E_A1_DECRYPT;
        }
        int i10 = 0;
        while (true) {
            int i11 = i10;
            a(this.i, this.t, this.j, j3, this.m, this.n, i9, this.p, a(j, j2, i9, j3, i, bArr, null, null, null, 0, bArrC, bArr3, i2, i3, jArr, i4, j4, i5, i6, i7, i8, bArr4, tlv_t104Var2.get_data(), oicq.wlogin_sdk.request.t.E, wUserSigInfo2._domains, wUserSigInfo));
            iA = a(java.lang.String.valueOf(this.x.f), false, wUserSigInfo);
            if (iA != 0) {
                break;
            }
            iA = b();
            oicq.wlogin_sdk.tools.util.LOGI("retry num:" + i11 + " ret:" + iA, "" + j3);
            if (iA != 180) {
                break;
            }
            i10 = i11 + 1;
            if (i11 >= 1) {
                break;
            }
            wUserSigInfo2 = wUserSigInfo;
        }
        return iA;
    }

    /* JADX WARN: Code duplicated, block: B:114:0x047e A[PHI: r12 r21 r22 r24
  0x047e: PHI (r12v26 oicq.wlogin_sdk.request.async_context) = 
  (r12v6 oicq.wlogin_sdk.request.async_context)
  (r12v6 oicq.wlogin_sdk.request.async_context)
  (r12v7 oicq.wlogin_sdk.request.async_context)
  (r12v7 oicq.wlogin_sdk.request.async_context)
  (r12v15 oicq.wlogin_sdk.request.async_context)
  (r12v16 oicq.wlogin_sdk.request.async_context)
  (r12v16 oicq.wlogin_sdk.request.async_context)
  (r12v17 oicq.wlogin_sdk.request.async_context)
  (r12v17 oicq.wlogin_sdk.request.async_context)
  (r12v19 oicq.wlogin_sdk.request.async_context)
  (r12v20 oicq.wlogin_sdk.request.async_context)
  (r12v20 oicq.wlogin_sdk.request.async_context)
  (r12v21 oicq.wlogin_sdk.request.async_context)
  (r12v21 oicq.wlogin_sdk.request.async_context)
  (r12v23 oicq.wlogin_sdk.request.async_context)
  (r12v23 oicq.wlogin_sdk.request.async_context)
  (r12v24 oicq.wlogin_sdk.request.async_context)
  (r12v24 oicq.wlogin_sdk.request.async_context)
  (r12v25 oicq.wlogin_sdk.request.async_context)
  (r12v25 oicq.wlogin_sdk.request.async_context)
  (r12v27 oicq.wlogin_sdk.request.async_context)
  (r12v27 oicq.wlogin_sdk.request.async_context)
 binds: [B:109:0x046e, B:111:0x0471, B:103:0x0437, B:105:0x0441, B:91:0x02ce, B:85:0x02ac, B:87:0x02af, B:79:0x028a, B:81:0x028d, B:75:0x0250, B:69:0x022f, B:71:0x0232, B:63:0x020f, B:65:0x0212, B:56:0x01d8, B:58:0x01db, B:50:0x01ae, B:52:0x01b1, B:44:0x018c, B:46:0x018f, B:39:0x0136, B:41:0x0139] A[DONT_GENERATE, DONT_INLINE]
  0x047e: PHI (r21v30 int) = 
  (r21v10 int)
  (r21v10 int)
  (r21v11 int)
  (r21v11 int)
  (r21v19 int)
  (r21v20 int)
  (r21v20 int)
  (r21v21 int)
  (r21v21 int)
  (r21v23 int)
  (r21v24 int)
  (r21v24 int)
  (r21v25 int)
  (r21v25 int)
  (r21v27 int)
  (r21v27 int)
  (r21v28 int)
  (r21v28 int)
  (r21v29 int)
  (r21v29 int)
  (r21v31 int)
  (r21v31 int)
 binds: [B:109:0x046e, B:111:0x0471, B:103:0x0437, B:105:0x0441, B:91:0x02ce, B:85:0x02ac, B:87:0x02af, B:79:0x028a, B:81:0x028d, B:75:0x0250, B:69:0x022f, B:71:0x0232, B:63:0x020f, B:65:0x0212, B:56:0x01d8, B:58:0x01db, B:50:0x01ae, B:52:0x01b1, B:44:0x018c, B:46:0x018f, B:39:0x0136, B:41:0x0139] A[DONT_GENERATE, DONT_INLINE]
  0x047e: PHI (r22v30 int[]) = 
  (r22v10 int[])
  (r22v10 int[])
  (r22v11 int[])
  (r22v11 int[])
  (r22v19 int[])
  (r22v20 int[])
  (r22v20 int[])
  (r22v21 int[])
  (r22v21 int[])
  (r22v23 int[])
  (r22v24 int[])
  (r22v24 int[])
  (r22v25 int[])
  (r22v25 int[])
  (r22v27 int[])
  (r22v27 int[])
  (r22v28 int[])
  (r22v28 int[])
  (r22v29 int[])
  (r22v29 int[])
  (r22v31 int[])
  (r22v31 int[])
 binds: [B:109:0x046e, B:111:0x0471, B:103:0x0437, B:105:0x0441, B:91:0x02ce, B:85:0x02ac, B:87:0x02af, B:79:0x028a, B:81:0x028d, B:75:0x0250, B:69:0x022f, B:71:0x0232, B:63:0x020f, B:65:0x0212, B:56:0x01d8, B:58:0x01db, B:50:0x01ae, B:52:0x01b1, B:44:0x018c, B:46:0x018f, B:39:0x0136, B:41:0x0139] A[DONT_GENERATE, DONT_INLINE]
  0x047e: PHI (r24v30 java.util.ArrayList) = 
  (r24v10 java.util.ArrayList)
  (r24v10 java.util.ArrayList)
  (r24v11 java.util.ArrayList)
  (r24v11 java.util.ArrayList)
  (r24v19 java.util.ArrayList)
  (r24v20 java.util.ArrayList)
  (r24v20 java.util.ArrayList)
  (r24v21 java.util.ArrayList)
  (r24v21 java.util.ArrayList)
  (r24v23 java.util.ArrayList)
  (r24v24 java.util.ArrayList)
  (r24v24 java.util.ArrayList)
  (r24v25 java.util.ArrayList)
  (r24v25 java.util.ArrayList)
  (r24v27 java.util.ArrayList)
  (r24v27 java.util.ArrayList)
  (r24v28 java.util.ArrayList)
  (r24v28 java.util.ArrayList)
  (r24v29 java.util.ArrayList)
  (r24v29 java.util.ArrayList)
  (r24v31 java.util.ArrayList)
  (r24v31 java.util.ArrayList)
 binds: [B:109:0x046e, B:111:0x0471, B:103:0x0437, B:105:0x0441, B:91:0x02ce, B:85:0x02ac, B:87:0x02af, B:79:0x028a, B:81:0x028d, B:75:0x0250, B:69:0x022f, B:71:0x0232, B:63:0x020f, B:65:0x0212, B:56:0x01d8, B:58:0x01db, B:50:0x01ae, B:52:0x01b1, B:44:0x018c, B:46:0x018f, B:39:0x0136, B:41:0x0139] A[DONT_GENERATE, DONT_INLINE]] */
    public byte[] a(long j, long j2, int i, long j3, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i3, byte[] bArr5, byte[] bArr6, int i4, int i5, long[] jArr, int i6, long j4, int i7, int i8, int i9, int i10, byte[] bArr7, byte[] bArr8, byte[] bArr9, java.util.List list, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        int i11;
        java.util.ArrayList arrayList;
        int[] iArr;
        oicq.wlogin_sdk.request.async_context async_contextVar;
        byte[] bArr10;
        oicq.wlogin_sdk.request.async_context async_contextVar2;
        byte[] bArr11;
        byte[] bArr12;
        byte[] bArr13;
        java.util.ArrayList arrayList2;
        int[] iArr2;
        oicq.wlogin_sdk.request.async_context async_contextVar3;
        byte[] bArr14;
        byte[] bArr15;
        java.util.ArrayList arrayList3;
        long j5 = j3;
        byte[] bArr16 = bArr8;
        int[] iArr3 = {24, 1, 262, 278, 256, 263, 264, 260, com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02, 274, 324, com.tencent.smtt.sdk.TbsListener.ErrorCode.THROWABLE_INITX5CORE, com.tencent.smtt.sdk.TbsListener.ErrorCode.TEST_THROWABLE_ISNOT_NULL, 358, 362, 340, 321, 8, 1297, 370, 389, 1024, 391, 392, 404, 401, android.support.v4.view.InputDeviceCompat.SOURCE_DPAD, 514, 375, 1302, 1313, 1317, 792};
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(this.x.h);
        java.util.ArrayList arrayList4 = new java.util.ArrayList();
        int i12 = 0;
        int length = 0;
        for (int i13 = 33; i12 < i13; i13 = 33) {
            byte[] bArr17 = null;
            switch (iArr3[i12]) {
                case 1:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar = async_contextVarB;
                    j5 = j3;
                    bArr17 = new oicq.wlogin_sdk.tlv_type.tlv_t1().get_tlv_1(j5, bArr);
                    bArr13 = bArr17;
                    break;
                case 8:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar = async_contextVarB;
                    bArr17 = new oicq.wlogin_sdk.tlv_type.tlv_t8().get_tlv_8(0, oicq.wlogin_sdk.request.t.u, 0);
                    j5 = j3;
                    bArr13 = bArr17;
                    break;
                case 24:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar = async_contextVarB;
                    bArr10 = new oicq.wlogin_sdk.tlv_type.tlv_t18().get_tlv_18(j, i, j3, i2);
                    bArr17 = bArr10;
                    j5 = j3;
                    bArr13 = bArr17;
                    break;
                case 256:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar = async_contextVarB;
                    bArr10 = new oicq.wlogin_sdk.tlv_type.tlv_t100().get_tlv_100(j, j4, i, i6);
                    bArr17 = bArr10;
                    j5 = j3;
                    bArr13 = bArr17;
                    break;
                case 260:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar = async_contextVarB;
                    if (bArr16 != null && bArr16.length != 0) {
                        bArr10 = new oicq.wlogin_sdk.tlv_type.tlv_t104().get_tlv_104(bArr16);
                        bArr17 = bArr10;
                    }
                    j5 = j3;
                    bArr13 = bArr17;
                    break;
                case 262:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    oicq.wlogin_sdk.tlv_type.tlv_t106 tlv_t106Var = new oicq.wlogin_sdk.tlv_type.tlv_t106();
                    if (bArr5 == null || bArr5.length <= 0) {
                        async_contextVar = async_contextVar2;
                        bArr17 = tlv_t106Var.get_tlv_106(j, j2, i, j3, bArr2, bArr, 1, bArr3, async_contextVar2._msalt, this.x.g.getBytes(), bArr4, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.A, i3);
                        j5 = j3;
                    } else {
                        tlv_t106Var.set_data(bArr5, bArr5.length);
                        bArr11 = tlv_t106Var.get_buf();
                        bArr17 = bArr11;
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    }
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 263:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    bArr11 = new oicq.wlogin_sdk.tlv_type.tlv_t107().get_tlv_107(i7, i8, i9, i10);
                    bArr17 = bArr11;
                    async_contextVar = async_contextVar2;
                    j5 = j5;
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 264:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    if (bArr7 == null || bArr7.length == 0) {
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    } else {
                        bArr11 = new oicq.wlogin_sdk.tlv_type.tlv_t108().get_tlv_108(bArr7);
                        bArr17 = bArr11;
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    }
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 274:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    java.lang.String str = this.x.g;
                    if (str == null || oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    } else {
                        bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t112().get_tlv_112(this.x.g.getBytes());
                        bArr17 = bArr12;
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    }
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 278:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t116().get_tlv_116(i4, i5, jArr);
                    bArr17 = bArr12;
                    async_contextVar = async_contextVar2;
                    j5 = j5;
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 321:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t141().get_tlv_141(oicq.wlogin_sdk.request.t.C, oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.F);
                    bArr17 = bArr12;
                    async_contextVar = async_contextVar2;
                    j5 = j5;
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02 /* 322 */:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t142().get_tlv_142(bArr9);
                    bArr17 = bArr12;
                    async_contextVar = async_contextVar2;
                    j5 = j5;
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 324:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t144().get_tlv_144(new oicq.wlogin_sdk.tlv_type.tlv_t109().get_tlv_109(oicq.wlogin_sdk.request.t.M), new oicq.wlogin_sdk.tlv_type.tlv_t124().get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), new oicq.wlogin_sdk.tlv_type.tlv_t128().get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), new oicq.wlogin_sdk.tlv_type.tlv_t16e().get_tlv_16e(oicq.wlogin_sdk.request.t.I), async_contextVar2._tgtgt_key);
                    bArr17 = bArr12;
                    async_contextVar = async_contextVar2;
                    j5 = j5;
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case com.tencent.smtt.sdk.TbsListener.ErrorCode.THROWABLE_INITX5CORE /* 325 */:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t145().get_tlv_145(oicq.wlogin_sdk.request.t.A);
                    bArr17 = bArr12;
                    async_contextVar = async_contextVar2;
                    j5 = j5;
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case com.tencent.smtt.sdk.TbsListener.ErrorCode.TEST_THROWABLE_ISNOT_NULL /* 327 */:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t147().get_tlv_147(j, oicq.wlogin_sdk.request.t.G, oicq.wlogin_sdk.request.t.H);
                    bArr17 = bArr12;
                    async_contextVar = async_contextVar2;
                    j5 = j5;
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 340:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t154().get_tlv_154(this.x.i);
                    bArr17 = bArr12;
                    async_contextVar = async_contextVar2;
                    j5 = j5;
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 358:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    if ((i4 & 128) == 0) {
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    } else {
                        bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t166().get_tlv_166(oicq.wlogin_sdk.request.t.x);
                        bArr17 = bArr12;
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    }
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 362:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    if (bArr6 == null || bArr6.length == 0) {
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    } else {
                        bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t16a().get_tlv_16a(bArr6);
                        bArr17 = bArr12;
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    }
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 370:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    byte[] bArr18 = this.x.r;
                    if (bArr18 == null || bArr18.length == 0) {
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    } else {
                        bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t172().get_tlv_172(this.x.r);
                        bArr17 = bArr12;
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    }
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 375:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t177().get_tlv_177(oicq.wlogin_sdk.tools.util.BUILD_TIME, oicq.wlogin_sdk.tools.util.SDK_VERSION);
                    bArr17 = bArr12;
                    async_contextVar = async_contextVar2;
                    j5 = j5;
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 389:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    if (i3 == 3) {
                        bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t185().get_tlv_185(1);
                        bArr17 = bArr12;
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    } else {
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    }
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 391:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    byte[] bArr19 = oicq.wlogin_sdk.request.t.N;
                    if (bArr19 == null || bArr19.length == 0) {
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    } else {
                        bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t187().get_tlv_187(oicq.wlogin_sdk.request.t.N);
                        bArr17 = bArr12;
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    }
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 392:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    byte[] bArr20 = oicq.wlogin_sdk.request.t.O;
                    if (bArr20 == null || bArr20.length == 0) {
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    } else {
                        bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t188().get_tlv_188(oicq.wlogin_sdk.request.t.O);
                        bArr17 = bArr12;
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    }
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 401:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t191().get_tlv_191(I);
                    bArr17 = bArr12;
                    async_contextVar = async_contextVar2;
                    j5 = j5;
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 404:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    byte[] bArr21 = oicq.wlogin_sdk.request.t.L;
                    if (bArr21 == null || bArr21.length == 0) {
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    } else {
                        bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t194().get_tlv_194(oicq.wlogin_sdk.request.t.L);
                        bArr17 = bArr12;
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    }
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case android.support.v4.view.InputDeviceCompat.SOURCE_DPAD /* 513 */:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    byte[] bArr22 = J;
                    if (bArr22 == null || bArr22.length == 0) {
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    } else {
                        bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t201().get_tlv_201(J, K, "qq".getBytes(), L);
                        bArr17 = bArr12;
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    }
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 514:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    byte[] bArr23 = oicq.wlogin_sdk.request.t.R;
                    if (bArr23 == null || bArr23.length == 0) {
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    } else {
                        bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t202().get_tlv_202(oicq.wlogin_sdk.request.t.R, oicq.wlogin_sdk.request.t.S);
                        bArr17 = bArr12;
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                    }
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 792:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar2 = async_contextVarB;
                    byte[] bArr24 = async_contextVar2.tgtQR;
                    if (bArr24 == null || bArr24.length == 0) {
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                        bArr16 = bArr8;
                        bArr13 = bArr17;
                    } else {
                        oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar = new oicq.wlogin_sdk.tlv_type.tlv_t(792);
                        byte[] bArr25 = async_contextVar2.tgtQR;
                        tlv_tVar.set_data(bArr25, bArr25.length);
                        byte[] bArr26 = tlv_tVar.get_buf();
                        oicq.wlogin_sdk.tools.util.LOGI("tgtQR len " + async_contextVar2.tgtQR.length, "" + j5);
                        async_contextVar = async_contextVar2;
                        j5 = j5;
                        bArr13 = bArr26;
                        bArr16 = bArr8;
                    }
                    break;
                case 1024:
                    i11 = i12;
                    arrayList2 = arrayList4;
                    iArr2 = iArr3;
                    async_contextVar3 = async_contextVarB;
                    oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA = this.x.a(j5, j);
                    if (wloginSigInfoA != null && (bArr14 = wloginSigInfoA._G) != null) {
                        if (bArr14.length != 0) {
                            byte[] bArr27 = wloginSigInfoA._dpwd;
                            if (bArr27 != null) {
                                if (bArr27.length != 0) {
                                    byte[] bArr28 = wloginSigInfoA._randseed;
                                    if (bArr28 != null) {
                                        if (bArr28.length != 0) {
                                            arrayList = arrayList2;
                                            iArr = iArr2;
                                            async_contextVar2 = async_contextVar3;
                                            bArr12 = new oicq.wlogin_sdk.tlv_type.tlv_t400().get_tlv_400(wloginSigInfoA._G, j3, oicq.wlogin_sdk.request.t.A, wloginSigInfoA._dpwd, j, j2, wloginSigInfoA._randseed);
                                            bArr17 = bArr12;
                                            async_contextVar = async_contextVar2;
                                            j5 = j5;
                                        }
                                    }
                                    bArr16 = bArr8;
                                    bArr13 = bArr17;
                                }
                            }
                        }
                        async_contextVar = async_contextVar3;
                        arrayList = arrayList2;
                        iArr = iArr2;
                        bArr13 = bArr17;
                    }
                    arrayList = arrayList2;
                    iArr = iArr2;
                    j5 = j5;
                    async_contextVar = async_contextVar3;
                    bArr16 = bArr8;
                    bArr13 = bArr17;
                    break;
                case 1297:
                    i11 = i12;
                    arrayList2 = arrayList4;
                    iArr2 = iArr3;
                    async_contextVar3 = async_contextVarB;
                    if (list != 0 && list.size() != 0) {
                        bArr15 = new oicq.wlogin_sdk.tlv_type.tlv_t511().get_tlv_511(list);
                        bArr17 = bArr15;
                        async_contextVar = async_contextVar3;
                        arrayList = arrayList2;
                        iArr = iArr2;
                        bArr13 = bArr17;
                    }
                    async_contextVar = async_contextVar3;
                    arrayList = arrayList2;
                    iArr = iArr2;
                    bArr13 = bArr17;
                    break;
                case 1302:
                    i11 = i12;
                    arrayList2 = arrayList4;
                    iArr2 = iArr3;
                    oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar2 = new oicq.wlogin_sdk.tlv_type.tlv_t(1302);
                    byte[] bArr29 = new byte[4];
                    async_contextVar3 = async_contextVarB;
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr29, 0, wUserSigInfo._source_type);
                    tlv_tVar2.set_data(bArr29, 4);
                    bArr15 = tlv_tVar2.get_buf();
                    bArr17 = bArr15;
                    async_contextVar = async_contextVar3;
                    arrayList = arrayList2;
                    iArr = iArr2;
                    bArr13 = bArr17;
                    break;
                case 1313:
                    i11 = i12;
                    oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar3 = new oicq.wlogin_sdk.tlv_type.tlv_t(1313);
                    arrayList2 = arrayList4;
                    byte[] bArr30 = new byte[6];
                    iArr2 = iArr3;
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr30, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr30, 4, 0);
                    tlv_tVar3.set_data(bArr30, 6);
                    bArr17 = tlv_tVar3.get_buf();
                    async_contextVar = async_contextVarB;
                    arrayList = arrayList2;
                    iArr = iArr2;
                    bArr13 = bArr17;
                    break;
                default:
                    i11 = i12;
                    arrayList = arrayList4;
                    iArr = iArr3;
                    async_contextVar = async_contextVarB;
                    bArr13 = bArr17;
                    break;
            }
            if (bArr13 != null) {
                arrayList3 = arrayList;
                arrayList3.add(bArr13);
                length += bArr13.length;
            } else {
                arrayList3 = arrayList;
            }
            i12 = i11 + 1;
            j5 = j5;
            arrayList4 = arrayList3;
            iArr3 = iArr;
            async_contextVarB = async_contextVar;
        }
        java.util.ArrayList arrayList5 = arrayList4;
        byte[] bArr31 = new byte[length];
        int size = arrayList5.size();
        int length2 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            byte[] bArr32 = (byte[]) arrayList5.get(i14);
            java.lang.System.arraycopy(bArr32, 0, bArr31, length2, bArr32.length);
            length2 += bArr32.length;
        }
        return b(bArr31, this.u, size);
    }
}
