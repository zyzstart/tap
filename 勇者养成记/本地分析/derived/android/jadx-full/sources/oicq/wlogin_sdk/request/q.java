package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class q extends oicq.wlogin_sdk.request.oicq_request {
    public q(oicq.wlogin_sdk.request.t tVar) {
        this.t = 2064;
        this.u = 20;
        this.v = "wtlogin.login";
        this.x = tVar;
        tVar.m = 0;
    }

    public int a(int i, int i2, long[] jArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        int iA;
        int i3 = oicq.wlogin_sdk.request.t.w;
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(this.x.h);
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var = async_contextVarB._t104;
        if (tlv_t104Var == null) {
            tlv_t104Var = new oicq.wlogin_sdk.tlv_type.tlv_t104();
        }
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var2 = tlv_t104Var;
        oicq.wlogin_sdk.tlv_type.tlv_t402 tlv_t402Var = async_contextVarB._t402;
        if (tlv_t402Var == null) {
            tlv_t402Var = new oicq.wlogin_sdk.tlv_type.tlv_t402();
        }
        oicq.wlogin_sdk.tlv_type.tlv_t403 tlv_t403Var = async_contextVarB._t403;
        if (tlv_t403Var == null) {
            tlv_t403Var = new oicq.wlogin_sdk.tlv_type.tlv_t403();
        }
        byte[] bytes = oicq.wlogin_sdk.tools.util.get_mpasswd().getBytes();
        async_contextVarB._dpwd = bytes;
        async_contextVarB._G = c(oicq.wlogin_sdk.request.t.A, bytes, tlv_t402Var.get_data());
        if (tlv_t402Var.get_data_len() > 0 && tlv_t403Var.get_data_len() > 0) {
            async_contextVarB._sec_guid_flag = true;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            int i6 = i3;
            a(this.i, this.t, this.j, this.x.f, this.m, this.n, i3, this.p, a(tlv_t104Var2.get_data(), i, i2, jArr, async_contextVarB._G));
            iA = a(java.lang.String.valueOf(this.x.f), false, wUserSigInfo);
            if (iA != 0) {
                break;
            }
            iA = b();
            oicq.wlogin_sdk.tools.util.LOGI("retry num:" + i5 + " ret:" + iA, "" + this.x.f);
            if (iA != 180) {
                break;
            }
            i4 = i5 + 1;
            if (i5 >= 1) {
                break;
            }
            i3 = i6;
        }
        return iA;
    }

    public byte[] a(byte[] bArr, int i, int i2, long[] jArr, byte[] bArr2) {
        oicq.wlogin_sdk.tlv_type.tlv_t8 tlv_t8Var = new oicq.wlogin_sdk.tlv_type.tlv_t8();
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var = new oicq.wlogin_sdk.tlv_type.tlv_t104();
        oicq.wlogin_sdk.tlv_type.tlv_t116 tlv_t116Var = new oicq.wlogin_sdk.tlv_type.tlv_t116();
        oicq.wlogin_sdk.tlv_type.tlv_t401 tlv_t401Var = new oicq.wlogin_sdk.tlv_type.tlv_t401();
        byte[] bArr3 = tlv_t8Var.get_tlv_8(0, oicq.wlogin_sdk.request.t.u, 0);
        byte[] bArr4 = tlv_t104Var.get_tlv_104(bArr);
        byte[] bArr5 = tlv_t116Var.get_tlv_116(i, i2, jArr);
        byte[] bArr6 = tlv_t401Var.get_tlv_401(bArr2);
        byte[] bArr7 = new byte[bArr3.length + bArr4.length + bArr5.length + bArr6.length];
        java.lang.System.arraycopy(bArr3, 0, bArr7, 0, bArr3.length);
        int length = bArr3.length + 0;
        java.lang.System.arraycopy(bArr4, 0, bArr7, length, bArr4.length);
        int length2 = length + bArr4.length;
        java.lang.System.arraycopy(bArr5, 0, bArr7, length2, bArr5.length);
        java.lang.System.arraycopy(bArr6, 0, bArr7, length2 + bArr5.length, bArr6.length);
        int length3 = bArr6.length;
        return b(bArr7, this.u, 4);
    }
}
