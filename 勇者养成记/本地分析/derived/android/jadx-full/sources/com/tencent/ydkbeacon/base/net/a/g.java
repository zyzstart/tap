package com.tencent.ydkbeacon.base.net.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class g implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.ydkbeacon.base.net.a.b f1211a;
    final /* synthetic */ com.tencent.ydkbeacon.base.net.a.i b;

    g(com.tencent.ydkbeacon.base.net.a.i iVar, com.tencent.ydkbeacon.base.net.a.b bVar) {
        this.b = iVar;
        this.f1211a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.f1211a);
    }
}
