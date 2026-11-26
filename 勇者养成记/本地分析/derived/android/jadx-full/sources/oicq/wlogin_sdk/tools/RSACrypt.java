package oicq.wlogin_sdk.tools;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class RSACrypt {
    protected static final java.lang.String DEFAULT_PRIV_KEY = "[REDACTED_HEX_CONSTANT]";
    public static final java.lang.String DEFAULT_PUB_KEY = "[REDACTED_HEX_CONSTANT]";
    private android.content.Context _context;
    private byte[] _pub_key = new byte[0];
    private byte[] _priv_key = new byte[0];

    public RSACrypt(android.content.Context context) {
        this._context = context;
        try {
            oicq.wlogin_sdk.tools.util.loadLibrary("wtecdh", context);
        } catch (java.lang.UnsatisfiedLinkError unused) {
        }
    }

    private native byte[] decryptdata(byte[] bArr, byte[] bArr2);

    private native byte[] encryptdata(byte[] bArr, byte[] bArr2);

    private native int genrsakey();

    public byte[] DecryptData(byte[] bArr, byte[] bArr2) {
        byte[] bArrDecryptdata = null;
        if (bArr2 == null) {
            return null;
        }
        if (bArr == null && ((bArr = oicq.wlogin_sdk.tools.util.get_rsa_privkey(this._context)) == null || bArr.length == 0)) {
            bArr = oicq.wlogin_sdk.tools.util.string_to_buf(DEFAULT_PRIV_KEY);
        }
        try {
            bArrDecryptdata = decryptdata(bArr, bArr2);
            if (bArrDecryptdata == null || bArrDecryptdata.length == 0) {
                bArrDecryptdata = decryptdata(oicq.wlogin_sdk.tools.util.string_to_buf(DEFAULT_PRIV_KEY), bArr2);
            }
        } catch (java.lang.UnsatisfiedLinkError unused) {
        }
        if (bArrDecryptdata != null) {
            return bArrDecryptdata;
        }
        try {
            byte[] bArrRSADecrypt = oicq.wlogin_sdk.tools.util.RSADecrypt(bArr2, oicq.wlogin_sdk.tools.util.RSAPrivKeyFromJNI(bArr));
            return (bArrRSADecrypt == null || bArrRSADecrypt.length == 0) ? oicq.wlogin_sdk.tools.util.RSADecrypt(bArr2, oicq.wlogin_sdk.tools.util.RSAPrivKeyFromJNI(oicq.wlogin_sdk.tools.util.string_to_buf(DEFAULT_PRIV_KEY))) : bArrRSADecrypt;
        } catch (java.lang.Exception unused2) {
            return bArrDecryptdata;
        }
    }

    public byte[] EncryptData(byte[] bArr, byte[] bArr2) {
        byte[] bArrEncryptdata = null;
        if (bArr == null || bArr2 == null) {
            return null;
        }
        try {
            bArrEncryptdata = encryptdata(bArr, bArr2);
        } catch (java.lang.UnsatisfiedLinkError unused) {
        }
        return bArrEncryptdata == null ? oicq.wlogin_sdk.tools.util.RSAEncrypt(bArr2, oicq.wlogin_sdk.tools.util.RSAPubKeyFromJNI(bArr)) : bArrEncryptdata;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x00df */
    /* JADX WARN: Code duplicated, block: B:111:0x0162 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x015e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x015f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0190 A[Catch: all -> 0x01ac, TryCatch #8 {, blocks: (B:84:0x0162, B:86:0x0170, B:89:0x0175, B:91:0x0178, B:92:0x018c, B:94:0x01aa, B:93:0x0190), top: B:111:0x0162 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int GenRSAKey() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: oicq.wlogin_sdk.tools.RSACrypt.GenRSAKey():int");
    }

    public byte[] get_priv_key() {
        return this._priv_key;
    }

    public byte[] get_pub_key() {
        return this._pub_key;
    }

    public void set_priv_key(byte[] bArr) {
        this._priv_key = bArr;
    }

    public void set_pub_key(byte[] bArr) {
        this._pub_key = bArr;
    }
}
