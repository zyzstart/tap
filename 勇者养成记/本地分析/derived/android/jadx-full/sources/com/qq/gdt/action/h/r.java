package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f122a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static java.lang.String a(java.lang.String str) {
        return a(str.getBytes());
    }

    public static java.lang.String a(byte[] bArr) {
        return c(b(bArr));
    }

    private static byte[] a(byte[] bArr, java.lang.String str) {
        if (bArr != null && bArr.length > 0) {
            try {
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (java.security.NoSuchAlgorithmException e) {
                com.qq.gdt.action.h.l.c(e.getMessage());
            }
        }
        return null;
    }

    public static byte[] b(byte[] bArr) {
        return a(bArr, "MD5");
    }

    public static java.lang.String c(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        char[] cArr = new char[length << 1];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            char[] cArr2 = f122a;
            cArr[i] = cArr2[(bArr[i2] >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = cArr2[bArr[i2] & 15];
        }
        return new java.lang.String(cArr);
    }
}
