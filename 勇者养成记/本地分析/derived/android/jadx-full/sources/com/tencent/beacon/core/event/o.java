package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class o implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.core.event.q f174a;

    o(com.tencent.beacon.core.event.q qVar) {
        this.f174a = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.beacon.core.e.d.f(this.f174a.a("[realtime event] -> do sync upload task."), new java.lang.Object[0]);
        try {
            this.f174a.c();
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
        }
    }
}
