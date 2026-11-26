package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class s extends oicq.wlogin_sdk.request.oicq_request {
    static int I;

    public s(oicq.wlogin_sdk.request.t tVar) {
        this.t = 2064;
        this.u = 8;
        this.v = "wtlogin.login";
        this.x = tVar;
        tVar.m = 0;
    }

    public int a(long j, int i, int i2, long[] jArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        int i3;
        int iA;
        int i4 = oicq.wlogin_sdk.request.t.w;
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(this.x.h);
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var = async_contextVarB._t104;
        if (tlv_t104Var == null) {
            tlv_t104Var = new oicq.wlogin_sdk.tlv_type.tlv_t104();
        }
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var2 = tlv_t104Var;
        oicq.wlogin_sdk.tlv_type.tlv_t174 tlv_t174Var = async_contextVarB._t174;
        if (tlv_t174Var == null) {
            tlv_t174Var = new oicq.wlogin_sdk.tlv_type.tlv_t174();
        }
        oicq.wlogin_sdk.tlv_type.tlv_t174 tlv_t174Var2 = tlv_t174Var;
        int i5 = 0;
        do {
            i3 = i5;
            a(this.i, this.t, this.j, this.x.f, this.m, this.n, i4, this.p, a(tlv_t104Var2.get_data(), j, tlv_t174Var2.get_data(), i, i2, jArr));
            iA = a(java.lang.String.valueOf(this.x.f), false, wUserSigInfo);
            if (iA != 0) {
                break;
            }
            iA = b();
            oicq.wlogin_sdk.tools.util.LOGI("retry num:" + i3 + " ret:" + iA, "" + this.x.f);
            if (iA != 180) {
                break;
            }
            i5 = i3 + 1;
        } while (i3 < 1);
        return iA;
    }

    public byte[] a(byte[] bArr, long j, byte[] bArr2, int i, int i2, long[] jArr) {
        oicq.wlogin_sdk.tlv_type.tlv_t8 tlv_t8Var = new oicq.wlogin_sdk.tlv_type.tlv_t8();
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var = new oicq.wlogin_sdk.tlv_type.tlv_t104();
        oicq.wlogin_sdk.tlv_type.tlv_t116 tlv_t116Var = new oicq.wlogin_sdk.tlv_type.tlv_t116();
        oicq.wlogin_sdk.tlv_type.tlv_t174 tlv_t174Var = new oicq.wlogin_sdk.tlv_type.tlv_t174();
        oicq.wlogin_sdk.tlv_type.tlv_t17a tlv_t17aVar = new oicq.wlogin_sdk.tlv_type.tlv_t17a();
        oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar = new oicq.wlogin_sdk.tlv_type.tlv_t(com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_LOAD_X5);
        byte[] bArr3 = tlv_t8Var.get_tlv_8(0, oicq.wlogin_sdk.request.t.u, 0);
        byte[] bArr4 = tlv_t104Var.get_tlv_104(bArr);
        byte[] bArr5 = tlv_t116Var.get_tlv_116(i, i2, jArr);
        byte[] bArr6 = tlv_t174Var.get_tlv_174(bArr2);
        byte[] bArr7 = tlv_t17aVar.get_tlv_17a(j);
        tlv_tVar.set_data(new byte[]{(byte) I}, 1);
        byte[] bArr8 = tlv_tVar.get_buf();
        byte[] bArr9 = new byte[bArr3.length + bArr4.length + bArr5.length + bArr6.length + bArr7.length + bArr8.length];
        java.lang.System.arraycopy(bArr3, 0, bArr9, 0, bArr3.length);
        int length = bArr3.length + 0;
        java.lang.System.arraycopy(bArr4, 0, bArr9, length, bArr4.length);
        int length2 = length + bArr4.length;
        java.lang.System.arraycopy(bArr5, 0, bArr9, length2, bArr5.length);
        int length3 = length2 + bArr5.length;
        java.lang.System.arraycopy(bArr6, 0, bArr9, length3, bArr6.length);
        int length4 = length3 + bArr6.length;
        java.lang.System.arraycopy(bArr7, 0, bArr9, length4, bArr7.length);
        java.lang.System.arraycopy(bArr8, 0, bArr9, length4 + bArr7.length, bArr8.length);
        int length5 = bArr8.length;
        return b(bArr9, this.u, 6);
    }

    @Override // oicq.wlogin_sdk.request.oicq_request
    public int d(byte[] bArr, int i, int i2) {
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var = new oicq.wlogin_sdk.tlv_type.tlv_t104();
        oicq.wlogin_sdk.tlv_type.tlv_t17b tlv_t17bVar = new oicq.wlogin_sdk.tlv_type.tlv_t17b();
        oicq.wlogin_sdk.tlv_type.tlv_t161 tlv_t161Var = new oicq.wlogin_sdk.tlv_type.tlv_t161();
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(this.x.h);
        int iC = c(bArr, i + 2);
        oicq.wlogin_sdk.tools.util.LOGD(oicq.wlogin_sdk.request.s.class.getName(), "type=" + iC);
        int i3 = i + 5;
        if (iC != 160) {
            if (iC == 180) {
                int i4 = tlv_t161Var.get_tlv(bArr, i3, (this.c - i3) - 1);
                if (i4 < 0) {
                    return i4;
                }
                a(tlv_t161Var);
            }
            c(bArr, i3, (this.c - i3) - 1);
        } else {
            int i5 = tlv_t104Var.get_tlv(bArr, i3, this.c - i3);
            if (i5 < 0) {
                return i5;
            }
            async_contextVarB._t104 = tlv_t104Var;
            int i6 = tlv_t17bVar.get_tlv(bArr, i3, this.c - i3);
            if (i6 < 0) {
                return i6;
            }
            async_contextVarB._t17b = tlv_t17bVar;
            a((oicq.wlogin_sdk.tools.ErrMsg) null);
        }
        return iC;
    }
}
