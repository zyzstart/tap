package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UrlRequestBuilderImpl extends com.tencent.smtt.export.external.interfaces.UrlRequest.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.String f879a = "UrlRequestBuilderImpl";
    private final java.lang.String b;
    private final com.tencent.smtt.export.external.interfaces.UrlRequest.Callback c;
    private final java.util.concurrent.Executor d;
    private java.lang.String e;
    private boolean g;
    private java.lang.String i;
    private byte[] j;
    private java.lang.String k;
    private java.lang.String l;
    private final java.util.ArrayList f = new java.util.ArrayList();
    private int h = 3;

    public UrlRequestBuilderImpl(java.lang.String str, com.tencent.smtt.export.external.interfaces.UrlRequest.Callback callback, java.util.concurrent.Executor executor) {
        if (str == null) {
            throw new java.lang.NullPointerException("URL is required.");
        }
        if (callback == null) {
            throw new java.lang.NullPointerException("Callback is required.");
        }
        if (executor == null) {
            throw new java.lang.NullPointerException("Executor is required.");
        }
        this.b = str;
        this.c = callback;
        this.d = executor;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public com.tencent.smtt.sdk.UrlRequestBuilderImpl addHeader(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            throw new java.lang.NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new java.lang.NullPointerException("Invalid header value.");
        }
        if ("Accept-Encoding".equalsIgnoreCase(str)) {
            return this;
        }
        this.f.add(android.util.Pair.create(str, str2));
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public com.tencent.smtt.export.external.interfaces.UrlRequest build() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            return null;
        }
        com.tencent.smtt.export.external.interfaces.UrlRequest urlRequest = (com.tencent.smtt.export.external.interfaces.UrlRequest) uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "UrlRequest_getX5UrlRequestProvider", new java.lang.Class[]{java.lang.String.class, java.lang.Integer.TYPE, com.tencent.smtt.export.external.interfaces.UrlRequest.Callback.class, java.util.concurrent.Executor.class, java.lang.Boolean.TYPE, java.lang.String.class, java.util.ArrayList.class, java.lang.String.class, byte[].class, java.lang.String.class, java.lang.String.class}, this.b, java.lang.Integer.valueOf(this.h), this.c, this.d, java.lang.Boolean.valueOf(this.g), this.e, this.f, this.i, this.j, this.k, this.l);
        if (urlRequest != null) {
            return urlRequest;
        }
        throw new java.lang.NullPointerException("UrlRequest build fail");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public com.tencent.smtt.sdk.UrlRequestBuilderImpl disableCache() {
        this.g = true;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public com.tencent.smtt.sdk.UrlRequestBuilderImpl setDns(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            throw new java.lang.NullPointerException("host and address are required.");
        }
        this.k = str;
        this.l = str2;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public com.tencent.smtt.export.external.interfaces.UrlRequest.Builder setHttpMethod(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("Method is required.");
        }
        this.e = str;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public com.tencent.smtt.sdk.UrlRequestBuilderImpl setPriority(int i) {
        this.h = i;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public com.tencent.smtt.export.external.interfaces.UrlRequest.Builder setRequestBody(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("Body is required.");
        }
        this.i = str;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public com.tencent.smtt.export.external.interfaces.UrlRequest.Builder setRequestBodyBytes(byte[] bArr) {
        if (bArr == null) {
            throw new java.lang.NullPointerException("Body is required.");
        }
        this.j = bArr;
        return this;
    }
}
