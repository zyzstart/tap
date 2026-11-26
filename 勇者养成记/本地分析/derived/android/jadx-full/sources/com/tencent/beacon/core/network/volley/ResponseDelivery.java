package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface ResponseDelivery {
    void postError(com.tencent.beacon.core.network.volley.Request request, com.tencent.beacon.core.network.volley.VolleyError volleyError);

    void postResponse(com.tencent.beacon.core.network.volley.Request request, com.tencent.beacon.core.network.volley.Response response);

    void postResponse(com.tencent.beacon.core.network.volley.Request request, com.tencent.beacon.core.network.volley.Response response, java.lang.Runnable runnable);
}
