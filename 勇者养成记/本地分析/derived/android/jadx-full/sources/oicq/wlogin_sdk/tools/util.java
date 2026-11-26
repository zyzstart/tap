package oicq.wlogin_sdk.tools;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class util {
    public static final int ASYN_CHECK_IMAGE = 2;
    public static final int ASYN_CHECK_SMS = 4;
    public static final int ASYN_EXCEPTION = 11;
    public static final int ASYN_GET_A1_WITH_A1 = 6;
    public static final int ASYN_GET_ST_WITHOUT_PWD = 5;
    public static final int ASYN_GET_ST_WITH_PWD = 0;
    public static final int ASYN_QUICKLOG_WITH_PTSIG = 16;
    public static final int ASYN_QUICKLOG_WITH_QQSIG = 15;
    public static final int ASYN_QUICKLOG_WITH_QRSIG = 17;
    public static final int ASYN_REFLUSH_IMAGE = 1;
    public static final int ASYN_REFLUSH_SMS = 3;
    public static final int ASYN_REPORT = 7;
    public static final int ASYN_REPORT_ERROR = 8;
    public static final int ASYN_SMSLOGIN_CHECK = 12;
    public static final int ASYN_SMSLOGIN_REFRESH = 14;
    public static final int ASYN_SMSLOGIN_VERIFY = 13;
    public static final int ASYN_TRANSPORT = 9;
    public static final int ASYN_TRANSPORT_MSF = 10;
    public static final long BUILD_TIME = 1502965326;
    public static final int D = 2;
    private static java.text.SimpleDateFormat DAYFORMAT = null;
    public static final int E_A1_DECRYPT = -1014;
    public static final int E_A1_FORMAT = -1016;
    public static final int E_ADVANCE_NOTICE = 257;
    public static final int E_APK_CHK_ERR = -1021;
    public static final int E_BUFFER_OVERFLOW = -1023;
    public static final int E_DECRYPT = -1002;
    public static final int E_ENCODING = -1013;
    public static final int E_ENCRYPTION_METHOD = -1024;
    public static final int E_INPUT = -1017;
    public static final int E_LOGIN_THROUGH_QQ = -2001;
    public static final int E_LOGIN_THROUGH_WEB = -2000;
    public static final int E_NAME_INVALID = -1008;
    public static final int E_NEWST_DECRYPT = -1025;
    public static final int E_NO_KEY = -1004;
    public static final int E_NO_NETWORK = -1026;
    public static final int E_NO_REG_CMD = -1010;
    public static final int E_NO_RET = -1000;
    public static final int E_NO_TGTKEY = -1006;
    public static final int E_NO_UIN = -1003;
    public static final int E_PENDING = -1001;
    public static final int E_PK_LEN = -1009;
    public static final int E_PUSH_REG = -1011;
    public static final int E_RESOLVE_ADDR = -1007;
    public static final int E_SAVE_TICKET_ERROR = -1022;
    public static final int E_SHARE_SERVICE_EXCEPTION = -1020;
    public static final int E_SHARE_SERVICE_PARAM = -1019;
    public static final int E_SHARE_SERVICE_UNCHECK = -1018;
    public static final int E_SYSTEM = -1012;
    public static final int E_TLV_DECRYPT = -1015;
    public static final int E_TLV_VERIFY = -1005;
    public static final java.lang.String FILE_DIR = "wtlogin";
    private static int HONEYCOMB = 0;
    public static final int I = 1;
    public static oicq.wlogin_sdk.tools.LogCallBack LCB = null;
    public static boolean LOGCAT_OUT = false;
    public static final java.lang.String LOG_DIR = "tencent/wtlogin";
    public static int LOG_LEVEL = 1;
    public static int MAX_APPID = 65535;
    public static final int MAX_CONTENT_SIZE = 20480;
    public static final int MAX_FILE_SIZE = 524288;
    public static int MAX_NAME_LEN = 128;

    @android.annotation.SuppressLint({"NewApi"})
    private static int MODE_MULTI_PROCESS = 0;
    public static final java.lang.String SDK_VERSION = "6.0.0.2202";
    public static final int SSO_VERSION = 5;
    public static final long SVN_VER = 2202;
    public static final int S_BABYLH_EXPIRED = 116;
    public static final int S_GET_IMAGE = 2;
    public static final int S_GET_SMS = 160;
    public static final int S_LH_EXPIRED = 41;
    public static final int S_PWD_WRONG = 1;
    public static final int S_ROLL_BACK = 180;
    public static final int S_SEC_GUID = 204;
    public static final int S_SUCCESS = 0;
    public static final java.lang.String TAG = "wlogin_sdk";
    public static final int W = 0;
    static final char[] base64_encode_chars;
    static final char base64_pad_url = '_';
    static final short[] base64_reverse_table_url;
    private static boolean libwtecdh_loaded = false;
    public static boolean loadEncryptSo = true;
    public static java.lang.String logContent = "";

    static {
        MODE_MULTI_PROCESS = android.os.Build.VERSION.SDK_INT > 9 ? 4 : 0;
        HONEYCOMB = 11;
        base64_encode_chars = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        base64_reverse_table_url = new short[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 63, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    public static boolean ExistSDCard() {
        return android.os.Environment.getExternalStorageState().equals("mounted");
    }

    public static void LOGD(java.lang.String str) {
        try {
            if (LOG_LEVEL >= 2) {
                if (LCB != null) {
                    LCB.OnLog(str);
                } else if (LOGCAT_OUT) {
                    android.util.Log.d(TAG + getLineInfo(2), str);
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static void LOGD(java.lang.String str, java.lang.String str2) {
        try {
            if (LOG_LEVEL >= 2) {
                if (LCB != null) {
                    LCB.OnLog(str, str2);
                } else if (LOGCAT_OUT) {
                    android.util.Log.d(TAG + getLineInfo(2), str + ":" + str2);
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static void LOGI(java.lang.String str) {
        try {
            if (LOG_LEVEL >= 1) {
                if (LCB != null) {
                    LCB.OnLog(str);
                } else if (LOGCAT_OUT) {
                    android.util.Log.i(TAG + getLineInfo(2), str);
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static void LOGI(java.lang.String str, java.lang.String str2) {
        try {
            if (LOG_LEVEL >= 1) {
                if (LCB != null) {
                    LCB.OnLog(str);
                } else if (LOGCAT_OUT) {
                    android.util.Log.i(TAG + getLineInfo(2), str);
                }
                oicq.wlogin_sdk.tools.d.a(str, str2);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static void LOGW(java.lang.String str, java.lang.String str2) {
        try {
            if (LOG_LEVEL >= 0) {
                if (LCB != null) {
                    LCB.OnLog(str, str2);
                } else if (LOGCAT_OUT) {
                    android.util.Log.w(TAG + getLineInfo(2), str + ":" + str2);
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static void LOGW(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            if (LOG_LEVEL >= 0) {
                if (LCB != null) {
                    LCB.OnLog(str, str2);
                } else if (LOGCAT_OUT) {
                    android.util.Log.w(TAG + getLineInfo(2), str + ":" + str2);
                }
                oicq.wlogin_sdk.tools.d.a(str + ":" + str2, str3);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static byte[] RSADecrypt(byte[] bArr, java.security.Key key) {
        if (bArr != null && key != null) {
            try {
                javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, key);
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                if (length % 128 != 0) {
                    return null;
                }
                int length2 = 0;
                for (int i = 0; i < length / 128; i++) {
                    byte[] bArr3 = new byte[128];
                    java.lang.System.arraycopy(bArr, i * 128, bArr3, 0, 128);
                    byte[] bArrDoFinal = cipher.doFinal(bArr3);
                    java.lang.System.arraycopy(bArrDoFinal, 0, bArr2, length2, bArrDoFinal.length);
                    length2 += bArrDoFinal.length;
                }
                byte[] bArr4 = new byte[length2];
                java.lang.System.arraycopy(bArr2, 0, bArr4, 0, length2);
                return bArr4;
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    public static byte[] RSAEncrypt(byte[] bArr, java.security.Key key) {
        if (bArr != null && key != null) {
            try {
                javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, key);
                int length = bArr.length;
                double d = length / 117;
                java.lang.Double.isNaN(d);
                int iRound = (int) java.lang.Math.round(d + 0.5d);
                byte[] bArr2 = new byte[iRound * 128];
                int i = length;
                int i2 = 117;
                for (int i3 = 0; i3 < iRound; i3++) {
                    if (i < 117) {
                        i2 = i;
                    }
                    byte[] bArr3 = new byte[i2];
                    java.lang.System.arraycopy(bArr, i3 * 117, bArr3, 0, i2);
                    java.lang.System.arraycopy(cipher.doFinal(bArr3), 0, bArr2, 128 * i3, 128);
                    i -= i2;
                }
                return bArr2;
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    public static java.security.Key RSAPrivKeyFromJNI(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = {48, -126, 2, 117, 2, 1, 0, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 4, -126, 2, 95};
        int length = bArr.length - 607;
        bArr2[3] = (byte) (bArr2[3] + length);
        bArr2[25] = (byte) (bArr2[25] + length);
        byte[] bArr3 = new byte[bArr.length + 26];
        java.lang.System.arraycopy(bArr2, 0, bArr3, 0, 26);
        java.lang.System.arraycopy(bArr, 0, bArr3, 26, bArr.length);
        try {
            return java.security.KeyFactory.getInstance("RSA").generatePrivate(new java.security.spec.PKCS8EncodedKeySpec(bArr3));
        } catch (java.lang.Exception e) {
            printException(e, "");
            return null;
        }
    }

    public static byte[] RSAPrivKeyFromJava(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            byte[] encoded = java.security.KeyFactory.getInstance("RSA").generatePrivate(new java.security.spec.PKCS8EncodedKeySpec(bArr)).getEncoded();
            int length = encoded.length - 26;
            byte[] bArr2 = new byte[length];
            java.lang.System.arraycopy(encoded, 26, bArr2, 0, length);
            return bArr2;
        } catch (java.lang.Exception e) {
            printException(e, "");
            return null;
        }
    }

    public static java.security.Key RSAPubKeyFromJNI(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length + 22];
        java.lang.System.arraycopy(new byte[]{48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0}, 0, bArr2, 0, 22);
        java.lang.System.arraycopy(bArr, 0, bArr2, 22, bArr.length);
        try {
            return java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(bArr2));
        } catch (java.lang.Exception e) {
            printException(e, "");
            return null;
        }
    }

    public static byte[] RSAPubKeyFromJava(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            byte[] encoded = java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(bArr)).getEncoded();
            int length = encoded.length - 22;
            byte[] bArr2 = new byte[length];
            java.lang.System.arraycopy(encoded, 22, bArr2, 0, length);
            return bArr2;
        } catch (java.lang.Exception e) {
            printException(e, "");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] base64_decode_url(byte[] bArr, int i) {
        int i2;
        byte[] bArr2 = new byte[24];
        short s = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i - 1;
            if (i > 0) {
                int i7 = i3 + 1;
                s = bArr[i3];
                if (s != 0 && s != 95) {
                    if (s == 32) {
                        s = 42;
                    }
                    s = base64_reverse_table_url[s];
                    if (s >= 0) {
                        switch (i4 % 4) {
                            case 0:
                                bArr2[i5] = (byte) (s << 2);
                                break;
                            case 1:
                                i2 = i5 + 1;
                                bArr2[i5] = (byte) (bArr2[i5] | (s >> 4));
                                bArr2[i2] = (byte) ((s & 15) << 4);
                                i5 = i2;
                                break;
                            case 2:
                                i2 = i5 + 1;
                                bArr2[i5] = (byte) (bArr2[i5] | (s >> 2));
                                bArr2[i2] = (byte) ((s & 3) << 6);
                                i5 = i2;
                                break;
                            case 3:
                                i2 = i5 + 1;
                                bArr2[i5] = bArr2[i5] | s ? (byte) 1 : (byte) 0;
                                i5 = i2;
                                break;
                        }
                        i4++;
                    }
                    i3 = i7;
                    i = i6;
                }
            }
        }
        if (s == 95) {
            switch (i4 % 4) {
                case 0:
                case 1:
                    return null;
                case 2:
                    i5++;
                    break;
            }
            bArr2[i5] = 0;
        }
        return bArr2;
    }

    public static java.lang.String base64_encode(byte[] bArr) {
        char c;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i2 == length) {
                stringBuffer.append(base64_encode_chars[i3 >>> 2]);
                c = base64_encode_chars[(i3 & 3) << 4];
            } else {
                int i4 = i2 + 1;
                int i5 = bArr[i2] & 255;
                if (i4 == length) {
                    stringBuffer.append(base64_encode_chars[i3 >>> 2]);
                    stringBuffer.append(base64_encode_chars[((i3 & 3) << 4) | ((i5 & com.tencent.smtt.sdk.TbsListener.ErrorCode.TPATCH_VERSION_FAILED) >>> 4)]);
                    c = base64_encode_chars[(i5 & 15) << 2];
                } else {
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & 255;
                    stringBuffer.append(base64_encode_chars[i3 >>> 2]);
                    stringBuffer.append(base64_encode_chars[((i3 & 3) << 4) | ((i5 & com.tencent.smtt.sdk.TbsListener.ErrorCode.TPATCH_VERSION_FAILED) >>> 4)]);
                    stringBuffer.append(base64_encode_chars[((i5 & 15) << 2) | ((i7 & 192) >>> 6)]);
                    stringBuffer.append(base64_encode_chars[i7 & 63]);
                    i = i6;
                }
            }
            stringBuffer.append(c);
            break;
        }
        return stringBuffer.toString();
    }

    public static long buf_len(byte[] bArr) {
        if (bArr == null) {
            return 0L;
        }
        return bArr.length;
    }

    public static int buf_to_int16(byte[] bArr, int i) {
        return ((bArr[i] << 8) & android.support.v4.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) + ((bArr[i + 1] << 0) & 255);
    }

    public static int buf_to_int32(byte[] bArr, int i) {
        return ((bArr[i] << 24) & (-16777216)) + ((bArr[i + 1] << 16) & 16711680) + ((bArr[i + 2] << 8) & android.support.v4.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) + ((bArr[i + 3] << 0) & 255);
    }

    public static long buf_to_int64(byte[] bArr, int i) {
        return ((((long) bArr[i]) << 56) & (-72057594037927936L)) + 0 + ((((long) bArr[i + 1]) << 48) & 71776119061217280L) + ((((long) bArr[i + 2]) << 40) & 280375465082880L) + ((((long) bArr[i + 3]) << 32) & 1095216660480L) + ((((long) bArr[i + 4]) << 24) & 4278190080L) + ((((long) bArr[i + 5]) << 16) & 16711680) + ((((long) bArr[i + 6]) << 8) & 65280) + ((((long) bArr[i + 7]) << 0) & 255);
    }

    public static int buf_to_int8(byte[] bArr, int i) {
        return bArr[i] & 255;
    }

    public static java.lang.String buf_to_string(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        java.lang.String str = "";
        for (int i = 0; i < bArr.length; i++) {
            str = (str + java.lang.Integer.toHexString((bArr[i] >> 4) & 15)) + java.lang.Integer.toHexString(bArr[i] & 15);
        }
        return str;
    }

    public static java.lang.String buf_to_string(byte[] bArr, int i) {
        if (bArr == null) {
            return "";
        }
        if (i > bArr.length) {
            i = bArr.length;
        }
        java.lang.String str = "";
        for (int i2 = 0; i2 < i; i2++) {
            str = (str + java.lang.Integer.toHexString((bArr[i2] >> 4) & 15)) + java.lang.Integer.toHexString(bArr[i2] & 15);
        }
        return str;
    }

    public static java.lang.Boolean check_uin_account(java.lang.String str) {
        try {
            long j = java.lang.Long.parseLong(str);
            return (j < 10000 || j > 4000000000L) ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE;
        } catch (java.lang.NumberFormatException unused) {
            return java.lang.Boolean.FALSE;
        }
    }

    public static void chg_retry_type(android.content.Context context) {
        set_net_retry_type(context, get_net_retry_type(context) == 0 ? 1 : 0);
    }

    public static byte[] compress(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            java.util.zip.DeflaterOutputStream deflaterOutputStream = new java.util.zip.DeflaterOutputStream(byteArrayOutputStream);
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (java.io.IOException unused) {
            return new byte[0];
        }
    }

    public static long constructSalt() {
        return (((long) get_rand_32()) << 32) + ((long) get_rand_32());
    }

    public static void decompress(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        LOGI("data len:" + bArr.length);
        int i = 0;
        int i2 = 0;
        while (bArr.length > i + 3) {
            int iBuf_to_int32 = buf_to_int32(bArr, i);
            if (bArr.length <= i + iBuf_to_int32 + 3) {
                return;
            }
            byte[] bArr2 = new byte[iBuf_to_int32];
            int i3 = i + 4;
            java.lang.System.arraycopy(bArr, i3, bArr2, 0, iBuf_to_int32);
            i = i3 + iBuf_to_int32;
            i2++;
            LOGI("len:" + iBuf_to_int32);
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                java.util.zip.InflaterInputStream inflaterInputStream = new java.util.zip.InflaterInputStream(new java.io.ByteArrayInputStream(bArr2));
                byte[] bArr3 = new byte[1024];
                while (true) {
                    int i4 = inflaterInputStream.read(bArr3);
                    if (i4 == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr3, 0, i4);
                    }
                }
                LOGI(i2 + byteArrayOutputStream.toString());
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void deleteExpireFile(java.lang.String str, int i) {
        java.io.File[] fileArrListFiles;
        if (str == null || str.length() == 0) {
            return;
        }
        LOGI("file path:" + str);
        try {
            java.io.File file = new java.io.File(str);
            if (!file.isDirectory() || (fileArrListFiles = file.listFiles(new oicq.wlogin_sdk.tools.e())) == null) {
                return;
            }
            int length = fileArrListFiles.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!fileArrListFiles[i2].isDirectory() && (java.lang.System.currentTimeMillis() - fileArrListFiles[i2].lastModified()) / 1000 > i) {
                    fileArrListFiles[i2].delete();
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static void deleteExpireLog(android.content.Context context) {
        java.lang.String str;
        if (context == null) {
            return;
        }
        try {
            if (oicq.wlogin_sdk.request.t.at != null && oicq.wlogin_sdk.request.t.at.length() != 0) {
                str = oicq.wlogin_sdk.request.t.at;
            } else {
                if (!ExistSDCard()) {
                    deleteExpireFile(context.getFilesDir().getPath() + "/" + LOG_DIR, 259200);
                    return;
                }
                str = android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + LOG_DIR + "/" + context.getPackageName();
            }
            deleteExpireFile(str, 691200);
        } catch (java.lang.Exception unused) {
        }
    }

    public static int format_ret_code(int i) {
        if (i != -1006 && i != -1002) {
            if (i == -1000) {
                return 1;
            }
            if (i == 0) {
                return 0;
            }
            if (i == 2) {
                return 2;
            }
            switch (i) {
                case E_TLV_DECRYPT /* -1015 */:
                case E_A1_DECRYPT /* -1014 */:
                    break;
                default:
                    return 17;
            }
        }
        return 5;
    }

    public static byte[] generateGuid(android.content.Context context) {
        android.net.wifi.WifiInfo connectionInfo;
        byte[] bArr = oicq.wlogin_sdk.request.t.ai;
        if (bArr != null && bArr.length != 0) {
            LOGI("generate guid from customer guid");
            return oicq.wlogin_sdk.request.t.ai;
        }
        LOGI("generate guid temporarily");
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            java.lang.String macAddress = null;
            java.lang.String deviceId = telephonyManager != null ? telephonyManager.getDeviceId() : null;
            LOGI("imei " + deviceId, "");
            android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getSystemService("wifi");
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                macAddress = connectionInfo.getMacAddress();
            }
            LOGI("mac " + macAddress, "");
            java.lang.String str = "";
            if (deviceId != null) {
                str = "" + deviceId;
            }
            if (macAddress != null) {
                str = str + macAddress;
            }
            return str.length() <= 0 ? new byte[0] : oicq.wlogin_sdk.tools.MD5.toMD5Byte(str.getBytes());
        } catch (java.lang.Throwable unused) {
            return new byte[0];
        }
    }

    public static java.security.KeyPair generateRSAKeyPair() {
        try {
            java.security.KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            return keyPairGenerator.generateKeyPair();
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static byte[] getAppName(android.content.Context context) {
        java.lang.String string;
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            if (applicationInfo != null && (string = context.getPackageManager().getApplicationLabel(applicationInfo).toString()) != null) {
                return string.getBytes();
            }
        } catch (java.lang.Throwable unused) {
        }
        return new byte[0];
    }

    public static java.lang.String getChannelId(android.content.Context context, java.lang.String str) {
        long j;
        if (str == null || str.length() == 0) {
            str = context.getPackageName();
        }
        java.lang.String strGroup = "";
        try {
            java.lang.String str2 = context.getPackageManager().getPackageInfo(str, 0).applicationInfo.sourceDir;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("pkg ");
            sb.append(str);
            sb.append(" path ");
            sb.append(str2 == null ? "null" : str2);
            LOGI(sb.toString(), "");
            if (str2 != null && str2.length() != 0) {
                byte[] bArr = {80, 75, 5, 6};
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(str2);
                long jAvailable = fileInputStream.available();
                int iSkip = (int) (jAvailable - fileInputStream.skip(jAvailable - 256));
                byte[] bArr2 = new byte[iSkip];
                fileInputStream.read(bArr2);
                fileInputStream.close();
                int i = 0;
                while (true) {
                    if (i >= iSkip - 4) {
                        j = -1;
                        break;
                    }
                    if (bArr2[i] == bArr[0] && bArr2[i + 1] == bArr[1] && bArr2[i + 2] == bArr[2] && bArr2[i + 3] == bArr[3]) {
                        j = i;
                        break;
                    }
                    i++;
                }
                if (j == -1) {
                    return "";
                }
                int i2 = ((int) j) + 20;
                int i3 = bArr2[i2] + (bArr2[i2 + 1] << 8);
                if (i3 == 0) {
                    return "";
                }
                byte[] bArr3 = new byte[i3];
                java.lang.System.arraycopy(bArr2, (int) (j + 20), bArr3, 0, i3);
                java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("channelId=(\\S+)").matcher(new java.lang.String(bArr3));
                strGroup = matcher.find() ? matcher.group(1) : "";
                LOGI("found comment " + new java.lang.String(bArr3) + " channelId:" + strGroup, "");
                return strGroup;
            }
            return "";
        } catch (java.lang.Exception e) {
            printException(e, "");
        }
    }

    public static java.lang.String getCurrentDay() {
        try {
            if (DAYFORMAT == null) {
                DAYFORMAT = new java.text.SimpleDateFormat("yyyyMMdd");
            }
            return DAYFORMAT.format(new java.util.Date());
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String getDate() {
        try {
            return "[" + java.lang.System.currentTimeMillis() + "]";
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static long getFileModifyTime(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return 0L;
        }
        try {
            java.io.File file = new java.io.File(str);
            if (file.exists() && file.isFile()) {
                return file.lastModified();
            }
            return 0L;
        } catch (java.lang.Exception unused) {
            return 0L;
        }
    }

    public static int getFileSize(java.lang.String str) {
        try {
            java.io.File file = new java.io.File(str);
            if (file.exists() && file.isFile()) {
                return (int) file.length();
            }
            return 0;
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    public static byte[] getGuidFromFile(android.content.Context context) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream;
        byte[] bArr = oicq.wlogin_sdk.request.t.ai;
        if (bArr != null && bArr.length != 0) {
            LOGI("get guid from customer guid", "");
            return oicq.wlogin_sdk.request.t.ai;
        }
        LOGI("get guid from file", "");
        java.io.FileInputStream fileInputStream2 = null;
        if (context == null) {
            return null;
        }
        byte[] bArr2 = new byte[0];
        try {
            try {
                try {
                    java.io.File file = new java.io.File(context.getFilesDir().getAbsolutePath() + "/wlogin_device.dat");
                    if (file.exists()) {
                        fileInputStream = new java.io.FileInputStream(file);
                        try {
                            int iAvailable = fileInputStream.available();
                            if (iAvailable < 1024) {
                                bArr2 = new byte[iAvailable];
                                fileInputStream.read(bArr2);
                            }
                        } catch (java.lang.Exception e) {
                            e = e;
                            fileInputStream2 = fileInputStream;
                            oicq.wlogin_sdk.request.t.Y |= 65536;
                            printException(e, "");
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            if (bArr2.length <= 0) {
                                saveGuidToFile(context, bArr2);
                            }
                            return bArr2;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (java.io.IOException e2) {
                                    printException(e2, "");
                                }
                            }
                            throw th;
                        }
                    } else {
                        fileInputStream = null;
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } catch (java.io.IOException e3) {
                    printException(e3, "");
                }
            } catch (java.lang.Exception e4) {
                e = e4;
            }
            if (bArr2.length <= 0 && (bArr2 = get_saved_imei(context)) != null && bArr2.length > 0) {
                saveGuidToFile(context, bArr2);
            }
            return bArr2;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream = fileInputStream2;
        }
    }

    public static java.lang.String getLanguage(android.content.Context context) {
        java.lang.String country = context.getResources().getConfiguration().locale.getCountry();
        if (country.equals("CN")) {
            return "CN";
        }
        return country.equals("TW") ? "TW" : "EN";
    }

    public static java.lang.String getLineInfo(int i) {
        if (i < 0) {
            return "";
        }
        try {
            java.lang.StackTraceElement stackTraceElement = new java.lang.Throwable().getStackTrace()[i];
            return "[" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String getLogDir(android.content.Context context) {
        java.lang.String str = oicq.wlogin_sdk.request.t.at;
        if (str != null && str.length() != 0) {
            return oicq.wlogin_sdk.request.t.at;
        }
        try {
            if (!ExistSDCard()) {
                return context.getFilesDir().getPath() + "/" + LOG_DIR;
            }
            return android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + LOG_DIR + "/" + context.getPackageName();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String getLogFileName(android.content.Context context, java.lang.String str) {
        if (context == null || str == null || str.length() == 0) {
            return null;
        }
        return getLogDir(context) + "/wtlogin_" + str + ".log";
    }

    public static long getLogModifyTime(android.content.Context context, java.lang.String str) {
        if (context == null || str == null || str.length() == 0) {
            return 0L;
        }
        return getFileModifyTime(getLogFileName(context, str));
    }

    public static java.lang.String getMaskBytes(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return "null";
        }
        java.lang.String str = new java.lang.String(bArr);
        if (i + i2 > str.length()) {
            return "***";
        }
        return str.substring(0, i) + "***" + str.substring(str.length() - i2);
    }

    public static java.lang.String getMaskString(java.lang.String str, int i, int i2) {
        if (i + i2 > str.length()) {
            return "***";
        }
        return str.substring(0, i) + "***" + str.substring(str.length() - i2);
    }

    public static byte[] getPkgSigFromApkName(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo.signatures != null && packageInfo.signatures.length > 0 && packageInfo.signatures[0] != null) {
                return oicq.wlogin_sdk.tools.MD5.toMD5Byte(packageInfo.signatures[0].toByteArray());
            }
            return new byte[0];
        } catch (java.lang.Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] getRequestInitTime() {
        byte[] bArr = new byte[4];
        int64_to_buf32(bArr, 0, (java.lang.System.currentTimeMillis() / 1000) + oicq.wlogin_sdk.request.t.ac);
        return bArr;
    }

    public static java.lang.String getSdkVersion() {
        return "[5]";
    }

    public static java.lang.String getThreadId() {
        return "[" + java.lang.Thread.currentThread().getId() + "]";
    }

    public static java.lang.String getUser(java.lang.String str) {
        if (str == null) {
            return "[]";
        }
        return "[" + str + "]";
    }

    public static byte[] get_IMSI(android.content.Context context) {
        java.lang.String subscriberId;
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && (subscriberId = telephonyManager.getSubscriberId()) != null) {
                return subscriberId.getBytes();
            }
        } catch (java.lang.Throwable unused) {
        }
        return new byte[0];
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static byte[] get_android_id(android.content.Context context) {
        try {
            java.lang.String string = android.provider.Settings.Secure.getString(context.getContentResolver(), com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
            if (string != null) {
                return string.getBytes();
            }
        } catch (java.lang.Throwable unused) {
        }
        return new byte[0];
    }

    public static byte[] get_apk_id(android.content.Context context) {
        try {
            return context.getPackageName().getBytes();
        } catch (java.lang.Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] get_apk_v(android.content.Context context, java.lang.String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName.getBytes();
        } catch (java.lang.Throwable unused) {
            return new byte[0];
        }
    }

    public static java.lang.String get_apn_string(android.content.Context context) {
        java.lang.String extraInfo;
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return (activeNetworkInfo.getType() != 0 || (extraInfo = activeNetworkInfo.getExtraInfo()) == null) ? "wifi" : extraInfo;
        } catch (java.lang.Throwable unused) {
            return "wifi";
        }
    }

    public static byte[] get_bssid_addr(android.content.Context context) {
        android.net.wifi.WifiInfo connectionInfo;
        java.lang.String bssid;
        try {
            android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getSystemService("wifi");
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null && (bssid = connectionInfo.getBSSID()) != null) {
                return bssid.toLowerCase().getBytes();
            }
        } catch (java.lang.Throwable unused) {
        }
        return new byte[0];
    }

    public static byte get_char(byte b) {
        int i;
        if (b < 48 || b > 57) {
            byte b2 = 97;
            if (b < 97 || b > 102) {
                b2 = 65;
                if (b < 65 || b > 70) {
                    return (byte) 0;
                }
            }
            i = (b - b2) + 10;
        } else {
            i = b - 48;
        }
        return (byte) i;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00b1 A[DONT_GENERATE, PHI: r6
  0x00b1: PHI (r6v3 android.database.Cursor) = (r6v2 android.database.Cursor), (r6v4 android.database.Cursor) binds: [B:25:0x00af, B:19:0x00a4] A[DONT_GENERATE, DONT_INLINE]] */
    public static byte[] get_cp_pubkey(android.content.Context context, long j, long j2) {
        if (context == null) {
            return new byte[0];
        }
        android.database.Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(android.net.Uri.parse("content://oicq.wlogin_sdk.WloginProvider/rsa_pubkey"), new java.lang.String[]{"id", "appid", "subappid", "pubkey", "pubkey_md5"}, "appid=? and subappid=?", new java.lang.String[]{"" + j, "" + j2}, null);
            if (cursorQuery != null && cursorQuery.moveToNext()) {
                java.lang.String string = cursorQuery.getString(cursorQuery.getColumnIndex("pubkey"));
                if (oicq.wlogin_sdk.tools.MD5.toMD5(string).equals(cursorQuery.getString(cursorQuery.getColumnIndex("pubkey_md5")))) {
                    return string_to_buf(string);
                }
            }
        } catch (java.lang.Exception e) {
            printException(e, "");
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        return string_to_buf(oicq.wlogin_sdk.tools.RSACrypt.DEFAULT_PUB_KEY);
    }

    public static java.lang.String get_error_msg(int i) {
        return oicq.wlogin_sdk.tools.InternationMsg.a(i != -1000 ? oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_3 : oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_4);
    }

    public static byte[] get_imei_id(android.content.Context context) {
        java.lang.String deviceId;
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && (deviceId = telephonyManager.getDeviceId()) != null) {
                return deviceId.getBytes();
            }
        } catch (java.lang.Throwable unused) {
        }
        return new byte[0];
    }

    public static byte[] get_ksid(android.content.Context context) {
        byte[] bArr = new byte[0];
        try {
            return string_to_buf(context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("ksid", new java.lang.String("")));
        } catch (java.lang.Throwable unused) {
            return bArr;
        }
    }

    public static int get_last_flag(android.content.Context context) {
        try {
            return context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getInt("last_flag", 0);
        } catch (java.lang.Throwable unused) {
            return 0;
        }
    }

    public static byte[] get_last_guid(android.content.Context context) {
        byte[] bArrString_to_buf = new byte[0];
        try {
            bArrString_to_buf = string_to_buf(context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("last_guid", new java.lang.String("")));
        } catch (java.lang.Throwable unused) {
        }
        return (bArrString_to_buf == null || bArrString_to_buf.length <= 0) ? new byte[0] : bArrString_to_buf;
    }

    public static byte[] get_last_imei(android.content.Context context) {
        byte[] bArrString_to_buf = new byte[0];
        try {
            bArrString_to_buf = string_to_buf(context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("last_imei", new java.lang.String("")));
        } catch (java.lang.Throwable unused) {
        }
        return (bArrString_to_buf == null || bArrString_to_buf.length <= 0) ? new byte[0] : bArrString_to_buf;
    }

    public static byte[] get_last_mac(android.content.Context context) {
        byte[] bArrString_to_buf = new byte[0];
        try {
            bArrString_to_buf = string_to_buf(context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("last_mac", new java.lang.String("")));
        } catch (java.lang.Throwable unused) {
        }
        return (bArrString_to_buf == null || bArrString_to_buf.length <= 0) ? new byte[0] : bArrString_to_buf;
    }

    public static byte[] get_mac_addr(android.content.Context context) {
        android.net.wifi.WifiInfo connectionInfo;
        java.lang.String macAddress;
        try {
            android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getSystemService("wifi");
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null && (macAddress = connectionInfo.getMacAddress()) != null) {
                return macAddress.getBytes();
            }
        } catch (java.lang.Throwable unused) {
        }
        return new byte[0];
    }

    public static java.lang.String get_mpasswd() {
        try {
            java.lang.String str = "";
            for (byte b : java.security.SecureRandom.getSeed(16)) {
                str = str + java.lang.String.valueOf((char) (java.lang.Math.abs(b % 26) + (new java.util.Random().nextBoolean() ? 97 : 65)));
            }
            return str;
        } catch (java.lang.Throwable unused) {
            return "1234567890123456";
        }
    }

    public static int get_net_retry_type(android.content.Context context) {
        try {
            return context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getInt("netretry_type", 0);
        } catch (java.lang.Throwable unused) {
            return 0;
        }
    }

    public static int get_network_type(android.content.Context context) {
        int type;
        try {
            type = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType();
        } catch (java.lang.Throwable unused) {
            type = 0;
        }
        if (type == 0) {
            return 1;
        }
        return type == 1 ? 2 : 0;
    }

    public static byte[] get_os_type() {
        return "android".getBytes();
    }

    public static byte[] get_os_version() {
        return android.os.Build.VERSION.RELEASE.getBytes();
    }

    public static byte[] get_prand_16byte() {
        try {
            byte[] bArr = new byte[16];
            int32_to_buf(bArr, 0, (int) (java.lang.Math.random() * 2.147483647E9d));
            int32_to_buf(bArr, 4, (int) (java.lang.Math.random() * 2.147483647E9d));
            int32_to_buf(bArr, 8, (int) (java.lang.Math.random() * 2.147483647E9d));
            int32_to_buf(bArr, 12, (int) (java.lang.Math.random() * 2.147483647E9d));
            return oicq.wlogin_sdk.tools.MD5.toMD5Byte(bArr);
        } catch (java.lang.Throwable unused) {
            return new byte[16];
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    @android.annotation.TargetApi(4)
    public static java.lang.String get_proxy_ip() {
        return android.os.Build.VERSION.SDK_INT < HONEYCOMB ? android.net.Proxy.getDefaultHost() : java.lang.System.getProperty("http.proxyHost");
    }

    @android.annotation.SuppressLint({"NewApi", "NewApi"})
    @android.annotation.TargetApi(4)
    public static int get_proxy_port() {
        if (android.os.Build.VERSION.SDK_INT < HONEYCOMB) {
            return android.net.Proxy.getDefaultPort();
        }
        try {
            return java.lang.Integer.parseInt(java.lang.System.getProperty("http.proxyPort"));
        } catch (java.lang.NumberFormatException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static byte[] get_rand_16byte(java.security.SecureRandom secureRandom) {
        try {
            byte[] bArr = new byte[16];
            secureRandom.nextBytes(bArr);
            return bArr;
        } catch (java.lang.Throwable unused) {
            return get_prand_16byte();
        }
    }

    public static byte[] get_rand_16byte(byte[] bArr) {
        try {
            byte[] seed = java.security.SecureRandom.getSeed(16);
            byte[] bArr2 = new byte[seed.length + bArr.length];
            java.lang.System.arraycopy(seed, 0, bArr2, 0, seed.length);
            java.lang.System.arraycopy(bArr, 0, bArr2, seed.length, bArr.length);
            return oicq.wlogin_sdk.tools.MD5.toMD5Byte(bArr2);
        } catch (java.lang.Throwable unused) {
            return get_prand_16byte();
        }
    }

    public static int get_rand_32() {
        return (int) (java.lang.Math.random() * 2.147483647E9d);
    }

    public static java.lang.String get_release_time() {
        return "2017/08/17 18:22:06";
    }

    public static byte[] get_rsa_privkey(android.content.Context context) {
        byte[] bArrString_to_buf = new byte[0];
        try {
            bArrString_to_buf = string_to_buf(context.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getString("rsa_privkey", ""));
        } catch (java.lang.Throwable unused) {
        }
        return (bArrString_to_buf == null || bArrString_to_buf.length <= 0) ? new byte[0] : bArrString_to_buf;
    }

    public static byte[] get_rsa_pubkey(android.content.Context context) {
        byte[] bArrString_to_buf = new byte[0];
        try {
            bArrString_to_buf = string_to_buf(context.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getString("rsa_pubkey", ""));
        } catch (java.lang.Throwable unused) {
        }
        return (bArrString_to_buf == null || bArrString_to_buf.length <= 0) ? new byte[0] : bArrString_to_buf;
    }

    public static byte[] get_saved_imei(android.content.Context context) {
        byte[] bArr = new byte[0];
        try {
            return string_to_buf(context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("imei", new java.lang.String("")));
        } catch (java.lang.Throwable th) {
            printThrowable(th, "");
            return bArr;
        }
    }

    public static int get_saved_network_type(android.content.Context context) {
        try {
            return context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getInt(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_NEWWORK_TYPE, 0);
        } catch (java.lang.Throwable unused) {
            return 0;
        }
    }

    public static long get_server_cur_time() {
        return oicq.wlogin_sdk.request.t.g();
    }

    public static byte[] get_server_host1(android.content.Context context) {
        try {
            return context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("host1", "").getBytes();
        } catch (java.lang.Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] get_server_host2(android.content.Context context) {
        try {
            return context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("host2", "").getBytes();
        } catch (java.lang.Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] get_sim_operator_name(android.content.Context context) {
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            if (telephonyManager.getSimState() == 5) {
                return telephonyManager.getSimOperatorName().getBytes();
            }
        } catch (java.lang.Throwable unused) {
        }
        return new byte[0];
    }

    public static byte[] get_ssid_addr(android.content.Context context) {
        android.net.wifi.WifiInfo connectionInfo;
        java.lang.String ssid;
        try {
            android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getSystemService("wifi");
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null && (ssid = connectionInfo.getSSID()) != null) {
                return ssid.getBytes();
            }
        } catch (java.lang.Throwable unused) {
        }
        return new byte[0];
    }

    public static byte[] get_wap_server_host1(android.content.Context context) {
        try {
            return context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("wap-host1", "").getBytes();
        } catch (java.lang.Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] get_wap_server_host2(android.content.Context context) {
        try {
            return context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("wap-host2", "").getBytes();
        } catch (java.lang.Throwable unused) {
            return new byte[0];
        }
    }

    public static void int16_to_buf(byte[] bArr, int i, int i2) {
        bArr[i + 1] = (byte) (i2 >> 0);
        bArr[i + 0] = (byte) (i2 >> 8);
    }

    public static void int32_to_buf(byte[] bArr, int i, int i2) {
        bArr[i + 3] = (byte) (i2 >> 0);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 0] = (byte) (i2 >> 24);
    }

    public static void int64_to_buf(byte[] bArr, int i, long j) {
        bArr[i + 7] = (byte) (j >> 0);
        bArr[i + 6] = (byte) (j >> 8);
        bArr[i + 5] = (byte) (j >> 16);
        bArr[i + 4] = (byte) (j >> 24);
        bArr[i + 3] = (byte) (j >> 32);
        bArr[i + 2] = (byte) (j >> 40);
        bArr[i + 1] = (byte) (j >> 48);
        bArr[i + 0] = (byte) (j >> 56);
    }

    public static void int64_to_buf32(byte[] bArr, int i, long j) {
        bArr[i + 3] = (byte) (j >> 0);
        bArr[i + 2] = (byte) (j >> 8);
        bArr[i + 1] = (byte) (j >> 16);
        bArr[i + 0] = (byte) (j >> 24);
    }

    public static void int8_to_buf(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 >> 0);
    }

    public static boolean isFileExist(java.lang.String str) {
        try {
            return new java.io.File(str).exists();
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean isMQQExist(android.content.Context context) {
        if (context == null) {
            return false;
        }
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0);
            if (packageInfo == null) {
                return false;
            }
            java.lang.String str = packageInfo.versionName;
            if (str.compareTo("4.6.0") >= 0) {
                return true;
            }
            try {
                return java.lang.Integer.parseInt(str.substring(0, str.indexOf("."))) >= 10;
            } catch (java.lang.Exception e) {
                printException(e, "");
                return false;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static boolean isPackageExist(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return false;
        }
        try {
            LOGI(context.getPackageManager().getPackageInfo(str, 0).versionName, "");
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean is_wap_proxy_retry(android.content.Context context) {
        try {
            java.lang.String str = get_apn_string(context);
            if (str != null) {
                return str.equalsIgnoreCase("cmwap") || str.equalsIgnoreCase("uniwap") || str.equalsIgnoreCase("ctwap") || str.equalsIgnoreCase("3gwap");
            }
            return false;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static boolean is_wap_retry(android.content.Context context) {
        return get_net_retry_type(context) != 0;
    }

    public static boolean loadLibrary(java.lang.String str, android.content.Context context) {
        java.io.File file;
        boolean z = false;
        if (!loadEncryptSo || android.os.Build.VERSION.SDK_INT >= 23) {
            return false;
        }
        if (libwtecdh_loaded) {
            return true;
        }
        if (context != null && str != null && str.length() != 0) {
            try {
                file = new java.io.File(context.getFilesDir().getParent() + "/txlib/lib" + str + ".so");
                try {
                    if (!file.exists()) {
                        file = new java.io.File(context.getFilesDir().getParent() + "/lib/lib" + str + ".so");
                    }
                } catch (java.lang.Exception e) {
                    e = e;
                    printException(e);
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                file = null;
            }
            if (file != null && file.exists()) {
                try {
                    java.lang.System.load(file.getAbsolutePath());
                    z = true;
                } catch (java.lang.UnsatisfiedLinkError e3) {
                    LOGI("loadLibrary failed " + e3.getMessage(), "");
                }
            }
            if (!z) {
                try {
                    java.lang.System.loadLibrary(str);
                    z = true;
                } catch (java.lang.UnsatisfiedLinkError e4) {
                    LOGI("loadLibrary failed " + e4.getMessage(), "");
                }
            }
            libwtecdh_loaded = z;
            LOGI("libwtecdh loaded " + libwtecdh_loaded, "");
        }
        return z;
    }

    public static android.os.Bundle packBundle(byte[][] bArr) {
        android.os.Bundle bundle = new android.os.Bundle();
        if (bArr != null && bArr.length > 0) {
            bundle.putInt("len", bArr.length);
            for (int i = 0; i < bArr.length; i++) {
                bundle.putByteArray(java.lang.String.valueOf(i), bArr[i]);
            }
        }
        if (bundle.isEmpty()) {
            return null;
        }
        return bundle;
    }

    public static void printException(java.lang.Exception exc) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        java.io.PrintWriter printWriter = new java.io.PrintWriter((java.io.Writer) stringWriter, true);
        exc.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        LOGW("exception:", stringWriter.toString());
    }

    public static void printException(java.lang.Exception exc, java.lang.String str) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        java.io.PrintWriter printWriter = new java.io.PrintWriter((java.io.Writer) stringWriter, true);
        exc.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        LOGW("exception", stringWriter.toString(), str);
    }

    public static void printThrowable(java.lang.Throwable th, java.lang.String str) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        java.io.PrintWriter printWriter = new java.io.PrintWriter((java.io.Writer) stringWriter, true);
        th.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        LOGW("throwable", stringWriter.toString(), str);
    }

    public static byte[] readFile(java.lang.String str) {
        if (str != null && str.length() != 0) {
            try {
                java.io.File file = new java.io.File(str);
                if (file.exists() && file.isFile()) {
                    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(str);
                    int iAvailable = fileInputStream.available();
                    if (iAvailable > 528384) {
                        fileInputStream.close();
                        return null;
                    }
                    byte[] bArr = new byte[iAvailable];
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                    return bArr;
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    public static byte[] readLog(android.content.Context context, java.lang.String str) {
        if (context == null || str == null || str.length() == 0) {
            return null;
        }
        return readFile(getLogFileName(context, str));
    }

    public static void saveGuidToFile(android.content.Context context, byte[] bArr) throws java.lang.Throwable {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                java.io.File file = new java.io.File(context.getFilesDir().getAbsolutePath() + "/wlogin_device.dat");
                if (!file.exists()) {
                    file.createNewFile();
                }
                if (file.exists() && file.canWrite()) {
                    java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file, false);
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream = fileOutputStream2;
                    } catch (java.lang.Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        printException(e, "");
                        if (fileOutputStream == null) {
                            return;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException e2) {
                                printException(e2, "");
                            }
                        }
                        throw th;
                    }
                }
                save_imei(context, bArr);
                if (fileOutputStream == null) {
                    return;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
        }
        try {
            fileOutputStream.close();
        } catch (java.io.IOException e4) {
            printException(e4, "");
        }
    }

    public static void save_cur_flag(android.content.Context context, int i) {
        if (context != null) {
            android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
            editorEdit.putInt("last_flag", i);
            editorEdit.commit();
        }
    }

    public static void save_cur_guid(android.content.Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
        editorEdit.putString("last_guid", buf_to_string(bArr));
        editorEdit.commit();
    }

    public static void save_cur_imei(android.content.Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
        editorEdit.putString("last_imei", buf_to_string(bArr));
        editorEdit.commit();
    }

    public static void save_cur_mac(android.content.Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
        editorEdit.putString("last_mac", buf_to_string(bArr));
        editorEdit.commit();
    }

    public static void save_imei(android.content.Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
        editorEdit.putString("imei", buf_to_string(bArr));
        editorEdit.commit();
    }

    public static void save_network_type(android.content.Context context, int i) {
        if (context != null) {
            android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
            editorEdit.putInt(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_NEWWORK_TYPE, i);
            editorEdit.commit();
        }
    }

    public static void save_rsa_privkey(android.content.Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
        editorEdit.putString("rsa_privkey", buf_to_string(bArr));
        editorEdit.commit();
    }

    public static void save_rsa_pubkey(android.content.Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
        editorEdit.putString("rsa_pubkey", buf_to_string(bArr));
        editorEdit.commit();
    }

    public static boolean set_cp_pubkey(android.content.Context context, long j, long j2) {
        if (context == null) {
            return false;
        }
        android.content.ContentResolver contentResolver = context.getContentResolver();
        android.net.Uri uri = android.net.Uri.parse("content://oicq.wlogin_sdk.WloginProvider/rsa_pubkey");
        LOGI(uri.toString());
        android.database.Cursor cursor = null;
        try {
            try {
                android.database.Cursor cursorQuery = contentResolver.query(uri, new java.lang.String[]{"id", "appid", "subappid", "pubkey", "pubkey_md5"}, "appid=? and subappid=?", new java.lang.String[]{"" + j, "" + j2}, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return false;
                }
                java.lang.String strBuf_to_string = buf_to_string(get_rsa_pubkey(context));
                if (strBuf_to_string.length() == 0) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return false;
                }
                java.lang.String md5 = oicq.wlogin_sdk.tools.MD5.toMD5(strBuf_to_string);
                if (cursorQuery.getCount() > 0) {
                    android.content.ContentValues contentValues = new android.content.ContentValues();
                    contentValues.put("pubkey", strBuf_to_string);
                    contentValues.put("pubkey_md5", md5);
                    cursorQuery.moveToNext();
                } else {
                    android.content.ContentValues contentValues2 = new android.content.ContentValues();
                    contentValues2.put("appid", java.lang.Long.valueOf(j));
                    contentValues2.put("subappid", java.lang.Long.valueOf(j2));
                    contentValues2.put("pubkey", strBuf_to_string);
                    contentValues2.put("pubkey_md5", md5);
                    LOGD("inserted uri: " + contentResolver.insert(uri, contentValues2) + ", with appid=" + j + ", subappid=" + j2);
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return true;
            } catch (java.lang.Exception e) {
                printException(e, "");
                if (0 != 0) {
                    cursor.close();
                }
                return false;
            }
        } catch (java.lang.Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public static void set_ksid(android.content.Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        byte[] bArr2 = get_ksid(context);
        if (bArr2 == null || bArr2.length <= 0) {
            android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
            editorEdit.putString("ksid", buf_to_string(bArr));
            editorEdit.commit();
        }
    }

    public static void set_net_retry_type(android.content.Context context, int i) {
        if (context != null) {
            android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
            editorEdit.putInt("netretry_type", i);
            editorEdit.commit();
        }
    }

    public static void set_server_host1(android.content.Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
        editorEdit.putString("host1", new java.lang.String(bArr));
        editorEdit.commit();
    }

    public static void set_server_host2(android.content.Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
        editorEdit.putString("host2", new java.lang.String(bArr));
        editorEdit.commit();
    }

    public static void set_wap_server_host1(android.content.Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
        editorEdit.putString("wap-host1", new java.lang.String(bArr));
        editorEdit.commit();
    }

    public static void set_wap_server_host2(android.content.Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
        editorEdit.putString("wap-host2", new java.lang.String(bArr));
        editorEdit.commit();
    }

    public static boolean shouldKick(int i) {
        return (i == -1000 || i == 257 || i == -1026) ? false : true;
    }

    public static byte[] string_to_buf(java.lang.String str) {
        if (str == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((get_char((byte) str.charAt(i2)) << 4) + get_char((byte) str.charAt(i2 + 1)));
        }
        return bArr;
    }

    public static byte[][] unpackBundle(android.os.Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        int i = bundle.getInt("len");
        byte[][] bArr = (byte[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) byte.class, i, 0);
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = bundle.getByteArray(java.lang.String.valueOf(i2));
        }
        return bArr;
    }

    public static synchronized void writeFile(java.lang.String str, byte[] bArr) {
        java.io.File parentFile;
        if (str != null) {
            if (str.length() != 0) {
                try {
                    java.io.File file = new java.io.File(str);
                    if (!file.exists() && ((parentFile = file.getParentFile()) == null || (!parentFile.mkdirs() && !parentFile.isDirectory()))) {
                        return;
                    }
                    if (getFileSize(str) < 524288) {
                        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file, true);
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                    }
                } catch (java.lang.Exception unused) {
                }
            }
        }
    }
}
