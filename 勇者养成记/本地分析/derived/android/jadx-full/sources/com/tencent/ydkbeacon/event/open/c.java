package com.tencent.ydkbeacon.event.open;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.ydkbeacon.event.open.BeaconReport f1264a;

    c(com.tencent.ydkbeacon.event.open.BeaconReport beaconReport) {
        this.f1264a = beaconReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1264a.b();
            this.f1264a.a();
            this.f1264a.c();
            com.tencent.ydkbeacon.a.e.e.a(this.f1264a.c);
            com.tencent.ydkbeacon.a.e.c.a("BeaconReport", "App: %s start success!", this.f1264a.e);
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.b.d.b().a("201", "sdk init error! msg:" + th.getMessage(), th);
            com.tencent.ydkbeacon.a.e.c.b("BeaconReport init error: " + th.getMessage(), new java.lang.Object[0]);
            com.tencent.ydkbeacon.a.e.c.a(th);
        }
    }
}
