package com.tencent.qqdownloader.pay.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {
    private static com.tencent.qqdownloader.pay.b.b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.util.concurrent.ScheduledExecutorService f760a;

    private b() {
        try {
            this.f760a = java.util.concurrent.Executors.newScheduledThreadPool(10, new com.tencent.qqdownloader.pay.a.c("http_thread_exp"));
        } catch (java.lang.Throwable unused) {
            this.f760a = java.util.concurrent.Executors.newScheduledThreadPool(10, new com.tencent.qqdownloader.pay.a.c("http_thread_exp"));
        }
    }

    public static final synchronized com.tencent.qqdownloader.pay.b.b a() {
        if (b == null) {
            b = new com.tencent.qqdownloader.pay.b.b();
        }
        return b;
    }

    public void a(java.lang.Runnable runnable) {
        try {
            this.f760a.submit(runnable);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
