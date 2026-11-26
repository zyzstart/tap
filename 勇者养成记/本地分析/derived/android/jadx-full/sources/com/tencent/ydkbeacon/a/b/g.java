package com.tencent.ydkbeacon.a.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class g implements java.util.concurrent.ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.util.concurrent.atomic.AtomicInteger f1184a = new java.util.concurrent.atomic.AtomicInteger(1);

    public java.lang.String a() {
        return "beacon-thread-" + this.f1184a.getAndIncrement();
    }

    @Override // java.util.concurrent.ThreadFactory
    public java.lang.Thread newThread(@android.support.annotation.NonNull java.lang.Runnable runnable) {
        try {
            return new java.lang.Thread(runnable, a());
        } catch (java.lang.Exception e) {
            com.tencent.ydkbeacon.a.e.c.a(e);
            return null;
        } catch (java.lang.OutOfMemoryError unused) {
            com.tencent.ydkbeacon.a.e.c.b("[task] memory not enough, create thread failed.", new java.lang.Object[0]);
            return null;
        }
    }
}
