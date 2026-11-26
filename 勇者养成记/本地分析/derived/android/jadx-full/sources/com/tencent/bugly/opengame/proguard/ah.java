package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ah implements com.tencent.bugly.opengame.proguard.aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f378a = null;

    @Override // com.tencent.bugly.opengame.proguard.aj
    public final void a(java.lang.String str) {
        if (str != null) {
            for (int length = str.length(); length < 16; length++) {
                str = str + "0";
            }
            this.f378a = str.substring(0, 16);
        }
    }

    @Override // com.tencent.bugly.opengame.proguard.aj
    public final byte[] a(byte[] bArr) throws javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        if (this.f378a == null || bArr == null) {
            return null;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(((int) b) + " ");
        }
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(this.f378a.getBytes(), "[REDACTED]");
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(com.tencent.ysdk.shell.libware.encrypt.AESHelper.DEFAULT_ALGORITHM);
        cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(this.f378a.getBytes()));
        byte[] bArrDoFinal = cipher.doFinal(bArr);
        java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
        for (byte b2 : bArrDoFinal) {
            stringBuffer2.append(((int) b2) + " ");
        }
        return bArrDoFinal;
    }

    @Override // com.tencent.bugly.opengame.proguard.aj
    public final byte[] b(byte[] bArr) throws javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        if (this.f378a == null || bArr == null) {
            return null;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(((int) b) + " ");
        }
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(this.f378a.getBytes(), "[REDACTED]");
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(com.tencent.ysdk.shell.libware.encrypt.AESHelper.DEFAULT_ALGORITHM);
        cipher.init(1, secretKeySpec, new javax.crypto.spec.IvParameterSpec(this.f378a.getBytes()));
        byte[] bArrDoFinal = cipher.doFinal(bArr);
        java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
        for (byte b2 : bArrDoFinal) {
            stringBuffer2.append(((int) b2) + " ");
        }
        return bArrDoFinal;
    }
}
