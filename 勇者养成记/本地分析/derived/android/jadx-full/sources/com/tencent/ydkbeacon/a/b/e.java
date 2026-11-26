package com.tencent.ydkbeacon.a.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class e implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f1182a;
    final /* synthetic */ com.tencent.ydkbeacon.a.b.f b;

    e(com.tencent.ydkbeacon.a.b.f fVar, java.lang.Runnable runnable) {
        this.b = fVar;
        this.f1182a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1182a.run();
        } catch (java.lang.Throwable th) {
            if (com.tencent.ydkbeacon.a.b.f.d.addAndGet(1) < 100) {
                com.tencent.ydkbeacon.a.b.d.b().a("599", "[task] run occur error!", th);
            }
            com.tencent.ydkbeacon.a.e.e.a(th.getMessage());
            com.tencent.ydkbeacon.a.e.c.a(th);
        }
    }
}
