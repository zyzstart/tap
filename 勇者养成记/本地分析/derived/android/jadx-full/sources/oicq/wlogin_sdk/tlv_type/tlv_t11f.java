package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t11f extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public tlv_t11f() {
        this._cmd = 287;
    }

    public int get_chg_time() {
        return oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, this._head_len);
    }

    public int get_tk_pri() {
        return oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, this._head_len + 4);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        return this._body_len < 8 ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE;
    }
}
