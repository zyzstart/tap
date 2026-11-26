package com.tencent.beacon.stat;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f215a;
    final /* synthetic */ long b;
    final /* synthetic */ long c;
    final /* synthetic */ com.tencent.beacon.stat.d d;

    b(com.tencent.beacon.stat.d dVar, java.lang.String str, long j, long j2) {
        this.d = dVar;
        this.f215a = str;
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.util.HashMap map = new java.util.HashMap();
        map.put("A145", this.f215a);
        map.put("A146", java.lang.String.valueOf(this.b));
        map.put("A147", java.lang.String.valueOf(this.c));
        com.tencent.beacon.core.e.d.a("[stat] upload last day logid Date: %s, realtimeesn: %d, normalesn: %d, upload success: %s", this.f215a, java.lang.Long.valueOf(this.b), java.lang.Long.valueOf(this.c), java.lang.Boolean.valueOf(com.tencent.beacon.event.UserAction.onUserAction("rqd_logidtrace", true, 0L, 0L, map, true)));
    }
}
