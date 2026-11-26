package com.tencent.beacon.core.event;

/* JADX INFO: renamed from: com.tencent.beacon.core.event.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class RunnableC0082b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f165a;
    final /* synthetic */ java.util.List b;
    final /* synthetic */ com.tencent.beacon.core.event.C0083c c;

    RunnableC0082b(com.tencent.beacon.core.event.C0083c c0083c, boolean z, java.util.List list) {
        this.c = c0083c;
        this.f165a = z;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.beacon.core.e.d.f(this.c.a("[event] -> do sync db and upload task."), new java.lang.Object[0]);
        this.c.a(this.f165a, this.b);
    }
}
