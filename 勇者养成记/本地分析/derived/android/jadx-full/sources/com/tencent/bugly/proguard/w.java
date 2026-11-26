package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.util.concurrent.atomic.AtomicInteger f453a = new java.util.concurrent.atomic.AtomicInteger(1);
    private static com.tencent.bugly.proguard.w b;
    private java.util.concurrent.ScheduledExecutorService c;

    protected w() {
        this.c = null;
        this.c = java.util.concurrent.Executors.newScheduledThreadPool(3, new java.util.concurrent.ThreadFactory(this) { // from class: com.tencent.bugly.proguard.w.1
            @Override // java.util.concurrent.ThreadFactory
            public final java.lang.Thread newThread(java.lang.Runnable runnable) {
                java.lang.Thread thread = new java.lang.Thread(runnable);
                thread.setName("BuglyThread-" + com.tencent.bugly.proguard.w.f453a.getAndIncrement());
                return thread;
            }
        });
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService = this.c;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            com.tencent.bugly.proguard.x.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new java.lang.Object[0]);
        }
    }

    public static synchronized com.tencent.bugly.proguard.w a() {
        if (b == null) {
            b = new com.tencent.bugly.proguard.w();
        }
        return b;
    }

    public final synchronized boolean a(java.lang.Runnable runnable) {
        if (!c()) {
            com.tencent.bugly.proguard.x.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new java.lang.Object[0]);
            return false;
        }
        if (runnable == null) {
            com.tencent.bugly.proguard.x.d("[AsyncTaskHandler] Task input is null.", new java.lang.Object[0]);
            return false;
        }
        com.tencent.bugly.proguard.x.c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
        try {
            this.c.execute(runnable);
            return true;
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.b.c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final synchronized boolean a(java.lang.Runnable runnable, long j) {
        if (!c()) {
            com.tencent.bugly.proguard.x.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new java.lang.Object[0]);
            return false;
        }
        if (runnable == null) {
            com.tencent.bugly.proguard.x.d("[AsyncTaskHandler] Task input is null.", new java.lang.Object[0]);
            return false;
        }
        if (j <= 0) {
            j = 0;
        }
        com.tencent.bugly.proguard.x.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", java.lang.Long.valueOf(j), runnable.getClass().getName());
        try {
            this.c.schedule(runnable, j, java.util.concurrent.TimeUnit.MILLISECONDS);
            return true;
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.b.c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final synchronized void b() {
        if (this.c != null && !this.c.isShutdown()) {
            com.tencent.bugly.proguard.x.c("[AsyncTaskHandler] Close async handler.", new java.lang.Object[0]);
            this.c.shutdownNow();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized boolean c() {
        return (this.c == null || this.c.isShutdown()) ? false : true;
    }
}
