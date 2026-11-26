package com.tencent.ydkbeacon.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class f implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1242a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ com.tencent.ydkbeacon.d.g c;

    f(com.tencent.ydkbeacon.d.g gVar, java.lang.String str, java.lang.String str2) {
        this.c = gVar;
        this.f1242a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.util.Date dateD = com.tencent.ydkbeacon.a.e.b.d(this.f1242a);
        long time = dateD != null ? dateD.getTime() / 1000 : 0L;
        if (time == 0) {
            time = (new java.util.Date().getTime() / 1000) + com.tencent.smtt.sdk.TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
        }
        com.tencent.ydkbeacon.a.d.a.a().edit().putString("sid_value", this.b).putLong("sid_mt", time);
    }
}
