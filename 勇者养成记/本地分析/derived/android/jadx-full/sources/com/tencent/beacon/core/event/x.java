package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class x implements com.tencent.beacon.core.event.TunnelModule.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f180a;
    final /* synthetic */ com.tencent.beacon.core.event.TunnelModule b;

    x(com.tencent.beacon.core.event.TunnelModule tunnelModule, boolean z) {
        this.b = tunnelModule;
        this.f180a = z;
    }

    @Override // com.tencent.beacon.core.event.TunnelModule.a
    public void a(com.tencent.beacon.core.event.h hVar) {
        boolean z = this.f180a;
        if (z != hVar.d) {
            hVar.a(z);
        }
    }
}
