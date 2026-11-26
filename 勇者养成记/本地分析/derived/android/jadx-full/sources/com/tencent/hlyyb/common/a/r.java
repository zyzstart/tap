package com.tencent.hlyyb.common.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.hlyyb.common.a.r f539a = new com.tencent.hlyyb.common.a.r();
    private java.util.Map c = new java.util.concurrent.ConcurrentHashMap();
    private java.util.Timer b = new java.util.Timer("ConnectionTimer", true);

    private r() {
    }

    public static com.tencent.hlyyb.common.a.r a() {
        return f539a;
    }

    private void a(java.lang.Runnable runnable, boolean z, long j) {
        synchronized (runnable) {
            a(runnable);
            com.tencent.hlyyb.common.a.s sVar = new com.tencent.hlyyb.common.a.s(this, runnable);
            if (z) {
                this.b.schedule(sVar, j, j);
            } else {
                this.b.schedule(sVar, j);
            }
            this.c.put(runnable, sVar);
        }
    }

    public final void a(java.lang.Runnable runnable, long j) {
        a(runnable, false, j);
    }

    public final boolean a(java.lang.Runnable runnable) {
        synchronized (runnable) {
            java.util.TimerTask timerTask = (java.util.TimerTask) this.c.get(runnable);
            if (timerTask == null) {
                return true;
            }
            this.c.remove(runnable);
            return timerTask.cancel();
        }
    }

    public final void b(java.lang.Runnable runnable, long j) {
        a(runnable, true, j);
    }
}
