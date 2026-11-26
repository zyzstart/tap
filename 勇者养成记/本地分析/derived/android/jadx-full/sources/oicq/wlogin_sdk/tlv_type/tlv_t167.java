package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t167 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public int _url_len = 0;

    public tlv_t167() {
        this._cmd = 359;
    }

    public byte[] get_img_format() {
        byte[] bArr = new byte[1];
        java.lang.System.arraycopy(this._buf, this._head_len + 1, bArr, 0, 1);
        return bArr;
    }

    public byte[] get_img_type() {
        byte[] bArr = new byte[1];
        java.lang.System.arraycopy(this._buf, this._head_len, bArr, 0, 1);
        return bArr;
    }

    public byte[] get_img_url() {
        int i = this._url_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 1 + 1 + 2, bArr, 0, i);
        return bArr;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        if (this._body_len < 4) {
            return java.lang.Boolean.FALSE;
        }
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 1 + 1);
        if (this._body_len < iBuf_to_int16 + 4) {
            return java.lang.Boolean.FALSE;
        }
        this._url_len = iBuf_to_int16;
        return java.lang.Boolean.TRUE;
    }
}
