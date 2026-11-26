package com.tencent.ysdk.shell.libware.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YSDKURLUtils {
    public static final java.lang.String HTTP_REQ_ENTITY_JOIN = "&";
    public static final java.lang.String HTTP_REQ_ENTITY_MERGE = "=";
    public static final java.lang.String HTTP_REQ_ENTITY_START = "?";

    /* JADX WARN: Code duplicated, block: B:22:0x0055  */
    public static java.lang.String encode(java.lang.String str) {
        int i;
        java.lang.String strEncode = "";
        try {
            strEncode = java.net.URLEncoder.encode(str, "UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(strEncode.length());
        int i2 = 0;
        while (i2 < strEncode.length()) {
            char cCharAt = strEncode.charAt(i2);
            if (cCharAt == '*') {
                stringBuffer.append("%2A");
            } else if (cCharAt == '+') {
                stringBuffer.append("%20");
            } else if (cCharAt == '%' && (i = i2 + 1) < strEncode.length() && strEncode.charAt(i) == '7') {
                int i3 = i2 + 2;
                if (strEncode.charAt(i3) == 'E') {
                    stringBuffer.append('~');
                    i2 = i3;
                } else {
                    stringBuffer.append(cCharAt);
                }
            } else {
                stringBuffer.append(cCharAt);
            }
            i2++;
        }
        return stringBuffer.toString();
    }

    public static java.lang.String getNoQueryUrl(java.lang.String str) {
        try {
            java.net.URL url = new java.net.URL(str);
            return new java.net.URL(url.getProtocol(), url.getHost(), url.getPort(), url.getPath()).toString();
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String getUrlEncodeValue(java.lang.String str) {
        if (str == null) {
            str = "";
        }
        return encode(str);
    }

    public static java.lang.String marge(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            return "";
        }
        if (str.contains(HTTP_REQ_ENTITY_START)) {
            str3 = str + "&";
        } else {
            str3 = str + HTTP_REQ_ENTITY_START;
        }
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str2)) {
            return str3;
        }
        return str3 + str2;
    }
}
