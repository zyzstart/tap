package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class z implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.core.event.TunnelModule f182a;

    z(com.tencent.beacon.core.event.TunnelModule tunnelModule) {
        this.f182a = tunnelModule;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.beacon.core.e.d.a("[net] db events to up on netConnectChange", new java.lang.Object[0]);
        try {
            com.tencent.beacon.core.event.TunnelModule.doUploadRecentCommonData(true);
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
        }
    }
}
