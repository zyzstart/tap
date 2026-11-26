package com.tencent.tmdownloader;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmdownloader.TMAssistantDownloadService f1114a;

    a(com.tencent.tmdownloader.TMAssistantDownloadService tMAssistantDownloadService) {
        this.f1114a = tMAssistantDownloadService;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            java.lang.Thread.sleep(10000L);
        } catch (java.lang.InterruptedException e) {
            com.tencent.tmassistantbase.util.TMLog.w("TMSelfUpdate_TMAssistantDownloadService", "exception:", e);
            e.printStackTrace();
        }
        com.tencent.tmdownloader.internal.logreport.i.a().c();
    }
}
