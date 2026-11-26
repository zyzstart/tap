package com.tencent.hlyyb.common.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class f implements com.tencent.hlyyb.common.d.a, com.tencent.hlyyb.common.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.hlyyb.common.d.f f587a = new com.tencent.hlyyb.common.d.f();
    private com.tencent.hlyyb.common.d.c c;
    private java.util.Map b = new java.util.concurrent.ConcurrentHashMap();
    private java.lang.Runnable d = new com.tencent.hlyyb.common.d.h(this);
    private java.lang.Runnable e = new com.tencent.hlyyb.common.d.i(this);

    private f() {
        com.tencent.hlyyb.common.d.a.c cVar = new com.tencent.hlyyb.common.d.a.c();
        this.b.put(cVar.b(), cVar);
        com.tencent.hlyyb.common.d.a.b bVar = new com.tencent.hlyyb.common.d.a.b();
        this.b.put(bVar.b(), bVar);
        com.tencent.hlyyb.common.d.a.a.a aVar = new com.tencent.hlyyb.common.d.a.a.a();
        this.b.put(aVar.b(), aVar);
        java.lang.Runnable runnable = this.d;
        if (!com.tencent.hlyyb.common.a.g() && com.tencent.hlyyb.common.a.h) {
            com.tencent.hlyyb.common.a.r.a().a(runnable);
            com.tencent.hlyyb.common.a.r.a().b(runnable, 30000L);
        }
        java.lang.Runnable runnable2 = this.e;
        if (com.tencent.hlyyb.common.a.g() || !com.tencent.hlyyb.common.a.h) {
            return;
        }
        com.tencent.hlyyb.common.a.r.a().a(runnable2);
        com.tencent.hlyyb.common.a.r.a().b(runnable2, 30000L);
    }

    public static com.tencent.hlyyb.common.d.f d() {
        return f587a;
    }

    @Override // com.tencent.hlyyb.common.d.a
    public final void a() {
        this.c.a();
    }

    @Override // com.tencent.hlyyb.common.d.a
    public final void a(int i) {
        com.tencent.hlyyb.common.a.k().post(new com.tencent.hlyyb.common.d.g(this, i));
    }

    @Override // com.tencent.hlyyb.common.d.b
    public final void a(java.lang.String str, java.lang.String str2) {
        java.lang.Runnable runnable = this.d;
        long jA = com.tencent.hlyyb.common.a.e.a("app_ipc_timertask_gap", 0, 3600000, com.youme.im.CommonConst.SPEECH_DURATION_MAX);
        if (!com.tencent.hlyyb.common.a.g() && com.tencent.hlyyb.common.a.h) {
            com.tencent.hlyyb.common.a.r.a().a(runnable);
            com.tencent.hlyyb.common.a.r.a().b(runnable, jA);
        }
        java.util.Iterator it = this.b.values().iterator();
        while (it.hasNext()) {
            ((com.tencent.hlyyb.common.d.a.a) it.next()).a(str, str2);
        }
    }

    @Override // com.tencent.hlyyb.common.d.b
    public final void a(java.lang.String str, byte[] bArr, java.lang.String str2) {
        java.lang.Runnable runnable = this.e;
        long jA = com.tencent.hlyyb.common.a.e.a("app_ipc_timertask_gap", 0, 3600000, com.youme.im.CommonConst.SPEECH_DURATION_MAX);
        if (!com.tencent.hlyyb.common.a.g() && com.tencent.hlyyb.common.a.h) {
            com.tencent.hlyyb.common.a.r.a().a(runnable);
            com.tencent.hlyyb.common.a.r.a().b(runnable, jA);
        }
        java.util.Iterator it = this.b.values().iterator();
        while (it.hasNext()) {
            ((com.tencent.hlyyb.common.d.a.a) it.next()).a(str, bArr, str2);
        }
    }

    @Override // com.tencent.hlyyb.common.d.a
    public final void a(boolean z) {
        if (com.tencent.hlyyb.common.a.g != z) {
            com.tencent.hlyyb.common.a.g = z;
            this.c.a(z);
        }
    }

    @Override // com.tencent.hlyyb.common.d.a
    public final void b() {
        this.c.b();
    }

    @Override // com.tencent.hlyyb.common.d.b
    public final void c() {
        java.util.Iterator it = this.b.values().iterator();
        while (it.hasNext()) {
            ((com.tencent.hlyyb.common.d.a.a) it.next()).c();
        }
    }

    public final com.tencent.hlyyb.common.d.d e() {
        return (com.tencent.hlyyb.common.d.d) this.b.get("settings");
    }

    public final com.tencent.hlyyb.common.a.c.c f() {
        return (com.tencent.hlyyb.common.a.c.c) this.b.get("accessscheduler");
    }

    public final void g() {
        if (com.tencent.hlyyb.common.a.g()) {
            this.c = com.tencent.hlyyb.common.d.e.d();
        }
        this.c.a(this);
        this.c.e();
    }
}
