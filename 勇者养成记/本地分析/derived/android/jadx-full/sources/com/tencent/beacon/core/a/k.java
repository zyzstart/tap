package com.tencent.beacon.core.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class k implements android.app.Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f140a = 0;
    private static boolean b = true;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
        int i = f140a + 1;
        f140a = i;
        if (i == 1) {
            if (b) {
                b = false;
                com.tencent.beacon.core.e.d.a("[lifecycle] Is App First Launch! ", new java.lang.Object[0]);
                return;
            }
            com.tencent.beacon.core.e.d.a("[lifecycle] App in the Foreground! ", new java.lang.Object[0]);
            if (com.tencent.beacon.upload.UploadStrategy.IS_STOP_BACKGROUND_TASK) {
                com.tencent.beacon.core.d.k.a(activity.getApplicationContext()).a(true);
                com.tencent.beacon.core.a.d.a().b();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
        int i = f140a - 1;
        f140a = i;
        if (i == 0) {
            com.tencent.beacon.core.e.d.a("[lifecycle] App in the Background! ", new java.lang.Object[0]);
            if (com.tencent.beacon.upload.UploadStrategy.IS_STOP_BACKGROUND_TASK) {
                com.tencent.beacon.core.a.d.a().b(false);
                com.tencent.beacon.core.d.k.a(activity.getApplicationContext()).a(false);
            }
        }
    }
}
