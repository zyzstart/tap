package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class aa implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final android.os.Handler f375a;
    private final java.lang.String b;
    private long c;
    private final long d;
    private boolean e = true;
    private long f;

    aa(android.os.Handler handler, java.lang.String str, long j) {
        this.f375a = handler;
        this.b = str;
        this.c = j;
        this.d = j;
    }

    public final void a() {
        if (!this.e) {
            com.tencent.bugly.opengame.proguard.x.d("scheduleCheckBlock fail as %s thread is blocked.", this.b);
            return;
        }
        this.e = false;
        this.f = android.os.SystemClock.uptimeMillis();
        this.f375a.postAtFrontOfQueue(this);
    }

    public final void a(long j) {
        this.c = Long.MAX_VALUE;
    }

    public final boolean b() {
        com.tencent.bugly.opengame.proguard.x.c("%s thread waitTime:%d", this.b, java.lang.Long.valueOf(this.c));
        return !this.e && android.os.SystemClock.uptimeMillis() > this.f + this.c;
    }

    public final int c() {
        if (this.e) {
            return 0;
        }
        return android.os.SystemClock.uptimeMillis() - this.f < this.c ? 1 : 3;
    }

    public final java.lang.Thread d() {
        return this.f375a.getLooper().getThread();
    }

    public final java.lang.String e() {
        return this.b;
    }

    public final void f() {
        this.c = this.d;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e = true;
        this.c = this.d;
    }
}
