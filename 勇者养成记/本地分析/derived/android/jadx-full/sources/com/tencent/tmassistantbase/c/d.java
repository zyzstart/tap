package com.tencent.tmassistantbase.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class d implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantbase.c.b f1016a;

    d(com.tencent.tmassistantbase.c.b bVar) {
        this.f1016a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.String str;
        java.lang.String str2;
        com.tencent.tmassistantbase.util.TMLog.i("SDKReportManager2", ">>onNetworkChanged enter");
        if (this.f1016a.c == null) {
            str = "SDKReportManager2";
            str2 = ">>onNetworkChanged mPostHandler == null return";
        } else {
            com.tencent.tmassistantbase.b.d.f();
            if (com.tencent.tmdownloader.internal.downloadservice.c.b()) {
                com.tencent.tmassistantbase.util.TMLog.i("SDKReportManager2", ">>onNetworkChanged connect");
                if (!this.f1016a.c.hasMessages(2)) {
                    this.f1016a.c.sendEmptyMessage(2);
                }
            } else {
                com.tencent.tmassistantbase.util.TMLog.i("SDKReportManager2", ">>onNetworkChanged unconnect");
                if (this.f1016a.c.hasMessages(2)) {
                    this.f1016a.c.removeMessages(2);
                }
            }
            str = "SDKReportManager2";
            str2 = ">>onNetworkChanged exit";
        }
        com.tencent.tmassistantbase.util.TMLog.i(str, str2);
    }
}
