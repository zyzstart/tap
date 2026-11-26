package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t153 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public tlv_t153() {
        this._cmd = 339;
    }

    public byte[] get_tlv_153(int i) {
        byte[] bArr = new byte[2];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr, 0, i);
        fill_head(this._cmd);
        fill_body(bArr, 2);
        set_length();
        return get_buf();
    }
}
