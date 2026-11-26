package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t178 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public int _country_code_len = 0;
    public int _mobile_len = 0;

    public tlv_t178() {
        this._cmd = 376;
    }

    public int get_available_msg_cnt() {
        return oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 2 + this._country_code_len + 2 + this._mobile_len + 4);
    }

    public byte[] get_country_code() {
        int i = this._country_code_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 2, bArr, 0, i);
        return bArr;
    }

    public byte[] get_mobile() {
        int i = this._mobile_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 2 + this._country_code_len + 2, bArr, 0, i);
        return bArr;
    }

    public int get_smscode_status() {
        return oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, this._head_len + 2 + this._country_code_len + 2 + this._mobile_len);
    }

    public int get_time_limit() {
        return oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 2 + this._country_code_len + 2 + this._mobile_len + 4 + 2);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        if (this._body_len < 12) {
            return java.lang.Boolean.FALSE;
        }
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len);
        if (this._body_len < iBuf_to_int16 + 12) {
            return java.lang.Boolean.FALSE;
        }
        this._country_code_len = iBuf_to_int16;
        int iBuf_to_int17 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 2 + iBuf_to_int16);
        if (this._body_len < this._country_code_len + 12 + iBuf_to_int17) {
            return java.lang.Boolean.FALSE;
        }
        this._mobile_len = iBuf_to_int17;
        return java.lang.Boolean.TRUE;
    }
}
