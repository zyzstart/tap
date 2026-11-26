package com.tencent.ydkbeacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c implements java.lang.Runnable, com.tencent.ydkbeacon.base.net.a.b, com.tencent.ydkbeacon.base.net.c.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.concurrent.atomic.AtomicInteger f1282a = new java.util.concurrent.atomic.AtomicInteger();
    private final android.content.Context b;

    public c(android.content.Context context) {
        this.b = context;
    }

    private void a(java.util.HashMap map) {
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put("q_m", map);
        com.tencent.ydkbeacon.a.a.b.a().a(new com.tencent.ydkbeacon.a.a.c(1, map2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.tencent.ydkbeacon.a.e.c.a(com.tencent.ydkbeacon.qimei.QimeiSDK.TAG, 4, "stop netListen.", new java.lang.Object[0]);
        com.tencent.ydkbeacon.base.net.c.e.a(this);
    }

    @Override // com.tencent.ydkbeacon.base.net.c.e.a
    public void a() {
        this.f1282a.set(0);
        com.tencent.ydkbeacon.a.b.a.a().a(this);
    }

    @Override // com.tencent.ydkbeacon.base.net.a.b
    public void a(com.tencent.ydkbeacon.base.net.e eVar) {
        com.tencent.ydkbeacon.a.e.c.a(com.tencent.ydkbeacon.qimei.QimeiSDK.TAG, 1, "onFailure msg: %s. Waiting next query.", eVar.toString());
        com.tencent.ydkbeacon.a.b.d.b().a("498", eVar.toString());
        if (com.tencent.ydkbeacon.qimei.a.a().b().isEmpty()) {
            com.tencent.ydkbeacon.a.b.a.a().a(10000L, this);
        }
    }

    public void a(java.lang.String str) {
        com.tencent.ydkbeacon.qimei.Qimei qimeiB = com.tencent.ydkbeacon.qimei.a.a().b();
        java.util.HashMap mapA = com.tencent.ydkbeacon.qimei.f.a(str);
        if (mapA != null) {
            com.tencent.ydkbeacon.qimei.Qimei qimei = new com.tencent.ydkbeacon.qimei.Qimei((java.lang.String) mapA.get("A3"), (java.lang.String) mapA.get("A153"), mapA);
            com.tencent.ydkbeacon.qimei.f.b(this.b, qimei.toString());
            qimeiB = qimei;
        }
        com.tencent.ydkbeacon.qimei.a.a().a(qimeiB);
        a(mapA);
    }

    @Override // com.tencent.ydkbeacon.base.net.a.b
    public void a(@android.support.annotation.NonNull byte[] bArr) {
        com.tencent.ydkbeacon.a.e.c.a(com.tencent.ydkbeacon.qimei.QimeiSDK.TAG, 1, "onResponse length: %d. ", java.lang.Integer.valueOf(bArr.length));
        com.tencent.ydkbeacon.pack.a aVar = new com.tencent.ydkbeacon.pack.a(bArr);
        com.tencent.ydkbeacon.pack.QimeiPackage qimeiPackage = new com.tencent.ydkbeacon.pack.QimeiPackage();
        qimeiPackage.readFrom(aVar);
        java.lang.String str = qimeiPackage.qimei;
        com.tencent.ydkbeacon.a.e.c.a(com.tencent.ydkbeacon.qimei.QimeiSDK.TAG, 2, "get new qimei: %s", str);
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.ydkbeacon.a.e.c.a(com.tencent.ydkbeacon.qimei.QimeiSDK.TAG, 3, "dispatch qimei to listener and save qimei!", new java.lang.Object[0]);
        a(str);
        com.tencent.ydkbeacon.qimei.f.a(this.b, str);
        com.tencent.ydkbeacon.qimei.f.a(java.lang.System.currentTimeMillis());
        d();
    }

    @Override // com.tencent.ydkbeacon.base.net.c.e.a
    public void b() {
    }

    public void c() {
        com.tencent.ydkbeacon.a.b.a.a().a(300L, new com.tencent.ydkbeacon.qimei.b(this));
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.ydkbeacon.base.net.c.e.a(this.b, this);
        if (com.tencent.ydkbeacon.base.net.c.d.d()) {
            if (!com.tencent.ydkbeacon.a.c.b.g(this.b)) {
                c();
                return;
            }
            com.tencent.ydkbeacon.qimei.QimeiSDK qimeiSDK = com.tencent.ydkbeacon.qimei.QimeiSDK.getInstance();
            com.tencent.ydkbeacon.base.net.a.k kVarA = com.tencent.ydkbeacon.base.net.a.k.a().a(com.tencent.ydkbeacon.base.net.RequestType.QIMEI).a(com.tencent.ydkbeacon.base.net.c.b.b(true), 8081).b(com.tencent.ydkbeacon.base.net.c.b.b(false)).a(qimeiSDK.getAppKey()).a(102).b(103).a(com.tencent.ydkbeacon.qimei.a.a().c()).b("[REDACTED]", qimeiSDK.getBeaconIdInfo()).b("[REDACTED]", java.lang.String.valueOf(qimeiSDK.getContext().getApplicationInfo().targetSdkVersion)).b("[REDACTED]", qimeiSDK.getOmgID()).b("[REDACTED]", com.tencent.ydkbeacon.a.c.f.p().y()).b("[REDACTED]", com.tencent.ydkbeacon.a.c.c.d().a()).a();
            com.tencent.ydkbeacon.base.net.d.c().a(kVarA).a(this);
            com.tencent.ydkbeacon.a.e.c.a(com.tencent.ydkbeacon.qimei.QimeiSDK.TAG, 0, "QimeiQueryTask start. RequestEntity: %s", kVarA.toString());
        }
    }
}
