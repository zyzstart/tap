package oicq.wlogin_sdk.devicelock;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TLV_CommRsp extends oicq.wlogin_sdk.devicelock.e {
    public int ErrInfoType;
    public int RetCode = -1;
    public int Reason = 0;
    public byte[] ErrTitle = new byte[0];
    public byte[] ErrMsg = new byte[0];
    public byte[] ErrInfo = new byte[0];

    public TLV_CommRsp() {
        this._type = 1;
    }

    @Override // oicq.wlogin_sdk.devicelock.e
    public void parse() {
        int i = this._head_len;
        this.RetCode = oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, i);
        int i2 = i + 4;
        this.Reason = oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, i2);
        int i3 = i2 + 4;
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, i3);
        int i4 = i3 + 2;
        byte[] bArr = new byte[iBuf_to_int16];
        this.ErrTitle = bArr;
        java.lang.System.arraycopy(this._buf, i4, bArr, 0, iBuf_to_int16);
        int i5 = i4 + iBuf_to_int16;
        int iBuf_to_int17 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, i5);
        int i6 = i5 + 2;
        byte[] bArr2 = new byte[iBuf_to_int17];
        this.ErrMsg = bArr2;
        java.lang.System.arraycopy(this._buf, i6, bArr2, 0, iBuf_to_int17);
        int i7 = i6 + iBuf_to_int17;
        this.ErrInfoType = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, i7);
        int i8 = i7 + 2;
        int iBuf_to_int18 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, i8);
        byte[] bArr3 = new byte[iBuf_to_int18];
        this.ErrInfo = bArr3;
        java.lang.System.arraycopy(this._buf, i8 + 2, bArr3, 0, iBuf_to_int18);
    }
}
