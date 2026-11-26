package com.pay.tool;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APMidasTools {
    static long lastClickTime;

    public static java.lang.String getCurrentThreadName(java.lang.Thread thread) {
        return thread.getName();
    }

    public static int getErrorCodeFromException(java.io.IOException iOException) {
        if (iOException instanceof java.io.CharConversionException) {
            return -20;
        }
        if (iOException instanceof java.nio.charset.MalformedInputException) {
            return -21;
        }
        if (iOException instanceof java.nio.charset.UnmappableCharacterException) {
            return -22;
        }
        if (iOException instanceof java.nio.channels.ClosedChannelException) {
            return -24;
        }
        if (iOException instanceof java.io.EOFException) {
            return -26;
        }
        if (iOException instanceof java.nio.channels.FileLockInterruptionException) {
            return -27;
        }
        if (iOException instanceof java.io.FileNotFoundException) {
            return -28;
        }
        if (iOException instanceof java.net.HttpRetryException) {
            return -29;
        }
        if (iOException instanceof org.apache.http.conn.ConnectTimeoutException) {
            return -7;
        }
        if (iOException instanceof java.net.SocketTimeoutException) {
            return -8;
        }
        if (iOException instanceof java.util.InvalidPropertiesFormatException) {
            return -30;
        }
        if (iOException instanceof java.net.MalformedURLException) {
            return -3;
        }
        if (iOException instanceof java.io.InvalidClassException) {
            return -33;
        }
        if (iOException instanceof java.io.InvalidObjectException) {
            return -34;
        }
        if (iOException instanceof java.io.NotActiveException) {
            return -35;
        }
        if (iOException instanceof java.io.NotSerializableException) {
            return -36;
        }
        if (iOException instanceof java.io.OptionalDataException) {
            return -37;
        }
        if (iOException instanceof java.io.StreamCorruptedException) {
            return -38;
        }
        if (iOException instanceof java.io.WriteAbortedException) {
            return -39;
        }
        if (iOException instanceof java.net.ProtocolException) {
            return -40;
        }
        if (iOException instanceof javax.net.ssl.SSLHandshakeException) {
            return -41;
        }
        if (iOException instanceof javax.net.ssl.SSLKeyException) {
            return -42;
        }
        if (iOException instanceof javax.net.ssl.SSLPeerUnverifiedException) {
            return -43;
        }
        if (iOException instanceof javax.net.ssl.SSLProtocolException) {
            return -44;
        }
        if (iOException instanceof java.net.BindException) {
            return -45;
        }
        if (iOException instanceof java.net.ConnectException) {
            return -46;
        }
        if (iOException instanceof java.net.NoRouteToHostException) {
            return -47;
        }
        if (iOException instanceof java.net.PortUnreachableException) {
            return -48;
        }
        if (iOException instanceof java.io.SyncFailedException) {
            return -49;
        }
        if (iOException instanceof java.io.UTFDataFormatException) {
            return -50;
        }
        if (iOException instanceof java.net.UnknownHostException) {
            return -51;
        }
        if (iOException instanceof java.net.UnknownServiceException) {
            return -52;
        }
        if (iOException instanceof java.io.UnsupportedEncodingException) {
            return -53;
        }
        return iOException instanceof java.util.zip.ZipException ? -54 : -2;
    }

    public static java.lang.String getSysServerDomain() {
        java.lang.String str = com.tencent.midas.api.APMidasPayAPI.env;
        if (str.equals(com.tencent.midas.api.APMidasPayAPI.ENV_DEV)) {
            return com.pay.http.APPluginUrlConf.UNIPAY_DEV_DOMAIN;
        }
        return str.equals(com.tencent.midas.api.APMidasPayAPI.ENV_TEST) ? com.pay.http.APPluginUrlConf.UNIPAY_SANDBOX_DOMAIN : "api.unipay.qq.com";
    }

    public static long getTimeInterval(long j, long j2) {
        return j2 - j;
    }

    public static java.lang.String getUUID() {
        try {
            return java.util.UUID.randomUUID().toString();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String getUrlParamsValue(java.lang.String str, java.lang.String str2) {
        java.lang.String[] strArrSplit = str.split("[?]");
        if (strArrSplit.length > 1 && strArrSplit[1] != null) {
            for (java.lang.String str3 : strArrSplit[1].split("[&]")) {
                java.lang.String[] strArrSplit2 = str3.split("[=]");
                java.lang.String str4 = (strArrSplit2.length <= 1 || strArrSplit2[0] == null) ? null : strArrSplit2[0];
                java.lang.String str5 = (strArrSplit2.length <= 1 || strArrSplit2[1] == null) ? null : strArrSplit2[1];
                if (str4 != null && str4.compareToIgnoreCase(str2) == 0) {
                    return str5;
                }
            }
        }
        return null;
    }

    public static boolean isFastClick() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (jCurrentTimeMillis - lastClickTime < 3000) {
            return true;
        }
        lastClickTime = jCurrentTimeMillis;
        return false;
    }

    public static java.lang.String map2UrlParams(java.util.HashMap map) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        try {
            for (java.util.Map.Entry entry : map.entrySet()) {
                stringBuffer.append((java.lang.String) entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append((java.lang.String) entry.getValue());
                stringBuffer.append("&");
            }
            if (!android.text.TextUtils.isEmpty(stringBuffer)) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        } catch (java.lang.Exception unused) {
        }
        return stringBuffer.toString();
    }

    public static java.lang.String urlDecode(java.lang.String str, int i) {
        java.lang.String str2 = "";
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.midas.comm.APLog.w("", "解码内容为空");
        } else {
            if (i <= 0) {
                return str;
            }
            int i2 = 0;
            while (i2 < i) {
                try {
                    str = java.net.URLDecoder.decode(str, com.unisound.b.f.b);
                } catch (java.lang.Exception e) {
                    com.tencent.midas.comm.APLog.i("urlEncode", e.toString());
                    str = str2;
                }
                i2++;
                str2 = str;
            }
        }
        return str2;
    }

    public static java.lang.String urlEncode(java.lang.String str, int i) {
        java.lang.String str2 = "";
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.midas.comm.APLog.i("urlEncode", "编码内容为空");
        } else {
            if (i <= 0) {
                return str;
            }
            int i2 = 0;
            while (i2 < i) {
                try {
                    str = java.net.URLEncoder.encode(str, com.unisound.b.f.b);
                } catch (java.lang.Exception e) {
                    com.tencent.midas.comm.APLog.i("urlEncode", e.toString());
                    str = str2;
                }
                i2++;
                str2 = str;
            }
        }
        return str2;
    }
}
