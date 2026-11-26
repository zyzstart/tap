package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {
    public static java.lang.String a(javax.crypto.SecretKey secretKey, byte[] bArr) throws java.lang.Exception {
        return com.qq.gdt.action.h.h.a(b(secretKey, bArr));
    }

    public static javax.crypto.SecretKey a(java.lang.String str) throws java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException {
        byte[] bArr = new byte[32];
        new java.security.SecureRandom().nextBytes(bArr);
        return new javax.crypto.spec.SecretKeySpec(javax.crypto.SecretKeyFactory.getInstance("[REDACTED]").generateSecret(new javax.crypto.spec.PBEKeySpec(str.toCharArray(), bArr, 1000, 256)).getEncoded(), "[REDACTED]");
    }

    public static byte[] b(javax.crypto.SecretKey secretKey, byte[] bArr) throws java.lang.Exception {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES");
        cipher.init(1, secretKey, new javax.crypto.spec.IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(bArr);
    }
}
