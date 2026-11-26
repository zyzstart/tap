package com.tencent.beacon.core.c.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {
    public static byte[] a(int i, java.lang.String str, byte[] bArr) {
        if (i == 1) {
            return c(str, bArr);
        }
        if (i == 3) {
            return a(str, bArr);
        }
        return null;
    }

    public static byte[] a(android.content.Context context, java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            java.security.interfaces.RSAPublicKey rSAPublicKey = (java.security.interfaces.RSAPublicKey) (context.getApplicationInfo().targetSdkVersion >= 28 ? java.security.KeyFactory.getInstance("RSA") : java.security.KeyFactory.getInstance("RSA", "BC")).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsAxNCSLyNUCOP1QqYStE8ZeiU\nv4afaMqEmoLCKb0mUZYvYOoVN7LPMi2IVY2MRaFJvuND3glVw1RDm2VJJtjQkwUd\n3kpR9TrHAf7UQOVTpNo3Vi7pXTOqZ6bh3ZA/fs56jDCCKV6+wT/pCeu8N6vVnPrD\nz3SdHIeNeWb/woazCwIDAQAB", 0)));
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, rSAPublicKey);
            return cipher.doFinal(str.getBytes(java.nio.charset.Charset.forName("UTF-8")));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] a(java.lang.String str, byte[] bArr) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        if (str == null || bArr == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str);
        for (int length = sb.length(); length < 16; length++) {
            sb.append("0");
        }
        java.lang.String strSubstring = sb.toString().substring(0, 16);
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(strSubstring.getBytes(java.nio.charset.Charset.forName("[REDACTED]")), "[REDACTED]");
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(com.tencent.ysdk.shell.libware.encrypt.AESHelper.DEFAULT_ALGORITHM);
        cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(strSubstring.getBytes(java.nio.charset.Charset.forName("[REDACTED]"))));
        return cipher.doFinal(bArr);
    }

    public static byte[] b(int i, java.lang.String str, byte[] bArr) {
        if (i == 1) {
            return d(str, bArr);
        }
        if (i == 3) {
            return b(str, bArr);
        }
        return null;
    }

    private static byte[] b(java.lang.String str, byte[] bArr) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        if (str == null || bArr == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str);
        for (int length = sb.length(); length < 16; length++) {
            sb.append("0");
        }
        java.lang.String strSubstring = sb.toString().substring(0, 16);
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(strSubstring.getBytes(java.nio.charset.Charset.forName("[REDACTED]")), "[REDACTED]");
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(com.tencent.ysdk.shell.libware.encrypt.AESHelper.DEFAULT_ALGORITHM);
        cipher.init(1, secretKeySpec, new javax.crypto.spec.IvParameterSpec(strSubstring.getBytes(java.nio.charset.Charset.forName("[REDACTED]"))));
        return cipher.doFinal(bArr);
    }

    private static byte[] c(java.lang.String str, byte[] bArr) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        if (str == null || bArr == null) {
            return null;
        }
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(2, javax.crypto.SecretKeyFactory.getInstance("[REDACTED]").generateSecret(new javax.crypto.spec.DESKeySpec(str.getBytes("[REDACTED]"))), new javax.crypto.spec.IvParameterSpec(str.getBytes("[REDACTED]")));
        return cipher.doFinal(bArr);
    }

    private static byte[] d(java.lang.String str, byte[] bArr) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        if (str == null || bArr == null) {
            return null;
        }
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(1, javax.crypto.SecretKeyFactory.getInstance("[REDACTED]").generateSecret(new javax.crypto.spec.DESKeySpec(str.getBytes("[REDACTED]"))), new javax.crypto.spec.IvParameterSpec(str.getBytes("[REDACTED]")));
        return cipher.doFinal(bArr);
    }
}
