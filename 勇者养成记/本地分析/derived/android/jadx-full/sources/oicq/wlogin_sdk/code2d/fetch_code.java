package oicq.wlogin_sdk.code2d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class fetch_code extends oicq.wlogin_sdk.code2d.b {

    public static class QRCodeCustom {
        public int Micro = 0;
        public int Version = 0;
        public int Size = 3;
        public int Margin = 4;
        public int Dpi = 72;
        public int EcLevel = 2;
        public int Hint = 2;
    }

    public fetch_code() {
        this._cmd = 49;
    }

    public byte[] get_request(long j, long j2, long j3, byte[] bArr, oicq.wlogin_sdk.code2d.fetch_code.QRCodeCustom qRCodeCustom, long j4, long j5, byte[] bArr2) {
        int length;
        byte[] appInfo;
        java.util.ArrayList arrayList;
        int i = 17;
        int length2 = bArr.length + 17 + 2;
        int[] iArr = {17, 22, 27, 29, 31, 51, 53};
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        int length3 = length2;
        int i2 = 0;
        for (int i3 = 7; i2 < i3; i3 = 7) {
            oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar = new oicq.wlogin_sdk.tlv_type.tlv_t();
            tlv_tVar.fill_head(iArr[i2]);
            int i4 = iArr[i2];
            if (i4 == i) {
                iArr = iArr;
                arrayList2 = arrayList2;
                if (bArr2 == 0 || bArr2.length <= 0) {
                    appInfo = null;
                    length = 0;
                } else {
                    int length4 = bArr2.length;
                    oicq.wlogin_sdk.tools.util.LOGI("qrpushsig of " + j2, j + "");
                    length = length4;
                    appInfo = bArr2;
                }
            } else if (i4 == 22) {
                iArr = iArr;
                arrayList2 = arrayList2;
                appInfo = getAppInfo(j2, j3);
                length = appInfo.length;
            } else if (i4 == 27) {
                byte[] bArr3 = new byte[30];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr3, 0, qRCodeCustom.Micro);
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr3, 4, qRCodeCustom.Version);
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr3, 8, qRCodeCustom.Size);
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr3, 12, qRCodeCustom.Margin);
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr3, 16, qRCodeCustom.Dpi);
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr3, 20, qRCodeCustom.EcLevel);
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr3, 24, qRCodeCustom.Hint);
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr3, 28, 0);
                appInfo = bArr3;
                length = 30;
            } else if (i4 == 29) {
                byte[] bArr4 = new byte[14];
                oicq.wlogin_sdk.tools.util.int8_to_buf(bArr4, 0, 1);
                oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr4, 1, j4);
                oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr4, 5, j5);
                oicq.wlogin_sdk.tools.util.int8_to_buf(bArr4, 9, 0);
                oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr4, 10, 0L);
                appInfo = bArr4;
                length = 14;
            } else if (i4 == 31) {
                int length5 = oicq.wlogin_sdk.request.t.K.length + 3 + 2 + oicq.wlogin_sdk.request.t.J.length + 2 + 2 + oicq.wlogin_sdk.request.t.C.length + 2 + 0 + 2 + oicq.wlogin_sdk.request.t.F.length;
                byte[] bArr5 = new byte[length5];
                oicq.wlogin_sdk.tools.util.LOGI("os " + new java.lang.String(oicq.wlogin_sdk.request.t.K) + " sim info " + new java.lang.String(oicq.wlogin_sdk.request.t.C) + " apn " + new java.lang.String(oicq.wlogin_sdk.request.t.F), "");
                oicq.wlogin_sdk.tools.util.int8_to_buf(bArr5, 0, oicq.wlogin_sdk.request.t.Z);
                int iFill_staff = fill_staff(bArr5, oicq.wlogin_sdk.request.t.J, fill_staff(bArr5, oicq.wlogin_sdk.request.t.K, 1));
                oicq.wlogin_sdk.tools.util.int16_to_buf(bArr5, iFill_staff, oicq.wlogin_sdk.request.t.D);
                fill_staff(bArr5, oicq.wlogin_sdk.request.t.F, fill_staff(bArr5, new byte[0], fill_staff(bArr5, oicq.wlogin_sdk.request.t.C, iFill_staff + 2)));
                appInfo = bArr5;
                length = length5;
            } else if (i4 == 51) {
                byte[] bArr6 = (byte[]) oicq.wlogin_sdk.request.t.A.clone();
                iArr = iArr;
                appInfo = bArr6;
                arrayList2 = arrayList2;
                length = bArr6.length;
            } else if (i4 != 53) {
                iArr = iArr;
                arrayList2 = arrayList2;
                appInfo = null;
                length = 0;
            } else {
                byte[] bArr7 = new byte[4];
                oicq.wlogin_sdk.tools.util.int32_to_buf(bArr7, 0, oicq.wlogin_sdk.request.t.au);
                length = 4;
                appInfo = bArr7;
            }
            if (appInfo != null) {
                tlv_tVar.fill_body(appInfo, length);
                tlv_tVar.set_length();
                byte[] bArr8 = tlv_tVar.get_buf();
                length3 += bArr8.length;
                arrayList = arrayList2;
                arrayList.add(bArr8);
            } else {
                arrayList = arrayList2;
            }
            i2++;
            arrayList2 = arrayList;
            iArr = iArr;
            i = 17;
        }
        java.util.ArrayList arrayList3 = arrayList2;
        byte[] bArr9 = new byte[length3];
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr9, 2, j2);
        oicq.wlogin_sdk.tools.util.int64_to_buf(bArr9, 6, j);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr9, 14, 8);
        int iFill_staff2 = fill_staff(bArr9, bArr, 15);
        int size = arrayList3.size();
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr9, iFill_staff2, size);
        int length6 = iFill_staff2 + 2;
        for (int i5 = 0; i5 < size; i5++) {
            byte[] bArr10 = (byte[]) arrayList3.get(i5);
            java.lang.System.arraycopy(bArr10, 0, bArr9, length6, bArr10.length);
            length6 += bArr10.length;
        }
        return get_request(j, true, bArr9);
    }

    public int get_response(byte[] bArr) {
        byte[] bArr2 = get_response(bArr, 0);
        if (bArr2 == null || bArr2.length < 11) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        oicq.wlogin_sdk.code2d.b._status.h = oicq.wlogin_sdk.tools.util.buf_to_int32(bArr2, 2);
        oicq.wlogin_sdk.code2d.b._status.b = oicq.wlogin_sdk.tools.util.buf_to_int8(bArr2, 6);
        if (oicq.wlogin_sdk.code2d.b._status.b != 0) {
            int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, 7);
            byte[] bArr3 = new byte[iBuf_to_int16];
            oicq.wlogin_sdk.code2d.b._status.f = bArr3;
            java.lang.System.arraycopy(bArr2, 9, bArr3, 0, iBuf_to_int16);
        } else {
            int iBuf_to_int17 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, 7);
            byte[] bArr4 = new byte[iBuf_to_int17];
            oicq.wlogin_sdk.code2d.c.i = bArr4;
            java.lang.System.arraycopy(bArr2, 9, bArr4, 0, iBuf_to_int17);
            int i = iBuf_to_int17 + 9;
            int iBuf_to_int18 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, i);
            int i2 = i + 2;
            for (int i3 = 0; i3 < iBuf_to_int18; i3++) {
                int iBuf_to_int19 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, i2);
                int i4 = i2 + 2;
                int iBuf_to_int110 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, i4);
                i2 = i4 + 2;
                if (iBuf_to_int19 == 23) {
                    byte[] bArr5 = new byte[iBuf_to_int110];
                    oicq.wlogin_sdk.code2d.b._status.j = bArr5;
                    java.lang.System.arraycopy(bArr2, i2, bArr5, 0, iBuf_to_int110);
                    i2 += iBuf_to_int110;
                } else if (iBuf_to_int19 == 28) {
                    oicq.wlogin_sdk.code2d.b._status.k = oicq.wlogin_sdk.tools.util.buf_to_int32(bArr2, i2);
                    int i5 = i2 + 4;
                    oicq.wlogin_sdk.code2d.b._status.l = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, i5);
                    i2 = i5 + 2;
                }
            }
        }
        return oicq.wlogin_sdk.code2d.b._status.b;
    }
}
