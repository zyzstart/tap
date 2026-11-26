package com.qq.gdt.action;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g implements android.app.Application.ActivityLifecycleCallbacks {
    private final com.qq.gdt.action.e c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f116a = 0;
    private int b = 0;
    private android.util.SparseArray d = new android.util.SparseArray();

    public g(com.qq.gdt.action.e eVar) {
        this.c = eVar;
    }

    private void a() {
        com.qq.gdt.action.h.l.a("App Enter Foreground", new java.lang.Object[0]);
        this.c.g();
    }

    private void a(android.app.Activity activity, java.lang.String str) {
        if (activity == null) {
            com.qq.gdt.action.h.l.c("acitivity == null, can't log " + str);
            return;
        }
        int iHashCode = activity.hashCode();
        this.d.put(iHashCode, java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()));
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("page_name", activity.getClass().getName());
        } catch (org.json.JSONException e) {
            com.qq.gdt.action.h.l.c(e.getMessage());
        }
        if ("PAUSE".equals(str)) {
            java.lang.Object obj = this.d.get(iHashCode);
            long jElapsedRealtime = -1;
            if (obj != null && (obj instanceof java.lang.Long)) {
                jElapsedRealtime = android.os.SystemClock.elapsedRealtime() - ((java.lang.Long) obj).longValue();
            }
            try {
                jSONObject.putOpt("duration", java.lang.Long.valueOf(jElapsedRealtime));
            } catch (org.json.JSONException e2) {
                com.qq.gdt.action.h.l.c(e2.getMessage());
            }
        }
        com.qq.gdt.action.GDTAction.logAction(str, jSONObject);
    }

    private void b() {
        com.qq.gdt.action.h.l.a("App Enter Background", new java.lang.Object[0]);
        this.c.h();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
        a(activity, "PAUSE");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        a(activity, "RESUME");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
        if (this.f116a <= 0) {
            a();
        }
        int i = this.b;
        if (i < 0) {
            this.b = i + 1;
        } else {
            this.f116a++;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.b--;
            return;
        }
        this.f116a--;
        if (this.f116a <= 0) {
            b();
        }
    }
}
