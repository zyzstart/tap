package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class v extends oicq.wlogin_sdk.request.oicq_request {
    public v(oicq.wlogin_sdk.request.t tVar) {
        this.t = 2064;
        this.u = 17;
        this.v = "wtlogin.login";
        this.x = tVar;
        tVar.m = 0;
    }

    public int a(long j, long j2, int i, byte[] bArr, java.lang.String str, int i2, int i3, long[] jArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        int iA;
        int i4 = oicq.wlogin_sdk.request.t.w;
        int i5 = 0;
        while (true) {
            a(this.i, this.t, this.j, this.x.f, this.m, this.n, i4, this.p, a(j, j2, i, i4, bArr, str.getBytes(), i2, i3, jArr));
            iA = a(java.lang.String.valueOf(this.x.f), false, wUserSigInfo);
            if (iA != 0) {
                break;
            }
            iA = b();
            oicq.wlogin_sdk.tools.util.LOGI("retry num:" + i5 + " ret:" + iA, "" + this.x.f);
            if (iA != 180) {
                break;
            }
            int i6 = i5 + 1;
            if (i5 >= 1) {
                break;
            }
            i5 = i6;
        }
        return iA;
    }

    public byte[] a(long j, long j2, int i, int i2, byte[] bArr, byte[] bArr2, int i3, int i4, long[] jArr) {
        int[] iArr = {256, 264, 265, 8, com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02, com.tencent.smtt.sdk.TbsListener.ErrorCode.THROWABLE_INITX5CORE, 340, 274, 278};
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int length = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < 9; i6++) {
            byte[] bArr3 = new byte[0];
            int i7 = iArr[i6];
            if (i7 == 8) {
                bArr3 = new oicq.wlogin_sdk.tlv_type.tlv_t8().get_tlv_8(0, oicq.wlogin_sdk.request.t.u, 0);
            } else if (i7 == 256) {
                bArr3 = new oicq.wlogin_sdk.tlv_type.tlv_t100().get_tlv_100(j, j2, i2, i);
            } else if (i7 == 274) {
                bArr3 = new oicq.wlogin_sdk.tlv_type.tlv_t112().get_tlv_112(bArr2);
            } else if (i7 == 278) {
                bArr3 = new oicq.wlogin_sdk.tlv_type.tlv_t116().get_tlv_116(i3, i4, jArr);
            } else if (i7 == 322) {
                bArr3 = new oicq.wlogin_sdk.tlv_type.tlv_t142().get_tlv_142(oicq.wlogin_sdk.request.t.E);
            } else if (i7 == 325) {
                bArr3 = new oicq.wlogin_sdk.tlv_type.tlv_t145().get_tlv_145(oicq.wlogin_sdk.request.t.A);
            } else if (i7 != 340) {
                switch (i7) {
                    case 264:
                        if (bArr != null && bArr.length > 0) {
                            bArr3 = new oicq.wlogin_sdk.tlv_type.tlv_t108().get_tlv_108(bArr);
                        }
                        break;
                    case 265:
                        byte[] bArr4 = oicq.wlogin_sdk.request.t.M;
                        if (bArr4 != null && bArr4.length > 0) {
                            bArr3 = new oicq.wlogin_sdk.tlv_type.tlv_t109().get_tlv_109(oicq.wlogin_sdk.request.t.M);
                        }
                        break;
                }
            } else {
                bArr3 = new oicq.wlogin_sdk.tlv_type.tlv_t154().get_tlv_154(this.x.i);
            }
            if (bArr3.length > 4) {
                i5++;
                length += bArr3.length;
                arrayList.add(bArr3);
            }
        }
        byte[] bArr5 = new byte[length];
        int length2 = 0;
        for (int i8 = 0; i8 < i5; i8++) {
            byte[] bArr6 = (byte[]) arrayList.get(i8);
            java.lang.System.arraycopy(bArr6, 0, bArr5, length2, bArr6.length);
            length2 += bArr6.length;
        }
        return b(bArr5, this.u, i5);
    }
}
