package com.tencent.qqdownloader.pay.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c implements java.util.concurrent.ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.util.concurrent.atomic.AtomicInteger f741a = new java.util.concurrent.atomic.AtomicInteger(1);
    public final java.lang.ThreadGroup b;
    public final java.util.concurrent.atomic.AtomicInteger c = new java.util.concurrent.atomic.AtomicInteger(1);
    public final java.lang.String d;

    public c(java.lang.String str) {
        java.lang.String str2;
        java.lang.SecurityManager securityManager = java.lang.System.getSecurityManager();
        this.b = securityManager != null ? securityManager.getThreadGroup() : java.lang.Thread.currentThread().getThreadGroup();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("pool-");
        sb.append(f741a.getAndIncrement());
        if (android.text.TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = "-" + str;
        }
        sb.append(str2);
        sb.append("-thread-");
        this.d = sb.toString();
    }

    @Override // java.util.concurrent.ThreadFactory
    public java.lang.Thread newThread(java.lang.Runnable runnable) {
        java.lang.Thread thread = new java.lang.Thread(this.b, runnable, this.d + this.c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 1) {
            thread.setPriority(1);
        }
        return thread;
    }
}
