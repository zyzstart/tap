package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t116 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _t116_body_len = 0;
    int _ver = 0;

    public tlv_t116() {
        this._cmd = 278;
    }

    public byte[] get_tlv_116(int i, int i2, long[] jArr) {
        if (jArr == null) {
            jArr = new long[0];
        }
        int i3 = 10;
        int length = (jArr.length * 4) + 10;
        this._t116_body_len = length;
        byte[] bArr = new byte[length];
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr, 0, this._ver);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr, 1, i);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr, 5, i2);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr, 9, jArr.length);
        for (long j : jArr) {
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr, i3, (int) j);
            i3 += 4;
        }
        fill_head(this._cmd);
        fill_body(bArr, this._t116_body_len);
        set_length();
        return get_buf();
    }
}
