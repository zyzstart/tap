package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class VolleyError extends java.lang.Exception {
    public final com.tencent.beacon.core.network.volley.NetworkResponse networkResponse;
    private long networkTimeMs;

    public VolleyError() {
        this.networkResponse = null;
    }

    public VolleyError(com.tencent.beacon.core.network.volley.NetworkResponse networkResponse) {
        this.networkResponse = networkResponse;
    }

    public VolleyError(java.lang.String str) {
        super(str);
        this.networkResponse = null;
    }

    public VolleyError(java.lang.String str, java.lang.Throwable th) {
        super(str, th);
        this.networkResponse = null;
    }

    public VolleyError(java.lang.Throwable th) {
        super(th);
        this.networkResponse = null;
    }

    public long getNetworkTimeMs() {
        return this.networkTimeMs;
    }

    void setNetworkTimeMs(long j) {
        this.networkTimeMs = j;
    }
}
