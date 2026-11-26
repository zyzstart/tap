package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ai implements com.tencent.bugly.proguard.aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f421a = null;

    @Override // com.tencent.bugly.proguard.aj
    public final void a(java.lang.String str) {
        if (str != null) {
            this.f421a = str;
        }
    }

    @Override // com.tencent.bugly.proguard.aj
    public final byte[] a(byte[] bArr) throws java.lang.Exception {
        if (this.f421a == null || bArr == null) {
            return null;
        }
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(2, javax.crypto.SecretKeyFactory.getInstance("[REDACTED]").generateSecret(new javax.crypto.spec.DESKeySpec(this.f421a.getBytes("[REDACTED]"))), new javax.crypto.spec.IvParameterSpec(this.f421a.getBytes("[REDACTED]")));
        return cipher.doFinal(bArr);
    }

    @Override // com.tencent.bugly.proguard.aj
    public final byte[] b(byte[] bArr) throws java.lang.Exception {
        if (this.f421a == null || bArr == null) {
            return null;
        }
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(1, javax.crypto.SecretKeyFactory.getInstance("[REDACTED]").generateSecret(new javax.crypto.spec.DESKeySpec(this.f421a.getBytes("[REDACTED]"))), new javax.crypto.spec.IvParameterSpec(this.f421a.getBytes("[REDACTED]")));
        return cipher.doFinal(bArr);
    }
}
