package oicq.wlogin_sdk.devicelock;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f extends oicq.wlogin_sdk.devicelock.DevlockBase {
    public f() {
        this._msgType = oicq.wlogin_sdk.devicelock.DevlockBase.a.c;
    }

    public byte[] a(long j, long j2, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7) {
        oicq.wlogin_sdk.devicelock.TLV_QuerySig tLV_QuerySig = oicq.wlogin_sdk.devicelock.DevlockBase.rst.querySig;
        if (tLV_QuerySig.get_size() == 0) {
            tLV_QuerySig.set_data(new byte[0], 0);
        }
        byte[] bArrA = new oicq.wlogin_sdk.devicelock.g().a(j2, j3, bArr, bArr2, bArr3, bArr4, bArr5, bArr6);
        if (bArrA == null || bArrA.length == 0) {
            return new byte[0];
        }
        byte[] bArrA2 = null;
        if (bArr7 == null || bArr7.length <= 0) {
            oicq.wlogin_sdk.devicelock.TLV_SppKey tLV_SppKey = oicq.wlogin_sdk.devicelock.DevlockBase.rst.sppKey;
            if (tLV_SppKey != null && tLV_SppKey.get_data_len() > 0) {
                bArrA2 = oicq.wlogin_sdk.devicelock.DevlockBase.rst.sppKey.get_buf();
            }
        } else {
            bArrA2 = new oicq.wlogin_sdk.devicelock.n().a(bArr7);
        }
        if (bArrA2 == null || bArrA2.length == 0) {
            return new byte[0];
        }
        int i = tLV_QuerySig.get_size();
        int length = bArrA.length;
        int length2 = bArrA2.length;
        int i2 = i + 2;
        int i3 = i2 + length;
        byte[] bArr8 = new byte[i3 + length2];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr8, 0, 3);
        java.lang.System.arraycopy(tLV_QuerySig.get_buf(), 0, bArr8, 2, i);
        java.lang.System.arraycopy(bArrA, 0, bArr8, i2, length);
        java.lang.System.arraycopy(bArrA2, 0, bArr8, i3, length2);
        return _get_request(j, j2, bArr8);
    }
}
