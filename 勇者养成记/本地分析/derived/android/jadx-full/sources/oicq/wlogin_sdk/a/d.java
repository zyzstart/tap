package oicq.wlogin_sdk.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d extends oicq.wlogin_sdk.a.a {
    public d() {
        this.b = 3;
    }

    public byte[] b(byte[] bArr, byte[] bArr2) {
        byte[] bArrA = a(bArr, bArr2);
        int length = bArr.length + 1 + 2 + bArrA.length;
        this.d = length;
        byte[] bArr3 = new byte[length];
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr3, 0, bArr.length);
        java.lang.System.arraycopy(bArr, 0, bArr3, 1, bArr.length);
        int length2 = bArr.length + 1;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr3, length2, bArrA.length);
        java.lang.System.arraycopy(bArrA, 0, bArr3, length2 + 2, bArrA.length);
        int length3 = bArrA.length;
        return a(bArr3);
    }
}
