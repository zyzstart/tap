package com.tencent.open.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.security.KeyStore f717a;
    private android.content.SharedPreferences b;

    public a(android.content.Context context) {
        try {
            this.b = context.getSharedPreferences("KEYSTORE_SETTING", 0);
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance("AndroidKeyStore");
            this.f717a = keyStore;
            keyStore.load(null);
            if (this.f717a.containsAlias("KEYSTORE_AES")) {
                return;
            }
            c("");
            a(context);
            a();
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.d("KEYSTORE", "Exception", e);
        }
    }

    private void a() throws javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        byte[] bArrDigest;
        byte[] bArr = new byte[16];
        java.security.SecureRandom secureRandom = new java.security.SecureRandom();
        secureRandom.nextBytes(bArr);
        c(android.util.Base64.encodeToString(secureRandom.generateSeed(12), 0));
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            java.security.PublicKey publicKey = this.f717a.getCertificate("KEYSTORE_AES").getPublicKey();
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKey);
            bArrDigest = cipher.doFinal(bArr);
        } else {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            bArrDigest = messageDigest.digest();
        }
        d(android.util.Base64.encodeToString(bArrDigest, 0));
    }

    private void a(android.content.Context context) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException, java.security.InvalidAlgorithmParameterException {
        com.tencent.open.log.SLog.d("KEYSTORE", "Build.VERSION.SDK_INT=" + android.os.Build.VERSION.SDK_INT);
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 23) {
            java.security.KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            keyPairGenerator.initialize(new android.security.keystore.KeyGenParameterSpec.Builder("KEYSTORE_AES", 3).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("PKCS1Padding").build());
            keyPairGenerator.generateKeyPair();
        } else if (i >= 18) {
            java.security.KeyPairGenerator keyPairGenerator2 = java.security.KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            java.util.Calendar calendar2 = java.util.Calendar.getInstance();
            calendar2.add(1, 30);
            keyPairGenerator2.initialize(new android.security.KeyPairGeneratorSpec.Builder(context).setAlias("KEYSTORE_AES").setSubject(new javax.security.auth.x500.X500Principal("CN=KEYSTORE_AES")).setSerialNumber(java.math.BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build());
            keyPairGenerator2.generateKeyPair();
        }
    }

    private byte[] b() {
        return android.util.Base64.decode(this.b.getString("PREF_KEY_IV", ""), 0);
    }

    private javax.crypto.spec.SecretKeySpec c() throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        java.lang.String string = this.b.getString("PREF_KEY_AES", "");
        if (android.os.Build.VERSION.SDK_INT < 18) {
            return new javax.crypto.spec.SecretKeySpec(android.util.Base64.decode(string, 0), "[REDACTED]");
        }
        java.security.PrivateKey privateKey = (java.security.PrivateKey) this.f717a.getKey("[REDACTED]", null);
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, privateKey);
        return new javax.crypto.spec.SecretKeySpec(cipher.doFinal(android.util.Base64.decode(string, 0)), "[REDACTED]");
    }

    private void c(java.lang.String str) {
        this.b.edit().putString("PREF_KEY_IV", str).apply();
    }

    private void d(java.lang.String str) {
        this.b.edit().putString("PREF_KEY_AES", str).apply();
    }

    public java.lang.String a(java.lang.String str) {
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, c(), new javax.crypto.spec.IvParameterSpec(b()));
            return android.util.Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("KEYSTORE", "Exception", e);
            return "";
        }
    }

    public java.lang.String b(java.lang.String str) {
        try {
            byte[] bArrDecode = android.util.Base64.decode(str.getBytes(), 0);
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, c(), new javax.crypto.spec.IvParameterSpec(b()));
            return new java.lang.String(cipher.doFinal(bArrDecode));
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("KEYSTORE", "Exception", e);
            return "";
        }
    }
}
