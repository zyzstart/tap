package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t400 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    int _version = 1;
    int _t400_body_len = 0;

    public tlv_t400() {
        this._cmd = 1024;
    }

    public byte[] get_tlv_400(byte[] bArr, long j, byte[] bArr2, byte[] bArr3, long j2, long j3, byte[] bArr4) {
        if (bArr == null) {
            bArr = new byte[16];
        }
        if (bArr2 == null) {
            bArr2 = new byte[16];
        }
        if (bArr3 == null) {
            bArr3 = new byte[16];
        }
        if (bArr4 == null) {
            bArr4 = new byte[8];
        }
        int length = bArr2.length + 10 + bArr3.length + 4 + 4 + 4 + bArr4.length;
        this._t400_body_len = length;
        byte[] bArr5 = new byte[length];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr5, 0, this._version);
        oicq.wlogin_sdk.tools.util.int64_to_buf(bArr5, 2, j);
        java.lang.System.arraycopy(bArr2, 0, bArr5, 10, bArr2.length);
        int length2 = bArr2.length + 10;
        java.lang.System.arraycopy(bArr3, 0, bArr5, length2, bArr3.length);
        int length3 = length2 + bArr3.length;
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr5, length3, (int) j2);
        int i = length3 + 4;
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr5, i, (int) j3);
        int i2 = i + 4;
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr5, i2, oicq.wlogin_sdk.tools.util.get_server_cur_time());
        java.lang.System.arraycopy(bArr4, 0, bArr5, i2 + 4, bArr4.length);
        int length4 = bArr4.length;
        byte[] bArrEncrypt = oicq.wlogin_sdk.tools.cryptor.encrypt(bArr5, 0, length, bArr);
        this._t400_body_len = bArrEncrypt.length;
        fill_head(this._cmd);
        fill_body(bArrEncrypt, bArrEncrypt.length);
        set_length();
        return get_buf();
    }
}
