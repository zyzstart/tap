package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class C implements com.tencent.beacon.core.event.TunnelModule.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f162a;

    C(boolean z) {
        this.f162a = z;
    }

    @Override // com.tencent.beacon.core.event.TunnelModule.a
    public void a(com.tencent.beacon.core.event.h hVar) {
        com.tencent.beacon.core.event.n nVarC = hVar.c();
        if (nVarC != null) {
            nVarC.b(this.f162a);
        }
        com.tencent.beacon.core.event.n nVarE = hVar.e();
        if (nVarE != null) {
            nVarE.b(this.f162a);
        }
    }
}
