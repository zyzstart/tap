package com.tencent.beaconselfupdate.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f226a = true;
    private static com.tencent.beaconselfupdate.a.b b;

    final class a extends com.tencent.beaconselfupdate.a.b {
        private java.util.concurrent.ScheduledExecutorService b;
        private android.util.SparseArray c;

        public a() {
            this.b = null;
            this.c = null;
            this.b = java.util.concurrent.Executors.newScheduledThreadPool(3);
            this.c = new android.util.SparseArray();
        }

        @Override // com.tencent.beaconselfupdate.a.b
        public final synchronized void a(int i) {
            java.util.concurrent.ScheduledFuture scheduledFuture = (java.util.concurrent.ScheduledFuture) this.c.get(i);
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                com.tencent.beaconselfupdate.c.a.b("cancel a old future!", new java.lang.Object[0]);
                scheduledFuture.cancel(true);
            }
            this.c.remove(i);
        }

        @Override // com.tencent.beaconselfupdate.a.b
        public final synchronized void a(int i, java.lang.Runnable runnable, long j, long j2) {
            try {
                if (runnable == null) {
                    com.tencent.beaconselfupdate.c.a.d("task runner should not be null", new java.lang.Object[0]);
                    return;
                }
                long j3 = j > 0 ? j : 0L;
                long j4 = (!com.tencent.beaconselfupdate.a.b.f226a || j2 > 10000) ? j2 : 10000L;
                a(i);
                java.util.concurrent.ScheduledFuture<?> scheduledFutureScheduleAtFixedRate = this.b.scheduleAtFixedRate(runnable, j3, j4, java.util.concurrent.TimeUnit.MILLISECONDS);
                if (scheduledFutureScheduleAtFixedRate != null) {
                    com.tencent.beaconselfupdate.c.a.b("add a new future! taskId: %d , periodTime: %d", java.lang.Integer.valueOf(i), java.lang.Long.valueOf(j4));
                    this.c.put(i, scheduledFutureScheduleAtFixedRate);
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }

        @Override // com.tencent.beaconselfupdate.a.b
        public final synchronized void a(java.lang.Runnable runnable) {
            try {
                if (runnable == null) {
                    com.tencent.beaconselfupdate.c.a.d("task runner should not be null", new java.lang.Object[0]);
                } else {
                    this.b.execute(runnable);
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }

        @Override // com.tencent.beaconselfupdate.a.b
        public final synchronized void a(java.lang.Runnable runnable, long j) {
            try {
                if (runnable == null) {
                    com.tencent.beaconselfupdate.c.a.d("task runner should not be null", new java.lang.Object[0]);
                    return;
                }
                if (j <= 0) {
                    j = 0;
                }
                this.b.schedule(runnable, j, java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized com.tencent.beaconselfupdate.a.b a() {
        if (b == null) {
            b = new com.tencent.beaconselfupdate.a.b.a();
        }
        return b;
    }

    public abstract void a(int i);

    public abstract void a(int i, java.lang.Runnable runnable, long j, long j2);

    public abstract void a(java.lang.Runnable runnable);

    public abstract void a(java.lang.Runnable runnable, long j);
}
