package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t182 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _msgCnt = 0;
    int _timeLimit = 0;

    public tlv_t182() {
        this._cmd = 386;
    }

    public int getMsgCnt() {
        return this._msgCnt;
    }

    public int getTimeLimit() {
        return this._timeLimit;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        if (this._body_len < 5) {
            return java.lang.Boolean.FALSE;
        }
        this._msgCnt = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 1);
        this._timeLimit = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 1 + 2);
        return java.lang.Boolean.TRUE;
    }
}
