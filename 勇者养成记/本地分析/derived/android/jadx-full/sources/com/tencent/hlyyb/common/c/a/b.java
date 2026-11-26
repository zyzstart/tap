package com.tencent.hlyyb.common.c.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ com.tencent.hlyyb.common.b.a.c f550a;
    private /* synthetic */ long b;
    private /* synthetic */ com.tencent.hlyyb.common.c.a.a c;

    b(com.tencent.hlyyb.common.c.a.a aVar, com.tencent.hlyyb.common.b.a.c cVar, long j) {
        this.c = aVar;
        this.f550a = cVar;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = false;
        try {
            com.tencent.hlyyb.common.b.a.f fVarB = this.f550a.b();
            this.f550a.j = android.os.SystemClock.elapsedRealtime() - this.b;
            this.f550a.a(false);
            if (fVarB.f547a == 0 && fVarB.c == 200) {
                z = true;
            }
        } catch (java.lang.Throwable unused) {
        }
        com.tencent.hlyyb.common.c.a.a.a(this.c, z);
    }
}
