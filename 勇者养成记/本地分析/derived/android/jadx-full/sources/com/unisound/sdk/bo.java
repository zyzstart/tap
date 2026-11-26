package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class bo implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.sdk.bg f1539a;

    bo(com.unisound.sdk.bg bgVar) {
        this.f1539a = bgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.unisound.common.y.c(com.unisound.common.y.v, "Runnable refresh activate");
        this.f1539a.refreshActivate();
    }
}
