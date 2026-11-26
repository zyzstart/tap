package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t125 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _openid_len = 0;
    int _openkey_len = 0;

    public tlv_t125() {
        this._cmd = 293;
    }

    public byte[] get_openid() {
        int i = this._openid_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 2, bArr, 0, i);
        return bArr;
    }

    public byte[] get_openkey() {
        int i = this._openkey_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 2 + this._openid_len + 2, bArr, 0, i);
        return bArr;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        if (this._body_len < 2) {
            return java.lang.Boolean.FALSE;
        }
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len);
        this._openid_len = iBuf_to_int16;
        if (this._body_len < iBuf_to_int16 + 2 + 2) {
            return java.lang.Boolean.FALSE;
        }
        this._openkey_len = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 2 + iBuf_to_int16);
        return java.lang.Boolean.TRUE;
    }
}
