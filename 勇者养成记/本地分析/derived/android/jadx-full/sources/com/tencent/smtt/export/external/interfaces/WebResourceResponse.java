package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WebResourceResponse {
    private java.lang.String mEncoding;
    private java.io.InputStream mInputStream;
    private java.lang.String mMimeType;
    private java.lang.String mReasonPhrase;
    private java.util.Map mResponseHeaders;
    private int mStatusCode;

    public WebResourceResponse() {
    }

    public WebResourceResponse(java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.util.Map map, java.io.InputStream inputStream) {
        this(str, str2, inputStream);
        setStatusCodeAndReasonPhrase(i, str3);
        setResponseHeaders(map);
    }

    public WebResourceResponse(java.lang.String str, java.lang.String str2, java.io.InputStream inputStream) {
        this.mMimeType = str;
        this.mEncoding = str2;
        setData(inputStream);
    }

    public java.io.InputStream getData() {
        return this.mInputStream;
    }

    public java.lang.String getEncoding() {
        return this.mEncoding;
    }

    public java.lang.String getMimeType() {
        return this.mMimeType;
    }

    public java.lang.String getReasonPhrase() {
        return this.mReasonPhrase;
    }

    public java.util.Map getResponseHeaders() {
        return this.mResponseHeaders;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public void setData(java.io.InputStream inputStream) {
        this.mInputStream = inputStream;
    }

    public void setEncoding(java.lang.String str) {
        this.mEncoding = str;
    }

    public void setMimeType(java.lang.String str) {
        this.mMimeType = str;
    }

    public void setResponseHeaders(java.util.Map map) {
        this.mResponseHeaders = map;
    }

    public void setStatusCodeAndReasonPhrase(int i, java.lang.String str) {
        this.mStatusCode = i;
        this.mReasonPhrase = str;
    }
}
