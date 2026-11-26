package com.tencent.hlyyb.common.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class a {
    private long c;
    private android.os.Handler d;
    private com.tencent.hlyyb.common.c.j e;
    private int k;
    private java.util.concurrent.atomic.AtomicInteger f = new java.util.concurrent.atomic.AtomicInteger(0);
    private java.util.List g = new java.util.ArrayList();
    private volatile boolean h = false;
    private volatile boolean i = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected java.util.concurrent.atomic.AtomicInteger f549a = new java.util.concurrent.atomic.AtomicInteger(0);
    private java.util.concurrent.atomic.AtomicInteger j = new java.util.concurrent.atomic.AtomicInteger(0);
    private java.util.concurrent.atomic.AtomicInteger l = new java.util.concurrent.atomic.AtomicInteger(0);
    private volatile boolean m = false;
    private com.tencent.hlyyb.common.c.k n = new com.tencent.hlyyb.common.c.f(this);
    private final java.lang.Runnable o = new com.tencent.hlyyb.common.c.h(this);
    private final java.lang.Runnable p = new com.tencent.hlyyb.common.c.i(this);
    private final java.lang.String b = a();

    public a() {
        com.tencent.hlyyb.common.c.l.a(com.tencent.hlyyb.common.a.a());
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(this.b, 10);
        handlerThread.start();
        this.d = new android.os.Handler(handlerThread.getLooper());
        this.e = new com.tencent.hlyyb.common.c.a.a();
        a(true);
        b(true, false);
        this.k = b();
    }

    static /* synthetic */ void a(com.tencent.hlyyb.common.c.a aVar, int i) {
        int iB = com.tencent.hlyyb.common.d.j.b("report_using_traffic", 0, false);
        if (iB == 0) {
            com.tencent.hlyyb.common.d.j.a("report_traffic_last_time", java.lang.System.currentTimeMillis(), false);
        }
        com.tencent.hlyyb.common.d.j.a("report_using_traffic", iB + i, false);
    }

    private void a(boolean z) {
        if (z) {
            this.d.postDelayed(new com.tencent.hlyyb.common.c.g(this), 5000L);
        } else {
            if (this.c == 0 || android.os.SystemClock.elapsedRealtime() - this.c <= 1800000) {
                return;
            }
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, boolean z2) {
        try {
            a(false);
            if (z && z2) {
                b(false, true);
            } else {
                b(false, false);
            }
            if (!this.h) {
                if (!z) {
                    this.f.set(0);
                }
                this.h = true;
                try {
                    new com.tencent.hlyyb.common.c.e(this, z, z2).a(true);
                } catch (java.lang.Throwable unused) {
                    this.h = false;
                }
            } else if (z) {
                this.i = true;
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, boolean z2) {
        if (z2) {
            if (this.l.get() > 3) {
                this.l.set(0);
                return;
            } else {
                com.tencent.hlyyb.common.a.r.a().a(this.o, com.tencent.hlyyb.common.a.e.a("report_real_timer_interval", 1, 60, 5) * 1000);
                return;
            }
        }
        if (z) {
            com.tencent.hlyyb.common.a.r.a().a(this.p, 10000L);
        } else {
            if (this.m) {
                return;
            }
            com.tencent.hlyyb.common.a.r.a().a(this.p, com.tencent.hlyyb.common.a.e.a("report_timer_interval", 30000, 600000, 300000));
        }
    }

    static /* synthetic */ boolean b(com.tencent.hlyyb.common.c.a aVar, boolean z) {
        aVar.h = false;
        return false;
    }

    static /* synthetic */ boolean c(com.tencent.hlyyb.common.c.a aVar, boolean z) {
        aVar.i = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        java.lang.String string;
        this.c = android.os.SystemClock.elapsedRealtime();
        int iB = com.tencent.hlyyb.common.d.j.b("report_missing_event", 0, false);
        int iB2 = com.tencent.hlyyb.common.d.j.b("report_using_traffic", 0, false);
        int iA = com.tencent.hlyyb.common.a.e.a("report_using_traffic_limit", 1, 10240, 32);
        if (iB != 0 || iB2 >= (iA << 10)) {
            long jB = com.tencent.hlyyb.common.d.j.b("report_traffic_last_time", 0L, false);
            if (jB == 0) {
                com.tencent.hlyyb.common.d.j.a("report_traffic_last_time", java.lang.System.currentTimeMillis(), false);
                return;
            }
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - jB;
            java.util.HashMap map = new java.util.HashMap();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(iB2);
            map.put("B110", sb.toString());
            if (jCurrentTimeMillis < 0) {
                string = "0";
            } else {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(jCurrentTimeMillis);
                string = sb2.toString();
            }
            map.put("B112", string);
            if (iB == 0) {
                com.tencent.hlyyb.common.a.b.a.a("HLReportEvent", com.tencent.hlyyb.common.a.c(), 0, "", map, null, false);
            } else {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append(iB);
                map.put("B111", sb3.toString());
                com.tencent.hlyyb.common.a.b.a.a("HLReportEvent", com.tencent.hlyyb.common.a.c(), -500, "", map, null, false);
                com.tencent.hlyyb.common.d.j.a("report_missing_event", 0, false);
            }
            com.tencent.hlyyb.common.d.j.a("report_using_traffic", 0, false);
        }
    }

    public abstract java.lang.String a();

    public final void a(java.lang.String str, boolean z, boolean z2) {
        try {
            if (this.j.getAndIncrement() > this.k) {
                this.j.decrementAndGet();
            } else {
                new com.tencent.hlyyb.common.c.c(this, str, z, z2).a(false);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public abstract int b();

    public abstract java.lang.String c();
}
