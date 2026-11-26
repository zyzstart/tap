package com.tencent.beacon.core.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class e implements org.apache.http.client.HttpRequestRetryHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.core.d.f.a f151a;

    e(com.tencent.beacon.core.d.f.a aVar) {
        this.f151a = aVar;
    }

    @Override // org.apache.http.client.HttpRequestRetryHandler
    public boolean retryRequest(java.io.IOException iOException, int i, org.apache.http.protocol.HttpContext httpContext) {
        if (i >= 3) {
            return false;
        }
        return (iOException instanceof org.apache.http.NoHttpResponseException) || (iOException instanceof org.apache.http.client.ClientProtocolException);
    }
}
