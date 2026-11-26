package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t8 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _t8_body_len = 0;

    public tlv_t8() {
        this._cmd = 8;
    }

    public byte[] get_tlv_8(int i, int i2, int i3) {
        this._t8_body_len = 8;
        byte[] bArr = new byte[8];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr, 0, i);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr, 2, i2);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr, 6, i3);
        fill_head(this._cmd);
        fill_body(bArr, this._t8_body_len);
        set_length();
        return get_buf();
    }
}
