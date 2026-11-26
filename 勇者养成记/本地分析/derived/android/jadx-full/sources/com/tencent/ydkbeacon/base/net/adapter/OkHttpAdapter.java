package com.tencent.ydkbeacon.base.net.adapter;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class OkHttpAdapter extends com.tencent.ydkbeacon.base.net.adapter.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private okhttp3.OkHttpClient f1216a;

    private OkHttpAdapter() {
        this.f1216a = new okhttp3.OkHttpClient.Builder().connectTimeout(30000L, java.util.concurrent.TimeUnit.MILLISECONDS).readTimeout(10000L, java.util.concurrent.TimeUnit.MILLISECONDS).build();
    }

    private OkHttpAdapter(okhttp3.OkHttpClient okHttpClient) {
        this.f1216a = okHttpClient;
    }

    private okhttp3.Headers a(java.util.Map map) {
        okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
        for (java.util.Map.Entry entry : map.entrySet()) {
            if (entry.getValue() != null) {
                builder.add((java.lang.String) entry.getKey(), (java.lang.String) entry.getValue());
            }
        }
        return builder.build();
    }

    private okhttp3.RequestBody a(com.tencent.ydkbeacon.base.net.a.f fVar) {
        okhttp3.MediaType mediaType;
        java.lang.String strB;
        com.tencent.ydkbeacon.base.net.BodyType bodyTypeA = fVar.a();
        int i = com.tencent.ydkbeacon.base.net.adapter.f.f1220a[bodyTypeA.ordinal()];
        if (i == 1) {
            mediaType = okhttp3.MediaType.parse(bodyTypeA.httpType);
            strB = com.tencent.ydkbeacon.base.net.c.d.b(fVar.d());
        } else {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return okhttp3.RequestBody.create(okhttp3.MediaType.parse("multipart/form-data"), fVar.c());
            }
            mediaType = okhttp3.MediaType.parse(bodyTypeA.httpType);
            strB = fVar.f();
        }
        return okhttp3.RequestBody.create(mediaType, strB);
    }

    public static com.tencent.ydkbeacon.base.net.adapter.c create(@android.support.annotation.Nullable okhttp3.OkHttpClient okHttpClient) {
        return okHttpClient != null ? new com.tencent.ydkbeacon.base.net.adapter.OkHttpAdapter(okHttpClient) : new com.tencent.ydkbeacon.base.net.adapter.OkHttpAdapter();
    }

    @Override // com.tencent.ydkbeacon.base.net.adapter.c
    public void a(com.tencent.ydkbeacon.base.net.a.f fVar, com.tencent.ydkbeacon.base.net.a.b bVar) {
        java.lang.String strH = fVar.h();
        this.f1216a.newCall(new okhttp3.Request.Builder().url(fVar.i()).method(fVar.g().name(), a(fVar)).headers(a(fVar.e())).tag(strH == null ? "beacon" : strH).build()).enqueue(new com.tencent.ydkbeacon.base.net.adapter.e(this, bVar, strH));
    }

    @Override // com.tencent.ydkbeacon.base.net.adapter.c
    public void a(com.tencent.ydkbeacon.base.net.a.k kVar, com.tencent.ydkbeacon.base.net.a.b bVar) {
        okhttp3.RequestBody requestBodyCreate = okhttp3.RequestBody.create(okhttp3.MediaType.parse("jce"), kVar.b());
        okhttp3.Headers headersA = a(kVar.d());
        java.lang.String strName = kVar.g().name();
        this.f1216a.newCall(new okhttp3.Request.Builder().url(kVar.h()).tag(strName).post(requestBodyCreate).headers(headersA).build()).enqueue(new com.tencent.ydkbeacon.base.net.adapter.d(this, bVar, strName));
    }
}
