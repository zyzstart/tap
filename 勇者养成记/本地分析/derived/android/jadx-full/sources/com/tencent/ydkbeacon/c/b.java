package com.tencent.ydkbeacon.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1236a;
    final /* synthetic */ com.tencent.ydkbeacon.a.d.a b;
    final /* synthetic */ com.tencent.ydkbeacon.c.c c;

    b(com.tencent.ydkbeacon.c.c cVar, java.lang.String str, com.tencent.ydkbeacon.a.d.a aVar) {
        this.c = cVar;
        this.f1236a = str;
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.tencent.ydkbeacon.base.net.c.d.d()) {
            boolean zC = this.c.c();
            if (this.c.c && zC) {
                com.tencent.ydkbeacon.a.e.c.a("[event] rqd_heartbeat A85=Y report success : " + this.f1236a, new java.lang.Object[0]);
                this.b.edit().putString("active_user_date", this.f1236a).commit();
                this.b.edit().putString("HEART_DENGTA", this.f1236a).commit();
            }
        }
    }
}
