package com.tencent.ydkbeacon.base.net;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d implements com.tencent.ydkbeacon.base.net.f, com.tencent.ydkbeacon.base.net.c.e.a, java.io.Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.ydkbeacon.base.net.d f1229a;
    private com.tencent.ydkbeacon.base.net.adapter.c b;
    public com.tencent.ydkbeacon.base.net.b.a d;
    public com.tencent.ydkbeacon.base.net.b.b e;
    private android.content.Context f;
    private com.tencent.ydkbeacon.base.net.adapter.c g;
    private com.tencent.ydkbeacon.base.net.adapter.c j;
    private final java.util.List c = new java.util.LinkedList();
    private final java.util.concurrent.atomic.AtomicBoolean h = new java.util.concurrent.atomic.AtomicBoolean(false);
    private final java.util.concurrent.atomic.AtomicInteger i = new java.util.concurrent.atomic.AtomicInteger();

    private d() {
    }

    public static synchronized com.tencent.ydkbeacon.base.net.d c() {
        if (f1229a == null) {
            f1229a = new com.tencent.ydkbeacon.base.net.d();
        }
        return f1229a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", "current net connected num: %d", java.lang.Integer.valueOf(this.i.decrementAndGet()));
    }

    private void g() {
        com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", "current net connected num: %d", java.lang.Integer.valueOf(this.i.incrementAndGet()));
    }

    public com.tencent.ydkbeacon.base.net.a.d a(com.tencent.ydkbeacon.base.net.a.f fVar) {
        return new com.tencent.ydkbeacon.base.net.a.d(fVar);
    }

    public com.tencent.ydkbeacon.base.net.a.i a(com.tencent.ydkbeacon.base.net.a.k kVar) {
        return new com.tencent.ydkbeacon.base.net.a.i(kVar);
    }

    @android.support.annotation.NonNull
    public com.tencent.ydkbeacon.base.net.adapter.c a(@android.support.annotation.Nullable com.tencent.ydkbeacon.base.net.adapter.c cVar) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("skip adapter: ");
        sb.append(cVar == null ? "" : cVar.getClass().getSimpleName());
        com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", sb.toString(), new java.lang.Object[0]);
        int iIndexOf = this.c.indexOf(cVar) + 1;
        if (iIndexOf >= this.c.size()) {
            iIndexOf = 0;
        }
        return (com.tencent.ydkbeacon.base.net.adapter.c) this.c.get(iIndexOf);
    }

    @Override // com.tencent.ydkbeacon.base.net.c.e.a
    public void a() {
        this.h.set(false);
        com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", "network recovery. open BeaconNet.", new java.lang.Object[0]);
    }

    public void a(android.content.Context context, com.tencent.ydkbeacon.base.net.adapter.c cVar) {
        this.f = context;
        if (cVar == null) {
            cVar = new com.tencent.ydkbeacon.base.net.adapter.b();
        }
        com.tencent.ydkbeacon.base.net.adapter.c cVarA = com.tencent.ydkbeacon.base.net.adapter.g.a();
        this.g = cVarA;
        this.j = cVar;
        this.c.add(cVarA);
        this.c.add(cVar);
        this.d = com.tencent.ydkbeacon.base.net.b.a.a();
        this.e = com.tencent.ydkbeacon.base.net.b.b.a();
        com.tencent.ydkbeacon.base.net.c.e.a(context, this);
    }

    public void a(com.tencent.ydkbeacon.base.net.a.f fVar, com.tencent.ydkbeacon.base.net.a.b bVar) {
        if (this.h.get()) {
            bVar.a(new com.tencent.ydkbeacon.base.net.e(fVar.h(), null, 0, "BeaconNet close."));
        } else {
            g();
            this.j.a(fVar, new com.tencent.ydkbeacon.base.net.c(this, fVar, bVar));
        }
    }

    public void a(com.tencent.ydkbeacon.base.net.a.k kVar, com.tencent.ydkbeacon.base.net.a.b bVar) {
        if (this.h.get()) {
            bVar.a(new com.tencent.ydkbeacon.base.net.e(kVar.g().name(), null, 0, "BeaconNet close."));
            return;
        }
        com.tencent.ydkbeacon.base.net.adapter.c cVarA = a(this.b);
        boolean z = cVarA == this.g;
        g();
        if (kVar.g() == com.tencent.ydkbeacon.base.net.RequestType.EVENT) {
            cVarA = this.g;
        }
        cVarA.a(kVar, new com.tencent.ydkbeacon.base.net.b(this, kVar, z, bVar));
    }

    public void a(@android.support.annotation.NonNull com.tencent.ydkbeacon.base.net.e eVar) {
        if (eVar.f1230a.equals("atta") || android.text.TextUtils.isEmpty(eVar.b)) {
            return;
        }
        com.tencent.ydkbeacon.a.b.d.b().a(eVar.b, eVar.toString(), eVar.e);
    }

    @Override // com.tencent.ydkbeacon.base.net.c.e.a
    public void b() {
        this.h.set(true);
        com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", "network can't use. close BeaconNet.", new java.lang.Object[0]);
    }

    public void b(com.tencent.ydkbeacon.base.net.adapter.c cVar) {
        this.b = cVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.h.set(true);
        com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", "network can't use. close BeaconNet.", new java.lang.Object[0]);
    }

    public boolean d() {
        return this.i.get() >= 5;
    }

    public void e() {
        this.h.set(false);
    }
}
