package com.tencent.hlyyb.common.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class h implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ com.tencent.hlyyb.common.c.a f557a;

    h(com.tencent.hlyyb.common.c.a aVar) {
        this.f557a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f557a.g.size() != 0) {
            this.f557a.a(true, true);
        } else {
            this.f557a.l.incrementAndGet();
            this.f557a.b(false, true);
        }
    }
}
