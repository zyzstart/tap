package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class u extends oicq.wlogin_sdk.request.k {
    public final int b = 1737040709;
    public final int c = 33;
    public final java.lang.String d = "x'Z8mSi,V(Wu~.v:";

    public u(oicq.wlogin_sdk.request.t tVar) {
        this.f1685a = tVar;
    }

    public int a(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, int i) {
        if (i == 0) {
            return b(j, bArr, bArr2, bArr3, j2);
        }
        if (i == 1) {
            return c(j, bArr, bArr2, bArr3, j2);
        }
        return 0;
    }

    public byte[] a(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2) {
        if (bArr2 == null || bArr2.length == 0) {
            byte[] bArrEncrypt = oicq.wlogin_sdk.tools.cryptor.encrypt(bArr, 0, bArr.length, "x'Z8mSi,V(Wu~.v:".getBytes());
            byte[] bArr4 = new byte[bArrEncrypt.length + 10];
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr4, 0, (int) j);
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr4, 4, (int) j2);
            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr4, 8, 0);
            java.lang.System.arraycopy(bArrEncrypt, 0, bArr4, 10, bArrEncrypt.length);
            int length = bArrEncrypt.length;
            return bArr4;
        }
        byte[] bArrEncrypt2 = oicq.wlogin_sdk.tools.cryptor.encrypt(bArr, 0, bArr.length, bArr3);
        byte[] bArr5 = new byte[bArr2.length + 10 + bArrEncrypt2.length];
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr5, 0, (int) j);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr5, 4, (int) j2);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr5, 8, bArr2.length);
        java.lang.System.arraycopy(bArr2, 0, bArr5, 10, bArr2.length);
        java.lang.System.arraycopy(bArrEncrypt2, 0, bArr5, bArr2.length + 10, bArrEncrypt2.length);
        int length2 = bArrEncrypt2.length;
        return bArr5;
    }

    public byte[] a(byte[] bArr, long j, long j2, long j3, int i) {
        int length = bArr.length + 33;
        byte[] bArr2 = new byte[length];
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr2, 0, 1737040709);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr2, 4, 0);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr2, 8, length);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr2, 12, j);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr2, 16, j2);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr2, 20, j3 / 1000);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr2, 24, i);
        java.lang.System.arraycopy(bArr, 0, bArr2, 33, bArr.length);
        int length2 = bArr.length;
        return bArr2;
    }

    public int b(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2) {
        byte[] bytes;
        byte[] bArrCompress;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        oicq.wlogin_sdk.request.t.an.commit(android.os.Build.VERSION.RELEASE, new java.lang.String(oicq.wlogin_sdk.request.t.G), "", oicq.wlogin_sdk.tools.util.buf_to_string(oicq.wlogin_sdk.tools.util.get_ksid(oicq.wlogin_sdk.request.t.t)), new java.lang.String(oicq.wlogin_sdk.request.t.E), new java.lang.String(oicq.wlogin_sdk.request.t.Q), new java.lang.String(oicq.wlogin_sdk.request.t.I), new java.lang.String(oicq.wlogin_sdk.request.t.H), oicq.wlogin_sdk.tools.util.get_release_time(), oicq.wlogin_sdk.tools.util.SDK_VERSION);
        int iB = 0;
        try {
            bytes = oicq.wlogin_sdk.request.t.an.toJasonObj().toString().getBytes();
        } catch (java.lang.Throwable unused) {
            bytes = new byte[0];
        }
        if (bytes != null && bytes.length != 0 && (bArrCompress = oicq.wlogin_sdk.tools.util.compress(bytes)) != null && bArrCompress.length != 0) {
            byte[] bArr4 = new byte[bArrCompress.length + 4];
            oicq.wlogin_sdk.tools.util.int8_to_buf(bArr4, 0, 0);
            oicq.wlogin_sdk.tools.util.int8_to_buf(bArr4, 1, 1);
            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr4, 2, bArrCompress.length);
            java.lang.System.arraycopy(bArrCompress, 0, bArr4, 4, bArrCompress.length);
            byte[] bArrA = a(bArr4, j, j2, jCurrentTimeMillis, 0);
            oicq.wlogin_sdk.report.report_t.delete_file(oicq.wlogin_sdk.request.t.t);
            iB = b(a(a(j, bArrA, bArr2, bArr3, j2)));
            oicq.wlogin_sdk.tools.util.LOGI("request_report_error(0) rsp: ret=" + iB);
            if (iB != 0) {
                oicq.wlogin_sdk.report.report_t.write_tofile(oicq.wlogin_sdk.request.t.an, oicq.wlogin_sdk.request.t.t);
            } else {
                oicq.wlogin_sdk.request.t.an.clear_t2();
            }
        }
        return iB;
    }

    public int c(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2) {
        int i = 0;
        if (this.f1685a.d != null && !oicq.wlogin_sdk.request.t.e.booleanValue()) {
            oicq.wlogin_sdk.request.t.e = java.lang.Boolean.TRUE;
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyyMMdd");
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            int i2 = this.f1685a.d.get_bitmap();
            byte b = this.f1685a.d.get_network();
            oicq.wlogin_sdk.tools.util.LOGI("bitmap:" + i2 + " network:" + ((int) b) + " local network:" + oicq.wlogin_sdk.tools.util.get_network_type(oicq.wlogin_sdk.request.t.t));
            int i3 = 0;
            while (i3 < 32) {
                if (((1 << i3) & i2) != 0 && (b == 0 || (b == 1 && oicq.wlogin_sdk.tools.util.get_network_type(oicq.wlogin_sdk.request.t.t) == 2))) {
                    long j3 = jCurrentTimeMillis - ((long) (86400000 * i3));
                    calendar.setTimeInMillis(j3);
                    java.lang.String str = simpleDateFormat.format(calendar.getTime());
                    long logModifyTime = oicq.wlogin_sdk.tools.util.getLogModifyTime(oicq.wlogin_sdk.request.t.t, str);
                    long j4 = logModifyTime == 0 ? j3 : logModifyTime;
                    byte[] log = oicq.wlogin_sdk.tools.util.readLog(oicq.wlogin_sdk.request.t.t, str);
                    byte[] bArrA = log == null ? new byte[i] : a(log, j, j2, j4, 1);
                    if (bArrA != null && bArrA.length > 0) {
                        oicq.wlogin_sdk.tools.util.LOGI("request_report_error(1) rsp: ret=" + b(a(a(j, bArrA, bArr2, bArr3, j2))) + "(" + str + ")");
                    }
                } else {
                    i3 = i3;
                    b = b;
                }
                i3++;
                b = b;
                i = 0;
            }
        }
        this.f1685a.d = null;
        oicq.wlogin_sdk.request.t.e = java.lang.Boolean.FALSE;
        return 0;
    }
}
