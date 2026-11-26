package com.tencent.ydkbeacon.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class e implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.ydkbeacon.d.g f1241a;

    e(com.tencent.ydkbeacon.d.g gVar) {
        this.f1241a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1241a.g != null) {
            com.tencent.ydkbeacon.d.g gVar = this.f1241a;
            gVar.a(gVar.g);
        }
    }
}
