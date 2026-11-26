package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class j implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f170a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ long c;

    j(long j, java.lang.String str, long j2) {
        this.f170a = j;
        this.b = str;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.util.HashMap map = new java.util.HashMap();
        map.put("A110", java.lang.String.valueOf(this.f170a));
        map.put("A111", this.b);
        map.put("A112", java.lang.String.valueOf(this.c));
        com.tencent.beacon.event.UserAction.onUserAction("rqd_page_fgt", true, 0L, 0L, map, false);
        if (this.c >= 30000) {
            com.tencent.beacon.core.e.d.a("[page] force flush page_fgt events in db.", new java.lang.Object[0]);
            com.tencent.beacon.event.UserAction.flushObjectsToDB(true);
        }
    }
}
