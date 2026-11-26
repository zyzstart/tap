package com.tencent.msdk.dns.base.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.tencent.msdk.dns.base.a.b f645a = new com.tencent.msdk.dns.base.a.a.C0027a();
    public static final com.tencent.msdk.dns.base.a.b b = new com.tencent.msdk.dns.base.a.a.b();

    /* JADX INFO: renamed from: com.tencent.msdk.dns.base.a.a$a, reason: collision with other inner class name */
    private static class C0027a implements com.tencent.msdk.dns.base.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private android.os.Handler f647a;
        private java.util.Map b = new java.util.concurrent.ConcurrentHashMap();

        C0027a() {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("httpdns-main");
            handlerThread.start();
            this.f647a = new android.os.Handler(handlerThread.getLooper());
        }

        @Override // com.tencent.msdk.dns.base.a.b
        public void a(java.lang.Runnable runnable) {
            java.lang.Runnable runnable2;
            if (runnable == null || (runnable2 = (java.lang.Runnable) this.b.get(runnable)) == null) {
                return;
            }
            this.f647a.removeCallbacks(runnable2);
        }

        @Override // com.tencent.msdk.dns.base.a.b
        public void a(java.lang.Runnable runnable, long j) {
            if (runnable == null || 0 > j) {
                return;
            }
            java.lang.Runnable runnableB = com.tencent.msdk.dns.base.a.a.b(runnable);
            this.b.put(runnable, runnableB);
            this.f647a.postDelayed(runnableB, j);
        }

        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            if (runnable != null) {
                this.f647a.post(com.tencent.msdk.dns.base.a.a.b(runnable));
            }
        }
    }

    private static class b implements com.tencent.msdk.dns.base.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private java.util.concurrent.Executor f648a;

        private b() {
            this.f648a = java.util.concurrent.Executors.newCachedThreadPool(new java.util.concurrent.ThreadFactory() { // from class: com.tencent.msdk.dns.base.a.a.b.1
                private java.util.concurrent.atomic.AtomicInteger b = new java.util.concurrent.atomic.AtomicInteger(0);

                @Override // java.util.concurrent.ThreadFactory
                public java.lang.Thread newThread(java.lang.Runnable runnable) {
                    java.lang.Thread thread = new java.lang.Thread(runnable, "httpdns-work-" + this.b.getAndIncrement());
                    if (thread.isDaemon()) {
                        thread.setDaemon(false);
                    }
                    return thread;
                }
            });
        }

        @Override // com.tencent.msdk.dns.base.a.b
        public void a(java.lang.Runnable runnable) {
        }

        @Override // com.tencent.msdk.dns.base.a.b
        public void a(java.lang.Runnable runnable, long j) {
        }

        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            if (runnable != null) {
                this.f648a.execute(com.tencent.msdk.dns.base.a.a.b(runnable));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.Runnable b(final java.lang.Runnable runnable) {
        return new java.lang.Runnable() { // from class: com.tencent.msdk.dns.base.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (runnable != null) {
                        runnable.run();
                    }
                } catch (java.lang.Exception e) {
                    com.tencent.msdk.dns.base.log.DnsLog.w(e, "Run task in executor failed", new java.lang.Object[0]);
                }
            }
        };
    }
}
