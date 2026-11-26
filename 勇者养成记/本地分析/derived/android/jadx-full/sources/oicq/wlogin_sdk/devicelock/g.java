package oicq.wlogin_sdk.devicelock;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g extends oicq.wlogin_sdk.devicelock.e {
    public g() {
        this._type = 2;
    }

    public byte[] a(long j, long j2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
        if (bArr == null || bArr2 == null || bArr3 == null || bArr4 == null || bArr5 == null || bArr6 == null) {
            return new byte[0];
        }
        int length = bArr.length + 10 + 2 + bArr2.length + 2 + bArr3.length + 2 + bArr4.length + 2 + bArr5.length + 2 + bArr6.length;
        int i = this._head_len;
        fill_head();
        fill_body(new byte[length], length);
        put_block(bArr6, put_block(bArr5, put_block(bArr4, put_block(bArr3, put_block(bArr2, put_block(bArr, put_int32((int) j2, put_int32((int) j, i))))))));
        return get_buf();
    }
}
