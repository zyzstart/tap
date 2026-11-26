package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t11d extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _st_len = 0;

    public tlv_t11d() {
        this._cmd = 285;
    }

    public long get_appid() {
        return ((long) oicq.wlogin_sdk.tools.util.buf_to_int32(this._buf, this._head_len)) & 4294967295L;
    }

    public byte[] get_st() {
        int i = this._st_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 4 + 16 + 2, bArr, 0, i);
        return bArr;
    }

    public byte[] get_stkey() {
        byte[] bArr = new byte[16];
        java.lang.System.arraycopy(this._buf, this._head_len + 4, bArr, 0, 16);
        return bArr;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        if (this._body_len < 22) {
            return java.lang.Boolean.FALSE;
        }
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 4 + 16);
        this._st_len = iBuf_to_int16;
        int i = iBuf_to_int16 & android.support.v4.internal.view.SupportMenu.USER_MASK;
        this._st_len = i;
        return this._body_len < i + 22 ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE;
    }
}
