package com.tencent.yybsdk.apkpatch.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g extends java.util.concurrent.ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1401a;
    private java.util.concurrent.CountDownLatch b;

    public g(int i) {
        super(3, 3, 30L, java.util.concurrent.TimeUnit.SECONDS, new com.tencent.yybsdk.apkpatch.c.d(10), new com.tencent.yybsdk.apkpatch.c.h("patch64"));
        this.f1401a = i;
        this.b = new java.util.concurrent.CountDownLatch(i);
    }

    public void a() throws java.lang.InterruptedException {
        if (isShutdown()) {
            return;
        }
        this.b.await();
    }

    public void a(int i) {
        this.f1401a = i;
        this.b = new java.util.concurrent.CountDownLatch(i);
    }

    public boolean a(long j, java.util.concurrent.TimeUnit timeUnit) {
        if (isShutdown()) {
            return true;
        }
        return this.b.await(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(java.lang.Runnable runnable, java.lang.Throwable th) {
        super.afterExecute(runnable, th);
        this.b.countDown();
        ((com.tencent.yybsdk.apkpatch.c.e) runnable).a(d());
    }

    public void b() {
        while (getActiveCount() + getQueue().size() != 0) {
            try {
                java.lang.Thread.sleep(100L);
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(java.lang.Thread thread, java.lang.Runnable runnable) {
        super.beforeExecute(thread, runnable);
    }

    public void c() {
        this.b.countDown();
    }

    public int d() {
        return this.f1401a - ((int) this.b.getCount());
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public java.util.List shutdownNow() {
        while (this.b.getCount() > 0) {
            this.b.countDown();
        }
        return super.shutdownNow();
    }
}
