package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class y implements com.tencent.beacon.core.a.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.core.event.TunnelModule f181a;

    y(com.tencent.beacon.core.event.TunnelModule tunnelModule) {
        this.f181a = tunnelModule;
    }

    @Override // com.tencent.beacon.core.a.g.a
    public void a() {
        com.tencent.beacon.core.a.d.a().a(this.f181a.doUploadTask);
    }
}
