package com.tencent.beacon.core.strategy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class f implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f191a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ android.content.Context c;
    final /* synthetic */ com.tencent.beacon.core.strategy.g d;

    f(com.tencent.beacon.core.strategy.g gVar, java.lang.String str, java.lang.String str2, android.content.Context context) {
        this.d = gVar;
        this.f191a = str;
        this.b = str2;
        this.c = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        long time;
        java.lang.Object[] objArr = new java.lang.Object[2];
        objArr[0] = this.f191a;
        try {
            java.util.Date dateD = com.tencent.beacon.core.e.b.d(this.b);
            time = dateD != null ? dateD.getTime() / 1000 : 0L;
        } catch (java.lang.Exception unused) {
        }
        if (time == 0) {
            time = (new java.util.Date().getTime() / 1000) + com.tencent.smtt.sdk.TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
        }
        objArr[1] = java.lang.Long.valueOf(time);
        com.tencent.beacon.core.a.a.c.a(this.c, "sid", objArr);
    }
}
