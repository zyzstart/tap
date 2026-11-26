package com.tencent.ydkbeacon.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.ydkbeacon.a.a.c f1175a;
    final /* synthetic */ com.tencent.ydkbeacon.a.a.b b;

    a(com.tencent.ydkbeacon.a.a.b bVar, com.tencent.ydkbeacon.a.a.c cVar) {
        this.b = bVar;
        this.f1175a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.f1175a);
    }
}
