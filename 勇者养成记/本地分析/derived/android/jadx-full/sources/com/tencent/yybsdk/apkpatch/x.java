package com.tencent.yybsdk.apkpatch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class x implements java.util.concurrent.ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.util.concurrent.atomic.AtomicInteger f1445a = new java.util.concurrent.atomic.AtomicInteger(1);
    private final java.lang.ThreadGroup b;
    private final java.util.concurrent.atomic.AtomicInteger c = new java.util.concurrent.atomic.AtomicInteger(1);
    private final java.lang.String d;

    x(java.lang.String str) {
        java.lang.SecurityManager securityManager = java.lang.System.getSecurityManager();
        this.b = securityManager != null ? securityManager.getThreadGroup() : java.lang.Thread.currentThread().getThreadGroup();
        this.d = "pool-" + str + f1445a.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public java.lang.Thread newThread(java.lang.Runnable runnable) {
        java.lang.Thread thread = new java.lang.Thread(this.b, runnable, this.d + this.c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
