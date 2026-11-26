package com.tencent.tmassistantbase.common.download;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class b extends com.tencent.tmassistantbase.aidl.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient f1020a;

    b(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient) {
        this.f1020a = tMAssistantDownloadClient;
    }

    @Override // com.tencent.tmassistantbase.aidl.a
    public void a(java.lang.String str, java.lang.String str2, int i, int i2, java.lang.String str3) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadSDKClient", "clientKey:" + str + ",state:" + i + ", errorcode" + i2 + ",url:" + str2);
        for (java.lang.ref.WeakReference weakReference : this.f1020a.mWeakListenerArrayList) {
            com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener = (com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener) weakReference.get();
            if (iTMAssistantDownloadClientListener == null) {
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadSDKClient", " listener = " + iTMAssistantDownloadClientListener + "   linstenerWeakReference :" + weakReference);
            }
            com.tencent.tmassistantbase.common.download.e.a().a(this.f1020a, iTMAssistantDownloadClientListener, str2, i, i2, str3);
        }
    }

    @Override // com.tencent.tmassistantbase.aidl.a
    public void a(java.lang.String str, java.lang.String str2, long j, long j2) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadSDKClient", "clientKey:" + str + ",receivedLen:" + j + ",totalLen:" + j2 + ",url:" + str2);
        for (java.lang.ref.WeakReference weakReference : this.f1020a.mWeakListenerArrayList) {
            com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener = (com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener) weakReference.get();
            if (iTMAssistantDownloadClientListener == null) {
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadSDKClient", " listener = " + iTMAssistantDownloadClientListener + "   linstenerWeakReference :" + weakReference);
            }
            com.tencent.tmassistantbase.common.download.e.a().a(this.f1020a, iTMAssistantDownloadClientListener, str2, j, j2);
        }
    }
}
