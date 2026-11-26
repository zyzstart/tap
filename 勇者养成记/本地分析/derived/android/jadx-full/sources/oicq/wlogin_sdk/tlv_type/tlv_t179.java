package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t179 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public int _verify_url_len = 0;

    public tlv_t179() {
        this._cmd = 377;
    }

    public byte[] get_verify_url() {
        int i = this._verify_url_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 2, bArr, 0, i);
        return bArr;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        if (this._body_len < 2) {
            return java.lang.Boolean.FALSE;
        }
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len);
        if (this._body_len < iBuf_to_int16 + 2) {
            return java.lang.Boolean.FALSE;
        }
        this._verify_url_len = iBuf_to_int16;
        return java.lang.Boolean.TRUE;
    }
}
