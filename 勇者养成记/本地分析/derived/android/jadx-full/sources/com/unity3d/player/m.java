package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class m implements java.lang.Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile java.lang.Thread.UncaughtExceptionHandler f1639a;

    m() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final synchronized boolean a() {
        boolean z;
        java.lang.Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = java.lang.Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == this) {
            z = false;
        } else {
            this.f1639a = defaultUncaughtExceptionHandler;
            java.lang.Thread.setDefaultUncaughtExceptionHandler(this);
            z = true;
        }
        return z;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        try {
            java.lang.Error error = new java.lang.Error(java.lang.String.format("FATAL EXCEPTION [%s]\n", thread.getName()) + java.lang.String.format("Unity version     : %s\n", "2018.4.8f1") + java.lang.String.format("Device model      : %s %s\n", android.os.Build.MANUFACTURER, android.os.Build.MODEL) + java.lang.String.format("Device fingerprint: %s\n", android.os.Build.FINGERPRINT));
            error.setStackTrace(new java.lang.StackTraceElement[0]);
            error.initCause(th);
            this.f1639a.uncaughtException(thread, error);
        } catch (java.lang.Throwable unused) {
            this.f1639a.uncaughtException(thread, th);
        }
    }
}
