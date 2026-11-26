package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h {
    public static java.lang.String a(java.lang.String str) {
        return a(str, "UTF-8");
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            return java.net.URLEncoder.encode(str, str2);
        } catch (java.io.UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static java.lang.String a(byte[] bArr) {
        return android.util.Base64.encodeToString(bArr, 2);
    }

    public static byte[] b(java.lang.String str) {
        return android.util.Base64.decode(str, 2);
    }
}
