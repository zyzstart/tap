package oicq.wlogin_sdk.devicelock;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i extends oicq.wlogin_sdk.devicelock.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1662a = 0;
    public int b = 0;
    public int c = 0;
    public byte[] d = new byte[0];
    public byte[] e = new byte[0];
    public byte[] f = new byte[0];
    public byte[] g = new byte[0];

    public i() {
        this._type = 3;
    }

    @Override // oicq.wlogin_sdk.devicelock.e
    public void parse() {
        int i = this._head_len;
        this.f1662a = oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, i);
        int i2 = i + 4;
        this.b = oicq.wlogin_sdk.tools.util.buf_to_int8(this._buf, i2);
        int i3 = i2 + 1;
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, i3);
        int i4 = i3 + 2;
        byte[] bArr = new byte[iBuf_to_int16];
        this.d = bArr;
        java.lang.System.arraycopy(this._buf, i4, bArr, 0, iBuf_to_int16);
        int i5 = i4 + iBuf_to_int16;
        int iBuf_to_int17 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, i5);
        int i6 = i5 + 2;
        byte[] bArr2 = new byte[iBuf_to_int17];
        this.e = bArr2;
        java.lang.System.arraycopy(this._buf, i6, bArr2, 0, iBuf_to_int17);
        int i7 = i6 + iBuf_to_int17;
        int iBuf_to_int18 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, i7);
        int i8 = i7 + 2;
        byte[] bArr3 = new byte[iBuf_to_int18];
        this.f = bArr3;
        java.lang.System.arraycopy(this._buf, i8, bArr3, 0, iBuf_to_int18);
        int i9 = i8 + iBuf_to_int18;
        this.c = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, i9);
        int i10 = i9 + 2;
        int iBuf_to_int19 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, i10);
        byte[] bArr4 = new byte[iBuf_to_int19];
        this.g = bArr4;
        java.lang.System.arraycopy(this._buf, i10 + 2, bArr4, 0, iBuf_to_int19);
    }
}
