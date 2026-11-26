package com.tencent.ysdk.shell.framework.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class HTTPConnection extends com.tencent.ysdk.shell.framework.request.BaseConnection {
    private java.net.HttpURLConnection mConn;

    public HTTPConnection(java.lang.String str) {
        this.mConn = null;
        try {
            this.mConn = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.BaseConnection
    protected java.net.HttpURLConnection getURLConnection() {
        return this.mConn;
    }
}
