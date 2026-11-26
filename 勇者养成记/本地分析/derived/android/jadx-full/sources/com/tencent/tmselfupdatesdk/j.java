package com.tencent.tmselfupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class j implements com.tencent.tmassistantsdk.ITMAssistantCallBackListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmselfupdatesdk.g f1168a;

    j(com.tencent.tmselfupdatesdk.g gVar) {
        this.f1168a = gVar;
    }

    @Override // com.tencent.tmassistantsdk.ITMAssistantCallBackListener
    public void OnDownloadTaskProgressChanged(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, long j, long j2) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "receiveDataLen: " + j + "; totalDataLen: " + j2);
        java.util.Iterator it = this.f1168a.m.iterator();
        while (it.hasNext()) {
            java.lang.Object obj = ((java.lang.ref.WeakReference) it.next()).get();
            if (obj == null) {
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "listener = null");
            } else if (obj instanceof com.tencent.tmselfupdatesdk.ITMSelfUpdateListener) {
                ((com.tencent.tmselfupdatesdk.ITMSelfUpdateListener) obj).onDownloadAppProgressChanged(j, j2);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "exit");
    }

    @Override // com.tencent.tmassistantsdk.ITMAssistantCallBackListener
    public void OnDownloadTaskStateChanged(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, int i, int i2, java.lang.String str) {
        if (tMAssistantCallYYBParamStruct != null) {
            this.f1168a.k = false;
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "mOpenSDKYYBStateListener;isFromStartUpdate:" + this.f1168a.k);
            try {
                this.f1168a.a(i, i2, str);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "exit");
    }

    @Override // com.tencent.tmassistantsdk.ITMAssistantCallBackListener
    public void OnQQDownloaderInvalid() {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "enter && exit");
    }

    @Override // com.tencent.tmassistantsdk.ITMAssistantCallBackListener
    public void OnServiceFree() {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "enter && exit");
    }
}
