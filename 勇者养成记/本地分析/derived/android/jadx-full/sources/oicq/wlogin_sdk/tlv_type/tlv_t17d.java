package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t17d extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public int _mb_guide_msg_len = 0;
    public int _mb_guide_info_len = 0;

    public tlv_t17d() {
        this._cmd = 381;
    }

    public byte[] get_mb_guide_info() {
        int i = this._mb_guide_info_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 2 + 2 + this._mb_guide_msg_len + 2 + 2, bArr, 0, i);
        return bArr;
    }

    public int get_mb_guide_info_type() {
        return oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 2 + 2 + this._mb_guide_msg_len);
    }

    public byte[] get_mb_guide_msg() {
        int i = this._mb_guide_msg_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 2 + 2, bArr, 0, i);
        return bArr;
    }

    public int get_mb_guide_type() {
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
        this._mb_guide_msg_len = iBuf_to_int16;
        int iBuf_to_int17 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 2 + 2 + iBuf_to_int16 + 2);
        if (this._body_len < this._mb_guide_msg_len + 8 + iBuf_to_int17) {
            return java.lang.Boolean.FALSE;
        }
        this._mb_guide_info_len = iBuf_to_int17;
        return java.lang.Boolean.TRUE;
    }
}
