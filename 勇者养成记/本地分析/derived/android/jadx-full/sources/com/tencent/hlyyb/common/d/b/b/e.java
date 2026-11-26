package com.tencent.hlyyb.common.d.b.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class e implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ com.tencent.hlyyb.common.d.b.b.c f583a;

    e(com.tencent.hlyyb.common.d.b.b.c cVar) {
        this.f583a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            com.tencent.hlyyb.common.a.f.e();
            com.tencent.hlyyb.common.d.b.b.c.a(this.f583a, com.tencent.hlyyb.common.a.f.b());
            this.f583a.d.removeCallbacks(this.f583a.h);
            this.f583a.d.post(this.f583a.h);
        } catch (java.lang.Throwable unused) {
        }
    }
}
