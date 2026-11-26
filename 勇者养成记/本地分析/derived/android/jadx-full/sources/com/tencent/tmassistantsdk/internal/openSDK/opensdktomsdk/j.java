package com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class j implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient f1098a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.i c;

    j(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.i iVar, com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient, java.lang.String str) {
        this.c = iVar;
        this.f1098a = tMAssistantDownloadClient;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            java.lang.String str = this.f1098a.getDownloadTaskState(this.b).mSavePath;
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            android.os.Message message = new android.os.Message();
            message.what = 0;
            message.obj = str;
            this.c.f1097a.mMainMessageHandler.sendMessage(message);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
