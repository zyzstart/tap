package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class NetworkError extends com.tencent.beacon.core.network.volley.VolleyError {
    public NetworkError() {
    }

    public NetworkError(com.tencent.beacon.core.network.volley.NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public NetworkError(java.lang.Throwable th) {
        super(th);
    }
}
