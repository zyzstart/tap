package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class q implements com.unisound.common.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.sdk.o f1571a;

    q(com.unisound.sdk.o oVar) {
        this.f1571a = oVar;
    }

    @Override // com.unisound.common.d
    public void a() {
        this.f1571a.start();
    }

    @Override // com.unisound.common.d
    public void b() {
        this.f1571a.stop();
    }

    @Override // com.unisound.common.d
    public void c() {
        this.f1571a.cancel();
    }
}
