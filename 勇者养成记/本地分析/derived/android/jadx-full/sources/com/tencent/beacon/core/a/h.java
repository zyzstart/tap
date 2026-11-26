package com.tencent.beacon.core.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class h implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.Activity f137a;
    final /* synthetic */ com.tencent.beacon.core.a.j b;

    h(com.tencent.beacon.core.a.j jVar, android.app.Activity activity) {
        this.b = jVar;
        this.f137a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.content.Context applicationContext = this.f137a.getApplicationContext();
        com.tencent.beacon.core.info.e eVarD = com.tencent.beacon.core.info.e.d(applicationContext);
        this.b.g.put("A33", eVarD.k(applicationContext));
        this.b.g.put("A85", com.tencent.beacon.core.info.a.e ? "Y" : "N");
        this.b.g.put("A20", eVarD.p(applicationContext));
        this.b.g.put("A69", eVarD.q(applicationContext));
        com.tencent.beacon.event.UserAction.onUserAction("rqd_applaunched", true, 0L, 0L, this.b.g, true);
        com.tencent.beacon.core.event.TunnelModule.doUploadRecentCommonData(true);
    }
}
