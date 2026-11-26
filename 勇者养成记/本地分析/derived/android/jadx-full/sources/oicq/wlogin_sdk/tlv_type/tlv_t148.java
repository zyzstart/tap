package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t148 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public tlv_t148() {
        this._cmd = com.tencent.smtt.sdk.TbsListener.ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT;
    }

    public byte[] get_tlv_148(byte[] bArr, long j, long j2, long j3, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = bArr == null ? new byte[0] : bArr;
        byte[] bArr5 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArr6 = bArr3 == null ? new byte[0] : bArr3;
        int iLimit_len = limit_len(bArr4, 32);
        int iLimit_len2 = limit_len(bArr5, 32);
        int iLimit_len3 = limit_len(bArr6, 32);
        int i = iLimit_len + 2;
        int i2 = i + 4;
        int i3 = i2 + 4;
        int i4 = i3 + 4;
        int i5 = i4 + 2;
        int i6 = i5 + iLimit_len2;
        int i7 = i6 + 2;
        int i8 = i7 + iLimit_len3;
        byte[] bArr7 = new byte[i8];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr7, 0, iLimit_len);
        java.lang.System.arraycopy(bArr4, 0, bArr7, 2, iLimit_len);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr7, i, j);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr7, i2, j2);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr7, i3, j3);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr7, i4, iLimit_len2);
        java.lang.System.arraycopy(bArr5, 0, bArr7, i5, iLimit_len2);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr7, i6, iLimit_len3);
        java.lang.System.arraycopy(bArr6, 0, bArr7, i7, iLimit_len3);
        fill_head(this._cmd);
        fill_body(bArr7, i8);
        set_length();
        return get_buf();
    }
}
