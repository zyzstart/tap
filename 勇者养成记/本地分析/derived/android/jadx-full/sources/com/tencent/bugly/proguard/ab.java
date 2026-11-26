package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ab extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f418a = false;
    private java.util.List<com.tencent.bugly.proguard.aa> b = java.util.Collections.synchronizedList(new java.util.ArrayList());
    private java.util.List<com.tencent.bugly.proguard.ac> c = java.util.Collections.synchronizedList(new java.util.ArrayList());

    /* JADX INFO: compiled from: BUGLY */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final com.tencent.bugly.proguard.ab f419a = new com.tencent.bugly.proguard.ab();
    }

    public static com.tencent.bugly.proguard.ab a(android.content.Context context) {
        return com.tencent.bugly.proguard.ab.a.f419a;
    }

    private void a(android.os.Handler handler) {
        if (handler == null) {
            com.tencent.bugly.proguard.x.e("removeThread handler should not be null", new java.lang.Object[0]);
            return;
        }
        for (int i = 0; i < this.b.size(); i++) {
            if (this.b.get(i).e().equals(handler.getLooper().getThread().getName())) {
                com.tencent.bugly.proguard.x.c("remove handler::%s", this.b.get(i));
                this.b.remove(i);
            }
        }
    }

    private void a(android.os.Handler handler, long j) {
        if (handler == null) {
            com.tencent.bugly.proguard.x.e("addThread handler should not be null", new java.lang.Object[0]);
            return;
        }
        java.lang.String name = handler.getLooper().getThread().getName();
        for (int i = 0; i < this.b.size(); i++) {
            if (this.b.get(i).e().equals(handler.getLooper().getThread().getName())) {
                com.tencent.bugly.proguard.x.e("addThread fail ,this thread has been added in monitor queue", new java.lang.Object[0]);
                return;
            }
        }
        this.b.add(new com.tencent.bugly.proguard.aa(handler, name, 5000L));
    }

    public final void a() {
        a(new android.os.Handler(android.os.Looper.getMainLooper()), 5000L);
    }

    public final void a(com.tencent.bugly.proguard.ac acVar) {
        if (this.c.contains(acVar)) {
            com.tencent.bugly.proguard.x.e("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new java.lang.Object[0]);
        } else {
            this.c.add(acVar);
        }
    }

    public final void b() {
        a(new android.os.Handler(android.os.Looper.getMainLooper()));
    }

    public final void b(com.tencent.bugly.proguard.ac acVar) {
        this.c.remove(acVar);
    }

    public final boolean c() {
        if (!isAlive()) {
            return false;
        }
        interrupt();
        f418a = true;
        return true;
    }

    public final boolean d() {
        if (isAlive()) {
            return false;
        }
        f418a = false;
        start();
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        setName("Bugly-ThreadMonitor");
        while (!f418a) {
            for (int i = 0; i < this.b.size(); i++) {
                this.b.get(i).a();
            }
            long jUptimeMillis = android.os.SystemClock.uptimeMillis();
            for (long jUptimeMillis2 = 2000; jUptimeMillis2 > 0 && !isInterrupted(); jUptimeMillis2 = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewConstants.HIDE_BUBBLE_TASK_DELAY - (android.os.SystemClock.uptimeMillis() - jUptimeMillis)) {
                try {
                    sleep(jUptimeMillis2);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            int iMax = 0;
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                iMax = java.lang.Math.max(iMax, this.b.get(i2).c());
            }
            if (iMax != 0 && iMax != 1) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i3 = 0; i3 < this.b.size(); i3++) {
                    com.tencent.bugly.proguard.aa aaVar = this.b.get(i3);
                    if (aaVar.b()) {
                        arrayList.add(aaVar);
                        aaVar.a(Long.MAX_VALUE);
                        com.tencent.bugly.proguard.x.d("to avoid upload block state repeated. as thread is blocked ,it may not be monitor until thread is unblock or this state has not been dealed with.", new java.lang.Object[0]);
                    }
                }
                int i4 = 0;
                boolean z = false;
                while (i4 < arrayList.size()) {
                    com.tencent.bugly.proguard.aa aaVar2 = (com.tencent.bugly.proguard.aa) arrayList.get(i4);
                    java.lang.Thread threadD = aaVar2.d();
                    boolean z2 = z;
                    for (int i5 = 0; i5 < this.c.size(); i5++) {
                        if (this.c.get(i5).a(threadD)) {
                            z2 = true;
                        }
                    }
                    if (!z2 && aaVar2.e().contains("main")) {
                        aaVar2.f();
                        com.tencent.bugly.proguard.x.d("although thread is blocked ,may not be anr error,so restore handler check wait time and restart check main thread", new java.lang.Object[0]);
                    }
                    i4++;
                    z = z2;
                }
            }
        }
    }
}
