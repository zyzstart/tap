package com.tencent.ydkbeacon.base.net;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c implements com.tencent.ydkbeacon.base.net.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.ydkbeacon.base.net.a.f f1225a;
    final /* synthetic */ com.tencent.ydkbeacon.base.net.a.b b;
    final /* synthetic */ com.tencent.ydkbeacon.base.net.d c;

    c(com.tencent.ydkbeacon.base.net.d dVar, com.tencent.ydkbeacon.base.net.a.f fVar, com.tencent.ydkbeacon.base.net.a.b bVar) {
        this.c = dVar;
        this.f1225a = fVar;
        this.b = bVar;
    }

    @Override // com.tencent.ydkbeacon.base.net.a.b
    public void a(com.tencent.ydkbeacon.base.net.a aVar) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("httpRequest: ");
            sb.append(this.f1225a.h());
            sb.append(" request success!");
            com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", sb.toString(), new java.lang.Object[0]);
            this.b.a(aVar);
            this.c.f();
        } catch (java.lang.Exception e) {
            a(new com.tencent.ydkbeacon.base.net.e(this.f1225a.h(), "453", 200, e.getMessage(), e));
        }
    }

    @Override // com.tencent.ydkbeacon.base.net.a.b
    public void a(com.tencent.ydkbeacon.base.net.e eVar) {
        com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", "httpRequest: " + eVar.toString(), new java.lang.Object[0]);
        this.c.a(eVar);
        this.b.a(eVar);
        this.c.f();
    }
}
