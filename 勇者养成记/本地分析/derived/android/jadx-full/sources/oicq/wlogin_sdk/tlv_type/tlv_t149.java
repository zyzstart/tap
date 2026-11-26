package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t149 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public int _title_len = 0;
    public int _content_len = 0;
    public int _otherinfo_len = 0;

    public tlv_t149() {
        this._cmd = com.tencent.smtt.sdk.TbsListener.ErrorCode.ERROR_GETSTRINGARRAY_JARFILE;
    }

    public byte[] get_content() {
        int i = this._content_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 2 + 2 + this._title_len + 2, bArr, 0, i);
        return bArr;
    }

    public byte[] get_otherinfo() {
        int i = this._otherinfo_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 2 + 2 + this._title_len + 2 + this._content_len + 2, bArr, 0, i);
        return bArr;
    }

    public byte[] get_title() {
        int i = this._title_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 2 + 2, bArr, 0, i);
        return bArr;
    }

    public int get_type() {
        return oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        if (this._body_len < 8) {
            return java.lang.Boolean.FALSE;
        }
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 2);
        if (this._body_len < iBuf_to_int16 + 8) {
            return java.lang.Boolean.FALSE;
        }
        this._title_len = iBuf_to_int16;
        int iBuf_to_int17 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 2 + 2 + iBuf_to_int16);
        int i = this._body_len;
        int i2 = this._title_len;
        if (i < i2 + 8 + iBuf_to_int17) {
            return java.lang.Boolean.FALSE;
        }
        this._content_len = iBuf_to_int17;
        int iBuf_to_int18 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 2 + 2 + i2 + 2 + iBuf_to_int17);
        if (this._body_len < this._title_len + 8 + this._content_len + iBuf_to_int18) {
            return java.lang.Boolean.FALSE;
        }
        this._otherinfo_len = iBuf_to_int18;
        return java.lang.Boolean.TRUE;
    }
}
