package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t202 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public tlv_t202() {
        this._cmd = 514;
    }

    public byte[] get_tlv_202(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = new byte[16];
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        int iLimit_len = limit_len(bArr, 16);
        int iLimit_len2 = limit_len(bArr2, 32);
        int i = iLimit_len + 2;
        int i2 = i + 2;
        int i3 = i2 + iLimit_len2;
        byte[] bArr3 = new byte[i3];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr3, 0, iLimit_len);
        java.lang.System.arraycopy(bArr, 0, bArr3, 2, iLimit_len);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr3, i, iLimit_len2);
        java.lang.System.arraycopy(bArr2, 0, bArr3, i2, iLimit_len2);
        fill_head(this._cmd);
        fill_body(bArr3, i3);
        set_length();
        return get_buf();
    }
}
