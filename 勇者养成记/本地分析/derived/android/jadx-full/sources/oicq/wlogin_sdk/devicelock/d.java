package oicq.wlogin_sdk.devicelock;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d extends oicq.wlogin_sdk.devicelock.DevlockBase {
    public d() {
        this._msgType = oicq.wlogin_sdk.devicelock.DevlockBase.a.b;
    }

    public byte[] a(long j, long j2, long j3) {
        oicq.wlogin_sdk.devicelock.TLV_QuerySig tLV_QuerySig = oicq.wlogin_sdk.devicelock.DevlockBase.rst.querySig;
        oicq.wlogin_sdk.devicelock.l lVar = new oicq.wlogin_sdk.devicelock.l();
        lVar.a(j3);
        int i = tLV_QuerySig.get_size();
        int i2 = lVar.get_size();
        if (i == 0 || i2 == 0) {
            return new byte[0];
        }
        int i3 = i + 2;
        byte[] bArr = new byte[i3 + i2];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr, 0, 2);
        java.lang.System.arraycopy(tLV_QuerySig.get_buf(), 0, bArr, 2, i);
        java.lang.System.arraycopy(lVar.get_buf(), 0, bArr, i3, i2);
        return _get_request(j, j2, bArr);
    }
}
