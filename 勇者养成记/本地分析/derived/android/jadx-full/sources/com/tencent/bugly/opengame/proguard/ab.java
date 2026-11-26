package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ab extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f376a = false;
    private java.util.List b = java.util.Collections.synchronizedList(new java.util.ArrayList());
    private java.util.List c = java.util.Collections.synchronizedList(new java.util.ArrayList());

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final com.tencent.bugly.opengame.proguard.ab f377a = new com.tencent.bugly.opengame.proguard.ab();
    }

    public static com.tencent.bugly.opengame.proguard.ab a(android.content.Context context) {
        return com.tencent.bugly.opengame.proguard.ab.a.f377a;
    }

    private void a(android.os.Handler handler) {
        if (handler == null) {
            com.tencent.bugly.opengame.proguard.x.e("removeThread handler should not be null", new java.lang.Object[0]);
            return;
        }
        for (int i = 0; i < this.b.size(); i++) {
            if (((com.tencent.bugly.opengame.proguard.aa) this.b.get(i)).e().equals(handler.getLooper().getThread().getName())) {
                com.tencent.bugly.opengame.proguard.x.c("remove handler::%s", this.b.get(i));
                this.b.remove(i);
            }
        }
    }

    private void a(android.os.Handler handler, long j) {
        if (handler == null) {
            com.tencent.bugly.opengame.proguard.x.e("addThread handler should not be null", new java.lang.Object[0]);
            return;
        }
        java.lang.String name = handler.getLooper().getThread().getName();
        for (int i = 0; i < this.b.size(); i++) {
            if (((com.tencent.bugly.opengame.proguard.aa) this.b.get(i)).e().equals(handler.getLooper().getThread().getName())) {
                com.tencent.bugly.opengame.proguard.x.e("addThread fail ,this thread has been added in monitor queue", new java.lang.Object[0]);
                return;
            }
        }
        this.b.add(new com.tencent.bugly.opengame.proguard.aa(handler, name, 5000L));
    }

    public final void a() {
        a(new android.os.Handler(android.os.Looper.getMainLooper()), 5000L);
    }

    public final void a(com.tencent.bugly.opengame.proguard.ac acVar) {
        if (this.c.contains(acVar)) {
            com.tencent.bugly.opengame.proguard.x.e("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new java.lang.Object[0]);
        } else {
            this.c.add(acVar);
        }
    }

    public final void b() {
        a(new android.os.Handler(android.os.Looper.getMainLooper()));
    }

    public final void b(com.tencent.bugly.opengame.proguard.ac acVar) {
        this.c.remove(acVar);
    }

    public final boolean c() {
        if (!isAlive()) {
            return false;
        }
        interrupt();
        f376a = true;
        return true;
    }

    public final boolean d() {
        if (isAlive()) {
            return false;
        }
        f376a = false;
        start();
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        setName("Bugly-ThreadMonitor");
        while (!f376a) {
            for (int i = 0; i < this.b.size(); i++) {
                ((com.tencent.bugly.opengame.proguard.aa) this.b.get(i)).a();
            }
            long jUptimeMillis = android.os.SystemClock.uptimeMillis();
            for (long jUptimeMillis2 = 2000; jUptimeMillis2 > 0 && !isInterrupted(); jUptimeMillis2 = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewConstants.HIDE_BUBBLE_TASK_DELAY - (android.os.SystemClock.uptimeMillis() - jUptimeMillis)) {
                try {
                    java.lang.Thread.sleep(jUptimeMillis2);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            int iMax = 0;
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                iMax = java.lang.Math.max(iMax, ((com.tencent.bugly.opengame.proguard.aa) this.b.get(i2)).c());
            }
            if (iMax != 0 && iMax != 1) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i3 = 0; i3 < this.b.size(); i3++) {
                    com.tencent.bugly.opengame.proguard.aa aaVar = (com.tencent.bugly.opengame.proguard.aa) this.b.get(i3);
                    if (aaVar.b()) {
                        arrayList.add(aaVar);
                        aaVar.a(Long.MAX_VALUE);
                        com.tencent.bugly.opengame.proguard.x.d("to avoid upload block state repeated. as thread is blocked ,it may not be monitor until thread is unblock or this state has not been dealed with.", new java.lang.Object[0]);
                    }
                }
                int i4 = 0;
                boolean z = false;
                while (i4 < arrayList.size()) {
                    com.tencent.bugly.opengame.proguard.aa aaVar2 = (com.tencent.bugly.opengame.proguard.aa) arrayList.get(i4);
                    java.lang.Thread threadD = aaVar2.d();
                    boolean z2 = z;
                    for (int i5 = 0; i5 < this.c.size(); i5++) {
                        if (((com.tencent.bugly.opengame.proguard.ac) this.c.get(i5)).a(threadD)) {
                            z2 = true;
                        }
                    }
                    if (!z2 && aaVar2.e().contains("main")) {
                        aaVar2.f();
                        com.tencent.bugly.opengame.proguard.x.d("although thread is blocked ,may not be anr error,so restore handler check wait time and restart check main thread", new java.lang.Object[0]);
                    }
                    i4++;
                    z = z2;
                }
            }
        }
    }
}
