package com.tencent.tmselfupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class k implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f1169a;
    final /* synthetic */ com.tencent.tmselfupdatesdk.g b;

    k(com.tencent.tmselfupdatesdk.g gVar, boolean z) {
        this.b = gVar;
        this.f1169a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.h() != null) {
            try {
                this.b.j = this.f1169a;
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString(com.tencent.tmassistantbase.common.download.TMAssistantDownloadConst.PARAM_APPID, "50801");
                bundle.putString(com.tencent.tmassistantbase.common.download.TMAssistantDownloadConst.PARAM_TASK_PACKNAME, "com.tencent.android.qqdownloader");
                bundle.putString(com.tencent.tmassistantbase.common.download.TMAssistantDownloadConst.PARAM_CHANNELID, this.b.b);
                bundle.putString(com.tencent.tmassistantbase.common.download.TMAssistantDownloadConst.PARAM_VIA, this.b.c + ".wifipredownload");
                bundle.putByte(com.tencent.tmassistantbase.common.download.TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, (byte) 2);
                int iStartDownloadTask = this.b.h().startDownloadTask(this.b.h, 2, com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK, null, null, bundle);
                if (this.b.j && 4 == iStartDownloadTask) {
                    this.b.k();
                } else {
                    com.tencent.tmselfupdatesdk.p.a(24, java.lang.String.valueOf(107), java.lang.String.valueOf(this.f1169a));
                }
            } catch (java.lang.Exception e) {
                com.tencent.tmassistantbase.util.TMLog.e("TMSelfUpdate_SaveUpdateManager", "exception:", e);
                e.printStackTrace();
            }
        }
    }
}
