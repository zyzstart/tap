package com.tencent.tmassistantbase.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c extends android.os.Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantbase.c.b f1015a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    c(com.tencent.tmassistantbase.c.b bVar, android.os.Looper looper) {
        super(looper);
        this.f1015a = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        com.tencent.tmassistantbase.util.TMLog.i("SDKReportManager2", ">>mPostHandler handleMessage enter");
        int i = message.what;
        if (i == 1) {
            com.tencent.tmassistantbase.util.TMLog.i("SDKReportManager2", ">>mPostHandler msg = MSG_POST_REPORT");
            this.f1015a.g();
        } else if (i == 2) {
            com.tencent.tmassistantbase.util.TMLog.i("SDKReportManager2", ">>mPostHandler msg = MSG_BATCH_REPORT");
            this.f1015a.f();
        }
        com.tencent.tmassistantbase.util.TMLog.i("SDKReportManager2", ">>mPostHandler handleMessage exit");
    }
}
