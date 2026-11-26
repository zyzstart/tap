package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t126 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _random_len = 0;

    public tlv_t126() {
        this._cmd = 294;
    }

    public byte[] get_random() {
        int i = this._random_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 2 + 2, bArr, 0, i);
        return bArr;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        int i = this._body_len;
        if (i >= 2 && i >= 4) {
            int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 2);
            this._random_len = iBuf_to_int16;
            return (iBuf_to_int16 + 2) + 2 > this._body_len ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE;
        }
        return java.lang.Boolean.FALSE;
    }
}
