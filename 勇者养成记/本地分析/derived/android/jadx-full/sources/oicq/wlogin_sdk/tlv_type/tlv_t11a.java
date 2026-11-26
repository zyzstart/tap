package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t11a extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public int _nick_len = 0;

    public tlv_t11a() {
        this._cmd = 282;
    }

    public byte[] get_age() {
        byte[] bArr = new byte[1];
        java.lang.System.arraycopy(this._buf, this._head_len + 2, bArr, 0, 1);
        return bArr;
    }

    public byte[] get_face() {
        byte[] bArr = new byte[2];
        java.lang.System.arraycopy(this._buf, this._head_len, bArr, 0, 2);
        return bArr;
    }

    public byte[] get_gender() {
        byte[] bArr = new byte[1];
        java.lang.System.arraycopy(this._buf, this._head_len + 2 + 1, bArr, 0, 1);
        return bArr;
    }

    public byte[] get_nick() {
        int i = this._nick_len;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this._buf, this._head_len + 2 + 1 + 1 + 1, bArr, 0, i);
        return bArr;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        if (this._body_len < 5) {
            return java.lang.Boolean.FALSE;
        }
        int iBuf_to_int8 = oicq.wlogin_sdk.tools.util.buf_to_int8(this._buf, this._head_len + 2 + 1 + 1);
        if (this._body_len < iBuf_to_int8 + 5) {
            return java.lang.Boolean.FALSE;
        }
        this._nick_len = iBuf_to_int8;
        return java.lang.Boolean.TRUE;
    }
}
