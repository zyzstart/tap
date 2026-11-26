package com.tencent.msdk.dns.base.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {
    @android.annotation.SuppressLint({"TrulyRandom"})
    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(str2.getBytes(com.unisound.b.f.b), "[REDACTED]");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(1, secretKeySpec);
            return com.tencent.msdk.dns.base.c.c.a(cipher.doFinal(str.getBytes(com.unisound.b.f.b)));
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(str2.getBytes(com.unisound.b.f.b), "[REDACTED]");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(2, secretKeySpec);
            byte[] bArrDoFinal = cipher.doFinal(com.tencent.msdk.dns.base.c.c.d(str));
            return bArrDoFinal == null ? "" : new java.lang.String(bArrDoFinal, java.nio.charset.Charset.forName("UTF-8"));
        } catch (java.lang.Exception unused) {
            return "";
        }
    }
}
