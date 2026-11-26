package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class JsonRequest extends com.tencent.beacon.core.network.volley.Request {
    protected static final java.lang.String PROTOCOL_CHARSET = "utf-8";
    private static final java.lang.String PROTOCOL_CONTENT_TYPE = java.lang.String.format("application/json; charset=%s", "utf-8");
    private com.tencent.beacon.core.network.volley.Response.Listener mListener;
    private final java.lang.Object mLock;
    private final java.lang.String mRequestBody;

    public JsonRequest(int i, java.lang.String str, java.lang.String str2, com.tencent.beacon.core.network.volley.Response.Listener listener, com.tencent.beacon.core.network.volley.Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.mLock = new java.lang.Object();
        this.mListener = listener;
        this.mRequestBody = str2;
    }

    @java.lang.Deprecated
    public JsonRequest(java.lang.String str, java.lang.String str2, com.tencent.beacon.core.network.volley.Response.Listener listener, com.tencent.beacon.core.network.volley.Response.ErrorListener errorListener) {
        this(-1, str, str2, listener, errorListener);
    }

    @Override // com.tencent.beacon.core.network.volley.Request
    public void cancel() {
        super.cancel();
        synchronized (this.mLock) {
            this.mListener = null;
        }
    }

    @Override // com.tencent.beacon.core.network.volley.Request
    protected void deliverResponse(java.lang.Object obj) {
        com.tencent.beacon.core.network.volley.Response.Listener listener;
        synchronized (this.mLock) {
            listener = this.mListener;
        }
        if (listener != null) {
            listener.onResponse(obj);
        }
    }

    @Override // com.tencent.beacon.core.network.volley.Request
    public byte[] getBody() {
        try {
            if (this.mRequestBody == null) {
                return null;
            }
            return this.mRequestBody.getBytes("utf-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            com.tencent.beacon.core.network.volley.VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", this.mRequestBody, "utf-8");
            return null;
        }
    }

    @Override // com.tencent.beacon.core.network.volley.Request
    public java.lang.String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    @Override // com.tencent.beacon.core.network.volley.Request
    @java.lang.Deprecated
    public byte[] getPostBody() {
        return getBody();
    }

    @Override // com.tencent.beacon.core.network.volley.Request
    @java.lang.Deprecated
    public java.lang.String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Override // com.tencent.beacon.core.network.volley.Request
    protected abstract com.tencent.beacon.core.network.volley.Response parseNetworkResponse(com.tencent.beacon.core.network.volley.NetworkResponse networkResponse);
}
