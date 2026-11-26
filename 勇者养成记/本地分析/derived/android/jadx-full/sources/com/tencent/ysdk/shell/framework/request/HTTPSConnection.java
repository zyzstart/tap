package com.tencent.ysdk.shell.framework.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class HTTPSConnection extends com.tencent.ysdk.shell.framework.request.BaseConnection {
    private javax.net.ssl.HttpsURLConnection mConn;

    public HTTPSConnection(java.lang.String str, final java.lang.String str2) {
        this.mConn = null;
        try {
            com.tencent.ysdk.shell.framework.request.MyX509TrustManager.getInstance();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        try {
            this.mConn = (javax.net.ssl.HttpsURLConnection) new java.net.URL(str).openConnection();
            this.mConn.setSSLSocketFactory(new com.tencent.ysdk.shell.framework.request.SNISSLSocketFactory(this.mConn));
            this.mConn.setRequestProperty("Host", str2);
            this.mConn.setHostnameVerifier(new javax.net.ssl.HostnameVerifier() { // from class: com.tencent.ysdk.shell.framework.request.HTTPSConnection.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(java.lang.String str3, javax.net.ssl.SSLSession sSLSession) {
                    return javax.net.ssl.HttpsURLConnection.getDefaultHostnameVerifier().verify(str2, sSLSession);
                }
            });
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.BaseConnection
    protected java.net.HttpURLConnection getURLConnection() {
        return this.mConn;
    }
}
