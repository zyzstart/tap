package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class l implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.core.event.m f172a;

    l(com.tencent.beacon.core.event.m mVar) {
        this.f172a = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f172a.a();
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
        }
    }
}
