package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ClearCacheRequest extends com.tencent.beacon.core.network.volley.Request {
    private final com.tencent.beacon.core.network.volley.Cache mCache;
    private final java.lang.Runnable mCallback;

    public ClearCacheRequest(com.tencent.beacon.core.network.volley.Cache cache, java.lang.Runnable runnable) {
        super(0, null, null);
        this.mCache = cache;
        this.mCallback = runnable;
    }

    @Override // com.tencent.beacon.core.network.volley.Request
    protected void deliverResponse(java.lang.Object obj) {
    }

    @Override // com.tencent.beacon.core.network.volley.Request
    public com.tencent.beacon.core.network.volley.Request.Priority getPriority() {
        return com.tencent.beacon.core.network.volley.Request.Priority.IMMEDIATE;
    }

    @Override // com.tencent.beacon.core.network.volley.Request
    public boolean isCanceled() {
        this.mCache.clear();
        if (this.mCallback == null) {
            return true;
        }
        new android.os.Handler(android.os.Looper.getMainLooper()).postAtFrontOfQueue(this.mCallback);
        return true;
    }

    @Override // com.tencent.beacon.core.network.volley.Request
    protected com.tencent.beacon.core.network.volley.Response parseNetworkResponse(com.tencent.beacon.core.network.volley.NetworkResponse networkResponse) {
        return null;
    }
}
