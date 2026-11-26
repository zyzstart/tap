package oicq.wlogin_sdk.devicelock;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends oicq.wlogin_sdk.devicelock.DevlockBase {
    public a() {
        this._msgType = oicq.wlogin_sdk.devicelock.DevlockBase.a.f1660a;
    }

    public byte[] a(long j, long j2, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
        byte[] bArrA = new oicq.wlogin_sdk.devicelock.g().a(j2, j3, bArr, bArr2, bArr3, bArr4, bArr5, bArr6);
        if (bArrA == null || bArrA.length == 0) {
            return new byte[0];
        }
        byte[] bArr7 = new byte[bArrA.length + 2];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr7, 0, 1);
        java.lang.System.arraycopy(bArrA, 0, bArr7, 2, bArrA.length);
        return _get_request(j, j2, bArr7);
    }
}
