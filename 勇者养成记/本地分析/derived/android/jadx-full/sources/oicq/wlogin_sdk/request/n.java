package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class n extends oicq.wlogin_sdk.request.oicq_request {
    public n(oicq.wlogin_sdk.request.t tVar) {
        this.t = 2064;
        this.u = 10;
        this.v = "wtlogin.exchange_emp";
        this.x = tVar;
        tVar.m = 0;
    }

    public int a(long j, long j2, long j3, int i, int i2, byte[] bArr, int i3, int i4, long[] jArr, byte[] bArr2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        int iA;
        long j4;
        oicq.wlogin_sdk.request.n nVar = this;
        oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo2 = wUserSigInfo;
        oicq.wlogin_sdk.tools.util.LOGI("start request_change_sig", "" + j);
        int i5 = oicq.wlogin_sdk.request.t.w;
        int i6 = i2 & (-33554433);
        oicq.wlogin_sdk.request.t.b(nVar.x.h)._main_sigmap = i6;
        int i7 = 0;
        while (true) {
            int i8 = i7;
            int i9 = i6;
            a(nVar.i, nVar.t, nVar.j, j, nVar.m, nVar.n, i5, nVar.p, a(j, j2, j3, i5, i6, bArr, i3, i4, jArr, oicq.wlogin_sdk.request.t.aa, bArr2, wUserSigInfo2._domains));
            iA = a(java.lang.String.valueOf(this.x.f), false, wUserSigInfo);
            if (iA != 0) {
                j4 = j;
                break;
            }
            iA = b();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("");
            j4 = j;
            sb.append(j4);
            oicq.wlogin_sdk.tools.util.LOGI("retry num:" + i8 + " ret:" + iA, sb.toString());
            if (iA != 180) {
                break;
            }
            i7 = i8 + 1;
            if (i8 >= 1) {
                break;
            }
            nVar = this;
            wUserSigInfo2 = wUserSigInfo;
            i6 = i9;
        }
        oicq.wlogin_sdk.tools.util.LOGI("end request_change_sig for user ret " + iA, "" + j4);
        return iA;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x016e  */
    /* JADX WARN: Code duplicated, block: B:16:0x0178  */
    /* JADX WARN: Code duplicated, block: B:18:0x017d  */
    /* JADX WARN: Code duplicated, block: B:19:0x0186  */
    /* JADX WARN: Code duplicated, block: B:23:0x018e  */
    /* JADX WARN: Code duplicated, block: B:25:0x0193  */
    /* JADX WARN: Code duplicated, block: B:26:0x019a  */
    /* JADX WARN: Code duplicated, block: B:30:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:33:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:36:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:38:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:39:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:43:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:45:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:46:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:47:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:51:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:54:0x0209  */
    /* JADX WARN: Code duplicated, block: B:57:0x027c  */
    /* JADX WARN: Code duplicated, block: B:60:0x0351  */
    /* JADX WARN: Code duplicated, block: B:62:0x036d  */
    /* JADX WARN: Code duplicated, block: B:65:0x0388  */
    /* JADX WARN: Multi-variable type inference failed */
    public byte[] a(long j, long j2, long j3, int i, int i2, byte[] bArr, int i3, int i4, long[] jArr, byte[] bArr2, byte[] bArr3, java.util.List list) {
        byte[] bArr4;
        byte[] bArr5;
        byte[] bArr6;
        int i5;
        byte[] bArr7;
        byte[] bArr8;
        byte[] bArr9;
        byte[] bArr10;
        byte[] bArr11;
        byte[] bArr12;
        byte[] bArr13;
        byte[] bArr14;
        byte[] bArr15;
        byte[] bArr16;
        byte[] bArr17;
        byte[] bArr18;
        byte[] bArr19;
        byte[] bArr20;
        byte[] bArr21;
        byte[] bArr22;
        byte[] bArr23;
        byte[] bArr24;
        byte[] bArr25;
        byte[] bArr26;
        java.lang.String str;
        byte[] bArr27;
        byte[] bArr28;
        int i6;
        int i7;
        int i8 = this.u;
        oicq.wlogin_sdk.tlv_type.tlv_t100 tlv_t100Var = new oicq.wlogin_sdk.tlv_type.tlv_t100();
        oicq.wlogin_sdk.tlv_type.tlv_t10a tlv_t10aVar = new oicq.wlogin_sdk.tlv_type.tlv_t10a();
        oicq.wlogin_sdk.tlv_type.tlv_t116 tlv_t116Var = new oicq.wlogin_sdk.tlv_type.tlv_t116();
        oicq.wlogin_sdk.tlv_type.tlv_t108 tlv_t108Var = new oicq.wlogin_sdk.tlv_type.tlv_t108();
        oicq.wlogin_sdk.tlv_type.tlv_t109 tlv_t109Var = new oicq.wlogin_sdk.tlv_type.tlv_t109();
        oicq.wlogin_sdk.tlv_type.tlv_t124 tlv_t124Var = new oicq.wlogin_sdk.tlv_type.tlv_t124();
        oicq.wlogin_sdk.tlv_type.tlv_t128 tlv_t128Var = new oicq.wlogin_sdk.tlv_type.tlv_t128();
        oicq.wlogin_sdk.tlv_type.tlv_t143 tlv_t143Var = new oicq.wlogin_sdk.tlv_type.tlv_t143();
        oicq.wlogin_sdk.tlv_type.tlv_t112 tlv_t112Var = new oicq.wlogin_sdk.tlv_type.tlv_t112();
        oicq.wlogin_sdk.tlv_type.tlv_t144 tlv_t144Var = new oicq.wlogin_sdk.tlv_type.tlv_t144();
        oicq.wlogin_sdk.tlv_type.tlv_t145 tlv_t145Var = new oicq.wlogin_sdk.tlv_type.tlv_t145();
        oicq.wlogin_sdk.tlv_type.tlv_t147 tlv_t147Var = new oicq.wlogin_sdk.tlv_type.tlv_t147();
        oicq.wlogin_sdk.tlv_type.tlv_t142 tlv_t142Var = new oicq.wlogin_sdk.tlv_type.tlv_t142();
        oicq.wlogin_sdk.tlv_type.tlv_t154 tlv_t154Var = new oicq.wlogin_sdk.tlv_type.tlv_t154();
        oicq.wlogin_sdk.tlv_type.tlv_t18 tlv_t18Var = new oicq.wlogin_sdk.tlv_type.tlv_t18();
        oicq.wlogin_sdk.tlv_type.tlv_t141 tlv_t141Var = new oicq.wlogin_sdk.tlv_type.tlv_t141();
        oicq.wlogin_sdk.tlv_type.tlv_t8 tlv_t8Var = new oicq.wlogin_sdk.tlv_type.tlv_t8();
        oicq.wlogin_sdk.tlv_type.tlv_t511 tlv_t511Var = new oicq.wlogin_sdk.tlv_type.tlv_t511();
        oicq.wlogin_sdk.tlv_type.tlv_t16e tlv_t16eVar = new oicq.wlogin_sdk.tlv_type.tlv_t16e();
        oicq.wlogin_sdk.tlv_type.tlv_t172 tlv_t172Var = new oicq.wlogin_sdk.tlv_type.tlv_t172();
        oicq.wlogin_sdk.tlv_type.tlv_t177 tlv_t177Var = new oicq.wlogin_sdk.tlv_type.tlv_t177();
        oicq.wlogin_sdk.tlv_type.tlv_t187 tlv_t187Var = new oicq.wlogin_sdk.tlv_type.tlv_t187();
        oicq.wlogin_sdk.tlv_type.tlv_t188 tlv_t188Var = new oicq.wlogin_sdk.tlv_type.tlv_t188();
        oicq.wlogin_sdk.tlv_type.tlv_t194 tlv_t194Var = new oicq.wlogin_sdk.tlv_type.tlv_t194();
        oicq.wlogin_sdk.tlv_type.tlv_t201 tlv_t201Var = new oicq.wlogin_sdk.tlv_type.tlv_t201();
        oicq.wlogin_sdk.tlv_type.tlv_t202 tlv_t202Var = new oicq.wlogin_sdk.tlv_type.tlv_t202();
        byte[] bArr29 = tlv_t100Var.get_tlv_100(j2, j3, i, i2);
        byte[] bArr30 = tlv_t10aVar.get_tlv_10a(bArr);
        byte[] bArr31 = tlv_t116Var.get_tlv_116(i3, i4, jArr);
        byte[] bArr32 = tlv_t145Var.get_tlv_145(oicq.wlogin_sdk.request.t.A);
        byte[] bArr33 = tlv_t142Var.get_tlv_142(oicq.wlogin_sdk.request.t.E);
        byte[] bArr34 = tlv_t154Var.get_tlv_154(this.x.i);
        byte[] bArr35 = tlv_t18Var.get_tlv_18(j2, i, j, 0);
        byte[] bArr36 = tlv_t141Var.get_tlv_141(oicq.wlogin_sdk.request.t.C, oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.F);
        byte[] bArr37 = tlv_t8Var.get_tlv_8(0, oicq.wlogin_sdk.request.t.u, 0);
        byte[] bArr38 = tlv_t147Var.get_tlv_147(j2, oicq.wlogin_sdk.request.t.G, oicq.wlogin_sdk.request.t.H);
        byte[] bArr39 = tlv_t177Var.get_tlv_177(oicq.wlogin_sdk.tools.util.BUILD_TIME, oicq.wlogin_sdk.tools.util.SDK_VERSION);
        byte[] bArr40 = new byte[0];
        byte[] bArr41 = new byte[0];
        byte[] bArr42 = new byte[0];
        byte[] bArr43 = new byte[0];
        byte[] bArr44 = new byte[0];
        byte[] bArr45 = new byte[0];
        byte[] bArr46 = new byte[0];
        byte[] bArr47 = new byte[0];
        byte[] bArr48 = new byte[0];
        byte[] bArr49 = new byte[0];
        if (bArr2 != null) {
            bArr4 = bArr49;
            if (bArr2.length > 0) {
                i5 = 11;
                bArr6 = tlv_t108Var.get_tlv_108(bArr2);
                bArr5 = bArr42;
            }
            if (list != 0 || list.size() <= 0) {
                bArr7 = bArr43;
            } else {
                bArr7 = tlv_t511Var.get_tlv_511(list);
                i5++;
            }
            bArr8 = this.x.r;
            if (bArr8 != null) {
                bArr9 = bArr32;
                if (bArr8.length > 0) {
                    bArr10 = tlv_t172Var.get_tlv_172(bArr8);
                    i5++;
                }
                bArr11 = oicq.wlogin_sdk.request.t.N;
                if (bArr11 != null) {
                    bArr12 = bArr39;
                    if (bArr11.length > 0) {
                        bArr13 = tlv_t187Var.get_tlv_187(bArr11);
                        i5++;
                    }
                    bArr14 = oicq.wlogin_sdk.request.t.O;
                    if (bArr14 != null || bArr14.length <= 0) {
                        bArr15 = bArr46;
                    } else {
                        bArr15 = tlv_t188Var.get_tlv_188(bArr14);
                        i5++;
                    }
                    bArr16 = oicq.wlogin_sdk.request.t.L;
                    if (bArr16 != null) {
                        bArr17 = bArr15;
                        if (bArr16.length > 0) {
                            bArr18 = tlv_t194Var.get_tlv_194(bArr16);
                            i5++;
                        }
                        bArr19 = oicq.wlogin_sdk.request.l.J;
                        if (bArr19 != null) {
                            bArr20 = bArr18;
                            if (bArr19.length > 0) {
                                bArr10 = bArr10;
                                bArr38 = bArr38;
                                bArr21 = tlv_t201Var.get_tlv_201(bArr19, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                                i5++;
                            }
                            bArr22 = oicq.wlogin_sdk.request.t.R;
                            if (bArr22 != null || bArr22.length <= 0) {
                                bArr23 = bArr4;
                            } else {
                                bArr23 = tlv_t202Var.get_tlv_202(bArr22, oicq.wlogin_sdk.request.t.S);
                                i5++;
                            }
                            bArr24 = bArr23;
                            bArr25 = bArr21;
                            bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                            if (bArr3 != null || bArr3.length <= 0) {
                                byte[] bArr50 = bArr12;
                                byte[] bArr51 = bArr38;
                                byte[] bArr52 = bArr17;
                                byte[] bArr53 = bArr20;
                                byte[] bArr54 = bArr10;
                                java.lang.Object[] objArr = bArr13;
                                int i9 = i5 + 2;
                                str = this.x.g;
                                if (str != null || oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
                                    bArr27 = bArr5;
                                } else {
                                    bArr27 = tlv_t112Var.get_tlv_112(this.x.g.getBytes());
                                    i9++;
                                }
                                int length = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                                byte[] bArr55 = bArr9;
                                byte[] bArr56 = bArr27;
                                bArr28 = new byte[length + bArr55.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51.length + bArr54.length + bArr50.length + objArr.length + bArr52.length + bArr53.length + bArr25.length + bArr24.length];
                                java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                                int length2 = bArr29.length + 0;
                                java.lang.System.arraycopy(bArr30, 0, bArr28, length2, bArr30.length);
                                int length3 = length2 + bArr30.length;
                                java.lang.System.arraycopy(bArr31, 0, bArr28, length3, bArr31.length);
                                int length4 = length3 + bArr31.length;
                                java.lang.System.arraycopy(bArr6, 0, bArr28, length4, bArr6.length);
                                int length5 = length4 + bArr6.length;
                                java.lang.System.arraycopy(bArr26, 0, bArr28, length5, bArr26.length);
                                int length6 = length5 + bArr26.length;
                                java.lang.System.arraycopy(bArr41, 0, bArr28, length6, 0);
                                int i10 = length6 + 0;
                                java.lang.System.arraycopy(bArr56, 0, bArr28, i10, bArr56.length);
                                int length7 = i10 + bArr56.length;
                                java.lang.System.arraycopy(bArr55, 0, bArr28, length7, bArr55.length);
                                int length8 = length7 + bArr55.length;
                                java.lang.System.arraycopy(bArr33, 0, bArr28, length8, bArr33.length);
                                int length9 = length8 + bArr33.length;
                                java.lang.System.arraycopy(bArr34, 0, bArr28, length9, bArr34.length);
                                int length10 = length9 + bArr34.length;
                                java.lang.System.arraycopy(bArr35, 0, bArr28, length10, bArr35.length);
                                int length11 = length10 + bArr35.length;
                                java.lang.System.arraycopy(bArr36, 0, bArr28, length11, bArr36.length);
                                int length12 = length11 + bArr36.length;
                                java.lang.System.arraycopy(bArr37, 0, bArr28, length12, bArr37.length);
                                int length13 = length12 + bArr37.length;
                                java.lang.System.arraycopy(bArr7, 0, bArr28, length13, bArr7.length);
                                int length14 = length13 + bArr7.length;
                                java.lang.System.arraycopy(bArr51, 0, bArr28, length14, bArr51.length);
                                int length15 = length14 + bArr51.length;
                                java.lang.System.arraycopy(bArr54, 0, bArr28, length15, bArr54.length);
                                int length16 = length15 + bArr54.length;
                                java.lang.System.arraycopy(bArr50, 0, bArr28, length16, bArr50.length);
                                int length17 = length16 + bArr50.length;
                                java.lang.System.arraycopy(objArr, 0, bArr28, length17, objArr.length);
                                int length18 = length17 + objArr.length;
                                java.lang.System.arraycopy(bArr52, 0, bArr28, length18, bArr52.length);
                                int length19 = length18 + bArr52.length;
                                java.lang.System.arraycopy(bArr53, 0, bArr28, length19, bArr53.length);
                                int length20 = length19 + bArr53.length;
                                java.lang.System.arraycopy(bArr25, 0, bArr28, length20, bArr25.length);
                                java.lang.System.arraycopy(bArr24, 0, bArr28, length20 + bArr25.length, bArr24.length);
                                int length21 = bArr24.length;
                                i6 = i9;
                                i7 = i8;
                            } else {
                                byte[] bArr57 = tlv_t143Var.get_tlv_143(bArr3);
                                byte[] bArr58 = bArr38;
                                byte[] bArr59 = new byte[bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + bArr57.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr58.length + bArr10.length + bArr12.length + bArr13.length + bArr17.length + bArr20.length + bArr25.length + bArr24.length];
                                java.lang.System.arraycopy(bArr29, 0, bArr59, 0, bArr29.length);
                                int length22 = bArr29.length + 0;
                                java.lang.System.arraycopy(bArr30, 0, bArr59, length22, bArr30.length);
                                int length23 = length22 + bArr30.length;
                                java.lang.System.arraycopy(bArr31, 0, bArr59, length23, bArr31.length);
                                int length24 = length23 + bArr31.length;
                                java.lang.System.arraycopy(bArr6, 0, bArr59, length24, bArr6.length);
                                int length25 = length24 + bArr6.length;
                                java.lang.System.arraycopy(bArr26, 0, bArr59, length25, bArr26.length);
                                int length26 = length25 + bArr26.length;
                                java.lang.System.arraycopy(bArr57, 0, bArr59, length26, bArr57.length);
                                int length27 = length26 + bArr57.length;
                                java.lang.System.arraycopy(bArr33, 0, bArr59, length27, bArr33.length);
                                int length28 = length27 + bArr33.length;
                                java.lang.System.arraycopy(bArr34, 0, bArr59, length28, bArr34.length);
                                int length29 = length28 + bArr34.length;
                                java.lang.System.arraycopy(bArr35, 0, bArr59, length29, bArr35.length);
                                int length30 = length29 + bArr35.length;
                                java.lang.System.arraycopy(bArr36, 0, bArr59, length30, bArr36.length);
                                int length31 = length30 + bArr36.length;
                                java.lang.System.arraycopy(bArr37, 0, bArr59, length31, bArr37.length);
                                int length32 = length31 + bArr37.length;
                                java.lang.System.arraycopy(bArr7, 0, bArr59, length32, bArr7.length);
                                int length33 = length32 + bArr7.length;
                                java.lang.System.arraycopy(bArr58, 0, bArr59, length33, bArr58.length);
                                int length34 = length33 + bArr58.length;
                                byte[] bArr60 = bArr10;
                                java.lang.System.arraycopy(bArr60, 0, bArr59, length34, bArr60.length);
                                int length35 = length34 + bArr60.length;
                                byte[] bArr61 = bArr12;
                                java.lang.System.arraycopy(bArr61, 0, bArr59, length35, bArr61.length);
                                int length36 = length35 + bArr61.length;
                                byte[] bArr62 = bArr13;
                                java.lang.System.arraycopy(bArr62, 0, bArr59, length36, bArr62.length);
                                int length37 = length36 + bArr62.length;
                                byte[] bArr63 = bArr17;
                                java.lang.System.arraycopy(bArr63, 0, bArr59, length37, bArr63.length);
                                int length38 = length37 + bArr63.length;
                                byte[] bArr64 = bArr20;
                                java.lang.System.arraycopy(bArr64, 0, bArr59, length38, bArr64.length);
                                int length39 = length38 + bArr64.length;
                                java.lang.System.arraycopy(bArr25, 0, bArr59, length39, bArr25.length);
                                java.lang.System.arraycopy(bArr24, 0, bArr59, length39 + bArr25.length, bArr24.length);
                                int length40 = bArr24.length;
                                bArr28 = bArr59;
                                i6 = i5 + 1 + 1;
                                i7 = 11;
                            }
                            return b(bArr28, i7, i6);
                        }
                        bArr20 = bArr18;
                        bArr21 = bArr48;
                        bArr22 = oicq.wlogin_sdk.request.t.R;
                        if (bArr22 != null) {
                            bArr23 = bArr4;
                        } else {
                            bArr23 = bArr4;
                        }
                        bArr24 = bArr23;
                        bArr25 = bArr21;
                        bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                        if (bArr3 != null) {
                            byte[] bArr510 = bArr12;
                            byte[] bArr511 = bArr38;
                            byte[] bArr512 = bArr17;
                            byte[] bArr513 = bArr20;
                            byte[] bArr514 = bArr10;
                            java.lang.Object[] objArr2 = bArr13;
                            int i11 = i5 + 2;
                            str = this.x.g;
                            if (str != null) {
                                bArr27 = bArr5;
                            } else {
                                bArr27 = bArr5;
                            }
                            int length41 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                            byte[] bArr515 = bArr9;
                            byte[] bArr516 = bArr27;
                            bArr28 = new byte[length41 + bArr515.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511.length + bArr514.length + bArr510.length + objArr2.length + bArr512.length + bArr513.length + bArr25.length + bArr24.length];
                            java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                            int length42 = bArr29.length + 0;
                            java.lang.System.arraycopy(bArr30, 0, bArr28, length42, bArr30.length);
                            int length43 = length42 + bArr30.length;
                            java.lang.System.arraycopy(bArr31, 0, bArr28, length43, bArr31.length);
                            int length44 = length43 + bArr31.length;
                            java.lang.System.arraycopy(bArr6, 0, bArr28, length44, bArr6.length);
                            int length45 = length44 + bArr6.length;
                            java.lang.System.arraycopy(bArr26, 0, bArr28, length45, bArr26.length);
                            int length46 = length45 + bArr26.length;
                            java.lang.System.arraycopy(bArr41, 0, bArr28, length46, 0);
                            int i12 = length46 + 0;
                            java.lang.System.arraycopy(bArr516, 0, bArr28, i12, bArr516.length);
                            int length47 = i12 + bArr516.length;
                            java.lang.System.arraycopy(bArr515, 0, bArr28, length47, bArr515.length);
                            int length48 = length47 + bArr515.length;
                            java.lang.System.arraycopy(bArr33, 0, bArr28, length48, bArr33.length);
                            int length49 = length48 + bArr33.length;
                            java.lang.System.arraycopy(bArr34, 0, bArr28, length49, bArr34.length);
                            int length110 = length49 + bArr34.length;
                            java.lang.System.arraycopy(bArr35, 0, bArr28, length110, bArr35.length);
                            int length111 = length110 + bArr35.length;
                            java.lang.System.arraycopy(bArr36, 0, bArr28, length111, bArr36.length);
                            int length112 = length111 + bArr36.length;
                            java.lang.System.arraycopy(bArr37, 0, bArr28, length112, bArr37.length);
                            int length113 = length112 + bArr37.length;
                            java.lang.System.arraycopy(bArr7, 0, bArr28, length113, bArr7.length);
                            int length114 = length113 + bArr7.length;
                            java.lang.System.arraycopy(bArr511, 0, bArr28, length114, bArr511.length);
                            int length115 = length114 + bArr511.length;
                            java.lang.System.arraycopy(bArr514, 0, bArr28, length115, bArr514.length);
                            int length116 = length115 + bArr514.length;
                            java.lang.System.arraycopy(bArr510, 0, bArr28, length116, bArr510.length);
                            int length117 = length116 + bArr510.length;
                            java.lang.System.arraycopy(objArr2, 0, bArr28, length117, objArr2.length);
                            int length118 = length117 + objArr2.length;
                            java.lang.System.arraycopy(bArr512, 0, bArr28, length118, bArr512.length);
                            int length119 = length118 + bArr512.length;
                            java.lang.System.arraycopy(bArr513, 0, bArr28, length119, bArr513.length);
                            int length210 = length119 + bArr513.length;
                            java.lang.System.arraycopy(bArr25, 0, bArr28, length210, bArr25.length);
                            java.lang.System.arraycopy(bArr24, 0, bArr28, length210 + bArr25.length, bArr24.length);
                            int length211 = bArr24.length;
                            i6 = i11;
                            i7 = i8;
                        } else {
                            byte[] bArr517 = bArr12;
                            byte[] bArr518 = bArr38;
                            byte[] bArr519 = bArr17;
                            byte[] bArr5110 = bArr20;
                            byte[] bArr5111 = bArr10;
                            java.lang.Object[] objArr3 = bArr13;
                            int i13 = i5 + 2;
                            str = this.x.g;
                            if (str != null) {
                                bArr27 = bArr5;
                            } else {
                                bArr27 = bArr5;
                            }
                            int length410 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                            byte[] bArr5112 = bArr9;
                            byte[] bArr5113 = bArr27;
                            bArr28 = new byte[length410 + bArr5112.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr518.length + bArr5111.length + bArr517.length + objArr3.length + bArr519.length + bArr5110.length + bArr25.length + bArr24.length];
                            java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                            int length411 = bArr29.length + 0;
                            java.lang.System.arraycopy(bArr30, 0, bArr28, length411, bArr30.length);
                            int length412 = length411 + bArr30.length;
                            java.lang.System.arraycopy(bArr31, 0, bArr28, length412, bArr31.length);
                            int length413 = length412 + bArr31.length;
                            java.lang.System.arraycopy(bArr6, 0, bArr28, length413, bArr6.length);
                            int length414 = length413 + bArr6.length;
                            java.lang.System.arraycopy(bArr26, 0, bArr28, length414, bArr26.length);
                            int length415 = length414 + bArr26.length;
                            java.lang.System.arraycopy(bArr41, 0, bArr28, length415, 0);
                            int i14 = length415 + 0;
                            java.lang.System.arraycopy(bArr5113, 0, bArr28, i14, bArr5113.length);
                            int length416 = i14 + bArr5113.length;
                            java.lang.System.arraycopy(bArr5112, 0, bArr28, length416, bArr5112.length);
                            int length417 = length416 + bArr5112.length;
                            java.lang.System.arraycopy(bArr33, 0, bArr28, length417, bArr33.length);
                            int length418 = length417 + bArr33.length;
                            java.lang.System.arraycopy(bArr34, 0, bArr28, length418, bArr34.length);
                            int length1110 = length418 + bArr34.length;
                            java.lang.System.arraycopy(bArr35, 0, bArr28, length1110, bArr35.length);
                            int length1111 = length1110 + bArr35.length;
                            java.lang.System.arraycopy(bArr36, 0, bArr28, length1111, bArr36.length);
                            int length1112 = length1111 + bArr36.length;
                            java.lang.System.arraycopy(bArr37, 0, bArr28, length1112, bArr37.length);
                            int length1113 = length1112 + bArr37.length;
                            java.lang.System.arraycopy(bArr7, 0, bArr28, length1113, bArr7.length);
                            int length1114 = length1113 + bArr7.length;
                            java.lang.System.arraycopy(bArr518, 0, bArr28, length1114, bArr518.length);
                            int length1115 = length1114 + bArr518.length;
                            java.lang.System.arraycopy(bArr5111, 0, bArr28, length1115, bArr5111.length);
                            int length1116 = length1115 + bArr5111.length;
                            java.lang.System.arraycopy(bArr517, 0, bArr28, length1116, bArr517.length);
                            int length1117 = length1116 + bArr517.length;
                            java.lang.System.arraycopy(objArr3, 0, bArr28, length1117, objArr3.length);
                            int length1118 = length1117 + objArr3.length;
                            java.lang.System.arraycopy(bArr519, 0, bArr28, length1118, bArr519.length);
                            int length1119 = length1118 + bArr519.length;
                            java.lang.System.arraycopy(bArr5110, 0, bArr28, length1119, bArr5110.length);
                            int length212 = length1119 + bArr5110.length;
                            java.lang.System.arraycopy(bArr25, 0, bArr28, length212, bArr25.length);
                            java.lang.System.arraycopy(bArr24, 0, bArr28, length212 + bArr25.length, bArr24.length);
                            int length213 = bArr24.length;
                            i6 = i13;
                            i7 = i8;
                        }
                        return b(bArr28, i7, i6);
                    }
                    bArr17 = bArr15;
                    bArr18 = bArr47;
                    bArr19 = oicq.wlogin_sdk.request.l.J;
                    if (bArr19 != null) {
                        bArr20 = bArr18;
                        if (bArr19.length > 0) {
                            bArr10 = bArr10;
                            bArr38 = bArr38;
                            bArr21 = tlv_t201Var.get_tlv_201(bArr19, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                            i5++;
                        }
                        bArr22 = oicq.wlogin_sdk.request.t.R;
                        if (bArr22 != null) {
                            bArr23 = bArr4;
                        } else {
                            bArr23 = bArr4;
                        }
                        bArr24 = bArr23;
                        bArr25 = bArr21;
                        bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                        if (bArr3 != null) {
                            byte[] bArr5114 = bArr12;
                            byte[] bArr5115 = bArr38;
                            byte[] bArr5116 = bArr17;
                            byte[] bArr5117 = bArr20;
                            byte[] bArr5118 = bArr10;
                            java.lang.Object[] objArr4 = bArr13;
                            int i15 = i5 + 2;
                            str = this.x.g;
                            if (str != null) {
                                bArr27 = bArr5;
                            } else {
                                bArr27 = bArr5;
                            }
                            int length419 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                            byte[] bArr5119 = bArr9;
                            byte[] bArr51110 = bArr27;
                            bArr28 = new byte[length419 + bArr5119.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5115.length + bArr5118.length + bArr5114.length + objArr4.length + bArr5116.length + bArr5117.length + bArr25.length + bArr24.length];
                            java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                            int length4110 = bArr29.length + 0;
                            java.lang.System.arraycopy(bArr30, 0, bArr28, length4110, bArr30.length);
                            int length4111 = length4110 + bArr30.length;
                            java.lang.System.arraycopy(bArr31, 0, bArr28, length4111, bArr31.length);
                            int length4112 = length4111 + bArr31.length;
                            java.lang.System.arraycopy(bArr6, 0, bArr28, length4112, bArr6.length);
                            int length4113 = length4112 + bArr6.length;
                            java.lang.System.arraycopy(bArr26, 0, bArr28, length4113, bArr26.length);
                            int length4114 = length4113 + bArr26.length;
                            java.lang.System.arraycopy(bArr41, 0, bArr28, length4114, 0);
                            int i16 = length4114 + 0;
                            java.lang.System.arraycopy(bArr51110, 0, bArr28, i16, bArr51110.length);
                            int length4115 = i16 + bArr51110.length;
                            java.lang.System.arraycopy(bArr5119, 0, bArr28, length4115, bArr5119.length);
                            int length4116 = length4115 + bArr5119.length;
                            java.lang.System.arraycopy(bArr33, 0, bArr28, length4116, bArr33.length);
                            int length4117 = length4116 + bArr33.length;
                            java.lang.System.arraycopy(bArr34, 0, bArr28, length4117, bArr34.length);
                            int length11110 = length4117 + bArr34.length;
                            java.lang.System.arraycopy(bArr35, 0, bArr28, length11110, bArr35.length);
                            int length11111 = length11110 + bArr35.length;
                            java.lang.System.arraycopy(bArr36, 0, bArr28, length11111, bArr36.length);
                            int length11112 = length11111 + bArr36.length;
                            java.lang.System.arraycopy(bArr37, 0, bArr28, length11112, bArr37.length);
                            int length11113 = length11112 + bArr37.length;
                            java.lang.System.arraycopy(bArr7, 0, bArr28, length11113, bArr7.length);
                            int length11114 = length11113 + bArr7.length;
                            java.lang.System.arraycopy(bArr5115, 0, bArr28, length11114, bArr5115.length);
                            int length11115 = length11114 + bArr5115.length;
                            java.lang.System.arraycopy(bArr5118, 0, bArr28, length11115, bArr5118.length);
                            int length11116 = length11115 + bArr5118.length;
                            java.lang.System.arraycopy(bArr5114, 0, bArr28, length11116, bArr5114.length);
                            int length11117 = length11116 + bArr5114.length;
                            java.lang.System.arraycopy(objArr4, 0, bArr28, length11117, objArr4.length);
                            int length11118 = length11117 + objArr4.length;
                            java.lang.System.arraycopy(bArr5116, 0, bArr28, length11118, bArr5116.length);
                            int length11119 = length11118 + bArr5116.length;
                            java.lang.System.arraycopy(bArr5117, 0, bArr28, length11119, bArr5117.length);
                            int length214 = length11119 + bArr5117.length;
                            java.lang.System.arraycopy(bArr25, 0, bArr28, length214, bArr25.length);
                            java.lang.System.arraycopy(bArr24, 0, bArr28, length214 + bArr25.length, bArr24.length);
                            int length215 = bArr24.length;
                            i6 = i15;
                            i7 = i8;
                        } else {
                            byte[] bArr51111 = bArr12;
                            byte[] bArr51112 = bArr38;
                            byte[] bArr51113 = bArr17;
                            byte[] bArr51114 = bArr20;
                            byte[] bArr51115 = bArr10;
                            java.lang.Object[] objArr5 = bArr13;
                            int i17 = i5 + 2;
                            str = this.x.g;
                            if (str != null) {
                                bArr27 = bArr5;
                            } else {
                                bArr27 = bArr5;
                            }
                            int length4118 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                            byte[] bArr51116 = bArr9;
                            byte[] bArr51117 = bArr27;
                            bArr28 = new byte[length4118 + bArr51116.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51112.length + bArr51115.length + bArr51111.length + objArr5.length + bArr51113.length + bArr51114.length + bArr25.length + bArr24.length];
                            java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                            int length4119 = bArr29.length + 0;
                            java.lang.System.arraycopy(bArr30, 0, bArr28, length4119, bArr30.length);
                            int length41110 = length4119 + bArr30.length;
                            java.lang.System.arraycopy(bArr31, 0, bArr28, length41110, bArr31.length);
                            int length41111 = length41110 + bArr31.length;
                            java.lang.System.arraycopy(bArr6, 0, bArr28, length41111, bArr6.length);
                            int length41112 = length41111 + bArr6.length;
                            java.lang.System.arraycopy(bArr26, 0, bArr28, length41112, bArr26.length);
                            int length41113 = length41112 + bArr26.length;
                            java.lang.System.arraycopy(bArr41, 0, bArr28, length41113, 0);
                            int i18 = length41113 + 0;
                            java.lang.System.arraycopy(bArr51117, 0, bArr28, i18, bArr51117.length);
                            int length41114 = i18 + bArr51117.length;
                            java.lang.System.arraycopy(bArr51116, 0, bArr28, length41114, bArr51116.length);
                            int length41115 = length41114 + bArr51116.length;
                            java.lang.System.arraycopy(bArr33, 0, bArr28, length41115, bArr33.length);
                            int length41116 = length41115 + bArr33.length;
                            java.lang.System.arraycopy(bArr34, 0, bArr28, length41116, bArr34.length);
                            int length111110 = length41116 + bArr34.length;
                            java.lang.System.arraycopy(bArr35, 0, bArr28, length111110, bArr35.length);
                            int length111111 = length111110 + bArr35.length;
                            java.lang.System.arraycopy(bArr36, 0, bArr28, length111111, bArr36.length);
                            int length111112 = length111111 + bArr36.length;
                            java.lang.System.arraycopy(bArr37, 0, bArr28, length111112, bArr37.length);
                            int length111113 = length111112 + bArr37.length;
                            java.lang.System.arraycopy(bArr7, 0, bArr28, length111113, bArr7.length);
                            int length111114 = length111113 + bArr7.length;
                            java.lang.System.arraycopy(bArr51112, 0, bArr28, length111114, bArr51112.length);
                            int length111115 = length111114 + bArr51112.length;
                            java.lang.System.arraycopy(bArr51115, 0, bArr28, length111115, bArr51115.length);
                            int length111116 = length111115 + bArr51115.length;
                            java.lang.System.arraycopy(bArr51111, 0, bArr28, length111116, bArr51111.length);
                            int length111117 = length111116 + bArr51111.length;
                            java.lang.System.arraycopy(objArr5, 0, bArr28, length111117, objArr5.length);
                            int length111118 = length111117 + objArr5.length;
                            java.lang.System.arraycopy(bArr51113, 0, bArr28, length111118, bArr51113.length);
                            int length111119 = length111118 + bArr51113.length;
                            java.lang.System.arraycopy(bArr51114, 0, bArr28, length111119, bArr51114.length);
                            int length216 = length111119 + bArr51114.length;
                            java.lang.System.arraycopy(bArr25, 0, bArr28, length216, bArr25.length);
                            java.lang.System.arraycopy(bArr24, 0, bArr28, length216 + bArr25.length, bArr24.length);
                            int length217 = bArr24.length;
                            i6 = i17;
                            i7 = i8;
                        }
                        return b(bArr28, i7, i6);
                    }
                    bArr20 = bArr18;
                    bArr21 = bArr48;
                    bArr22 = oicq.wlogin_sdk.request.t.R;
                    if (bArr22 != null) {
                        bArr23 = bArr4;
                    } else {
                        bArr23 = bArr4;
                    }
                    bArr24 = bArr23;
                    bArr25 = bArr21;
                    bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                    if (bArr3 != null) {
                        byte[] bArr51118 = bArr12;
                        byte[] bArr51119 = bArr38;
                        byte[] bArr511110 = bArr17;
                        byte[] bArr511111 = bArr20;
                        byte[] bArr511112 = bArr10;
                        java.lang.Object[] objArr6 = bArr13;
                        int i19 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length41117 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr511113 = bArr9;
                        byte[] bArr511114 = bArr27;
                        bArr28 = new byte[length41117 + bArr511113.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51119.length + bArr511112.length + bArr51118.length + objArr6.length + bArr511110.length + bArr511111.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length41118 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length41118, bArr30.length);
                        int length41119 = length41118 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length41119, bArr31.length);
                        int length411110 = length41119 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length411110, bArr6.length);
                        int length411111 = length411110 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length411111, bArr26.length);
                        int length411112 = length411111 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length411112, 0);
                        int i110 = length411112 + 0;
                        java.lang.System.arraycopy(bArr511114, 0, bArr28, i110, bArr511114.length);
                        int length411113 = i110 + bArr511114.length;
                        java.lang.System.arraycopy(bArr511113, 0, bArr28, length411113, bArr511113.length);
                        int length411114 = length411113 + bArr511113.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length411114, bArr33.length);
                        int length411115 = length411114 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length411115, bArr34.length);
                        int length1111110 = length411115 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length1111110, bArr35.length);
                        int length1111111 = length1111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111, bArr36.length);
                        int length1111112 = length1111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length1111112, bArr37.length);
                        int length1111113 = length1111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length1111113, bArr7.length);
                        int length1111114 = length1111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr51119, 0, bArr28, length1111114, bArr51119.length);
                        int length1111115 = length1111114 + bArr51119.length;
                        java.lang.System.arraycopy(bArr511112, 0, bArr28, length1111115, bArr511112.length);
                        int length1111116 = length1111115 + bArr511112.length;
                        java.lang.System.arraycopy(bArr51118, 0, bArr28, length1111116, bArr51118.length);
                        int length1111117 = length1111116 + bArr51118.length;
                        java.lang.System.arraycopy(objArr6, 0, bArr28, length1111117, objArr6.length);
                        int length1111118 = length1111117 + objArr6.length;
                        java.lang.System.arraycopy(bArr511110, 0, bArr28, length1111118, bArr511110.length);
                        int length1111119 = length1111118 + bArr511110.length;
                        java.lang.System.arraycopy(bArr511111, 0, bArr28, length1111119, bArr511111.length);
                        int length218 = length1111119 + bArr511111.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length218, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length218 + bArr25.length, bArr24.length);
                        int length219 = bArr24.length;
                        i6 = i19;
                        i7 = i8;
                    } else {
                        byte[] bArr511115 = bArr12;
                        byte[] bArr511116 = bArr38;
                        byte[] bArr511117 = bArr17;
                        byte[] bArr511118 = bArr20;
                        byte[] bArr511119 = bArr10;
                        java.lang.Object[] objArr7 = bArr13;
                        int i111 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length411116 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr5111110 = bArr9;
                        byte[] bArr5111111 = bArr27;
                        bArr28 = new byte[length411116 + bArr5111110.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511116.length + bArr511119.length + bArr511115.length + objArr7.length + bArr511117.length + bArr511118.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length411117 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length411117, bArr30.length);
                        int length411118 = length411117 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length411118, bArr31.length);
                        int length411119 = length411118 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length411119, bArr6.length);
                        int length4111110 = length411119 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length4111110, bArr26.length);
                        int length4111111 = length4111110 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length4111111, 0);
                        int i112 = length4111111 + 0;
                        java.lang.System.arraycopy(bArr5111111, 0, bArr28, i112, bArr5111111.length);
                        int length4111112 = i112 + bArr5111111.length;
                        java.lang.System.arraycopy(bArr5111110, 0, bArr28, length4111112, bArr5111110.length);
                        int length4111113 = length4111112 + bArr5111110.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length4111113, bArr33.length);
                        int length4111114 = length4111113 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length4111114, bArr34.length);
                        int length11111110 = length4111114 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length11111110, bArr35.length);
                        int length11111111 = length11111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111, bArr36.length);
                        int length11111112 = length11111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length11111112, bArr37.length);
                        int length11111113 = length11111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length11111113, bArr7.length);
                        int length11111114 = length11111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr511116, 0, bArr28, length11111114, bArr511116.length);
                        int length11111115 = length11111114 + bArr511116.length;
                        java.lang.System.arraycopy(bArr511119, 0, bArr28, length11111115, bArr511119.length);
                        int length11111116 = length11111115 + bArr511119.length;
                        java.lang.System.arraycopy(bArr511115, 0, bArr28, length11111116, bArr511115.length);
                        int length11111117 = length11111116 + bArr511115.length;
                        java.lang.System.arraycopy(objArr7, 0, bArr28, length11111117, objArr7.length);
                        int length11111118 = length11111117 + objArr7.length;
                        java.lang.System.arraycopy(bArr511117, 0, bArr28, length11111118, bArr511117.length);
                        int length11111119 = length11111118 + bArr511117.length;
                        java.lang.System.arraycopy(bArr511118, 0, bArr28, length11111119, bArr511118.length);
                        int length2110 = length11111119 + bArr511118.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length2110, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length2110 + bArr25.length, bArr24.length);
                        int length2111 = bArr24.length;
                        i6 = i111;
                        i7 = i8;
                    }
                    return b(bArr28, i7, i6);
                }
                bArr12 = bArr39;
                bArr13 = bArr45;
                bArr14 = oicq.wlogin_sdk.request.t.O;
                if (bArr14 != null) {
                    bArr15 = bArr46;
                } else {
                    bArr15 = bArr46;
                }
                bArr16 = oicq.wlogin_sdk.request.t.L;
                if (bArr16 != null) {
                    bArr17 = bArr15;
                    if (bArr16.length > 0) {
                        bArr18 = tlv_t194Var.get_tlv_194(bArr16);
                        i5++;
                    }
                    bArr19 = oicq.wlogin_sdk.request.l.J;
                    if (bArr19 != null) {
                        bArr20 = bArr18;
                        if (bArr19.length > 0) {
                            bArr10 = bArr10;
                            bArr38 = bArr38;
                            bArr21 = tlv_t201Var.get_tlv_201(bArr19, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                            i5++;
                        }
                        bArr22 = oicq.wlogin_sdk.request.t.R;
                        if (bArr22 != null) {
                            bArr23 = bArr4;
                        } else {
                            bArr23 = bArr4;
                        }
                        bArr24 = bArr23;
                        bArr25 = bArr21;
                        bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                        if (bArr3 != null) {
                            byte[] bArr5111112 = bArr12;
                            byte[] bArr5111113 = bArr38;
                            byte[] bArr5111114 = bArr17;
                            byte[] bArr5111115 = bArr20;
                            byte[] bArr5111116 = bArr10;
                            java.lang.Object[] objArr8 = bArr13;
                            int i113 = i5 + 2;
                            str = this.x.g;
                            if (str != null) {
                                bArr27 = bArr5;
                            } else {
                                bArr27 = bArr5;
                            }
                            int length4111115 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                            byte[] bArr5111117 = bArr9;
                            byte[] bArr5111118 = bArr27;
                            bArr28 = new byte[length4111115 + bArr5111117.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111113.length + bArr5111116.length + bArr5111112.length + objArr8.length + bArr5111114.length + bArr5111115.length + bArr25.length + bArr24.length];
                            java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                            int length4111116 = bArr29.length + 0;
                            java.lang.System.arraycopy(bArr30, 0, bArr28, length4111116, bArr30.length);
                            int length4111117 = length4111116 + bArr30.length;
                            java.lang.System.arraycopy(bArr31, 0, bArr28, length4111117, bArr31.length);
                            int length4111118 = length4111117 + bArr31.length;
                            java.lang.System.arraycopy(bArr6, 0, bArr28, length4111118, bArr6.length);
                            int length4111119 = length4111118 + bArr6.length;
                            java.lang.System.arraycopy(bArr26, 0, bArr28, length4111119, bArr26.length);
                            int length41111110 = length4111119 + bArr26.length;
                            java.lang.System.arraycopy(bArr41, 0, bArr28, length41111110, 0);
                            int i114 = length41111110 + 0;
                            java.lang.System.arraycopy(bArr5111118, 0, bArr28, i114, bArr5111118.length);
                            int length41111111 = i114 + bArr5111118.length;
                            java.lang.System.arraycopy(bArr5111117, 0, bArr28, length41111111, bArr5111117.length);
                            int length41111112 = length41111111 + bArr5111117.length;
                            java.lang.System.arraycopy(bArr33, 0, bArr28, length41111112, bArr33.length);
                            int length41111113 = length41111112 + bArr33.length;
                            java.lang.System.arraycopy(bArr34, 0, bArr28, length41111113, bArr34.length);
                            int length111111110 = length41111113 + bArr34.length;
                            java.lang.System.arraycopy(bArr35, 0, bArr28, length111111110, bArr35.length);
                            int length111111111 = length111111110 + bArr35.length;
                            java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111, bArr36.length);
                            int length111111112 = length111111111 + bArr36.length;
                            java.lang.System.arraycopy(bArr37, 0, bArr28, length111111112, bArr37.length);
                            int length111111113 = length111111112 + bArr37.length;
                            java.lang.System.arraycopy(bArr7, 0, bArr28, length111111113, bArr7.length);
                            int length111111114 = length111111113 + bArr7.length;
                            java.lang.System.arraycopy(bArr5111113, 0, bArr28, length111111114, bArr5111113.length);
                            int length111111115 = length111111114 + bArr5111113.length;
                            java.lang.System.arraycopy(bArr5111116, 0, bArr28, length111111115, bArr5111116.length);
                            int length111111116 = length111111115 + bArr5111116.length;
                            java.lang.System.arraycopy(bArr5111112, 0, bArr28, length111111116, bArr5111112.length);
                            int length111111117 = length111111116 + bArr5111112.length;
                            java.lang.System.arraycopy(objArr8, 0, bArr28, length111111117, objArr8.length);
                            int length111111118 = length111111117 + objArr8.length;
                            java.lang.System.arraycopy(bArr5111114, 0, bArr28, length111111118, bArr5111114.length);
                            int length111111119 = length111111118 + bArr5111114.length;
                            java.lang.System.arraycopy(bArr5111115, 0, bArr28, length111111119, bArr5111115.length);
                            int length2112 = length111111119 + bArr5111115.length;
                            java.lang.System.arraycopy(bArr25, 0, bArr28, length2112, bArr25.length);
                            java.lang.System.arraycopy(bArr24, 0, bArr28, length2112 + bArr25.length, bArr24.length);
                            int length2113 = bArr24.length;
                            i6 = i113;
                            i7 = i8;
                        } else {
                            byte[] bArr5111119 = bArr12;
                            byte[] bArr51111110 = bArr38;
                            byte[] bArr51111111 = bArr17;
                            byte[] bArr51111112 = bArr20;
                            byte[] bArr51111113 = bArr10;
                            java.lang.Object[] objArr9 = bArr13;
                            int i115 = i5 + 2;
                            str = this.x.g;
                            if (str != null) {
                                bArr27 = bArr5;
                            } else {
                                bArr27 = bArr5;
                            }
                            int length41111114 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                            byte[] bArr51111114 = bArr9;
                            byte[] bArr51111115 = bArr27;
                            bArr28 = new byte[length41111114 + bArr51111114.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111110.length + bArr51111113.length + bArr5111119.length + objArr9.length + bArr51111111.length + bArr51111112.length + bArr25.length + bArr24.length];
                            java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                            int length41111115 = bArr29.length + 0;
                            java.lang.System.arraycopy(bArr30, 0, bArr28, length41111115, bArr30.length);
                            int length41111116 = length41111115 + bArr30.length;
                            java.lang.System.arraycopy(bArr31, 0, bArr28, length41111116, bArr31.length);
                            int length41111117 = length41111116 + bArr31.length;
                            java.lang.System.arraycopy(bArr6, 0, bArr28, length41111117, bArr6.length);
                            int length41111118 = length41111117 + bArr6.length;
                            java.lang.System.arraycopy(bArr26, 0, bArr28, length41111118, bArr26.length);
                            int length41111119 = length41111118 + bArr26.length;
                            java.lang.System.arraycopy(bArr41, 0, bArr28, length41111119, 0);
                            int i116 = length41111119 + 0;
                            java.lang.System.arraycopy(bArr51111115, 0, bArr28, i116, bArr51111115.length);
                            int length411111110 = i116 + bArr51111115.length;
                            java.lang.System.arraycopy(bArr51111114, 0, bArr28, length411111110, bArr51111114.length);
                            int length411111111 = length411111110 + bArr51111114.length;
                            java.lang.System.arraycopy(bArr33, 0, bArr28, length411111111, bArr33.length);
                            int length411111112 = length411111111 + bArr33.length;
                            java.lang.System.arraycopy(bArr34, 0, bArr28, length411111112, bArr34.length);
                            int length1111111110 = length411111112 + bArr34.length;
                            java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111110, bArr35.length);
                            int length1111111111 = length1111111110 + bArr35.length;
                            java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111, bArr36.length);
                            int length1111111112 = length1111111111 + bArr36.length;
                            java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111112, bArr37.length);
                            int length1111111113 = length1111111112 + bArr37.length;
                            java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111113, bArr7.length);
                            int length1111111114 = length1111111113 + bArr7.length;
                            java.lang.System.arraycopy(bArr51111110, 0, bArr28, length1111111114, bArr51111110.length);
                            int length1111111115 = length1111111114 + bArr51111110.length;
                            java.lang.System.arraycopy(bArr51111113, 0, bArr28, length1111111115, bArr51111113.length);
                            int length1111111116 = length1111111115 + bArr51111113.length;
                            java.lang.System.arraycopy(bArr5111119, 0, bArr28, length1111111116, bArr5111119.length);
                            int length1111111117 = length1111111116 + bArr5111119.length;
                            java.lang.System.arraycopy(objArr9, 0, bArr28, length1111111117, objArr9.length);
                            int length1111111118 = length1111111117 + objArr9.length;
                            java.lang.System.arraycopy(bArr51111111, 0, bArr28, length1111111118, bArr51111111.length);
                            int length1111111119 = length1111111118 + bArr51111111.length;
                            java.lang.System.arraycopy(bArr51111112, 0, bArr28, length1111111119, bArr51111112.length);
                            int length2114 = length1111111119 + bArr51111112.length;
                            java.lang.System.arraycopy(bArr25, 0, bArr28, length2114, bArr25.length);
                            java.lang.System.arraycopy(bArr24, 0, bArr28, length2114 + bArr25.length, bArr24.length);
                            int length2115 = bArr24.length;
                            i6 = i115;
                            i7 = i8;
                        }
                        return b(bArr28, i7, i6);
                    }
                    bArr20 = bArr18;
                    bArr21 = bArr48;
                    bArr22 = oicq.wlogin_sdk.request.t.R;
                    if (bArr22 != null) {
                        bArr23 = bArr4;
                    } else {
                        bArr23 = bArr4;
                    }
                    bArr24 = bArr23;
                    bArr25 = bArr21;
                    bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                    if (bArr3 != null) {
                        byte[] bArr51111116 = bArr12;
                        byte[] bArr51111117 = bArr38;
                        byte[] bArr51111118 = bArr17;
                        byte[] bArr51111119 = bArr20;
                        byte[] bArr511111110 = bArr10;
                        java.lang.Object[] objArr10 = bArr13;
                        int i117 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length411111113 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr511111111 = bArr9;
                        byte[] bArr511111112 = bArr27;
                        bArr28 = new byte[length411111113 + bArr511111111.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111117.length + bArr511111110.length + bArr51111116.length + objArr10.length + bArr51111118.length + bArr51111119.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length411111114 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length411111114, bArr30.length);
                        int length411111115 = length411111114 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length411111115, bArr31.length);
                        int length411111116 = length411111115 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length411111116, bArr6.length);
                        int length411111117 = length411111116 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length411111117, bArr26.length);
                        int length411111118 = length411111117 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length411111118, 0);
                        int i118 = length411111118 + 0;
                        java.lang.System.arraycopy(bArr511111112, 0, bArr28, i118, bArr511111112.length);
                        int length411111119 = i118 + bArr511111112.length;
                        java.lang.System.arraycopy(bArr511111111, 0, bArr28, length411111119, bArr511111111.length);
                        int length4111111110 = length411111119 + bArr511111111.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111110, bArr33.length);
                        int length4111111111 = length4111111110 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length4111111111, bArr34.length);
                        int length11111111110 = length4111111111 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111110, bArr35.length);
                        int length11111111111 = length11111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111, bArr36.length);
                        int length11111111112 = length11111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111112, bArr37.length);
                        int length11111111113 = length11111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111113, bArr7.length);
                        int length11111111114 = length11111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr51111117, 0, bArr28, length11111111114, bArr51111117.length);
                        int length11111111115 = length11111111114 + bArr51111117.length;
                        java.lang.System.arraycopy(bArr511111110, 0, bArr28, length11111111115, bArr511111110.length);
                        int length11111111116 = length11111111115 + bArr511111110.length;
                        java.lang.System.arraycopy(bArr51111116, 0, bArr28, length11111111116, bArr51111116.length);
                        int length11111111117 = length11111111116 + bArr51111116.length;
                        java.lang.System.arraycopy(objArr10, 0, bArr28, length11111111117, objArr10.length);
                        int length11111111118 = length11111111117 + objArr10.length;
                        java.lang.System.arraycopy(bArr51111118, 0, bArr28, length11111111118, bArr51111118.length);
                        int length11111111119 = length11111111118 + bArr51111118.length;
                        java.lang.System.arraycopy(bArr51111119, 0, bArr28, length11111111119, bArr51111119.length);
                        int length2116 = length11111111119 + bArr51111119.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length2116, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length2116 + bArr25.length, bArr24.length);
                        int length2117 = bArr24.length;
                        i6 = i117;
                        i7 = i8;
                    } else {
                        byte[] bArr511111113 = bArr12;
                        byte[] bArr511111114 = bArr38;
                        byte[] bArr511111115 = bArr17;
                        byte[] bArr511111116 = bArr20;
                        byte[] bArr511111117 = bArr10;
                        java.lang.Object[] objArr11 = bArr13;
                        int i119 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length4111111112 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr511111118 = bArr9;
                        byte[] bArr511111119 = bArr27;
                        bArr28 = new byte[length4111111112 + bArr511111118.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111114.length + bArr511111117.length + bArr511111113.length + objArr11.length + bArr511111115.length + bArr511111116.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length4111111113 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111113, bArr30.length);
                        int length4111111114 = length4111111113 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length4111111114, bArr31.length);
                        int length4111111115 = length4111111114 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length4111111115, bArr6.length);
                        int length4111111116 = length4111111115 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111116, bArr26.length);
                        int length4111111117 = length4111111116 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length4111111117, 0);
                        int i1110 = length4111111117 + 0;
                        java.lang.System.arraycopy(bArr511111119, 0, bArr28, i1110, bArr511111119.length);
                        int length4111111118 = i1110 + bArr511111119.length;
                        java.lang.System.arraycopy(bArr511111118, 0, bArr28, length4111111118, bArr511111118.length);
                        int length4111111119 = length4111111118 + bArr511111118.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111119, bArr33.length);
                        int length41111111110 = length4111111119 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111110, bArr34.length);
                        int length111111111110 = length41111111110 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111110, bArr35.length);
                        int length111111111111 = length111111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111, bArr36.length);
                        int length111111111112 = length111111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111112, bArr37.length);
                        int length111111111113 = length111111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111113, bArr7.length);
                        int length111111111114 = length111111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr511111114, 0, bArr28, length111111111114, bArr511111114.length);
                        int length111111111115 = length111111111114 + bArr511111114.length;
                        java.lang.System.arraycopy(bArr511111117, 0, bArr28, length111111111115, bArr511111117.length);
                        int length111111111116 = length111111111115 + bArr511111117.length;
                        java.lang.System.arraycopy(bArr511111113, 0, bArr28, length111111111116, bArr511111113.length);
                        int length111111111117 = length111111111116 + bArr511111113.length;
                        java.lang.System.arraycopy(objArr11, 0, bArr28, length111111111117, objArr11.length);
                        int length111111111118 = length111111111117 + objArr11.length;
                        java.lang.System.arraycopy(bArr511111115, 0, bArr28, length111111111118, bArr511111115.length);
                        int length111111111119 = length111111111118 + bArr511111115.length;
                        java.lang.System.arraycopy(bArr511111116, 0, bArr28, length111111111119, bArr511111116.length);
                        int length2118 = length111111111119 + bArr511111116.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length2118, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length2118 + bArr25.length, bArr24.length);
                        int length2119 = bArr24.length;
                        i6 = i119;
                        i7 = i8;
                    }
                    return b(bArr28, i7, i6);
                }
                bArr17 = bArr15;
                bArr18 = bArr47;
                bArr19 = oicq.wlogin_sdk.request.l.J;
                if (bArr19 != null) {
                    bArr20 = bArr18;
                    if (bArr19.length > 0) {
                        bArr10 = bArr10;
                        bArr38 = bArr38;
                        bArr21 = tlv_t201Var.get_tlv_201(bArr19, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                        i5++;
                    }
                    bArr22 = oicq.wlogin_sdk.request.t.R;
                    if (bArr22 != null) {
                        bArr23 = bArr4;
                    } else {
                        bArr23 = bArr4;
                    }
                    bArr24 = bArr23;
                    bArr25 = bArr21;
                    bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                    if (bArr3 != null) {
                        byte[] bArr5111111110 = bArr12;
                        byte[] bArr5111111111 = bArr38;
                        byte[] bArr5111111112 = bArr17;
                        byte[] bArr5111111113 = bArr20;
                        byte[] bArr5111111114 = bArr10;
                        java.lang.Object[] objArr12 = bArr13;
                        int i1111 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length41111111111 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr5111111115 = bArr9;
                        byte[] bArr5111111116 = bArr27;
                        bArr28 = new byte[length41111111111 + bArr5111111115.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111111.length + bArr5111111114.length + bArr5111111110.length + objArr12.length + bArr5111111112.length + bArr5111111113.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length41111111112 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length41111111112, bArr30.length);
                        int length41111111113 = length41111111112 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111113, bArr31.length);
                        int length41111111114 = length41111111113 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length41111111114, bArr6.length);
                        int length41111111115 = length41111111114 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length41111111115, bArr26.length);
                        int length41111111116 = length41111111115 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111116, 0);
                        int i1112 = length41111111116 + 0;
                        java.lang.System.arraycopy(bArr5111111116, 0, bArr28, i1112, bArr5111111116.length);
                        int length41111111117 = i1112 + bArr5111111116.length;
                        java.lang.System.arraycopy(bArr5111111115, 0, bArr28, length41111111117, bArr5111111115.length);
                        int length41111111118 = length41111111117 + bArr5111111115.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length41111111118, bArr33.length);
                        int length41111111119 = length41111111118 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111119, bArr34.length);
                        int length1111111111110 = length41111111119 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111110, bArr35.length);
                        int length1111111111111 = length1111111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111, bArr36.length);
                        int length1111111111112 = length1111111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111112, bArr37.length);
                        int length1111111111113 = length1111111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111113, bArr7.length);
                        int length1111111111114 = length1111111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr5111111111, 0, bArr28, length1111111111114, bArr5111111111.length);
                        int length1111111111115 = length1111111111114 + bArr5111111111.length;
                        java.lang.System.arraycopy(bArr5111111114, 0, bArr28, length1111111111115, bArr5111111114.length);
                        int length1111111111116 = length1111111111115 + bArr5111111114.length;
                        java.lang.System.arraycopy(bArr5111111110, 0, bArr28, length1111111111116, bArr5111111110.length);
                        int length1111111111117 = length1111111111116 + bArr5111111110.length;
                        java.lang.System.arraycopy(objArr12, 0, bArr28, length1111111111117, objArr12.length);
                        int length1111111111118 = length1111111111117 + objArr12.length;
                        java.lang.System.arraycopy(bArr5111111112, 0, bArr28, length1111111111118, bArr5111111112.length);
                        int length1111111111119 = length1111111111118 + bArr5111111112.length;
                        java.lang.System.arraycopy(bArr5111111113, 0, bArr28, length1111111111119, bArr5111111113.length);
                        int length21110 = length1111111111119 + bArr5111111113.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length21110, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length21110 + bArr25.length, bArr24.length);
                        int length21111 = bArr24.length;
                        i6 = i1111;
                        i7 = i8;
                    } else {
                        byte[] bArr5111111117 = bArr12;
                        byte[] bArr5111111118 = bArr38;
                        byte[] bArr5111111119 = bArr17;
                        byte[] bArr51111111110 = bArr20;
                        byte[] bArr51111111111 = bArr10;
                        java.lang.Object[] objArr13 = bArr13;
                        int i1113 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length411111111110 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr51111111112 = bArr9;
                        byte[] bArr51111111113 = bArr27;
                        bArr28 = new byte[length411111111110 + bArr51111111112.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111118.length + bArr51111111111.length + bArr5111111117.length + objArr13.length + bArr5111111119.length + bArr51111111110.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length411111111111 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length411111111111, bArr30.length);
                        int length411111111112 = length411111111111 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length411111111112, bArr31.length);
                        int length411111111113 = length411111111112 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111113, bArr6.length);
                        int length411111111114 = length411111111113 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length411111111114, bArr26.length);
                        int length411111111115 = length411111111114 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length411111111115, 0);
                        int i1114 = length411111111115 + 0;
                        java.lang.System.arraycopy(bArr51111111113, 0, bArr28, i1114, bArr51111111113.length);
                        int length411111111116 = i1114 + bArr51111111113.length;
                        java.lang.System.arraycopy(bArr51111111112, 0, bArr28, length411111111116, bArr51111111112.length);
                        int length411111111117 = length411111111116 + bArr51111111112.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length411111111117, bArr33.length);
                        int length411111111118 = length411111111117 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length411111111118, bArr34.length);
                        int length11111111111110 = length411111111118 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111111110, bArr35.length);
                        int length11111111111111 = length11111111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111111, bArr36.length);
                        int length11111111111112 = length11111111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111111112, bArr37.length);
                        int length11111111111113 = length11111111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111111113, bArr7.length);
                        int length11111111111114 = length11111111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr5111111118, 0, bArr28, length11111111111114, bArr5111111118.length);
                        int length11111111111115 = length11111111111114 + bArr5111111118.length;
                        java.lang.System.arraycopy(bArr51111111111, 0, bArr28, length11111111111115, bArr51111111111.length);
                        int length11111111111116 = length11111111111115 + bArr51111111111.length;
                        java.lang.System.arraycopy(bArr5111111117, 0, bArr28, length11111111111116, bArr5111111117.length);
                        int length11111111111117 = length11111111111116 + bArr5111111117.length;
                        java.lang.System.arraycopy(objArr13, 0, bArr28, length11111111111117, objArr13.length);
                        int length11111111111118 = length11111111111117 + objArr13.length;
                        java.lang.System.arraycopy(bArr5111111119, 0, bArr28, length11111111111118, bArr5111111119.length);
                        int length11111111111119 = length11111111111118 + bArr5111111119.length;
                        java.lang.System.arraycopy(bArr51111111110, 0, bArr28, length11111111111119, bArr51111111110.length);
                        int length21112 = length11111111111119 + bArr51111111110.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length21112, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length21112 + bArr25.length, bArr24.length);
                        int length21113 = bArr24.length;
                        i6 = i1113;
                        i7 = i8;
                    }
                    return b(bArr28, i7, i6);
                }
                bArr20 = bArr18;
                bArr21 = bArr48;
                bArr22 = oicq.wlogin_sdk.request.t.R;
                if (bArr22 != null) {
                    bArr23 = bArr4;
                } else {
                    bArr23 = bArr4;
                }
                bArr24 = bArr23;
                bArr25 = bArr21;
                bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                if (bArr3 != null) {
                    byte[] bArr51111111114 = bArr12;
                    byte[] bArr51111111115 = bArr38;
                    byte[] bArr51111111116 = bArr17;
                    byte[] bArr51111111117 = bArr20;
                    byte[] bArr51111111118 = bArr10;
                    java.lang.Object[] objArr14 = bArr13;
                    int i1115 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length411111111119 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr51111111119 = bArr9;
                    byte[] bArr511111111110 = bArr27;
                    bArr28 = new byte[length411111111119 + bArr51111111119.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111111115.length + bArr51111111118.length + bArr51111111114.length + objArr14.length + bArr51111111116.length + bArr51111111117.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length4111111111110 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111110, bArr30.length);
                    int length4111111111111 = length4111111111110 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length4111111111111, bArr31.length);
                    int length4111111111112 = length4111111111111 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length4111111111112, bArr6.length);
                    int length4111111111113 = length4111111111112 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111113, bArr26.length);
                    int length4111111111114 = length4111111111113 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length4111111111114, 0);
                    int i1116 = length4111111111114 + 0;
                    java.lang.System.arraycopy(bArr511111111110, 0, bArr28, i1116, bArr511111111110.length);
                    int length4111111111115 = i1116 + bArr511111111110.length;
                    java.lang.System.arraycopy(bArr51111111119, 0, bArr28, length4111111111115, bArr51111111119.length);
                    int length4111111111116 = length4111111111115 + bArr51111111119.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111116, bArr33.length);
                    int length4111111111117 = length4111111111116 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length4111111111117, bArr34.length);
                    int length111111111111110 = length4111111111117 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111111110, bArr35.length);
                    int length111111111111111 = length111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111111, bArr36.length);
                    int length111111111111112 = length111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111111112, bArr37.length);
                    int length111111111111113 = length111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111111113, bArr7.length);
                    int length111111111111114 = length111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr51111111115, 0, bArr28, length111111111111114, bArr51111111115.length);
                    int length111111111111115 = length111111111111114 + bArr51111111115.length;
                    java.lang.System.arraycopy(bArr51111111118, 0, bArr28, length111111111111115, bArr51111111118.length);
                    int length111111111111116 = length111111111111115 + bArr51111111118.length;
                    java.lang.System.arraycopy(bArr51111111114, 0, bArr28, length111111111111116, bArr51111111114.length);
                    int length111111111111117 = length111111111111116 + bArr51111111114.length;
                    java.lang.System.arraycopy(objArr14, 0, bArr28, length111111111111117, objArr14.length);
                    int length111111111111118 = length111111111111117 + objArr14.length;
                    java.lang.System.arraycopy(bArr51111111116, 0, bArr28, length111111111111118, bArr51111111116.length);
                    int length111111111111119 = length111111111111118 + bArr51111111116.length;
                    java.lang.System.arraycopy(bArr51111111117, 0, bArr28, length111111111111119, bArr51111111117.length);
                    int length21114 = length111111111111119 + bArr51111111117.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length21114, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length21114 + bArr25.length, bArr24.length);
                    int length21115 = bArr24.length;
                    i6 = i1115;
                    i7 = i8;
                } else {
                    byte[] bArr511111111111 = bArr12;
                    byte[] bArr511111111112 = bArr38;
                    byte[] bArr511111111113 = bArr17;
                    byte[] bArr511111111114 = bArr20;
                    byte[] bArr511111111115 = bArr10;
                    java.lang.Object[] objArr15 = bArr13;
                    int i1117 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length4111111111118 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr511111111116 = bArr9;
                    byte[] bArr511111111117 = bArr27;
                    bArr28 = new byte[length4111111111118 + bArr511111111116.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111112.length + bArr511111111115.length + bArr511111111111.length + objArr15.length + bArr511111111113.length + bArr511111111114.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length4111111111119 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111119, bArr30.length);
                    int length41111111111110 = length4111111111119 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111110, bArr31.length);
                    int length41111111111111 = length41111111111110 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length41111111111111, bArr6.length);
                    int length41111111111112 = length41111111111111 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length41111111111112, bArr26.length);
                    int length41111111111113 = length41111111111112 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111113, 0);
                    int i1118 = length41111111111113 + 0;
                    java.lang.System.arraycopy(bArr511111111117, 0, bArr28, i1118, bArr511111111117.length);
                    int length41111111111114 = i1118 + bArr511111111117.length;
                    java.lang.System.arraycopy(bArr511111111116, 0, bArr28, length41111111111114, bArr511111111116.length);
                    int length41111111111115 = length41111111111114 + bArr511111111116.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length41111111111115, bArr33.length);
                    int length41111111111116 = length41111111111115 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111116, bArr34.length);
                    int length1111111111111110 = length41111111111116 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111111110, bArr35.length);
                    int length1111111111111111 = length1111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111111, bArr36.length);
                    int length1111111111111112 = length1111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111111112, bArr37.length);
                    int length1111111111111113 = length1111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111111113, bArr7.length);
                    int length1111111111111114 = length1111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr511111111112, 0, bArr28, length1111111111111114, bArr511111111112.length);
                    int length1111111111111115 = length1111111111111114 + bArr511111111112.length;
                    java.lang.System.arraycopy(bArr511111111115, 0, bArr28, length1111111111111115, bArr511111111115.length);
                    int length1111111111111116 = length1111111111111115 + bArr511111111115.length;
                    java.lang.System.arraycopy(bArr511111111111, 0, bArr28, length1111111111111116, bArr511111111111.length);
                    int length1111111111111117 = length1111111111111116 + bArr511111111111.length;
                    java.lang.System.arraycopy(objArr15, 0, bArr28, length1111111111111117, objArr15.length);
                    int length1111111111111118 = length1111111111111117 + objArr15.length;
                    java.lang.System.arraycopy(bArr511111111113, 0, bArr28, length1111111111111118, bArr511111111113.length);
                    int length1111111111111119 = length1111111111111118 + bArr511111111113.length;
                    java.lang.System.arraycopy(bArr511111111114, 0, bArr28, length1111111111111119, bArr511111111114.length);
                    int length21116 = length1111111111111119 + bArr511111111114.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length21116, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length21116 + bArr25.length, bArr24.length);
                    int length21117 = bArr24.length;
                    i6 = i1117;
                    i7 = i8;
                }
                return b(bArr28, i7, i6);
            }
            bArr9 = bArr32;
            bArr10 = bArr44;
            bArr11 = oicq.wlogin_sdk.request.t.N;
            if (bArr11 != null) {
                bArr12 = bArr39;
                if (bArr11.length > 0) {
                    bArr13 = tlv_t187Var.get_tlv_187(bArr11);
                    i5++;
                }
                bArr14 = oicq.wlogin_sdk.request.t.O;
                if (bArr14 != null) {
                    bArr15 = bArr46;
                } else {
                    bArr15 = bArr46;
                }
                bArr16 = oicq.wlogin_sdk.request.t.L;
                if (bArr16 != null) {
                    bArr17 = bArr15;
                    if (bArr16.length > 0) {
                        bArr18 = tlv_t194Var.get_tlv_194(bArr16);
                        i5++;
                    }
                    bArr19 = oicq.wlogin_sdk.request.l.J;
                    if (bArr19 != null) {
                        bArr20 = bArr18;
                        if (bArr19.length > 0) {
                            bArr10 = bArr10;
                            bArr38 = bArr38;
                            bArr21 = tlv_t201Var.get_tlv_201(bArr19, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                            i5++;
                        }
                        bArr22 = oicq.wlogin_sdk.request.t.R;
                        if (bArr22 != null) {
                            bArr23 = bArr4;
                        } else {
                            bArr23 = bArr4;
                        }
                        bArr24 = bArr23;
                        bArr25 = bArr21;
                        bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                        if (bArr3 != null) {
                            byte[] bArr511111111118 = bArr12;
                            byte[] bArr511111111119 = bArr38;
                            byte[] bArr5111111111110 = bArr17;
                            byte[] bArr5111111111111 = bArr20;
                            byte[] bArr5111111111112 = bArr10;
                            java.lang.Object[] objArr16 = bArr13;
                            int i1119 = i5 + 2;
                            str = this.x.g;
                            if (str != null) {
                                bArr27 = bArr5;
                            } else {
                                bArr27 = bArr5;
                            }
                            int length41111111111117 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                            byte[] bArr5111111111113 = bArr9;
                            byte[] bArr5111111111114 = bArr27;
                            bArr28 = new byte[length41111111111117 + bArr5111111111113.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111119.length + bArr5111111111112.length + bArr511111111118.length + objArr16.length + bArr5111111111110.length + bArr5111111111111.length + bArr25.length + bArr24.length];
                            java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                            int length41111111111118 = bArr29.length + 0;
                            java.lang.System.arraycopy(bArr30, 0, bArr28, length41111111111118, bArr30.length);
                            int length41111111111119 = length41111111111118 + bArr30.length;
                            java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111119, bArr31.length);
                            int length411111111111110 = length41111111111119 + bArr31.length;
                            java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111110, bArr6.length);
                            int length411111111111111 = length411111111111110 + bArr6.length;
                            java.lang.System.arraycopy(bArr26, 0, bArr28, length411111111111111, bArr26.length);
                            int length411111111111112 = length411111111111111 + bArr26.length;
                            java.lang.System.arraycopy(bArr41, 0, bArr28, length411111111111112, 0);
                            int i11110 = length411111111111112 + 0;
                            java.lang.System.arraycopy(bArr5111111111114, 0, bArr28, i11110, bArr5111111111114.length);
                            int length411111111111113 = i11110 + bArr5111111111114.length;
                            java.lang.System.arraycopy(bArr5111111111113, 0, bArr28, length411111111111113, bArr5111111111113.length);
                            int length411111111111114 = length411111111111113 + bArr5111111111113.length;
                            java.lang.System.arraycopy(bArr33, 0, bArr28, length411111111111114, bArr33.length);
                            int length411111111111115 = length411111111111114 + bArr33.length;
                            java.lang.System.arraycopy(bArr34, 0, bArr28, length411111111111115, bArr34.length);
                            int length11111111111111110 = length411111111111115 + bArr34.length;
                            java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111111111110, bArr35.length);
                            int length11111111111111111 = length11111111111111110 + bArr35.length;
                            java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111111111, bArr36.length);
                            int length11111111111111112 = length11111111111111111 + bArr36.length;
                            java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111111111112, bArr37.length);
                            int length11111111111111113 = length11111111111111112 + bArr37.length;
                            java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111111111113, bArr7.length);
                            int length11111111111111114 = length11111111111111113 + bArr7.length;
                            java.lang.System.arraycopy(bArr511111111119, 0, bArr28, length11111111111111114, bArr511111111119.length);
                            int length11111111111111115 = length11111111111111114 + bArr511111111119.length;
                            java.lang.System.arraycopy(bArr5111111111112, 0, bArr28, length11111111111111115, bArr5111111111112.length);
                            int length11111111111111116 = length11111111111111115 + bArr5111111111112.length;
                            java.lang.System.arraycopy(bArr511111111118, 0, bArr28, length11111111111111116, bArr511111111118.length);
                            int length11111111111111117 = length11111111111111116 + bArr511111111118.length;
                            java.lang.System.arraycopy(objArr16, 0, bArr28, length11111111111111117, objArr16.length);
                            int length11111111111111118 = length11111111111111117 + objArr16.length;
                            java.lang.System.arraycopy(bArr5111111111110, 0, bArr28, length11111111111111118, bArr5111111111110.length);
                            int length11111111111111119 = length11111111111111118 + bArr5111111111110.length;
                            java.lang.System.arraycopy(bArr5111111111111, 0, bArr28, length11111111111111119, bArr5111111111111.length);
                            int length21118 = length11111111111111119 + bArr5111111111111.length;
                            java.lang.System.arraycopy(bArr25, 0, bArr28, length21118, bArr25.length);
                            java.lang.System.arraycopy(bArr24, 0, bArr28, length21118 + bArr25.length, bArr24.length);
                            int length21119 = bArr24.length;
                            i6 = i1119;
                            i7 = i8;
                        } else {
                            byte[] bArr5111111111115 = bArr12;
                            byte[] bArr5111111111116 = bArr38;
                            byte[] bArr5111111111117 = bArr17;
                            byte[] bArr5111111111118 = bArr20;
                            byte[] bArr5111111111119 = bArr10;
                            java.lang.Object[] objArr17 = bArr13;
                            int i11111 = i5 + 2;
                            str = this.x.g;
                            if (str != null) {
                                bArr27 = bArr5;
                            } else {
                                bArr27 = bArr5;
                            }
                            int length411111111111116 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                            byte[] bArr51111111111110 = bArr9;
                            byte[] bArr51111111111111 = bArr27;
                            bArr28 = new byte[length411111111111116 + bArr51111111111110.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111111116.length + bArr5111111111119.length + bArr5111111111115.length + objArr17.length + bArr5111111111117.length + bArr5111111111118.length + bArr25.length + bArr24.length];
                            java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                            int length411111111111117 = bArr29.length + 0;
                            java.lang.System.arraycopy(bArr30, 0, bArr28, length411111111111117, bArr30.length);
                            int length411111111111118 = length411111111111117 + bArr30.length;
                            java.lang.System.arraycopy(bArr31, 0, bArr28, length411111111111118, bArr31.length);
                            int length411111111111119 = length411111111111118 + bArr31.length;
                            java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111119, bArr6.length);
                            int length4111111111111110 = length411111111111119 + bArr6.length;
                            java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111110, bArr26.length);
                            int length4111111111111111 = length4111111111111110 + bArr26.length;
                            java.lang.System.arraycopy(bArr41, 0, bArr28, length4111111111111111, 0);
                            int i11112 = length4111111111111111 + 0;
                            java.lang.System.arraycopy(bArr51111111111111, 0, bArr28, i11112, bArr51111111111111.length);
                            int length4111111111111112 = i11112 + bArr51111111111111.length;
                            java.lang.System.arraycopy(bArr51111111111110, 0, bArr28, length4111111111111112, bArr51111111111110.length);
                            int length4111111111111113 = length4111111111111112 + bArr51111111111110.length;
                            java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111113, bArr33.length);
                            int length4111111111111114 = length4111111111111113 + bArr33.length;
                            java.lang.System.arraycopy(bArr34, 0, bArr28, length4111111111111114, bArr34.length);
                            int length111111111111111110 = length4111111111111114 + bArr34.length;
                            java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111111111110, bArr35.length);
                            int length111111111111111111 = length111111111111111110 + bArr35.length;
                            java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111111111, bArr36.length);
                            int length111111111111111112 = length111111111111111111 + bArr36.length;
                            java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111111111112, bArr37.length);
                            int length111111111111111113 = length111111111111111112 + bArr37.length;
                            java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111111111113, bArr7.length);
                            int length111111111111111114 = length111111111111111113 + bArr7.length;
                            java.lang.System.arraycopy(bArr5111111111116, 0, bArr28, length111111111111111114, bArr5111111111116.length);
                            int length111111111111111115 = length111111111111111114 + bArr5111111111116.length;
                            java.lang.System.arraycopy(bArr5111111111119, 0, bArr28, length111111111111111115, bArr5111111111119.length);
                            int length111111111111111116 = length111111111111111115 + bArr5111111111119.length;
                            java.lang.System.arraycopy(bArr5111111111115, 0, bArr28, length111111111111111116, bArr5111111111115.length);
                            int length111111111111111117 = length111111111111111116 + bArr5111111111115.length;
                            java.lang.System.arraycopy(objArr17, 0, bArr28, length111111111111111117, objArr17.length);
                            int length111111111111111118 = length111111111111111117 + objArr17.length;
                            java.lang.System.arraycopy(bArr5111111111117, 0, bArr28, length111111111111111118, bArr5111111111117.length);
                            int length111111111111111119 = length111111111111111118 + bArr5111111111117.length;
                            java.lang.System.arraycopy(bArr5111111111118, 0, bArr28, length111111111111111119, bArr5111111111118.length);
                            int length211110 = length111111111111111119 + bArr5111111111118.length;
                            java.lang.System.arraycopy(bArr25, 0, bArr28, length211110, bArr25.length);
                            java.lang.System.arraycopy(bArr24, 0, bArr28, length211110 + bArr25.length, bArr24.length);
                            int length211111 = bArr24.length;
                            i6 = i11111;
                            i7 = i8;
                        }
                        return b(bArr28, i7, i6);
                    }
                    bArr20 = bArr18;
                    bArr21 = bArr48;
                    bArr22 = oicq.wlogin_sdk.request.t.R;
                    if (bArr22 != null) {
                        bArr23 = bArr4;
                    } else {
                        bArr23 = bArr4;
                    }
                    bArr24 = bArr23;
                    bArr25 = bArr21;
                    bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                    if (bArr3 != null) {
                        byte[] bArr51111111111112 = bArr12;
                        byte[] bArr51111111111113 = bArr38;
                        byte[] bArr51111111111114 = bArr17;
                        byte[] bArr51111111111115 = bArr20;
                        byte[] bArr51111111111116 = bArr10;
                        java.lang.Object[] objArr18 = bArr13;
                        int i11113 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length4111111111111115 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr51111111111117 = bArr9;
                        byte[] bArr51111111111118 = bArr27;
                        bArr28 = new byte[length4111111111111115 + bArr51111111111117.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111111111113.length + bArr51111111111116.length + bArr51111111111112.length + objArr18.length + bArr51111111111114.length + bArr51111111111115.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length4111111111111116 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111116, bArr30.length);
                        int length4111111111111117 = length4111111111111116 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length4111111111111117, bArr31.length);
                        int length4111111111111118 = length4111111111111117 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length4111111111111118, bArr6.length);
                        int length4111111111111119 = length4111111111111118 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111119, bArr26.length);
                        int length41111111111111110 = length4111111111111119 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111110, 0);
                        int i11114 = length41111111111111110 + 0;
                        java.lang.System.arraycopy(bArr51111111111118, 0, bArr28, i11114, bArr51111111111118.length);
                        int length41111111111111111 = i11114 + bArr51111111111118.length;
                        java.lang.System.arraycopy(bArr51111111111117, 0, bArr28, length41111111111111111, bArr51111111111117.length);
                        int length41111111111111112 = length41111111111111111 + bArr51111111111117.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length41111111111111112, bArr33.length);
                        int length41111111111111113 = length41111111111111112 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111113, bArr34.length);
                        int length1111111111111111110 = length41111111111111113 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111111111110, bArr35.length);
                        int length1111111111111111111 = length1111111111111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111111111, bArr36.length);
                        int length1111111111111111112 = length1111111111111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111111111112, bArr37.length);
                        int length1111111111111111113 = length1111111111111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111111111113, bArr7.length);
                        int length1111111111111111114 = length1111111111111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr51111111111113, 0, bArr28, length1111111111111111114, bArr51111111111113.length);
                        int length1111111111111111115 = length1111111111111111114 + bArr51111111111113.length;
                        java.lang.System.arraycopy(bArr51111111111116, 0, bArr28, length1111111111111111115, bArr51111111111116.length);
                        int length1111111111111111116 = length1111111111111111115 + bArr51111111111116.length;
                        java.lang.System.arraycopy(bArr51111111111112, 0, bArr28, length1111111111111111116, bArr51111111111112.length);
                        int length1111111111111111117 = length1111111111111111116 + bArr51111111111112.length;
                        java.lang.System.arraycopy(objArr18, 0, bArr28, length1111111111111111117, objArr18.length);
                        int length1111111111111111118 = length1111111111111111117 + objArr18.length;
                        java.lang.System.arraycopy(bArr51111111111114, 0, bArr28, length1111111111111111118, bArr51111111111114.length);
                        int length1111111111111111119 = length1111111111111111118 + bArr51111111111114.length;
                        java.lang.System.arraycopy(bArr51111111111115, 0, bArr28, length1111111111111111119, bArr51111111111115.length);
                        int length211112 = length1111111111111111119 + bArr51111111111115.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length211112, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length211112 + bArr25.length, bArr24.length);
                        int length211113 = bArr24.length;
                        i6 = i11113;
                        i7 = i8;
                    } else {
                        byte[] bArr51111111111119 = bArr12;
                        byte[] bArr511111111111110 = bArr38;
                        byte[] bArr511111111111111 = bArr17;
                        byte[] bArr511111111111112 = bArr20;
                        byte[] bArr511111111111113 = bArr10;
                        java.lang.Object[] objArr19 = bArr13;
                        int i11115 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length41111111111111114 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr511111111111114 = bArr9;
                        byte[] bArr511111111111115 = bArr27;
                        bArr28 = new byte[length41111111111111114 + bArr511111111111114.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111111110.length + bArr511111111111113.length + bArr51111111111119.length + objArr19.length + bArr511111111111111.length + bArr511111111111112.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length41111111111111115 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length41111111111111115, bArr30.length);
                        int length41111111111111116 = length41111111111111115 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111116, bArr31.length);
                        int length41111111111111117 = length41111111111111116 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length41111111111111117, bArr6.length);
                        int length41111111111111118 = length41111111111111117 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length41111111111111118, bArr26.length);
                        int length41111111111111119 = length41111111111111118 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111119, 0);
                        int i11116 = length41111111111111119 + 0;
                        java.lang.System.arraycopy(bArr511111111111115, 0, bArr28, i11116, bArr511111111111115.length);
                        int length411111111111111110 = i11116 + bArr511111111111115.length;
                        java.lang.System.arraycopy(bArr511111111111114, 0, bArr28, length411111111111111110, bArr511111111111114.length);
                        int length411111111111111111 = length411111111111111110 + bArr511111111111114.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length411111111111111111, bArr33.length);
                        int length411111111111111112 = length411111111111111111 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length411111111111111112, bArr34.length);
                        int length11111111111111111110 = length411111111111111112 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111111111111110, bArr35.length);
                        int length11111111111111111111 = length11111111111111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111111111111, bArr36.length);
                        int length11111111111111111112 = length11111111111111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111111111111112, bArr37.length);
                        int length11111111111111111113 = length11111111111111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111111111111113, bArr7.length);
                        int length11111111111111111114 = length11111111111111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr511111111111110, 0, bArr28, length11111111111111111114, bArr511111111111110.length);
                        int length11111111111111111115 = length11111111111111111114 + bArr511111111111110.length;
                        java.lang.System.arraycopy(bArr511111111111113, 0, bArr28, length11111111111111111115, bArr511111111111113.length);
                        int length11111111111111111116 = length11111111111111111115 + bArr511111111111113.length;
                        java.lang.System.arraycopy(bArr51111111111119, 0, bArr28, length11111111111111111116, bArr51111111111119.length);
                        int length11111111111111111117 = length11111111111111111116 + bArr51111111111119.length;
                        java.lang.System.arraycopy(objArr19, 0, bArr28, length11111111111111111117, objArr19.length);
                        int length11111111111111111118 = length11111111111111111117 + objArr19.length;
                        java.lang.System.arraycopy(bArr511111111111111, 0, bArr28, length11111111111111111118, bArr511111111111111.length);
                        int length11111111111111111119 = length11111111111111111118 + bArr511111111111111.length;
                        java.lang.System.arraycopy(bArr511111111111112, 0, bArr28, length11111111111111111119, bArr511111111111112.length);
                        int length211114 = length11111111111111111119 + bArr511111111111112.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length211114, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length211114 + bArr25.length, bArr24.length);
                        int length211115 = bArr24.length;
                        i6 = i11115;
                        i7 = i8;
                    }
                    return b(bArr28, i7, i6);
                }
                bArr17 = bArr15;
                bArr18 = bArr47;
                bArr19 = oicq.wlogin_sdk.request.l.J;
                if (bArr19 != null) {
                    bArr20 = bArr18;
                    if (bArr19.length > 0) {
                        bArr10 = bArr10;
                        bArr38 = bArr38;
                        bArr21 = tlv_t201Var.get_tlv_201(bArr19, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                        i5++;
                    }
                    bArr22 = oicq.wlogin_sdk.request.t.R;
                    if (bArr22 != null) {
                        bArr23 = bArr4;
                    } else {
                        bArr23 = bArr4;
                    }
                    bArr24 = bArr23;
                    bArr25 = bArr21;
                    bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                    if (bArr3 != null) {
                        byte[] bArr511111111111116 = bArr12;
                        byte[] bArr511111111111117 = bArr38;
                        byte[] bArr511111111111118 = bArr17;
                        byte[] bArr511111111111119 = bArr20;
                        byte[] bArr5111111111111110 = bArr10;
                        java.lang.Object[] objArr110 = bArr13;
                        int i11117 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length411111111111111113 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr5111111111111111 = bArr9;
                        byte[] bArr5111111111111112 = bArr27;
                        bArr28 = new byte[length411111111111111113 + bArr5111111111111111.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111111117.length + bArr5111111111111110.length + bArr511111111111116.length + objArr110.length + bArr511111111111118.length + bArr511111111111119.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length411111111111111114 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length411111111111111114, bArr30.length);
                        int length411111111111111115 = length411111111111111114 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length411111111111111115, bArr31.length);
                        int length411111111111111116 = length411111111111111115 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111116, bArr6.length);
                        int length411111111111111117 = length411111111111111116 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length411111111111111117, bArr26.length);
                        int length411111111111111118 = length411111111111111117 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length411111111111111118, 0);
                        int i11118 = length411111111111111118 + 0;
                        java.lang.System.arraycopy(bArr5111111111111112, 0, bArr28, i11118, bArr5111111111111112.length);
                        int length411111111111111119 = i11118 + bArr5111111111111112.length;
                        java.lang.System.arraycopy(bArr5111111111111111, 0, bArr28, length411111111111111119, bArr5111111111111111.length);
                        int length4111111111111111110 = length411111111111111119 + bArr5111111111111111.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111110, bArr33.length);
                        int length4111111111111111111 = length4111111111111111110 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length4111111111111111111, bArr34.length);
                        int length111111111111111111110 = length4111111111111111111 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111111111111110, bArr35.length);
                        int length111111111111111111111 = length111111111111111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111111111111, bArr36.length);
                        int length111111111111111111112 = length111111111111111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111111111111112, bArr37.length);
                        int length111111111111111111113 = length111111111111111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111111111111113, bArr7.length);
                        int length111111111111111111114 = length111111111111111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr511111111111117, 0, bArr28, length111111111111111111114, bArr511111111111117.length);
                        int length111111111111111111115 = length111111111111111111114 + bArr511111111111117.length;
                        java.lang.System.arraycopy(bArr5111111111111110, 0, bArr28, length111111111111111111115, bArr5111111111111110.length);
                        int length111111111111111111116 = length111111111111111111115 + bArr5111111111111110.length;
                        java.lang.System.arraycopy(bArr511111111111116, 0, bArr28, length111111111111111111116, bArr511111111111116.length);
                        int length111111111111111111117 = length111111111111111111116 + bArr511111111111116.length;
                        java.lang.System.arraycopy(objArr110, 0, bArr28, length111111111111111111117, objArr110.length);
                        int length111111111111111111118 = length111111111111111111117 + objArr110.length;
                        java.lang.System.arraycopy(bArr511111111111118, 0, bArr28, length111111111111111111118, bArr511111111111118.length);
                        int length111111111111111111119 = length111111111111111111118 + bArr511111111111118.length;
                        java.lang.System.arraycopy(bArr511111111111119, 0, bArr28, length111111111111111111119, bArr511111111111119.length);
                        int length211116 = length111111111111111111119 + bArr511111111111119.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length211116, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length211116 + bArr25.length, bArr24.length);
                        int length211117 = bArr24.length;
                        i6 = i11117;
                        i7 = i8;
                    } else {
                        byte[] bArr5111111111111113 = bArr12;
                        byte[] bArr5111111111111114 = bArr38;
                        byte[] bArr5111111111111115 = bArr17;
                        byte[] bArr5111111111111116 = bArr20;
                        byte[] bArr5111111111111117 = bArr10;
                        java.lang.Object[] objArr111 = bArr13;
                        int i11119 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length4111111111111111112 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr5111111111111118 = bArr9;
                        byte[] bArr5111111111111119 = bArr27;
                        bArr28 = new byte[length4111111111111111112 + bArr5111111111111118.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111111111114.length + bArr5111111111111117.length + bArr5111111111111113.length + objArr111.length + bArr5111111111111115.length + bArr5111111111111116.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length4111111111111111113 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111111113, bArr30.length);
                        int length4111111111111111114 = length4111111111111111113 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length4111111111111111114, bArr31.length);
                        int length4111111111111111115 = length4111111111111111114 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length4111111111111111115, bArr6.length);
                        int length4111111111111111116 = length4111111111111111115 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111111116, bArr26.length);
                        int length4111111111111111117 = length4111111111111111116 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length4111111111111111117, 0);
                        int i111110 = length4111111111111111117 + 0;
                        java.lang.System.arraycopy(bArr5111111111111119, 0, bArr28, i111110, bArr5111111111111119.length);
                        int length4111111111111111118 = i111110 + bArr5111111111111119.length;
                        java.lang.System.arraycopy(bArr5111111111111118, 0, bArr28, length4111111111111111118, bArr5111111111111118.length);
                        int length4111111111111111119 = length4111111111111111118 + bArr5111111111111118.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111119, bArr33.length);
                        int length41111111111111111110 = length4111111111111111119 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111110, bArr34.length);
                        int length1111111111111111111110 = length41111111111111111110 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111111111111110, bArr35.length);
                        int length1111111111111111111111 = length1111111111111111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111111111111, bArr36.length);
                        int length1111111111111111111112 = length1111111111111111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111111111111112, bArr37.length);
                        int length1111111111111111111113 = length1111111111111111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111111111111113, bArr7.length);
                        int length1111111111111111111114 = length1111111111111111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr5111111111111114, 0, bArr28, length1111111111111111111114, bArr5111111111111114.length);
                        int length1111111111111111111115 = length1111111111111111111114 + bArr5111111111111114.length;
                        java.lang.System.arraycopy(bArr5111111111111117, 0, bArr28, length1111111111111111111115, bArr5111111111111117.length);
                        int length1111111111111111111116 = length1111111111111111111115 + bArr5111111111111117.length;
                        java.lang.System.arraycopy(bArr5111111111111113, 0, bArr28, length1111111111111111111116, bArr5111111111111113.length);
                        int length1111111111111111111117 = length1111111111111111111116 + bArr5111111111111113.length;
                        java.lang.System.arraycopy(objArr111, 0, bArr28, length1111111111111111111117, objArr111.length);
                        int length1111111111111111111118 = length1111111111111111111117 + objArr111.length;
                        java.lang.System.arraycopy(bArr5111111111111115, 0, bArr28, length1111111111111111111118, bArr5111111111111115.length);
                        int length1111111111111111111119 = length1111111111111111111118 + bArr5111111111111115.length;
                        java.lang.System.arraycopy(bArr5111111111111116, 0, bArr28, length1111111111111111111119, bArr5111111111111116.length);
                        int length211118 = length1111111111111111111119 + bArr5111111111111116.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length211118, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length211118 + bArr25.length, bArr24.length);
                        int length211119 = bArr24.length;
                        i6 = i11119;
                        i7 = i8;
                    }
                    return b(bArr28, i7, i6);
                }
                bArr20 = bArr18;
                bArr21 = bArr48;
                bArr22 = oicq.wlogin_sdk.request.t.R;
                if (bArr22 != null) {
                    bArr23 = bArr4;
                } else {
                    bArr23 = bArr4;
                }
                bArr24 = bArr23;
                bArr25 = bArr21;
                bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                if (bArr3 != null) {
                    byte[] bArr51111111111111110 = bArr12;
                    byte[] bArr51111111111111111 = bArr38;
                    byte[] bArr51111111111111112 = bArr17;
                    byte[] bArr51111111111111113 = bArr20;
                    byte[] bArr51111111111111114 = bArr10;
                    java.lang.Object[] objArr112 = bArr13;
                    int i111111 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length41111111111111111111 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr51111111111111115 = bArr9;
                    byte[] bArr51111111111111116 = bArr27;
                    bArr28 = new byte[length41111111111111111111 + bArr51111111111111115.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111111111111111.length + bArr51111111111111114.length + bArr51111111111111110.length + objArr112.length + bArr51111111111111112.length + bArr51111111111111113.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length41111111111111111112 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length41111111111111111112, bArr30.length);
                    int length41111111111111111113 = length41111111111111111112 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111111113, bArr31.length);
                    int length41111111111111111114 = length41111111111111111113 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length41111111111111111114, bArr6.length);
                    int length41111111111111111115 = length41111111111111111114 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length41111111111111111115, bArr26.length);
                    int length41111111111111111116 = length41111111111111111115 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111111116, 0);
                    int i111112 = length41111111111111111116 + 0;
                    java.lang.System.arraycopy(bArr51111111111111116, 0, bArr28, i111112, bArr51111111111111116.length);
                    int length41111111111111111117 = i111112 + bArr51111111111111116.length;
                    java.lang.System.arraycopy(bArr51111111111111115, 0, bArr28, length41111111111111111117, bArr51111111111111115.length);
                    int length41111111111111111118 = length41111111111111111117 + bArr51111111111111115.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length41111111111111111118, bArr33.length);
                    int length41111111111111111119 = length41111111111111111118 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111119, bArr34.length);
                    int length11111111111111111111110 = length41111111111111111119 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111111111111111110, bArr35.length);
                    int length11111111111111111111111 = length11111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111111111111111, bArr36.length);
                    int length11111111111111111111112 = length11111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111111111111111112, bArr37.length);
                    int length11111111111111111111113 = length11111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111111111111111113, bArr7.length);
                    int length11111111111111111111114 = length11111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr51111111111111111, 0, bArr28, length11111111111111111111114, bArr51111111111111111.length);
                    int length11111111111111111111115 = length11111111111111111111114 + bArr51111111111111111.length;
                    java.lang.System.arraycopy(bArr51111111111111114, 0, bArr28, length11111111111111111111115, bArr51111111111111114.length);
                    int length11111111111111111111116 = length11111111111111111111115 + bArr51111111111111114.length;
                    java.lang.System.arraycopy(bArr51111111111111110, 0, bArr28, length11111111111111111111116, bArr51111111111111110.length);
                    int length11111111111111111111117 = length11111111111111111111116 + bArr51111111111111110.length;
                    java.lang.System.arraycopy(objArr112, 0, bArr28, length11111111111111111111117, objArr112.length);
                    int length11111111111111111111118 = length11111111111111111111117 + objArr112.length;
                    java.lang.System.arraycopy(bArr51111111111111112, 0, bArr28, length11111111111111111111118, bArr51111111111111112.length);
                    int length11111111111111111111119 = length11111111111111111111118 + bArr51111111111111112.length;
                    java.lang.System.arraycopy(bArr51111111111111113, 0, bArr28, length11111111111111111111119, bArr51111111111111113.length);
                    int length2111110 = length11111111111111111111119 + bArr51111111111111113.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length2111110, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length2111110 + bArr25.length, bArr24.length);
                    int length2111111 = bArr24.length;
                    i6 = i111111;
                    i7 = i8;
                } else {
                    byte[] bArr51111111111111117 = bArr12;
                    byte[] bArr51111111111111118 = bArr38;
                    byte[] bArr51111111111111119 = bArr17;
                    byte[] bArr511111111111111110 = bArr20;
                    byte[] bArr511111111111111111 = bArr10;
                    java.lang.Object[] objArr113 = bArr13;
                    int i111113 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length411111111111111111110 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr511111111111111112 = bArr9;
                    byte[] bArr511111111111111113 = bArr27;
                    bArr28 = new byte[length411111111111111111110 + bArr511111111111111112.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111111111111118.length + bArr511111111111111111.length + bArr51111111111111117.length + objArr113.length + bArr51111111111111119.length + bArr511111111111111110.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length411111111111111111111 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length411111111111111111111, bArr30.length);
                    int length411111111111111111112 = length411111111111111111111 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length411111111111111111112, bArr31.length);
                    int length411111111111111111113 = length411111111111111111112 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111111113, bArr6.length);
                    int length411111111111111111114 = length411111111111111111113 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length411111111111111111114, bArr26.length);
                    int length411111111111111111115 = length411111111111111111114 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length411111111111111111115, 0);
                    int i111114 = length411111111111111111115 + 0;
                    java.lang.System.arraycopy(bArr511111111111111113, 0, bArr28, i111114, bArr511111111111111113.length);
                    int length411111111111111111116 = i111114 + bArr511111111111111113.length;
                    java.lang.System.arraycopy(bArr511111111111111112, 0, bArr28, length411111111111111111116, bArr511111111111111112.length);
                    int length411111111111111111117 = length411111111111111111116 + bArr511111111111111112.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length411111111111111111117, bArr33.length);
                    int length411111111111111111118 = length411111111111111111117 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length411111111111111111118, bArr34.length);
                    int length111111111111111111111110 = length411111111111111111118 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111111111111111110, bArr35.length);
                    int length111111111111111111111111 = length111111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111111111111111, bArr36.length);
                    int length111111111111111111111112 = length111111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111111111111111112, bArr37.length);
                    int length111111111111111111111113 = length111111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111111111111111113, bArr7.length);
                    int length111111111111111111111114 = length111111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr51111111111111118, 0, bArr28, length111111111111111111111114, bArr51111111111111118.length);
                    int length111111111111111111111115 = length111111111111111111111114 + bArr51111111111111118.length;
                    java.lang.System.arraycopy(bArr511111111111111111, 0, bArr28, length111111111111111111111115, bArr511111111111111111.length);
                    int length111111111111111111111116 = length111111111111111111111115 + bArr511111111111111111.length;
                    java.lang.System.arraycopy(bArr51111111111111117, 0, bArr28, length111111111111111111111116, bArr51111111111111117.length);
                    int length111111111111111111111117 = length111111111111111111111116 + bArr51111111111111117.length;
                    java.lang.System.arraycopy(objArr113, 0, bArr28, length111111111111111111111117, objArr113.length);
                    int length111111111111111111111118 = length111111111111111111111117 + objArr113.length;
                    java.lang.System.arraycopy(bArr51111111111111119, 0, bArr28, length111111111111111111111118, bArr51111111111111119.length);
                    int length111111111111111111111119 = length111111111111111111111118 + bArr51111111111111119.length;
                    java.lang.System.arraycopy(bArr511111111111111110, 0, bArr28, length111111111111111111111119, bArr511111111111111110.length);
                    int length2111112 = length111111111111111111111119 + bArr511111111111111110.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length2111112, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length2111112 + bArr25.length, bArr24.length);
                    int length2111113 = bArr24.length;
                    i6 = i111113;
                    i7 = i8;
                }
                return b(bArr28, i7, i6);
            }
            bArr12 = bArr39;
            bArr13 = bArr45;
            bArr14 = oicq.wlogin_sdk.request.t.O;
            if (bArr14 != null) {
                bArr15 = bArr46;
            } else {
                bArr15 = bArr46;
            }
            bArr16 = oicq.wlogin_sdk.request.t.L;
            if (bArr16 != null) {
                bArr17 = bArr15;
                if (bArr16.length > 0) {
                    bArr18 = tlv_t194Var.get_tlv_194(bArr16);
                    i5++;
                }
                bArr19 = oicq.wlogin_sdk.request.l.J;
                if (bArr19 != null) {
                    bArr20 = bArr18;
                    if (bArr19.length > 0) {
                        bArr10 = bArr10;
                        bArr38 = bArr38;
                        bArr21 = tlv_t201Var.get_tlv_201(bArr19, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                        i5++;
                    }
                    bArr22 = oicq.wlogin_sdk.request.t.R;
                    if (bArr22 != null) {
                        bArr23 = bArr4;
                    } else {
                        bArr23 = bArr4;
                    }
                    bArr24 = bArr23;
                    bArr25 = bArr21;
                    bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                    if (bArr3 != null) {
                        byte[] bArr511111111111111114 = bArr12;
                        byte[] bArr511111111111111115 = bArr38;
                        byte[] bArr511111111111111116 = bArr17;
                        byte[] bArr511111111111111117 = bArr20;
                        byte[] bArr511111111111111118 = bArr10;
                        java.lang.Object[] objArr114 = bArr13;
                        int i111115 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length411111111111111111119 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr511111111111111119 = bArr9;
                        byte[] bArr5111111111111111110 = bArr27;
                        bArr28 = new byte[length411111111111111111119 + bArr511111111111111119.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111111111115.length + bArr511111111111111118.length + bArr511111111111111114.length + objArr114.length + bArr511111111111111116.length + bArr511111111111111117.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length4111111111111111111110 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111111111110, bArr30.length);
                        int length4111111111111111111111 = length4111111111111111111110 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length4111111111111111111111, bArr31.length);
                        int length4111111111111111111112 = length4111111111111111111111 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length4111111111111111111112, bArr6.length);
                        int length4111111111111111111113 = length4111111111111111111112 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111111111113, bArr26.length);
                        int length4111111111111111111114 = length4111111111111111111113 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length4111111111111111111114, 0);
                        int i111116 = length4111111111111111111114 + 0;
                        java.lang.System.arraycopy(bArr5111111111111111110, 0, bArr28, i111116, bArr5111111111111111110.length);
                        int length4111111111111111111115 = i111116 + bArr5111111111111111110.length;
                        java.lang.System.arraycopy(bArr511111111111111119, 0, bArr28, length4111111111111111111115, bArr511111111111111119.length);
                        int length4111111111111111111116 = length4111111111111111111115 + bArr511111111111111119.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111111116, bArr33.length);
                        int length4111111111111111111117 = length4111111111111111111116 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length4111111111111111111117, bArr34.length);
                        int length1111111111111111111111110 = length4111111111111111111117 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111111111111111110, bArr35.length);
                        int length1111111111111111111111111 = length1111111111111111111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111111111111111, bArr36.length);
                        int length1111111111111111111111112 = length1111111111111111111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111111111111111112, bArr37.length);
                        int length1111111111111111111111113 = length1111111111111111111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111111111111111113, bArr7.length);
                        int length1111111111111111111111114 = length1111111111111111111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr511111111111111115, 0, bArr28, length1111111111111111111111114, bArr511111111111111115.length);
                        int length1111111111111111111111115 = length1111111111111111111111114 + bArr511111111111111115.length;
                        java.lang.System.arraycopy(bArr511111111111111118, 0, bArr28, length1111111111111111111111115, bArr511111111111111118.length);
                        int length1111111111111111111111116 = length1111111111111111111111115 + bArr511111111111111118.length;
                        java.lang.System.arraycopy(bArr511111111111111114, 0, bArr28, length1111111111111111111111116, bArr511111111111111114.length);
                        int length1111111111111111111111117 = length1111111111111111111111116 + bArr511111111111111114.length;
                        java.lang.System.arraycopy(objArr114, 0, bArr28, length1111111111111111111111117, objArr114.length);
                        int length1111111111111111111111118 = length1111111111111111111111117 + objArr114.length;
                        java.lang.System.arraycopy(bArr511111111111111116, 0, bArr28, length1111111111111111111111118, bArr511111111111111116.length);
                        int length1111111111111111111111119 = length1111111111111111111111118 + bArr511111111111111116.length;
                        java.lang.System.arraycopy(bArr511111111111111117, 0, bArr28, length1111111111111111111111119, bArr511111111111111117.length);
                        int length2111114 = length1111111111111111111111119 + bArr511111111111111117.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length2111114, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length2111114 + bArr25.length, bArr24.length);
                        int length2111115 = bArr24.length;
                        i6 = i111115;
                        i7 = i8;
                    } else {
                        byte[] bArr5111111111111111111 = bArr12;
                        byte[] bArr5111111111111111112 = bArr38;
                        byte[] bArr5111111111111111113 = bArr17;
                        byte[] bArr5111111111111111114 = bArr20;
                        byte[] bArr5111111111111111115 = bArr10;
                        java.lang.Object[] objArr115 = bArr13;
                        int i111117 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length4111111111111111111118 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr5111111111111111116 = bArr9;
                        byte[] bArr5111111111111111117 = bArr27;
                        bArr28 = new byte[length4111111111111111111118 + bArr5111111111111111116.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111111111111112.length + bArr5111111111111111115.length + bArr5111111111111111111.length + objArr115.length + bArr5111111111111111113.length + bArr5111111111111111114.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length4111111111111111111119 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111111111119, bArr30.length);
                        int length41111111111111111111110 = length4111111111111111111119 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111111111110, bArr31.length);
                        int length41111111111111111111111 = length41111111111111111111110 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length41111111111111111111111, bArr6.length);
                        int length41111111111111111111112 = length41111111111111111111111 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length41111111111111111111112, bArr26.length);
                        int length41111111111111111111113 = length41111111111111111111112 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111111111113, 0);
                        int i111118 = length41111111111111111111113 + 0;
                        java.lang.System.arraycopy(bArr5111111111111111117, 0, bArr28, i111118, bArr5111111111111111117.length);
                        int length41111111111111111111114 = i111118 + bArr5111111111111111117.length;
                        java.lang.System.arraycopy(bArr5111111111111111116, 0, bArr28, length41111111111111111111114, bArr5111111111111111116.length);
                        int length41111111111111111111115 = length41111111111111111111114 + bArr5111111111111111116.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length41111111111111111111115, bArr33.length);
                        int length41111111111111111111116 = length41111111111111111111115 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111111116, bArr34.length);
                        int length11111111111111111111111110 = length41111111111111111111116 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111111111111111111110, bArr35.length);
                        int length11111111111111111111111111 = length11111111111111111111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111111111111111111, bArr36.length);
                        int length11111111111111111111111112 = length11111111111111111111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111111111111111111112, bArr37.length);
                        int length11111111111111111111111113 = length11111111111111111111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111111111111111111113, bArr7.length);
                        int length11111111111111111111111114 = length11111111111111111111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr5111111111111111112, 0, bArr28, length11111111111111111111111114, bArr5111111111111111112.length);
                        int length11111111111111111111111115 = length11111111111111111111111114 + bArr5111111111111111112.length;
                        java.lang.System.arraycopy(bArr5111111111111111115, 0, bArr28, length11111111111111111111111115, bArr5111111111111111115.length);
                        int length11111111111111111111111116 = length11111111111111111111111115 + bArr5111111111111111115.length;
                        java.lang.System.arraycopy(bArr5111111111111111111, 0, bArr28, length11111111111111111111111116, bArr5111111111111111111.length);
                        int length11111111111111111111111117 = length11111111111111111111111116 + bArr5111111111111111111.length;
                        java.lang.System.arraycopy(objArr115, 0, bArr28, length11111111111111111111111117, objArr115.length);
                        int length11111111111111111111111118 = length11111111111111111111111117 + objArr115.length;
                        java.lang.System.arraycopy(bArr5111111111111111113, 0, bArr28, length11111111111111111111111118, bArr5111111111111111113.length);
                        int length11111111111111111111111119 = length11111111111111111111111118 + bArr5111111111111111113.length;
                        java.lang.System.arraycopy(bArr5111111111111111114, 0, bArr28, length11111111111111111111111119, bArr5111111111111111114.length);
                        int length2111116 = length11111111111111111111111119 + bArr5111111111111111114.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length2111116, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length2111116 + bArr25.length, bArr24.length);
                        int length2111117 = bArr24.length;
                        i6 = i111117;
                        i7 = i8;
                    }
                    return b(bArr28, i7, i6);
                }
                bArr20 = bArr18;
                bArr21 = bArr48;
                bArr22 = oicq.wlogin_sdk.request.t.R;
                if (bArr22 != null) {
                    bArr23 = bArr4;
                } else {
                    bArr23 = bArr4;
                }
                bArr24 = bArr23;
                bArr25 = bArr21;
                bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                if (bArr3 != null) {
                    byte[] bArr5111111111111111118 = bArr12;
                    byte[] bArr5111111111111111119 = bArr38;
                    byte[] bArr51111111111111111110 = bArr17;
                    byte[] bArr51111111111111111111 = bArr20;
                    byte[] bArr51111111111111111112 = bArr10;
                    java.lang.Object[] objArr116 = bArr13;
                    int i111119 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length41111111111111111111117 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr51111111111111111113 = bArr9;
                    byte[] bArr51111111111111111114 = bArr27;
                    bArr28 = new byte[length41111111111111111111117 + bArr51111111111111111113.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111111111111119.length + bArr51111111111111111112.length + bArr5111111111111111118.length + objArr116.length + bArr51111111111111111110.length + bArr51111111111111111111.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length41111111111111111111118 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length41111111111111111111118, bArr30.length);
                    int length41111111111111111111119 = length41111111111111111111118 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111111111119, bArr31.length);
                    int length411111111111111111111110 = length41111111111111111111119 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111111111110, bArr6.length);
                    int length411111111111111111111111 = length411111111111111111111110 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length411111111111111111111111, bArr26.length);
                    int length411111111111111111111112 = length411111111111111111111111 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length411111111111111111111112, 0);
                    int i1111110 = length411111111111111111111112 + 0;
                    java.lang.System.arraycopy(bArr51111111111111111114, 0, bArr28, i1111110, bArr51111111111111111114.length);
                    int length411111111111111111111113 = i1111110 + bArr51111111111111111114.length;
                    java.lang.System.arraycopy(bArr51111111111111111113, 0, bArr28, length411111111111111111111113, bArr51111111111111111113.length);
                    int length411111111111111111111114 = length411111111111111111111113 + bArr51111111111111111113.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length411111111111111111111114, bArr33.length);
                    int length411111111111111111111115 = length411111111111111111111114 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length411111111111111111111115, bArr34.length);
                    int length111111111111111111111111110 = length411111111111111111111115 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111111111111111111110, bArr35.length);
                    int length111111111111111111111111111 = length111111111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111111111111111111, bArr36.length);
                    int length111111111111111111111111112 = length111111111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111111111111111111112, bArr37.length);
                    int length111111111111111111111111113 = length111111111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111111111111111111113, bArr7.length);
                    int length111111111111111111111111114 = length111111111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr5111111111111111119, 0, bArr28, length111111111111111111111111114, bArr5111111111111111119.length);
                    int length111111111111111111111111115 = length111111111111111111111111114 + bArr5111111111111111119.length;
                    java.lang.System.arraycopy(bArr51111111111111111112, 0, bArr28, length111111111111111111111111115, bArr51111111111111111112.length);
                    int length111111111111111111111111116 = length111111111111111111111111115 + bArr51111111111111111112.length;
                    java.lang.System.arraycopy(bArr5111111111111111118, 0, bArr28, length111111111111111111111111116, bArr5111111111111111118.length);
                    int length111111111111111111111111117 = length111111111111111111111111116 + bArr5111111111111111118.length;
                    java.lang.System.arraycopy(objArr116, 0, bArr28, length111111111111111111111111117, objArr116.length);
                    int length111111111111111111111111118 = length111111111111111111111111117 + objArr116.length;
                    java.lang.System.arraycopy(bArr51111111111111111110, 0, bArr28, length111111111111111111111111118, bArr51111111111111111110.length);
                    int length111111111111111111111111119 = length111111111111111111111111118 + bArr51111111111111111110.length;
                    java.lang.System.arraycopy(bArr51111111111111111111, 0, bArr28, length111111111111111111111111119, bArr51111111111111111111.length);
                    int length2111118 = length111111111111111111111111119 + bArr51111111111111111111.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length2111118, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length2111118 + bArr25.length, bArr24.length);
                    int length2111119 = bArr24.length;
                    i6 = i111119;
                    i7 = i8;
                } else {
                    byte[] bArr51111111111111111115 = bArr12;
                    byte[] bArr51111111111111111116 = bArr38;
                    byte[] bArr51111111111111111117 = bArr17;
                    byte[] bArr51111111111111111118 = bArr20;
                    byte[] bArr51111111111111111119 = bArr10;
                    java.lang.Object[] objArr117 = bArr13;
                    int i1111111 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length411111111111111111111116 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr511111111111111111110 = bArr9;
                    byte[] bArr511111111111111111111 = bArr27;
                    bArr28 = new byte[length411111111111111111111116 + bArr511111111111111111110.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111111111111111116.length + bArr51111111111111111119.length + bArr51111111111111111115.length + objArr117.length + bArr51111111111111111117.length + bArr51111111111111111118.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length411111111111111111111117 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length411111111111111111111117, bArr30.length);
                    int length411111111111111111111118 = length411111111111111111111117 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length411111111111111111111118, bArr31.length);
                    int length411111111111111111111119 = length411111111111111111111118 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111111111119, bArr6.length);
                    int length4111111111111111111111110 = length411111111111111111111119 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111111111111110, bArr26.length);
                    int length4111111111111111111111111 = length4111111111111111111111110 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length4111111111111111111111111, 0);
                    int i1111112 = length4111111111111111111111111 + 0;
                    java.lang.System.arraycopy(bArr511111111111111111111, 0, bArr28, i1111112, bArr511111111111111111111.length);
                    int length4111111111111111111111112 = i1111112 + bArr511111111111111111111.length;
                    java.lang.System.arraycopy(bArr511111111111111111110, 0, bArr28, length4111111111111111111111112, bArr511111111111111111110.length);
                    int length4111111111111111111111113 = length4111111111111111111111112 + bArr511111111111111111110.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111111111113, bArr33.length);
                    int length4111111111111111111111114 = length4111111111111111111111113 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length4111111111111111111111114, bArr34.length);
                    int length1111111111111111111111111110 = length4111111111111111111111114 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111111111111111111110, bArr35.length);
                    int length1111111111111111111111111111 = length1111111111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111111111111111111, bArr36.length);
                    int length1111111111111111111111111112 = length1111111111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111111111111111111112, bArr37.length);
                    int length1111111111111111111111111113 = length1111111111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111111111111111111113, bArr7.length);
                    int length1111111111111111111111111114 = length1111111111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr51111111111111111116, 0, bArr28, length1111111111111111111111111114, bArr51111111111111111116.length);
                    int length1111111111111111111111111115 = length1111111111111111111111111114 + bArr51111111111111111116.length;
                    java.lang.System.arraycopy(bArr51111111111111111119, 0, bArr28, length1111111111111111111111111115, bArr51111111111111111119.length);
                    int length1111111111111111111111111116 = length1111111111111111111111111115 + bArr51111111111111111119.length;
                    java.lang.System.arraycopy(bArr51111111111111111115, 0, bArr28, length1111111111111111111111111116, bArr51111111111111111115.length);
                    int length1111111111111111111111111117 = length1111111111111111111111111116 + bArr51111111111111111115.length;
                    java.lang.System.arraycopy(objArr117, 0, bArr28, length1111111111111111111111111117, objArr117.length);
                    int length1111111111111111111111111118 = length1111111111111111111111111117 + objArr117.length;
                    java.lang.System.arraycopy(bArr51111111111111111117, 0, bArr28, length1111111111111111111111111118, bArr51111111111111111117.length);
                    int length1111111111111111111111111119 = length1111111111111111111111111118 + bArr51111111111111111117.length;
                    java.lang.System.arraycopy(bArr51111111111111111118, 0, bArr28, length1111111111111111111111111119, bArr51111111111111111118.length);
                    int length21111110 = length1111111111111111111111111119 + bArr51111111111111111118.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length21111110, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length21111110 + bArr25.length, bArr24.length);
                    int length21111111 = bArr24.length;
                    i6 = i1111111;
                    i7 = i8;
                }
                return b(bArr28, i7, i6);
            }
            bArr17 = bArr15;
            bArr18 = bArr47;
            bArr19 = oicq.wlogin_sdk.request.l.J;
            if (bArr19 != null) {
                bArr20 = bArr18;
                if (bArr19.length > 0) {
                    bArr10 = bArr10;
                    bArr38 = bArr38;
                    bArr21 = tlv_t201Var.get_tlv_201(bArr19, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                    i5++;
                }
                bArr22 = oicq.wlogin_sdk.request.t.R;
                if (bArr22 != null) {
                    bArr23 = bArr4;
                } else {
                    bArr23 = bArr4;
                }
                bArr24 = bArr23;
                bArr25 = bArr21;
                bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                if (bArr3 != null) {
                    byte[] bArr511111111111111111112 = bArr12;
                    byte[] bArr511111111111111111113 = bArr38;
                    byte[] bArr511111111111111111114 = bArr17;
                    byte[] bArr511111111111111111115 = bArr20;
                    byte[] bArr511111111111111111116 = bArr10;
                    java.lang.Object[] objArr118 = bArr13;
                    int i1111113 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length4111111111111111111111115 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr511111111111111111117 = bArr9;
                    byte[] bArr511111111111111111118 = bArr27;
                    bArr28 = new byte[length4111111111111111111111115 + bArr511111111111111111117.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111111111111113.length + bArr511111111111111111116.length + bArr511111111111111111112.length + objArr118.length + bArr511111111111111111114.length + bArr511111111111111111115.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length4111111111111111111111116 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111111111111116, bArr30.length);
                    int length4111111111111111111111117 = length4111111111111111111111116 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length4111111111111111111111117, bArr31.length);
                    int length4111111111111111111111118 = length4111111111111111111111117 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length4111111111111111111111118, bArr6.length);
                    int length4111111111111111111111119 = length4111111111111111111111118 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111111111111119, bArr26.length);
                    int length41111111111111111111111110 = length4111111111111111111111119 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111111111111110, 0);
                    int i1111114 = length41111111111111111111111110 + 0;
                    java.lang.System.arraycopy(bArr511111111111111111118, 0, bArr28, i1111114, bArr511111111111111111118.length);
                    int length41111111111111111111111111 = i1111114 + bArr511111111111111111118.length;
                    java.lang.System.arraycopy(bArr511111111111111111117, 0, bArr28, length41111111111111111111111111, bArr511111111111111111117.length);
                    int length41111111111111111111111112 = length41111111111111111111111111 + bArr511111111111111111117.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length41111111111111111111111112, bArr33.length);
                    int length41111111111111111111111113 = length41111111111111111111111112 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111111111113, bArr34.length);
                    int length11111111111111111111111111110 = length41111111111111111111111113 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111111111111111111111110, bArr35.length);
                    int length11111111111111111111111111111 = length11111111111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111111111111111111111, bArr36.length);
                    int length11111111111111111111111111112 = length11111111111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111111111111111111111112, bArr37.length);
                    int length11111111111111111111111111113 = length11111111111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111111111111111111111113, bArr7.length);
                    int length11111111111111111111111111114 = length11111111111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr511111111111111111113, 0, bArr28, length11111111111111111111111111114, bArr511111111111111111113.length);
                    int length11111111111111111111111111115 = length11111111111111111111111111114 + bArr511111111111111111113.length;
                    java.lang.System.arraycopy(bArr511111111111111111116, 0, bArr28, length11111111111111111111111111115, bArr511111111111111111116.length);
                    int length11111111111111111111111111116 = length11111111111111111111111111115 + bArr511111111111111111116.length;
                    java.lang.System.arraycopy(bArr511111111111111111112, 0, bArr28, length11111111111111111111111111116, bArr511111111111111111112.length);
                    int length11111111111111111111111111117 = length11111111111111111111111111116 + bArr511111111111111111112.length;
                    java.lang.System.arraycopy(objArr118, 0, bArr28, length11111111111111111111111111117, objArr118.length);
                    int length11111111111111111111111111118 = length11111111111111111111111111117 + objArr118.length;
                    java.lang.System.arraycopy(bArr511111111111111111114, 0, bArr28, length11111111111111111111111111118, bArr511111111111111111114.length);
                    int length11111111111111111111111111119 = length11111111111111111111111111118 + bArr511111111111111111114.length;
                    java.lang.System.arraycopy(bArr511111111111111111115, 0, bArr28, length11111111111111111111111111119, bArr511111111111111111115.length);
                    int length21111112 = length11111111111111111111111111119 + bArr511111111111111111115.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length21111112, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length21111112 + bArr25.length, bArr24.length);
                    int length21111113 = bArr24.length;
                    i6 = i1111113;
                    i7 = i8;
                } else {
                    byte[] bArr511111111111111111119 = bArr12;
                    byte[] bArr5111111111111111111110 = bArr38;
                    byte[] bArr5111111111111111111111 = bArr17;
                    byte[] bArr5111111111111111111112 = bArr20;
                    byte[] bArr5111111111111111111113 = bArr10;
                    java.lang.Object[] objArr119 = bArr13;
                    int i1111115 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length41111111111111111111111114 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr5111111111111111111114 = bArr9;
                    byte[] bArr5111111111111111111115 = bArr27;
                    bArr28 = new byte[length41111111111111111111111114 + bArr5111111111111111111114.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111111111111111110.length + bArr5111111111111111111113.length + bArr511111111111111111119.length + objArr119.length + bArr5111111111111111111111.length + bArr5111111111111111111112.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length41111111111111111111111115 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length41111111111111111111111115, bArr30.length);
                    int length41111111111111111111111116 = length41111111111111111111111115 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111111111111116, bArr31.length);
                    int length41111111111111111111111117 = length41111111111111111111111116 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length41111111111111111111111117, bArr6.length);
                    int length41111111111111111111111118 = length41111111111111111111111117 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length41111111111111111111111118, bArr26.length);
                    int length41111111111111111111111119 = length41111111111111111111111118 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111111111111119, 0);
                    int i1111116 = length41111111111111111111111119 + 0;
                    java.lang.System.arraycopy(bArr5111111111111111111115, 0, bArr28, i1111116, bArr5111111111111111111115.length);
                    int length411111111111111111111111110 = i1111116 + bArr5111111111111111111115.length;
                    java.lang.System.arraycopy(bArr5111111111111111111114, 0, bArr28, length411111111111111111111111110, bArr5111111111111111111114.length);
                    int length411111111111111111111111111 = length411111111111111111111111110 + bArr5111111111111111111114.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length411111111111111111111111111, bArr33.length);
                    int length411111111111111111111111112 = length411111111111111111111111111 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length411111111111111111111111112, bArr34.length);
                    int length111111111111111111111111111110 = length411111111111111111111111112 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111111111111111111111110, bArr35.length);
                    int length111111111111111111111111111111 = length111111111111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111111111111111111111, bArr36.length);
                    int length111111111111111111111111111112 = length111111111111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111111111111111111111112, bArr37.length);
                    int length111111111111111111111111111113 = length111111111111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111111111111111111111113, bArr7.length);
                    int length111111111111111111111111111114 = length111111111111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr5111111111111111111110, 0, bArr28, length111111111111111111111111111114, bArr5111111111111111111110.length);
                    int length111111111111111111111111111115 = length111111111111111111111111111114 + bArr5111111111111111111110.length;
                    java.lang.System.arraycopy(bArr5111111111111111111113, 0, bArr28, length111111111111111111111111111115, bArr5111111111111111111113.length);
                    int length111111111111111111111111111116 = length111111111111111111111111111115 + bArr5111111111111111111113.length;
                    java.lang.System.arraycopy(bArr511111111111111111119, 0, bArr28, length111111111111111111111111111116, bArr511111111111111111119.length);
                    int length111111111111111111111111111117 = length111111111111111111111111111116 + bArr511111111111111111119.length;
                    java.lang.System.arraycopy(objArr119, 0, bArr28, length111111111111111111111111111117, objArr119.length);
                    int length111111111111111111111111111118 = length111111111111111111111111111117 + objArr119.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111, 0, bArr28, length111111111111111111111111111118, bArr5111111111111111111111.length);
                    int length111111111111111111111111111119 = length111111111111111111111111111118 + bArr5111111111111111111111.length;
                    java.lang.System.arraycopy(bArr5111111111111111111112, 0, bArr28, length111111111111111111111111111119, bArr5111111111111111111112.length);
                    int length21111114 = length111111111111111111111111111119 + bArr5111111111111111111112.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length21111114, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length21111114 + bArr25.length, bArr24.length);
                    int length21111115 = bArr24.length;
                    i6 = i1111115;
                    i7 = i8;
                }
                return b(bArr28, i7, i6);
            }
            bArr20 = bArr18;
            bArr21 = bArr48;
            bArr22 = oicq.wlogin_sdk.request.t.R;
            if (bArr22 != null) {
                bArr23 = bArr4;
            } else {
                bArr23 = bArr4;
            }
            bArr24 = bArr23;
            bArr25 = bArr21;
            bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
            if (bArr3 != null) {
                byte[] bArr5111111111111111111116 = bArr12;
                byte[] bArr5111111111111111111117 = bArr38;
                byte[] bArr5111111111111111111118 = bArr17;
                byte[] bArr5111111111111111111119 = bArr20;
                byte[] bArr51111111111111111111110 = bArr10;
                java.lang.Object[] objArr1110 = bArr13;
                int i1111117 = i5 + 2;
                str = this.x.g;
                if (str != null) {
                    bArr27 = bArr5;
                } else {
                    bArr27 = bArr5;
                }
                int length411111111111111111111111113 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                byte[] bArr51111111111111111111111 = bArr9;
                byte[] bArr51111111111111111111112 = bArr27;
                bArr28 = new byte[length411111111111111111111111113 + bArr51111111111111111111111.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111111111111111117.length + bArr51111111111111111111110.length + bArr5111111111111111111116.length + objArr1110.length + bArr5111111111111111111118.length + bArr5111111111111111111119.length + bArr25.length + bArr24.length];
                java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                int length411111111111111111111111114 = bArr29.length + 0;
                java.lang.System.arraycopy(bArr30, 0, bArr28, length411111111111111111111111114, bArr30.length);
                int length411111111111111111111111115 = length411111111111111111111111114 + bArr30.length;
                java.lang.System.arraycopy(bArr31, 0, bArr28, length411111111111111111111111115, bArr31.length);
                int length411111111111111111111111116 = length411111111111111111111111115 + bArr31.length;
                java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111111111111116, bArr6.length);
                int length411111111111111111111111117 = length411111111111111111111111116 + bArr6.length;
                java.lang.System.arraycopy(bArr26, 0, bArr28, length411111111111111111111111117, bArr26.length);
                int length411111111111111111111111118 = length411111111111111111111111117 + bArr26.length;
                java.lang.System.arraycopy(bArr41, 0, bArr28, length411111111111111111111111118, 0);
                int i1111118 = length411111111111111111111111118 + 0;
                java.lang.System.arraycopy(bArr51111111111111111111112, 0, bArr28, i1111118, bArr51111111111111111111112.length);
                int length411111111111111111111111119 = i1111118 + bArr51111111111111111111112.length;
                java.lang.System.arraycopy(bArr51111111111111111111111, 0, bArr28, length411111111111111111111111119, bArr51111111111111111111111.length);
                int length4111111111111111111111111110 = length411111111111111111111111119 + bArr51111111111111111111111.length;
                java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111111111111110, bArr33.length);
                int length4111111111111111111111111111 = length4111111111111111111111111110 + bArr33.length;
                java.lang.System.arraycopy(bArr34, 0, bArr28, length4111111111111111111111111111, bArr34.length);
                int length1111111111111111111111111111110 = length4111111111111111111111111111 + bArr34.length;
                java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111111111111111111111110, bArr35.length);
                int length1111111111111111111111111111111 = length1111111111111111111111111111110 + bArr35.length;
                java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111111111111111111111, bArr36.length);
                int length1111111111111111111111111111112 = length1111111111111111111111111111111 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111111111111111111111112, bArr37.length);
                int length1111111111111111111111111111113 = length1111111111111111111111111111112 + bArr37.length;
                java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111111111111111111111113, bArr7.length);
                int length1111111111111111111111111111114 = length1111111111111111111111111111113 + bArr7.length;
                java.lang.System.arraycopy(bArr5111111111111111111117, 0, bArr28, length1111111111111111111111111111114, bArr5111111111111111111117.length);
                int length1111111111111111111111111111115 = length1111111111111111111111111111114 + bArr5111111111111111111117.length;
                java.lang.System.arraycopy(bArr51111111111111111111110, 0, bArr28, length1111111111111111111111111111115, bArr51111111111111111111110.length);
                int length1111111111111111111111111111116 = length1111111111111111111111111111115 + bArr51111111111111111111110.length;
                java.lang.System.arraycopy(bArr5111111111111111111116, 0, bArr28, length1111111111111111111111111111116, bArr5111111111111111111116.length);
                int length1111111111111111111111111111117 = length1111111111111111111111111111116 + bArr5111111111111111111116.length;
                java.lang.System.arraycopy(objArr1110, 0, bArr28, length1111111111111111111111111111117, objArr1110.length);
                int length1111111111111111111111111111118 = length1111111111111111111111111111117 + objArr1110.length;
                java.lang.System.arraycopy(bArr5111111111111111111118, 0, bArr28, length1111111111111111111111111111118, bArr5111111111111111111118.length);
                int length1111111111111111111111111111119 = length1111111111111111111111111111118 + bArr5111111111111111111118.length;
                java.lang.System.arraycopy(bArr5111111111111111111119, 0, bArr28, length1111111111111111111111111111119, bArr5111111111111111111119.length);
                int length21111116 = length1111111111111111111111111111119 + bArr5111111111111111111119.length;
                java.lang.System.arraycopy(bArr25, 0, bArr28, length21111116, bArr25.length);
                java.lang.System.arraycopy(bArr24, 0, bArr28, length21111116 + bArr25.length, bArr24.length);
                int length21111117 = bArr24.length;
                i6 = i1111117;
                i7 = i8;
            } else {
                byte[] bArr51111111111111111111113 = bArr12;
                byte[] bArr51111111111111111111114 = bArr38;
                byte[] bArr51111111111111111111115 = bArr17;
                byte[] bArr51111111111111111111116 = bArr20;
                byte[] bArr51111111111111111111117 = bArr10;
                java.lang.Object[] objArr1111 = bArr13;
                int i1111119 = i5 + 2;
                str = this.x.g;
                if (str != null) {
                    bArr27 = bArr5;
                } else {
                    bArr27 = bArr5;
                }
                int length4111111111111111111111111112 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                byte[] bArr51111111111111111111118 = bArr9;
                byte[] bArr51111111111111111111119 = bArr27;
                bArr28 = new byte[length4111111111111111111111111112 + bArr51111111111111111111118.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111111111111111111114.length + bArr51111111111111111111117.length + bArr51111111111111111111113.length + objArr1111.length + bArr51111111111111111111115.length + bArr51111111111111111111116.length + bArr25.length + bArr24.length];
                java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                int length4111111111111111111111111113 = bArr29.length + 0;
                java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111111111111111113, bArr30.length);
                int length4111111111111111111111111114 = length4111111111111111111111111113 + bArr30.length;
                java.lang.System.arraycopy(bArr31, 0, bArr28, length4111111111111111111111111114, bArr31.length);
                int length4111111111111111111111111115 = length4111111111111111111111111114 + bArr31.length;
                java.lang.System.arraycopy(bArr6, 0, bArr28, length4111111111111111111111111115, bArr6.length);
                int length4111111111111111111111111116 = length4111111111111111111111111115 + bArr6.length;
                java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111111111111111116, bArr26.length);
                int length4111111111111111111111111117 = length4111111111111111111111111116 + bArr26.length;
                java.lang.System.arraycopy(bArr41, 0, bArr28, length4111111111111111111111111117, 0);
                int i11111110 = length4111111111111111111111111117 + 0;
                java.lang.System.arraycopy(bArr51111111111111111111119, 0, bArr28, i11111110, bArr51111111111111111111119.length);
                int length4111111111111111111111111118 = i11111110 + bArr51111111111111111111119.length;
                java.lang.System.arraycopy(bArr51111111111111111111118, 0, bArr28, length4111111111111111111111111118, bArr51111111111111111111118.length);
                int length4111111111111111111111111119 = length4111111111111111111111111118 + bArr51111111111111111111118.length;
                java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111111111111119, bArr33.length);
                int length41111111111111111111111111110 = length4111111111111111111111111119 + bArr33.length;
                java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111111111111110, bArr34.length);
                int length11111111111111111111111111111110 = length41111111111111111111111111110 + bArr34.length;
                java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111111111111111111111111110, bArr35.length);
                int length11111111111111111111111111111111 = length11111111111111111111111111111110 + bArr35.length;
                java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111111111111111111111111, bArr36.length);
                int length11111111111111111111111111111112 = length11111111111111111111111111111111 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111111111111111111111111112, bArr37.length);
                int length11111111111111111111111111111113 = length11111111111111111111111111111112 + bArr37.length;
                java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111111111111111111111111113, bArr7.length);
                int length11111111111111111111111111111114 = length11111111111111111111111111111113 + bArr7.length;
                java.lang.System.arraycopy(bArr51111111111111111111114, 0, bArr28, length11111111111111111111111111111114, bArr51111111111111111111114.length);
                int length11111111111111111111111111111115 = length11111111111111111111111111111114 + bArr51111111111111111111114.length;
                java.lang.System.arraycopy(bArr51111111111111111111117, 0, bArr28, length11111111111111111111111111111115, bArr51111111111111111111117.length);
                int length11111111111111111111111111111116 = length11111111111111111111111111111115 + bArr51111111111111111111117.length;
                java.lang.System.arraycopy(bArr51111111111111111111113, 0, bArr28, length11111111111111111111111111111116, bArr51111111111111111111113.length);
                int length11111111111111111111111111111117 = length11111111111111111111111111111116 + bArr51111111111111111111113.length;
                java.lang.System.arraycopy(objArr1111, 0, bArr28, length11111111111111111111111111111117, objArr1111.length);
                int length11111111111111111111111111111118 = length11111111111111111111111111111117 + objArr1111.length;
                java.lang.System.arraycopy(bArr51111111111111111111115, 0, bArr28, length11111111111111111111111111111118, bArr51111111111111111111115.length);
                int length11111111111111111111111111111119 = length11111111111111111111111111111118 + bArr51111111111111111111115.length;
                java.lang.System.arraycopy(bArr51111111111111111111116, 0, bArr28, length11111111111111111111111111111119, bArr51111111111111111111116.length);
                int length21111118 = length11111111111111111111111111111119 + bArr51111111111111111111116.length;
                java.lang.System.arraycopy(bArr25, 0, bArr28, length21111118, bArr25.length);
                java.lang.System.arraycopy(bArr24, 0, bArr28, length21111118 + bArr25.length, bArr24.length);
                int length21111119 = bArr24.length;
                i6 = i1111119;
                i7 = i8;
            }
            return b(bArr28, i7, i6);
        }
        bArr4 = bArr49;
        bArr5 = bArr42;
        bArr6 = bArr40;
        i5 = 10;
        if (list != 0) {
            bArr7 = bArr43;
        } else {
            bArr7 = bArr43;
        }
        bArr8 = this.x.r;
        if (bArr8 != null) {
            bArr9 = bArr32;
            if (bArr8.length > 0) {
                bArr10 = tlv_t172Var.get_tlv_172(bArr8);
                i5++;
            }
            bArr11 = oicq.wlogin_sdk.request.t.N;
            if (bArr11 != null) {
                bArr12 = bArr39;
                if (bArr11.length > 0) {
                    bArr13 = tlv_t187Var.get_tlv_187(bArr11);
                    i5++;
                }
                bArr14 = oicq.wlogin_sdk.request.t.O;
                if (bArr14 != null) {
                    bArr15 = bArr46;
                } else {
                    bArr15 = bArr46;
                }
                bArr16 = oicq.wlogin_sdk.request.t.L;
                if (bArr16 != null) {
                    bArr17 = bArr15;
                    if (bArr16.length > 0) {
                        bArr18 = tlv_t194Var.get_tlv_194(bArr16);
                        i5++;
                    }
                    bArr19 = oicq.wlogin_sdk.request.l.J;
                    if (bArr19 != null) {
                        bArr20 = bArr18;
                        if (bArr19.length > 0) {
                            bArr10 = bArr10;
                            bArr38 = bArr38;
                            bArr21 = tlv_t201Var.get_tlv_201(bArr19, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                            i5++;
                        }
                        bArr22 = oicq.wlogin_sdk.request.t.R;
                        if (bArr22 != null) {
                            bArr23 = bArr4;
                        } else {
                            bArr23 = bArr4;
                        }
                        bArr24 = bArr23;
                        bArr25 = bArr21;
                        bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                        if (bArr3 != null) {
                            byte[] bArr511111111111111111111110 = bArr12;
                            byte[] bArr511111111111111111111111 = bArr38;
                            byte[] bArr511111111111111111111112 = bArr17;
                            byte[] bArr511111111111111111111113 = bArr20;
                            byte[] bArr511111111111111111111114 = bArr10;
                            java.lang.Object[] objArr1112 = bArr13;
                            int i11111111 = i5 + 2;
                            str = this.x.g;
                            if (str != null) {
                                bArr27 = bArr5;
                            } else {
                                bArr27 = bArr5;
                            }
                            int length41111111111111111111111111111 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                            byte[] bArr511111111111111111111115 = bArr9;
                            byte[] bArr511111111111111111111116 = bArr27;
                            bArr28 = new byte[length41111111111111111111111111111 + bArr511111111111111111111115.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111111111111111111.length + bArr511111111111111111111114.length + bArr511111111111111111111110.length + objArr1112.length + bArr511111111111111111111112.length + bArr511111111111111111111113.length + bArr25.length + bArr24.length];
                            java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                            int length41111111111111111111111111112 = bArr29.length + 0;
                            java.lang.System.arraycopy(bArr30, 0, bArr28, length41111111111111111111111111112, bArr30.length);
                            int length41111111111111111111111111113 = length41111111111111111111111111112 + bArr30.length;
                            java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111111111111111113, bArr31.length);
                            int length41111111111111111111111111114 = length41111111111111111111111111113 + bArr31.length;
                            java.lang.System.arraycopy(bArr6, 0, bArr28, length41111111111111111111111111114, bArr6.length);
                            int length41111111111111111111111111115 = length41111111111111111111111111114 + bArr6.length;
                            java.lang.System.arraycopy(bArr26, 0, bArr28, length41111111111111111111111111115, bArr26.length);
                            int length41111111111111111111111111116 = length41111111111111111111111111115 + bArr26.length;
                            java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111111111111111116, 0);
                            int i11111112 = length41111111111111111111111111116 + 0;
                            java.lang.System.arraycopy(bArr511111111111111111111116, 0, bArr28, i11111112, bArr511111111111111111111116.length);
                            int length41111111111111111111111111117 = i11111112 + bArr511111111111111111111116.length;
                            java.lang.System.arraycopy(bArr511111111111111111111115, 0, bArr28, length41111111111111111111111111117, bArr511111111111111111111115.length);
                            int length41111111111111111111111111118 = length41111111111111111111111111117 + bArr511111111111111111111115.length;
                            java.lang.System.arraycopy(bArr33, 0, bArr28, length41111111111111111111111111118, bArr33.length);
                            int length41111111111111111111111111119 = length41111111111111111111111111118 + bArr33.length;
                            java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111111111111119, bArr34.length);
                            int length111111111111111111111111111111110 = length41111111111111111111111111119 + bArr34.length;
                            java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111111111111111111111111110, bArr35.length);
                            int length111111111111111111111111111111111 = length111111111111111111111111111111110 + bArr35.length;
                            java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111111111111111111111111, bArr36.length);
                            int length111111111111111111111111111111112 = length111111111111111111111111111111111 + bArr36.length;
                            java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111111111111111111111111112, bArr37.length);
                            int length111111111111111111111111111111113 = length111111111111111111111111111111112 + bArr37.length;
                            java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111111111111111111111111113, bArr7.length);
                            int length111111111111111111111111111111114 = length111111111111111111111111111111113 + bArr7.length;
                            java.lang.System.arraycopy(bArr511111111111111111111111, 0, bArr28, length111111111111111111111111111111114, bArr511111111111111111111111.length);
                            int length111111111111111111111111111111115 = length111111111111111111111111111111114 + bArr511111111111111111111111.length;
                            java.lang.System.arraycopy(bArr511111111111111111111114, 0, bArr28, length111111111111111111111111111111115, bArr511111111111111111111114.length);
                            int length111111111111111111111111111111116 = length111111111111111111111111111111115 + bArr511111111111111111111114.length;
                            java.lang.System.arraycopy(bArr511111111111111111111110, 0, bArr28, length111111111111111111111111111111116, bArr511111111111111111111110.length);
                            int length111111111111111111111111111111117 = length111111111111111111111111111111116 + bArr511111111111111111111110.length;
                            java.lang.System.arraycopy(objArr1112, 0, bArr28, length111111111111111111111111111111117, objArr1112.length);
                            int length111111111111111111111111111111118 = length111111111111111111111111111111117 + objArr1112.length;
                            java.lang.System.arraycopy(bArr511111111111111111111112, 0, bArr28, length111111111111111111111111111111118, bArr511111111111111111111112.length);
                            int length111111111111111111111111111111119 = length111111111111111111111111111111118 + bArr511111111111111111111112.length;
                            java.lang.System.arraycopy(bArr511111111111111111111113, 0, bArr28, length111111111111111111111111111111119, bArr511111111111111111111113.length);
                            int length211111110 = length111111111111111111111111111111119 + bArr511111111111111111111113.length;
                            java.lang.System.arraycopy(bArr25, 0, bArr28, length211111110, bArr25.length);
                            java.lang.System.arraycopy(bArr24, 0, bArr28, length211111110 + bArr25.length, bArr24.length);
                            int length211111111 = bArr24.length;
                            i6 = i11111111;
                            i7 = i8;
                        } else {
                            byte[] bArr511111111111111111111117 = bArr12;
                            byte[] bArr511111111111111111111118 = bArr38;
                            byte[] bArr511111111111111111111119 = bArr17;
                            byte[] bArr5111111111111111111111110 = bArr20;
                            byte[] bArr5111111111111111111111111 = bArr10;
                            java.lang.Object[] objArr1113 = bArr13;
                            int i11111113 = i5 + 2;
                            str = this.x.g;
                            if (str != null) {
                                bArr27 = bArr5;
                            } else {
                                bArr27 = bArr5;
                            }
                            int length411111111111111111111111111110 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                            byte[] bArr5111111111111111111111112 = bArr9;
                            byte[] bArr5111111111111111111111113 = bArr27;
                            bArr28 = new byte[length411111111111111111111111111110 + bArr5111111111111111111111112.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111111111111111118.length + bArr5111111111111111111111111.length + bArr511111111111111111111117.length + objArr1113.length + bArr511111111111111111111119.length + bArr5111111111111111111111110.length + bArr25.length + bArr24.length];
                            java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                            int length411111111111111111111111111111 = bArr29.length + 0;
                            java.lang.System.arraycopy(bArr30, 0, bArr28, length411111111111111111111111111111, bArr30.length);
                            int length411111111111111111111111111112 = length411111111111111111111111111111 + bArr30.length;
                            java.lang.System.arraycopy(bArr31, 0, bArr28, length411111111111111111111111111112, bArr31.length);
                            int length411111111111111111111111111113 = length411111111111111111111111111112 + bArr31.length;
                            java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111111111111111113, bArr6.length);
                            int length411111111111111111111111111114 = length411111111111111111111111111113 + bArr6.length;
                            java.lang.System.arraycopy(bArr26, 0, bArr28, length411111111111111111111111111114, bArr26.length);
                            int length411111111111111111111111111115 = length411111111111111111111111111114 + bArr26.length;
                            java.lang.System.arraycopy(bArr41, 0, bArr28, length411111111111111111111111111115, 0);
                            int i11111114 = length411111111111111111111111111115 + 0;
                            java.lang.System.arraycopy(bArr5111111111111111111111113, 0, bArr28, i11111114, bArr5111111111111111111111113.length);
                            int length411111111111111111111111111116 = i11111114 + bArr5111111111111111111111113.length;
                            java.lang.System.arraycopy(bArr5111111111111111111111112, 0, bArr28, length411111111111111111111111111116, bArr5111111111111111111111112.length);
                            int length411111111111111111111111111117 = length411111111111111111111111111116 + bArr5111111111111111111111112.length;
                            java.lang.System.arraycopy(bArr33, 0, bArr28, length411111111111111111111111111117, bArr33.length);
                            int length411111111111111111111111111118 = length411111111111111111111111111117 + bArr33.length;
                            java.lang.System.arraycopy(bArr34, 0, bArr28, length411111111111111111111111111118, bArr34.length);
                            int length1111111111111111111111111111111110 = length411111111111111111111111111118 + bArr34.length;
                            java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111111111111111111111111110, bArr35.length);
                            int length1111111111111111111111111111111111 = length1111111111111111111111111111111110 + bArr35.length;
                            java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111111111111111111111111, bArr36.length);
                            int length1111111111111111111111111111111112 = length1111111111111111111111111111111111 + bArr36.length;
                            java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111111111111111111111111112, bArr37.length);
                            int length1111111111111111111111111111111113 = length1111111111111111111111111111111112 + bArr37.length;
                            java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111111111111111111111111113, bArr7.length);
                            int length1111111111111111111111111111111114 = length1111111111111111111111111111111113 + bArr7.length;
                            java.lang.System.arraycopy(bArr511111111111111111111118, 0, bArr28, length1111111111111111111111111111111114, bArr511111111111111111111118.length);
                            int length1111111111111111111111111111111115 = length1111111111111111111111111111111114 + bArr511111111111111111111118.length;
                            java.lang.System.arraycopy(bArr5111111111111111111111111, 0, bArr28, length1111111111111111111111111111111115, bArr5111111111111111111111111.length);
                            int length1111111111111111111111111111111116 = length1111111111111111111111111111111115 + bArr5111111111111111111111111.length;
                            java.lang.System.arraycopy(bArr511111111111111111111117, 0, bArr28, length1111111111111111111111111111111116, bArr511111111111111111111117.length);
                            int length1111111111111111111111111111111117 = length1111111111111111111111111111111116 + bArr511111111111111111111117.length;
                            java.lang.System.arraycopy(objArr1113, 0, bArr28, length1111111111111111111111111111111117, objArr1113.length);
                            int length1111111111111111111111111111111118 = length1111111111111111111111111111111117 + objArr1113.length;
                            java.lang.System.arraycopy(bArr511111111111111111111119, 0, bArr28, length1111111111111111111111111111111118, bArr511111111111111111111119.length);
                            int length1111111111111111111111111111111119 = length1111111111111111111111111111111118 + bArr511111111111111111111119.length;
                            java.lang.System.arraycopy(bArr5111111111111111111111110, 0, bArr28, length1111111111111111111111111111111119, bArr5111111111111111111111110.length);
                            int length211111112 = length1111111111111111111111111111111119 + bArr5111111111111111111111110.length;
                            java.lang.System.arraycopy(bArr25, 0, bArr28, length211111112, bArr25.length);
                            java.lang.System.arraycopy(bArr24, 0, bArr28, length211111112 + bArr25.length, bArr24.length);
                            int length211111113 = bArr24.length;
                            i6 = i11111113;
                            i7 = i8;
                        }
                        return b(bArr28, i7, i6);
                    }
                    bArr20 = bArr18;
                    bArr21 = bArr48;
                    bArr22 = oicq.wlogin_sdk.request.t.R;
                    if (bArr22 != null) {
                        bArr23 = bArr4;
                    } else {
                        bArr23 = bArr4;
                    }
                    bArr24 = bArr23;
                    bArr25 = bArr21;
                    bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                    if (bArr3 != null) {
                        byte[] bArr5111111111111111111111114 = bArr12;
                        byte[] bArr5111111111111111111111115 = bArr38;
                        byte[] bArr5111111111111111111111116 = bArr17;
                        byte[] bArr5111111111111111111111117 = bArr20;
                        byte[] bArr5111111111111111111111118 = bArr10;
                        java.lang.Object[] objArr1114 = bArr13;
                        int i11111115 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length411111111111111111111111111119 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr5111111111111111111111119 = bArr9;
                        byte[] bArr51111111111111111111111110 = bArr27;
                        bArr28 = new byte[length411111111111111111111111111119 + bArr5111111111111111111111119.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111111111111111111115.length + bArr5111111111111111111111118.length + bArr5111111111111111111111114.length + objArr1114.length + bArr5111111111111111111111116.length + bArr5111111111111111111111117.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length4111111111111111111111111111110 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111111111111111111110, bArr30.length);
                        int length4111111111111111111111111111111 = length4111111111111111111111111111110 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length4111111111111111111111111111111, bArr31.length);
                        int length4111111111111111111111111111112 = length4111111111111111111111111111111 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length4111111111111111111111111111112, bArr6.length);
                        int length4111111111111111111111111111113 = length4111111111111111111111111111112 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111111111111111111113, bArr26.length);
                        int length4111111111111111111111111111114 = length4111111111111111111111111111113 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length4111111111111111111111111111114, 0);
                        int i11111116 = length4111111111111111111111111111114 + 0;
                        java.lang.System.arraycopy(bArr51111111111111111111111110, 0, bArr28, i11111116, bArr51111111111111111111111110.length);
                        int length4111111111111111111111111111115 = i11111116 + bArr51111111111111111111111110.length;
                        java.lang.System.arraycopy(bArr5111111111111111111111119, 0, bArr28, length4111111111111111111111111111115, bArr5111111111111111111111119.length);
                        int length4111111111111111111111111111116 = length4111111111111111111111111111115 + bArr5111111111111111111111119.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111111111111111116, bArr33.length);
                        int length4111111111111111111111111111117 = length4111111111111111111111111111116 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length4111111111111111111111111111117, bArr34.length);
                        int length11111111111111111111111111111111110 = length4111111111111111111111111111117 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111111111111111111111111111110, bArr35.length);
                        int length11111111111111111111111111111111111 = length11111111111111111111111111111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111111111111111111111111111, bArr36.length);
                        int length11111111111111111111111111111111112 = length11111111111111111111111111111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111111111111111111111111111112, bArr37.length);
                        int length11111111111111111111111111111111113 = length11111111111111111111111111111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111111111111111111111111111113, bArr7.length);
                        int length11111111111111111111111111111111114 = length11111111111111111111111111111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr5111111111111111111111115, 0, bArr28, length11111111111111111111111111111111114, bArr5111111111111111111111115.length);
                        int length11111111111111111111111111111111115 = length11111111111111111111111111111111114 + bArr5111111111111111111111115.length;
                        java.lang.System.arraycopy(bArr5111111111111111111111118, 0, bArr28, length11111111111111111111111111111111115, bArr5111111111111111111111118.length);
                        int length11111111111111111111111111111111116 = length11111111111111111111111111111111115 + bArr5111111111111111111111118.length;
                        java.lang.System.arraycopy(bArr5111111111111111111111114, 0, bArr28, length11111111111111111111111111111111116, bArr5111111111111111111111114.length);
                        int length11111111111111111111111111111111117 = length11111111111111111111111111111111116 + bArr5111111111111111111111114.length;
                        java.lang.System.arraycopy(objArr1114, 0, bArr28, length11111111111111111111111111111111117, objArr1114.length);
                        int length11111111111111111111111111111111118 = length11111111111111111111111111111111117 + objArr1114.length;
                        java.lang.System.arraycopy(bArr5111111111111111111111116, 0, bArr28, length11111111111111111111111111111111118, bArr5111111111111111111111116.length);
                        int length11111111111111111111111111111111119 = length11111111111111111111111111111111118 + bArr5111111111111111111111116.length;
                        java.lang.System.arraycopy(bArr5111111111111111111111117, 0, bArr28, length11111111111111111111111111111111119, bArr5111111111111111111111117.length);
                        int length211111114 = length11111111111111111111111111111111119 + bArr5111111111111111111111117.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length211111114, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length211111114 + bArr25.length, bArr24.length);
                        int length211111115 = bArr24.length;
                        i6 = i11111115;
                        i7 = i8;
                    } else {
                        byte[] bArr51111111111111111111111111 = bArr12;
                        byte[] bArr51111111111111111111111112 = bArr38;
                        byte[] bArr51111111111111111111111113 = bArr17;
                        byte[] bArr51111111111111111111111114 = bArr20;
                        byte[] bArr51111111111111111111111115 = bArr10;
                        java.lang.Object[] objArr1115 = bArr13;
                        int i11111117 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length4111111111111111111111111111118 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr51111111111111111111111116 = bArr9;
                        byte[] bArr51111111111111111111111117 = bArr27;
                        bArr28 = new byte[length4111111111111111111111111111118 + bArr51111111111111111111111116.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111111111111111111111112.length + bArr51111111111111111111111115.length + bArr51111111111111111111111111.length + objArr1115.length + bArr51111111111111111111111113.length + bArr51111111111111111111111114.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length4111111111111111111111111111119 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111111111111111111119, bArr30.length);
                        int length41111111111111111111111111111110 = length4111111111111111111111111111119 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111111111111111111110, bArr31.length);
                        int length41111111111111111111111111111111 = length41111111111111111111111111111110 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length41111111111111111111111111111111, bArr6.length);
                        int length41111111111111111111111111111112 = length41111111111111111111111111111111 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length41111111111111111111111111111112, bArr26.length);
                        int length41111111111111111111111111111113 = length41111111111111111111111111111112 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111111111111111111113, 0);
                        int i11111118 = length41111111111111111111111111111113 + 0;
                        java.lang.System.arraycopy(bArr51111111111111111111111117, 0, bArr28, i11111118, bArr51111111111111111111111117.length);
                        int length41111111111111111111111111111114 = i11111118 + bArr51111111111111111111111117.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111116, 0, bArr28, length41111111111111111111111111111114, bArr51111111111111111111111116.length);
                        int length41111111111111111111111111111115 = length41111111111111111111111111111114 + bArr51111111111111111111111116.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length41111111111111111111111111111115, bArr33.length);
                        int length41111111111111111111111111111116 = length41111111111111111111111111111115 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111111111111111116, bArr34.length);
                        int length111111111111111111111111111111111110 = length41111111111111111111111111111116 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111111111111111111111111111110, bArr35.length);
                        int length111111111111111111111111111111111111 = length111111111111111111111111111111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111111111111111111111111111, bArr36.length);
                        int length111111111111111111111111111111111112 = length111111111111111111111111111111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111111111111111111111111111112, bArr37.length);
                        int length111111111111111111111111111111111113 = length111111111111111111111111111111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111111111111111111111111111113, bArr7.length);
                        int length111111111111111111111111111111111114 = length111111111111111111111111111111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111112, 0, bArr28, length111111111111111111111111111111111114, bArr51111111111111111111111112.length);
                        int length111111111111111111111111111111111115 = length111111111111111111111111111111111114 + bArr51111111111111111111111112.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111115, 0, bArr28, length111111111111111111111111111111111115, bArr51111111111111111111111115.length);
                        int length111111111111111111111111111111111116 = length111111111111111111111111111111111115 + bArr51111111111111111111111115.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111111, 0, bArr28, length111111111111111111111111111111111116, bArr51111111111111111111111111.length);
                        int length111111111111111111111111111111111117 = length111111111111111111111111111111111116 + bArr51111111111111111111111111.length;
                        java.lang.System.arraycopy(objArr1115, 0, bArr28, length111111111111111111111111111111111117, objArr1115.length);
                        int length111111111111111111111111111111111118 = length111111111111111111111111111111111117 + objArr1115.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111113, 0, bArr28, length111111111111111111111111111111111118, bArr51111111111111111111111113.length);
                        int length111111111111111111111111111111111119 = length111111111111111111111111111111111118 + bArr51111111111111111111111113.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111114, 0, bArr28, length111111111111111111111111111111111119, bArr51111111111111111111111114.length);
                        int length211111116 = length111111111111111111111111111111111119 + bArr51111111111111111111111114.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length211111116, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length211111116 + bArr25.length, bArr24.length);
                        int length211111117 = bArr24.length;
                        i6 = i11111117;
                        i7 = i8;
                    }
                    return b(bArr28, i7, i6);
                }
                bArr17 = bArr15;
                bArr18 = bArr47;
                bArr19 = oicq.wlogin_sdk.request.l.J;
                if (bArr19 != null) {
                    bArr20 = bArr18;
                    if (bArr19.length > 0) {
                        bArr10 = bArr10;
                        bArr38 = bArr38;
                        bArr21 = tlv_t201Var.get_tlv_201(bArr19, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                        i5++;
                    }
                    bArr22 = oicq.wlogin_sdk.request.t.R;
                    if (bArr22 != null) {
                        bArr23 = bArr4;
                    } else {
                        bArr23 = bArr4;
                    }
                    bArr24 = bArr23;
                    bArr25 = bArr21;
                    bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                    if (bArr3 != null) {
                        byte[] bArr51111111111111111111111118 = bArr12;
                        byte[] bArr51111111111111111111111119 = bArr38;
                        byte[] bArr511111111111111111111111110 = bArr17;
                        byte[] bArr511111111111111111111111111 = bArr20;
                        byte[] bArr511111111111111111111111112 = bArr10;
                        java.lang.Object[] objArr1116 = bArr13;
                        int i11111119 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length41111111111111111111111111111117 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr511111111111111111111111113 = bArr9;
                        byte[] bArr511111111111111111111111114 = bArr27;
                        bArr28 = new byte[length41111111111111111111111111111117 + bArr511111111111111111111111113.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111111111111111111111119.length + bArr511111111111111111111111112.length + bArr51111111111111111111111118.length + objArr1116.length + bArr511111111111111111111111110.length + bArr511111111111111111111111111.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length41111111111111111111111111111118 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length41111111111111111111111111111118, bArr30.length);
                        int length41111111111111111111111111111119 = length41111111111111111111111111111118 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111111111111111111119, bArr31.length);
                        int length411111111111111111111111111111110 = length41111111111111111111111111111119 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111111111111111111110, bArr6.length);
                        int length411111111111111111111111111111111 = length411111111111111111111111111111110 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length411111111111111111111111111111111, bArr26.length);
                        int length411111111111111111111111111111112 = length411111111111111111111111111111111 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length411111111111111111111111111111112, 0);
                        int i111111110 = length411111111111111111111111111111112 + 0;
                        java.lang.System.arraycopy(bArr511111111111111111111111114, 0, bArr28, i111111110, bArr511111111111111111111111114.length);
                        int length411111111111111111111111111111113 = i111111110 + bArr511111111111111111111111114.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111113, 0, bArr28, length411111111111111111111111111111113, bArr511111111111111111111111113.length);
                        int length411111111111111111111111111111114 = length411111111111111111111111111111113 + bArr511111111111111111111111113.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length411111111111111111111111111111114, bArr33.length);
                        int length411111111111111111111111111111115 = length411111111111111111111111111111114 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length411111111111111111111111111111115, bArr34.length);
                        int length1111111111111111111111111111111111110 = length411111111111111111111111111111115 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111111111111111111111111111110, bArr35.length);
                        int length1111111111111111111111111111111111111 = length1111111111111111111111111111111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111111111111111111111111111, bArr36.length);
                        int length1111111111111111111111111111111111112 = length1111111111111111111111111111111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111111111111111111111111111112, bArr37.length);
                        int length1111111111111111111111111111111111113 = length1111111111111111111111111111111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111111111111111111111111111113, bArr7.length);
                        int length1111111111111111111111111111111111114 = length1111111111111111111111111111111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111119, 0, bArr28, length1111111111111111111111111111111111114, bArr51111111111111111111111119.length);
                        int length1111111111111111111111111111111111115 = length1111111111111111111111111111111111114 + bArr51111111111111111111111119.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111112, 0, bArr28, length1111111111111111111111111111111111115, bArr511111111111111111111111112.length);
                        int length1111111111111111111111111111111111116 = length1111111111111111111111111111111111115 + bArr511111111111111111111111112.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111118, 0, bArr28, length1111111111111111111111111111111111116, bArr51111111111111111111111118.length);
                        int length1111111111111111111111111111111111117 = length1111111111111111111111111111111111116 + bArr51111111111111111111111118.length;
                        java.lang.System.arraycopy(objArr1116, 0, bArr28, length1111111111111111111111111111111111117, objArr1116.length);
                        int length1111111111111111111111111111111111118 = length1111111111111111111111111111111111117 + objArr1116.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111110, 0, bArr28, length1111111111111111111111111111111111118, bArr511111111111111111111111110.length);
                        int length1111111111111111111111111111111111119 = length1111111111111111111111111111111111118 + bArr511111111111111111111111110.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111111, 0, bArr28, length1111111111111111111111111111111111119, bArr511111111111111111111111111.length);
                        int length211111118 = length1111111111111111111111111111111111119 + bArr511111111111111111111111111.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length211111118, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length211111118 + bArr25.length, bArr24.length);
                        int length211111119 = bArr24.length;
                        i6 = i11111119;
                        i7 = i8;
                    } else {
                        byte[] bArr511111111111111111111111115 = bArr12;
                        byte[] bArr511111111111111111111111116 = bArr38;
                        byte[] bArr511111111111111111111111117 = bArr17;
                        byte[] bArr511111111111111111111111118 = bArr20;
                        byte[] bArr511111111111111111111111119 = bArr10;
                        java.lang.Object[] objArr1117 = bArr13;
                        int i111111111 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length411111111111111111111111111111116 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr5111111111111111111111111110 = bArr9;
                        byte[] bArr5111111111111111111111111111 = bArr27;
                        bArr28 = new byte[length411111111111111111111111111111116 + bArr5111111111111111111111111110.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111111111111111111116.length + bArr511111111111111111111111119.length + bArr511111111111111111111111115.length + objArr1117.length + bArr511111111111111111111111117.length + bArr511111111111111111111111118.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length411111111111111111111111111111117 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length411111111111111111111111111111117, bArr30.length);
                        int length411111111111111111111111111111118 = length411111111111111111111111111111117 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length411111111111111111111111111111118, bArr31.length);
                        int length411111111111111111111111111111119 = length411111111111111111111111111111118 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111111111111111111119, bArr6.length);
                        int length4111111111111111111111111111111110 = length411111111111111111111111111111119 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111111111111111111111110, bArr26.length);
                        int length4111111111111111111111111111111111 = length4111111111111111111111111111111110 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length4111111111111111111111111111111111, 0);
                        int i111111112 = length4111111111111111111111111111111111 + 0;
                        java.lang.System.arraycopy(bArr5111111111111111111111111111, 0, bArr28, i111111112, bArr5111111111111111111111111111.length);
                        int length4111111111111111111111111111111112 = i111111112 + bArr5111111111111111111111111111.length;
                        java.lang.System.arraycopy(bArr5111111111111111111111111110, 0, bArr28, length4111111111111111111111111111111112, bArr5111111111111111111111111110.length);
                        int length4111111111111111111111111111111113 = length4111111111111111111111111111111112 + bArr5111111111111111111111111110.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111111111111111111113, bArr33.length);
                        int length4111111111111111111111111111111114 = length4111111111111111111111111111111113 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length4111111111111111111111111111111114, bArr34.length);
                        int length11111111111111111111111111111111111110 = length4111111111111111111111111111111114 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111111111111111111111111111111110, bArr35.length);
                        int length11111111111111111111111111111111111111 = length11111111111111111111111111111111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111111111111111111111111111111, bArr36.length);
                        int length11111111111111111111111111111111111112 = length11111111111111111111111111111111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111111111111111111111111111111112, bArr37.length);
                        int length11111111111111111111111111111111111113 = length11111111111111111111111111111111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111111111111111111111111111111113, bArr7.length);
                        int length11111111111111111111111111111111111114 = length11111111111111111111111111111111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111116, 0, bArr28, length11111111111111111111111111111111111114, bArr511111111111111111111111116.length);
                        int length11111111111111111111111111111111111115 = length11111111111111111111111111111111111114 + bArr511111111111111111111111116.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111119, 0, bArr28, length11111111111111111111111111111111111115, bArr511111111111111111111111119.length);
                        int length11111111111111111111111111111111111116 = length11111111111111111111111111111111111115 + bArr511111111111111111111111119.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111115, 0, bArr28, length11111111111111111111111111111111111116, bArr511111111111111111111111115.length);
                        int length11111111111111111111111111111111111117 = length11111111111111111111111111111111111116 + bArr511111111111111111111111115.length;
                        java.lang.System.arraycopy(objArr1117, 0, bArr28, length11111111111111111111111111111111111117, objArr1117.length);
                        int length11111111111111111111111111111111111118 = length11111111111111111111111111111111111117 + objArr1117.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111117, 0, bArr28, length11111111111111111111111111111111111118, bArr511111111111111111111111117.length);
                        int length11111111111111111111111111111111111119 = length11111111111111111111111111111111111118 + bArr511111111111111111111111117.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111118, 0, bArr28, length11111111111111111111111111111111111119, bArr511111111111111111111111118.length);
                        int length2111111110 = length11111111111111111111111111111111111119 + bArr511111111111111111111111118.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length2111111110, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length2111111110 + bArr25.length, bArr24.length);
                        int length2111111111 = bArr24.length;
                        i6 = i111111111;
                        i7 = i8;
                    }
                    return b(bArr28, i7, i6);
                }
                bArr20 = bArr18;
                bArr21 = bArr48;
                bArr22 = oicq.wlogin_sdk.request.t.R;
                if (bArr22 != null) {
                    bArr23 = bArr4;
                } else {
                    bArr23 = bArr4;
                }
                bArr24 = bArr23;
                bArr25 = bArr21;
                bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                if (bArr3 != null) {
                    byte[] bArr5111111111111111111111111112 = bArr12;
                    byte[] bArr5111111111111111111111111113 = bArr38;
                    byte[] bArr5111111111111111111111111114 = bArr17;
                    byte[] bArr5111111111111111111111111115 = bArr20;
                    byte[] bArr5111111111111111111111111116 = bArr10;
                    java.lang.Object[] objArr1118 = bArr13;
                    int i111111113 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length4111111111111111111111111111111115 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr5111111111111111111111111117 = bArr9;
                    byte[] bArr5111111111111111111111111118 = bArr27;
                    bArr28 = new byte[length4111111111111111111111111111111115 + bArr5111111111111111111111111117.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111111111111111111111113.length + bArr5111111111111111111111111116.length + bArr5111111111111111111111111112.length + objArr1118.length + bArr5111111111111111111111111114.length + bArr5111111111111111111111111115.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length4111111111111111111111111111111116 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111111111111111111111116, bArr30.length);
                    int length4111111111111111111111111111111117 = length4111111111111111111111111111111116 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length4111111111111111111111111111111117, bArr31.length);
                    int length4111111111111111111111111111111118 = length4111111111111111111111111111111117 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length4111111111111111111111111111111118, bArr6.length);
                    int length4111111111111111111111111111111119 = length4111111111111111111111111111111118 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111111111111111111111119, bArr26.length);
                    int length41111111111111111111111111111111110 = length4111111111111111111111111111111119 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111111111111111111111110, 0);
                    int i111111114 = length41111111111111111111111111111111110 + 0;
                    java.lang.System.arraycopy(bArr5111111111111111111111111118, 0, bArr28, i111111114, bArr5111111111111111111111111118.length);
                    int length41111111111111111111111111111111111 = i111111114 + bArr5111111111111111111111111118.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111117, 0, bArr28, length41111111111111111111111111111111111, bArr5111111111111111111111111117.length);
                    int length41111111111111111111111111111111112 = length41111111111111111111111111111111111 + bArr5111111111111111111111111117.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length41111111111111111111111111111111112, bArr33.length);
                    int length41111111111111111111111111111111113 = length41111111111111111111111111111111112 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111111111111111111113, bArr34.length);
                    int length111111111111111111111111111111111111110 = length41111111111111111111111111111111113 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111111111111111111111111111111110, bArr35.length);
                    int length111111111111111111111111111111111111111 = length111111111111111111111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111111111111111111111111111111, bArr36.length);
                    int length111111111111111111111111111111111111112 = length111111111111111111111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111111111111111111111111111111112, bArr37.length);
                    int length111111111111111111111111111111111111113 = length111111111111111111111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111111111111111111111111111111113, bArr7.length);
                    int length111111111111111111111111111111111111114 = length111111111111111111111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111113, 0, bArr28, length111111111111111111111111111111111111114, bArr5111111111111111111111111113.length);
                    int length111111111111111111111111111111111111115 = length111111111111111111111111111111111111114 + bArr5111111111111111111111111113.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111116, 0, bArr28, length111111111111111111111111111111111111115, bArr5111111111111111111111111116.length);
                    int length111111111111111111111111111111111111116 = length111111111111111111111111111111111111115 + bArr5111111111111111111111111116.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111112, 0, bArr28, length111111111111111111111111111111111111116, bArr5111111111111111111111111112.length);
                    int length111111111111111111111111111111111111117 = length111111111111111111111111111111111111116 + bArr5111111111111111111111111112.length;
                    java.lang.System.arraycopy(objArr1118, 0, bArr28, length111111111111111111111111111111111111117, objArr1118.length);
                    int length111111111111111111111111111111111111118 = length111111111111111111111111111111111111117 + objArr1118.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111114, 0, bArr28, length111111111111111111111111111111111111118, bArr5111111111111111111111111114.length);
                    int length111111111111111111111111111111111111119 = length111111111111111111111111111111111111118 + bArr5111111111111111111111111114.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111115, 0, bArr28, length111111111111111111111111111111111111119, bArr5111111111111111111111111115.length);
                    int length2111111112 = length111111111111111111111111111111111111119 + bArr5111111111111111111111111115.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length2111111112, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length2111111112 + bArr25.length, bArr24.length);
                    int length2111111113 = bArr24.length;
                    i6 = i111111113;
                    i7 = i8;
                } else {
                    byte[] bArr5111111111111111111111111119 = bArr12;
                    byte[] bArr51111111111111111111111111110 = bArr38;
                    byte[] bArr51111111111111111111111111111 = bArr17;
                    byte[] bArr51111111111111111111111111112 = bArr20;
                    byte[] bArr51111111111111111111111111113 = bArr10;
                    java.lang.Object[] objArr1119 = bArr13;
                    int i111111115 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length41111111111111111111111111111111114 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr51111111111111111111111111114 = bArr9;
                    byte[] bArr51111111111111111111111111115 = bArr27;
                    bArr28 = new byte[length41111111111111111111111111111111114 + bArr51111111111111111111111111114.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111111111111111111111111110.length + bArr51111111111111111111111111113.length + bArr5111111111111111111111111119.length + objArr1119.length + bArr51111111111111111111111111111.length + bArr51111111111111111111111111112.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length41111111111111111111111111111111115 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length41111111111111111111111111111111115, bArr30.length);
                    int length41111111111111111111111111111111116 = length41111111111111111111111111111111115 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111111111111111111111116, bArr31.length);
                    int length41111111111111111111111111111111117 = length41111111111111111111111111111111116 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length41111111111111111111111111111111117, bArr6.length);
                    int length41111111111111111111111111111111118 = length41111111111111111111111111111111117 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length41111111111111111111111111111111118, bArr26.length);
                    int length41111111111111111111111111111111119 = length41111111111111111111111111111111118 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111111111111111111111119, 0);
                    int i111111116 = length41111111111111111111111111111111119 + 0;
                    java.lang.System.arraycopy(bArr51111111111111111111111111115, 0, bArr28, i111111116, bArr51111111111111111111111111115.length);
                    int length411111111111111111111111111111111110 = i111111116 + bArr51111111111111111111111111115.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111114, 0, bArr28, length411111111111111111111111111111111110, bArr51111111111111111111111111114.length);
                    int length411111111111111111111111111111111111 = length411111111111111111111111111111111110 + bArr51111111111111111111111111114.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length411111111111111111111111111111111111, bArr33.length);
                    int length411111111111111111111111111111111112 = length411111111111111111111111111111111111 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length411111111111111111111111111111111112, bArr34.length);
                    int length1111111111111111111111111111111111111110 = length411111111111111111111111111111111112 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111111111111111111111111111111110, bArr35.length);
                    int length1111111111111111111111111111111111111111 = length1111111111111111111111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111111111111111111111111111111, bArr36.length);
                    int length1111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111111111111111111111111111111112, bArr37.length);
                    int length1111111111111111111111111111111111111113 = length1111111111111111111111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111111111111111111111111111111113, bArr7.length);
                    int length1111111111111111111111111111111111111114 = length1111111111111111111111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111110, 0, bArr28, length1111111111111111111111111111111111111114, bArr51111111111111111111111111110.length);
                    int length1111111111111111111111111111111111111115 = length1111111111111111111111111111111111111114 + bArr51111111111111111111111111110.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111113, 0, bArr28, length1111111111111111111111111111111111111115, bArr51111111111111111111111111113.length);
                    int length1111111111111111111111111111111111111116 = length1111111111111111111111111111111111111115 + bArr51111111111111111111111111113.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111119, 0, bArr28, length1111111111111111111111111111111111111116, bArr5111111111111111111111111119.length);
                    int length1111111111111111111111111111111111111117 = length1111111111111111111111111111111111111116 + bArr5111111111111111111111111119.length;
                    java.lang.System.arraycopy(objArr1119, 0, bArr28, length1111111111111111111111111111111111111117, objArr1119.length);
                    int length1111111111111111111111111111111111111118 = length1111111111111111111111111111111111111117 + objArr1119.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111, 0, bArr28, length1111111111111111111111111111111111111118, bArr51111111111111111111111111111.length);
                    int length1111111111111111111111111111111111111119 = length1111111111111111111111111111111111111118 + bArr51111111111111111111111111111.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111112, 0, bArr28, length1111111111111111111111111111111111111119, bArr51111111111111111111111111112.length);
                    int length2111111114 = length1111111111111111111111111111111111111119 + bArr51111111111111111111111111112.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length2111111114, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length2111111114 + bArr25.length, bArr24.length);
                    int length2111111115 = bArr24.length;
                    i6 = i111111115;
                    i7 = i8;
                }
                return b(bArr28, i7, i6);
            }
            bArr12 = bArr39;
            bArr13 = bArr45;
            bArr14 = oicq.wlogin_sdk.request.t.O;
            if (bArr14 != null) {
                bArr15 = bArr46;
            } else {
                bArr15 = bArr46;
            }
            bArr16 = oicq.wlogin_sdk.request.t.L;
            if (bArr16 != null) {
                bArr17 = bArr15;
                if (bArr16.length > 0) {
                    bArr18 = tlv_t194Var.get_tlv_194(bArr16);
                    i5++;
                }
                bArr19 = oicq.wlogin_sdk.request.l.J;
                if (bArr19 != null) {
                    bArr20 = bArr18;
                    if (bArr19.length > 0) {
                        bArr10 = bArr10;
                        bArr38 = bArr38;
                        bArr21 = tlv_t201Var.get_tlv_201(bArr19, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                        i5++;
                    }
                    bArr22 = oicq.wlogin_sdk.request.t.R;
                    if (bArr22 != null) {
                        bArr23 = bArr4;
                    } else {
                        bArr23 = bArr4;
                    }
                    bArr24 = bArr23;
                    bArr25 = bArr21;
                    bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                    if (bArr3 != null) {
                        byte[] bArr51111111111111111111111111116 = bArr12;
                        byte[] bArr51111111111111111111111111117 = bArr38;
                        byte[] bArr51111111111111111111111111118 = bArr17;
                        byte[] bArr51111111111111111111111111119 = bArr20;
                        byte[] bArr511111111111111111111111111110 = bArr10;
                        java.lang.Object[] objArr11110 = bArr13;
                        int i111111117 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length411111111111111111111111111111111113 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr511111111111111111111111111111 = bArr9;
                        byte[] bArr511111111111111111111111111112 = bArr27;
                        bArr28 = new byte[length411111111111111111111111111111111113 + bArr511111111111111111111111111111.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111111111111111111111111117.length + bArr511111111111111111111111111110.length + bArr51111111111111111111111111116.length + objArr11110.length + bArr51111111111111111111111111118.length + bArr51111111111111111111111111119.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length411111111111111111111111111111111114 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length411111111111111111111111111111111114, bArr30.length);
                        int length411111111111111111111111111111111115 = length411111111111111111111111111111111114 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length411111111111111111111111111111111115, bArr31.length);
                        int length411111111111111111111111111111111116 = length411111111111111111111111111111111115 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111111111111111111111116, bArr6.length);
                        int length411111111111111111111111111111111117 = length411111111111111111111111111111111116 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length411111111111111111111111111111111117, bArr26.length);
                        int length411111111111111111111111111111111118 = length411111111111111111111111111111111117 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length411111111111111111111111111111111118, 0);
                        int i111111118 = length411111111111111111111111111111111118 + 0;
                        java.lang.System.arraycopy(bArr511111111111111111111111111112, 0, bArr28, i111111118, bArr511111111111111111111111111112.length);
                        int length411111111111111111111111111111111119 = i111111118 + bArr511111111111111111111111111112.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111111111, 0, bArr28, length411111111111111111111111111111111119, bArr511111111111111111111111111111.length);
                        int length4111111111111111111111111111111111110 = length411111111111111111111111111111111119 + bArr511111111111111111111111111111.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111111111111111111111110, bArr33.length);
                        int length4111111111111111111111111111111111111 = length4111111111111111111111111111111111110 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length4111111111111111111111111111111111111, bArr34.length);
                        int length11111111111111111111111111111111111111110 = length4111111111111111111111111111111111111 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111111111111111111111111111111111110, bArr35.length);
                        int length11111111111111111111111111111111111111111 = length11111111111111111111111111111111111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111111111111111111111111111111111, bArr36.length);
                        int length11111111111111111111111111111111111111112 = length11111111111111111111111111111111111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111111111111111111111111111111111112, bArr37.length);
                        int length11111111111111111111111111111111111111113 = length11111111111111111111111111111111111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111111111111111111111111111111111113, bArr7.length);
                        int length11111111111111111111111111111111111111114 = length11111111111111111111111111111111111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111111117, 0, bArr28, length11111111111111111111111111111111111111114, bArr51111111111111111111111111117.length);
                        int length11111111111111111111111111111111111111115 = length11111111111111111111111111111111111111114 + bArr51111111111111111111111111117.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111111110, 0, bArr28, length11111111111111111111111111111111111111115, bArr511111111111111111111111111110.length);
                        int length11111111111111111111111111111111111111116 = length11111111111111111111111111111111111111115 + bArr511111111111111111111111111110.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111111116, 0, bArr28, length11111111111111111111111111111111111111116, bArr51111111111111111111111111116.length);
                        int length11111111111111111111111111111111111111117 = length11111111111111111111111111111111111111116 + bArr51111111111111111111111111116.length;
                        java.lang.System.arraycopy(objArr11110, 0, bArr28, length11111111111111111111111111111111111111117, objArr11110.length);
                        int length11111111111111111111111111111111111111118 = length11111111111111111111111111111111111111117 + objArr11110.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111111118, 0, bArr28, length11111111111111111111111111111111111111118, bArr51111111111111111111111111118.length);
                        int length11111111111111111111111111111111111111119 = length11111111111111111111111111111111111111118 + bArr51111111111111111111111111118.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111111119, 0, bArr28, length11111111111111111111111111111111111111119, bArr51111111111111111111111111119.length);
                        int length2111111116 = length11111111111111111111111111111111111111119 + bArr51111111111111111111111111119.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length2111111116, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length2111111116 + bArr25.length, bArr24.length);
                        int length2111111117 = bArr24.length;
                        i6 = i111111117;
                        i7 = i8;
                    } else {
                        byte[] bArr511111111111111111111111111113 = bArr12;
                        byte[] bArr511111111111111111111111111114 = bArr38;
                        byte[] bArr511111111111111111111111111115 = bArr17;
                        byte[] bArr511111111111111111111111111116 = bArr20;
                        byte[] bArr511111111111111111111111111117 = bArr10;
                        java.lang.Object[] objArr11111 = bArr13;
                        int i111111119 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length4111111111111111111111111111111111112 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr511111111111111111111111111118 = bArr9;
                        byte[] bArr511111111111111111111111111119 = bArr27;
                        bArr28 = new byte[length4111111111111111111111111111111111112 + bArr511111111111111111111111111118.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111111111111111111111114.length + bArr511111111111111111111111111117.length + bArr511111111111111111111111111113.length + objArr11111.length + bArr511111111111111111111111111115.length + bArr511111111111111111111111111116.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length4111111111111111111111111111111111113 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111111111111111111111111113, bArr30.length);
                        int length4111111111111111111111111111111111114 = length4111111111111111111111111111111111113 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length4111111111111111111111111111111111114, bArr31.length);
                        int length4111111111111111111111111111111111115 = length4111111111111111111111111111111111114 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length4111111111111111111111111111111111115, bArr6.length);
                        int length4111111111111111111111111111111111116 = length4111111111111111111111111111111111115 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111111111111111111111111116, bArr26.length);
                        int length4111111111111111111111111111111111117 = length4111111111111111111111111111111111116 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length4111111111111111111111111111111111117, 0);
                        int i1111111110 = length4111111111111111111111111111111111117 + 0;
                        java.lang.System.arraycopy(bArr511111111111111111111111111119, 0, bArr28, i1111111110, bArr511111111111111111111111111119.length);
                        int length4111111111111111111111111111111111118 = i1111111110 + bArr511111111111111111111111111119.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111111118, 0, bArr28, length4111111111111111111111111111111111118, bArr511111111111111111111111111118.length);
                        int length4111111111111111111111111111111111119 = length4111111111111111111111111111111111118 + bArr511111111111111111111111111118.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111111111111111111111119, bArr33.length);
                        int length41111111111111111111111111111111111110 = length4111111111111111111111111111111111119 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111111111111111111111110, bArr34.length);
                        int length111111111111111111111111111111111111111110 = length41111111111111111111111111111111111110 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111111111111111111111111111111111110, bArr35.length);
                        int length111111111111111111111111111111111111111111 = length111111111111111111111111111111111111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111111111111111111111111111111111, bArr36.length);
                        int length111111111111111111111111111111111111111112 = length111111111111111111111111111111111111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111111111111111111111111111111111112, bArr37.length);
                        int length111111111111111111111111111111111111111113 = length111111111111111111111111111111111111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111111111111111111111111111111111113, bArr7.length);
                        int length111111111111111111111111111111111111111114 = length111111111111111111111111111111111111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111111114, 0, bArr28, length111111111111111111111111111111111111111114, bArr511111111111111111111111111114.length);
                        int length111111111111111111111111111111111111111115 = length111111111111111111111111111111111111111114 + bArr511111111111111111111111111114.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111111117, 0, bArr28, length111111111111111111111111111111111111111115, bArr511111111111111111111111111117.length);
                        int length111111111111111111111111111111111111111116 = length111111111111111111111111111111111111111115 + bArr511111111111111111111111111117.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111111113, 0, bArr28, length111111111111111111111111111111111111111116, bArr511111111111111111111111111113.length);
                        int length111111111111111111111111111111111111111117 = length111111111111111111111111111111111111111116 + bArr511111111111111111111111111113.length;
                        java.lang.System.arraycopy(objArr11111, 0, bArr28, length111111111111111111111111111111111111111117, objArr11111.length);
                        int length111111111111111111111111111111111111111118 = length111111111111111111111111111111111111111117 + objArr11111.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111111115, 0, bArr28, length111111111111111111111111111111111111111118, bArr511111111111111111111111111115.length);
                        int length111111111111111111111111111111111111111119 = length111111111111111111111111111111111111111118 + bArr511111111111111111111111111115.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111111116, 0, bArr28, length111111111111111111111111111111111111111119, bArr511111111111111111111111111116.length);
                        int length2111111118 = length111111111111111111111111111111111111111119 + bArr511111111111111111111111111116.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length2111111118, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length2111111118 + bArr25.length, bArr24.length);
                        int length2111111119 = bArr24.length;
                        i6 = i111111119;
                        i7 = i8;
                    }
                    return b(bArr28, i7, i6);
                }
                bArr20 = bArr18;
                bArr21 = bArr48;
                bArr22 = oicq.wlogin_sdk.request.t.R;
                if (bArr22 != null) {
                    bArr23 = bArr4;
                } else {
                    bArr23 = bArr4;
                }
                bArr24 = bArr23;
                bArr25 = bArr21;
                bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                if (bArr3 != null) {
                    byte[] bArr5111111111111111111111111111110 = bArr12;
                    byte[] bArr5111111111111111111111111111111 = bArr38;
                    byte[] bArr5111111111111111111111111111112 = bArr17;
                    byte[] bArr5111111111111111111111111111113 = bArr20;
                    byte[] bArr5111111111111111111111111111114 = bArr10;
                    java.lang.Object[] objArr11112 = bArr13;
                    int i1111111111 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length41111111111111111111111111111111111111 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr5111111111111111111111111111115 = bArr9;
                    byte[] bArr5111111111111111111111111111116 = bArr27;
                    bArr28 = new byte[length41111111111111111111111111111111111111 + bArr5111111111111111111111111111115.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111111111111111111111111111.length + bArr5111111111111111111111111111114.length + bArr5111111111111111111111111111110.length + objArr11112.length + bArr5111111111111111111111111111112.length + bArr5111111111111111111111111111113.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length41111111111111111111111111111111111112 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length41111111111111111111111111111111111112, bArr30.length);
                    int length41111111111111111111111111111111111113 = length41111111111111111111111111111111111112 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111111111111111111111111113, bArr31.length);
                    int length41111111111111111111111111111111111114 = length41111111111111111111111111111111111113 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length41111111111111111111111111111111111114, bArr6.length);
                    int length41111111111111111111111111111111111115 = length41111111111111111111111111111111111114 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length41111111111111111111111111111111111115, bArr26.length);
                    int length41111111111111111111111111111111111116 = length41111111111111111111111111111111111115 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111111111111111111111111116, 0);
                    int i1111111112 = length41111111111111111111111111111111111116 + 0;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111116, 0, bArr28, i1111111112, bArr5111111111111111111111111111116.length);
                    int length41111111111111111111111111111111111117 = i1111111112 + bArr5111111111111111111111111111116.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111115, 0, bArr28, length41111111111111111111111111111111111117, bArr5111111111111111111111111111115.length);
                    int length41111111111111111111111111111111111118 = length41111111111111111111111111111111111117 + bArr5111111111111111111111111111115.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length41111111111111111111111111111111111118, bArr33.length);
                    int length41111111111111111111111111111111111119 = length41111111111111111111111111111111111118 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111111111111111111111119, bArr34.length);
                    int length1111111111111111111111111111111111111111110 = length41111111111111111111111111111111111119 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111111111111111111111111111111111110, bArr35.length);
                    int length1111111111111111111111111111111111111111111 = length1111111111111111111111111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111111111111111111111111111111111, bArr36.length);
                    int length1111111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111111111111111111111111111111111112, bArr37.length);
                    int length1111111111111111111111111111111111111111113 = length1111111111111111111111111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111111111111111111111111111111111113, bArr7.length);
                    int length1111111111111111111111111111111111111111114 = length1111111111111111111111111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111111, 0, bArr28, length1111111111111111111111111111111111111111114, bArr5111111111111111111111111111111.length);
                    int length1111111111111111111111111111111111111111115 = length1111111111111111111111111111111111111111114 + bArr5111111111111111111111111111111.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111114, 0, bArr28, length1111111111111111111111111111111111111111115, bArr5111111111111111111111111111114.length);
                    int length1111111111111111111111111111111111111111116 = length1111111111111111111111111111111111111111115 + bArr5111111111111111111111111111114.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111110, 0, bArr28, length1111111111111111111111111111111111111111116, bArr5111111111111111111111111111110.length);
                    int length1111111111111111111111111111111111111111117 = length1111111111111111111111111111111111111111116 + bArr5111111111111111111111111111110.length;
                    java.lang.System.arraycopy(objArr11112, 0, bArr28, length1111111111111111111111111111111111111111117, objArr11112.length);
                    int length1111111111111111111111111111111111111111118 = length1111111111111111111111111111111111111111117 + objArr11112.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111112, 0, bArr28, length1111111111111111111111111111111111111111118, bArr5111111111111111111111111111112.length);
                    int length1111111111111111111111111111111111111111119 = length1111111111111111111111111111111111111111118 + bArr5111111111111111111111111111112.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111113, 0, bArr28, length1111111111111111111111111111111111111111119, bArr5111111111111111111111111111113.length);
                    int length21111111110 = length1111111111111111111111111111111111111111119 + bArr5111111111111111111111111111113.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length21111111110, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length21111111110 + bArr25.length, bArr24.length);
                    int length21111111111 = bArr24.length;
                    i6 = i1111111111;
                    i7 = i8;
                } else {
                    byte[] bArr5111111111111111111111111111117 = bArr12;
                    byte[] bArr5111111111111111111111111111118 = bArr38;
                    byte[] bArr5111111111111111111111111111119 = bArr17;
                    byte[] bArr51111111111111111111111111111110 = bArr20;
                    byte[] bArr51111111111111111111111111111111 = bArr10;
                    java.lang.Object[] objArr11113 = bArr13;
                    int i1111111113 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length411111111111111111111111111111111111110 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr51111111111111111111111111111112 = bArr9;
                    byte[] bArr51111111111111111111111111111113 = bArr27;
                    bArr28 = new byte[length411111111111111111111111111111111111110 + bArr51111111111111111111111111111112.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111111111111111111111111118.length + bArr51111111111111111111111111111111.length + bArr5111111111111111111111111111117.length + objArr11113.length + bArr5111111111111111111111111111119.length + bArr51111111111111111111111111111110.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length411111111111111111111111111111111111111 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length411111111111111111111111111111111111111, bArr30.length);
                    int length411111111111111111111111111111111111112 = length411111111111111111111111111111111111111 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length411111111111111111111111111111111111112, bArr31.length);
                    int length411111111111111111111111111111111111113 = length411111111111111111111111111111111111112 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111111111111111111111111113, bArr6.length);
                    int length411111111111111111111111111111111111114 = length411111111111111111111111111111111111113 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length411111111111111111111111111111111111114, bArr26.length);
                    int length411111111111111111111111111111111111115 = length411111111111111111111111111111111111114 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length411111111111111111111111111111111111115, 0);
                    int i1111111114 = length411111111111111111111111111111111111115 + 0;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111113, 0, bArr28, i1111111114, bArr51111111111111111111111111111113.length);
                    int length411111111111111111111111111111111111116 = i1111111114 + bArr51111111111111111111111111111113.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111112, 0, bArr28, length411111111111111111111111111111111111116, bArr51111111111111111111111111111112.length);
                    int length411111111111111111111111111111111111117 = length411111111111111111111111111111111111116 + bArr51111111111111111111111111111112.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length411111111111111111111111111111111111117, bArr33.length);
                    int length411111111111111111111111111111111111118 = length411111111111111111111111111111111111117 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length411111111111111111111111111111111111118, bArr34.length);
                    int length11111111111111111111111111111111111111111110 = length411111111111111111111111111111111111118 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111111111111111111111111111111111111110, bArr35.length);
                    int length11111111111111111111111111111111111111111111 = length11111111111111111111111111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111111111111111111111111111111111111, bArr36.length);
                    int length11111111111111111111111111111111111111111112 = length11111111111111111111111111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111111111111111111111111111111111111112, bArr37.length);
                    int length11111111111111111111111111111111111111111113 = length11111111111111111111111111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111111111111111111111111111111111111113, bArr7.length);
                    int length11111111111111111111111111111111111111111114 = length11111111111111111111111111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111118, 0, bArr28, length11111111111111111111111111111111111111111114, bArr5111111111111111111111111111118.length);
                    int length11111111111111111111111111111111111111111115 = length11111111111111111111111111111111111111111114 + bArr5111111111111111111111111111118.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111, 0, bArr28, length11111111111111111111111111111111111111111115, bArr51111111111111111111111111111111.length);
                    int length11111111111111111111111111111111111111111116 = length11111111111111111111111111111111111111111115 + bArr51111111111111111111111111111111.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111117, 0, bArr28, length11111111111111111111111111111111111111111116, bArr5111111111111111111111111111117.length);
                    int length11111111111111111111111111111111111111111117 = length11111111111111111111111111111111111111111116 + bArr5111111111111111111111111111117.length;
                    java.lang.System.arraycopy(objArr11113, 0, bArr28, length11111111111111111111111111111111111111111117, objArr11113.length);
                    int length11111111111111111111111111111111111111111118 = length11111111111111111111111111111111111111111117 + objArr11113.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111119, 0, bArr28, length11111111111111111111111111111111111111111118, bArr5111111111111111111111111111119.length);
                    int length11111111111111111111111111111111111111111119 = length11111111111111111111111111111111111111111118 + bArr5111111111111111111111111111119.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111110, 0, bArr28, length11111111111111111111111111111111111111111119, bArr51111111111111111111111111111110.length);
                    int length21111111112 = length11111111111111111111111111111111111111111119 + bArr51111111111111111111111111111110.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length21111111112, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length21111111112 + bArr25.length, bArr24.length);
                    int length21111111113 = bArr24.length;
                    i6 = i1111111113;
                    i7 = i8;
                }
                return b(bArr28, i7, i6);
            }
            bArr17 = bArr15;
            bArr18 = bArr47;
            bArr19 = oicq.wlogin_sdk.request.l.J;
            if (bArr19 != null) {
                bArr20 = bArr18;
                if (bArr19.length > 0) {
                    bArr10 = bArr10;
                    bArr38 = bArr38;
                    bArr21 = tlv_t201Var.get_tlv_201(bArr19, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                    i5++;
                }
                bArr22 = oicq.wlogin_sdk.request.t.R;
                if (bArr22 != null) {
                    bArr23 = bArr4;
                } else {
                    bArr23 = bArr4;
                }
                bArr24 = bArr23;
                bArr25 = bArr21;
                bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                if (bArr3 != null) {
                    byte[] bArr51111111111111111111111111111114 = bArr12;
                    byte[] bArr51111111111111111111111111111115 = bArr38;
                    byte[] bArr51111111111111111111111111111116 = bArr17;
                    byte[] bArr51111111111111111111111111111117 = bArr20;
                    byte[] bArr51111111111111111111111111111118 = bArr10;
                    java.lang.Object[] objArr11114 = bArr13;
                    int i1111111115 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length411111111111111111111111111111111111119 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr51111111111111111111111111111119 = bArr9;
                    byte[] bArr511111111111111111111111111111110 = bArr27;
                    bArr28 = new byte[length411111111111111111111111111111111111119 + bArr51111111111111111111111111111119.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111111111111111111111111111115.length + bArr51111111111111111111111111111118.length + bArr51111111111111111111111111111114.length + objArr11114.length + bArr51111111111111111111111111111116.length + bArr51111111111111111111111111111117.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length4111111111111111111111111111111111111110 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111111111111111111111111111110, bArr30.length);
                    int length4111111111111111111111111111111111111111 = length4111111111111111111111111111111111111110 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length4111111111111111111111111111111111111111, bArr31.length);
                    int length4111111111111111111111111111111111111112 = length4111111111111111111111111111111111111111 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length4111111111111111111111111111111111111112, bArr6.length);
                    int length4111111111111111111111111111111111111113 = length4111111111111111111111111111111111111112 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111111111111111111111111111113, bArr26.length);
                    int length4111111111111111111111111111111111111114 = length4111111111111111111111111111111111111113 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length4111111111111111111111111111111111111114, 0);
                    int i1111111116 = length4111111111111111111111111111111111111114 + 0;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111110, 0, bArr28, i1111111116, bArr511111111111111111111111111111110.length);
                    int length4111111111111111111111111111111111111115 = i1111111116 + bArr511111111111111111111111111111110.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111119, 0, bArr28, length4111111111111111111111111111111111111115, bArr51111111111111111111111111111119.length);
                    int length4111111111111111111111111111111111111116 = length4111111111111111111111111111111111111115 + bArr51111111111111111111111111111119.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111111111111111111111111116, bArr33.length);
                    int length4111111111111111111111111111111111111117 = length4111111111111111111111111111111111111116 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length4111111111111111111111111111111111111117, bArr34.length);
                    int length111111111111111111111111111111111111111111110 = length4111111111111111111111111111111111111117 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111111111111111111111111111111111111110, bArr35.length);
                    int length111111111111111111111111111111111111111111111 = length111111111111111111111111111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111111111111111111111111111111111111, bArr36.length);
                    int length111111111111111111111111111111111111111111112 = length111111111111111111111111111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111111111111111111111111111111111111112, bArr37.length);
                    int length111111111111111111111111111111111111111111113 = length111111111111111111111111111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111111111111111111111111111111111111113, bArr7.length);
                    int length111111111111111111111111111111111111111111114 = length111111111111111111111111111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111115, 0, bArr28, length111111111111111111111111111111111111111111114, bArr51111111111111111111111111111115.length);
                    int length111111111111111111111111111111111111111111115 = length111111111111111111111111111111111111111111114 + bArr51111111111111111111111111111115.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111118, 0, bArr28, length111111111111111111111111111111111111111111115, bArr51111111111111111111111111111118.length);
                    int length111111111111111111111111111111111111111111116 = length111111111111111111111111111111111111111111115 + bArr51111111111111111111111111111118.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111114, 0, bArr28, length111111111111111111111111111111111111111111116, bArr51111111111111111111111111111114.length);
                    int length111111111111111111111111111111111111111111117 = length111111111111111111111111111111111111111111116 + bArr51111111111111111111111111111114.length;
                    java.lang.System.arraycopy(objArr11114, 0, bArr28, length111111111111111111111111111111111111111111117, objArr11114.length);
                    int length111111111111111111111111111111111111111111118 = length111111111111111111111111111111111111111111117 + objArr11114.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111116, 0, bArr28, length111111111111111111111111111111111111111111118, bArr51111111111111111111111111111116.length);
                    int length111111111111111111111111111111111111111111119 = length111111111111111111111111111111111111111111118 + bArr51111111111111111111111111111116.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111117, 0, bArr28, length111111111111111111111111111111111111111111119, bArr51111111111111111111111111111117.length);
                    int length21111111114 = length111111111111111111111111111111111111111111119 + bArr51111111111111111111111111111117.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length21111111114, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length21111111114 + bArr25.length, bArr24.length);
                    int length21111111115 = bArr24.length;
                    i6 = i1111111115;
                    i7 = i8;
                } else {
                    byte[] bArr511111111111111111111111111111111 = bArr12;
                    byte[] bArr511111111111111111111111111111112 = bArr38;
                    byte[] bArr511111111111111111111111111111113 = bArr17;
                    byte[] bArr511111111111111111111111111111114 = bArr20;
                    byte[] bArr511111111111111111111111111111115 = bArr10;
                    java.lang.Object[] objArr11115 = bArr13;
                    int i1111111117 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length4111111111111111111111111111111111111118 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr511111111111111111111111111111116 = bArr9;
                    byte[] bArr511111111111111111111111111111117 = bArr27;
                    bArr28 = new byte[length4111111111111111111111111111111111111118 + bArr511111111111111111111111111111116.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111111111111111111111111112.length + bArr511111111111111111111111111111115.length + bArr511111111111111111111111111111111.length + objArr11115.length + bArr511111111111111111111111111111113.length + bArr511111111111111111111111111111114.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length4111111111111111111111111111111111111119 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111111111111111111111111111119, bArr30.length);
                    int length41111111111111111111111111111111111111110 = length4111111111111111111111111111111111111119 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111111111111111111111111111110, bArr31.length);
                    int length41111111111111111111111111111111111111111 = length41111111111111111111111111111111111111110 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length41111111111111111111111111111111111111111, bArr6.length);
                    int length41111111111111111111111111111111111111112 = length41111111111111111111111111111111111111111 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length41111111111111111111111111111111111111112, bArr26.length);
                    int length41111111111111111111111111111111111111113 = length41111111111111111111111111111111111111112 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111111111111111111111111111113, 0);
                    int i1111111118 = length41111111111111111111111111111111111111113 + 0;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111117, 0, bArr28, i1111111118, bArr511111111111111111111111111111117.length);
                    int length41111111111111111111111111111111111111114 = i1111111118 + bArr511111111111111111111111111111117.length;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111116, 0, bArr28, length41111111111111111111111111111111111111114, bArr511111111111111111111111111111116.length);
                    int length41111111111111111111111111111111111111115 = length41111111111111111111111111111111111111114 + bArr511111111111111111111111111111116.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length41111111111111111111111111111111111111115, bArr33.length);
                    int length41111111111111111111111111111111111111116 = length41111111111111111111111111111111111111115 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111111111111111111111111116, bArr34.length);
                    int length1111111111111111111111111111111111111111111110 = length41111111111111111111111111111111111111116 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111111111111111111111111111111111111110, bArr35.length);
                    int length1111111111111111111111111111111111111111111111 = length1111111111111111111111111111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111111111111111111111111111111111111, bArr36.length);
                    int length1111111111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111111111111111111111111111111111111112, bArr37.length);
                    int length1111111111111111111111111111111111111111111113 = length1111111111111111111111111111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111111111111111111111111111111111111113, bArr7.length);
                    int length1111111111111111111111111111111111111111111114 = length1111111111111111111111111111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111112, 0, bArr28, length1111111111111111111111111111111111111111111114, bArr511111111111111111111111111111112.length);
                    int length1111111111111111111111111111111111111111111115 = length1111111111111111111111111111111111111111111114 + bArr511111111111111111111111111111112.length;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111115, 0, bArr28, length1111111111111111111111111111111111111111111115, bArr511111111111111111111111111111115.length);
                    int length1111111111111111111111111111111111111111111116 = length1111111111111111111111111111111111111111111115 + bArr511111111111111111111111111111115.length;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111111, 0, bArr28, length1111111111111111111111111111111111111111111116, bArr511111111111111111111111111111111.length);
                    int length1111111111111111111111111111111111111111111117 = length1111111111111111111111111111111111111111111116 + bArr511111111111111111111111111111111.length;
                    java.lang.System.arraycopy(objArr11115, 0, bArr28, length1111111111111111111111111111111111111111111117, objArr11115.length);
                    int length1111111111111111111111111111111111111111111118 = length1111111111111111111111111111111111111111111117 + objArr11115.length;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111113, 0, bArr28, length1111111111111111111111111111111111111111111118, bArr511111111111111111111111111111113.length);
                    int length1111111111111111111111111111111111111111111119 = length1111111111111111111111111111111111111111111118 + bArr511111111111111111111111111111113.length;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111114, 0, bArr28, length1111111111111111111111111111111111111111111119, bArr511111111111111111111111111111114.length);
                    int length21111111116 = length1111111111111111111111111111111111111111111119 + bArr511111111111111111111111111111114.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length21111111116, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length21111111116 + bArr25.length, bArr24.length);
                    int length21111111117 = bArr24.length;
                    i6 = i1111111117;
                    i7 = i8;
                }
                return b(bArr28, i7, i6);
            }
            bArr20 = bArr18;
            bArr21 = bArr48;
            bArr22 = oicq.wlogin_sdk.request.t.R;
            if (bArr22 != null) {
                bArr23 = bArr4;
            } else {
                bArr23 = bArr4;
            }
            bArr24 = bArr23;
            bArr25 = bArr21;
            bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
            if (bArr3 != null) {
                byte[] bArr511111111111111111111111111111118 = bArr12;
                byte[] bArr511111111111111111111111111111119 = bArr38;
                byte[] bArr5111111111111111111111111111111110 = bArr17;
                byte[] bArr5111111111111111111111111111111111 = bArr20;
                byte[] bArr5111111111111111111111111111111112 = bArr10;
                java.lang.Object[] objArr11116 = bArr13;
                int i1111111119 = i5 + 2;
                str = this.x.g;
                if (str != null) {
                    bArr27 = bArr5;
                } else {
                    bArr27 = bArr5;
                }
                int length41111111111111111111111111111111111111117 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                byte[] bArr5111111111111111111111111111111113 = bArr9;
                byte[] bArr5111111111111111111111111111111114 = bArr27;
                bArr28 = new byte[length41111111111111111111111111111111111111117 + bArr5111111111111111111111111111111113.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111111111111111111111111119.length + bArr5111111111111111111111111111111112.length + bArr511111111111111111111111111111118.length + objArr11116.length + bArr5111111111111111111111111111111110.length + bArr5111111111111111111111111111111111.length + bArr25.length + bArr24.length];
                java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                int length41111111111111111111111111111111111111118 = bArr29.length + 0;
                java.lang.System.arraycopy(bArr30, 0, bArr28, length41111111111111111111111111111111111111118, bArr30.length);
                int length41111111111111111111111111111111111111119 = length41111111111111111111111111111111111111118 + bArr30.length;
                java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111111111111111111111111111119, bArr31.length);
                int length411111111111111111111111111111111111111110 = length41111111111111111111111111111111111111119 + bArr31.length;
                java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111111111111111111111111111110, bArr6.length);
                int length411111111111111111111111111111111111111111 = length411111111111111111111111111111111111111110 + bArr6.length;
                java.lang.System.arraycopy(bArr26, 0, bArr28, length411111111111111111111111111111111111111111, bArr26.length);
                int length411111111111111111111111111111111111111112 = length411111111111111111111111111111111111111111 + bArr26.length;
                java.lang.System.arraycopy(bArr41, 0, bArr28, length411111111111111111111111111111111111111112, 0);
                int i11111111110 = length411111111111111111111111111111111111111112 + 0;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111114, 0, bArr28, i11111111110, bArr5111111111111111111111111111111114.length);
                int length411111111111111111111111111111111111111113 = i11111111110 + bArr5111111111111111111111111111111114.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111113, 0, bArr28, length411111111111111111111111111111111111111113, bArr5111111111111111111111111111111113.length);
                int length411111111111111111111111111111111111111114 = length411111111111111111111111111111111111111113 + bArr5111111111111111111111111111111113.length;
                java.lang.System.arraycopy(bArr33, 0, bArr28, length411111111111111111111111111111111111111114, bArr33.length);
                int length411111111111111111111111111111111111111115 = length411111111111111111111111111111111111111114 + bArr33.length;
                java.lang.System.arraycopy(bArr34, 0, bArr28, length411111111111111111111111111111111111111115, bArr34.length);
                int length11111111111111111111111111111111111111111111110 = length411111111111111111111111111111111111111115 + bArr34.length;
                java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111111111111111111111111111111111111111110, bArr35.length);
                int length11111111111111111111111111111111111111111111111 = length11111111111111111111111111111111111111111111110 + bArr35.length;
                java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111111111111111111111111111111111111111, bArr36.length);
                int length11111111111111111111111111111111111111111111112 = length11111111111111111111111111111111111111111111111 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111111111111111111111111111111111111111112, bArr37.length);
                int length11111111111111111111111111111111111111111111113 = length11111111111111111111111111111111111111111111112 + bArr37.length;
                java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111111111111111111111111111111111111111113, bArr7.length);
                int length11111111111111111111111111111111111111111111114 = length11111111111111111111111111111111111111111111113 + bArr7.length;
                java.lang.System.arraycopy(bArr511111111111111111111111111111119, 0, bArr28, length11111111111111111111111111111111111111111111114, bArr511111111111111111111111111111119.length);
                int length11111111111111111111111111111111111111111111115 = length11111111111111111111111111111111111111111111114 + bArr511111111111111111111111111111119.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111112, 0, bArr28, length11111111111111111111111111111111111111111111115, bArr5111111111111111111111111111111112.length);
                int length11111111111111111111111111111111111111111111116 = length11111111111111111111111111111111111111111111115 + bArr5111111111111111111111111111111112.length;
                java.lang.System.arraycopy(bArr511111111111111111111111111111118, 0, bArr28, length11111111111111111111111111111111111111111111116, bArr511111111111111111111111111111118.length);
                int length11111111111111111111111111111111111111111111117 = length11111111111111111111111111111111111111111111116 + bArr511111111111111111111111111111118.length;
                java.lang.System.arraycopy(objArr11116, 0, bArr28, length11111111111111111111111111111111111111111111117, objArr11116.length);
                int length11111111111111111111111111111111111111111111118 = length11111111111111111111111111111111111111111111117 + objArr11116.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111110, 0, bArr28, length11111111111111111111111111111111111111111111118, bArr5111111111111111111111111111111110.length);
                int length11111111111111111111111111111111111111111111119 = length11111111111111111111111111111111111111111111118 + bArr5111111111111111111111111111111110.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111, 0, bArr28, length11111111111111111111111111111111111111111111119, bArr5111111111111111111111111111111111.length);
                int length21111111118 = length11111111111111111111111111111111111111111111119 + bArr5111111111111111111111111111111111.length;
                java.lang.System.arraycopy(bArr25, 0, bArr28, length21111111118, bArr25.length);
                java.lang.System.arraycopy(bArr24, 0, bArr28, length21111111118 + bArr25.length, bArr24.length);
                int length21111111119 = bArr24.length;
                i6 = i1111111119;
                i7 = i8;
            } else {
                byte[] bArr5111111111111111111111111111111115 = bArr12;
                byte[] bArr5111111111111111111111111111111116 = bArr38;
                byte[] bArr5111111111111111111111111111111117 = bArr17;
                byte[] bArr5111111111111111111111111111111118 = bArr20;
                byte[] bArr5111111111111111111111111111111119 = bArr10;
                java.lang.Object[] objArr11117 = bArr13;
                int i11111111111 = i5 + 2;
                str = this.x.g;
                if (str != null) {
                    bArr27 = bArr5;
                } else {
                    bArr27 = bArr5;
                }
                int length411111111111111111111111111111111111111116 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                byte[] bArr51111111111111111111111111111111110 = bArr9;
                byte[] bArr51111111111111111111111111111111111 = bArr27;
                bArr28 = new byte[length411111111111111111111111111111111111111116 + bArr51111111111111111111111111111111110.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111111111111111111111111111116.length + bArr5111111111111111111111111111111119.length + bArr5111111111111111111111111111111115.length + objArr11117.length + bArr5111111111111111111111111111111117.length + bArr5111111111111111111111111111111118.length + bArr25.length + bArr24.length];
                java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                int length411111111111111111111111111111111111111117 = bArr29.length + 0;
                java.lang.System.arraycopy(bArr30, 0, bArr28, length411111111111111111111111111111111111111117, bArr30.length);
                int length411111111111111111111111111111111111111118 = length411111111111111111111111111111111111111117 + bArr30.length;
                java.lang.System.arraycopy(bArr31, 0, bArr28, length411111111111111111111111111111111111111118, bArr31.length);
                int length411111111111111111111111111111111111111119 = length411111111111111111111111111111111111111118 + bArr31.length;
                java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111111111111111111111111111119, bArr6.length);
                int length4111111111111111111111111111111111111111110 = length411111111111111111111111111111111111111119 + bArr6.length;
                java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111111111111111111111111111111110, bArr26.length);
                int length4111111111111111111111111111111111111111111 = length4111111111111111111111111111111111111111110 + bArr26.length;
                java.lang.System.arraycopy(bArr41, 0, bArr28, length4111111111111111111111111111111111111111111, 0);
                int i11111111112 = length4111111111111111111111111111111111111111111 + 0;
                java.lang.System.arraycopy(bArr51111111111111111111111111111111111, 0, bArr28, i11111111112, bArr51111111111111111111111111111111111.length);
                int length4111111111111111111111111111111111111111112 = i11111111112 + bArr51111111111111111111111111111111111.length;
                java.lang.System.arraycopy(bArr51111111111111111111111111111111110, 0, bArr28, length4111111111111111111111111111111111111111112, bArr51111111111111111111111111111111110.length);
                int length4111111111111111111111111111111111111111113 = length4111111111111111111111111111111111111111112 + bArr51111111111111111111111111111111110.length;
                java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111111111111111111111111111113, bArr33.length);
                int length4111111111111111111111111111111111111111114 = length4111111111111111111111111111111111111111113 + bArr33.length;
                java.lang.System.arraycopy(bArr34, 0, bArr28, length4111111111111111111111111111111111111111114, bArr34.length);
                int length111111111111111111111111111111111111111111111110 = length4111111111111111111111111111111111111111114 + bArr34.length;
                java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111111111111111111111111111111111111111110, bArr35.length);
                int length111111111111111111111111111111111111111111111111 = length111111111111111111111111111111111111111111111110 + bArr35.length;
                java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111111111111111111111111111111111111111, bArr36.length);
                int length111111111111111111111111111111111111111111111112 = length111111111111111111111111111111111111111111111111 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111111111111111111111111111111111111111112, bArr37.length);
                int length111111111111111111111111111111111111111111111113 = length111111111111111111111111111111111111111111111112 + bArr37.length;
                java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111111111111111111111111111111111111111113, bArr7.length);
                int length111111111111111111111111111111111111111111111114 = length111111111111111111111111111111111111111111111113 + bArr7.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111116, 0, bArr28, length111111111111111111111111111111111111111111111114, bArr5111111111111111111111111111111116.length);
                int length111111111111111111111111111111111111111111111115 = length111111111111111111111111111111111111111111111114 + bArr5111111111111111111111111111111116.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111119, 0, bArr28, length111111111111111111111111111111111111111111111115, bArr5111111111111111111111111111111119.length);
                int length111111111111111111111111111111111111111111111116 = length111111111111111111111111111111111111111111111115 + bArr5111111111111111111111111111111119.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111115, 0, bArr28, length111111111111111111111111111111111111111111111116, bArr5111111111111111111111111111111115.length);
                int length111111111111111111111111111111111111111111111117 = length111111111111111111111111111111111111111111111116 + bArr5111111111111111111111111111111115.length;
                java.lang.System.arraycopy(objArr11117, 0, bArr28, length111111111111111111111111111111111111111111111117, objArr11117.length);
                int length111111111111111111111111111111111111111111111118 = length111111111111111111111111111111111111111111111117 + objArr11117.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111117, 0, bArr28, length111111111111111111111111111111111111111111111118, bArr5111111111111111111111111111111117.length);
                int length111111111111111111111111111111111111111111111119 = length111111111111111111111111111111111111111111111118 + bArr5111111111111111111111111111111117.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111118, 0, bArr28, length111111111111111111111111111111111111111111111119, bArr5111111111111111111111111111111118.length);
                int length211111111110 = length111111111111111111111111111111111111111111111119 + bArr5111111111111111111111111111111118.length;
                java.lang.System.arraycopy(bArr25, 0, bArr28, length211111111110, bArr25.length);
                java.lang.System.arraycopy(bArr24, 0, bArr28, length211111111110 + bArr25.length, bArr24.length);
                int length211111111111 = bArr24.length;
                i6 = i11111111111;
                i7 = i8;
            }
            return b(bArr28, i7, i6);
        }
        bArr9 = bArr32;
        bArr10 = bArr44;
        bArr11 = oicq.wlogin_sdk.request.t.N;
        if (bArr11 != null) {
            bArr12 = bArr39;
            if (bArr11.length > 0) {
                bArr13 = tlv_t187Var.get_tlv_187(bArr11);
                i5++;
            }
            bArr14 = oicq.wlogin_sdk.request.t.O;
            if (bArr14 != null) {
                bArr15 = bArr46;
            } else {
                bArr15 = bArr46;
            }
            bArr16 = oicq.wlogin_sdk.request.t.L;
            if (bArr16 != null) {
                bArr17 = bArr15;
                if (bArr16.length > 0) {
                    bArr18 = tlv_t194Var.get_tlv_194(bArr16);
                    i5++;
                }
                bArr19 = oicq.wlogin_sdk.request.l.J;
                if (bArr19 != null) {
                    bArr20 = bArr18;
                    if (bArr19.length > 0) {
                        bArr10 = bArr10;
                        bArr38 = bArr38;
                        bArr21 = tlv_t201Var.get_tlv_201(bArr19, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                        i5++;
                    }
                    bArr22 = oicq.wlogin_sdk.request.t.R;
                    if (bArr22 != null) {
                        bArr23 = bArr4;
                    } else {
                        bArr23 = bArr4;
                    }
                    bArr24 = bArr23;
                    bArr25 = bArr21;
                    bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                    if (bArr3 != null) {
                        byte[] bArr51111111111111111111111111111111112 = bArr12;
                        byte[] bArr51111111111111111111111111111111113 = bArr38;
                        byte[] bArr51111111111111111111111111111111114 = bArr17;
                        byte[] bArr51111111111111111111111111111111115 = bArr20;
                        byte[] bArr51111111111111111111111111111111116 = bArr10;
                        java.lang.Object[] objArr11118 = bArr13;
                        int i11111111113 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length4111111111111111111111111111111111111111115 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr51111111111111111111111111111111117 = bArr9;
                        byte[] bArr51111111111111111111111111111111118 = bArr27;
                        bArr28 = new byte[length4111111111111111111111111111111111111111115 + bArr51111111111111111111111111111111117.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111111111111111111111111111111113.length + bArr51111111111111111111111111111111116.length + bArr51111111111111111111111111111111112.length + objArr11118.length + bArr51111111111111111111111111111111114.length + bArr51111111111111111111111111111111115.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length4111111111111111111111111111111111111111116 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111111111111111111111111111111116, bArr30.length);
                        int length4111111111111111111111111111111111111111117 = length4111111111111111111111111111111111111111116 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length4111111111111111111111111111111111111111117, bArr31.length);
                        int length4111111111111111111111111111111111111111118 = length4111111111111111111111111111111111111111117 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length4111111111111111111111111111111111111111118, bArr6.length);
                        int length4111111111111111111111111111111111111111119 = length4111111111111111111111111111111111111111118 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111111111111111111111111111111119, bArr26.length);
                        int length41111111111111111111111111111111111111111110 = length4111111111111111111111111111111111111111119 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111111111111111111111111111111110, 0);
                        int i11111111114 = length41111111111111111111111111111111111111111110 + 0;
                        java.lang.System.arraycopy(bArr51111111111111111111111111111111118, 0, bArr28, i11111111114, bArr51111111111111111111111111111111118.length);
                        int length41111111111111111111111111111111111111111111 = i11111111114 + bArr51111111111111111111111111111111118.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111111111111117, 0, bArr28, length41111111111111111111111111111111111111111111, bArr51111111111111111111111111111111117.length);
                        int length41111111111111111111111111111111111111111112 = length41111111111111111111111111111111111111111111 + bArr51111111111111111111111111111111117.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length41111111111111111111111111111111111111111112, bArr33.length);
                        int length41111111111111111111111111111111111111111113 = length41111111111111111111111111111111111111111112 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111111111111111111111111111113, bArr34.length);
                        int length1111111111111111111111111111111111111111111111110 = length41111111111111111111111111111111111111111113 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111111111111111111111111111111111111111110, bArr35.length);
                        int length1111111111111111111111111111111111111111111111111 = length1111111111111111111111111111111111111111111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111111111111111111111111111111111111111, bArr36.length);
                        int length1111111111111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111111111111111111111111111111111111111112, bArr37.length);
                        int length1111111111111111111111111111111111111111111111113 = length1111111111111111111111111111111111111111111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111111111111111111111111111111111111111113, bArr7.length);
                        int length1111111111111111111111111111111111111111111111114 = length1111111111111111111111111111111111111111111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111111111111113, 0, bArr28, length1111111111111111111111111111111111111111111111114, bArr51111111111111111111111111111111113.length);
                        int length1111111111111111111111111111111111111111111111115 = length1111111111111111111111111111111111111111111111114 + bArr51111111111111111111111111111111113.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111111111111116, 0, bArr28, length1111111111111111111111111111111111111111111111115, bArr51111111111111111111111111111111116.length);
                        int length1111111111111111111111111111111111111111111111116 = length1111111111111111111111111111111111111111111111115 + bArr51111111111111111111111111111111116.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111111111111112, 0, bArr28, length1111111111111111111111111111111111111111111111116, bArr51111111111111111111111111111111112.length);
                        int length1111111111111111111111111111111111111111111111117 = length1111111111111111111111111111111111111111111111116 + bArr51111111111111111111111111111111112.length;
                        java.lang.System.arraycopy(objArr11118, 0, bArr28, length1111111111111111111111111111111111111111111111117, objArr11118.length);
                        int length1111111111111111111111111111111111111111111111118 = length1111111111111111111111111111111111111111111111117 + objArr11118.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111111111111114, 0, bArr28, length1111111111111111111111111111111111111111111111118, bArr51111111111111111111111111111111114.length);
                        int length1111111111111111111111111111111111111111111111119 = length1111111111111111111111111111111111111111111111118 + bArr51111111111111111111111111111111114.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111111111111115, 0, bArr28, length1111111111111111111111111111111111111111111111119, bArr51111111111111111111111111111111115.length);
                        int length211111111112 = length1111111111111111111111111111111111111111111111119 + bArr51111111111111111111111111111111115.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length211111111112, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length211111111112 + bArr25.length, bArr24.length);
                        int length211111111113 = bArr24.length;
                        i6 = i11111111113;
                        i7 = i8;
                    } else {
                        byte[] bArr51111111111111111111111111111111119 = bArr12;
                        byte[] bArr511111111111111111111111111111111110 = bArr38;
                        byte[] bArr511111111111111111111111111111111111 = bArr17;
                        byte[] bArr511111111111111111111111111111111112 = bArr20;
                        byte[] bArr511111111111111111111111111111111113 = bArr10;
                        java.lang.Object[] objArr11119 = bArr13;
                        int i11111111115 = i5 + 2;
                        str = this.x.g;
                        if (str != null) {
                            bArr27 = bArr5;
                        } else {
                            bArr27 = bArr5;
                        }
                        int length41111111111111111111111111111111111111111114 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                        byte[] bArr511111111111111111111111111111111114 = bArr9;
                        byte[] bArr511111111111111111111111111111111115 = bArr27;
                        bArr28 = new byte[length41111111111111111111111111111111111111111114 + bArr511111111111111111111111111111111114.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111111111111111111111111111110.length + bArr511111111111111111111111111111111113.length + bArr51111111111111111111111111111111119.length + objArr11119.length + bArr511111111111111111111111111111111111.length + bArr511111111111111111111111111111111112.length + bArr25.length + bArr24.length];
                        java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                        int length41111111111111111111111111111111111111111115 = bArr29.length + 0;
                        java.lang.System.arraycopy(bArr30, 0, bArr28, length41111111111111111111111111111111111111111115, bArr30.length);
                        int length41111111111111111111111111111111111111111116 = length41111111111111111111111111111111111111111115 + bArr30.length;
                        java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111111111111111111111111111111116, bArr31.length);
                        int length41111111111111111111111111111111111111111117 = length41111111111111111111111111111111111111111116 + bArr31.length;
                        java.lang.System.arraycopy(bArr6, 0, bArr28, length41111111111111111111111111111111111111111117, bArr6.length);
                        int length41111111111111111111111111111111111111111118 = length41111111111111111111111111111111111111111117 + bArr6.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr28, length41111111111111111111111111111111111111111118, bArr26.length);
                        int length41111111111111111111111111111111111111111119 = length41111111111111111111111111111111111111111118 + bArr26.length;
                        java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111111111111111111111111111111119, 0);
                        int i11111111116 = length41111111111111111111111111111111111111111119 + 0;
                        java.lang.System.arraycopy(bArr511111111111111111111111111111111115, 0, bArr28, i11111111116, bArr511111111111111111111111111111111115.length);
                        int length411111111111111111111111111111111111111111110 = i11111111116 + bArr511111111111111111111111111111111115.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111111111111114, 0, bArr28, length411111111111111111111111111111111111111111110, bArr511111111111111111111111111111111114.length);
                        int length411111111111111111111111111111111111111111111 = length411111111111111111111111111111111111111111110 + bArr511111111111111111111111111111111114.length;
                        java.lang.System.arraycopy(bArr33, 0, bArr28, length411111111111111111111111111111111111111111111, bArr33.length);
                        int length411111111111111111111111111111111111111111112 = length411111111111111111111111111111111111111111111 + bArr33.length;
                        java.lang.System.arraycopy(bArr34, 0, bArr28, length411111111111111111111111111111111111111111112, bArr34.length);
                        int length11111111111111111111111111111111111111111111111110 = length411111111111111111111111111111111111111111112 + bArr34.length;
                        java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111111111111111111111111111111111111111111110, bArr35.length);
                        int length11111111111111111111111111111111111111111111111111 = length11111111111111111111111111111111111111111111111110 + bArr35.length;
                        java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111111111111111111111111111111111111111111, bArr36.length);
                        int length11111111111111111111111111111111111111111111111112 = length11111111111111111111111111111111111111111111111111 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111111111111111111111111111111111111111111112, bArr37.length);
                        int length11111111111111111111111111111111111111111111111113 = length11111111111111111111111111111111111111111111111112 + bArr37.length;
                        java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111111111111111111111111111111111111111111113, bArr7.length);
                        int length11111111111111111111111111111111111111111111111114 = length11111111111111111111111111111111111111111111111113 + bArr7.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111111111111110, 0, bArr28, length11111111111111111111111111111111111111111111111114, bArr511111111111111111111111111111111110.length);
                        int length11111111111111111111111111111111111111111111111115 = length11111111111111111111111111111111111111111111111114 + bArr511111111111111111111111111111111110.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111111111111113, 0, bArr28, length11111111111111111111111111111111111111111111111115, bArr511111111111111111111111111111111113.length);
                        int length11111111111111111111111111111111111111111111111116 = length11111111111111111111111111111111111111111111111115 + bArr511111111111111111111111111111111113.length;
                        java.lang.System.arraycopy(bArr51111111111111111111111111111111119, 0, bArr28, length11111111111111111111111111111111111111111111111116, bArr51111111111111111111111111111111119.length);
                        int length11111111111111111111111111111111111111111111111117 = length11111111111111111111111111111111111111111111111116 + bArr51111111111111111111111111111111119.length;
                        java.lang.System.arraycopy(objArr11119, 0, bArr28, length11111111111111111111111111111111111111111111111117, objArr11119.length);
                        int length11111111111111111111111111111111111111111111111118 = length11111111111111111111111111111111111111111111111117 + objArr11119.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111111111111111, 0, bArr28, length11111111111111111111111111111111111111111111111118, bArr511111111111111111111111111111111111.length);
                        int length11111111111111111111111111111111111111111111111119 = length11111111111111111111111111111111111111111111111118 + bArr511111111111111111111111111111111111.length;
                        java.lang.System.arraycopy(bArr511111111111111111111111111111111112, 0, bArr28, length11111111111111111111111111111111111111111111111119, bArr511111111111111111111111111111111112.length);
                        int length211111111114 = length11111111111111111111111111111111111111111111111119 + bArr511111111111111111111111111111111112.length;
                        java.lang.System.arraycopy(bArr25, 0, bArr28, length211111111114, bArr25.length);
                        java.lang.System.arraycopy(bArr24, 0, bArr28, length211111111114 + bArr25.length, bArr24.length);
                        int length211111111115 = bArr24.length;
                        i6 = i11111111115;
                        i7 = i8;
                    }
                    return b(bArr28, i7, i6);
                }
                bArr20 = bArr18;
                bArr21 = bArr48;
                bArr22 = oicq.wlogin_sdk.request.t.R;
                if (bArr22 != null) {
                    bArr23 = bArr4;
                } else {
                    bArr23 = bArr4;
                }
                bArr24 = bArr23;
                bArr25 = bArr21;
                bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                if (bArr3 != null) {
                    byte[] bArr511111111111111111111111111111111116 = bArr12;
                    byte[] bArr511111111111111111111111111111111117 = bArr38;
                    byte[] bArr511111111111111111111111111111111118 = bArr17;
                    byte[] bArr511111111111111111111111111111111119 = bArr20;
                    byte[] bArr5111111111111111111111111111111111110 = bArr10;
                    java.lang.Object[] objArr111110 = bArr13;
                    int i11111111117 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length411111111111111111111111111111111111111111113 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr5111111111111111111111111111111111111 = bArr9;
                    byte[] bArr5111111111111111111111111111111111112 = bArr27;
                    bArr28 = new byte[length411111111111111111111111111111111111111111113 + bArr5111111111111111111111111111111111111.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111111111111111111111111111117.length + bArr5111111111111111111111111111111111110.length + bArr511111111111111111111111111111111116.length + objArr111110.length + bArr511111111111111111111111111111111118.length + bArr511111111111111111111111111111111119.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length411111111111111111111111111111111111111111114 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length411111111111111111111111111111111111111111114, bArr30.length);
                    int length411111111111111111111111111111111111111111115 = length411111111111111111111111111111111111111111114 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length411111111111111111111111111111111111111111115, bArr31.length);
                    int length411111111111111111111111111111111111111111116 = length411111111111111111111111111111111111111111115 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111111111111111111111111111111116, bArr6.length);
                    int length411111111111111111111111111111111111111111117 = length411111111111111111111111111111111111111111116 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length411111111111111111111111111111111111111111117, bArr26.length);
                    int length411111111111111111111111111111111111111111118 = length411111111111111111111111111111111111111111117 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length411111111111111111111111111111111111111111118, 0);
                    int i11111111118 = length411111111111111111111111111111111111111111118 + 0;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111111111112, 0, bArr28, i11111111118, bArr5111111111111111111111111111111111112.length);
                    int length411111111111111111111111111111111111111111119 = i11111111118 + bArr5111111111111111111111111111111111112.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111111111111, 0, bArr28, length411111111111111111111111111111111111111111119, bArr5111111111111111111111111111111111111.length);
                    int length4111111111111111111111111111111111111111111110 = length411111111111111111111111111111111111111111119 + bArr5111111111111111111111111111111111111.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111111111111111111111111111111110, bArr33.length);
                    int length4111111111111111111111111111111111111111111111 = length4111111111111111111111111111111111111111111110 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length4111111111111111111111111111111111111111111111, bArr34.length);
                    int length111111111111111111111111111111111111111111111111110 = length4111111111111111111111111111111111111111111111 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111111111111111111111111111111111111111111110, bArr35.length);
                    int length111111111111111111111111111111111111111111111111111 = length111111111111111111111111111111111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111111111111111111111111111111111111111111, bArr36.length);
                    int length111111111111111111111111111111111111111111111111112 = length111111111111111111111111111111111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111111111111111111111111111111111111111111112, bArr37.length);
                    int length111111111111111111111111111111111111111111111111113 = length111111111111111111111111111111111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111111111111111111111111111111111111111111113, bArr7.length);
                    int length111111111111111111111111111111111111111111111111114 = length111111111111111111111111111111111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111111117, 0, bArr28, length111111111111111111111111111111111111111111111111114, bArr511111111111111111111111111111111117.length);
                    int length111111111111111111111111111111111111111111111111115 = length111111111111111111111111111111111111111111111111114 + bArr511111111111111111111111111111111117.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111111111110, 0, bArr28, length111111111111111111111111111111111111111111111111115, bArr5111111111111111111111111111111111110.length);
                    int length111111111111111111111111111111111111111111111111116 = length111111111111111111111111111111111111111111111111115 + bArr5111111111111111111111111111111111110.length;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111111116, 0, bArr28, length111111111111111111111111111111111111111111111111116, bArr511111111111111111111111111111111116.length);
                    int length111111111111111111111111111111111111111111111111117 = length111111111111111111111111111111111111111111111111116 + bArr511111111111111111111111111111111116.length;
                    java.lang.System.arraycopy(objArr111110, 0, bArr28, length111111111111111111111111111111111111111111111111117, objArr111110.length);
                    int length111111111111111111111111111111111111111111111111118 = length111111111111111111111111111111111111111111111111117 + objArr111110.length;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111111118, 0, bArr28, length111111111111111111111111111111111111111111111111118, bArr511111111111111111111111111111111118.length);
                    int length111111111111111111111111111111111111111111111111119 = length111111111111111111111111111111111111111111111111118 + bArr511111111111111111111111111111111118.length;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111111119, 0, bArr28, length111111111111111111111111111111111111111111111111119, bArr511111111111111111111111111111111119.length);
                    int length211111111116 = length111111111111111111111111111111111111111111111111119 + bArr511111111111111111111111111111111119.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length211111111116, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length211111111116 + bArr25.length, bArr24.length);
                    int length211111111117 = bArr24.length;
                    i6 = i11111111117;
                    i7 = i8;
                } else {
                    byte[] bArr5111111111111111111111111111111111113 = bArr12;
                    byte[] bArr5111111111111111111111111111111111114 = bArr38;
                    byte[] bArr5111111111111111111111111111111111115 = bArr17;
                    byte[] bArr5111111111111111111111111111111111116 = bArr20;
                    byte[] bArr5111111111111111111111111111111111117 = bArr10;
                    java.lang.Object[] objArr111111 = bArr13;
                    int i11111111119 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length4111111111111111111111111111111111111111111112 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr5111111111111111111111111111111111118 = bArr9;
                    byte[] bArr5111111111111111111111111111111111119 = bArr27;
                    bArr28 = new byte[length4111111111111111111111111111111111111111111112 + bArr5111111111111111111111111111111111118.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111111111111111111111111111111114.length + bArr5111111111111111111111111111111111117.length + bArr5111111111111111111111111111111111113.length + objArr111111.length + bArr5111111111111111111111111111111111115.length + bArr5111111111111111111111111111111111116.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length4111111111111111111111111111111111111111111113 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111111111111111111111111111111111113, bArr30.length);
                    int length4111111111111111111111111111111111111111111114 = length4111111111111111111111111111111111111111111113 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length4111111111111111111111111111111111111111111114, bArr31.length);
                    int length4111111111111111111111111111111111111111111115 = length4111111111111111111111111111111111111111111114 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length4111111111111111111111111111111111111111111115, bArr6.length);
                    int length4111111111111111111111111111111111111111111116 = length4111111111111111111111111111111111111111111115 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111111111111111111111111111111111116, bArr26.length);
                    int length4111111111111111111111111111111111111111111117 = length4111111111111111111111111111111111111111111116 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length4111111111111111111111111111111111111111111117, 0);
                    int i111111111110 = length4111111111111111111111111111111111111111111117 + 0;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111111111119, 0, bArr28, i111111111110, bArr5111111111111111111111111111111111119.length);
                    int length4111111111111111111111111111111111111111111118 = i111111111110 + bArr5111111111111111111111111111111111119.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111111111118, 0, bArr28, length4111111111111111111111111111111111111111111118, bArr5111111111111111111111111111111111118.length);
                    int length4111111111111111111111111111111111111111111119 = length4111111111111111111111111111111111111111111118 + bArr5111111111111111111111111111111111118.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111111111111111111111111111111119, bArr33.length);
                    int length41111111111111111111111111111111111111111111110 = length4111111111111111111111111111111111111111111119 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111111111111111111111111111111110, bArr34.length);
                    int length1111111111111111111111111111111111111111111111111110 = length41111111111111111111111111111111111111111111110 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111111111111111111111111111111111111111111110, bArr35.length);
                    int length1111111111111111111111111111111111111111111111111111 = length1111111111111111111111111111111111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111111111111111111111111111111111111111111, bArr36.length);
                    int length1111111111111111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111111111111111111111111111111111111111111112, bArr37.length);
                    int length1111111111111111111111111111111111111111111111111113 = length1111111111111111111111111111111111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111111111111111111111111111111111111111111113, bArr7.length);
                    int length1111111111111111111111111111111111111111111111111114 = length1111111111111111111111111111111111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111111111114, 0, bArr28, length1111111111111111111111111111111111111111111111111114, bArr5111111111111111111111111111111111114.length);
                    int length1111111111111111111111111111111111111111111111111115 = length1111111111111111111111111111111111111111111111111114 + bArr5111111111111111111111111111111111114.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111111111117, 0, bArr28, length1111111111111111111111111111111111111111111111111115, bArr5111111111111111111111111111111111117.length);
                    int length1111111111111111111111111111111111111111111111111116 = length1111111111111111111111111111111111111111111111111115 + bArr5111111111111111111111111111111111117.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111111111113, 0, bArr28, length1111111111111111111111111111111111111111111111111116, bArr5111111111111111111111111111111111113.length);
                    int length1111111111111111111111111111111111111111111111111117 = length1111111111111111111111111111111111111111111111111116 + bArr5111111111111111111111111111111111113.length;
                    java.lang.System.arraycopy(objArr111111, 0, bArr28, length1111111111111111111111111111111111111111111111111117, objArr111111.length);
                    int length1111111111111111111111111111111111111111111111111118 = length1111111111111111111111111111111111111111111111111117 + objArr111111.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111111111115, 0, bArr28, length1111111111111111111111111111111111111111111111111118, bArr5111111111111111111111111111111111115.length);
                    int length1111111111111111111111111111111111111111111111111119 = length1111111111111111111111111111111111111111111111111118 + bArr5111111111111111111111111111111111115.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111111111116, 0, bArr28, length1111111111111111111111111111111111111111111111111119, bArr5111111111111111111111111111111111116.length);
                    int length211111111118 = length1111111111111111111111111111111111111111111111111119 + bArr5111111111111111111111111111111111116.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length211111111118, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length211111111118 + bArr25.length, bArr24.length);
                    int length211111111119 = bArr24.length;
                    i6 = i11111111119;
                    i7 = i8;
                }
                return b(bArr28, i7, i6);
            }
            bArr17 = bArr15;
            bArr18 = bArr47;
            bArr19 = oicq.wlogin_sdk.request.l.J;
            if (bArr19 != null) {
                bArr20 = bArr18;
                if (bArr19.length > 0) {
                    bArr10 = bArr10;
                    bArr38 = bArr38;
                    bArr21 = tlv_t201Var.get_tlv_201(bArr19, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                    i5++;
                }
                bArr22 = oicq.wlogin_sdk.request.t.R;
                if (bArr22 != null) {
                    bArr23 = bArr4;
                } else {
                    bArr23 = bArr4;
                }
                bArr24 = bArr23;
                bArr25 = bArr21;
                bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                if (bArr3 != null) {
                    byte[] bArr51111111111111111111111111111111111110 = bArr12;
                    byte[] bArr51111111111111111111111111111111111111 = bArr38;
                    byte[] bArr51111111111111111111111111111111111112 = bArr17;
                    byte[] bArr51111111111111111111111111111111111113 = bArr20;
                    byte[] bArr51111111111111111111111111111111111114 = bArr10;
                    java.lang.Object[] objArr111112 = bArr13;
                    int i111111111111 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length41111111111111111111111111111111111111111111111 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr51111111111111111111111111111111111115 = bArr9;
                    byte[] bArr51111111111111111111111111111111111116 = bArr27;
                    bArr28 = new byte[length41111111111111111111111111111111111111111111111 + bArr51111111111111111111111111111111111115.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111111111111111111111111111111111111.length + bArr51111111111111111111111111111111111114.length + bArr51111111111111111111111111111111111110.length + objArr111112.length + bArr51111111111111111111111111111111111112.length + bArr51111111111111111111111111111111111113.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length41111111111111111111111111111111111111111111112 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length41111111111111111111111111111111111111111111112, bArr30.length);
                    int length41111111111111111111111111111111111111111111113 = length41111111111111111111111111111111111111111111112 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111111111111111111111111111111111113, bArr31.length);
                    int length41111111111111111111111111111111111111111111114 = length41111111111111111111111111111111111111111111113 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length41111111111111111111111111111111111111111111114, bArr6.length);
                    int length41111111111111111111111111111111111111111111115 = length41111111111111111111111111111111111111111111114 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length41111111111111111111111111111111111111111111115, bArr26.length);
                    int length41111111111111111111111111111111111111111111116 = length41111111111111111111111111111111111111111111115 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111111111111111111111111111111111116, 0);
                    int i111111111112 = length41111111111111111111111111111111111111111111116 + 0;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111116, 0, bArr28, i111111111112, bArr51111111111111111111111111111111111116.length);
                    int length41111111111111111111111111111111111111111111117 = i111111111112 + bArr51111111111111111111111111111111111116.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111115, 0, bArr28, length41111111111111111111111111111111111111111111117, bArr51111111111111111111111111111111111115.length);
                    int length41111111111111111111111111111111111111111111118 = length41111111111111111111111111111111111111111111117 + bArr51111111111111111111111111111111111115.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length41111111111111111111111111111111111111111111118, bArr33.length);
                    int length41111111111111111111111111111111111111111111119 = length41111111111111111111111111111111111111111111118 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111111111111111111111111111111119, bArr34.length);
                    int length11111111111111111111111111111111111111111111111111110 = length41111111111111111111111111111111111111111111119 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111111111111111111111111111111111111111111111110, bArr35.length);
                    int length11111111111111111111111111111111111111111111111111111 = length11111111111111111111111111111111111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111111111111111111111111111111111111111111111, bArr36.length);
                    int length11111111111111111111111111111111111111111111111111112 = length11111111111111111111111111111111111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111111111111111111111111111111111111111111111112, bArr37.length);
                    int length11111111111111111111111111111111111111111111111111113 = length11111111111111111111111111111111111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111111111111111111111111111111111111111111111113, bArr7.length);
                    int length11111111111111111111111111111111111111111111111111114 = length11111111111111111111111111111111111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111111, 0, bArr28, length11111111111111111111111111111111111111111111111111114, bArr51111111111111111111111111111111111111.length);
                    int length11111111111111111111111111111111111111111111111111115 = length11111111111111111111111111111111111111111111111111114 + bArr51111111111111111111111111111111111111.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111114, 0, bArr28, length11111111111111111111111111111111111111111111111111115, bArr51111111111111111111111111111111111114.length);
                    int length11111111111111111111111111111111111111111111111111116 = length11111111111111111111111111111111111111111111111111115 + bArr51111111111111111111111111111111111114.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111110, 0, bArr28, length11111111111111111111111111111111111111111111111111116, bArr51111111111111111111111111111111111110.length);
                    int length11111111111111111111111111111111111111111111111111117 = length11111111111111111111111111111111111111111111111111116 + bArr51111111111111111111111111111111111110.length;
                    java.lang.System.arraycopy(objArr111112, 0, bArr28, length11111111111111111111111111111111111111111111111111117, objArr111112.length);
                    int length11111111111111111111111111111111111111111111111111118 = length11111111111111111111111111111111111111111111111111117 + objArr111112.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111112, 0, bArr28, length11111111111111111111111111111111111111111111111111118, bArr51111111111111111111111111111111111112.length);
                    int length11111111111111111111111111111111111111111111111111119 = length11111111111111111111111111111111111111111111111111118 + bArr51111111111111111111111111111111111112.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111113, 0, bArr28, length11111111111111111111111111111111111111111111111111119, bArr51111111111111111111111111111111111113.length);
                    int length2111111111110 = length11111111111111111111111111111111111111111111111111119 + bArr51111111111111111111111111111111111113.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length2111111111110, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length2111111111110 + bArr25.length, bArr24.length);
                    int length2111111111111 = bArr24.length;
                    i6 = i111111111111;
                    i7 = i8;
                } else {
                    byte[] bArr51111111111111111111111111111111111117 = bArr12;
                    byte[] bArr51111111111111111111111111111111111118 = bArr38;
                    byte[] bArr51111111111111111111111111111111111119 = bArr17;
                    byte[] bArr511111111111111111111111111111111111110 = bArr20;
                    byte[] bArr511111111111111111111111111111111111111 = bArr10;
                    java.lang.Object[] objArr111113 = bArr13;
                    int i111111111113 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length411111111111111111111111111111111111111111111110 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr511111111111111111111111111111111111112 = bArr9;
                    byte[] bArr511111111111111111111111111111111111113 = bArr27;
                    bArr28 = new byte[length411111111111111111111111111111111111111111111110 + bArr511111111111111111111111111111111111112.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111111111111111111111111111111111118.length + bArr511111111111111111111111111111111111111.length + bArr51111111111111111111111111111111111117.length + objArr111113.length + bArr51111111111111111111111111111111111119.length + bArr511111111111111111111111111111111111110.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length411111111111111111111111111111111111111111111111 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length411111111111111111111111111111111111111111111111, bArr30.length);
                    int length411111111111111111111111111111111111111111111112 = length411111111111111111111111111111111111111111111111 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length411111111111111111111111111111111111111111111112, bArr31.length);
                    int length411111111111111111111111111111111111111111111113 = length411111111111111111111111111111111111111111111112 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111111111111111111111111111111111113, bArr6.length);
                    int length411111111111111111111111111111111111111111111114 = length411111111111111111111111111111111111111111111113 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length411111111111111111111111111111111111111111111114, bArr26.length);
                    int length411111111111111111111111111111111111111111111115 = length411111111111111111111111111111111111111111111114 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length411111111111111111111111111111111111111111111115, 0);
                    int i111111111114 = length411111111111111111111111111111111111111111111115 + 0;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111111111113, 0, bArr28, i111111111114, bArr511111111111111111111111111111111111113.length);
                    int length411111111111111111111111111111111111111111111116 = i111111111114 + bArr511111111111111111111111111111111111113.length;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111111111112, 0, bArr28, length411111111111111111111111111111111111111111111116, bArr511111111111111111111111111111111111112.length);
                    int length411111111111111111111111111111111111111111111117 = length411111111111111111111111111111111111111111111116 + bArr511111111111111111111111111111111111112.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length411111111111111111111111111111111111111111111117, bArr33.length);
                    int length411111111111111111111111111111111111111111111118 = length411111111111111111111111111111111111111111111117 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length411111111111111111111111111111111111111111111118, bArr34.length);
                    int length111111111111111111111111111111111111111111111111111110 = length411111111111111111111111111111111111111111111118 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111111111111111111111111111111111111111111111110, bArr35.length);
                    int length111111111111111111111111111111111111111111111111111111 = length111111111111111111111111111111111111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111111111111111111111111111111111111111111111, bArr36.length);
                    int length111111111111111111111111111111111111111111111111111112 = length111111111111111111111111111111111111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111111111111111111111111111111111111111111111112, bArr37.length);
                    int length111111111111111111111111111111111111111111111111111113 = length111111111111111111111111111111111111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111111111111111111111111111111111111111111111113, bArr7.length);
                    int length111111111111111111111111111111111111111111111111111114 = length111111111111111111111111111111111111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111118, 0, bArr28, length111111111111111111111111111111111111111111111111111114, bArr51111111111111111111111111111111111118.length);
                    int length111111111111111111111111111111111111111111111111111115 = length111111111111111111111111111111111111111111111111111114 + bArr51111111111111111111111111111111111118.length;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111111111111, 0, bArr28, length111111111111111111111111111111111111111111111111111115, bArr511111111111111111111111111111111111111.length);
                    int length111111111111111111111111111111111111111111111111111116 = length111111111111111111111111111111111111111111111111111115 + bArr511111111111111111111111111111111111111.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111117, 0, bArr28, length111111111111111111111111111111111111111111111111111116, bArr51111111111111111111111111111111111117.length);
                    int length111111111111111111111111111111111111111111111111111117 = length111111111111111111111111111111111111111111111111111116 + bArr51111111111111111111111111111111111117.length;
                    java.lang.System.arraycopy(objArr111113, 0, bArr28, length111111111111111111111111111111111111111111111111111117, objArr111113.length);
                    int length111111111111111111111111111111111111111111111111111118 = length111111111111111111111111111111111111111111111111111117 + objArr111113.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111119, 0, bArr28, length111111111111111111111111111111111111111111111111111118, bArr51111111111111111111111111111111111119.length);
                    int length111111111111111111111111111111111111111111111111111119 = length111111111111111111111111111111111111111111111111111118 + bArr51111111111111111111111111111111111119.length;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111111111110, 0, bArr28, length111111111111111111111111111111111111111111111111111119, bArr511111111111111111111111111111111111110.length);
                    int length2111111111112 = length111111111111111111111111111111111111111111111111111119 + bArr511111111111111111111111111111111111110.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length2111111111112, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length2111111111112 + bArr25.length, bArr24.length);
                    int length2111111111113 = bArr24.length;
                    i6 = i111111111113;
                    i7 = i8;
                }
                return b(bArr28, i7, i6);
            }
            bArr20 = bArr18;
            bArr21 = bArr48;
            bArr22 = oicq.wlogin_sdk.request.t.R;
            if (bArr22 != null) {
                bArr23 = bArr4;
            } else {
                bArr23 = bArr4;
            }
            bArr24 = bArr23;
            bArr25 = bArr21;
            bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
            if (bArr3 != null) {
                byte[] bArr511111111111111111111111111111111111114 = bArr12;
                byte[] bArr511111111111111111111111111111111111115 = bArr38;
                byte[] bArr511111111111111111111111111111111111116 = bArr17;
                byte[] bArr511111111111111111111111111111111111117 = bArr20;
                byte[] bArr511111111111111111111111111111111111118 = bArr10;
                java.lang.Object[] objArr111114 = bArr13;
                int i111111111115 = i5 + 2;
                str = this.x.g;
                if (str != null) {
                    bArr27 = bArr5;
                } else {
                    bArr27 = bArr5;
                }
                int length411111111111111111111111111111111111111111111119 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                byte[] bArr511111111111111111111111111111111111119 = bArr9;
                byte[] bArr5111111111111111111111111111111111111110 = bArr27;
                bArr28 = new byte[length411111111111111111111111111111111111111111111119 + bArr511111111111111111111111111111111111119.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111111111111111111111111111111115.length + bArr511111111111111111111111111111111111118.length + bArr511111111111111111111111111111111111114.length + objArr111114.length + bArr511111111111111111111111111111111111116.length + bArr511111111111111111111111111111111111117.length + bArr25.length + bArr24.length];
                java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                int length4111111111111111111111111111111111111111111111110 = bArr29.length + 0;
                java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111111111111111111111111111111111111110, bArr30.length);
                int length4111111111111111111111111111111111111111111111111 = length4111111111111111111111111111111111111111111111110 + bArr30.length;
                java.lang.System.arraycopy(bArr31, 0, bArr28, length4111111111111111111111111111111111111111111111111, bArr31.length);
                int length4111111111111111111111111111111111111111111111112 = length4111111111111111111111111111111111111111111111111 + bArr31.length;
                java.lang.System.arraycopy(bArr6, 0, bArr28, length4111111111111111111111111111111111111111111111112, bArr6.length);
                int length4111111111111111111111111111111111111111111111113 = length4111111111111111111111111111111111111111111111112 + bArr6.length;
                java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111111111111111111111111111111111111113, bArr26.length);
                int length4111111111111111111111111111111111111111111111114 = length4111111111111111111111111111111111111111111111113 + bArr26.length;
                java.lang.System.arraycopy(bArr41, 0, bArr28, length4111111111111111111111111111111111111111111111114, 0);
                int i111111111116 = length4111111111111111111111111111111111111111111111114 + 0;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111110, 0, bArr28, i111111111116, bArr5111111111111111111111111111111111111110.length);
                int length4111111111111111111111111111111111111111111111115 = i111111111116 + bArr5111111111111111111111111111111111111110.length;
                java.lang.System.arraycopy(bArr511111111111111111111111111111111111119, 0, bArr28, length4111111111111111111111111111111111111111111111115, bArr511111111111111111111111111111111111119.length);
                int length4111111111111111111111111111111111111111111111116 = length4111111111111111111111111111111111111111111111115 + bArr511111111111111111111111111111111111119.length;
                java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111111111111111111111111111111111116, bArr33.length);
                int length4111111111111111111111111111111111111111111111117 = length4111111111111111111111111111111111111111111111116 + bArr33.length;
                java.lang.System.arraycopy(bArr34, 0, bArr28, length4111111111111111111111111111111111111111111111117, bArr34.length);
                int length1111111111111111111111111111111111111111111111111111110 = length4111111111111111111111111111111111111111111111117 + bArr34.length;
                java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111111111111111111111111111111111111111111111110, bArr35.length);
                int length1111111111111111111111111111111111111111111111111111111 = length1111111111111111111111111111111111111111111111111111110 + bArr35.length;
                java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111111111111111111111111111111111111111111111, bArr36.length);
                int length1111111111111111111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111111111111111111 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111111111111111111111111111111111111111111111112, bArr37.length);
                int length1111111111111111111111111111111111111111111111111111113 = length1111111111111111111111111111111111111111111111111111112 + bArr37.length;
                java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111111111111111111111111111111111111111111111113, bArr7.length);
                int length1111111111111111111111111111111111111111111111111111114 = length1111111111111111111111111111111111111111111111111111113 + bArr7.length;
                java.lang.System.arraycopy(bArr511111111111111111111111111111111111115, 0, bArr28, length1111111111111111111111111111111111111111111111111111114, bArr511111111111111111111111111111111111115.length);
                int length1111111111111111111111111111111111111111111111111111115 = length1111111111111111111111111111111111111111111111111111114 + bArr511111111111111111111111111111111111115.length;
                java.lang.System.arraycopy(bArr511111111111111111111111111111111111118, 0, bArr28, length1111111111111111111111111111111111111111111111111111115, bArr511111111111111111111111111111111111118.length);
                int length1111111111111111111111111111111111111111111111111111116 = length1111111111111111111111111111111111111111111111111111115 + bArr511111111111111111111111111111111111118.length;
                java.lang.System.arraycopy(bArr511111111111111111111111111111111111114, 0, bArr28, length1111111111111111111111111111111111111111111111111111116, bArr511111111111111111111111111111111111114.length);
                int length1111111111111111111111111111111111111111111111111111117 = length1111111111111111111111111111111111111111111111111111116 + bArr511111111111111111111111111111111111114.length;
                java.lang.System.arraycopy(objArr111114, 0, bArr28, length1111111111111111111111111111111111111111111111111111117, objArr111114.length);
                int length1111111111111111111111111111111111111111111111111111118 = length1111111111111111111111111111111111111111111111111111117 + objArr111114.length;
                java.lang.System.arraycopy(bArr511111111111111111111111111111111111116, 0, bArr28, length1111111111111111111111111111111111111111111111111111118, bArr511111111111111111111111111111111111116.length);
                int length1111111111111111111111111111111111111111111111111111119 = length1111111111111111111111111111111111111111111111111111118 + bArr511111111111111111111111111111111111116.length;
                java.lang.System.arraycopy(bArr511111111111111111111111111111111111117, 0, bArr28, length1111111111111111111111111111111111111111111111111111119, bArr511111111111111111111111111111111111117.length);
                int length2111111111114 = length1111111111111111111111111111111111111111111111111111119 + bArr511111111111111111111111111111111111117.length;
                java.lang.System.arraycopy(bArr25, 0, bArr28, length2111111111114, bArr25.length);
                java.lang.System.arraycopy(bArr24, 0, bArr28, length2111111111114 + bArr25.length, bArr24.length);
                int length2111111111115 = bArr24.length;
                i6 = i111111111115;
                i7 = i8;
            } else {
                byte[] bArr5111111111111111111111111111111111111111 = bArr12;
                byte[] bArr5111111111111111111111111111111111111112 = bArr38;
                byte[] bArr5111111111111111111111111111111111111113 = bArr17;
                byte[] bArr5111111111111111111111111111111111111114 = bArr20;
                byte[] bArr5111111111111111111111111111111111111115 = bArr10;
                java.lang.Object[] objArr111115 = bArr13;
                int i111111111117 = i5 + 2;
                str = this.x.g;
                if (str != null) {
                    bArr27 = bArr5;
                } else {
                    bArr27 = bArr5;
                }
                int length4111111111111111111111111111111111111111111111118 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                byte[] bArr5111111111111111111111111111111111111116 = bArr9;
                byte[] bArr5111111111111111111111111111111111111117 = bArr27;
                bArr28 = new byte[length4111111111111111111111111111111111111111111111118 + bArr5111111111111111111111111111111111111116.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111111111111111111111111111111111112.length + bArr5111111111111111111111111111111111111115.length + bArr5111111111111111111111111111111111111111.length + objArr111115.length + bArr5111111111111111111111111111111111111113.length + bArr5111111111111111111111111111111111111114.length + bArr25.length + bArr24.length];
                java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                int length4111111111111111111111111111111111111111111111119 = bArr29.length + 0;
                java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111111111111111111111111111111111111119, bArr30.length);
                int length41111111111111111111111111111111111111111111111110 = length4111111111111111111111111111111111111111111111119 + bArr30.length;
                java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111111111111111111111111111111111111110, bArr31.length);
                int length41111111111111111111111111111111111111111111111111 = length41111111111111111111111111111111111111111111111110 + bArr31.length;
                java.lang.System.arraycopy(bArr6, 0, bArr28, length41111111111111111111111111111111111111111111111111, bArr6.length);
                int length41111111111111111111111111111111111111111111111112 = length41111111111111111111111111111111111111111111111111 + bArr6.length;
                java.lang.System.arraycopy(bArr26, 0, bArr28, length41111111111111111111111111111111111111111111111112, bArr26.length);
                int length41111111111111111111111111111111111111111111111113 = length41111111111111111111111111111111111111111111111112 + bArr26.length;
                java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111111111111111111111111111111111111113, 0);
                int i111111111118 = length41111111111111111111111111111111111111111111111113 + 0;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111117, 0, bArr28, i111111111118, bArr5111111111111111111111111111111111111117.length);
                int length41111111111111111111111111111111111111111111111114 = i111111111118 + bArr5111111111111111111111111111111111111117.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111116, 0, bArr28, length41111111111111111111111111111111111111111111111114, bArr5111111111111111111111111111111111111116.length);
                int length41111111111111111111111111111111111111111111111115 = length41111111111111111111111111111111111111111111111114 + bArr5111111111111111111111111111111111111116.length;
                java.lang.System.arraycopy(bArr33, 0, bArr28, length41111111111111111111111111111111111111111111111115, bArr33.length);
                int length41111111111111111111111111111111111111111111111116 = length41111111111111111111111111111111111111111111111115 + bArr33.length;
                java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111111111111111111111111111111111116, bArr34.length);
                int length11111111111111111111111111111111111111111111111111111110 = length41111111111111111111111111111111111111111111111116 + bArr34.length;
                java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111111111111111111111111111111111111111111111111110, bArr35.length);
                int length11111111111111111111111111111111111111111111111111111111 = length11111111111111111111111111111111111111111111111111111110 + bArr35.length;
                java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111111111111111111111111111111111111111111111111, bArr36.length);
                int length11111111111111111111111111111111111111111111111111111112 = length11111111111111111111111111111111111111111111111111111111 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111111111111111111111111111111111111111111111111112, bArr37.length);
                int length11111111111111111111111111111111111111111111111111111113 = length11111111111111111111111111111111111111111111111111111112 + bArr37.length;
                java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111111111111111111111111111111111111111111111111113, bArr7.length);
                int length11111111111111111111111111111111111111111111111111111114 = length11111111111111111111111111111111111111111111111111111113 + bArr7.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111112, 0, bArr28, length11111111111111111111111111111111111111111111111111111114, bArr5111111111111111111111111111111111111112.length);
                int length11111111111111111111111111111111111111111111111111111115 = length11111111111111111111111111111111111111111111111111111114 + bArr5111111111111111111111111111111111111112.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111115, 0, bArr28, length11111111111111111111111111111111111111111111111111111115, bArr5111111111111111111111111111111111111115.length);
                int length11111111111111111111111111111111111111111111111111111116 = length11111111111111111111111111111111111111111111111111111115 + bArr5111111111111111111111111111111111111115.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111111, 0, bArr28, length11111111111111111111111111111111111111111111111111111116, bArr5111111111111111111111111111111111111111.length);
                int length11111111111111111111111111111111111111111111111111111117 = length11111111111111111111111111111111111111111111111111111116 + bArr5111111111111111111111111111111111111111.length;
                java.lang.System.arraycopy(objArr111115, 0, bArr28, length11111111111111111111111111111111111111111111111111111117, objArr111115.length);
                int length11111111111111111111111111111111111111111111111111111118 = length11111111111111111111111111111111111111111111111111111117 + objArr111115.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111113, 0, bArr28, length11111111111111111111111111111111111111111111111111111118, bArr5111111111111111111111111111111111111113.length);
                int length11111111111111111111111111111111111111111111111111111119 = length11111111111111111111111111111111111111111111111111111118 + bArr5111111111111111111111111111111111111113.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111114, 0, bArr28, length11111111111111111111111111111111111111111111111111111119, bArr5111111111111111111111111111111111111114.length);
                int length2111111111116 = length11111111111111111111111111111111111111111111111111111119 + bArr5111111111111111111111111111111111111114.length;
                java.lang.System.arraycopy(bArr25, 0, bArr28, length2111111111116, bArr25.length);
                java.lang.System.arraycopy(bArr24, 0, bArr28, length2111111111116 + bArr25.length, bArr24.length);
                int length2111111111117 = bArr24.length;
                i6 = i111111111117;
                i7 = i8;
            }
            return b(bArr28, i7, i6);
        }
        bArr12 = bArr39;
        bArr13 = bArr45;
        bArr14 = oicq.wlogin_sdk.request.t.O;
        if (bArr14 != null) {
            bArr15 = bArr46;
        } else {
            bArr15 = bArr46;
        }
        bArr16 = oicq.wlogin_sdk.request.t.L;
        if (bArr16 != null) {
            bArr17 = bArr15;
            if (bArr16.length > 0) {
                bArr18 = tlv_t194Var.get_tlv_194(bArr16);
                i5++;
            }
            bArr19 = oicq.wlogin_sdk.request.l.J;
            if (bArr19 != null) {
                bArr20 = bArr18;
                if (bArr19.length > 0) {
                    bArr10 = bArr10;
                    bArr38 = bArr38;
                    bArr21 = tlv_t201Var.get_tlv_201(bArr19, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                    i5++;
                }
                bArr22 = oicq.wlogin_sdk.request.t.R;
                if (bArr22 != null) {
                    bArr23 = bArr4;
                } else {
                    bArr23 = bArr4;
                }
                bArr24 = bArr23;
                bArr25 = bArr21;
                bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
                if (bArr3 != null) {
                    byte[] bArr5111111111111111111111111111111111111118 = bArr12;
                    byte[] bArr5111111111111111111111111111111111111119 = bArr38;
                    byte[] bArr51111111111111111111111111111111111111110 = bArr17;
                    byte[] bArr51111111111111111111111111111111111111111 = bArr20;
                    byte[] bArr51111111111111111111111111111111111111112 = bArr10;
                    java.lang.Object[] objArr111116 = bArr13;
                    int i111111111119 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length41111111111111111111111111111111111111111111111117 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr51111111111111111111111111111111111111113 = bArr9;
                    byte[] bArr51111111111111111111111111111111111111114 = bArr27;
                    bArr28 = new byte[length41111111111111111111111111111111111111111111111117 + bArr51111111111111111111111111111111111111113.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111111111111111111111111111111111119.length + bArr51111111111111111111111111111111111111112.length + bArr5111111111111111111111111111111111111118.length + objArr111116.length + bArr51111111111111111111111111111111111111110.length + bArr51111111111111111111111111111111111111111.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length41111111111111111111111111111111111111111111111118 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length41111111111111111111111111111111111111111111111118, bArr30.length);
                    int length41111111111111111111111111111111111111111111111119 = length41111111111111111111111111111111111111111111111118 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111111111111111111111111111111111111119, bArr31.length);
                    int length411111111111111111111111111111111111111111111111110 = length41111111111111111111111111111111111111111111111119 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111111111111111111111111111111111111110, bArr6.length);
                    int length411111111111111111111111111111111111111111111111111 = length411111111111111111111111111111111111111111111111110 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length411111111111111111111111111111111111111111111111111, bArr26.length);
                    int length411111111111111111111111111111111111111111111111112 = length411111111111111111111111111111111111111111111111111 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length411111111111111111111111111111111111111111111111112, 0);
                    int i1111111111110 = length411111111111111111111111111111111111111111111111112 + 0;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111111114, 0, bArr28, i1111111111110, bArr51111111111111111111111111111111111111114.length);
                    int length411111111111111111111111111111111111111111111111113 = i1111111111110 + bArr51111111111111111111111111111111111111114.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111111113, 0, bArr28, length411111111111111111111111111111111111111111111111113, bArr51111111111111111111111111111111111111113.length);
                    int length411111111111111111111111111111111111111111111111114 = length411111111111111111111111111111111111111111111111113 + bArr51111111111111111111111111111111111111113.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length411111111111111111111111111111111111111111111111114, bArr33.length);
                    int length411111111111111111111111111111111111111111111111115 = length411111111111111111111111111111111111111111111111114 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length411111111111111111111111111111111111111111111111115, bArr34.length);
                    int length111111111111111111111111111111111111111111111111111111110 = length411111111111111111111111111111111111111111111111115 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111111111111111111111111111111111111111111111111110, bArr35.length);
                    int length111111111111111111111111111111111111111111111111111111111 = length111111111111111111111111111111111111111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111111111111111111111111111111111111111111111111, bArr36.length);
                    int length111111111111111111111111111111111111111111111111111111112 = length111111111111111111111111111111111111111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111111111111111111111111111111111111111111111111112, bArr37.length);
                    int length111111111111111111111111111111111111111111111111111111113 = length111111111111111111111111111111111111111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111111111111111111111111111111111111111111111111113, bArr7.length);
                    int length111111111111111111111111111111111111111111111111111111114 = length111111111111111111111111111111111111111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111111111111119, 0, bArr28, length111111111111111111111111111111111111111111111111111111114, bArr5111111111111111111111111111111111111119.length);
                    int length111111111111111111111111111111111111111111111111111111115 = length111111111111111111111111111111111111111111111111111111114 + bArr5111111111111111111111111111111111111119.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111111112, 0, bArr28, length111111111111111111111111111111111111111111111111111111115, bArr51111111111111111111111111111111111111112.length);
                    int length111111111111111111111111111111111111111111111111111111116 = length111111111111111111111111111111111111111111111111111111115 + bArr51111111111111111111111111111111111111112.length;
                    java.lang.System.arraycopy(bArr5111111111111111111111111111111111111118, 0, bArr28, length111111111111111111111111111111111111111111111111111111116, bArr5111111111111111111111111111111111111118.length);
                    int length111111111111111111111111111111111111111111111111111111117 = length111111111111111111111111111111111111111111111111111111116 + bArr5111111111111111111111111111111111111118.length;
                    java.lang.System.arraycopy(objArr111116, 0, bArr28, length111111111111111111111111111111111111111111111111111111117, objArr111116.length);
                    int length111111111111111111111111111111111111111111111111111111118 = length111111111111111111111111111111111111111111111111111111117 + objArr111116.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111111110, 0, bArr28, length111111111111111111111111111111111111111111111111111111118, bArr51111111111111111111111111111111111111110.length);
                    int length111111111111111111111111111111111111111111111111111111119 = length111111111111111111111111111111111111111111111111111111118 + bArr51111111111111111111111111111111111111110.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111111111, 0, bArr28, length111111111111111111111111111111111111111111111111111111119, bArr51111111111111111111111111111111111111111.length);
                    int length2111111111118 = length111111111111111111111111111111111111111111111111111111119 + bArr51111111111111111111111111111111111111111.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length2111111111118, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length2111111111118 + bArr25.length, bArr24.length);
                    int length2111111111119 = bArr24.length;
                    i6 = i111111111119;
                    i7 = i8;
                } else {
                    byte[] bArr51111111111111111111111111111111111111115 = bArr12;
                    byte[] bArr51111111111111111111111111111111111111116 = bArr38;
                    byte[] bArr51111111111111111111111111111111111111117 = bArr17;
                    byte[] bArr51111111111111111111111111111111111111118 = bArr20;
                    byte[] bArr51111111111111111111111111111111111111119 = bArr10;
                    java.lang.Object[] objArr111117 = bArr13;
                    int i1111111111111 = i5 + 2;
                    str = this.x.g;
                    if (str != null) {
                        bArr27 = bArr5;
                    } else {
                        bArr27 = bArr5;
                    }
                    int length411111111111111111111111111111111111111111111111116 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                    byte[] bArr511111111111111111111111111111111111111110 = bArr9;
                    byte[] bArr511111111111111111111111111111111111111111 = bArr27;
                    bArr28 = new byte[length411111111111111111111111111111111111111111111111116 + bArr511111111111111111111111111111111111111110.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111111111111111111111111111111111111116.length + bArr51111111111111111111111111111111111111119.length + bArr51111111111111111111111111111111111111115.length + objArr111117.length + bArr51111111111111111111111111111111111111117.length + bArr51111111111111111111111111111111111111118.length + bArr25.length + bArr24.length];
                    java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                    int length411111111111111111111111111111111111111111111111117 = bArr29.length + 0;
                    java.lang.System.arraycopy(bArr30, 0, bArr28, length411111111111111111111111111111111111111111111111117, bArr30.length);
                    int length411111111111111111111111111111111111111111111111118 = length411111111111111111111111111111111111111111111111117 + bArr30.length;
                    java.lang.System.arraycopy(bArr31, 0, bArr28, length411111111111111111111111111111111111111111111111118, bArr31.length);
                    int length411111111111111111111111111111111111111111111111119 = length411111111111111111111111111111111111111111111111118 + bArr31.length;
                    java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111111111111111111111111111111111111119, bArr6.length);
                    int length4111111111111111111111111111111111111111111111111110 = length411111111111111111111111111111111111111111111111119 + bArr6.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111111111111111111111111111111111111111110, bArr26.length);
                    int length4111111111111111111111111111111111111111111111111111 = length4111111111111111111111111111111111111111111111111110 + bArr26.length;
                    java.lang.System.arraycopy(bArr41, 0, bArr28, length4111111111111111111111111111111111111111111111111111, 0);
                    int i1111111111112 = length4111111111111111111111111111111111111111111111111111 + 0;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111111111111111, 0, bArr28, i1111111111112, bArr511111111111111111111111111111111111111111.length);
                    int length4111111111111111111111111111111111111111111111111112 = i1111111111112 + bArr511111111111111111111111111111111111111111.length;
                    java.lang.System.arraycopy(bArr511111111111111111111111111111111111111110, 0, bArr28, length4111111111111111111111111111111111111111111111111112, bArr511111111111111111111111111111111111111110.length);
                    int length4111111111111111111111111111111111111111111111111113 = length4111111111111111111111111111111111111111111111111112 + bArr511111111111111111111111111111111111111110.length;
                    java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111111111111111111111111111111111111113, bArr33.length);
                    int length4111111111111111111111111111111111111111111111111114 = length4111111111111111111111111111111111111111111111111113 + bArr33.length;
                    java.lang.System.arraycopy(bArr34, 0, bArr28, length4111111111111111111111111111111111111111111111111114, bArr34.length);
                    int length1111111111111111111111111111111111111111111111111111111110 = length4111111111111111111111111111111111111111111111111114 + bArr34.length;
                    java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111111111111111111111111111111111111111111111111110, bArr35.length);
                    int length1111111111111111111111111111111111111111111111111111111111 = length1111111111111111111111111111111111111111111111111111111110 + bArr35.length;
                    java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111, bArr36.length);
                    int length1111111111111111111111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111111111111111111111 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111111111111111111111111111111111111111111111111112, bArr37.length);
                    int length1111111111111111111111111111111111111111111111111111111113 = length1111111111111111111111111111111111111111111111111111111112 + bArr37.length;
                    java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111111111111111111111111111111111111111111111111113, bArr7.length);
                    int length1111111111111111111111111111111111111111111111111111111114 = length1111111111111111111111111111111111111111111111111111111113 + bArr7.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111111116, 0, bArr28, length1111111111111111111111111111111111111111111111111111111114, bArr51111111111111111111111111111111111111116.length);
                    int length1111111111111111111111111111111111111111111111111111111115 = length1111111111111111111111111111111111111111111111111111111114 + bArr51111111111111111111111111111111111111116.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111111119, 0, bArr28, length1111111111111111111111111111111111111111111111111111111115, bArr51111111111111111111111111111111111111119.length);
                    int length1111111111111111111111111111111111111111111111111111111116 = length1111111111111111111111111111111111111111111111111111111115 + bArr51111111111111111111111111111111111111119.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111111115, 0, bArr28, length1111111111111111111111111111111111111111111111111111111116, bArr51111111111111111111111111111111111111115.length);
                    int length1111111111111111111111111111111111111111111111111111111117 = length1111111111111111111111111111111111111111111111111111111116 + bArr51111111111111111111111111111111111111115.length;
                    java.lang.System.arraycopy(objArr111117, 0, bArr28, length1111111111111111111111111111111111111111111111111111111117, objArr111117.length);
                    int length1111111111111111111111111111111111111111111111111111111118 = length1111111111111111111111111111111111111111111111111111111117 + objArr111117.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111111117, 0, bArr28, length1111111111111111111111111111111111111111111111111111111118, bArr51111111111111111111111111111111111111117.length);
                    int length1111111111111111111111111111111111111111111111111111111119 = length1111111111111111111111111111111111111111111111111111111118 + bArr51111111111111111111111111111111111111117.length;
                    java.lang.System.arraycopy(bArr51111111111111111111111111111111111111118, 0, bArr28, length1111111111111111111111111111111111111111111111111111111119, bArr51111111111111111111111111111111111111118.length);
                    int length21111111111110 = length1111111111111111111111111111111111111111111111111111111119 + bArr51111111111111111111111111111111111111118.length;
                    java.lang.System.arraycopy(bArr25, 0, bArr28, length21111111111110, bArr25.length);
                    java.lang.System.arraycopy(bArr24, 0, bArr28, length21111111111110 + bArr25.length, bArr24.length);
                    int length21111111111111 = bArr24.length;
                    i6 = i1111111111111;
                    i7 = i8;
                }
                return b(bArr28, i7, i6);
            }
            bArr20 = bArr18;
            bArr21 = bArr48;
            bArr22 = oicq.wlogin_sdk.request.t.R;
            if (bArr22 != null) {
                bArr23 = bArr4;
            } else {
                bArr23 = bArr4;
            }
            bArr24 = bArr23;
            bArr25 = bArr21;
            bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
            if (bArr3 != null) {
                byte[] bArr511111111111111111111111111111111111111112 = bArr12;
                byte[] bArr511111111111111111111111111111111111111113 = bArr38;
                byte[] bArr511111111111111111111111111111111111111114 = bArr17;
                byte[] bArr511111111111111111111111111111111111111115 = bArr20;
                byte[] bArr511111111111111111111111111111111111111116 = bArr10;
                java.lang.Object[] objArr111118 = bArr13;
                int i1111111111113 = i5 + 2;
                str = this.x.g;
                if (str != null) {
                    bArr27 = bArr5;
                } else {
                    bArr27 = bArr5;
                }
                int length4111111111111111111111111111111111111111111111111115 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                byte[] bArr511111111111111111111111111111111111111117 = bArr9;
                byte[] bArr511111111111111111111111111111111111111118 = bArr27;
                bArr28 = new byte[length4111111111111111111111111111111111111111111111111115 + bArr511111111111111111111111111111111111111117.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111111111111111111111111111111111113.length + bArr511111111111111111111111111111111111111116.length + bArr511111111111111111111111111111111111111112.length + objArr111118.length + bArr511111111111111111111111111111111111111114.length + bArr511111111111111111111111111111111111111115.length + bArr25.length + bArr24.length];
                java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                int length4111111111111111111111111111111111111111111111111116 = bArr29.length + 0;
                java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111111111111111111111111111111111111111116, bArr30.length);
                int length4111111111111111111111111111111111111111111111111117 = length4111111111111111111111111111111111111111111111111116 + bArr30.length;
                java.lang.System.arraycopy(bArr31, 0, bArr28, length4111111111111111111111111111111111111111111111111117, bArr31.length);
                int length4111111111111111111111111111111111111111111111111118 = length4111111111111111111111111111111111111111111111111117 + bArr31.length;
                java.lang.System.arraycopy(bArr6, 0, bArr28, length4111111111111111111111111111111111111111111111111118, bArr6.length);
                int length4111111111111111111111111111111111111111111111111119 = length4111111111111111111111111111111111111111111111111118 + bArr6.length;
                java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111111111111111111111111111111111111111119, bArr26.length);
                int length41111111111111111111111111111111111111111111111111110 = length4111111111111111111111111111111111111111111111111119 + bArr26.length;
                java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111111111111111111111111111111111111111110, 0);
                int i1111111111114 = length41111111111111111111111111111111111111111111111111110 + 0;
                java.lang.System.arraycopy(bArr511111111111111111111111111111111111111118, 0, bArr28, i1111111111114, bArr511111111111111111111111111111111111111118.length);
                int length41111111111111111111111111111111111111111111111111111 = i1111111111114 + bArr511111111111111111111111111111111111111118.length;
                java.lang.System.arraycopy(bArr511111111111111111111111111111111111111117, 0, bArr28, length41111111111111111111111111111111111111111111111111111, bArr511111111111111111111111111111111111111117.length);
                int length41111111111111111111111111111111111111111111111111112 = length41111111111111111111111111111111111111111111111111111 + bArr511111111111111111111111111111111111111117.length;
                java.lang.System.arraycopy(bArr33, 0, bArr28, length41111111111111111111111111111111111111111111111111112, bArr33.length);
                int length41111111111111111111111111111111111111111111111111113 = length41111111111111111111111111111111111111111111111111112 + bArr33.length;
                java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111111111111111111111111111111111111113, bArr34.length);
                int length11111111111111111111111111111111111111111111111111111111110 = length41111111111111111111111111111111111111111111111111113 + bArr34.length;
                java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111111111111111111111111111111111111111111111111111110, bArr35.length);
                int length11111111111111111111111111111111111111111111111111111111111 = length11111111111111111111111111111111111111111111111111111111110 + bArr35.length;
                java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111111111111111111111111111111111111111111111111111, bArr36.length);
                int length11111111111111111111111111111111111111111111111111111111112 = length11111111111111111111111111111111111111111111111111111111111 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111111111111111111111111111111111111111111111111111112, bArr37.length);
                int length11111111111111111111111111111111111111111111111111111111113 = length11111111111111111111111111111111111111111111111111111111112 + bArr37.length;
                java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111111111111111111111111111111111111111111111111111113, bArr7.length);
                int length11111111111111111111111111111111111111111111111111111111114 = length11111111111111111111111111111111111111111111111111111111113 + bArr7.length;
                java.lang.System.arraycopy(bArr511111111111111111111111111111111111111113, 0, bArr28, length11111111111111111111111111111111111111111111111111111111114, bArr511111111111111111111111111111111111111113.length);
                int length11111111111111111111111111111111111111111111111111111111115 = length11111111111111111111111111111111111111111111111111111111114 + bArr511111111111111111111111111111111111111113.length;
                java.lang.System.arraycopy(bArr511111111111111111111111111111111111111116, 0, bArr28, length11111111111111111111111111111111111111111111111111111111115, bArr511111111111111111111111111111111111111116.length);
                int length11111111111111111111111111111111111111111111111111111111116 = length11111111111111111111111111111111111111111111111111111111115 + bArr511111111111111111111111111111111111111116.length;
                java.lang.System.arraycopy(bArr511111111111111111111111111111111111111112, 0, bArr28, length11111111111111111111111111111111111111111111111111111111116, bArr511111111111111111111111111111111111111112.length);
                int length11111111111111111111111111111111111111111111111111111111117 = length11111111111111111111111111111111111111111111111111111111116 + bArr511111111111111111111111111111111111111112.length;
                java.lang.System.arraycopy(objArr111118, 0, bArr28, length11111111111111111111111111111111111111111111111111111111117, objArr111118.length);
                int length11111111111111111111111111111111111111111111111111111111118 = length11111111111111111111111111111111111111111111111111111111117 + objArr111118.length;
                java.lang.System.arraycopy(bArr511111111111111111111111111111111111111114, 0, bArr28, length11111111111111111111111111111111111111111111111111111111118, bArr511111111111111111111111111111111111111114.length);
                int length11111111111111111111111111111111111111111111111111111111119 = length11111111111111111111111111111111111111111111111111111111118 + bArr511111111111111111111111111111111111111114.length;
                java.lang.System.arraycopy(bArr511111111111111111111111111111111111111115, 0, bArr28, length11111111111111111111111111111111111111111111111111111111119, bArr511111111111111111111111111111111111111115.length);
                int length21111111111112 = length11111111111111111111111111111111111111111111111111111111119 + bArr511111111111111111111111111111111111111115.length;
                java.lang.System.arraycopy(bArr25, 0, bArr28, length21111111111112, bArr25.length);
                java.lang.System.arraycopy(bArr24, 0, bArr28, length21111111111112 + bArr25.length, bArr24.length);
                int length21111111111113 = bArr24.length;
                i6 = i1111111111113;
                i7 = i8;
            } else {
                byte[] bArr511111111111111111111111111111111111111119 = bArr12;
                byte[] bArr5111111111111111111111111111111111111111110 = bArr38;
                byte[] bArr5111111111111111111111111111111111111111111 = bArr17;
                byte[] bArr5111111111111111111111111111111111111111112 = bArr20;
                byte[] bArr5111111111111111111111111111111111111111113 = bArr10;
                java.lang.Object[] objArr111119 = bArr13;
                int i1111111111115 = i5 + 2;
                str = this.x.g;
                if (str != null) {
                    bArr27 = bArr5;
                } else {
                    bArr27 = bArr5;
                }
                int length41111111111111111111111111111111111111111111111111114 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                byte[] bArr5111111111111111111111111111111111111111114 = bArr9;
                byte[] bArr5111111111111111111111111111111111111111115 = bArr27;
                bArr28 = new byte[length41111111111111111111111111111111111111111111111111114 + bArr5111111111111111111111111111111111111111114.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111111111111111111111111111111111111110.length + bArr5111111111111111111111111111111111111111113.length + bArr511111111111111111111111111111111111111119.length + objArr111119.length + bArr5111111111111111111111111111111111111111111.length + bArr5111111111111111111111111111111111111111112.length + bArr25.length + bArr24.length];
                java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                int length41111111111111111111111111111111111111111111111111115 = bArr29.length + 0;
                java.lang.System.arraycopy(bArr30, 0, bArr28, length41111111111111111111111111111111111111111111111111115, bArr30.length);
                int length41111111111111111111111111111111111111111111111111116 = length41111111111111111111111111111111111111111111111111115 + bArr30.length;
                java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111111111111111111111111111111111111111116, bArr31.length);
                int length41111111111111111111111111111111111111111111111111117 = length41111111111111111111111111111111111111111111111111116 + bArr31.length;
                java.lang.System.arraycopy(bArr6, 0, bArr28, length41111111111111111111111111111111111111111111111111117, bArr6.length);
                int length41111111111111111111111111111111111111111111111111118 = length41111111111111111111111111111111111111111111111111117 + bArr6.length;
                java.lang.System.arraycopy(bArr26, 0, bArr28, length41111111111111111111111111111111111111111111111111118, bArr26.length);
                int length41111111111111111111111111111111111111111111111111119 = length41111111111111111111111111111111111111111111111111118 + bArr26.length;
                java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111111111111111111111111111111111111111119, 0);
                int i1111111111116 = length41111111111111111111111111111111111111111111111111119 + 0;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111111115, 0, bArr28, i1111111111116, bArr5111111111111111111111111111111111111111115.length);
                int length411111111111111111111111111111111111111111111111111110 = i1111111111116 + bArr5111111111111111111111111111111111111111115.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111111114, 0, bArr28, length411111111111111111111111111111111111111111111111111110, bArr5111111111111111111111111111111111111111114.length);
                int length411111111111111111111111111111111111111111111111111111 = length411111111111111111111111111111111111111111111111111110 + bArr5111111111111111111111111111111111111111114.length;
                java.lang.System.arraycopy(bArr33, 0, bArr28, length411111111111111111111111111111111111111111111111111111, bArr33.length);
                int length411111111111111111111111111111111111111111111111111112 = length411111111111111111111111111111111111111111111111111111 + bArr33.length;
                java.lang.System.arraycopy(bArr34, 0, bArr28, length411111111111111111111111111111111111111111111111111112, bArr34.length);
                int length111111111111111111111111111111111111111111111111111111111110 = length411111111111111111111111111111111111111111111111111112 + bArr34.length;
                java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111111111111111111111111111111111111111111111111111110, bArr35.length);
                int length111111111111111111111111111111111111111111111111111111111111 = length111111111111111111111111111111111111111111111111111111111110 + bArr35.length;
                java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111111111111111111111111111111111111111111111111111, bArr36.length);
                int length111111111111111111111111111111111111111111111111111111111112 = length111111111111111111111111111111111111111111111111111111111111 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111111111111111111111111111111111111111111111111111112, bArr37.length);
                int length111111111111111111111111111111111111111111111111111111111113 = length111111111111111111111111111111111111111111111111111111111112 + bArr37.length;
                java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111111111111111111111111111111111111111111111111111113, bArr7.length);
                int length111111111111111111111111111111111111111111111111111111111114 = length111111111111111111111111111111111111111111111111111111111113 + bArr7.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111111110, 0, bArr28, length111111111111111111111111111111111111111111111111111111111114, bArr5111111111111111111111111111111111111111110.length);
                int length111111111111111111111111111111111111111111111111111111111115 = length111111111111111111111111111111111111111111111111111111111114 + bArr5111111111111111111111111111111111111111110.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111111113, 0, bArr28, length111111111111111111111111111111111111111111111111111111111115, bArr5111111111111111111111111111111111111111113.length);
                int length111111111111111111111111111111111111111111111111111111111116 = length111111111111111111111111111111111111111111111111111111111115 + bArr5111111111111111111111111111111111111111113.length;
                java.lang.System.arraycopy(bArr511111111111111111111111111111111111111119, 0, bArr28, length111111111111111111111111111111111111111111111111111111111116, bArr511111111111111111111111111111111111111119.length);
                int length111111111111111111111111111111111111111111111111111111111117 = length111111111111111111111111111111111111111111111111111111111116 + bArr511111111111111111111111111111111111111119.length;
                java.lang.System.arraycopy(objArr111119, 0, bArr28, length111111111111111111111111111111111111111111111111111111111117, objArr111119.length);
                int length111111111111111111111111111111111111111111111111111111111118 = length111111111111111111111111111111111111111111111111111111111117 + objArr111119.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111111111, 0, bArr28, length111111111111111111111111111111111111111111111111111111111118, bArr5111111111111111111111111111111111111111111.length);
                int length111111111111111111111111111111111111111111111111111111111119 = length111111111111111111111111111111111111111111111111111111111118 + bArr5111111111111111111111111111111111111111111.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111111112, 0, bArr28, length111111111111111111111111111111111111111111111111111111111119, bArr5111111111111111111111111111111111111111112.length);
                int length21111111111114 = length111111111111111111111111111111111111111111111111111111111119 + bArr5111111111111111111111111111111111111111112.length;
                java.lang.System.arraycopy(bArr25, 0, bArr28, length21111111111114, bArr25.length);
                java.lang.System.arraycopy(bArr24, 0, bArr28, length21111111111114 + bArr25.length, bArr24.length);
                int length21111111111115 = bArr24.length;
                i6 = i1111111111115;
                i7 = i8;
            }
            return b(bArr28, i7, i6);
        }
        bArr17 = bArr15;
        bArr18 = bArr47;
        bArr19 = oicq.wlogin_sdk.request.l.J;
        if (bArr19 != null) {
            bArr20 = bArr18;
            if (bArr19.length > 0) {
                bArr10 = bArr10;
                bArr38 = bArr38;
                bArr21 = tlv_t201Var.get_tlv_201(bArr19, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                i5++;
            }
            bArr22 = oicq.wlogin_sdk.request.t.R;
            if (bArr22 != null) {
                bArr23 = bArr4;
            } else {
                bArr23 = bArr4;
            }
            bArr24 = bArr23;
            bArr25 = bArr21;
            bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
            if (bArr3 != null) {
                byte[] bArr5111111111111111111111111111111111111111116 = bArr12;
                byte[] bArr5111111111111111111111111111111111111111117 = bArr38;
                byte[] bArr5111111111111111111111111111111111111111118 = bArr17;
                byte[] bArr5111111111111111111111111111111111111111119 = bArr20;
                byte[] bArr51111111111111111111111111111111111111111110 = bArr10;
                java.lang.Object[] objArr1111110 = bArr13;
                int i1111111111117 = i5 + 2;
                str = this.x.g;
                if (str != null) {
                    bArr27 = bArr5;
                } else {
                    bArr27 = bArr5;
                }
                int length411111111111111111111111111111111111111111111111111113 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                byte[] bArr51111111111111111111111111111111111111111111 = bArr9;
                byte[] bArr51111111111111111111111111111111111111111112 = bArr27;
                bArr28 = new byte[length411111111111111111111111111111111111111111111111111113 + bArr51111111111111111111111111111111111111111111.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr5111111111111111111111111111111111111111117.length + bArr51111111111111111111111111111111111111111110.length + bArr5111111111111111111111111111111111111111116.length + objArr1111110.length + bArr5111111111111111111111111111111111111111118.length + bArr5111111111111111111111111111111111111111119.length + bArr25.length + bArr24.length];
                java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                int length411111111111111111111111111111111111111111111111111114 = bArr29.length + 0;
                java.lang.System.arraycopy(bArr30, 0, bArr28, length411111111111111111111111111111111111111111111111111114, bArr30.length);
                int length411111111111111111111111111111111111111111111111111115 = length411111111111111111111111111111111111111111111111111114 + bArr30.length;
                java.lang.System.arraycopy(bArr31, 0, bArr28, length411111111111111111111111111111111111111111111111111115, bArr31.length);
                int length411111111111111111111111111111111111111111111111111116 = length411111111111111111111111111111111111111111111111111115 + bArr31.length;
                java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111111111111111111111111111111111111111116, bArr6.length);
                int length411111111111111111111111111111111111111111111111111117 = length411111111111111111111111111111111111111111111111111116 + bArr6.length;
                java.lang.System.arraycopy(bArr26, 0, bArr28, length411111111111111111111111111111111111111111111111111117, bArr26.length);
                int length411111111111111111111111111111111111111111111111111118 = length411111111111111111111111111111111111111111111111111117 + bArr26.length;
                java.lang.System.arraycopy(bArr41, 0, bArr28, length411111111111111111111111111111111111111111111111111118, 0);
                int i1111111111118 = length411111111111111111111111111111111111111111111111111118 + 0;
                java.lang.System.arraycopy(bArr51111111111111111111111111111111111111111112, 0, bArr28, i1111111111118, bArr51111111111111111111111111111111111111111112.length);
                int length411111111111111111111111111111111111111111111111111119 = i1111111111118 + bArr51111111111111111111111111111111111111111112.length;
                java.lang.System.arraycopy(bArr51111111111111111111111111111111111111111111, 0, bArr28, length411111111111111111111111111111111111111111111111111119, bArr51111111111111111111111111111111111111111111.length);
                int length4111111111111111111111111111111111111111111111111111110 = length411111111111111111111111111111111111111111111111111119 + bArr51111111111111111111111111111111111111111111.length;
                java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111111111111111111111111111111111111111110, bArr33.length);
                int length4111111111111111111111111111111111111111111111111111111 = length4111111111111111111111111111111111111111111111111111110 + bArr33.length;
                java.lang.System.arraycopy(bArr34, 0, bArr28, length4111111111111111111111111111111111111111111111111111111, bArr34.length);
                int length1111111111111111111111111111111111111111111111111111111111110 = length4111111111111111111111111111111111111111111111111111111 + bArr34.length;
                java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111110, bArr35.length);
                int length1111111111111111111111111111111111111111111111111111111111111 = length1111111111111111111111111111111111111111111111111111111111110 + bArr35.length;
                java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111111, bArr36.length);
                int length1111111111111111111111111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111111111111111111111111 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111112, bArr37.length);
                int length1111111111111111111111111111111111111111111111111111111111113 = length1111111111111111111111111111111111111111111111111111111111112 + bArr37.length;
                java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111113, bArr7.length);
                int length1111111111111111111111111111111111111111111111111111111111114 = length1111111111111111111111111111111111111111111111111111111111113 + bArr7.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111111117, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111114, bArr5111111111111111111111111111111111111111117.length);
                int length1111111111111111111111111111111111111111111111111111111111115 = length1111111111111111111111111111111111111111111111111111111111114 + bArr5111111111111111111111111111111111111111117.length;
                java.lang.System.arraycopy(bArr51111111111111111111111111111111111111111110, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111115, bArr51111111111111111111111111111111111111111110.length);
                int length1111111111111111111111111111111111111111111111111111111111116 = length1111111111111111111111111111111111111111111111111111111111115 + bArr51111111111111111111111111111111111111111110.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111111116, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111116, bArr5111111111111111111111111111111111111111116.length);
                int length1111111111111111111111111111111111111111111111111111111111117 = length1111111111111111111111111111111111111111111111111111111111116 + bArr5111111111111111111111111111111111111111116.length;
                java.lang.System.arraycopy(objArr1111110, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111117, objArr1111110.length);
                int length1111111111111111111111111111111111111111111111111111111111118 = length1111111111111111111111111111111111111111111111111111111111117 + objArr1111110.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111111118, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111118, bArr5111111111111111111111111111111111111111118.length);
                int length1111111111111111111111111111111111111111111111111111111111119 = length1111111111111111111111111111111111111111111111111111111111118 + bArr5111111111111111111111111111111111111111118.length;
                java.lang.System.arraycopy(bArr5111111111111111111111111111111111111111119, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111119, bArr5111111111111111111111111111111111111111119.length);
                int length21111111111116 = length1111111111111111111111111111111111111111111111111111111111119 + bArr5111111111111111111111111111111111111111119.length;
                java.lang.System.arraycopy(bArr25, 0, bArr28, length21111111111116, bArr25.length);
                java.lang.System.arraycopy(bArr24, 0, bArr28, length21111111111116 + bArr25.length, bArr24.length);
                int length21111111111117 = bArr24.length;
                i6 = i1111111111117;
                i7 = i8;
            } else {
                byte[] bArr51111111111111111111111111111111111111111113 = bArr12;
                byte[] bArr51111111111111111111111111111111111111111114 = bArr38;
                byte[] bArr51111111111111111111111111111111111111111115 = bArr17;
                byte[] bArr51111111111111111111111111111111111111111116 = bArr20;
                byte[] bArr51111111111111111111111111111111111111111117 = bArr10;
                java.lang.Object[] objArr1111111 = bArr13;
                int i1111111111119 = i5 + 2;
                str = this.x.g;
                if (str != null) {
                    bArr27 = bArr5;
                } else {
                    bArr27 = bArr5;
                }
                int length4111111111111111111111111111111111111111111111111111112 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
                byte[] bArr51111111111111111111111111111111111111111118 = bArr9;
                byte[] bArr51111111111111111111111111111111111111111119 = bArr27;
                bArr28 = new byte[length4111111111111111111111111111111111111111111111111111112 + bArr51111111111111111111111111111111111111111118.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr51111111111111111111111111111111111111111114.length + bArr51111111111111111111111111111111111111111117.length + bArr51111111111111111111111111111111111111111113.length + objArr1111111.length + bArr51111111111111111111111111111111111111111115.length + bArr51111111111111111111111111111111111111111116.length + bArr25.length + bArr24.length];
                java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
                int length4111111111111111111111111111111111111111111111111111113 = bArr29.length + 0;
                java.lang.System.arraycopy(bArr30, 0, bArr28, length4111111111111111111111111111111111111111111111111111113, bArr30.length);
                int length4111111111111111111111111111111111111111111111111111114 = length4111111111111111111111111111111111111111111111111111113 + bArr30.length;
                java.lang.System.arraycopy(bArr31, 0, bArr28, length4111111111111111111111111111111111111111111111111111114, bArr31.length);
                int length4111111111111111111111111111111111111111111111111111115 = length4111111111111111111111111111111111111111111111111111114 + bArr31.length;
                java.lang.System.arraycopy(bArr6, 0, bArr28, length4111111111111111111111111111111111111111111111111111115, bArr6.length);
                int length4111111111111111111111111111111111111111111111111111116 = length4111111111111111111111111111111111111111111111111111115 + bArr6.length;
                java.lang.System.arraycopy(bArr26, 0, bArr28, length4111111111111111111111111111111111111111111111111111116, bArr26.length);
                int length4111111111111111111111111111111111111111111111111111117 = length4111111111111111111111111111111111111111111111111111116 + bArr26.length;
                java.lang.System.arraycopy(bArr41, 0, bArr28, length4111111111111111111111111111111111111111111111111111117, 0);
                int i11111111111110 = length4111111111111111111111111111111111111111111111111111117 + 0;
                java.lang.System.arraycopy(bArr51111111111111111111111111111111111111111119, 0, bArr28, i11111111111110, bArr51111111111111111111111111111111111111111119.length);
                int length4111111111111111111111111111111111111111111111111111118 = i11111111111110 + bArr51111111111111111111111111111111111111111119.length;
                java.lang.System.arraycopy(bArr51111111111111111111111111111111111111111118, 0, bArr28, length4111111111111111111111111111111111111111111111111111118, bArr51111111111111111111111111111111111111111118.length);
                int length4111111111111111111111111111111111111111111111111111119 = length4111111111111111111111111111111111111111111111111111118 + bArr51111111111111111111111111111111111111111118.length;
                java.lang.System.arraycopy(bArr33, 0, bArr28, length4111111111111111111111111111111111111111111111111111119, bArr33.length);
                int length41111111111111111111111111111111111111111111111111111110 = length4111111111111111111111111111111111111111111111111111119 + bArr33.length;
                java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111111111111111111111111111111111111111110, bArr34.length);
                int length11111111111111111111111111111111111111111111111111111111111110 = length41111111111111111111111111111111111111111111111111111110 + bArr34.length;
                java.lang.System.arraycopy(bArr35, 0, bArr28, length11111111111111111111111111111111111111111111111111111111111110, bArr35.length);
                int length11111111111111111111111111111111111111111111111111111111111111 = length11111111111111111111111111111111111111111111111111111111111110 + bArr35.length;
                java.lang.System.arraycopy(bArr36, 0, bArr28, length11111111111111111111111111111111111111111111111111111111111111, bArr36.length);
                int length11111111111111111111111111111111111111111111111111111111111112 = length11111111111111111111111111111111111111111111111111111111111111 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr28, length11111111111111111111111111111111111111111111111111111111111112, bArr37.length);
                int length11111111111111111111111111111111111111111111111111111111111113 = length11111111111111111111111111111111111111111111111111111111111112 + bArr37.length;
                java.lang.System.arraycopy(bArr7, 0, bArr28, length11111111111111111111111111111111111111111111111111111111111113, bArr7.length);
                int length11111111111111111111111111111111111111111111111111111111111114 = length11111111111111111111111111111111111111111111111111111111111113 + bArr7.length;
                java.lang.System.arraycopy(bArr51111111111111111111111111111111111111111114, 0, bArr28, length11111111111111111111111111111111111111111111111111111111111114, bArr51111111111111111111111111111111111111111114.length);
                int length11111111111111111111111111111111111111111111111111111111111115 = length11111111111111111111111111111111111111111111111111111111111114 + bArr51111111111111111111111111111111111111111114.length;
                java.lang.System.arraycopy(bArr51111111111111111111111111111111111111111117, 0, bArr28, length11111111111111111111111111111111111111111111111111111111111115, bArr51111111111111111111111111111111111111111117.length);
                int length11111111111111111111111111111111111111111111111111111111111116 = length11111111111111111111111111111111111111111111111111111111111115 + bArr51111111111111111111111111111111111111111117.length;
                java.lang.System.arraycopy(bArr51111111111111111111111111111111111111111113, 0, bArr28, length11111111111111111111111111111111111111111111111111111111111116, bArr51111111111111111111111111111111111111111113.length);
                int length11111111111111111111111111111111111111111111111111111111111117 = length11111111111111111111111111111111111111111111111111111111111116 + bArr51111111111111111111111111111111111111111113.length;
                java.lang.System.arraycopy(objArr1111111, 0, bArr28, length11111111111111111111111111111111111111111111111111111111111117, objArr1111111.length);
                int length11111111111111111111111111111111111111111111111111111111111118 = length11111111111111111111111111111111111111111111111111111111111117 + objArr1111111.length;
                java.lang.System.arraycopy(bArr51111111111111111111111111111111111111111115, 0, bArr28, length11111111111111111111111111111111111111111111111111111111111118, bArr51111111111111111111111111111111111111111115.length);
                int length11111111111111111111111111111111111111111111111111111111111119 = length11111111111111111111111111111111111111111111111111111111111118 + bArr51111111111111111111111111111111111111111115.length;
                java.lang.System.arraycopy(bArr51111111111111111111111111111111111111111116, 0, bArr28, length11111111111111111111111111111111111111111111111111111111111119, bArr51111111111111111111111111111111111111111116.length);
                int length21111111111118 = length11111111111111111111111111111111111111111111111111111111111119 + bArr51111111111111111111111111111111111111111116.length;
                java.lang.System.arraycopy(bArr25, 0, bArr28, length21111111111118, bArr25.length);
                java.lang.System.arraycopy(bArr24, 0, bArr28, length21111111111118 + bArr25.length, bArr24.length);
                int length21111111111119 = bArr24.length;
                i6 = i1111111111119;
                i7 = i8;
            }
            return b(bArr28, i7, i6);
        }
        bArr20 = bArr18;
        bArr21 = bArr48;
        bArr22 = oicq.wlogin_sdk.request.t.R;
        if (bArr22 != null) {
            bArr23 = bArr4;
        } else {
            bArr23 = bArr4;
        }
        bArr24 = bArr23;
        bArr25 = bArr21;
        bArr26 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), this.x.b);
        if (bArr3 != null) {
            byte[] bArr511111111111111111111111111111111111111111110 = bArr12;
            byte[] bArr511111111111111111111111111111111111111111111 = bArr38;
            byte[] bArr511111111111111111111111111111111111111111112 = bArr17;
            byte[] bArr511111111111111111111111111111111111111111113 = bArr20;
            byte[] bArr511111111111111111111111111111111111111111114 = bArr10;
            java.lang.Object[] objArr1111112 = bArr13;
            int i11111111111111 = i5 + 2;
            str = this.x.g;
            if (str != null) {
                bArr27 = bArr5;
            } else {
                bArr27 = bArr5;
            }
            int length41111111111111111111111111111111111111111111111111111111 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
            byte[] bArr511111111111111111111111111111111111111111115 = bArr9;
            byte[] bArr511111111111111111111111111111111111111111116 = bArr27;
            bArr28 = new byte[length41111111111111111111111111111111111111111111111111111111 + bArr511111111111111111111111111111111111111111115.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111111111111111111111111111111111111111.length + bArr511111111111111111111111111111111111111111114.length + bArr511111111111111111111111111111111111111111110.length + objArr1111112.length + bArr511111111111111111111111111111111111111111112.length + bArr511111111111111111111111111111111111111111113.length + bArr25.length + bArr24.length];
            java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
            int length41111111111111111111111111111111111111111111111111111112 = bArr29.length + 0;
            java.lang.System.arraycopy(bArr30, 0, bArr28, length41111111111111111111111111111111111111111111111111111112, bArr30.length);
            int length41111111111111111111111111111111111111111111111111111113 = length41111111111111111111111111111111111111111111111111111112 + bArr30.length;
            java.lang.System.arraycopy(bArr31, 0, bArr28, length41111111111111111111111111111111111111111111111111111113, bArr31.length);
            int length41111111111111111111111111111111111111111111111111111114 = length41111111111111111111111111111111111111111111111111111113 + bArr31.length;
            java.lang.System.arraycopy(bArr6, 0, bArr28, length41111111111111111111111111111111111111111111111111111114, bArr6.length);
            int length41111111111111111111111111111111111111111111111111111115 = length41111111111111111111111111111111111111111111111111111114 + bArr6.length;
            java.lang.System.arraycopy(bArr26, 0, bArr28, length41111111111111111111111111111111111111111111111111111115, bArr26.length);
            int length41111111111111111111111111111111111111111111111111111116 = length41111111111111111111111111111111111111111111111111111115 + bArr26.length;
            java.lang.System.arraycopy(bArr41, 0, bArr28, length41111111111111111111111111111111111111111111111111111116, 0);
            int i11111111111112 = length41111111111111111111111111111111111111111111111111111116 + 0;
            java.lang.System.arraycopy(bArr511111111111111111111111111111111111111111116, 0, bArr28, i11111111111112, bArr511111111111111111111111111111111111111111116.length);
            int length41111111111111111111111111111111111111111111111111111117 = i11111111111112 + bArr511111111111111111111111111111111111111111116.length;
            java.lang.System.arraycopy(bArr511111111111111111111111111111111111111111115, 0, bArr28, length41111111111111111111111111111111111111111111111111111117, bArr511111111111111111111111111111111111111111115.length);
            int length41111111111111111111111111111111111111111111111111111118 = length41111111111111111111111111111111111111111111111111111117 + bArr511111111111111111111111111111111111111111115.length;
            java.lang.System.arraycopy(bArr33, 0, bArr28, length41111111111111111111111111111111111111111111111111111118, bArr33.length);
            int length41111111111111111111111111111111111111111111111111111119 = length41111111111111111111111111111111111111111111111111111118 + bArr33.length;
            java.lang.System.arraycopy(bArr34, 0, bArr28, length41111111111111111111111111111111111111111111111111111119, bArr34.length);
            int length111111111111111111111111111111111111111111111111111111111111110 = length41111111111111111111111111111111111111111111111111111119 + bArr34.length;
            java.lang.System.arraycopy(bArr35, 0, bArr28, length111111111111111111111111111111111111111111111111111111111111110, bArr35.length);
            int length111111111111111111111111111111111111111111111111111111111111111 = length111111111111111111111111111111111111111111111111111111111111110 + bArr35.length;
            java.lang.System.arraycopy(bArr36, 0, bArr28, length111111111111111111111111111111111111111111111111111111111111111, bArr36.length);
            int length111111111111111111111111111111111111111111111111111111111111112 = length111111111111111111111111111111111111111111111111111111111111111 + bArr36.length;
            java.lang.System.arraycopy(bArr37, 0, bArr28, length111111111111111111111111111111111111111111111111111111111111112, bArr37.length);
            int length111111111111111111111111111111111111111111111111111111111111113 = length111111111111111111111111111111111111111111111111111111111111112 + bArr37.length;
            java.lang.System.arraycopy(bArr7, 0, bArr28, length111111111111111111111111111111111111111111111111111111111111113, bArr7.length);
            int length111111111111111111111111111111111111111111111111111111111111114 = length111111111111111111111111111111111111111111111111111111111111113 + bArr7.length;
            java.lang.System.arraycopy(bArr511111111111111111111111111111111111111111111, 0, bArr28, length111111111111111111111111111111111111111111111111111111111111114, bArr511111111111111111111111111111111111111111111.length);
            int length111111111111111111111111111111111111111111111111111111111111115 = length111111111111111111111111111111111111111111111111111111111111114 + bArr511111111111111111111111111111111111111111111.length;
            java.lang.System.arraycopy(bArr511111111111111111111111111111111111111111114, 0, bArr28, length111111111111111111111111111111111111111111111111111111111111115, bArr511111111111111111111111111111111111111111114.length);
            int length111111111111111111111111111111111111111111111111111111111111116 = length111111111111111111111111111111111111111111111111111111111111115 + bArr511111111111111111111111111111111111111111114.length;
            java.lang.System.arraycopy(bArr511111111111111111111111111111111111111111110, 0, bArr28, length111111111111111111111111111111111111111111111111111111111111116, bArr511111111111111111111111111111111111111111110.length);
            int length111111111111111111111111111111111111111111111111111111111111117 = length111111111111111111111111111111111111111111111111111111111111116 + bArr511111111111111111111111111111111111111111110.length;
            java.lang.System.arraycopy(objArr1111112, 0, bArr28, length111111111111111111111111111111111111111111111111111111111111117, objArr1111112.length);
            int length111111111111111111111111111111111111111111111111111111111111118 = length111111111111111111111111111111111111111111111111111111111111117 + objArr1111112.length;
            java.lang.System.arraycopy(bArr511111111111111111111111111111111111111111112, 0, bArr28, length111111111111111111111111111111111111111111111111111111111111118, bArr511111111111111111111111111111111111111111112.length);
            int length111111111111111111111111111111111111111111111111111111111111119 = length111111111111111111111111111111111111111111111111111111111111118 + bArr511111111111111111111111111111111111111111112.length;
            java.lang.System.arraycopy(bArr511111111111111111111111111111111111111111113, 0, bArr28, length111111111111111111111111111111111111111111111111111111111111119, bArr511111111111111111111111111111111111111111113.length);
            int length211111111111110 = length111111111111111111111111111111111111111111111111111111111111119 + bArr511111111111111111111111111111111111111111113.length;
            java.lang.System.arraycopy(bArr25, 0, bArr28, length211111111111110, bArr25.length);
            java.lang.System.arraycopy(bArr24, 0, bArr28, length211111111111110 + bArr25.length, bArr24.length);
            int length211111111111111 = bArr24.length;
            i6 = i11111111111111;
            i7 = i8;
        } else {
            byte[] bArr511111111111111111111111111111111111111111117 = bArr12;
            byte[] bArr511111111111111111111111111111111111111111118 = bArr38;
            byte[] bArr511111111111111111111111111111111111111111119 = bArr17;
            byte[] bArr5111111111111111111111111111111111111111111110 = bArr20;
            byte[] bArr5111111111111111111111111111111111111111111111 = bArr10;
            java.lang.Object[] objArr1111113 = bArr13;
            int i11111111111113 = i5 + 2;
            str = this.x.g;
            if (str != null) {
                bArr27 = bArr5;
            } else {
                bArr27 = bArr5;
            }
            int length411111111111111111111111111111111111111111111111111111110 = bArr29.length + bArr30.length + bArr31.length + bArr6.length + bArr26.length + 0 + bArr27.length;
            byte[] bArr5111111111111111111111111111111111111111111112 = bArr9;
            byte[] bArr5111111111111111111111111111111111111111111113 = bArr27;
            bArr28 = new byte[length411111111111111111111111111111111111111111111111111111110 + bArr5111111111111111111111111111111111111111111112.length + bArr33.length + bArr34.length + bArr35.length + bArr36.length + bArr37.length + bArr7.length + bArr511111111111111111111111111111111111111111118.length + bArr5111111111111111111111111111111111111111111111.length + bArr511111111111111111111111111111111111111111117.length + objArr1111113.length + bArr511111111111111111111111111111111111111111119.length + bArr5111111111111111111111111111111111111111111110.length + bArr25.length + bArr24.length];
            java.lang.System.arraycopy(bArr29, 0, bArr28, 0, bArr29.length);
            int length411111111111111111111111111111111111111111111111111111111 = bArr29.length + 0;
            java.lang.System.arraycopy(bArr30, 0, bArr28, length411111111111111111111111111111111111111111111111111111111, bArr30.length);
            int length411111111111111111111111111111111111111111111111111111112 = length411111111111111111111111111111111111111111111111111111111 + bArr30.length;
            java.lang.System.arraycopy(bArr31, 0, bArr28, length411111111111111111111111111111111111111111111111111111112, bArr31.length);
            int length411111111111111111111111111111111111111111111111111111113 = length411111111111111111111111111111111111111111111111111111112 + bArr31.length;
            java.lang.System.arraycopy(bArr6, 0, bArr28, length411111111111111111111111111111111111111111111111111111113, bArr6.length);
            int length411111111111111111111111111111111111111111111111111111114 = length411111111111111111111111111111111111111111111111111111113 + bArr6.length;
            java.lang.System.arraycopy(bArr26, 0, bArr28, length411111111111111111111111111111111111111111111111111111114, bArr26.length);
            int length411111111111111111111111111111111111111111111111111111115 = length411111111111111111111111111111111111111111111111111111114 + bArr26.length;
            java.lang.System.arraycopy(bArr41, 0, bArr28, length411111111111111111111111111111111111111111111111111111115, 0);
            int i11111111111114 = length411111111111111111111111111111111111111111111111111111115 + 0;
            java.lang.System.arraycopy(bArr5111111111111111111111111111111111111111111113, 0, bArr28, i11111111111114, bArr5111111111111111111111111111111111111111111113.length);
            int length411111111111111111111111111111111111111111111111111111116 = i11111111111114 + bArr5111111111111111111111111111111111111111111113.length;
            java.lang.System.arraycopy(bArr5111111111111111111111111111111111111111111112, 0, bArr28, length411111111111111111111111111111111111111111111111111111116, bArr5111111111111111111111111111111111111111111112.length);
            int length411111111111111111111111111111111111111111111111111111117 = length411111111111111111111111111111111111111111111111111111116 + bArr5111111111111111111111111111111111111111111112.length;
            java.lang.System.arraycopy(bArr33, 0, bArr28, length411111111111111111111111111111111111111111111111111111117, bArr33.length);
            int length411111111111111111111111111111111111111111111111111111118 = length411111111111111111111111111111111111111111111111111111117 + bArr33.length;
            java.lang.System.arraycopy(bArr34, 0, bArr28, length411111111111111111111111111111111111111111111111111111118, bArr34.length);
            int length1111111111111111111111111111111111111111111111111111111111111110 = length411111111111111111111111111111111111111111111111111111118 + bArr34.length;
            java.lang.System.arraycopy(bArr35, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111111110, bArr35.length);
            int length1111111111111111111111111111111111111111111111111111111111111111 = length1111111111111111111111111111111111111111111111111111111111111110 + bArr35.length;
            java.lang.System.arraycopy(bArr36, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111111111, bArr36.length);
            int length1111111111111111111111111111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111111111111111111111111111 + bArr36.length;
            java.lang.System.arraycopy(bArr37, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111111112, bArr37.length);
            int length1111111111111111111111111111111111111111111111111111111111111113 = length1111111111111111111111111111111111111111111111111111111111111112 + bArr37.length;
            java.lang.System.arraycopy(bArr7, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111111113, bArr7.length);
            int length1111111111111111111111111111111111111111111111111111111111111114 = length1111111111111111111111111111111111111111111111111111111111111113 + bArr7.length;
            java.lang.System.arraycopy(bArr511111111111111111111111111111111111111111118, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111111114, bArr511111111111111111111111111111111111111111118.length);
            int length1111111111111111111111111111111111111111111111111111111111111115 = length1111111111111111111111111111111111111111111111111111111111111114 + bArr511111111111111111111111111111111111111111118.length;
            java.lang.System.arraycopy(bArr5111111111111111111111111111111111111111111111, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111111115, bArr5111111111111111111111111111111111111111111111.length);
            int length1111111111111111111111111111111111111111111111111111111111111116 = length1111111111111111111111111111111111111111111111111111111111111115 + bArr5111111111111111111111111111111111111111111111.length;
            java.lang.System.arraycopy(bArr511111111111111111111111111111111111111111117, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111111116, bArr511111111111111111111111111111111111111111117.length);
            int length1111111111111111111111111111111111111111111111111111111111111117 = length1111111111111111111111111111111111111111111111111111111111111116 + bArr511111111111111111111111111111111111111111117.length;
            java.lang.System.arraycopy(objArr1111113, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111111117, objArr1111113.length);
            int length1111111111111111111111111111111111111111111111111111111111111118 = length1111111111111111111111111111111111111111111111111111111111111117 + objArr1111113.length;
            java.lang.System.arraycopy(bArr511111111111111111111111111111111111111111119, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111111118, bArr511111111111111111111111111111111111111111119.length);
            int length1111111111111111111111111111111111111111111111111111111111111119 = length1111111111111111111111111111111111111111111111111111111111111118 + bArr511111111111111111111111111111111111111111119.length;
            java.lang.System.arraycopy(bArr5111111111111111111111111111111111111111111110, 0, bArr28, length1111111111111111111111111111111111111111111111111111111111111119, bArr5111111111111111111111111111111111111111111110.length);
            int length211111111111112 = length1111111111111111111111111111111111111111111111111111111111111119 + bArr5111111111111111111111111111111111111111111110.length;
            java.lang.System.arraycopy(bArr25, 0, bArr28, length211111111111112, bArr25.length);
            java.lang.System.arraycopy(bArr24, 0, bArr28, length211111111111112 + bArr25.length, bArr24.length);
            int length211111111111113 = bArr24.length;
            i6 = i11111111111113;
            i7 = i8;
        }
        return b(bArr28, i7, i6);
    }
}
