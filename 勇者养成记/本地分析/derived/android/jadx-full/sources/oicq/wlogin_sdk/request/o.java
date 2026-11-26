package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class o extends oicq.wlogin_sdk.request.oicq_request {
    public static boolean I = false;

    public o(oicq.wlogin_sdk.request.t tVar) {
        this.t = 2064;
        this.u = 2;
        this.v = "wtlogin.login";
        this.x = tVar;
        tVar.m = 0;
    }

    public int a(byte[] bArr, int i, int i2, long[] jArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        int i3;
        int iA;
        int i4 = oicq.wlogin_sdk.request.t.w;
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(this.x.h);
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var = async_contextVarB._t104;
        if (tlv_t104Var == null) {
            tlv_t104Var = new oicq.wlogin_sdk.tlv_type.tlv_t104();
        }
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var2 = tlv_t104Var;
        oicq.wlogin_sdk.tlv_type.tlv_t105 tlv_t105Var = async_contextVarB._t105;
        if (tlv_t105Var == null) {
            tlv_t105Var = new oicq.wlogin_sdk.tlv_type.tlv_t105();
        }
        oicq.wlogin_sdk.tlv_type.tlv_t105 tlv_t105Var2 = tlv_t105Var;
        int i5 = 0;
        do {
            i3 = i5;
            a(this.i, this.t, this.j, this.x.f, this.m, this.n, i4, this.p, a(tlv_t104Var2.get_data(), bArr, tlv_t105Var2.get_sign(), i, i2, jArr));
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

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, long[] jArr) {
        oicq.wlogin_sdk.tlv_type.tlv_t2 tlv_t2Var = new oicq.wlogin_sdk.tlv_type.tlv_t2();
        oicq.wlogin_sdk.tlv_type.tlv_t8 tlv_t8Var = new oicq.wlogin_sdk.tlv_type.tlv_t8();
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var = new oicq.wlogin_sdk.tlv_type.tlv_t104();
        oicq.wlogin_sdk.tlv_type.tlv_t116 tlv_t116Var = new oicq.wlogin_sdk.tlv_type.tlv_t116();
        oicq.wlogin_sdk.tlv_type.tlv_t193 tlv_t193Var = new oicq.wlogin_sdk.tlv_type.tlv_t193();
        byte[] bArr4 = tlv_t8Var.get_tlv_8(0, oicq.wlogin_sdk.request.t.u, 0);
        byte[] bArr5 = tlv_t104Var.get_tlv_104(bArr);
        byte[] bArr6 = tlv_t116Var.get_tlv_116(i, i2, jArr);
        byte[] bArr7 = I ? tlv_t193Var.get_tlv_193(bArr2) : tlv_t2Var.get_tlv_2(bArr2, bArr3);
        byte[] bArr8 = new byte[bArr7.length + bArr4.length + bArr5.length + bArr6.length];
        java.lang.System.arraycopy(bArr7, 0, bArr8, 0, bArr7.length);
        int length = bArr7.length + 0;
        java.lang.System.arraycopy(bArr4, 0, bArr8, length, bArr4.length);
        int length2 = length + bArr4.length;
        java.lang.System.arraycopy(bArr5, 0, bArr8, length2, bArr5.length);
        java.lang.System.arraycopy(bArr6, 0, bArr8, length2 + bArr5.length, bArr6.length);
        int length3 = bArr6.length;
        return b(bArr8, this.u, 4);
    }
}
