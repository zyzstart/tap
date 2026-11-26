package com.tencent.beacon.core.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class e extends com.tencent.beacon.core.network.volley.StringRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.util.Map f145a;
    final /* synthetic */ com.tencent.beacon.core.b.f b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e(com.tencent.beacon.core.b.f fVar, int i, java.lang.String str, com.tencent.beacon.core.network.volley.Response.Listener listener, com.tencent.beacon.core.network.volley.Response.ErrorListener errorListener, java.util.Map map) {
        super(i, str, listener, errorListener);
        this.b = fVar;
        this.f145a = map;
    }

    @Override // com.tencent.beacon.core.network.volley.Request
    protected java.util.Map getParams() {
        return this.f145a;
    }
}
