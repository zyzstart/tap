package com.tencent.qqdownloader.pay.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static char[] f768a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static java.lang.String a(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            return "";
        }
        char[] cArr = new char[32];
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = bArr[i2];
            int i3 = i + 1;
            char[] cArr2 = f768a;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = cArr2[b & 15];
        }
        return new java.lang.String(cArr);
    }

    public static byte[] a(java.lang.String str) {
        try {
            return java.security.MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String b(java.lang.String str) {
        byte[] bArrA = a(str);
        return bArrA == null ? "" : a(bArrA);
    }
}
