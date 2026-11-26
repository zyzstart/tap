package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t18 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _t18_body_len = 22;
    int _ping_version = 1;
    int _sso_version = 1536;

    public tlv_t18() {
        this._cmd = 24;
    }

    public byte[] get_tlv_18(long j, int i, long j2, int i2) {
        byte[] bArr = new byte[this._t18_body_len];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr, 0, this._ping_version);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr, 2, this._sso_version);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr, 6, (int) j);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr, 10, i);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr, 14, (int) j2);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr, 18, i2);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr, 20, 0);
        fill_head(this._cmd);
        fill_body(bArr, this._t18_body_len);
        set_length();
        return get_buf();
    }
}
