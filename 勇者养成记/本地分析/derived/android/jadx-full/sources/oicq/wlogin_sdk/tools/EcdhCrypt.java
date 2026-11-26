package oicq.wlogin_sdk.tools;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class EcdhCrypt {
    public static final java.lang.String DEFAULT_PUB_KEY = "[REDACTED_HEX_CONSTANT]";
    public static final java.lang.String DEFAULT_SHARE_KEY = "[REDACTED_HEX_CONSTANT]";
    public static final java.lang.String S_PUB_KEY = "[REDACTED_HEX_CONSTANT]";
    public static final java.lang.String X509_S_PUB_KEY = "[REDACTED_HEX_CONSTANT]";
    private static boolean initFlg = false;
    public static java.security.PrivateKey pkcs8PrivateKey = null;
    private static boolean userOpenSSLLib = true;
    public static java.security.PublicKey x509PublicKey;
    public static byte[] _c_pub_key = new byte[0];
    public static byte[] _c_pri_key = new byte[0];
    private static byte[] _g_share_key = new byte[0];

    public EcdhCrypt(android.content.Context context) {
        oicq.wlogin_sdk.tools.util.loadLibrary("wtecdh", context);
    }

    private byte[] calShareKeyByBouncycastle(byte[] bArr) {
        try {
            java.lang.String str = bArr.length < 30 ? "[REDACTED_HEX_CONSTANT]" : "[REDACTED_HEX_CONSTANT]";
            java.security.PublicKey publicKeyConstructX509PublicKey = constructX509PublicKey(str + oicq.wlogin_sdk.tools.util.buf_to_string(bArr));
            oicq.wlogin_sdk.tools.util.LOGI("raw public key " + oicq.wlogin_sdk.tools.util.buf_to_string(_c_pub_key), "");
            oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + pkcs8PrivateKey.toString(), "[REDACTED]");
            javax.crypto.KeyAgreement keyAgreement = javax.crypto.KeyAgreement.getInstance("ECDH", "BC");
            keyAgreement.init(pkcs8PrivateKey);
            keyAgreement.doPhase(publicKeyConstructX509PublicKey, true);
            byte[] bArrGenerateSecret = keyAgreement.generateSecret();
            byte[] mD5Byte = oicq.wlogin_sdk.tools.MD5.toMD5Byte(bArrGenerateSecret);
            oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_to_string(bArrGenerateSecret), "[REDACTED]");
            oicq.wlogin_sdk.tools.util.LOGI("share key md5 " + oicq.wlogin_sdk.tools.util.buf_to_string(mD5Byte), "");
            return mD5Byte;
        } catch (java.lang.Exception e) {
            oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + pkcs8PrivateKey.toString() + "[REDACTED]" + oicq.wlogin_sdk.tools.util.buf_to_string(bArr), "[REDACTED]");
            oicq.wlogin_sdk.tools.util.printException(e);
            oicq.wlogin_sdk.request.t.an.attr_api(2459818);
            return null;
        } catch (java.lang.ExceptionInInitializerError e2) {
            oicq.wlogin_sdk.tools.util.LOGW("create key failed ExceptionInInitializerError, " + e2.getMessage(), "");
            oicq.wlogin_sdk.request.t.an.attr_api(2459818);
            return null;
        }
    }

    private byte[] calShareKeyByOpenSSL(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        oicq.wlogin_sdk.tools.util.LOGI("calShareKeyByOpenSSL publickey " + str2, "");
        if (GenECDHKeyEx(str3, str2, str) == 0) {
            return _g_share_key;
        }
        oicq.wlogin_sdk.request.t.an.attr_api(2461268);
        return null;
    }

    private java.security.PublicKey constructX509PublicKey(java.lang.String str) {
        oicq.wlogin_sdk.tools.util.LOGI("constructX509PublicKey publickey " + str + " at " + oicq.wlogin_sdk.request.t.l(), "");
        return java.security.KeyFactory.getInstance("EC", "BC").generatePublic(new java.security.spec.X509EncodedKeySpec(oicq.wlogin_sdk.tools.util.string_to_buf(str)));
    }

    private int initShareKeyByBouncycastle() {
        try {
            java.security.KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance("EC", "BC");
            keyPairGenerator.initialize(new java.security.spec.ECGenParameterSpec("secp192k1"));
            java.security.KeyPair keyPairGenKeyPair = keyPairGenerator.genKeyPair();
            java.security.PublicKey publicKey = keyPairGenKeyPair.getPublic();
            byte[] encoded = publicKey.getEncoded();
            java.security.PrivateKey privateKey = keyPairGenKeyPair.getPrivate();
            privateKey.getEncoded();
            java.security.PublicKey publicKeyConstructX509PublicKey = constructX509PublicKey(X509_S_PUB_KEY);
            javax.crypto.KeyAgreement keyAgreement = javax.crypto.KeyAgreement.getInstance("ECDH", "BC");
            keyAgreement.init(privateKey);
            keyAgreement.doPhase(publicKeyConstructX509PublicKey, true);
            _g_share_key = oicq.wlogin_sdk.tools.MD5.toMD5Byte(keyAgreement.generateSecret());
            byte[] bArr = new byte[49];
            _c_pub_key = bArr;
            java.lang.System.arraycopy(encoded, 23, bArr, 0, 49);
            x509PublicKey = publicKey;
            pkcs8PrivateKey = privateKey;
            oicq.wlogin_sdk.tools.util.LOGI("initShareKeyByBouncycastle OK", "");
            return 0;
        } catch (java.lang.Exception e) {
            oicq.wlogin_sdk.tools.util.LOGI("initShareKeyByBouncycastle failed, ", "");
            oicq.wlogin_sdk.tools.util.printException(e);
            oicq.wlogin_sdk.request.t.an.attr_api(2368735);
            return -2;
        } catch (java.lang.ExceptionInInitializerError e2) {
            oicq.wlogin_sdk.tools.util.LOGW("create key pair and shared key failed ExceptionInInitializerError, " + e2.getMessage(), "");
            oicq.wlogin_sdk.request.t.an.attr_api(2368735);
            return -1;
        }
    }

    private int initShareKeyByOpenSSL() {
        byte[] bArr;
        byte[] bArr2;
        if (android.os.Build.VERSION.SDK_INT >= 23 || GenereateKey() != 0) {
            return -1;
        }
        byte[] bArr3 = _c_pub_key;
        if (bArr3 != null && bArr3.length != 0 && (bArr = _c_pri_key) != null && bArr.length != 0 && (bArr2 = _g_share_key) != null && bArr2.length != 0) {
            oicq.wlogin_sdk.tools.util.LOGI("initShareKeyByOpenSSL OK", "");
            return 0;
        }
        oicq.wlogin_sdk.tools.util.LOGI("_c_pub_key " + oicq.wlogin_sdk.tools.util.buf_to_string(_c_pub_key), "");
        oicq.wlogin_sdk.tools.util.LOGI("_c_pri_key " + oicq.wlogin_sdk.tools.util.buf_to_string(_c_pri_key), "");
        oicq.wlogin_sdk.tools.util.LOGI("_g_share_key " + oicq.wlogin_sdk.tools.util.buf_to_string(_g_share_key), "");
        oicq.wlogin_sdk.tools.util.LOGI("initShareKeyByOpenSSL generate null key", "");
        return -2;
    }

    public native int GenECDHKeyEx(java.lang.String str, java.lang.String str2, java.lang.String str3);

    public int GenereateKey() {
        int iGenECDHKeyEx;
        try {
            synchronized (oicq.wlogin_sdk.tools.EcdhCrypt.class) {
                iGenECDHKeyEx = GenECDHKeyEx(S_PUB_KEY, "", "");
            }
            return iGenECDHKeyEx;
        } catch (java.lang.Error e) {
            oicq.wlogin_sdk.tools.util.LOGI("GenereateKey failed " + e.getMessage(), "");
            return -4;
        } catch (java.lang.RuntimeException e2) {
            oicq.wlogin_sdk.tools.util.LOGW("OpenSSL generate key failed, turn another method " + e2.getMessage(), "");
            return -2;
        } catch (java.lang.Exception e3) {
            oicq.wlogin_sdk.tools.util.LOGI("GenereateKey failed " + e3.getMessage(), "");
            return -3;
        } catch (java.lang.UnsatisfiedLinkError e4) {
            oicq.wlogin_sdk.tools.util.LOGI("GenereateKey failed " + e4.getMessage(), "");
            return -1;
        }
    }

    public byte[] calShareKeyMd5ByPeerPublicKey(byte[] bArr) {
        oicq.wlogin_sdk.tools.util.LOGI("userOpenSSLLib " + userOpenSSLLib + " peerRawPublicKey " + oicq.wlogin_sdk.tools.util.buf_to_string(bArr) + " at " + oicq.wlogin_sdk.request.t.l(), "");
        return true == userOpenSSLLib ? calShareKeyByOpenSSL(oicq.wlogin_sdk.tools.util.buf_to_string(_c_pri_key), oicq.wlogin_sdk.tools.util.buf_to_string(_c_pub_key), oicq.wlogin_sdk.tools.util.buf_to_string(bArr)) : calShareKeyByBouncycastle(bArr);
    }

    public byte[] get_c_pub_key() {
        return (byte[]) _c_pub_key.clone();
    }

    public byte[] get_g_share_key() {
        return (byte[]) _g_share_key.clone();
    }

    public int initShareKey() {
        if (true == initFlg) {
            return 0;
        }
        initFlg = true;
        if (initShareKeyByOpenSSL() == 0) {
            userOpenSSLLib = true;
            return 0;
        }
        if (initShareKeyByBouncycastle() != 0) {
            return initShareKeyByDefault();
        }
        userOpenSSLLib = false;
        return 0;
    }

    public int initShareKeyByDefault() {
        _c_pub_key = oicq.wlogin_sdk.tools.util.string_to_buf(DEFAULT_PUB_KEY);
        _g_share_key = oicq.wlogin_sdk.tools.util.string_to_buf(DEFAULT_SHARE_KEY);
        oicq.wlogin_sdk.tools.util.LOGI("initShareKeyByDefault OK", "");
        return 0;
    }

    public void set_c_pri_key(byte[] bArr) {
        _c_pri_key = bArr != null ? (byte[]) bArr.clone() : new byte[0];
    }

    public void set_c_pub_key(byte[] bArr) {
        _c_pub_key = bArr != null ? (byte[]) bArr.clone() : new byte[0];
    }

    public void set_g_share_key(byte[] bArr) {
        _g_share_key = bArr != null ? (byte[]) bArr.clone() : new byte[0];
    }
}
