package com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class f implements android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager f1094a;

    f(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager tMAssistantAuthorizedManager) {
        this.f1094a = tMAssistantAuthorizedManager;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (this.f1094a.mContext == null) {
            return;
        }
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.a aVar = (com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.a) view.getTag();
        try {
            int iCheckQQDownloaderInstalled = this.f1094a.mOpenSDK.checkQQDownloaderInstalled(this.f1094a.mSupportVersionCode);
            if (iCheckQQDownloaderInstalled == 0) {
                try {
                    this.f1094a.startToQQDownloaderAuthorized(aVar.d);
                    return;
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (iCheckQQDownloaderInstalled == 1 || iCheckQQDownloaderInstalled == 2) {
                com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager tMAssistantAuthorizedManager = this.f1094a;
                java.lang.String str = this.f1094a.mDownloadUrl;
                tMAssistantAuthorizedManager.startDownloadTask(str, aVar.d);
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }
}
