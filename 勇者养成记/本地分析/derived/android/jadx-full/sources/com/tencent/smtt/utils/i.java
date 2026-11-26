package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f978a = "0123456789abcdef".toCharArray();
    private static com.tencent.smtt.utils.i b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;

    private i() {
        int iNextInt = new java.util.Random().nextInt(89999999) + 10000000;
        int iNextInt2 = new java.util.Random().nextInt(89999999) + 10000000;
        this.e = java.lang.String.valueOf(iNextInt);
        this.c = this.e + java.lang.String.valueOf(iNextInt2);
    }

    public static synchronized com.tencent.smtt.utils.i a() {
        if (b == null) {
            b = new com.tencent.smtt.utils.i();
        }
        return b;
    }

    private java.lang.String b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f978a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new java.lang.String(cArr);
    }

    public byte[] a(byte[] bArr) {
        return com.tencent.smtt.sdk.a.a.a(this.e.getBytes(), bArr, 1);
    }

    public void b() {
        java.security.Security.addProvider((java.security.Provider) java.lang.Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, java.lang.ClassLoader.getSystemClassLoader()).newInstance());
    }

    public java.lang.String c() throws java.security.InvalidKeyException {
        if (this.d == null) {
            byte[] bytes = this.c.getBytes();
            javax.crypto.Cipher cipher = null;
            try {
                try {
                    cipher = javax.crypto.Cipher.getInstance("RSA/ECB/NoPadding");
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            } catch (java.lang.Exception unused) {
                b();
                cipher = javax.crypto.Cipher.getInstance("RSA/ECB/NoPadding");
            }
            cipher.init(1, java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
            this.d = b(cipher.doFinal(bytes));
        }
        return this.d;
    }
}
