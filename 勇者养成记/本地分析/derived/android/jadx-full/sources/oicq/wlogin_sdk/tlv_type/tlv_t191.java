package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t191 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public tlv_t191() {
        this._cmd = 401;
    }

    public byte[] get_tlv_191(int i) {
        fill_head(this._cmd);
        fill_body(new byte[]{(byte) i}, 1);
        set_length();
        return get_buf();
    }
}
