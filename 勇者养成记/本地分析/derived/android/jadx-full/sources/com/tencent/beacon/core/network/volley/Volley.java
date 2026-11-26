package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Volley {
    private static final java.lang.String DEFAULT_CACHE_DIR = "beacon_volley";

    public static com.tencent.beacon.core.network.volley.RequestQueue newRequestQueue(android.content.Context context) {
        return newRequestQueue(context, (com.tencent.beacon.core.network.volley.BaseHttpStack) null);
    }

    public static com.tencent.beacon.core.network.volley.RequestQueue newRequestQueue(android.content.Context context, com.tencent.beacon.core.network.volley.BaseHttpStack baseHttpStack) {
        return newRequestQueue(context, baseHttpStack == null ? new com.tencent.beacon.core.network.volley.BasicNetwork((com.tencent.beacon.core.network.volley.BaseHttpStack) new com.tencent.beacon.core.network.volley.HurlStack()) : new com.tencent.beacon.core.network.volley.BasicNetwork(baseHttpStack));
    }

    @java.lang.Deprecated
    public static com.tencent.beacon.core.network.volley.RequestQueue newRequestQueue(android.content.Context context, com.tencent.beacon.core.network.volley.HttpStack httpStack) {
        return httpStack == null ? newRequestQueue(context, (com.tencent.beacon.core.network.volley.BaseHttpStack) null) : newRequestQueue(context, new com.tencent.beacon.core.network.volley.BasicNetwork(httpStack));
    }

    private static com.tencent.beacon.core.network.volley.RequestQueue newRequestQueue(android.content.Context context, com.tencent.beacon.core.network.volley.Network network) {
        final android.content.Context applicationContext = context.getApplicationContext();
        com.tencent.beacon.core.network.volley.RequestQueue requestQueue = new com.tencent.beacon.core.network.volley.RequestQueue(new com.tencent.beacon.core.network.volley.DiskBasedCache(new com.tencent.beacon.core.network.volley.DiskBasedCache.FileSupplier() { // from class: com.tencent.beacon.core.network.volley.Volley.1
            private java.io.File cacheDir = null;

            @Override // com.tencent.beacon.core.network.volley.DiskBasedCache.FileSupplier
            public java.io.File get() {
                if (this.cacheDir == null) {
                    this.cacheDir = new java.io.File(applicationContext.getCacheDir(), com.tencent.beacon.core.network.volley.Volley.DEFAULT_CACHE_DIR);
                }
                return this.cacheDir;
            }
        }), network);
        requestQueue.start();
        return requestQueue;
    }
}
