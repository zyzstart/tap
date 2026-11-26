package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t17a extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public tlv_t17a() {
        this._cmd = 378;
    }

    public byte[] get_tlv_17a(long j) {
        byte[] bArr = new byte[4];
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr, 0, j);
        fill_head(this._cmd);
        fill_body(bArr, 4);
        set_length();
        return get_buf();
    }
}
