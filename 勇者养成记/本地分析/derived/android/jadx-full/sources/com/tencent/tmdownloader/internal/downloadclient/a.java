package com.tencent.tmdownloader.internal.downloadclient;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.Context f1127a;
    final /* synthetic */ com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver b;

    a(com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver mobileQQCloseServiceReceiver, android.content.Context context) {
        this.b = mobileQQCloseServiceReceiver;
        this.f1127a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            boolean zIsAllDownloadFinished = com.tencent.tmdownloader.TMAssistantDownloadManager.getInstance(this.f1127a).getDownloadSDKSettingClient().isAllDownloadFinished();
            com.tencent.tmassistantbase.util.TMLog.i("MobileQQCloseServiceReceiver", "receive broadcast isAllDownloadFinished = " + zIsAllDownloadFinished);
            if (zIsAllDownloadFinished) {
                com.tencent.tmdownloader.TMAssistantDownloadManager.closeAllService(this.f1127a);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
