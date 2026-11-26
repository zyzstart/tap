package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class p extends oicq.wlogin_sdk.request.oicq_request {
    public p(oicq.wlogin_sdk.request.t tVar) {
        this.t = 2064;
        this.u = 7;
        this.v = "wtlogin.login";
        this.x = tVar;
        tVar.m = 0;
    }

    public int a(byte[] bArr, int i, int i2, long[] jArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        int iA;
        int i3 = oicq.wlogin_sdk.request.t.w;
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
            byte[] bArrA = a(tlv_t104Var2.get_data(), bArr, tlv_t174Var2.get_data(), i, i2, jArr, async_contextVarB._G);
            oicq.wlogin_sdk.request.async_context async_contextVar = async_contextVarB;
            int i5 = i4;
            int i6 = i3;
            a(this.i, this.t, this.j, this.x.f, this.m, this.n, i3, this.p, bArrA);
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
            async_contextVarB = async_contextVar;
            i3 = i6;
        }
        return iA;
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, long[] jArr, byte[] bArr4) {
        int[] iArr = {8, 260, 278, 372, 380, 1025, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_DISABLED_BY_CRASH};
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int length = 0;
        for (int i3 = 0; i3 < 7; i3++) {
            byte[] bArr5 = null;
            int i4 = iArr[i3];
            if (i4 == 8) {
                bArr5 = new oicq.wlogin_sdk.tlv_type.tlv_t8().get_tlv_8(0, oicq.wlogin_sdk.request.t.u, 0);
            } else if (i4 == 260) {
                bArr5 = new oicq.wlogin_sdk.tlv_type.tlv_t104().get_tlv_104(bArr);
            } else if (i4 == 278) {
                bArr5 = new oicq.wlogin_sdk.tlv_type.tlv_t116().get_tlv_116(i, i2, jArr);
            } else if (i4 == 372) {
                bArr5 = new oicq.wlogin_sdk.tlv_type.tlv_t174().get_tlv_174(bArr3);
            } else if (i4 == 380) {
                bArr5 = new oicq.wlogin_sdk.tlv_type.tlv_t17c().get_tlv_17c(bArr2);
            } else if (i4 == 408) {
                oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar = new oicq.wlogin_sdk.tlv_type.tlv_t(com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_DISABLED_BY_CRASH);
                tlv_tVar.set_data(new byte[]{(byte) oicq.wlogin_sdk.request.s.I}, 1);
                bArr5 = tlv_tVar.get_buf();
            } else if (i4 == 1025) {
                bArr5 = new oicq.wlogin_sdk.tlv_type.tlv_t401().get_tlv_401(bArr4);
            }
            if (bArr5 != null) {
                arrayList.add(bArr5);
                length += bArr5.length;
            }
        }
        int size = arrayList.size();
        byte[] bArr6 = new byte[length];
        int length2 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            byte[] bArr7 = (byte[]) arrayList.get(i5);
            java.lang.System.arraycopy(bArr7, 0, bArr6, length2, bArr7.length);
            length2 += bArr7.length;
        }
        return b(bArr6, this.u, size);
    }
}
