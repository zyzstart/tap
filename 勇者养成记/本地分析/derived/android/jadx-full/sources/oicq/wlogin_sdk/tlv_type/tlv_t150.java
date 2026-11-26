package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t150 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public int _other_len = 0;

    public tlv_t150() {
        this._cmd = 336;
    }

    public int get_bitmap() {
        return oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, this._head_len);
    }

    public byte get_network() {
        return (byte) (oicq.wlogin_sdk.tools.util.buf_to_int8(this._buf, this._head_len + 4) & 255);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        if (this._body_len < 7) {
            return java.lang.Boolean.FALSE;
        }
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 5);
        if (this._body_len < iBuf_to_int16 + 7) {
            return java.lang.Boolean.FALSE;
        }
        this._other_len = iBuf_to_int16;
        return java.lang.Boolean.TRUE;
    }
}
