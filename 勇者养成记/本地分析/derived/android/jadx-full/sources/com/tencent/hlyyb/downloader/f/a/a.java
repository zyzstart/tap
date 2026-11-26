package com.tencent.hlyyb.downloader.f.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a extends java.util.concurrent.PriorityBlockingQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.hlyyb.downloader.f.a.b f637a;
    private java.lang.Integer b;

    public a() {
        this.f637a = null;
        this.b = null;
    }

    public a(int i) {
        super(64);
        this.f637a = null;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.Runnable poll(long j, java.util.concurrent.TimeUnit timeUnit) {
        com.tencent.hlyyb.downloader.f.a.b bVar;
        java.lang.Runnable runnable = (java.lang.Runnable) super.poll(j, timeUnit);
        if (runnable == null && (bVar = this.f637a) != null) {
            bVar.a();
        }
        return runnable;
    }

    public final void a(com.tencent.hlyyb.downloader.f.a.b bVar) {
        this.f637a = bVar;
    }

    public final boolean a(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        if (this.f637a.isShutdown()) {
            throw new java.util.concurrent.RejectedExecutionException("Executor not running, can't force a command into the queue");
        }
        return super.offer(runnable, j, timeUnit);
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    public final /* synthetic */ boolean offer(java.lang.Object obj) {
        java.lang.Runnable runnable = (java.lang.Runnable) obj;
        com.tencent.hlyyb.downloader.f.a.b bVar = this.f637a;
        if (bVar == null || bVar.getPoolSize() == this.f637a.getMaximumPoolSize() || this.f637a.c() < this.f637a.getPoolSize() || this.f637a.getPoolSize() >= this.f637a.getMaximumPoolSize()) {
            return super.offer(runnable);
        }
        return false;
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public final int remainingCapacity() {
        return super.remainingCapacity();
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public final /* synthetic */ java.lang.Object take() {
        com.tencent.hlyyb.downloader.f.a.b bVar = this.f637a;
        return (bVar == null || !bVar.b()) ? (java.lang.Runnable) super.take() : poll(this.f637a.getKeepAliveTime(java.util.concurrent.TimeUnit.MILLISECONDS), java.util.concurrent.TimeUnit.MILLISECONDS);
    }
}
