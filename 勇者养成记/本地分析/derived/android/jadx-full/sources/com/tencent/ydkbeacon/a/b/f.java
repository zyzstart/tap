package com.tencent.ydkbeacon.a.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f extends com.tencent.ydkbeacon.a.b.a {
    private static final int b;
    private static final int c;
    private static final java.util.concurrent.atomic.AtomicInteger d;
    private final java.util.concurrent.ScheduledExecutorService e;
    private final android.util.SparseArray f;
    private final android.util.SparseArray g;
    private boolean h;
    private final com.tencent.ydkbeacon.a.b.g i;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private java.util.concurrent.Future f1183a;
        private final java.lang.Runnable b;
        private final long c;
        private final long d;
        private final java.util.concurrent.TimeUnit e;

        a(java.util.concurrent.Future future, java.lang.Runnable runnable, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
            this.f1183a = future;
            this.b = runnable;
            this.c = j;
            this.d = j2;
            this.e = timeUnit;
        }

        boolean a() {
            return this.f1183a.isCancelled();
        }

        boolean a(boolean z) {
            return this.f1183a.cancel(z);
        }
    }

    static {
        int iAvailableProcessors = java.lang.Runtime.getRuntime().availableProcessors();
        b = iAvailableProcessors;
        c = java.lang.Math.max(2, java.lang.Math.min(iAvailableProcessors - 1, 3));
        d = new java.util.concurrent.atomic.AtomicInteger(0);
    }

    f() {
        this(null);
    }

    f(java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        this.h = false;
        com.tencent.ydkbeacon.a.b.g gVar = new com.tencent.ydkbeacon.a.b.g();
        this.i = gVar;
        this.e = scheduledExecutorService == null ? java.util.concurrent.Executors.newScheduledThreadPool(c, gVar) : scheduledExecutorService;
        this.f = new android.util.SparseArray();
        this.g = new android.util.SparseArray();
    }

    private java.lang.Runnable b(java.lang.Runnable runnable) {
        return new com.tencent.ydkbeacon.a.b.e(this, runnable);
    }

    private boolean d() {
        if (!this.h) {
            return false;
        }
        com.tencent.ydkbeacon.a.e.c.b("[task] was closed , should all stopped!", new java.lang.Object[0]);
        return true;
    }

    @Override // com.tencent.ydkbeacon.a.b.a
    public synchronized android.os.Handler a(int i) {
        android.os.Handler handler;
        handler = (android.os.Handler) this.g.get(i);
        if (handler == null) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread(this.i.a());
            handlerThread.start();
            handler = new android.os.Handler(handlerThread.getLooper());
        }
        this.g.put(i, handler);
        return handler;
    }

    @Override // com.tencent.ydkbeacon.a.b.a
    public synchronized void a(int i, long j, long j2, @android.support.annotation.NonNull java.lang.Runnable runnable) {
        if (d()) {
            return;
        }
        com.tencent.ydkbeacon.a.b.f.a aVar = (com.tencent.ydkbeacon.a.b.f.a) this.f.get(i);
        if (aVar == null || aVar.a()) {
            java.lang.Runnable runnableB = b(runnable);
            if (j <= 0) {
                j = 0;
            }
            if (j2 < 500) {
                j2 = 500;
            }
            com.tencent.ydkbeacon.a.b.f.a aVar2 = new com.tencent.ydkbeacon.a.b.f.a(this.e.scheduleAtFixedRate(runnableB, j, j2, java.util.concurrent.TimeUnit.MILLISECONDS), runnableB, j, j2, java.util.concurrent.TimeUnit.MILLISECONDS);
            com.tencent.ydkbeacon.a.e.c.a("[task] add a new polling task! taskId: %d , periodTime: %d", java.lang.Integer.valueOf(i), java.lang.Long.valueOf(j2));
            this.f.put(i, aVar2);
        }
    }

    @Override // com.tencent.ydkbeacon.a.b.a
    public void a(int i, boolean z) {
        com.tencent.ydkbeacon.a.b.f.a aVar = (com.tencent.ydkbeacon.a.b.f.a) this.f.get(i);
        if (aVar == null || aVar.a()) {
            return;
        }
        com.tencent.ydkbeacon.a.e.c.a("[task] cancel a old pollingTaskWrapper!", new java.lang.Object[0]);
        aVar.a(z);
    }

    @Override // com.tencent.ydkbeacon.a.b.a
    public synchronized void a(long j, @android.support.annotation.NonNull java.lang.Runnable runnable) {
        if (d()) {
            return;
        }
        java.lang.Runnable runnableB = b(runnable);
        if (j <= 0) {
            j = 0;
        }
        this.e.schedule(runnableB, j, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    @Override // com.tencent.ydkbeacon.a.b.a
    public synchronized void a(@android.support.annotation.NonNull java.lang.Runnable runnable) {
        if (d()) {
            return;
        }
        this.e.execute(b(runnable));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.ydkbeacon.a.b.a
    public synchronized void a(boolean z) {
        if (d()) {
            return;
        }
        for (int i = 0; i < this.f.size(); i++) {
            a(this.f.keyAt(i), z);
        }
        com.tencent.ydkbeacon.a.e.c.a("[task] All schedule tasks stop", new java.lang.Object[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.ydkbeacon.a.b.a
    public synchronized void b() {
        com.tencent.ydkbeacon.a.e.c.a("[task] Resumed all schedule task", new java.lang.Object[0]);
        if (d()) {
            return;
        }
        for (int i = 0; i < this.f.size(); i++) {
            b(this.f.keyAt(i));
        }
        com.tencent.ydkbeacon.a.e.c.a("[task] Resumed all schedule task", new java.lang.Object[0]);
    }

    @Override // com.tencent.ydkbeacon.a.b.a
    public synchronized void b(int i) {
        com.tencent.ydkbeacon.a.b.f.a aVar = (com.tencent.ydkbeacon.a.b.f.a) this.f.get(i);
        if (aVar != null) {
            if (!aVar.a()) {
            } else {
                aVar.f1183a = this.e.scheduleAtFixedRate(aVar.b, aVar.c, aVar.d, aVar.e);
            }
        }
    }
}
