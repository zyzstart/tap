package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t183 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    long _msalt = 0;

    public tlv_t183() {
        this._cmd = 387;
    }

    public long getMsalt() {
        return this._msalt;
    }

    public byte[] get_tlv_183(long j) {
        byte[] bArr = new byte[8];
        oicq.wlogin_sdk.tools.util.int64_to_buf(bArr, 0, j);
        fill_head(this._cmd);
        fill_body(bArr, 8);
        set_length();
        return get_buf();
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        if (this._body_len < 8) {
            return java.lang.Boolean.FALSE;
        }
        this._msalt = oicq.wlogin_sdk.tools.util.buf_to_int64(this._buf, this._head_len);
        return java.lang.Boolean.TRUE;
    }
}
