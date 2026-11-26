package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c extends oicq.wlogin_sdk.request.oicq_request {
    private java.lang.String I;

    public c(oicq.wlogin_sdk.request.t tVar, java.lang.String str) {
        this.t = 2064;
        this.u = 22;
        this.v = "wtlogin.login";
        this.x = tVar;
        tVar.m = 0;
        this.I = str;
    }

    public int a(int i, int i2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        int iA;
        int i3 = 0;
        while (true) {
            a(this.x.f, a(i, i2), this.y);
            iA = a(java.lang.String.valueOf(this.x.f), false, wUserSigInfo);
            if (iA != 0) {
                break;
            }
            iA = b();
            oicq.wlogin_sdk.tools.util.LOGI("retry num:" + i3 + " ret:" + iA, "" + this.x.f);
            if (iA != 180) {
                break;
            }
            int i4 = i3 + 1;
            if (i3 >= 1) {
                break;
            }
            i3 = i4;
        }
        return iA;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public byte[] a(int i, int i2) {
        int[] iArr = {8, 256, 264, 265, 278, com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02, com.tencent.smtt.sdk.TbsListener.ErrorCode.THROWABLE_INITX5CORE, 340, 387, 388, 1312};
        java.util.ArrayList arrayList = new java.util.ArrayList();
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(this.x.h);
        int i3 = 0;
        int length = 0;
        int i4 = 0;
        for (int i5 = 11; i3 < i5; i5 = 11) {
            byte[] bArr = new byte[0];
            switch (iArr[i3]) {
                case 8:
                    bArr = new oicq.wlogin_sdk.tlv_type.tlv_t8().get_tlv_8(0, oicq.wlogin_sdk.request.t.u, 0);
                    break;
                case 256:
                    bArr = new oicq.wlogin_sdk.tlv_type.tlv_t100().get_tlv_100(async_contextVarB._appid, async_contextVarB._sub_appid, 0, async_contextVarB._main_sigmap);
                    break;
                case 264:
                    byte[] bArr2 = oicq.wlogin_sdk.request.t.aa;
                    if (bArr2 != null && bArr2.length != 0) {
                        oicq.wlogin_sdk.tlv_type.tlv_t108 tlv_t108Var = new oicq.wlogin_sdk.tlv_type.tlv_t108();
                        byte[] bArr3 = oicq.wlogin_sdk.request.t.aa;
                        tlv_t108Var.set_data(bArr3, bArr3.length);
                        bArr = tlv_t108Var.get_buf();
                    }
                    break;
                case 265:
                    bArr = new oicq.wlogin_sdk.tlv_type.tlv_t109().get_tlv_109(oicq.wlogin_sdk.request.t.M);
                    break;
                case 278:
                    bArr = new oicq.wlogin_sdk.tlv_type.tlv_t116().get_tlv_116(i, i2, async_contextVarB._sub_appid_list);
                    break;
                case com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02 /* 322 */:
                    bArr = new oicq.wlogin_sdk.tlv_type.tlv_t142().get_tlv_142(oicq.wlogin_sdk.request.t.E);
                    break;
                case com.tencent.smtt.sdk.TbsListener.ErrorCode.THROWABLE_INITX5CORE /* 325 */:
                    bArr = new oicq.wlogin_sdk.tlv_type.tlv_t145().get_tlv_145(oicq.wlogin_sdk.request.t.A);
                    break;
                case 340:
                    bArr = new oicq.wlogin_sdk.tlv_type.tlv_t154().get_tlv_154(this.x.i);
                    break;
                case 387:
                    bArr = new oicq.wlogin_sdk.tlv_type.tlv_t183().get_tlv_183(async_contextVarB._msalt);
                    break;
                case 388:
                    bArr = new oicq.wlogin_sdk.tlv_type.tlv_t184().get_tlv_184(async_contextVarB._msalt, async_contextVarB._mpasswd);
                    break;
                case 1312:
                    oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar = new oicq.wlogin_sdk.tlv_type.tlv_t(1312);
                    byte[] bArrString_to_buf = oicq.wlogin_sdk.tools.util.string_to_buf(this.I);
                    tlv_tVar.set_data(bArrString_to_buf, bArrString_to_buf.length);
                    bArr = tlv_tVar.get_buf();
                    break;
                default:
                    break;
            }
            if (bArr.length > 4) {
                i4++;
                length += bArr.length;
                arrayList.add(bArr);
            }
            i3++;
        }
        byte[] bArr4 = new byte[length];
        int length2 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            byte[] bArr5 = (byte[]) arrayList.get(i6);
            java.lang.System.arraycopy(bArr5, 0, bArr4, length2, bArr5.length);
            length2 += bArr5.length;
        }
        return b(bArr4, this.u, i4);
    }
}
