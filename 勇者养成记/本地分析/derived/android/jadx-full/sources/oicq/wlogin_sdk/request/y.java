package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class y extends oicq.wlogin_sdk.request.oicq_request {
    public y(oicq.wlogin_sdk.request.t tVar, android.content.Context context) {
        this.t = 2064;
        this.u = 15;
        this.v = "wtlogin.exchange_emp";
        this.x = tVar;
        tVar.m = 0;
        this.y = oicq.wlogin_sdk.request.oicq_request.EncryptionMethod.EM_ST;
        this.f1686a = context;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:12:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:15:0x01df  */
    /* JADX WARN: Code duplicated, block: B:17:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:18:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:22:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:24:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:25:0x0203  */
    /* JADX WARN: Code duplicated, block: B:29:0x020b  */
    /* JADX WARN: Code duplicated, block: B:31:0x0210  */
    /* JADX WARN: Code duplicated, block: B:32:0x0219  */
    /* JADX WARN: Code duplicated, block: B:36:0x0221  */
    /* JADX WARN: Code duplicated, block: B:38:0x0226  */
    /* JADX WARN: Code duplicated, block: B:39:0x022f  */
    /* JADX WARN: Code duplicated, block: B:43:0x0237  */
    /* JADX WARN: Code duplicated, block: B:45:0x023c  */
    /* JADX WARN: Code duplicated, block: B:46:0x0255  */
    /* JADX WARN: Code duplicated, block: B:47:0x0258  */
    /* JADX WARN: Code duplicated, block: B:51:0x0266  */
    /* JADX WARN: Code duplicated, block: B:54:0x0274  */
    /* JADX WARN: Code duplicated, block: B:57:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:60:0x0319  */
    /* JADX WARN: Code duplicated, block: B:63:0x0320  */
    /* JADX WARN: Code duplicated, block: B:66:0x032c  */
    /* JADX WARN: Code duplicated, block: B:69:0x0332  */
    /* JADX WARN: Code duplicated, block: B:72:0x0342  */
    /* JADX WARN: Code duplicated, block: B:75:0x0348  */
    /* JADX WARN: Code duplicated, block: B:88:0x037c  */
    /* JADX WARN: Multi-variable type inference failed */
    private byte[] a(long j, int i, long j2, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i3, int i4, long[] jArr, int i5, long j3, int i6, int i7, int i8, int i9, int i10, byte[] bArr4, long j4, byte[] bArr5, java.util.List list, int i11) {
        byte[] bArr6;
        int i12;
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
        int i13;
        java.lang.String str;
        int i14;
        byte[] bArr26;
        byte[] bArr27;
        byte[] bArr28;
        byte[] bArr29;
        byte[] bArr30;
        byte[] bArr31;
        byte[] bArr32;
        byte[] bArr33;
        byte[] bArr34;
        oicq.wlogin_sdk.tlv_type.tlv_t18 tlv_t18Var = new oicq.wlogin_sdk.tlv_type.tlv_t18();
        oicq.wlogin_sdk.tlv_type.tlv_t1 tlv_t1Var = new oicq.wlogin_sdk.tlv_type.tlv_t1();
        oicq.wlogin_sdk.tlv_type.tlv_t106 tlv_t106Var = new oicq.wlogin_sdk.tlv_type.tlv_t106();
        oicq.wlogin_sdk.tlv_type.tlv_t116 tlv_t116Var = new oicq.wlogin_sdk.tlv_type.tlv_t116();
        oicq.wlogin_sdk.tlv_type.tlv_t100 tlv_t100Var = new oicq.wlogin_sdk.tlv_type.tlv_t100();
        oicq.wlogin_sdk.tlv_type.tlv_t107 tlv_t107Var = new oicq.wlogin_sdk.tlv_type.tlv_t107();
        oicq.wlogin_sdk.tlv_type.tlv_t108 tlv_t108Var = new oicq.wlogin_sdk.tlv_type.tlv_t108();
        oicq.wlogin_sdk.tlv_type.tlv_t109 tlv_t109Var = new oicq.wlogin_sdk.tlv_type.tlv_t109();
        oicq.wlogin_sdk.tlv_type.tlv_t124 tlv_t124Var = new oicq.wlogin_sdk.tlv_type.tlv_t124();
        oicq.wlogin_sdk.tlv_type.tlv_t128 tlv_t128Var = new oicq.wlogin_sdk.tlv_type.tlv_t128();
        oicq.wlogin_sdk.tlv_type.tlv_t142 tlv_t142Var = new oicq.wlogin_sdk.tlv_type.tlv_t142();
        oicq.wlogin_sdk.tlv_type.tlv_t112 tlv_t112Var = new oicq.wlogin_sdk.tlv_type.tlv_t112();
        oicq.wlogin_sdk.tlv_type.tlv_t144 tlv_t144Var = new oicq.wlogin_sdk.tlv_type.tlv_t144();
        oicq.wlogin_sdk.tlv_type.tlv_t145 tlv_t145Var = new oicq.wlogin_sdk.tlv_type.tlv_t145();
        oicq.wlogin_sdk.tlv_type.tlv_t147 tlv_t147Var = new oicq.wlogin_sdk.tlv_type.tlv_t147();
        oicq.wlogin_sdk.tlv_type.tlv_t166 tlv_t166Var = new oicq.wlogin_sdk.tlv_type.tlv_t166();
        oicq.wlogin_sdk.tlv_type.tlv_t16a tlv_t16aVar = new oicq.wlogin_sdk.tlv_type.tlv_t16a();
        oicq.wlogin_sdk.tlv_type.tlv_t141 tlv_t141Var = new oicq.wlogin_sdk.tlv_type.tlv_t141();
        oicq.wlogin_sdk.tlv_type.tlv_t8 tlv_t8Var = new oicq.wlogin_sdk.tlv_type.tlv_t8();
        oicq.wlogin_sdk.tlv_type.tlv_t154 tlv_t154Var = new oicq.wlogin_sdk.tlv_type.tlv_t154();
        oicq.wlogin_sdk.tlv_type.tlv_t511 tlv_t511Var = new oicq.wlogin_sdk.tlv_type.tlv_t511();
        oicq.wlogin_sdk.tlv_type.tlv_t16e tlv_t16eVar = new oicq.wlogin_sdk.tlv_type.tlv_t16e();
        oicq.wlogin_sdk.tlv_type.tlv_t172 tlv_t172Var = new oicq.wlogin_sdk.tlv_type.tlv_t172();
        oicq.wlogin_sdk.tlv_type.tlv_t177 tlv_t177Var = new oicq.wlogin_sdk.tlv_type.tlv_t177();
        oicq.wlogin_sdk.tlv_type.tlv_t400 tlv_t400Var = new oicq.wlogin_sdk.tlv_type.tlv_t400();
        oicq.wlogin_sdk.tlv_type.tlv_t187 tlv_t187Var = new oicq.wlogin_sdk.tlv_type.tlv_t187();
        oicq.wlogin_sdk.tlv_type.tlv_t188 tlv_t188Var = new oicq.wlogin_sdk.tlv_type.tlv_t188();
        oicq.wlogin_sdk.tlv_type.tlv_t194 tlv_t194Var = new oicq.wlogin_sdk.tlv_type.tlv_t194();
        oicq.wlogin_sdk.tlv_type.tlv_t201 tlv_t201Var = new oicq.wlogin_sdk.tlv_type.tlv_t201();
        oicq.wlogin_sdk.tlv_type.tlv_t202 tlv_t202Var = new oicq.wlogin_sdk.tlv_type.tlv_t202();
        oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar = new oicq.wlogin_sdk.tlv_type.tlv_t(1302);
        oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar2 = new oicq.wlogin_sdk.tlv_type.tlv_t(1313);
        new oicq.wlogin_sdk.tlv_type.tlv_t(1317);
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA = this.x.a(j2, j4);
        byte[] bArr35 = tlv_t18Var.get_tlv_18(j, i, j2, i2);
        byte[] bArr36 = tlv_t1Var.get_tlv_1(j2, bArr);
        tlv_t106Var.set_data(bArr2, bArr2.length);
        byte[] bArr37 = tlv_t106Var.get_buf();
        oicq.wlogin_sdk.tools.util.LOGD("req2 a1:", oicq.wlogin_sdk.tools.util.buf_to_string(bArr37));
        byte[] bArr38 = tlv_t100Var.get_tlv_100(j, j3, i, i5);
        byte[] bArr39 = tlv_t107Var.get_tlv_107(i7, i8, i9, i10);
        byte[] bArr40 = tlv_t116Var.get_tlv_116(i3, i4, jArr);
        byte[] bArr41 = tlv_t145Var.get_tlv_145(oicq.wlogin_sdk.request.t.A);
        byte[] bArr42 = tlv_t154Var.get_tlv_154(this.x.i);
        byte[] bArr43 = tlv_t141Var.get_tlv_141(oicq.wlogin_sdk.request.t.C, oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.F);
        byte[] bArr44 = tlv_t8Var.get_tlv_8(0, oicq.wlogin_sdk.request.t.u, 0);
        byte[] bArr45 = tlv_t147Var.get_tlv_147(j4, oicq.wlogin_sdk.request.t.G, oicq.wlogin_sdk.request.t.H);
        byte[] bArr46 = tlv_t177Var.get_tlv_177(oicq.wlogin_sdk.tools.util.BUILD_TIME, oicq.wlogin_sdk.tools.util.SDK_VERSION);
        byte[] bArr47 = new byte[0];
        byte[] bArr48 = new byte[0];
        byte[] bArr49 = new byte[0];
        byte[] bArr50 = new byte[0];
        byte[] bArr51 = new byte[0];
        byte[] bArr52 = new byte[0];
        byte[] bArr53 = new byte[0];
        byte[] bArr54 = new byte[0];
        byte[] bArr55 = new byte[0];
        byte[] bArr56 = new byte[0];
        byte[] bArr57 = new byte[0];
        byte[] bArr58 = new byte[0];
        if (bArr4 != null) {
            bArr6 = bArr58;
            if (bArr4.length > 0) {
                bArr7 = tlv_t108Var.get_tlv_108(bArr4);
                i12 = 13;
            }
            if ((i3 & 128) != 0) {
                bArr8 = tlv_t166Var.get_tlv_166(oicq.wlogin_sdk.request.t.x);
                i12++;
            } else {
                bArr8 = bArr49;
            }
            bArr9 = this.x.r;
            if (bArr9 != null) {
                bArr10 = bArr46;
                if (bArr9.length > 0) {
                    bArr11 = tlv_t172Var.get_tlv_172(bArr9);
                    i12++;
                }
                bArr12 = oicq.wlogin_sdk.request.t.N;
                if (bArr12 != null) {
                    bArr13 = bArr11;
                    if (bArr12.length > 0) {
                        bArr14 = tlv_t187Var.get_tlv_187(bArr12);
                        i12++;
                    }
                    bArr15 = oicq.wlogin_sdk.request.t.O;
                    if (bArr15 != null) {
                        bArr16 = bArr14;
                        if (bArr15.length > 0) {
                            bArr17 = tlv_t188Var.get_tlv_188(bArr15);
                            i12++;
                        }
                        bArr18 = oicq.wlogin_sdk.request.t.L;
                        if (bArr18 != null) {
                            bArr19 = bArr17;
                            if (bArr18.length > 0) {
                                bArr20 = tlv_t194Var.get_tlv_194(bArr18);
                                i12++;
                            }
                            bArr21 = oicq.wlogin_sdk.request.l.J;
                            if (bArr21 != null) {
                                bArr22 = bArr20;
                                if (bArr21.length > 0) {
                                    bArr41 = bArr41;
                                    bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                                    i12++;
                                }
                                bArr24 = oicq.wlogin_sdk.request.t.R;
                                if (bArr24 != null || bArr24.length <= 0) {
                                    bArr25 = bArr6;
                                } else {
                                    bArr25 = tlv_t202Var.get_tlv_202(bArr24, oicq.wlogin_sdk.request.t.S);
                                    i12++;
                                }
                                byte[] bArr59 = bArr23;
                                byte[] bArr60 = bArr25;
                                byte[] bArr61 = bArr7;
                                byte[] bArr62 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                                byte[] bArr63 = tlv_t142Var.get_tlv_142(bArr5);
                                i13 = i12 + 1 + 1;
                                str = this.x.g;
                                if (str != null || oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
                                    i14 = i13;
                                    bArr26 = bArr48;
                                } else {
                                    bArr26 = tlv_t112Var.get_tlv_112(this.x.g.getBytes());
                                    i14 = i13 + 1;
                                }
                                if (bArr3 != null || bArr3.length <= 0) {
                                    bArr27 = bArr50;
                                } else {
                                    bArr27 = tlv_t16aVar.get_tlv_16a(bArr3);
                                    i14++;
                                }
                                if (list != null || list.size() <= 0) {
                                    bArr28 = bArr51;
                                } else {
                                    i14++;
                                    bArr28 = tlv_t511Var.get_tlv_511(list);
                                }
                                if (wloginSigInfoA == null && (bArr32 = wloginSigInfoA._G) != null) {
                                    bArr29 = bArr28;
                                    if (bArr32.length > 0 && (bArr33 = wloginSigInfoA._dpwd) != null) {
                                        bArr30 = bArr27;
                                        if (bArr33.length > 0 && (bArr34 = wloginSigInfoA._randseed) != null && bArr34.length > 0) {
                                            bArr31 = tlv_t400Var.get_tlv_400(bArr32, j2, oicq.wlogin_sdk.request.t.A, bArr33, j4, 1L, bArr34);
                                            i14++;
                                        }
                                        byte[] bArr64 = new byte[4];
                                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr64, 0, i11);
                                        tlv_tVar.set_data(bArr64, 4);
                                        byte[] bArr65 = tlv_tVar.get_buf();
                                        byte[] bArr66 = new byte[6];
                                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr66, 0, oicq.wlogin_sdk.request.t.au);
                                        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr66, 4, 0);
                                        tlv_tVar2.set_data(bArr66, 6);
                                        byte[] bArr67 = tlv_tVar2.get_buf();
                                        int i15 = i14 + 1 + 1;
                                        int length = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr61.length + bArr62.length + bArr63.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                                        byte[] bArr68 = bArr10;
                                        byte[] bArr69 = bArr31;
                                        byte[] bArr70 = new byte[length + bArr68.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr59.length + bArr60.length + bArr65.length + bArr67.length];
                                        java.lang.System.arraycopy(bArr35, 0, bArr70, 0, bArr35.length);
                                        int length2 = bArr35.length + 0;
                                        java.lang.System.arraycopy(bArr36, 0, bArr70, length2, bArr36.length);
                                        int length3 = length2 + bArr36.length;
                                        java.lang.System.arraycopy(bArr37, 0, bArr70, length3, bArr37.length);
                                        int length4 = length3 + bArr37.length;
                                        java.lang.System.arraycopy(bArr40, 0, bArr70, length4, bArr40.length);
                                        int length5 = length4 + bArr40.length;
                                        java.lang.System.arraycopy(bArr38, 0, bArr70, length5, bArr38.length);
                                        int length6 = length5 + bArr38.length;
                                        java.lang.System.arraycopy(bArr39, 0, bArr70, length6, bArr39.length);
                                        int length7 = length6 + bArr39.length;
                                        java.lang.System.arraycopy(bArr61, 0, bArr70, length7, bArr61.length);
                                        int length8 = length7 + bArr61.length;
                                        java.lang.System.arraycopy(bArr62, 0, bArr70, length8, bArr62.length);
                                        int length9 = length8 + bArr62.length;
                                        java.lang.System.arraycopy(bArr63, 0, bArr70, length9, bArr63.length);
                                        int length10 = length9 + bArr63.length;
                                        java.lang.System.arraycopy(bArr26, 0, bArr70, length10, bArr26.length);
                                        int length11 = length10 + bArr26.length;
                                        byte[] bArr71 = bArr41;
                                        java.lang.System.arraycopy(bArr71, 0, bArr70, length11, bArr71.length);
                                        int length12 = length11 + bArr71.length;
                                        byte[] bArr72 = bArr8;
                                        java.lang.System.arraycopy(bArr72, 0, bArr70, length12, bArr72.length);
                                        int length13 = length12 + bArr72.length;
                                        byte[] bArr73 = bArr30;
                                        java.lang.System.arraycopy(bArr73, 0, bArr70, length13, bArr73.length);
                                        int length14 = length13 + bArr73.length;
                                        java.lang.System.arraycopy(bArr42, 0, bArr70, length14, bArr42.length);
                                        int length15 = length14 + bArr42.length;
                                        java.lang.System.arraycopy(bArr43, 0, bArr70, length15, bArr43.length);
                                        int length16 = length15 + bArr43.length;
                                        java.lang.System.arraycopy(bArr44, 0, bArr70, length16, bArr44.length);
                                        int length17 = length16 + bArr44.length;
                                        byte[] bArr74 = bArr29;
                                        java.lang.System.arraycopy(bArr74, 0, bArr70, length17, bArr74.length);
                                        int length18 = length17 + bArr74.length;
                                        java.lang.System.arraycopy(bArr45, 0, bArr70, length18, bArr45.length);
                                        int length19 = length18 + bArr45.length;
                                        byte[] bArr75 = bArr13;
                                        java.lang.System.arraycopy(bArr75, 0, bArr70, length19, bArr75.length);
                                        int length20 = length19 + bArr75.length;
                                        java.lang.System.arraycopy(bArr68, 0, bArr70, length20, bArr68.length);
                                        int length21 = length20 + bArr68.length;
                                        java.lang.System.arraycopy(bArr69, 0, bArr70, length21, bArr69.length);
                                        int length22 = length21 + bArr69.length;
                                        byte[] bArr76 = bArr16;
                                        java.lang.System.arraycopy(bArr76, 0, bArr70, length22, bArr76.length);
                                        int length23 = length22 + bArr76.length;
                                        byte[] bArr77 = bArr19;
                                        java.lang.System.arraycopy(bArr77, 0, bArr70, length23, bArr77.length);
                                        int length24 = length23 + bArr77.length;
                                        byte[] bArr78 = bArr22;
                                        java.lang.System.arraycopy(bArr78, 0, bArr70, length24, bArr78.length);
                                        int length25 = length24 + bArr78.length;
                                        java.lang.System.arraycopy(bArr59, 0, bArr70, length25, bArr59.length);
                                        int length26 = length25 + bArr59.length;
                                        java.lang.System.arraycopy(bArr60, 0, bArr70, length26, bArr60.length);
                                        int length27 = length26 + bArr60.length;
                                        java.lang.System.arraycopy(bArr65, 0, bArr70, length27, bArr65.length);
                                        java.lang.System.arraycopy(bArr67, 0, bArr70, length27 + bArr65.length, bArr67.length);
                                        int length28 = bArr67.length;
                                        return a(a(bArr70, this.u, i15), this.y, this.A, this.B);
                                    }
                                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                                    bArr31 = bArr53;
                                    byte[] bArr610 = new byte[4];
                                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr610, 0, i11);
                                    tlv_tVar.set_data(bArr610, 4);
                                    byte[] bArr611 = tlv_tVar.get_buf();
                                    byte[] bArr612 = new byte[6];
                                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr612, 0, oicq.wlogin_sdk.request.t.au);
                                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr612, 4, 0);
                                    tlv_tVar2.set_data(bArr612, 6);
                                    byte[] bArr613 = tlv_tVar2.get_buf();
                                    int i16 = i14 + 1 + 1;
                                    int length29 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr61.length + bArr62.length + bArr63.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                                    byte[] bArr614 = bArr10;
                                    byte[] bArr615 = bArr31;
                                    byte[] bArr79 = new byte[length29 + bArr614.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr59.length + bArr60.length + bArr611.length + bArr613.length];
                                    java.lang.System.arraycopy(bArr35, 0, bArr79, 0, bArr35.length);
                                    int length30 = bArr35.length + 0;
                                    java.lang.System.arraycopy(bArr36, 0, bArr79, length30, bArr36.length);
                                    int length31 = length30 + bArr36.length;
                                    java.lang.System.arraycopy(bArr37, 0, bArr79, length31, bArr37.length);
                                    int length32 = length31 + bArr37.length;
                                    java.lang.System.arraycopy(bArr40, 0, bArr79, length32, bArr40.length);
                                    int length33 = length32 + bArr40.length;
                                    java.lang.System.arraycopy(bArr38, 0, bArr79, length33, bArr38.length);
                                    int length34 = length33 + bArr38.length;
                                    java.lang.System.arraycopy(bArr39, 0, bArr79, length34, bArr39.length);
                                    int length35 = length34 + bArr39.length;
                                    java.lang.System.arraycopy(bArr61, 0, bArr79, length35, bArr61.length);
                                    int length36 = length35 + bArr61.length;
                                    java.lang.System.arraycopy(bArr62, 0, bArr79, length36, bArr62.length);
                                    int length37 = length36 + bArr62.length;
                                    java.lang.System.arraycopy(bArr63, 0, bArr79, length37, bArr63.length);
                                    int length110 = length37 + bArr63.length;
                                    java.lang.System.arraycopy(bArr26, 0, bArr79, length110, bArr26.length);
                                    int length111 = length110 + bArr26.length;
                                    byte[] bArr710 = bArr41;
                                    java.lang.System.arraycopy(bArr710, 0, bArr79, length111, bArr710.length);
                                    int length112 = length111 + bArr710.length;
                                    byte[] bArr711 = bArr8;
                                    java.lang.System.arraycopy(bArr711, 0, bArr79, length112, bArr711.length);
                                    int length113 = length112 + bArr711.length;
                                    byte[] bArr712 = bArr30;
                                    java.lang.System.arraycopy(bArr712, 0, bArr79, length113, bArr712.length);
                                    int length114 = length113 + bArr712.length;
                                    java.lang.System.arraycopy(bArr42, 0, bArr79, length114, bArr42.length);
                                    int length115 = length114 + bArr42.length;
                                    java.lang.System.arraycopy(bArr43, 0, bArr79, length115, bArr43.length);
                                    int length116 = length115 + bArr43.length;
                                    java.lang.System.arraycopy(bArr44, 0, bArr79, length116, bArr44.length);
                                    int length117 = length116 + bArr44.length;
                                    byte[] bArr713 = bArr29;
                                    java.lang.System.arraycopy(bArr713, 0, bArr79, length117, bArr713.length);
                                    int length118 = length117 + bArr713.length;
                                    java.lang.System.arraycopy(bArr45, 0, bArr79, length118, bArr45.length);
                                    int length119 = length118 + bArr45.length;
                                    byte[] bArr714 = bArr13;
                                    java.lang.System.arraycopy(bArr714, 0, bArr79, length119, bArr714.length);
                                    int length210 = length119 + bArr714.length;
                                    java.lang.System.arraycopy(bArr614, 0, bArr79, length210, bArr614.length);
                                    int length211 = length210 + bArr614.length;
                                    java.lang.System.arraycopy(bArr615, 0, bArr79, length211, bArr615.length);
                                    int length212 = length211 + bArr615.length;
                                    byte[] bArr715 = bArr16;
                                    java.lang.System.arraycopy(bArr715, 0, bArr79, length212, bArr715.length);
                                    int length213 = length212 + bArr715.length;
                                    byte[] bArr716 = bArr19;
                                    java.lang.System.arraycopy(bArr716, 0, bArr79, length213, bArr716.length);
                                    int length214 = length213 + bArr716.length;
                                    byte[] bArr717 = bArr22;
                                    java.lang.System.arraycopy(bArr717, 0, bArr79, length214, bArr717.length);
                                    int length215 = length214 + bArr717.length;
                                    java.lang.System.arraycopy(bArr59, 0, bArr79, length215, bArr59.length);
                                    int length216 = length215 + bArr59.length;
                                    java.lang.System.arraycopy(bArr60, 0, bArr79, length216, bArr60.length);
                                    int length217 = length216 + bArr60.length;
                                    java.lang.System.arraycopy(bArr611, 0, bArr79, length217, bArr611.length);
                                    java.lang.System.arraycopy(bArr613, 0, bArr79, length217 + bArr611.length, bArr613.length);
                                    int length218 = bArr613.length;
                                    return a(a(bArr79, this.u, i16), this.y, this.A, this.B);
                                }
                                bArr29 = bArr28;
                                bArr30 = bArr27;
                                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                                bArr31 = bArr53;
                                byte[] bArr616 = new byte[4];
                                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr616, 0, i11);
                                tlv_tVar.set_data(bArr616, 4);
                                byte[] bArr617 = tlv_tVar.get_buf();
                                byte[] bArr618 = new byte[6];
                                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr618, 0, oicq.wlogin_sdk.request.t.au);
                                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr618, 4, 0);
                                tlv_tVar2.set_data(bArr618, 6);
                                byte[] bArr619 = tlv_tVar2.get_buf();
                                int i17 = i14 + 1 + 1;
                                int length219 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr61.length + bArr62.length + bArr63.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                                byte[] bArr6110 = bArr10;
                                byte[] bArr6111 = bArr31;
                                byte[] bArr718 = new byte[length219 + bArr6110.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr59.length + bArr60.length + bArr617.length + bArr619.length];
                                java.lang.System.arraycopy(bArr35, 0, bArr718, 0, bArr35.length);
                                int length38 = bArr35.length + 0;
                                java.lang.System.arraycopy(bArr36, 0, bArr718, length38, bArr36.length);
                                int length39 = length38 + bArr36.length;
                                java.lang.System.arraycopy(bArr37, 0, bArr718, length39, bArr37.length);
                                int length310 = length39 + bArr37.length;
                                java.lang.System.arraycopy(bArr40, 0, bArr718, length310, bArr40.length);
                                int length311 = length310 + bArr40.length;
                                java.lang.System.arraycopy(bArr38, 0, bArr718, length311, bArr38.length);
                                int length312 = length311 + bArr38.length;
                                java.lang.System.arraycopy(bArr39, 0, bArr718, length312, bArr39.length);
                                int length313 = length312 + bArr39.length;
                                java.lang.System.arraycopy(bArr61, 0, bArr718, length313, bArr61.length);
                                int length314 = length313 + bArr61.length;
                                java.lang.System.arraycopy(bArr62, 0, bArr718, length314, bArr62.length);
                                int length315 = length314 + bArr62.length;
                                java.lang.System.arraycopy(bArr63, 0, bArr718, length315, bArr63.length);
                                int length1110 = length315 + bArr63.length;
                                java.lang.System.arraycopy(bArr26, 0, bArr718, length1110, bArr26.length);
                                int length1111 = length1110 + bArr26.length;
                                byte[] bArr719 = bArr41;
                                java.lang.System.arraycopy(bArr719, 0, bArr718, length1111, bArr719.length);
                                int length1112 = length1111 + bArr719.length;
                                byte[] bArr7110 = bArr8;
                                java.lang.System.arraycopy(bArr7110, 0, bArr718, length1112, bArr7110.length);
                                int length1113 = length1112 + bArr7110.length;
                                byte[] bArr7111 = bArr30;
                                java.lang.System.arraycopy(bArr7111, 0, bArr718, length1113, bArr7111.length);
                                int length1114 = length1113 + bArr7111.length;
                                java.lang.System.arraycopy(bArr42, 0, bArr718, length1114, bArr42.length);
                                int length1115 = length1114 + bArr42.length;
                                java.lang.System.arraycopy(bArr43, 0, bArr718, length1115, bArr43.length);
                                int length1116 = length1115 + bArr43.length;
                                java.lang.System.arraycopy(bArr44, 0, bArr718, length1116, bArr44.length);
                                int length1117 = length1116 + bArr44.length;
                                byte[] bArr7112 = bArr29;
                                java.lang.System.arraycopy(bArr7112, 0, bArr718, length1117, bArr7112.length);
                                int length1118 = length1117 + bArr7112.length;
                                java.lang.System.arraycopy(bArr45, 0, bArr718, length1118, bArr45.length);
                                int length1119 = length1118 + bArr45.length;
                                byte[] bArr7113 = bArr13;
                                java.lang.System.arraycopy(bArr7113, 0, bArr718, length1119, bArr7113.length);
                                int length2110 = length1119 + bArr7113.length;
                                java.lang.System.arraycopy(bArr6110, 0, bArr718, length2110, bArr6110.length);
                                int length2111 = length2110 + bArr6110.length;
                                java.lang.System.arraycopy(bArr6111, 0, bArr718, length2111, bArr6111.length);
                                int length2112 = length2111 + bArr6111.length;
                                byte[] bArr7114 = bArr16;
                                java.lang.System.arraycopy(bArr7114, 0, bArr718, length2112, bArr7114.length);
                                int length2113 = length2112 + bArr7114.length;
                                byte[] bArr7115 = bArr19;
                                java.lang.System.arraycopy(bArr7115, 0, bArr718, length2113, bArr7115.length);
                                int length2114 = length2113 + bArr7115.length;
                                byte[] bArr7116 = bArr22;
                                java.lang.System.arraycopy(bArr7116, 0, bArr718, length2114, bArr7116.length);
                                int length2115 = length2114 + bArr7116.length;
                                java.lang.System.arraycopy(bArr59, 0, bArr718, length2115, bArr59.length);
                                int length2116 = length2115 + bArr59.length;
                                java.lang.System.arraycopy(bArr60, 0, bArr718, length2116, bArr60.length);
                                int length2117 = length2116 + bArr60.length;
                                java.lang.System.arraycopy(bArr617, 0, bArr718, length2117, bArr617.length);
                                java.lang.System.arraycopy(bArr619, 0, bArr718, length2117 + bArr617.length, bArr619.length);
                                int length2118 = bArr619.length;
                                return a(a(bArr718, this.u, i17), this.y, this.A, this.B);
                            }
                            bArr22 = bArr20;
                            bArr23 = bArr57;
                            bArr24 = oicq.wlogin_sdk.request.t.R;
                            if (bArr24 != null) {
                                bArr25 = bArr6;
                            } else {
                                bArr25 = bArr6;
                            }
                            byte[] bArr510 = bArr23;
                            byte[] bArr620 = bArr25;
                            byte[] bArr621 = bArr7;
                            byte[] bArr622 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                            byte[] bArr623 = tlv_t142Var.get_tlv_142(bArr5);
                            i13 = i12 + 1 + 1;
                            str = this.x.g;
                            if (str != null) {
                                i14 = i13;
                                bArr26 = bArr48;
                            } else {
                                i14 = i13;
                                bArr26 = bArr48;
                            }
                            if (bArr3 != null) {
                                bArr27 = bArr50;
                            } else {
                                bArr27 = bArr50;
                            }
                            if (list != null) {
                                bArr28 = bArr51;
                            } else {
                                bArr28 = bArr51;
                            }
                            if (wloginSigInfoA == null) {
                                bArr29 = bArr28;
                                bArr30 = bArr27;
                                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                                bArr31 = bArr53;
                            } else {
                                bArr29 = bArr28;
                                bArr30 = bArr27;
                                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                                bArr31 = bArr53;
                            }
                            byte[] bArr6112 = new byte[4];
                            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6112, 0, i11);
                            tlv_tVar.set_data(bArr6112, 4);
                            byte[] bArr6113 = tlv_tVar.get_buf();
                            byte[] bArr6114 = new byte[6];
                            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6114, 0, oicq.wlogin_sdk.request.t.au);
                            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr6114, 4, 0);
                            tlv_tVar2.set_data(bArr6114, 6);
                            byte[] bArr6115 = tlv_tVar2.get_buf();
                            int i18 = i14 + 1 + 1;
                            int length2119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621.length + bArr622.length + bArr623.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                            byte[] bArr6116 = bArr10;
                            byte[] bArr6117 = bArr31;
                            byte[] bArr7117 = new byte[length2119 + bArr6116.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr510.length + bArr620.length + bArr6113.length + bArr6115.length];
                            java.lang.System.arraycopy(bArr35, 0, bArr7117, 0, bArr35.length);
                            int length316 = bArr35.length + 0;
                            java.lang.System.arraycopy(bArr36, 0, bArr7117, length316, bArr36.length);
                            int length317 = length316 + bArr36.length;
                            java.lang.System.arraycopy(bArr37, 0, bArr7117, length317, bArr37.length);
                            int length318 = length317 + bArr37.length;
                            java.lang.System.arraycopy(bArr40, 0, bArr7117, length318, bArr40.length);
                            int length319 = length318 + bArr40.length;
                            java.lang.System.arraycopy(bArr38, 0, bArr7117, length319, bArr38.length);
                            int length3110 = length319 + bArr38.length;
                            java.lang.System.arraycopy(bArr39, 0, bArr7117, length3110, bArr39.length);
                            int length3111 = length3110 + bArr39.length;
                            java.lang.System.arraycopy(bArr621, 0, bArr7117, length3111, bArr621.length);
                            int length3112 = length3111 + bArr621.length;
                            java.lang.System.arraycopy(bArr622, 0, bArr7117, length3112, bArr622.length);
                            int length3113 = length3112 + bArr622.length;
                            java.lang.System.arraycopy(bArr623, 0, bArr7117, length3113, bArr623.length);
                            int length11110 = length3113 + bArr623.length;
                            java.lang.System.arraycopy(bArr26, 0, bArr7117, length11110, bArr26.length);
                            int length11111 = length11110 + bArr26.length;
                            byte[] bArr7118 = bArr41;
                            java.lang.System.arraycopy(bArr7118, 0, bArr7117, length11111, bArr7118.length);
                            int length11112 = length11111 + bArr7118.length;
                            byte[] bArr7119 = bArr8;
                            java.lang.System.arraycopy(bArr7119, 0, bArr7117, length11112, bArr7119.length);
                            int length11113 = length11112 + bArr7119.length;
                            byte[] bArr71110 = bArr30;
                            java.lang.System.arraycopy(bArr71110, 0, bArr7117, length11113, bArr71110.length);
                            int length11114 = length11113 + bArr71110.length;
                            java.lang.System.arraycopy(bArr42, 0, bArr7117, length11114, bArr42.length);
                            int length11115 = length11114 + bArr42.length;
                            java.lang.System.arraycopy(bArr43, 0, bArr7117, length11115, bArr43.length);
                            int length11116 = length11115 + bArr43.length;
                            java.lang.System.arraycopy(bArr44, 0, bArr7117, length11116, bArr44.length);
                            int length11117 = length11116 + bArr44.length;
                            byte[] bArr71111 = bArr29;
                            java.lang.System.arraycopy(bArr71111, 0, bArr7117, length11117, bArr71111.length);
                            int length11118 = length11117 + bArr71111.length;
                            java.lang.System.arraycopy(bArr45, 0, bArr7117, length11118, bArr45.length);
                            int length11119 = length11118 + bArr45.length;
                            byte[] bArr71112 = bArr13;
                            java.lang.System.arraycopy(bArr71112, 0, bArr7117, length11119, bArr71112.length);
                            int length21110 = length11119 + bArr71112.length;
                            java.lang.System.arraycopy(bArr6116, 0, bArr7117, length21110, bArr6116.length);
                            int length21111 = length21110 + bArr6116.length;
                            java.lang.System.arraycopy(bArr6117, 0, bArr7117, length21111, bArr6117.length);
                            int length21112 = length21111 + bArr6117.length;
                            byte[] bArr71113 = bArr16;
                            java.lang.System.arraycopy(bArr71113, 0, bArr7117, length21112, bArr71113.length);
                            int length21113 = length21112 + bArr71113.length;
                            byte[] bArr71114 = bArr19;
                            java.lang.System.arraycopy(bArr71114, 0, bArr7117, length21113, bArr71114.length);
                            int length21114 = length21113 + bArr71114.length;
                            byte[] bArr71115 = bArr22;
                            java.lang.System.arraycopy(bArr71115, 0, bArr7117, length21114, bArr71115.length);
                            int length21115 = length21114 + bArr71115.length;
                            java.lang.System.arraycopy(bArr510, 0, bArr7117, length21115, bArr510.length);
                            int length21116 = length21115 + bArr510.length;
                            java.lang.System.arraycopy(bArr620, 0, bArr7117, length21116, bArr620.length);
                            int length21117 = length21116 + bArr620.length;
                            java.lang.System.arraycopy(bArr6113, 0, bArr7117, length21117, bArr6113.length);
                            java.lang.System.arraycopy(bArr6115, 0, bArr7117, length21117 + bArr6113.length, bArr6115.length);
                            int length21118 = bArr6115.length;
                            return a(a(bArr7117, this.u, i18), this.y, this.A, this.B);
                        }
                        bArr19 = bArr17;
                        bArr20 = bArr56;
                        bArr21 = oicq.wlogin_sdk.request.l.J;
                        if (bArr21 != null) {
                            bArr22 = bArr20;
                            if (bArr21.length > 0) {
                                bArr41 = bArr41;
                                bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                                i12++;
                            }
                            bArr24 = oicq.wlogin_sdk.request.t.R;
                            if (bArr24 != null) {
                                bArr25 = bArr6;
                            } else {
                                bArr25 = bArr6;
                            }
                            byte[] bArr511 = bArr23;
                            byte[] bArr624 = bArr25;
                            byte[] bArr625 = bArr7;
                            byte[] bArr626 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                            byte[] bArr627 = tlv_t142Var.get_tlv_142(bArr5);
                            i13 = i12 + 1 + 1;
                            str = this.x.g;
                            if (str != null) {
                                i14 = i13;
                                bArr26 = bArr48;
                            } else {
                                i14 = i13;
                                bArr26 = bArr48;
                            }
                            if (bArr3 != null) {
                                bArr27 = bArr50;
                            } else {
                                bArr27 = bArr50;
                            }
                            if (list != null) {
                                bArr28 = bArr51;
                            } else {
                                bArr28 = bArr51;
                            }
                            if (wloginSigInfoA == null) {
                                bArr29 = bArr28;
                                bArr30 = bArr27;
                                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                                bArr31 = bArr53;
                            } else {
                                bArr29 = bArr28;
                                bArr30 = bArr27;
                                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                                bArr31 = bArr53;
                            }
                            byte[] bArr6118 = new byte[4];
                            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6118, 0, i11);
                            tlv_tVar.set_data(bArr6118, 4);
                            byte[] bArr6119 = tlv_tVar.get_buf();
                            byte[] bArr61110 = new byte[6];
                            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61110, 0, oicq.wlogin_sdk.request.t.au);
                            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61110, 4, 0);
                            tlv_tVar2.set_data(bArr61110, 6);
                            byte[] bArr61111 = tlv_tVar2.get_buf();
                            int i19 = i14 + 1 + 1;
                            int length21119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr625.length + bArr626.length + bArr627.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                            byte[] bArr61112 = bArr10;
                            byte[] bArr61113 = bArr31;
                            byte[] bArr71116 = new byte[length21119 + bArr61112.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr511.length + bArr624.length + bArr6119.length + bArr61111.length];
                            java.lang.System.arraycopy(bArr35, 0, bArr71116, 0, bArr35.length);
                            int length3114 = bArr35.length + 0;
                            java.lang.System.arraycopy(bArr36, 0, bArr71116, length3114, bArr36.length);
                            int length3115 = length3114 + bArr36.length;
                            java.lang.System.arraycopy(bArr37, 0, bArr71116, length3115, bArr37.length);
                            int length3116 = length3115 + bArr37.length;
                            java.lang.System.arraycopy(bArr40, 0, bArr71116, length3116, bArr40.length);
                            int length3117 = length3116 + bArr40.length;
                            java.lang.System.arraycopy(bArr38, 0, bArr71116, length3117, bArr38.length);
                            int length3118 = length3117 + bArr38.length;
                            java.lang.System.arraycopy(bArr39, 0, bArr71116, length3118, bArr39.length);
                            int length3119 = length3118 + bArr39.length;
                            java.lang.System.arraycopy(bArr625, 0, bArr71116, length3119, bArr625.length);
                            int length31110 = length3119 + bArr625.length;
                            java.lang.System.arraycopy(bArr626, 0, bArr71116, length31110, bArr626.length);
                            int length31111 = length31110 + bArr626.length;
                            java.lang.System.arraycopy(bArr627, 0, bArr71116, length31111, bArr627.length);
                            int length111110 = length31111 + bArr627.length;
                            java.lang.System.arraycopy(bArr26, 0, bArr71116, length111110, bArr26.length);
                            int length111111 = length111110 + bArr26.length;
                            byte[] bArr71117 = bArr41;
                            java.lang.System.arraycopy(bArr71117, 0, bArr71116, length111111, bArr71117.length);
                            int length111112 = length111111 + bArr71117.length;
                            byte[] bArr71118 = bArr8;
                            java.lang.System.arraycopy(bArr71118, 0, bArr71116, length111112, bArr71118.length);
                            int length111113 = length111112 + bArr71118.length;
                            byte[] bArr71119 = bArr30;
                            java.lang.System.arraycopy(bArr71119, 0, bArr71116, length111113, bArr71119.length);
                            int length111114 = length111113 + bArr71119.length;
                            java.lang.System.arraycopy(bArr42, 0, bArr71116, length111114, bArr42.length);
                            int length111115 = length111114 + bArr42.length;
                            java.lang.System.arraycopy(bArr43, 0, bArr71116, length111115, bArr43.length);
                            int length111116 = length111115 + bArr43.length;
                            java.lang.System.arraycopy(bArr44, 0, bArr71116, length111116, bArr44.length);
                            int length111117 = length111116 + bArr44.length;
                            byte[] bArr711110 = bArr29;
                            java.lang.System.arraycopy(bArr711110, 0, bArr71116, length111117, bArr711110.length);
                            int length111118 = length111117 + bArr711110.length;
                            java.lang.System.arraycopy(bArr45, 0, bArr71116, length111118, bArr45.length);
                            int length111119 = length111118 + bArr45.length;
                            byte[] bArr711111 = bArr13;
                            java.lang.System.arraycopy(bArr711111, 0, bArr71116, length111119, bArr711111.length);
                            int length211110 = length111119 + bArr711111.length;
                            java.lang.System.arraycopy(bArr61112, 0, bArr71116, length211110, bArr61112.length);
                            int length211111 = length211110 + bArr61112.length;
                            java.lang.System.arraycopy(bArr61113, 0, bArr71116, length211111, bArr61113.length);
                            int length211112 = length211111 + bArr61113.length;
                            byte[] bArr711112 = bArr16;
                            java.lang.System.arraycopy(bArr711112, 0, bArr71116, length211112, bArr711112.length);
                            int length211113 = length211112 + bArr711112.length;
                            byte[] bArr711113 = bArr19;
                            java.lang.System.arraycopy(bArr711113, 0, bArr71116, length211113, bArr711113.length);
                            int length211114 = length211113 + bArr711113.length;
                            byte[] bArr711114 = bArr22;
                            java.lang.System.arraycopy(bArr711114, 0, bArr71116, length211114, bArr711114.length);
                            int length211115 = length211114 + bArr711114.length;
                            java.lang.System.arraycopy(bArr511, 0, bArr71116, length211115, bArr511.length);
                            int length211116 = length211115 + bArr511.length;
                            java.lang.System.arraycopy(bArr624, 0, bArr71116, length211116, bArr624.length);
                            int length211117 = length211116 + bArr624.length;
                            java.lang.System.arraycopy(bArr6119, 0, bArr71116, length211117, bArr6119.length);
                            java.lang.System.arraycopy(bArr61111, 0, bArr71116, length211117 + bArr6119.length, bArr61111.length);
                            int length211118 = bArr61111.length;
                            return a(a(bArr71116, this.u, i19), this.y, this.A, this.B);
                        }
                        bArr22 = bArr20;
                        bArr23 = bArr57;
                        bArr24 = oicq.wlogin_sdk.request.t.R;
                        if (bArr24 != null) {
                            bArr25 = bArr6;
                        } else {
                            bArr25 = bArr6;
                        }
                        byte[] bArr512 = bArr23;
                        byte[] bArr628 = bArr25;
                        byte[] bArr629 = bArr7;
                        byte[] bArr6210 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                        byte[] bArr6211 = tlv_t142Var.get_tlv_142(bArr5);
                        i13 = i12 + 1 + 1;
                        str = this.x.g;
                        if (str != null) {
                            i14 = i13;
                            bArr26 = bArr48;
                        } else {
                            i14 = i13;
                            bArr26 = bArr48;
                        }
                        if (bArr3 != null) {
                            bArr27 = bArr50;
                        } else {
                            bArr27 = bArr50;
                        }
                        if (list != null) {
                            bArr28 = bArr51;
                        } else {
                            bArr28 = bArr51;
                        }
                        if (wloginSigInfoA == null) {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        } else {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        }
                        byte[] bArr61114 = new byte[4];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61114, 0, i11);
                        tlv_tVar.set_data(bArr61114, 4);
                        byte[] bArr61115 = tlv_tVar.get_buf();
                        byte[] bArr61116 = new byte[6];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61116, 0, oicq.wlogin_sdk.request.t.au);
                        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61116, 4, 0);
                        tlv_tVar2.set_data(bArr61116, 6);
                        byte[] bArr61117 = tlv_tVar2.get_buf();
                        int i110 = i14 + 1 + 1;
                        int length211119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr629.length + bArr6210.length + bArr6211.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                        byte[] bArr61118 = bArr10;
                        byte[] bArr61119 = bArr31;
                        byte[] bArr711115 = new byte[length211119 + bArr61118.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr512.length + bArr628.length + bArr61115.length + bArr61117.length];
                        java.lang.System.arraycopy(bArr35, 0, bArr711115, 0, bArr35.length);
                        int length31112 = bArr35.length + 0;
                        java.lang.System.arraycopy(bArr36, 0, bArr711115, length31112, bArr36.length);
                        int length31113 = length31112 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr711115, length31113, bArr37.length);
                        int length31114 = length31113 + bArr37.length;
                        java.lang.System.arraycopy(bArr40, 0, bArr711115, length31114, bArr40.length);
                        int length31115 = length31114 + bArr40.length;
                        java.lang.System.arraycopy(bArr38, 0, bArr711115, length31115, bArr38.length);
                        int length31116 = length31115 + bArr38.length;
                        java.lang.System.arraycopy(bArr39, 0, bArr711115, length31116, bArr39.length);
                        int length31117 = length31116 + bArr39.length;
                        java.lang.System.arraycopy(bArr629, 0, bArr711115, length31117, bArr629.length);
                        int length31118 = length31117 + bArr629.length;
                        java.lang.System.arraycopy(bArr6210, 0, bArr711115, length31118, bArr6210.length);
                        int length31119 = length31118 + bArr6210.length;
                        java.lang.System.arraycopy(bArr6211, 0, bArr711115, length31119, bArr6211.length);
                        int length1111110 = length31119 + bArr6211.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr711115, length1111110, bArr26.length);
                        int length1111111 = length1111110 + bArr26.length;
                        byte[] bArr711116 = bArr41;
                        java.lang.System.arraycopy(bArr711116, 0, bArr711115, length1111111, bArr711116.length);
                        int length1111112 = length1111111 + bArr711116.length;
                        byte[] bArr711117 = bArr8;
                        java.lang.System.arraycopy(bArr711117, 0, bArr711115, length1111112, bArr711117.length);
                        int length1111113 = length1111112 + bArr711117.length;
                        byte[] bArr711118 = bArr30;
                        java.lang.System.arraycopy(bArr711118, 0, bArr711115, length1111113, bArr711118.length);
                        int length1111114 = length1111113 + bArr711118.length;
                        java.lang.System.arraycopy(bArr42, 0, bArr711115, length1111114, bArr42.length);
                        int length1111115 = length1111114 + bArr42.length;
                        java.lang.System.arraycopy(bArr43, 0, bArr711115, length1111115, bArr43.length);
                        int length1111116 = length1111115 + bArr43.length;
                        java.lang.System.arraycopy(bArr44, 0, bArr711115, length1111116, bArr44.length);
                        int length1111117 = length1111116 + bArr44.length;
                        byte[] bArr711119 = bArr29;
                        java.lang.System.arraycopy(bArr711119, 0, bArr711115, length1111117, bArr711119.length);
                        int length1111118 = length1111117 + bArr711119.length;
                        java.lang.System.arraycopy(bArr45, 0, bArr711115, length1111118, bArr45.length);
                        int length1111119 = length1111118 + bArr45.length;
                        byte[] bArr7111110 = bArr13;
                        java.lang.System.arraycopy(bArr7111110, 0, bArr711115, length1111119, bArr7111110.length);
                        int length2111110 = length1111119 + bArr7111110.length;
                        java.lang.System.arraycopy(bArr61118, 0, bArr711115, length2111110, bArr61118.length);
                        int length2111111 = length2111110 + bArr61118.length;
                        java.lang.System.arraycopy(bArr61119, 0, bArr711115, length2111111, bArr61119.length);
                        int length2111112 = length2111111 + bArr61119.length;
                        byte[] bArr7111111 = bArr16;
                        java.lang.System.arraycopy(bArr7111111, 0, bArr711115, length2111112, bArr7111111.length);
                        int length2111113 = length2111112 + bArr7111111.length;
                        byte[] bArr7111112 = bArr19;
                        java.lang.System.arraycopy(bArr7111112, 0, bArr711115, length2111113, bArr7111112.length);
                        int length2111114 = length2111113 + bArr7111112.length;
                        byte[] bArr7111113 = bArr22;
                        java.lang.System.arraycopy(bArr7111113, 0, bArr711115, length2111114, bArr7111113.length);
                        int length2111115 = length2111114 + bArr7111113.length;
                        java.lang.System.arraycopy(bArr512, 0, bArr711115, length2111115, bArr512.length);
                        int length2111116 = length2111115 + bArr512.length;
                        java.lang.System.arraycopy(bArr628, 0, bArr711115, length2111116, bArr628.length);
                        int length2111117 = length2111116 + bArr628.length;
                        java.lang.System.arraycopy(bArr61115, 0, bArr711115, length2111117, bArr61115.length);
                        java.lang.System.arraycopy(bArr61117, 0, bArr711115, length2111117 + bArr61115.length, bArr61117.length);
                        int length2111118 = bArr61117.length;
                        return a(a(bArr711115, this.u, i110), this.y, this.A, this.B);
                    }
                    bArr16 = bArr14;
                    bArr17 = bArr55;
                    bArr18 = oicq.wlogin_sdk.request.t.L;
                    if (bArr18 != null) {
                        bArr19 = bArr17;
                        if (bArr18.length > 0) {
                            bArr20 = tlv_t194Var.get_tlv_194(bArr18);
                            i12++;
                        }
                        bArr21 = oicq.wlogin_sdk.request.l.J;
                        if (bArr21 != null) {
                            bArr22 = bArr20;
                            if (bArr21.length > 0) {
                                bArr41 = bArr41;
                                bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                                i12++;
                            }
                            bArr24 = oicq.wlogin_sdk.request.t.R;
                            if (bArr24 != null) {
                                bArr25 = bArr6;
                            } else {
                                bArr25 = bArr6;
                            }
                            byte[] bArr513 = bArr23;
                            byte[] bArr6212 = bArr25;
                            byte[] bArr6213 = bArr7;
                            byte[] bArr6214 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                            byte[] bArr6215 = tlv_t142Var.get_tlv_142(bArr5);
                            i13 = i12 + 1 + 1;
                            str = this.x.g;
                            if (str != null) {
                                i14 = i13;
                                bArr26 = bArr48;
                            } else {
                                i14 = i13;
                                bArr26 = bArr48;
                            }
                            if (bArr3 != null) {
                                bArr27 = bArr50;
                            } else {
                                bArr27 = bArr50;
                            }
                            if (list != null) {
                                bArr28 = bArr51;
                            } else {
                                bArr28 = bArr51;
                            }
                            if (wloginSigInfoA == null) {
                                bArr29 = bArr28;
                                bArr30 = bArr27;
                                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                                bArr31 = bArr53;
                            } else {
                                bArr29 = bArr28;
                                bArr30 = bArr27;
                                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                                bArr31 = bArr53;
                            }
                            byte[] bArr611110 = new byte[4];
                            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611110, 0, i11);
                            tlv_tVar.set_data(bArr611110, 4);
                            byte[] bArr611111 = tlv_tVar.get_buf();
                            byte[] bArr611112 = new byte[6];
                            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611112, 0, oicq.wlogin_sdk.request.t.au);
                            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611112, 4, 0);
                            tlv_tVar2.set_data(bArr611112, 6);
                            byte[] bArr611113 = tlv_tVar2.get_buf();
                            int i111 = i14 + 1 + 1;
                            int length2111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6213.length + bArr6214.length + bArr6215.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                            byte[] bArr611114 = bArr10;
                            byte[] bArr611115 = bArr31;
                            byte[] bArr7111114 = new byte[length2111119 + bArr611114.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr513.length + bArr6212.length + bArr611111.length + bArr611113.length];
                            java.lang.System.arraycopy(bArr35, 0, bArr7111114, 0, bArr35.length);
                            int length311110 = bArr35.length + 0;
                            java.lang.System.arraycopy(bArr36, 0, bArr7111114, length311110, bArr36.length);
                            int length311111 = length311110 + bArr36.length;
                            java.lang.System.arraycopy(bArr37, 0, bArr7111114, length311111, bArr37.length);
                            int length311112 = length311111 + bArr37.length;
                            java.lang.System.arraycopy(bArr40, 0, bArr7111114, length311112, bArr40.length);
                            int length311113 = length311112 + bArr40.length;
                            java.lang.System.arraycopy(bArr38, 0, bArr7111114, length311113, bArr38.length);
                            int length311114 = length311113 + bArr38.length;
                            java.lang.System.arraycopy(bArr39, 0, bArr7111114, length311114, bArr39.length);
                            int length311115 = length311114 + bArr39.length;
                            java.lang.System.arraycopy(bArr6213, 0, bArr7111114, length311115, bArr6213.length);
                            int length311116 = length311115 + bArr6213.length;
                            java.lang.System.arraycopy(bArr6214, 0, bArr7111114, length311116, bArr6214.length);
                            int length311117 = length311116 + bArr6214.length;
                            java.lang.System.arraycopy(bArr6215, 0, bArr7111114, length311117, bArr6215.length);
                            int length11111110 = length311117 + bArr6215.length;
                            java.lang.System.arraycopy(bArr26, 0, bArr7111114, length11111110, bArr26.length);
                            int length11111111 = length11111110 + bArr26.length;
                            byte[] bArr7111115 = bArr41;
                            java.lang.System.arraycopy(bArr7111115, 0, bArr7111114, length11111111, bArr7111115.length);
                            int length11111112 = length11111111 + bArr7111115.length;
                            byte[] bArr7111116 = bArr8;
                            java.lang.System.arraycopy(bArr7111116, 0, bArr7111114, length11111112, bArr7111116.length);
                            int length11111113 = length11111112 + bArr7111116.length;
                            byte[] bArr7111117 = bArr30;
                            java.lang.System.arraycopy(bArr7111117, 0, bArr7111114, length11111113, bArr7111117.length);
                            int length11111114 = length11111113 + bArr7111117.length;
                            java.lang.System.arraycopy(bArr42, 0, bArr7111114, length11111114, bArr42.length);
                            int length11111115 = length11111114 + bArr42.length;
                            java.lang.System.arraycopy(bArr43, 0, bArr7111114, length11111115, bArr43.length);
                            int length11111116 = length11111115 + bArr43.length;
                            java.lang.System.arraycopy(bArr44, 0, bArr7111114, length11111116, bArr44.length);
                            int length11111117 = length11111116 + bArr44.length;
                            byte[] bArr7111118 = bArr29;
                            java.lang.System.arraycopy(bArr7111118, 0, bArr7111114, length11111117, bArr7111118.length);
                            int length11111118 = length11111117 + bArr7111118.length;
                            java.lang.System.arraycopy(bArr45, 0, bArr7111114, length11111118, bArr45.length);
                            int length11111119 = length11111118 + bArr45.length;
                            byte[] bArr7111119 = bArr13;
                            java.lang.System.arraycopy(bArr7111119, 0, bArr7111114, length11111119, bArr7111119.length);
                            int length21111110 = length11111119 + bArr7111119.length;
                            java.lang.System.arraycopy(bArr611114, 0, bArr7111114, length21111110, bArr611114.length);
                            int length21111111 = length21111110 + bArr611114.length;
                            java.lang.System.arraycopy(bArr611115, 0, bArr7111114, length21111111, bArr611115.length);
                            int length21111112 = length21111111 + bArr611115.length;
                            byte[] bArr71111110 = bArr16;
                            java.lang.System.arraycopy(bArr71111110, 0, bArr7111114, length21111112, bArr71111110.length);
                            int length21111113 = length21111112 + bArr71111110.length;
                            byte[] bArr71111111 = bArr19;
                            java.lang.System.arraycopy(bArr71111111, 0, bArr7111114, length21111113, bArr71111111.length);
                            int length21111114 = length21111113 + bArr71111111.length;
                            byte[] bArr71111112 = bArr22;
                            java.lang.System.arraycopy(bArr71111112, 0, bArr7111114, length21111114, bArr71111112.length);
                            int length21111115 = length21111114 + bArr71111112.length;
                            java.lang.System.arraycopy(bArr513, 0, bArr7111114, length21111115, bArr513.length);
                            int length21111116 = length21111115 + bArr513.length;
                            java.lang.System.arraycopy(bArr6212, 0, bArr7111114, length21111116, bArr6212.length);
                            int length21111117 = length21111116 + bArr6212.length;
                            java.lang.System.arraycopy(bArr611111, 0, bArr7111114, length21111117, bArr611111.length);
                            java.lang.System.arraycopy(bArr611113, 0, bArr7111114, length21111117 + bArr611111.length, bArr611113.length);
                            int length21111118 = bArr611113.length;
                            return a(a(bArr7111114, this.u, i111), this.y, this.A, this.B);
                        }
                        bArr22 = bArr20;
                        bArr23 = bArr57;
                        bArr24 = oicq.wlogin_sdk.request.t.R;
                        if (bArr24 != null) {
                            bArr25 = bArr6;
                        } else {
                            bArr25 = bArr6;
                        }
                        byte[] bArr514 = bArr23;
                        byte[] bArr6216 = bArr25;
                        byte[] bArr6217 = bArr7;
                        byte[] bArr6218 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                        byte[] bArr6219 = tlv_t142Var.get_tlv_142(bArr5);
                        i13 = i12 + 1 + 1;
                        str = this.x.g;
                        if (str != null) {
                            i14 = i13;
                            bArr26 = bArr48;
                        } else {
                            i14 = i13;
                            bArr26 = bArr48;
                        }
                        if (bArr3 != null) {
                            bArr27 = bArr50;
                        } else {
                            bArr27 = bArr50;
                        }
                        if (list != null) {
                            bArr28 = bArr51;
                        } else {
                            bArr28 = bArr51;
                        }
                        if (wloginSigInfoA == null) {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        } else {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        }
                        byte[] bArr611116 = new byte[4];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611116, 0, i11);
                        tlv_tVar.set_data(bArr611116, 4);
                        byte[] bArr611117 = tlv_tVar.get_buf();
                        byte[] bArr611118 = new byte[6];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611118, 0, oicq.wlogin_sdk.request.t.au);
                        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611118, 4, 0);
                        tlv_tVar2.set_data(bArr611118, 6);
                        byte[] bArr611119 = tlv_tVar2.get_buf();
                        int i112 = i14 + 1 + 1;
                        int length21111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6217.length + bArr6218.length + bArr6219.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                        byte[] bArr6111110 = bArr10;
                        byte[] bArr6111111 = bArr31;
                        byte[] bArr71111113 = new byte[length21111119 + bArr6111110.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr514.length + bArr6216.length + bArr611117.length + bArr611119.length];
                        java.lang.System.arraycopy(bArr35, 0, bArr71111113, 0, bArr35.length);
                        int length311118 = bArr35.length + 0;
                        java.lang.System.arraycopy(bArr36, 0, bArr71111113, length311118, bArr36.length);
                        int length311119 = length311118 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr71111113, length311119, bArr37.length);
                        int length3111110 = length311119 + bArr37.length;
                        java.lang.System.arraycopy(bArr40, 0, bArr71111113, length3111110, bArr40.length);
                        int length3111111 = length3111110 + bArr40.length;
                        java.lang.System.arraycopy(bArr38, 0, bArr71111113, length3111111, bArr38.length);
                        int length3111112 = length3111111 + bArr38.length;
                        java.lang.System.arraycopy(bArr39, 0, bArr71111113, length3111112, bArr39.length);
                        int length3111113 = length3111112 + bArr39.length;
                        java.lang.System.arraycopy(bArr6217, 0, bArr71111113, length3111113, bArr6217.length);
                        int length3111114 = length3111113 + bArr6217.length;
                        java.lang.System.arraycopy(bArr6218, 0, bArr71111113, length3111114, bArr6218.length);
                        int length3111115 = length3111114 + bArr6218.length;
                        java.lang.System.arraycopy(bArr6219, 0, bArr71111113, length3111115, bArr6219.length);
                        int length111111110 = length3111115 + bArr6219.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr71111113, length111111110, bArr26.length);
                        int length111111111 = length111111110 + bArr26.length;
                        byte[] bArr71111114 = bArr41;
                        java.lang.System.arraycopy(bArr71111114, 0, bArr71111113, length111111111, bArr71111114.length);
                        int length111111112 = length111111111 + bArr71111114.length;
                        byte[] bArr71111115 = bArr8;
                        java.lang.System.arraycopy(bArr71111115, 0, bArr71111113, length111111112, bArr71111115.length);
                        int length111111113 = length111111112 + bArr71111115.length;
                        byte[] bArr71111116 = bArr30;
                        java.lang.System.arraycopy(bArr71111116, 0, bArr71111113, length111111113, bArr71111116.length);
                        int length111111114 = length111111113 + bArr71111116.length;
                        java.lang.System.arraycopy(bArr42, 0, bArr71111113, length111111114, bArr42.length);
                        int length111111115 = length111111114 + bArr42.length;
                        java.lang.System.arraycopy(bArr43, 0, bArr71111113, length111111115, bArr43.length);
                        int length111111116 = length111111115 + bArr43.length;
                        java.lang.System.arraycopy(bArr44, 0, bArr71111113, length111111116, bArr44.length);
                        int length111111117 = length111111116 + bArr44.length;
                        byte[] bArr71111117 = bArr29;
                        java.lang.System.arraycopy(bArr71111117, 0, bArr71111113, length111111117, bArr71111117.length);
                        int length111111118 = length111111117 + bArr71111117.length;
                        java.lang.System.arraycopy(bArr45, 0, bArr71111113, length111111118, bArr45.length);
                        int length111111119 = length111111118 + bArr45.length;
                        byte[] bArr71111118 = bArr13;
                        java.lang.System.arraycopy(bArr71111118, 0, bArr71111113, length111111119, bArr71111118.length);
                        int length211111110 = length111111119 + bArr71111118.length;
                        java.lang.System.arraycopy(bArr6111110, 0, bArr71111113, length211111110, bArr6111110.length);
                        int length211111111 = length211111110 + bArr6111110.length;
                        java.lang.System.arraycopy(bArr6111111, 0, bArr71111113, length211111111, bArr6111111.length);
                        int length211111112 = length211111111 + bArr6111111.length;
                        byte[] bArr71111119 = bArr16;
                        java.lang.System.arraycopy(bArr71111119, 0, bArr71111113, length211111112, bArr71111119.length);
                        int length211111113 = length211111112 + bArr71111119.length;
                        byte[] bArr711111110 = bArr19;
                        java.lang.System.arraycopy(bArr711111110, 0, bArr71111113, length211111113, bArr711111110.length);
                        int length211111114 = length211111113 + bArr711111110.length;
                        byte[] bArr711111111 = bArr22;
                        java.lang.System.arraycopy(bArr711111111, 0, bArr71111113, length211111114, bArr711111111.length);
                        int length211111115 = length211111114 + bArr711111111.length;
                        java.lang.System.arraycopy(bArr514, 0, bArr71111113, length211111115, bArr514.length);
                        int length211111116 = length211111115 + bArr514.length;
                        java.lang.System.arraycopy(bArr6216, 0, bArr71111113, length211111116, bArr6216.length);
                        int length211111117 = length211111116 + bArr6216.length;
                        java.lang.System.arraycopy(bArr611117, 0, bArr71111113, length211111117, bArr611117.length);
                        java.lang.System.arraycopy(bArr611119, 0, bArr71111113, length211111117 + bArr611117.length, bArr611119.length);
                        int length211111118 = bArr611119.length;
                        return a(a(bArr71111113, this.u, i112), this.y, this.A, this.B);
                    }
                    bArr19 = bArr17;
                    bArr20 = bArr56;
                    bArr21 = oicq.wlogin_sdk.request.l.J;
                    if (bArr21 != null) {
                        bArr22 = bArr20;
                        if (bArr21.length > 0) {
                            bArr41 = bArr41;
                            bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                            i12++;
                        }
                        bArr24 = oicq.wlogin_sdk.request.t.R;
                        if (bArr24 != null) {
                            bArr25 = bArr6;
                        } else {
                            bArr25 = bArr6;
                        }
                        byte[] bArr515 = bArr23;
                        byte[] bArr62110 = bArr25;
                        byte[] bArr62111 = bArr7;
                        byte[] bArr62112 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                        byte[] bArr62113 = tlv_t142Var.get_tlv_142(bArr5);
                        i13 = i12 + 1 + 1;
                        str = this.x.g;
                        if (str != null) {
                            i14 = i13;
                            bArr26 = bArr48;
                        } else {
                            i14 = i13;
                            bArr26 = bArr48;
                        }
                        if (bArr3 != null) {
                            bArr27 = bArr50;
                        } else {
                            bArr27 = bArr50;
                        }
                        if (list != null) {
                            bArr28 = bArr51;
                        } else {
                            bArr28 = bArr51;
                        }
                        if (wloginSigInfoA == null) {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        } else {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        }
                        byte[] bArr6111112 = new byte[4];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111112, 0, i11);
                        tlv_tVar.set_data(bArr6111112, 4);
                        byte[] bArr6111113 = tlv_tVar.get_buf();
                        byte[] bArr6111114 = new byte[6];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111114, 0, oicq.wlogin_sdk.request.t.au);
                        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr6111114, 4, 0);
                        tlv_tVar2.set_data(bArr6111114, 6);
                        byte[] bArr6111115 = tlv_tVar2.get_buf();
                        int i113 = i14 + 1 + 1;
                        int length211111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111.length + bArr62112.length + bArr62113.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                        byte[] bArr6111116 = bArr10;
                        byte[] bArr6111117 = bArr31;
                        byte[] bArr711111112 = new byte[length211111119 + bArr6111116.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr515.length + bArr62110.length + bArr6111113.length + bArr6111115.length];
                        java.lang.System.arraycopy(bArr35, 0, bArr711111112, 0, bArr35.length);
                        int length3111116 = bArr35.length + 0;
                        java.lang.System.arraycopy(bArr36, 0, bArr711111112, length3111116, bArr36.length);
                        int length3111117 = length3111116 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr711111112, length3111117, bArr37.length);
                        int length3111118 = length3111117 + bArr37.length;
                        java.lang.System.arraycopy(bArr40, 0, bArr711111112, length3111118, bArr40.length);
                        int length3111119 = length3111118 + bArr40.length;
                        java.lang.System.arraycopy(bArr38, 0, bArr711111112, length3111119, bArr38.length);
                        int length31111110 = length3111119 + bArr38.length;
                        java.lang.System.arraycopy(bArr39, 0, bArr711111112, length31111110, bArr39.length);
                        int length31111111 = length31111110 + bArr39.length;
                        java.lang.System.arraycopy(bArr62111, 0, bArr711111112, length31111111, bArr62111.length);
                        int length31111112 = length31111111 + bArr62111.length;
                        java.lang.System.arraycopy(bArr62112, 0, bArr711111112, length31111112, bArr62112.length);
                        int length31111113 = length31111112 + bArr62112.length;
                        java.lang.System.arraycopy(bArr62113, 0, bArr711111112, length31111113, bArr62113.length);
                        int length1111111110 = length31111113 + bArr62113.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr711111112, length1111111110, bArr26.length);
                        int length1111111111 = length1111111110 + bArr26.length;
                        byte[] bArr711111113 = bArr41;
                        java.lang.System.arraycopy(bArr711111113, 0, bArr711111112, length1111111111, bArr711111113.length);
                        int length1111111112 = length1111111111 + bArr711111113.length;
                        byte[] bArr711111114 = bArr8;
                        java.lang.System.arraycopy(bArr711111114, 0, bArr711111112, length1111111112, bArr711111114.length);
                        int length1111111113 = length1111111112 + bArr711111114.length;
                        byte[] bArr711111115 = bArr30;
                        java.lang.System.arraycopy(bArr711111115, 0, bArr711111112, length1111111113, bArr711111115.length);
                        int length1111111114 = length1111111113 + bArr711111115.length;
                        java.lang.System.arraycopy(bArr42, 0, bArr711111112, length1111111114, bArr42.length);
                        int length1111111115 = length1111111114 + bArr42.length;
                        java.lang.System.arraycopy(bArr43, 0, bArr711111112, length1111111115, bArr43.length);
                        int length1111111116 = length1111111115 + bArr43.length;
                        java.lang.System.arraycopy(bArr44, 0, bArr711111112, length1111111116, bArr44.length);
                        int length1111111117 = length1111111116 + bArr44.length;
                        byte[] bArr711111116 = bArr29;
                        java.lang.System.arraycopy(bArr711111116, 0, bArr711111112, length1111111117, bArr711111116.length);
                        int length1111111118 = length1111111117 + bArr711111116.length;
                        java.lang.System.arraycopy(bArr45, 0, bArr711111112, length1111111118, bArr45.length);
                        int length1111111119 = length1111111118 + bArr45.length;
                        byte[] bArr711111117 = bArr13;
                        java.lang.System.arraycopy(bArr711111117, 0, bArr711111112, length1111111119, bArr711111117.length);
                        int length2111111110 = length1111111119 + bArr711111117.length;
                        java.lang.System.arraycopy(bArr6111116, 0, bArr711111112, length2111111110, bArr6111116.length);
                        int length2111111111 = length2111111110 + bArr6111116.length;
                        java.lang.System.arraycopy(bArr6111117, 0, bArr711111112, length2111111111, bArr6111117.length);
                        int length2111111112 = length2111111111 + bArr6111117.length;
                        byte[] bArr711111118 = bArr16;
                        java.lang.System.arraycopy(bArr711111118, 0, bArr711111112, length2111111112, bArr711111118.length);
                        int length2111111113 = length2111111112 + bArr711111118.length;
                        byte[] bArr711111119 = bArr19;
                        java.lang.System.arraycopy(bArr711111119, 0, bArr711111112, length2111111113, bArr711111119.length);
                        int length2111111114 = length2111111113 + bArr711111119.length;
                        byte[] bArr7111111110 = bArr22;
                        java.lang.System.arraycopy(bArr7111111110, 0, bArr711111112, length2111111114, bArr7111111110.length);
                        int length2111111115 = length2111111114 + bArr7111111110.length;
                        java.lang.System.arraycopy(bArr515, 0, bArr711111112, length2111111115, bArr515.length);
                        int length2111111116 = length2111111115 + bArr515.length;
                        java.lang.System.arraycopy(bArr62110, 0, bArr711111112, length2111111116, bArr62110.length);
                        int length2111111117 = length2111111116 + bArr62110.length;
                        java.lang.System.arraycopy(bArr6111113, 0, bArr711111112, length2111111117, bArr6111113.length);
                        java.lang.System.arraycopy(bArr6111115, 0, bArr711111112, length2111111117 + bArr6111113.length, bArr6111115.length);
                        int length2111111118 = bArr6111115.length;
                        return a(a(bArr711111112, this.u, i113), this.y, this.A, this.B);
                    }
                    bArr22 = bArr20;
                    bArr23 = bArr57;
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr516 = bArr23;
                    byte[] bArr62114 = bArr25;
                    byte[] bArr62115 = bArr7;
                    byte[] bArr62116 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr62117 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr6111118 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111118, 0, i11);
                    tlv_tVar.set_data(bArr6111118, 4);
                    byte[] bArr6111119 = tlv_tVar.get_buf();
                    byte[] bArr61111110 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111110, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111110, 4, 0);
                    tlv_tVar2.set_data(bArr61111110, 6);
                    byte[] bArr61111111 = tlv_tVar2.get_buf();
                    int i114 = i14 + 1 + 1;
                    int length2111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62115.length + bArr62116.length + bArr62117.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr61111112 = bArr10;
                    byte[] bArr61111113 = bArr31;
                    byte[] bArr7111111111 = new byte[length2111111119 + bArr61111112.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr516.length + bArr62114.length + bArr6111119.length + bArr61111111.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr7111111111, 0, bArr35.length);
                    int length31111114 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr7111111111, length31111114, bArr36.length);
                    int length31111115 = length31111114 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr7111111111, length31111115, bArr37.length);
                    int length31111116 = length31111115 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr7111111111, length31111116, bArr40.length);
                    int length31111117 = length31111116 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr7111111111, length31111117, bArr38.length);
                    int length31111118 = length31111117 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr7111111111, length31111118, bArr39.length);
                    int length31111119 = length31111118 + bArr39.length;
                    java.lang.System.arraycopy(bArr62115, 0, bArr7111111111, length31111119, bArr62115.length);
                    int length311111110 = length31111119 + bArr62115.length;
                    java.lang.System.arraycopy(bArr62116, 0, bArr7111111111, length311111110, bArr62116.length);
                    int length311111111 = length311111110 + bArr62116.length;
                    java.lang.System.arraycopy(bArr62117, 0, bArr7111111111, length311111111, bArr62117.length);
                    int length11111111110 = length311111111 + bArr62117.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr7111111111, length11111111110, bArr26.length);
                    int length11111111111 = length11111111110 + bArr26.length;
                    byte[] bArr7111111112 = bArr41;
                    java.lang.System.arraycopy(bArr7111111112, 0, bArr7111111111, length11111111111, bArr7111111112.length);
                    int length11111111112 = length11111111111 + bArr7111111112.length;
                    byte[] bArr7111111113 = bArr8;
                    java.lang.System.arraycopy(bArr7111111113, 0, bArr7111111111, length11111111112, bArr7111111113.length);
                    int length11111111113 = length11111111112 + bArr7111111113.length;
                    byte[] bArr7111111114 = bArr30;
                    java.lang.System.arraycopy(bArr7111111114, 0, bArr7111111111, length11111111113, bArr7111111114.length);
                    int length11111111114 = length11111111113 + bArr7111111114.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr7111111111, length11111111114, bArr42.length);
                    int length11111111115 = length11111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr7111111111, length11111111115, bArr43.length);
                    int length11111111116 = length11111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr7111111111, length11111111116, bArr44.length);
                    int length11111111117 = length11111111116 + bArr44.length;
                    byte[] bArr7111111115 = bArr29;
                    java.lang.System.arraycopy(bArr7111111115, 0, bArr7111111111, length11111111117, bArr7111111115.length);
                    int length11111111118 = length11111111117 + bArr7111111115.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr7111111111, length11111111118, bArr45.length);
                    int length11111111119 = length11111111118 + bArr45.length;
                    byte[] bArr7111111116 = bArr13;
                    java.lang.System.arraycopy(bArr7111111116, 0, bArr7111111111, length11111111119, bArr7111111116.length);
                    int length21111111110 = length11111111119 + bArr7111111116.length;
                    java.lang.System.arraycopy(bArr61111112, 0, bArr7111111111, length21111111110, bArr61111112.length);
                    int length21111111111 = length21111111110 + bArr61111112.length;
                    java.lang.System.arraycopy(bArr61111113, 0, bArr7111111111, length21111111111, bArr61111113.length);
                    int length21111111112 = length21111111111 + bArr61111113.length;
                    byte[] bArr7111111117 = bArr16;
                    java.lang.System.arraycopy(bArr7111111117, 0, bArr7111111111, length21111111112, bArr7111111117.length);
                    int length21111111113 = length21111111112 + bArr7111111117.length;
                    byte[] bArr7111111118 = bArr19;
                    java.lang.System.arraycopy(bArr7111111118, 0, bArr7111111111, length21111111113, bArr7111111118.length);
                    int length21111111114 = length21111111113 + bArr7111111118.length;
                    byte[] bArr7111111119 = bArr22;
                    java.lang.System.arraycopy(bArr7111111119, 0, bArr7111111111, length21111111114, bArr7111111119.length);
                    int length21111111115 = length21111111114 + bArr7111111119.length;
                    java.lang.System.arraycopy(bArr516, 0, bArr7111111111, length21111111115, bArr516.length);
                    int length21111111116 = length21111111115 + bArr516.length;
                    java.lang.System.arraycopy(bArr62114, 0, bArr7111111111, length21111111116, bArr62114.length);
                    int length21111111117 = length21111111116 + bArr62114.length;
                    java.lang.System.arraycopy(bArr6111119, 0, bArr7111111111, length21111111117, bArr6111119.length);
                    java.lang.System.arraycopy(bArr61111111, 0, bArr7111111111, length21111111117 + bArr6111119.length, bArr61111111.length);
                    int length21111111118 = bArr61111111.length;
                    return a(a(bArr7111111111, this.u, i114), this.y, this.A, this.B);
                }
                bArr13 = bArr11;
                bArr14 = bArr54;
                bArr15 = oicq.wlogin_sdk.request.t.O;
                if (bArr15 != null) {
                    bArr16 = bArr14;
                    if (bArr15.length > 0) {
                        bArr17 = tlv_t188Var.get_tlv_188(bArr15);
                        i12++;
                    }
                    bArr18 = oicq.wlogin_sdk.request.t.L;
                    if (bArr18 != null) {
                        bArr19 = bArr17;
                        if (bArr18.length > 0) {
                            bArr20 = tlv_t194Var.get_tlv_194(bArr18);
                            i12++;
                        }
                        bArr21 = oicq.wlogin_sdk.request.l.J;
                        if (bArr21 != null) {
                            bArr22 = bArr20;
                            if (bArr21.length > 0) {
                                bArr41 = bArr41;
                                bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                                i12++;
                            }
                            bArr24 = oicq.wlogin_sdk.request.t.R;
                            if (bArr24 != null) {
                                bArr25 = bArr6;
                            } else {
                                bArr25 = bArr6;
                            }
                            byte[] bArr517 = bArr23;
                            byte[] bArr62118 = bArr25;
                            byte[] bArr62119 = bArr7;
                            byte[] bArr621110 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                            byte[] bArr621111 = tlv_t142Var.get_tlv_142(bArr5);
                            i13 = i12 + 1 + 1;
                            str = this.x.g;
                            if (str != null) {
                                i14 = i13;
                                bArr26 = bArr48;
                            } else {
                                i14 = i13;
                                bArr26 = bArr48;
                            }
                            if (bArr3 != null) {
                                bArr27 = bArr50;
                            } else {
                                bArr27 = bArr50;
                            }
                            if (list != null) {
                                bArr28 = bArr51;
                            } else {
                                bArr28 = bArr51;
                            }
                            if (wloginSigInfoA == null) {
                                bArr29 = bArr28;
                                bArr30 = bArr27;
                                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                                bArr31 = bArr53;
                            } else {
                                bArr29 = bArr28;
                                bArr30 = bArr27;
                                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                                bArr31 = bArr53;
                            }
                            byte[] bArr61111114 = new byte[4];
                            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111114, 0, i11);
                            tlv_tVar.set_data(bArr61111114, 4);
                            byte[] bArr61111115 = tlv_tVar.get_buf();
                            byte[] bArr61111116 = new byte[6];
                            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111116, 0, oicq.wlogin_sdk.request.t.au);
                            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111116, 4, 0);
                            tlv_tVar2.set_data(bArr61111116, 6);
                            byte[] bArr61111117 = tlv_tVar2.get_buf();
                            int i115 = i14 + 1 + 1;
                            int length21111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62119.length + bArr621110.length + bArr621111.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                            byte[] bArr61111118 = bArr10;
                            byte[] bArr61111119 = bArr31;
                            byte[] bArr71111111110 = new byte[length21111111119 + bArr61111118.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr517.length + bArr62118.length + bArr61111115.length + bArr61111117.length];
                            java.lang.System.arraycopy(bArr35, 0, bArr71111111110, 0, bArr35.length);
                            int length311111112 = bArr35.length + 0;
                            java.lang.System.arraycopy(bArr36, 0, bArr71111111110, length311111112, bArr36.length);
                            int length311111113 = length311111112 + bArr36.length;
                            java.lang.System.arraycopy(bArr37, 0, bArr71111111110, length311111113, bArr37.length);
                            int length311111114 = length311111113 + bArr37.length;
                            java.lang.System.arraycopy(bArr40, 0, bArr71111111110, length311111114, bArr40.length);
                            int length311111115 = length311111114 + bArr40.length;
                            java.lang.System.arraycopy(bArr38, 0, bArr71111111110, length311111115, bArr38.length);
                            int length311111116 = length311111115 + bArr38.length;
                            java.lang.System.arraycopy(bArr39, 0, bArr71111111110, length311111116, bArr39.length);
                            int length311111117 = length311111116 + bArr39.length;
                            java.lang.System.arraycopy(bArr62119, 0, bArr71111111110, length311111117, bArr62119.length);
                            int length311111118 = length311111117 + bArr62119.length;
                            java.lang.System.arraycopy(bArr621110, 0, bArr71111111110, length311111118, bArr621110.length);
                            int length311111119 = length311111118 + bArr621110.length;
                            java.lang.System.arraycopy(bArr621111, 0, bArr71111111110, length311111119, bArr621111.length);
                            int length111111111110 = length311111119 + bArr621111.length;
                            java.lang.System.arraycopy(bArr26, 0, bArr71111111110, length111111111110, bArr26.length);
                            int length111111111111 = length111111111110 + bArr26.length;
                            byte[] bArr71111111111 = bArr41;
                            java.lang.System.arraycopy(bArr71111111111, 0, bArr71111111110, length111111111111, bArr71111111111.length);
                            int length111111111112 = length111111111111 + bArr71111111111.length;
                            byte[] bArr71111111112 = bArr8;
                            java.lang.System.arraycopy(bArr71111111112, 0, bArr71111111110, length111111111112, bArr71111111112.length);
                            int length111111111113 = length111111111112 + bArr71111111112.length;
                            byte[] bArr71111111113 = bArr30;
                            java.lang.System.arraycopy(bArr71111111113, 0, bArr71111111110, length111111111113, bArr71111111113.length);
                            int length111111111114 = length111111111113 + bArr71111111113.length;
                            java.lang.System.arraycopy(bArr42, 0, bArr71111111110, length111111111114, bArr42.length);
                            int length111111111115 = length111111111114 + bArr42.length;
                            java.lang.System.arraycopy(bArr43, 0, bArr71111111110, length111111111115, bArr43.length);
                            int length111111111116 = length111111111115 + bArr43.length;
                            java.lang.System.arraycopy(bArr44, 0, bArr71111111110, length111111111116, bArr44.length);
                            int length111111111117 = length111111111116 + bArr44.length;
                            byte[] bArr71111111114 = bArr29;
                            java.lang.System.arraycopy(bArr71111111114, 0, bArr71111111110, length111111111117, bArr71111111114.length);
                            int length111111111118 = length111111111117 + bArr71111111114.length;
                            java.lang.System.arraycopy(bArr45, 0, bArr71111111110, length111111111118, bArr45.length);
                            int length111111111119 = length111111111118 + bArr45.length;
                            byte[] bArr71111111115 = bArr13;
                            java.lang.System.arraycopy(bArr71111111115, 0, bArr71111111110, length111111111119, bArr71111111115.length);
                            int length211111111110 = length111111111119 + bArr71111111115.length;
                            java.lang.System.arraycopy(bArr61111118, 0, bArr71111111110, length211111111110, bArr61111118.length);
                            int length211111111111 = length211111111110 + bArr61111118.length;
                            java.lang.System.arraycopy(bArr61111119, 0, bArr71111111110, length211111111111, bArr61111119.length);
                            int length211111111112 = length211111111111 + bArr61111119.length;
                            byte[] bArr71111111116 = bArr16;
                            java.lang.System.arraycopy(bArr71111111116, 0, bArr71111111110, length211111111112, bArr71111111116.length);
                            int length211111111113 = length211111111112 + bArr71111111116.length;
                            byte[] bArr71111111117 = bArr19;
                            java.lang.System.arraycopy(bArr71111111117, 0, bArr71111111110, length211111111113, bArr71111111117.length);
                            int length211111111114 = length211111111113 + bArr71111111117.length;
                            byte[] bArr71111111118 = bArr22;
                            java.lang.System.arraycopy(bArr71111111118, 0, bArr71111111110, length211111111114, bArr71111111118.length);
                            int length211111111115 = length211111111114 + bArr71111111118.length;
                            java.lang.System.arraycopy(bArr517, 0, bArr71111111110, length211111111115, bArr517.length);
                            int length211111111116 = length211111111115 + bArr517.length;
                            java.lang.System.arraycopy(bArr62118, 0, bArr71111111110, length211111111116, bArr62118.length);
                            int length211111111117 = length211111111116 + bArr62118.length;
                            java.lang.System.arraycopy(bArr61111115, 0, bArr71111111110, length211111111117, bArr61111115.length);
                            java.lang.System.arraycopy(bArr61111117, 0, bArr71111111110, length211111111117 + bArr61111115.length, bArr61111117.length);
                            int length211111111118 = bArr61111117.length;
                            return a(a(bArr71111111110, this.u, i115), this.y, this.A, this.B);
                        }
                        bArr22 = bArr20;
                        bArr23 = bArr57;
                        bArr24 = oicq.wlogin_sdk.request.t.R;
                        if (bArr24 != null) {
                            bArr25 = bArr6;
                        } else {
                            bArr25 = bArr6;
                        }
                        byte[] bArr518 = bArr23;
                        byte[] bArr621112 = bArr25;
                        byte[] bArr621113 = bArr7;
                        byte[] bArr621114 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                        byte[] bArr621115 = tlv_t142Var.get_tlv_142(bArr5);
                        i13 = i12 + 1 + 1;
                        str = this.x.g;
                        if (str != null) {
                            i14 = i13;
                            bArr26 = bArr48;
                        } else {
                            i14 = i13;
                            bArr26 = bArr48;
                        }
                        if (bArr3 != null) {
                            bArr27 = bArr50;
                        } else {
                            bArr27 = bArr50;
                        }
                        if (list != null) {
                            bArr28 = bArr51;
                        } else {
                            bArr28 = bArr51;
                        }
                        if (wloginSigInfoA == null) {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        } else {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        }
                        byte[] bArr611111110 = new byte[4];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111110, 0, i11);
                        tlv_tVar.set_data(bArr611111110, 4);
                        byte[] bArr611111111 = tlv_tVar.get_buf();
                        byte[] bArr611111112 = new byte[6];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111112, 0, oicq.wlogin_sdk.request.t.au);
                        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111112, 4, 0);
                        tlv_tVar2.set_data(bArr611111112, 6);
                        byte[] bArr611111113 = tlv_tVar2.get_buf();
                        int i116 = i14 + 1 + 1;
                        int length211111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621113.length + bArr621114.length + bArr621115.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                        byte[] bArr611111114 = bArr10;
                        byte[] bArr611111115 = bArr31;
                        byte[] bArr71111111119 = new byte[length211111111119 + bArr611111114.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr518.length + bArr621112.length + bArr611111111.length + bArr611111113.length];
                        java.lang.System.arraycopy(bArr35, 0, bArr71111111119, 0, bArr35.length);
                        int length3111111110 = bArr35.length + 0;
                        java.lang.System.arraycopy(bArr36, 0, bArr71111111119, length3111111110, bArr36.length);
                        int length3111111111 = length3111111110 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr71111111119, length3111111111, bArr37.length);
                        int length3111111112 = length3111111111 + bArr37.length;
                        java.lang.System.arraycopy(bArr40, 0, bArr71111111119, length3111111112, bArr40.length);
                        int length3111111113 = length3111111112 + bArr40.length;
                        java.lang.System.arraycopy(bArr38, 0, bArr71111111119, length3111111113, bArr38.length);
                        int length3111111114 = length3111111113 + bArr38.length;
                        java.lang.System.arraycopy(bArr39, 0, bArr71111111119, length3111111114, bArr39.length);
                        int length3111111115 = length3111111114 + bArr39.length;
                        java.lang.System.arraycopy(bArr621113, 0, bArr71111111119, length3111111115, bArr621113.length);
                        int length3111111116 = length3111111115 + bArr621113.length;
                        java.lang.System.arraycopy(bArr621114, 0, bArr71111111119, length3111111116, bArr621114.length);
                        int length3111111117 = length3111111116 + bArr621114.length;
                        java.lang.System.arraycopy(bArr621115, 0, bArr71111111119, length3111111117, bArr621115.length);
                        int length1111111111110 = length3111111117 + bArr621115.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr71111111119, length1111111111110, bArr26.length);
                        int length1111111111111 = length1111111111110 + bArr26.length;
                        byte[] bArr711111111110 = bArr41;
                        java.lang.System.arraycopy(bArr711111111110, 0, bArr71111111119, length1111111111111, bArr711111111110.length);
                        int length1111111111112 = length1111111111111 + bArr711111111110.length;
                        byte[] bArr711111111111 = bArr8;
                        java.lang.System.arraycopy(bArr711111111111, 0, bArr71111111119, length1111111111112, bArr711111111111.length);
                        int length1111111111113 = length1111111111112 + bArr711111111111.length;
                        byte[] bArr711111111112 = bArr30;
                        java.lang.System.arraycopy(bArr711111111112, 0, bArr71111111119, length1111111111113, bArr711111111112.length);
                        int length1111111111114 = length1111111111113 + bArr711111111112.length;
                        java.lang.System.arraycopy(bArr42, 0, bArr71111111119, length1111111111114, bArr42.length);
                        int length1111111111115 = length1111111111114 + bArr42.length;
                        java.lang.System.arraycopy(bArr43, 0, bArr71111111119, length1111111111115, bArr43.length);
                        int length1111111111116 = length1111111111115 + bArr43.length;
                        java.lang.System.arraycopy(bArr44, 0, bArr71111111119, length1111111111116, bArr44.length);
                        int length1111111111117 = length1111111111116 + bArr44.length;
                        byte[] bArr711111111113 = bArr29;
                        java.lang.System.arraycopy(bArr711111111113, 0, bArr71111111119, length1111111111117, bArr711111111113.length);
                        int length1111111111118 = length1111111111117 + bArr711111111113.length;
                        java.lang.System.arraycopy(bArr45, 0, bArr71111111119, length1111111111118, bArr45.length);
                        int length1111111111119 = length1111111111118 + bArr45.length;
                        byte[] bArr711111111114 = bArr13;
                        java.lang.System.arraycopy(bArr711111111114, 0, bArr71111111119, length1111111111119, bArr711111111114.length);
                        int length2111111111110 = length1111111111119 + bArr711111111114.length;
                        java.lang.System.arraycopy(bArr611111114, 0, bArr71111111119, length2111111111110, bArr611111114.length);
                        int length2111111111111 = length2111111111110 + bArr611111114.length;
                        java.lang.System.arraycopy(bArr611111115, 0, bArr71111111119, length2111111111111, bArr611111115.length);
                        int length2111111111112 = length2111111111111 + bArr611111115.length;
                        byte[] bArr711111111115 = bArr16;
                        java.lang.System.arraycopy(bArr711111111115, 0, bArr71111111119, length2111111111112, bArr711111111115.length);
                        int length2111111111113 = length2111111111112 + bArr711111111115.length;
                        byte[] bArr711111111116 = bArr19;
                        java.lang.System.arraycopy(bArr711111111116, 0, bArr71111111119, length2111111111113, bArr711111111116.length);
                        int length2111111111114 = length2111111111113 + bArr711111111116.length;
                        byte[] bArr711111111117 = bArr22;
                        java.lang.System.arraycopy(bArr711111111117, 0, bArr71111111119, length2111111111114, bArr711111111117.length);
                        int length2111111111115 = length2111111111114 + bArr711111111117.length;
                        java.lang.System.arraycopy(bArr518, 0, bArr71111111119, length2111111111115, bArr518.length);
                        int length2111111111116 = length2111111111115 + bArr518.length;
                        java.lang.System.arraycopy(bArr621112, 0, bArr71111111119, length2111111111116, bArr621112.length);
                        int length2111111111117 = length2111111111116 + bArr621112.length;
                        java.lang.System.arraycopy(bArr611111111, 0, bArr71111111119, length2111111111117, bArr611111111.length);
                        java.lang.System.arraycopy(bArr611111113, 0, bArr71111111119, length2111111111117 + bArr611111111.length, bArr611111113.length);
                        int length2111111111118 = bArr611111113.length;
                        return a(a(bArr71111111119, this.u, i116), this.y, this.A, this.B);
                    }
                    bArr19 = bArr17;
                    bArr20 = bArr56;
                    bArr21 = oicq.wlogin_sdk.request.l.J;
                    if (bArr21 != null) {
                        bArr22 = bArr20;
                        if (bArr21.length > 0) {
                            bArr41 = bArr41;
                            bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                            i12++;
                        }
                        bArr24 = oicq.wlogin_sdk.request.t.R;
                        if (bArr24 != null) {
                            bArr25 = bArr6;
                        } else {
                            bArr25 = bArr6;
                        }
                        byte[] bArr519 = bArr23;
                        byte[] bArr621116 = bArr25;
                        byte[] bArr621117 = bArr7;
                        byte[] bArr621118 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                        byte[] bArr621119 = tlv_t142Var.get_tlv_142(bArr5);
                        i13 = i12 + 1 + 1;
                        str = this.x.g;
                        if (str != null) {
                            i14 = i13;
                            bArr26 = bArr48;
                        } else {
                            i14 = i13;
                            bArr26 = bArr48;
                        }
                        if (bArr3 != null) {
                            bArr27 = bArr50;
                        } else {
                            bArr27 = bArr50;
                        }
                        if (list != null) {
                            bArr28 = bArr51;
                        } else {
                            bArr28 = bArr51;
                        }
                        if (wloginSigInfoA == null) {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        } else {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        }
                        byte[] bArr611111116 = new byte[4];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111116, 0, i11);
                        tlv_tVar.set_data(bArr611111116, 4);
                        byte[] bArr611111117 = tlv_tVar.get_buf();
                        byte[] bArr611111118 = new byte[6];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111118, 0, oicq.wlogin_sdk.request.t.au);
                        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111118, 4, 0);
                        tlv_tVar2.set_data(bArr611111118, 6);
                        byte[] bArr611111119 = tlv_tVar2.get_buf();
                        int i117 = i14 + 1 + 1;
                        int length2111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621117.length + bArr621118.length + bArr621119.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                        byte[] bArr6111111110 = bArr10;
                        byte[] bArr6111111111 = bArr31;
                        byte[] bArr711111111118 = new byte[length2111111111119 + bArr6111111110.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr519.length + bArr621116.length + bArr611111117.length + bArr611111119.length];
                        java.lang.System.arraycopy(bArr35, 0, bArr711111111118, 0, bArr35.length);
                        int length3111111118 = bArr35.length + 0;
                        java.lang.System.arraycopy(bArr36, 0, bArr711111111118, length3111111118, bArr36.length);
                        int length3111111119 = length3111111118 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr711111111118, length3111111119, bArr37.length);
                        int length31111111110 = length3111111119 + bArr37.length;
                        java.lang.System.arraycopy(bArr40, 0, bArr711111111118, length31111111110, bArr40.length);
                        int length31111111111 = length31111111110 + bArr40.length;
                        java.lang.System.arraycopy(bArr38, 0, bArr711111111118, length31111111111, bArr38.length);
                        int length31111111112 = length31111111111 + bArr38.length;
                        java.lang.System.arraycopy(bArr39, 0, bArr711111111118, length31111111112, bArr39.length);
                        int length31111111113 = length31111111112 + bArr39.length;
                        java.lang.System.arraycopy(bArr621117, 0, bArr711111111118, length31111111113, bArr621117.length);
                        int length31111111114 = length31111111113 + bArr621117.length;
                        java.lang.System.arraycopy(bArr621118, 0, bArr711111111118, length31111111114, bArr621118.length);
                        int length31111111115 = length31111111114 + bArr621118.length;
                        java.lang.System.arraycopy(bArr621119, 0, bArr711111111118, length31111111115, bArr621119.length);
                        int length11111111111110 = length31111111115 + bArr621119.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr711111111118, length11111111111110, bArr26.length);
                        int length11111111111111 = length11111111111110 + bArr26.length;
                        byte[] bArr711111111119 = bArr41;
                        java.lang.System.arraycopy(bArr711111111119, 0, bArr711111111118, length11111111111111, bArr711111111119.length);
                        int length11111111111112 = length11111111111111 + bArr711111111119.length;
                        byte[] bArr7111111111110 = bArr8;
                        java.lang.System.arraycopy(bArr7111111111110, 0, bArr711111111118, length11111111111112, bArr7111111111110.length);
                        int length11111111111113 = length11111111111112 + bArr7111111111110.length;
                        byte[] bArr7111111111111 = bArr30;
                        java.lang.System.arraycopy(bArr7111111111111, 0, bArr711111111118, length11111111111113, bArr7111111111111.length);
                        int length11111111111114 = length11111111111113 + bArr7111111111111.length;
                        java.lang.System.arraycopy(bArr42, 0, bArr711111111118, length11111111111114, bArr42.length);
                        int length11111111111115 = length11111111111114 + bArr42.length;
                        java.lang.System.arraycopy(bArr43, 0, bArr711111111118, length11111111111115, bArr43.length);
                        int length11111111111116 = length11111111111115 + bArr43.length;
                        java.lang.System.arraycopy(bArr44, 0, bArr711111111118, length11111111111116, bArr44.length);
                        int length11111111111117 = length11111111111116 + bArr44.length;
                        byte[] bArr7111111111112 = bArr29;
                        java.lang.System.arraycopy(bArr7111111111112, 0, bArr711111111118, length11111111111117, bArr7111111111112.length);
                        int length11111111111118 = length11111111111117 + bArr7111111111112.length;
                        java.lang.System.arraycopy(bArr45, 0, bArr711111111118, length11111111111118, bArr45.length);
                        int length11111111111119 = length11111111111118 + bArr45.length;
                        byte[] bArr7111111111113 = bArr13;
                        java.lang.System.arraycopy(bArr7111111111113, 0, bArr711111111118, length11111111111119, bArr7111111111113.length);
                        int length21111111111110 = length11111111111119 + bArr7111111111113.length;
                        java.lang.System.arraycopy(bArr6111111110, 0, bArr711111111118, length21111111111110, bArr6111111110.length);
                        int length21111111111111 = length21111111111110 + bArr6111111110.length;
                        java.lang.System.arraycopy(bArr6111111111, 0, bArr711111111118, length21111111111111, bArr6111111111.length);
                        int length21111111111112 = length21111111111111 + bArr6111111111.length;
                        byte[] bArr7111111111114 = bArr16;
                        java.lang.System.arraycopy(bArr7111111111114, 0, bArr711111111118, length21111111111112, bArr7111111111114.length);
                        int length21111111111113 = length21111111111112 + bArr7111111111114.length;
                        byte[] bArr7111111111115 = bArr19;
                        java.lang.System.arraycopy(bArr7111111111115, 0, bArr711111111118, length21111111111113, bArr7111111111115.length);
                        int length21111111111114 = length21111111111113 + bArr7111111111115.length;
                        byte[] bArr7111111111116 = bArr22;
                        java.lang.System.arraycopy(bArr7111111111116, 0, bArr711111111118, length21111111111114, bArr7111111111116.length);
                        int length21111111111115 = length21111111111114 + bArr7111111111116.length;
                        java.lang.System.arraycopy(bArr519, 0, bArr711111111118, length21111111111115, bArr519.length);
                        int length21111111111116 = length21111111111115 + bArr519.length;
                        java.lang.System.arraycopy(bArr621116, 0, bArr711111111118, length21111111111116, bArr621116.length);
                        int length21111111111117 = length21111111111116 + bArr621116.length;
                        java.lang.System.arraycopy(bArr611111117, 0, bArr711111111118, length21111111111117, bArr611111117.length);
                        java.lang.System.arraycopy(bArr611111119, 0, bArr711111111118, length21111111111117 + bArr611111117.length, bArr611111119.length);
                        int length21111111111118 = bArr611111119.length;
                        return a(a(bArr711111111118, this.u, i117), this.y, this.A, this.B);
                    }
                    bArr22 = bArr20;
                    bArr23 = bArr57;
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr5110 = bArr23;
                    byte[] bArr6211110 = bArr25;
                    byte[] bArr6211111 = bArr7;
                    byte[] bArr6211112 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr6211113 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr6111111112 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111112, 0, i11);
                    tlv_tVar.set_data(bArr6111111112, 4);
                    byte[] bArr6111111113 = tlv_tVar.get_buf();
                    byte[] bArr6111111114 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111114, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr6111111114, 4, 0);
                    tlv_tVar2.set_data(bArr6111111114, 6);
                    byte[] bArr6111111115 = tlv_tVar2.get_buf();
                    int i118 = i14 + 1 + 1;
                    int length21111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211111.length + bArr6211112.length + bArr6211113.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr6111111116 = bArr10;
                    byte[] bArr6111111117 = bArr31;
                    byte[] bArr7111111111117 = new byte[length21111111111119 + bArr6111111116.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5110.length + bArr6211110.length + bArr6111111113.length + bArr6111111115.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr7111111111117, 0, bArr35.length);
                    int length31111111116 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr7111111111117, length31111111116, bArr36.length);
                    int length31111111117 = length31111111116 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr7111111111117, length31111111117, bArr37.length);
                    int length31111111118 = length31111111117 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr7111111111117, length31111111118, bArr40.length);
                    int length31111111119 = length31111111118 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr7111111111117, length31111111119, bArr38.length);
                    int length311111111110 = length31111111119 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr7111111111117, length311111111110, bArr39.length);
                    int length311111111111 = length311111111110 + bArr39.length;
                    java.lang.System.arraycopy(bArr6211111, 0, bArr7111111111117, length311111111111, bArr6211111.length);
                    int length311111111112 = length311111111111 + bArr6211111.length;
                    java.lang.System.arraycopy(bArr6211112, 0, bArr7111111111117, length311111111112, bArr6211112.length);
                    int length311111111113 = length311111111112 + bArr6211112.length;
                    java.lang.System.arraycopy(bArr6211113, 0, bArr7111111111117, length311111111113, bArr6211113.length);
                    int length111111111111110 = length311111111113 + bArr6211113.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr7111111111117, length111111111111110, bArr26.length);
                    int length111111111111111 = length111111111111110 + bArr26.length;
                    byte[] bArr7111111111118 = bArr41;
                    java.lang.System.arraycopy(bArr7111111111118, 0, bArr7111111111117, length111111111111111, bArr7111111111118.length);
                    int length111111111111112 = length111111111111111 + bArr7111111111118.length;
                    byte[] bArr7111111111119 = bArr8;
                    java.lang.System.arraycopy(bArr7111111111119, 0, bArr7111111111117, length111111111111112, bArr7111111111119.length);
                    int length111111111111113 = length111111111111112 + bArr7111111111119.length;
                    byte[] bArr71111111111110 = bArr30;
                    java.lang.System.arraycopy(bArr71111111111110, 0, bArr7111111111117, length111111111111113, bArr71111111111110.length);
                    int length111111111111114 = length111111111111113 + bArr71111111111110.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr7111111111117, length111111111111114, bArr42.length);
                    int length111111111111115 = length111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr7111111111117, length111111111111115, bArr43.length);
                    int length111111111111116 = length111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr7111111111117, length111111111111116, bArr44.length);
                    int length111111111111117 = length111111111111116 + bArr44.length;
                    byte[] bArr71111111111111 = bArr29;
                    java.lang.System.arraycopy(bArr71111111111111, 0, bArr7111111111117, length111111111111117, bArr71111111111111.length);
                    int length111111111111118 = length111111111111117 + bArr71111111111111.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr7111111111117, length111111111111118, bArr45.length);
                    int length111111111111119 = length111111111111118 + bArr45.length;
                    byte[] bArr71111111111112 = bArr13;
                    java.lang.System.arraycopy(bArr71111111111112, 0, bArr7111111111117, length111111111111119, bArr71111111111112.length);
                    int length211111111111110 = length111111111111119 + bArr71111111111112.length;
                    java.lang.System.arraycopy(bArr6111111116, 0, bArr7111111111117, length211111111111110, bArr6111111116.length);
                    int length211111111111111 = length211111111111110 + bArr6111111116.length;
                    java.lang.System.arraycopy(bArr6111111117, 0, bArr7111111111117, length211111111111111, bArr6111111117.length);
                    int length211111111111112 = length211111111111111 + bArr6111111117.length;
                    byte[] bArr71111111111113 = bArr16;
                    java.lang.System.arraycopy(bArr71111111111113, 0, bArr7111111111117, length211111111111112, bArr71111111111113.length);
                    int length211111111111113 = length211111111111112 + bArr71111111111113.length;
                    byte[] bArr71111111111114 = bArr19;
                    java.lang.System.arraycopy(bArr71111111111114, 0, bArr7111111111117, length211111111111113, bArr71111111111114.length);
                    int length211111111111114 = length211111111111113 + bArr71111111111114.length;
                    byte[] bArr71111111111115 = bArr22;
                    java.lang.System.arraycopy(bArr71111111111115, 0, bArr7111111111117, length211111111111114, bArr71111111111115.length);
                    int length211111111111115 = length211111111111114 + bArr71111111111115.length;
                    java.lang.System.arraycopy(bArr5110, 0, bArr7111111111117, length211111111111115, bArr5110.length);
                    int length211111111111116 = length211111111111115 + bArr5110.length;
                    java.lang.System.arraycopy(bArr6211110, 0, bArr7111111111117, length211111111111116, bArr6211110.length);
                    int length211111111111117 = length211111111111116 + bArr6211110.length;
                    java.lang.System.arraycopy(bArr6111111113, 0, bArr7111111111117, length211111111111117, bArr6111111113.length);
                    java.lang.System.arraycopy(bArr6111111115, 0, bArr7111111111117, length211111111111117 + bArr6111111113.length, bArr6111111115.length);
                    int length211111111111118 = bArr6111111115.length;
                    return a(a(bArr7111111111117, this.u, i118), this.y, this.A, this.B);
                }
                bArr16 = bArr14;
                bArr17 = bArr55;
                bArr18 = oicq.wlogin_sdk.request.t.L;
                if (bArr18 != null) {
                    bArr19 = bArr17;
                    if (bArr18.length > 0) {
                        bArr20 = tlv_t194Var.get_tlv_194(bArr18);
                        i12++;
                    }
                    bArr21 = oicq.wlogin_sdk.request.l.J;
                    if (bArr21 != null) {
                        bArr22 = bArr20;
                        if (bArr21.length > 0) {
                            bArr41 = bArr41;
                            bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                            i12++;
                        }
                        bArr24 = oicq.wlogin_sdk.request.t.R;
                        if (bArr24 != null) {
                            bArr25 = bArr6;
                        } else {
                            bArr25 = bArr6;
                        }
                        byte[] bArr5111 = bArr23;
                        byte[] bArr6211114 = bArr25;
                        byte[] bArr6211115 = bArr7;
                        byte[] bArr6211116 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                        byte[] bArr6211117 = tlv_t142Var.get_tlv_142(bArr5);
                        i13 = i12 + 1 + 1;
                        str = this.x.g;
                        if (str != null) {
                            i14 = i13;
                            bArr26 = bArr48;
                        } else {
                            i14 = i13;
                            bArr26 = bArr48;
                        }
                        if (bArr3 != null) {
                            bArr27 = bArr50;
                        } else {
                            bArr27 = bArr50;
                        }
                        if (list != null) {
                            bArr28 = bArr51;
                        } else {
                            bArr28 = bArr51;
                        }
                        if (wloginSigInfoA == null) {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        } else {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        }
                        byte[] bArr6111111118 = new byte[4];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111118, 0, i11);
                        tlv_tVar.set_data(bArr6111111118, 4);
                        byte[] bArr6111111119 = tlv_tVar.get_buf();
                        byte[] bArr61111111110 = new byte[6];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111110, 0, oicq.wlogin_sdk.request.t.au);
                        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111110, 4, 0);
                        tlv_tVar2.set_data(bArr61111111110, 6);
                        byte[] bArr61111111111 = tlv_tVar2.get_buf();
                        int i119 = i14 + 1 + 1;
                        int length211111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211115.length + bArr6211116.length + bArr6211117.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                        byte[] bArr61111111112 = bArr10;
                        byte[] bArr61111111113 = bArr31;
                        byte[] bArr71111111111116 = new byte[length211111111111119 + bArr61111111112.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5111.length + bArr6211114.length + bArr6111111119.length + bArr61111111111.length];
                        java.lang.System.arraycopy(bArr35, 0, bArr71111111111116, 0, bArr35.length);
                        int length311111111114 = bArr35.length + 0;
                        java.lang.System.arraycopy(bArr36, 0, bArr71111111111116, length311111111114, bArr36.length);
                        int length311111111115 = length311111111114 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr71111111111116, length311111111115, bArr37.length);
                        int length311111111116 = length311111111115 + bArr37.length;
                        java.lang.System.arraycopy(bArr40, 0, bArr71111111111116, length311111111116, bArr40.length);
                        int length311111111117 = length311111111116 + bArr40.length;
                        java.lang.System.arraycopy(bArr38, 0, bArr71111111111116, length311111111117, bArr38.length);
                        int length311111111118 = length311111111117 + bArr38.length;
                        java.lang.System.arraycopy(bArr39, 0, bArr71111111111116, length311111111118, bArr39.length);
                        int length311111111119 = length311111111118 + bArr39.length;
                        java.lang.System.arraycopy(bArr6211115, 0, bArr71111111111116, length311111111119, bArr6211115.length);
                        int length3111111111110 = length311111111119 + bArr6211115.length;
                        java.lang.System.arraycopy(bArr6211116, 0, bArr71111111111116, length3111111111110, bArr6211116.length);
                        int length3111111111111 = length3111111111110 + bArr6211116.length;
                        java.lang.System.arraycopy(bArr6211117, 0, bArr71111111111116, length3111111111111, bArr6211117.length);
                        int length1111111111111110 = length3111111111111 + bArr6211117.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr71111111111116, length1111111111111110, bArr26.length);
                        int length1111111111111111 = length1111111111111110 + bArr26.length;
                        byte[] bArr71111111111117 = bArr41;
                        java.lang.System.arraycopy(bArr71111111111117, 0, bArr71111111111116, length1111111111111111, bArr71111111111117.length);
                        int length1111111111111112 = length1111111111111111 + bArr71111111111117.length;
                        byte[] bArr71111111111118 = bArr8;
                        java.lang.System.arraycopy(bArr71111111111118, 0, bArr71111111111116, length1111111111111112, bArr71111111111118.length);
                        int length1111111111111113 = length1111111111111112 + bArr71111111111118.length;
                        byte[] bArr71111111111119 = bArr30;
                        java.lang.System.arraycopy(bArr71111111111119, 0, bArr71111111111116, length1111111111111113, bArr71111111111119.length);
                        int length1111111111111114 = length1111111111111113 + bArr71111111111119.length;
                        java.lang.System.arraycopy(bArr42, 0, bArr71111111111116, length1111111111111114, bArr42.length);
                        int length1111111111111115 = length1111111111111114 + bArr42.length;
                        java.lang.System.arraycopy(bArr43, 0, bArr71111111111116, length1111111111111115, bArr43.length);
                        int length1111111111111116 = length1111111111111115 + bArr43.length;
                        java.lang.System.arraycopy(bArr44, 0, bArr71111111111116, length1111111111111116, bArr44.length);
                        int length1111111111111117 = length1111111111111116 + bArr44.length;
                        byte[] bArr711111111111110 = bArr29;
                        java.lang.System.arraycopy(bArr711111111111110, 0, bArr71111111111116, length1111111111111117, bArr711111111111110.length);
                        int length1111111111111118 = length1111111111111117 + bArr711111111111110.length;
                        java.lang.System.arraycopy(bArr45, 0, bArr71111111111116, length1111111111111118, bArr45.length);
                        int length1111111111111119 = length1111111111111118 + bArr45.length;
                        byte[] bArr711111111111111 = bArr13;
                        java.lang.System.arraycopy(bArr711111111111111, 0, bArr71111111111116, length1111111111111119, bArr711111111111111.length);
                        int length2111111111111110 = length1111111111111119 + bArr711111111111111.length;
                        java.lang.System.arraycopy(bArr61111111112, 0, bArr71111111111116, length2111111111111110, bArr61111111112.length);
                        int length2111111111111111 = length2111111111111110 + bArr61111111112.length;
                        java.lang.System.arraycopy(bArr61111111113, 0, bArr71111111111116, length2111111111111111, bArr61111111113.length);
                        int length2111111111111112 = length2111111111111111 + bArr61111111113.length;
                        byte[] bArr711111111111112 = bArr16;
                        java.lang.System.arraycopy(bArr711111111111112, 0, bArr71111111111116, length2111111111111112, bArr711111111111112.length);
                        int length2111111111111113 = length2111111111111112 + bArr711111111111112.length;
                        byte[] bArr711111111111113 = bArr19;
                        java.lang.System.arraycopy(bArr711111111111113, 0, bArr71111111111116, length2111111111111113, bArr711111111111113.length);
                        int length2111111111111114 = length2111111111111113 + bArr711111111111113.length;
                        byte[] bArr711111111111114 = bArr22;
                        java.lang.System.arraycopy(bArr711111111111114, 0, bArr71111111111116, length2111111111111114, bArr711111111111114.length);
                        int length2111111111111115 = length2111111111111114 + bArr711111111111114.length;
                        java.lang.System.arraycopy(bArr5111, 0, bArr71111111111116, length2111111111111115, bArr5111.length);
                        int length2111111111111116 = length2111111111111115 + bArr5111.length;
                        java.lang.System.arraycopy(bArr6211114, 0, bArr71111111111116, length2111111111111116, bArr6211114.length);
                        int length2111111111111117 = length2111111111111116 + bArr6211114.length;
                        java.lang.System.arraycopy(bArr6111111119, 0, bArr71111111111116, length2111111111111117, bArr6111111119.length);
                        java.lang.System.arraycopy(bArr61111111111, 0, bArr71111111111116, length2111111111111117 + bArr6111111119.length, bArr61111111111.length);
                        int length2111111111111118 = bArr61111111111.length;
                        return a(a(bArr71111111111116, this.u, i119), this.y, this.A, this.B);
                    }
                    bArr22 = bArr20;
                    bArr23 = bArr57;
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr5112 = bArr23;
                    byte[] bArr6211118 = bArr25;
                    byte[] bArr6211119 = bArr7;
                    byte[] bArr62111110 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr62111111 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr61111111114 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111114, 0, i11);
                    tlv_tVar.set_data(bArr61111111114, 4);
                    byte[] bArr61111111115 = tlv_tVar.get_buf();
                    byte[] bArr61111111116 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111116, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111116, 4, 0);
                    tlv_tVar2.set_data(bArr61111111116, 6);
                    byte[] bArr61111111117 = tlv_tVar2.get_buf();
                    int i1110 = i14 + 1 + 1;
                    int length2111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211119.length + bArr62111110.length + bArr62111111.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr61111111118 = bArr10;
                    byte[] bArr61111111119 = bArr31;
                    byte[] bArr711111111111115 = new byte[length2111111111111119 + bArr61111111118.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5112.length + bArr6211118.length + bArr61111111115.length + bArr61111111117.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr711111111111115, 0, bArr35.length);
                    int length3111111111112 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr711111111111115, length3111111111112, bArr36.length);
                    int length3111111111113 = length3111111111112 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr711111111111115, length3111111111113, bArr37.length);
                    int length3111111111114 = length3111111111113 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr711111111111115, length3111111111114, bArr40.length);
                    int length3111111111115 = length3111111111114 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr711111111111115, length3111111111115, bArr38.length);
                    int length3111111111116 = length3111111111115 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr711111111111115, length3111111111116, bArr39.length);
                    int length3111111111117 = length3111111111116 + bArr39.length;
                    java.lang.System.arraycopy(bArr6211119, 0, bArr711111111111115, length3111111111117, bArr6211119.length);
                    int length3111111111118 = length3111111111117 + bArr6211119.length;
                    java.lang.System.arraycopy(bArr62111110, 0, bArr711111111111115, length3111111111118, bArr62111110.length);
                    int length3111111111119 = length3111111111118 + bArr62111110.length;
                    java.lang.System.arraycopy(bArr62111111, 0, bArr711111111111115, length3111111111119, bArr62111111.length);
                    int length11111111111111110 = length3111111111119 + bArr62111111.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr711111111111115, length11111111111111110, bArr26.length);
                    int length11111111111111111 = length11111111111111110 + bArr26.length;
                    byte[] bArr711111111111116 = bArr41;
                    java.lang.System.arraycopy(bArr711111111111116, 0, bArr711111111111115, length11111111111111111, bArr711111111111116.length);
                    int length11111111111111112 = length11111111111111111 + bArr711111111111116.length;
                    byte[] bArr711111111111117 = bArr8;
                    java.lang.System.arraycopy(bArr711111111111117, 0, bArr711111111111115, length11111111111111112, bArr711111111111117.length);
                    int length11111111111111113 = length11111111111111112 + bArr711111111111117.length;
                    byte[] bArr711111111111118 = bArr30;
                    java.lang.System.arraycopy(bArr711111111111118, 0, bArr711111111111115, length11111111111111113, bArr711111111111118.length);
                    int length11111111111111114 = length11111111111111113 + bArr711111111111118.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr711111111111115, length11111111111111114, bArr42.length);
                    int length11111111111111115 = length11111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr711111111111115, length11111111111111115, bArr43.length);
                    int length11111111111111116 = length11111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr711111111111115, length11111111111111116, bArr44.length);
                    int length11111111111111117 = length11111111111111116 + bArr44.length;
                    byte[] bArr711111111111119 = bArr29;
                    java.lang.System.arraycopy(bArr711111111111119, 0, bArr711111111111115, length11111111111111117, bArr711111111111119.length);
                    int length11111111111111118 = length11111111111111117 + bArr711111111111119.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr711111111111115, length11111111111111118, bArr45.length);
                    int length11111111111111119 = length11111111111111118 + bArr45.length;
                    byte[] bArr7111111111111110 = bArr13;
                    java.lang.System.arraycopy(bArr7111111111111110, 0, bArr711111111111115, length11111111111111119, bArr7111111111111110.length);
                    int length21111111111111110 = length11111111111111119 + bArr7111111111111110.length;
                    java.lang.System.arraycopy(bArr61111111118, 0, bArr711111111111115, length21111111111111110, bArr61111111118.length);
                    int length21111111111111111 = length21111111111111110 + bArr61111111118.length;
                    java.lang.System.arraycopy(bArr61111111119, 0, bArr711111111111115, length21111111111111111, bArr61111111119.length);
                    int length21111111111111112 = length21111111111111111 + bArr61111111119.length;
                    byte[] bArr7111111111111111 = bArr16;
                    java.lang.System.arraycopy(bArr7111111111111111, 0, bArr711111111111115, length21111111111111112, bArr7111111111111111.length);
                    int length21111111111111113 = length21111111111111112 + bArr7111111111111111.length;
                    byte[] bArr7111111111111112 = bArr19;
                    java.lang.System.arraycopy(bArr7111111111111112, 0, bArr711111111111115, length21111111111111113, bArr7111111111111112.length);
                    int length21111111111111114 = length21111111111111113 + bArr7111111111111112.length;
                    byte[] bArr7111111111111113 = bArr22;
                    java.lang.System.arraycopy(bArr7111111111111113, 0, bArr711111111111115, length21111111111111114, bArr7111111111111113.length);
                    int length21111111111111115 = length21111111111111114 + bArr7111111111111113.length;
                    java.lang.System.arraycopy(bArr5112, 0, bArr711111111111115, length21111111111111115, bArr5112.length);
                    int length21111111111111116 = length21111111111111115 + bArr5112.length;
                    java.lang.System.arraycopy(bArr6211118, 0, bArr711111111111115, length21111111111111116, bArr6211118.length);
                    int length21111111111111117 = length21111111111111116 + bArr6211118.length;
                    java.lang.System.arraycopy(bArr61111111115, 0, bArr711111111111115, length21111111111111117, bArr61111111115.length);
                    java.lang.System.arraycopy(bArr61111111117, 0, bArr711111111111115, length21111111111111117 + bArr61111111115.length, bArr61111111117.length);
                    int length21111111111111118 = bArr61111111117.length;
                    return a(a(bArr711111111111115, this.u, i1110), this.y, this.A, this.B);
                }
                bArr19 = bArr17;
                bArr20 = bArr56;
                bArr21 = oicq.wlogin_sdk.request.l.J;
                if (bArr21 != null) {
                    bArr22 = bArr20;
                    if (bArr21.length > 0) {
                        bArr41 = bArr41;
                        bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                        i12++;
                    }
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr5113 = bArr23;
                    byte[] bArr62111112 = bArr25;
                    byte[] bArr62111113 = bArr7;
                    byte[] bArr62111114 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr62111115 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr611111111110 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111110, 0, i11);
                    tlv_tVar.set_data(bArr611111111110, 4);
                    byte[] bArr611111111111 = tlv_tVar.get_buf();
                    byte[] bArr611111111112 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111112, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111112, 4, 0);
                    tlv_tVar2.set_data(bArr611111111112, 6);
                    byte[] bArr611111111113 = tlv_tVar2.get_buf();
                    int i1111 = i14 + 1 + 1;
                    int length21111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111113.length + bArr62111114.length + bArr62111115.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr611111111114 = bArr10;
                    byte[] bArr611111111115 = bArr31;
                    byte[] bArr7111111111111114 = new byte[length21111111111111119 + bArr611111111114.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5113.length + bArr62111112.length + bArr611111111111.length + bArr611111111113.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr7111111111111114, 0, bArr35.length);
                    int length31111111111110 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr7111111111111114, length31111111111110, bArr36.length);
                    int length31111111111111 = length31111111111110 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr7111111111111114, length31111111111111, bArr37.length);
                    int length31111111111112 = length31111111111111 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr7111111111111114, length31111111111112, bArr40.length);
                    int length31111111111113 = length31111111111112 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr7111111111111114, length31111111111113, bArr38.length);
                    int length31111111111114 = length31111111111113 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr7111111111111114, length31111111111114, bArr39.length);
                    int length31111111111115 = length31111111111114 + bArr39.length;
                    java.lang.System.arraycopy(bArr62111113, 0, bArr7111111111111114, length31111111111115, bArr62111113.length);
                    int length31111111111116 = length31111111111115 + bArr62111113.length;
                    java.lang.System.arraycopy(bArr62111114, 0, bArr7111111111111114, length31111111111116, bArr62111114.length);
                    int length31111111111117 = length31111111111116 + bArr62111114.length;
                    java.lang.System.arraycopy(bArr62111115, 0, bArr7111111111111114, length31111111111117, bArr62111115.length);
                    int length111111111111111110 = length31111111111117 + bArr62111115.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr7111111111111114, length111111111111111110, bArr26.length);
                    int length111111111111111111 = length111111111111111110 + bArr26.length;
                    byte[] bArr7111111111111115 = bArr41;
                    java.lang.System.arraycopy(bArr7111111111111115, 0, bArr7111111111111114, length111111111111111111, bArr7111111111111115.length);
                    int length111111111111111112 = length111111111111111111 + bArr7111111111111115.length;
                    byte[] bArr7111111111111116 = bArr8;
                    java.lang.System.arraycopy(bArr7111111111111116, 0, bArr7111111111111114, length111111111111111112, bArr7111111111111116.length);
                    int length111111111111111113 = length111111111111111112 + bArr7111111111111116.length;
                    byte[] bArr7111111111111117 = bArr30;
                    java.lang.System.arraycopy(bArr7111111111111117, 0, bArr7111111111111114, length111111111111111113, bArr7111111111111117.length);
                    int length111111111111111114 = length111111111111111113 + bArr7111111111111117.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr7111111111111114, length111111111111111114, bArr42.length);
                    int length111111111111111115 = length111111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr7111111111111114, length111111111111111115, bArr43.length);
                    int length111111111111111116 = length111111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr7111111111111114, length111111111111111116, bArr44.length);
                    int length111111111111111117 = length111111111111111116 + bArr44.length;
                    byte[] bArr7111111111111118 = bArr29;
                    java.lang.System.arraycopy(bArr7111111111111118, 0, bArr7111111111111114, length111111111111111117, bArr7111111111111118.length);
                    int length111111111111111118 = length111111111111111117 + bArr7111111111111118.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr7111111111111114, length111111111111111118, bArr45.length);
                    int length111111111111111119 = length111111111111111118 + bArr45.length;
                    byte[] bArr7111111111111119 = bArr13;
                    java.lang.System.arraycopy(bArr7111111111111119, 0, bArr7111111111111114, length111111111111111119, bArr7111111111111119.length);
                    int length211111111111111110 = length111111111111111119 + bArr7111111111111119.length;
                    java.lang.System.arraycopy(bArr611111111114, 0, bArr7111111111111114, length211111111111111110, bArr611111111114.length);
                    int length211111111111111111 = length211111111111111110 + bArr611111111114.length;
                    java.lang.System.arraycopy(bArr611111111115, 0, bArr7111111111111114, length211111111111111111, bArr611111111115.length);
                    int length211111111111111112 = length211111111111111111 + bArr611111111115.length;
                    byte[] bArr71111111111111110 = bArr16;
                    java.lang.System.arraycopy(bArr71111111111111110, 0, bArr7111111111111114, length211111111111111112, bArr71111111111111110.length);
                    int length211111111111111113 = length211111111111111112 + bArr71111111111111110.length;
                    byte[] bArr71111111111111111 = bArr19;
                    java.lang.System.arraycopy(bArr71111111111111111, 0, bArr7111111111111114, length211111111111111113, bArr71111111111111111.length);
                    int length211111111111111114 = length211111111111111113 + bArr71111111111111111.length;
                    byte[] bArr71111111111111112 = bArr22;
                    java.lang.System.arraycopy(bArr71111111111111112, 0, bArr7111111111111114, length211111111111111114, bArr71111111111111112.length);
                    int length211111111111111115 = length211111111111111114 + bArr71111111111111112.length;
                    java.lang.System.arraycopy(bArr5113, 0, bArr7111111111111114, length211111111111111115, bArr5113.length);
                    int length211111111111111116 = length211111111111111115 + bArr5113.length;
                    java.lang.System.arraycopy(bArr62111112, 0, bArr7111111111111114, length211111111111111116, bArr62111112.length);
                    int length211111111111111117 = length211111111111111116 + bArr62111112.length;
                    java.lang.System.arraycopy(bArr611111111111, 0, bArr7111111111111114, length211111111111111117, bArr611111111111.length);
                    java.lang.System.arraycopy(bArr611111111113, 0, bArr7111111111111114, length211111111111111117 + bArr611111111111.length, bArr611111111113.length);
                    int length211111111111111118 = bArr611111111113.length;
                    return a(a(bArr7111111111111114, this.u, i1111), this.y, this.A, this.B);
                }
                bArr22 = bArr20;
                bArr23 = bArr57;
                bArr24 = oicq.wlogin_sdk.request.t.R;
                if (bArr24 != null) {
                    bArr25 = bArr6;
                } else {
                    bArr25 = bArr6;
                }
                byte[] bArr5114 = bArr23;
                byte[] bArr62111116 = bArr25;
                byte[] bArr62111117 = bArr7;
                byte[] bArr62111118 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                byte[] bArr62111119 = tlv_t142Var.get_tlv_142(bArr5);
                i13 = i12 + 1 + 1;
                str = this.x.g;
                if (str != null) {
                    i14 = i13;
                    bArr26 = bArr48;
                } else {
                    i14 = i13;
                    bArr26 = bArr48;
                }
                if (bArr3 != null) {
                    bArr27 = bArr50;
                } else {
                    bArr27 = bArr50;
                }
                if (list != null) {
                    bArr28 = bArr51;
                } else {
                    bArr28 = bArr51;
                }
                if (wloginSigInfoA == null) {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                } else {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                }
                byte[] bArr611111111116 = new byte[4];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111116, 0, i11);
                tlv_tVar.set_data(bArr611111111116, 4);
                byte[] bArr611111111117 = tlv_tVar.get_buf();
                byte[] bArr611111111118 = new byte[6];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111118, 0, oicq.wlogin_sdk.request.t.au);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111118, 4, 0);
                tlv_tVar2.set_data(bArr611111111118, 6);
                byte[] bArr611111111119 = tlv_tVar2.get_buf();
                int i1112 = i14 + 1 + 1;
                int length211111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111117.length + bArr62111118.length + bArr62111119.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                byte[] bArr6111111111110 = bArr10;
                byte[] bArr6111111111111 = bArr31;
                byte[] bArr71111111111111113 = new byte[length211111111111111119 + bArr6111111111110.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5114.length + bArr62111116.length + bArr611111111117.length + bArr611111111119.length];
                java.lang.System.arraycopy(bArr35, 0, bArr71111111111111113, 0, bArr35.length);
                int length31111111111118 = bArr35.length + 0;
                java.lang.System.arraycopy(bArr36, 0, bArr71111111111111113, length31111111111118, bArr36.length);
                int length31111111111119 = length31111111111118 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr71111111111111113, length31111111111119, bArr37.length);
                int length311111111111110 = length31111111111119 + bArr37.length;
                java.lang.System.arraycopy(bArr40, 0, bArr71111111111111113, length311111111111110, bArr40.length);
                int length311111111111111 = length311111111111110 + bArr40.length;
                java.lang.System.arraycopy(bArr38, 0, bArr71111111111111113, length311111111111111, bArr38.length);
                int length311111111111112 = length311111111111111 + bArr38.length;
                java.lang.System.arraycopy(bArr39, 0, bArr71111111111111113, length311111111111112, bArr39.length);
                int length311111111111113 = length311111111111112 + bArr39.length;
                java.lang.System.arraycopy(bArr62111117, 0, bArr71111111111111113, length311111111111113, bArr62111117.length);
                int length311111111111114 = length311111111111113 + bArr62111117.length;
                java.lang.System.arraycopy(bArr62111118, 0, bArr71111111111111113, length311111111111114, bArr62111118.length);
                int length311111111111115 = length311111111111114 + bArr62111118.length;
                java.lang.System.arraycopy(bArr62111119, 0, bArr71111111111111113, length311111111111115, bArr62111119.length);
                int length1111111111111111110 = length311111111111115 + bArr62111119.length;
                java.lang.System.arraycopy(bArr26, 0, bArr71111111111111113, length1111111111111111110, bArr26.length);
                int length1111111111111111111 = length1111111111111111110 + bArr26.length;
                byte[] bArr71111111111111114 = bArr41;
                java.lang.System.arraycopy(bArr71111111111111114, 0, bArr71111111111111113, length1111111111111111111, bArr71111111111111114.length);
                int length1111111111111111112 = length1111111111111111111 + bArr71111111111111114.length;
                byte[] bArr71111111111111115 = bArr8;
                java.lang.System.arraycopy(bArr71111111111111115, 0, bArr71111111111111113, length1111111111111111112, bArr71111111111111115.length);
                int length1111111111111111113 = length1111111111111111112 + bArr71111111111111115.length;
                byte[] bArr71111111111111116 = bArr30;
                java.lang.System.arraycopy(bArr71111111111111116, 0, bArr71111111111111113, length1111111111111111113, bArr71111111111111116.length);
                int length1111111111111111114 = length1111111111111111113 + bArr71111111111111116.length;
                java.lang.System.arraycopy(bArr42, 0, bArr71111111111111113, length1111111111111111114, bArr42.length);
                int length1111111111111111115 = length1111111111111111114 + bArr42.length;
                java.lang.System.arraycopy(bArr43, 0, bArr71111111111111113, length1111111111111111115, bArr43.length);
                int length1111111111111111116 = length1111111111111111115 + bArr43.length;
                java.lang.System.arraycopy(bArr44, 0, bArr71111111111111113, length1111111111111111116, bArr44.length);
                int length1111111111111111117 = length1111111111111111116 + bArr44.length;
                byte[] bArr71111111111111117 = bArr29;
                java.lang.System.arraycopy(bArr71111111111111117, 0, bArr71111111111111113, length1111111111111111117, bArr71111111111111117.length);
                int length1111111111111111118 = length1111111111111111117 + bArr71111111111111117.length;
                java.lang.System.arraycopy(bArr45, 0, bArr71111111111111113, length1111111111111111118, bArr45.length);
                int length1111111111111111119 = length1111111111111111118 + bArr45.length;
                byte[] bArr71111111111111118 = bArr13;
                java.lang.System.arraycopy(bArr71111111111111118, 0, bArr71111111111111113, length1111111111111111119, bArr71111111111111118.length);
                int length2111111111111111110 = length1111111111111111119 + bArr71111111111111118.length;
                java.lang.System.arraycopy(bArr6111111111110, 0, bArr71111111111111113, length2111111111111111110, bArr6111111111110.length);
                int length2111111111111111111 = length2111111111111111110 + bArr6111111111110.length;
                java.lang.System.arraycopy(bArr6111111111111, 0, bArr71111111111111113, length2111111111111111111, bArr6111111111111.length);
                int length2111111111111111112 = length2111111111111111111 + bArr6111111111111.length;
                byte[] bArr71111111111111119 = bArr16;
                java.lang.System.arraycopy(bArr71111111111111119, 0, bArr71111111111111113, length2111111111111111112, bArr71111111111111119.length);
                int length2111111111111111113 = length2111111111111111112 + bArr71111111111111119.length;
                byte[] bArr711111111111111110 = bArr19;
                java.lang.System.arraycopy(bArr711111111111111110, 0, bArr71111111111111113, length2111111111111111113, bArr711111111111111110.length);
                int length2111111111111111114 = length2111111111111111113 + bArr711111111111111110.length;
                byte[] bArr711111111111111111 = bArr22;
                java.lang.System.arraycopy(bArr711111111111111111, 0, bArr71111111111111113, length2111111111111111114, bArr711111111111111111.length);
                int length2111111111111111115 = length2111111111111111114 + bArr711111111111111111.length;
                java.lang.System.arraycopy(bArr5114, 0, bArr71111111111111113, length2111111111111111115, bArr5114.length);
                int length2111111111111111116 = length2111111111111111115 + bArr5114.length;
                java.lang.System.arraycopy(bArr62111116, 0, bArr71111111111111113, length2111111111111111116, bArr62111116.length);
                int length2111111111111111117 = length2111111111111111116 + bArr62111116.length;
                java.lang.System.arraycopy(bArr611111111117, 0, bArr71111111111111113, length2111111111111111117, bArr611111111117.length);
                java.lang.System.arraycopy(bArr611111111119, 0, bArr71111111111111113, length2111111111111111117 + bArr611111111117.length, bArr611111111119.length);
                int length2111111111111111118 = bArr611111111119.length;
                return a(a(bArr71111111111111113, this.u, i1112), this.y, this.A, this.B);
            }
            bArr10 = bArr46;
            bArr11 = bArr52;
            bArr12 = oicq.wlogin_sdk.request.t.N;
            if (bArr12 != null) {
                bArr13 = bArr11;
                if (bArr12.length > 0) {
                    bArr14 = tlv_t187Var.get_tlv_187(bArr12);
                    i12++;
                }
                bArr15 = oicq.wlogin_sdk.request.t.O;
                if (bArr15 != null) {
                    bArr16 = bArr14;
                    if (bArr15.length > 0) {
                        bArr17 = tlv_t188Var.get_tlv_188(bArr15);
                        i12++;
                    }
                    bArr18 = oicq.wlogin_sdk.request.t.L;
                    if (bArr18 != null) {
                        bArr19 = bArr17;
                        if (bArr18.length > 0) {
                            bArr20 = tlv_t194Var.get_tlv_194(bArr18);
                            i12++;
                        }
                        bArr21 = oicq.wlogin_sdk.request.l.J;
                        if (bArr21 != null) {
                            bArr22 = bArr20;
                            if (bArr21.length > 0) {
                                bArr41 = bArr41;
                                bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                                i12++;
                            }
                            bArr24 = oicq.wlogin_sdk.request.t.R;
                            if (bArr24 != null) {
                                bArr25 = bArr6;
                            } else {
                                bArr25 = bArr6;
                            }
                            byte[] bArr5115 = bArr23;
                            byte[] bArr621111110 = bArr25;
                            byte[] bArr621111111 = bArr7;
                            byte[] bArr621111112 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                            byte[] bArr621111113 = tlv_t142Var.get_tlv_142(bArr5);
                            i13 = i12 + 1 + 1;
                            str = this.x.g;
                            if (str != null) {
                                i14 = i13;
                                bArr26 = bArr48;
                            } else {
                                i14 = i13;
                                bArr26 = bArr48;
                            }
                            if (bArr3 != null) {
                                bArr27 = bArr50;
                            } else {
                                bArr27 = bArr50;
                            }
                            if (list != null) {
                                bArr28 = bArr51;
                            } else {
                                bArr28 = bArr51;
                            }
                            if (wloginSigInfoA == null) {
                                bArr29 = bArr28;
                                bArr30 = bArr27;
                                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                                bArr31 = bArr53;
                            } else {
                                bArr29 = bArr28;
                                bArr30 = bArr27;
                                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                                bArr31 = bArr53;
                            }
                            byte[] bArr6111111111112 = new byte[4];
                            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111112, 0, i11);
                            tlv_tVar.set_data(bArr6111111111112, 4);
                            byte[] bArr6111111111113 = tlv_tVar.get_buf();
                            byte[] bArr6111111111114 = new byte[6];
                            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111114, 0, oicq.wlogin_sdk.request.t.au);
                            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr6111111111114, 4, 0);
                            tlv_tVar2.set_data(bArr6111111111114, 6);
                            byte[] bArr6111111111115 = tlv_tVar2.get_buf();
                            int i1113 = i14 + 1 + 1;
                            int length2111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111111.length + bArr621111112.length + bArr621111113.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                            byte[] bArr6111111111116 = bArr10;
                            byte[] bArr6111111111117 = bArr31;
                            byte[] bArr711111111111111112 = new byte[length2111111111111111119 + bArr6111111111116.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5115.length + bArr621111110.length + bArr6111111111113.length + bArr6111111111115.length];
                            java.lang.System.arraycopy(bArr35, 0, bArr711111111111111112, 0, bArr35.length);
                            int length311111111111116 = bArr35.length + 0;
                            java.lang.System.arraycopy(bArr36, 0, bArr711111111111111112, length311111111111116, bArr36.length);
                            int length311111111111117 = length311111111111116 + bArr36.length;
                            java.lang.System.arraycopy(bArr37, 0, bArr711111111111111112, length311111111111117, bArr37.length);
                            int length311111111111118 = length311111111111117 + bArr37.length;
                            java.lang.System.arraycopy(bArr40, 0, bArr711111111111111112, length311111111111118, bArr40.length);
                            int length311111111111119 = length311111111111118 + bArr40.length;
                            java.lang.System.arraycopy(bArr38, 0, bArr711111111111111112, length311111111111119, bArr38.length);
                            int length3111111111111110 = length311111111111119 + bArr38.length;
                            java.lang.System.arraycopy(bArr39, 0, bArr711111111111111112, length3111111111111110, bArr39.length);
                            int length3111111111111111 = length3111111111111110 + bArr39.length;
                            java.lang.System.arraycopy(bArr621111111, 0, bArr711111111111111112, length3111111111111111, bArr621111111.length);
                            int length3111111111111112 = length3111111111111111 + bArr621111111.length;
                            java.lang.System.arraycopy(bArr621111112, 0, bArr711111111111111112, length3111111111111112, bArr621111112.length);
                            int length3111111111111113 = length3111111111111112 + bArr621111112.length;
                            java.lang.System.arraycopy(bArr621111113, 0, bArr711111111111111112, length3111111111111113, bArr621111113.length);
                            int length11111111111111111110 = length3111111111111113 + bArr621111113.length;
                            java.lang.System.arraycopy(bArr26, 0, bArr711111111111111112, length11111111111111111110, bArr26.length);
                            int length11111111111111111111 = length11111111111111111110 + bArr26.length;
                            byte[] bArr711111111111111113 = bArr41;
                            java.lang.System.arraycopy(bArr711111111111111113, 0, bArr711111111111111112, length11111111111111111111, bArr711111111111111113.length);
                            int length11111111111111111112 = length11111111111111111111 + bArr711111111111111113.length;
                            byte[] bArr711111111111111114 = bArr8;
                            java.lang.System.arraycopy(bArr711111111111111114, 0, bArr711111111111111112, length11111111111111111112, bArr711111111111111114.length);
                            int length11111111111111111113 = length11111111111111111112 + bArr711111111111111114.length;
                            byte[] bArr711111111111111115 = bArr30;
                            java.lang.System.arraycopy(bArr711111111111111115, 0, bArr711111111111111112, length11111111111111111113, bArr711111111111111115.length);
                            int length11111111111111111114 = length11111111111111111113 + bArr711111111111111115.length;
                            java.lang.System.arraycopy(bArr42, 0, bArr711111111111111112, length11111111111111111114, bArr42.length);
                            int length11111111111111111115 = length11111111111111111114 + bArr42.length;
                            java.lang.System.arraycopy(bArr43, 0, bArr711111111111111112, length11111111111111111115, bArr43.length);
                            int length11111111111111111116 = length11111111111111111115 + bArr43.length;
                            java.lang.System.arraycopy(bArr44, 0, bArr711111111111111112, length11111111111111111116, bArr44.length);
                            int length11111111111111111117 = length11111111111111111116 + bArr44.length;
                            byte[] bArr711111111111111116 = bArr29;
                            java.lang.System.arraycopy(bArr711111111111111116, 0, bArr711111111111111112, length11111111111111111117, bArr711111111111111116.length);
                            int length11111111111111111118 = length11111111111111111117 + bArr711111111111111116.length;
                            java.lang.System.arraycopy(bArr45, 0, bArr711111111111111112, length11111111111111111118, bArr45.length);
                            int length11111111111111111119 = length11111111111111111118 + bArr45.length;
                            byte[] bArr711111111111111117 = bArr13;
                            java.lang.System.arraycopy(bArr711111111111111117, 0, bArr711111111111111112, length11111111111111111119, bArr711111111111111117.length);
                            int length21111111111111111110 = length11111111111111111119 + bArr711111111111111117.length;
                            java.lang.System.arraycopy(bArr6111111111116, 0, bArr711111111111111112, length21111111111111111110, bArr6111111111116.length);
                            int length21111111111111111111 = length21111111111111111110 + bArr6111111111116.length;
                            java.lang.System.arraycopy(bArr6111111111117, 0, bArr711111111111111112, length21111111111111111111, bArr6111111111117.length);
                            int length21111111111111111112 = length21111111111111111111 + bArr6111111111117.length;
                            byte[] bArr711111111111111118 = bArr16;
                            java.lang.System.arraycopy(bArr711111111111111118, 0, bArr711111111111111112, length21111111111111111112, bArr711111111111111118.length);
                            int length21111111111111111113 = length21111111111111111112 + bArr711111111111111118.length;
                            byte[] bArr711111111111111119 = bArr19;
                            java.lang.System.arraycopy(bArr711111111111111119, 0, bArr711111111111111112, length21111111111111111113, bArr711111111111111119.length);
                            int length21111111111111111114 = length21111111111111111113 + bArr711111111111111119.length;
                            byte[] bArr7111111111111111110 = bArr22;
                            java.lang.System.arraycopy(bArr7111111111111111110, 0, bArr711111111111111112, length21111111111111111114, bArr7111111111111111110.length);
                            int length21111111111111111115 = length21111111111111111114 + bArr7111111111111111110.length;
                            java.lang.System.arraycopy(bArr5115, 0, bArr711111111111111112, length21111111111111111115, bArr5115.length);
                            int length21111111111111111116 = length21111111111111111115 + bArr5115.length;
                            java.lang.System.arraycopy(bArr621111110, 0, bArr711111111111111112, length21111111111111111116, bArr621111110.length);
                            int length21111111111111111117 = length21111111111111111116 + bArr621111110.length;
                            java.lang.System.arraycopy(bArr6111111111113, 0, bArr711111111111111112, length21111111111111111117, bArr6111111111113.length);
                            java.lang.System.arraycopy(bArr6111111111115, 0, bArr711111111111111112, length21111111111111111117 + bArr6111111111113.length, bArr6111111111115.length);
                            int length21111111111111111118 = bArr6111111111115.length;
                            return a(a(bArr711111111111111112, this.u, i1113), this.y, this.A, this.B);
                        }
                        bArr22 = bArr20;
                        bArr23 = bArr57;
                        bArr24 = oicq.wlogin_sdk.request.t.R;
                        if (bArr24 != null) {
                            bArr25 = bArr6;
                        } else {
                            bArr25 = bArr6;
                        }
                        byte[] bArr5116 = bArr23;
                        byte[] bArr621111114 = bArr25;
                        byte[] bArr621111115 = bArr7;
                        byte[] bArr621111116 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                        byte[] bArr621111117 = tlv_t142Var.get_tlv_142(bArr5);
                        i13 = i12 + 1 + 1;
                        str = this.x.g;
                        if (str != null) {
                            i14 = i13;
                            bArr26 = bArr48;
                        } else {
                            i14 = i13;
                            bArr26 = bArr48;
                        }
                        if (bArr3 != null) {
                            bArr27 = bArr50;
                        } else {
                            bArr27 = bArr50;
                        }
                        if (list != null) {
                            bArr28 = bArr51;
                        } else {
                            bArr28 = bArr51;
                        }
                        if (wloginSigInfoA == null) {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        } else {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        }
                        byte[] bArr6111111111118 = new byte[4];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111118, 0, i11);
                        tlv_tVar.set_data(bArr6111111111118, 4);
                        byte[] bArr6111111111119 = tlv_tVar.get_buf();
                        byte[] bArr61111111111110 = new byte[6];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111110, 0, oicq.wlogin_sdk.request.t.au);
                        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111110, 4, 0);
                        tlv_tVar2.set_data(bArr61111111111110, 6);
                        byte[] bArr61111111111111 = tlv_tVar2.get_buf();
                        int i1114 = i14 + 1 + 1;
                        int length21111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111115.length + bArr621111116.length + bArr621111117.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                        byte[] bArr61111111111112 = bArr10;
                        byte[] bArr61111111111113 = bArr31;
                        byte[] bArr7111111111111111111 = new byte[length21111111111111111119 + bArr61111111111112.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5116.length + bArr621111114.length + bArr6111111111119.length + bArr61111111111111.length];
                        java.lang.System.arraycopy(bArr35, 0, bArr7111111111111111111, 0, bArr35.length);
                        int length3111111111111114 = bArr35.length + 0;
                        java.lang.System.arraycopy(bArr36, 0, bArr7111111111111111111, length3111111111111114, bArr36.length);
                        int length3111111111111115 = length3111111111111114 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr7111111111111111111, length3111111111111115, bArr37.length);
                        int length3111111111111116 = length3111111111111115 + bArr37.length;
                        java.lang.System.arraycopy(bArr40, 0, bArr7111111111111111111, length3111111111111116, bArr40.length);
                        int length3111111111111117 = length3111111111111116 + bArr40.length;
                        java.lang.System.arraycopy(bArr38, 0, bArr7111111111111111111, length3111111111111117, bArr38.length);
                        int length3111111111111118 = length3111111111111117 + bArr38.length;
                        java.lang.System.arraycopy(bArr39, 0, bArr7111111111111111111, length3111111111111118, bArr39.length);
                        int length3111111111111119 = length3111111111111118 + bArr39.length;
                        java.lang.System.arraycopy(bArr621111115, 0, bArr7111111111111111111, length3111111111111119, bArr621111115.length);
                        int length31111111111111110 = length3111111111111119 + bArr621111115.length;
                        java.lang.System.arraycopy(bArr621111116, 0, bArr7111111111111111111, length31111111111111110, bArr621111116.length);
                        int length31111111111111111 = length31111111111111110 + bArr621111116.length;
                        java.lang.System.arraycopy(bArr621111117, 0, bArr7111111111111111111, length31111111111111111, bArr621111117.length);
                        int length111111111111111111110 = length31111111111111111 + bArr621111117.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr7111111111111111111, length111111111111111111110, bArr26.length);
                        int length111111111111111111111 = length111111111111111111110 + bArr26.length;
                        byte[] bArr7111111111111111112 = bArr41;
                        java.lang.System.arraycopy(bArr7111111111111111112, 0, bArr7111111111111111111, length111111111111111111111, bArr7111111111111111112.length);
                        int length111111111111111111112 = length111111111111111111111 + bArr7111111111111111112.length;
                        byte[] bArr7111111111111111113 = bArr8;
                        java.lang.System.arraycopy(bArr7111111111111111113, 0, bArr7111111111111111111, length111111111111111111112, bArr7111111111111111113.length);
                        int length111111111111111111113 = length111111111111111111112 + bArr7111111111111111113.length;
                        byte[] bArr7111111111111111114 = bArr30;
                        java.lang.System.arraycopy(bArr7111111111111111114, 0, bArr7111111111111111111, length111111111111111111113, bArr7111111111111111114.length);
                        int length111111111111111111114 = length111111111111111111113 + bArr7111111111111111114.length;
                        java.lang.System.arraycopy(bArr42, 0, bArr7111111111111111111, length111111111111111111114, bArr42.length);
                        int length111111111111111111115 = length111111111111111111114 + bArr42.length;
                        java.lang.System.arraycopy(bArr43, 0, bArr7111111111111111111, length111111111111111111115, bArr43.length);
                        int length111111111111111111116 = length111111111111111111115 + bArr43.length;
                        java.lang.System.arraycopy(bArr44, 0, bArr7111111111111111111, length111111111111111111116, bArr44.length);
                        int length111111111111111111117 = length111111111111111111116 + bArr44.length;
                        byte[] bArr7111111111111111115 = bArr29;
                        java.lang.System.arraycopy(bArr7111111111111111115, 0, bArr7111111111111111111, length111111111111111111117, bArr7111111111111111115.length);
                        int length111111111111111111118 = length111111111111111111117 + bArr7111111111111111115.length;
                        java.lang.System.arraycopy(bArr45, 0, bArr7111111111111111111, length111111111111111111118, bArr45.length);
                        int length111111111111111111119 = length111111111111111111118 + bArr45.length;
                        byte[] bArr7111111111111111116 = bArr13;
                        java.lang.System.arraycopy(bArr7111111111111111116, 0, bArr7111111111111111111, length111111111111111111119, bArr7111111111111111116.length);
                        int length211111111111111111110 = length111111111111111111119 + bArr7111111111111111116.length;
                        java.lang.System.arraycopy(bArr61111111111112, 0, bArr7111111111111111111, length211111111111111111110, bArr61111111111112.length);
                        int length211111111111111111111 = length211111111111111111110 + bArr61111111111112.length;
                        java.lang.System.arraycopy(bArr61111111111113, 0, bArr7111111111111111111, length211111111111111111111, bArr61111111111113.length);
                        int length211111111111111111112 = length211111111111111111111 + bArr61111111111113.length;
                        byte[] bArr7111111111111111117 = bArr16;
                        java.lang.System.arraycopy(bArr7111111111111111117, 0, bArr7111111111111111111, length211111111111111111112, bArr7111111111111111117.length);
                        int length211111111111111111113 = length211111111111111111112 + bArr7111111111111111117.length;
                        byte[] bArr7111111111111111118 = bArr19;
                        java.lang.System.arraycopy(bArr7111111111111111118, 0, bArr7111111111111111111, length211111111111111111113, bArr7111111111111111118.length);
                        int length211111111111111111114 = length211111111111111111113 + bArr7111111111111111118.length;
                        byte[] bArr7111111111111111119 = bArr22;
                        java.lang.System.arraycopy(bArr7111111111111111119, 0, bArr7111111111111111111, length211111111111111111114, bArr7111111111111111119.length);
                        int length211111111111111111115 = length211111111111111111114 + bArr7111111111111111119.length;
                        java.lang.System.arraycopy(bArr5116, 0, bArr7111111111111111111, length211111111111111111115, bArr5116.length);
                        int length211111111111111111116 = length211111111111111111115 + bArr5116.length;
                        java.lang.System.arraycopy(bArr621111114, 0, bArr7111111111111111111, length211111111111111111116, bArr621111114.length);
                        int length211111111111111111117 = length211111111111111111116 + bArr621111114.length;
                        java.lang.System.arraycopy(bArr6111111111119, 0, bArr7111111111111111111, length211111111111111111117, bArr6111111111119.length);
                        java.lang.System.arraycopy(bArr61111111111111, 0, bArr7111111111111111111, length211111111111111111117 + bArr6111111111119.length, bArr61111111111111.length);
                        int length211111111111111111118 = bArr61111111111111.length;
                        return a(a(bArr7111111111111111111, this.u, i1114), this.y, this.A, this.B);
                    }
                    bArr19 = bArr17;
                    bArr20 = bArr56;
                    bArr21 = oicq.wlogin_sdk.request.l.J;
                    if (bArr21 != null) {
                        bArr22 = bArr20;
                        if (bArr21.length > 0) {
                            bArr41 = bArr41;
                            bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                            i12++;
                        }
                        bArr24 = oicq.wlogin_sdk.request.t.R;
                        if (bArr24 != null) {
                            bArr25 = bArr6;
                        } else {
                            bArr25 = bArr6;
                        }
                        byte[] bArr5117 = bArr23;
                        byte[] bArr621111118 = bArr25;
                        byte[] bArr621111119 = bArr7;
                        byte[] bArr6211111110 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                        byte[] bArr6211111111 = tlv_t142Var.get_tlv_142(bArr5);
                        i13 = i12 + 1 + 1;
                        str = this.x.g;
                        if (str != null) {
                            i14 = i13;
                            bArr26 = bArr48;
                        } else {
                            i14 = i13;
                            bArr26 = bArr48;
                        }
                        if (bArr3 != null) {
                            bArr27 = bArr50;
                        } else {
                            bArr27 = bArr50;
                        }
                        if (list != null) {
                            bArr28 = bArr51;
                        } else {
                            bArr28 = bArr51;
                        }
                        if (wloginSigInfoA == null) {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        } else {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        }
                        byte[] bArr61111111111114 = new byte[4];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111114, 0, i11);
                        tlv_tVar.set_data(bArr61111111111114, 4);
                        byte[] bArr61111111111115 = tlv_tVar.get_buf();
                        byte[] bArr61111111111116 = new byte[6];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111116, 0, oicq.wlogin_sdk.request.t.au);
                        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111116, 4, 0);
                        tlv_tVar2.set_data(bArr61111111111116, 6);
                        byte[] bArr61111111111117 = tlv_tVar2.get_buf();
                        int i1115 = i14 + 1 + 1;
                        int length211111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111119.length + bArr6211111110.length + bArr6211111111.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                        byte[] bArr61111111111118 = bArr10;
                        byte[] bArr61111111111119 = bArr31;
                        byte[] bArr71111111111111111110 = new byte[length211111111111111111119 + bArr61111111111118.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5117.length + bArr621111118.length + bArr61111111111115.length + bArr61111111111117.length];
                        java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111110, 0, bArr35.length);
                        int length31111111111111112 = bArr35.length + 0;
                        java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111110, length31111111111111112, bArr36.length);
                        int length31111111111111113 = length31111111111111112 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111110, length31111111111111113, bArr37.length);
                        int length31111111111111114 = length31111111111111113 + bArr37.length;
                        java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111110, length31111111111111114, bArr40.length);
                        int length31111111111111115 = length31111111111111114 + bArr40.length;
                        java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111110, length31111111111111115, bArr38.length);
                        int length31111111111111116 = length31111111111111115 + bArr38.length;
                        java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111110, length31111111111111116, bArr39.length);
                        int length31111111111111117 = length31111111111111116 + bArr39.length;
                        java.lang.System.arraycopy(bArr621111119, 0, bArr71111111111111111110, length31111111111111117, bArr621111119.length);
                        int length31111111111111118 = length31111111111111117 + bArr621111119.length;
                        java.lang.System.arraycopy(bArr6211111110, 0, bArr71111111111111111110, length31111111111111118, bArr6211111110.length);
                        int length31111111111111119 = length31111111111111118 + bArr6211111110.length;
                        java.lang.System.arraycopy(bArr6211111111, 0, bArr71111111111111111110, length31111111111111119, bArr6211111111.length);
                        int length1111111111111111111110 = length31111111111111119 + bArr6211111111.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111110, length1111111111111111111110, bArr26.length);
                        int length1111111111111111111111 = length1111111111111111111110 + bArr26.length;
                        byte[] bArr71111111111111111111 = bArr41;
                        java.lang.System.arraycopy(bArr71111111111111111111, 0, bArr71111111111111111110, length1111111111111111111111, bArr71111111111111111111.length);
                        int length1111111111111111111112 = length1111111111111111111111 + bArr71111111111111111111.length;
                        byte[] bArr71111111111111111112 = bArr8;
                        java.lang.System.arraycopy(bArr71111111111111111112, 0, bArr71111111111111111110, length1111111111111111111112, bArr71111111111111111112.length);
                        int length1111111111111111111113 = length1111111111111111111112 + bArr71111111111111111112.length;
                        byte[] bArr71111111111111111113 = bArr30;
                        java.lang.System.arraycopy(bArr71111111111111111113, 0, bArr71111111111111111110, length1111111111111111111113, bArr71111111111111111113.length);
                        int length1111111111111111111114 = length1111111111111111111113 + bArr71111111111111111113.length;
                        java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111110, length1111111111111111111114, bArr42.length);
                        int length1111111111111111111115 = length1111111111111111111114 + bArr42.length;
                        java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111110, length1111111111111111111115, bArr43.length);
                        int length1111111111111111111116 = length1111111111111111111115 + bArr43.length;
                        java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111110, length1111111111111111111116, bArr44.length);
                        int length1111111111111111111117 = length1111111111111111111116 + bArr44.length;
                        byte[] bArr71111111111111111114 = bArr29;
                        java.lang.System.arraycopy(bArr71111111111111111114, 0, bArr71111111111111111110, length1111111111111111111117, bArr71111111111111111114.length);
                        int length1111111111111111111118 = length1111111111111111111117 + bArr71111111111111111114.length;
                        java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111110, length1111111111111111111118, bArr45.length);
                        int length1111111111111111111119 = length1111111111111111111118 + bArr45.length;
                        byte[] bArr71111111111111111115 = bArr13;
                        java.lang.System.arraycopy(bArr71111111111111111115, 0, bArr71111111111111111110, length1111111111111111111119, bArr71111111111111111115.length);
                        int length2111111111111111111110 = length1111111111111111111119 + bArr71111111111111111115.length;
                        java.lang.System.arraycopy(bArr61111111111118, 0, bArr71111111111111111110, length2111111111111111111110, bArr61111111111118.length);
                        int length2111111111111111111111 = length2111111111111111111110 + bArr61111111111118.length;
                        java.lang.System.arraycopy(bArr61111111111119, 0, bArr71111111111111111110, length2111111111111111111111, bArr61111111111119.length);
                        int length2111111111111111111112 = length2111111111111111111111 + bArr61111111111119.length;
                        byte[] bArr71111111111111111116 = bArr16;
                        java.lang.System.arraycopy(bArr71111111111111111116, 0, bArr71111111111111111110, length2111111111111111111112, bArr71111111111111111116.length);
                        int length2111111111111111111113 = length2111111111111111111112 + bArr71111111111111111116.length;
                        byte[] bArr71111111111111111117 = bArr19;
                        java.lang.System.arraycopy(bArr71111111111111111117, 0, bArr71111111111111111110, length2111111111111111111113, bArr71111111111111111117.length);
                        int length2111111111111111111114 = length2111111111111111111113 + bArr71111111111111111117.length;
                        byte[] bArr71111111111111111118 = bArr22;
                        java.lang.System.arraycopy(bArr71111111111111111118, 0, bArr71111111111111111110, length2111111111111111111114, bArr71111111111111111118.length);
                        int length2111111111111111111115 = length2111111111111111111114 + bArr71111111111111111118.length;
                        java.lang.System.arraycopy(bArr5117, 0, bArr71111111111111111110, length2111111111111111111115, bArr5117.length);
                        int length2111111111111111111116 = length2111111111111111111115 + bArr5117.length;
                        java.lang.System.arraycopy(bArr621111118, 0, bArr71111111111111111110, length2111111111111111111116, bArr621111118.length);
                        int length2111111111111111111117 = length2111111111111111111116 + bArr621111118.length;
                        java.lang.System.arraycopy(bArr61111111111115, 0, bArr71111111111111111110, length2111111111111111111117, bArr61111111111115.length);
                        java.lang.System.arraycopy(bArr61111111111117, 0, bArr71111111111111111110, length2111111111111111111117 + bArr61111111111115.length, bArr61111111111117.length);
                        int length2111111111111111111118 = bArr61111111111117.length;
                        return a(a(bArr71111111111111111110, this.u, i1115), this.y, this.A, this.B);
                    }
                    bArr22 = bArr20;
                    bArr23 = bArr57;
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr5118 = bArr23;
                    byte[] bArr6211111112 = bArr25;
                    byte[] bArr6211111113 = bArr7;
                    byte[] bArr6211111114 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr6211111115 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr611111111111110 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111110, 0, i11);
                    tlv_tVar.set_data(bArr611111111111110, 4);
                    byte[] bArr611111111111111 = tlv_tVar.get_buf();
                    byte[] bArr611111111111112 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111112, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111112, 4, 0);
                    tlv_tVar2.set_data(bArr611111111111112, 6);
                    byte[] bArr611111111111113 = tlv_tVar2.get_buf();
                    int i1116 = i14 + 1 + 1;
                    int length2111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211111113.length + bArr6211111114.length + bArr6211111115.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr611111111111114 = bArr10;
                    byte[] bArr611111111111115 = bArr31;
                    byte[] bArr71111111111111111119 = new byte[length2111111111111111111119 + bArr611111111111114.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5118.length + bArr6211111112.length + bArr611111111111111.length + bArr611111111111113.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111119, 0, bArr35.length);
                    int length311111111111111110 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111119, length311111111111111110, bArr36.length);
                    int length311111111111111111 = length311111111111111110 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111119, length311111111111111111, bArr37.length);
                    int length311111111111111112 = length311111111111111111 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111119, length311111111111111112, bArr40.length);
                    int length311111111111111113 = length311111111111111112 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111119, length311111111111111113, bArr38.length);
                    int length311111111111111114 = length311111111111111113 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111119, length311111111111111114, bArr39.length);
                    int length311111111111111115 = length311111111111111114 + bArr39.length;
                    java.lang.System.arraycopy(bArr6211111113, 0, bArr71111111111111111119, length311111111111111115, bArr6211111113.length);
                    int length311111111111111116 = length311111111111111115 + bArr6211111113.length;
                    java.lang.System.arraycopy(bArr6211111114, 0, bArr71111111111111111119, length311111111111111116, bArr6211111114.length);
                    int length311111111111111117 = length311111111111111116 + bArr6211111114.length;
                    java.lang.System.arraycopy(bArr6211111115, 0, bArr71111111111111111119, length311111111111111117, bArr6211111115.length);
                    int length11111111111111111111110 = length311111111111111117 + bArr6211111115.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111119, length11111111111111111111110, bArr26.length);
                    int length11111111111111111111111 = length11111111111111111111110 + bArr26.length;
                    byte[] bArr711111111111111111110 = bArr41;
                    java.lang.System.arraycopy(bArr711111111111111111110, 0, bArr71111111111111111119, length11111111111111111111111, bArr711111111111111111110.length);
                    int length11111111111111111111112 = length11111111111111111111111 + bArr711111111111111111110.length;
                    byte[] bArr711111111111111111111 = bArr8;
                    java.lang.System.arraycopy(bArr711111111111111111111, 0, bArr71111111111111111119, length11111111111111111111112, bArr711111111111111111111.length);
                    int length11111111111111111111113 = length11111111111111111111112 + bArr711111111111111111111.length;
                    byte[] bArr711111111111111111112 = bArr30;
                    java.lang.System.arraycopy(bArr711111111111111111112, 0, bArr71111111111111111119, length11111111111111111111113, bArr711111111111111111112.length);
                    int length11111111111111111111114 = length11111111111111111111113 + bArr711111111111111111112.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111119, length11111111111111111111114, bArr42.length);
                    int length11111111111111111111115 = length11111111111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111119, length11111111111111111111115, bArr43.length);
                    int length11111111111111111111116 = length11111111111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111119, length11111111111111111111116, bArr44.length);
                    int length11111111111111111111117 = length11111111111111111111116 + bArr44.length;
                    byte[] bArr711111111111111111113 = bArr29;
                    java.lang.System.arraycopy(bArr711111111111111111113, 0, bArr71111111111111111119, length11111111111111111111117, bArr711111111111111111113.length);
                    int length11111111111111111111118 = length11111111111111111111117 + bArr711111111111111111113.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111119, length11111111111111111111118, bArr45.length);
                    int length11111111111111111111119 = length11111111111111111111118 + bArr45.length;
                    byte[] bArr711111111111111111114 = bArr13;
                    java.lang.System.arraycopy(bArr711111111111111111114, 0, bArr71111111111111111119, length11111111111111111111119, bArr711111111111111111114.length);
                    int length21111111111111111111110 = length11111111111111111111119 + bArr711111111111111111114.length;
                    java.lang.System.arraycopy(bArr611111111111114, 0, bArr71111111111111111119, length21111111111111111111110, bArr611111111111114.length);
                    int length21111111111111111111111 = length21111111111111111111110 + bArr611111111111114.length;
                    java.lang.System.arraycopy(bArr611111111111115, 0, bArr71111111111111111119, length21111111111111111111111, bArr611111111111115.length);
                    int length21111111111111111111112 = length21111111111111111111111 + bArr611111111111115.length;
                    byte[] bArr711111111111111111115 = bArr16;
                    java.lang.System.arraycopy(bArr711111111111111111115, 0, bArr71111111111111111119, length21111111111111111111112, bArr711111111111111111115.length);
                    int length21111111111111111111113 = length21111111111111111111112 + bArr711111111111111111115.length;
                    byte[] bArr711111111111111111116 = bArr19;
                    java.lang.System.arraycopy(bArr711111111111111111116, 0, bArr71111111111111111119, length21111111111111111111113, bArr711111111111111111116.length);
                    int length21111111111111111111114 = length21111111111111111111113 + bArr711111111111111111116.length;
                    byte[] bArr711111111111111111117 = bArr22;
                    java.lang.System.arraycopy(bArr711111111111111111117, 0, bArr71111111111111111119, length21111111111111111111114, bArr711111111111111111117.length);
                    int length21111111111111111111115 = length21111111111111111111114 + bArr711111111111111111117.length;
                    java.lang.System.arraycopy(bArr5118, 0, bArr71111111111111111119, length21111111111111111111115, bArr5118.length);
                    int length21111111111111111111116 = length21111111111111111111115 + bArr5118.length;
                    java.lang.System.arraycopy(bArr6211111112, 0, bArr71111111111111111119, length21111111111111111111116, bArr6211111112.length);
                    int length21111111111111111111117 = length21111111111111111111116 + bArr6211111112.length;
                    java.lang.System.arraycopy(bArr611111111111111, 0, bArr71111111111111111119, length21111111111111111111117, bArr611111111111111.length);
                    java.lang.System.arraycopy(bArr611111111111113, 0, bArr71111111111111111119, length21111111111111111111117 + bArr611111111111111.length, bArr611111111111113.length);
                    int length21111111111111111111118 = bArr611111111111113.length;
                    return a(a(bArr71111111111111111119, this.u, i1116), this.y, this.A, this.B);
                }
                bArr16 = bArr14;
                bArr17 = bArr55;
                bArr18 = oicq.wlogin_sdk.request.t.L;
                if (bArr18 != null) {
                    bArr19 = bArr17;
                    if (bArr18.length > 0) {
                        bArr20 = tlv_t194Var.get_tlv_194(bArr18);
                        i12++;
                    }
                    bArr21 = oicq.wlogin_sdk.request.l.J;
                    if (bArr21 != null) {
                        bArr22 = bArr20;
                        if (bArr21.length > 0) {
                            bArr41 = bArr41;
                            bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                            i12++;
                        }
                        bArr24 = oicq.wlogin_sdk.request.t.R;
                        if (bArr24 != null) {
                            bArr25 = bArr6;
                        } else {
                            bArr25 = bArr6;
                        }
                        byte[] bArr5119 = bArr23;
                        byte[] bArr6211111116 = bArr25;
                        byte[] bArr6211111117 = bArr7;
                        byte[] bArr6211111118 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                        byte[] bArr6211111119 = tlv_t142Var.get_tlv_142(bArr5);
                        i13 = i12 + 1 + 1;
                        str = this.x.g;
                        if (str != null) {
                            i14 = i13;
                            bArr26 = bArr48;
                        } else {
                            i14 = i13;
                            bArr26 = bArr48;
                        }
                        if (bArr3 != null) {
                            bArr27 = bArr50;
                        } else {
                            bArr27 = bArr50;
                        }
                        if (list != null) {
                            bArr28 = bArr51;
                        } else {
                            bArr28 = bArr51;
                        }
                        if (wloginSigInfoA == null) {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        } else {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        }
                        byte[] bArr611111111111116 = new byte[4];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111116, 0, i11);
                        tlv_tVar.set_data(bArr611111111111116, 4);
                        byte[] bArr611111111111117 = tlv_tVar.get_buf();
                        byte[] bArr611111111111118 = new byte[6];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111118, 0, oicq.wlogin_sdk.request.t.au);
                        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111118, 4, 0);
                        tlv_tVar2.set_data(bArr611111111111118, 6);
                        byte[] bArr611111111111119 = tlv_tVar2.get_buf();
                        int i1117 = i14 + 1 + 1;
                        int length21111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211111117.length + bArr6211111118.length + bArr6211111119.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                        byte[] bArr6111111111111110 = bArr10;
                        byte[] bArr6111111111111111 = bArr31;
                        byte[] bArr711111111111111111118 = new byte[length21111111111111111111119 + bArr6111111111111110.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5119.length + bArr6211111116.length + bArr611111111111117.length + bArr611111111111119.length];
                        java.lang.System.arraycopy(bArr35, 0, bArr711111111111111111118, 0, bArr35.length);
                        int length311111111111111118 = bArr35.length + 0;
                        java.lang.System.arraycopy(bArr36, 0, bArr711111111111111111118, length311111111111111118, bArr36.length);
                        int length311111111111111119 = length311111111111111118 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr711111111111111111118, length311111111111111119, bArr37.length);
                        int length3111111111111111110 = length311111111111111119 + bArr37.length;
                        java.lang.System.arraycopy(bArr40, 0, bArr711111111111111111118, length3111111111111111110, bArr40.length);
                        int length3111111111111111111 = length3111111111111111110 + bArr40.length;
                        java.lang.System.arraycopy(bArr38, 0, bArr711111111111111111118, length3111111111111111111, bArr38.length);
                        int length3111111111111111112 = length3111111111111111111 + bArr38.length;
                        java.lang.System.arraycopy(bArr39, 0, bArr711111111111111111118, length3111111111111111112, bArr39.length);
                        int length3111111111111111113 = length3111111111111111112 + bArr39.length;
                        java.lang.System.arraycopy(bArr6211111117, 0, bArr711111111111111111118, length3111111111111111113, bArr6211111117.length);
                        int length3111111111111111114 = length3111111111111111113 + bArr6211111117.length;
                        java.lang.System.arraycopy(bArr6211111118, 0, bArr711111111111111111118, length3111111111111111114, bArr6211111118.length);
                        int length3111111111111111115 = length3111111111111111114 + bArr6211111118.length;
                        java.lang.System.arraycopy(bArr6211111119, 0, bArr711111111111111111118, length3111111111111111115, bArr6211111119.length);
                        int length111111111111111111111110 = length3111111111111111115 + bArr6211111119.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr711111111111111111118, length111111111111111111111110, bArr26.length);
                        int length111111111111111111111111 = length111111111111111111111110 + bArr26.length;
                        byte[] bArr711111111111111111119 = bArr41;
                        java.lang.System.arraycopy(bArr711111111111111111119, 0, bArr711111111111111111118, length111111111111111111111111, bArr711111111111111111119.length);
                        int length111111111111111111111112 = length111111111111111111111111 + bArr711111111111111111119.length;
                        byte[] bArr7111111111111111111110 = bArr8;
                        java.lang.System.arraycopy(bArr7111111111111111111110, 0, bArr711111111111111111118, length111111111111111111111112, bArr7111111111111111111110.length);
                        int length111111111111111111111113 = length111111111111111111111112 + bArr7111111111111111111110.length;
                        byte[] bArr7111111111111111111111 = bArr30;
                        java.lang.System.arraycopy(bArr7111111111111111111111, 0, bArr711111111111111111118, length111111111111111111111113, bArr7111111111111111111111.length);
                        int length111111111111111111111114 = length111111111111111111111113 + bArr7111111111111111111111.length;
                        java.lang.System.arraycopy(bArr42, 0, bArr711111111111111111118, length111111111111111111111114, bArr42.length);
                        int length111111111111111111111115 = length111111111111111111111114 + bArr42.length;
                        java.lang.System.arraycopy(bArr43, 0, bArr711111111111111111118, length111111111111111111111115, bArr43.length);
                        int length111111111111111111111116 = length111111111111111111111115 + bArr43.length;
                        java.lang.System.arraycopy(bArr44, 0, bArr711111111111111111118, length111111111111111111111116, bArr44.length);
                        int length111111111111111111111117 = length111111111111111111111116 + bArr44.length;
                        byte[] bArr7111111111111111111112 = bArr29;
                        java.lang.System.arraycopy(bArr7111111111111111111112, 0, bArr711111111111111111118, length111111111111111111111117, bArr7111111111111111111112.length);
                        int length111111111111111111111118 = length111111111111111111111117 + bArr7111111111111111111112.length;
                        java.lang.System.arraycopy(bArr45, 0, bArr711111111111111111118, length111111111111111111111118, bArr45.length);
                        int length111111111111111111111119 = length111111111111111111111118 + bArr45.length;
                        byte[] bArr7111111111111111111113 = bArr13;
                        java.lang.System.arraycopy(bArr7111111111111111111113, 0, bArr711111111111111111118, length111111111111111111111119, bArr7111111111111111111113.length);
                        int length211111111111111111111110 = length111111111111111111111119 + bArr7111111111111111111113.length;
                        java.lang.System.arraycopy(bArr6111111111111110, 0, bArr711111111111111111118, length211111111111111111111110, bArr6111111111111110.length);
                        int length211111111111111111111111 = length211111111111111111111110 + bArr6111111111111110.length;
                        java.lang.System.arraycopy(bArr6111111111111111, 0, bArr711111111111111111118, length211111111111111111111111, bArr6111111111111111.length);
                        int length211111111111111111111112 = length211111111111111111111111 + bArr6111111111111111.length;
                        byte[] bArr7111111111111111111114 = bArr16;
                        java.lang.System.arraycopy(bArr7111111111111111111114, 0, bArr711111111111111111118, length211111111111111111111112, bArr7111111111111111111114.length);
                        int length211111111111111111111113 = length211111111111111111111112 + bArr7111111111111111111114.length;
                        byte[] bArr7111111111111111111115 = bArr19;
                        java.lang.System.arraycopy(bArr7111111111111111111115, 0, bArr711111111111111111118, length211111111111111111111113, bArr7111111111111111111115.length);
                        int length211111111111111111111114 = length211111111111111111111113 + bArr7111111111111111111115.length;
                        byte[] bArr7111111111111111111116 = bArr22;
                        java.lang.System.arraycopy(bArr7111111111111111111116, 0, bArr711111111111111111118, length211111111111111111111114, bArr7111111111111111111116.length);
                        int length211111111111111111111115 = length211111111111111111111114 + bArr7111111111111111111116.length;
                        java.lang.System.arraycopy(bArr5119, 0, bArr711111111111111111118, length211111111111111111111115, bArr5119.length);
                        int length211111111111111111111116 = length211111111111111111111115 + bArr5119.length;
                        java.lang.System.arraycopy(bArr6211111116, 0, bArr711111111111111111118, length211111111111111111111116, bArr6211111116.length);
                        int length211111111111111111111117 = length211111111111111111111116 + bArr6211111116.length;
                        java.lang.System.arraycopy(bArr611111111111117, 0, bArr711111111111111111118, length211111111111111111111117, bArr611111111111117.length);
                        java.lang.System.arraycopy(bArr611111111111119, 0, bArr711111111111111111118, length211111111111111111111117 + bArr611111111111117.length, bArr611111111111119.length);
                        int length211111111111111111111118 = bArr611111111111119.length;
                        return a(a(bArr711111111111111111118, this.u, i1117), this.y, this.A, this.B);
                    }
                    bArr22 = bArr20;
                    bArr23 = bArr57;
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr51110 = bArr23;
                    byte[] bArr62111111110 = bArr25;
                    byte[] bArr62111111111 = bArr7;
                    byte[] bArr62111111112 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr62111111113 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr6111111111111112 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111112, 0, i11);
                    tlv_tVar.set_data(bArr6111111111111112, 4);
                    byte[] bArr6111111111111113 = tlv_tVar.get_buf();
                    byte[] bArr6111111111111114 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111114, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr6111111111111114, 4, 0);
                    tlv_tVar2.set_data(bArr6111111111111114, 6);
                    byte[] bArr6111111111111115 = tlv_tVar2.get_buf();
                    int i1118 = i14 + 1 + 1;
                    int length211111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111111111.length + bArr62111111112.length + bArr62111111113.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr6111111111111116 = bArr10;
                    byte[] bArr6111111111111117 = bArr31;
                    byte[] bArr7111111111111111111117 = new byte[length211111111111111111111119 + bArr6111111111111116.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51110.length + bArr62111111110.length + bArr6111111111111113.length + bArr6111111111111115.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr7111111111111111111117, 0, bArr35.length);
                    int length3111111111111111116 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr7111111111111111111117, length3111111111111111116, bArr36.length);
                    int length3111111111111111117 = length3111111111111111116 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr7111111111111111111117, length3111111111111111117, bArr37.length);
                    int length3111111111111111118 = length3111111111111111117 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr7111111111111111111117, length3111111111111111118, bArr40.length);
                    int length3111111111111111119 = length3111111111111111118 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr7111111111111111111117, length3111111111111111119, bArr38.length);
                    int length31111111111111111110 = length3111111111111111119 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr7111111111111111111117, length31111111111111111110, bArr39.length);
                    int length31111111111111111111 = length31111111111111111110 + bArr39.length;
                    java.lang.System.arraycopy(bArr62111111111, 0, bArr7111111111111111111117, length31111111111111111111, bArr62111111111.length);
                    int length31111111111111111112 = length31111111111111111111 + bArr62111111111.length;
                    java.lang.System.arraycopy(bArr62111111112, 0, bArr7111111111111111111117, length31111111111111111112, bArr62111111112.length);
                    int length31111111111111111113 = length31111111111111111112 + bArr62111111112.length;
                    java.lang.System.arraycopy(bArr62111111113, 0, bArr7111111111111111111117, length31111111111111111113, bArr62111111113.length);
                    int length1111111111111111111111110 = length31111111111111111113 + bArr62111111113.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr7111111111111111111117, length1111111111111111111111110, bArr26.length);
                    int length1111111111111111111111111 = length1111111111111111111111110 + bArr26.length;
                    byte[] bArr7111111111111111111118 = bArr41;
                    java.lang.System.arraycopy(bArr7111111111111111111118, 0, bArr7111111111111111111117, length1111111111111111111111111, bArr7111111111111111111118.length);
                    int length1111111111111111111111112 = length1111111111111111111111111 + bArr7111111111111111111118.length;
                    byte[] bArr7111111111111111111119 = bArr8;
                    java.lang.System.arraycopy(bArr7111111111111111111119, 0, bArr7111111111111111111117, length1111111111111111111111112, bArr7111111111111111111119.length);
                    int length1111111111111111111111113 = length1111111111111111111111112 + bArr7111111111111111111119.length;
                    byte[] bArr71111111111111111111110 = bArr30;
                    java.lang.System.arraycopy(bArr71111111111111111111110, 0, bArr7111111111111111111117, length1111111111111111111111113, bArr71111111111111111111110.length);
                    int length1111111111111111111111114 = length1111111111111111111111113 + bArr71111111111111111111110.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr7111111111111111111117, length1111111111111111111111114, bArr42.length);
                    int length1111111111111111111111115 = length1111111111111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr7111111111111111111117, length1111111111111111111111115, bArr43.length);
                    int length1111111111111111111111116 = length1111111111111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr7111111111111111111117, length1111111111111111111111116, bArr44.length);
                    int length1111111111111111111111117 = length1111111111111111111111116 + bArr44.length;
                    byte[] bArr71111111111111111111111 = bArr29;
                    java.lang.System.arraycopy(bArr71111111111111111111111, 0, bArr7111111111111111111117, length1111111111111111111111117, bArr71111111111111111111111.length);
                    int length1111111111111111111111118 = length1111111111111111111111117 + bArr71111111111111111111111.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr7111111111111111111117, length1111111111111111111111118, bArr45.length);
                    int length1111111111111111111111119 = length1111111111111111111111118 + bArr45.length;
                    byte[] bArr71111111111111111111112 = bArr13;
                    java.lang.System.arraycopy(bArr71111111111111111111112, 0, bArr7111111111111111111117, length1111111111111111111111119, bArr71111111111111111111112.length);
                    int length2111111111111111111111110 = length1111111111111111111111119 + bArr71111111111111111111112.length;
                    java.lang.System.arraycopy(bArr6111111111111116, 0, bArr7111111111111111111117, length2111111111111111111111110, bArr6111111111111116.length);
                    int length2111111111111111111111111 = length2111111111111111111111110 + bArr6111111111111116.length;
                    java.lang.System.arraycopy(bArr6111111111111117, 0, bArr7111111111111111111117, length2111111111111111111111111, bArr6111111111111117.length);
                    int length2111111111111111111111112 = length2111111111111111111111111 + bArr6111111111111117.length;
                    byte[] bArr71111111111111111111113 = bArr16;
                    java.lang.System.arraycopy(bArr71111111111111111111113, 0, bArr7111111111111111111117, length2111111111111111111111112, bArr71111111111111111111113.length);
                    int length2111111111111111111111113 = length2111111111111111111111112 + bArr71111111111111111111113.length;
                    byte[] bArr71111111111111111111114 = bArr19;
                    java.lang.System.arraycopy(bArr71111111111111111111114, 0, bArr7111111111111111111117, length2111111111111111111111113, bArr71111111111111111111114.length);
                    int length2111111111111111111111114 = length2111111111111111111111113 + bArr71111111111111111111114.length;
                    byte[] bArr71111111111111111111115 = bArr22;
                    java.lang.System.arraycopy(bArr71111111111111111111115, 0, bArr7111111111111111111117, length2111111111111111111111114, bArr71111111111111111111115.length);
                    int length2111111111111111111111115 = length2111111111111111111111114 + bArr71111111111111111111115.length;
                    java.lang.System.arraycopy(bArr51110, 0, bArr7111111111111111111117, length2111111111111111111111115, bArr51110.length);
                    int length2111111111111111111111116 = length2111111111111111111111115 + bArr51110.length;
                    java.lang.System.arraycopy(bArr62111111110, 0, bArr7111111111111111111117, length2111111111111111111111116, bArr62111111110.length);
                    int length2111111111111111111111117 = length2111111111111111111111116 + bArr62111111110.length;
                    java.lang.System.arraycopy(bArr6111111111111113, 0, bArr7111111111111111111117, length2111111111111111111111117, bArr6111111111111113.length);
                    java.lang.System.arraycopy(bArr6111111111111115, 0, bArr7111111111111111111117, length2111111111111111111111117 + bArr6111111111111113.length, bArr6111111111111115.length);
                    int length2111111111111111111111118 = bArr6111111111111115.length;
                    return a(a(bArr7111111111111111111117, this.u, i1118), this.y, this.A, this.B);
                }
                bArr19 = bArr17;
                bArr20 = bArr56;
                bArr21 = oicq.wlogin_sdk.request.l.J;
                if (bArr21 != null) {
                    bArr22 = bArr20;
                    if (bArr21.length > 0) {
                        bArr41 = bArr41;
                        bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                        i12++;
                    }
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr51111 = bArr23;
                    byte[] bArr62111111114 = bArr25;
                    byte[] bArr62111111115 = bArr7;
                    byte[] bArr62111111116 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr62111111117 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr6111111111111118 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111118, 0, i11);
                    tlv_tVar.set_data(bArr6111111111111118, 4);
                    byte[] bArr6111111111111119 = tlv_tVar.get_buf();
                    byte[] bArr61111111111111110 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111110, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111110, 4, 0);
                    tlv_tVar2.set_data(bArr61111111111111110, 6);
                    byte[] bArr61111111111111111 = tlv_tVar2.get_buf();
                    int i1119 = i14 + 1 + 1;
                    int length2111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111111115.length + bArr62111111116.length + bArr62111111117.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr61111111111111112 = bArr10;
                    byte[] bArr61111111111111113 = bArr31;
                    byte[] bArr71111111111111111111116 = new byte[length2111111111111111111111119 + bArr61111111111111112.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51111.length + bArr62111111114.length + bArr6111111111111119.length + bArr61111111111111111.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111111116, 0, bArr35.length);
                    int length31111111111111111114 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111111116, length31111111111111111114, bArr36.length);
                    int length31111111111111111115 = length31111111111111111114 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111111116, length31111111111111111115, bArr37.length);
                    int length31111111111111111116 = length31111111111111111115 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111111116, length31111111111111111116, bArr40.length);
                    int length31111111111111111117 = length31111111111111111116 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111111116, length31111111111111111117, bArr38.length);
                    int length31111111111111111118 = length31111111111111111117 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111111116, length31111111111111111118, bArr39.length);
                    int length31111111111111111119 = length31111111111111111118 + bArr39.length;
                    java.lang.System.arraycopy(bArr62111111115, 0, bArr71111111111111111111116, length31111111111111111119, bArr62111111115.length);
                    int length311111111111111111110 = length31111111111111111119 + bArr62111111115.length;
                    java.lang.System.arraycopy(bArr62111111116, 0, bArr71111111111111111111116, length311111111111111111110, bArr62111111116.length);
                    int length311111111111111111111 = length311111111111111111110 + bArr62111111116.length;
                    java.lang.System.arraycopy(bArr62111111117, 0, bArr71111111111111111111116, length311111111111111111111, bArr62111111117.length);
                    int length11111111111111111111111110 = length311111111111111111111 + bArr62111111117.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111111116, length11111111111111111111111110, bArr26.length);
                    int length11111111111111111111111111 = length11111111111111111111111110 + bArr26.length;
                    byte[] bArr71111111111111111111117 = bArr41;
                    java.lang.System.arraycopy(bArr71111111111111111111117, 0, bArr71111111111111111111116, length11111111111111111111111111, bArr71111111111111111111117.length);
                    int length11111111111111111111111112 = length11111111111111111111111111 + bArr71111111111111111111117.length;
                    byte[] bArr71111111111111111111118 = bArr8;
                    java.lang.System.arraycopy(bArr71111111111111111111118, 0, bArr71111111111111111111116, length11111111111111111111111112, bArr71111111111111111111118.length);
                    int length11111111111111111111111113 = length11111111111111111111111112 + bArr71111111111111111111118.length;
                    byte[] bArr71111111111111111111119 = bArr30;
                    java.lang.System.arraycopy(bArr71111111111111111111119, 0, bArr71111111111111111111116, length11111111111111111111111113, bArr71111111111111111111119.length);
                    int length11111111111111111111111114 = length11111111111111111111111113 + bArr71111111111111111111119.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111111116, length11111111111111111111111114, bArr42.length);
                    int length11111111111111111111111115 = length11111111111111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111111116, length11111111111111111111111115, bArr43.length);
                    int length11111111111111111111111116 = length11111111111111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111111116, length11111111111111111111111116, bArr44.length);
                    int length11111111111111111111111117 = length11111111111111111111111116 + bArr44.length;
                    byte[] bArr711111111111111111111110 = bArr29;
                    java.lang.System.arraycopy(bArr711111111111111111111110, 0, bArr71111111111111111111116, length11111111111111111111111117, bArr711111111111111111111110.length);
                    int length11111111111111111111111118 = length11111111111111111111111117 + bArr711111111111111111111110.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111111116, length11111111111111111111111118, bArr45.length);
                    int length11111111111111111111111119 = length11111111111111111111111118 + bArr45.length;
                    byte[] bArr711111111111111111111111 = bArr13;
                    java.lang.System.arraycopy(bArr711111111111111111111111, 0, bArr71111111111111111111116, length11111111111111111111111119, bArr711111111111111111111111.length);
                    int length21111111111111111111111110 = length11111111111111111111111119 + bArr711111111111111111111111.length;
                    java.lang.System.arraycopy(bArr61111111111111112, 0, bArr71111111111111111111116, length21111111111111111111111110, bArr61111111111111112.length);
                    int length21111111111111111111111111 = length21111111111111111111111110 + bArr61111111111111112.length;
                    java.lang.System.arraycopy(bArr61111111111111113, 0, bArr71111111111111111111116, length21111111111111111111111111, bArr61111111111111113.length);
                    int length21111111111111111111111112 = length21111111111111111111111111 + bArr61111111111111113.length;
                    byte[] bArr711111111111111111111112 = bArr16;
                    java.lang.System.arraycopy(bArr711111111111111111111112, 0, bArr71111111111111111111116, length21111111111111111111111112, bArr711111111111111111111112.length);
                    int length21111111111111111111111113 = length21111111111111111111111112 + bArr711111111111111111111112.length;
                    byte[] bArr711111111111111111111113 = bArr19;
                    java.lang.System.arraycopy(bArr711111111111111111111113, 0, bArr71111111111111111111116, length21111111111111111111111113, bArr711111111111111111111113.length);
                    int length21111111111111111111111114 = length21111111111111111111111113 + bArr711111111111111111111113.length;
                    byte[] bArr711111111111111111111114 = bArr22;
                    java.lang.System.arraycopy(bArr711111111111111111111114, 0, bArr71111111111111111111116, length21111111111111111111111114, bArr711111111111111111111114.length);
                    int length21111111111111111111111115 = length21111111111111111111111114 + bArr711111111111111111111114.length;
                    java.lang.System.arraycopy(bArr51111, 0, bArr71111111111111111111116, length21111111111111111111111115, bArr51111.length);
                    int length21111111111111111111111116 = length21111111111111111111111115 + bArr51111.length;
                    java.lang.System.arraycopy(bArr62111111114, 0, bArr71111111111111111111116, length21111111111111111111111116, bArr62111111114.length);
                    int length21111111111111111111111117 = length21111111111111111111111116 + bArr62111111114.length;
                    java.lang.System.arraycopy(bArr6111111111111119, 0, bArr71111111111111111111116, length21111111111111111111111117, bArr6111111111111119.length);
                    java.lang.System.arraycopy(bArr61111111111111111, 0, bArr71111111111111111111116, length21111111111111111111111117 + bArr6111111111111119.length, bArr61111111111111111.length);
                    int length21111111111111111111111118 = bArr61111111111111111.length;
                    return a(a(bArr71111111111111111111116, this.u, i1119), this.y, this.A, this.B);
                }
                bArr22 = bArr20;
                bArr23 = bArr57;
                bArr24 = oicq.wlogin_sdk.request.t.R;
                if (bArr24 != null) {
                    bArr25 = bArr6;
                } else {
                    bArr25 = bArr6;
                }
                byte[] bArr51112 = bArr23;
                byte[] bArr62111111118 = bArr25;
                byte[] bArr62111111119 = bArr7;
                byte[] bArr621111111110 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                byte[] bArr621111111111 = tlv_t142Var.get_tlv_142(bArr5);
                i13 = i12 + 1 + 1;
                str = this.x.g;
                if (str != null) {
                    i14 = i13;
                    bArr26 = bArr48;
                } else {
                    i14 = i13;
                    bArr26 = bArr48;
                }
                if (bArr3 != null) {
                    bArr27 = bArr50;
                } else {
                    bArr27 = bArr50;
                }
                if (list != null) {
                    bArr28 = bArr51;
                } else {
                    bArr28 = bArr51;
                }
                if (wloginSigInfoA == null) {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                } else {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                }
                byte[] bArr61111111111111114 = new byte[4];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111114, 0, i11);
                tlv_tVar.set_data(bArr61111111111111114, 4);
                byte[] bArr61111111111111115 = tlv_tVar.get_buf();
                byte[] bArr61111111111111116 = new byte[6];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111116, 0, oicq.wlogin_sdk.request.t.au);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111116, 4, 0);
                tlv_tVar2.set_data(bArr61111111111111116, 6);
                byte[] bArr61111111111111117 = tlv_tVar2.get_buf();
                int i11110 = i14 + 1 + 1;
                int length21111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111111119.length + bArr621111111110.length + bArr621111111111.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                byte[] bArr61111111111111118 = bArr10;
                byte[] bArr61111111111111119 = bArr31;
                byte[] bArr711111111111111111111115 = new byte[length21111111111111111111111119 + bArr61111111111111118.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51112.length + bArr62111111118.length + bArr61111111111111115.length + bArr61111111111111117.length];
                java.lang.System.arraycopy(bArr35, 0, bArr711111111111111111111115, 0, bArr35.length);
                int length311111111111111111112 = bArr35.length + 0;
                java.lang.System.arraycopy(bArr36, 0, bArr711111111111111111111115, length311111111111111111112, bArr36.length);
                int length311111111111111111113 = length311111111111111111112 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr711111111111111111111115, length311111111111111111113, bArr37.length);
                int length311111111111111111114 = length311111111111111111113 + bArr37.length;
                java.lang.System.arraycopy(bArr40, 0, bArr711111111111111111111115, length311111111111111111114, bArr40.length);
                int length311111111111111111115 = length311111111111111111114 + bArr40.length;
                java.lang.System.arraycopy(bArr38, 0, bArr711111111111111111111115, length311111111111111111115, bArr38.length);
                int length311111111111111111116 = length311111111111111111115 + bArr38.length;
                java.lang.System.arraycopy(bArr39, 0, bArr711111111111111111111115, length311111111111111111116, bArr39.length);
                int length311111111111111111117 = length311111111111111111116 + bArr39.length;
                java.lang.System.arraycopy(bArr62111111119, 0, bArr711111111111111111111115, length311111111111111111117, bArr62111111119.length);
                int length311111111111111111118 = length311111111111111111117 + bArr62111111119.length;
                java.lang.System.arraycopy(bArr621111111110, 0, bArr711111111111111111111115, length311111111111111111118, bArr621111111110.length);
                int length311111111111111111119 = length311111111111111111118 + bArr621111111110.length;
                java.lang.System.arraycopy(bArr621111111111, 0, bArr711111111111111111111115, length311111111111111111119, bArr621111111111.length);
                int length111111111111111111111111110 = length311111111111111111119 + bArr621111111111.length;
                java.lang.System.arraycopy(bArr26, 0, bArr711111111111111111111115, length111111111111111111111111110, bArr26.length);
                int length111111111111111111111111111 = length111111111111111111111111110 + bArr26.length;
                byte[] bArr711111111111111111111116 = bArr41;
                java.lang.System.arraycopy(bArr711111111111111111111116, 0, bArr711111111111111111111115, length111111111111111111111111111, bArr711111111111111111111116.length);
                int length111111111111111111111111112 = length111111111111111111111111111 + bArr711111111111111111111116.length;
                byte[] bArr711111111111111111111117 = bArr8;
                java.lang.System.arraycopy(bArr711111111111111111111117, 0, bArr711111111111111111111115, length111111111111111111111111112, bArr711111111111111111111117.length);
                int length111111111111111111111111113 = length111111111111111111111111112 + bArr711111111111111111111117.length;
                byte[] bArr711111111111111111111118 = bArr30;
                java.lang.System.arraycopy(bArr711111111111111111111118, 0, bArr711111111111111111111115, length111111111111111111111111113, bArr711111111111111111111118.length);
                int length111111111111111111111111114 = length111111111111111111111111113 + bArr711111111111111111111118.length;
                java.lang.System.arraycopy(bArr42, 0, bArr711111111111111111111115, length111111111111111111111111114, bArr42.length);
                int length111111111111111111111111115 = length111111111111111111111111114 + bArr42.length;
                java.lang.System.arraycopy(bArr43, 0, bArr711111111111111111111115, length111111111111111111111111115, bArr43.length);
                int length111111111111111111111111116 = length111111111111111111111111115 + bArr43.length;
                java.lang.System.arraycopy(bArr44, 0, bArr711111111111111111111115, length111111111111111111111111116, bArr44.length);
                int length111111111111111111111111117 = length111111111111111111111111116 + bArr44.length;
                byte[] bArr711111111111111111111119 = bArr29;
                java.lang.System.arraycopy(bArr711111111111111111111119, 0, bArr711111111111111111111115, length111111111111111111111111117, bArr711111111111111111111119.length);
                int length111111111111111111111111118 = length111111111111111111111111117 + bArr711111111111111111111119.length;
                java.lang.System.arraycopy(bArr45, 0, bArr711111111111111111111115, length111111111111111111111111118, bArr45.length);
                int length111111111111111111111111119 = length111111111111111111111111118 + bArr45.length;
                byte[] bArr7111111111111111111111110 = bArr13;
                java.lang.System.arraycopy(bArr7111111111111111111111110, 0, bArr711111111111111111111115, length111111111111111111111111119, bArr7111111111111111111111110.length);
                int length211111111111111111111111110 = length111111111111111111111111119 + bArr7111111111111111111111110.length;
                java.lang.System.arraycopy(bArr61111111111111118, 0, bArr711111111111111111111115, length211111111111111111111111110, bArr61111111111111118.length);
                int length211111111111111111111111111 = length211111111111111111111111110 + bArr61111111111111118.length;
                java.lang.System.arraycopy(bArr61111111111111119, 0, bArr711111111111111111111115, length211111111111111111111111111, bArr61111111111111119.length);
                int length211111111111111111111111112 = length211111111111111111111111111 + bArr61111111111111119.length;
                byte[] bArr7111111111111111111111111 = bArr16;
                java.lang.System.arraycopy(bArr7111111111111111111111111, 0, bArr711111111111111111111115, length211111111111111111111111112, bArr7111111111111111111111111.length);
                int length211111111111111111111111113 = length211111111111111111111111112 + bArr7111111111111111111111111.length;
                byte[] bArr7111111111111111111111112 = bArr19;
                java.lang.System.arraycopy(bArr7111111111111111111111112, 0, bArr711111111111111111111115, length211111111111111111111111113, bArr7111111111111111111111112.length);
                int length211111111111111111111111114 = length211111111111111111111111113 + bArr7111111111111111111111112.length;
                byte[] bArr7111111111111111111111113 = bArr22;
                java.lang.System.arraycopy(bArr7111111111111111111111113, 0, bArr711111111111111111111115, length211111111111111111111111114, bArr7111111111111111111111113.length);
                int length211111111111111111111111115 = length211111111111111111111111114 + bArr7111111111111111111111113.length;
                java.lang.System.arraycopy(bArr51112, 0, bArr711111111111111111111115, length211111111111111111111111115, bArr51112.length);
                int length211111111111111111111111116 = length211111111111111111111111115 + bArr51112.length;
                java.lang.System.arraycopy(bArr62111111118, 0, bArr711111111111111111111115, length211111111111111111111111116, bArr62111111118.length);
                int length211111111111111111111111117 = length211111111111111111111111116 + bArr62111111118.length;
                java.lang.System.arraycopy(bArr61111111111111115, 0, bArr711111111111111111111115, length211111111111111111111111117, bArr61111111111111115.length);
                java.lang.System.arraycopy(bArr61111111111111117, 0, bArr711111111111111111111115, length211111111111111111111111117 + bArr61111111111111115.length, bArr61111111111111117.length);
                int length211111111111111111111111118 = bArr61111111111111117.length;
                return a(a(bArr711111111111111111111115, this.u, i11110), this.y, this.A, this.B);
            }
            bArr13 = bArr11;
            bArr14 = bArr54;
            bArr15 = oicq.wlogin_sdk.request.t.O;
            if (bArr15 != null) {
                bArr16 = bArr14;
                if (bArr15.length > 0) {
                    bArr17 = tlv_t188Var.get_tlv_188(bArr15);
                    i12++;
                }
                bArr18 = oicq.wlogin_sdk.request.t.L;
                if (bArr18 != null) {
                    bArr19 = bArr17;
                    if (bArr18.length > 0) {
                        bArr20 = tlv_t194Var.get_tlv_194(bArr18);
                        i12++;
                    }
                    bArr21 = oicq.wlogin_sdk.request.l.J;
                    if (bArr21 != null) {
                        bArr22 = bArr20;
                        if (bArr21.length > 0) {
                            bArr41 = bArr41;
                            bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                            i12++;
                        }
                        bArr24 = oicq.wlogin_sdk.request.t.R;
                        if (bArr24 != null) {
                            bArr25 = bArr6;
                        } else {
                            bArr25 = bArr6;
                        }
                        byte[] bArr51113 = bArr23;
                        byte[] bArr621111111112 = bArr25;
                        byte[] bArr621111111113 = bArr7;
                        byte[] bArr621111111114 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                        byte[] bArr621111111115 = tlv_t142Var.get_tlv_142(bArr5);
                        i13 = i12 + 1 + 1;
                        str = this.x.g;
                        if (str != null) {
                            i14 = i13;
                            bArr26 = bArr48;
                        } else {
                            i14 = i13;
                            bArr26 = bArr48;
                        }
                        if (bArr3 != null) {
                            bArr27 = bArr50;
                        } else {
                            bArr27 = bArr50;
                        }
                        if (list != null) {
                            bArr28 = bArr51;
                        } else {
                            bArr28 = bArr51;
                        }
                        if (wloginSigInfoA == null) {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        } else {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        }
                        byte[] bArr611111111111111110 = new byte[4];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111110, 0, i11);
                        tlv_tVar.set_data(bArr611111111111111110, 4);
                        byte[] bArr611111111111111111 = tlv_tVar.get_buf();
                        byte[] bArr611111111111111112 = new byte[6];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111112, 0, oicq.wlogin_sdk.request.t.au);
                        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111111112, 4, 0);
                        tlv_tVar2.set_data(bArr611111111111111112, 6);
                        byte[] bArr611111111111111113 = tlv_tVar2.get_buf();
                        int i11111 = i14 + 1 + 1;
                        int length211111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111111113.length + bArr621111111114.length + bArr621111111115.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                        byte[] bArr611111111111111114 = bArr10;
                        byte[] bArr611111111111111115 = bArr31;
                        byte[] bArr7111111111111111111111114 = new byte[length211111111111111111111111119 + bArr611111111111111114.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51113.length + bArr621111111112.length + bArr611111111111111111.length + bArr611111111111111113.length];
                        java.lang.System.arraycopy(bArr35, 0, bArr7111111111111111111111114, 0, bArr35.length);
                        int length3111111111111111111110 = bArr35.length + 0;
                        java.lang.System.arraycopy(bArr36, 0, bArr7111111111111111111111114, length3111111111111111111110, bArr36.length);
                        int length3111111111111111111111 = length3111111111111111111110 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr7111111111111111111111114, length3111111111111111111111, bArr37.length);
                        int length3111111111111111111112 = length3111111111111111111111 + bArr37.length;
                        java.lang.System.arraycopy(bArr40, 0, bArr7111111111111111111111114, length3111111111111111111112, bArr40.length);
                        int length3111111111111111111113 = length3111111111111111111112 + bArr40.length;
                        java.lang.System.arraycopy(bArr38, 0, bArr7111111111111111111111114, length3111111111111111111113, bArr38.length);
                        int length3111111111111111111114 = length3111111111111111111113 + bArr38.length;
                        java.lang.System.arraycopy(bArr39, 0, bArr7111111111111111111111114, length3111111111111111111114, bArr39.length);
                        int length3111111111111111111115 = length3111111111111111111114 + bArr39.length;
                        java.lang.System.arraycopy(bArr621111111113, 0, bArr7111111111111111111111114, length3111111111111111111115, bArr621111111113.length);
                        int length3111111111111111111116 = length3111111111111111111115 + bArr621111111113.length;
                        java.lang.System.arraycopy(bArr621111111114, 0, bArr7111111111111111111111114, length3111111111111111111116, bArr621111111114.length);
                        int length3111111111111111111117 = length3111111111111111111116 + bArr621111111114.length;
                        java.lang.System.arraycopy(bArr621111111115, 0, bArr7111111111111111111111114, length3111111111111111111117, bArr621111111115.length);
                        int length1111111111111111111111111110 = length3111111111111111111117 + bArr621111111115.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr7111111111111111111111114, length1111111111111111111111111110, bArr26.length);
                        int length1111111111111111111111111111 = length1111111111111111111111111110 + bArr26.length;
                        byte[] bArr7111111111111111111111115 = bArr41;
                        java.lang.System.arraycopy(bArr7111111111111111111111115, 0, bArr7111111111111111111111114, length1111111111111111111111111111, bArr7111111111111111111111115.length);
                        int length1111111111111111111111111112 = length1111111111111111111111111111 + bArr7111111111111111111111115.length;
                        byte[] bArr7111111111111111111111116 = bArr8;
                        java.lang.System.arraycopy(bArr7111111111111111111111116, 0, bArr7111111111111111111111114, length1111111111111111111111111112, bArr7111111111111111111111116.length);
                        int length1111111111111111111111111113 = length1111111111111111111111111112 + bArr7111111111111111111111116.length;
                        byte[] bArr7111111111111111111111117 = bArr30;
                        java.lang.System.arraycopy(bArr7111111111111111111111117, 0, bArr7111111111111111111111114, length1111111111111111111111111113, bArr7111111111111111111111117.length);
                        int length1111111111111111111111111114 = length1111111111111111111111111113 + bArr7111111111111111111111117.length;
                        java.lang.System.arraycopy(bArr42, 0, bArr7111111111111111111111114, length1111111111111111111111111114, bArr42.length);
                        int length1111111111111111111111111115 = length1111111111111111111111111114 + bArr42.length;
                        java.lang.System.arraycopy(bArr43, 0, bArr7111111111111111111111114, length1111111111111111111111111115, bArr43.length);
                        int length1111111111111111111111111116 = length1111111111111111111111111115 + bArr43.length;
                        java.lang.System.arraycopy(bArr44, 0, bArr7111111111111111111111114, length1111111111111111111111111116, bArr44.length);
                        int length1111111111111111111111111117 = length1111111111111111111111111116 + bArr44.length;
                        byte[] bArr7111111111111111111111118 = bArr29;
                        java.lang.System.arraycopy(bArr7111111111111111111111118, 0, bArr7111111111111111111111114, length1111111111111111111111111117, bArr7111111111111111111111118.length);
                        int length1111111111111111111111111118 = length1111111111111111111111111117 + bArr7111111111111111111111118.length;
                        java.lang.System.arraycopy(bArr45, 0, bArr7111111111111111111111114, length1111111111111111111111111118, bArr45.length);
                        int length1111111111111111111111111119 = length1111111111111111111111111118 + bArr45.length;
                        byte[] bArr7111111111111111111111119 = bArr13;
                        java.lang.System.arraycopy(bArr7111111111111111111111119, 0, bArr7111111111111111111111114, length1111111111111111111111111119, bArr7111111111111111111111119.length);
                        int length2111111111111111111111111110 = length1111111111111111111111111119 + bArr7111111111111111111111119.length;
                        java.lang.System.arraycopy(bArr611111111111111114, 0, bArr7111111111111111111111114, length2111111111111111111111111110, bArr611111111111111114.length);
                        int length2111111111111111111111111111 = length2111111111111111111111111110 + bArr611111111111111114.length;
                        java.lang.System.arraycopy(bArr611111111111111115, 0, bArr7111111111111111111111114, length2111111111111111111111111111, bArr611111111111111115.length);
                        int length2111111111111111111111111112 = length2111111111111111111111111111 + bArr611111111111111115.length;
                        byte[] bArr71111111111111111111111110 = bArr16;
                        java.lang.System.arraycopy(bArr71111111111111111111111110, 0, bArr7111111111111111111111114, length2111111111111111111111111112, bArr71111111111111111111111110.length);
                        int length2111111111111111111111111113 = length2111111111111111111111111112 + bArr71111111111111111111111110.length;
                        byte[] bArr71111111111111111111111111 = bArr19;
                        java.lang.System.arraycopy(bArr71111111111111111111111111, 0, bArr7111111111111111111111114, length2111111111111111111111111113, bArr71111111111111111111111111.length);
                        int length2111111111111111111111111114 = length2111111111111111111111111113 + bArr71111111111111111111111111.length;
                        byte[] bArr71111111111111111111111112 = bArr22;
                        java.lang.System.arraycopy(bArr71111111111111111111111112, 0, bArr7111111111111111111111114, length2111111111111111111111111114, bArr71111111111111111111111112.length);
                        int length2111111111111111111111111115 = length2111111111111111111111111114 + bArr71111111111111111111111112.length;
                        java.lang.System.arraycopy(bArr51113, 0, bArr7111111111111111111111114, length2111111111111111111111111115, bArr51113.length);
                        int length2111111111111111111111111116 = length2111111111111111111111111115 + bArr51113.length;
                        java.lang.System.arraycopy(bArr621111111112, 0, bArr7111111111111111111111114, length2111111111111111111111111116, bArr621111111112.length);
                        int length2111111111111111111111111117 = length2111111111111111111111111116 + bArr621111111112.length;
                        java.lang.System.arraycopy(bArr611111111111111111, 0, bArr7111111111111111111111114, length2111111111111111111111111117, bArr611111111111111111.length);
                        java.lang.System.arraycopy(bArr611111111111111113, 0, bArr7111111111111111111111114, length2111111111111111111111111117 + bArr611111111111111111.length, bArr611111111111111113.length);
                        int length2111111111111111111111111118 = bArr611111111111111113.length;
                        return a(a(bArr7111111111111111111111114, this.u, i11111), this.y, this.A, this.B);
                    }
                    bArr22 = bArr20;
                    bArr23 = bArr57;
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr51114 = bArr23;
                    byte[] bArr621111111116 = bArr25;
                    byte[] bArr621111111117 = bArr7;
                    byte[] bArr621111111118 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr621111111119 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr611111111111111116 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111116, 0, i11);
                    tlv_tVar.set_data(bArr611111111111111116, 4);
                    byte[] bArr611111111111111117 = tlv_tVar.get_buf();
                    byte[] bArr611111111111111118 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111118, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111111118, 4, 0);
                    tlv_tVar2.set_data(bArr611111111111111118, 6);
                    byte[] bArr611111111111111119 = tlv_tVar2.get_buf();
                    int i11112 = i14 + 1 + 1;
                    int length2111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111111117.length + bArr621111111118.length + bArr621111111119.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr6111111111111111110 = bArr10;
                    byte[] bArr6111111111111111111 = bArr31;
                    byte[] bArr71111111111111111111111113 = new byte[length2111111111111111111111111119 + bArr6111111111111111110.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51114.length + bArr621111111116.length + bArr611111111111111117.length + bArr611111111111111119.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111111111113, 0, bArr35.length);
                    int length3111111111111111111118 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111111111113, length3111111111111111111118, bArr36.length);
                    int length3111111111111111111119 = length3111111111111111111118 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111111111113, length3111111111111111111119, bArr37.length);
                    int length31111111111111111111110 = length3111111111111111111119 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111111111113, length31111111111111111111110, bArr40.length);
                    int length31111111111111111111111 = length31111111111111111111110 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111111111113, length31111111111111111111111, bArr38.length);
                    int length31111111111111111111112 = length31111111111111111111111 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111111111113, length31111111111111111111112, bArr39.length);
                    int length31111111111111111111113 = length31111111111111111111112 + bArr39.length;
                    java.lang.System.arraycopy(bArr621111111117, 0, bArr71111111111111111111111113, length31111111111111111111113, bArr621111111117.length);
                    int length31111111111111111111114 = length31111111111111111111113 + bArr621111111117.length;
                    java.lang.System.arraycopy(bArr621111111118, 0, bArr71111111111111111111111113, length31111111111111111111114, bArr621111111118.length);
                    int length31111111111111111111115 = length31111111111111111111114 + bArr621111111118.length;
                    java.lang.System.arraycopy(bArr621111111119, 0, bArr71111111111111111111111113, length31111111111111111111115, bArr621111111119.length);
                    int length11111111111111111111111111110 = length31111111111111111111115 + bArr621111111119.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111111111113, length11111111111111111111111111110, bArr26.length);
                    int length11111111111111111111111111111 = length11111111111111111111111111110 + bArr26.length;
                    byte[] bArr71111111111111111111111114 = bArr41;
                    java.lang.System.arraycopy(bArr71111111111111111111111114, 0, bArr71111111111111111111111113, length11111111111111111111111111111, bArr71111111111111111111111114.length);
                    int length11111111111111111111111111112 = length11111111111111111111111111111 + bArr71111111111111111111111114.length;
                    byte[] bArr71111111111111111111111115 = bArr8;
                    java.lang.System.arraycopy(bArr71111111111111111111111115, 0, bArr71111111111111111111111113, length11111111111111111111111111112, bArr71111111111111111111111115.length);
                    int length11111111111111111111111111113 = length11111111111111111111111111112 + bArr71111111111111111111111115.length;
                    byte[] bArr71111111111111111111111116 = bArr30;
                    java.lang.System.arraycopy(bArr71111111111111111111111116, 0, bArr71111111111111111111111113, length11111111111111111111111111113, bArr71111111111111111111111116.length);
                    int length11111111111111111111111111114 = length11111111111111111111111111113 + bArr71111111111111111111111116.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111111111113, length11111111111111111111111111114, bArr42.length);
                    int length11111111111111111111111111115 = length11111111111111111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111111111113, length11111111111111111111111111115, bArr43.length);
                    int length11111111111111111111111111116 = length11111111111111111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111111111113, length11111111111111111111111111116, bArr44.length);
                    int length11111111111111111111111111117 = length11111111111111111111111111116 + bArr44.length;
                    byte[] bArr71111111111111111111111117 = bArr29;
                    java.lang.System.arraycopy(bArr71111111111111111111111117, 0, bArr71111111111111111111111113, length11111111111111111111111111117, bArr71111111111111111111111117.length);
                    int length11111111111111111111111111118 = length11111111111111111111111111117 + bArr71111111111111111111111117.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111111111113, length11111111111111111111111111118, bArr45.length);
                    int length11111111111111111111111111119 = length11111111111111111111111111118 + bArr45.length;
                    byte[] bArr71111111111111111111111118 = bArr13;
                    java.lang.System.arraycopy(bArr71111111111111111111111118, 0, bArr71111111111111111111111113, length11111111111111111111111111119, bArr71111111111111111111111118.length);
                    int length21111111111111111111111111110 = length11111111111111111111111111119 + bArr71111111111111111111111118.length;
                    java.lang.System.arraycopy(bArr6111111111111111110, 0, bArr71111111111111111111111113, length21111111111111111111111111110, bArr6111111111111111110.length);
                    int length21111111111111111111111111111 = length21111111111111111111111111110 + bArr6111111111111111110.length;
                    java.lang.System.arraycopy(bArr6111111111111111111, 0, bArr71111111111111111111111113, length21111111111111111111111111111, bArr6111111111111111111.length);
                    int length21111111111111111111111111112 = length21111111111111111111111111111 + bArr6111111111111111111.length;
                    byte[] bArr71111111111111111111111119 = bArr16;
                    java.lang.System.arraycopy(bArr71111111111111111111111119, 0, bArr71111111111111111111111113, length21111111111111111111111111112, bArr71111111111111111111111119.length);
                    int length21111111111111111111111111113 = length21111111111111111111111111112 + bArr71111111111111111111111119.length;
                    byte[] bArr711111111111111111111111110 = bArr19;
                    java.lang.System.arraycopy(bArr711111111111111111111111110, 0, bArr71111111111111111111111113, length21111111111111111111111111113, bArr711111111111111111111111110.length);
                    int length21111111111111111111111111114 = length21111111111111111111111111113 + bArr711111111111111111111111110.length;
                    byte[] bArr711111111111111111111111111 = bArr22;
                    java.lang.System.arraycopy(bArr711111111111111111111111111, 0, bArr71111111111111111111111113, length21111111111111111111111111114, bArr711111111111111111111111111.length);
                    int length21111111111111111111111111115 = length21111111111111111111111111114 + bArr711111111111111111111111111.length;
                    java.lang.System.arraycopy(bArr51114, 0, bArr71111111111111111111111113, length21111111111111111111111111115, bArr51114.length);
                    int length21111111111111111111111111116 = length21111111111111111111111111115 + bArr51114.length;
                    java.lang.System.arraycopy(bArr621111111116, 0, bArr71111111111111111111111113, length21111111111111111111111111116, bArr621111111116.length);
                    int length21111111111111111111111111117 = length21111111111111111111111111116 + bArr621111111116.length;
                    java.lang.System.arraycopy(bArr611111111111111117, 0, bArr71111111111111111111111113, length21111111111111111111111111117, bArr611111111111111117.length);
                    java.lang.System.arraycopy(bArr611111111111111119, 0, bArr71111111111111111111111113, length21111111111111111111111111117 + bArr611111111111111117.length, bArr611111111111111119.length);
                    int length21111111111111111111111111118 = bArr611111111111111119.length;
                    return a(a(bArr71111111111111111111111113, this.u, i11112), this.y, this.A, this.B);
                }
                bArr19 = bArr17;
                bArr20 = bArr56;
                bArr21 = oicq.wlogin_sdk.request.l.J;
                if (bArr21 != null) {
                    bArr22 = bArr20;
                    if (bArr21.length > 0) {
                        bArr41 = bArr41;
                        bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                        i12++;
                    }
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr51115 = bArr23;
                    byte[] bArr6211111111110 = bArr25;
                    byte[] bArr6211111111111 = bArr7;
                    byte[] bArr6211111111112 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr6211111111113 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr6111111111111111112 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111112, 0, i11);
                    tlv_tVar.set_data(bArr6111111111111111112, 4);
                    byte[] bArr6111111111111111113 = tlv_tVar.get_buf();
                    byte[] bArr6111111111111111114 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111114, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr6111111111111111114, 4, 0);
                    tlv_tVar2.set_data(bArr6111111111111111114, 6);
                    byte[] bArr6111111111111111115 = tlv_tVar2.get_buf();
                    int i11113 = i14 + 1 + 1;
                    int length21111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211111111111.length + bArr6211111111112.length + bArr6211111111113.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr6111111111111111116 = bArr10;
                    byte[] bArr6111111111111111117 = bArr31;
                    byte[] bArr711111111111111111111111112 = new byte[length21111111111111111111111111119 + bArr6111111111111111116.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51115.length + bArr6211111111110.length + bArr6111111111111111113.length + bArr6111111111111111115.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr711111111111111111111111112, 0, bArr35.length);
                    int length31111111111111111111116 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr711111111111111111111111112, length31111111111111111111116, bArr36.length);
                    int length31111111111111111111117 = length31111111111111111111116 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr711111111111111111111111112, length31111111111111111111117, bArr37.length);
                    int length31111111111111111111118 = length31111111111111111111117 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr711111111111111111111111112, length31111111111111111111118, bArr40.length);
                    int length31111111111111111111119 = length31111111111111111111118 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr711111111111111111111111112, length31111111111111111111119, bArr38.length);
                    int length311111111111111111111110 = length31111111111111111111119 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr711111111111111111111111112, length311111111111111111111110, bArr39.length);
                    int length311111111111111111111111 = length311111111111111111111110 + bArr39.length;
                    java.lang.System.arraycopy(bArr6211111111111, 0, bArr711111111111111111111111112, length311111111111111111111111, bArr6211111111111.length);
                    int length311111111111111111111112 = length311111111111111111111111 + bArr6211111111111.length;
                    java.lang.System.arraycopy(bArr6211111111112, 0, bArr711111111111111111111111112, length311111111111111111111112, bArr6211111111112.length);
                    int length311111111111111111111113 = length311111111111111111111112 + bArr6211111111112.length;
                    java.lang.System.arraycopy(bArr6211111111113, 0, bArr711111111111111111111111112, length311111111111111111111113, bArr6211111111113.length);
                    int length111111111111111111111111111110 = length311111111111111111111113 + bArr6211111111113.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr711111111111111111111111112, length111111111111111111111111111110, bArr26.length);
                    int length111111111111111111111111111111 = length111111111111111111111111111110 + bArr26.length;
                    byte[] bArr711111111111111111111111113 = bArr41;
                    java.lang.System.arraycopy(bArr711111111111111111111111113, 0, bArr711111111111111111111111112, length111111111111111111111111111111, bArr711111111111111111111111113.length);
                    int length111111111111111111111111111112 = length111111111111111111111111111111 + bArr711111111111111111111111113.length;
                    byte[] bArr711111111111111111111111114 = bArr8;
                    java.lang.System.arraycopy(bArr711111111111111111111111114, 0, bArr711111111111111111111111112, length111111111111111111111111111112, bArr711111111111111111111111114.length);
                    int length111111111111111111111111111113 = length111111111111111111111111111112 + bArr711111111111111111111111114.length;
                    byte[] bArr711111111111111111111111115 = bArr30;
                    java.lang.System.arraycopy(bArr711111111111111111111111115, 0, bArr711111111111111111111111112, length111111111111111111111111111113, bArr711111111111111111111111115.length);
                    int length111111111111111111111111111114 = length111111111111111111111111111113 + bArr711111111111111111111111115.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr711111111111111111111111112, length111111111111111111111111111114, bArr42.length);
                    int length111111111111111111111111111115 = length111111111111111111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr711111111111111111111111112, length111111111111111111111111111115, bArr43.length);
                    int length111111111111111111111111111116 = length111111111111111111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr711111111111111111111111112, length111111111111111111111111111116, bArr44.length);
                    int length111111111111111111111111111117 = length111111111111111111111111111116 + bArr44.length;
                    byte[] bArr711111111111111111111111116 = bArr29;
                    java.lang.System.arraycopy(bArr711111111111111111111111116, 0, bArr711111111111111111111111112, length111111111111111111111111111117, bArr711111111111111111111111116.length);
                    int length111111111111111111111111111118 = length111111111111111111111111111117 + bArr711111111111111111111111116.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr711111111111111111111111112, length111111111111111111111111111118, bArr45.length);
                    int length111111111111111111111111111119 = length111111111111111111111111111118 + bArr45.length;
                    byte[] bArr711111111111111111111111117 = bArr13;
                    java.lang.System.arraycopy(bArr711111111111111111111111117, 0, bArr711111111111111111111111112, length111111111111111111111111111119, bArr711111111111111111111111117.length);
                    int length211111111111111111111111111110 = length111111111111111111111111111119 + bArr711111111111111111111111117.length;
                    java.lang.System.arraycopy(bArr6111111111111111116, 0, bArr711111111111111111111111112, length211111111111111111111111111110, bArr6111111111111111116.length);
                    int length211111111111111111111111111111 = length211111111111111111111111111110 + bArr6111111111111111116.length;
                    java.lang.System.arraycopy(bArr6111111111111111117, 0, bArr711111111111111111111111112, length211111111111111111111111111111, bArr6111111111111111117.length);
                    int length211111111111111111111111111112 = length211111111111111111111111111111 + bArr6111111111111111117.length;
                    byte[] bArr711111111111111111111111118 = bArr16;
                    java.lang.System.arraycopy(bArr711111111111111111111111118, 0, bArr711111111111111111111111112, length211111111111111111111111111112, bArr711111111111111111111111118.length);
                    int length211111111111111111111111111113 = length211111111111111111111111111112 + bArr711111111111111111111111118.length;
                    byte[] bArr711111111111111111111111119 = bArr19;
                    java.lang.System.arraycopy(bArr711111111111111111111111119, 0, bArr711111111111111111111111112, length211111111111111111111111111113, bArr711111111111111111111111119.length);
                    int length211111111111111111111111111114 = length211111111111111111111111111113 + bArr711111111111111111111111119.length;
                    byte[] bArr7111111111111111111111111110 = bArr22;
                    java.lang.System.arraycopy(bArr7111111111111111111111111110, 0, bArr711111111111111111111111112, length211111111111111111111111111114, bArr7111111111111111111111111110.length);
                    int length211111111111111111111111111115 = length211111111111111111111111111114 + bArr7111111111111111111111111110.length;
                    java.lang.System.arraycopy(bArr51115, 0, bArr711111111111111111111111112, length211111111111111111111111111115, bArr51115.length);
                    int length211111111111111111111111111116 = length211111111111111111111111111115 + bArr51115.length;
                    java.lang.System.arraycopy(bArr6211111111110, 0, bArr711111111111111111111111112, length211111111111111111111111111116, bArr6211111111110.length);
                    int length211111111111111111111111111117 = length211111111111111111111111111116 + bArr6211111111110.length;
                    java.lang.System.arraycopy(bArr6111111111111111113, 0, bArr711111111111111111111111112, length211111111111111111111111111117, bArr6111111111111111113.length);
                    java.lang.System.arraycopy(bArr6111111111111111115, 0, bArr711111111111111111111111112, length211111111111111111111111111117 + bArr6111111111111111113.length, bArr6111111111111111115.length);
                    int length211111111111111111111111111118 = bArr6111111111111111115.length;
                    return a(a(bArr711111111111111111111111112, this.u, i11113), this.y, this.A, this.B);
                }
                bArr22 = bArr20;
                bArr23 = bArr57;
                bArr24 = oicq.wlogin_sdk.request.t.R;
                if (bArr24 != null) {
                    bArr25 = bArr6;
                } else {
                    bArr25 = bArr6;
                }
                byte[] bArr51116 = bArr23;
                byte[] bArr6211111111114 = bArr25;
                byte[] bArr6211111111115 = bArr7;
                byte[] bArr6211111111116 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                byte[] bArr6211111111117 = tlv_t142Var.get_tlv_142(bArr5);
                i13 = i12 + 1 + 1;
                str = this.x.g;
                if (str != null) {
                    i14 = i13;
                    bArr26 = bArr48;
                } else {
                    i14 = i13;
                    bArr26 = bArr48;
                }
                if (bArr3 != null) {
                    bArr27 = bArr50;
                } else {
                    bArr27 = bArr50;
                }
                if (list != null) {
                    bArr28 = bArr51;
                } else {
                    bArr28 = bArr51;
                }
                if (wloginSigInfoA == null) {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                } else {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                }
                byte[] bArr6111111111111111118 = new byte[4];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111118, 0, i11);
                tlv_tVar.set_data(bArr6111111111111111118, 4);
                byte[] bArr6111111111111111119 = tlv_tVar.get_buf();
                byte[] bArr61111111111111111110 = new byte[6];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111110, 0, oicq.wlogin_sdk.request.t.au);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111111110, 4, 0);
                tlv_tVar2.set_data(bArr61111111111111111110, 6);
                byte[] bArr61111111111111111111 = tlv_tVar2.get_buf();
                int i11114 = i14 + 1 + 1;
                int length211111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211111111115.length + bArr6211111111116.length + bArr6211111111117.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                byte[] bArr61111111111111111112 = bArr10;
                byte[] bArr61111111111111111113 = bArr31;
                byte[] bArr7111111111111111111111111111 = new byte[length211111111111111111111111111119 + bArr61111111111111111112.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51116.length + bArr6211111111114.length + bArr6111111111111111119.length + bArr61111111111111111111.length];
                java.lang.System.arraycopy(bArr35, 0, bArr7111111111111111111111111111, 0, bArr35.length);
                int length311111111111111111111114 = bArr35.length + 0;
                java.lang.System.arraycopy(bArr36, 0, bArr7111111111111111111111111111, length311111111111111111111114, bArr36.length);
                int length311111111111111111111115 = length311111111111111111111114 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr7111111111111111111111111111, length311111111111111111111115, bArr37.length);
                int length311111111111111111111116 = length311111111111111111111115 + bArr37.length;
                java.lang.System.arraycopy(bArr40, 0, bArr7111111111111111111111111111, length311111111111111111111116, bArr40.length);
                int length311111111111111111111117 = length311111111111111111111116 + bArr40.length;
                java.lang.System.arraycopy(bArr38, 0, bArr7111111111111111111111111111, length311111111111111111111117, bArr38.length);
                int length311111111111111111111118 = length311111111111111111111117 + bArr38.length;
                java.lang.System.arraycopy(bArr39, 0, bArr7111111111111111111111111111, length311111111111111111111118, bArr39.length);
                int length311111111111111111111119 = length311111111111111111111118 + bArr39.length;
                java.lang.System.arraycopy(bArr6211111111115, 0, bArr7111111111111111111111111111, length311111111111111111111119, bArr6211111111115.length);
                int length3111111111111111111111110 = length311111111111111111111119 + bArr6211111111115.length;
                java.lang.System.arraycopy(bArr6211111111116, 0, bArr7111111111111111111111111111, length3111111111111111111111110, bArr6211111111116.length);
                int length3111111111111111111111111 = length3111111111111111111111110 + bArr6211111111116.length;
                java.lang.System.arraycopy(bArr6211111111117, 0, bArr7111111111111111111111111111, length3111111111111111111111111, bArr6211111111117.length);
                int length1111111111111111111111111111110 = length3111111111111111111111111 + bArr6211111111117.length;
                java.lang.System.arraycopy(bArr26, 0, bArr7111111111111111111111111111, length1111111111111111111111111111110, bArr26.length);
                int length1111111111111111111111111111111 = length1111111111111111111111111111110 + bArr26.length;
                byte[] bArr7111111111111111111111111112 = bArr41;
                java.lang.System.arraycopy(bArr7111111111111111111111111112, 0, bArr7111111111111111111111111111, length1111111111111111111111111111111, bArr7111111111111111111111111112.length);
                int length1111111111111111111111111111112 = length1111111111111111111111111111111 + bArr7111111111111111111111111112.length;
                byte[] bArr7111111111111111111111111113 = bArr8;
                java.lang.System.arraycopy(bArr7111111111111111111111111113, 0, bArr7111111111111111111111111111, length1111111111111111111111111111112, bArr7111111111111111111111111113.length);
                int length1111111111111111111111111111113 = length1111111111111111111111111111112 + bArr7111111111111111111111111113.length;
                byte[] bArr7111111111111111111111111114 = bArr30;
                java.lang.System.arraycopy(bArr7111111111111111111111111114, 0, bArr7111111111111111111111111111, length1111111111111111111111111111113, bArr7111111111111111111111111114.length);
                int length1111111111111111111111111111114 = length1111111111111111111111111111113 + bArr7111111111111111111111111114.length;
                java.lang.System.arraycopy(bArr42, 0, bArr7111111111111111111111111111, length1111111111111111111111111111114, bArr42.length);
                int length1111111111111111111111111111115 = length1111111111111111111111111111114 + bArr42.length;
                java.lang.System.arraycopy(bArr43, 0, bArr7111111111111111111111111111, length1111111111111111111111111111115, bArr43.length);
                int length1111111111111111111111111111116 = length1111111111111111111111111111115 + bArr43.length;
                java.lang.System.arraycopy(bArr44, 0, bArr7111111111111111111111111111, length1111111111111111111111111111116, bArr44.length);
                int length1111111111111111111111111111117 = length1111111111111111111111111111116 + bArr44.length;
                byte[] bArr7111111111111111111111111115 = bArr29;
                java.lang.System.arraycopy(bArr7111111111111111111111111115, 0, bArr7111111111111111111111111111, length1111111111111111111111111111117, bArr7111111111111111111111111115.length);
                int length1111111111111111111111111111118 = length1111111111111111111111111111117 + bArr7111111111111111111111111115.length;
                java.lang.System.arraycopy(bArr45, 0, bArr7111111111111111111111111111, length1111111111111111111111111111118, bArr45.length);
                int length1111111111111111111111111111119 = length1111111111111111111111111111118 + bArr45.length;
                byte[] bArr7111111111111111111111111116 = bArr13;
                java.lang.System.arraycopy(bArr7111111111111111111111111116, 0, bArr7111111111111111111111111111, length1111111111111111111111111111119, bArr7111111111111111111111111116.length);
                int length2111111111111111111111111111110 = length1111111111111111111111111111119 + bArr7111111111111111111111111116.length;
                java.lang.System.arraycopy(bArr61111111111111111112, 0, bArr7111111111111111111111111111, length2111111111111111111111111111110, bArr61111111111111111112.length);
                int length2111111111111111111111111111111 = length2111111111111111111111111111110 + bArr61111111111111111112.length;
                java.lang.System.arraycopy(bArr61111111111111111113, 0, bArr7111111111111111111111111111, length2111111111111111111111111111111, bArr61111111111111111113.length);
                int length2111111111111111111111111111112 = length2111111111111111111111111111111 + bArr61111111111111111113.length;
                byte[] bArr7111111111111111111111111117 = bArr16;
                java.lang.System.arraycopy(bArr7111111111111111111111111117, 0, bArr7111111111111111111111111111, length2111111111111111111111111111112, bArr7111111111111111111111111117.length);
                int length2111111111111111111111111111113 = length2111111111111111111111111111112 + bArr7111111111111111111111111117.length;
                byte[] bArr7111111111111111111111111118 = bArr19;
                java.lang.System.arraycopy(bArr7111111111111111111111111118, 0, bArr7111111111111111111111111111, length2111111111111111111111111111113, bArr7111111111111111111111111118.length);
                int length2111111111111111111111111111114 = length2111111111111111111111111111113 + bArr7111111111111111111111111118.length;
                byte[] bArr7111111111111111111111111119 = bArr22;
                java.lang.System.arraycopy(bArr7111111111111111111111111119, 0, bArr7111111111111111111111111111, length2111111111111111111111111111114, bArr7111111111111111111111111119.length);
                int length2111111111111111111111111111115 = length2111111111111111111111111111114 + bArr7111111111111111111111111119.length;
                java.lang.System.arraycopy(bArr51116, 0, bArr7111111111111111111111111111, length2111111111111111111111111111115, bArr51116.length);
                int length2111111111111111111111111111116 = length2111111111111111111111111111115 + bArr51116.length;
                java.lang.System.arraycopy(bArr6211111111114, 0, bArr7111111111111111111111111111, length2111111111111111111111111111116, bArr6211111111114.length);
                int length2111111111111111111111111111117 = length2111111111111111111111111111116 + bArr6211111111114.length;
                java.lang.System.arraycopy(bArr6111111111111111119, 0, bArr7111111111111111111111111111, length2111111111111111111111111111117, bArr6111111111111111119.length);
                java.lang.System.arraycopy(bArr61111111111111111111, 0, bArr7111111111111111111111111111, length2111111111111111111111111111117 + bArr6111111111111111119.length, bArr61111111111111111111.length);
                int length2111111111111111111111111111118 = bArr61111111111111111111.length;
                return a(a(bArr7111111111111111111111111111, this.u, i11114), this.y, this.A, this.B);
            }
            bArr16 = bArr14;
            bArr17 = bArr55;
            bArr18 = oicq.wlogin_sdk.request.t.L;
            if (bArr18 != null) {
                bArr19 = bArr17;
                if (bArr18.length > 0) {
                    bArr20 = tlv_t194Var.get_tlv_194(bArr18);
                    i12++;
                }
                bArr21 = oicq.wlogin_sdk.request.l.J;
                if (bArr21 != null) {
                    bArr22 = bArr20;
                    if (bArr21.length > 0) {
                        bArr41 = bArr41;
                        bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                        i12++;
                    }
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr51117 = bArr23;
                    byte[] bArr6211111111118 = bArr25;
                    byte[] bArr6211111111119 = bArr7;
                    byte[] bArr62111111111110 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr62111111111111 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr61111111111111111114 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111114, 0, i11);
                    tlv_tVar.set_data(bArr61111111111111111114, 4);
                    byte[] bArr61111111111111111115 = tlv_tVar.get_buf();
                    byte[] bArr61111111111111111116 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111116, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111111116, 4, 0);
                    tlv_tVar2.set_data(bArr61111111111111111116, 6);
                    byte[] bArr61111111111111111117 = tlv_tVar2.get_buf();
                    int i11115 = i14 + 1 + 1;
                    int length2111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211111111119.length + bArr62111111111110.length + bArr62111111111111.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr61111111111111111118 = bArr10;
                    byte[] bArr61111111111111111119 = bArr31;
                    byte[] bArr71111111111111111111111111110 = new byte[length2111111111111111111111111111119 + bArr61111111111111111118.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51117.length + bArr6211111111118.length + bArr61111111111111111115.length + bArr61111111111111111117.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111111111111110, 0, bArr35.length);
                    int length3111111111111111111111112 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111111111111110, length3111111111111111111111112, bArr36.length);
                    int length3111111111111111111111113 = length3111111111111111111111112 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111111111111110, length3111111111111111111111113, bArr37.length);
                    int length3111111111111111111111114 = length3111111111111111111111113 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111111111111110, length3111111111111111111111114, bArr40.length);
                    int length3111111111111111111111115 = length3111111111111111111111114 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111111111111110, length3111111111111111111111115, bArr38.length);
                    int length3111111111111111111111116 = length3111111111111111111111115 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111111111111110, length3111111111111111111111116, bArr39.length);
                    int length3111111111111111111111117 = length3111111111111111111111116 + bArr39.length;
                    java.lang.System.arraycopy(bArr6211111111119, 0, bArr71111111111111111111111111110, length3111111111111111111111117, bArr6211111111119.length);
                    int length3111111111111111111111118 = length3111111111111111111111117 + bArr6211111111119.length;
                    java.lang.System.arraycopy(bArr62111111111110, 0, bArr71111111111111111111111111110, length3111111111111111111111118, bArr62111111111110.length);
                    int length3111111111111111111111119 = length3111111111111111111111118 + bArr62111111111110.length;
                    java.lang.System.arraycopy(bArr62111111111111, 0, bArr71111111111111111111111111110, length3111111111111111111111119, bArr62111111111111.length);
                    int length11111111111111111111111111111110 = length3111111111111111111111119 + bArr62111111111111.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111111111111110, length11111111111111111111111111111110, bArr26.length);
                    int length11111111111111111111111111111111 = length11111111111111111111111111111110 + bArr26.length;
                    byte[] bArr71111111111111111111111111111 = bArr41;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111, 0, bArr71111111111111111111111111110, length11111111111111111111111111111111, bArr71111111111111111111111111111.length);
                    int length11111111111111111111111111111112 = length11111111111111111111111111111111 + bArr71111111111111111111111111111.length;
                    byte[] bArr71111111111111111111111111112 = bArr8;
                    java.lang.System.arraycopy(bArr71111111111111111111111111112, 0, bArr71111111111111111111111111110, length11111111111111111111111111111112, bArr71111111111111111111111111112.length);
                    int length11111111111111111111111111111113 = length11111111111111111111111111111112 + bArr71111111111111111111111111112.length;
                    byte[] bArr71111111111111111111111111113 = bArr30;
                    java.lang.System.arraycopy(bArr71111111111111111111111111113, 0, bArr71111111111111111111111111110, length11111111111111111111111111111113, bArr71111111111111111111111111113.length);
                    int length11111111111111111111111111111114 = length11111111111111111111111111111113 + bArr71111111111111111111111111113.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111111111111110, length11111111111111111111111111111114, bArr42.length);
                    int length11111111111111111111111111111115 = length11111111111111111111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111111111111110, length11111111111111111111111111111115, bArr43.length);
                    int length11111111111111111111111111111116 = length11111111111111111111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111111111111110, length11111111111111111111111111111116, bArr44.length);
                    int length11111111111111111111111111111117 = length11111111111111111111111111111116 + bArr44.length;
                    byte[] bArr71111111111111111111111111114 = bArr29;
                    java.lang.System.arraycopy(bArr71111111111111111111111111114, 0, bArr71111111111111111111111111110, length11111111111111111111111111111117, bArr71111111111111111111111111114.length);
                    int length11111111111111111111111111111118 = length11111111111111111111111111111117 + bArr71111111111111111111111111114.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111111111111110, length11111111111111111111111111111118, bArr45.length);
                    int length11111111111111111111111111111119 = length11111111111111111111111111111118 + bArr45.length;
                    byte[] bArr71111111111111111111111111115 = bArr13;
                    java.lang.System.arraycopy(bArr71111111111111111111111111115, 0, bArr71111111111111111111111111110, length11111111111111111111111111111119, bArr71111111111111111111111111115.length);
                    int length21111111111111111111111111111110 = length11111111111111111111111111111119 + bArr71111111111111111111111111115.length;
                    java.lang.System.arraycopy(bArr61111111111111111118, 0, bArr71111111111111111111111111110, length21111111111111111111111111111110, bArr61111111111111111118.length);
                    int length21111111111111111111111111111111 = length21111111111111111111111111111110 + bArr61111111111111111118.length;
                    java.lang.System.arraycopy(bArr61111111111111111119, 0, bArr71111111111111111111111111110, length21111111111111111111111111111111, bArr61111111111111111119.length);
                    int length21111111111111111111111111111112 = length21111111111111111111111111111111 + bArr61111111111111111119.length;
                    byte[] bArr71111111111111111111111111116 = bArr16;
                    java.lang.System.arraycopy(bArr71111111111111111111111111116, 0, bArr71111111111111111111111111110, length21111111111111111111111111111112, bArr71111111111111111111111111116.length);
                    int length21111111111111111111111111111113 = length21111111111111111111111111111112 + bArr71111111111111111111111111116.length;
                    byte[] bArr71111111111111111111111111117 = bArr19;
                    java.lang.System.arraycopy(bArr71111111111111111111111111117, 0, bArr71111111111111111111111111110, length21111111111111111111111111111113, bArr71111111111111111111111111117.length);
                    int length21111111111111111111111111111114 = length21111111111111111111111111111113 + bArr71111111111111111111111111117.length;
                    byte[] bArr71111111111111111111111111118 = bArr22;
                    java.lang.System.arraycopy(bArr71111111111111111111111111118, 0, bArr71111111111111111111111111110, length21111111111111111111111111111114, bArr71111111111111111111111111118.length);
                    int length21111111111111111111111111111115 = length21111111111111111111111111111114 + bArr71111111111111111111111111118.length;
                    java.lang.System.arraycopy(bArr51117, 0, bArr71111111111111111111111111110, length21111111111111111111111111111115, bArr51117.length);
                    int length21111111111111111111111111111116 = length21111111111111111111111111111115 + bArr51117.length;
                    java.lang.System.arraycopy(bArr6211111111118, 0, bArr71111111111111111111111111110, length21111111111111111111111111111116, bArr6211111111118.length);
                    int length21111111111111111111111111111117 = length21111111111111111111111111111116 + bArr6211111111118.length;
                    java.lang.System.arraycopy(bArr61111111111111111115, 0, bArr71111111111111111111111111110, length21111111111111111111111111111117, bArr61111111111111111115.length);
                    java.lang.System.arraycopy(bArr61111111111111111117, 0, bArr71111111111111111111111111110, length21111111111111111111111111111117 + bArr61111111111111111115.length, bArr61111111111111111117.length);
                    int length21111111111111111111111111111118 = bArr61111111111111111117.length;
                    return a(a(bArr71111111111111111111111111110, this.u, i11115), this.y, this.A, this.B);
                }
                bArr22 = bArr20;
                bArr23 = bArr57;
                bArr24 = oicq.wlogin_sdk.request.t.R;
                if (bArr24 != null) {
                    bArr25 = bArr6;
                } else {
                    bArr25 = bArr6;
                }
                byte[] bArr51118 = bArr23;
                byte[] bArr62111111111112 = bArr25;
                byte[] bArr62111111111113 = bArr7;
                byte[] bArr62111111111114 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                byte[] bArr62111111111115 = tlv_t142Var.get_tlv_142(bArr5);
                i13 = i12 + 1 + 1;
                str = this.x.g;
                if (str != null) {
                    i14 = i13;
                    bArr26 = bArr48;
                } else {
                    i14 = i13;
                    bArr26 = bArr48;
                }
                if (bArr3 != null) {
                    bArr27 = bArr50;
                } else {
                    bArr27 = bArr50;
                }
                if (list != null) {
                    bArr28 = bArr51;
                } else {
                    bArr28 = bArr51;
                }
                if (wloginSigInfoA == null) {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                } else {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                }
                byte[] bArr611111111111111111110 = new byte[4];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111110, 0, i11);
                tlv_tVar.set_data(bArr611111111111111111110, 4);
                byte[] bArr611111111111111111111 = tlv_tVar.get_buf();
                byte[] bArr611111111111111111112 = new byte[6];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111112, 0, oicq.wlogin_sdk.request.t.au);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111111111112, 4, 0);
                tlv_tVar2.set_data(bArr611111111111111111112, 6);
                byte[] bArr611111111111111111113 = tlv_tVar2.get_buf();
                int i11116 = i14 + 1 + 1;
                int length21111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111111111113.length + bArr62111111111114.length + bArr62111111111115.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                byte[] bArr611111111111111111114 = bArr10;
                byte[] bArr611111111111111111115 = bArr31;
                byte[] bArr71111111111111111111111111119 = new byte[length21111111111111111111111111111119 + bArr611111111111111111114.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51118.length + bArr62111111111112.length + bArr611111111111111111111.length + bArr611111111111111111113.length];
                java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111111111111119, 0, bArr35.length);
                int length31111111111111111111111110 = bArr35.length + 0;
                java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111111111111119, length31111111111111111111111110, bArr36.length);
                int length31111111111111111111111111 = length31111111111111111111111110 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111111111111119, length31111111111111111111111111, bArr37.length);
                int length31111111111111111111111112 = length31111111111111111111111111 + bArr37.length;
                java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111111111111119, length31111111111111111111111112, bArr40.length);
                int length31111111111111111111111113 = length31111111111111111111111112 + bArr40.length;
                java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111111111111119, length31111111111111111111111113, bArr38.length);
                int length31111111111111111111111114 = length31111111111111111111111113 + bArr38.length;
                java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111111111111119, length31111111111111111111111114, bArr39.length);
                int length31111111111111111111111115 = length31111111111111111111111114 + bArr39.length;
                java.lang.System.arraycopy(bArr62111111111113, 0, bArr71111111111111111111111111119, length31111111111111111111111115, bArr62111111111113.length);
                int length31111111111111111111111116 = length31111111111111111111111115 + bArr62111111111113.length;
                java.lang.System.arraycopy(bArr62111111111114, 0, bArr71111111111111111111111111119, length31111111111111111111111116, bArr62111111111114.length);
                int length31111111111111111111111117 = length31111111111111111111111116 + bArr62111111111114.length;
                java.lang.System.arraycopy(bArr62111111111115, 0, bArr71111111111111111111111111119, length31111111111111111111111117, bArr62111111111115.length);
                int length111111111111111111111111111111110 = length31111111111111111111111117 + bArr62111111111115.length;
                java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111111111111119, length111111111111111111111111111111110, bArr26.length);
                int length111111111111111111111111111111111 = length111111111111111111111111111111110 + bArr26.length;
                byte[] bArr711111111111111111111111111110 = bArr41;
                java.lang.System.arraycopy(bArr711111111111111111111111111110, 0, bArr71111111111111111111111111119, length111111111111111111111111111111111, bArr711111111111111111111111111110.length);
                int length111111111111111111111111111111112 = length111111111111111111111111111111111 + bArr711111111111111111111111111110.length;
                byte[] bArr711111111111111111111111111111 = bArr8;
                java.lang.System.arraycopy(bArr711111111111111111111111111111, 0, bArr71111111111111111111111111119, length111111111111111111111111111111112, bArr711111111111111111111111111111.length);
                int length111111111111111111111111111111113 = length111111111111111111111111111111112 + bArr711111111111111111111111111111.length;
                byte[] bArr711111111111111111111111111112 = bArr30;
                java.lang.System.arraycopy(bArr711111111111111111111111111112, 0, bArr71111111111111111111111111119, length111111111111111111111111111111113, bArr711111111111111111111111111112.length);
                int length111111111111111111111111111111114 = length111111111111111111111111111111113 + bArr711111111111111111111111111112.length;
                java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111111111111119, length111111111111111111111111111111114, bArr42.length);
                int length111111111111111111111111111111115 = length111111111111111111111111111111114 + bArr42.length;
                java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111111111111119, length111111111111111111111111111111115, bArr43.length);
                int length111111111111111111111111111111116 = length111111111111111111111111111111115 + bArr43.length;
                java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111111111111119, length111111111111111111111111111111116, bArr44.length);
                int length111111111111111111111111111111117 = length111111111111111111111111111111116 + bArr44.length;
                byte[] bArr711111111111111111111111111113 = bArr29;
                java.lang.System.arraycopy(bArr711111111111111111111111111113, 0, bArr71111111111111111111111111119, length111111111111111111111111111111117, bArr711111111111111111111111111113.length);
                int length111111111111111111111111111111118 = length111111111111111111111111111111117 + bArr711111111111111111111111111113.length;
                java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111111111111119, length111111111111111111111111111111118, bArr45.length);
                int length111111111111111111111111111111119 = length111111111111111111111111111111118 + bArr45.length;
                byte[] bArr711111111111111111111111111114 = bArr13;
                java.lang.System.arraycopy(bArr711111111111111111111111111114, 0, bArr71111111111111111111111111119, length111111111111111111111111111111119, bArr711111111111111111111111111114.length);
                int length211111111111111111111111111111110 = length111111111111111111111111111111119 + bArr711111111111111111111111111114.length;
                java.lang.System.arraycopy(bArr611111111111111111114, 0, bArr71111111111111111111111111119, length211111111111111111111111111111110, bArr611111111111111111114.length);
                int length211111111111111111111111111111111 = length211111111111111111111111111111110 + bArr611111111111111111114.length;
                java.lang.System.arraycopy(bArr611111111111111111115, 0, bArr71111111111111111111111111119, length211111111111111111111111111111111, bArr611111111111111111115.length);
                int length211111111111111111111111111111112 = length211111111111111111111111111111111 + bArr611111111111111111115.length;
                byte[] bArr711111111111111111111111111115 = bArr16;
                java.lang.System.arraycopy(bArr711111111111111111111111111115, 0, bArr71111111111111111111111111119, length211111111111111111111111111111112, bArr711111111111111111111111111115.length);
                int length211111111111111111111111111111113 = length211111111111111111111111111111112 + bArr711111111111111111111111111115.length;
                byte[] bArr711111111111111111111111111116 = bArr19;
                java.lang.System.arraycopy(bArr711111111111111111111111111116, 0, bArr71111111111111111111111111119, length211111111111111111111111111111113, bArr711111111111111111111111111116.length);
                int length211111111111111111111111111111114 = length211111111111111111111111111111113 + bArr711111111111111111111111111116.length;
                byte[] bArr711111111111111111111111111117 = bArr22;
                java.lang.System.arraycopy(bArr711111111111111111111111111117, 0, bArr71111111111111111111111111119, length211111111111111111111111111111114, bArr711111111111111111111111111117.length);
                int length211111111111111111111111111111115 = length211111111111111111111111111111114 + bArr711111111111111111111111111117.length;
                java.lang.System.arraycopy(bArr51118, 0, bArr71111111111111111111111111119, length211111111111111111111111111111115, bArr51118.length);
                int length211111111111111111111111111111116 = length211111111111111111111111111111115 + bArr51118.length;
                java.lang.System.arraycopy(bArr62111111111112, 0, bArr71111111111111111111111111119, length211111111111111111111111111111116, bArr62111111111112.length);
                int length211111111111111111111111111111117 = length211111111111111111111111111111116 + bArr62111111111112.length;
                java.lang.System.arraycopy(bArr611111111111111111111, 0, bArr71111111111111111111111111119, length211111111111111111111111111111117, bArr611111111111111111111.length);
                java.lang.System.arraycopy(bArr611111111111111111113, 0, bArr71111111111111111111111111119, length211111111111111111111111111111117 + bArr611111111111111111111.length, bArr611111111111111111113.length);
                int length211111111111111111111111111111118 = bArr611111111111111111113.length;
                return a(a(bArr71111111111111111111111111119, this.u, i11116), this.y, this.A, this.B);
            }
            bArr19 = bArr17;
            bArr20 = bArr56;
            bArr21 = oicq.wlogin_sdk.request.l.J;
            if (bArr21 != null) {
                bArr22 = bArr20;
                if (bArr21.length > 0) {
                    bArr41 = bArr41;
                    bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                    i12++;
                }
                bArr24 = oicq.wlogin_sdk.request.t.R;
                if (bArr24 != null) {
                    bArr25 = bArr6;
                } else {
                    bArr25 = bArr6;
                }
                byte[] bArr51119 = bArr23;
                byte[] bArr62111111111116 = bArr25;
                byte[] bArr62111111111117 = bArr7;
                byte[] bArr62111111111118 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                byte[] bArr62111111111119 = tlv_t142Var.get_tlv_142(bArr5);
                i13 = i12 + 1 + 1;
                str = this.x.g;
                if (str != null) {
                    i14 = i13;
                    bArr26 = bArr48;
                } else {
                    i14 = i13;
                    bArr26 = bArr48;
                }
                if (bArr3 != null) {
                    bArr27 = bArr50;
                } else {
                    bArr27 = bArr50;
                }
                if (list != null) {
                    bArr28 = bArr51;
                } else {
                    bArr28 = bArr51;
                }
                if (wloginSigInfoA == null) {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                } else {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                }
                byte[] bArr611111111111111111116 = new byte[4];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111116, 0, i11);
                tlv_tVar.set_data(bArr611111111111111111116, 4);
                byte[] bArr611111111111111111117 = tlv_tVar.get_buf();
                byte[] bArr611111111111111111118 = new byte[6];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111118, 0, oicq.wlogin_sdk.request.t.au);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111111111118, 4, 0);
                tlv_tVar2.set_data(bArr611111111111111111118, 6);
                byte[] bArr611111111111111111119 = tlv_tVar2.get_buf();
                int i11117 = i14 + 1 + 1;
                int length211111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111111111117.length + bArr62111111111118.length + bArr62111111111119.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                byte[] bArr6111111111111111111110 = bArr10;
                byte[] bArr6111111111111111111111 = bArr31;
                byte[] bArr711111111111111111111111111118 = new byte[length211111111111111111111111111111119 + bArr6111111111111111111110.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51119.length + bArr62111111111116.length + bArr611111111111111111117.length + bArr611111111111111111119.length];
                java.lang.System.arraycopy(bArr35, 0, bArr711111111111111111111111111118, 0, bArr35.length);
                int length31111111111111111111111118 = bArr35.length + 0;
                java.lang.System.arraycopy(bArr36, 0, bArr711111111111111111111111111118, length31111111111111111111111118, bArr36.length);
                int length31111111111111111111111119 = length31111111111111111111111118 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr711111111111111111111111111118, length31111111111111111111111119, bArr37.length);
                int length311111111111111111111111110 = length31111111111111111111111119 + bArr37.length;
                java.lang.System.arraycopy(bArr40, 0, bArr711111111111111111111111111118, length311111111111111111111111110, bArr40.length);
                int length311111111111111111111111111 = length311111111111111111111111110 + bArr40.length;
                java.lang.System.arraycopy(bArr38, 0, bArr711111111111111111111111111118, length311111111111111111111111111, bArr38.length);
                int length311111111111111111111111112 = length311111111111111111111111111 + bArr38.length;
                java.lang.System.arraycopy(bArr39, 0, bArr711111111111111111111111111118, length311111111111111111111111112, bArr39.length);
                int length311111111111111111111111113 = length311111111111111111111111112 + bArr39.length;
                java.lang.System.arraycopy(bArr62111111111117, 0, bArr711111111111111111111111111118, length311111111111111111111111113, bArr62111111111117.length);
                int length311111111111111111111111114 = length311111111111111111111111113 + bArr62111111111117.length;
                java.lang.System.arraycopy(bArr62111111111118, 0, bArr711111111111111111111111111118, length311111111111111111111111114, bArr62111111111118.length);
                int length311111111111111111111111115 = length311111111111111111111111114 + bArr62111111111118.length;
                java.lang.System.arraycopy(bArr62111111111119, 0, bArr711111111111111111111111111118, length311111111111111111111111115, bArr62111111111119.length);
                int length1111111111111111111111111111111110 = length311111111111111111111111115 + bArr62111111111119.length;
                java.lang.System.arraycopy(bArr26, 0, bArr711111111111111111111111111118, length1111111111111111111111111111111110, bArr26.length);
                int length1111111111111111111111111111111111 = length1111111111111111111111111111111110 + bArr26.length;
                byte[] bArr711111111111111111111111111119 = bArr41;
                java.lang.System.arraycopy(bArr711111111111111111111111111119, 0, bArr711111111111111111111111111118, length1111111111111111111111111111111111, bArr711111111111111111111111111119.length);
                int length1111111111111111111111111111111112 = length1111111111111111111111111111111111 + bArr711111111111111111111111111119.length;
                byte[] bArr7111111111111111111111111111110 = bArr8;
                java.lang.System.arraycopy(bArr7111111111111111111111111111110, 0, bArr711111111111111111111111111118, length1111111111111111111111111111111112, bArr7111111111111111111111111111110.length);
                int length1111111111111111111111111111111113 = length1111111111111111111111111111111112 + bArr7111111111111111111111111111110.length;
                byte[] bArr7111111111111111111111111111111 = bArr30;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111, 0, bArr711111111111111111111111111118, length1111111111111111111111111111111113, bArr7111111111111111111111111111111.length);
                int length1111111111111111111111111111111114 = length1111111111111111111111111111111113 + bArr7111111111111111111111111111111.length;
                java.lang.System.arraycopy(bArr42, 0, bArr711111111111111111111111111118, length1111111111111111111111111111111114, bArr42.length);
                int length1111111111111111111111111111111115 = length1111111111111111111111111111111114 + bArr42.length;
                java.lang.System.arraycopy(bArr43, 0, bArr711111111111111111111111111118, length1111111111111111111111111111111115, bArr43.length);
                int length1111111111111111111111111111111116 = length1111111111111111111111111111111115 + bArr43.length;
                java.lang.System.arraycopy(bArr44, 0, bArr711111111111111111111111111118, length1111111111111111111111111111111116, bArr44.length);
                int length1111111111111111111111111111111117 = length1111111111111111111111111111111116 + bArr44.length;
                byte[] bArr7111111111111111111111111111112 = bArr29;
                java.lang.System.arraycopy(bArr7111111111111111111111111111112, 0, bArr711111111111111111111111111118, length1111111111111111111111111111111117, bArr7111111111111111111111111111112.length);
                int length1111111111111111111111111111111118 = length1111111111111111111111111111111117 + bArr7111111111111111111111111111112.length;
                java.lang.System.arraycopy(bArr45, 0, bArr711111111111111111111111111118, length1111111111111111111111111111111118, bArr45.length);
                int length1111111111111111111111111111111119 = length1111111111111111111111111111111118 + bArr45.length;
                byte[] bArr7111111111111111111111111111113 = bArr13;
                java.lang.System.arraycopy(bArr7111111111111111111111111111113, 0, bArr711111111111111111111111111118, length1111111111111111111111111111111119, bArr7111111111111111111111111111113.length);
                int length2111111111111111111111111111111110 = length1111111111111111111111111111111119 + bArr7111111111111111111111111111113.length;
                java.lang.System.arraycopy(bArr6111111111111111111110, 0, bArr711111111111111111111111111118, length2111111111111111111111111111111110, bArr6111111111111111111110.length);
                int length2111111111111111111111111111111111 = length2111111111111111111111111111111110 + bArr6111111111111111111110.length;
                java.lang.System.arraycopy(bArr6111111111111111111111, 0, bArr711111111111111111111111111118, length2111111111111111111111111111111111, bArr6111111111111111111111.length);
                int length2111111111111111111111111111111112 = length2111111111111111111111111111111111 + bArr6111111111111111111111.length;
                byte[] bArr7111111111111111111111111111114 = bArr16;
                java.lang.System.arraycopy(bArr7111111111111111111111111111114, 0, bArr711111111111111111111111111118, length2111111111111111111111111111111112, bArr7111111111111111111111111111114.length);
                int length2111111111111111111111111111111113 = length2111111111111111111111111111111112 + bArr7111111111111111111111111111114.length;
                byte[] bArr7111111111111111111111111111115 = bArr19;
                java.lang.System.arraycopy(bArr7111111111111111111111111111115, 0, bArr711111111111111111111111111118, length2111111111111111111111111111111113, bArr7111111111111111111111111111115.length);
                int length2111111111111111111111111111111114 = length2111111111111111111111111111111113 + bArr7111111111111111111111111111115.length;
                byte[] bArr7111111111111111111111111111116 = bArr22;
                java.lang.System.arraycopy(bArr7111111111111111111111111111116, 0, bArr711111111111111111111111111118, length2111111111111111111111111111111114, bArr7111111111111111111111111111116.length);
                int length2111111111111111111111111111111115 = length2111111111111111111111111111111114 + bArr7111111111111111111111111111116.length;
                java.lang.System.arraycopy(bArr51119, 0, bArr711111111111111111111111111118, length2111111111111111111111111111111115, bArr51119.length);
                int length2111111111111111111111111111111116 = length2111111111111111111111111111111115 + bArr51119.length;
                java.lang.System.arraycopy(bArr62111111111116, 0, bArr711111111111111111111111111118, length2111111111111111111111111111111116, bArr62111111111116.length);
                int length2111111111111111111111111111111117 = length2111111111111111111111111111111116 + bArr62111111111116.length;
                java.lang.System.arraycopy(bArr611111111111111111117, 0, bArr711111111111111111111111111118, length2111111111111111111111111111111117, bArr611111111111111111117.length);
                java.lang.System.arraycopy(bArr611111111111111111119, 0, bArr711111111111111111111111111118, length2111111111111111111111111111111117 + bArr611111111111111111117.length, bArr611111111111111111119.length);
                int length2111111111111111111111111111111118 = bArr611111111111111111119.length;
                return a(a(bArr711111111111111111111111111118, this.u, i11117), this.y, this.A, this.B);
            }
            bArr22 = bArr20;
            bArr23 = bArr57;
            bArr24 = oicq.wlogin_sdk.request.t.R;
            if (bArr24 != null) {
                bArr25 = bArr6;
            } else {
                bArr25 = bArr6;
            }
            byte[] bArr511110 = bArr23;
            byte[] bArr621111111111110 = bArr25;
            byte[] bArr621111111111111 = bArr7;
            byte[] bArr621111111111112 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
            byte[] bArr621111111111113 = tlv_t142Var.get_tlv_142(bArr5);
            i13 = i12 + 1 + 1;
            str = this.x.g;
            if (str != null) {
                i14 = i13;
                bArr26 = bArr48;
            } else {
                i14 = i13;
                bArr26 = bArr48;
            }
            if (bArr3 != null) {
                bArr27 = bArr50;
            } else {
                bArr27 = bArr50;
            }
            if (list != null) {
                bArr28 = bArr51;
            } else {
                bArr28 = bArr51;
            }
            if (wloginSigInfoA == null) {
                bArr29 = bArr28;
                bArr30 = bArr27;
                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                bArr31 = bArr53;
            } else {
                bArr29 = bArr28;
                bArr30 = bArr27;
                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                bArr31 = bArr53;
            }
            byte[] bArr6111111111111111111112 = new byte[4];
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111112, 0, i11);
            tlv_tVar.set_data(bArr6111111111111111111112, 4);
            byte[] bArr6111111111111111111113 = tlv_tVar.get_buf();
            byte[] bArr6111111111111111111114 = new byte[6];
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111114, 0, oicq.wlogin_sdk.request.t.au);
            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr6111111111111111111114, 4, 0);
            tlv_tVar2.set_data(bArr6111111111111111111114, 6);
            byte[] bArr6111111111111111111115 = tlv_tVar2.get_buf();
            int i11118 = i14 + 1 + 1;
            int length2111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111111111111.length + bArr621111111111112.length + bArr621111111111113.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
            byte[] bArr6111111111111111111116 = bArr10;
            byte[] bArr6111111111111111111117 = bArr31;
            byte[] bArr7111111111111111111111111111117 = new byte[length2111111111111111111111111111111119 + bArr6111111111111111111116.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr511110.length + bArr621111111111110.length + bArr6111111111111111111113.length + bArr6111111111111111111115.length];
            java.lang.System.arraycopy(bArr35, 0, bArr7111111111111111111111111111117, 0, bArr35.length);
            int length311111111111111111111111116 = bArr35.length + 0;
            java.lang.System.arraycopy(bArr36, 0, bArr7111111111111111111111111111117, length311111111111111111111111116, bArr36.length);
            int length311111111111111111111111117 = length311111111111111111111111116 + bArr36.length;
            java.lang.System.arraycopy(bArr37, 0, bArr7111111111111111111111111111117, length311111111111111111111111117, bArr37.length);
            int length311111111111111111111111118 = length311111111111111111111111117 + bArr37.length;
            java.lang.System.arraycopy(bArr40, 0, bArr7111111111111111111111111111117, length311111111111111111111111118, bArr40.length);
            int length311111111111111111111111119 = length311111111111111111111111118 + bArr40.length;
            java.lang.System.arraycopy(bArr38, 0, bArr7111111111111111111111111111117, length311111111111111111111111119, bArr38.length);
            int length3111111111111111111111111110 = length311111111111111111111111119 + bArr38.length;
            java.lang.System.arraycopy(bArr39, 0, bArr7111111111111111111111111111117, length3111111111111111111111111110, bArr39.length);
            int length3111111111111111111111111111 = length3111111111111111111111111110 + bArr39.length;
            java.lang.System.arraycopy(bArr621111111111111, 0, bArr7111111111111111111111111111117, length3111111111111111111111111111, bArr621111111111111.length);
            int length3111111111111111111111111112 = length3111111111111111111111111111 + bArr621111111111111.length;
            java.lang.System.arraycopy(bArr621111111111112, 0, bArr7111111111111111111111111111117, length3111111111111111111111111112, bArr621111111111112.length);
            int length3111111111111111111111111113 = length3111111111111111111111111112 + bArr621111111111112.length;
            java.lang.System.arraycopy(bArr621111111111113, 0, bArr7111111111111111111111111111117, length3111111111111111111111111113, bArr621111111111113.length);
            int length11111111111111111111111111111111110 = length3111111111111111111111111113 + bArr621111111111113.length;
            java.lang.System.arraycopy(bArr26, 0, bArr7111111111111111111111111111117, length11111111111111111111111111111111110, bArr26.length);
            int length11111111111111111111111111111111111 = length11111111111111111111111111111111110 + bArr26.length;
            byte[] bArr7111111111111111111111111111118 = bArr41;
            java.lang.System.arraycopy(bArr7111111111111111111111111111118, 0, bArr7111111111111111111111111111117, length11111111111111111111111111111111111, bArr7111111111111111111111111111118.length);
            int length11111111111111111111111111111111112 = length11111111111111111111111111111111111 + bArr7111111111111111111111111111118.length;
            byte[] bArr7111111111111111111111111111119 = bArr8;
            java.lang.System.arraycopy(bArr7111111111111111111111111111119, 0, bArr7111111111111111111111111111117, length11111111111111111111111111111111112, bArr7111111111111111111111111111119.length);
            int length11111111111111111111111111111111113 = length11111111111111111111111111111111112 + bArr7111111111111111111111111111119.length;
            byte[] bArr71111111111111111111111111111110 = bArr30;
            java.lang.System.arraycopy(bArr71111111111111111111111111111110, 0, bArr7111111111111111111111111111117, length11111111111111111111111111111111113, bArr71111111111111111111111111111110.length);
            int length11111111111111111111111111111111114 = length11111111111111111111111111111111113 + bArr71111111111111111111111111111110.length;
            java.lang.System.arraycopy(bArr42, 0, bArr7111111111111111111111111111117, length11111111111111111111111111111111114, bArr42.length);
            int length11111111111111111111111111111111115 = length11111111111111111111111111111111114 + bArr42.length;
            java.lang.System.arraycopy(bArr43, 0, bArr7111111111111111111111111111117, length11111111111111111111111111111111115, bArr43.length);
            int length11111111111111111111111111111111116 = length11111111111111111111111111111111115 + bArr43.length;
            java.lang.System.arraycopy(bArr44, 0, bArr7111111111111111111111111111117, length11111111111111111111111111111111116, bArr44.length);
            int length11111111111111111111111111111111117 = length11111111111111111111111111111111116 + bArr44.length;
            byte[] bArr71111111111111111111111111111111 = bArr29;
            java.lang.System.arraycopy(bArr71111111111111111111111111111111, 0, bArr7111111111111111111111111111117, length11111111111111111111111111111111117, bArr71111111111111111111111111111111.length);
            int length11111111111111111111111111111111118 = length11111111111111111111111111111111117 + bArr71111111111111111111111111111111.length;
            java.lang.System.arraycopy(bArr45, 0, bArr7111111111111111111111111111117, length11111111111111111111111111111111118, bArr45.length);
            int length11111111111111111111111111111111119 = length11111111111111111111111111111111118 + bArr45.length;
            byte[] bArr71111111111111111111111111111112 = bArr13;
            java.lang.System.arraycopy(bArr71111111111111111111111111111112, 0, bArr7111111111111111111111111111117, length11111111111111111111111111111111119, bArr71111111111111111111111111111112.length);
            int length21111111111111111111111111111111110 = length11111111111111111111111111111111119 + bArr71111111111111111111111111111112.length;
            java.lang.System.arraycopy(bArr6111111111111111111116, 0, bArr7111111111111111111111111111117, length21111111111111111111111111111111110, bArr6111111111111111111116.length);
            int length21111111111111111111111111111111111 = length21111111111111111111111111111111110 + bArr6111111111111111111116.length;
            java.lang.System.arraycopy(bArr6111111111111111111117, 0, bArr7111111111111111111111111111117, length21111111111111111111111111111111111, bArr6111111111111111111117.length);
            int length21111111111111111111111111111111112 = length21111111111111111111111111111111111 + bArr6111111111111111111117.length;
            byte[] bArr71111111111111111111111111111113 = bArr16;
            java.lang.System.arraycopy(bArr71111111111111111111111111111113, 0, bArr7111111111111111111111111111117, length21111111111111111111111111111111112, bArr71111111111111111111111111111113.length);
            int length21111111111111111111111111111111113 = length21111111111111111111111111111111112 + bArr71111111111111111111111111111113.length;
            byte[] bArr71111111111111111111111111111114 = bArr19;
            java.lang.System.arraycopy(bArr71111111111111111111111111111114, 0, bArr7111111111111111111111111111117, length21111111111111111111111111111111113, bArr71111111111111111111111111111114.length);
            int length21111111111111111111111111111111114 = length21111111111111111111111111111111113 + bArr71111111111111111111111111111114.length;
            byte[] bArr71111111111111111111111111111115 = bArr22;
            java.lang.System.arraycopy(bArr71111111111111111111111111111115, 0, bArr7111111111111111111111111111117, length21111111111111111111111111111111114, bArr71111111111111111111111111111115.length);
            int length21111111111111111111111111111111115 = length21111111111111111111111111111111114 + bArr71111111111111111111111111111115.length;
            java.lang.System.arraycopy(bArr511110, 0, bArr7111111111111111111111111111117, length21111111111111111111111111111111115, bArr511110.length);
            int length21111111111111111111111111111111116 = length21111111111111111111111111111111115 + bArr511110.length;
            java.lang.System.arraycopy(bArr621111111111110, 0, bArr7111111111111111111111111111117, length21111111111111111111111111111111116, bArr621111111111110.length);
            int length21111111111111111111111111111111117 = length21111111111111111111111111111111116 + bArr621111111111110.length;
            java.lang.System.arraycopy(bArr6111111111111111111113, 0, bArr7111111111111111111111111111117, length21111111111111111111111111111111117, bArr6111111111111111111113.length);
            java.lang.System.arraycopy(bArr6111111111111111111115, 0, bArr7111111111111111111111111111117, length21111111111111111111111111111111117 + bArr6111111111111111111113.length, bArr6111111111111111111115.length);
            int length21111111111111111111111111111111118 = bArr6111111111111111111115.length;
            return a(a(bArr7111111111111111111111111111117, this.u, i11118), this.y, this.A, this.B);
        }
        bArr6 = bArr58;
        i12 = 12;
        bArr7 = bArr47;
        if ((i3 & 128) != 0) {
            bArr8 = tlv_t166Var.get_tlv_166(oicq.wlogin_sdk.request.t.x);
            i12++;
        } else {
            bArr8 = bArr49;
        }
        bArr9 = this.x.r;
        if (bArr9 != null) {
            bArr10 = bArr46;
            if (bArr9.length > 0) {
                bArr11 = tlv_t172Var.get_tlv_172(bArr9);
                i12++;
            }
            bArr12 = oicq.wlogin_sdk.request.t.N;
            if (bArr12 != null) {
                bArr13 = bArr11;
                if (bArr12.length > 0) {
                    bArr14 = tlv_t187Var.get_tlv_187(bArr12);
                    i12++;
                }
                bArr15 = oicq.wlogin_sdk.request.t.O;
                if (bArr15 != null) {
                    bArr16 = bArr14;
                    if (bArr15.length > 0) {
                        bArr17 = tlv_t188Var.get_tlv_188(bArr15);
                        i12++;
                    }
                    bArr18 = oicq.wlogin_sdk.request.t.L;
                    if (bArr18 != null) {
                        bArr19 = bArr17;
                        if (bArr18.length > 0) {
                            bArr20 = tlv_t194Var.get_tlv_194(bArr18);
                            i12++;
                        }
                        bArr21 = oicq.wlogin_sdk.request.l.J;
                        if (bArr21 != null) {
                            bArr22 = bArr20;
                            if (bArr21.length > 0) {
                                bArr41 = bArr41;
                                bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                                i12++;
                            }
                            bArr24 = oicq.wlogin_sdk.request.t.R;
                            if (bArr24 != null) {
                                bArr25 = bArr6;
                            } else {
                                bArr25 = bArr6;
                            }
                            byte[] bArr511111 = bArr23;
                            byte[] bArr621111111111114 = bArr25;
                            byte[] bArr621111111111115 = bArr7;
                            byte[] bArr621111111111116 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                            byte[] bArr621111111111117 = tlv_t142Var.get_tlv_142(bArr5);
                            i13 = i12 + 1 + 1;
                            str = this.x.g;
                            if (str != null) {
                                i14 = i13;
                                bArr26 = bArr48;
                            } else {
                                i14 = i13;
                                bArr26 = bArr48;
                            }
                            if (bArr3 != null) {
                                bArr27 = bArr50;
                            } else {
                                bArr27 = bArr50;
                            }
                            if (list != null) {
                                bArr28 = bArr51;
                            } else {
                                bArr28 = bArr51;
                            }
                            if (wloginSigInfoA == null) {
                                bArr29 = bArr28;
                                bArr30 = bArr27;
                                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                                bArr31 = bArr53;
                            } else {
                                bArr29 = bArr28;
                                bArr30 = bArr27;
                                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                                bArr31 = bArr53;
                            }
                            byte[] bArr6111111111111111111118 = new byte[4];
                            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111118, 0, i11);
                            tlv_tVar.set_data(bArr6111111111111111111118, 4);
                            byte[] bArr6111111111111111111119 = tlv_tVar.get_buf();
                            byte[] bArr61111111111111111111110 = new byte[6];
                            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111110, 0, oicq.wlogin_sdk.request.t.au);
                            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111111111110, 4, 0);
                            tlv_tVar2.set_data(bArr61111111111111111111110, 6);
                            byte[] bArr61111111111111111111111 = tlv_tVar2.get_buf();
                            int i11119 = i14 + 1 + 1;
                            int length21111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111111111115.length + bArr621111111111116.length + bArr621111111111117.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                            byte[] bArr61111111111111111111112 = bArr10;
                            byte[] bArr61111111111111111111113 = bArr31;
                            byte[] bArr71111111111111111111111111111116 = new byte[length21111111111111111111111111111111119 + bArr61111111111111111111112.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr511111.length + bArr621111111111114.length + bArr6111111111111111111119.length + bArr61111111111111111111111.length];
                            java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111111111111111116, 0, bArr35.length);
                            int length3111111111111111111111111114 = bArr35.length + 0;
                            java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111111111111111116, length3111111111111111111111111114, bArr36.length);
                            int length3111111111111111111111111115 = length3111111111111111111111111114 + bArr36.length;
                            java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111111111111111116, length3111111111111111111111111115, bArr37.length);
                            int length3111111111111111111111111116 = length3111111111111111111111111115 + bArr37.length;
                            java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111111111111111116, length3111111111111111111111111116, bArr40.length);
                            int length3111111111111111111111111117 = length3111111111111111111111111116 + bArr40.length;
                            java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111111111111111116, length3111111111111111111111111117, bArr38.length);
                            int length3111111111111111111111111118 = length3111111111111111111111111117 + bArr38.length;
                            java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111111111111111116, length3111111111111111111111111118, bArr39.length);
                            int length3111111111111111111111111119 = length3111111111111111111111111118 + bArr39.length;
                            java.lang.System.arraycopy(bArr621111111111115, 0, bArr71111111111111111111111111111116, length3111111111111111111111111119, bArr621111111111115.length);
                            int length31111111111111111111111111110 = length3111111111111111111111111119 + bArr621111111111115.length;
                            java.lang.System.arraycopy(bArr621111111111116, 0, bArr71111111111111111111111111111116, length31111111111111111111111111110, bArr621111111111116.length);
                            int length31111111111111111111111111111 = length31111111111111111111111111110 + bArr621111111111116.length;
                            java.lang.System.arraycopy(bArr621111111111117, 0, bArr71111111111111111111111111111116, length31111111111111111111111111111, bArr621111111111117.length);
                            int length111111111111111111111111111111111110 = length31111111111111111111111111111 + bArr621111111111117.length;
                            java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111111111111111116, length111111111111111111111111111111111110, bArr26.length);
                            int length111111111111111111111111111111111111 = length111111111111111111111111111111111110 + bArr26.length;
                            byte[] bArr71111111111111111111111111111117 = bArr41;
                            java.lang.System.arraycopy(bArr71111111111111111111111111111117, 0, bArr71111111111111111111111111111116, length111111111111111111111111111111111111, bArr71111111111111111111111111111117.length);
                            int length111111111111111111111111111111111112 = length111111111111111111111111111111111111 + bArr71111111111111111111111111111117.length;
                            byte[] bArr71111111111111111111111111111118 = bArr8;
                            java.lang.System.arraycopy(bArr71111111111111111111111111111118, 0, bArr71111111111111111111111111111116, length111111111111111111111111111111111112, bArr71111111111111111111111111111118.length);
                            int length111111111111111111111111111111111113 = length111111111111111111111111111111111112 + bArr71111111111111111111111111111118.length;
                            byte[] bArr71111111111111111111111111111119 = bArr30;
                            java.lang.System.arraycopy(bArr71111111111111111111111111111119, 0, bArr71111111111111111111111111111116, length111111111111111111111111111111111113, bArr71111111111111111111111111111119.length);
                            int length111111111111111111111111111111111114 = length111111111111111111111111111111111113 + bArr71111111111111111111111111111119.length;
                            java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111111111111111116, length111111111111111111111111111111111114, bArr42.length);
                            int length111111111111111111111111111111111115 = length111111111111111111111111111111111114 + bArr42.length;
                            java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111111111111111116, length111111111111111111111111111111111115, bArr43.length);
                            int length111111111111111111111111111111111116 = length111111111111111111111111111111111115 + bArr43.length;
                            java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111111111111111116, length111111111111111111111111111111111116, bArr44.length);
                            int length111111111111111111111111111111111117 = length111111111111111111111111111111111116 + bArr44.length;
                            byte[] bArr711111111111111111111111111111110 = bArr29;
                            java.lang.System.arraycopy(bArr711111111111111111111111111111110, 0, bArr71111111111111111111111111111116, length111111111111111111111111111111111117, bArr711111111111111111111111111111110.length);
                            int length111111111111111111111111111111111118 = length111111111111111111111111111111111117 + bArr711111111111111111111111111111110.length;
                            java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111111111111111116, length111111111111111111111111111111111118, bArr45.length);
                            int length111111111111111111111111111111111119 = length111111111111111111111111111111111118 + bArr45.length;
                            byte[] bArr711111111111111111111111111111111 = bArr13;
                            java.lang.System.arraycopy(bArr711111111111111111111111111111111, 0, bArr71111111111111111111111111111116, length111111111111111111111111111111111119, bArr711111111111111111111111111111111.length);
                            int length211111111111111111111111111111111110 = length111111111111111111111111111111111119 + bArr711111111111111111111111111111111.length;
                            java.lang.System.arraycopy(bArr61111111111111111111112, 0, bArr71111111111111111111111111111116, length211111111111111111111111111111111110, bArr61111111111111111111112.length);
                            int length211111111111111111111111111111111111 = length211111111111111111111111111111111110 + bArr61111111111111111111112.length;
                            java.lang.System.arraycopy(bArr61111111111111111111113, 0, bArr71111111111111111111111111111116, length211111111111111111111111111111111111, bArr61111111111111111111113.length);
                            int length211111111111111111111111111111111112 = length211111111111111111111111111111111111 + bArr61111111111111111111113.length;
                            byte[] bArr711111111111111111111111111111112 = bArr16;
                            java.lang.System.arraycopy(bArr711111111111111111111111111111112, 0, bArr71111111111111111111111111111116, length211111111111111111111111111111111112, bArr711111111111111111111111111111112.length);
                            int length211111111111111111111111111111111113 = length211111111111111111111111111111111112 + bArr711111111111111111111111111111112.length;
                            byte[] bArr711111111111111111111111111111113 = bArr19;
                            java.lang.System.arraycopy(bArr711111111111111111111111111111113, 0, bArr71111111111111111111111111111116, length211111111111111111111111111111111113, bArr711111111111111111111111111111113.length);
                            int length211111111111111111111111111111111114 = length211111111111111111111111111111111113 + bArr711111111111111111111111111111113.length;
                            byte[] bArr711111111111111111111111111111114 = bArr22;
                            java.lang.System.arraycopy(bArr711111111111111111111111111111114, 0, bArr71111111111111111111111111111116, length211111111111111111111111111111111114, bArr711111111111111111111111111111114.length);
                            int length211111111111111111111111111111111115 = length211111111111111111111111111111111114 + bArr711111111111111111111111111111114.length;
                            java.lang.System.arraycopy(bArr511111, 0, bArr71111111111111111111111111111116, length211111111111111111111111111111111115, bArr511111.length);
                            int length211111111111111111111111111111111116 = length211111111111111111111111111111111115 + bArr511111.length;
                            java.lang.System.arraycopy(bArr621111111111114, 0, bArr71111111111111111111111111111116, length211111111111111111111111111111111116, bArr621111111111114.length);
                            int length211111111111111111111111111111111117 = length211111111111111111111111111111111116 + bArr621111111111114.length;
                            java.lang.System.arraycopy(bArr6111111111111111111119, 0, bArr71111111111111111111111111111116, length211111111111111111111111111111111117, bArr6111111111111111111119.length);
                            java.lang.System.arraycopy(bArr61111111111111111111111, 0, bArr71111111111111111111111111111116, length211111111111111111111111111111111117 + bArr6111111111111111111119.length, bArr61111111111111111111111.length);
                            int length211111111111111111111111111111111118 = bArr61111111111111111111111.length;
                            return a(a(bArr71111111111111111111111111111116, this.u, i11119), this.y, this.A, this.B);
                        }
                        bArr22 = bArr20;
                        bArr23 = bArr57;
                        bArr24 = oicq.wlogin_sdk.request.t.R;
                        if (bArr24 != null) {
                            bArr25 = bArr6;
                        } else {
                            bArr25 = bArr6;
                        }
                        byte[] bArr511112 = bArr23;
                        byte[] bArr621111111111118 = bArr25;
                        byte[] bArr621111111111119 = bArr7;
                        byte[] bArr6211111111111110 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                        byte[] bArr6211111111111111 = tlv_t142Var.get_tlv_142(bArr5);
                        i13 = i12 + 1 + 1;
                        str = this.x.g;
                        if (str != null) {
                            i14 = i13;
                            bArr26 = bArr48;
                        } else {
                            i14 = i13;
                            bArr26 = bArr48;
                        }
                        if (bArr3 != null) {
                            bArr27 = bArr50;
                        } else {
                            bArr27 = bArr50;
                        }
                        if (list != null) {
                            bArr28 = bArr51;
                        } else {
                            bArr28 = bArr51;
                        }
                        if (wloginSigInfoA == null) {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        } else {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        }
                        byte[] bArr61111111111111111111114 = new byte[4];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111114, 0, i11);
                        tlv_tVar.set_data(bArr61111111111111111111114, 4);
                        byte[] bArr61111111111111111111115 = tlv_tVar.get_buf();
                        byte[] bArr61111111111111111111116 = new byte[6];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111116, 0, oicq.wlogin_sdk.request.t.au);
                        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111111111116, 4, 0);
                        tlv_tVar2.set_data(bArr61111111111111111111116, 6);
                        byte[] bArr61111111111111111111117 = tlv_tVar2.get_buf();
                        int i111110 = i14 + 1 + 1;
                        int length211111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111111111119.length + bArr6211111111111110.length + bArr6211111111111111.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                        byte[] bArr61111111111111111111118 = bArr10;
                        byte[] bArr61111111111111111111119 = bArr31;
                        byte[] bArr711111111111111111111111111111115 = new byte[length211111111111111111111111111111111119 + bArr61111111111111111111118.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr511112.length + bArr621111111111118.length + bArr61111111111111111111115.length + bArr61111111111111111111117.length];
                        java.lang.System.arraycopy(bArr35, 0, bArr711111111111111111111111111111115, 0, bArr35.length);
                        int length31111111111111111111111111112 = bArr35.length + 0;
                        java.lang.System.arraycopy(bArr36, 0, bArr711111111111111111111111111111115, length31111111111111111111111111112, bArr36.length);
                        int length31111111111111111111111111113 = length31111111111111111111111111112 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr711111111111111111111111111111115, length31111111111111111111111111113, bArr37.length);
                        int length31111111111111111111111111114 = length31111111111111111111111111113 + bArr37.length;
                        java.lang.System.arraycopy(bArr40, 0, bArr711111111111111111111111111111115, length31111111111111111111111111114, bArr40.length);
                        int length31111111111111111111111111115 = length31111111111111111111111111114 + bArr40.length;
                        java.lang.System.arraycopy(bArr38, 0, bArr711111111111111111111111111111115, length31111111111111111111111111115, bArr38.length);
                        int length31111111111111111111111111116 = length31111111111111111111111111115 + bArr38.length;
                        java.lang.System.arraycopy(bArr39, 0, bArr711111111111111111111111111111115, length31111111111111111111111111116, bArr39.length);
                        int length31111111111111111111111111117 = length31111111111111111111111111116 + bArr39.length;
                        java.lang.System.arraycopy(bArr621111111111119, 0, bArr711111111111111111111111111111115, length31111111111111111111111111117, bArr621111111111119.length);
                        int length31111111111111111111111111118 = length31111111111111111111111111117 + bArr621111111111119.length;
                        java.lang.System.arraycopy(bArr6211111111111110, 0, bArr711111111111111111111111111111115, length31111111111111111111111111118, bArr6211111111111110.length);
                        int length31111111111111111111111111119 = length31111111111111111111111111118 + bArr6211111111111110.length;
                        java.lang.System.arraycopy(bArr6211111111111111, 0, bArr711111111111111111111111111111115, length31111111111111111111111111119, bArr6211111111111111.length);
                        int length1111111111111111111111111111111111110 = length31111111111111111111111111119 + bArr6211111111111111.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr711111111111111111111111111111115, length1111111111111111111111111111111111110, bArr26.length);
                        int length1111111111111111111111111111111111111 = length1111111111111111111111111111111111110 + bArr26.length;
                        byte[] bArr711111111111111111111111111111116 = bArr41;
                        java.lang.System.arraycopy(bArr711111111111111111111111111111116, 0, bArr711111111111111111111111111111115, length1111111111111111111111111111111111111, bArr711111111111111111111111111111116.length);
                        int length1111111111111111111111111111111111112 = length1111111111111111111111111111111111111 + bArr711111111111111111111111111111116.length;
                        byte[] bArr711111111111111111111111111111117 = bArr8;
                        java.lang.System.arraycopy(bArr711111111111111111111111111111117, 0, bArr711111111111111111111111111111115, length1111111111111111111111111111111111112, bArr711111111111111111111111111111117.length);
                        int length1111111111111111111111111111111111113 = length1111111111111111111111111111111111112 + bArr711111111111111111111111111111117.length;
                        byte[] bArr711111111111111111111111111111118 = bArr30;
                        java.lang.System.arraycopy(bArr711111111111111111111111111111118, 0, bArr711111111111111111111111111111115, length1111111111111111111111111111111111113, bArr711111111111111111111111111111118.length);
                        int length1111111111111111111111111111111111114 = length1111111111111111111111111111111111113 + bArr711111111111111111111111111111118.length;
                        java.lang.System.arraycopy(bArr42, 0, bArr711111111111111111111111111111115, length1111111111111111111111111111111111114, bArr42.length);
                        int length1111111111111111111111111111111111115 = length1111111111111111111111111111111111114 + bArr42.length;
                        java.lang.System.arraycopy(bArr43, 0, bArr711111111111111111111111111111115, length1111111111111111111111111111111111115, bArr43.length);
                        int length1111111111111111111111111111111111116 = length1111111111111111111111111111111111115 + bArr43.length;
                        java.lang.System.arraycopy(bArr44, 0, bArr711111111111111111111111111111115, length1111111111111111111111111111111111116, bArr44.length);
                        int length1111111111111111111111111111111111117 = length1111111111111111111111111111111111116 + bArr44.length;
                        byte[] bArr711111111111111111111111111111119 = bArr29;
                        java.lang.System.arraycopy(bArr711111111111111111111111111111119, 0, bArr711111111111111111111111111111115, length1111111111111111111111111111111111117, bArr711111111111111111111111111111119.length);
                        int length1111111111111111111111111111111111118 = length1111111111111111111111111111111111117 + bArr711111111111111111111111111111119.length;
                        java.lang.System.arraycopy(bArr45, 0, bArr711111111111111111111111111111115, length1111111111111111111111111111111111118, bArr45.length);
                        int length1111111111111111111111111111111111119 = length1111111111111111111111111111111111118 + bArr45.length;
                        byte[] bArr7111111111111111111111111111111110 = bArr13;
                        java.lang.System.arraycopy(bArr7111111111111111111111111111111110, 0, bArr711111111111111111111111111111115, length1111111111111111111111111111111111119, bArr7111111111111111111111111111111110.length);
                        int length2111111111111111111111111111111111110 = length1111111111111111111111111111111111119 + bArr7111111111111111111111111111111110.length;
                        java.lang.System.arraycopy(bArr61111111111111111111118, 0, bArr711111111111111111111111111111115, length2111111111111111111111111111111111110, bArr61111111111111111111118.length);
                        int length2111111111111111111111111111111111111 = length2111111111111111111111111111111111110 + bArr61111111111111111111118.length;
                        java.lang.System.arraycopy(bArr61111111111111111111119, 0, bArr711111111111111111111111111111115, length2111111111111111111111111111111111111, bArr61111111111111111111119.length);
                        int length2111111111111111111111111111111111112 = length2111111111111111111111111111111111111 + bArr61111111111111111111119.length;
                        byte[] bArr7111111111111111111111111111111111 = bArr16;
                        java.lang.System.arraycopy(bArr7111111111111111111111111111111111, 0, bArr711111111111111111111111111111115, length2111111111111111111111111111111111112, bArr7111111111111111111111111111111111.length);
                        int length2111111111111111111111111111111111113 = length2111111111111111111111111111111111112 + bArr7111111111111111111111111111111111.length;
                        byte[] bArr7111111111111111111111111111111112 = bArr19;
                        java.lang.System.arraycopy(bArr7111111111111111111111111111111112, 0, bArr711111111111111111111111111111115, length2111111111111111111111111111111111113, bArr7111111111111111111111111111111112.length);
                        int length2111111111111111111111111111111111114 = length2111111111111111111111111111111111113 + bArr7111111111111111111111111111111112.length;
                        byte[] bArr7111111111111111111111111111111113 = bArr22;
                        java.lang.System.arraycopy(bArr7111111111111111111111111111111113, 0, bArr711111111111111111111111111111115, length2111111111111111111111111111111111114, bArr7111111111111111111111111111111113.length);
                        int length2111111111111111111111111111111111115 = length2111111111111111111111111111111111114 + bArr7111111111111111111111111111111113.length;
                        java.lang.System.arraycopy(bArr511112, 0, bArr711111111111111111111111111111115, length2111111111111111111111111111111111115, bArr511112.length);
                        int length2111111111111111111111111111111111116 = length2111111111111111111111111111111111115 + bArr511112.length;
                        java.lang.System.arraycopy(bArr621111111111118, 0, bArr711111111111111111111111111111115, length2111111111111111111111111111111111116, bArr621111111111118.length);
                        int length2111111111111111111111111111111111117 = length2111111111111111111111111111111111116 + bArr621111111111118.length;
                        java.lang.System.arraycopy(bArr61111111111111111111115, 0, bArr711111111111111111111111111111115, length2111111111111111111111111111111111117, bArr61111111111111111111115.length);
                        java.lang.System.arraycopy(bArr61111111111111111111117, 0, bArr711111111111111111111111111111115, length2111111111111111111111111111111111117 + bArr61111111111111111111115.length, bArr61111111111111111111117.length);
                        int length2111111111111111111111111111111111118 = bArr61111111111111111111117.length;
                        return a(a(bArr711111111111111111111111111111115, this.u, i111110), this.y, this.A, this.B);
                    }
                    bArr19 = bArr17;
                    bArr20 = bArr56;
                    bArr21 = oicq.wlogin_sdk.request.l.J;
                    if (bArr21 != null) {
                        bArr22 = bArr20;
                        if (bArr21.length > 0) {
                            bArr41 = bArr41;
                            bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                            i12++;
                        }
                        bArr24 = oicq.wlogin_sdk.request.t.R;
                        if (bArr24 != null) {
                            bArr25 = bArr6;
                        } else {
                            bArr25 = bArr6;
                        }
                        byte[] bArr511113 = bArr23;
                        byte[] bArr6211111111111112 = bArr25;
                        byte[] bArr6211111111111113 = bArr7;
                        byte[] bArr6211111111111114 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                        byte[] bArr6211111111111115 = tlv_t142Var.get_tlv_142(bArr5);
                        i13 = i12 + 1 + 1;
                        str = this.x.g;
                        if (str != null) {
                            i14 = i13;
                            bArr26 = bArr48;
                        } else {
                            i14 = i13;
                            bArr26 = bArr48;
                        }
                        if (bArr3 != null) {
                            bArr27 = bArr50;
                        } else {
                            bArr27 = bArr50;
                        }
                        if (list != null) {
                            bArr28 = bArr51;
                        } else {
                            bArr28 = bArr51;
                        }
                        if (wloginSigInfoA == null) {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        } else {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        }
                        byte[] bArr611111111111111111111110 = new byte[4];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111110, 0, i11);
                        tlv_tVar.set_data(bArr611111111111111111111110, 4);
                        byte[] bArr611111111111111111111111 = tlv_tVar.get_buf();
                        byte[] bArr611111111111111111111112 = new byte[6];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111112, 0, oicq.wlogin_sdk.request.t.au);
                        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111111111111112, 4, 0);
                        tlv_tVar2.set_data(bArr611111111111111111111112, 6);
                        byte[] bArr611111111111111111111113 = tlv_tVar2.get_buf();
                        int i111111 = i14 + 1 + 1;
                        int length2111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211111111111113.length + bArr6211111111111114.length + bArr6211111111111115.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                        byte[] bArr611111111111111111111114 = bArr10;
                        byte[] bArr611111111111111111111115 = bArr31;
                        byte[] bArr7111111111111111111111111111111114 = new byte[length2111111111111111111111111111111111119 + bArr611111111111111111111114.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr511113.length + bArr6211111111111112.length + bArr611111111111111111111111.length + bArr611111111111111111111113.length];
                        java.lang.System.arraycopy(bArr35, 0, bArr7111111111111111111111111111111114, 0, bArr35.length);
                        int length311111111111111111111111111110 = bArr35.length + 0;
                        java.lang.System.arraycopy(bArr36, 0, bArr7111111111111111111111111111111114, length311111111111111111111111111110, bArr36.length);
                        int length311111111111111111111111111111 = length311111111111111111111111111110 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr7111111111111111111111111111111114, length311111111111111111111111111111, bArr37.length);
                        int length311111111111111111111111111112 = length311111111111111111111111111111 + bArr37.length;
                        java.lang.System.arraycopy(bArr40, 0, bArr7111111111111111111111111111111114, length311111111111111111111111111112, bArr40.length);
                        int length311111111111111111111111111113 = length311111111111111111111111111112 + bArr40.length;
                        java.lang.System.arraycopy(bArr38, 0, bArr7111111111111111111111111111111114, length311111111111111111111111111113, bArr38.length);
                        int length311111111111111111111111111114 = length311111111111111111111111111113 + bArr38.length;
                        java.lang.System.arraycopy(bArr39, 0, bArr7111111111111111111111111111111114, length311111111111111111111111111114, bArr39.length);
                        int length311111111111111111111111111115 = length311111111111111111111111111114 + bArr39.length;
                        java.lang.System.arraycopy(bArr6211111111111113, 0, bArr7111111111111111111111111111111114, length311111111111111111111111111115, bArr6211111111111113.length);
                        int length311111111111111111111111111116 = length311111111111111111111111111115 + bArr6211111111111113.length;
                        java.lang.System.arraycopy(bArr6211111111111114, 0, bArr7111111111111111111111111111111114, length311111111111111111111111111116, bArr6211111111111114.length);
                        int length311111111111111111111111111117 = length311111111111111111111111111116 + bArr6211111111111114.length;
                        java.lang.System.arraycopy(bArr6211111111111115, 0, bArr7111111111111111111111111111111114, length311111111111111111111111111117, bArr6211111111111115.length);
                        int length11111111111111111111111111111111111110 = length311111111111111111111111111117 + bArr6211111111111115.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr7111111111111111111111111111111114, length11111111111111111111111111111111111110, bArr26.length);
                        int length11111111111111111111111111111111111111 = length11111111111111111111111111111111111110 + bArr26.length;
                        byte[] bArr7111111111111111111111111111111115 = bArr41;
                        java.lang.System.arraycopy(bArr7111111111111111111111111111111115, 0, bArr7111111111111111111111111111111114, length11111111111111111111111111111111111111, bArr7111111111111111111111111111111115.length);
                        int length11111111111111111111111111111111111112 = length11111111111111111111111111111111111111 + bArr7111111111111111111111111111111115.length;
                        byte[] bArr7111111111111111111111111111111116 = bArr8;
                        java.lang.System.arraycopy(bArr7111111111111111111111111111111116, 0, bArr7111111111111111111111111111111114, length11111111111111111111111111111111111112, bArr7111111111111111111111111111111116.length);
                        int length11111111111111111111111111111111111113 = length11111111111111111111111111111111111112 + bArr7111111111111111111111111111111116.length;
                        byte[] bArr7111111111111111111111111111111117 = bArr30;
                        java.lang.System.arraycopy(bArr7111111111111111111111111111111117, 0, bArr7111111111111111111111111111111114, length11111111111111111111111111111111111113, bArr7111111111111111111111111111111117.length);
                        int length11111111111111111111111111111111111114 = length11111111111111111111111111111111111113 + bArr7111111111111111111111111111111117.length;
                        java.lang.System.arraycopy(bArr42, 0, bArr7111111111111111111111111111111114, length11111111111111111111111111111111111114, bArr42.length);
                        int length11111111111111111111111111111111111115 = length11111111111111111111111111111111111114 + bArr42.length;
                        java.lang.System.arraycopy(bArr43, 0, bArr7111111111111111111111111111111114, length11111111111111111111111111111111111115, bArr43.length);
                        int length11111111111111111111111111111111111116 = length11111111111111111111111111111111111115 + bArr43.length;
                        java.lang.System.arraycopy(bArr44, 0, bArr7111111111111111111111111111111114, length11111111111111111111111111111111111116, bArr44.length);
                        int length11111111111111111111111111111111111117 = length11111111111111111111111111111111111116 + bArr44.length;
                        byte[] bArr7111111111111111111111111111111118 = bArr29;
                        java.lang.System.arraycopy(bArr7111111111111111111111111111111118, 0, bArr7111111111111111111111111111111114, length11111111111111111111111111111111111117, bArr7111111111111111111111111111111118.length);
                        int length11111111111111111111111111111111111118 = length11111111111111111111111111111111111117 + bArr7111111111111111111111111111111118.length;
                        java.lang.System.arraycopy(bArr45, 0, bArr7111111111111111111111111111111114, length11111111111111111111111111111111111118, bArr45.length);
                        int length11111111111111111111111111111111111119 = length11111111111111111111111111111111111118 + bArr45.length;
                        byte[] bArr7111111111111111111111111111111119 = bArr13;
                        java.lang.System.arraycopy(bArr7111111111111111111111111111111119, 0, bArr7111111111111111111111111111111114, length11111111111111111111111111111111111119, bArr7111111111111111111111111111111119.length);
                        int length21111111111111111111111111111111111110 = length11111111111111111111111111111111111119 + bArr7111111111111111111111111111111119.length;
                        java.lang.System.arraycopy(bArr611111111111111111111114, 0, bArr7111111111111111111111111111111114, length21111111111111111111111111111111111110, bArr611111111111111111111114.length);
                        int length21111111111111111111111111111111111111 = length21111111111111111111111111111111111110 + bArr611111111111111111111114.length;
                        java.lang.System.arraycopy(bArr611111111111111111111115, 0, bArr7111111111111111111111111111111114, length21111111111111111111111111111111111111, bArr611111111111111111111115.length);
                        int length21111111111111111111111111111111111112 = length21111111111111111111111111111111111111 + bArr611111111111111111111115.length;
                        byte[] bArr71111111111111111111111111111111110 = bArr16;
                        java.lang.System.arraycopy(bArr71111111111111111111111111111111110, 0, bArr7111111111111111111111111111111114, length21111111111111111111111111111111111112, bArr71111111111111111111111111111111110.length);
                        int length21111111111111111111111111111111111113 = length21111111111111111111111111111111111112 + bArr71111111111111111111111111111111110.length;
                        byte[] bArr71111111111111111111111111111111111 = bArr19;
                        java.lang.System.arraycopy(bArr71111111111111111111111111111111111, 0, bArr7111111111111111111111111111111114, length21111111111111111111111111111111111113, bArr71111111111111111111111111111111111.length);
                        int length21111111111111111111111111111111111114 = length21111111111111111111111111111111111113 + bArr71111111111111111111111111111111111.length;
                        byte[] bArr71111111111111111111111111111111112 = bArr22;
                        java.lang.System.arraycopy(bArr71111111111111111111111111111111112, 0, bArr7111111111111111111111111111111114, length21111111111111111111111111111111111114, bArr71111111111111111111111111111111112.length);
                        int length21111111111111111111111111111111111115 = length21111111111111111111111111111111111114 + bArr71111111111111111111111111111111112.length;
                        java.lang.System.arraycopy(bArr511113, 0, bArr7111111111111111111111111111111114, length21111111111111111111111111111111111115, bArr511113.length);
                        int length21111111111111111111111111111111111116 = length21111111111111111111111111111111111115 + bArr511113.length;
                        java.lang.System.arraycopy(bArr6211111111111112, 0, bArr7111111111111111111111111111111114, length21111111111111111111111111111111111116, bArr6211111111111112.length);
                        int length21111111111111111111111111111111111117 = length21111111111111111111111111111111111116 + bArr6211111111111112.length;
                        java.lang.System.arraycopy(bArr611111111111111111111111, 0, bArr7111111111111111111111111111111114, length21111111111111111111111111111111111117, bArr611111111111111111111111.length);
                        java.lang.System.arraycopy(bArr611111111111111111111113, 0, bArr7111111111111111111111111111111114, length21111111111111111111111111111111111117 + bArr611111111111111111111111.length, bArr611111111111111111111113.length);
                        int length21111111111111111111111111111111111118 = bArr611111111111111111111113.length;
                        return a(a(bArr7111111111111111111111111111111114, this.u, i111111), this.y, this.A, this.B);
                    }
                    bArr22 = bArr20;
                    bArr23 = bArr57;
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr511114 = bArr23;
                    byte[] bArr6211111111111116 = bArr25;
                    byte[] bArr6211111111111117 = bArr7;
                    byte[] bArr6211111111111118 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr6211111111111119 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr611111111111111111111116 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111116, 0, i11);
                    tlv_tVar.set_data(bArr611111111111111111111116, 4);
                    byte[] bArr611111111111111111111117 = tlv_tVar.get_buf();
                    byte[] bArr611111111111111111111118 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111118, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111111111111118, 4, 0);
                    tlv_tVar2.set_data(bArr611111111111111111111118, 6);
                    byte[] bArr611111111111111111111119 = tlv_tVar2.get_buf();
                    int i111112 = i14 + 1 + 1;
                    int length21111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211111111111117.length + bArr6211111111111118.length + bArr6211111111111119.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr6111111111111111111111110 = bArr10;
                    byte[] bArr6111111111111111111111111 = bArr31;
                    byte[] bArr71111111111111111111111111111111113 = new byte[length21111111111111111111111111111111111119 + bArr6111111111111111111111110.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr511114.length + bArr6211111111111116.length + bArr611111111111111111111117.length + bArr611111111111111111111119.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111111111111111111113, 0, bArr35.length);
                    int length311111111111111111111111111118 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111111111111111111113, length311111111111111111111111111118, bArr36.length);
                    int length311111111111111111111111111119 = length311111111111111111111111111118 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111111111111111111113, length311111111111111111111111111119, bArr37.length);
                    int length3111111111111111111111111111110 = length311111111111111111111111111119 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111111111111111111113, length3111111111111111111111111111110, bArr40.length);
                    int length3111111111111111111111111111111 = length3111111111111111111111111111110 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111111111111111111113, length3111111111111111111111111111111, bArr38.length);
                    int length3111111111111111111111111111112 = length3111111111111111111111111111111 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111111111111111111113, length3111111111111111111111111111112, bArr39.length);
                    int length3111111111111111111111111111113 = length3111111111111111111111111111112 + bArr39.length;
                    java.lang.System.arraycopy(bArr6211111111111117, 0, bArr71111111111111111111111111111111113, length3111111111111111111111111111113, bArr6211111111111117.length);
                    int length3111111111111111111111111111114 = length3111111111111111111111111111113 + bArr6211111111111117.length;
                    java.lang.System.arraycopy(bArr6211111111111118, 0, bArr71111111111111111111111111111111113, length3111111111111111111111111111114, bArr6211111111111118.length);
                    int length3111111111111111111111111111115 = length3111111111111111111111111111114 + bArr6211111111111118.length;
                    java.lang.System.arraycopy(bArr6211111111111119, 0, bArr71111111111111111111111111111111113, length3111111111111111111111111111115, bArr6211111111111119.length);
                    int length111111111111111111111111111111111111110 = length3111111111111111111111111111115 + bArr6211111111111119.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111111111111111111113, length111111111111111111111111111111111111110, bArr26.length);
                    int length111111111111111111111111111111111111111 = length111111111111111111111111111111111111110 + bArr26.length;
                    byte[] bArr71111111111111111111111111111111114 = bArr41;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111114, 0, bArr71111111111111111111111111111111113, length111111111111111111111111111111111111111, bArr71111111111111111111111111111111114.length);
                    int length111111111111111111111111111111111111112 = length111111111111111111111111111111111111111 + bArr71111111111111111111111111111111114.length;
                    byte[] bArr71111111111111111111111111111111115 = bArr8;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111115, 0, bArr71111111111111111111111111111111113, length111111111111111111111111111111111111112, bArr71111111111111111111111111111111115.length);
                    int length111111111111111111111111111111111111113 = length111111111111111111111111111111111111112 + bArr71111111111111111111111111111111115.length;
                    byte[] bArr71111111111111111111111111111111116 = bArr30;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111116, 0, bArr71111111111111111111111111111111113, length111111111111111111111111111111111111113, bArr71111111111111111111111111111111116.length);
                    int length111111111111111111111111111111111111114 = length111111111111111111111111111111111111113 + bArr71111111111111111111111111111111116.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111111111111111111113, length111111111111111111111111111111111111114, bArr42.length);
                    int length111111111111111111111111111111111111115 = length111111111111111111111111111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111111111111111111113, length111111111111111111111111111111111111115, bArr43.length);
                    int length111111111111111111111111111111111111116 = length111111111111111111111111111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111111111111111111113, length111111111111111111111111111111111111116, bArr44.length);
                    int length111111111111111111111111111111111111117 = length111111111111111111111111111111111111116 + bArr44.length;
                    byte[] bArr71111111111111111111111111111111117 = bArr29;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111117, 0, bArr71111111111111111111111111111111113, length111111111111111111111111111111111111117, bArr71111111111111111111111111111111117.length);
                    int length111111111111111111111111111111111111118 = length111111111111111111111111111111111111117 + bArr71111111111111111111111111111111117.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111111111111111111113, length111111111111111111111111111111111111118, bArr45.length);
                    int length111111111111111111111111111111111111119 = length111111111111111111111111111111111111118 + bArr45.length;
                    byte[] bArr71111111111111111111111111111111118 = bArr13;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111118, 0, bArr71111111111111111111111111111111113, length111111111111111111111111111111111111119, bArr71111111111111111111111111111111118.length);
                    int length211111111111111111111111111111111111110 = length111111111111111111111111111111111111119 + bArr71111111111111111111111111111111118.length;
                    java.lang.System.arraycopy(bArr6111111111111111111111110, 0, bArr71111111111111111111111111111111113, length211111111111111111111111111111111111110, bArr6111111111111111111111110.length);
                    int length211111111111111111111111111111111111111 = length211111111111111111111111111111111111110 + bArr6111111111111111111111110.length;
                    java.lang.System.arraycopy(bArr6111111111111111111111111, 0, bArr71111111111111111111111111111111113, length211111111111111111111111111111111111111, bArr6111111111111111111111111.length);
                    int length211111111111111111111111111111111111112 = length211111111111111111111111111111111111111 + bArr6111111111111111111111111.length;
                    byte[] bArr71111111111111111111111111111111119 = bArr16;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111119, 0, bArr71111111111111111111111111111111113, length211111111111111111111111111111111111112, bArr71111111111111111111111111111111119.length);
                    int length211111111111111111111111111111111111113 = length211111111111111111111111111111111111112 + bArr71111111111111111111111111111111119.length;
                    byte[] bArr711111111111111111111111111111111110 = bArr19;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111110, 0, bArr71111111111111111111111111111111113, length211111111111111111111111111111111111113, bArr711111111111111111111111111111111110.length);
                    int length211111111111111111111111111111111111114 = length211111111111111111111111111111111111113 + bArr711111111111111111111111111111111110.length;
                    byte[] bArr711111111111111111111111111111111111 = bArr22;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111, 0, bArr71111111111111111111111111111111113, length211111111111111111111111111111111111114, bArr711111111111111111111111111111111111.length);
                    int length211111111111111111111111111111111111115 = length211111111111111111111111111111111111114 + bArr711111111111111111111111111111111111.length;
                    java.lang.System.arraycopy(bArr511114, 0, bArr71111111111111111111111111111111113, length211111111111111111111111111111111111115, bArr511114.length);
                    int length211111111111111111111111111111111111116 = length211111111111111111111111111111111111115 + bArr511114.length;
                    java.lang.System.arraycopy(bArr6211111111111116, 0, bArr71111111111111111111111111111111113, length211111111111111111111111111111111111116, bArr6211111111111116.length);
                    int length211111111111111111111111111111111111117 = length211111111111111111111111111111111111116 + bArr6211111111111116.length;
                    java.lang.System.arraycopy(bArr611111111111111111111117, 0, bArr71111111111111111111111111111111113, length211111111111111111111111111111111111117, bArr611111111111111111111117.length);
                    java.lang.System.arraycopy(bArr611111111111111111111119, 0, bArr71111111111111111111111111111111113, length211111111111111111111111111111111111117 + bArr611111111111111111111117.length, bArr611111111111111111111119.length);
                    int length211111111111111111111111111111111111118 = bArr611111111111111111111119.length;
                    return a(a(bArr71111111111111111111111111111111113, this.u, i111112), this.y, this.A, this.B);
                }
                bArr16 = bArr14;
                bArr17 = bArr55;
                bArr18 = oicq.wlogin_sdk.request.t.L;
                if (bArr18 != null) {
                    bArr19 = bArr17;
                    if (bArr18.length > 0) {
                        bArr20 = tlv_t194Var.get_tlv_194(bArr18);
                        i12++;
                    }
                    bArr21 = oicq.wlogin_sdk.request.l.J;
                    if (bArr21 != null) {
                        bArr22 = bArr20;
                        if (bArr21.length > 0) {
                            bArr41 = bArr41;
                            bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                            i12++;
                        }
                        bArr24 = oicq.wlogin_sdk.request.t.R;
                        if (bArr24 != null) {
                            bArr25 = bArr6;
                        } else {
                            bArr25 = bArr6;
                        }
                        byte[] bArr511115 = bArr23;
                        byte[] bArr62111111111111110 = bArr25;
                        byte[] bArr62111111111111111 = bArr7;
                        byte[] bArr62111111111111112 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                        byte[] bArr62111111111111113 = tlv_t142Var.get_tlv_142(bArr5);
                        i13 = i12 + 1 + 1;
                        str = this.x.g;
                        if (str != null) {
                            i14 = i13;
                            bArr26 = bArr48;
                        } else {
                            i14 = i13;
                            bArr26 = bArr48;
                        }
                        if (bArr3 != null) {
                            bArr27 = bArr50;
                        } else {
                            bArr27 = bArr50;
                        }
                        if (list != null) {
                            bArr28 = bArr51;
                        } else {
                            bArr28 = bArr51;
                        }
                        if (wloginSigInfoA == null) {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        } else {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        }
                        byte[] bArr6111111111111111111111112 = new byte[4];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111112, 0, i11);
                        tlv_tVar.set_data(bArr6111111111111111111111112, 4);
                        byte[] bArr6111111111111111111111113 = tlv_tVar.get_buf();
                        byte[] bArr6111111111111111111111114 = new byte[6];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111114, 0, oicq.wlogin_sdk.request.t.au);
                        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr6111111111111111111111114, 4, 0);
                        tlv_tVar2.set_data(bArr6111111111111111111111114, 6);
                        byte[] bArr6111111111111111111111115 = tlv_tVar2.get_buf();
                        int i111113 = i14 + 1 + 1;
                        int length211111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111111111111111.length + bArr62111111111111112.length + bArr62111111111111113.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                        byte[] bArr6111111111111111111111116 = bArr10;
                        byte[] bArr6111111111111111111111117 = bArr31;
                        byte[] bArr711111111111111111111111111111111112 = new byte[length211111111111111111111111111111111111119 + bArr6111111111111111111111116.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr511115.length + bArr62111111111111110.length + bArr6111111111111111111111113.length + bArr6111111111111111111111115.length];
                        java.lang.System.arraycopy(bArr35, 0, bArr711111111111111111111111111111111112, 0, bArr35.length);
                        int length3111111111111111111111111111116 = bArr35.length + 0;
                        java.lang.System.arraycopy(bArr36, 0, bArr711111111111111111111111111111111112, length3111111111111111111111111111116, bArr36.length);
                        int length3111111111111111111111111111117 = length3111111111111111111111111111116 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr711111111111111111111111111111111112, length3111111111111111111111111111117, bArr37.length);
                        int length3111111111111111111111111111118 = length3111111111111111111111111111117 + bArr37.length;
                        java.lang.System.arraycopy(bArr40, 0, bArr711111111111111111111111111111111112, length3111111111111111111111111111118, bArr40.length);
                        int length3111111111111111111111111111119 = length3111111111111111111111111111118 + bArr40.length;
                        java.lang.System.arraycopy(bArr38, 0, bArr711111111111111111111111111111111112, length3111111111111111111111111111119, bArr38.length);
                        int length31111111111111111111111111111110 = length3111111111111111111111111111119 + bArr38.length;
                        java.lang.System.arraycopy(bArr39, 0, bArr711111111111111111111111111111111112, length31111111111111111111111111111110, bArr39.length);
                        int length31111111111111111111111111111111 = length31111111111111111111111111111110 + bArr39.length;
                        java.lang.System.arraycopy(bArr62111111111111111, 0, bArr711111111111111111111111111111111112, length31111111111111111111111111111111, bArr62111111111111111.length);
                        int length31111111111111111111111111111112 = length31111111111111111111111111111111 + bArr62111111111111111.length;
                        java.lang.System.arraycopy(bArr62111111111111112, 0, bArr711111111111111111111111111111111112, length31111111111111111111111111111112, bArr62111111111111112.length);
                        int length31111111111111111111111111111113 = length31111111111111111111111111111112 + bArr62111111111111112.length;
                        java.lang.System.arraycopy(bArr62111111111111113, 0, bArr711111111111111111111111111111111112, length31111111111111111111111111111113, bArr62111111111111113.length);
                        int length1111111111111111111111111111111111111110 = length31111111111111111111111111111113 + bArr62111111111111113.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr711111111111111111111111111111111112, length1111111111111111111111111111111111111110, bArr26.length);
                        int length1111111111111111111111111111111111111111 = length1111111111111111111111111111111111111110 + bArr26.length;
                        byte[] bArr711111111111111111111111111111111113 = bArr41;
                        java.lang.System.arraycopy(bArr711111111111111111111111111111111113, 0, bArr711111111111111111111111111111111112, length1111111111111111111111111111111111111111, bArr711111111111111111111111111111111113.length);
                        int length1111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111 + bArr711111111111111111111111111111111113.length;
                        byte[] bArr711111111111111111111111111111111114 = bArr8;
                        java.lang.System.arraycopy(bArr711111111111111111111111111111111114, 0, bArr711111111111111111111111111111111112, length1111111111111111111111111111111111111112, bArr711111111111111111111111111111111114.length);
                        int length1111111111111111111111111111111111111113 = length1111111111111111111111111111111111111112 + bArr711111111111111111111111111111111114.length;
                        byte[] bArr711111111111111111111111111111111115 = bArr30;
                        java.lang.System.arraycopy(bArr711111111111111111111111111111111115, 0, bArr711111111111111111111111111111111112, length1111111111111111111111111111111111111113, bArr711111111111111111111111111111111115.length);
                        int length1111111111111111111111111111111111111114 = length1111111111111111111111111111111111111113 + bArr711111111111111111111111111111111115.length;
                        java.lang.System.arraycopy(bArr42, 0, bArr711111111111111111111111111111111112, length1111111111111111111111111111111111111114, bArr42.length);
                        int length1111111111111111111111111111111111111115 = length1111111111111111111111111111111111111114 + bArr42.length;
                        java.lang.System.arraycopy(bArr43, 0, bArr711111111111111111111111111111111112, length1111111111111111111111111111111111111115, bArr43.length);
                        int length1111111111111111111111111111111111111116 = length1111111111111111111111111111111111111115 + bArr43.length;
                        java.lang.System.arraycopy(bArr44, 0, bArr711111111111111111111111111111111112, length1111111111111111111111111111111111111116, bArr44.length);
                        int length1111111111111111111111111111111111111117 = length1111111111111111111111111111111111111116 + bArr44.length;
                        byte[] bArr711111111111111111111111111111111116 = bArr29;
                        java.lang.System.arraycopy(bArr711111111111111111111111111111111116, 0, bArr711111111111111111111111111111111112, length1111111111111111111111111111111111111117, bArr711111111111111111111111111111111116.length);
                        int length1111111111111111111111111111111111111118 = length1111111111111111111111111111111111111117 + bArr711111111111111111111111111111111116.length;
                        java.lang.System.arraycopy(bArr45, 0, bArr711111111111111111111111111111111112, length1111111111111111111111111111111111111118, bArr45.length);
                        int length1111111111111111111111111111111111111119 = length1111111111111111111111111111111111111118 + bArr45.length;
                        byte[] bArr711111111111111111111111111111111117 = bArr13;
                        java.lang.System.arraycopy(bArr711111111111111111111111111111111117, 0, bArr711111111111111111111111111111111112, length1111111111111111111111111111111111111119, bArr711111111111111111111111111111111117.length);
                        int length2111111111111111111111111111111111111110 = length1111111111111111111111111111111111111119 + bArr711111111111111111111111111111111117.length;
                        java.lang.System.arraycopy(bArr6111111111111111111111116, 0, bArr711111111111111111111111111111111112, length2111111111111111111111111111111111111110, bArr6111111111111111111111116.length);
                        int length2111111111111111111111111111111111111111 = length2111111111111111111111111111111111111110 + bArr6111111111111111111111116.length;
                        java.lang.System.arraycopy(bArr6111111111111111111111117, 0, bArr711111111111111111111111111111111112, length2111111111111111111111111111111111111111, bArr6111111111111111111111117.length);
                        int length2111111111111111111111111111111111111112 = length2111111111111111111111111111111111111111 + bArr6111111111111111111111117.length;
                        byte[] bArr711111111111111111111111111111111118 = bArr16;
                        java.lang.System.arraycopy(bArr711111111111111111111111111111111118, 0, bArr711111111111111111111111111111111112, length2111111111111111111111111111111111111112, bArr711111111111111111111111111111111118.length);
                        int length2111111111111111111111111111111111111113 = length2111111111111111111111111111111111111112 + bArr711111111111111111111111111111111118.length;
                        byte[] bArr711111111111111111111111111111111119 = bArr19;
                        java.lang.System.arraycopy(bArr711111111111111111111111111111111119, 0, bArr711111111111111111111111111111111112, length2111111111111111111111111111111111111113, bArr711111111111111111111111111111111119.length);
                        int length2111111111111111111111111111111111111114 = length2111111111111111111111111111111111111113 + bArr711111111111111111111111111111111119.length;
                        byte[] bArr7111111111111111111111111111111111110 = bArr22;
                        java.lang.System.arraycopy(bArr7111111111111111111111111111111111110, 0, bArr711111111111111111111111111111111112, length2111111111111111111111111111111111111114, bArr7111111111111111111111111111111111110.length);
                        int length2111111111111111111111111111111111111115 = length2111111111111111111111111111111111111114 + bArr7111111111111111111111111111111111110.length;
                        java.lang.System.arraycopy(bArr511115, 0, bArr711111111111111111111111111111111112, length2111111111111111111111111111111111111115, bArr511115.length);
                        int length2111111111111111111111111111111111111116 = length2111111111111111111111111111111111111115 + bArr511115.length;
                        java.lang.System.arraycopy(bArr62111111111111110, 0, bArr711111111111111111111111111111111112, length2111111111111111111111111111111111111116, bArr62111111111111110.length);
                        int length2111111111111111111111111111111111111117 = length2111111111111111111111111111111111111116 + bArr62111111111111110.length;
                        java.lang.System.arraycopy(bArr6111111111111111111111113, 0, bArr711111111111111111111111111111111112, length2111111111111111111111111111111111111117, bArr6111111111111111111111113.length);
                        java.lang.System.arraycopy(bArr6111111111111111111111115, 0, bArr711111111111111111111111111111111112, length2111111111111111111111111111111111111117 + bArr6111111111111111111111113.length, bArr6111111111111111111111115.length);
                        int length2111111111111111111111111111111111111118 = bArr6111111111111111111111115.length;
                        return a(a(bArr711111111111111111111111111111111112, this.u, i111113), this.y, this.A, this.B);
                    }
                    bArr22 = bArr20;
                    bArr23 = bArr57;
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr511116 = bArr23;
                    byte[] bArr62111111111111114 = bArr25;
                    byte[] bArr62111111111111115 = bArr7;
                    byte[] bArr62111111111111116 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr62111111111111117 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr6111111111111111111111118 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111118, 0, i11);
                    tlv_tVar.set_data(bArr6111111111111111111111118, 4);
                    byte[] bArr6111111111111111111111119 = tlv_tVar.get_buf();
                    byte[] bArr61111111111111111111111110 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111110, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111111111111110, 4, 0);
                    tlv_tVar2.set_data(bArr61111111111111111111111110, 6);
                    byte[] bArr61111111111111111111111111 = tlv_tVar2.get_buf();
                    int i111114 = i14 + 1 + 1;
                    int length2111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111111111111115.length + bArr62111111111111116.length + bArr62111111111111117.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr61111111111111111111111112 = bArr10;
                    byte[] bArr61111111111111111111111113 = bArr31;
                    byte[] bArr7111111111111111111111111111111111111 = new byte[length2111111111111111111111111111111111111119 + bArr61111111111111111111111112.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr511116.length + bArr62111111111111114.length + bArr6111111111111111111111119.length + bArr61111111111111111111111111.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr7111111111111111111111111111111111111, 0, bArr35.length);
                    int length31111111111111111111111111111114 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr7111111111111111111111111111111111111, length31111111111111111111111111111114, bArr36.length);
                    int length31111111111111111111111111111115 = length31111111111111111111111111111114 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr7111111111111111111111111111111111111, length31111111111111111111111111111115, bArr37.length);
                    int length31111111111111111111111111111116 = length31111111111111111111111111111115 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr7111111111111111111111111111111111111, length31111111111111111111111111111116, bArr40.length);
                    int length31111111111111111111111111111117 = length31111111111111111111111111111116 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr7111111111111111111111111111111111111, length31111111111111111111111111111117, bArr38.length);
                    int length31111111111111111111111111111118 = length31111111111111111111111111111117 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr7111111111111111111111111111111111111, length31111111111111111111111111111118, bArr39.length);
                    int length31111111111111111111111111111119 = length31111111111111111111111111111118 + bArr39.length;
                    java.lang.System.arraycopy(bArr62111111111111115, 0, bArr7111111111111111111111111111111111111, length31111111111111111111111111111119, bArr62111111111111115.length);
                    int length311111111111111111111111111111110 = length31111111111111111111111111111119 + bArr62111111111111115.length;
                    java.lang.System.arraycopy(bArr62111111111111116, 0, bArr7111111111111111111111111111111111111, length311111111111111111111111111111110, bArr62111111111111116.length);
                    int length311111111111111111111111111111111 = length311111111111111111111111111111110 + bArr62111111111111116.length;
                    java.lang.System.arraycopy(bArr62111111111111117, 0, bArr7111111111111111111111111111111111111, length311111111111111111111111111111111, bArr62111111111111117.length);
                    int length11111111111111111111111111111111111111110 = length311111111111111111111111111111111 + bArr62111111111111117.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr7111111111111111111111111111111111111, length11111111111111111111111111111111111111110, bArr26.length);
                    int length11111111111111111111111111111111111111111 = length11111111111111111111111111111111111111110 + bArr26.length;
                    byte[] bArr7111111111111111111111111111111111112 = bArr41;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111112, 0, bArr7111111111111111111111111111111111111, length11111111111111111111111111111111111111111, bArr7111111111111111111111111111111111112.length);
                    int length11111111111111111111111111111111111111112 = length11111111111111111111111111111111111111111 + bArr7111111111111111111111111111111111112.length;
                    byte[] bArr7111111111111111111111111111111111113 = bArr8;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111113, 0, bArr7111111111111111111111111111111111111, length11111111111111111111111111111111111111112, bArr7111111111111111111111111111111111113.length);
                    int length11111111111111111111111111111111111111113 = length11111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111113.length;
                    byte[] bArr7111111111111111111111111111111111114 = bArr30;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111114, 0, bArr7111111111111111111111111111111111111, length11111111111111111111111111111111111111113, bArr7111111111111111111111111111111111114.length);
                    int length11111111111111111111111111111111111111114 = length11111111111111111111111111111111111111113 + bArr7111111111111111111111111111111111114.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr7111111111111111111111111111111111111, length11111111111111111111111111111111111111114, bArr42.length);
                    int length11111111111111111111111111111111111111115 = length11111111111111111111111111111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr7111111111111111111111111111111111111, length11111111111111111111111111111111111111115, bArr43.length);
                    int length11111111111111111111111111111111111111116 = length11111111111111111111111111111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr7111111111111111111111111111111111111, length11111111111111111111111111111111111111116, bArr44.length);
                    int length11111111111111111111111111111111111111117 = length11111111111111111111111111111111111111116 + bArr44.length;
                    byte[] bArr7111111111111111111111111111111111115 = bArr29;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111115, 0, bArr7111111111111111111111111111111111111, length11111111111111111111111111111111111111117, bArr7111111111111111111111111111111111115.length);
                    int length11111111111111111111111111111111111111118 = length11111111111111111111111111111111111111117 + bArr7111111111111111111111111111111111115.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr7111111111111111111111111111111111111, length11111111111111111111111111111111111111118, bArr45.length);
                    int length11111111111111111111111111111111111111119 = length11111111111111111111111111111111111111118 + bArr45.length;
                    byte[] bArr7111111111111111111111111111111111116 = bArr13;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111116, 0, bArr7111111111111111111111111111111111111, length11111111111111111111111111111111111111119, bArr7111111111111111111111111111111111116.length);
                    int length21111111111111111111111111111111111111110 = length11111111111111111111111111111111111111119 + bArr7111111111111111111111111111111111116.length;
                    java.lang.System.arraycopy(bArr61111111111111111111111112, 0, bArr7111111111111111111111111111111111111, length21111111111111111111111111111111111111110, bArr61111111111111111111111112.length);
                    int length21111111111111111111111111111111111111111 = length21111111111111111111111111111111111111110 + bArr61111111111111111111111112.length;
                    java.lang.System.arraycopy(bArr61111111111111111111111113, 0, bArr7111111111111111111111111111111111111, length21111111111111111111111111111111111111111, bArr61111111111111111111111113.length);
                    int length21111111111111111111111111111111111111112 = length21111111111111111111111111111111111111111 + bArr61111111111111111111111113.length;
                    byte[] bArr7111111111111111111111111111111111117 = bArr16;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111117, 0, bArr7111111111111111111111111111111111111, length21111111111111111111111111111111111111112, bArr7111111111111111111111111111111111117.length);
                    int length21111111111111111111111111111111111111113 = length21111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111117.length;
                    byte[] bArr7111111111111111111111111111111111118 = bArr19;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111118, 0, bArr7111111111111111111111111111111111111, length21111111111111111111111111111111111111113, bArr7111111111111111111111111111111111118.length);
                    int length21111111111111111111111111111111111111114 = length21111111111111111111111111111111111111113 + bArr7111111111111111111111111111111111118.length;
                    byte[] bArr7111111111111111111111111111111111119 = bArr22;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111119, 0, bArr7111111111111111111111111111111111111, length21111111111111111111111111111111111111114, bArr7111111111111111111111111111111111119.length);
                    int length21111111111111111111111111111111111111115 = length21111111111111111111111111111111111111114 + bArr7111111111111111111111111111111111119.length;
                    java.lang.System.arraycopy(bArr511116, 0, bArr7111111111111111111111111111111111111, length21111111111111111111111111111111111111115, bArr511116.length);
                    int length21111111111111111111111111111111111111116 = length21111111111111111111111111111111111111115 + bArr511116.length;
                    java.lang.System.arraycopy(bArr62111111111111114, 0, bArr7111111111111111111111111111111111111, length21111111111111111111111111111111111111116, bArr62111111111111114.length);
                    int length21111111111111111111111111111111111111117 = length21111111111111111111111111111111111111116 + bArr62111111111111114.length;
                    java.lang.System.arraycopy(bArr6111111111111111111111119, 0, bArr7111111111111111111111111111111111111, length21111111111111111111111111111111111111117, bArr6111111111111111111111119.length);
                    java.lang.System.arraycopy(bArr61111111111111111111111111, 0, bArr7111111111111111111111111111111111111, length21111111111111111111111111111111111111117 + bArr6111111111111111111111119.length, bArr61111111111111111111111111.length);
                    int length21111111111111111111111111111111111111118 = bArr61111111111111111111111111.length;
                    return a(a(bArr7111111111111111111111111111111111111, this.u, i111114), this.y, this.A, this.B);
                }
                bArr19 = bArr17;
                bArr20 = bArr56;
                bArr21 = oicq.wlogin_sdk.request.l.J;
                if (bArr21 != null) {
                    bArr22 = bArr20;
                    if (bArr21.length > 0) {
                        bArr41 = bArr41;
                        bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                        i12++;
                    }
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr511117 = bArr23;
                    byte[] bArr62111111111111118 = bArr25;
                    byte[] bArr62111111111111119 = bArr7;
                    byte[] bArr621111111111111110 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr621111111111111111 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr61111111111111111111111114 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111114, 0, i11);
                    tlv_tVar.set_data(bArr61111111111111111111111114, 4);
                    byte[] bArr61111111111111111111111115 = tlv_tVar.get_buf();
                    byte[] bArr61111111111111111111111116 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111116, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111111111111116, 4, 0);
                    tlv_tVar2.set_data(bArr61111111111111111111111116, 6);
                    byte[] bArr61111111111111111111111117 = tlv_tVar2.get_buf();
                    int i111115 = i14 + 1 + 1;
                    int length21111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111111111111119.length + bArr621111111111111110.length + bArr621111111111111111.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr61111111111111111111111118 = bArr10;
                    byte[] bArr61111111111111111111111119 = bArr31;
                    byte[] bArr71111111111111111111111111111111111110 = new byte[length21111111111111111111111111111111111111119 + bArr61111111111111111111111118.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr511117.length + bArr62111111111111118.length + bArr61111111111111111111111115.length + bArr61111111111111111111111117.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111111111111111111111110, 0, bArr35.length);
                    int length311111111111111111111111111111112 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111111111111111111111110, length311111111111111111111111111111112, bArr36.length);
                    int length311111111111111111111111111111113 = length311111111111111111111111111111112 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111111111111111111111110, length311111111111111111111111111111113, bArr37.length);
                    int length311111111111111111111111111111114 = length311111111111111111111111111111113 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111111111111111111111110, length311111111111111111111111111111114, bArr40.length);
                    int length311111111111111111111111111111115 = length311111111111111111111111111111114 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111111111111111111111110, length311111111111111111111111111111115, bArr38.length);
                    int length311111111111111111111111111111116 = length311111111111111111111111111111115 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111111111111111111111110, length311111111111111111111111111111116, bArr39.length);
                    int length311111111111111111111111111111117 = length311111111111111111111111111111116 + bArr39.length;
                    java.lang.System.arraycopy(bArr62111111111111119, 0, bArr71111111111111111111111111111111111110, length311111111111111111111111111111117, bArr62111111111111119.length);
                    int length311111111111111111111111111111118 = length311111111111111111111111111111117 + bArr62111111111111119.length;
                    java.lang.System.arraycopy(bArr621111111111111110, 0, bArr71111111111111111111111111111111111110, length311111111111111111111111111111118, bArr621111111111111110.length);
                    int length311111111111111111111111111111119 = length311111111111111111111111111111118 + bArr621111111111111110.length;
                    java.lang.System.arraycopy(bArr621111111111111111, 0, bArr71111111111111111111111111111111111110, length311111111111111111111111111111119, bArr621111111111111111.length);
                    int length111111111111111111111111111111111111111110 = length311111111111111111111111111111119 + bArr621111111111111111.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111111111111111111111110, length111111111111111111111111111111111111111110, bArr26.length);
                    int length111111111111111111111111111111111111111111 = length111111111111111111111111111111111111111110 + bArr26.length;
                    byte[] bArr71111111111111111111111111111111111111 = bArr41;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111111, 0, bArr71111111111111111111111111111111111110, length111111111111111111111111111111111111111111, bArr71111111111111111111111111111111111111.length);
                    int length111111111111111111111111111111111111111112 = length111111111111111111111111111111111111111111 + bArr71111111111111111111111111111111111111.length;
                    byte[] bArr71111111111111111111111111111111111112 = bArr8;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111112, 0, bArr71111111111111111111111111111111111110, length111111111111111111111111111111111111111112, bArr71111111111111111111111111111111111112.length);
                    int length111111111111111111111111111111111111111113 = length111111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111112.length;
                    byte[] bArr71111111111111111111111111111111111113 = bArr30;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111113, 0, bArr71111111111111111111111111111111111110, length111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111113.length);
                    int length111111111111111111111111111111111111111114 = length111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111113.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111111111111111111111110, length111111111111111111111111111111111111111114, bArr42.length);
                    int length111111111111111111111111111111111111111115 = length111111111111111111111111111111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111111111111111111111110, length111111111111111111111111111111111111111115, bArr43.length);
                    int length111111111111111111111111111111111111111116 = length111111111111111111111111111111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111111111111111111111110, length111111111111111111111111111111111111111116, bArr44.length);
                    int length111111111111111111111111111111111111111117 = length111111111111111111111111111111111111111116 + bArr44.length;
                    byte[] bArr71111111111111111111111111111111111114 = bArr29;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111114, 0, bArr71111111111111111111111111111111111110, length111111111111111111111111111111111111111117, bArr71111111111111111111111111111111111114.length);
                    int length111111111111111111111111111111111111111118 = length111111111111111111111111111111111111111117 + bArr71111111111111111111111111111111111114.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111111111111111111111110, length111111111111111111111111111111111111111118, bArr45.length);
                    int length111111111111111111111111111111111111111119 = length111111111111111111111111111111111111111118 + bArr45.length;
                    byte[] bArr71111111111111111111111111111111111115 = bArr13;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111115, 0, bArr71111111111111111111111111111111111110, length111111111111111111111111111111111111111119, bArr71111111111111111111111111111111111115.length);
                    int length211111111111111111111111111111111111111110 = length111111111111111111111111111111111111111119 + bArr71111111111111111111111111111111111115.length;
                    java.lang.System.arraycopy(bArr61111111111111111111111118, 0, bArr71111111111111111111111111111111111110, length211111111111111111111111111111111111111110, bArr61111111111111111111111118.length);
                    int length211111111111111111111111111111111111111111 = length211111111111111111111111111111111111111110 + bArr61111111111111111111111118.length;
                    java.lang.System.arraycopy(bArr61111111111111111111111119, 0, bArr71111111111111111111111111111111111110, length211111111111111111111111111111111111111111, bArr61111111111111111111111119.length);
                    int length211111111111111111111111111111111111111112 = length211111111111111111111111111111111111111111 + bArr61111111111111111111111119.length;
                    byte[] bArr71111111111111111111111111111111111116 = bArr16;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111116, 0, bArr71111111111111111111111111111111111110, length211111111111111111111111111111111111111112, bArr71111111111111111111111111111111111116.length);
                    int length211111111111111111111111111111111111111113 = length211111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111116.length;
                    byte[] bArr71111111111111111111111111111111111117 = bArr19;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111117, 0, bArr71111111111111111111111111111111111110, length211111111111111111111111111111111111111113, bArr71111111111111111111111111111111111117.length);
                    int length211111111111111111111111111111111111111114 = length211111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111117.length;
                    byte[] bArr71111111111111111111111111111111111118 = bArr22;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111118, 0, bArr71111111111111111111111111111111111110, length211111111111111111111111111111111111111114, bArr71111111111111111111111111111111111118.length);
                    int length211111111111111111111111111111111111111115 = length211111111111111111111111111111111111111114 + bArr71111111111111111111111111111111111118.length;
                    java.lang.System.arraycopy(bArr511117, 0, bArr71111111111111111111111111111111111110, length211111111111111111111111111111111111111115, bArr511117.length);
                    int length211111111111111111111111111111111111111116 = length211111111111111111111111111111111111111115 + bArr511117.length;
                    java.lang.System.arraycopy(bArr62111111111111118, 0, bArr71111111111111111111111111111111111110, length211111111111111111111111111111111111111116, bArr62111111111111118.length);
                    int length211111111111111111111111111111111111111117 = length211111111111111111111111111111111111111116 + bArr62111111111111118.length;
                    java.lang.System.arraycopy(bArr61111111111111111111111115, 0, bArr71111111111111111111111111111111111110, length211111111111111111111111111111111111111117, bArr61111111111111111111111115.length);
                    java.lang.System.arraycopy(bArr61111111111111111111111117, 0, bArr71111111111111111111111111111111111110, length211111111111111111111111111111111111111117 + bArr61111111111111111111111115.length, bArr61111111111111111111111117.length);
                    int length211111111111111111111111111111111111111118 = bArr61111111111111111111111117.length;
                    return a(a(bArr71111111111111111111111111111111111110, this.u, i111115), this.y, this.A, this.B);
                }
                bArr22 = bArr20;
                bArr23 = bArr57;
                bArr24 = oicq.wlogin_sdk.request.t.R;
                if (bArr24 != null) {
                    bArr25 = bArr6;
                } else {
                    bArr25 = bArr6;
                }
                byte[] bArr511118 = bArr23;
                byte[] bArr621111111111111112 = bArr25;
                byte[] bArr621111111111111113 = bArr7;
                byte[] bArr621111111111111114 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                byte[] bArr621111111111111115 = tlv_t142Var.get_tlv_142(bArr5);
                i13 = i12 + 1 + 1;
                str = this.x.g;
                if (str != null) {
                    i14 = i13;
                    bArr26 = bArr48;
                } else {
                    i14 = i13;
                    bArr26 = bArr48;
                }
                if (bArr3 != null) {
                    bArr27 = bArr50;
                } else {
                    bArr27 = bArr50;
                }
                if (list != null) {
                    bArr28 = bArr51;
                } else {
                    bArr28 = bArr51;
                }
                if (wloginSigInfoA == null) {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                } else {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                }
                byte[] bArr611111111111111111111111110 = new byte[4];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111110, 0, i11);
                tlv_tVar.set_data(bArr611111111111111111111111110, 4);
                byte[] bArr611111111111111111111111111 = tlv_tVar.get_buf();
                byte[] bArr611111111111111111111111112 = new byte[6];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111112, 0, oicq.wlogin_sdk.request.t.au);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111111111111111112, 4, 0);
                tlv_tVar2.set_data(bArr611111111111111111111111112, 6);
                byte[] bArr611111111111111111111111113 = tlv_tVar2.get_buf();
                int i111116 = i14 + 1 + 1;
                int length211111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111111111111113.length + bArr621111111111111114.length + bArr621111111111111115.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                byte[] bArr611111111111111111111111114 = bArr10;
                byte[] bArr611111111111111111111111115 = bArr31;
                byte[] bArr71111111111111111111111111111111111119 = new byte[length211111111111111111111111111111111111111119 + bArr611111111111111111111111114.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr511118.length + bArr621111111111111112.length + bArr611111111111111111111111111.length + bArr611111111111111111111111113.length];
                java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111111111111111111111119, 0, bArr35.length);
                int length3111111111111111111111111111111110 = bArr35.length + 0;
                java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111111111111111111111119, length3111111111111111111111111111111110, bArr36.length);
                int length3111111111111111111111111111111111 = length3111111111111111111111111111111110 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111111111111111111111119, length3111111111111111111111111111111111, bArr37.length);
                int length3111111111111111111111111111111112 = length3111111111111111111111111111111111 + bArr37.length;
                java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111111111111111111111119, length3111111111111111111111111111111112, bArr40.length);
                int length3111111111111111111111111111111113 = length3111111111111111111111111111111112 + bArr40.length;
                java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111111111111111111111119, length3111111111111111111111111111111113, bArr38.length);
                int length3111111111111111111111111111111114 = length3111111111111111111111111111111113 + bArr38.length;
                java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111111111111111111111119, length3111111111111111111111111111111114, bArr39.length);
                int length3111111111111111111111111111111115 = length3111111111111111111111111111111114 + bArr39.length;
                java.lang.System.arraycopy(bArr621111111111111113, 0, bArr71111111111111111111111111111111111119, length3111111111111111111111111111111115, bArr621111111111111113.length);
                int length3111111111111111111111111111111116 = length3111111111111111111111111111111115 + bArr621111111111111113.length;
                java.lang.System.arraycopy(bArr621111111111111114, 0, bArr71111111111111111111111111111111111119, length3111111111111111111111111111111116, bArr621111111111111114.length);
                int length3111111111111111111111111111111117 = length3111111111111111111111111111111116 + bArr621111111111111114.length;
                java.lang.System.arraycopy(bArr621111111111111115, 0, bArr71111111111111111111111111111111111119, length3111111111111111111111111111111117, bArr621111111111111115.length);
                int length1111111111111111111111111111111111111111110 = length3111111111111111111111111111111117 + bArr621111111111111115.length;
                java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111111111111111111111119, length1111111111111111111111111111111111111111110, bArr26.length);
                int length1111111111111111111111111111111111111111111 = length1111111111111111111111111111111111111111110 + bArr26.length;
                byte[] bArr711111111111111111111111111111111111110 = bArr41;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111110, 0, bArr71111111111111111111111111111111111119, length1111111111111111111111111111111111111111111, bArr711111111111111111111111111111111111110.length);
                int length1111111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111111 + bArr711111111111111111111111111111111111110.length;
                byte[] bArr711111111111111111111111111111111111111 = bArr8;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111, 0, bArr71111111111111111111111111111111111119, length1111111111111111111111111111111111111111112, bArr711111111111111111111111111111111111111.length);
                int length1111111111111111111111111111111111111111113 = length1111111111111111111111111111111111111111112 + bArr711111111111111111111111111111111111111.length;
                byte[] bArr711111111111111111111111111111111111112 = bArr30;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111112, 0, bArr71111111111111111111111111111111111119, length1111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111112.length);
                int length1111111111111111111111111111111111111111114 = length1111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111112.length;
                java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111111111111111111111119, length1111111111111111111111111111111111111111114, bArr42.length);
                int length1111111111111111111111111111111111111111115 = length1111111111111111111111111111111111111111114 + bArr42.length;
                java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111111111111111111111119, length1111111111111111111111111111111111111111115, bArr43.length);
                int length1111111111111111111111111111111111111111116 = length1111111111111111111111111111111111111111115 + bArr43.length;
                java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111111111111111111111119, length1111111111111111111111111111111111111111116, bArr44.length);
                int length1111111111111111111111111111111111111111117 = length1111111111111111111111111111111111111111116 + bArr44.length;
                byte[] bArr711111111111111111111111111111111111113 = bArr29;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111113, 0, bArr71111111111111111111111111111111111119, length1111111111111111111111111111111111111111117, bArr711111111111111111111111111111111111113.length);
                int length1111111111111111111111111111111111111111118 = length1111111111111111111111111111111111111111117 + bArr711111111111111111111111111111111111113.length;
                java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111111111111111111111119, length1111111111111111111111111111111111111111118, bArr45.length);
                int length1111111111111111111111111111111111111111119 = length1111111111111111111111111111111111111111118 + bArr45.length;
                byte[] bArr711111111111111111111111111111111111114 = bArr13;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111114, 0, bArr71111111111111111111111111111111111119, length1111111111111111111111111111111111111111119, bArr711111111111111111111111111111111111114.length);
                int length2111111111111111111111111111111111111111110 = length1111111111111111111111111111111111111111119 + bArr711111111111111111111111111111111111114.length;
                java.lang.System.arraycopy(bArr611111111111111111111111114, 0, bArr71111111111111111111111111111111111119, length2111111111111111111111111111111111111111110, bArr611111111111111111111111114.length);
                int length2111111111111111111111111111111111111111111 = length2111111111111111111111111111111111111111110 + bArr611111111111111111111111114.length;
                java.lang.System.arraycopy(bArr611111111111111111111111115, 0, bArr71111111111111111111111111111111111119, length2111111111111111111111111111111111111111111, bArr611111111111111111111111115.length);
                int length2111111111111111111111111111111111111111112 = length2111111111111111111111111111111111111111111 + bArr611111111111111111111111115.length;
                byte[] bArr711111111111111111111111111111111111115 = bArr16;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111115, 0, bArr71111111111111111111111111111111111119, length2111111111111111111111111111111111111111112, bArr711111111111111111111111111111111111115.length);
                int length2111111111111111111111111111111111111111113 = length2111111111111111111111111111111111111111112 + bArr711111111111111111111111111111111111115.length;
                byte[] bArr711111111111111111111111111111111111116 = bArr19;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111116, 0, bArr71111111111111111111111111111111111119, length2111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111116.length);
                int length2111111111111111111111111111111111111111114 = length2111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111116.length;
                byte[] bArr711111111111111111111111111111111111117 = bArr22;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111117, 0, bArr71111111111111111111111111111111111119, length2111111111111111111111111111111111111111114, bArr711111111111111111111111111111111111117.length);
                int length2111111111111111111111111111111111111111115 = length2111111111111111111111111111111111111111114 + bArr711111111111111111111111111111111111117.length;
                java.lang.System.arraycopy(bArr511118, 0, bArr71111111111111111111111111111111111119, length2111111111111111111111111111111111111111115, bArr511118.length);
                int length2111111111111111111111111111111111111111116 = length2111111111111111111111111111111111111111115 + bArr511118.length;
                java.lang.System.arraycopy(bArr621111111111111112, 0, bArr71111111111111111111111111111111111119, length2111111111111111111111111111111111111111116, bArr621111111111111112.length);
                int length2111111111111111111111111111111111111111117 = length2111111111111111111111111111111111111111116 + bArr621111111111111112.length;
                java.lang.System.arraycopy(bArr611111111111111111111111111, 0, bArr71111111111111111111111111111111111119, length2111111111111111111111111111111111111111117, bArr611111111111111111111111111.length);
                java.lang.System.arraycopy(bArr611111111111111111111111113, 0, bArr71111111111111111111111111111111111119, length2111111111111111111111111111111111111111117 + bArr611111111111111111111111111.length, bArr611111111111111111111111113.length);
                int length2111111111111111111111111111111111111111118 = bArr611111111111111111111111113.length;
                return a(a(bArr71111111111111111111111111111111111119, this.u, i111116), this.y, this.A, this.B);
            }
            bArr13 = bArr11;
            bArr14 = bArr54;
            bArr15 = oicq.wlogin_sdk.request.t.O;
            if (bArr15 != null) {
                bArr16 = bArr14;
                if (bArr15.length > 0) {
                    bArr17 = tlv_t188Var.get_tlv_188(bArr15);
                    i12++;
                }
                bArr18 = oicq.wlogin_sdk.request.t.L;
                if (bArr18 != null) {
                    bArr19 = bArr17;
                    if (bArr18.length > 0) {
                        bArr20 = tlv_t194Var.get_tlv_194(bArr18);
                        i12++;
                    }
                    bArr21 = oicq.wlogin_sdk.request.l.J;
                    if (bArr21 != null) {
                        bArr22 = bArr20;
                        if (bArr21.length > 0) {
                            bArr41 = bArr41;
                            bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                            i12++;
                        }
                        bArr24 = oicq.wlogin_sdk.request.t.R;
                        if (bArr24 != null) {
                            bArr25 = bArr6;
                        } else {
                            bArr25 = bArr6;
                        }
                        byte[] bArr511119 = bArr23;
                        byte[] bArr621111111111111116 = bArr25;
                        byte[] bArr621111111111111117 = bArr7;
                        byte[] bArr621111111111111118 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                        byte[] bArr621111111111111119 = tlv_t142Var.get_tlv_142(bArr5);
                        i13 = i12 + 1 + 1;
                        str = this.x.g;
                        if (str != null) {
                            i14 = i13;
                            bArr26 = bArr48;
                        } else {
                            i14 = i13;
                            bArr26 = bArr48;
                        }
                        if (bArr3 != null) {
                            bArr27 = bArr50;
                        } else {
                            bArr27 = bArr50;
                        }
                        if (list != null) {
                            bArr28 = bArr51;
                        } else {
                            bArr28 = bArr51;
                        }
                        if (wloginSigInfoA == null) {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        } else {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        }
                        byte[] bArr611111111111111111111111116 = new byte[4];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111116, 0, i11);
                        tlv_tVar.set_data(bArr611111111111111111111111116, 4);
                        byte[] bArr611111111111111111111111117 = tlv_tVar.get_buf();
                        byte[] bArr611111111111111111111111118 = new byte[6];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111118, 0, oicq.wlogin_sdk.request.t.au);
                        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111111111111111118, 4, 0);
                        tlv_tVar2.set_data(bArr611111111111111111111111118, 6);
                        byte[] bArr611111111111111111111111119 = tlv_tVar2.get_buf();
                        int i111117 = i14 + 1 + 1;
                        int length2111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111111111111117.length + bArr621111111111111118.length + bArr621111111111111119.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                        byte[] bArr6111111111111111111111111110 = bArr10;
                        byte[] bArr6111111111111111111111111111 = bArr31;
                        byte[] bArr711111111111111111111111111111111111118 = new byte[length2111111111111111111111111111111111111111119 + bArr6111111111111111111111111110.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr511119.length + bArr621111111111111116.length + bArr611111111111111111111111117.length + bArr611111111111111111111111119.length];
                        java.lang.System.arraycopy(bArr35, 0, bArr711111111111111111111111111111111111118, 0, bArr35.length);
                        int length3111111111111111111111111111111118 = bArr35.length + 0;
                        java.lang.System.arraycopy(bArr36, 0, bArr711111111111111111111111111111111111118, length3111111111111111111111111111111118, bArr36.length);
                        int length3111111111111111111111111111111119 = length3111111111111111111111111111111118 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr711111111111111111111111111111111111118, length3111111111111111111111111111111119, bArr37.length);
                        int length31111111111111111111111111111111110 = length3111111111111111111111111111111119 + bArr37.length;
                        java.lang.System.arraycopy(bArr40, 0, bArr711111111111111111111111111111111111118, length31111111111111111111111111111111110, bArr40.length);
                        int length31111111111111111111111111111111111 = length31111111111111111111111111111111110 + bArr40.length;
                        java.lang.System.arraycopy(bArr38, 0, bArr711111111111111111111111111111111111118, length31111111111111111111111111111111111, bArr38.length);
                        int length31111111111111111111111111111111112 = length31111111111111111111111111111111111 + bArr38.length;
                        java.lang.System.arraycopy(bArr39, 0, bArr711111111111111111111111111111111111118, length31111111111111111111111111111111112, bArr39.length);
                        int length31111111111111111111111111111111113 = length31111111111111111111111111111111112 + bArr39.length;
                        java.lang.System.arraycopy(bArr621111111111111117, 0, bArr711111111111111111111111111111111111118, length31111111111111111111111111111111113, bArr621111111111111117.length);
                        int length31111111111111111111111111111111114 = length31111111111111111111111111111111113 + bArr621111111111111117.length;
                        java.lang.System.arraycopy(bArr621111111111111118, 0, bArr711111111111111111111111111111111111118, length31111111111111111111111111111111114, bArr621111111111111118.length);
                        int length31111111111111111111111111111111115 = length31111111111111111111111111111111114 + bArr621111111111111118.length;
                        java.lang.System.arraycopy(bArr621111111111111119, 0, bArr711111111111111111111111111111111111118, length31111111111111111111111111111111115, bArr621111111111111119.length);
                        int length11111111111111111111111111111111111111111110 = length31111111111111111111111111111111115 + bArr621111111111111119.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr711111111111111111111111111111111111118, length11111111111111111111111111111111111111111110, bArr26.length);
                        int length11111111111111111111111111111111111111111111 = length11111111111111111111111111111111111111111110 + bArr26.length;
                        byte[] bArr711111111111111111111111111111111111119 = bArr41;
                        java.lang.System.arraycopy(bArr711111111111111111111111111111111111119, 0, bArr711111111111111111111111111111111111118, length11111111111111111111111111111111111111111111, bArr711111111111111111111111111111111111119.length);
                        int length11111111111111111111111111111111111111111112 = length11111111111111111111111111111111111111111111 + bArr711111111111111111111111111111111111119.length;
                        byte[] bArr7111111111111111111111111111111111111110 = bArr8;
                        java.lang.System.arraycopy(bArr7111111111111111111111111111111111111110, 0, bArr711111111111111111111111111111111111118, length11111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111110.length);
                        int length11111111111111111111111111111111111111111113 = length11111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111110.length;
                        byte[] bArr7111111111111111111111111111111111111111 = bArr30;
                        java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111, 0, bArr711111111111111111111111111111111111118, length11111111111111111111111111111111111111111113, bArr7111111111111111111111111111111111111111.length);
                        int length11111111111111111111111111111111111111111114 = length11111111111111111111111111111111111111111113 + bArr7111111111111111111111111111111111111111.length;
                        java.lang.System.arraycopy(bArr42, 0, bArr711111111111111111111111111111111111118, length11111111111111111111111111111111111111111114, bArr42.length);
                        int length11111111111111111111111111111111111111111115 = length11111111111111111111111111111111111111111114 + bArr42.length;
                        java.lang.System.arraycopy(bArr43, 0, bArr711111111111111111111111111111111111118, length11111111111111111111111111111111111111111115, bArr43.length);
                        int length11111111111111111111111111111111111111111116 = length11111111111111111111111111111111111111111115 + bArr43.length;
                        java.lang.System.arraycopy(bArr44, 0, bArr711111111111111111111111111111111111118, length11111111111111111111111111111111111111111116, bArr44.length);
                        int length11111111111111111111111111111111111111111117 = length11111111111111111111111111111111111111111116 + bArr44.length;
                        byte[] bArr7111111111111111111111111111111111111112 = bArr29;
                        java.lang.System.arraycopy(bArr7111111111111111111111111111111111111112, 0, bArr711111111111111111111111111111111111118, length11111111111111111111111111111111111111111117, bArr7111111111111111111111111111111111111112.length);
                        int length11111111111111111111111111111111111111111118 = length11111111111111111111111111111111111111111117 + bArr7111111111111111111111111111111111111112.length;
                        java.lang.System.arraycopy(bArr45, 0, bArr711111111111111111111111111111111111118, length11111111111111111111111111111111111111111118, bArr45.length);
                        int length11111111111111111111111111111111111111111119 = length11111111111111111111111111111111111111111118 + bArr45.length;
                        byte[] bArr7111111111111111111111111111111111111113 = bArr13;
                        java.lang.System.arraycopy(bArr7111111111111111111111111111111111111113, 0, bArr711111111111111111111111111111111111118, length11111111111111111111111111111111111111111119, bArr7111111111111111111111111111111111111113.length);
                        int length21111111111111111111111111111111111111111110 = length11111111111111111111111111111111111111111119 + bArr7111111111111111111111111111111111111113.length;
                        java.lang.System.arraycopy(bArr6111111111111111111111111110, 0, bArr711111111111111111111111111111111111118, length21111111111111111111111111111111111111111110, bArr6111111111111111111111111110.length);
                        int length21111111111111111111111111111111111111111111 = length21111111111111111111111111111111111111111110 + bArr6111111111111111111111111110.length;
                        java.lang.System.arraycopy(bArr6111111111111111111111111111, 0, bArr711111111111111111111111111111111111118, length21111111111111111111111111111111111111111111, bArr6111111111111111111111111111.length);
                        int length21111111111111111111111111111111111111111112 = length21111111111111111111111111111111111111111111 + bArr6111111111111111111111111111.length;
                        byte[] bArr7111111111111111111111111111111111111114 = bArr16;
                        java.lang.System.arraycopy(bArr7111111111111111111111111111111111111114, 0, bArr711111111111111111111111111111111111118, length21111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111114.length);
                        int length21111111111111111111111111111111111111111113 = length21111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111114.length;
                        byte[] bArr7111111111111111111111111111111111111115 = bArr19;
                        java.lang.System.arraycopy(bArr7111111111111111111111111111111111111115, 0, bArr711111111111111111111111111111111111118, length21111111111111111111111111111111111111111113, bArr7111111111111111111111111111111111111115.length);
                        int length21111111111111111111111111111111111111111114 = length21111111111111111111111111111111111111111113 + bArr7111111111111111111111111111111111111115.length;
                        byte[] bArr7111111111111111111111111111111111111116 = bArr22;
                        java.lang.System.arraycopy(bArr7111111111111111111111111111111111111116, 0, bArr711111111111111111111111111111111111118, length21111111111111111111111111111111111111111114, bArr7111111111111111111111111111111111111116.length);
                        int length21111111111111111111111111111111111111111115 = length21111111111111111111111111111111111111111114 + bArr7111111111111111111111111111111111111116.length;
                        java.lang.System.arraycopy(bArr511119, 0, bArr711111111111111111111111111111111111118, length21111111111111111111111111111111111111111115, bArr511119.length);
                        int length21111111111111111111111111111111111111111116 = length21111111111111111111111111111111111111111115 + bArr511119.length;
                        java.lang.System.arraycopy(bArr621111111111111116, 0, bArr711111111111111111111111111111111111118, length21111111111111111111111111111111111111111116, bArr621111111111111116.length);
                        int length21111111111111111111111111111111111111111117 = length21111111111111111111111111111111111111111116 + bArr621111111111111116.length;
                        java.lang.System.arraycopy(bArr611111111111111111111111117, 0, bArr711111111111111111111111111111111111118, length21111111111111111111111111111111111111111117, bArr611111111111111111111111117.length);
                        java.lang.System.arraycopy(bArr611111111111111111111111119, 0, bArr711111111111111111111111111111111111118, length21111111111111111111111111111111111111111117 + bArr611111111111111111111111117.length, bArr611111111111111111111111119.length);
                        int length21111111111111111111111111111111111111111118 = bArr611111111111111111111111119.length;
                        return a(a(bArr711111111111111111111111111111111111118, this.u, i111117), this.y, this.A, this.B);
                    }
                    bArr22 = bArr20;
                    bArr23 = bArr57;
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr5111110 = bArr23;
                    byte[] bArr6211111111111111110 = bArr25;
                    byte[] bArr6211111111111111111 = bArr7;
                    byte[] bArr6211111111111111112 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr6211111111111111113 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr6111111111111111111111111112 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111111112, 0, i11);
                    tlv_tVar.set_data(bArr6111111111111111111111111112, 4);
                    byte[] bArr6111111111111111111111111113 = tlv_tVar.get_buf();
                    byte[] bArr6111111111111111111111111114 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111111114, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr6111111111111111111111111114, 4, 0);
                    tlv_tVar2.set_data(bArr6111111111111111111111111114, 6);
                    byte[] bArr6111111111111111111111111115 = tlv_tVar2.get_buf();
                    int i111118 = i14 + 1 + 1;
                    int length21111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211111111111111111.length + bArr6211111111111111112.length + bArr6211111111111111113.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr6111111111111111111111111116 = bArr10;
                    byte[] bArr6111111111111111111111111117 = bArr31;
                    byte[] bArr7111111111111111111111111111111111111117 = new byte[length21111111111111111111111111111111111111111119 + bArr6111111111111111111111111116.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5111110.length + bArr6211111111111111110.length + bArr6111111111111111111111111113.length + bArr6111111111111111111111111115.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr7111111111111111111111111111111111111117, 0, bArr35.length);
                    int length31111111111111111111111111111111116 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr7111111111111111111111111111111111111117, length31111111111111111111111111111111116, bArr36.length);
                    int length31111111111111111111111111111111117 = length31111111111111111111111111111111116 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr7111111111111111111111111111111111111117, length31111111111111111111111111111111117, bArr37.length);
                    int length31111111111111111111111111111111118 = length31111111111111111111111111111111117 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr7111111111111111111111111111111111111117, length31111111111111111111111111111111118, bArr40.length);
                    int length31111111111111111111111111111111119 = length31111111111111111111111111111111118 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr7111111111111111111111111111111111111117, length31111111111111111111111111111111119, bArr38.length);
                    int length311111111111111111111111111111111110 = length31111111111111111111111111111111119 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr7111111111111111111111111111111111111117, length311111111111111111111111111111111110, bArr39.length);
                    int length311111111111111111111111111111111111 = length311111111111111111111111111111111110 + bArr39.length;
                    java.lang.System.arraycopy(bArr6211111111111111111, 0, bArr7111111111111111111111111111111111111117, length311111111111111111111111111111111111, bArr6211111111111111111.length);
                    int length311111111111111111111111111111111112 = length311111111111111111111111111111111111 + bArr6211111111111111111.length;
                    java.lang.System.arraycopy(bArr6211111111111111112, 0, bArr7111111111111111111111111111111111111117, length311111111111111111111111111111111112, bArr6211111111111111112.length);
                    int length311111111111111111111111111111111113 = length311111111111111111111111111111111112 + bArr6211111111111111112.length;
                    java.lang.System.arraycopy(bArr6211111111111111113, 0, bArr7111111111111111111111111111111111111117, length311111111111111111111111111111111113, bArr6211111111111111113.length);
                    int length111111111111111111111111111111111111111111110 = length311111111111111111111111111111111113 + bArr6211111111111111113.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr7111111111111111111111111111111111111117, length111111111111111111111111111111111111111111110, bArr26.length);
                    int length111111111111111111111111111111111111111111111 = length111111111111111111111111111111111111111111110 + bArr26.length;
                    byte[] bArr7111111111111111111111111111111111111118 = bArr41;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111111118, 0, bArr7111111111111111111111111111111111111117, length111111111111111111111111111111111111111111111, bArr7111111111111111111111111111111111111118.length);
                    int length111111111111111111111111111111111111111111112 = length111111111111111111111111111111111111111111111 + bArr7111111111111111111111111111111111111118.length;
                    byte[] bArr7111111111111111111111111111111111111119 = bArr8;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111111119, 0, bArr7111111111111111111111111111111111111117, length111111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111119.length);
                    int length111111111111111111111111111111111111111111113 = length111111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111119.length;
                    byte[] bArr71111111111111111111111111111111111111110 = bArr30;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111111110, 0, bArr7111111111111111111111111111111111111117, length111111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111111110.length);
                    int length111111111111111111111111111111111111111111114 = length111111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111111110.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr7111111111111111111111111111111111111117, length111111111111111111111111111111111111111111114, bArr42.length);
                    int length111111111111111111111111111111111111111111115 = length111111111111111111111111111111111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr7111111111111111111111111111111111111117, length111111111111111111111111111111111111111111115, bArr43.length);
                    int length111111111111111111111111111111111111111111116 = length111111111111111111111111111111111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr7111111111111111111111111111111111111117, length111111111111111111111111111111111111111111116, bArr44.length);
                    int length111111111111111111111111111111111111111111117 = length111111111111111111111111111111111111111111116 + bArr44.length;
                    byte[] bArr71111111111111111111111111111111111111111 = bArr29;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111, 0, bArr7111111111111111111111111111111111111117, length111111111111111111111111111111111111111111117, bArr71111111111111111111111111111111111111111.length);
                    int length111111111111111111111111111111111111111111118 = length111111111111111111111111111111111111111111117 + bArr71111111111111111111111111111111111111111.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr7111111111111111111111111111111111111117, length111111111111111111111111111111111111111111118, bArr45.length);
                    int length111111111111111111111111111111111111111111119 = length111111111111111111111111111111111111111111118 + bArr45.length;
                    byte[] bArr71111111111111111111111111111111111111112 = bArr13;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111111112, 0, bArr7111111111111111111111111111111111111117, length111111111111111111111111111111111111111111119, bArr71111111111111111111111111111111111111112.length);
                    int length211111111111111111111111111111111111111111110 = length111111111111111111111111111111111111111111119 + bArr71111111111111111111111111111111111111112.length;
                    java.lang.System.arraycopy(bArr6111111111111111111111111116, 0, bArr7111111111111111111111111111111111111117, length211111111111111111111111111111111111111111110, bArr6111111111111111111111111116.length);
                    int length211111111111111111111111111111111111111111111 = length211111111111111111111111111111111111111111110 + bArr6111111111111111111111111116.length;
                    java.lang.System.arraycopy(bArr6111111111111111111111111117, 0, bArr7111111111111111111111111111111111111117, length211111111111111111111111111111111111111111111, bArr6111111111111111111111111117.length);
                    int length211111111111111111111111111111111111111111112 = length211111111111111111111111111111111111111111111 + bArr6111111111111111111111111117.length;
                    byte[] bArr71111111111111111111111111111111111111113 = bArr16;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111111113, 0, bArr7111111111111111111111111111111111111117, length211111111111111111111111111111111111111111112, bArr71111111111111111111111111111111111111113.length);
                    int length211111111111111111111111111111111111111111113 = length211111111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111111113.length;
                    byte[] bArr71111111111111111111111111111111111111114 = bArr19;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111111114, 0, bArr7111111111111111111111111111111111111117, length211111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111111114.length);
                    int length211111111111111111111111111111111111111111114 = length211111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111111114.length;
                    byte[] bArr71111111111111111111111111111111111111115 = bArr22;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111111115, 0, bArr7111111111111111111111111111111111111117, length211111111111111111111111111111111111111111114, bArr71111111111111111111111111111111111111115.length);
                    int length211111111111111111111111111111111111111111115 = length211111111111111111111111111111111111111111114 + bArr71111111111111111111111111111111111111115.length;
                    java.lang.System.arraycopy(bArr5111110, 0, bArr7111111111111111111111111111111111111117, length211111111111111111111111111111111111111111115, bArr5111110.length);
                    int length211111111111111111111111111111111111111111116 = length211111111111111111111111111111111111111111115 + bArr5111110.length;
                    java.lang.System.arraycopy(bArr6211111111111111110, 0, bArr7111111111111111111111111111111111111117, length211111111111111111111111111111111111111111116, bArr6211111111111111110.length);
                    int length211111111111111111111111111111111111111111117 = length211111111111111111111111111111111111111111116 + bArr6211111111111111110.length;
                    java.lang.System.arraycopy(bArr6111111111111111111111111113, 0, bArr7111111111111111111111111111111111111117, length211111111111111111111111111111111111111111117, bArr6111111111111111111111111113.length);
                    java.lang.System.arraycopy(bArr6111111111111111111111111115, 0, bArr7111111111111111111111111111111111111117, length211111111111111111111111111111111111111111117 + bArr6111111111111111111111111113.length, bArr6111111111111111111111111115.length);
                    int length211111111111111111111111111111111111111111118 = bArr6111111111111111111111111115.length;
                    return a(a(bArr7111111111111111111111111111111111111117, this.u, i111118), this.y, this.A, this.B);
                }
                bArr19 = bArr17;
                bArr20 = bArr56;
                bArr21 = oicq.wlogin_sdk.request.l.J;
                if (bArr21 != null) {
                    bArr22 = bArr20;
                    if (bArr21.length > 0) {
                        bArr41 = bArr41;
                        bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                        i12++;
                    }
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr5111111 = bArr23;
                    byte[] bArr6211111111111111114 = bArr25;
                    byte[] bArr6211111111111111115 = bArr7;
                    byte[] bArr6211111111111111116 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr6211111111111111117 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr6111111111111111111111111118 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111111118, 0, i11);
                    tlv_tVar.set_data(bArr6111111111111111111111111118, 4);
                    byte[] bArr6111111111111111111111111119 = tlv_tVar.get_buf();
                    byte[] bArr61111111111111111111111111110 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111111110, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111111111111111110, 4, 0);
                    tlv_tVar2.set_data(bArr61111111111111111111111111110, 6);
                    byte[] bArr61111111111111111111111111111 = tlv_tVar2.get_buf();
                    int i111119 = i14 + 1 + 1;
                    int length211111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211111111111111115.length + bArr6211111111111111116.length + bArr6211111111111111117.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr61111111111111111111111111112 = bArr10;
                    byte[] bArr61111111111111111111111111113 = bArr31;
                    byte[] bArr71111111111111111111111111111111111111116 = new byte[length211111111111111111111111111111111111111111119 + bArr61111111111111111111111111112.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5111111.length + bArr6211111111111111114.length + bArr6111111111111111111111111119.length + bArr61111111111111111111111111111.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111111111111111111111111116, 0, bArr35.length);
                    int length311111111111111111111111111111111114 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111111111111111111111111116, length311111111111111111111111111111111114, bArr36.length);
                    int length311111111111111111111111111111111115 = length311111111111111111111111111111111114 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111111111111111111111111116, length311111111111111111111111111111111115, bArr37.length);
                    int length311111111111111111111111111111111116 = length311111111111111111111111111111111115 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111111111111111111111111116, length311111111111111111111111111111111116, bArr40.length);
                    int length311111111111111111111111111111111117 = length311111111111111111111111111111111116 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111111111111111111111111116, length311111111111111111111111111111111117, bArr38.length);
                    int length311111111111111111111111111111111118 = length311111111111111111111111111111111117 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111111111111111111111111116, length311111111111111111111111111111111118, bArr39.length);
                    int length311111111111111111111111111111111119 = length311111111111111111111111111111111118 + bArr39.length;
                    java.lang.System.arraycopy(bArr6211111111111111115, 0, bArr71111111111111111111111111111111111111116, length311111111111111111111111111111111119, bArr6211111111111111115.length);
                    int length3111111111111111111111111111111111110 = length311111111111111111111111111111111119 + bArr6211111111111111115.length;
                    java.lang.System.arraycopy(bArr6211111111111111116, 0, bArr71111111111111111111111111111111111111116, length3111111111111111111111111111111111110, bArr6211111111111111116.length);
                    int length3111111111111111111111111111111111111 = length3111111111111111111111111111111111110 + bArr6211111111111111116.length;
                    java.lang.System.arraycopy(bArr6211111111111111117, 0, bArr71111111111111111111111111111111111111116, length3111111111111111111111111111111111111, bArr6211111111111111117.length);
                    int length1111111111111111111111111111111111111111111110 = length3111111111111111111111111111111111111 + bArr6211111111111111117.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111111111111111111111111116, length1111111111111111111111111111111111111111111110, bArr26.length);
                    int length1111111111111111111111111111111111111111111111 = length1111111111111111111111111111111111111111111110 + bArr26.length;
                    byte[] bArr71111111111111111111111111111111111111117 = bArr41;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111111117, 0, bArr71111111111111111111111111111111111111116, length1111111111111111111111111111111111111111111111, bArr71111111111111111111111111111111111111117.length);
                    int length1111111111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111111111 + bArr71111111111111111111111111111111111111117.length;
                    byte[] bArr71111111111111111111111111111111111111118 = bArr8;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111111118, 0, bArr71111111111111111111111111111111111111116, length1111111111111111111111111111111111111111111112, bArr71111111111111111111111111111111111111118.length);
                    int length1111111111111111111111111111111111111111111113 = length1111111111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111111118.length;
                    byte[] bArr71111111111111111111111111111111111111119 = bArr30;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111111119, 0, bArr71111111111111111111111111111111111111116, length1111111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111111119.length);
                    int length1111111111111111111111111111111111111111111114 = length1111111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111111119.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111111111111111111111111116, length1111111111111111111111111111111111111111111114, bArr42.length);
                    int length1111111111111111111111111111111111111111111115 = length1111111111111111111111111111111111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111111111111111111111111116, length1111111111111111111111111111111111111111111115, bArr43.length);
                    int length1111111111111111111111111111111111111111111116 = length1111111111111111111111111111111111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111111111111111111111111116, length1111111111111111111111111111111111111111111116, bArr44.length);
                    int length1111111111111111111111111111111111111111111117 = length1111111111111111111111111111111111111111111116 + bArr44.length;
                    byte[] bArr711111111111111111111111111111111111111110 = bArr29;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111110, 0, bArr71111111111111111111111111111111111111116, length1111111111111111111111111111111111111111111117, bArr711111111111111111111111111111111111111110.length);
                    int length1111111111111111111111111111111111111111111118 = length1111111111111111111111111111111111111111111117 + bArr711111111111111111111111111111111111111110.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111111111111111111111111116, length1111111111111111111111111111111111111111111118, bArr45.length);
                    int length1111111111111111111111111111111111111111111119 = length1111111111111111111111111111111111111111111118 + bArr45.length;
                    byte[] bArr711111111111111111111111111111111111111111 = bArr13;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111, 0, bArr71111111111111111111111111111111111111116, length1111111111111111111111111111111111111111111119, bArr711111111111111111111111111111111111111111.length);
                    int length2111111111111111111111111111111111111111111110 = length1111111111111111111111111111111111111111111119 + bArr711111111111111111111111111111111111111111.length;
                    java.lang.System.arraycopy(bArr61111111111111111111111111112, 0, bArr71111111111111111111111111111111111111116, length2111111111111111111111111111111111111111111110, bArr61111111111111111111111111112.length);
                    int length2111111111111111111111111111111111111111111111 = length2111111111111111111111111111111111111111111110 + bArr61111111111111111111111111112.length;
                    java.lang.System.arraycopy(bArr61111111111111111111111111113, 0, bArr71111111111111111111111111111111111111116, length2111111111111111111111111111111111111111111111, bArr61111111111111111111111111113.length);
                    int length2111111111111111111111111111111111111111111112 = length2111111111111111111111111111111111111111111111 + bArr61111111111111111111111111113.length;
                    byte[] bArr711111111111111111111111111111111111111112 = bArr16;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111112, 0, bArr71111111111111111111111111111111111111116, length2111111111111111111111111111111111111111111112, bArr711111111111111111111111111111111111111112.length);
                    int length2111111111111111111111111111111111111111111113 = length2111111111111111111111111111111111111111111112 + bArr711111111111111111111111111111111111111112.length;
                    byte[] bArr711111111111111111111111111111111111111113 = bArr19;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111113, 0, bArr71111111111111111111111111111111111111116, length2111111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111111113.length);
                    int length2111111111111111111111111111111111111111111114 = length2111111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111111113.length;
                    byte[] bArr711111111111111111111111111111111111111114 = bArr22;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111114, 0, bArr71111111111111111111111111111111111111116, length2111111111111111111111111111111111111111111114, bArr711111111111111111111111111111111111111114.length);
                    int length2111111111111111111111111111111111111111111115 = length2111111111111111111111111111111111111111111114 + bArr711111111111111111111111111111111111111114.length;
                    java.lang.System.arraycopy(bArr5111111, 0, bArr71111111111111111111111111111111111111116, length2111111111111111111111111111111111111111111115, bArr5111111.length);
                    int length2111111111111111111111111111111111111111111116 = length2111111111111111111111111111111111111111111115 + bArr5111111.length;
                    java.lang.System.arraycopy(bArr6211111111111111114, 0, bArr71111111111111111111111111111111111111116, length2111111111111111111111111111111111111111111116, bArr6211111111111111114.length);
                    int length2111111111111111111111111111111111111111111117 = length2111111111111111111111111111111111111111111116 + bArr6211111111111111114.length;
                    java.lang.System.arraycopy(bArr6111111111111111111111111119, 0, bArr71111111111111111111111111111111111111116, length2111111111111111111111111111111111111111111117, bArr6111111111111111111111111119.length);
                    java.lang.System.arraycopy(bArr61111111111111111111111111111, 0, bArr71111111111111111111111111111111111111116, length2111111111111111111111111111111111111111111117 + bArr6111111111111111111111111119.length, bArr61111111111111111111111111111.length);
                    int length2111111111111111111111111111111111111111111118 = bArr61111111111111111111111111111.length;
                    return a(a(bArr71111111111111111111111111111111111111116, this.u, i111119), this.y, this.A, this.B);
                }
                bArr22 = bArr20;
                bArr23 = bArr57;
                bArr24 = oicq.wlogin_sdk.request.t.R;
                if (bArr24 != null) {
                    bArr25 = bArr6;
                } else {
                    bArr25 = bArr6;
                }
                byte[] bArr5111112 = bArr23;
                byte[] bArr6211111111111111118 = bArr25;
                byte[] bArr6211111111111111119 = bArr7;
                byte[] bArr62111111111111111110 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                byte[] bArr62111111111111111111 = tlv_t142Var.get_tlv_142(bArr5);
                i13 = i12 + 1 + 1;
                str = this.x.g;
                if (str != null) {
                    i14 = i13;
                    bArr26 = bArr48;
                } else {
                    i14 = i13;
                    bArr26 = bArr48;
                }
                if (bArr3 != null) {
                    bArr27 = bArr50;
                } else {
                    bArr27 = bArr50;
                }
                if (list != null) {
                    bArr28 = bArr51;
                } else {
                    bArr28 = bArr51;
                }
                if (wloginSigInfoA == null) {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                } else {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                }
                byte[] bArr61111111111111111111111111114 = new byte[4];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111111114, 0, i11);
                tlv_tVar.set_data(bArr61111111111111111111111111114, 4);
                byte[] bArr61111111111111111111111111115 = tlv_tVar.get_buf();
                byte[] bArr61111111111111111111111111116 = new byte[6];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111111116, 0, oicq.wlogin_sdk.request.t.au);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111111111111111116, 4, 0);
                tlv_tVar2.set_data(bArr61111111111111111111111111116, 6);
                byte[] bArr61111111111111111111111111117 = tlv_tVar2.get_buf();
                int i1111110 = i14 + 1 + 1;
                int length2111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211111111111111119.length + bArr62111111111111111110.length + bArr62111111111111111111.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                byte[] bArr61111111111111111111111111118 = bArr10;
                byte[] bArr61111111111111111111111111119 = bArr31;
                byte[] bArr711111111111111111111111111111111111111115 = new byte[length2111111111111111111111111111111111111111111119 + bArr61111111111111111111111111118.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5111112.length + bArr6211111111111111118.length + bArr61111111111111111111111111115.length + bArr61111111111111111111111111117.length];
                java.lang.System.arraycopy(bArr35, 0, bArr711111111111111111111111111111111111111115, 0, bArr35.length);
                int length3111111111111111111111111111111111112 = bArr35.length + 0;
                java.lang.System.arraycopy(bArr36, 0, bArr711111111111111111111111111111111111111115, length3111111111111111111111111111111111112, bArr36.length);
                int length3111111111111111111111111111111111113 = length3111111111111111111111111111111111112 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr711111111111111111111111111111111111111115, length3111111111111111111111111111111111113, bArr37.length);
                int length3111111111111111111111111111111111114 = length3111111111111111111111111111111111113 + bArr37.length;
                java.lang.System.arraycopy(bArr40, 0, bArr711111111111111111111111111111111111111115, length3111111111111111111111111111111111114, bArr40.length);
                int length3111111111111111111111111111111111115 = length3111111111111111111111111111111111114 + bArr40.length;
                java.lang.System.arraycopy(bArr38, 0, bArr711111111111111111111111111111111111111115, length3111111111111111111111111111111111115, bArr38.length);
                int length3111111111111111111111111111111111116 = length3111111111111111111111111111111111115 + bArr38.length;
                java.lang.System.arraycopy(bArr39, 0, bArr711111111111111111111111111111111111111115, length3111111111111111111111111111111111116, bArr39.length);
                int length3111111111111111111111111111111111117 = length3111111111111111111111111111111111116 + bArr39.length;
                java.lang.System.arraycopy(bArr6211111111111111119, 0, bArr711111111111111111111111111111111111111115, length3111111111111111111111111111111111117, bArr6211111111111111119.length);
                int length3111111111111111111111111111111111118 = length3111111111111111111111111111111111117 + bArr6211111111111111119.length;
                java.lang.System.arraycopy(bArr62111111111111111110, 0, bArr711111111111111111111111111111111111111115, length3111111111111111111111111111111111118, bArr62111111111111111110.length);
                int length3111111111111111111111111111111111119 = length3111111111111111111111111111111111118 + bArr62111111111111111110.length;
                java.lang.System.arraycopy(bArr62111111111111111111, 0, bArr711111111111111111111111111111111111111115, length3111111111111111111111111111111111119, bArr62111111111111111111.length);
                int length11111111111111111111111111111111111111111111110 = length3111111111111111111111111111111111119 + bArr62111111111111111111.length;
                java.lang.System.arraycopy(bArr26, 0, bArr711111111111111111111111111111111111111115, length11111111111111111111111111111111111111111111110, bArr26.length);
                int length11111111111111111111111111111111111111111111111 = length11111111111111111111111111111111111111111111110 + bArr26.length;
                byte[] bArr711111111111111111111111111111111111111116 = bArr41;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111116, 0, bArr711111111111111111111111111111111111111115, length11111111111111111111111111111111111111111111111, bArr711111111111111111111111111111111111111116.length);
                int length11111111111111111111111111111111111111111111112 = length11111111111111111111111111111111111111111111111 + bArr711111111111111111111111111111111111111116.length;
                byte[] bArr711111111111111111111111111111111111111117 = bArr8;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111117, 0, bArr711111111111111111111111111111111111111115, length11111111111111111111111111111111111111111111112, bArr711111111111111111111111111111111111111117.length);
                int length11111111111111111111111111111111111111111111113 = length11111111111111111111111111111111111111111111112 + bArr711111111111111111111111111111111111111117.length;
                byte[] bArr711111111111111111111111111111111111111118 = bArr30;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111118, 0, bArr711111111111111111111111111111111111111115, length11111111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111111118.length);
                int length11111111111111111111111111111111111111111111114 = length11111111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111111118.length;
                java.lang.System.arraycopy(bArr42, 0, bArr711111111111111111111111111111111111111115, length11111111111111111111111111111111111111111111114, bArr42.length);
                int length11111111111111111111111111111111111111111111115 = length11111111111111111111111111111111111111111111114 + bArr42.length;
                java.lang.System.arraycopy(bArr43, 0, bArr711111111111111111111111111111111111111115, length11111111111111111111111111111111111111111111115, bArr43.length);
                int length11111111111111111111111111111111111111111111116 = length11111111111111111111111111111111111111111111115 + bArr43.length;
                java.lang.System.arraycopy(bArr44, 0, bArr711111111111111111111111111111111111111115, length11111111111111111111111111111111111111111111116, bArr44.length);
                int length11111111111111111111111111111111111111111111117 = length11111111111111111111111111111111111111111111116 + bArr44.length;
                byte[] bArr711111111111111111111111111111111111111119 = bArr29;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111119, 0, bArr711111111111111111111111111111111111111115, length11111111111111111111111111111111111111111111117, bArr711111111111111111111111111111111111111119.length);
                int length11111111111111111111111111111111111111111111118 = length11111111111111111111111111111111111111111111117 + bArr711111111111111111111111111111111111111119.length;
                java.lang.System.arraycopy(bArr45, 0, bArr711111111111111111111111111111111111111115, length11111111111111111111111111111111111111111111118, bArr45.length);
                int length11111111111111111111111111111111111111111111119 = length11111111111111111111111111111111111111111111118 + bArr45.length;
                byte[] bArr7111111111111111111111111111111111111111110 = bArr13;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111110, 0, bArr711111111111111111111111111111111111111115, length11111111111111111111111111111111111111111111119, bArr7111111111111111111111111111111111111111110.length);
                int length21111111111111111111111111111111111111111111110 = length11111111111111111111111111111111111111111111119 + bArr7111111111111111111111111111111111111111110.length;
                java.lang.System.arraycopy(bArr61111111111111111111111111118, 0, bArr711111111111111111111111111111111111111115, length21111111111111111111111111111111111111111111110, bArr61111111111111111111111111118.length);
                int length21111111111111111111111111111111111111111111111 = length21111111111111111111111111111111111111111111110 + bArr61111111111111111111111111118.length;
                java.lang.System.arraycopy(bArr61111111111111111111111111119, 0, bArr711111111111111111111111111111111111111115, length21111111111111111111111111111111111111111111111, bArr61111111111111111111111111119.length);
                int length21111111111111111111111111111111111111111111112 = length21111111111111111111111111111111111111111111111 + bArr61111111111111111111111111119.length;
                byte[] bArr7111111111111111111111111111111111111111111 = bArr16;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111, 0, bArr711111111111111111111111111111111111111115, length21111111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111111111.length);
                int length21111111111111111111111111111111111111111111113 = length21111111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111111111.length;
                byte[] bArr7111111111111111111111111111111111111111112 = bArr19;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111112, 0, bArr711111111111111111111111111111111111111115, length21111111111111111111111111111111111111111111113, bArr7111111111111111111111111111111111111111112.length);
                int length21111111111111111111111111111111111111111111114 = length21111111111111111111111111111111111111111111113 + bArr7111111111111111111111111111111111111111112.length;
                byte[] bArr7111111111111111111111111111111111111111113 = bArr22;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111113, 0, bArr711111111111111111111111111111111111111115, length21111111111111111111111111111111111111111111114, bArr7111111111111111111111111111111111111111113.length);
                int length21111111111111111111111111111111111111111111115 = length21111111111111111111111111111111111111111111114 + bArr7111111111111111111111111111111111111111113.length;
                java.lang.System.arraycopy(bArr5111112, 0, bArr711111111111111111111111111111111111111115, length21111111111111111111111111111111111111111111115, bArr5111112.length);
                int length21111111111111111111111111111111111111111111116 = length21111111111111111111111111111111111111111111115 + bArr5111112.length;
                java.lang.System.arraycopy(bArr6211111111111111118, 0, bArr711111111111111111111111111111111111111115, length21111111111111111111111111111111111111111111116, bArr6211111111111111118.length);
                int length21111111111111111111111111111111111111111111117 = length21111111111111111111111111111111111111111111116 + bArr6211111111111111118.length;
                java.lang.System.arraycopy(bArr61111111111111111111111111115, 0, bArr711111111111111111111111111111111111111115, length21111111111111111111111111111111111111111111117, bArr61111111111111111111111111115.length);
                java.lang.System.arraycopy(bArr61111111111111111111111111117, 0, bArr711111111111111111111111111111111111111115, length21111111111111111111111111111111111111111111117 + bArr61111111111111111111111111115.length, bArr61111111111111111111111111117.length);
                int length21111111111111111111111111111111111111111111118 = bArr61111111111111111111111111117.length;
                return a(a(bArr711111111111111111111111111111111111111115, this.u, i1111110), this.y, this.A, this.B);
            }
            bArr16 = bArr14;
            bArr17 = bArr55;
            bArr18 = oicq.wlogin_sdk.request.t.L;
            if (bArr18 != null) {
                bArr19 = bArr17;
                if (bArr18.length > 0) {
                    bArr20 = tlv_t194Var.get_tlv_194(bArr18);
                    i12++;
                }
                bArr21 = oicq.wlogin_sdk.request.l.J;
                if (bArr21 != null) {
                    bArr22 = bArr20;
                    if (bArr21.length > 0) {
                        bArr41 = bArr41;
                        bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                        i12++;
                    }
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr5111113 = bArr23;
                    byte[] bArr62111111111111111112 = bArr25;
                    byte[] bArr62111111111111111113 = bArr7;
                    byte[] bArr62111111111111111114 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr62111111111111111115 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr611111111111111111111111111110 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111111110, 0, i11);
                    tlv_tVar.set_data(bArr611111111111111111111111111110, 4);
                    byte[] bArr611111111111111111111111111111 = tlv_tVar.get_buf();
                    byte[] bArr611111111111111111111111111112 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111111112, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111111111111111111112, 4, 0);
                    tlv_tVar2.set_data(bArr611111111111111111111111111112, 6);
                    byte[] bArr611111111111111111111111111113 = tlv_tVar2.get_buf();
                    int i1111111 = i14 + 1 + 1;
                    int length21111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111111111111111113.length + bArr62111111111111111114.length + bArr62111111111111111115.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr611111111111111111111111111114 = bArr10;
                    byte[] bArr611111111111111111111111111115 = bArr31;
                    byte[] bArr7111111111111111111111111111111111111111114 = new byte[length21111111111111111111111111111111111111111111119 + bArr611111111111111111111111111114.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5111113.length + bArr62111111111111111112.length + bArr611111111111111111111111111111.length + bArr611111111111111111111111111113.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr7111111111111111111111111111111111111111114, 0, bArr35.length);
                    int length31111111111111111111111111111111111110 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr7111111111111111111111111111111111111111114, length31111111111111111111111111111111111110, bArr36.length);
                    int length31111111111111111111111111111111111111 = length31111111111111111111111111111111111110 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr7111111111111111111111111111111111111111114, length31111111111111111111111111111111111111, bArr37.length);
                    int length31111111111111111111111111111111111112 = length31111111111111111111111111111111111111 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr7111111111111111111111111111111111111111114, length31111111111111111111111111111111111112, bArr40.length);
                    int length31111111111111111111111111111111111113 = length31111111111111111111111111111111111112 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr7111111111111111111111111111111111111111114, length31111111111111111111111111111111111113, bArr38.length);
                    int length31111111111111111111111111111111111114 = length31111111111111111111111111111111111113 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr7111111111111111111111111111111111111111114, length31111111111111111111111111111111111114, bArr39.length);
                    int length31111111111111111111111111111111111115 = length31111111111111111111111111111111111114 + bArr39.length;
                    java.lang.System.arraycopy(bArr62111111111111111113, 0, bArr7111111111111111111111111111111111111111114, length31111111111111111111111111111111111115, bArr62111111111111111113.length);
                    int length31111111111111111111111111111111111116 = length31111111111111111111111111111111111115 + bArr62111111111111111113.length;
                    java.lang.System.arraycopy(bArr62111111111111111114, 0, bArr7111111111111111111111111111111111111111114, length31111111111111111111111111111111111116, bArr62111111111111111114.length);
                    int length31111111111111111111111111111111111117 = length31111111111111111111111111111111111116 + bArr62111111111111111114.length;
                    java.lang.System.arraycopy(bArr62111111111111111115, 0, bArr7111111111111111111111111111111111111111114, length31111111111111111111111111111111111117, bArr62111111111111111115.length);
                    int length111111111111111111111111111111111111111111111110 = length31111111111111111111111111111111111117 + bArr62111111111111111115.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr7111111111111111111111111111111111111111114, length111111111111111111111111111111111111111111111110, bArr26.length);
                    int length111111111111111111111111111111111111111111111111 = length111111111111111111111111111111111111111111111110 + bArr26.length;
                    byte[] bArr7111111111111111111111111111111111111111115 = bArr41;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111115, 0, bArr7111111111111111111111111111111111111111114, length111111111111111111111111111111111111111111111111, bArr7111111111111111111111111111111111111111115.length);
                    int length111111111111111111111111111111111111111111111112 = length111111111111111111111111111111111111111111111111 + bArr7111111111111111111111111111111111111111115.length;
                    byte[] bArr7111111111111111111111111111111111111111116 = bArr8;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111116, 0, bArr7111111111111111111111111111111111111111114, length111111111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111111116.length);
                    int length111111111111111111111111111111111111111111111113 = length111111111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111111116.length;
                    byte[] bArr7111111111111111111111111111111111111111117 = bArr30;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111117, 0, bArr7111111111111111111111111111111111111111114, length111111111111111111111111111111111111111111111113, bArr7111111111111111111111111111111111111111117.length);
                    int length111111111111111111111111111111111111111111111114 = length111111111111111111111111111111111111111111111113 + bArr7111111111111111111111111111111111111111117.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr7111111111111111111111111111111111111111114, length111111111111111111111111111111111111111111111114, bArr42.length);
                    int length111111111111111111111111111111111111111111111115 = length111111111111111111111111111111111111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr7111111111111111111111111111111111111111114, length111111111111111111111111111111111111111111111115, bArr43.length);
                    int length111111111111111111111111111111111111111111111116 = length111111111111111111111111111111111111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr7111111111111111111111111111111111111111114, length111111111111111111111111111111111111111111111116, bArr44.length);
                    int length111111111111111111111111111111111111111111111117 = length111111111111111111111111111111111111111111111116 + bArr44.length;
                    byte[] bArr7111111111111111111111111111111111111111118 = bArr29;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111118, 0, bArr7111111111111111111111111111111111111111114, length111111111111111111111111111111111111111111111117, bArr7111111111111111111111111111111111111111118.length);
                    int length111111111111111111111111111111111111111111111118 = length111111111111111111111111111111111111111111111117 + bArr7111111111111111111111111111111111111111118.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr7111111111111111111111111111111111111111114, length111111111111111111111111111111111111111111111118, bArr45.length);
                    int length111111111111111111111111111111111111111111111119 = length111111111111111111111111111111111111111111111118 + bArr45.length;
                    byte[] bArr7111111111111111111111111111111111111111119 = bArr13;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111119, 0, bArr7111111111111111111111111111111111111111114, length111111111111111111111111111111111111111111111119, bArr7111111111111111111111111111111111111111119.length);
                    int length211111111111111111111111111111111111111111111110 = length111111111111111111111111111111111111111111111119 + bArr7111111111111111111111111111111111111111119.length;
                    java.lang.System.arraycopy(bArr611111111111111111111111111114, 0, bArr7111111111111111111111111111111111111111114, length211111111111111111111111111111111111111111111110, bArr611111111111111111111111111114.length);
                    int length211111111111111111111111111111111111111111111111 = length211111111111111111111111111111111111111111111110 + bArr611111111111111111111111111114.length;
                    java.lang.System.arraycopy(bArr611111111111111111111111111115, 0, bArr7111111111111111111111111111111111111111114, length211111111111111111111111111111111111111111111111, bArr611111111111111111111111111115.length);
                    int length211111111111111111111111111111111111111111111112 = length211111111111111111111111111111111111111111111111 + bArr611111111111111111111111111115.length;
                    byte[] bArr71111111111111111111111111111111111111111110 = bArr16;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111110, 0, bArr7111111111111111111111111111111111111111114, length211111111111111111111111111111111111111111111112, bArr71111111111111111111111111111111111111111110.length);
                    int length211111111111111111111111111111111111111111111113 = length211111111111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111111111110.length;
                    byte[] bArr71111111111111111111111111111111111111111111 = bArr19;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111, 0, bArr7111111111111111111111111111111111111111114, length211111111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111111111111.length);
                    int length211111111111111111111111111111111111111111111114 = length211111111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111111111111.length;
                    byte[] bArr71111111111111111111111111111111111111111112 = bArr22;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111112, 0, bArr7111111111111111111111111111111111111111114, length211111111111111111111111111111111111111111111114, bArr71111111111111111111111111111111111111111112.length);
                    int length211111111111111111111111111111111111111111111115 = length211111111111111111111111111111111111111111111114 + bArr71111111111111111111111111111111111111111112.length;
                    java.lang.System.arraycopy(bArr5111113, 0, bArr7111111111111111111111111111111111111111114, length211111111111111111111111111111111111111111111115, bArr5111113.length);
                    int length211111111111111111111111111111111111111111111116 = length211111111111111111111111111111111111111111111115 + bArr5111113.length;
                    java.lang.System.arraycopy(bArr62111111111111111112, 0, bArr7111111111111111111111111111111111111111114, length211111111111111111111111111111111111111111111116, bArr62111111111111111112.length);
                    int length211111111111111111111111111111111111111111111117 = length211111111111111111111111111111111111111111111116 + bArr62111111111111111112.length;
                    java.lang.System.arraycopy(bArr611111111111111111111111111111, 0, bArr7111111111111111111111111111111111111111114, length211111111111111111111111111111111111111111111117, bArr611111111111111111111111111111.length);
                    java.lang.System.arraycopy(bArr611111111111111111111111111113, 0, bArr7111111111111111111111111111111111111111114, length211111111111111111111111111111111111111111111117 + bArr611111111111111111111111111111.length, bArr611111111111111111111111111113.length);
                    int length211111111111111111111111111111111111111111111118 = bArr611111111111111111111111111113.length;
                    return a(a(bArr7111111111111111111111111111111111111111114, this.u, i1111111), this.y, this.A, this.B);
                }
                bArr22 = bArr20;
                bArr23 = bArr57;
                bArr24 = oicq.wlogin_sdk.request.t.R;
                if (bArr24 != null) {
                    bArr25 = bArr6;
                } else {
                    bArr25 = bArr6;
                }
                byte[] bArr5111114 = bArr23;
                byte[] bArr62111111111111111116 = bArr25;
                byte[] bArr62111111111111111117 = bArr7;
                byte[] bArr62111111111111111118 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                byte[] bArr62111111111111111119 = tlv_t142Var.get_tlv_142(bArr5);
                i13 = i12 + 1 + 1;
                str = this.x.g;
                if (str != null) {
                    i14 = i13;
                    bArr26 = bArr48;
                } else {
                    i14 = i13;
                    bArr26 = bArr48;
                }
                if (bArr3 != null) {
                    bArr27 = bArr50;
                } else {
                    bArr27 = bArr50;
                }
                if (list != null) {
                    bArr28 = bArr51;
                } else {
                    bArr28 = bArr51;
                }
                if (wloginSigInfoA == null) {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                } else {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                }
                byte[] bArr611111111111111111111111111116 = new byte[4];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111111116, 0, i11);
                tlv_tVar.set_data(bArr611111111111111111111111111116, 4);
                byte[] bArr611111111111111111111111111117 = tlv_tVar.get_buf();
                byte[] bArr611111111111111111111111111118 = new byte[6];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111111118, 0, oicq.wlogin_sdk.request.t.au);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111111111111111111118, 4, 0);
                tlv_tVar2.set_data(bArr611111111111111111111111111118, 6);
                byte[] bArr611111111111111111111111111119 = tlv_tVar2.get_buf();
                int i1111112 = i14 + 1 + 1;
                int length211111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111111111111111117.length + bArr62111111111111111118.length + bArr62111111111111111119.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                byte[] bArr6111111111111111111111111111110 = bArr10;
                byte[] bArr6111111111111111111111111111111 = bArr31;
                byte[] bArr71111111111111111111111111111111111111111113 = new byte[length211111111111111111111111111111111111111111111119 + bArr6111111111111111111111111111110.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5111114.length + bArr62111111111111111116.length + bArr611111111111111111111111111117.length + bArr611111111111111111111111111119.length];
                java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111111111111111111111111111113, 0, bArr35.length);
                int length31111111111111111111111111111111111118 = bArr35.length + 0;
                java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111111111111111111111111111113, length31111111111111111111111111111111111118, bArr36.length);
                int length31111111111111111111111111111111111119 = length31111111111111111111111111111111111118 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111111111111111111111111111113, length31111111111111111111111111111111111119, bArr37.length);
                int length311111111111111111111111111111111111110 = length31111111111111111111111111111111111119 + bArr37.length;
                java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111111111111111111111111111113, length311111111111111111111111111111111111110, bArr40.length);
                int length311111111111111111111111111111111111111 = length311111111111111111111111111111111111110 + bArr40.length;
                java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111111111111111111111111111113, length311111111111111111111111111111111111111, bArr38.length);
                int length311111111111111111111111111111111111112 = length311111111111111111111111111111111111111 + bArr38.length;
                java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111111111111111111111111111113, length311111111111111111111111111111111111112, bArr39.length);
                int length311111111111111111111111111111111111113 = length311111111111111111111111111111111111112 + bArr39.length;
                java.lang.System.arraycopy(bArr62111111111111111117, 0, bArr71111111111111111111111111111111111111111113, length311111111111111111111111111111111111113, bArr62111111111111111117.length);
                int length311111111111111111111111111111111111114 = length311111111111111111111111111111111111113 + bArr62111111111111111117.length;
                java.lang.System.arraycopy(bArr62111111111111111118, 0, bArr71111111111111111111111111111111111111111113, length311111111111111111111111111111111111114, bArr62111111111111111118.length);
                int length311111111111111111111111111111111111115 = length311111111111111111111111111111111111114 + bArr62111111111111111118.length;
                java.lang.System.arraycopy(bArr62111111111111111119, 0, bArr71111111111111111111111111111111111111111113, length311111111111111111111111111111111111115, bArr62111111111111111119.length);
                int length1111111111111111111111111111111111111111111111110 = length311111111111111111111111111111111111115 + bArr62111111111111111119.length;
                java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111111111111111111111111111113, length1111111111111111111111111111111111111111111111110, bArr26.length);
                int length1111111111111111111111111111111111111111111111111 = length1111111111111111111111111111111111111111111111110 + bArr26.length;
                byte[] bArr71111111111111111111111111111111111111111114 = bArr41;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111114, 0, bArr71111111111111111111111111111111111111111113, length1111111111111111111111111111111111111111111111111, bArr71111111111111111111111111111111111111111114.length);
                int length1111111111111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111111111111 + bArr71111111111111111111111111111111111111111114.length;
                byte[] bArr71111111111111111111111111111111111111111115 = bArr8;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111115, 0, bArr71111111111111111111111111111111111111111113, length1111111111111111111111111111111111111111111111112, bArr71111111111111111111111111111111111111111115.length);
                int length1111111111111111111111111111111111111111111111113 = length1111111111111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111111111115.length;
                byte[] bArr71111111111111111111111111111111111111111116 = bArr30;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111116, 0, bArr71111111111111111111111111111111111111111113, length1111111111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111111111116.length);
                int length1111111111111111111111111111111111111111111111114 = length1111111111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111111111116.length;
                java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111111111111111111111111111113, length1111111111111111111111111111111111111111111111114, bArr42.length);
                int length1111111111111111111111111111111111111111111111115 = length1111111111111111111111111111111111111111111111114 + bArr42.length;
                java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111111111111111111111111111113, length1111111111111111111111111111111111111111111111115, bArr43.length);
                int length1111111111111111111111111111111111111111111111116 = length1111111111111111111111111111111111111111111111115 + bArr43.length;
                java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111111111111111111111111111113, length1111111111111111111111111111111111111111111111116, bArr44.length);
                int length1111111111111111111111111111111111111111111111117 = length1111111111111111111111111111111111111111111111116 + bArr44.length;
                byte[] bArr71111111111111111111111111111111111111111117 = bArr29;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111117, 0, bArr71111111111111111111111111111111111111111113, length1111111111111111111111111111111111111111111111117, bArr71111111111111111111111111111111111111111117.length);
                int length1111111111111111111111111111111111111111111111118 = length1111111111111111111111111111111111111111111111117 + bArr71111111111111111111111111111111111111111117.length;
                java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111111111111111111111111111113, length1111111111111111111111111111111111111111111111118, bArr45.length);
                int length1111111111111111111111111111111111111111111111119 = length1111111111111111111111111111111111111111111111118 + bArr45.length;
                byte[] bArr71111111111111111111111111111111111111111118 = bArr13;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111118, 0, bArr71111111111111111111111111111111111111111113, length1111111111111111111111111111111111111111111111119, bArr71111111111111111111111111111111111111111118.length);
                int length2111111111111111111111111111111111111111111111110 = length1111111111111111111111111111111111111111111111119 + bArr71111111111111111111111111111111111111111118.length;
                java.lang.System.arraycopy(bArr6111111111111111111111111111110, 0, bArr71111111111111111111111111111111111111111113, length2111111111111111111111111111111111111111111111110, bArr6111111111111111111111111111110.length);
                int length2111111111111111111111111111111111111111111111111 = length2111111111111111111111111111111111111111111111110 + bArr6111111111111111111111111111110.length;
                java.lang.System.arraycopy(bArr6111111111111111111111111111111, 0, bArr71111111111111111111111111111111111111111113, length2111111111111111111111111111111111111111111111111, bArr6111111111111111111111111111111.length);
                int length2111111111111111111111111111111111111111111111112 = length2111111111111111111111111111111111111111111111111 + bArr6111111111111111111111111111111.length;
                byte[] bArr71111111111111111111111111111111111111111119 = bArr16;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111119, 0, bArr71111111111111111111111111111111111111111113, length2111111111111111111111111111111111111111111111112, bArr71111111111111111111111111111111111111111119.length);
                int length2111111111111111111111111111111111111111111111113 = length2111111111111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111111111119.length;
                byte[] bArr711111111111111111111111111111111111111111110 = bArr19;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111110, 0, bArr71111111111111111111111111111111111111111113, length2111111111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111111111110.length);
                int length2111111111111111111111111111111111111111111111114 = length2111111111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111111111110.length;
                byte[] bArr711111111111111111111111111111111111111111111 = bArr22;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111, 0, bArr71111111111111111111111111111111111111111113, length2111111111111111111111111111111111111111111111114, bArr711111111111111111111111111111111111111111111.length);
                int length2111111111111111111111111111111111111111111111115 = length2111111111111111111111111111111111111111111111114 + bArr711111111111111111111111111111111111111111111.length;
                java.lang.System.arraycopy(bArr5111114, 0, bArr71111111111111111111111111111111111111111113, length2111111111111111111111111111111111111111111111115, bArr5111114.length);
                int length2111111111111111111111111111111111111111111111116 = length2111111111111111111111111111111111111111111111115 + bArr5111114.length;
                java.lang.System.arraycopy(bArr62111111111111111116, 0, bArr71111111111111111111111111111111111111111113, length2111111111111111111111111111111111111111111111116, bArr62111111111111111116.length);
                int length2111111111111111111111111111111111111111111111117 = length2111111111111111111111111111111111111111111111116 + bArr62111111111111111116.length;
                java.lang.System.arraycopy(bArr611111111111111111111111111117, 0, bArr71111111111111111111111111111111111111111113, length2111111111111111111111111111111111111111111111117, bArr611111111111111111111111111117.length);
                java.lang.System.arraycopy(bArr611111111111111111111111111119, 0, bArr71111111111111111111111111111111111111111113, length2111111111111111111111111111111111111111111111117 + bArr611111111111111111111111111117.length, bArr611111111111111111111111111119.length);
                int length2111111111111111111111111111111111111111111111118 = bArr611111111111111111111111111119.length;
                return a(a(bArr71111111111111111111111111111111111111111113, this.u, i1111112), this.y, this.A, this.B);
            }
            bArr19 = bArr17;
            bArr20 = bArr56;
            bArr21 = oicq.wlogin_sdk.request.l.J;
            if (bArr21 != null) {
                bArr22 = bArr20;
                if (bArr21.length > 0) {
                    bArr41 = bArr41;
                    bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                    i12++;
                }
                bArr24 = oicq.wlogin_sdk.request.t.R;
                if (bArr24 != null) {
                    bArr25 = bArr6;
                } else {
                    bArr25 = bArr6;
                }
                byte[] bArr5111115 = bArr23;
                byte[] bArr621111111111111111110 = bArr25;
                byte[] bArr621111111111111111111 = bArr7;
                byte[] bArr621111111111111111112 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                byte[] bArr621111111111111111113 = tlv_t142Var.get_tlv_142(bArr5);
                i13 = i12 + 1 + 1;
                str = this.x.g;
                if (str != null) {
                    i14 = i13;
                    bArr26 = bArr48;
                } else {
                    i14 = i13;
                    bArr26 = bArr48;
                }
                if (bArr3 != null) {
                    bArr27 = bArr50;
                } else {
                    bArr27 = bArr50;
                }
                if (list != null) {
                    bArr28 = bArr51;
                } else {
                    bArr28 = bArr51;
                }
                if (wloginSigInfoA == null) {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                } else {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                }
                byte[] bArr6111111111111111111111111111112 = new byte[4];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111111111112, 0, i11);
                tlv_tVar.set_data(bArr6111111111111111111111111111112, 4);
                byte[] bArr6111111111111111111111111111113 = tlv_tVar.get_buf();
                byte[] bArr6111111111111111111111111111114 = new byte[6];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111111111114, 0, oicq.wlogin_sdk.request.t.au);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr6111111111111111111111111111114, 4, 0);
                tlv_tVar2.set_data(bArr6111111111111111111111111111114, 6);
                byte[] bArr6111111111111111111111111111115 = tlv_tVar2.get_buf();
                int i1111113 = i14 + 1 + 1;
                int length2111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111111111111111111.length + bArr621111111111111111112.length + bArr621111111111111111113.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                byte[] bArr6111111111111111111111111111116 = bArr10;
                byte[] bArr6111111111111111111111111111117 = bArr31;
                byte[] bArr711111111111111111111111111111111111111111112 = new byte[length2111111111111111111111111111111111111111111111119 + bArr6111111111111111111111111111116.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5111115.length + bArr621111111111111111110.length + bArr6111111111111111111111111111113.length + bArr6111111111111111111111111111115.length];
                java.lang.System.arraycopy(bArr35, 0, bArr711111111111111111111111111111111111111111112, 0, bArr35.length);
                int length311111111111111111111111111111111111116 = bArr35.length + 0;
                java.lang.System.arraycopy(bArr36, 0, bArr711111111111111111111111111111111111111111112, length311111111111111111111111111111111111116, bArr36.length);
                int length311111111111111111111111111111111111117 = length311111111111111111111111111111111111116 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr711111111111111111111111111111111111111111112, length311111111111111111111111111111111111117, bArr37.length);
                int length311111111111111111111111111111111111118 = length311111111111111111111111111111111111117 + bArr37.length;
                java.lang.System.arraycopy(bArr40, 0, bArr711111111111111111111111111111111111111111112, length311111111111111111111111111111111111118, bArr40.length);
                int length311111111111111111111111111111111111119 = length311111111111111111111111111111111111118 + bArr40.length;
                java.lang.System.arraycopy(bArr38, 0, bArr711111111111111111111111111111111111111111112, length311111111111111111111111111111111111119, bArr38.length);
                int length3111111111111111111111111111111111111110 = length311111111111111111111111111111111111119 + bArr38.length;
                java.lang.System.arraycopy(bArr39, 0, bArr711111111111111111111111111111111111111111112, length3111111111111111111111111111111111111110, bArr39.length);
                int length3111111111111111111111111111111111111111 = length3111111111111111111111111111111111111110 + bArr39.length;
                java.lang.System.arraycopy(bArr621111111111111111111, 0, bArr711111111111111111111111111111111111111111112, length3111111111111111111111111111111111111111, bArr621111111111111111111.length);
                int length3111111111111111111111111111111111111112 = length3111111111111111111111111111111111111111 + bArr621111111111111111111.length;
                java.lang.System.arraycopy(bArr621111111111111111112, 0, bArr711111111111111111111111111111111111111111112, length3111111111111111111111111111111111111112, bArr621111111111111111112.length);
                int length3111111111111111111111111111111111111113 = length3111111111111111111111111111111111111112 + bArr621111111111111111112.length;
                java.lang.System.arraycopy(bArr621111111111111111113, 0, bArr711111111111111111111111111111111111111111112, length3111111111111111111111111111111111111113, bArr621111111111111111113.length);
                int length11111111111111111111111111111111111111111111111110 = length3111111111111111111111111111111111111113 + bArr621111111111111111113.length;
                java.lang.System.arraycopy(bArr26, 0, bArr711111111111111111111111111111111111111111112, length11111111111111111111111111111111111111111111111110, bArr26.length);
                int length11111111111111111111111111111111111111111111111111 = length11111111111111111111111111111111111111111111111110 + bArr26.length;
                byte[] bArr711111111111111111111111111111111111111111113 = bArr41;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111113, 0, bArr711111111111111111111111111111111111111111112, length11111111111111111111111111111111111111111111111111, bArr711111111111111111111111111111111111111111113.length);
                int length11111111111111111111111111111111111111111111111112 = length11111111111111111111111111111111111111111111111111 + bArr711111111111111111111111111111111111111111113.length;
                byte[] bArr711111111111111111111111111111111111111111114 = bArr8;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111114, 0, bArr711111111111111111111111111111111111111111112, length11111111111111111111111111111111111111111111111112, bArr711111111111111111111111111111111111111111114.length);
                int length11111111111111111111111111111111111111111111111113 = length11111111111111111111111111111111111111111111111112 + bArr711111111111111111111111111111111111111111114.length;
                byte[] bArr711111111111111111111111111111111111111111115 = bArr30;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111115, 0, bArr711111111111111111111111111111111111111111112, length11111111111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111111111115.length);
                int length11111111111111111111111111111111111111111111111114 = length11111111111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111111111115.length;
                java.lang.System.arraycopy(bArr42, 0, bArr711111111111111111111111111111111111111111112, length11111111111111111111111111111111111111111111111114, bArr42.length);
                int length11111111111111111111111111111111111111111111111115 = length11111111111111111111111111111111111111111111111114 + bArr42.length;
                java.lang.System.arraycopy(bArr43, 0, bArr711111111111111111111111111111111111111111112, length11111111111111111111111111111111111111111111111115, bArr43.length);
                int length11111111111111111111111111111111111111111111111116 = length11111111111111111111111111111111111111111111111115 + bArr43.length;
                java.lang.System.arraycopy(bArr44, 0, bArr711111111111111111111111111111111111111111112, length11111111111111111111111111111111111111111111111116, bArr44.length);
                int length11111111111111111111111111111111111111111111111117 = length11111111111111111111111111111111111111111111111116 + bArr44.length;
                byte[] bArr711111111111111111111111111111111111111111116 = bArr29;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111116, 0, bArr711111111111111111111111111111111111111111112, length11111111111111111111111111111111111111111111111117, bArr711111111111111111111111111111111111111111116.length);
                int length11111111111111111111111111111111111111111111111118 = length11111111111111111111111111111111111111111111111117 + bArr711111111111111111111111111111111111111111116.length;
                java.lang.System.arraycopy(bArr45, 0, bArr711111111111111111111111111111111111111111112, length11111111111111111111111111111111111111111111111118, bArr45.length);
                int length11111111111111111111111111111111111111111111111119 = length11111111111111111111111111111111111111111111111118 + bArr45.length;
                byte[] bArr711111111111111111111111111111111111111111117 = bArr13;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111117, 0, bArr711111111111111111111111111111111111111111112, length11111111111111111111111111111111111111111111111119, bArr711111111111111111111111111111111111111111117.length);
                int length21111111111111111111111111111111111111111111111110 = length11111111111111111111111111111111111111111111111119 + bArr711111111111111111111111111111111111111111117.length;
                java.lang.System.arraycopy(bArr6111111111111111111111111111116, 0, bArr711111111111111111111111111111111111111111112, length21111111111111111111111111111111111111111111111110, bArr6111111111111111111111111111116.length);
                int length21111111111111111111111111111111111111111111111111 = length21111111111111111111111111111111111111111111111110 + bArr6111111111111111111111111111116.length;
                java.lang.System.arraycopy(bArr6111111111111111111111111111117, 0, bArr711111111111111111111111111111111111111111112, length21111111111111111111111111111111111111111111111111, bArr6111111111111111111111111111117.length);
                int length21111111111111111111111111111111111111111111111112 = length21111111111111111111111111111111111111111111111111 + bArr6111111111111111111111111111117.length;
                byte[] bArr711111111111111111111111111111111111111111118 = bArr16;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111118, 0, bArr711111111111111111111111111111111111111111112, length21111111111111111111111111111111111111111111111112, bArr711111111111111111111111111111111111111111118.length);
                int length21111111111111111111111111111111111111111111111113 = length21111111111111111111111111111111111111111111111112 + bArr711111111111111111111111111111111111111111118.length;
                byte[] bArr711111111111111111111111111111111111111111119 = bArr19;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111119, 0, bArr711111111111111111111111111111111111111111112, length21111111111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111111111119.length);
                int length21111111111111111111111111111111111111111111111114 = length21111111111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111111111119.length;
                byte[] bArr7111111111111111111111111111111111111111111110 = bArr22;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111110, 0, bArr711111111111111111111111111111111111111111112, length21111111111111111111111111111111111111111111111114, bArr7111111111111111111111111111111111111111111110.length);
                int length21111111111111111111111111111111111111111111111115 = length21111111111111111111111111111111111111111111111114 + bArr7111111111111111111111111111111111111111111110.length;
                java.lang.System.arraycopy(bArr5111115, 0, bArr711111111111111111111111111111111111111111112, length21111111111111111111111111111111111111111111111115, bArr5111115.length);
                int length21111111111111111111111111111111111111111111111116 = length21111111111111111111111111111111111111111111111115 + bArr5111115.length;
                java.lang.System.arraycopy(bArr621111111111111111110, 0, bArr711111111111111111111111111111111111111111112, length21111111111111111111111111111111111111111111111116, bArr621111111111111111110.length);
                int length21111111111111111111111111111111111111111111111117 = length21111111111111111111111111111111111111111111111116 + bArr621111111111111111110.length;
                java.lang.System.arraycopy(bArr6111111111111111111111111111113, 0, bArr711111111111111111111111111111111111111111112, length21111111111111111111111111111111111111111111111117, bArr6111111111111111111111111111113.length);
                java.lang.System.arraycopy(bArr6111111111111111111111111111115, 0, bArr711111111111111111111111111111111111111111112, length21111111111111111111111111111111111111111111111117 + bArr6111111111111111111111111111113.length, bArr6111111111111111111111111111115.length);
                int length21111111111111111111111111111111111111111111111118 = bArr6111111111111111111111111111115.length;
                return a(a(bArr711111111111111111111111111111111111111111112, this.u, i1111113), this.y, this.A, this.B);
            }
            bArr22 = bArr20;
            bArr23 = bArr57;
            bArr24 = oicq.wlogin_sdk.request.t.R;
            if (bArr24 != null) {
                bArr25 = bArr6;
            } else {
                bArr25 = bArr6;
            }
            byte[] bArr5111116 = bArr23;
            byte[] bArr621111111111111111114 = bArr25;
            byte[] bArr621111111111111111115 = bArr7;
            byte[] bArr621111111111111111116 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
            byte[] bArr621111111111111111117 = tlv_t142Var.get_tlv_142(bArr5);
            i13 = i12 + 1 + 1;
            str = this.x.g;
            if (str != null) {
                i14 = i13;
                bArr26 = bArr48;
            } else {
                i14 = i13;
                bArr26 = bArr48;
            }
            if (bArr3 != null) {
                bArr27 = bArr50;
            } else {
                bArr27 = bArr50;
            }
            if (list != null) {
                bArr28 = bArr51;
            } else {
                bArr28 = bArr51;
            }
            if (wloginSigInfoA == null) {
                bArr29 = bArr28;
                bArr30 = bArr27;
                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                bArr31 = bArr53;
            } else {
                bArr29 = bArr28;
                bArr30 = bArr27;
                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                bArr31 = bArr53;
            }
            byte[] bArr6111111111111111111111111111118 = new byte[4];
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111111111118, 0, i11);
            tlv_tVar.set_data(bArr6111111111111111111111111111118, 4);
            byte[] bArr6111111111111111111111111111119 = tlv_tVar.get_buf();
            byte[] bArr61111111111111111111111111111110 = new byte[6];
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111111111110, 0, oicq.wlogin_sdk.request.t.au);
            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111111111111111111110, 4, 0);
            tlv_tVar2.set_data(bArr61111111111111111111111111111110, 6);
            byte[] bArr61111111111111111111111111111111 = tlv_tVar2.get_buf();
            int i1111114 = i14 + 1 + 1;
            int length21111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111111111111111115.length + bArr621111111111111111116.length + bArr621111111111111111117.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
            byte[] bArr61111111111111111111111111111112 = bArr10;
            byte[] bArr61111111111111111111111111111113 = bArr31;
            byte[] bArr7111111111111111111111111111111111111111111111 = new byte[length21111111111111111111111111111111111111111111111119 + bArr61111111111111111111111111111112.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5111116.length + bArr621111111111111111114.length + bArr6111111111111111111111111111119.length + bArr61111111111111111111111111111111.length];
            java.lang.System.arraycopy(bArr35, 0, bArr7111111111111111111111111111111111111111111111, 0, bArr35.length);
            int length3111111111111111111111111111111111111114 = bArr35.length + 0;
            java.lang.System.arraycopy(bArr36, 0, bArr7111111111111111111111111111111111111111111111, length3111111111111111111111111111111111111114, bArr36.length);
            int length3111111111111111111111111111111111111115 = length3111111111111111111111111111111111111114 + bArr36.length;
            java.lang.System.arraycopy(bArr37, 0, bArr7111111111111111111111111111111111111111111111, length3111111111111111111111111111111111111115, bArr37.length);
            int length3111111111111111111111111111111111111116 = length3111111111111111111111111111111111111115 + bArr37.length;
            java.lang.System.arraycopy(bArr40, 0, bArr7111111111111111111111111111111111111111111111, length3111111111111111111111111111111111111116, bArr40.length);
            int length3111111111111111111111111111111111111117 = length3111111111111111111111111111111111111116 + bArr40.length;
            java.lang.System.arraycopy(bArr38, 0, bArr7111111111111111111111111111111111111111111111, length3111111111111111111111111111111111111117, bArr38.length);
            int length3111111111111111111111111111111111111118 = length3111111111111111111111111111111111111117 + bArr38.length;
            java.lang.System.arraycopy(bArr39, 0, bArr7111111111111111111111111111111111111111111111, length3111111111111111111111111111111111111118, bArr39.length);
            int length3111111111111111111111111111111111111119 = length3111111111111111111111111111111111111118 + bArr39.length;
            java.lang.System.arraycopy(bArr621111111111111111115, 0, bArr7111111111111111111111111111111111111111111111, length3111111111111111111111111111111111111119, bArr621111111111111111115.length);
            int length31111111111111111111111111111111111111110 = length3111111111111111111111111111111111111119 + bArr621111111111111111115.length;
            java.lang.System.arraycopy(bArr621111111111111111116, 0, bArr7111111111111111111111111111111111111111111111, length31111111111111111111111111111111111111110, bArr621111111111111111116.length);
            int length31111111111111111111111111111111111111111 = length31111111111111111111111111111111111111110 + bArr621111111111111111116.length;
            java.lang.System.arraycopy(bArr621111111111111111117, 0, bArr7111111111111111111111111111111111111111111111, length31111111111111111111111111111111111111111, bArr621111111111111111117.length);
            int length111111111111111111111111111111111111111111111111110 = length31111111111111111111111111111111111111111 + bArr621111111111111111117.length;
            java.lang.System.arraycopy(bArr26, 0, bArr7111111111111111111111111111111111111111111111, length111111111111111111111111111111111111111111111111110, bArr26.length);
            int length111111111111111111111111111111111111111111111111111 = length111111111111111111111111111111111111111111111111110 + bArr26.length;
            byte[] bArr7111111111111111111111111111111111111111111112 = bArr41;
            java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111112, 0, bArr7111111111111111111111111111111111111111111111, length111111111111111111111111111111111111111111111111111, bArr7111111111111111111111111111111111111111111112.length);
            int length111111111111111111111111111111111111111111111111112 = length111111111111111111111111111111111111111111111111111 + bArr7111111111111111111111111111111111111111111112.length;
            byte[] bArr7111111111111111111111111111111111111111111113 = bArr8;
            java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111113, 0, bArr7111111111111111111111111111111111111111111111, length111111111111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111111111113.length);
            int length111111111111111111111111111111111111111111111111113 = length111111111111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111111111113.length;
            byte[] bArr7111111111111111111111111111111111111111111114 = bArr30;
            java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111114, 0, bArr7111111111111111111111111111111111111111111111, length111111111111111111111111111111111111111111111111113, bArr7111111111111111111111111111111111111111111114.length);
            int length111111111111111111111111111111111111111111111111114 = length111111111111111111111111111111111111111111111111113 + bArr7111111111111111111111111111111111111111111114.length;
            java.lang.System.arraycopy(bArr42, 0, bArr7111111111111111111111111111111111111111111111, length111111111111111111111111111111111111111111111111114, bArr42.length);
            int length111111111111111111111111111111111111111111111111115 = length111111111111111111111111111111111111111111111111114 + bArr42.length;
            java.lang.System.arraycopy(bArr43, 0, bArr7111111111111111111111111111111111111111111111, length111111111111111111111111111111111111111111111111115, bArr43.length);
            int length111111111111111111111111111111111111111111111111116 = length111111111111111111111111111111111111111111111111115 + bArr43.length;
            java.lang.System.arraycopy(bArr44, 0, bArr7111111111111111111111111111111111111111111111, length111111111111111111111111111111111111111111111111116, bArr44.length);
            int length111111111111111111111111111111111111111111111111117 = length111111111111111111111111111111111111111111111111116 + bArr44.length;
            byte[] bArr7111111111111111111111111111111111111111111115 = bArr29;
            java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111115, 0, bArr7111111111111111111111111111111111111111111111, length111111111111111111111111111111111111111111111111117, bArr7111111111111111111111111111111111111111111115.length);
            int length111111111111111111111111111111111111111111111111118 = length111111111111111111111111111111111111111111111111117 + bArr7111111111111111111111111111111111111111111115.length;
            java.lang.System.arraycopy(bArr45, 0, bArr7111111111111111111111111111111111111111111111, length111111111111111111111111111111111111111111111111118, bArr45.length);
            int length111111111111111111111111111111111111111111111111119 = length111111111111111111111111111111111111111111111111118 + bArr45.length;
            byte[] bArr7111111111111111111111111111111111111111111116 = bArr13;
            java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111116, 0, bArr7111111111111111111111111111111111111111111111, length111111111111111111111111111111111111111111111111119, bArr7111111111111111111111111111111111111111111116.length);
            int length211111111111111111111111111111111111111111111111110 = length111111111111111111111111111111111111111111111111119 + bArr7111111111111111111111111111111111111111111116.length;
            java.lang.System.arraycopy(bArr61111111111111111111111111111112, 0, bArr7111111111111111111111111111111111111111111111, length211111111111111111111111111111111111111111111111110, bArr61111111111111111111111111111112.length);
            int length211111111111111111111111111111111111111111111111111 = length211111111111111111111111111111111111111111111111110 + bArr61111111111111111111111111111112.length;
            java.lang.System.arraycopy(bArr61111111111111111111111111111113, 0, bArr7111111111111111111111111111111111111111111111, length211111111111111111111111111111111111111111111111111, bArr61111111111111111111111111111113.length);
            int length211111111111111111111111111111111111111111111111112 = length211111111111111111111111111111111111111111111111111 + bArr61111111111111111111111111111113.length;
            byte[] bArr7111111111111111111111111111111111111111111117 = bArr16;
            java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111117, 0, bArr7111111111111111111111111111111111111111111111, length211111111111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111111111117.length);
            int length211111111111111111111111111111111111111111111111113 = length211111111111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111111111117.length;
            byte[] bArr7111111111111111111111111111111111111111111118 = bArr19;
            java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111118, 0, bArr7111111111111111111111111111111111111111111111, length211111111111111111111111111111111111111111111111113, bArr7111111111111111111111111111111111111111111118.length);
            int length211111111111111111111111111111111111111111111111114 = length211111111111111111111111111111111111111111111111113 + bArr7111111111111111111111111111111111111111111118.length;
            byte[] bArr7111111111111111111111111111111111111111111119 = bArr22;
            java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111119, 0, bArr7111111111111111111111111111111111111111111111, length211111111111111111111111111111111111111111111111114, bArr7111111111111111111111111111111111111111111119.length);
            int length211111111111111111111111111111111111111111111111115 = length211111111111111111111111111111111111111111111111114 + bArr7111111111111111111111111111111111111111111119.length;
            java.lang.System.arraycopy(bArr5111116, 0, bArr7111111111111111111111111111111111111111111111, length211111111111111111111111111111111111111111111111115, bArr5111116.length);
            int length211111111111111111111111111111111111111111111111116 = length211111111111111111111111111111111111111111111111115 + bArr5111116.length;
            java.lang.System.arraycopy(bArr621111111111111111114, 0, bArr7111111111111111111111111111111111111111111111, length211111111111111111111111111111111111111111111111116, bArr621111111111111111114.length);
            int length211111111111111111111111111111111111111111111111117 = length211111111111111111111111111111111111111111111111116 + bArr621111111111111111114.length;
            java.lang.System.arraycopy(bArr6111111111111111111111111111119, 0, bArr7111111111111111111111111111111111111111111111, length211111111111111111111111111111111111111111111111117, bArr6111111111111111111111111111119.length);
            java.lang.System.arraycopy(bArr61111111111111111111111111111111, 0, bArr7111111111111111111111111111111111111111111111, length211111111111111111111111111111111111111111111111117 + bArr6111111111111111111111111111119.length, bArr61111111111111111111111111111111.length);
            int length211111111111111111111111111111111111111111111111118 = bArr61111111111111111111111111111111.length;
            return a(a(bArr7111111111111111111111111111111111111111111111, this.u, i1111114), this.y, this.A, this.B);
        }
        bArr10 = bArr46;
        bArr11 = bArr52;
        bArr12 = oicq.wlogin_sdk.request.t.N;
        if (bArr12 != null) {
            bArr13 = bArr11;
            if (bArr12.length > 0) {
                bArr14 = tlv_t187Var.get_tlv_187(bArr12);
                i12++;
            }
            bArr15 = oicq.wlogin_sdk.request.t.O;
            if (bArr15 != null) {
                bArr16 = bArr14;
                if (bArr15.length > 0) {
                    bArr17 = tlv_t188Var.get_tlv_188(bArr15);
                    i12++;
                }
                bArr18 = oicq.wlogin_sdk.request.t.L;
                if (bArr18 != null) {
                    bArr19 = bArr17;
                    if (bArr18.length > 0) {
                        bArr20 = tlv_t194Var.get_tlv_194(bArr18);
                        i12++;
                    }
                    bArr21 = oicq.wlogin_sdk.request.l.J;
                    if (bArr21 != null) {
                        bArr22 = bArr20;
                        if (bArr21.length > 0) {
                            bArr41 = bArr41;
                            bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                            i12++;
                        }
                        bArr24 = oicq.wlogin_sdk.request.t.R;
                        if (bArr24 != null) {
                            bArr25 = bArr6;
                        } else {
                            bArr25 = bArr6;
                        }
                        byte[] bArr5111117 = bArr23;
                        byte[] bArr621111111111111111118 = bArr25;
                        byte[] bArr621111111111111111119 = bArr7;
                        byte[] bArr6211111111111111111110 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                        byte[] bArr6211111111111111111111 = tlv_t142Var.get_tlv_142(bArr5);
                        i13 = i12 + 1 + 1;
                        str = this.x.g;
                        if (str != null) {
                            i14 = i13;
                            bArr26 = bArr48;
                        } else {
                            i14 = i13;
                            bArr26 = bArr48;
                        }
                        if (bArr3 != null) {
                            bArr27 = bArr50;
                        } else {
                            bArr27 = bArr50;
                        }
                        if (list != null) {
                            bArr28 = bArr51;
                        } else {
                            bArr28 = bArr51;
                        }
                        if (wloginSigInfoA == null) {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        } else {
                            bArr29 = bArr28;
                            bArr30 = bArr27;
                            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                            bArr31 = bArr53;
                        }
                        byte[] bArr61111111111111111111111111111114 = new byte[4];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111111111114, 0, i11);
                        tlv_tVar.set_data(bArr61111111111111111111111111111114, 4);
                        byte[] bArr61111111111111111111111111111115 = tlv_tVar.get_buf();
                        byte[] bArr61111111111111111111111111111116 = new byte[6];
                        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111111111116, 0, oicq.wlogin_sdk.request.t.au);
                        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111111111111111111116, 4, 0);
                        tlv_tVar2.set_data(bArr61111111111111111111111111111116, 6);
                        byte[] bArr61111111111111111111111111111117 = tlv_tVar2.get_buf();
                        int i1111115 = i14 + 1 + 1;
                        int length211111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111111111111111119.length + bArr6211111111111111111110.length + bArr6211111111111111111111.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                        byte[] bArr61111111111111111111111111111118 = bArr10;
                        byte[] bArr61111111111111111111111111111119 = bArr31;
                        byte[] bArr71111111111111111111111111111111111111111111110 = new byte[length211111111111111111111111111111111111111111111111119 + bArr61111111111111111111111111111118.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5111117.length + bArr621111111111111111118.length + bArr61111111111111111111111111111115.length + bArr61111111111111111111111111111117.length];
                        java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111111111111111111111111111111110, 0, bArr35.length);
                        int length31111111111111111111111111111111111111112 = bArr35.length + 0;
                        java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111111111111111111111111111111110, length31111111111111111111111111111111111111112, bArr36.length);
                        int length31111111111111111111111111111111111111113 = length31111111111111111111111111111111111111112 + bArr36.length;
                        java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111111111111111111111111111111110, length31111111111111111111111111111111111111113, bArr37.length);
                        int length31111111111111111111111111111111111111114 = length31111111111111111111111111111111111111113 + bArr37.length;
                        java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111111111111111111111111111111110, length31111111111111111111111111111111111111114, bArr40.length);
                        int length31111111111111111111111111111111111111115 = length31111111111111111111111111111111111111114 + bArr40.length;
                        java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111111111111111111111111111111110, length31111111111111111111111111111111111111115, bArr38.length);
                        int length31111111111111111111111111111111111111116 = length31111111111111111111111111111111111111115 + bArr38.length;
                        java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111111111111111111111111111111110, length31111111111111111111111111111111111111116, bArr39.length);
                        int length31111111111111111111111111111111111111117 = length31111111111111111111111111111111111111116 + bArr39.length;
                        java.lang.System.arraycopy(bArr621111111111111111119, 0, bArr71111111111111111111111111111111111111111111110, length31111111111111111111111111111111111111117, bArr621111111111111111119.length);
                        int length31111111111111111111111111111111111111118 = length31111111111111111111111111111111111111117 + bArr621111111111111111119.length;
                        java.lang.System.arraycopy(bArr6211111111111111111110, 0, bArr71111111111111111111111111111111111111111111110, length31111111111111111111111111111111111111118, bArr6211111111111111111110.length);
                        int length31111111111111111111111111111111111111119 = length31111111111111111111111111111111111111118 + bArr6211111111111111111110.length;
                        java.lang.System.arraycopy(bArr6211111111111111111111, 0, bArr71111111111111111111111111111111111111111111110, length31111111111111111111111111111111111111119, bArr6211111111111111111111.length);
                        int length1111111111111111111111111111111111111111111111111110 = length31111111111111111111111111111111111111119 + bArr6211111111111111111111.length;
                        java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111111111111111111111111111111110, length1111111111111111111111111111111111111111111111111110, bArr26.length);
                        int length1111111111111111111111111111111111111111111111111111 = length1111111111111111111111111111111111111111111111111110 + bArr26.length;
                        byte[] bArr71111111111111111111111111111111111111111111111 = bArr41;
                        java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111, 0, bArr71111111111111111111111111111111111111111111110, length1111111111111111111111111111111111111111111111111111, bArr71111111111111111111111111111111111111111111111.length);
                        int length1111111111111111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111111111111111 + bArr71111111111111111111111111111111111111111111111.length;
                        byte[] bArr71111111111111111111111111111111111111111111112 = bArr8;
                        java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111112, 0, bArr71111111111111111111111111111111111111111111110, length1111111111111111111111111111111111111111111111111112, bArr71111111111111111111111111111111111111111111112.length);
                        int length1111111111111111111111111111111111111111111111111113 = length1111111111111111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111111111111112.length;
                        byte[] bArr71111111111111111111111111111111111111111111113 = bArr30;
                        java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111113, 0, bArr71111111111111111111111111111111111111111111110, length1111111111111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111111111111113.length);
                        int length1111111111111111111111111111111111111111111111111114 = length1111111111111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111111111111113.length;
                        java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111111111111111111111111111111110, length1111111111111111111111111111111111111111111111111114, bArr42.length);
                        int length1111111111111111111111111111111111111111111111111115 = length1111111111111111111111111111111111111111111111111114 + bArr42.length;
                        java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111111111111111111111111111111110, length1111111111111111111111111111111111111111111111111115, bArr43.length);
                        int length1111111111111111111111111111111111111111111111111116 = length1111111111111111111111111111111111111111111111111115 + bArr43.length;
                        java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111111111111111111111111111111110, length1111111111111111111111111111111111111111111111111116, bArr44.length);
                        int length1111111111111111111111111111111111111111111111111117 = length1111111111111111111111111111111111111111111111111116 + bArr44.length;
                        byte[] bArr71111111111111111111111111111111111111111111114 = bArr29;
                        java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111114, 0, bArr71111111111111111111111111111111111111111111110, length1111111111111111111111111111111111111111111111111117, bArr71111111111111111111111111111111111111111111114.length);
                        int length1111111111111111111111111111111111111111111111111118 = length1111111111111111111111111111111111111111111111111117 + bArr71111111111111111111111111111111111111111111114.length;
                        java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111111111111111111111111111111110, length1111111111111111111111111111111111111111111111111118, bArr45.length);
                        int length1111111111111111111111111111111111111111111111111119 = length1111111111111111111111111111111111111111111111111118 + bArr45.length;
                        byte[] bArr71111111111111111111111111111111111111111111115 = bArr13;
                        java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111115, 0, bArr71111111111111111111111111111111111111111111110, length1111111111111111111111111111111111111111111111111119, bArr71111111111111111111111111111111111111111111115.length);
                        int length2111111111111111111111111111111111111111111111111110 = length1111111111111111111111111111111111111111111111111119 + bArr71111111111111111111111111111111111111111111115.length;
                        java.lang.System.arraycopy(bArr61111111111111111111111111111118, 0, bArr71111111111111111111111111111111111111111111110, length2111111111111111111111111111111111111111111111111110, bArr61111111111111111111111111111118.length);
                        int length2111111111111111111111111111111111111111111111111111 = length2111111111111111111111111111111111111111111111111110 + bArr61111111111111111111111111111118.length;
                        java.lang.System.arraycopy(bArr61111111111111111111111111111119, 0, bArr71111111111111111111111111111111111111111111110, length2111111111111111111111111111111111111111111111111111, bArr61111111111111111111111111111119.length);
                        int length2111111111111111111111111111111111111111111111111112 = length2111111111111111111111111111111111111111111111111111 + bArr61111111111111111111111111111119.length;
                        byte[] bArr71111111111111111111111111111111111111111111116 = bArr16;
                        java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111116, 0, bArr71111111111111111111111111111111111111111111110, length2111111111111111111111111111111111111111111111111112, bArr71111111111111111111111111111111111111111111116.length);
                        int length2111111111111111111111111111111111111111111111111113 = length2111111111111111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111111111111116.length;
                        byte[] bArr71111111111111111111111111111111111111111111117 = bArr19;
                        java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111117, 0, bArr71111111111111111111111111111111111111111111110, length2111111111111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111111111111117.length);
                        int length2111111111111111111111111111111111111111111111111114 = length2111111111111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111111111111117.length;
                        byte[] bArr71111111111111111111111111111111111111111111118 = bArr22;
                        java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111118, 0, bArr71111111111111111111111111111111111111111111110, length2111111111111111111111111111111111111111111111111114, bArr71111111111111111111111111111111111111111111118.length);
                        int length2111111111111111111111111111111111111111111111111115 = length2111111111111111111111111111111111111111111111111114 + bArr71111111111111111111111111111111111111111111118.length;
                        java.lang.System.arraycopy(bArr5111117, 0, bArr71111111111111111111111111111111111111111111110, length2111111111111111111111111111111111111111111111111115, bArr5111117.length);
                        int length2111111111111111111111111111111111111111111111111116 = length2111111111111111111111111111111111111111111111111115 + bArr5111117.length;
                        java.lang.System.arraycopy(bArr621111111111111111118, 0, bArr71111111111111111111111111111111111111111111110, length2111111111111111111111111111111111111111111111111116, bArr621111111111111111118.length);
                        int length2111111111111111111111111111111111111111111111111117 = length2111111111111111111111111111111111111111111111111116 + bArr621111111111111111118.length;
                        java.lang.System.arraycopy(bArr61111111111111111111111111111115, 0, bArr71111111111111111111111111111111111111111111110, length2111111111111111111111111111111111111111111111111117, bArr61111111111111111111111111111115.length);
                        java.lang.System.arraycopy(bArr61111111111111111111111111111117, 0, bArr71111111111111111111111111111111111111111111110, length2111111111111111111111111111111111111111111111111117 + bArr61111111111111111111111111111115.length, bArr61111111111111111111111111111117.length);
                        int length2111111111111111111111111111111111111111111111111118 = bArr61111111111111111111111111111117.length;
                        return a(a(bArr71111111111111111111111111111111111111111111110, this.u, i1111115), this.y, this.A, this.B);
                    }
                    bArr22 = bArr20;
                    bArr23 = bArr57;
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr5111118 = bArr23;
                    byte[] bArr6211111111111111111112 = bArr25;
                    byte[] bArr6211111111111111111113 = bArr7;
                    byte[] bArr6211111111111111111114 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr6211111111111111111115 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr611111111111111111111111111111110 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111111111110, 0, i11);
                    tlv_tVar.set_data(bArr611111111111111111111111111111110, 4);
                    byte[] bArr611111111111111111111111111111111 = tlv_tVar.get_buf();
                    byte[] bArr611111111111111111111111111111112 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111111111112, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111111111111111111111112, 4, 0);
                    tlv_tVar2.set_data(bArr611111111111111111111111111111112, 6);
                    byte[] bArr611111111111111111111111111111113 = tlv_tVar2.get_buf();
                    int i1111116 = i14 + 1 + 1;
                    int length2111111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211111111111111111113.length + bArr6211111111111111111114.length + bArr6211111111111111111115.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr611111111111111111111111111111114 = bArr10;
                    byte[] bArr611111111111111111111111111111115 = bArr31;
                    byte[] bArr71111111111111111111111111111111111111111111119 = new byte[length2111111111111111111111111111111111111111111111111119 + bArr611111111111111111111111111111114.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5111118.length + bArr6211111111111111111112.length + bArr611111111111111111111111111111111.length + bArr611111111111111111111111111111113.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111111111111111111111111111111119, 0, bArr35.length);
                    int length311111111111111111111111111111111111111110 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111111111111111111111111111111119, length311111111111111111111111111111111111111110, bArr36.length);
                    int length311111111111111111111111111111111111111111 = length311111111111111111111111111111111111111110 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111111111111111111111111111111119, length311111111111111111111111111111111111111111, bArr37.length);
                    int length311111111111111111111111111111111111111112 = length311111111111111111111111111111111111111111 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111111111111111111111111111111119, length311111111111111111111111111111111111111112, bArr40.length);
                    int length311111111111111111111111111111111111111113 = length311111111111111111111111111111111111111112 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111111111111111111111111111111119, length311111111111111111111111111111111111111113, bArr38.length);
                    int length311111111111111111111111111111111111111114 = length311111111111111111111111111111111111111113 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111111111111111111111111111111119, length311111111111111111111111111111111111111114, bArr39.length);
                    int length311111111111111111111111111111111111111115 = length311111111111111111111111111111111111111114 + bArr39.length;
                    java.lang.System.arraycopy(bArr6211111111111111111113, 0, bArr71111111111111111111111111111111111111111111119, length311111111111111111111111111111111111111115, bArr6211111111111111111113.length);
                    int length311111111111111111111111111111111111111116 = length311111111111111111111111111111111111111115 + bArr6211111111111111111113.length;
                    java.lang.System.arraycopy(bArr6211111111111111111114, 0, bArr71111111111111111111111111111111111111111111119, length311111111111111111111111111111111111111116, bArr6211111111111111111114.length);
                    int length311111111111111111111111111111111111111117 = length311111111111111111111111111111111111111116 + bArr6211111111111111111114.length;
                    java.lang.System.arraycopy(bArr6211111111111111111115, 0, bArr71111111111111111111111111111111111111111111119, length311111111111111111111111111111111111111117, bArr6211111111111111111115.length);
                    int length11111111111111111111111111111111111111111111111111110 = length311111111111111111111111111111111111111117 + bArr6211111111111111111115.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111111111111111111111111111111119, length11111111111111111111111111111111111111111111111111110, bArr26.length);
                    int length11111111111111111111111111111111111111111111111111111 = length11111111111111111111111111111111111111111111111111110 + bArr26.length;
                    byte[] bArr711111111111111111111111111111111111111111111110 = bArr41;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111110, 0, bArr71111111111111111111111111111111111111111111119, length11111111111111111111111111111111111111111111111111111, bArr711111111111111111111111111111111111111111111110.length);
                    int length11111111111111111111111111111111111111111111111111112 = length11111111111111111111111111111111111111111111111111111 + bArr711111111111111111111111111111111111111111111110.length;
                    byte[] bArr711111111111111111111111111111111111111111111111 = bArr8;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111, 0, bArr71111111111111111111111111111111111111111111119, length11111111111111111111111111111111111111111111111111112, bArr711111111111111111111111111111111111111111111111.length);
                    int length11111111111111111111111111111111111111111111111111113 = length11111111111111111111111111111111111111111111111111112 + bArr711111111111111111111111111111111111111111111111.length;
                    byte[] bArr711111111111111111111111111111111111111111111112 = bArr30;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111112, 0, bArr71111111111111111111111111111111111111111111119, length11111111111111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111111111111112.length);
                    int length11111111111111111111111111111111111111111111111111114 = length11111111111111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111111111111112.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111111111111111111111111111111119, length11111111111111111111111111111111111111111111111111114, bArr42.length);
                    int length11111111111111111111111111111111111111111111111111115 = length11111111111111111111111111111111111111111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111111111111111111111111111111119, length11111111111111111111111111111111111111111111111111115, bArr43.length);
                    int length11111111111111111111111111111111111111111111111111116 = length11111111111111111111111111111111111111111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111111111111111111111111111111119, length11111111111111111111111111111111111111111111111111116, bArr44.length);
                    int length11111111111111111111111111111111111111111111111111117 = length11111111111111111111111111111111111111111111111111116 + bArr44.length;
                    byte[] bArr711111111111111111111111111111111111111111111113 = bArr29;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111113, 0, bArr71111111111111111111111111111111111111111111119, length11111111111111111111111111111111111111111111111111117, bArr711111111111111111111111111111111111111111111113.length);
                    int length11111111111111111111111111111111111111111111111111118 = length11111111111111111111111111111111111111111111111111117 + bArr711111111111111111111111111111111111111111111113.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111111111111111111111111111111119, length11111111111111111111111111111111111111111111111111118, bArr45.length);
                    int length11111111111111111111111111111111111111111111111111119 = length11111111111111111111111111111111111111111111111111118 + bArr45.length;
                    byte[] bArr711111111111111111111111111111111111111111111114 = bArr13;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111114, 0, bArr71111111111111111111111111111111111111111111119, length11111111111111111111111111111111111111111111111111119, bArr711111111111111111111111111111111111111111111114.length);
                    int length21111111111111111111111111111111111111111111111111110 = length11111111111111111111111111111111111111111111111111119 + bArr711111111111111111111111111111111111111111111114.length;
                    java.lang.System.arraycopy(bArr611111111111111111111111111111114, 0, bArr71111111111111111111111111111111111111111111119, length21111111111111111111111111111111111111111111111111110, bArr611111111111111111111111111111114.length);
                    int length21111111111111111111111111111111111111111111111111111 = length21111111111111111111111111111111111111111111111111110 + bArr611111111111111111111111111111114.length;
                    java.lang.System.arraycopy(bArr611111111111111111111111111111115, 0, bArr71111111111111111111111111111111111111111111119, length21111111111111111111111111111111111111111111111111111, bArr611111111111111111111111111111115.length);
                    int length21111111111111111111111111111111111111111111111111112 = length21111111111111111111111111111111111111111111111111111 + bArr611111111111111111111111111111115.length;
                    byte[] bArr711111111111111111111111111111111111111111111115 = bArr16;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111115, 0, bArr71111111111111111111111111111111111111111111119, length21111111111111111111111111111111111111111111111111112, bArr711111111111111111111111111111111111111111111115.length);
                    int length21111111111111111111111111111111111111111111111111113 = length21111111111111111111111111111111111111111111111111112 + bArr711111111111111111111111111111111111111111111115.length;
                    byte[] bArr711111111111111111111111111111111111111111111116 = bArr19;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111116, 0, bArr71111111111111111111111111111111111111111111119, length21111111111111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111111111111116.length);
                    int length21111111111111111111111111111111111111111111111111114 = length21111111111111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111111111111116.length;
                    byte[] bArr711111111111111111111111111111111111111111111117 = bArr22;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111117, 0, bArr71111111111111111111111111111111111111111111119, length21111111111111111111111111111111111111111111111111114, bArr711111111111111111111111111111111111111111111117.length);
                    int length21111111111111111111111111111111111111111111111111115 = length21111111111111111111111111111111111111111111111111114 + bArr711111111111111111111111111111111111111111111117.length;
                    java.lang.System.arraycopy(bArr5111118, 0, bArr71111111111111111111111111111111111111111111119, length21111111111111111111111111111111111111111111111111115, bArr5111118.length);
                    int length21111111111111111111111111111111111111111111111111116 = length21111111111111111111111111111111111111111111111111115 + bArr5111118.length;
                    java.lang.System.arraycopy(bArr6211111111111111111112, 0, bArr71111111111111111111111111111111111111111111119, length21111111111111111111111111111111111111111111111111116, bArr6211111111111111111112.length);
                    int length21111111111111111111111111111111111111111111111111117 = length21111111111111111111111111111111111111111111111111116 + bArr6211111111111111111112.length;
                    java.lang.System.arraycopy(bArr611111111111111111111111111111111, 0, bArr71111111111111111111111111111111111111111111119, length21111111111111111111111111111111111111111111111111117, bArr611111111111111111111111111111111.length);
                    java.lang.System.arraycopy(bArr611111111111111111111111111111113, 0, bArr71111111111111111111111111111111111111111111119, length21111111111111111111111111111111111111111111111111117 + bArr611111111111111111111111111111111.length, bArr611111111111111111111111111111113.length);
                    int length21111111111111111111111111111111111111111111111111118 = bArr611111111111111111111111111111113.length;
                    return a(a(bArr71111111111111111111111111111111111111111111119, this.u, i1111116), this.y, this.A, this.B);
                }
                bArr19 = bArr17;
                bArr20 = bArr56;
                bArr21 = oicq.wlogin_sdk.request.l.J;
                if (bArr21 != null) {
                    bArr22 = bArr20;
                    if (bArr21.length > 0) {
                        bArr41 = bArr41;
                        bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                        i12++;
                    }
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr5111119 = bArr23;
                    byte[] bArr6211111111111111111116 = bArr25;
                    byte[] bArr6211111111111111111117 = bArr7;
                    byte[] bArr6211111111111111111118 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr6211111111111111111119 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr611111111111111111111111111111116 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111111111116, 0, i11);
                    tlv_tVar.set_data(bArr611111111111111111111111111111116, 4);
                    byte[] bArr611111111111111111111111111111117 = tlv_tVar.get_buf();
                    byte[] bArr611111111111111111111111111111118 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111111111118, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111111111111111111111118, 4, 0);
                    tlv_tVar2.set_data(bArr611111111111111111111111111111118, 6);
                    byte[] bArr611111111111111111111111111111119 = tlv_tVar2.get_buf();
                    int i1111117 = i14 + 1 + 1;
                    int length21111111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211111111111111111117.length + bArr6211111111111111111118.length + bArr6211111111111111111119.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr6111111111111111111111111111111110 = bArr10;
                    byte[] bArr6111111111111111111111111111111111 = bArr31;
                    byte[] bArr711111111111111111111111111111111111111111111118 = new byte[length21111111111111111111111111111111111111111111111111119 + bArr6111111111111111111111111111111110.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr5111119.length + bArr6211111111111111111116.length + bArr611111111111111111111111111111117.length + bArr611111111111111111111111111111119.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr711111111111111111111111111111111111111111111118, 0, bArr35.length);
                    int length311111111111111111111111111111111111111118 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr711111111111111111111111111111111111111111111118, length311111111111111111111111111111111111111118, bArr36.length);
                    int length311111111111111111111111111111111111111119 = length311111111111111111111111111111111111111118 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr711111111111111111111111111111111111111111111118, length311111111111111111111111111111111111111119, bArr37.length);
                    int length3111111111111111111111111111111111111111110 = length311111111111111111111111111111111111111119 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr711111111111111111111111111111111111111111111118, length3111111111111111111111111111111111111111110, bArr40.length);
                    int length3111111111111111111111111111111111111111111 = length3111111111111111111111111111111111111111110 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr711111111111111111111111111111111111111111111118, length3111111111111111111111111111111111111111111, bArr38.length);
                    int length3111111111111111111111111111111111111111112 = length3111111111111111111111111111111111111111111 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr711111111111111111111111111111111111111111111118, length3111111111111111111111111111111111111111112, bArr39.length);
                    int length3111111111111111111111111111111111111111113 = length3111111111111111111111111111111111111111112 + bArr39.length;
                    java.lang.System.arraycopy(bArr6211111111111111111117, 0, bArr711111111111111111111111111111111111111111111118, length3111111111111111111111111111111111111111113, bArr6211111111111111111117.length);
                    int length3111111111111111111111111111111111111111114 = length3111111111111111111111111111111111111111113 + bArr6211111111111111111117.length;
                    java.lang.System.arraycopy(bArr6211111111111111111118, 0, bArr711111111111111111111111111111111111111111111118, length3111111111111111111111111111111111111111114, bArr6211111111111111111118.length);
                    int length3111111111111111111111111111111111111111115 = length3111111111111111111111111111111111111111114 + bArr6211111111111111111118.length;
                    java.lang.System.arraycopy(bArr6211111111111111111119, 0, bArr711111111111111111111111111111111111111111111118, length3111111111111111111111111111111111111111115, bArr6211111111111111111119.length);
                    int length111111111111111111111111111111111111111111111111111110 = length3111111111111111111111111111111111111111115 + bArr6211111111111111111119.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr711111111111111111111111111111111111111111111118, length111111111111111111111111111111111111111111111111111110, bArr26.length);
                    int length111111111111111111111111111111111111111111111111111111 = length111111111111111111111111111111111111111111111111111110 + bArr26.length;
                    byte[] bArr711111111111111111111111111111111111111111111119 = bArr41;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111119, 0, bArr711111111111111111111111111111111111111111111118, length111111111111111111111111111111111111111111111111111111, bArr711111111111111111111111111111111111111111111119.length);
                    int length111111111111111111111111111111111111111111111111111112 = length111111111111111111111111111111111111111111111111111111 + bArr711111111111111111111111111111111111111111111119.length;
                    byte[] bArr7111111111111111111111111111111111111111111111110 = bArr8;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111110, 0, bArr711111111111111111111111111111111111111111111118, length111111111111111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111111111111110.length);
                    int length111111111111111111111111111111111111111111111111111113 = length111111111111111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111111111111110.length;
                    byte[] bArr7111111111111111111111111111111111111111111111111 = bArr30;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111, 0, bArr711111111111111111111111111111111111111111111118, length111111111111111111111111111111111111111111111111111113, bArr7111111111111111111111111111111111111111111111111.length);
                    int length111111111111111111111111111111111111111111111111111114 = length111111111111111111111111111111111111111111111111111113 + bArr7111111111111111111111111111111111111111111111111.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr711111111111111111111111111111111111111111111118, length111111111111111111111111111111111111111111111111111114, bArr42.length);
                    int length111111111111111111111111111111111111111111111111111115 = length111111111111111111111111111111111111111111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr711111111111111111111111111111111111111111111118, length111111111111111111111111111111111111111111111111111115, bArr43.length);
                    int length111111111111111111111111111111111111111111111111111116 = length111111111111111111111111111111111111111111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr711111111111111111111111111111111111111111111118, length111111111111111111111111111111111111111111111111111116, bArr44.length);
                    int length111111111111111111111111111111111111111111111111111117 = length111111111111111111111111111111111111111111111111111116 + bArr44.length;
                    byte[] bArr7111111111111111111111111111111111111111111111112 = bArr29;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111112, 0, bArr711111111111111111111111111111111111111111111118, length111111111111111111111111111111111111111111111111111117, bArr7111111111111111111111111111111111111111111111112.length);
                    int length111111111111111111111111111111111111111111111111111118 = length111111111111111111111111111111111111111111111111111117 + bArr7111111111111111111111111111111111111111111111112.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr711111111111111111111111111111111111111111111118, length111111111111111111111111111111111111111111111111111118, bArr45.length);
                    int length111111111111111111111111111111111111111111111111111119 = length111111111111111111111111111111111111111111111111111118 + bArr45.length;
                    byte[] bArr7111111111111111111111111111111111111111111111113 = bArr13;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111113, 0, bArr711111111111111111111111111111111111111111111118, length111111111111111111111111111111111111111111111111111119, bArr7111111111111111111111111111111111111111111111113.length);
                    int length211111111111111111111111111111111111111111111111111110 = length111111111111111111111111111111111111111111111111111119 + bArr7111111111111111111111111111111111111111111111113.length;
                    java.lang.System.arraycopy(bArr6111111111111111111111111111111110, 0, bArr711111111111111111111111111111111111111111111118, length211111111111111111111111111111111111111111111111111110, bArr6111111111111111111111111111111110.length);
                    int length211111111111111111111111111111111111111111111111111111 = length211111111111111111111111111111111111111111111111111110 + bArr6111111111111111111111111111111110.length;
                    java.lang.System.arraycopy(bArr6111111111111111111111111111111111, 0, bArr711111111111111111111111111111111111111111111118, length211111111111111111111111111111111111111111111111111111, bArr6111111111111111111111111111111111.length);
                    int length211111111111111111111111111111111111111111111111111112 = length211111111111111111111111111111111111111111111111111111 + bArr6111111111111111111111111111111111.length;
                    byte[] bArr7111111111111111111111111111111111111111111111114 = bArr16;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111114, 0, bArr711111111111111111111111111111111111111111111118, length211111111111111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111111111111114.length);
                    int length211111111111111111111111111111111111111111111111111113 = length211111111111111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111111111111114.length;
                    byte[] bArr7111111111111111111111111111111111111111111111115 = bArr19;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111115, 0, bArr711111111111111111111111111111111111111111111118, length211111111111111111111111111111111111111111111111111113, bArr7111111111111111111111111111111111111111111111115.length);
                    int length211111111111111111111111111111111111111111111111111114 = length211111111111111111111111111111111111111111111111111113 + bArr7111111111111111111111111111111111111111111111115.length;
                    byte[] bArr7111111111111111111111111111111111111111111111116 = bArr22;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111116, 0, bArr711111111111111111111111111111111111111111111118, length211111111111111111111111111111111111111111111111111114, bArr7111111111111111111111111111111111111111111111116.length);
                    int length211111111111111111111111111111111111111111111111111115 = length211111111111111111111111111111111111111111111111111114 + bArr7111111111111111111111111111111111111111111111116.length;
                    java.lang.System.arraycopy(bArr5111119, 0, bArr711111111111111111111111111111111111111111111118, length211111111111111111111111111111111111111111111111111115, bArr5111119.length);
                    int length211111111111111111111111111111111111111111111111111116 = length211111111111111111111111111111111111111111111111111115 + bArr5111119.length;
                    java.lang.System.arraycopy(bArr6211111111111111111116, 0, bArr711111111111111111111111111111111111111111111118, length211111111111111111111111111111111111111111111111111116, bArr6211111111111111111116.length);
                    int length211111111111111111111111111111111111111111111111111117 = length211111111111111111111111111111111111111111111111111116 + bArr6211111111111111111116.length;
                    java.lang.System.arraycopy(bArr611111111111111111111111111111117, 0, bArr711111111111111111111111111111111111111111111118, length211111111111111111111111111111111111111111111111111117, bArr611111111111111111111111111111117.length);
                    java.lang.System.arraycopy(bArr611111111111111111111111111111119, 0, bArr711111111111111111111111111111111111111111111118, length211111111111111111111111111111111111111111111111111117 + bArr611111111111111111111111111111117.length, bArr611111111111111111111111111111119.length);
                    int length211111111111111111111111111111111111111111111111111118 = bArr611111111111111111111111111111119.length;
                    return a(a(bArr711111111111111111111111111111111111111111111118, this.u, i1111117), this.y, this.A, this.B);
                }
                bArr22 = bArr20;
                bArr23 = bArr57;
                bArr24 = oicq.wlogin_sdk.request.t.R;
                if (bArr24 != null) {
                    bArr25 = bArr6;
                } else {
                    bArr25 = bArr6;
                }
                byte[] bArr51111110 = bArr23;
                byte[] bArr62111111111111111111110 = bArr25;
                byte[] bArr62111111111111111111111 = bArr7;
                byte[] bArr62111111111111111111112 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                byte[] bArr62111111111111111111113 = tlv_t142Var.get_tlv_142(bArr5);
                i13 = i12 + 1 + 1;
                str = this.x.g;
                if (str != null) {
                    i14 = i13;
                    bArr26 = bArr48;
                } else {
                    i14 = i13;
                    bArr26 = bArr48;
                }
                if (bArr3 != null) {
                    bArr27 = bArr50;
                } else {
                    bArr27 = bArr50;
                }
                if (list != null) {
                    bArr28 = bArr51;
                } else {
                    bArr28 = bArr51;
                }
                if (wloginSigInfoA == null) {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                } else {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                }
                byte[] bArr6111111111111111111111111111111112 = new byte[4];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111111111111112, 0, i11);
                tlv_tVar.set_data(bArr6111111111111111111111111111111112, 4);
                byte[] bArr6111111111111111111111111111111113 = tlv_tVar.get_buf();
                byte[] bArr6111111111111111111111111111111114 = new byte[6];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111111111111114, 0, oicq.wlogin_sdk.request.t.au);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr6111111111111111111111111111111114, 4, 0);
                tlv_tVar2.set_data(bArr6111111111111111111111111111111114, 6);
                byte[] bArr6111111111111111111111111111111115 = tlv_tVar2.get_buf();
                int i1111118 = i14 + 1 + 1;
                int length211111111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111111111111111111111.length + bArr62111111111111111111112.length + bArr62111111111111111111113.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                byte[] bArr6111111111111111111111111111111116 = bArr10;
                byte[] bArr6111111111111111111111111111111117 = bArr31;
                byte[] bArr7111111111111111111111111111111111111111111111117 = new byte[length211111111111111111111111111111111111111111111111111119 + bArr6111111111111111111111111111111116.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51111110.length + bArr62111111111111111111110.length + bArr6111111111111111111111111111111113.length + bArr6111111111111111111111111111111115.length];
                java.lang.System.arraycopy(bArr35, 0, bArr7111111111111111111111111111111111111111111111117, 0, bArr35.length);
                int length3111111111111111111111111111111111111111116 = bArr35.length + 0;
                java.lang.System.arraycopy(bArr36, 0, bArr7111111111111111111111111111111111111111111111117, length3111111111111111111111111111111111111111116, bArr36.length);
                int length3111111111111111111111111111111111111111117 = length3111111111111111111111111111111111111111116 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr7111111111111111111111111111111111111111111111117, length3111111111111111111111111111111111111111117, bArr37.length);
                int length3111111111111111111111111111111111111111118 = length3111111111111111111111111111111111111111117 + bArr37.length;
                java.lang.System.arraycopy(bArr40, 0, bArr7111111111111111111111111111111111111111111111117, length3111111111111111111111111111111111111111118, bArr40.length);
                int length3111111111111111111111111111111111111111119 = length3111111111111111111111111111111111111111118 + bArr40.length;
                java.lang.System.arraycopy(bArr38, 0, bArr7111111111111111111111111111111111111111111111117, length3111111111111111111111111111111111111111119, bArr38.length);
                int length31111111111111111111111111111111111111111110 = length3111111111111111111111111111111111111111119 + bArr38.length;
                java.lang.System.arraycopy(bArr39, 0, bArr7111111111111111111111111111111111111111111111117, length31111111111111111111111111111111111111111110, bArr39.length);
                int length31111111111111111111111111111111111111111111 = length31111111111111111111111111111111111111111110 + bArr39.length;
                java.lang.System.arraycopy(bArr62111111111111111111111, 0, bArr7111111111111111111111111111111111111111111111117, length31111111111111111111111111111111111111111111, bArr62111111111111111111111.length);
                int length31111111111111111111111111111111111111111112 = length31111111111111111111111111111111111111111111 + bArr62111111111111111111111.length;
                java.lang.System.arraycopy(bArr62111111111111111111112, 0, bArr7111111111111111111111111111111111111111111111117, length31111111111111111111111111111111111111111112, bArr62111111111111111111112.length);
                int length31111111111111111111111111111111111111111113 = length31111111111111111111111111111111111111111112 + bArr62111111111111111111112.length;
                java.lang.System.arraycopy(bArr62111111111111111111113, 0, bArr7111111111111111111111111111111111111111111111117, length31111111111111111111111111111111111111111113, bArr62111111111111111111113.length);
                int length1111111111111111111111111111111111111111111111111111110 = length31111111111111111111111111111111111111111113 + bArr62111111111111111111113.length;
                java.lang.System.arraycopy(bArr26, 0, bArr7111111111111111111111111111111111111111111111117, length1111111111111111111111111111111111111111111111111111110, bArr26.length);
                int length1111111111111111111111111111111111111111111111111111111 = length1111111111111111111111111111111111111111111111111111110 + bArr26.length;
                byte[] bArr7111111111111111111111111111111111111111111111118 = bArr41;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111118, 0, bArr7111111111111111111111111111111111111111111111117, length1111111111111111111111111111111111111111111111111111111, bArr7111111111111111111111111111111111111111111111118.length);
                int length1111111111111111111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111111111111111111 + bArr7111111111111111111111111111111111111111111111118.length;
                byte[] bArr7111111111111111111111111111111111111111111111119 = bArr8;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111119, 0, bArr7111111111111111111111111111111111111111111111117, length1111111111111111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111111111111119.length);
                int length1111111111111111111111111111111111111111111111111111113 = length1111111111111111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111111111111119.length;
                byte[] bArr71111111111111111111111111111111111111111111111110 = bArr30;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111110, 0, bArr7111111111111111111111111111111111111111111111117, length1111111111111111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111111111111111110.length);
                int length1111111111111111111111111111111111111111111111111111114 = length1111111111111111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111111111111111110.length;
                java.lang.System.arraycopy(bArr42, 0, bArr7111111111111111111111111111111111111111111111117, length1111111111111111111111111111111111111111111111111111114, bArr42.length);
                int length1111111111111111111111111111111111111111111111111111115 = length1111111111111111111111111111111111111111111111111111114 + bArr42.length;
                java.lang.System.arraycopy(bArr43, 0, bArr7111111111111111111111111111111111111111111111117, length1111111111111111111111111111111111111111111111111111115, bArr43.length);
                int length1111111111111111111111111111111111111111111111111111116 = length1111111111111111111111111111111111111111111111111111115 + bArr43.length;
                java.lang.System.arraycopy(bArr44, 0, bArr7111111111111111111111111111111111111111111111117, length1111111111111111111111111111111111111111111111111111116, bArr44.length);
                int length1111111111111111111111111111111111111111111111111111117 = length1111111111111111111111111111111111111111111111111111116 + bArr44.length;
                byte[] bArr71111111111111111111111111111111111111111111111111 = bArr29;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111, 0, bArr7111111111111111111111111111111111111111111111117, length1111111111111111111111111111111111111111111111111111117, bArr71111111111111111111111111111111111111111111111111.length);
                int length1111111111111111111111111111111111111111111111111111118 = length1111111111111111111111111111111111111111111111111111117 + bArr71111111111111111111111111111111111111111111111111.length;
                java.lang.System.arraycopy(bArr45, 0, bArr7111111111111111111111111111111111111111111111117, length1111111111111111111111111111111111111111111111111111118, bArr45.length);
                int length1111111111111111111111111111111111111111111111111111119 = length1111111111111111111111111111111111111111111111111111118 + bArr45.length;
                byte[] bArr71111111111111111111111111111111111111111111111112 = bArr13;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111112, 0, bArr7111111111111111111111111111111111111111111111117, length1111111111111111111111111111111111111111111111111111119, bArr71111111111111111111111111111111111111111111111112.length);
                int length2111111111111111111111111111111111111111111111111111110 = length1111111111111111111111111111111111111111111111111111119 + bArr71111111111111111111111111111111111111111111111112.length;
                java.lang.System.arraycopy(bArr6111111111111111111111111111111116, 0, bArr7111111111111111111111111111111111111111111111117, length2111111111111111111111111111111111111111111111111111110, bArr6111111111111111111111111111111116.length);
                int length2111111111111111111111111111111111111111111111111111111 = length2111111111111111111111111111111111111111111111111111110 + bArr6111111111111111111111111111111116.length;
                java.lang.System.arraycopy(bArr6111111111111111111111111111111117, 0, bArr7111111111111111111111111111111111111111111111117, length2111111111111111111111111111111111111111111111111111111, bArr6111111111111111111111111111111117.length);
                int length2111111111111111111111111111111111111111111111111111112 = length2111111111111111111111111111111111111111111111111111111 + bArr6111111111111111111111111111111117.length;
                byte[] bArr71111111111111111111111111111111111111111111111113 = bArr16;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111113, 0, bArr7111111111111111111111111111111111111111111111117, length2111111111111111111111111111111111111111111111111111112, bArr71111111111111111111111111111111111111111111111113.length);
                int length2111111111111111111111111111111111111111111111111111113 = length2111111111111111111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111111111111111113.length;
                byte[] bArr71111111111111111111111111111111111111111111111114 = bArr19;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111114, 0, bArr7111111111111111111111111111111111111111111111117, length2111111111111111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111111111111111114.length);
                int length2111111111111111111111111111111111111111111111111111114 = length2111111111111111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111111111111111114.length;
                byte[] bArr71111111111111111111111111111111111111111111111115 = bArr22;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111115, 0, bArr7111111111111111111111111111111111111111111111117, length2111111111111111111111111111111111111111111111111111114, bArr71111111111111111111111111111111111111111111111115.length);
                int length2111111111111111111111111111111111111111111111111111115 = length2111111111111111111111111111111111111111111111111111114 + bArr71111111111111111111111111111111111111111111111115.length;
                java.lang.System.arraycopy(bArr51111110, 0, bArr7111111111111111111111111111111111111111111111117, length2111111111111111111111111111111111111111111111111111115, bArr51111110.length);
                int length2111111111111111111111111111111111111111111111111111116 = length2111111111111111111111111111111111111111111111111111115 + bArr51111110.length;
                java.lang.System.arraycopy(bArr62111111111111111111110, 0, bArr7111111111111111111111111111111111111111111111117, length2111111111111111111111111111111111111111111111111111116, bArr62111111111111111111110.length);
                int length2111111111111111111111111111111111111111111111111111117 = length2111111111111111111111111111111111111111111111111111116 + bArr62111111111111111111110.length;
                java.lang.System.arraycopy(bArr6111111111111111111111111111111113, 0, bArr7111111111111111111111111111111111111111111111117, length2111111111111111111111111111111111111111111111111111117, bArr6111111111111111111111111111111113.length);
                java.lang.System.arraycopy(bArr6111111111111111111111111111111115, 0, bArr7111111111111111111111111111111111111111111111117, length2111111111111111111111111111111111111111111111111111117 + bArr6111111111111111111111111111111113.length, bArr6111111111111111111111111111111115.length);
                int length2111111111111111111111111111111111111111111111111111118 = bArr6111111111111111111111111111111115.length;
                return a(a(bArr7111111111111111111111111111111111111111111111117, this.u, i1111118), this.y, this.A, this.B);
            }
            bArr16 = bArr14;
            bArr17 = bArr55;
            bArr18 = oicq.wlogin_sdk.request.t.L;
            if (bArr18 != null) {
                bArr19 = bArr17;
                if (bArr18.length > 0) {
                    bArr20 = tlv_t194Var.get_tlv_194(bArr18);
                    i12++;
                }
                bArr21 = oicq.wlogin_sdk.request.l.J;
                if (bArr21 != null) {
                    bArr22 = bArr20;
                    if (bArr21.length > 0) {
                        bArr41 = bArr41;
                        bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                        i12++;
                    }
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr51111111 = bArr23;
                    byte[] bArr62111111111111111111114 = bArr25;
                    byte[] bArr62111111111111111111115 = bArr7;
                    byte[] bArr62111111111111111111116 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr62111111111111111111117 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr6111111111111111111111111111111118 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111111111111118, 0, i11);
                    tlv_tVar.set_data(bArr6111111111111111111111111111111118, 4);
                    byte[] bArr6111111111111111111111111111111119 = tlv_tVar.get_buf();
                    byte[] bArr61111111111111111111111111111111110 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111111111111110, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111111111111111111111110, 4, 0);
                    tlv_tVar2.set_data(bArr61111111111111111111111111111111110, 6);
                    byte[] bArr61111111111111111111111111111111111 = tlv_tVar2.get_buf();
                    int i1111119 = i14 + 1 + 1;
                    int length2111111111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111111111111111111115.length + bArr62111111111111111111116.length + bArr62111111111111111111117.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr61111111111111111111111111111111112 = bArr10;
                    byte[] bArr61111111111111111111111111111111113 = bArr31;
                    byte[] bArr71111111111111111111111111111111111111111111111116 = new byte[length2111111111111111111111111111111111111111111111111111119 + bArr61111111111111111111111111111111112.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51111111.length + bArr62111111111111111111114.length + bArr6111111111111111111111111111111119.length + bArr61111111111111111111111111111111111.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111111111111111111111111111111111116, 0, bArr35.length);
                    int length31111111111111111111111111111111111111111114 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111111111111111111111111111111111116, length31111111111111111111111111111111111111111114, bArr36.length);
                    int length31111111111111111111111111111111111111111115 = length31111111111111111111111111111111111111111114 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111111111111111111111111111111111116, length31111111111111111111111111111111111111111115, bArr37.length);
                    int length31111111111111111111111111111111111111111116 = length31111111111111111111111111111111111111111115 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111111111111111111111111111111111116, length31111111111111111111111111111111111111111116, bArr40.length);
                    int length31111111111111111111111111111111111111111117 = length31111111111111111111111111111111111111111116 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111111111111111111111111111111111116, length31111111111111111111111111111111111111111117, bArr38.length);
                    int length31111111111111111111111111111111111111111118 = length31111111111111111111111111111111111111111117 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111111111111111111111111111111111116, length31111111111111111111111111111111111111111118, bArr39.length);
                    int length31111111111111111111111111111111111111111119 = length31111111111111111111111111111111111111111118 + bArr39.length;
                    java.lang.System.arraycopy(bArr62111111111111111111115, 0, bArr71111111111111111111111111111111111111111111111116, length31111111111111111111111111111111111111111119, bArr62111111111111111111115.length);
                    int length311111111111111111111111111111111111111111110 = length31111111111111111111111111111111111111111119 + bArr62111111111111111111115.length;
                    java.lang.System.arraycopy(bArr62111111111111111111116, 0, bArr71111111111111111111111111111111111111111111111116, length311111111111111111111111111111111111111111110, bArr62111111111111111111116.length);
                    int length311111111111111111111111111111111111111111111 = length311111111111111111111111111111111111111111110 + bArr62111111111111111111116.length;
                    java.lang.System.arraycopy(bArr62111111111111111111117, 0, bArr71111111111111111111111111111111111111111111111116, length311111111111111111111111111111111111111111111, bArr62111111111111111111117.length);
                    int length11111111111111111111111111111111111111111111111111111110 = length311111111111111111111111111111111111111111111 + bArr62111111111111111111117.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111111111111111111111111111111111116, length11111111111111111111111111111111111111111111111111111110, bArr26.length);
                    int length11111111111111111111111111111111111111111111111111111111 = length11111111111111111111111111111111111111111111111111111110 + bArr26.length;
                    byte[] bArr71111111111111111111111111111111111111111111111117 = bArr41;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111117, 0, bArr71111111111111111111111111111111111111111111111116, length11111111111111111111111111111111111111111111111111111111, bArr71111111111111111111111111111111111111111111111117.length);
                    int length11111111111111111111111111111111111111111111111111111112 = length11111111111111111111111111111111111111111111111111111111 + bArr71111111111111111111111111111111111111111111111117.length;
                    byte[] bArr71111111111111111111111111111111111111111111111118 = bArr8;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111118, 0, bArr71111111111111111111111111111111111111111111111116, length11111111111111111111111111111111111111111111111111111112, bArr71111111111111111111111111111111111111111111111118.length);
                    int length11111111111111111111111111111111111111111111111111111113 = length11111111111111111111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111111111111111118.length;
                    byte[] bArr71111111111111111111111111111111111111111111111119 = bArr30;
                    java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111119, 0, bArr71111111111111111111111111111111111111111111111116, length11111111111111111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111111111111111119.length);
                    int length11111111111111111111111111111111111111111111111111111114 = length11111111111111111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111111111111111119.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111111111111111111111111111111111116, length11111111111111111111111111111111111111111111111111111114, bArr42.length);
                    int length11111111111111111111111111111111111111111111111111111115 = length11111111111111111111111111111111111111111111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111111111111111111111111111111111116, length11111111111111111111111111111111111111111111111111111115, bArr43.length);
                    int length11111111111111111111111111111111111111111111111111111116 = length11111111111111111111111111111111111111111111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111111111111111111111111111111111116, length11111111111111111111111111111111111111111111111111111116, bArr44.length);
                    int length11111111111111111111111111111111111111111111111111111117 = length11111111111111111111111111111111111111111111111111111116 + bArr44.length;
                    byte[] bArr711111111111111111111111111111111111111111111111110 = bArr29;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111110, 0, bArr71111111111111111111111111111111111111111111111116, length11111111111111111111111111111111111111111111111111111117, bArr711111111111111111111111111111111111111111111111110.length);
                    int length11111111111111111111111111111111111111111111111111111118 = length11111111111111111111111111111111111111111111111111111117 + bArr711111111111111111111111111111111111111111111111110.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111111111111111111111111111111111116, length11111111111111111111111111111111111111111111111111111118, bArr45.length);
                    int length11111111111111111111111111111111111111111111111111111119 = length11111111111111111111111111111111111111111111111111111118 + bArr45.length;
                    byte[] bArr711111111111111111111111111111111111111111111111111 = bArr13;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111, 0, bArr71111111111111111111111111111111111111111111111116, length11111111111111111111111111111111111111111111111111111119, bArr711111111111111111111111111111111111111111111111111.length);
                    int length21111111111111111111111111111111111111111111111111111110 = length11111111111111111111111111111111111111111111111111111119 + bArr711111111111111111111111111111111111111111111111111.length;
                    java.lang.System.arraycopy(bArr61111111111111111111111111111111112, 0, bArr71111111111111111111111111111111111111111111111116, length21111111111111111111111111111111111111111111111111111110, bArr61111111111111111111111111111111112.length);
                    int length21111111111111111111111111111111111111111111111111111111 = length21111111111111111111111111111111111111111111111111111110 + bArr61111111111111111111111111111111112.length;
                    java.lang.System.arraycopy(bArr61111111111111111111111111111111113, 0, bArr71111111111111111111111111111111111111111111111116, length21111111111111111111111111111111111111111111111111111111, bArr61111111111111111111111111111111113.length);
                    int length21111111111111111111111111111111111111111111111111111112 = length21111111111111111111111111111111111111111111111111111111 + bArr61111111111111111111111111111111113.length;
                    byte[] bArr711111111111111111111111111111111111111111111111112 = bArr16;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111112, 0, bArr71111111111111111111111111111111111111111111111116, length21111111111111111111111111111111111111111111111111111112, bArr711111111111111111111111111111111111111111111111112.length);
                    int length21111111111111111111111111111111111111111111111111111113 = length21111111111111111111111111111111111111111111111111111112 + bArr711111111111111111111111111111111111111111111111112.length;
                    byte[] bArr711111111111111111111111111111111111111111111111113 = bArr19;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111113, 0, bArr71111111111111111111111111111111111111111111111116, length21111111111111111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111111111111111113.length);
                    int length21111111111111111111111111111111111111111111111111111114 = length21111111111111111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111111111111111113.length;
                    byte[] bArr711111111111111111111111111111111111111111111111114 = bArr22;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111114, 0, bArr71111111111111111111111111111111111111111111111116, length21111111111111111111111111111111111111111111111111111114, bArr711111111111111111111111111111111111111111111111114.length);
                    int length21111111111111111111111111111111111111111111111111111115 = length21111111111111111111111111111111111111111111111111111114 + bArr711111111111111111111111111111111111111111111111114.length;
                    java.lang.System.arraycopy(bArr51111111, 0, bArr71111111111111111111111111111111111111111111111116, length21111111111111111111111111111111111111111111111111111115, bArr51111111.length);
                    int length21111111111111111111111111111111111111111111111111111116 = length21111111111111111111111111111111111111111111111111111115 + bArr51111111.length;
                    java.lang.System.arraycopy(bArr62111111111111111111114, 0, bArr71111111111111111111111111111111111111111111111116, length21111111111111111111111111111111111111111111111111111116, bArr62111111111111111111114.length);
                    int length21111111111111111111111111111111111111111111111111111117 = length21111111111111111111111111111111111111111111111111111116 + bArr62111111111111111111114.length;
                    java.lang.System.arraycopy(bArr6111111111111111111111111111111119, 0, bArr71111111111111111111111111111111111111111111111116, length21111111111111111111111111111111111111111111111111111117, bArr6111111111111111111111111111111119.length);
                    java.lang.System.arraycopy(bArr61111111111111111111111111111111111, 0, bArr71111111111111111111111111111111111111111111111116, length21111111111111111111111111111111111111111111111111111117 + bArr6111111111111111111111111111111119.length, bArr61111111111111111111111111111111111.length);
                    int length21111111111111111111111111111111111111111111111111111118 = bArr61111111111111111111111111111111111.length;
                    return a(a(bArr71111111111111111111111111111111111111111111111116, this.u, i1111119), this.y, this.A, this.B);
                }
                bArr22 = bArr20;
                bArr23 = bArr57;
                bArr24 = oicq.wlogin_sdk.request.t.R;
                if (bArr24 != null) {
                    bArr25 = bArr6;
                } else {
                    bArr25 = bArr6;
                }
                byte[] bArr51111112 = bArr23;
                byte[] bArr62111111111111111111118 = bArr25;
                byte[] bArr62111111111111111111119 = bArr7;
                byte[] bArr621111111111111111111110 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                byte[] bArr621111111111111111111111 = tlv_t142Var.get_tlv_142(bArr5);
                i13 = i12 + 1 + 1;
                str = this.x.g;
                if (str != null) {
                    i14 = i13;
                    bArr26 = bArr48;
                } else {
                    i14 = i13;
                    bArr26 = bArr48;
                }
                if (bArr3 != null) {
                    bArr27 = bArr50;
                } else {
                    bArr27 = bArr50;
                }
                if (list != null) {
                    bArr28 = bArr51;
                } else {
                    bArr28 = bArr51;
                }
                if (wloginSigInfoA == null) {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                } else {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                }
                byte[] bArr61111111111111111111111111111111114 = new byte[4];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111111111111114, 0, i11);
                tlv_tVar.set_data(bArr61111111111111111111111111111111114, 4);
                byte[] bArr61111111111111111111111111111111115 = tlv_tVar.get_buf();
                byte[] bArr61111111111111111111111111111111116 = new byte[6];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111111111111116, 0, oicq.wlogin_sdk.request.t.au);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111111111111111111111116, 4, 0);
                tlv_tVar2.set_data(bArr61111111111111111111111111111111116, 6);
                byte[] bArr61111111111111111111111111111111117 = tlv_tVar2.get_buf();
                int i11111110 = i14 + 1 + 1;
                int length21111111111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111111111111111111119.length + bArr621111111111111111111110.length + bArr621111111111111111111111.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                byte[] bArr61111111111111111111111111111111118 = bArr10;
                byte[] bArr61111111111111111111111111111111119 = bArr31;
                byte[] bArr711111111111111111111111111111111111111111111111115 = new byte[length21111111111111111111111111111111111111111111111111111119 + bArr61111111111111111111111111111111118.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51111112.length + bArr62111111111111111111118.length + bArr61111111111111111111111111111111115.length + bArr61111111111111111111111111111111117.length];
                java.lang.System.arraycopy(bArr35, 0, bArr711111111111111111111111111111111111111111111111115, 0, bArr35.length);
                int length311111111111111111111111111111111111111111112 = bArr35.length + 0;
                java.lang.System.arraycopy(bArr36, 0, bArr711111111111111111111111111111111111111111111111115, length311111111111111111111111111111111111111111112, bArr36.length);
                int length311111111111111111111111111111111111111111113 = length311111111111111111111111111111111111111111112 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr711111111111111111111111111111111111111111111111115, length311111111111111111111111111111111111111111113, bArr37.length);
                int length311111111111111111111111111111111111111111114 = length311111111111111111111111111111111111111111113 + bArr37.length;
                java.lang.System.arraycopy(bArr40, 0, bArr711111111111111111111111111111111111111111111111115, length311111111111111111111111111111111111111111114, bArr40.length);
                int length311111111111111111111111111111111111111111115 = length311111111111111111111111111111111111111111114 + bArr40.length;
                java.lang.System.arraycopy(bArr38, 0, bArr711111111111111111111111111111111111111111111111115, length311111111111111111111111111111111111111111115, bArr38.length);
                int length311111111111111111111111111111111111111111116 = length311111111111111111111111111111111111111111115 + bArr38.length;
                java.lang.System.arraycopy(bArr39, 0, bArr711111111111111111111111111111111111111111111111115, length311111111111111111111111111111111111111111116, bArr39.length);
                int length311111111111111111111111111111111111111111117 = length311111111111111111111111111111111111111111116 + bArr39.length;
                java.lang.System.arraycopy(bArr62111111111111111111119, 0, bArr711111111111111111111111111111111111111111111111115, length311111111111111111111111111111111111111111117, bArr62111111111111111111119.length);
                int length311111111111111111111111111111111111111111118 = length311111111111111111111111111111111111111111117 + bArr62111111111111111111119.length;
                java.lang.System.arraycopy(bArr621111111111111111111110, 0, bArr711111111111111111111111111111111111111111111111115, length311111111111111111111111111111111111111111118, bArr621111111111111111111110.length);
                int length311111111111111111111111111111111111111111119 = length311111111111111111111111111111111111111111118 + bArr621111111111111111111110.length;
                java.lang.System.arraycopy(bArr621111111111111111111111, 0, bArr711111111111111111111111111111111111111111111111115, length311111111111111111111111111111111111111111119, bArr621111111111111111111111.length);
                int length111111111111111111111111111111111111111111111111111111110 = length311111111111111111111111111111111111111111119 + bArr621111111111111111111111.length;
                java.lang.System.arraycopy(bArr26, 0, bArr711111111111111111111111111111111111111111111111115, length111111111111111111111111111111111111111111111111111111110, bArr26.length);
                int length111111111111111111111111111111111111111111111111111111111 = length111111111111111111111111111111111111111111111111111111110 + bArr26.length;
                byte[] bArr711111111111111111111111111111111111111111111111116 = bArr41;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111116, 0, bArr711111111111111111111111111111111111111111111111115, length111111111111111111111111111111111111111111111111111111111, bArr711111111111111111111111111111111111111111111111116.length);
                int length111111111111111111111111111111111111111111111111111111112 = length111111111111111111111111111111111111111111111111111111111 + bArr711111111111111111111111111111111111111111111111116.length;
                byte[] bArr711111111111111111111111111111111111111111111111117 = bArr8;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111117, 0, bArr711111111111111111111111111111111111111111111111115, length111111111111111111111111111111111111111111111111111111112, bArr711111111111111111111111111111111111111111111111117.length);
                int length111111111111111111111111111111111111111111111111111111113 = length111111111111111111111111111111111111111111111111111111112 + bArr711111111111111111111111111111111111111111111111117.length;
                byte[] bArr711111111111111111111111111111111111111111111111118 = bArr30;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111118, 0, bArr711111111111111111111111111111111111111111111111115, length111111111111111111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111111111111111118.length);
                int length111111111111111111111111111111111111111111111111111111114 = length111111111111111111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111111111111111118.length;
                java.lang.System.arraycopy(bArr42, 0, bArr711111111111111111111111111111111111111111111111115, length111111111111111111111111111111111111111111111111111111114, bArr42.length);
                int length111111111111111111111111111111111111111111111111111111115 = length111111111111111111111111111111111111111111111111111111114 + bArr42.length;
                java.lang.System.arraycopy(bArr43, 0, bArr711111111111111111111111111111111111111111111111115, length111111111111111111111111111111111111111111111111111111115, bArr43.length);
                int length111111111111111111111111111111111111111111111111111111116 = length111111111111111111111111111111111111111111111111111111115 + bArr43.length;
                java.lang.System.arraycopy(bArr44, 0, bArr711111111111111111111111111111111111111111111111115, length111111111111111111111111111111111111111111111111111111116, bArr44.length);
                int length111111111111111111111111111111111111111111111111111111117 = length111111111111111111111111111111111111111111111111111111116 + bArr44.length;
                byte[] bArr711111111111111111111111111111111111111111111111119 = bArr29;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111119, 0, bArr711111111111111111111111111111111111111111111111115, length111111111111111111111111111111111111111111111111111111117, bArr711111111111111111111111111111111111111111111111119.length);
                int length111111111111111111111111111111111111111111111111111111118 = length111111111111111111111111111111111111111111111111111111117 + bArr711111111111111111111111111111111111111111111111119.length;
                java.lang.System.arraycopy(bArr45, 0, bArr711111111111111111111111111111111111111111111111115, length111111111111111111111111111111111111111111111111111111118, bArr45.length);
                int length111111111111111111111111111111111111111111111111111111119 = length111111111111111111111111111111111111111111111111111111118 + bArr45.length;
                byte[] bArr7111111111111111111111111111111111111111111111111110 = bArr13;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111110, 0, bArr711111111111111111111111111111111111111111111111115, length111111111111111111111111111111111111111111111111111111119, bArr7111111111111111111111111111111111111111111111111110.length);
                int length211111111111111111111111111111111111111111111111111111110 = length111111111111111111111111111111111111111111111111111111119 + bArr7111111111111111111111111111111111111111111111111110.length;
                java.lang.System.arraycopy(bArr61111111111111111111111111111111118, 0, bArr711111111111111111111111111111111111111111111111115, length211111111111111111111111111111111111111111111111111111110, bArr61111111111111111111111111111111118.length);
                int length211111111111111111111111111111111111111111111111111111111 = length211111111111111111111111111111111111111111111111111111110 + bArr61111111111111111111111111111111118.length;
                java.lang.System.arraycopy(bArr61111111111111111111111111111111119, 0, bArr711111111111111111111111111111111111111111111111115, length211111111111111111111111111111111111111111111111111111111, bArr61111111111111111111111111111111119.length);
                int length211111111111111111111111111111111111111111111111111111112 = length211111111111111111111111111111111111111111111111111111111 + bArr61111111111111111111111111111111119.length;
                byte[] bArr7111111111111111111111111111111111111111111111111111 = bArr16;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111, 0, bArr711111111111111111111111111111111111111111111111115, length211111111111111111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111111111111111111.length);
                int length211111111111111111111111111111111111111111111111111111113 = length211111111111111111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111111111111111111.length;
                byte[] bArr7111111111111111111111111111111111111111111111111112 = bArr19;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111112, 0, bArr711111111111111111111111111111111111111111111111115, length211111111111111111111111111111111111111111111111111111113, bArr7111111111111111111111111111111111111111111111111112.length);
                int length211111111111111111111111111111111111111111111111111111114 = length211111111111111111111111111111111111111111111111111111113 + bArr7111111111111111111111111111111111111111111111111112.length;
                byte[] bArr7111111111111111111111111111111111111111111111111113 = bArr22;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111113, 0, bArr711111111111111111111111111111111111111111111111115, length211111111111111111111111111111111111111111111111111111114, bArr7111111111111111111111111111111111111111111111111113.length);
                int length211111111111111111111111111111111111111111111111111111115 = length211111111111111111111111111111111111111111111111111111114 + bArr7111111111111111111111111111111111111111111111111113.length;
                java.lang.System.arraycopy(bArr51111112, 0, bArr711111111111111111111111111111111111111111111111115, length211111111111111111111111111111111111111111111111111111115, bArr51111112.length);
                int length211111111111111111111111111111111111111111111111111111116 = length211111111111111111111111111111111111111111111111111111115 + bArr51111112.length;
                java.lang.System.arraycopy(bArr62111111111111111111118, 0, bArr711111111111111111111111111111111111111111111111115, length211111111111111111111111111111111111111111111111111111116, bArr62111111111111111111118.length);
                int length211111111111111111111111111111111111111111111111111111117 = length211111111111111111111111111111111111111111111111111111116 + bArr62111111111111111111118.length;
                java.lang.System.arraycopy(bArr61111111111111111111111111111111115, 0, bArr711111111111111111111111111111111111111111111111115, length211111111111111111111111111111111111111111111111111111117, bArr61111111111111111111111111111111115.length);
                java.lang.System.arraycopy(bArr61111111111111111111111111111111117, 0, bArr711111111111111111111111111111111111111111111111115, length211111111111111111111111111111111111111111111111111111117 + bArr61111111111111111111111111111111115.length, bArr61111111111111111111111111111111117.length);
                int length211111111111111111111111111111111111111111111111111111118 = bArr61111111111111111111111111111111117.length;
                return a(a(bArr711111111111111111111111111111111111111111111111115, this.u, i11111110), this.y, this.A, this.B);
            }
            bArr19 = bArr17;
            bArr20 = bArr56;
            bArr21 = oicq.wlogin_sdk.request.l.J;
            if (bArr21 != null) {
                bArr22 = bArr20;
                if (bArr21.length > 0) {
                    bArr41 = bArr41;
                    bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                    i12++;
                }
                bArr24 = oicq.wlogin_sdk.request.t.R;
                if (bArr24 != null) {
                    bArr25 = bArr6;
                } else {
                    bArr25 = bArr6;
                }
                byte[] bArr51111113 = bArr23;
                byte[] bArr621111111111111111111112 = bArr25;
                byte[] bArr621111111111111111111113 = bArr7;
                byte[] bArr621111111111111111111114 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                byte[] bArr621111111111111111111115 = tlv_t142Var.get_tlv_142(bArr5);
                i13 = i12 + 1 + 1;
                str = this.x.g;
                if (str != null) {
                    i14 = i13;
                    bArr26 = bArr48;
                } else {
                    i14 = i13;
                    bArr26 = bArr48;
                }
                if (bArr3 != null) {
                    bArr27 = bArr50;
                } else {
                    bArr27 = bArr50;
                }
                if (list != null) {
                    bArr28 = bArr51;
                } else {
                    bArr28 = bArr51;
                }
                if (wloginSigInfoA == null) {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                } else {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                }
                byte[] bArr611111111111111111111111111111111110 = new byte[4];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111111111111110, 0, i11);
                tlv_tVar.set_data(bArr611111111111111111111111111111111110, 4);
                byte[] bArr611111111111111111111111111111111111 = tlv_tVar.get_buf();
                byte[] bArr611111111111111111111111111111111112 = new byte[6];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111111111111112, 0, oicq.wlogin_sdk.request.t.au);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111111111111111111111111112, 4, 0);
                tlv_tVar2.set_data(bArr611111111111111111111111111111111112, 6);
                byte[] bArr611111111111111111111111111111111113 = tlv_tVar2.get_buf();
                int i11111111 = i14 + 1 + 1;
                int length211111111111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111111111111111111113.length + bArr621111111111111111111114.length + bArr621111111111111111111115.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                byte[] bArr611111111111111111111111111111111114 = bArr10;
                byte[] bArr611111111111111111111111111111111115 = bArr31;
                byte[] bArr7111111111111111111111111111111111111111111111111114 = new byte[length211111111111111111111111111111111111111111111111111111119 + bArr611111111111111111111111111111111114.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51111113.length + bArr621111111111111111111112.length + bArr611111111111111111111111111111111111.length + bArr611111111111111111111111111111111113.length];
                java.lang.System.arraycopy(bArr35, 0, bArr7111111111111111111111111111111111111111111111111114, 0, bArr35.length);
                int length3111111111111111111111111111111111111111111110 = bArr35.length + 0;
                java.lang.System.arraycopy(bArr36, 0, bArr7111111111111111111111111111111111111111111111111114, length3111111111111111111111111111111111111111111110, bArr36.length);
                int length3111111111111111111111111111111111111111111111 = length3111111111111111111111111111111111111111111110 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr7111111111111111111111111111111111111111111111111114, length3111111111111111111111111111111111111111111111, bArr37.length);
                int length3111111111111111111111111111111111111111111112 = length3111111111111111111111111111111111111111111111 + bArr37.length;
                java.lang.System.arraycopy(bArr40, 0, bArr7111111111111111111111111111111111111111111111111114, length3111111111111111111111111111111111111111111112, bArr40.length);
                int length3111111111111111111111111111111111111111111113 = length3111111111111111111111111111111111111111111112 + bArr40.length;
                java.lang.System.arraycopy(bArr38, 0, bArr7111111111111111111111111111111111111111111111111114, length3111111111111111111111111111111111111111111113, bArr38.length);
                int length3111111111111111111111111111111111111111111114 = length3111111111111111111111111111111111111111111113 + bArr38.length;
                java.lang.System.arraycopy(bArr39, 0, bArr7111111111111111111111111111111111111111111111111114, length3111111111111111111111111111111111111111111114, bArr39.length);
                int length3111111111111111111111111111111111111111111115 = length3111111111111111111111111111111111111111111114 + bArr39.length;
                java.lang.System.arraycopy(bArr621111111111111111111113, 0, bArr7111111111111111111111111111111111111111111111111114, length3111111111111111111111111111111111111111111115, bArr621111111111111111111113.length);
                int length3111111111111111111111111111111111111111111116 = length3111111111111111111111111111111111111111111115 + bArr621111111111111111111113.length;
                java.lang.System.arraycopy(bArr621111111111111111111114, 0, bArr7111111111111111111111111111111111111111111111111114, length3111111111111111111111111111111111111111111116, bArr621111111111111111111114.length);
                int length3111111111111111111111111111111111111111111117 = length3111111111111111111111111111111111111111111116 + bArr621111111111111111111114.length;
                java.lang.System.arraycopy(bArr621111111111111111111115, 0, bArr7111111111111111111111111111111111111111111111111114, length3111111111111111111111111111111111111111111117, bArr621111111111111111111115.length);
                int length1111111111111111111111111111111111111111111111111111111110 = length3111111111111111111111111111111111111111111117 + bArr621111111111111111111115.length;
                java.lang.System.arraycopy(bArr26, 0, bArr7111111111111111111111111111111111111111111111111114, length1111111111111111111111111111111111111111111111111111111110, bArr26.length);
                int length1111111111111111111111111111111111111111111111111111111111 = length1111111111111111111111111111111111111111111111111111111110 + bArr26.length;
                byte[] bArr7111111111111111111111111111111111111111111111111115 = bArr41;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111115, 0, bArr7111111111111111111111111111111111111111111111111114, length1111111111111111111111111111111111111111111111111111111111, bArr7111111111111111111111111111111111111111111111111115.length);
                int length1111111111111111111111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111111111111111111111 + bArr7111111111111111111111111111111111111111111111111115.length;
                byte[] bArr7111111111111111111111111111111111111111111111111116 = bArr8;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111116, 0, bArr7111111111111111111111111111111111111111111111111114, length1111111111111111111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111111111111111116.length);
                int length1111111111111111111111111111111111111111111111111111111113 = length1111111111111111111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111111111111111116.length;
                byte[] bArr7111111111111111111111111111111111111111111111111117 = bArr30;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111117, 0, bArr7111111111111111111111111111111111111111111111111114, length1111111111111111111111111111111111111111111111111111111113, bArr7111111111111111111111111111111111111111111111111117.length);
                int length1111111111111111111111111111111111111111111111111111111114 = length1111111111111111111111111111111111111111111111111111111113 + bArr7111111111111111111111111111111111111111111111111117.length;
                java.lang.System.arraycopy(bArr42, 0, bArr7111111111111111111111111111111111111111111111111114, length1111111111111111111111111111111111111111111111111111111114, bArr42.length);
                int length1111111111111111111111111111111111111111111111111111111115 = length1111111111111111111111111111111111111111111111111111111114 + bArr42.length;
                java.lang.System.arraycopy(bArr43, 0, bArr7111111111111111111111111111111111111111111111111114, length1111111111111111111111111111111111111111111111111111111115, bArr43.length);
                int length1111111111111111111111111111111111111111111111111111111116 = length1111111111111111111111111111111111111111111111111111111115 + bArr43.length;
                java.lang.System.arraycopy(bArr44, 0, bArr7111111111111111111111111111111111111111111111111114, length1111111111111111111111111111111111111111111111111111111116, bArr44.length);
                int length1111111111111111111111111111111111111111111111111111111117 = length1111111111111111111111111111111111111111111111111111111116 + bArr44.length;
                byte[] bArr7111111111111111111111111111111111111111111111111118 = bArr29;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111118, 0, bArr7111111111111111111111111111111111111111111111111114, length1111111111111111111111111111111111111111111111111111111117, bArr7111111111111111111111111111111111111111111111111118.length);
                int length1111111111111111111111111111111111111111111111111111111118 = length1111111111111111111111111111111111111111111111111111111117 + bArr7111111111111111111111111111111111111111111111111118.length;
                java.lang.System.arraycopy(bArr45, 0, bArr7111111111111111111111111111111111111111111111111114, length1111111111111111111111111111111111111111111111111111111118, bArr45.length);
                int length1111111111111111111111111111111111111111111111111111111119 = length1111111111111111111111111111111111111111111111111111111118 + bArr45.length;
                byte[] bArr7111111111111111111111111111111111111111111111111119 = bArr13;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111119, 0, bArr7111111111111111111111111111111111111111111111111114, length1111111111111111111111111111111111111111111111111111111119, bArr7111111111111111111111111111111111111111111111111119.length);
                int length2111111111111111111111111111111111111111111111111111111110 = length1111111111111111111111111111111111111111111111111111111119 + bArr7111111111111111111111111111111111111111111111111119.length;
                java.lang.System.arraycopy(bArr611111111111111111111111111111111114, 0, bArr7111111111111111111111111111111111111111111111111114, length2111111111111111111111111111111111111111111111111111111110, bArr611111111111111111111111111111111114.length);
                int length2111111111111111111111111111111111111111111111111111111111 = length2111111111111111111111111111111111111111111111111111111110 + bArr611111111111111111111111111111111114.length;
                java.lang.System.arraycopy(bArr611111111111111111111111111111111115, 0, bArr7111111111111111111111111111111111111111111111111114, length2111111111111111111111111111111111111111111111111111111111, bArr611111111111111111111111111111111115.length);
                int length2111111111111111111111111111111111111111111111111111111112 = length2111111111111111111111111111111111111111111111111111111111 + bArr611111111111111111111111111111111115.length;
                byte[] bArr71111111111111111111111111111111111111111111111111110 = bArr16;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111110, 0, bArr7111111111111111111111111111111111111111111111111114, length2111111111111111111111111111111111111111111111111111111112, bArr71111111111111111111111111111111111111111111111111110.length);
                int length2111111111111111111111111111111111111111111111111111111113 = length2111111111111111111111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111111111111111111110.length;
                byte[] bArr71111111111111111111111111111111111111111111111111111 = bArr19;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111, 0, bArr7111111111111111111111111111111111111111111111111114, length2111111111111111111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111111111111111111111.length);
                int length2111111111111111111111111111111111111111111111111111111114 = length2111111111111111111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111111111111111111111.length;
                byte[] bArr71111111111111111111111111111111111111111111111111112 = bArr22;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111112, 0, bArr7111111111111111111111111111111111111111111111111114, length2111111111111111111111111111111111111111111111111111111114, bArr71111111111111111111111111111111111111111111111111112.length);
                int length2111111111111111111111111111111111111111111111111111111115 = length2111111111111111111111111111111111111111111111111111111114 + bArr71111111111111111111111111111111111111111111111111112.length;
                java.lang.System.arraycopy(bArr51111113, 0, bArr7111111111111111111111111111111111111111111111111114, length2111111111111111111111111111111111111111111111111111111115, bArr51111113.length);
                int length2111111111111111111111111111111111111111111111111111111116 = length2111111111111111111111111111111111111111111111111111111115 + bArr51111113.length;
                java.lang.System.arraycopy(bArr621111111111111111111112, 0, bArr7111111111111111111111111111111111111111111111111114, length2111111111111111111111111111111111111111111111111111111116, bArr621111111111111111111112.length);
                int length2111111111111111111111111111111111111111111111111111111117 = length2111111111111111111111111111111111111111111111111111111116 + bArr621111111111111111111112.length;
                java.lang.System.arraycopy(bArr611111111111111111111111111111111111, 0, bArr7111111111111111111111111111111111111111111111111114, length2111111111111111111111111111111111111111111111111111111117, bArr611111111111111111111111111111111111.length);
                java.lang.System.arraycopy(bArr611111111111111111111111111111111113, 0, bArr7111111111111111111111111111111111111111111111111114, length2111111111111111111111111111111111111111111111111111111117 + bArr611111111111111111111111111111111111.length, bArr611111111111111111111111111111111113.length);
                int length2111111111111111111111111111111111111111111111111111111118 = bArr611111111111111111111111111111111113.length;
                return a(a(bArr7111111111111111111111111111111111111111111111111114, this.u, i11111111), this.y, this.A, this.B);
            }
            bArr22 = bArr20;
            bArr23 = bArr57;
            bArr24 = oicq.wlogin_sdk.request.t.R;
            if (bArr24 != null) {
                bArr25 = bArr6;
            } else {
                bArr25 = bArr6;
            }
            byte[] bArr51111114 = bArr23;
            byte[] bArr621111111111111111111116 = bArr25;
            byte[] bArr621111111111111111111117 = bArr7;
            byte[] bArr621111111111111111111118 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
            byte[] bArr621111111111111111111119 = tlv_t142Var.get_tlv_142(bArr5);
            i13 = i12 + 1 + 1;
            str = this.x.g;
            if (str != null) {
                i14 = i13;
                bArr26 = bArr48;
            } else {
                i14 = i13;
                bArr26 = bArr48;
            }
            if (bArr3 != null) {
                bArr27 = bArr50;
            } else {
                bArr27 = bArr50;
            }
            if (list != null) {
                bArr28 = bArr51;
            } else {
                bArr28 = bArr51;
            }
            if (wloginSigInfoA == null) {
                bArr29 = bArr28;
                bArr30 = bArr27;
                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                bArr31 = bArr53;
            } else {
                bArr29 = bArr28;
                bArr30 = bArr27;
                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                bArr31 = bArr53;
            }
            byte[] bArr611111111111111111111111111111111116 = new byte[4];
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111111111111116, 0, i11);
            tlv_tVar.set_data(bArr611111111111111111111111111111111116, 4);
            byte[] bArr611111111111111111111111111111111117 = tlv_tVar.get_buf();
            byte[] bArr611111111111111111111111111111111118 = new byte[6];
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111111111111118, 0, oicq.wlogin_sdk.request.t.au);
            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111111111111111111111111118, 4, 0);
            tlv_tVar2.set_data(bArr611111111111111111111111111111111118, 6);
            byte[] bArr611111111111111111111111111111111119 = tlv_tVar2.get_buf();
            int i11111112 = i14 + 1 + 1;
            int length2111111111111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111111111111111111117.length + bArr621111111111111111111118.length + bArr621111111111111111111119.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
            byte[] bArr6111111111111111111111111111111111110 = bArr10;
            byte[] bArr6111111111111111111111111111111111111 = bArr31;
            byte[] bArr71111111111111111111111111111111111111111111111111113 = new byte[length2111111111111111111111111111111111111111111111111111111119 + bArr6111111111111111111111111111111111110.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51111114.length + bArr621111111111111111111116.length + bArr611111111111111111111111111111111117.length + bArr611111111111111111111111111111111119.length];
            java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111111111111111111111111111111111111113, 0, bArr35.length);
            int length3111111111111111111111111111111111111111111118 = bArr35.length + 0;
            java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111111111111111111111111111111111111113, length3111111111111111111111111111111111111111111118, bArr36.length);
            int length3111111111111111111111111111111111111111111119 = length3111111111111111111111111111111111111111111118 + bArr36.length;
            java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111111111111111111111111111111111111113, length3111111111111111111111111111111111111111111119, bArr37.length);
            int length31111111111111111111111111111111111111111111110 = length3111111111111111111111111111111111111111111119 + bArr37.length;
            java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111111111111111111111111111111111111113, length31111111111111111111111111111111111111111111110, bArr40.length);
            int length31111111111111111111111111111111111111111111111 = length31111111111111111111111111111111111111111111110 + bArr40.length;
            java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111111111111111111111111111111111111113, length31111111111111111111111111111111111111111111111, bArr38.length);
            int length31111111111111111111111111111111111111111111112 = length31111111111111111111111111111111111111111111111 + bArr38.length;
            java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111111111111111111111111111111111111113, length31111111111111111111111111111111111111111111112, bArr39.length);
            int length31111111111111111111111111111111111111111111113 = length31111111111111111111111111111111111111111111112 + bArr39.length;
            java.lang.System.arraycopy(bArr621111111111111111111117, 0, bArr71111111111111111111111111111111111111111111111111113, length31111111111111111111111111111111111111111111113, bArr621111111111111111111117.length);
            int length31111111111111111111111111111111111111111111114 = length31111111111111111111111111111111111111111111113 + bArr621111111111111111111117.length;
            java.lang.System.arraycopy(bArr621111111111111111111118, 0, bArr71111111111111111111111111111111111111111111111111113, length31111111111111111111111111111111111111111111114, bArr621111111111111111111118.length);
            int length31111111111111111111111111111111111111111111115 = length31111111111111111111111111111111111111111111114 + bArr621111111111111111111118.length;
            java.lang.System.arraycopy(bArr621111111111111111111119, 0, bArr71111111111111111111111111111111111111111111111111113, length31111111111111111111111111111111111111111111115, bArr621111111111111111111119.length);
            int length11111111111111111111111111111111111111111111111111111111110 = length31111111111111111111111111111111111111111111115 + bArr621111111111111111111119.length;
            java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111111111111111111111111111111111111113, length11111111111111111111111111111111111111111111111111111111110, bArr26.length);
            int length11111111111111111111111111111111111111111111111111111111111 = length11111111111111111111111111111111111111111111111111111111110 + bArr26.length;
            byte[] bArr71111111111111111111111111111111111111111111111111114 = bArr41;
            java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111114, 0, bArr71111111111111111111111111111111111111111111111111113, length11111111111111111111111111111111111111111111111111111111111, bArr71111111111111111111111111111111111111111111111111114.length);
            int length11111111111111111111111111111111111111111111111111111111112 = length11111111111111111111111111111111111111111111111111111111111 + bArr71111111111111111111111111111111111111111111111111114.length;
            byte[] bArr71111111111111111111111111111111111111111111111111115 = bArr8;
            java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111115, 0, bArr71111111111111111111111111111111111111111111111111113, length11111111111111111111111111111111111111111111111111111111112, bArr71111111111111111111111111111111111111111111111111115.length);
            int length11111111111111111111111111111111111111111111111111111111113 = length11111111111111111111111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111111111111111111115.length;
            byte[] bArr71111111111111111111111111111111111111111111111111116 = bArr30;
            java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111116, 0, bArr71111111111111111111111111111111111111111111111111113, length11111111111111111111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111111111111111111116.length);
            int length11111111111111111111111111111111111111111111111111111111114 = length11111111111111111111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111111111111111111116.length;
            java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111111111111111111111111111111111111113, length11111111111111111111111111111111111111111111111111111111114, bArr42.length);
            int length11111111111111111111111111111111111111111111111111111111115 = length11111111111111111111111111111111111111111111111111111111114 + bArr42.length;
            java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111111111111111111111111111111111111113, length11111111111111111111111111111111111111111111111111111111115, bArr43.length);
            int length11111111111111111111111111111111111111111111111111111111116 = length11111111111111111111111111111111111111111111111111111111115 + bArr43.length;
            java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111111111111111111111111111111111111113, length11111111111111111111111111111111111111111111111111111111116, bArr44.length);
            int length11111111111111111111111111111111111111111111111111111111117 = length11111111111111111111111111111111111111111111111111111111116 + bArr44.length;
            byte[] bArr71111111111111111111111111111111111111111111111111117 = bArr29;
            java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111117, 0, bArr71111111111111111111111111111111111111111111111111113, length11111111111111111111111111111111111111111111111111111111117, bArr71111111111111111111111111111111111111111111111111117.length);
            int length11111111111111111111111111111111111111111111111111111111118 = length11111111111111111111111111111111111111111111111111111111117 + bArr71111111111111111111111111111111111111111111111111117.length;
            java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111111111111111111111111111111111111113, length11111111111111111111111111111111111111111111111111111111118, bArr45.length);
            int length11111111111111111111111111111111111111111111111111111111119 = length11111111111111111111111111111111111111111111111111111111118 + bArr45.length;
            byte[] bArr71111111111111111111111111111111111111111111111111118 = bArr13;
            java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111118, 0, bArr71111111111111111111111111111111111111111111111111113, length11111111111111111111111111111111111111111111111111111111119, bArr71111111111111111111111111111111111111111111111111118.length);
            int length21111111111111111111111111111111111111111111111111111111110 = length11111111111111111111111111111111111111111111111111111111119 + bArr71111111111111111111111111111111111111111111111111118.length;
            java.lang.System.arraycopy(bArr6111111111111111111111111111111111110, 0, bArr71111111111111111111111111111111111111111111111111113, length21111111111111111111111111111111111111111111111111111111110, bArr6111111111111111111111111111111111110.length);
            int length21111111111111111111111111111111111111111111111111111111111 = length21111111111111111111111111111111111111111111111111111111110 + bArr6111111111111111111111111111111111110.length;
            java.lang.System.arraycopy(bArr6111111111111111111111111111111111111, 0, bArr71111111111111111111111111111111111111111111111111113, length21111111111111111111111111111111111111111111111111111111111, bArr6111111111111111111111111111111111111.length);
            int length21111111111111111111111111111111111111111111111111111111112 = length21111111111111111111111111111111111111111111111111111111111 + bArr6111111111111111111111111111111111111.length;
            byte[] bArr71111111111111111111111111111111111111111111111111119 = bArr16;
            java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111119, 0, bArr71111111111111111111111111111111111111111111111111113, length21111111111111111111111111111111111111111111111111111111112, bArr71111111111111111111111111111111111111111111111111119.length);
            int length21111111111111111111111111111111111111111111111111111111113 = length21111111111111111111111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111111111111111111119.length;
            byte[] bArr711111111111111111111111111111111111111111111111111110 = bArr19;
            java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111110, 0, bArr71111111111111111111111111111111111111111111111111113, length21111111111111111111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111111111111111111110.length);
            int length21111111111111111111111111111111111111111111111111111111114 = length21111111111111111111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111111111111111111110.length;
            byte[] bArr711111111111111111111111111111111111111111111111111111 = bArr22;
            java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111, 0, bArr71111111111111111111111111111111111111111111111111113, length21111111111111111111111111111111111111111111111111111111114, bArr711111111111111111111111111111111111111111111111111111.length);
            int length21111111111111111111111111111111111111111111111111111111115 = length21111111111111111111111111111111111111111111111111111111114 + bArr711111111111111111111111111111111111111111111111111111.length;
            java.lang.System.arraycopy(bArr51111114, 0, bArr71111111111111111111111111111111111111111111111111113, length21111111111111111111111111111111111111111111111111111111115, bArr51111114.length);
            int length21111111111111111111111111111111111111111111111111111111116 = length21111111111111111111111111111111111111111111111111111111115 + bArr51111114.length;
            java.lang.System.arraycopy(bArr621111111111111111111116, 0, bArr71111111111111111111111111111111111111111111111111113, length21111111111111111111111111111111111111111111111111111111116, bArr621111111111111111111116.length);
            int length21111111111111111111111111111111111111111111111111111111117 = length21111111111111111111111111111111111111111111111111111111116 + bArr621111111111111111111116.length;
            java.lang.System.arraycopy(bArr611111111111111111111111111111111117, 0, bArr71111111111111111111111111111111111111111111111111113, length21111111111111111111111111111111111111111111111111111111117, bArr611111111111111111111111111111111117.length);
            java.lang.System.arraycopy(bArr611111111111111111111111111111111119, 0, bArr71111111111111111111111111111111111111111111111111113, length21111111111111111111111111111111111111111111111111111111117 + bArr611111111111111111111111111111111117.length, bArr611111111111111111111111111111111119.length);
            int length21111111111111111111111111111111111111111111111111111111118 = bArr611111111111111111111111111111111119.length;
            return a(a(bArr71111111111111111111111111111111111111111111111111113, this.u, i11111112), this.y, this.A, this.B);
        }
        bArr13 = bArr11;
        bArr14 = bArr54;
        bArr15 = oicq.wlogin_sdk.request.t.O;
        if (bArr15 != null) {
            bArr16 = bArr14;
            if (bArr15.length > 0) {
                bArr17 = tlv_t188Var.get_tlv_188(bArr15);
                i12++;
            }
            bArr18 = oicq.wlogin_sdk.request.t.L;
            if (bArr18 != null) {
                bArr19 = bArr17;
                if (bArr18.length > 0) {
                    bArr20 = tlv_t194Var.get_tlv_194(bArr18);
                    i12++;
                }
                bArr21 = oicq.wlogin_sdk.request.l.J;
                if (bArr21 != null) {
                    bArr22 = bArr20;
                    if (bArr21.length > 0) {
                        bArr41 = bArr41;
                        bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                        i12++;
                    }
                    bArr24 = oicq.wlogin_sdk.request.t.R;
                    if (bArr24 != null) {
                        bArr25 = bArr6;
                    } else {
                        bArr25 = bArr6;
                    }
                    byte[] bArr51111115 = bArr23;
                    byte[] bArr6211111111111111111111110 = bArr25;
                    byte[] bArr6211111111111111111111111 = bArr7;
                    byte[] bArr6211111111111111111111112 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                    byte[] bArr6211111111111111111111113 = tlv_t142Var.get_tlv_142(bArr5);
                    i13 = i12 + 1 + 1;
                    str = this.x.g;
                    if (str != null) {
                        i14 = i13;
                        bArr26 = bArr48;
                    } else {
                        i14 = i13;
                        bArr26 = bArr48;
                    }
                    if (bArr3 != null) {
                        bArr27 = bArr50;
                    } else {
                        bArr27 = bArr50;
                    }
                    if (list != null) {
                        bArr28 = bArr51;
                    } else {
                        bArr28 = bArr51;
                    }
                    if (wloginSigInfoA == null) {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    } else {
                        bArr29 = bArr28;
                        bArr30 = bArr27;
                        oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                        bArr31 = bArr53;
                    }
                    byte[] bArr6111111111111111111111111111111111112 = new byte[4];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111111111111111112, 0, i11);
                    tlv_tVar.set_data(bArr6111111111111111111111111111111111112, 4);
                    byte[] bArr6111111111111111111111111111111111113 = tlv_tVar.get_buf();
                    byte[] bArr6111111111111111111111111111111111114 = new byte[6];
                    oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111111111111111114, 0, oicq.wlogin_sdk.request.t.au);
                    oicq.wlogin_sdk.tools.util.int16_to_buf(bArr6111111111111111111111111111111111114, 4, 0);
                    tlv_tVar2.set_data(bArr6111111111111111111111111111111111114, 6);
                    byte[] bArr6111111111111111111111111111111111115 = tlv_tVar2.get_buf();
                    int i11111113 = i14 + 1 + 1;
                    int length21111111111111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211111111111111111111111.length + bArr6211111111111111111111112.length + bArr6211111111111111111111113.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                    byte[] bArr6111111111111111111111111111111111116 = bArr10;
                    byte[] bArr6111111111111111111111111111111111117 = bArr31;
                    byte[] bArr711111111111111111111111111111111111111111111111111112 = new byte[length21111111111111111111111111111111111111111111111111111111119 + bArr6111111111111111111111111111111111116.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51111115.length + bArr6211111111111111111111110.length + bArr6111111111111111111111111111111111113.length + bArr6111111111111111111111111111111111115.length];
                    java.lang.System.arraycopy(bArr35, 0, bArr711111111111111111111111111111111111111111111111111112, 0, bArr35.length);
                    int length31111111111111111111111111111111111111111111116 = bArr35.length + 0;
                    java.lang.System.arraycopy(bArr36, 0, bArr711111111111111111111111111111111111111111111111111112, length31111111111111111111111111111111111111111111116, bArr36.length);
                    int length31111111111111111111111111111111111111111111117 = length31111111111111111111111111111111111111111111116 + bArr36.length;
                    java.lang.System.arraycopy(bArr37, 0, bArr711111111111111111111111111111111111111111111111111112, length31111111111111111111111111111111111111111111117, bArr37.length);
                    int length31111111111111111111111111111111111111111111118 = length31111111111111111111111111111111111111111111117 + bArr37.length;
                    java.lang.System.arraycopy(bArr40, 0, bArr711111111111111111111111111111111111111111111111111112, length31111111111111111111111111111111111111111111118, bArr40.length);
                    int length31111111111111111111111111111111111111111111119 = length31111111111111111111111111111111111111111111118 + bArr40.length;
                    java.lang.System.arraycopy(bArr38, 0, bArr711111111111111111111111111111111111111111111111111112, length31111111111111111111111111111111111111111111119, bArr38.length);
                    int length311111111111111111111111111111111111111111111110 = length31111111111111111111111111111111111111111111119 + bArr38.length;
                    java.lang.System.arraycopy(bArr39, 0, bArr711111111111111111111111111111111111111111111111111112, length311111111111111111111111111111111111111111111110, bArr39.length);
                    int length311111111111111111111111111111111111111111111111 = length311111111111111111111111111111111111111111111110 + bArr39.length;
                    java.lang.System.arraycopy(bArr6211111111111111111111111, 0, bArr711111111111111111111111111111111111111111111111111112, length311111111111111111111111111111111111111111111111, bArr6211111111111111111111111.length);
                    int length311111111111111111111111111111111111111111111112 = length311111111111111111111111111111111111111111111111 + bArr6211111111111111111111111.length;
                    java.lang.System.arraycopy(bArr6211111111111111111111112, 0, bArr711111111111111111111111111111111111111111111111111112, length311111111111111111111111111111111111111111111112, bArr6211111111111111111111112.length);
                    int length311111111111111111111111111111111111111111111113 = length311111111111111111111111111111111111111111111112 + bArr6211111111111111111111112.length;
                    java.lang.System.arraycopy(bArr6211111111111111111111113, 0, bArr711111111111111111111111111111111111111111111111111112, length311111111111111111111111111111111111111111111113, bArr6211111111111111111111113.length);
                    int length111111111111111111111111111111111111111111111111111111111110 = length311111111111111111111111111111111111111111111113 + bArr6211111111111111111111113.length;
                    java.lang.System.arraycopy(bArr26, 0, bArr711111111111111111111111111111111111111111111111111112, length111111111111111111111111111111111111111111111111111111111110, bArr26.length);
                    int length111111111111111111111111111111111111111111111111111111111111 = length111111111111111111111111111111111111111111111111111111111110 + bArr26.length;
                    byte[] bArr711111111111111111111111111111111111111111111111111113 = bArr41;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111113, 0, bArr711111111111111111111111111111111111111111111111111112, length111111111111111111111111111111111111111111111111111111111111, bArr711111111111111111111111111111111111111111111111111113.length);
                    int length111111111111111111111111111111111111111111111111111111111112 = length111111111111111111111111111111111111111111111111111111111111 + bArr711111111111111111111111111111111111111111111111111113.length;
                    byte[] bArr711111111111111111111111111111111111111111111111111114 = bArr8;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111114, 0, bArr711111111111111111111111111111111111111111111111111112, length111111111111111111111111111111111111111111111111111111111112, bArr711111111111111111111111111111111111111111111111111114.length);
                    int length111111111111111111111111111111111111111111111111111111111113 = length111111111111111111111111111111111111111111111111111111111112 + bArr711111111111111111111111111111111111111111111111111114.length;
                    byte[] bArr711111111111111111111111111111111111111111111111111115 = bArr30;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111115, 0, bArr711111111111111111111111111111111111111111111111111112, length111111111111111111111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111111111111111111115.length);
                    int length111111111111111111111111111111111111111111111111111111111114 = length111111111111111111111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111111111111111111115.length;
                    java.lang.System.arraycopy(bArr42, 0, bArr711111111111111111111111111111111111111111111111111112, length111111111111111111111111111111111111111111111111111111111114, bArr42.length);
                    int length111111111111111111111111111111111111111111111111111111111115 = length111111111111111111111111111111111111111111111111111111111114 + bArr42.length;
                    java.lang.System.arraycopy(bArr43, 0, bArr711111111111111111111111111111111111111111111111111112, length111111111111111111111111111111111111111111111111111111111115, bArr43.length);
                    int length111111111111111111111111111111111111111111111111111111111116 = length111111111111111111111111111111111111111111111111111111111115 + bArr43.length;
                    java.lang.System.arraycopy(bArr44, 0, bArr711111111111111111111111111111111111111111111111111112, length111111111111111111111111111111111111111111111111111111111116, bArr44.length);
                    int length111111111111111111111111111111111111111111111111111111111117 = length111111111111111111111111111111111111111111111111111111111116 + bArr44.length;
                    byte[] bArr711111111111111111111111111111111111111111111111111116 = bArr29;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111116, 0, bArr711111111111111111111111111111111111111111111111111112, length111111111111111111111111111111111111111111111111111111111117, bArr711111111111111111111111111111111111111111111111111116.length);
                    int length111111111111111111111111111111111111111111111111111111111118 = length111111111111111111111111111111111111111111111111111111111117 + bArr711111111111111111111111111111111111111111111111111116.length;
                    java.lang.System.arraycopy(bArr45, 0, bArr711111111111111111111111111111111111111111111111111112, length111111111111111111111111111111111111111111111111111111111118, bArr45.length);
                    int length111111111111111111111111111111111111111111111111111111111119 = length111111111111111111111111111111111111111111111111111111111118 + bArr45.length;
                    byte[] bArr711111111111111111111111111111111111111111111111111117 = bArr13;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111117, 0, bArr711111111111111111111111111111111111111111111111111112, length111111111111111111111111111111111111111111111111111111111119, bArr711111111111111111111111111111111111111111111111111117.length);
                    int length211111111111111111111111111111111111111111111111111111111110 = length111111111111111111111111111111111111111111111111111111111119 + bArr711111111111111111111111111111111111111111111111111117.length;
                    java.lang.System.arraycopy(bArr6111111111111111111111111111111111116, 0, bArr711111111111111111111111111111111111111111111111111112, length211111111111111111111111111111111111111111111111111111111110, bArr6111111111111111111111111111111111116.length);
                    int length211111111111111111111111111111111111111111111111111111111111 = length211111111111111111111111111111111111111111111111111111111110 + bArr6111111111111111111111111111111111116.length;
                    java.lang.System.arraycopy(bArr6111111111111111111111111111111111117, 0, bArr711111111111111111111111111111111111111111111111111112, length211111111111111111111111111111111111111111111111111111111111, bArr6111111111111111111111111111111111117.length);
                    int length211111111111111111111111111111111111111111111111111111111112 = length211111111111111111111111111111111111111111111111111111111111 + bArr6111111111111111111111111111111111117.length;
                    byte[] bArr711111111111111111111111111111111111111111111111111118 = bArr16;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111118, 0, bArr711111111111111111111111111111111111111111111111111112, length211111111111111111111111111111111111111111111111111111111112, bArr711111111111111111111111111111111111111111111111111118.length);
                    int length211111111111111111111111111111111111111111111111111111111113 = length211111111111111111111111111111111111111111111111111111111112 + bArr711111111111111111111111111111111111111111111111111118.length;
                    byte[] bArr711111111111111111111111111111111111111111111111111119 = bArr19;
                    java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111119, 0, bArr711111111111111111111111111111111111111111111111111112, length211111111111111111111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111111111111111111119.length);
                    int length211111111111111111111111111111111111111111111111111111111114 = length211111111111111111111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111111111111111111119.length;
                    byte[] bArr7111111111111111111111111111111111111111111111111111110 = bArr22;
                    java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111110, 0, bArr711111111111111111111111111111111111111111111111111112, length211111111111111111111111111111111111111111111111111111111114, bArr7111111111111111111111111111111111111111111111111111110.length);
                    int length211111111111111111111111111111111111111111111111111111111115 = length211111111111111111111111111111111111111111111111111111111114 + bArr7111111111111111111111111111111111111111111111111111110.length;
                    java.lang.System.arraycopy(bArr51111115, 0, bArr711111111111111111111111111111111111111111111111111112, length211111111111111111111111111111111111111111111111111111111115, bArr51111115.length);
                    int length211111111111111111111111111111111111111111111111111111111116 = length211111111111111111111111111111111111111111111111111111111115 + bArr51111115.length;
                    java.lang.System.arraycopy(bArr6211111111111111111111110, 0, bArr711111111111111111111111111111111111111111111111111112, length211111111111111111111111111111111111111111111111111111111116, bArr6211111111111111111111110.length);
                    int length211111111111111111111111111111111111111111111111111111111117 = length211111111111111111111111111111111111111111111111111111111116 + bArr6211111111111111111111110.length;
                    java.lang.System.arraycopy(bArr6111111111111111111111111111111111113, 0, bArr711111111111111111111111111111111111111111111111111112, length211111111111111111111111111111111111111111111111111111111117, bArr6111111111111111111111111111111111113.length);
                    java.lang.System.arraycopy(bArr6111111111111111111111111111111111115, 0, bArr711111111111111111111111111111111111111111111111111112, length211111111111111111111111111111111111111111111111111111111117 + bArr6111111111111111111111111111111111113.length, bArr6111111111111111111111111111111111115.length);
                    int length211111111111111111111111111111111111111111111111111111111118 = bArr6111111111111111111111111111111111115.length;
                    return a(a(bArr711111111111111111111111111111111111111111111111111112, this.u, i11111113), this.y, this.A, this.B);
                }
                bArr22 = bArr20;
                bArr23 = bArr57;
                bArr24 = oicq.wlogin_sdk.request.t.R;
                if (bArr24 != null) {
                    bArr25 = bArr6;
                } else {
                    bArr25 = bArr6;
                }
                byte[] bArr51111116 = bArr23;
                byte[] bArr6211111111111111111111114 = bArr25;
                byte[] bArr6211111111111111111111115 = bArr7;
                byte[] bArr6211111111111111111111116 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                byte[] bArr6211111111111111111111117 = tlv_t142Var.get_tlv_142(bArr5);
                i13 = i12 + 1 + 1;
                str = this.x.g;
                if (str != null) {
                    i14 = i13;
                    bArr26 = bArr48;
                } else {
                    i14 = i13;
                    bArr26 = bArr48;
                }
                if (bArr3 != null) {
                    bArr27 = bArr50;
                } else {
                    bArr27 = bArr50;
                }
                if (list != null) {
                    bArr28 = bArr51;
                } else {
                    bArr28 = bArr51;
                }
                if (wloginSigInfoA == null) {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                } else {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                }
                byte[] bArr6111111111111111111111111111111111118 = new byte[4];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111111111111111118, 0, i11);
                tlv_tVar.set_data(bArr6111111111111111111111111111111111118, 4);
                byte[] bArr6111111111111111111111111111111111119 = tlv_tVar.get_buf();
                byte[] bArr61111111111111111111111111111111111110 = new byte[6];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111111111111111110, 0, oicq.wlogin_sdk.request.t.au);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111111111111111111111111110, 4, 0);
                tlv_tVar2.set_data(bArr61111111111111111111111111111111111110, 6);
                byte[] bArr61111111111111111111111111111111111111 = tlv_tVar2.get_buf();
                int i11111114 = i14 + 1 + 1;
                int length211111111111111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211111111111111111111115.length + bArr6211111111111111111111116.length + bArr6211111111111111111111117.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                byte[] bArr61111111111111111111111111111111111112 = bArr10;
                byte[] bArr61111111111111111111111111111111111113 = bArr31;
                byte[] bArr7111111111111111111111111111111111111111111111111111111 = new byte[length211111111111111111111111111111111111111111111111111111111119 + bArr61111111111111111111111111111111111112.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51111116.length + bArr6211111111111111111111114.length + bArr6111111111111111111111111111111111119.length + bArr61111111111111111111111111111111111111.length];
                java.lang.System.arraycopy(bArr35, 0, bArr7111111111111111111111111111111111111111111111111111111, 0, bArr35.length);
                int length311111111111111111111111111111111111111111111114 = bArr35.length + 0;
                java.lang.System.arraycopy(bArr36, 0, bArr7111111111111111111111111111111111111111111111111111111, length311111111111111111111111111111111111111111111114, bArr36.length);
                int length311111111111111111111111111111111111111111111115 = length311111111111111111111111111111111111111111111114 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr7111111111111111111111111111111111111111111111111111111, length311111111111111111111111111111111111111111111115, bArr37.length);
                int length311111111111111111111111111111111111111111111116 = length311111111111111111111111111111111111111111111115 + bArr37.length;
                java.lang.System.arraycopy(bArr40, 0, bArr7111111111111111111111111111111111111111111111111111111, length311111111111111111111111111111111111111111111116, bArr40.length);
                int length311111111111111111111111111111111111111111111117 = length311111111111111111111111111111111111111111111116 + bArr40.length;
                java.lang.System.arraycopy(bArr38, 0, bArr7111111111111111111111111111111111111111111111111111111, length311111111111111111111111111111111111111111111117, bArr38.length);
                int length311111111111111111111111111111111111111111111118 = length311111111111111111111111111111111111111111111117 + bArr38.length;
                java.lang.System.arraycopy(bArr39, 0, bArr7111111111111111111111111111111111111111111111111111111, length311111111111111111111111111111111111111111111118, bArr39.length);
                int length311111111111111111111111111111111111111111111119 = length311111111111111111111111111111111111111111111118 + bArr39.length;
                java.lang.System.arraycopy(bArr6211111111111111111111115, 0, bArr7111111111111111111111111111111111111111111111111111111, length311111111111111111111111111111111111111111111119, bArr6211111111111111111111115.length);
                int length3111111111111111111111111111111111111111111111110 = length311111111111111111111111111111111111111111111119 + bArr6211111111111111111111115.length;
                java.lang.System.arraycopy(bArr6211111111111111111111116, 0, bArr7111111111111111111111111111111111111111111111111111111, length3111111111111111111111111111111111111111111111110, bArr6211111111111111111111116.length);
                int length3111111111111111111111111111111111111111111111111 = length3111111111111111111111111111111111111111111111110 + bArr6211111111111111111111116.length;
                java.lang.System.arraycopy(bArr6211111111111111111111117, 0, bArr7111111111111111111111111111111111111111111111111111111, length3111111111111111111111111111111111111111111111111, bArr6211111111111111111111117.length);
                int length1111111111111111111111111111111111111111111111111111111111110 = length3111111111111111111111111111111111111111111111111 + bArr6211111111111111111111117.length;
                java.lang.System.arraycopy(bArr26, 0, bArr7111111111111111111111111111111111111111111111111111111, length1111111111111111111111111111111111111111111111111111111111110, bArr26.length);
                int length1111111111111111111111111111111111111111111111111111111111111 = length1111111111111111111111111111111111111111111111111111111111110 + bArr26.length;
                byte[] bArr7111111111111111111111111111111111111111111111111111112 = bArr41;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111112, 0, bArr7111111111111111111111111111111111111111111111111111111, length1111111111111111111111111111111111111111111111111111111111111, bArr7111111111111111111111111111111111111111111111111111112.length);
                int length1111111111111111111111111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111111111111111111111111 + bArr7111111111111111111111111111111111111111111111111111112.length;
                byte[] bArr7111111111111111111111111111111111111111111111111111113 = bArr8;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111113, 0, bArr7111111111111111111111111111111111111111111111111111111, length1111111111111111111111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111111111111111111113.length);
                int length1111111111111111111111111111111111111111111111111111111111113 = length1111111111111111111111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111111111111111111113.length;
                byte[] bArr7111111111111111111111111111111111111111111111111111114 = bArr30;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111114, 0, bArr7111111111111111111111111111111111111111111111111111111, length1111111111111111111111111111111111111111111111111111111111113, bArr7111111111111111111111111111111111111111111111111111114.length);
                int length1111111111111111111111111111111111111111111111111111111111114 = length1111111111111111111111111111111111111111111111111111111111113 + bArr7111111111111111111111111111111111111111111111111111114.length;
                java.lang.System.arraycopy(bArr42, 0, bArr7111111111111111111111111111111111111111111111111111111, length1111111111111111111111111111111111111111111111111111111111114, bArr42.length);
                int length1111111111111111111111111111111111111111111111111111111111115 = length1111111111111111111111111111111111111111111111111111111111114 + bArr42.length;
                java.lang.System.arraycopy(bArr43, 0, bArr7111111111111111111111111111111111111111111111111111111, length1111111111111111111111111111111111111111111111111111111111115, bArr43.length);
                int length1111111111111111111111111111111111111111111111111111111111116 = length1111111111111111111111111111111111111111111111111111111111115 + bArr43.length;
                java.lang.System.arraycopy(bArr44, 0, bArr7111111111111111111111111111111111111111111111111111111, length1111111111111111111111111111111111111111111111111111111111116, bArr44.length);
                int length1111111111111111111111111111111111111111111111111111111111117 = length1111111111111111111111111111111111111111111111111111111111116 + bArr44.length;
                byte[] bArr7111111111111111111111111111111111111111111111111111115 = bArr29;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111115, 0, bArr7111111111111111111111111111111111111111111111111111111, length1111111111111111111111111111111111111111111111111111111111117, bArr7111111111111111111111111111111111111111111111111111115.length);
                int length1111111111111111111111111111111111111111111111111111111111118 = length1111111111111111111111111111111111111111111111111111111111117 + bArr7111111111111111111111111111111111111111111111111111115.length;
                java.lang.System.arraycopy(bArr45, 0, bArr7111111111111111111111111111111111111111111111111111111, length1111111111111111111111111111111111111111111111111111111111118, bArr45.length);
                int length1111111111111111111111111111111111111111111111111111111111119 = length1111111111111111111111111111111111111111111111111111111111118 + bArr45.length;
                byte[] bArr7111111111111111111111111111111111111111111111111111116 = bArr13;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111116, 0, bArr7111111111111111111111111111111111111111111111111111111, length1111111111111111111111111111111111111111111111111111111111119, bArr7111111111111111111111111111111111111111111111111111116.length);
                int length2111111111111111111111111111111111111111111111111111111111110 = length1111111111111111111111111111111111111111111111111111111111119 + bArr7111111111111111111111111111111111111111111111111111116.length;
                java.lang.System.arraycopy(bArr61111111111111111111111111111111111112, 0, bArr7111111111111111111111111111111111111111111111111111111, length2111111111111111111111111111111111111111111111111111111111110, bArr61111111111111111111111111111111111112.length);
                int length2111111111111111111111111111111111111111111111111111111111111 = length2111111111111111111111111111111111111111111111111111111111110 + bArr61111111111111111111111111111111111112.length;
                java.lang.System.arraycopy(bArr61111111111111111111111111111111111113, 0, bArr7111111111111111111111111111111111111111111111111111111, length2111111111111111111111111111111111111111111111111111111111111, bArr61111111111111111111111111111111111113.length);
                int length2111111111111111111111111111111111111111111111111111111111112 = length2111111111111111111111111111111111111111111111111111111111111 + bArr61111111111111111111111111111111111113.length;
                byte[] bArr7111111111111111111111111111111111111111111111111111117 = bArr16;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111117, 0, bArr7111111111111111111111111111111111111111111111111111111, length2111111111111111111111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111111111111111111117.length);
                int length2111111111111111111111111111111111111111111111111111111111113 = length2111111111111111111111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111111111111111111117.length;
                byte[] bArr7111111111111111111111111111111111111111111111111111118 = bArr19;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111118, 0, bArr7111111111111111111111111111111111111111111111111111111, length2111111111111111111111111111111111111111111111111111111111113, bArr7111111111111111111111111111111111111111111111111111118.length);
                int length2111111111111111111111111111111111111111111111111111111111114 = length2111111111111111111111111111111111111111111111111111111111113 + bArr7111111111111111111111111111111111111111111111111111118.length;
                byte[] bArr7111111111111111111111111111111111111111111111111111119 = bArr22;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111119, 0, bArr7111111111111111111111111111111111111111111111111111111, length2111111111111111111111111111111111111111111111111111111111114, bArr7111111111111111111111111111111111111111111111111111119.length);
                int length2111111111111111111111111111111111111111111111111111111111115 = length2111111111111111111111111111111111111111111111111111111111114 + bArr7111111111111111111111111111111111111111111111111111119.length;
                java.lang.System.arraycopy(bArr51111116, 0, bArr7111111111111111111111111111111111111111111111111111111, length2111111111111111111111111111111111111111111111111111111111115, bArr51111116.length);
                int length2111111111111111111111111111111111111111111111111111111111116 = length2111111111111111111111111111111111111111111111111111111111115 + bArr51111116.length;
                java.lang.System.arraycopy(bArr6211111111111111111111114, 0, bArr7111111111111111111111111111111111111111111111111111111, length2111111111111111111111111111111111111111111111111111111111116, bArr6211111111111111111111114.length);
                int length2111111111111111111111111111111111111111111111111111111111117 = length2111111111111111111111111111111111111111111111111111111111116 + bArr6211111111111111111111114.length;
                java.lang.System.arraycopy(bArr6111111111111111111111111111111111119, 0, bArr7111111111111111111111111111111111111111111111111111111, length2111111111111111111111111111111111111111111111111111111111117, bArr6111111111111111111111111111111111119.length);
                java.lang.System.arraycopy(bArr61111111111111111111111111111111111111, 0, bArr7111111111111111111111111111111111111111111111111111111, length2111111111111111111111111111111111111111111111111111111111117 + bArr6111111111111111111111111111111111119.length, bArr61111111111111111111111111111111111111.length);
                int length2111111111111111111111111111111111111111111111111111111111118 = bArr61111111111111111111111111111111111111.length;
                return a(a(bArr7111111111111111111111111111111111111111111111111111111, this.u, i11111114), this.y, this.A, this.B);
            }
            bArr19 = bArr17;
            bArr20 = bArr56;
            bArr21 = oicq.wlogin_sdk.request.l.J;
            if (bArr21 != null) {
                bArr22 = bArr20;
                if (bArr21.length > 0) {
                    bArr41 = bArr41;
                    bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                    i12++;
                }
                bArr24 = oicq.wlogin_sdk.request.t.R;
                if (bArr24 != null) {
                    bArr25 = bArr6;
                } else {
                    bArr25 = bArr6;
                }
                byte[] bArr51111117 = bArr23;
                byte[] bArr6211111111111111111111118 = bArr25;
                byte[] bArr6211111111111111111111119 = bArr7;
                byte[] bArr62111111111111111111111110 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                byte[] bArr62111111111111111111111111 = tlv_t142Var.get_tlv_142(bArr5);
                i13 = i12 + 1 + 1;
                str = this.x.g;
                if (str != null) {
                    i14 = i13;
                    bArr26 = bArr48;
                } else {
                    i14 = i13;
                    bArr26 = bArr48;
                }
                if (bArr3 != null) {
                    bArr27 = bArr50;
                } else {
                    bArr27 = bArr50;
                }
                if (list != null) {
                    bArr28 = bArr51;
                } else {
                    bArr28 = bArr51;
                }
                if (wloginSigInfoA == null) {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                } else {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                }
                byte[] bArr61111111111111111111111111111111111114 = new byte[4];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111111111111111114, 0, i11);
                tlv_tVar.set_data(bArr61111111111111111111111111111111111114, 4);
                byte[] bArr61111111111111111111111111111111111115 = tlv_tVar.get_buf();
                byte[] bArr61111111111111111111111111111111111116 = new byte[6];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111111111111111116, 0, oicq.wlogin_sdk.request.t.au);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111111111111111111111111116, 4, 0);
                tlv_tVar2.set_data(bArr61111111111111111111111111111111111116, 6);
                byte[] bArr61111111111111111111111111111111111117 = tlv_tVar2.get_buf();
                int i11111115 = i14 + 1 + 1;
                int length2111111111111111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr6211111111111111111111119.length + bArr62111111111111111111111110.length + bArr62111111111111111111111111.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                byte[] bArr61111111111111111111111111111111111118 = bArr10;
                byte[] bArr61111111111111111111111111111111111119 = bArr31;
                byte[] bArr71111111111111111111111111111111111111111111111111111110 = new byte[length2111111111111111111111111111111111111111111111111111111111119 + bArr61111111111111111111111111111111111118.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51111117.length + bArr6211111111111111111111118.length + bArr61111111111111111111111111111111111115.length + bArr61111111111111111111111111111111111117.length];
                java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111111111111111111111111111111111111111110, 0, bArr35.length);
                int length3111111111111111111111111111111111111111111111112 = bArr35.length + 0;
                java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111111111111111111111111111111111111111110, length3111111111111111111111111111111111111111111111112, bArr36.length);
                int length3111111111111111111111111111111111111111111111113 = length3111111111111111111111111111111111111111111111112 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111111111111111111111111111111111111111110, length3111111111111111111111111111111111111111111111113, bArr37.length);
                int length3111111111111111111111111111111111111111111111114 = length3111111111111111111111111111111111111111111111113 + bArr37.length;
                java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111111111111111111111111111111111111111110, length3111111111111111111111111111111111111111111111114, bArr40.length);
                int length3111111111111111111111111111111111111111111111115 = length3111111111111111111111111111111111111111111111114 + bArr40.length;
                java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111111111111111111111111111111111111111110, length3111111111111111111111111111111111111111111111115, bArr38.length);
                int length3111111111111111111111111111111111111111111111116 = length3111111111111111111111111111111111111111111111115 + bArr38.length;
                java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111111111111111111111111111111111111111110, length3111111111111111111111111111111111111111111111116, bArr39.length);
                int length3111111111111111111111111111111111111111111111117 = length3111111111111111111111111111111111111111111111116 + bArr39.length;
                java.lang.System.arraycopy(bArr6211111111111111111111119, 0, bArr71111111111111111111111111111111111111111111111111111110, length3111111111111111111111111111111111111111111111117, bArr6211111111111111111111119.length);
                int length3111111111111111111111111111111111111111111111118 = length3111111111111111111111111111111111111111111111117 + bArr6211111111111111111111119.length;
                java.lang.System.arraycopy(bArr62111111111111111111111110, 0, bArr71111111111111111111111111111111111111111111111111111110, length3111111111111111111111111111111111111111111111118, bArr62111111111111111111111110.length);
                int length3111111111111111111111111111111111111111111111119 = length3111111111111111111111111111111111111111111111118 + bArr62111111111111111111111110.length;
                java.lang.System.arraycopy(bArr62111111111111111111111111, 0, bArr71111111111111111111111111111111111111111111111111111110, length3111111111111111111111111111111111111111111111119, bArr62111111111111111111111111.length);
                int length11111111111111111111111111111111111111111111111111111111111110 = length3111111111111111111111111111111111111111111111119 + bArr62111111111111111111111111.length;
                java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111111111111111111111111111111111111111110, length11111111111111111111111111111111111111111111111111111111111110, bArr26.length);
                int length11111111111111111111111111111111111111111111111111111111111111 = length11111111111111111111111111111111111111111111111111111111111110 + bArr26.length;
                byte[] bArr71111111111111111111111111111111111111111111111111111111 = bArr41;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111111, 0, bArr71111111111111111111111111111111111111111111111111111110, length11111111111111111111111111111111111111111111111111111111111111, bArr71111111111111111111111111111111111111111111111111111111.length);
                int length11111111111111111111111111111111111111111111111111111111111112 = length11111111111111111111111111111111111111111111111111111111111111 + bArr71111111111111111111111111111111111111111111111111111111.length;
                byte[] bArr71111111111111111111111111111111111111111111111111111112 = bArr8;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111112, 0, bArr71111111111111111111111111111111111111111111111111111110, length11111111111111111111111111111111111111111111111111111111111112, bArr71111111111111111111111111111111111111111111111111111112.length);
                int length11111111111111111111111111111111111111111111111111111111111113 = length11111111111111111111111111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111111111111111111111112.length;
                byte[] bArr71111111111111111111111111111111111111111111111111111113 = bArr30;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111113, 0, bArr71111111111111111111111111111111111111111111111111111110, length11111111111111111111111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111111111111111111111113.length);
                int length11111111111111111111111111111111111111111111111111111111111114 = length11111111111111111111111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111111111111111111111113.length;
                java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111111111111111111111111111111111111111110, length11111111111111111111111111111111111111111111111111111111111114, bArr42.length);
                int length11111111111111111111111111111111111111111111111111111111111115 = length11111111111111111111111111111111111111111111111111111111111114 + bArr42.length;
                java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111111111111111111111111111111111111111110, length11111111111111111111111111111111111111111111111111111111111115, bArr43.length);
                int length11111111111111111111111111111111111111111111111111111111111116 = length11111111111111111111111111111111111111111111111111111111111115 + bArr43.length;
                java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111111111111111111111111111111111111111110, length11111111111111111111111111111111111111111111111111111111111116, bArr44.length);
                int length11111111111111111111111111111111111111111111111111111111111117 = length11111111111111111111111111111111111111111111111111111111111116 + bArr44.length;
                byte[] bArr71111111111111111111111111111111111111111111111111111114 = bArr29;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111114, 0, bArr71111111111111111111111111111111111111111111111111111110, length11111111111111111111111111111111111111111111111111111111111117, bArr71111111111111111111111111111111111111111111111111111114.length);
                int length11111111111111111111111111111111111111111111111111111111111118 = length11111111111111111111111111111111111111111111111111111111111117 + bArr71111111111111111111111111111111111111111111111111111114.length;
                java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111111111111111111111111111111111111111110, length11111111111111111111111111111111111111111111111111111111111118, bArr45.length);
                int length11111111111111111111111111111111111111111111111111111111111119 = length11111111111111111111111111111111111111111111111111111111111118 + bArr45.length;
                byte[] bArr71111111111111111111111111111111111111111111111111111115 = bArr13;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111115, 0, bArr71111111111111111111111111111111111111111111111111111110, length11111111111111111111111111111111111111111111111111111111111119, bArr71111111111111111111111111111111111111111111111111111115.length);
                int length21111111111111111111111111111111111111111111111111111111111110 = length11111111111111111111111111111111111111111111111111111111111119 + bArr71111111111111111111111111111111111111111111111111111115.length;
                java.lang.System.arraycopy(bArr61111111111111111111111111111111111118, 0, bArr71111111111111111111111111111111111111111111111111111110, length21111111111111111111111111111111111111111111111111111111111110, bArr61111111111111111111111111111111111118.length);
                int length21111111111111111111111111111111111111111111111111111111111111 = length21111111111111111111111111111111111111111111111111111111111110 + bArr61111111111111111111111111111111111118.length;
                java.lang.System.arraycopy(bArr61111111111111111111111111111111111119, 0, bArr71111111111111111111111111111111111111111111111111111110, length21111111111111111111111111111111111111111111111111111111111111, bArr61111111111111111111111111111111111119.length);
                int length21111111111111111111111111111111111111111111111111111111111112 = length21111111111111111111111111111111111111111111111111111111111111 + bArr61111111111111111111111111111111111119.length;
                byte[] bArr71111111111111111111111111111111111111111111111111111116 = bArr16;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111116, 0, bArr71111111111111111111111111111111111111111111111111111110, length21111111111111111111111111111111111111111111111111111111111112, bArr71111111111111111111111111111111111111111111111111111116.length);
                int length21111111111111111111111111111111111111111111111111111111111113 = length21111111111111111111111111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111111111111111111111116.length;
                byte[] bArr71111111111111111111111111111111111111111111111111111117 = bArr19;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111117, 0, bArr71111111111111111111111111111111111111111111111111111110, length21111111111111111111111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111111111111111111111117.length);
                int length21111111111111111111111111111111111111111111111111111111111114 = length21111111111111111111111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111111111111111111111117.length;
                byte[] bArr71111111111111111111111111111111111111111111111111111118 = bArr22;
                java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111118, 0, bArr71111111111111111111111111111111111111111111111111111110, length21111111111111111111111111111111111111111111111111111111111114, bArr71111111111111111111111111111111111111111111111111111118.length);
                int length21111111111111111111111111111111111111111111111111111111111115 = length21111111111111111111111111111111111111111111111111111111111114 + bArr71111111111111111111111111111111111111111111111111111118.length;
                java.lang.System.arraycopy(bArr51111117, 0, bArr71111111111111111111111111111111111111111111111111111110, length21111111111111111111111111111111111111111111111111111111111115, bArr51111117.length);
                int length21111111111111111111111111111111111111111111111111111111111116 = length21111111111111111111111111111111111111111111111111111111111115 + bArr51111117.length;
                java.lang.System.arraycopy(bArr6211111111111111111111118, 0, bArr71111111111111111111111111111111111111111111111111111110, length21111111111111111111111111111111111111111111111111111111111116, bArr6211111111111111111111118.length);
                int length21111111111111111111111111111111111111111111111111111111111117 = length21111111111111111111111111111111111111111111111111111111111116 + bArr6211111111111111111111118.length;
                java.lang.System.arraycopy(bArr61111111111111111111111111111111111115, 0, bArr71111111111111111111111111111111111111111111111111111110, length21111111111111111111111111111111111111111111111111111111111117, bArr61111111111111111111111111111111111115.length);
                java.lang.System.arraycopy(bArr61111111111111111111111111111111111117, 0, bArr71111111111111111111111111111111111111111111111111111110, length21111111111111111111111111111111111111111111111111111111111117 + bArr61111111111111111111111111111111111115.length, bArr61111111111111111111111111111111111117.length);
                int length21111111111111111111111111111111111111111111111111111111111118 = bArr61111111111111111111111111111111111117.length;
                return a(a(bArr71111111111111111111111111111111111111111111111111111110, this.u, i11111115), this.y, this.A, this.B);
            }
            bArr22 = bArr20;
            bArr23 = bArr57;
            bArr24 = oicq.wlogin_sdk.request.t.R;
            if (bArr24 != null) {
                bArr25 = bArr6;
            } else {
                bArr25 = bArr6;
            }
            byte[] bArr51111118 = bArr23;
            byte[] bArr62111111111111111111111112 = bArr25;
            byte[] bArr62111111111111111111111113 = bArr7;
            byte[] bArr62111111111111111111111114 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
            byte[] bArr62111111111111111111111115 = tlv_t142Var.get_tlv_142(bArr5);
            i13 = i12 + 1 + 1;
            str = this.x.g;
            if (str != null) {
                i14 = i13;
                bArr26 = bArr48;
            } else {
                i14 = i13;
                bArr26 = bArr48;
            }
            if (bArr3 != null) {
                bArr27 = bArr50;
            } else {
                bArr27 = bArr50;
            }
            if (list != null) {
                bArr28 = bArr51;
            } else {
                bArr28 = bArr51;
            }
            if (wloginSigInfoA == null) {
                bArr29 = bArr28;
                bArr30 = bArr27;
                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                bArr31 = bArr53;
            } else {
                bArr29 = bArr28;
                bArr30 = bArr27;
                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                bArr31 = bArr53;
            }
            byte[] bArr611111111111111111111111111111111111110 = new byte[4];
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111111111111111110, 0, i11);
            tlv_tVar.set_data(bArr611111111111111111111111111111111111110, 4);
            byte[] bArr611111111111111111111111111111111111111 = tlv_tVar.get_buf();
            byte[] bArr611111111111111111111111111111111111112 = new byte[6];
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111111111111111112, 0, oicq.wlogin_sdk.request.t.au);
            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111111111111111111111111111112, 4, 0);
            tlv_tVar2.set_data(bArr611111111111111111111111111111111111112, 6);
            byte[] bArr611111111111111111111111111111111111113 = tlv_tVar2.get_buf();
            int i11111116 = i14 + 1 + 1;
            int length21111111111111111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111111111111111111111113.length + bArr62111111111111111111111114.length + bArr62111111111111111111111115.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
            byte[] bArr611111111111111111111111111111111111114 = bArr10;
            byte[] bArr611111111111111111111111111111111111115 = bArr31;
            byte[] bArr71111111111111111111111111111111111111111111111111111119 = new byte[length21111111111111111111111111111111111111111111111111111111111119 + bArr611111111111111111111111111111111111114.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51111118.length + bArr62111111111111111111111112.length + bArr611111111111111111111111111111111111111.length + bArr611111111111111111111111111111111111113.length];
            java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111111111111111111111111111111111111111119, 0, bArr35.length);
            int length31111111111111111111111111111111111111111111111110 = bArr35.length + 0;
            java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111111111111111111111111111111111111111119, length31111111111111111111111111111111111111111111111110, bArr36.length);
            int length31111111111111111111111111111111111111111111111111 = length31111111111111111111111111111111111111111111111110 + bArr36.length;
            java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111111111111111111111111111111111111111119, length31111111111111111111111111111111111111111111111111, bArr37.length);
            int length31111111111111111111111111111111111111111111111112 = length31111111111111111111111111111111111111111111111111 + bArr37.length;
            java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111111111111111111111111111111111111111119, length31111111111111111111111111111111111111111111111112, bArr40.length);
            int length31111111111111111111111111111111111111111111111113 = length31111111111111111111111111111111111111111111111112 + bArr40.length;
            java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111111111111111111111111111111111111111119, length31111111111111111111111111111111111111111111111113, bArr38.length);
            int length31111111111111111111111111111111111111111111111114 = length31111111111111111111111111111111111111111111111113 + bArr38.length;
            java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111111111111111111111111111111111111111119, length31111111111111111111111111111111111111111111111114, bArr39.length);
            int length31111111111111111111111111111111111111111111111115 = length31111111111111111111111111111111111111111111111114 + bArr39.length;
            java.lang.System.arraycopy(bArr62111111111111111111111113, 0, bArr71111111111111111111111111111111111111111111111111111119, length31111111111111111111111111111111111111111111111115, bArr62111111111111111111111113.length);
            int length31111111111111111111111111111111111111111111111116 = length31111111111111111111111111111111111111111111111115 + bArr62111111111111111111111113.length;
            java.lang.System.arraycopy(bArr62111111111111111111111114, 0, bArr71111111111111111111111111111111111111111111111111111119, length31111111111111111111111111111111111111111111111116, bArr62111111111111111111111114.length);
            int length31111111111111111111111111111111111111111111111117 = length31111111111111111111111111111111111111111111111116 + bArr62111111111111111111111114.length;
            java.lang.System.arraycopy(bArr62111111111111111111111115, 0, bArr71111111111111111111111111111111111111111111111111111119, length31111111111111111111111111111111111111111111111117, bArr62111111111111111111111115.length);
            int length111111111111111111111111111111111111111111111111111111111111110 = length31111111111111111111111111111111111111111111111117 + bArr62111111111111111111111115.length;
            java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111111111111111111111111111111111111111119, length111111111111111111111111111111111111111111111111111111111111110, bArr26.length);
            int length111111111111111111111111111111111111111111111111111111111111111 = length111111111111111111111111111111111111111111111111111111111111110 + bArr26.length;
            byte[] bArr711111111111111111111111111111111111111111111111111111110 = bArr41;
            java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111110, 0, bArr71111111111111111111111111111111111111111111111111111119, length111111111111111111111111111111111111111111111111111111111111111, bArr711111111111111111111111111111111111111111111111111111110.length);
            int length111111111111111111111111111111111111111111111111111111111111112 = length111111111111111111111111111111111111111111111111111111111111111 + bArr711111111111111111111111111111111111111111111111111111110.length;
            byte[] bArr711111111111111111111111111111111111111111111111111111111 = bArr8;
            java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111111, 0, bArr71111111111111111111111111111111111111111111111111111119, length111111111111111111111111111111111111111111111111111111111111112, bArr711111111111111111111111111111111111111111111111111111111.length);
            int length111111111111111111111111111111111111111111111111111111111111113 = length111111111111111111111111111111111111111111111111111111111111112 + bArr711111111111111111111111111111111111111111111111111111111.length;
            byte[] bArr711111111111111111111111111111111111111111111111111111112 = bArr30;
            java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111112, 0, bArr71111111111111111111111111111111111111111111111111111119, length111111111111111111111111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111111111111111111111112.length);
            int length111111111111111111111111111111111111111111111111111111111111114 = length111111111111111111111111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111111111111111111111112.length;
            java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111111111111111111111111111111111111111119, length111111111111111111111111111111111111111111111111111111111111114, bArr42.length);
            int length111111111111111111111111111111111111111111111111111111111111115 = length111111111111111111111111111111111111111111111111111111111111114 + bArr42.length;
            java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111111111111111111111111111111111111111119, length111111111111111111111111111111111111111111111111111111111111115, bArr43.length);
            int length111111111111111111111111111111111111111111111111111111111111116 = length111111111111111111111111111111111111111111111111111111111111115 + bArr43.length;
            java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111111111111111111111111111111111111111119, length111111111111111111111111111111111111111111111111111111111111116, bArr44.length);
            int length111111111111111111111111111111111111111111111111111111111111117 = length111111111111111111111111111111111111111111111111111111111111116 + bArr44.length;
            byte[] bArr711111111111111111111111111111111111111111111111111111113 = bArr29;
            java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111113, 0, bArr71111111111111111111111111111111111111111111111111111119, length111111111111111111111111111111111111111111111111111111111111117, bArr711111111111111111111111111111111111111111111111111111113.length);
            int length111111111111111111111111111111111111111111111111111111111111118 = length111111111111111111111111111111111111111111111111111111111111117 + bArr711111111111111111111111111111111111111111111111111111113.length;
            java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111111111111111111111111111111111111111119, length111111111111111111111111111111111111111111111111111111111111118, bArr45.length);
            int length111111111111111111111111111111111111111111111111111111111111119 = length111111111111111111111111111111111111111111111111111111111111118 + bArr45.length;
            byte[] bArr711111111111111111111111111111111111111111111111111111114 = bArr13;
            java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111114, 0, bArr71111111111111111111111111111111111111111111111111111119, length111111111111111111111111111111111111111111111111111111111111119, bArr711111111111111111111111111111111111111111111111111111114.length);
            int length211111111111111111111111111111111111111111111111111111111111110 = length111111111111111111111111111111111111111111111111111111111111119 + bArr711111111111111111111111111111111111111111111111111111114.length;
            java.lang.System.arraycopy(bArr611111111111111111111111111111111111114, 0, bArr71111111111111111111111111111111111111111111111111111119, length211111111111111111111111111111111111111111111111111111111111110, bArr611111111111111111111111111111111111114.length);
            int length211111111111111111111111111111111111111111111111111111111111111 = length211111111111111111111111111111111111111111111111111111111111110 + bArr611111111111111111111111111111111111114.length;
            java.lang.System.arraycopy(bArr611111111111111111111111111111111111115, 0, bArr71111111111111111111111111111111111111111111111111111119, length211111111111111111111111111111111111111111111111111111111111111, bArr611111111111111111111111111111111111115.length);
            int length211111111111111111111111111111111111111111111111111111111111112 = length211111111111111111111111111111111111111111111111111111111111111 + bArr611111111111111111111111111111111111115.length;
            byte[] bArr711111111111111111111111111111111111111111111111111111115 = bArr16;
            java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111115, 0, bArr71111111111111111111111111111111111111111111111111111119, length211111111111111111111111111111111111111111111111111111111111112, bArr711111111111111111111111111111111111111111111111111111115.length);
            int length211111111111111111111111111111111111111111111111111111111111113 = length211111111111111111111111111111111111111111111111111111111111112 + bArr711111111111111111111111111111111111111111111111111111115.length;
            byte[] bArr711111111111111111111111111111111111111111111111111111116 = bArr19;
            java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111116, 0, bArr71111111111111111111111111111111111111111111111111111119, length211111111111111111111111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111111111111111111111116.length);
            int length211111111111111111111111111111111111111111111111111111111111114 = length211111111111111111111111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111111111111111111111116.length;
            byte[] bArr711111111111111111111111111111111111111111111111111111117 = bArr22;
            java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111117, 0, bArr71111111111111111111111111111111111111111111111111111119, length211111111111111111111111111111111111111111111111111111111111114, bArr711111111111111111111111111111111111111111111111111111117.length);
            int length211111111111111111111111111111111111111111111111111111111111115 = length211111111111111111111111111111111111111111111111111111111111114 + bArr711111111111111111111111111111111111111111111111111111117.length;
            java.lang.System.arraycopy(bArr51111118, 0, bArr71111111111111111111111111111111111111111111111111111119, length211111111111111111111111111111111111111111111111111111111111115, bArr51111118.length);
            int length211111111111111111111111111111111111111111111111111111111111116 = length211111111111111111111111111111111111111111111111111111111111115 + bArr51111118.length;
            java.lang.System.arraycopy(bArr62111111111111111111111112, 0, bArr71111111111111111111111111111111111111111111111111111119, length211111111111111111111111111111111111111111111111111111111111116, bArr62111111111111111111111112.length);
            int length211111111111111111111111111111111111111111111111111111111111117 = length211111111111111111111111111111111111111111111111111111111111116 + bArr62111111111111111111111112.length;
            java.lang.System.arraycopy(bArr611111111111111111111111111111111111111, 0, bArr71111111111111111111111111111111111111111111111111111119, length211111111111111111111111111111111111111111111111111111111111117, bArr611111111111111111111111111111111111111.length);
            java.lang.System.arraycopy(bArr611111111111111111111111111111111111113, 0, bArr71111111111111111111111111111111111111111111111111111119, length211111111111111111111111111111111111111111111111111111111111117 + bArr611111111111111111111111111111111111111.length, bArr611111111111111111111111111111111111113.length);
            int length211111111111111111111111111111111111111111111111111111111111118 = bArr611111111111111111111111111111111111113.length;
            return a(a(bArr71111111111111111111111111111111111111111111111111111119, this.u, i11111116), this.y, this.A, this.B);
        }
        bArr16 = bArr14;
        bArr17 = bArr55;
        bArr18 = oicq.wlogin_sdk.request.t.L;
        if (bArr18 != null) {
            bArr19 = bArr17;
            if (bArr18.length > 0) {
                bArr20 = tlv_t194Var.get_tlv_194(bArr18);
                i12++;
            }
            bArr21 = oicq.wlogin_sdk.request.l.J;
            if (bArr21 != null) {
                bArr22 = bArr20;
                if (bArr21.length > 0) {
                    bArr41 = bArr41;
                    bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                    i12++;
                }
                bArr24 = oicq.wlogin_sdk.request.t.R;
                if (bArr24 != null) {
                    bArr25 = bArr6;
                } else {
                    bArr25 = bArr6;
                }
                byte[] bArr51111119 = bArr23;
                byte[] bArr62111111111111111111111116 = bArr25;
                byte[] bArr62111111111111111111111117 = bArr7;
                byte[] bArr62111111111111111111111118 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
                byte[] bArr62111111111111111111111119 = tlv_t142Var.get_tlv_142(bArr5);
                i13 = i12 + 1 + 1;
                str = this.x.g;
                if (str != null) {
                    i14 = i13;
                    bArr26 = bArr48;
                } else {
                    i14 = i13;
                    bArr26 = bArr48;
                }
                if (bArr3 != null) {
                    bArr27 = bArr50;
                } else {
                    bArr27 = bArr50;
                }
                if (list != null) {
                    bArr28 = bArr51;
                } else {
                    bArr28 = bArr51;
                }
                if (wloginSigInfoA == null) {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                } else {
                    bArr29 = bArr28;
                    bArr30 = bArr27;
                    oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                    bArr31 = bArr53;
                }
                byte[] bArr611111111111111111111111111111111111116 = new byte[4];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111111111111111116, 0, i11);
                tlv_tVar.set_data(bArr611111111111111111111111111111111111116, 4);
                byte[] bArr611111111111111111111111111111111111117 = tlv_tVar.get_buf();
                byte[] bArr611111111111111111111111111111111111118 = new byte[6];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr611111111111111111111111111111111111118, 0, oicq.wlogin_sdk.request.t.au);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr611111111111111111111111111111111111118, 4, 0);
                tlv_tVar2.set_data(bArr611111111111111111111111111111111111118, 6);
                byte[] bArr611111111111111111111111111111111111119 = tlv_tVar2.get_buf();
                int i11111117 = i14 + 1 + 1;
                int length211111111111111111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr62111111111111111111111117.length + bArr62111111111111111111111118.length + bArr62111111111111111111111119.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
                byte[] bArr6111111111111111111111111111111111111110 = bArr10;
                byte[] bArr6111111111111111111111111111111111111111 = bArr31;
                byte[] bArr711111111111111111111111111111111111111111111111111111118 = new byte[length211111111111111111111111111111111111111111111111111111111111119 + bArr6111111111111111111111111111111111111110.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr51111119.length + bArr62111111111111111111111116.length + bArr611111111111111111111111111111111111117.length + bArr611111111111111111111111111111111111119.length];
                java.lang.System.arraycopy(bArr35, 0, bArr711111111111111111111111111111111111111111111111111111118, 0, bArr35.length);
                int length31111111111111111111111111111111111111111111111118 = bArr35.length + 0;
                java.lang.System.arraycopy(bArr36, 0, bArr711111111111111111111111111111111111111111111111111111118, length31111111111111111111111111111111111111111111111118, bArr36.length);
                int length31111111111111111111111111111111111111111111111119 = length31111111111111111111111111111111111111111111111118 + bArr36.length;
                java.lang.System.arraycopy(bArr37, 0, bArr711111111111111111111111111111111111111111111111111111118, length31111111111111111111111111111111111111111111111119, bArr37.length);
                int length311111111111111111111111111111111111111111111111110 = length31111111111111111111111111111111111111111111111119 + bArr37.length;
                java.lang.System.arraycopy(bArr40, 0, bArr711111111111111111111111111111111111111111111111111111118, length311111111111111111111111111111111111111111111111110, bArr40.length);
                int length311111111111111111111111111111111111111111111111111 = length311111111111111111111111111111111111111111111111110 + bArr40.length;
                java.lang.System.arraycopy(bArr38, 0, bArr711111111111111111111111111111111111111111111111111111118, length311111111111111111111111111111111111111111111111111, bArr38.length);
                int length311111111111111111111111111111111111111111111111112 = length311111111111111111111111111111111111111111111111111 + bArr38.length;
                java.lang.System.arraycopy(bArr39, 0, bArr711111111111111111111111111111111111111111111111111111118, length311111111111111111111111111111111111111111111111112, bArr39.length);
                int length311111111111111111111111111111111111111111111111113 = length311111111111111111111111111111111111111111111111112 + bArr39.length;
                java.lang.System.arraycopy(bArr62111111111111111111111117, 0, bArr711111111111111111111111111111111111111111111111111111118, length311111111111111111111111111111111111111111111111113, bArr62111111111111111111111117.length);
                int length311111111111111111111111111111111111111111111111114 = length311111111111111111111111111111111111111111111111113 + bArr62111111111111111111111117.length;
                java.lang.System.arraycopy(bArr62111111111111111111111118, 0, bArr711111111111111111111111111111111111111111111111111111118, length311111111111111111111111111111111111111111111111114, bArr62111111111111111111111118.length);
                int length311111111111111111111111111111111111111111111111115 = length311111111111111111111111111111111111111111111111114 + bArr62111111111111111111111118.length;
                java.lang.System.arraycopy(bArr62111111111111111111111119, 0, bArr711111111111111111111111111111111111111111111111111111118, length311111111111111111111111111111111111111111111111115, bArr62111111111111111111111119.length);
                int length1111111111111111111111111111111111111111111111111111111111111110 = length311111111111111111111111111111111111111111111111115 + bArr62111111111111111111111119.length;
                java.lang.System.arraycopy(bArr26, 0, bArr711111111111111111111111111111111111111111111111111111118, length1111111111111111111111111111111111111111111111111111111111111110, bArr26.length);
                int length1111111111111111111111111111111111111111111111111111111111111111 = length1111111111111111111111111111111111111111111111111111111111111110 + bArr26.length;
                byte[] bArr711111111111111111111111111111111111111111111111111111119 = bArr41;
                java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111119, 0, bArr711111111111111111111111111111111111111111111111111111118, length1111111111111111111111111111111111111111111111111111111111111111, bArr711111111111111111111111111111111111111111111111111111119.length);
                int length1111111111111111111111111111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111111111111111111111111111 + bArr711111111111111111111111111111111111111111111111111111119.length;
                byte[] bArr7111111111111111111111111111111111111111111111111111111110 = bArr8;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111111110, 0, bArr711111111111111111111111111111111111111111111111111111118, length1111111111111111111111111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111111111111111111111110.length);
                int length1111111111111111111111111111111111111111111111111111111111111113 = length1111111111111111111111111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111111111111111111111110.length;
                byte[] bArr7111111111111111111111111111111111111111111111111111111111 = bArr30;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111111111, 0, bArr711111111111111111111111111111111111111111111111111111118, length1111111111111111111111111111111111111111111111111111111111111113, bArr7111111111111111111111111111111111111111111111111111111111.length);
                int length1111111111111111111111111111111111111111111111111111111111111114 = length1111111111111111111111111111111111111111111111111111111111111113 + bArr7111111111111111111111111111111111111111111111111111111111.length;
                java.lang.System.arraycopy(bArr42, 0, bArr711111111111111111111111111111111111111111111111111111118, length1111111111111111111111111111111111111111111111111111111111111114, bArr42.length);
                int length1111111111111111111111111111111111111111111111111111111111111115 = length1111111111111111111111111111111111111111111111111111111111111114 + bArr42.length;
                java.lang.System.arraycopy(bArr43, 0, bArr711111111111111111111111111111111111111111111111111111118, length1111111111111111111111111111111111111111111111111111111111111115, bArr43.length);
                int length1111111111111111111111111111111111111111111111111111111111111116 = length1111111111111111111111111111111111111111111111111111111111111115 + bArr43.length;
                java.lang.System.arraycopy(bArr44, 0, bArr711111111111111111111111111111111111111111111111111111118, length1111111111111111111111111111111111111111111111111111111111111116, bArr44.length);
                int length1111111111111111111111111111111111111111111111111111111111111117 = length1111111111111111111111111111111111111111111111111111111111111116 + bArr44.length;
                byte[] bArr7111111111111111111111111111111111111111111111111111111112 = bArr29;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111111112, 0, bArr711111111111111111111111111111111111111111111111111111118, length1111111111111111111111111111111111111111111111111111111111111117, bArr7111111111111111111111111111111111111111111111111111111112.length);
                int length1111111111111111111111111111111111111111111111111111111111111118 = length1111111111111111111111111111111111111111111111111111111111111117 + bArr7111111111111111111111111111111111111111111111111111111112.length;
                java.lang.System.arraycopy(bArr45, 0, bArr711111111111111111111111111111111111111111111111111111118, length1111111111111111111111111111111111111111111111111111111111111118, bArr45.length);
                int length1111111111111111111111111111111111111111111111111111111111111119 = length1111111111111111111111111111111111111111111111111111111111111118 + bArr45.length;
                byte[] bArr7111111111111111111111111111111111111111111111111111111113 = bArr13;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111111113, 0, bArr711111111111111111111111111111111111111111111111111111118, length1111111111111111111111111111111111111111111111111111111111111119, bArr7111111111111111111111111111111111111111111111111111111113.length);
                int length2111111111111111111111111111111111111111111111111111111111111110 = length1111111111111111111111111111111111111111111111111111111111111119 + bArr7111111111111111111111111111111111111111111111111111111113.length;
                java.lang.System.arraycopy(bArr6111111111111111111111111111111111111110, 0, bArr711111111111111111111111111111111111111111111111111111118, length2111111111111111111111111111111111111111111111111111111111111110, bArr6111111111111111111111111111111111111110.length);
                int length2111111111111111111111111111111111111111111111111111111111111111 = length2111111111111111111111111111111111111111111111111111111111111110 + bArr6111111111111111111111111111111111111110.length;
                java.lang.System.arraycopy(bArr6111111111111111111111111111111111111111, 0, bArr711111111111111111111111111111111111111111111111111111118, length2111111111111111111111111111111111111111111111111111111111111111, bArr6111111111111111111111111111111111111111.length);
                int length2111111111111111111111111111111111111111111111111111111111111112 = length2111111111111111111111111111111111111111111111111111111111111111 + bArr6111111111111111111111111111111111111111.length;
                byte[] bArr7111111111111111111111111111111111111111111111111111111114 = bArr16;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111111114, 0, bArr711111111111111111111111111111111111111111111111111111118, length2111111111111111111111111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111111111111111111111114.length);
                int length2111111111111111111111111111111111111111111111111111111111111113 = length2111111111111111111111111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111111111111111111111114.length;
                byte[] bArr7111111111111111111111111111111111111111111111111111111115 = bArr19;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111111115, 0, bArr711111111111111111111111111111111111111111111111111111118, length2111111111111111111111111111111111111111111111111111111111111113, bArr7111111111111111111111111111111111111111111111111111111115.length);
                int length2111111111111111111111111111111111111111111111111111111111111114 = length2111111111111111111111111111111111111111111111111111111111111113 + bArr7111111111111111111111111111111111111111111111111111111115.length;
                byte[] bArr7111111111111111111111111111111111111111111111111111111116 = bArr22;
                java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111111116, 0, bArr711111111111111111111111111111111111111111111111111111118, length2111111111111111111111111111111111111111111111111111111111111114, bArr7111111111111111111111111111111111111111111111111111111116.length);
                int length2111111111111111111111111111111111111111111111111111111111111115 = length2111111111111111111111111111111111111111111111111111111111111114 + bArr7111111111111111111111111111111111111111111111111111111116.length;
                java.lang.System.arraycopy(bArr51111119, 0, bArr711111111111111111111111111111111111111111111111111111118, length2111111111111111111111111111111111111111111111111111111111111115, bArr51111119.length);
                int length2111111111111111111111111111111111111111111111111111111111111116 = length2111111111111111111111111111111111111111111111111111111111111115 + bArr51111119.length;
                java.lang.System.arraycopy(bArr62111111111111111111111116, 0, bArr711111111111111111111111111111111111111111111111111111118, length2111111111111111111111111111111111111111111111111111111111111116, bArr62111111111111111111111116.length);
                int length2111111111111111111111111111111111111111111111111111111111111117 = length2111111111111111111111111111111111111111111111111111111111111116 + bArr62111111111111111111111116.length;
                java.lang.System.arraycopy(bArr611111111111111111111111111111111111117, 0, bArr711111111111111111111111111111111111111111111111111111118, length2111111111111111111111111111111111111111111111111111111111111117, bArr611111111111111111111111111111111111117.length);
                java.lang.System.arraycopy(bArr611111111111111111111111111111111111119, 0, bArr711111111111111111111111111111111111111111111111111111118, length2111111111111111111111111111111111111111111111111111111111111117 + bArr611111111111111111111111111111111111117.length, bArr611111111111111111111111111111111111119.length);
                int length2111111111111111111111111111111111111111111111111111111111111118 = bArr611111111111111111111111111111111111119.length;
                return a(a(bArr711111111111111111111111111111111111111111111111111111118, this.u, i11111117), this.y, this.A, this.B);
            }
            bArr22 = bArr20;
            bArr23 = bArr57;
            bArr24 = oicq.wlogin_sdk.request.t.R;
            if (bArr24 != null) {
                bArr25 = bArr6;
            } else {
                bArr25 = bArr6;
            }
            byte[] bArr511111110 = bArr23;
            byte[] bArr621111111111111111111111110 = bArr25;
            byte[] bArr621111111111111111111111111 = bArr7;
            byte[] bArr621111111111111111111111112 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
            byte[] bArr621111111111111111111111113 = tlv_t142Var.get_tlv_142(bArr5);
            i13 = i12 + 1 + 1;
            str = this.x.g;
            if (str != null) {
                i14 = i13;
                bArr26 = bArr48;
            } else {
                i14 = i13;
                bArr26 = bArr48;
            }
            if (bArr3 != null) {
                bArr27 = bArr50;
            } else {
                bArr27 = bArr50;
            }
            if (list != null) {
                bArr28 = bArr51;
            } else {
                bArr28 = bArr51;
            }
            if (wloginSigInfoA == null) {
                bArr29 = bArr28;
                bArr30 = bArr27;
                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                bArr31 = bArr53;
            } else {
                bArr29 = bArr28;
                bArr30 = bArr27;
                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                bArr31 = bArr53;
            }
            byte[] bArr6111111111111111111111111111111111111112 = new byte[4];
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111111111111111111112, 0, i11);
            tlv_tVar.set_data(bArr6111111111111111111111111111111111111112, 4);
            byte[] bArr6111111111111111111111111111111111111113 = tlv_tVar.get_buf();
            byte[] bArr6111111111111111111111111111111111111114 = new byte[6];
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111111111111111111114, 0, oicq.wlogin_sdk.request.t.au);
            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr6111111111111111111111111111111111111114, 4, 0);
            tlv_tVar2.set_data(bArr6111111111111111111111111111111111111114, 6);
            byte[] bArr6111111111111111111111111111111111111115 = tlv_tVar2.get_buf();
            int i11111118 = i14 + 1 + 1;
            int length2111111111111111111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111111111111111111111111.length + bArr621111111111111111111111112.length + bArr621111111111111111111111113.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
            byte[] bArr6111111111111111111111111111111111111116 = bArr10;
            byte[] bArr6111111111111111111111111111111111111117 = bArr31;
            byte[] bArr7111111111111111111111111111111111111111111111111111111117 = new byte[length2111111111111111111111111111111111111111111111111111111111111119 + bArr6111111111111111111111111111111111111116.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr511111110.length + bArr621111111111111111111111110.length + bArr6111111111111111111111111111111111111113.length + bArr6111111111111111111111111111111111111115.length];
            java.lang.System.arraycopy(bArr35, 0, bArr7111111111111111111111111111111111111111111111111111111117, 0, bArr35.length);
            int length311111111111111111111111111111111111111111111111116 = bArr35.length + 0;
            java.lang.System.arraycopy(bArr36, 0, bArr7111111111111111111111111111111111111111111111111111111117, length311111111111111111111111111111111111111111111111116, bArr36.length);
            int length311111111111111111111111111111111111111111111111117 = length311111111111111111111111111111111111111111111111116 + bArr36.length;
            java.lang.System.arraycopy(bArr37, 0, bArr7111111111111111111111111111111111111111111111111111111117, length311111111111111111111111111111111111111111111111117, bArr37.length);
            int length311111111111111111111111111111111111111111111111118 = length311111111111111111111111111111111111111111111111117 + bArr37.length;
            java.lang.System.arraycopy(bArr40, 0, bArr7111111111111111111111111111111111111111111111111111111117, length311111111111111111111111111111111111111111111111118, bArr40.length);
            int length311111111111111111111111111111111111111111111111119 = length311111111111111111111111111111111111111111111111118 + bArr40.length;
            java.lang.System.arraycopy(bArr38, 0, bArr7111111111111111111111111111111111111111111111111111111117, length311111111111111111111111111111111111111111111111119, bArr38.length);
            int length3111111111111111111111111111111111111111111111111110 = length311111111111111111111111111111111111111111111111119 + bArr38.length;
            java.lang.System.arraycopy(bArr39, 0, bArr7111111111111111111111111111111111111111111111111111111117, length3111111111111111111111111111111111111111111111111110, bArr39.length);
            int length3111111111111111111111111111111111111111111111111111 = length3111111111111111111111111111111111111111111111111110 + bArr39.length;
            java.lang.System.arraycopy(bArr621111111111111111111111111, 0, bArr7111111111111111111111111111111111111111111111111111111117, length3111111111111111111111111111111111111111111111111111, bArr621111111111111111111111111.length);
            int length3111111111111111111111111111111111111111111111111112 = length3111111111111111111111111111111111111111111111111111 + bArr621111111111111111111111111.length;
            java.lang.System.arraycopy(bArr621111111111111111111111112, 0, bArr7111111111111111111111111111111111111111111111111111111117, length3111111111111111111111111111111111111111111111111112, bArr621111111111111111111111112.length);
            int length3111111111111111111111111111111111111111111111111113 = length3111111111111111111111111111111111111111111111111112 + bArr621111111111111111111111112.length;
            java.lang.System.arraycopy(bArr621111111111111111111111113, 0, bArr7111111111111111111111111111111111111111111111111111111117, length3111111111111111111111111111111111111111111111111113, bArr621111111111111111111111113.length);
            int length11111111111111111111111111111111111111111111111111111111111111110 = length3111111111111111111111111111111111111111111111111113 + bArr621111111111111111111111113.length;
            java.lang.System.arraycopy(bArr26, 0, bArr7111111111111111111111111111111111111111111111111111111117, length11111111111111111111111111111111111111111111111111111111111111110, bArr26.length);
            int length11111111111111111111111111111111111111111111111111111111111111111 = length11111111111111111111111111111111111111111111111111111111111111110 + bArr26.length;
            byte[] bArr7111111111111111111111111111111111111111111111111111111118 = bArr41;
            java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111111118, 0, bArr7111111111111111111111111111111111111111111111111111111117, length11111111111111111111111111111111111111111111111111111111111111111, bArr7111111111111111111111111111111111111111111111111111111118.length);
            int length11111111111111111111111111111111111111111111111111111111111111112 = length11111111111111111111111111111111111111111111111111111111111111111 + bArr7111111111111111111111111111111111111111111111111111111118.length;
            byte[] bArr7111111111111111111111111111111111111111111111111111111119 = bArr8;
            java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111111119, 0, bArr7111111111111111111111111111111111111111111111111111111117, length11111111111111111111111111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111111111111111111111119.length);
            int length11111111111111111111111111111111111111111111111111111111111111113 = length11111111111111111111111111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111111111111111111111119.length;
            byte[] bArr71111111111111111111111111111111111111111111111111111111110 = bArr30;
            java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111111110, 0, bArr7111111111111111111111111111111111111111111111111111111117, length11111111111111111111111111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111111111111111111111111110.length);
            int length11111111111111111111111111111111111111111111111111111111111111114 = length11111111111111111111111111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111111111111111111111111110.length;
            java.lang.System.arraycopy(bArr42, 0, bArr7111111111111111111111111111111111111111111111111111111117, length11111111111111111111111111111111111111111111111111111111111111114, bArr42.length);
            int length11111111111111111111111111111111111111111111111111111111111111115 = length11111111111111111111111111111111111111111111111111111111111111114 + bArr42.length;
            java.lang.System.arraycopy(bArr43, 0, bArr7111111111111111111111111111111111111111111111111111111117, length11111111111111111111111111111111111111111111111111111111111111115, bArr43.length);
            int length11111111111111111111111111111111111111111111111111111111111111116 = length11111111111111111111111111111111111111111111111111111111111111115 + bArr43.length;
            java.lang.System.arraycopy(bArr44, 0, bArr7111111111111111111111111111111111111111111111111111111117, length11111111111111111111111111111111111111111111111111111111111111116, bArr44.length);
            int length11111111111111111111111111111111111111111111111111111111111111117 = length11111111111111111111111111111111111111111111111111111111111111116 + bArr44.length;
            byte[] bArr71111111111111111111111111111111111111111111111111111111111 = bArr29;
            java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111111111, 0, bArr7111111111111111111111111111111111111111111111111111111117, length11111111111111111111111111111111111111111111111111111111111111117, bArr71111111111111111111111111111111111111111111111111111111111.length);
            int length11111111111111111111111111111111111111111111111111111111111111118 = length11111111111111111111111111111111111111111111111111111111111111117 + bArr71111111111111111111111111111111111111111111111111111111111.length;
            java.lang.System.arraycopy(bArr45, 0, bArr7111111111111111111111111111111111111111111111111111111117, length11111111111111111111111111111111111111111111111111111111111111118, bArr45.length);
            int length11111111111111111111111111111111111111111111111111111111111111119 = length11111111111111111111111111111111111111111111111111111111111111118 + bArr45.length;
            byte[] bArr71111111111111111111111111111111111111111111111111111111112 = bArr13;
            java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111111112, 0, bArr7111111111111111111111111111111111111111111111111111111117, length11111111111111111111111111111111111111111111111111111111111111119, bArr71111111111111111111111111111111111111111111111111111111112.length);
            int length21111111111111111111111111111111111111111111111111111111111111110 = length11111111111111111111111111111111111111111111111111111111111111119 + bArr71111111111111111111111111111111111111111111111111111111112.length;
            java.lang.System.arraycopy(bArr6111111111111111111111111111111111111116, 0, bArr7111111111111111111111111111111111111111111111111111111117, length21111111111111111111111111111111111111111111111111111111111111110, bArr6111111111111111111111111111111111111116.length);
            int length21111111111111111111111111111111111111111111111111111111111111111 = length21111111111111111111111111111111111111111111111111111111111111110 + bArr6111111111111111111111111111111111111116.length;
            java.lang.System.arraycopy(bArr6111111111111111111111111111111111111117, 0, bArr7111111111111111111111111111111111111111111111111111111117, length21111111111111111111111111111111111111111111111111111111111111111, bArr6111111111111111111111111111111111111117.length);
            int length21111111111111111111111111111111111111111111111111111111111111112 = length21111111111111111111111111111111111111111111111111111111111111111 + bArr6111111111111111111111111111111111111117.length;
            byte[] bArr71111111111111111111111111111111111111111111111111111111113 = bArr16;
            java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111111113, 0, bArr7111111111111111111111111111111111111111111111111111111117, length21111111111111111111111111111111111111111111111111111111111111112, bArr71111111111111111111111111111111111111111111111111111111113.length);
            int length21111111111111111111111111111111111111111111111111111111111111113 = length21111111111111111111111111111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111111111111111111111111113.length;
            byte[] bArr71111111111111111111111111111111111111111111111111111111114 = bArr19;
            java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111111114, 0, bArr7111111111111111111111111111111111111111111111111111111117, length21111111111111111111111111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111111111111111111111111114.length);
            int length21111111111111111111111111111111111111111111111111111111111111114 = length21111111111111111111111111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111111111111111111111111114.length;
            byte[] bArr71111111111111111111111111111111111111111111111111111111115 = bArr22;
            java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111111115, 0, bArr7111111111111111111111111111111111111111111111111111111117, length21111111111111111111111111111111111111111111111111111111111111114, bArr71111111111111111111111111111111111111111111111111111111115.length);
            int length21111111111111111111111111111111111111111111111111111111111111115 = length21111111111111111111111111111111111111111111111111111111111111114 + bArr71111111111111111111111111111111111111111111111111111111115.length;
            java.lang.System.arraycopy(bArr511111110, 0, bArr7111111111111111111111111111111111111111111111111111111117, length21111111111111111111111111111111111111111111111111111111111111115, bArr511111110.length);
            int length21111111111111111111111111111111111111111111111111111111111111116 = length21111111111111111111111111111111111111111111111111111111111111115 + bArr511111110.length;
            java.lang.System.arraycopy(bArr621111111111111111111111110, 0, bArr7111111111111111111111111111111111111111111111111111111117, length21111111111111111111111111111111111111111111111111111111111111116, bArr621111111111111111111111110.length);
            int length21111111111111111111111111111111111111111111111111111111111111117 = length21111111111111111111111111111111111111111111111111111111111111116 + bArr621111111111111111111111110.length;
            java.lang.System.arraycopy(bArr6111111111111111111111111111111111111113, 0, bArr7111111111111111111111111111111111111111111111111111111117, length21111111111111111111111111111111111111111111111111111111111111117, bArr6111111111111111111111111111111111111113.length);
            java.lang.System.arraycopy(bArr6111111111111111111111111111111111111115, 0, bArr7111111111111111111111111111111111111111111111111111111117, length21111111111111111111111111111111111111111111111111111111111111117 + bArr6111111111111111111111111111111111111113.length, bArr6111111111111111111111111111111111111115.length);
            int length21111111111111111111111111111111111111111111111111111111111111118 = bArr6111111111111111111111111111111111111115.length;
            return a(a(bArr7111111111111111111111111111111111111111111111111111111117, this.u, i11111118), this.y, this.A, this.B);
        }
        bArr19 = bArr17;
        bArr20 = bArr56;
        bArr21 = oicq.wlogin_sdk.request.l.J;
        if (bArr21 != null) {
            bArr22 = bArr20;
            if (bArr21.length > 0) {
                bArr41 = bArr41;
                bArr23 = tlv_t201Var.get_tlv_201(bArr21, oicq.wlogin_sdk.request.l.K, "qq".getBytes(), oicq.wlogin_sdk.request.l.L);
                i12++;
            }
            bArr24 = oicq.wlogin_sdk.request.t.R;
            if (bArr24 != null) {
                bArr25 = bArr6;
            } else {
                bArr25 = bArr6;
            }
            byte[] bArr511111111 = bArr23;
            byte[] bArr621111111111111111111111114 = bArr25;
            byte[] bArr621111111111111111111111115 = bArr7;
            byte[] bArr621111111111111111111111116 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
            byte[] bArr621111111111111111111111117 = tlv_t142Var.get_tlv_142(bArr5);
            i13 = i12 + 1 + 1;
            str = this.x.g;
            if (str != null) {
                i14 = i13;
                bArr26 = bArr48;
            } else {
                i14 = i13;
                bArr26 = bArr48;
            }
            if (bArr3 != null) {
                bArr27 = bArr50;
            } else {
                bArr27 = bArr50;
            }
            if (list != null) {
                bArr28 = bArr51;
            } else {
                bArr28 = bArr51;
            }
            if (wloginSigInfoA == null) {
                bArr29 = bArr28;
                bArr30 = bArr27;
                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                bArr31 = bArr53;
            } else {
                bArr29 = bArr28;
                bArr30 = bArr27;
                oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
                bArr31 = bArr53;
            }
            byte[] bArr6111111111111111111111111111111111111118 = new byte[4];
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr6111111111111111111111111111111111111118, 0, i11);
            tlv_tVar.set_data(bArr6111111111111111111111111111111111111118, 4);
            byte[] bArr6111111111111111111111111111111111111119 = tlv_tVar.get_buf();
            byte[] bArr61111111111111111111111111111111111111110 = new byte[6];
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111111111111111111110, 0, oicq.wlogin_sdk.request.t.au);
            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111111111111111111111111111110, 4, 0);
            tlv_tVar2.set_data(bArr61111111111111111111111111111111111111110, 6);
            byte[] bArr61111111111111111111111111111111111111111 = tlv_tVar2.get_buf();
            int i11111119 = i14 + 1 + 1;
            int length21111111111111111111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111111111111111111111115.length + bArr621111111111111111111111116.length + bArr621111111111111111111111117.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
            byte[] bArr61111111111111111111111111111111111111112 = bArr10;
            byte[] bArr61111111111111111111111111111111111111113 = bArr31;
            byte[] bArr71111111111111111111111111111111111111111111111111111111116 = new byte[length21111111111111111111111111111111111111111111111111111111111111119 + bArr61111111111111111111111111111111111111112.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr511111111.length + bArr621111111111111111111111114.length + bArr6111111111111111111111111111111111111119.length + bArr61111111111111111111111111111111111111111.length];
            java.lang.System.arraycopy(bArr35, 0, bArr71111111111111111111111111111111111111111111111111111111116, 0, bArr35.length);
            int length3111111111111111111111111111111111111111111111111114 = bArr35.length + 0;
            java.lang.System.arraycopy(bArr36, 0, bArr71111111111111111111111111111111111111111111111111111111116, length3111111111111111111111111111111111111111111111111114, bArr36.length);
            int length3111111111111111111111111111111111111111111111111115 = length3111111111111111111111111111111111111111111111111114 + bArr36.length;
            java.lang.System.arraycopy(bArr37, 0, bArr71111111111111111111111111111111111111111111111111111111116, length3111111111111111111111111111111111111111111111111115, bArr37.length);
            int length3111111111111111111111111111111111111111111111111116 = length3111111111111111111111111111111111111111111111111115 + bArr37.length;
            java.lang.System.arraycopy(bArr40, 0, bArr71111111111111111111111111111111111111111111111111111111116, length3111111111111111111111111111111111111111111111111116, bArr40.length);
            int length3111111111111111111111111111111111111111111111111117 = length3111111111111111111111111111111111111111111111111116 + bArr40.length;
            java.lang.System.arraycopy(bArr38, 0, bArr71111111111111111111111111111111111111111111111111111111116, length3111111111111111111111111111111111111111111111111117, bArr38.length);
            int length3111111111111111111111111111111111111111111111111118 = length3111111111111111111111111111111111111111111111111117 + bArr38.length;
            java.lang.System.arraycopy(bArr39, 0, bArr71111111111111111111111111111111111111111111111111111111116, length3111111111111111111111111111111111111111111111111118, bArr39.length);
            int length3111111111111111111111111111111111111111111111111119 = length3111111111111111111111111111111111111111111111111118 + bArr39.length;
            java.lang.System.arraycopy(bArr621111111111111111111111115, 0, bArr71111111111111111111111111111111111111111111111111111111116, length3111111111111111111111111111111111111111111111111119, bArr621111111111111111111111115.length);
            int length31111111111111111111111111111111111111111111111111110 = length3111111111111111111111111111111111111111111111111119 + bArr621111111111111111111111115.length;
            java.lang.System.arraycopy(bArr621111111111111111111111116, 0, bArr71111111111111111111111111111111111111111111111111111111116, length31111111111111111111111111111111111111111111111111110, bArr621111111111111111111111116.length);
            int length31111111111111111111111111111111111111111111111111111 = length31111111111111111111111111111111111111111111111111110 + bArr621111111111111111111111116.length;
            java.lang.System.arraycopy(bArr621111111111111111111111117, 0, bArr71111111111111111111111111111111111111111111111111111111116, length31111111111111111111111111111111111111111111111111111, bArr621111111111111111111111117.length);
            int length111111111111111111111111111111111111111111111111111111111111111110 = length31111111111111111111111111111111111111111111111111111 + bArr621111111111111111111111117.length;
            java.lang.System.arraycopy(bArr26, 0, bArr71111111111111111111111111111111111111111111111111111111116, length111111111111111111111111111111111111111111111111111111111111111110, bArr26.length);
            int length111111111111111111111111111111111111111111111111111111111111111111 = length111111111111111111111111111111111111111111111111111111111111111110 + bArr26.length;
            byte[] bArr71111111111111111111111111111111111111111111111111111111117 = bArr41;
            java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111111117, 0, bArr71111111111111111111111111111111111111111111111111111111116, length111111111111111111111111111111111111111111111111111111111111111111, bArr71111111111111111111111111111111111111111111111111111111117.length);
            int length111111111111111111111111111111111111111111111111111111111111111112 = length111111111111111111111111111111111111111111111111111111111111111111 + bArr71111111111111111111111111111111111111111111111111111111117.length;
            byte[] bArr71111111111111111111111111111111111111111111111111111111118 = bArr8;
            java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111111118, 0, bArr71111111111111111111111111111111111111111111111111111111116, length111111111111111111111111111111111111111111111111111111111111111112, bArr71111111111111111111111111111111111111111111111111111111118.length);
            int length111111111111111111111111111111111111111111111111111111111111111113 = length111111111111111111111111111111111111111111111111111111111111111112 + bArr71111111111111111111111111111111111111111111111111111111118.length;
            byte[] bArr71111111111111111111111111111111111111111111111111111111119 = bArr30;
            java.lang.System.arraycopy(bArr71111111111111111111111111111111111111111111111111111111119, 0, bArr71111111111111111111111111111111111111111111111111111111116, length111111111111111111111111111111111111111111111111111111111111111113, bArr71111111111111111111111111111111111111111111111111111111119.length);
            int length111111111111111111111111111111111111111111111111111111111111111114 = length111111111111111111111111111111111111111111111111111111111111111113 + bArr71111111111111111111111111111111111111111111111111111111119.length;
            java.lang.System.arraycopy(bArr42, 0, bArr71111111111111111111111111111111111111111111111111111111116, length111111111111111111111111111111111111111111111111111111111111111114, bArr42.length);
            int length111111111111111111111111111111111111111111111111111111111111111115 = length111111111111111111111111111111111111111111111111111111111111111114 + bArr42.length;
            java.lang.System.arraycopy(bArr43, 0, bArr71111111111111111111111111111111111111111111111111111111116, length111111111111111111111111111111111111111111111111111111111111111115, bArr43.length);
            int length111111111111111111111111111111111111111111111111111111111111111116 = length111111111111111111111111111111111111111111111111111111111111111115 + bArr43.length;
            java.lang.System.arraycopy(bArr44, 0, bArr71111111111111111111111111111111111111111111111111111111116, length111111111111111111111111111111111111111111111111111111111111111116, bArr44.length);
            int length111111111111111111111111111111111111111111111111111111111111111117 = length111111111111111111111111111111111111111111111111111111111111111116 + bArr44.length;
            byte[] bArr711111111111111111111111111111111111111111111111111111111110 = bArr29;
            java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111111110, 0, bArr71111111111111111111111111111111111111111111111111111111116, length111111111111111111111111111111111111111111111111111111111111111117, bArr711111111111111111111111111111111111111111111111111111111110.length);
            int length111111111111111111111111111111111111111111111111111111111111111118 = length111111111111111111111111111111111111111111111111111111111111111117 + bArr711111111111111111111111111111111111111111111111111111111110.length;
            java.lang.System.arraycopy(bArr45, 0, bArr71111111111111111111111111111111111111111111111111111111116, length111111111111111111111111111111111111111111111111111111111111111118, bArr45.length);
            int length111111111111111111111111111111111111111111111111111111111111111119 = length111111111111111111111111111111111111111111111111111111111111111118 + bArr45.length;
            byte[] bArr711111111111111111111111111111111111111111111111111111111111 = bArr13;
            java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111111111, 0, bArr71111111111111111111111111111111111111111111111111111111116, length111111111111111111111111111111111111111111111111111111111111111119, bArr711111111111111111111111111111111111111111111111111111111111.length);
            int length211111111111111111111111111111111111111111111111111111111111111110 = length111111111111111111111111111111111111111111111111111111111111111119 + bArr711111111111111111111111111111111111111111111111111111111111.length;
            java.lang.System.arraycopy(bArr61111111111111111111111111111111111111112, 0, bArr71111111111111111111111111111111111111111111111111111111116, length211111111111111111111111111111111111111111111111111111111111111110, bArr61111111111111111111111111111111111111112.length);
            int length211111111111111111111111111111111111111111111111111111111111111111 = length211111111111111111111111111111111111111111111111111111111111111110 + bArr61111111111111111111111111111111111111112.length;
            java.lang.System.arraycopy(bArr61111111111111111111111111111111111111113, 0, bArr71111111111111111111111111111111111111111111111111111111116, length211111111111111111111111111111111111111111111111111111111111111111, bArr61111111111111111111111111111111111111113.length);
            int length211111111111111111111111111111111111111111111111111111111111111112 = length211111111111111111111111111111111111111111111111111111111111111111 + bArr61111111111111111111111111111111111111113.length;
            byte[] bArr711111111111111111111111111111111111111111111111111111111112 = bArr16;
            java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111111112, 0, bArr71111111111111111111111111111111111111111111111111111111116, length211111111111111111111111111111111111111111111111111111111111111112, bArr711111111111111111111111111111111111111111111111111111111112.length);
            int length211111111111111111111111111111111111111111111111111111111111111113 = length211111111111111111111111111111111111111111111111111111111111111112 + bArr711111111111111111111111111111111111111111111111111111111112.length;
            byte[] bArr711111111111111111111111111111111111111111111111111111111113 = bArr19;
            java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111111113, 0, bArr71111111111111111111111111111111111111111111111111111111116, length211111111111111111111111111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111111111111111111111111113.length);
            int length211111111111111111111111111111111111111111111111111111111111111114 = length211111111111111111111111111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111111111111111111111111113.length;
            byte[] bArr711111111111111111111111111111111111111111111111111111111114 = bArr22;
            java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111111114, 0, bArr71111111111111111111111111111111111111111111111111111111116, length211111111111111111111111111111111111111111111111111111111111111114, bArr711111111111111111111111111111111111111111111111111111111114.length);
            int length211111111111111111111111111111111111111111111111111111111111111115 = length211111111111111111111111111111111111111111111111111111111111111114 + bArr711111111111111111111111111111111111111111111111111111111114.length;
            java.lang.System.arraycopy(bArr511111111, 0, bArr71111111111111111111111111111111111111111111111111111111116, length211111111111111111111111111111111111111111111111111111111111111115, bArr511111111.length);
            int length211111111111111111111111111111111111111111111111111111111111111116 = length211111111111111111111111111111111111111111111111111111111111111115 + bArr511111111.length;
            java.lang.System.arraycopy(bArr621111111111111111111111114, 0, bArr71111111111111111111111111111111111111111111111111111111116, length211111111111111111111111111111111111111111111111111111111111111116, bArr621111111111111111111111114.length);
            int length211111111111111111111111111111111111111111111111111111111111111117 = length211111111111111111111111111111111111111111111111111111111111111116 + bArr621111111111111111111111114.length;
            java.lang.System.arraycopy(bArr6111111111111111111111111111111111111119, 0, bArr71111111111111111111111111111111111111111111111111111111116, length211111111111111111111111111111111111111111111111111111111111111117, bArr6111111111111111111111111111111111111119.length);
            java.lang.System.arraycopy(bArr61111111111111111111111111111111111111111, 0, bArr71111111111111111111111111111111111111111111111111111111116, length211111111111111111111111111111111111111111111111111111111111111117 + bArr6111111111111111111111111111111111111119.length, bArr61111111111111111111111111111111111111111.length);
            int length211111111111111111111111111111111111111111111111111111111111111118 = bArr61111111111111111111111111111111111111111.length;
            return a(a(bArr71111111111111111111111111111111111111111111111111111111116, this.u, i11111119), this.y, this.A, this.B);
        }
        bArr22 = bArr20;
        bArr23 = bArr57;
        bArr24 = oicq.wlogin_sdk.request.t.R;
        if (bArr24 != null) {
            bArr25 = bArr6;
        } else {
            bArr25 = bArr6;
        }
        byte[] bArr511111112 = bArr23;
        byte[] bArr621111111111111111111111118 = bArr25;
        byte[] bArr621111111111111111111111119 = bArr7;
        byte[] bArr6211111111111111111111111110 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.request.t.M), tlv_t124Var.get_tlv_124(oicq.wlogin_sdk.tools.util.get_os_type(), oicq.wlogin_sdk.tools.util.get_os_version(), oicq.wlogin_sdk.request.t.D, oicq.wlogin_sdk.request.t.C, new byte[0], oicq.wlogin_sdk.request.t.F), tlv_t128Var.get_tlv_128(oicq.wlogin_sdk.request.t.T, oicq.wlogin_sdk.request.t.U, oicq.wlogin_sdk.request.t.V, oicq.wlogin_sdk.request.t.Y, oicq.wlogin_sdk.request.t.I, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.P), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.request.t.I), oicq.wlogin_sdk.request.t.b(this.x.h)._tgtgt_key);
        byte[] bArr6211111111111111111111111111 = tlv_t142Var.get_tlv_142(bArr5);
        i13 = i12 + 1 + 1;
        str = this.x.g;
        if (str != null) {
            i14 = i13;
            bArr26 = bArr48;
        } else {
            i14 = i13;
            bArr26 = bArr48;
        }
        if (bArr3 != null) {
            bArr27 = bArr50;
        } else {
            bArr27 = bArr50;
        }
        if (list != null) {
            bArr28 = bArr51;
        } else {
            bArr28 = bArr51;
        }
        if (wloginSigInfoA == null) {
            bArr29 = bArr28;
            bArr30 = bArr27;
            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
            bArr31 = bArr53;
        } else {
            bArr29 = bArr28;
            bArr30 = bArr27;
            oicq.wlogin_sdk.tools.util.LOGI("request_tgtgt_nopicsig req without DA1", "" + j2);
            bArr31 = bArr53;
        }
        byte[] bArr61111111111111111111111111111111111111114 = new byte[4];
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111111111111111111114, 0, i11);
        tlv_tVar.set_data(bArr61111111111111111111111111111111111111114, 4);
        byte[] bArr61111111111111111111111111111111111111115 = tlv_tVar.get_buf();
        byte[] bArr61111111111111111111111111111111111111116 = new byte[6];
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr61111111111111111111111111111111111111116, 0, oicq.wlogin_sdk.request.t.au);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr61111111111111111111111111111111111111116, 4, 0);
        tlv_tVar2.set_data(bArr61111111111111111111111111111111111111116, 6);
        byte[] bArr61111111111111111111111111111111111111117 = tlv_tVar2.get_buf();
        int i111111110 = i14 + 1 + 1;
        int length211111111111111111111111111111111111111111111111111111111111111119 = bArr35.length + bArr36.length + bArr37.length + bArr40.length + bArr38.length + bArr39.length + bArr621111111111111111111111119.length + bArr6211111111111111111111111110.length + bArr6211111111111111111111111111.length + bArr26.length + bArr41.length + bArr8.length + bArr30.length + bArr42.length + bArr43.length + bArr44.length + bArr29.length + bArr45.length + bArr13.length;
        byte[] bArr61111111111111111111111111111111111111118 = bArr10;
        byte[] bArr61111111111111111111111111111111111111119 = bArr31;
        byte[] bArr711111111111111111111111111111111111111111111111111111111115 = new byte[length211111111111111111111111111111111111111111111111111111111111111119 + bArr61111111111111111111111111111111111111118.length + bArr31.length + bArr16.length + bArr19.length + bArr22.length + bArr511111112.length + bArr621111111111111111111111118.length + bArr61111111111111111111111111111111111111115.length + bArr61111111111111111111111111111111111111117.length];
        java.lang.System.arraycopy(bArr35, 0, bArr711111111111111111111111111111111111111111111111111111111115, 0, bArr35.length);
        int length31111111111111111111111111111111111111111111111111112 = bArr35.length + 0;
        java.lang.System.arraycopy(bArr36, 0, bArr711111111111111111111111111111111111111111111111111111111115, length31111111111111111111111111111111111111111111111111112, bArr36.length);
        int length31111111111111111111111111111111111111111111111111113 = length31111111111111111111111111111111111111111111111111112 + bArr36.length;
        java.lang.System.arraycopy(bArr37, 0, bArr711111111111111111111111111111111111111111111111111111111115, length31111111111111111111111111111111111111111111111111113, bArr37.length);
        int length31111111111111111111111111111111111111111111111111114 = length31111111111111111111111111111111111111111111111111113 + bArr37.length;
        java.lang.System.arraycopy(bArr40, 0, bArr711111111111111111111111111111111111111111111111111111111115, length31111111111111111111111111111111111111111111111111114, bArr40.length);
        int length31111111111111111111111111111111111111111111111111115 = length31111111111111111111111111111111111111111111111111114 + bArr40.length;
        java.lang.System.arraycopy(bArr38, 0, bArr711111111111111111111111111111111111111111111111111111111115, length31111111111111111111111111111111111111111111111111115, bArr38.length);
        int length31111111111111111111111111111111111111111111111111116 = length31111111111111111111111111111111111111111111111111115 + bArr38.length;
        java.lang.System.arraycopy(bArr39, 0, bArr711111111111111111111111111111111111111111111111111111111115, length31111111111111111111111111111111111111111111111111116, bArr39.length);
        int length31111111111111111111111111111111111111111111111111117 = length31111111111111111111111111111111111111111111111111116 + bArr39.length;
        java.lang.System.arraycopy(bArr621111111111111111111111119, 0, bArr711111111111111111111111111111111111111111111111111111111115, length31111111111111111111111111111111111111111111111111117, bArr621111111111111111111111119.length);
        int length31111111111111111111111111111111111111111111111111118 = length31111111111111111111111111111111111111111111111111117 + bArr621111111111111111111111119.length;
        java.lang.System.arraycopy(bArr6211111111111111111111111110, 0, bArr711111111111111111111111111111111111111111111111111111111115, length31111111111111111111111111111111111111111111111111118, bArr6211111111111111111111111110.length);
        int length31111111111111111111111111111111111111111111111111119 = length31111111111111111111111111111111111111111111111111118 + bArr6211111111111111111111111110.length;
        java.lang.System.arraycopy(bArr6211111111111111111111111111, 0, bArr711111111111111111111111111111111111111111111111111111111115, length31111111111111111111111111111111111111111111111111119, bArr6211111111111111111111111111.length);
        int length1111111111111111111111111111111111111111111111111111111111111111110 = length31111111111111111111111111111111111111111111111111119 + bArr6211111111111111111111111111.length;
        java.lang.System.arraycopy(bArr26, 0, bArr711111111111111111111111111111111111111111111111111111111115, length1111111111111111111111111111111111111111111111111111111111111111110, bArr26.length);
        int length1111111111111111111111111111111111111111111111111111111111111111111 = length1111111111111111111111111111111111111111111111111111111111111111110 + bArr26.length;
        byte[] bArr711111111111111111111111111111111111111111111111111111111116 = bArr41;
        java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111111116, 0, bArr711111111111111111111111111111111111111111111111111111111115, length1111111111111111111111111111111111111111111111111111111111111111111, bArr711111111111111111111111111111111111111111111111111111111116.length);
        int length1111111111111111111111111111111111111111111111111111111111111111112 = length1111111111111111111111111111111111111111111111111111111111111111111 + bArr711111111111111111111111111111111111111111111111111111111116.length;
        byte[] bArr711111111111111111111111111111111111111111111111111111111117 = bArr8;
        java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111111117, 0, bArr711111111111111111111111111111111111111111111111111111111115, length1111111111111111111111111111111111111111111111111111111111111111112, bArr711111111111111111111111111111111111111111111111111111111117.length);
        int length1111111111111111111111111111111111111111111111111111111111111111113 = length1111111111111111111111111111111111111111111111111111111111111111112 + bArr711111111111111111111111111111111111111111111111111111111117.length;
        byte[] bArr711111111111111111111111111111111111111111111111111111111118 = bArr30;
        java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111111118, 0, bArr711111111111111111111111111111111111111111111111111111111115, length1111111111111111111111111111111111111111111111111111111111111111113, bArr711111111111111111111111111111111111111111111111111111111118.length);
        int length1111111111111111111111111111111111111111111111111111111111111111114 = length1111111111111111111111111111111111111111111111111111111111111111113 + bArr711111111111111111111111111111111111111111111111111111111118.length;
        java.lang.System.arraycopy(bArr42, 0, bArr711111111111111111111111111111111111111111111111111111111115, length1111111111111111111111111111111111111111111111111111111111111111114, bArr42.length);
        int length1111111111111111111111111111111111111111111111111111111111111111115 = length1111111111111111111111111111111111111111111111111111111111111111114 + bArr42.length;
        java.lang.System.arraycopy(bArr43, 0, bArr711111111111111111111111111111111111111111111111111111111115, length1111111111111111111111111111111111111111111111111111111111111111115, bArr43.length);
        int length1111111111111111111111111111111111111111111111111111111111111111116 = length1111111111111111111111111111111111111111111111111111111111111111115 + bArr43.length;
        java.lang.System.arraycopy(bArr44, 0, bArr711111111111111111111111111111111111111111111111111111111115, length1111111111111111111111111111111111111111111111111111111111111111116, bArr44.length);
        int length1111111111111111111111111111111111111111111111111111111111111111117 = length1111111111111111111111111111111111111111111111111111111111111111116 + bArr44.length;
        byte[] bArr711111111111111111111111111111111111111111111111111111111119 = bArr29;
        java.lang.System.arraycopy(bArr711111111111111111111111111111111111111111111111111111111119, 0, bArr711111111111111111111111111111111111111111111111111111111115, length1111111111111111111111111111111111111111111111111111111111111111117, bArr711111111111111111111111111111111111111111111111111111111119.length);
        int length1111111111111111111111111111111111111111111111111111111111111111118 = length1111111111111111111111111111111111111111111111111111111111111111117 + bArr711111111111111111111111111111111111111111111111111111111119.length;
        java.lang.System.arraycopy(bArr45, 0, bArr711111111111111111111111111111111111111111111111111111111115, length1111111111111111111111111111111111111111111111111111111111111111118, bArr45.length);
        int length1111111111111111111111111111111111111111111111111111111111111111119 = length1111111111111111111111111111111111111111111111111111111111111111118 + bArr45.length;
        byte[] bArr7111111111111111111111111111111111111111111111111111111111110 = bArr13;
        java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111111111110, 0, bArr711111111111111111111111111111111111111111111111111111111115, length1111111111111111111111111111111111111111111111111111111111111111119, bArr7111111111111111111111111111111111111111111111111111111111110.length);
        int length2111111111111111111111111111111111111111111111111111111111111111110 = length1111111111111111111111111111111111111111111111111111111111111111119 + bArr7111111111111111111111111111111111111111111111111111111111110.length;
        java.lang.System.arraycopy(bArr61111111111111111111111111111111111111118, 0, bArr711111111111111111111111111111111111111111111111111111111115, length2111111111111111111111111111111111111111111111111111111111111111110, bArr61111111111111111111111111111111111111118.length);
        int length2111111111111111111111111111111111111111111111111111111111111111111 = length2111111111111111111111111111111111111111111111111111111111111111110 + bArr61111111111111111111111111111111111111118.length;
        java.lang.System.arraycopy(bArr61111111111111111111111111111111111111119, 0, bArr711111111111111111111111111111111111111111111111111111111115, length2111111111111111111111111111111111111111111111111111111111111111111, bArr61111111111111111111111111111111111111119.length);
        int length2111111111111111111111111111111111111111111111111111111111111111112 = length2111111111111111111111111111111111111111111111111111111111111111111 + bArr61111111111111111111111111111111111111119.length;
        byte[] bArr7111111111111111111111111111111111111111111111111111111111111 = bArr16;
        java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111111111111, 0, bArr711111111111111111111111111111111111111111111111111111111115, length2111111111111111111111111111111111111111111111111111111111111111112, bArr7111111111111111111111111111111111111111111111111111111111111.length);
        int length2111111111111111111111111111111111111111111111111111111111111111113 = length2111111111111111111111111111111111111111111111111111111111111111112 + bArr7111111111111111111111111111111111111111111111111111111111111.length;
        byte[] bArr7111111111111111111111111111111111111111111111111111111111112 = bArr19;
        java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111111111112, 0, bArr711111111111111111111111111111111111111111111111111111111115, length2111111111111111111111111111111111111111111111111111111111111111113, bArr7111111111111111111111111111111111111111111111111111111111112.length);
        int length2111111111111111111111111111111111111111111111111111111111111111114 = length2111111111111111111111111111111111111111111111111111111111111111113 + bArr7111111111111111111111111111111111111111111111111111111111112.length;
        byte[] bArr7111111111111111111111111111111111111111111111111111111111113 = bArr22;
        java.lang.System.arraycopy(bArr7111111111111111111111111111111111111111111111111111111111113, 0, bArr711111111111111111111111111111111111111111111111111111111115, length2111111111111111111111111111111111111111111111111111111111111111114, bArr7111111111111111111111111111111111111111111111111111111111113.length);
        int length2111111111111111111111111111111111111111111111111111111111111111115 = length2111111111111111111111111111111111111111111111111111111111111111114 + bArr7111111111111111111111111111111111111111111111111111111111113.length;
        java.lang.System.arraycopy(bArr511111112, 0, bArr711111111111111111111111111111111111111111111111111111111115, length2111111111111111111111111111111111111111111111111111111111111111115, bArr511111112.length);
        int length2111111111111111111111111111111111111111111111111111111111111111116 = length2111111111111111111111111111111111111111111111111111111111111111115 + bArr511111112.length;
        java.lang.System.arraycopy(bArr621111111111111111111111118, 0, bArr711111111111111111111111111111111111111111111111111111111115, length2111111111111111111111111111111111111111111111111111111111111111116, bArr621111111111111111111111118.length);
        int length2111111111111111111111111111111111111111111111111111111111111111117 = length2111111111111111111111111111111111111111111111111111111111111111116 + bArr621111111111111111111111118.length;
        java.lang.System.arraycopy(bArr61111111111111111111111111111111111111115, 0, bArr711111111111111111111111111111111111111111111111111111111115, length2111111111111111111111111111111111111111111111111111111111111111117, bArr61111111111111111111111111111111111111115.length);
        java.lang.System.arraycopy(bArr61111111111111111111111111111111111111117, 0, bArr711111111111111111111111111111111111111111111111111111111115, length2111111111111111111111111111111111111111111111111111111111111111117 + bArr61111111111111111111111111111111111111115.length, bArr61111111111111111111111111111111111111117.length);
        int length2111111111111111111111111111111111111111111111111111111111111111118 = bArr61111111111111111111111111111111111111117.length;
        return a(a(bArr711111111111111111111111111111111111111111111111111111111115, this.u, i111111110), this.y, this.A, this.B);
    }

    public int a(long j, int i, long j2, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i3, int i4, long[] jArr, int i5, long j3, int i6, int i7, int i8, int i9, int i10, byte[] bArr4, long j4, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        int iA;
        byte[] bArr5;
        byte[] bArr6;
        oicq.wlogin_sdk.request.y yVar = this;
        long j5 = j2;
        oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo2 = wUserSigInfo;
        oicq.wlogin_sdk.tools.util.LOGI("start request_tgtgt_nopicsig", "" + j5);
        int i11 = oicq.wlogin_sdk.request.t.w;
        byte[] bArrC = yVar.c(bArr2);
        if (bArrC == null) {
            return oicq.wlogin_sdk.tools.util.E_A1_DECRYPT;
        }
        int i12 = 0;
        while (true) {
            if (yVar.y == oicq.wlogin_sdk.request.oicq_request.EncryptionMethod.EM_ST && ((bArr5 = yVar.B) == null || bArr5.length == 0 || (bArr6 = yVar.A) == null || bArr6.length == 0)) {
                yVar.y = oicq.wlogin_sdk.request.oicq_request.EncryptionMethod.EM_ECDH;
                oicq.wlogin_sdk.request.t.an.attr_api(2413503);
                oicq.wlogin_sdk.tools.util.LOGI("using wt st encrypt body but no st key", "" + j5);
            }
            int i13 = i12;
            a(j2, a(j, i11, j2, i2, bArr, bArrC, bArr3, i3, i4, jArr, i5, j3, i11, i7, i8, i9, i10, bArr4, j4, oicq.wlogin_sdk.request.t.E, wUserSigInfo2._domains, wUserSigInfo2._source_type), this.y);
            iA = a(java.lang.String.valueOf(this.x.f), false, wUserSigInfo);
            if (iA != 0) {
                break;
            }
            iA = b();
            oicq.wlogin_sdk.tools.util.LOGI("retry num:" + i13 + " ret:" + iA, "" + j2);
            if (iA != 180) {
                break;
            }
            i12 = i13 + 1;
            if (i13 >= 1) {
                break;
            }
            yVar = this;
            wUserSigInfo2 = wUserSigInfo;
            j5 = j2;
        }
        oicq.wlogin_sdk.tools.util.LOGI("end request_tgtgt_nopicsig ret " + iA, "" + j2);
        return iA;
    }
}
