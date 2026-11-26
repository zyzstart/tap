package com.tencent.hlyyb.common.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d extends java.util.concurrent.ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.util.concurrent.atomic.AtomicInteger f523a;
    private final java.util.concurrent.atomic.AtomicLong b;
    private final java.util.concurrent.atomic.AtomicLong c;
    private long d;

    public d(int i, int i2, long j, java.util.concurrent.TimeUnit timeUnit, java.util.concurrent.BlockingQueue blockingQueue, java.util.concurrent.ThreadFactory threadFactory) {
        super(0, i2, 5L, timeUnit, blockingQueue, threadFactory, new com.tencent.hlyyb.common.a.a.e((byte) 0));
        this.f523a = new java.util.concurrent.atomic.AtomicInteger(0);
        this.b = new java.util.concurrent.atomic.AtomicLong(0L);
        this.c = new java.util.concurrent.atomic.AtomicLong(0L);
        this.d = 1000L;
    }

    protected final void a() {
        if (b()) {
            long jLongValue = this.c.longValue();
            if (this.d + jLongValue >= java.lang.System.currentTimeMillis() || !this.c.compareAndSet(jLongValue, java.lang.System.currentTimeMillis() + 1)) {
                return;
            }
            java.lang.Thread.currentThread().setUncaughtExceptionHandler(new com.tencent.hlyyb.common.a.a.f(this));
            throw new java.lang.RuntimeException("Stopping thread to avoid potential memory leaks after a context was stopped.");
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected final void afterExecute(java.lang.Runnable runnable, java.lang.Throwable th) {
        this.f523a.decrementAndGet();
        if (th == null) {
            a();
        }
    }

    protected final boolean b() {
        return this.d >= 0 && (java.lang.Thread.currentThread() instanceof com.tencent.hlyyb.common.a.a.c) && ((com.tencent.hlyyb.common.a.a.c) java.lang.Thread.currentThread()).a() < this.b.longValue();
    }

    public final int c() {
        return this.f523a.get();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(java.lang.Runnable runnable) {
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        this.f523a.incrementAndGet();
        try {
            super.execute(runnable);
        } catch (java.util.concurrent.RejectedExecutionException e) {
            if (!(super.getQueue() instanceof com.tencent.hlyyb.common.a.a.b)) {
                this.f523a.decrementAndGet();
                throw e;
            }
            try {
                if (((com.tencent.hlyyb.common.a.a.b) super.getQueue()).a(runnable, 0L, timeUnit)) {
                    return;
                }
                this.f523a.decrementAndGet();
                throw new java.util.concurrent.RejectedExecutionException("Queue capacity is full.");
            } catch (java.lang.InterruptedException e2) {
                this.f523a.decrementAndGet();
                java.lang.Thread.interrupted();
                throw new java.util.concurrent.RejectedExecutionException(e2);
            }
        }
    }
}
