package oicq.wlogin_sdk.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c extends oicq.wlogin_sdk.a.a {
    public c() {
        this.b = 7;
    }

    public byte[] a(int i, byte[] bArr, long j) {
        int length = bArr.length + 2 + 4;
        this.d = length;
        byte[] bArr2 = new byte[length];
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr2, 0, i);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr2, 1, bArr.length);
        java.lang.System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr2, bArr.length + 2, j);
        return a(bArr2);
    }
}
