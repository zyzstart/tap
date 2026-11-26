package com.tencent.ydkqmsp.sdk.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f1346a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static java.lang.String a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            for (int i = 0; i < bArr.length; i++) {
                try {
                    byte b = bArr[i];
                    int i2 = i * 2;
                    cArr[i2 + 1] = f1346a[b & 15];
                    cArr[i2 + 0] = f1346a[((byte) (b >>> 4)) & 15];
                } catch (java.lang.Exception e) {
                    com.tencent.ydkqmsp.sdk.f.g.a("Qp.b2h", 1, " === bytes2HexStr error === " + e.toString());
                }
            }
            return new java.lang.String(cArr);
        }
        return null;
    }
}
