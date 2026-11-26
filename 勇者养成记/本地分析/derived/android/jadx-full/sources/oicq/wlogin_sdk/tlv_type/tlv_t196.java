package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t196 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _state = 0;
    byte[] _cn = new byte[0];
    byte[] _mobile = new byte[0];

    public tlv_t196() {
        this._cmd = com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_OLD;
    }

    public java.lang.String getBakMobile() {
        return new java.lang.String(this._mobile);
    }

    public int getBakMobileState() {
        return this._state;
    }

    public java.lang.String getCountryCode() {
        return new java.lang.String(this._cn);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        if (this._body_len < 5) {
            return java.lang.Boolean.FALSE;
        }
        int i = this._head_len;
        this._state = oicq.wlogin_sdk.tools.util.buf_to_int8(this._buf, i);
        int i2 = i + 1;
        int iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, i2);
        int i3 = i2 + 2;
        if ((i3 - this._head_len) + iBuf_to_int16 > this._body_len) {
            return java.lang.Boolean.FALSE;
        }
        byte[] bArr = new byte[iBuf_to_int16];
        this._cn = bArr;
        java.lang.System.arraycopy(this._buf, i3, bArr, 0, iBuf_to_int16);
        int i4 = i3 + iBuf_to_int16;
        int iBuf_to_int17 = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, i4);
        int i5 = i4 + 2;
        if ((i5 - this._head_len) + iBuf_to_int17 > this._body_len) {
            return java.lang.Boolean.FALSE;
        }
        byte[] bArr2 = new byte[iBuf_to_int17];
        this._mobile = bArr2;
        java.lang.System.arraycopy(this._buf, i5, bArr2, 0, iBuf_to_int17);
        return java.lang.Boolean.TRUE;
    }
}
