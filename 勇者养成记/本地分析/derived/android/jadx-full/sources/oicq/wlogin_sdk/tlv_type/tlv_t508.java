package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t508 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public static boolean doFetch = true;
    public static int timeout = 1000;
    public static byte[] userBuf = new byte[0];

    public tlv_t508() {
        this._cmd = 1288;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public java.lang.Boolean verify() {
        try {
            try {
                java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(this._buf);
                byteBufferWrap.position(this._head_len);
                boolean z = true;
                if (byteBufferWrap.get() != 1) {
                    z = false;
                }
                doFetch = z;
                timeout = byteBufferWrap.getInt();
                byte[] bArr = new byte[byteBufferWrap.getShort()];
                userBuf = bArr;
                byteBufferWrap.get(bArr);
                if (timeout == 0) {
                    timeout = 1000;
                }
                if (userBuf == null) {
                    userBuf = new byte[0];
                }
                return java.lang.Boolean.TRUE;
            } catch (java.lang.Exception unused) {
                java.lang.Boolean bool = java.lang.Boolean.FALSE;
                if (timeout == 0) {
                    timeout = 1000;
                }
                if (userBuf == null) {
                    userBuf = new byte[0];
                }
                return bool;
            }
        } catch (java.lang.Throwable th) {
            if (timeout == 0) {
                timeout = 1000;
            }
            if (userBuf == null) {
                userBuf = new byte[0];
            }
            throw th;
        }
    }
}
