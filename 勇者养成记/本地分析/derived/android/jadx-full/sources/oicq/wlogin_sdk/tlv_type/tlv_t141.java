package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t141 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _version = 1;

    public tlv_t141() {
        this._cmd = 321;
    }

    public byte[] get_tlv_141(byte[] bArr, int i, byte[] bArr2) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        int length = bArr.length + 4 + 2 + 2 + bArr2.length;
        byte[] bArr3 = new byte[length];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr3, 0, this._version);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr3, 2, bArr.length);
        java.lang.System.arraycopy(bArr, 0, bArr3, 4, bArr.length);
        int length2 = bArr.length + 4;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr3, length2, i);
        int i2 = length2 + 2;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr3, i2, bArr2.length);
        java.lang.System.arraycopy(bArr2, 0, bArr3, i2 + 2, bArr2.length);
        int length3 = bArr2.length;
        fill_head(this._cmd);
        fill_body(bArr3, length);
        set_length();
        return get_buf();
    }
}
