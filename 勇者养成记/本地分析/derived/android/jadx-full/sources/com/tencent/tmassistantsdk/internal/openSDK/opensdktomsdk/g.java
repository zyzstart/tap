package com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class g implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1095a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager c;

    g(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager tMAssistantAuthorizedManager, java.lang.String str, java.lang.String str2) {
        this.c = tMAssistantAuthorizedManager;
        this.f1095a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.os.Message message;
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager tMAssistantAuthorizedManager;
        com.tencent.tmassistantsdk.internal.protocol.jce.TipsInfoLog tipsInfoLogA;
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager tMAssistantAuthorizedManager2 = this.c;
        if (tMAssistantAuthorizedManager2.mContext != null && tMAssistantAuthorizedManager2.mOpenSDK != null && !android.text.TextUtils.isEmpty(this.f1095a)) {
            com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager tMAssistantAuthorizedManager3 = this.c;
            tMAssistantAuthorizedManager3.insertActionId = tMAssistantAuthorizedManager3.mOpenSDK.addDownloadTaskFromAuthorize(this.f1095a);
        }
        com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient client = this.c.getClient();
        if (client == null) {
            return;
        }
        try {
            int iStartDownloadTask = client.startDownloadTask(this.b, com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK, new android.os.Bundle());
            if (4 == iStartDownloadTask) {
                java.lang.String str = client.getDownloadTaskState(this.b).mSavePath;
                android.os.Message message2 = new android.os.Message();
                message2.what = 0;
                message2.obj = str;
                this.c.mMainMessageHandler.sendMessage(message2);
            } else if (iStartDownloadTask == 0) {
                com.tencent.tmassistantbase.util.TMLog.i("OpensdkToMsdkManager", "start success!");
            } else {
                if (1 == iStartDownloadTask) {
                    message = new android.os.Message();
                    message.what = 5;
                    message.obj = 1;
                    tMAssistantAuthorizedManager = this.c;
                } else {
                    message = new android.os.Message();
                    message.what = 3;
                    tMAssistantAuthorizedManager = this.c;
                }
                tMAssistantAuthorizedManager.mMainMessageHandler.sendMessage(message);
            }
            if (iStartDownloadTask == 4) {
                tipsInfoLogA = com.tencent.tmassistantsdk.internal.c.h.h().a(this.c.mAuthorizedInfo);
                if (tipsInfoLogA == null) {
                    return;
                } else {
                    tipsInfoLogA.installBtnClickCount++;
                }
            } else {
                tipsInfoLogA = com.tencent.tmassistantsdk.internal.c.h.h().a(this.c.mAuthorizedInfo);
                if (tipsInfoLogA == null) {
                    return;
                } else {
                    tipsInfoLogA.downloadBtnClickCount++;
                }
            }
            com.tencent.tmassistantsdk.internal.c.h.h().a(tipsInfoLogA);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
