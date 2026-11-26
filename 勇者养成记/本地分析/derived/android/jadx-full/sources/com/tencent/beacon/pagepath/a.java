package com.tencent.beacon.pagepath;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f205a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ long c;
    final /* synthetic */ com.tencent.beacon.pagepath.b d;

    a(com.tencent.beacon.pagepath.b bVar, long j, java.lang.String str, long j2) {
        this.d = bVar;
        this.f205a = j;
        this.b = str;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.util.HashMap map = new java.util.HashMap();
        map.put("A110", java.lang.String.valueOf(this.f205a));
        map.put("A111", this.b);
        map.put("A112", java.lang.String.valueOf(this.c));
        com.tencent.beacon.event.UserAction.onUserAction("rqd_page", true, 0L, 0L, map, false);
        this.d.c += this.c;
        if (this.d.c >= 15000) {
            this.d.c = 0L;
            com.tencent.beacon.event.UserAction.flushObjectsToDB(false);
        }
    }
}
