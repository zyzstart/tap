package com.tencent.hlyyb.downloader.f.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b extends java.util.concurrent.ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.util.concurrent.atomic.AtomicInteger f638a;
    private final java.util.concurrent.atomic.AtomicLong b;
    private final java.util.concurrent.atomic.AtomicLong c;
    private long d;

    public b(int i, int i2, long j, java.util.concurrent.TimeUnit timeUnit, java.util.concurrent.BlockingQueue blockingQueue, java.util.concurrent.ThreadFactory threadFactory) {
        super(0, i2, 5L, timeUnit, blockingQueue, threadFactory, new com.tencent.hlyyb.downloader.f.a.d((byte) 0));
        this.f638a = new java.util.concurrent.atomic.AtomicInteger(0);
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
            java.lang.Thread.currentThread().setUncaughtExceptionHandler(new com.tencent.hlyyb.downloader.f.a.e(this));
            throw new java.lang.RuntimeException("Stopping thread to avoid potential memory leaks after a context was stopped.");
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected final void afterExecute(java.lang.Runnable runnable, java.lang.Throwable th) {
        this.f638a.decrementAndGet();
        if (th == null) {
            a();
        }
    }

    protected final boolean b() {
        return this.d >= 0 && (java.lang.Thread.currentThread() instanceof com.tencent.hlyyb.common.a.a.c) && ((com.tencent.hlyyb.common.a.a.c) java.lang.Thread.currentThread()).a() < this.b.longValue();
    }

    public final int c() {
        return this.f638a.get();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(java.lang.Runnable runnable) {
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        this.f638a.incrementAndGet();
        try {
            super.execute(runnable);
        } catch (java.util.concurrent.RejectedExecutionException e) {
            if (!(super.getQueue() instanceof com.tencent.hlyyb.downloader.f.a.a)) {
                this.f638a.decrementAndGet();
                throw e;
            }
            try {
                if (((com.tencent.hlyyb.downloader.f.a.a) super.getQueue()).a(runnable, 0L, timeUnit)) {
                    return;
                }
                this.f638a.decrementAndGet();
                throw new java.util.concurrent.RejectedExecutionException("Queue capacity is full.");
            } catch (java.lang.InterruptedException e2) {
                this.f638a.decrementAndGet();
                java.lang.Thread.interrupted();
                throw new java.util.concurrent.RejectedExecutionException(e2);
            }
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final java.util.concurrent.RunnableFuture newTaskFor(java.lang.Runnable runnable, java.lang.Object obj) {
        return (java.util.concurrent.RunnableFuture) runnable;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final java.util.concurrent.RunnableFuture newTaskFor(java.util.concurrent.Callable callable) {
        return (java.util.concurrent.RunnableFuture) callable;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final java.util.concurrent.Future submit(java.lang.Runnable runnable) {
        return super.submit(new com.tencent.hlyyb.downloader.f.a.c(this, runnable, null));
    }
}
