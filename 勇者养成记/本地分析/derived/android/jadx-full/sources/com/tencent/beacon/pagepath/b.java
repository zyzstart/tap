package com.tencent.beacon.pagepath;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.annotation.TargetApi(14)
public class b implements android.app.Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f206a = java.lang.System.currentTimeMillis();
    private java.util.Map b = new java.util.HashMap();
    private long c = 0;

    private void a(android.app.Activity activity) {
        java.lang.Long lValueOf = (java.lang.Long) this.b.get(activity);
        if (lValueOf == null) {
            lValueOf = java.lang.Long.valueOf(this.f206a);
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        a(activity.getLocalClassName(), jCurrentTimeMillis - lValueOf.longValue(), jCurrentTimeMillis);
        this.b.remove(activity);
    }

    private void a(java.lang.String str, long j, long j2) {
        com.tencent.beacon.core.a.d.a().a(new com.tencent.beacon.pagepath.a(this, j2, str, j));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        this.b.put(activity, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
    }
}
