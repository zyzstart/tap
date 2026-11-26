package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t146 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public int _title_len = 0;
    public int _msg_len = 0;
    public int _errorinfo_len = 0;

    public tlv_t146() {
        this._cmd = com.tencent.smtt.sdk.TbsListener.ErrorCode.TEST_THROWABLE_IS_NULL;
    }

    public int get_code() {
        return oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 2);
    }

    public byte[] get_errorinfo() {
        int i = this._errorinfo_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 12 + this._title_len + this._msg_len, bArr, 0, i);
        return bArr;
    }

    public byte[] get_msg() {
        int i = this._msg_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 8 + this._title_len, bArr, 0, i);
        return bArr;
    }

    public byte[] get_title() {
        int i = this._title_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 6, bArr, 0, i);
        return bArr;
    }

    public int get_type() {
        return oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 8 + this._title_len + this._msg_len);
    }

    public int get_ver() {
        return oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        if (this._body_len < 12) {
            return java.lang.Boolean.FALSE;
        }
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 4);
        if (this._body_len < iBuf_to_int16 + 12) {
            return java.lang.Boolean.FALSE;
        }
        this._title_len = iBuf_to_int16;
        int iBuf_to_int17 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 6 + iBuf_to_int16);
        int i = this._body_len;
        int i2 = this._title_len;
        if (i < i2 + 12 + iBuf_to_int17) {
            return java.lang.Boolean.FALSE;
        }
        this._msg_len = iBuf_to_int17;
        int iBuf_to_int18 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 10 + i2 + iBuf_to_int17);
        if (this._body_len < this._title_len + 12 + this._msg_len + iBuf_to_int18) {
            return java.lang.Boolean.FALSE;
        }
        this._errorinfo_len = iBuf_to_int18;
        return java.lang.Boolean.TRUE;
    }
}
