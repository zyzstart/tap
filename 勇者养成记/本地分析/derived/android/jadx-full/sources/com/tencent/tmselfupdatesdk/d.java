package com.tencent.tmselfupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class d implements com.tencent.yybsdk.apkpatch.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmselfupdatesdk.a f1160a;

    d(com.tencent.tmselfupdatesdk.a aVar) {
        this.f1160a = aVar;
    }

    @Override // com.tencent.yybsdk.apkpatch.r
    public void a(com.tencent.yybsdk.apkpatch.u uVar, int i, int i2) {
    }

    @Override // com.tencent.yybsdk.apkpatch.r
    public void a(com.tencent.yybsdk.apkpatch.u uVar, int i, int i2, java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "onApkPatchState; task=" + uVar + "; state=" + i + "; errorCode=" + i2 + "; errorMsg=" + str);
        if (uVar == null || android.text.TextUtils.isEmpty(this.f1160a.f)) {
            return;
        }
        if (i == 7) {
            com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_new_algorithm_result", true, java.lang.String.valueOf(java.lang.System.currentTimeMillis() - this.f1160a.p));
            if (!this.f1160a.f.equals(uVar.c)) {
                return;
            }
            com.tencent.tmselfupdatesdk.a aVar = this.f1160a;
            aVar.c(aVar.f);
            this.f1160a.a(100, 7, "SelfUpdate success,New pkg gen success!");
            str2 = "TMSelfUpdate_CommonUpdateManager";
            str3 = "<onApkPatchState> gen succ,call onAppStateChanged, state = ApkPatchConstant.STATE_SUCCEED";
        } else {
            if (i != 8) {
                return;
            }
            com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_new_algorithm_result", false, java.lang.String.valueOf(i2), str);
            this.f1160a.a(102, 8, "SelfUpdate failure,genNewApk failure!");
            str2 = "TMSelfUpdate_CommonUpdateManager";
            str3 = "<onApkPatchState> gen faile,call onAppStateChanged, state = ApkPatchConstant.STATE_FAILED";
        }
        com.tencent.tmassistantbase.util.TMLog.i(str2, str3);
    }
}
