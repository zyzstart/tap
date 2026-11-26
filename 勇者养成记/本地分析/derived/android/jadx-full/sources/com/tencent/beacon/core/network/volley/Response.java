package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Response {
    public final com.tencent.beacon.core.network.volley.Cache.Entry cacheEntry;
    public final com.tencent.beacon.core.network.volley.VolleyError error;
    public boolean intermediate;
    public final java.lang.Object result;

    public interface ErrorListener {
        void onErrorResponse(com.tencent.beacon.core.network.volley.VolleyError volleyError);
    }

    public interface Listener {
        void onResponse(java.lang.Object obj);
    }

    private Response(com.tencent.beacon.core.network.volley.VolleyError volleyError) {
        this.intermediate = false;
        this.result = null;
        this.cacheEntry = null;
        this.error = volleyError;
    }

    private Response(java.lang.Object obj, com.tencent.beacon.core.network.volley.Cache.Entry entry) {
        this.intermediate = false;
        this.result = obj;
        this.cacheEntry = entry;
        this.error = null;
    }

    public static com.tencent.beacon.core.network.volley.Response error(com.tencent.beacon.core.network.volley.VolleyError volleyError) {
        return new com.tencent.beacon.core.network.volley.Response(volleyError);
    }

    public static com.tencent.beacon.core.network.volley.Response success(java.lang.Object obj, com.tencent.beacon.core.network.volley.Cache.Entry entry) {
        return new com.tencent.beacon.core.network.volley.Response(obj, entry);
    }

    public boolean isSuccess() {
        return this.error == null;
    }
}
