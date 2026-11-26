package com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager f1091a;

    c(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager tMAssistantAuthorizedManager) {
        this.f1091a = tMAssistantAuthorizedManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.tmassistantsdk.internal.protocol.jce.TipsInfoLog tipsInfoLogA;
        android.os.Message message;
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager tMAssistantAuthorizedManager;
        try {
            com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo downloadTaskState = this.f1091a.getClient().getDownloadTaskState(this.f1091a.mDownloadUrl);
            if (downloadTaskState != null) {
                if (downloadTaskState.mState == 3) {
                    message = new android.os.Message();
                    message.what = 6;
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putLong("receiveDataLen", downloadTaskState.mReceiveDataLen);
                    bundle.putLong("totalDataLen", downloadTaskState.mTotalDataLen);
                    message.setData(bundle);
                    tMAssistantAuthorizedManager = this.f1091a;
                } else if (downloadTaskState.mState == 4) {
                    message = new android.os.Message();
                    message.what = 0;
                    message.arg1 = 1;
                    message.obj = downloadTaskState.mSavePath;
                    tMAssistantAuthorizedManager = this.f1091a;
                }
                tMAssistantAuthorizedManager.mMainMessageHandler.sendMessage(message);
            }
            if (downloadTaskState == null || downloadTaskState.mState != 4) {
                tipsInfoLogA = com.tencent.tmassistantsdk.internal.c.h.h().a(this.f1091a.mAuthorizedInfo);
                if (tipsInfoLogA == null) {
                    return;
                } else {
                    tipsInfoLogA.downloadTipsCount++;
                }
            } else {
                tipsInfoLogA = com.tencent.tmassistantsdk.internal.c.h.h().a(this.f1091a.mAuthorizedInfo);
                if (tipsInfoLogA == null) {
                    return;
                } else {
                    tipsInfoLogA.installTipsCount++;
                }
            }
            com.tencent.tmassistantsdk.internal.c.h.h().a(tipsInfoLogA);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
