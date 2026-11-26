package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t174 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _t174_body_len = 0;

    public tlv_t174() {
        this._cmd = 372;
    }

    public byte[] get_tlv_174(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        this._t174_body_len = length;
        byte[] bArr2 = new byte[length];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        fill_head(this._cmd);
        fill_body(bArr2, this._t174_body_len);
        set_length();
        return get_buf();
    }
}
