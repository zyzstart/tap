package com.tencent.ydkbeacon.base.net.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c implements com.tencent.ydkbeacon.base.net.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.ydkbeacon.base.net.a.b f1206a;
    final /* synthetic */ com.tencent.ydkbeacon.base.net.a.d b;

    c(com.tencent.ydkbeacon.base.net.a.d dVar, com.tencent.ydkbeacon.base.net.a.b bVar) {
        this.b = dVar;
        this.f1206a = bVar;
    }

    @Override // com.tencent.ydkbeacon.base.net.a.b
    public void a(com.tencent.ydkbeacon.base.net.a aVar) {
        com.tencent.ydkbeacon.base.net.a.b bVar = this.f1206a;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.tencent.ydkbeacon.base.net.a.b
    public void a(com.tencent.ydkbeacon.base.net.e eVar) {
        com.tencent.ydkbeacon.base.net.a.b bVar = this.f1206a;
        if (bVar != null) {
            bVar.a(eVar);
        }
    }
}
