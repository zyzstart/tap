package com.tencent.tmselfupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmapkupdatesdk.model.ApkUpdateDetail f1159a;
    final /* synthetic */ com.tencent.tmselfupdatesdk.a b;

    c(com.tencent.tmselfupdatesdk.a aVar, com.tencent.tmapkupdatesdk.model.ApkUpdateDetail apkUpdateDetail) {
        this.b = aVar;
        this.f1159a = apkUpdateDetail;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("selfUpdateDetail:pakgname=");
            sb.append(this.b.i.packageName != null ? this.b.i.packageName : "");
            sb.append("; versioncode=");
            sb.append(this.b.i.versioncode);
            sb.append("; updatemethod=");
            sb.append(this.b.i.updatemethod);
            sb.append("; url=");
            sb.append(this.b.i.url != null ? this.b.i.url : "");
            sb.append("; overwriteChannelid=");
            sb.append((int) this.b.i.overwriteChannelid);
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_CommonUpdateManager", sb.toString());
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString(com.tencent.tmassistantbase.common.download.TMAssistantDownloadConst.PARAM_TASK_PACKNAME, this.b.g);
            bundle.putString(com.tencent.tmassistantbase.common.download.TMAssistantDownloadConst.PARAM_CHANNELID, this.b.h);
            bundle.putString(com.tencent.tmassistantbase.common.download.TMAssistantDownloadConst.PARAM_VIA, this.b.f1145a);
            if (this.b.i.updatemethod != 4 && this.b.i.updatemethod != 5) {
                if (this.b.i.updatemethod == 2) {
                    this.b.b(bundle, this.f1159a);
                    return;
                } else if (this.b.i.updatemethod == 1) {
                    this.b.a(100, -15, "SelfUpdate success, NO Update!");
                    return;
                } else {
                    this.b.a(102, -20, "SelfUpdate failure, UNKNOWN EXCEPTION!");
                    return;
                }
            }
            this.b.a(bundle, this.f1159a);
        } catch (java.lang.Throwable th) {
            this.b.a(102, -20, "SelfUpdate failure, UNKNOWN EXCEPTION!");
            com.tencent.tmassistantbase.util.TMLog.e("TMSelfUpdate_CommonUpdateManager", "exception:", th);
            th.printStackTrace();
        }
    }
}
