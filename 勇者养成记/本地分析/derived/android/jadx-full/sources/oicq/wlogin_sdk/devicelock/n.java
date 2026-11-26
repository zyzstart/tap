package oicq.wlogin_sdk.devicelock;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class n extends oicq.wlogin_sdk.devicelock.e {
    public n() {
        this._type = 7;
    }

    public byte[] a(byte[] bArr) {
        if (bArr == null) {
            return new byte[0];
        }
        int length = bArr.length + 2;
        fill_head();
        fill_body(new byte[length], length);
        put_block(bArr, this._head_len);
        return get_buf();
    }
}
