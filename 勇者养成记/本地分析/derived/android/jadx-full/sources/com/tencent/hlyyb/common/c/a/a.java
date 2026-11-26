package com.tencent.hlyyb.common.c.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a extends com.tencent.hlyyb.common.c.j {
    static /* synthetic */ boolean a(com.tencent.hlyyb.common.c.a.a aVar, boolean z) {
        aVar.b.a(z, aVar.f559a);
        return z;
    }

    @Override // com.tencent.hlyyb.common.c.j
    public final boolean a(byte[] bArr, int i, boolean z, java.lang.Object obj, com.tencent.hlyyb.common.c.k kVar, int i2) {
        java.lang.String str;
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        this.b = kVar;
        this.f559a = obj;
        java.util.HashMap map = new java.util.HashMap();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(i);
        map.put("B-Length", sb.toString());
        if (i2 == 1) {
            str = "devlog";
        } else {
            str = z ? "realtime_speed" : "hllog";
        }
        map.put("HLReportCmd", str);
        com.tencent.hlyyb.common.b.a.c cVarA = com.tencent.hlyyb.common.b.a.c.a("https://up-hl.3g.qq.com/upreport", false, map, bArr, cn.yunzhisheng.asr.a.b, com.tencent.hlyyb.common.f.c.f(), true, null);
        cVarA.n = false;
        cVarA.a(android.support.v4.app.NotificationCompat.CATEGORY_EVENT);
        try {
            com.tencent.hlyyb.common.a.k.a().b().execute(new com.tencent.hlyyb.common.c.a.b(this, cVarA, jElapsedRealtime));
            return true;
        } catch (java.lang.Throwable unused) {
            this.b.a(false, this.f559a);
            return false;
        }
    }
}
