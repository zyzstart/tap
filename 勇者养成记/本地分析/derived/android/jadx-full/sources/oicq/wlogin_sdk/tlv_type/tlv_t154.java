package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t154 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public tlv_t154() {
        this._cmd = 340;
    }

    public byte[] get_tlv_154(int i) {
        byte[] bArr = new byte[4];
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr, 0, i);
        fill_head(this._cmd);
        fill_body(bArr, 4);
        set_length();
        return get_buf();
    }
}
