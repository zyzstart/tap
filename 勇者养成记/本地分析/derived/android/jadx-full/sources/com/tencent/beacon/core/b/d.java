package com.tencent.beacon.core.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class d implements com.tencent.beacon.core.network.volley.Response.ErrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.core.b.b f144a;
    final /* synthetic */ com.tencent.beacon.core.b.f b;

    d(com.tencent.beacon.core.b.f fVar, com.tencent.beacon.core.b.b bVar) {
        this.b = fVar;
        this.f144a = bVar;
    }

    @Override // com.tencent.beacon.core.network.volley.Response.ErrorListener
    public void onErrorResponse(com.tencent.beacon.core.network.volley.VolleyError volleyError) {
        com.tencent.beacon.core.b.b bVar = this.f144a;
        if (bVar != null) {
            bVar.a(volleyError);
        }
    }
}
