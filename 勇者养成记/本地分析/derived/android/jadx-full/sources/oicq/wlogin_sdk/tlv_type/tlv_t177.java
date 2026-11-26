package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t177 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _t177_body_len = 0;

    public tlv_t177() {
        this._cmd = 375;
    }

    public byte[] get_tlv_177(long j, java.lang.String str) {
        byte[] bytes = new byte[0];
        if (str != null) {
            bytes = str.getBytes();
        }
        int length = bytes.length + 7;
        this._t177_body_len = length;
        byte[] bArr = new byte[length];
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr, 0, 1);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr, 1, j);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr, 5, bytes.length);
        java.lang.System.arraycopy(bytes, 0, bArr, 7, bytes.length);
        int length2 = bytes.length;
        fill_head(this._cmd);
        fill_body(bArr, this._t177_body_len);
        set_length();
        return get_buf();
    }
}
