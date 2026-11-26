package com.tencent.hlyyb.common.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class g implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ int f588a;
    private /* synthetic */ com.tencent.hlyyb.common.d.f b;

    g(com.tencent.hlyyb.common.d.f fVar, int i) {
        this.b = fVar;
        this.f588a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.c.a(this.f588a);
    }
}
