package com.tencent.open.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class j {
    private static android.os.Handler c;
    private static android.os.HandlerThread d;
    private static java.lang.Object b = new java.lang.Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.util.concurrent.Executor f728a = c();

    private static class a implements java.util.concurrent.Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final java.util.Queue f729a;
        java.lang.Runnable b;

        private a() {
            this.f729a = new java.util.LinkedList();
        }

        protected synchronized void a() {
            java.lang.Runnable runnable = (java.lang.Runnable) this.f729a.poll();
            this.b = runnable;
            if (runnable != null) {
                com.tencent.open.utils.j.f728a.execute(runnable);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final java.lang.Runnable runnable) {
            this.f729a.offer(new java.lang.Runnable() { // from class: com.tencent.open.utils.j.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        com.tencent.open.utils.j.a.this.a();
                    }
                }
            });
            if (this.b == null) {
                a();
            }
        }
    }

    public static android.os.Handler a() {
        if (c == null) {
            synchronized (com.tencent.open.utils.j.class) {
                android.os.HandlerThread handlerThread = new android.os.HandlerThread("SDK_SUB");
                d = handlerThread;
                handlerThread.start();
                c = new android.os.Handler(d.getLooper());
            }
        }
        return c;
    }

    public static void a(java.lang.Runnable runnable) {
        a().post(runnable);
    }

    public static java.util.concurrent.Executor b() {
        return new com.tencent.open.utils.j.a();
    }

    private static java.util.concurrent.Executor c() {
        java.util.concurrent.Executor threadPoolExecutor;
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());
        } else {
            try {
                java.lang.reflect.Field declaredField = android.os.AsyncTask.class.getDeclaredField("sExecutor");
                declaredField.setAccessible(true);
                threadPoolExecutor = (java.util.concurrent.Executor) declaredField.get(null);
            } catch (java.lang.Exception unused) {
                threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());
            }
        }
        if (threadPoolExecutor instanceof java.util.concurrent.ThreadPoolExecutor) {
            ((java.util.concurrent.ThreadPoolExecutor) threadPoolExecutor).setCorePoolSize(3);
        }
        return threadPoolExecutor;
    }
}
