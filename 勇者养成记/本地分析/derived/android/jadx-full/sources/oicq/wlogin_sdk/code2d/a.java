package oicq.wlogin_sdk.code2d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends oicq.wlogin_sdk.code2d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static byte[] f1657a;

    public a() {
        this._cmd = 20;
    }

    public int a(byte[] bArr, long j, android.content.Context context, java.util.Map map) throws java.lang.Throwable {
        int iBuf_to_int16;
        oicq.wlogin_sdk.request.WloginAllSigInfo wloginAllSigInfo;
        byte[] bArr2 = get_response(bArr, 0);
        if (bArr2 == null || bArr2.length < 11) {
            return oicq.wlogin_sdk.tools.util.E_PK_LEN;
        }
        oicq.wlogin_sdk.code2d.b._status.f1658a = oicq.wlogin_sdk.tools.util.buf_to_int64(bArr2, 2);
        oicq.wlogin_sdk.code2d.b._status.b = oicq.wlogin_sdk.tools.util.buf_to_int8(bArr2, 10) & 255;
        oicq.wlogin_sdk.code2d.c cVar = oicq.wlogin_sdk.code2d.b._status;
        if (cVar.b != 0) {
            int iBuf_to_int17 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, 11);
            byte[] bArr3 = new byte[iBuf_to_int17];
            oicq.wlogin_sdk.code2d.b._status.f = bArr3;
            java.lang.System.arraycopy(bArr2, 13, bArr3, 0, iBuf_to_int17);
        } else {
            cVar.c = ((long) oicq.wlogin_sdk.tools.util.buf_to_int32(bArr2, 11)) & 4294967295L;
            int iBuf_to_int18 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, 15);
            byte[] bArr4 = new byte[iBuf_to_int18];
            oicq.wlogin_sdk.code2d.b._status.d = bArr4;
            java.lang.System.arraycopy(bArr2, 17, bArr4, 0, iBuf_to_int18);
            int i = iBuf_to_int18 + 17;
            int i2 = i + 2;
            if (i2 + 2 + 1 < bArr2.length && (iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, i)) != 0) {
                byte[] bArrDecrypt = oicq.wlogin_sdk.tools.cryptor.decrypt(bArr2, i2, iBuf_to_int16, f1657a);
                if (bArrDecrypt == null || bArrDecrypt.length == 0) {
                    return oicq.wlogin_sdk.tools.util.E_A1_DECRYPT;
                }
                int i3 = i2 + iBuf_to_int16;
                int iBuf_to_int19 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArrDecrypt, 0);
                byte[] bArr5 = null;
                byte[] bArr6 = null;
                byte[] bArr7 = null;
                int i4 = 2;
                for (int i5 = 0; i5 < iBuf_to_int19; i5++) {
                    int iBuf_to_int110 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArrDecrypt, i4);
                    int i6 = i4 + 2;
                    int iBuf_to_int111 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArrDecrypt, i6);
                    int i7 = i6 + 2;
                    if (iBuf_to_int110 == 24) {
                        byte[] bArr8 = new byte[iBuf_to_int111];
                        java.lang.System.arraycopy(bArrDecrypt, i7, bArr8, 0, iBuf_to_int111);
                        bArr6 = bArr8;
                    } else if (iBuf_to_int110 == 25) {
                        byte[] bArr9 = new byte[iBuf_to_int111];
                        java.lang.System.arraycopy(bArrDecrypt, i7, bArr9, 0, iBuf_to_int111);
                        bArr5 = bArr9;
                    } else if (iBuf_to_int110 == 30) {
                        byte[] bArr10 = new byte[iBuf_to_int111];
                        java.lang.System.arraycopy(bArrDecrypt, i7, bArr10, 0, iBuf_to_int111);
                        bArr7 = bArr10;
                    }
                    i4 = i7 + iBuf_to_int111;
                }
                int iBuf_to_int112 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr2, i3);
                int i8 = i3 + 2;
                int iA = oicq.wlogin_sdk.tools.b.a(iBuf_to_int112, bArr2, i8, bArr2.length - i8, map);
                if (iA != 0) {
                    oicq.wlogin_sdk.tools.util.LOGI("parseTLV failed " + iA, "");
                    return oicq.wlogin_sdk.tools.util.E_PK_LEN;
                }
                if (oicq.wlogin_sdk.code2d.c.t) {
                    if (bArr5 == null || bArr6 == null || bArr7 == null) {
                        return oicq.wlogin_sdk.tools.util.E_PK_LEN;
                    }
                    java.util.TreeMap treeMapA = oicq.wlogin_sdk.request.d.a(context, "tk_file", 0L);
                    if (treeMapA == null || (wloginAllSigInfo = (oicq.wlogin_sdk.request.WloginAllSigInfo) treeMapA.get(java.lang.Long.valueOf(oicq.wlogin_sdk.code2d.b._status.f1658a))) == null) {
                        return oicq.wlogin_sdk.tools.util.E_NO_KEY;
                    }
                    byte[][] bArr11 = (byte[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) byte.class, 5, 0);
                    for (int i9 = 0; i9 < 5; i9++) {
                        bArr11[i9] = new byte[0];
                    }
                    bArr11[0] = oicq.wlogin_sdk.request.oicq_request.b(bArr6, bArr7);
                    bArr11[1] = bArr5;
                    wloginAllSigInfo.put_siginfo(j, bArr11, oicq.wlogin_sdk.request.t.f());
                    treeMapA.put(java.lang.Long.valueOf(oicq.wlogin_sdk.code2d.b._status.f1658a), wloginAllSigInfo.get_clone());
                    oicq.wlogin_sdk.request.t.al.a(treeMapA, "tk_file");
                }
            }
        }
        return oicq.wlogin_sdk.code2d.b._status.b;
    }

    public byte[] a(long j, long j2, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, java.util.List list, byte[] bArr4, byte[] bArr5, long j4, long j5) {
        byte[] bArr6;
        byte[] appInfo;
        java.util.List arrayList = list == null ? new java.util.ArrayList() : list;
        int[] iArr = {22, 24, 25, 29, 104};
        int i2 = 0;
        int[] iArr2 = new int[0];
        if (!oicq.wlogin_sdk.code2d.c.t || bArr4.length <= 16) {
            iArr = iArr2;
            bArr6 = null;
        } else {
            int length = bArr4.length - 16;
            bArr6 = new byte[length];
            byte[] bArr7 = new byte[16];
            java.lang.System.arraycopy(bArr4, 0, bArr6, 0, length);
            java.lang.System.arraycopy(bArr4, length, bArr7, 0, 16);
            f1657a = bArr7;
        }
        oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar = new oicq.wlogin_sdk.tlv_type.tlv_t();
        tlv_tVar.fill_head(104);
        byte[] bArr8 = oicq.wlogin_sdk.request.t.A;
        tlv_tVar.fill_body(bArr8, bArr8.length);
        tlv_tVar.set_length();
        arrayList.add(tlv_tVar.get_buf());
        int i3 = 0;
        while (i3 < iArr.length) {
            oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar2 = new oicq.wlogin_sdk.tlv_type.tlv_t();
            tlv_tVar2.fill_head(iArr[i3]);
            int i4 = iArr[i3];
            if (i4 == 22) {
                iArr = iArr;
                tlv_tVar2 = tlv_tVar2;
                appInfo = getAppInfo(j2, j3);
            } else if (i4 == 29) {
                byte[] bArr9 = new byte[10];
                oicq.wlogin_sdk.tools.util.int8_to_buf(bArr9, i2, i2);
                oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr9, 1, j4);
                oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr9, 5, j5);
                oicq.wlogin_sdk.tools.util.int8_to_buf(bArr9, 9, 0);
                appInfo = bArr9;
            } else if (i4 == 24) {
                appInfo = bArr6;
            } else if (i4 != 25) {
                appInfo = null;
            } else {
                iArr = iArr;
                tlv_tVar2 = tlv_tVar2;
                appInfo = bArr5;
            }
            if (appInfo != null) {
                oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar3 = tlv_tVar2;
                tlv_tVar3.fill_body(appInfo, appInfo.length);
                tlv_tVar3.set_length();
                arrayList.add(tlv_tVar3.get_buf());
            }
            i3++;
            iArr = iArr;
            i2 = 0;
        }
        int size = arrayList.size();
        int length2 = bArr.length + 16 + 2 + bArr2.length + 1 + 2;
        for (int i5 = 0; i5 < size; i5++) {
            if (arrayList.get(i5) != null) {
                length2 += ((byte[]) arrayList.get(i5)).length;
            }
        }
        byte[] bArr10 = new byte[length2];
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr10, 2, j2);
        oicq.wlogin_sdk.tools.util.int64_to_buf(bArr10, 6, j);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr10, 14, bArr.length);
        java.lang.System.arraycopy(bArr, 0, bArr10, 16, bArr.length);
        int length3 = bArr.length + 16;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr10, length3, bArr2.length);
        int i6 = length3 + 2;
        java.lang.System.arraycopy(bArr2, 0, bArr10, i6, bArr2.length);
        int length4 = i6 + bArr2.length;
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr10, length4, 3);
        int i7 = length4 + 1;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr10, i7, size);
        int length5 = i7 + 2;
        for (int i8 = 0; i8 < size; i8++) {
            byte[] bArr11 = (byte[]) arrayList.get(i8);
            if (bArr11 != null) {
                java.lang.System.arraycopy(bArr11, 0, bArr10, length5, bArr11.length);
                length5 += bArr11.length;
            }
        }
        return get_request(j, true, bArr10);
    }
}
