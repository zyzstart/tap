package com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class h implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1096a;
    final /* synthetic */ com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager b;

    h(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager tMAssistantAuthorizedManager, java.lang.String str) {
        this.b = tMAssistantAuthorizedManager;
        this.f1096a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient client = this.b.getClient();
        try {
            if (client.getDownloadTaskState(this.f1096a) != null) {
                client.pauseDownloadTask(this.f1096a);
            } else {
                com.tencent.tmassistantbase.util.TMLog.i("OpensdkToMsdkManager", "getDownloadTaskState taskinfo is null!");
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
