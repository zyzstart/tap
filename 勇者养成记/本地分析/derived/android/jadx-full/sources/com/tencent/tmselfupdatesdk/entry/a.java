package com.tencent.tmselfupdatesdk.entry;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl f1163a;

    a(com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl tMSelfUpdateManagerImpl) {
        this.f1163a = tMSelfUpdateManagerImpl;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1163a.g = com.tencent.yybsdk.apkpatch.f.e.b(com.tencent.tmassistantbase.util.k.a().b().getPackageManager().getPackageInfo(this.f1163a.c, 0).applicationInfo.sourceDir);
            com.tencent.tmselfupdatesdk.g.a().a(this.f1163a.g);
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMSelfUpdateManagerImpl", "mCutEocdMd5: " + this.f1163a.g);
        } catch (java.lang.Exception unused) {
        }
    }
}
