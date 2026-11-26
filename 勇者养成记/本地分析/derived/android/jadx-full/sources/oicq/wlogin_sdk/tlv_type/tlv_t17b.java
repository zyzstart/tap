package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t17b extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public tlv_t17b() {
        this._cmd = 379;
    }

    public int get_available_msg_cnt() {
        if (this._body_len < 4) {
            return 0;
        }
        return oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len);
    }

    public int get_time_limit() {
        if (this._body_len < 4) {
            return 0;
        }
        return oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 2);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        return this._body_len < 4 ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE;
    }
}
