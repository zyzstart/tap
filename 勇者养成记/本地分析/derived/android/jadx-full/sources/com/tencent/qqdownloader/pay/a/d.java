package com.tencent.qqdownloader.pay.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.tencent.qqdownloader.pay.a.d f742a;
    public java.util.concurrent.ScheduledExecutorService b;

    public d() {
        try {
            this.b = java.util.concurrent.Executors.newScheduledThreadPool(7, new com.tencent.qqdownloader.pay.a.c("temporary"));
        } catch (java.lang.Throwable unused) {
            this.b = java.util.concurrent.Executors.newScheduledThreadPool(7, new com.tencent.qqdownloader.pay.a.c("temporary_exp"));
        }
    }

    public static synchronized com.tencent.qqdownloader.pay.a.d a() {
        if (f742a == null) {
            f742a = new com.tencent.qqdownloader.pay.a.d();
        }
        return f742a;
    }

    public void a(java.lang.Runnable runnable) {
        try {
            this.b.submit(runnable);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
