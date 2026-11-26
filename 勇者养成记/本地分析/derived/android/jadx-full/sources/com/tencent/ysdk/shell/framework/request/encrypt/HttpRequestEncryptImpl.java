package com.tencent.ysdk.shell.framework.request.encrypt;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class HttpRequestEncryptImpl implements com.tencent.ysdk.shell.framework.request.encrypt.IHttpRequestEncrypt {
    private static final java.lang.String DEFAULT_CHARSET = "UTF-8";
    public static final java.lang.String DEFAULT_IV = "Bp:W8_<+V)198lSG";
    public static final java.lang.String DEFAULT_KEY = "(M`PSw*'aS(]p#F";
    private static final int DEFAULT_KEY_LENGTH = 16;
    private static final java.lang.String TAG = "HttpRequestEncryptImpl";

    @Override // com.tencent.ysdk.shell.framework.request.encrypt.IHttpRequestEncrypt
    public java.lang.String encrypt(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return com.tencent.ysdk.libware.encrypt.HexUtils.bytes2HexStr(com.tencent.ysdk.shell.libware.encrypt.AESHelper.encrypt(com.tencent.ysdk.shell.libware.encrypt.MD5.toMD5(str + DEFAULT_KEY).toUpperCase().substring(0, 16).getBytes(DEFAULT_CHARSET), DEFAULT_IV.getBytes(DEFAULT_CHARSET), str2.getBytes(DEFAULT_CHARSET)));
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.libware.file.Logger.e(TAG, e);
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
            return "";
        }
    }
}
