package com.tencent.tmselfupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class h implements com.tencent.tmassistantbase.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmselfupdatesdk.g f1166a;

    h(com.tencent.tmselfupdatesdk.g gVar) {
        this.f1166a = gVar;
    }

    @Override // com.tencent.tmassistantbase.common.c
    public void a(java.lang.String str, int i) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "enter");
        if (i == 1) {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "packageAction == PackageInstallReceiver.PACKAGE_ADDED");
            if (str.equals("com.tencent.android.qqdownloader")) {
                new android.os.Handler().postDelayed(new com.tencent.tmselfupdatesdk.i(this), 3000L);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "exit");
    }
}
