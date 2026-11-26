package com.tencent.hlyyb.common.d.b.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class g implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ com.tencent.hlyyb.common.d.b.b.c f585a;

    g(com.tencent.hlyyb.common.d.b.b.c cVar) {
        this.f585a = cVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        int i = 0;
        try {
            com.tencent.hlyyb.common.d.b.b.a aVar = new com.tencent.hlyyb.common.d.b.b.a();
            java.util.Iterator it = this.f585a.e.values().iterator();
            while (it.hasNext()) {
                ((com.tencent.hlyyb.common.d.b.b.b) it.next()).a(aVar);
            }
            byte[] bArrA = aVar.a();
            if (!com.tencent.hlyyb.common.f.c.a(bArrA)) {
                com.tencent.hlyyb.common.b.a.c cVarA = com.tencent.hlyyb.common.b.a.c.a("https://yun-hl.3g.qq.com/halleycloud", false, null, bArrA, 15000, com.tencent.hlyyb.common.f.c.f(), true, com.tencent.hlyyb.common.d.f.d().f());
                cVarA.a("platform");
                com.tencent.hlyyb.common.b.a.f fVarB = cVarA.b();
                int i2 = fVarB.f547a;
                try {
                    if (fVarB.f547a == 0 && fVarB.c == 200 && !com.tencent.hlyyb.common.f.c.a(fVarB.d)) {
                        try {
                            org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(fVarB.d));
                            com.tencent.hlyyb.common.a.f.e();
                            java.util.Iterator it2 = this.f585a.e.values().iterator();
                            while (it2.hasNext()) {
                                ((com.tencent.hlyyb.common.d.b.b.b) it2.next()).a(jSONObject);
                            }
                        } catch (java.lang.Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    cVarA.j = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime;
                    cVarA.a(false);
                    i = i2;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    i = i2;
                    try {
                        th.printStackTrace();
                    } finally {
                        com.tencent.hlyyb.common.d.b.b.d dVarA = com.tencent.hlyyb.common.d.b.b.c.a(this.f585a, com.tencent.hlyyb.common.a.f.b());
                        dVarA.f581a = android.os.SystemClock.elapsedRealtime();
                        dVarA.b = i;
                        this.f585a.d.removeCallbacks(this.f585a.h);
                    }
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }
}
