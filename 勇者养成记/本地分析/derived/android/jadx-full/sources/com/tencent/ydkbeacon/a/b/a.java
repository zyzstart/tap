package com.tencent.ydkbeacon.a.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static volatile com.tencent.ydkbeacon.a.b.a f1178a;

    public static synchronized com.tencent.ydkbeacon.a.b.a a() {
        if (f1178a == null) {
            f1178a = new com.tencent.ydkbeacon.a.b.f();
        }
        return f1178a;
    }

    public static synchronized void a(@android.support.annotation.NonNull java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        if (f1178a == null) {
            f1178a = new com.tencent.ydkbeacon.a.b.f(scheduledExecutorService);
        }
    }

    public abstract android.os.Handler a(int i);

    public abstract void a(int i, long j, long j2, @android.support.annotation.NonNull java.lang.Runnable runnable);

    public abstract void a(int i, boolean z);

    public abstract void a(long j, @android.support.annotation.NonNull java.lang.Runnable runnable);

    public abstract void a(@android.support.annotation.NonNull java.lang.Runnable runnable);

    public abstract void a(boolean z);

    public abstract void b();

    public abstract void b(int i);
}
