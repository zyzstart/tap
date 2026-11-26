package com.tencent.beaconselfupdate.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class f implements android.app.Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static android.util.SparseArray f239a = new android.util.SparseArray();

    private static void a(android.app.Activity activity) {
        if (activity == null || f239a == null) {
            return;
        }
        int iHashCode = activity.hashCode();
        if (f239a.get(iHashCode) == null) {
            f239a.put(iHashCode, new java.lang.ref.WeakReference(activity));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(android.app.Activity activity) {
        com.tencent.beaconselfupdate.a.a.b = true;
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(android.app.Activity activity) {
        com.tencent.beaconselfupdate.a.a.b = true;
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(android.app.Activity activity) {
        com.tencent.beaconselfupdate.a.a.b = true;
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        com.tencent.beaconselfupdate.a.a.b = true;
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(android.app.Activity activity) {
        com.tencent.beaconselfupdate.a.a.b = true;
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(android.app.Activity activity) {
        com.tencent.beaconselfupdate.a.a.b = true;
        a(activity);
    }
}
