package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class RegTLV extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _head_len;

    public RegTLV(int i) {
        super(i);
        this._head_len = 4;
    }

    public byte[] getBuf() {
        return get_buf();
    }

    public void setByte(byte b) {
        setData(new byte[]{b}, 1);
    }

    public void setData(byte[] bArr, int i) {
        int i2 = this._head_len;
        int i3 = i + i2;
        if (i3 > this._max) {
            int i4 = i3 + 128;
            this._max = i4;
            byte[] bArr2 = new byte[i4];
            java.lang.System.arraycopy(this._buf, 0, bArr2, 0, i2);
            this._buf = bArr2;
        }
        int i5 = this._head_len;
        this._pos = i + i5;
        java.lang.System.arraycopy(bArr, 0, this._buf, i5, i);
        this._body_len = i;
        oicq.wlogin_sdk.tools.util.int16_to_buf(this._buf, 0, this._cmd);
        oicq.wlogin_sdk.tools.util.int16_to_buf(this._buf, 2, this._body_len);
    }

    public void setInt(int i) {
        byte[] bArr = new byte[4];
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr, 0, i);
        setData(bArr, 4);
    }

    public void setLong(long j) {
        byte[] bArr = new byte[8];
        oicq.wlogin_sdk.tools.util.int64_to_buf(bArr, 0, j);
        setData(bArr, 8);
    }

    public void setShort(int i) {
        byte[] bArr = new byte[2];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr, 0, i);
        setData(bArr, 2);
    }
}
