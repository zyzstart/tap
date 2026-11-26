package com.tencent.tmselfupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class l implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmselfupdatesdk.g f1170a;

    l(com.tencent.tmselfupdatesdk.g gVar) {
        this.f1170a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1170a.h().pauseDownloadTask(this.f1170a.h);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
