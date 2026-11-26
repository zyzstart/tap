package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class j {
    private static java.lang.String a(java.lang.String str) {
        try {
            return com.qq.gdt.action.h.r.c(com.qq.gdt.action.h.p.b(android.util.Base64.decode(str, 2)));
        } catch (java.lang.Throwable th) {
            com.qq.gdt.action.h.l.b("rsa decrypt exception", th);
            return null;
        }
    }

    public static boolean a(java.lang.String str, java.lang.String str2) {
        if (com.qq.gdt.action.h.t.a(str) || com.qq.gdt.action.h.t.a(str2)) {
            return false;
        }
        java.lang.String strA = a(str);
        boolean zEquals = str2.equals(strA);
        com.qq.gdt.action.h.l.a("VerifySign result: " + zEquals + ", expect = " + str2 + ", decrypted = " + strA, new java.lang.Object[0]);
        return zEquals;
    }

    public static byte[] a(byte[] bArr) {
        try {
            return com.qq.gdt.action.h.p.a(bArr);
        } catch (java.lang.Throwable th) {
            com.qq.gdt.action.h.l.b("Exception while encrypt plainBytes", th);
            return null;
        }
    }
}
