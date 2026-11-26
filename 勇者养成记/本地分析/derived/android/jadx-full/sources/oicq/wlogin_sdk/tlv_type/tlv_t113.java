package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t113 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public tlv_t113() {
        this._cmd = 275;
    }

    public long get_uin() {
        return ((long) oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, this._head_len)) & 4294967295L;
    }
}
