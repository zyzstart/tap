package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t107 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _t107_body_len = 6;

    public tlv_t107() {
        this._cmd = 263;
    }

    public byte[] get_tlv_107(int i, int i2, int i3, int i4) {
        byte[] bArr = new byte[this._t107_body_len];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr, 0, i);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr, 2, i2);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr, 3, i3);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr, 5, i4);
        fill_head(this._cmd);
        fill_body(bArr, this._t107_body_len);
        set_length();
        return get_buf();
    }
}
