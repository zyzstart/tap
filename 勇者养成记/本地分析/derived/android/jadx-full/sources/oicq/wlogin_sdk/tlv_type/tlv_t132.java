package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t132 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _token_len = 0;
    int _openid_len = 0;

    public tlv_t132() {
        this._cmd = com.tencent.smtt.sdk.TbsListener.ErrorCode.THROWABLE_QBSDK_INIT;
    }

    public byte[] get_access_token() {
        int i = this._token_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 2, bArr, 0, i);
        return bArr;
    }

    public byte[] get_openid() {
        int i = this._openid_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 2 + this._token_len + 4 + 2, bArr, 0, i);
        return bArr;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        if (this._body_len < 2) {
            return java.lang.Boolean.FALSE;
        }
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len);
        this._token_len = iBuf_to_int16;
        if (iBuf_to_int16 + 2 + 4 + 2 > this._body_len) {
            return java.lang.Boolean.FALSE;
        }
        this._openid_len = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 2 + iBuf_to_int16 + 4);
        return java.lang.Boolean.TRUE;
    }
}
