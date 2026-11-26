package com.tencent.beacon.core.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.annotation.TargetApi(14)
public class j implements android.app.Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static android.util.SparseArray f139a = new android.util.SparseArray();
    private boolean b = false;
    private long c = 0;
    private long d = 0;
    private long e = 20000;
    private java.lang.String f = "";
    private java.util.Map g;

    public j() {
        this.g = null;
        java.util.HashMap map = new java.util.HashMap(6);
        this.g = map;
        map.put("A63", "N");
        this.g.put("A66", "F");
    }

    private long a() {
        if (this.e <= 20000) {
            java.lang.String strB = com.tencent.beacon.core.strategy.c.g().b("hotLauncher");
            if (strB != null) {
                try {
                    this.e = java.lang.Long.valueOf(strB).longValue();
                    com.tencent.beacon.core.e.d.a("[strategy] -> change launcher time: %s ms", strB);
                } catch (java.lang.NumberFormatException unused) {
                    com.tencent.beacon.core.e.d.b("[strategy] -> event param 'hotLauncher' error.", new java.lang.Object[0]);
                }
            }
            this.e++;
        }
        return this.e;
    }

    private void a(android.app.Activity activity) {
        com.tencent.beacon.core.info.a.e = true;
        b(activity);
        if (!this.b) {
            com.tencent.beacon.core.e.d.a("[event] lifecycle callback recover active user.", new java.lang.Object[0]);
            com.tencent.beacon.core.a.d.a().a(new com.tencent.beacon.core.a.i(this, activity));
            this.b = true;
        }
        if (a((android.content.Context) activity)) {
            c(activity);
        }
    }

    private void a(boolean z, android.app.Activity activity) {
        com.tencent.beacon.core.event.UserEventModule userEventModule = com.tencent.beacon.core.event.UserEventModule.getInstance();
        if (z) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (this.c > 0) {
                long j = this.d;
                if (j > 0 && j + a() <= jCurrentTimeMillis) {
                    com.tencent.beacon.core.e.d.a("[lifecycle] -> return foreground more than 20s.", new java.lang.Object[0]);
                    c(activity);
                    if (userEventModule != null) {
                        userEventModule.onAppHotLaunch();
                    }
                }
            }
            this.c = jCurrentTimeMillis;
            this.d = 0L;
            return;
        }
        long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
        this.d = jCurrentTimeMillis2;
        long j2 = this.c;
        if (800 + j2 > jCurrentTimeMillis2) {
            com.tencent.beacon.core.e.d.a("[lifecycle] -> debounce activity switch.", new java.lang.Object[0]);
            this.c = 0L;
            return;
        }
        if (j2 == 0) {
            this.c = jCurrentTimeMillis2;
        }
        if (userEventModule != null) {
            userEventModule.onAppStop();
        }
        com.tencent.beacon.core.event.TunnelModule.flushObjectsToDB(false);
    }

    private boolean a(android.content.Context context) {
        java.lang.String strA = com.tencent.beacon.core.e.b.a();
        if ("".equals(this.f)) {
            this.f = com.tencent.beacon.core.a.f.a(context).a("LAUEVE_DENGTA", "");
        }
        boolean z = false;
        if (!strA.equals(this.f)) {
            com.tencent.beacon.core.a.f.a(context).b().a("LAUEVE_DENGTA", (java.lang.Object) strA).a();
            if (!"".equals(this.f)) {
                com.tencent.beacon.core.e.d.a("[core] -> report new day launcher event.", new java.lang.Object[0]);
                z = true;
            }
            this.f = strA;
        }
        return z;
    }

    private static void b(android.app.Activity activity) {
        if (activity == null || f139a == null) {
            return;
        }
        int iHashCode = activity.hashCode();
        if (f139a.get(iHashCode) == null) {
            f139a.put(iHashCode, new java.lang.ref.WeakReference(activity));
        }
    }

    private void c(android.app.Activity activity) {
        com.tencent.beacon.core.a.d.a().a(new com.tencent.beacon.core.a.h(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        a(activity);
        a(true, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
        a(activity);
        a(false, activity);
    }
}
