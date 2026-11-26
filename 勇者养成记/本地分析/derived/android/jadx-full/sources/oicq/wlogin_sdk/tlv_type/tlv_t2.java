package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t2 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _t2_body_len = 0;
    int _sigVer = 0;

    public tlv_t2() {
        this._cmd = 2;
    }

    public byte[] get_tlv_2(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        int length = bArr.length + 6 + bArr2.length;
        this._t2_body_len = length;
        byte[] bArr3 = new byte[length];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr3, 0, this._sigVer);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr3, 2, bArr.length);
        java.lang.System.arraycopy(bArr, 0, bArr3, 4, bArr.length);
        int length2 = bArr.length + 4;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr3, length2, bArr2.length);
        java.lang.System.arraycopy(bArr2, 0, bArr3, length2 + 2, bArr2.length);
        int length3 = bArr2.length;
        fill_head(this._cmd);
        fill_body(bArr3, this._t2_body_len);
        set_length();
        return get_buf();
    }
}
