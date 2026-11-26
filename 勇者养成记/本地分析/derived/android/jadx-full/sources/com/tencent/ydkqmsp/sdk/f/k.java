package com.tencent.ydkqmsp.sdk.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f1349a;

    static {
        new java.util.HashMap();
        f1349a = new byte[]{6, 120, -74, 67, 37, 123, 99, -11, 32, 48, -93, 65, 60, 58, 122, -8, 49, 117, -95, 83, 111};
    }

    public static java.lang.String a(byte[] bArr) {
        byte[] bArr2 = {69, 16, -45, 32, 78, 91, 23, -99, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i % 8]);
        }
        return new java.lang.String(bArr3);
    }
}
