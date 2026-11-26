package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t200 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    byte[] pf = new byte[0];
    byte[] pfkey = new byte[0];

    public tlv_t200() {
        this._cmd = 512;
    }

    public byte[] getPf() {
        return this.pf;
    }

    public byte[] getPfKey() {
        return this.pfkey;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        int iBuf_to_int16;
        int iBuf_to_int17;
        if (this._body_len >= 2 && this._body_len >= (iBuf_to_int17 = (iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + 0)) + 2)) {
            byte[] bArr = new byte[iBuf_to_int16];
            this.pf = bArr;
            java.lang.System.arraycopy(this._buf, this._head_len + 2, bArr, 0, iBuf_to_int16);
            int i = iBuf_to_int17 + 2;
            if (this._body_len < i) {
                return java.lang.Boolean.FALSE;
            }
            int iBuf_to_int18 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, this._head_len + iBuf_to_int17);
            if (this._body_len < i + iBuf_to_int18) {
                return java.lang.Boolean.FALSE;
            }
            byte[] bArr2 = new byte[iBuf_to_int18];
            this.pfkey = bArr2;
            java.lang.System.arraycopy(this._buf, this._head_len + i, bArr2, 0, iBuf_to_int18);
            return java.lang.Boolean.TRUE;
        }
        return java.lang.Boolean.FALSE;
    }
}
