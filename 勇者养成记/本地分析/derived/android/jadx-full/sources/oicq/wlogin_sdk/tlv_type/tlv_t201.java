package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t201 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public tlv_t201() {
        this._cmd = android.support.v4.view.InputDeviceCompat.SOURCE_DPAD;
    }

    public byte[] get_tlv_201(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        if (bArr4 == null) {
            bArr4 = new byte[0];
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length + 2 + 2 + bArr2.length + 2 + bArr3.length + 2 + bArr4.length;
        byte[] bArr5 = new byte[length];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr5, 0, bArr.length);
        java.lang.System.arraycopy(bArr, 0, bArr5, 2, bArr.length);
        int length2 = bArr.length + 2;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr5, length2, bArr2.length);
        int i = length2 + 2;
        java.lang.System.arraycopy(bArr2, 0, bArr5, i, bArr2.length);
        int length3 = i + bArr2.length;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr5, length3, bArr3.length);
        int i2 = length3 + 2;
        java.lang.System.arraycopy(bArr3, 0, bArr5, i2, bArr3.length);
        int length4 = i2 + bArr3.length;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr5, length4, bArr4.length);
        java.lang.System.arraycopy(bArr4, 0, bArr5, length4 + 2, bArr4.length);
        int length5 = bArr4.length;
        fill_head(this._cmd);
        fill_body(bArr5, length);
        set_length();
        return get_buf();
    }
}
