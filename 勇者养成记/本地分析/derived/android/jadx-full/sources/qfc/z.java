package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class z {
    public static java.lang.String a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length <= 245) {
            return new java.lang.String(a(bArr, bArr2, "RSA/ECB/PKCS1Padding"));
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        byte[] bArr3 = new byte[245];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            bArr3[i2] = bArr[i];
            i2++;
            if (i2 == 245 || i == length - 1) {
                i3++;
                if (i3 != 1) {
                    sb.append("#PART#");
                }
                sb.append(new java.lang.String(a(bArr3, bArr2, "RSA/ECB/PKCS1Padding")));
                bArr3 = i == length + (-1) ? null : new byte[java.lang.Math.min(245, (length - i) - 1)];
                i2 = 0;
            }
            i++;
        }
        return sb.toString();
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, java.lang.String str) {
        return android.util.Base64.encode(b(bArr, bArr2, str), 2);
    }

    private static byte[] b(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        java.lang.System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        java.lang.System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static byte[] b(byte[] bArr, byte[] bArr2, java.lang.String str) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            try {
                java.security.PublicKey publicKeyGeneratePublic = java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(bArr2));
                if (publicKeyGeneratePublic == null) {
                    return null;
                }
                javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(str);
                cipher.init(1, publicKeyGeneratePublic);
                int length = bArr.length;
                int i = length / 117;
                if (i <= 0) {
                    return cipher.doFinal(bArr);
                }
                byte[] bArr3 = new byte[117];
                byte[] bArrB = new byte[0];
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    java.lang.System.arraycopy(bArr, i2, bArr3, 0, 117);
                    bArrB = b(bArrB, cipher.doFinal(bArr3));
                    i2 += 117;
                }
                if (i2 == length) {
                    return bArrB;
                }
                int i4 = length - i2;
                byte[] bArr4 = new byte[i4];
                java.lang.System.arraycopy(bArr, i2, bArr4, 0, i4);
                return b(bArrB, cipher.doFinal(bArr4));
            } catch (java.security.InvalidKeyException e) {
                e.printStackTrace();
            } catch (java.security.NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            } catch (java.security.spec.InvalidKeySpecException e3) {
                e3.printStackTrace();
            } catch (javax.crypto.BadPaddingException e4) {
                e4.printStackTrace();
            } catch (javax.crypto.IllegalBlockSizeException e5) {
                e5.printStackTrace();
            } catch (javax.crypto.NoSuchPaddingException e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }
}
