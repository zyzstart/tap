package com.tencent.ydkbeacon.c.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c implements android.app.Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static android.util.SparseArray f1234a = new android.util.SparseArray();
    private boolean b = false;
    private long c = 0;
    private long d = 0;
    private long e = 20000;
    private java.lang.String f = "";
    private java.util.Map g;
    private com.tencent.ydkbeacon.module.StatModule h;

    public c(com.tencent.ydkbeacon.module.StatModule statModule) {
        this.h = statModule;
        java.util.HashMap map = new java.util.HashMap(6);
        this.g = map;
        map.put("A63", "N");
        this.g.put("A66", "F");
    }

    private long a() {
        if (this.e <= 20000) {
            java.lang.String strB = com.tencent.ydkbeacon.d.a.a().b("hotLauncher");
            if (strB != null) {
                try {
                    this.e = java.lang.Long.valueOf(strB).longValue();
                    com.tencent.ydkbeacon.a.e.c.a("[strategy] -> change launcher time: %s ms", strB);
                } catch (java.lang.NumberFormatException unused) {
                    com.tencent.ydkbeacon.a.e.c.b("[strategy] -> event param 'hotLauncher' error.", new java.lang.Object[0]);
                }
            }
            this.e++;
        }
        return this.e;
    }

    private void a(android.app.Activity activity) {
        com.tencent.ydkbeacon.a.c.b.f = true;
        b(activity);
        if (!this.b) {
            com.tencent.ydkbeacon.a.e.c.a("[event] lifecycle callback recover active user.", new java.lang.Object[0]);
            com.tencent.ydkbeacon.a.b.a.a().a(new com.tencent.ydkbeacon.c.a.b(this, activity));
            this.b = true;
        }
        if (b()) {
            c();
        }
    }

    private void a(boolean z, android.app.Activity activity) {
        if (z) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (this.c > 0) {
                long j = this.d;
                if (j > 0 && j + a() <= jCurrentTimeMillis) {
                    com.tencent.ydkbeacon.a.e.c.a("[lifecycle] -> return foreground more than 20s.", new java.lang.Object[0]);
                    c();
                    com.tencent.ydkbeacon.module.StatModule statModule = this.h;
                    if (statModule != null) {
                        statModule.a();
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
            com.tencent.ydkbeacon.a.e.c.a("[lifecycle] -> debounce activity switch.", new java.lang.Object[0]);
            this.c = 0L;
            return;
        }
        if (j2 == 0) {
            this.c = jCurrentTimeMillis2;
        }
        com.tencent.ydkbeacon.module.StatModule statModule2 = this.h;
        if (statModule2 != null) {
            statModule2.b();
        }
    }

    private static void b(android.app.Activity activity) {
        if (activity == null || f1234a == null) {
            return;
        }
        int iHashCode = activity.hashCode();
        if (f1234a.get(iHashCode) == null) {
            f1234a.put(iHashCode, new java.lang.ref.WeakReference(activity));
        }
    }

    private boolean b() {
        java.lang.String strC = com.tencent.ydkbeacon.a.e.b.c();
        if ("".equals(this.f)) {
            this.f = com.tencent.ydkbeacon.a.d.a.a().getString("LAUEVE_DENGTA", "");
        }
        boolean z = false;
        if (!strC.equals(this.f)) {
            com.tencent.ydkbeacon.a.d.a.a().edit().putString("LAUEVE_DENGTA", strC);
            if (!"".equals(this.f)) {
                com.tencent.ydkbeacon.a.e.c.a("[core] -> report new day launcher event.", new java.lang.Object[0]);
                z = true;
            }
            this.f = strC;
        }
        return z;
    }

    private void c() {
        com.tencent.ydkbeacon.a.b.a.a().a(new com.tencent.ydkbeacon.c.a.a(this));
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
