package com.tencent.beacon.core.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class i implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.Activity f138a;
    final /* synthetic */ com.tencent.beacon.core.a.j b;

    i(com.tencent.beacon.core.a.j jVar, android.app.Activity activity) {
        this.b = jVar;
        this.f138a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        new com.tencent.beacon.core.event.m(this.f138a.getApplicationContext()).c();
    }
}
