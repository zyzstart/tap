package com.tencent.tmselfupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class b implements com.tencent.tmapkupdatesdk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmselfupdatesdk.a f1149a;

    b(com.tencent.tmselfupdatesdk.a aVar) {
        this.f1149a = aVar;
    }

    @Override // com.tencent.tmapkupdatesdk.a
    public void a(java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "arg0: " + str);
        if (com.tencent.tmselfupdatesdk.a.j) {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "<onCheckUpdateFailed> sending fail updateInfo by onAppStateChanged");
            com.tencent.tmselfupdatesdk.a aVar = this.f1149a;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onCheckUpdateFailed; message=");
            sb.append(str != null ? str : "");
            aVar.a(102, -12, sb.toString());
        } else {
            com.tencent.tmselfupdatesdk.model.TMSelfUpdateUpdateInfo tMSelfUpdateUpdateInfo = new com.tencent.tmselfupdatesdk.model.TMSelfUpdateUpdateInfo(1, 0, 0L, 0L, "", "", (byte) 0, "", 0);
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "<onCheckUpdateFailed> sending fail updateInfo by onCheckNeedUpdateInfo");
            this.f1149a.a(tMSelfUpdateUpdateInfo);
        }
        com.tencent.tmselfupdatesdk.p.a(23, java.lang.String.valueOf(106), java.lang.String.valueOf(str));
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "exit");
    }

    @Override // com.tencent.tmapkupdatesdk.a
    public void a(java.util.ArrayList arrayList) {
        com.tencent.tmselfupdatesdk.model.TMSelfUpdateUpdateInfo tMSelfUpdateUpdateInfo;
        java.lang.String str;
        java.lang.String str2;
        com.tencent.tmselfupdatesdk.a aVar;
        int i;
        int i2;
        java.lang.String str3;
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "enter");
        if (arrayList == null || arrayList.size() <= 0) {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "apkUpdateDetailList == null || apkUpdateDetailList.size() <=0");
            if (com.tencent.tmselfupdatesdk.a.j) {
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "<onCheckUpdateSucceed> sending no updateInfo(onAppStateChanged)");
                aVar = this.f1149a;
                i = 100;
                i2 = -15;
                str3 = "SelfUpdate success, NO Update!";
                aVar.a(i, i2, str3);
            } else {
                tMSelfUpdateUpdateInfo = new com.tencent.tmselfupdatesdk.model.TMSelfUpdateUpdateInfo(0, 0, 0L, 0L, "", "", (byte) 0, "", 0);
                str = "TMSelfUpdate_CommonUpdateManager";
                str2 = "<onCheckUpdateSucceed> apkUpdateDetailList == null || apkUpdateDetailList.size() <=0, sending no update info";
                com.tencent.tmassistantbase.util.TMLog.i(str, str2);
                this.f1149a.a(tMSelfUpdateUpdateInfo);
            }
        } else {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "onCheckUpdateSucceed apkUpdateDetailList size: " + arrayList.size());
            this.f1149a.i = (com.tencent.tmapkupdatesdk.model.ApkUpdateDetail) arrayList.get(0);
            if (!com.tencent.tmselfupdatesdk.a.j) {
                if (this.f1149a.i != null) {
                    tMSelfUpdateUpdateInfo = this.f1149a.g();
                    com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "<onCheckUpdateSucceed> sending updateInfo(onCheckNeedUpdateInfo):" + tMSelfUpdateUpdateInfo.toString());
                } else {
                    tMSelfUpdateUpdateInfo = new com.tencent.tmselfupdatesdk.model.TMSelfUpdateUpdateInfo(2, 0, 0L, 0L, "", "", (byte) 0, "", 0);
                    str = "TMSelfUpdate_CommonUpdateManager";
                    str2 = "<onCheckUpdateSucceed> mApkUpdateDetail is null, sending no update info(onCheckNeedUpdateInfo)";
                    com.tencent.tmassistantbase.util.TMLog.i(str, str2);
                }
                this.f1149a.a(tMSelfUpdateUpdateInfo);
            } else if (this.f1149a.i != null) {
                com.tencent.tmselfupdatesdk.a aVar2 = this.f1149a;
                aVar2.a(aVar2.i);
            } else {
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "<onCheckUpdateSucceed> sending fail updateInfo(onAppStateChanged)");
                aVar = this.f1149a;
                i = 102;
                i2 = -13;
                str3 = "onCheckUpdateSucceed,but apkUpdateDetailList is null!";
                aVar.a(i, i2, str3);
            }
        }
        com.tencent.tmselfupdatesdk.p.a(23, java.lang.String.valueOf(105), java.lang.String.valueOf(this.f1149a.i == null ? 1 : this.f1149a.i.updatemethod));
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", "exit");
    }
}
