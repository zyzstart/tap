package com.tencent.hlyyb.common.d.b.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class f implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ com.tencent.hlyyb.common.d.b.b.c f584a;

    f(com.tencent.hlyyb.common.d.b.b.c cVar) {
        this.f584a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            com.tencent.hlyyb.common.a.f.e();
            com.tencent.hlyyb.common.d.b.b.d dVarA = com.tencent.hlyyb.common.d.b.b.c.a(this.f584a, com.tencent.hlyyb.common.a.f.b());
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            com.tencent.hlyyb.common.d.b.b.c cVar = this.f584a;
            if (jElapsedRealtime - dVarA.f581a > com.tencent.hlyyb.common.d.b.b.c.b(dVarA.b)) {
                this.f584a.d.removeCallbacks(this.f584a.h);
                this.f584a.d.post(this.f584a.h);
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
