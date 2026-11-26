package com.tencent.ydkbeacon.event.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class d implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f1255a = 0;
    private volatile long b = 0;
    final /* synthetic */ com.tencent.ydkbeacon.event.c.e c;

    d(com.tencent.ydkbeacon.event.c.e eVar) {
        this.c = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.c) {
            long j = this.c.j.get();
            long j2 = this.c.i.get();
            if (this.f1255a == j && this.b == j2) {
                return;
            }
            this.f1255a = j;
            this.b = j2;
            this.c.a(this.c.f).edit().putString("on_date", this.c.h).putLong("realtime_log_id", this.f1255a).putLong("normal_log_id", this.b).apply();
        }
    }
}
