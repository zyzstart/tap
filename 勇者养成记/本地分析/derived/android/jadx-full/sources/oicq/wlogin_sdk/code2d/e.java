package oicq.wlogin_sdk.code2d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e extends oicq.wlogin_sdk.code2d.b {
    public e() {
        this._cmd = 19;
    }

    public int a(byte[] bArr) {
        byte[] bArr2 = get_response(bArr, 0);
        if (bArr2 == null || bArr2.length < 11) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        oicq.wlogin_sdk.code2d.b._status.f1658a = oicq.wlogin_sdk.tools.util.buf_to_int64(bArr2, 2);
        oicq.wlogin_sdk.code2d.b._status.b = oicq.wlogin_sdk.tools.util.buf_to_int8(bArr2, 10) & 255;
        oicq.wlogin_sdk.code2d.c cVar = oicq.wlogin_sdk.code2d.b._status;
        if (cVar.b != 0) {
            int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, 11);
            byte[] bArr3 = new byte[iBuf_to_int16];
            oicq.wlogin_sdk.code2d.b._status.f = bArr3;
            java.lang.System.arraycopy(bArr2, 13, bArr3, 0, iBuf_to_int16);
        } else {
            cVar.c = ((long) oicq.wlogin_sdk.tools.util.buf_to_int32(bArr2, 11)) & 4294967295L;
            int iBuf_to_int17 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, 15);
            byte[] bArr4 = new byte[iBuf_to_int17];
            oicq.wlogin_sdk.code2d.b._status.d = bArr4;
            java.lang.System.arraycopy(bArr2, 17, bArr4, 0, iBuf_to_int17);
            int i = iBuf_to_int17 + 17;
            int iBuf_to_int18 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, i);
            oicq.wlogin_sdk.code2d.c cVar2 = oicq.wlogin_sdk.code2d.b._status;
            cVar2.g = new byte[0];
            cVar2.e = new java.util.ArrayList(iBuf_to_int18);
            int i2 = i + 2;
            for (int i3 = 0; i3 < iBuf_to_int18; i3++) {
                int iBuf_to_int19 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, i2);
                int iBuf_to_int110 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, i2 + 2);
                if (iBuf_to_int19 == 13) {
                    byte[] bArr5 = new byte[iBuf_to_int110];
                    oicq.wlogin_sdk.code2d.b._status.g = bArr5;
                    java.lang.System.arraycopy(bArr2, i2 + 4, bArr5, 0, iBuf_to_int110);
                } else if (iBuf_to_int19 == 26) {
                    oicq.wlogin_sdk.code2d.c.t = oicq.wlogin_sdk.tools.util.buf_to_int8(bArr2, i2 + 4) == 1;
                } else {
                    int i4 = iBuf_to_int110 + 4;
                    byte[] bArr6 = new byte[i4];
                    java.lang.System.arraycopy(bArr2, i2, bArr6, 0, i4);
                    oicq.wlogin_sdk.code2d.b._status.e.add(bArr6);
                }
                i2 += iBuf_to_int110 + 4;
            }
        }
        return oicq.wlogin_sdk.code2d.b._status.b;
    }

    public byte[] a(long j, long j2, boolean z, byte[] bArr, int[] iArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, byte[] bArr5) {
        int length;
        int length2;
        byte[] bArr6 = bArr == null ? new byte[0] : bArr;
        int[] iArr2 = iArr == null ? new int[0] : iArr;
        byte[] bArr7 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArr8 = bArr3 == null ? new byte[0] : bArr3;
        byte[] bArr9 = bArr4 == null ? new byte[0] : bArr4;
        byte[] bArr10 = bArr5 == null ? new byte[0] : bArr5;
        int i2 = 1;
        if (bArr10 == null || bArr10.length <= 0) {
            length = bArr6.length + 16 + 2 + bArr7.length + 16 + 1 + 2 + 1 + 2 + (iArr2.length * 2) + 2 + 4;
            length2 = bArr9.length;
        } else {
            length = bArr6.length + 16 + 2 + bArr7.length + 16 + 1 + 2 + 1 + 2 + (iArr2.length * 2) + 2 + 4 + bArr9.length + 4;
            length2 = bArr10.length;
        }
        byte[] bArr11 = new byte[length + length2];
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr11, 2, j2);
        oicq.wlogin_sdk.tools.util.int64_to_buf(bArr11, 6, j);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr11, 14, bArr6.length);
        java.lang.System.arraycopy(bArr6, 0, bArr11, 16, bArr6.length);
        int length3 = bArr6.length + 16;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr11, length3, bArr7.length);
        int i3 = length3 + 2;
        java.lang.System.arraycopy(bArr7, 0, bArr11, i3, bArr7.length);
        int length4 = i3 + bArr7.length;
        if (bArr8 != null && bArr8.length == 16) {
            java.lang.System.arraycopy(bArr8, 0, bArr11, length4, 16);
        }
        int i4 = length4 + 16;
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr11, i4, 1);
        int i5 = i4 + 1;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr11, i5, i);
        int i6 = i5 + 2;
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr11, i6, 3);
        int i7 = i6 + 1;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr11, i7, iArr2.length);
        int i8 = i7 + 2;
        for (int i9 : iArr2) {
            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr11, i8, i9);
            i8 += 2;
        }
        if (bArr10 != null && bArr10.length > 0) {
            i2 = 2;
        }
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr11, i8, i2);
        int i10 = i8 + 2;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr11, i10, 9);
        int i11 = i10 + 2;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr11, i11, bArr9.length);
        int i12 = i11 + 2;
        java.lang.System.arraycopy(bArr9, 0, bArr11, i12, bArr9.length);
        int length5 = i12 + bArr9.length;
        if (bArr10 != null && bArr10.length > 0) {
            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr11, length5, 12);
            int i13 = length5 + 2;
            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr11, i13, bArr10.length);
            java.lang.System.arraycopy(bArr10, 0, bArr11, i13 + 2, bArr10.length);
            int length6 = bArr10.length;
        }
        return get_request(j, z, bArr11);
    }
}
