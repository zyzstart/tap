package com.tencent.beacon.stat;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f216a = 0;
    private volatile long b = 0;
    final /* synthetic */ com.tencent.beacon.stat.d c;

    c(com.tencent.beacon.stat.d dVar) {
        this.c = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.c) {
            long j = this.c.i.get();
            long j2 = this.c.h.get();
            if (this.f216a == j && this.b == j2) {
                return;
            }
            this.f216a = j;
            this.b = j2;
            this.c.a(this.c.e).edit().putString("on_date", this.c.g).putLong("realtime_log_id", this.f216a).putLong("normal_log_id", this.b).apply();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("[LogID ");
            sb.append(this.c.f);
            sb.append("]  write serial to sp, date: %s ,realtime: %d, normal: %d ");
            com.tencent.beacon.core.e.d.a(sb.toString(), this.c.g, java.lang.Long.valueOf(this.f216a), java.lang.Long.valueOf(this.b));
        }
    }
}
