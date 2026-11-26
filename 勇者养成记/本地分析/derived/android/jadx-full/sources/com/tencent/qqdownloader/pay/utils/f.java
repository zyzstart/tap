package com.tencent.qqdownloader.pay.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {
    public static byte[] a(java.lang.String str, java.lang.String str2) {
        try {
            java.security.PublicKey publicKeyGeneratePublic = java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(com.tencent.qqdownloader.pay.utils.a.a(str2)));
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKeyGeneratePublic);
            return cipher.doFinal(str.getBytes("UTF-8"));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
