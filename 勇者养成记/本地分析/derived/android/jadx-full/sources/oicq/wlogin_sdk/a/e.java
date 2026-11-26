package oicq.wlogin_sdk.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e extends oicq.wlogin_sdk.a.a {
    public e() {
        this.b = 4;
    }

    public byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length + 1;
        this.d = length;
        byte[] bArr3 = new byte[length];
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr3, 0, bArr.length);
        java.lang.System.arraycopy(bArr, 0, bArr3, 1, bArr.length);
        int length2 = bArr.length;
        return a(bArr3);
    }
}
