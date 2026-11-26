package oicq.wlogin_sdk.devicelock;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class k extends oicq.wlogin_sdk.devicelock.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f1664a = new byte[0];
    public byte[] b = new byte[0];
    public int c;
    public int d;
    public int e;

    public k() {
        this._type = 4;
    }

    @Override // oicq.wlogin_sdk.devicelock.e
    public void parse() {
        int i = this._head_len;
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, i);
        int i2 = i + 2;
        byte[] bArr = new byte[iBuf_to_int16];
        this.f1664a = bArr;
        java.lang.System.arraycopy(this._buf, i2, bArr, 0, iBuf_to_int16);
        int i3 = i2 + iBuf_to_int16;
        int iBuf_to_int17 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, i3);
        int i4 = i3 + 2;
        byte[] bArr2 = new byte[iBuf_to_int17];
        this.b = bArr2;
        java.lang.System.arraycopy(this._buf, i4, bArr2, 0, iBuf_to_int17);
        int i5 = i4 + iBuf_to_int17;
        this.c = oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, i5);
        int i6 = i5 + 4;
        this.d = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, i6);
        this.e = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, i6 + 2);
    }
}
