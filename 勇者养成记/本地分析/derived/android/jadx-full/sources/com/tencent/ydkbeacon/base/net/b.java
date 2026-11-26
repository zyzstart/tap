package com.tencent.ydkbeacon.base.net;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class b implements com.tencent.ydkbeacon.base.net.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.ydkbeacon.base.net.a.k f1222a;
    final /* synthetic */ boolean b;
    final /* synthetic */ com.tencent.ydkbeacon.base.net.a.b c;
    final /* synthetic */ com.tencent.ydkbeacon.base.net.d d;

    b(com.tencent.ydkbeacon.base.net.d dVar, com.tencent.ydkbeacon.base.net.a.k kVar, boolean z, com.tencent.ydkbeacon.base.net.a.b bVar) {
        this.d = dVar;
        this.f1222a = kVar;
        this.b = z;
        this.c = bVar;
    }

    @Override // com.tencent.ydkbeacon.base.net.a.b
    public void a(com.tencent.ydkbeacon.base.net.e eVar) {
        com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", "jceRequest: " + eVar.toString(), new java.lang.Object[0]);
        this.d.a(eVar);
        this.c.a(eVar);
        this.d.f();
    }

    @Override // com.tencent.ydkbeacon.base.net.a.b
    public void a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            a(new com.tencent.ydkbeacon.base.net.e(this.f1222a.g().name(), this.b ? "402" : "452", 200, "raw response == null", null));
            return;
        }
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("jceRequest: ");
            sb.append(this.f1222a.g());
            sb.append(" request success!");
            com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", sb.toString(), new java.lang.Object[0]);
            this.c.a(bArr);
            this.d.f();
        } catch (java.lang.Exception e) {
            a(new com.tencent.ydkbeacon.base.net.e(this.f1222a.g().name(), this.b ? "403" : "453", 200, e.getMessage(), e));
        }
    }
}
