package com.tencent.tmselfupdatesdk.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class j implements com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmselfupdatesdk.b.f f1157a;

    j(com.tencent.tmselfupdatesdk.b.f fVar) {
        this.f1157a = fVar;
    }

    @Override // com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener
    public void OnDownloadSDKTaskProgressChanged(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient, java.lang.String str, long j, long j2) {
        com.tencent.tmassistantbase.util.TMLog.i("PatchManager", "mSelfPatchDownloadCallback >> OnDownloadSDKTaskProgressChanged enter");
        com.tencent.tmassistantbase.util.TMLog.i("PatchManager", "client: " + tMAssistantDownloadClient + "; url: " + str + "; receiveDataLen: " + j + "; totalDataLen: " + j2);
        com.tencent.tmassistantbase.util.TMLog.i("PatchManager", "mSelfPatchDownloadCallback >> OnDownloadSDKTaskProgressChanged exit");
    }

    @Override // com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener
    public void OnDownloadSDKTaskStateChanged(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient, java.lang.String str, int i, int i2, java.lang.String str2) {
        java.lang.String strB;
        java.lang.String strB2;
        java.lang.String strB3;
        com.tencent.tmselfupdatesdk.b.f fVar;
        java.lang.String str3;
        java.lang.String strB4;
        com.tencent.tmassistantbase.util.TMLog.i("PatchManager", "mSelfPatchDownloadCallback >> OnDownloadSDKTaskStateChanged.");
        com.tencent.tmassistantbase.util.TMLog.i("PatchManager", "mSelfPatchDownloadCallback >> clientKey:" + tMAssistantDownloadClient + ",state:" + i + ",url:" + str);
        if (i == 4) {
            com.tencent.tmassistantbase.util.x.a("PatchManager", "sdk更新包下载成功！");
            java.lang.String[] strArr = new java.lang.String[1];
            if (this.f1157a.h != null) {
                com.tencent.tmselfupdatesdk.b.f fVar2 = this.f1157a;
                strB2 = fVar2.b(fVar2.h.patchSdkVersion, this.f1157a.h.patchBuilderNum);
            } else {
                strB2 = "null";
            }
            strArr[0] = strB2;
            com.tencent.tmselfupdatesdk.util.a.a("downloadPatchSuccess", true, strArr);
            try {
                com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClientA = com.tencent.tmselfupdatesdk.g.a().a((com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener) null);
                if (tMAssistantDownloadClientA != null) {
                    com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo downloadTaskState = tMAssistantDownloadClientA.getDownloadTaskState(str);
                    com.tencent.tmassistantbase.util.x.a("PatchManager", "开始解压拷贝文件. form:" + downloadTaskState.mSavePath + ". to:" + this.f1157a.b());
                    boolean zA = com.tencent.tmselfupdatesdk.util.e.a(downloadTaskState.mSavePath, this.f1157a.c(), "patch.dex");
                    com.tencent.yybsdk.apkpatch.f.b.a(downloadTaskState.mSavePath);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("解压拷贝文件");
                    sb.append(zA ? "成功" : "失败");
                    com.tencent.tmassistantbase.util.x.a("PatchManager", sb.toString());
                    if (this.f1157a.h == null || this.f1157a.h.patchMD5 == null) {
                        fVar = this.f1157a;
                        str3 = "key_patch_md5";
                        strB4 = com.tencent.tmassistantbase.util.n.b(this.f1157a.b());
                    } else {
                        fVar = this.f1157a;
                        str3 = "key_patch_md5";
                        strB4 = this.f1157a.h.patchMD5;
                    }
                    fVar.a(str3, strB4);
                    if (this.f1157a.i != null) {
                        this.f1157a.b(this.f1157a.i);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.tencent.tmassistantbase.util.x.b("PatchManager", "热更新包下载成功，但是解压拷贝文件出错.");
                java.lang.String[] strArr2 = new java.lang.String[1];
                if (this.f1157a.h != null) {
                    com.tencent.tmselfupdatesdk.b.f fVar3 = this.f1157a;
                    strB3 = fVar3.b(fVar3.h.patchSdkVersion, this.f1157a.h.patchBuilderNum);
                } else {
                    strB3 = "null";
                }
                strArr2[0] = strB3;
                com.tencent.tmselfupdatesdk.util.a.a("unzipPatchFailed", true, strArr2);
                th.printStackTrace();
            }
        } else if (i == 5) {
            com.tencent.tmassistantbase.util.x.a("PatchManager", "sdk更新包下载失败！errorCode=" + i2 + ". errorMsg=" + str2);
            java.lang.String[] strArr3 = new java.lang.String[2];
            if (this.f1157a.h != null) {
                com.tencent.tmselfupdatesdk.b.f fVar4 = this.f1157a;
                strB = fVar4.b(fVar4.h.patchSdkVersion, this.f1157a.h.patchBuilderNum);
            } else {
                strB = "null";
            }
            strArr3[0] = strB;
            strArr3[1] = java.lang.String.valueOf(i2);
            com.tencent.tmselfupdatesdk.util.a.a("downloadPatchFailed", true, strArr3);
        }
        com.tencent.tmassistantbase.util.TMLog.i("PatchManager", "mSelfPatchDownloadCallback >> OnDownloadSDKTaskStateChanged exit");
    }

    @Override // com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener
    public void OnDwonloadSDKServiceInvalid(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient) {
        com.tencent.tmassistantbase.util.TMLog.i("PatchManager", "mSelfPatchDownloadCallback >> OnDwonloadSDKServiceInvalid");
    }
}
