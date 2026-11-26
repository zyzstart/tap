package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t106 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _TGTGTVer = 4;
    int _SSoVer = 5;
    int _t106_body_len = 98;

    public tlv_t106() {
        this._cmd = 262;
    }

    public byte[] get_tlv_106(long j, long j2, int i, long j3, byte[] bArr, byte[] bArr2, int i2, byte[] bArr3, long j4, byte[] bArr4, byte[] bArr5, int i3, byte[] bArr6, int i4) {
        int length;
        byte[] bArr7 = bArr == null ? new byte[0] : bArr;
        byte[] bArr8 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArr9 = bArr3 == null ? new byte[0] : bArr3;
        byte[] bArr10 = bArr5 == null ? new byte[0] : bArr5;
        byte[] bArr11 = bArr6 == null ? new byte[0] : bArr6;
        byte[] bArr12 = bArr4 == null ? new byte[0] : bArr4;
        int length2 = this._t106_body_len + bArr12.length + 2;
        this._t106_body_len = length2;
        byte[] bArr13 = new byte[length2];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr13, 0, this._TGTGTVer);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr13, 2, oicq.wlogin_sdk.tools.util.get_rand_32());
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr13, 6, this._SSoVer);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr13, 10, (int) j);
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr13, 14, i);
        oicq.wlogin_sdk.tools.util.int64_to_buf(bArr13, 18, j3 == 0 ? j4 : j3);
        java.lang.System.arraycopy(bArr7, 0, bArr13, 26, bArr7.length);
        int length3 = bArr7.length + 26;
        java.lang.System.arraycopy(bArr8, 0, bArr13, length3, bArr8.length);
        int length4 = length3 + bArr8.length;
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr13, length4, i2);
        int i5 = length4 + 1;
        java.lang.System.arraycopy(bArr9, 0, bArr13, i5, bArr9.length);
        int length5 = i5 + bArr9.length;
        java.lang.System.arraycopy(bArr10, 0, bArr13, length5, bArr10.length);
        int length6 = length5 + bArr10.length;
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr13, length6, 0);
        int i6 = length6 + 4;
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr13, i6, i3);
        int i7 = i6 + 1;
        if (bArr11.length == 0) {
            byte[] bArr14 = new byte[16];
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr14, 0, oicq.wlogin_sdk.tools.util.get_rand_32());
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr14, 4, oicq.wlogin_sdk.tools.util.get_rand_32());
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr14, 8, oicq.wlogin_sdk.tools.util.get_rand_32());
            oicq.wlogin_sdk.tools.util.int32_to_buf(bArr14, 12, oicq.wlogin_sdk.tools.util.get_rand_32());
            length = i7 + 16;
        } else {
            java.lang.System.arraycopy(bArr11, 0, bArr13, i7, bArr11.length);
            length = i7 + bArr11.length;
        }
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr13, length, j2);
        int i8 = length + 4;
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr13, i8, i4);
        int i9 = i8 + 4;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr13, i9, bArr12.length);
        java.lang.System.arraycopy(bArr12, 0, bArr13, i9 + 2, bArr12.length);
        byte[] bArr15 = new byte[24];
        java.lang.System.arraycopy(bArr9, 0, bArr15, 0, bArr9.length);
        if (j4 == 0) {
            oicq.wlogin_sdk.tools.util.int64_to_buf(bArr15, 16, j3);
        } else {
            oicq.wlogin_sdk.tools.util.int64_to_buf(bArr15, 16, j4);
        }
        byte[] bArrEncrypt = oicq.wlogin_sdk.tools.cryptor.encrypt(bArr13, 0, length2, oicq.wlogin_sdk.tools.MD5.toMD5Byte(bArr15));
        this._t106_body_len = bArrEncrypt.length;
        fill_head(this._cmd);
        fill_body(bArrEncrypt, this._t106_body_len);
        set_length();
        return get_buf();
    }
}
