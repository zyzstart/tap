package com.tencent.ysdk.shell.framework.request.encrypt;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class HttpRequestEncryptFactory {
    private static com.tencent.ysdk.shell.framework.request.encrypt.IHttpRequestEncrypt sEncrypt;

    private HttpRequestEncryptFactory() {
    }

    public static com.tencent.ysdk.shell.framework.request.encrypt.IHttpRequestEncrypt getHttpRequestEncrypt() {
        com.tencent.ysdk.shell.framework.request.encrypt.IHttpRequestEncrypt iHttpRequestEncrypt = sEncrypt;
        if (iHttpRequestEncrypt != null) {
            return iHttpRequestEncrypt;
        }
        synchronized (com.tencent.ysdk.shell.framework.request.encrypt.HttpRequestEncryptFactory.class) {
            if (sEncrypt == null) {
                sEncrypt = new com.tencent.ysdk.shell.framework.request.encrypt.HttpRequestEncryptImpl();
            }
        }
        return sEncrypt;
    }
}
