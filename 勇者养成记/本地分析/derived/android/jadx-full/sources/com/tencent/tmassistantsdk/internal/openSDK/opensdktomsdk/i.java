package com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class i implements com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager f1097a;

    i(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager tMAssistantAuthorizedManager) {
        this.f1097a = tMAssistantAuthorizedManager;
    }

    @Override // com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener
    public void OnDownloadSDKTaskProgressChanged(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient, java.lang.String str, long j, long j2) {
        android.os.Message message = new android.os.Message();
        message.what = 1;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putLong("receiveDataLen", j);
        bundle.putLong("totalDataLen", j2);
        message.setData(bundle);
        this.f1097a.mMainMessageHandler.sendMessage(message);
    }

    @Override // com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener
    public void OnDownloadSDKTaskStateChanged(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient, java.lang.String str, int i, int i2, java.lang.String str2) {
        com.tencent.tmassistantbase.util.TMLog.i("OpensdkToMsdkManager", "OnDownloadSDKTaskStateChanged client:" + tMAssistantDownloadClient + " | state:" + i + " | errorcode:" + i2 + " | errorMsg:" + str2);
        if (tMAssistantDownloadClient == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (4 == i) {
            this.f1097a.mSubMessageHandler.post(new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.j(this, tMAssistantDownloadClient, str));
        } else if (5 == i) {
            android.os.Message message = new android.os.Message();
            message.what = 3;
            this.f1097a.mMainMessageHandler.sendMessage(message);
        }
    }

    @Override // com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener
    public void OnDwonloadSDKServiceInvalid(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient) {
    }
}
