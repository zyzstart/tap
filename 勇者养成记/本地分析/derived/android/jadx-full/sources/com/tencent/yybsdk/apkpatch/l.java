package com.tencent.yybsdk.apkpatch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class l implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.yybsdk.apkpatch.j f1434a;

    l(com.tencent.yybsdk.apkpatch.j jVar) {
        this.f1434a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.yybsdk.apkpatch.r rVar = this.f1434a.d;
        com.tencent.yybsdk.apkpatch.j jVar = this.f1434a;
        rVar.a(jVar.f1432a, jVar.p.c.i(), this.f1434a.p.f.m);
    }
}
