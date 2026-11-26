package com.tencent.tmselfupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class f implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1164a;
    final /* synthetic */ int b;
    final /* synthetic */ com.tencent.tmselfupdatesdk.e c;

    f(com.tencent.tmselfupdatesdk.e eVar, java.lang.String str, int i) {
        this.c = eVar;
        this.f1164a = str;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.tmselfupdatesdk.a aVar;
        int i;
        java.lang.String str;
        try {
            if (this.c.f1161a.d() != null) {
                com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo downloadTaskState = this.c.f1161a.d().getDownloadTaskState(this.f1164a);
                i = -19;
                if (downloadTaskState != null) {
                    java.lang.String str2 = downloadTaskState.mSavePath;
                    com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "mClientSDKListener,url:" + this.f1164a + "; state:" + this.b + "; patchPath:" + str2);
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        this.c.f1161a.b(str2);
                        return;
                    } else {
                        aVar = this.c.f1161a;
                        str = "SelfUpdate failure,OnDownloadSDKTaskStateChanged SelfUpdateSDKErrorCode_getSavePath_IS_NULL!";
                    }
                } else {
                    aVar = this.c.f1161a;
                    str = "SelfUpdate failure,OnDownloadSDKTaskStateChanged SelfUpdateSDKErrorCode_GetDownloadTaskState_IS_NULL!";
                }
            } else {
                aVar = this.c.f1161a;
                i = -18;
                str = "SelfUpdate failure, TMAssistantDownloadSDKClient_IS_NULL!";
            }
            aVar.a(102, i, str);
        } catch (java.lang.Exception e) {
            this.c.f1161a.a(102, -20, "mClientSDKListener," + e.getMessage());
            com.tencent.tmassistantbase.util.TMLog.e("TMSelfUpdate_CommonUpdateManager", "exception:", e);
            e.printStackTrace();
        }
    }
}
