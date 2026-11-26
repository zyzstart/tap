package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class r extends oicq.wlogin_sdk.request.oicq_request {
    public r(oicq.wlogin_sdk.request.t tVar) {
        this.t = 2064;
        this.u = 3;
        this.v = "wtlogin.login";
        this.x = tVar;
        tVar.m = 0;
    }

    public int a(int i, int i2, long[] jArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        int iA;
        int i3 = oicq.wlogin_sdk.request.t.w;
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var = oicq.wlogin_sdk.request.t.b(this.x.h)._t104;
        if (tlv_t104Var == null) {
            tlv_t104Var = new oicq.wlogin_sdk.tlv_type.tlv_t104();
        }
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var2 = tlv_t104Var;
        int i4 = 0;
        while (true) {
            a(this.i, this.t, this.j, this.x.f, this.m, this.n, i3, this.p, a(tlv_t104Var2.get_data(), i, i2, jArr));
            iA = a(java.lang.String.valueOf(this.x.f), false, wUserSigInfo);
            if (iA != 0) {
                break;
            }
            iA = b();
            oicq.wlogin_sdk.tools.util.LOGI("retry num:" + i4 + " ret:" + iA, "" + this.x.f);
            if (iA != 180) {
                break;
            }
            int i5 = i4 + 1;
            if (i4 >= 1) {
                break;
            }
            i4 = i5;
        }
        return iA;
    }

    public byte[] a(byte[] bArr, int i, int i2, long[] jArr) {
        oicq.wlogin_sdk.tlv_type.tlv_t8 tlv_t8Var = new oicq.wlogin_sdk.tlv_type.tlv_t8();
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var = new oicq.wlogin_sdk.tlv_type.tlv_t104();
        oicq.wlogin_sdk.tlv_type.tlv_t116 tlv_t116Var = new oicq.wlogin_sdk.tlv_type.tlv_t116();
        byte[] bArr2 = tlv_t8Var.get_tlv_8(0, oicq.wlogin_sdk.request.t.u, 0);
        byte[] bArr3 = tlv_t104Var.get_tlv_104(bArr);
        byte[] bArr4 = tlv_t116Var.get_tlv_116(i, i2, jArr);
        byte[] bArr5 = new byte[bArr2.length + bArr3.length + bArr4.length];
        java.lang.System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
        int length = bArr2.length + 0;
        java.lang.System.arraycopy(bArr3, 0, bArr5, length, bArr3.length);
        java.lang.System.arraycopy(bArr4, 0, bArr5, length + bArr3.length, bArr4.length);
        int length2 = bArr4.length;
        return b(bArr5, this.u, 3);
    }

    @Override // oicq.wlogin_sdk.request.oicq_request
    public int d(byte[] bArr, int i, int i2) {
        oicq.wlogin_sdk.tlv_type.tlv_t104 tlv_t104Var = new oicq.wlogin_sdk.tlv_type.tlv_t104();
        oicq.wlogin_sdk.tlv_type.tlv_t105 tlv_t105Var = new oicq.wlogin_sdk.tlv_type.tlv_t105();
        oicq.wlogin_sdk.tlv_type.tlv_t165 tlv_t165Var = new oicq.wlogin_sdk.tlv_type.tlv_t165();
        oicq.wlogin_sdk.tlv_type.tlv_t161 tlv_t161Var = new oicq.wlogin_sdk.tlv_type.tlv_t161();
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(this.x.h);
        int iC = c(bArr, i + 2);
        oicq.wlogin_sdk.tools.util.LOGD(oicq.wlogin_sdk.request.r.class.getName(), "type=" + iC);
        int i3 = i + 5;
        if (iC != 2) {
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
            int i6 = tlv_t105Var.get_tlv(bArr, i3, this.c - i3);
            if (i6 < 0) {
                return i6;
            }
            async_contextVarB._t105 = tlv_t105Var;
            if (tlv_t165Var.get_tlv(bArr, i3, this.c - i3) >= 0) {
                async_contextVarB._t165 = tlv_t165Var;
            } else {
                async_contextVarB._t165 = new oicq.wlogin_sdk.tlv_type.tlv_t165();
            }
            a((oicq.wlogin_sdk.tools.ErrMsg) null);
        }
        return iC;
    }
}
