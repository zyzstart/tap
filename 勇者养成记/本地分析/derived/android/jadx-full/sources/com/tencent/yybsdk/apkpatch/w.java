package com.tencent.yybsdk.apkpatch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class w extends java.util.concurrent.ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.lang.String f1444a;
    private java.util.List b;

    public w(int i, int i2, long j, java.util.concurrent.TimeUnit timeUnit, java.util.concurrent.BlockingQueue blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue, new com.tencent.yybsdk.apkpatch.x("apkpatch"), new java.util.concurrent.ThreadPoolExecutor.AbortPolicy());
        this.f1444a = "ApkPatchThreadPoolExecutor";
        this.b = java.util.Collections.synchronizedList(new java.util.ArrayList());
    }

    private void a() {
        java.util.Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((com.tencent.yybsdk.apkpatch.a) ((java.lang.Runnable) it.next())).f1390a.b(this.b.size());
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(java.lang.Runnable runnable, java.lang.Throwable th) {
        super.afterExecute(runnable, th);
        if (!(runnable instanceof com.tencent.yybsdk.apkpatch.a) || th != null) {
            com.tencent.yybsdk.apkpatch.f.a.d("ApkPatchThreadPoolExecutor", "r: " + runnable);
            com.tencent.yybsdk.apkpatch.f.a.d("ApkPatchThreadPoolExecutor", "t: " + th);
            return;
        }
        java.lang.Object obj = null;
        com.tencent.yybsdk.apkpatch.a aVar = (com.tencent.yybsdk.apkpatch.a) runnable;
        try {
            obj = ((java.util.concurrent.Future) runnable).get();
        } catch (java.lang.InterruptedException e) {
            e = e;
            th = e;
        } catch (java.util.concurrent.CancellationException e2) {
            e = e2;
            th = e;
        } catch (java.util.concurrent.ExecutionException e3) {
            th = e3.getCause();
        }
        if (obj == null) {
            th.printStackTrace();
            com.tencent.yybsdk.apkpatch.f.a.c("ApkPatchThreadPoolExecutor", "result == null, exception: " + th.getClass().getSimpleName());
        }
        this.b.remove(aVar);
        aVar.f1390a.a();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(java.lang.Thread thread, java.lang.Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this.b.add(runnable);
        try {
            a();
        } catch (java.lang.Throwable unused) {
        }
    }
}
