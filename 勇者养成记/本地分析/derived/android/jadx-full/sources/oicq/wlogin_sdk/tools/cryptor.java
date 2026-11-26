package oicq.wlogin_sdk.tools;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class cryptor {
    public static byte[] decrypt(byte[] bArr, int i, int i2, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[i2];
        java.lang.System.arraycopy(bArr, i, bArr3, 0, i2);
        byte[] bArr4 = new byte[bArr2.length];
        java.lang.System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
        return new oicq.wlogin_sdk.tools.a().a(bArr3, bArr4);
    }

    public static byte[] encrypt(byte[] bArr, int i, int i2, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[i2];
        java.lang.System.arraycopy(bArr, i, bArr3, 0, i2);
        byte[] bArr4 = new byte[bArr2.length];
        java.lang.System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
        return new oicq.wlogin_sdk.tools.a().b(bArr3, bArr4);
    }
}
