package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t128 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _t128_body_len = 0;

    public tlv_t128() {
        this._cmd = 296;
    }

    public byte[] get_tlv_128(int i, int i2, int i3, int i4, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = bArr == null ? new byte[0] : bArr;
        byte[] bArr5 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArr6 = bArr3 == null ? new byte[0] : bArr3;
        int iLimit_len = limit_len(bArr4, 32);
        int iLimit_len2 = limit_len(bArr5, 16);
        int iLimit_len3 = limit_len(bArr6, 16);
        int i5 = iLimit_len + 11;
        int i6 = i5 + 2;
        int i7 = i6 + iLimit_len2;
        int i8 = i7 + 2;
        int i9 = i8 + iLimit_len3;
        this._t128_body_len = i9;
        byte[] bArr7 = new byte[i9];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr7, 0, 0);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr7, 2, i);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr7, 3, i2);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr7, 4, i3);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr7, 5, i4);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr7, 9, iLimit_len);
        java.lang.System.arraycopy(bArr4, 0, bArr7, 11, iLimit_len);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr7, i5, iLimit_len2);
        java.lang.System.arraycopy(bArr5, 0, bArr7, i6, iLimit_len2);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr7, i7, iLimit_len3);
        java.lang.System.arraycopy(bArr6, 0, bArr7, i8, iLimit_len3);
        fill_head(this._cmd);
        fill_body(bArr7, this._t128_body_len);
        set_length();
        return get_buf();
    }
}
