package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class x extends oicq.wlogin_sdk.request.oicq_request {
    public x(oicq.wlogin_sdk.request.t tVar) {
        this.t = 2064;
        this.u = 18;
        this.v = "wtlogin.login";
        this.x = tVar;
        tVar.m = 0;
    }

    public int a(java.lang.String str, int i, int i2, long[] jArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        int iA;
        int i3 = oicq.wlogin_sdk.request.t.w;
        int i4 = 0;
        while (true) {
            a(this.i, this.t, this.j, this.x.f, this.m, this.n, i3, this.p, a(str.getBytes(), i, i2, jArr));
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
        int[] iArr = {260, 8, 295, 388, 278};
        java.util.ArrayList arrayList = new java.util.ArrayList();
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(this.x.h);
        int length = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 5; i4++) {
            byte[] bArr2 = new byte[0];
            int i5 = iArr[i4];
            if (i5 == 8) {
                bArr2 = new oicq.wlogin_sdk.tlv_type.tlv_t8().get_tlv_8(0, oicq.wlogin_sdk.request.t.u, 0);
            } else if (i5 == 260) {
                bArr2 = async_contextVarB._t104.get_buf();
            } else if (i5 == 278) {
                bArr2 = new oicq.wlogin_sdk.tlv_type.tlv_t116().get_tlv_116(i, i2, jArr);
            } else if (i5 == 295) {
                bArr2 = new oicq.wlogin_sdk.tlv_type.tlv_t127().get_tlv_127(bArr, async_contextVarB._t126.get_random());
            } else if (i5 == 388) {
                bArr2 = new oicq.wlogin_sdk.tlv_type.tlv_t184().get_tlv_184(async_contextVarB._msalt, async_contextVarB._mpasswd);
            }
            if (bArr2.length > 4) {
                i3++;
                length += bArr2.length;
                arrayList.add(bArr2);
            }
        }
        byte[] bArr3 = new byte[length];
        int length2 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            byte[] bArr4 = (byte[]) arrayList.get(i6);
            java.lang.System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
            length2 += bArr4.length;
        }
        return b(bArr3, this.u, i3);
    }
}
