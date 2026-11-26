package com.tencent.beacon.core.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f130a;
    final /* synthetic */ com.tencent.beacon.core.a.d.a b;

    c(com.tencent.beacon.core.a.d.a aVar, java.lang.Runnable runnable) {
        this.b = aVar;
        this.f130a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f130a.run();
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.d.i.a().a("599", "[task] run occur error!", th);
            com.tencent.beacon.core.e.i.a(th.getMessage());
            th.printStackTrace();
        }
    }
}
