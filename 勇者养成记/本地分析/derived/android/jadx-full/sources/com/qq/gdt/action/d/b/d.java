package com.qq.gdt.action.d.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f90a = (int) java.util.concurrent.TimeUnit.SECONDS.toMillis(30);
    public int b = (int) java.util.concurrent.TimeUnit.SECONDS.toMillis(30);
    public java.util.concurrent.Executor c = new java.util.concurrent.ThreadPoolExecutor(3, 10, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());
    public java.util.concurrent.Executor d = new java.util.concurrent.Executor() { // from class: com.qq.gdt.action.d.b.d.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        android.os.Handler f91a = new android.os.Handler(android.os.Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            this.f91a.post(runnable);
        }
    };
}
