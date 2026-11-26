package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t100 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _db_buf_ver = 1;
    int _sso_ver = 5;
    int _t100_body_len = 22;

    public tlv_t100() {
        this._cmd = 256;
    }

    public byte[] get_tlv_100(long j, long j2, int i, int i2) {
        byte[] bArr = new byte[this._t100_body_len];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr, 0, this._db_buf_ver);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr, 2, this._sso_ver);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr, 6, (int) j);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr, 10, (int) j2);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr, 14, i);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr, 18, i2);
        fill_head(this._cmd);
        fill_body(bArr, this._t100_body_len);
        set_length();
        return get_buf();
    }
}
