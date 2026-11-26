package com.tencent.tmselfupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class n implements com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmselfupdatesdk.g f1172a;

    n(com.tencent.tmselfupdatesdk.g gVar) {
        this.f1172a = gVar;
    }

    @Override // com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener
    public void OnDownloadSDKTaskProgressChanged(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient, java.lang.String str, long j, long j2) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "client: " + tMAssistantDownloadClient + "; url: " + str + "; receiveDataLen: " + j + "; totalDataLen: " + j2);
        java.util.Iterator it = this.f1172a.m.iterator();
        while (it.hasNext()) {
            java.lang.Object obj = ((java.lang.ref.WeakReference) it.next()).get();
            if (obj == null) {
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "listener = null");
            } else if (obj instanceof com.tencent.tmselfupdatesdk.YYBDownloadListener) {
                ((com.tencent.tmselfupdatesdk.YYBDownloadListener) obj).onDownloadYYBProgressChanged(str, j, j2);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "exit");
    }

    @Override // com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener
    public void OnDownloadSDKTaskStateChanged(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient, java.lang.String str, int i, int i2, java.lang.String str2) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "clientKey:" + tMAssistantDownloadClient + ",state:" + i + ",url:" + str);
        this.f1172a.a(str, i, i2, str2);
        if (i == 4) {
            com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_yyb_download_result", true, new java.lang.String[0]);
            com.tencent.tmselfupdatesdk.p.a(4, com.tencent.pipe.IPipeInterface.EVENT_PAY_IS_LOGIN, "com.tencent.android.qqdownloader");
            if (this.f1172a.j) {
                this.f1172a.k();
            }
        }
        if (i == 5) {
            com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_yyb_download_result", false, java.lang.String.valueOf(i2), str2);
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "test0629 yybDownload failed arg2=" + i);
            com.tencent.tmselfupdatesdk.p.a(6, 401, "com.tencent.android.qqdownloader");
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "exit");
    }

    @Override // com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener
    public void OnDwonloadSDKServiceInvalid(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "enter && exit");
        com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_download_client_invalid");
    }
}
