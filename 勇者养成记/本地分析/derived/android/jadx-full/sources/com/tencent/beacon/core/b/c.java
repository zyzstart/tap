package com.tencent.beacon.core.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c implements com.tencent.beacon.core.network.volley.Response.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.core.b.b f143a;
    final /* synthetic */ com.tencent.beacon.core.b.f b;

    c(com.tencent.beacon.core.b.f fVar, com.tencent.beacon.core.b.b bVar) {
        this.b = fVar;
        this.f143a = bVar;
    }

    @Override // com.tencent.beacon.core.network.volley.Response.Listener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResponse(java.lang.String str) {
        com.tencent.beacon.core.b.b bVar = this.f143a;
        if (bVar != null) {
            bVar.onResponse(str);
        }
    }
}
