package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class g implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.core.event.h f168a;

    g(com.tencent.beacon.core.event.h hVar) {
        this.f168a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f168a.a(true, false);
    }
}
