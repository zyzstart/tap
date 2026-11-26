package com.tencent.hlyyb.common.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b extends java.util.concurrent.LinkedBlockingQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.hlyyb.common.a.a.d f521a;
    private java.lang.Integer b;

    public b() {
        this.f521a = null;
        this.b = null;
    }

    public b(int i) {
        super(16);
        this.f521a = null;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.Runnable poll(long j, java.util.concurrent.TimeUnit timeUnit) {
        com.tencent.hlyyb.common.a.a.d dVar;
        java.lang.Runnable runnable = (java.lang.Runnable) super.poll(j, timeUnit);
        if (runnable == null && (dVar = this.f521a) != null) {
            dVar.a();
        }
        return runnable;
    }

    public final void a(com.tencent.hlyyb.common.a.a.d dVar) {
        this.f521a = dVar;
    }

    public final boolean a(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        if (this.f521a.isShutdown()) {
            throw new java.util.concurrent.RejectedExecutionException("Executor not running, can't force a command into the queue");
        }
        return super.offer(runnable, j, timeUnit);
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    public final /* synthetic */ boolean offer(java.lang.Object obj) {
        java.lang.Runnable runnable = (java.lang.Runnable) obj;
        com.tencent.hlyyb.common.a.a.d dVar = this.f521a;
        if (dVar == null || dVar.getPoolSize() == this.f521a.getMaximumPoolSize() || this.f521a.c() < this.f521a.getPoolSize() || this.f521a.getPoolSize() >= this.f521a.getMaximumPoolSize()) {
            return super.offer(runnable);
        }
        return false;
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
    public final int remainingCapacity() {
        return super.remainingCapacity();
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
    public final /* synthetic */ java.lang.Object take() {
        com.tencent.hlyyb.common.a.a.d dVar = this.f521a;
        return (dVar == null || !dVar.b()) ? (java.lang.Runnable) super.take() : poll(this.f521a.getKeepAliveTime(java.util.concurrent.TimeUnit.MILLISECONDS), java.util.concurrent.TimeUnit.MILLISECONDS);
    }
}
