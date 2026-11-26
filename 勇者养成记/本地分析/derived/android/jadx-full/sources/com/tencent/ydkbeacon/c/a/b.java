package com.tencent.ydkbeacon.c.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.Activity f1233a;
    final /* synthetic */ com.tencent.ydkbeacon.c.a.c b;

    b(com.tencent.ydkbeacon.c.a.c cVar, android.app.Activity activity) {
        this.b = cVar;
        this.f1233a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        new com.tencent.ydkbeacon.c.c(this.f1233a.getApplicationContext()).a();
    }
}
