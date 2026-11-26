package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t105 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _piclen = 0;
    int _enlen = 0;
    int _pic_pos = 0;
    int _en_pos = 0;

    public tlv_t105() {
        this._cmd = 261;
    }

    public byte[] get_pic() {
        int i = this._piclen;
        byte[] bArr = new byte[i];
        if (i <= 0) {
            return bArr;
        }
        java.lang.System.arraycopy(this._buf, this._pic_pos, bArr, 0, i);
        return bArr;
    }

    public byte[] get_sign() {
        int i = this._enlen;
        byte[] bArr = new byte[i];
        if (i <= 0) {
            return bArr;
        }
        java.lang.System.arraycopy(this._buf, this._en_pos, bArr, 0, i);
        return bArr;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        if (this._body_len < 2) {
            return java.lang.Boolean.FALSE;
        }
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len);
        this._enlen = iBuf_to_int16;
        if (this._body_len < iBuf_to_int16 + 2 + 2) {
            return java.lang.Boolean.FALSE;
        }
        int iBuf_to_int17 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 2 + iBuf_to_int16);
        this._piclen = iBuf_to_int17;
        int i = this._body_len;
        int i2 = this._enlen + 2 + 2;
        if (i < iBuf_to_int17 + i2) {
            return java.lang.Boolean.FALSE;
        }
        int i3 = this._head_len;
        this._en_pos = i3 + 2;
        this._pic_pos = i2 + i3;
        return java.lang.Boolean.TRUE;
    }
}
