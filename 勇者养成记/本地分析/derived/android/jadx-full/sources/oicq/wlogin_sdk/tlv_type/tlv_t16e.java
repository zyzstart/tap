package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t16e extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _t16e_body_len = 0;

    public tlv_t16e() {
        this._cmd = 366;
    }

    public byte[] get_tlv_16e(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length < 64 ? bArr.length : 64;
        this._t16e_body_len = length;
        byte[] bArr2 = new byte[length];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, length);
        fill_head(this._cmd);
        fill_body(bArr2, this._t16e_body_len);
        set_length();
        return get_buf();
    }
}
