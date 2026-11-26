package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h {
    private static java.lang.String b = "";
    private static byte[] c;
    private static java.lang.String g;
    private javax.crypto.Cipher d;
    private javax.crypto.Cipher e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final char[] f977a = "0123456789abcdef".toCharArray();
    private static com.tencent.smtt.utils.h f = null;

    private h() throws java.security.spec.InvalidKeySpecException, javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        this.d = null;
        this.e = null;
        g = java.lang.String.valueOf(new java.util.Random().nextInt(89999999) + 10000000) + java.lang.String.valueOf(new java.util.Random().nextInt(89999999) + 10000000) + java.lang.String.valueOf(new java.util.Random().nextInt(89999999) + 10000000);
        java.lang.String str = com.tencent.ysdk.module.user.UserLoginRet.DEFAULT_CHANNEL;
        for (int i = 0; i < 12; i++) {
            str = str + java.lang.String.valueOf(new java.util.Random().nextInt(89999999) + 10000000);
        }
        c = (str + g).getBytes();
        this.d = javax.crypto.Cipher.getInstance("RSA/ECB/NoPadding");
        this.d.init(1, java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode((d() + e()).getBytes(), 0))));
        b = b(this.d.doFinal(c));
        javax.crypto.SecretKey secretKeyGenerateSecret = javax.crypto.SecretKeyFactory.getInstance("[REDACTED]").generateSecret(new javax.crypto.spec.DESedeKeySpec(g.getBytes()));
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DESede/ECB/PKCS5Padding");
        this.e = cipher;
        cipher.init(1, secretKeyGenerateSecret);
    }

    public static com.tencent.smtt.utils.h a() {
        try {
            if (f == null) {
                f = new com.tencent.smtt.utils.h();
            }
            return f;
        } catch (java.lang.Exception e) {
            f = null;
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, java.lang.String str) throws java.security.spec.InvalidKeySpecException, javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        javax.crypto.SecretKey secretKeyGenerateSecret = javax.crypto.SecretKeyFactory.getInstance("[REDACTED]").generateSecret(new javax.crypto.spec.DESedeKeySpec(str.getBytes()));
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(1, secretKeyGenerateSecret);
        return cipher.doFinal(bArr);
    }

    public static java.lang.String b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f977a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new java.lang.String(cArr);
    }

    public static byte[] b(byte[] bArr, java.lang.String str) {
        try {
            javax.crypto.SecretKey secretKeyGenerateSecret = javax.crypto.SecretKeyFactory.getInstance("[REDACTED]").generateSecret(new javax.crypto.spec.DESedeKeySpec(str.getBytes()));
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(2, secretKeyGenerateSecret);
            return cipher.doFinal(bArr);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String c() {
        return g;
    }

    private java.lang.String d() {
        return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0";
    }

    private java.lang.String e() {
        return "fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB";
    }

    public byte[] a(byte[] bArr) {
        return this.e.doFinal(bArr);
    }

    public java.lang.String b() {
        return b;
    }

    public byte[] c(byte[] bArr) {
        try {
            javax.crypto.SecretKey secretKeyGenerateSecret = javax.crypto.SecretKeyFactory.getInstance("[REDACTED]").generateSecret(new javax.crypto.spec.DESedeKeySpec(g.getBytes()));
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(2, secretKeyGenerateSecret);
            return cipher.doFinal(bArr);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
