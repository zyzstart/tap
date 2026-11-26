package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class UrlRequest {

    public static abstract class Builder {
        public static final int REQUEST_PRIORITY_HIGHEST = 4;
        public static final int REQUEST_PRIORITY_IDLE = 0;
        public static final int REQUEST_PRIORITY_LOW = 2;
        public static final int REQUEST_PRIORITY_LOWEST = 1;
        public static final int REQUEST_PRIORITY_MEDIUM = 3;

        public abstract com.tencent.smtt.export.external.interfaces.UrlRequest.Builder addHeader(java.lang.String str, java.lang.String str2);

        public abstract com.tencent.smtt.export.external.interfaces.UrlRequest build();

        public abstract com.tencent.smtt.export.external.interfaces.UrlRequest.Builder disableCache();

        public abstract com.tencent.smtt.export.external.interfaces.UrlRequest.Builder setDns(java.lang.String str, java.lang.String str2);

        public abstract com.tencent.smtt.export.external.interfaces.UrlRequest.Builder setHttpMethod(java.lang.String str);

        public abstract com.tencent.smtt.export.external.interfaces.UrlRequest.Builder setPriority(int i);

        public abstract com.tencent.smtt.export.external.interfaces.UrlRequest.Builder setRequestBody(java.lang.String str);

        public abstract com.tencent.smtt.export.external.interfaces.UrlRequest.Builder setRequestBodyBytes(byte[] bArr);
    }

    public static abstract class Callback {
        public void onCanceled(com.tencent.smtt.export.external.interfaces.UrlRequest urlRequest, com.tencent.smtt.export.external.interfaces.UrlResponseInfo urlResponseInfo) {
        }

        public abstract void onFailed(com.tencent.smtt.export.external.interfaces.UrlRequest urlRequest, com.tencent.smtt.export.external.interfaces.UrlResponseInfo urlResponseInfo, com.tencent.smtt.export.external.interfaces.X5netException x5netException);

        public abstract void onReadCompleted(com.tencent.smtt.export.external.interfaces.UrlRequest urlRequest, com.tencent.smtt.export.external.interfaces.UrlResponseInfo urlResponseInfo, java.nio.ByteBuffer byteBuffer);

        public abstract void onRedirectReceived(com.tencent.smtt.export.external.interfaces.UrlRequest urlRequest, com.tencent.smtt.export.external.interfaces.UrlResponseInfo urlResponseInfo, java.lang.String str);

        public abstract void onResponseStarted(com.tencent.smtt.export.external.interfaces.UrlRequest urlRequest, com.tencent.smtt.export.external.interfaces.UrlResponseInfo urlResponseInfo);

        public abstract void onSucceeded(com.tencent.smtt.export.external.interfaces.UrlRequest urlRequest, com.tencent.smtt.export.external.interfaces.UrlResponseInfo urlResponseInfo);
    }

    public abstract void cancel();

    public abstract void followRedirect();

    public abstract boolean isDone();

    public abstract void read(java.nio.ByteBuffer byteBuffer);

    public abstract void start();
}
