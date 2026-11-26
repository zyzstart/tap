package com.tencent.tmselfupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class e implements com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmselfupdatesdk.a f1161a;

    e(com.tencent.tmselfupdatesdk.a aVar) {
        this.f1161a = aVar;
    }

    @Override // com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener
    public void OnDownloadSDKTaskProgressChanged(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient, java.lang.String str, long j, long j2) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "client: " + tMAssistantDownloadClient + "; url: " + str + "; receiveDataLen: " + j + "; totalDataLen: " + j2);
        java.util.Iterator it = this.f1161a.l.iterator();
        while (it.hasNext()) {
            java.lang.Object obj = ((java.lang.ref.WeakReference) it.next()).get();
            if (obj == null) {
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "listener = null");
            } else if (obj instanceof com.tencent.tmselfupdatesdk.ITMSelfUpdateListener) {
                ((com.tencent.tmselfupdatesdk.ITMSelfUpdateListener) obj).onDownloadAppProgressChanged(j, j2);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "exit");
    }

    @Override // com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener
    public void OnDownloadSDKTaskStateChanged(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient, java.lang.String str, int i, int i2, java.lang.String str2) {
        com.tencent.tmselfupdatesdk.a aVar;
        int i3;
        java.lang.String str3;
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "clientKey:" + tMAssistantDownloadClient + ",state:" + i + ",url:" + str);
        if (i == 2) {
            this.f1161a.a(101, 0, "SelfUpdate DownloadSDKTaskState_DOWNLOADING!");
        } else if (i == 4) {
            com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_update_download_result", true, new java.lang.String[0]);
            this.f1161a.e.post(new com.tencent.tmselfupdatesdk.f(this, str, i));
        } else if (i == 5) {
            com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_update_download_result", false, java.lang.String.valueOf(i2), str2);
            if (i2 == 712) {
                aVar = this.f1161a;
                i3 = -22;
                str3 = "mClientSDKListener,OnDownloadSDKTaskStateChanged,DownloadSDKTaskState_FILESIZE_CHECK_ERROR!";
            } else {
                aVar = this.f1161a;
                i3 = -17;
                str3 = "mClientSDKListener,OnDownloadSDKTaskStateChanged,DownloadSDKTaskState_FAILED!";
            }
            aVar.a(102, i3, str3);
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "exit");
    }

    @Override // com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener
    public void OnDwonloadSDKServiceInvalid(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient) {
        com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_download_client_invalid");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "clientKey:" + tMAssistantDownloadClient);
        this.f1161a.a(102, -16, "SelfUpdate DwonloadSDKServiceInvalid!");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "exit");
    }
}
