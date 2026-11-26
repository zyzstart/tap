package com.tencent.tmassistantsdk.internal.openSDK;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.Intent f1082a;
    final /* synthetic */ com.tencent.tmassistantsdk.internal.openSDK.DownloadStateChangedReceiver b;

    a(com.tencent.tmassistantsdk.internal.openSDK.DownloadStateChangedReceiver downloadStateChangedReceiver, android.content.Intent intent) {
        this.b = downloadStateChangedReceiver;
        this.f1082a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.tmassistantsdk.internal.openSDK.e eVar = new com.tencent.tmassistantsdk.internal.openSDK.e();
        eVar.b = this.f1082a.getStringExtra("hostPackageName");
        eVar.c = this.f1082a.getStringExtra("hostVersion");
        eVar.d = this.f1082a.getStringExtra("taskId");
        eVar.f = java.lang.Integer.parseInt(this.f1082a.getStringExtra(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_ERROR_CODE));
        eVar.g = this.f1082a.getStringExtra("errorMsg");
        eVar.e = java.lang.Integer.parseInt(this.f1082a.getStringExtra("state"));
        com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct = new com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct();
        tMAssistantCallYYBParamStruct.SNGAppId = this.f1082a.getStringExtra("sngAppId");
        tMAssistantCallYYBParamStruct.taskAppId = this.f1082a.getStringExtra("taskAppId");
        tMAssistantCallYYBParamStruct.taskApkId = this.f1082a.getStringExtra("taskApkId");
        tMAssistantCallYYBParamStruct.taskPackageName = this.f1082a.getStringExtra("taskPackageName");
        tMAssistantCallYYBParamStruct.taskVersion = java.lang.Integer.parseInt(this.f1082a.getStringExtra("taskVersion"));
        tMAssistantCallYYBParamStruct.via = this.f1082a.getStringExtra("via");
        tMAssistantCallYYBParamStruct.uin = this.f1082a.getStringExtra("uin");
        tMAssistantCallYYBParamStruct.uinType = this.f1082a.getStringExtra("uinType");
        eVar.f1084a = tMAssistantCallYYBParamStruct;
        java.util.Iterator it = this.b.f.iterator();
        while (it.hasNext()) {
            ((com.tencent.tmassistantsdk.internal.openSDK.b) it.next()).onDownloadStateChanged(eVar);
        }
    }
}
