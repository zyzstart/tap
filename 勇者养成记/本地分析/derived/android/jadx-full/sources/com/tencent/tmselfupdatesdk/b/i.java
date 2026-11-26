package com.tencent.tmselfupdatesdk.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class i implements com.tencent.tmselfupdatesdk.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmselfupdatesdk.b.f f1156a;

    i(com.tencent.tmselfupdatesdk.b.f fVar) {
        this.f1156a = fVar;
    }

    @Override // com.tencent.tmselfupdatesdk.b.c
    public void a(int i) {
        com.tencent.tmassistantbase.util.x.b("PatchManager", "PatchManager >> mUpdateCallback.onRequestFailed. errorCode=" + i);
    }

    @Override // com.tencent.tmselfupdatesdk.b.c
    public void a(com.tencent.tmassistantbase.jce.GetHotSdkUpdateResponse getHotSdkUpdateResponse) {
        java.lang.String[] strArr;
        java.lang.String str;
        com.tencent.tmassistantbase.util.x.a("PatchManager", "PatchManager >> mUpdateCallback.onRequestSucceed.");
        this.f1156a.a("key_last_request_patch_success_time", java.lang.System.currentTimeMillis());
        if (getHotSdkUpdateResponse == null) {
            return;
        }
        int i = getHotSdkUpdateResponse.ret;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                com.tencent.tmassistantbase.util.x.a("PatchManager", "PatchManager >> mUpdateCallback.onRequestSucceed. RET_NO_PATCH.");
                return;
            }
            com.tencent.tmassistantbase.util.x.a("PatchManager", "PatchManager >> mUpdateCallback.onRequestSucceed. RET_ROLLBACK.");
            com.tencent.yybsdk.apkpatch.f.b.a(this.f1156a.b());
            if (this.f1156a.e != null) {
                this.f1156a.e.l = true;
            }
            com.tencent.tmselfupdatesdk.TMSelfUpdateManager.getInstance().reInit();
            com.tencent.tmselfupdatesdk.b.f fVar = this.f1156a;
            com.tencent.tmselfupdatesdk.util.a.a("revertPatchSuccess", true, fVar.b(fVar.h.patchSdkVersion, this.f1156a.h.patchBuilderNum));
            return;
        }
        com.tencent.tmassistantbase.util.x.a("PatchManager", "PatchManager >> mUpdateCallback.onRequestSucceed. RET_HAS_PATCH. \npatchUrl=" + getHotSdkUpdateResponse.patchUrl + "\npatchSdkVersion=" + getHotSdkUpdateResponse.patchSdkVersion + "\npatchBuilderNum=" + getHotSdkUpdateResponse.patchBuilderNum + "\npatchSize=" + getHotSdkUpdateResponse.patchSize + "\nnetType=" + getHotSdkUpdateResponse.netType + "\npatchMD5=" + getHotSdkUpdateResponse.patchMD5);
        this.f1156a.h = getHotSdkUpdateResponse;
        com.tencent.tmselfupdatesdk.b.f fVar2 = this.f1156a;
        com.tencent.tmselfupdatesdk.util.a.a("getPatchSuccess", true, fVar2.b(fVar2.h.patchSdkVersion, this.f1156a.h.patchBuilderNum));
        if ((this.f1156a.e != null && this.f1156a.h.patchSdkVersion <= this.f1156a.e.g) || this.f1156a.h.patchSdkVersion <= 3010) {
            com.tencent.tmassistantbase.util.x.b("PatchManager", "返回的补丁包版本小于或等于当前版本，不下载补丁！");
            com.tencent.tmselfupdatesdk.b.f fVar3 = this.f1156a;
            strArr = new java.lang.String[]{fVar3.b(fVar3.h.patchSdkVersion, this.f1156a.h.patchBuilderNum)};
            str = "giveupPatchDownloadForLowVersion";
        } else if (com.tencent.tmassistantbase.b.d.c() || (this.f1156a.h.netType & 7) != 0) {
            java.util.List listG = this.f1156a.g();
            com.tencent.tmselfupdatesdk.b.f fVar4 = this.f1156a;
            if (!listG.contains(fVar4.b(fVar4.h.patchSdkVersion, this.f1156a.h.patchBuilderNum))) {
                com.tencent.tmselfupdatesdk.b.f fVar5 = this.f1156a;
                com.tencent.tmselfupdatesdk.util.a.a("startPatchDownload", true, fVar5.b(fVar5.h.patchSdkVersion, this.f1156a.h.patchBuilderNum));
                java.lang.String strA = com.tencent.tmassistantbase.util.n.a(getHotSdkUpdateResponse.patchUrl);
                com.tencent.tmassistantbase.util.x.a("PatchManager", "url=" + getHotSdkUpdateResponse.patchUrl + ". fileName=" + strA);
                if (4 == com.tencent.tmselfupdatesdk.g.a().a(getHotSdkUpdateResponse.patchUrl, strA, this.f1156a.k)) {
                    com.tencent.tmassistantbase.util.x.a("PatchManager", "PatchManager >> mUpdateCallback.onRequestSucceed. 更新包已存在。");
                    this.f1156a.k.OnDownloadSDKTaskStateChanged(com.tencent.tmselfupdatesdk.g.a().a((com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener) null), getHotSdkUpdateResponse.patchUrl, 4, 0, "");
                    return;
                }
                return;
            }
            com.tencent.tmassistantbase.util.x.a("PatchManager", "当前补丁在此手机上发生过异常，不下载补丁.");
            com.tencent.tmselfupdatesdk.b.f fVar6 = this.f1156a;
            strArr = new java.lang.String[]{fVar6.b(fVar6.h.patchSdkVersion, this.f1156a.h.patchBuilderNum)};
            str = "giveupPatchDownloadForException";
        } else {
            com.tencent.tmassistantbase.util.x.a("PatchManager", "当前无wifi，后台下发的配置为" + this.f1156a.h.netType + ". 不下载补丁.");
            com.tencent.tmselfupdatesdk.b.f fVar7 = this.f1156a;
            strArr = new java.lang.String[]{fVar7.b(fVar7.h.patchSdkVersion, this.f1156a.h.patchBuilderNum), com.tencent.tmassistantbase.b.d.e().name(), java.lang.String.valueOf(this.f1156a.h.netType)};
            str = "giveupPatchDownloadForNettype";
        }
        com.tencent.tmselfupdatesdk.util.a.a(str, true, strArr);
    }
}
