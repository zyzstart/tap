package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t144 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public int _t144_body_len = 0;

    public tlv_t144() {
        this._cmd = 324;
    }

    public byte[] get_tlv_144(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        int length;
        int i;
        if (bArr == null || bArr.length <= 0) {
            length = 0;
            i = 0;
        } else {
            length = bArr.length + 0;
            i = 1;
        }
        if (bArr2 != null && bArr2.length > 0) {
            length += bArr2.length;
            i++;
        }
        if (bArr3 != null && bArr3.length > 0) {
            length += bArr3.length;
            i++;
        }
        if (bArr4 != null && bArr4.length > 0) {
            length += bArr4.length;
            i++;
        }
        int length2 = 2;
        int i2 = length + 2;
        byte[] bArr6 = new byte[i2];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr6, 0, i);
        if (bArr != null && bArr.length > 0) {
            java.lang.System.arraycopy(bArr, 0, bArr6, 2, bArr.length);
            length2 = 2 + bArr.length;
        }
        if (bArr2 != null && bArr2.length > 0) {
            java.lang.System.arraycopy(bArr2, 0, bArr6, length2, bArr2.length);
            length2 += bArr2.length;
        }
        if (bArr3 != null && bArr3.length > 0) {
            java.lang.System.arraycopy(bArr3, 0, bArr6, length2, bArr3.length);
            length2 += bArr3.length;
        }
        if (bArr4 != null && bArr4.length > 0) {
            java.lang.System.arraycopy(bArr4, 0, bArr6, length2, bArr4.length);
            int length3 = bArr4.length;
        }
        byte[] bArrEncrypt = oicq.wlogin_sdk.tools.cryptor.encrypt(bArr6, 0, i2, bArr5);
        this._t144_body_len = bArrEncrypt.length;
        fill_head(this._cmd);
        fill_body(bArrEncrypt, bArrEncrypt.length);
        set_length();
        return get_buf();
    }

    public byte[] get_tlv_144(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8) {
        int length;
        int i;
        if (bArr == null || bArr.length <= 0) {
            length = 0;
            i = 0;
        } else {
            length = bArr.length + 0;
            i = 1;
        }
        if (bArr2 != null && bArr2.length > 0) {
            length += bArr2.length;
            i++;
        }
        if (bArr3 != null && bArr3.length > 0) {
            length += bArr3.length;
            i++;
        }
        if (bArr4 != null && bArr4.length > 0) {
            length += bArr4.length;
            i++;
        }
        if (bArr5 != null && bArr5.length > 0) {
            length += bArr5.length;
            i++;
        }
        if (bArr6 != null && bArr6.length > 0) {
            length += bArr6.length;
            i++;
        }
        if (bArr7 != null && bArr7.length > 0) {
            length += bArr7.length;
            i++;
        }
        int length2 = 2;
        int i2 = length + 2;
        byte[] bArr9 = new byte[i2];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr9, 0, i);
        if (bArr != null && bArr.length > 0) {
            java.lang.System.arraycopy(bArr, 0, bArr9, 2, bArr.length);
            length2 = 2 + bArr.length;
        }
        if (bArr2 != null && bArr2.length > 0) {
            java.lang.System.arraycopy(bArr2, 0, bArr9, length2, bArr2.length);
            length2 += bArr2.length;
        }
        if (bArr3 != null && bArr3.length > 0) {
            java.lang.System.arraycopy(bArr3, 0, bArr9, length2, bArr3.length);
            length2 += bArr3.length;
        }
        if (bArr4 != null && bArr4.length > 0) {
            java.lang.System.arraycopy(bArr4, 0, bArr9, length2, bArr4.length);
            length2 += bArr4.length;
        }
        if (bArr5 != null && bArr5.length > 0) {
            java.lang.System.arraycopy(bArr5, 0, bArr9, length2, bArr5.length);
            length2 += bArr5.length;
        }
        if (bArr6 != null && bArr6.length > 0) {
            java.lang.System.arraycopy(bArr6, 0, bArr9, length2, bArr6.length);
            length2 += bArr6.length;
        }
        if (bArr7 != null && bArr7.length > 0) {
            java.lang.System.arraycopy(bArr7, 0, bArr9, length2, bArr7.length);
            int length3 = bArr7.length;
        }
        byte[] bArrEncrypt = oicq.wlogin_sdk.tools.cryptor.encrypt(bArr9, 0, i2, bArr8);
        this._t144_body_len = bArrEncrypt.length;
        fill_head(this._cmd);
        fill_body(bArrEncrypt, bArrEncrypt.length);
        set_length();
        return get_buf();
    }
}
