package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t124 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _t124_body_len = 0;

    public tlv_t124() {
        this._cmd = 292;
    }

    public byte[] get_tlv_124(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        byte[] bArr6 = bArr == null ? new byte[0] : bArr;
        byte[] bArr7 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArr8 = bArr3 == null ? new byte[0] : bArr3;
        byte[] bArr9 = bArr4 == null ? new byte[0] : bArr4;
        byte[] bArr10 = bArr5 == null ? new byte[0] : bArr5;
        int iLimit_len = limit_len(bArr6, 16);
        int iLimit_len2 = limit_len(bArr7, 16);
        int iLimit_len3 = limit_len(bArr8, 16);
        int iLimit_len4 = limit_len(bArr9, 32);
        int iLimit_len5 = limit_len(bArr10, 16);
        int i2 = iLimit_len + 2;
        int i3 = i2 + 2;
        int i4 = i3 + iLimit_len2;
        int i5 = i4 + 2;
        int i6 = i5 + 2;
        byte[] bArr11 = bArr10;
        int i7 = i6 + iLimit_len3;
        byte[] bArr12 = bArr9;
        int i8 = i7 + 2;
        int i9 = i8 + iLimit_len4;
        int i10 = i9 + 2;
        int i11 = i10 + iLimit_len5;
        this._t124_body_len = i11;
        byte[] bArr13 = new byte[i11];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr13, 0, iLimit_len);
        java.lang.System.arraycopy(bArr6, 0, bArr13, 2, iLimit_len);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr13, i2, iLimit_len2);
        java.lang.System.arraycopy(bArr7, 0, bArr13, i3, iLimit_len2);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr13, i4, i);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr13, i5, iLimit_len3);
        java.lang.System.arraycopy(bArr8, 0, bArr13, i6, iLimit_len3);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr13, i7, iLimit_len4);
        java.lang.System.arraycopy(bArr12, 0, bArr13, i8, iLimit_len4);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr13, i9, iLimit_len5);
        java.lang.System.arraycopy(bArr11, 0, bArr13, i10, iLimit_len5);
        fill_head(this._cmd);
        fill_body(bArr13, this._t124_body_len);
        set_length();
        return get_buf();
    }
}
