package com.tencent.tmdownloader;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b extends com.tencent.tmassistantbase.aidl.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmdownloader.TMAssistantDownloadService f1115a;

    protected b(com.tencent.tmdownloader.TMAssistantDownloadService tMAssistantDownloadService) {
        this.f1115a = tMAssistantDownloadService;
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public int a() {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "returnValue: 1");
        return 1;
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public int a(java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.lang.String str4, java.util.Map map, android.os.Bundle bundle) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "clientkey:" + str + ",url:" + str2 + ",manager:" + this.f1115a.mServiceDownloadTaskManager + ",fileName:" + str4);
        if (this.f1115a.mServiceDownloadTaskManager == null) {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "returnValue: TMAssistantDownloadErrorCode.DownloadSDK_START_FAILED_PARAMETERS_INVALID");
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "exit");
            return 3;
        }
        com.tencent.tmdownloader.internal.b.a.a().a(str, str2);
        int iA = this.f1115a.mServiceDownloadTaskManager.a(str, str2, i, str3, str4, map, bundle);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "returnValue: " + iA);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "exit");
        return iA;
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo a(java.lang.String str, java.lang.String str2) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "enter");
        com.tencent.tmdownloader.internal.downloadservice.a.c cVar = this.f1115a.mServiceDownloadTaskManager;
        if (cVar == null) {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "mServiceDownloadTaskManager == null");
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "returnValue: null");
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "exit");
            return null;
        }
        com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfoA = cVar.a(str, str2);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "returnValue: " + tMAssistantDownloadTaskInfoA);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "exit");
        return tMAssistantDownloadTaskInfoA;
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public void a(int i) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "maxTaskNum: " + i);
        com.tencent.tmdownloader.internal.downloadservice.g.a().a(i);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "exit");
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public void a(java.lang.String str, com.tencent.tmassistantbase.aidl.a aVar) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "clientKey:" + str);
        if (str != null && aVar != null) {
            this.f1115a.mCallbacks.register(aVar);
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "register callback");
            synchronized (this) {
                this.f1115a.mCallbackHashMap.put(aVar, str);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "exit");
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public void a(boolean z) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "isTaskAutoResume: " + z);
        com.tencent.tmdownloader.internal.downloadservice.g.a().a(z);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "exit");
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public void b(java.lang.String str, com.tencent.tmassistantbase.aidl.a aVar) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "clientKey:" + str);
        if (str != null && aVar != null) {
            this.f1115a.mCallbacks.unregister(aVar);
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "unregister callback");
            synchronized (this) {
                this.f1115a.mCallbackHashMap.remove(aVar);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "exit");
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public void b(java.lang.String str, java.lang.String str2) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "clientkey:" + str + ",url:" + str2);
        try {
            if (this.f1115a.mServiceDownloadTaskManager != null) {
                this.f1115a.mServiceDownloadTaskManager.b(str, str2);
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "pauseDownload");
            }
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e("TMSelfUpdate_TMAssistantDownloadService", "exception: ", e);
            e.printStackTrace();
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "exit");
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public void b(boolean z) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "isDownloadWifiOnly: " + z);
        com.tencent.tmdownloader.internal.downloadservice.g.a().b(z);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "exit");
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public boolean b() {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "enter");
        boolean zBooleanValue = com.tencent.tmdownloader.internal.downloadservice.a.b().e().booleanValue();
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "returnValue: " + zBooleanValue);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "exit");
        return zBooleanValue;
    }

    @Override // com.tencent.tmassistantbase.aidl.d
    public void c(java.lang.String str, java.lang.String str2) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "clientkey:" + str + ",url:" + str2);
        com.tencent.tmdownloader.internal.downloadservice.a.c cVar = this.f1115a.mServiceDownloadTaskManager;
        if (cVar != null) {
            cVar.c(str, str2);
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "cancelDownload");
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_TMAssistantDownloadService", "exit");
    }
}
