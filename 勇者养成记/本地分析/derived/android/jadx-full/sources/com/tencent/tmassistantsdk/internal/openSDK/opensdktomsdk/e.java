package com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class e implements android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager f1093a;

    e(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager tMAssistantAuthorizedManager) {
        this.f1093a = tMAssistantAuthorizedManager;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (this.f1093a.dialog.isShowing()) {
            this.f1093a.dialog.dismiss();
            this.f1093a.mHttpRequest = null;
        }
        com.tencent.tmassistantsdk.internal.protocol.jce.TipsInfoLog tipsInfoLogA = com.tencent.tmassistantsdk.internal.c.h.h().a(this.f1093a.mAuthorizedInfo);
        if (tipsInfoLogA != null) {
            tipsInfoLogA.cancelBtnClickCount++;
            com.tencent.tmassistantsdk.internal.c.h.h().a(tipsInfoLogA);
        }
        try {
            if (this.f1093a.mClient != null) {
                this.f1093a.pauseDownloadTask(this.f1093a.mDownloadUrl);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager tMAssistantAuthorizedManager = this.f1093a;
        if (tMAssistantAuthorizedManager.authorizedState == 2) {
            tMAssistantAuthorizedManager.notifyAuthorizedFinished(true, tMAssistantAuthorizedManager.mAuthorizedInfo);
        } else {
            tMAssistantAuthorizedManager.notifyAuthorizedFinished(false, tMAssistantAuthorizedManager.mAuthorizedInfo);
        }
    }
}
