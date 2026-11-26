package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t184 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    byte[] _mS2 = new byte[0];

    public tlv_t184() {
        this._cmd = 388;
    }

    public byte[] getMS2() {
        return this._mS2;
    }

    public byte[] get_tlv_184(long j, java.lang.String str) {
        byte[] mD5Byte = oicq.wlogin_sdk.tools.MD5.toMD5Byte(str);
        int length = mD5Byte.length;
        byte[] bArr = new byte[length + 8];
        java.lang.System.arraycopy(mD5Byte, 0, bArr, 0, length);
        oicq.wlogin_sdk.tools.util.int64_to_buf(bArr, length + 0, j);
        byte[] mD5Byte2 = oicq.wlogin_sdk.tools.MD5.toMD5Byte(bArr);
        fill_head(this._cmd);
        fill_body(mD5Byte2, mD5Byte2.length);
        set_length();
        return get_buf();
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        if (this._body_len < 16) {
            return java.lang.Boolean.FALSE;
        }
        byte[] bArr = new byte[16];
        this._mS2 = bArr;
        java.lang.System.arraycopy(this._buf, this._head_len, bArr, 0, 16);
        return java.lang.Boolean.TRUE;
    }
}
