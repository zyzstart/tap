package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class StringRequest extends com.tencent.beacon.core.network.volley.Request {
    private com.tencent.beacon.core.network.volley.Response.Listener mListener;
    private final java.lang.Object mLock;

    public StringRequest(int i, java.lang.String str, com.tencent.beacon.core.network.volley.Response.Listener listener, com.tencent.beacon.core.network.volley.Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.mLock = new java.lang.Object();
        this.mListener = listener;
    }

    public StringRequest(java.lang.String str, com.tencent.beacon.core.network.volley.Response.Listener listener, com.tencent.beacon.core.network.volley.Response.ErrorListener errorListener) {
        this(0, str, listener, errorListener);
    }

    @Override // com.tencent.beacon.core.network.volley.Request
    public void cancel() {
        super.cancel();
        synchronized (this.mLock) {
            this.mListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.beacon.core.network.volley.Request
    public void deliverResponse(java.lang.String str) {
        com.tencent.beacon.core.network.volley.Response.Listener listener;
        synchronized (this.mLock) {
            listener = this.mListener;
        }
        if (listener != null) {
            listener.onResponse(str);
        }
    }

    @Override // com.tencent.beacon.core.network.volley.Request
    protected com.tencent.beacon.core.network.volley.Response parseNetworkResponse(com.tencent.beacon.core.network.volley.NetworkResponse networkResponse) {
        java.lang.String str;
        try {
            str = new java.lang.String(networkResponse.data, com.tencent.beacon.core.network.volley.HttpHeaderParser.parseCharset(networkResponse.headers));
        } catch (java.io.UnsupportedEncodingException unused) {
            str = new java.lang.String(networkResponse.data, java.nio.charset.Charset.forName("UTF-8"));
        }
        return com.tencent.beacon.core.network.volley.Response.success(str, com.tencent.beacon.core.network.volley.HttpHeaderParser.parseCacheHeaders(networkResponse));
    }
}
