package oicq.wlogin_sdk.code2d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {
    public static int _seq = 0;
    public static oicq.wlogin_sdk.code2d.c _status = new oicq.wlogin_sdk.code2d.c();
    public static int _version = 50;
    public static final int reservedBufTypeClientType = 1;
    public static final int reservedBufTypeUin = 2;
    public int _role = 114;
    public int _cmd = 0;
    public int _sub_cmd = 0;
    public int _head_len = 43;
    public int stxLen = 1;
    public int ptDBPkgHeadLen = 28;
    public int ptCldPkgHeadLen = 14;

    protected int fill_staff(byte[] bArr, byte[] bArr2, int i) {
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr, i, bArr2.length);
        int i2 = i + 2;
        java.lang.System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
        return i2 + bArr2.length;
    }

    protected byte[] getAppInfo(long j, long j2) {
        byte[] bArr = new byte[oicq.wlogin_sdk.request.t.E.length + 2 + 2 + oicq.wlogin_sdk.request.t.G.length + 2 + oicq.wlogin_sdk.request.t.H.length + 28];
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr, 0, 5L);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr, 4, j);
        oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr, 8, j2);
        byte[] bArr2 = oicq.wlogin_sdk.request.t.A;
        java.lang.System.arraycopy(bArr2, 0, bArr, 12, bArr2.length);
        fill_staff(bArr, oicq.wlogin_sdk.request.t.H, fill_staff(bArr, oicq.wlogin_sdk.request.t.G, fill_staff(bArr, oicq.wlogin_sdk.request.t.E, oicq.wlogin_sdk.request.t.A.length + 12)));
        return bArr;
    }

    public int get_cmd() {
        return this._cmd;
    }

    protected byte[] get_request(long j, boolean z, byte[] bArr) {
        int length = this._head_len + bArr.length + 1;
        byte[] bArr2 = new byte[length];
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr2, 0, 2);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 1, length);
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 3, this._cmd);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr2, 26, 3);
        if (z) {
            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 27, 0);
        } else {
            oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 27, 1);
        }
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr2, 29, _version);
        int i = _seq;
        _seq = i + 1;
        oicq.wlogin_sdk.tools.util.int32_to_buf(bArr2, 31, i);
        oicq.wlogin_sdk.tools.util.int64_to_buf(bArr2, 35, j);
        java.lang.System.arraycopy(bArr, 0, bArr2, 43, bArr.length);
        oicq.wlogin_sdk.tools.util.int8_to_buf(bArr2, bArr.length + 43, 3);
        return bArr2;
    }

    protected byte[] get_response(byte[] bArr, int i) {
        int length = bArr.length;
        int i2 = this._head_len;
        if (length <= i2) {
            return null;
        }
        int length2 = bArr.length - i2;
        byte[] bArr2 = new byte[length2];
        java.lang.System.arraycopy(bArr, i2, bArr2, 0, length2);
        return bArr2;
    }
}
