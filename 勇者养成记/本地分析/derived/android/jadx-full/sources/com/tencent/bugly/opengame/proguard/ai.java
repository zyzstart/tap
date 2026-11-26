package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ai implements com.tencent.bugly.opengame.proguard.aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f379a = null;

    @Override // com.tencent.bugly.opengame.proguard.aj
    public final void a(java.lang.String str) {
        if (str != null) {
            this.f379a = str;
        }
    }

    @Override // com.tencent.bugly.opengame.proguard.aj
    public final byte[] a(byte[] bArr) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        if (this.f379a == null || bArr == null) {
            return null;
        }
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(2, javax.crypto.SecretKeyFactory.getInstance("[REDACTED]").generateSecret(new javax.crypto.spec.DESKeySpec(this.f379a.getBytes("[REDACTED]"))), new javax.crypto.spec.IvParameterSpec(this.f379a.getBytes("[REDACTED]")));
        return cipher.doFinal(bArr);
    }

    @Override // com.tencent.bugly.opengame.proguard.aj
    public final byte[] b(byte[] bArr) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        if (this.f379a == null || bArr == null) {
            return null;
        }
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(1, javax.crypto.SecretKeyFactory.getInstance("[REDACTED]").generateSecret(new javax.crypto.spec.DESKeySpec(this.f379a.getBytes("[REDACTED]"))), new javax.crypto.spec.IvParameterSpec(this.f379a.getBytes("[REDACTED]")));
        return cipher.doFinal(bArr);
    }
}
