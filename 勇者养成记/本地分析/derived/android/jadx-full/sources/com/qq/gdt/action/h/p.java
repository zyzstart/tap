package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class p {
    public static java.lang.String a(java.lang.String str) {
        byte[] bArrA = new byte[0];
        try {
            bArrA = a(str.getBytes(), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIxHA9yAi16YbRRJqi+UB5jhbb\ns3MlTsGxv0eFf3LSzPbIcbc0lIDzRIZQstKo/4oN/drDg5JWqShCmxERA+KM0D4h\npD6CFRNtN1DVvpw+H4tNkF5yB1TwAUlbNNhSuc7hi4YpttiZlSqEnl8UlX+9OWOi\n0L7IU9mCkDdQY4ErLwIDAQAB");
        } catch (java.lang.Exception e) {
            com.qq.gdt.action.h.l.a("Rsa encrypt encounter error: " + e.getMessage(), new java.lang.Object[0]);
        }
        return com.qq.gdt.action.h.h.a(bArrA);
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        try {
            return a(bArr, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIxHA9yAi16YbRRJqi+UB5jhbb\ns3MlTsGxv0eFf3LSzPbIcbc0lIDzRIZQstKo/4oN/drDg5JWqShCmxERA+KM0D4h\npD6CFRNtN1DVvpw+H4tNkF5yB1TwAUlbNNhSuc7hi4YpttiZlSqEnl8UlX+9OWOi\n0L7IU9mCkDdQY4ErLwIDAQAB");
        } catch (java.lang.Exception e) {
            com.qq.gdt.action.h.l.a("Rsa encrypt encounter error: " + e.getMessage(), new java.lang.Object[0]);
            return bArr2;
        }
    }

    private static byte[] a(byte[] bArr, java.lang.String str) throws javax.crypto.BadPaddingException, java.security.spec.InvalidKeySpecException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.io.IOException {
        java.security.PublicKey publicKeyGeneratePublic = java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(com.qq.gdt.action.h.h.b(str)));
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKeyGeneratePublic);
        int length = bArr.length;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i;
            if (i3 <= 0) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byte[] bArrDoFinal = i3 > 245 ? cipher.doFinal(bArr, i, 245) : cipher.doFinal(bArr, i, i3);
            byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
            i2++;
            i = i2 * 245;
        }
    }

    public static byte[] b(byte[] bArr) throws javax.crypto.BadPaddingException, java.security.spec.InvalidKeySpecException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        if (bArr.length > 128) {
            com.qq.gdt.action.h.l.c("");
            return null;
        }
        java.security.PublicKey publicKeyGeneratePublic = java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(com.qq.gdt.action.h.h.b("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIxHA9yAi16YbRRJqi+UB5jhbb\ns3MlTsGxv0eFf3LSzPbIcbc0lIDzRIZQstKo/4oN/drDg5JWqShCmxERA+KM0D4h\npD6CFRNtN1DVvpw+H4tNkF5yB1TwAUlbNNhSuc7hi4YpttiZlSqEnl8UlX+9OWOi\n0L7IU9mCkDdQY4ErLwIDAQAB")));
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, publicKeyGeneratePublic);
        return cipher.doFinal(bArr);
    }
}
