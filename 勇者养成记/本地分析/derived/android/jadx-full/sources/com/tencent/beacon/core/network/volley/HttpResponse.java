package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class HttpResponse {
    private final java.io.InputStream mContent;
    private final int mContentLength;
    private final java.util.List mHeaders;
    private final int mStatusCode;

    public HttpResponse(int i, java.util.List list) {
        this(i, list, -1, null);
    }

    public HttpResponse(int i, java.util.List list, int i2, java.io.InputStream inputStream) {
        this.mStatusCode = i;
        this.mHeaders = list;
        this.mContentLength = i2;
        this.mContent = inputStream;
    }

    public final java.io.InputStream getContent() {
        return this.mContent;
    }

    public final int getContentLength() {
        return this.mContentLength;
    }

    public final java.util.List getHeaders() {
        return java.util.Collections.unmodifiableList(this.mHeaders);
    }

    public final int getStatusCode() {
        return this.mStatusCode;
    }
}
