package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t186 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    private int _pwdflag;

    public tlv_t186() {
        this._cmd = 390;
    }

    public boolean getPwdflag() {
        return this._pwdflag == 1;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        if (this._body_len < 2) {
            return java.lang.Boolean.FALSE;
        }
        this._pwdflag = oicq.wlogin_sdk.tools.util.buf_to_int8(this._buf, this._head_len + 1);
        return java.lang.Boolean.TRUE;
    }
}
