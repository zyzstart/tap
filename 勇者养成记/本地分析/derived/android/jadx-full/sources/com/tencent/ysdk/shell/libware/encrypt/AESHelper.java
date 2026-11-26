package com.tencent.ysdk.shell.libware.encrypt;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AESHelper {
    public static final java.lang.String DEFAULT_ALGORITHM = "AES/CBC/PKCS5Padding";

    private AESHelper() {
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws java.lang.Exception {
        return decrypt(bArr, bArr2, bArr3, DEFAULT_ALGORITHM);
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, java.lang.String str) throws java.lang.Exception {
        javax.crypto.Cipher.getMaxAllowedKeyLength(str);
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "[REDACTED]");
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(str);
        cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(bArr2));
        return cipher.doFinal(bArr3);
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws java.lang.Exception {
        return encrypt(bArr, bArr2, bArr3, DEFAULT_ALGORITHM);
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, java.lang.String str) throws java.lang.Exception {
        javax.crypto.Cipher.getMaxAllowedKeyLength(str);
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "[REDACTED]");
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(str);
        cipher.init(1, secretKeySpec, new javax.crypto.spec.IvParameterSpec(bArr2));
        return cipher.doFinal(bArr3);
    }
}
