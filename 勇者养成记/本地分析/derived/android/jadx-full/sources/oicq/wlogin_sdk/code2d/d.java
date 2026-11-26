package oicq.wlogin_sdk.code2d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d extends oicq.wlogin_sdk.code2d.b {

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1659a;
        long b;
        long c;
        int d;

        a() {
        }
    }

    public d() {
        this._cmd = 18;
    }

    public int a(byte[] bArr) {
        byte[] bArr2 = get_response(bArr, 0);
        if (bArr2 != null && bArr2.length >= 8) {
            oicq.wlogin_sdk.code2d.d.a aVarA = a(bArr2, 0);
            oicq.wlogin_sdk.code2d.c cVar = oicq.wlogin_sdk.code2d.b._status;
            cVar.f1658a = aVarA.b;
            cVar.h = aVarA.c;
            int i = aVarA.d;
            cVar.b = i;
            int i2 = aVarA.f1659a + 0;
            if (i != 0) {
                return i;
            }
            cVar.f1658a = oicq.wlogin_sdk.tools.util.buf_to_int64(bArr2, i2);
            int i3 = i2 + 8;
            oicq.wlogin_sdk.code2d.b._status.c = oicq.wlogin_sdk.tools.util.buf_to_int32(bArr2, i3);
            int i4 = i3 + 4;
            oicq.wlogin_sdk.code2d.b._status.e = new java.util.ArrayList();
            int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, i4);
            byte[] bArr3 = null;
            int i5 = i4 + 2;
            byte[] bArr4 = null;
            byte[] bArr5 = null;
            byte[] bArr6 = null;
            for (int i6 = 0; i6 < iBuf_to_int16; i6++) {
                int iBuf_to_int17 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, i5);
                int i7 = i5 + 2;
                int iBuf_to_int18 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, i7);
                int i8 = i7 + 2;
                if (iBuf_to_int17 == 24) {
                    bArr3 = new byte[iBuf_to_int18];
                    java.lang.System.arraycopy(bArr2, i8, bArr3, 0, iBuf_to_int18);
                } else if (iBuf_to_int17 == 25) {
                    bArr5 = new byte[iBuf_to_int18];
                    java.lang.System.arraycopy(bArr2, i8, bArr5, 0, iBuf_to_int18);
                } else if (iBuf_to_int17 != 30) {
                    if (iBuf_to_int17 != 101) {
                        int i9 = iBuf_to_int18 + 4;
                        byte[] bArr7 = new byte[i9];
                        java.lang.System.arraycopy(bArr2, i8 - 4, bArr7, 0, i9);
                        oicq.wlogin_sdk.code2d.b._status.e.add(bArr7);
                    } else {
                        bArr6 = new byte[iBuf_to_int18];
                        java.lang.System.arraycopy(bArr2, i8, bArr6, 0, iBuf_to_int18);
                        i5 = i8 + iBuf_to_int18;
                        oicq.wlogin_sdk.tools.util.LOGI("get tgtQR len " + iBuf_to_int18, "" + oicq.wlogin_sdk.code2d.b._status.f1658a);
                    }
                } else {
                    bArr4 = new byte[iBuf_to_int18];
                    java.lang.System.arraycopy(bArr2, i8, bArr4, 0, iBuf_to_int18);
                }
                i5 = i8 + iBuf_to_int18;
            }
            if (bArr3 != null && bArr4 != null && bArr5 != null) {
                oicq.wlogin_sdk.code2d.c.q = oicq.wlogin_sdk.request.oicq_request.b(bArr3, bArr4);
                oicq.wlogin_sdk.code2d.c.r = bArr5;
                oicq.wlogin_sdk.code2d.c.s = bArr6;
                return oicq.wlogin_sdk.code2d.b._status.b;
            }
        }
        return oicq.wlogin_sdk.tools.util.E_PK_LEN;
    }

    protected oicq.wlogin_sdk.code2d.d.a a(byte[] bArr, int i) {
        oicq.wlogin_sdk.code2d.d.a aVar = new oicq.wlogin_sdk.code2d.d.a();
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, i);
        int i2 = i + 2;
        if (2 == (iBuf_to_int16 != 0 ? oicq.wlogin_sdk.tools.util.buf_to_int8(bArr, i2) : 0)) {
            aVar.b = oicq.wlogin_sdk.tools.util.buf_to_int64(bArr, i2 + 1);
        }
        int i3 = i2 + iBuf_to_int16;
        aVar.c = oicq.wlogin_sdk.tools.util.buf_to_int32(bArr, i3);
        aVar.d = oicq.wlogin_sdk.tools.util.buf_to_int8(bArr, i3 + 4);
        aVar.f1659a = iBuf_to_int16 + 2 + 4 + 1;
        return aVar;
    }

    public byte[] a(long j, long j2, byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + 13 + bArr2.length + 11 + 2];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr3, 0, 5);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr3, 2, 1);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr3, 3, oicq.wlogin_sdk.request.t.au);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr3, 7, j2);
        int iFill_staff = fill_staff(bArr3, bArr, 11);
        oicq.wlogin_sdk.tools.util.int64_to_buf(bArr3, iFill_staff, j);
        int i = iFill_staff + 8;
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr3, i, 8);
        fill_staff(bArr3, bArr2, i + 1);
        return get_request(j, true, bArr3);
    }
}
