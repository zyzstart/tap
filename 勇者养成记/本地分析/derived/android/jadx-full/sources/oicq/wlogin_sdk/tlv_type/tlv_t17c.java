package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t17c extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _t17c_body_len = 0;

    public tlv_t17c() {
        this._cmd = 380;
    }

    public byte[] get_tlv_17c(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length + 2;
        this._t17c_body_len = length;
        byte[] bArr2 = new byte[length];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 0, bArr.length);
        java.lang.System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        int length2 = bArr.length;
        fill_head(this._cmd);
        fill_body(bArr2, this._t17c_body_len);
        set_length();
        return get_buf();
    }
}
