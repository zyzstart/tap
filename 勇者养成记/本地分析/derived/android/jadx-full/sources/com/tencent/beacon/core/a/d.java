package com.tencent.beacon.core.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f131a = true;
    protected static com.tencent.beacon.core.a.d b;

    static class a extends com.tencent.beacon.core.a.d {
        java.util.concurrent.ScheduledExecutorService c;
        android.util.SparseArray d;
        boolean e = false;

        public a() {
            this.c = null;
            this.d = null;
            this.c = java.util.concurrent.Executors.newScheduledThreadPool(4, new com.tencent.beacon.core.a.d.b());
            this.d = new android.util.SparseArray();
        }

        public a(java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
            this.c = null;
            this.d = null;
            if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
                throw new java.lang.IllegalArgumentException("ScheduledExecutorService is not valiable!");
            }
            this.c = scheduledExecutorService;
            this.d = new android.util.SparseArray();
        }

        private java.lang.Runnable b(java.lang.Runnable runnable) {
            return new com.tencent.beacon.core.a.c(this, runnable);
        }

        @Override // com.tencent.beacon.core.a.d
        public synchronized void a(int i, java.lang.Runnable runnable, long j, long j2) {
            if (this.e) {
                com.tencent.beacon.core.e.d.b("[task] was closed , should not post!", new java.lang.Object[0]);
                return;
            }
            if (runnable == null) {
                com.tencent.beacon.core.e.d.b("[task] runner should not be null", new java.lang.Object[0]);
                return;
            }
            java.lang.Runnable runnableB = b(runnable);
            long j3 = j > 0 ? j : 0L;
            long j4 = (!com.tencent.beacon.core.a.d.f131a || j2 > 10000) ? j2 : 10000L;
            a(i, true);
            com.tencent.beacon.core.a.d.c cVar = new com.tencent.beacon.core.a.d.c((java.util.concurrent.FutureTask) this.c.scheduleAtFixedRate(runnableB, j3, j4, java.util.concurrent.TimeUnit.MILLISECONDS), runnableB, j3, j4, java.util.concurrent.TimeUnit.MILLISECONDS);
            com.tencent.beacon.core.e.d.a("[task] add a new future! taskId: %d , periodTime: %d", java.lang.Integer.valueOf(i), java.lang.Long.valueOf(j4));
            this.d.put(i, cVar);
        }

        @Override // com.tencent.beacon.core.a.d
        public synchronized void a(int i, boolean z) {
            if (this.e) {
                com.tencent.beacon.core.e.d.b("[task] was closed , should all stopped!", new java.lang.Object[0]);
                return;
            }
            com.tencent.beacon.core.a.d.c cVar = (com.tencent.beacon.core.a.d.c) this.d.get(i);
            if (cVar != null && !cVar.a()) {
                com.tencent.beacon.core.e.d.a("[task] cancel a old future!", new java.lang.Object[0]);
                cVar.a(z);
            }
            this.d.remove(i);
        }

        @Override // com.tencent.beacon.core.a.d
        public synchronized void a(java.lang.Runnable runnable) {
            if (this.e) {
                com.tencent.beacon.core.e.d.b("[task] was closed , should not post!", new java.lang.Object[0]);
            } else if (runnable == null) {
                com.tencent.beacon.core.e.d.b("[task] runner should not be null", new java.lang.Object[0]);
            } else {
                this.c.execute(b(runnable));
            }
        }

        @Override // com.tencent.beacon.core.a.d
        public synchronized void a(java.lang.Runnable runnable, long j) {
            if (this.e) {
                com.tencent.beacon.core.e.d.b("[task] was closed , should not post!", new java.lang.Object[0]);
                return;
            }
            if (runnable == null) {
                com.tencent.beacon.core.e.d.b("[task] runner should not be null", new java.lang.Object[0]);
                return;
            }
            java.lang.Runnable runnableB = b(runnable);
            if (j <= 0) {
                j = 0;
            }
            this.c.schedule(runnableB, j, java.util.concurrent.TimeUnit.MILLISECONDS);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.tencent.beacon.core.a.d
        public synchronized void b() {
            com.tencent.beacon.core.e.d.a("[task] Resumed all schedule task", new java.lang.Object[0]);
            if (this.e) {
                com.tencent.beacon.core.e.d.b("task was close, should all stopped!", new java.lang.Object[0]);
                return;
            }
            for (int i = 0; i < this.d.size(); i++) {
                android.util.SparseArray sparseArray = this.d;
                com.tencent.beacon.core.a.d.c cVar = (com.tencent.beacon.core.a.d.c) sparseArray.get(sparseArray.keyAt(i));
                if (cVar != null) {
                    if (!cVar.f133a.isCancelled()) {
                        cVar.f133a.cancel(true);
                    }
                    cVar.f133a = (java.util.concurrent.FutureTask) this.c.scheduleAtFixedRate(cVar.b, cVar.c, cVar.d, cVar.e);
                }
            }
            com.tencent.beacon.core.e.d.a("[task] Resumed all schedule task", new java.lang.Object[0]);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.tencent.beacon.core.a.d
        public synchronized void b(boolean z) {
            com.tencent.beacon.core.e.d.a("[task] Start stop all schedule task", new java.lang.Object[0]);
            if (this.e) {
                com.tencent.beacon.core.e.d.b("task was close, should all stopped!", new java.lang.Object[0]);
                return;
            }
            for (int i = 0; i < this.d.size(); i++) {
                android.util.SparseArray sparseArray = this.d;
                com.tencent.beacon.core.a.d.c cVar = (com.tencent.beacon.core.a.d.c) sparseArray.get(sparseArray.keyAt(i));
                if (cVar != null && !cVar.a()) {
                    cVar.a(z);
                }
            }
            com.tencent.beacon.core.e.d.a("[task] All schedule tasks stop", new java.lang.Object[0]);
        }

        @Override // com.tencent.beacon.core.a.d
        public synchronized void c(boolean z) {
            com.tencent.beacon.core.e.d.a("[task] start", new java.lang.Object[0]);
            if (this.e) {
                com.tencent.beacon.core.e.d.b("[task] was closed , should all stopped!", new java.lang.Object[0]);
                return;
            }
            com.tencent.beacon.core.e.d.a("[task] stop All ScheduleTasks!", new java.lang.Object[0]);
            this.e = true;
            this.c.shutdown();
            this.c = null;
            this.d.clear();
            this.d = null;
            com.tencent.beacon.core.e.d.a("[task]  end", new java.lang.Object[0]);
        }
    }

    public static class b implements java.util.concurrent.ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final java.util.concurrent.atomic.AtomicInteger f132a = new java.util.concurrent.atomic.AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("beacon-thread-");
                sb.append(this.f132a.getAndIncrement());
                return new java.lang.Thread(runnable, sb.toString());
            } catch (java.lang.Exception e) {
                com.tencent.beacon.core.e.d.a(e);
                return null;
            } catch (java.lang.OutOfMemoryError unused) {
                com.tencent.beacon.core.e.d.b("[task] memory not enough, create thread failed.", new java.lang.Object[0]);
                com.tencent.beacon.core.d.i.a().a("599", "[task] BeaconThreadFactory newThread occur outOfMemoryError!");
                return null;
            }
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private java.util.concurrent.FutureTask f133a;
        private final java.lang.Runnable b;
        private final long c;
        private final long d;
        private final java.util.concurrent.TimeUnit e;

        public c(java.util.concurrent.FutureTask futureTask, java.lang.Runnable runnable, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
            this.f133a = futureTask;
            this.b = runnable;
            this.c = j;
            this.d = j2;
            this.e = timeUnit;
        }

        public boolean a() {
            return this.f133a.isCancelled();
        }

        public boolean a(boolean z) {
            return this.f133a.cancel(z);
        }
    }

    public static synchronized com.tencent.beacon.core.a.d a() {
        if (b == null) {
            b = new com.tencent.beacon.core.a.d.a();
        }
        return b;
    }

    public static com.tencent.beacon.core.a.d a(java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        return new com.tencent.beacon.core.a.d.a(scheduledExecutorService);
    }

    public static synchronized void a(com.tencent.beacon.core.a.d dVar) {
        com.tencent.beacon.core.e.d.a("[task] setInstance: " + dVar, new java.lang.Object[0]);
        com.tencent.beacon.core.a.d dVar2 = b;
        if (dVar2 != null) {
            dVar2.c(true);
        }
        b = dVar;
        com.tencent.beacon.core.e.d.a("[task] setInstance end", new java.lang.Object[0]);
    }

    public static synchronized void a(boolean z) {
        f131a = z;
    }

    public abstract void a(int i, java.lang.Runnable runnable, long j, long j2);

    public abstract void a(int i, boolean z);

    public abstract void a(java.lang.Runnable runnable);

    public abstract void a(java.lang.Runnable runnable, long j);

    public abstract void b();

    public abstract void b(boolean z);

    public abstract void c(boolean z);
}
