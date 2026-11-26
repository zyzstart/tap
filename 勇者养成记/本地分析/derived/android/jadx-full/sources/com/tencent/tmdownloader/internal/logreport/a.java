package com.tencent.tmdownloader.internal.logreport;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class a extends android.os.Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmdownloader.internal.logreport.AppInstallReportReceiver f1138a;

    a(com.tencent.tmdownloader.internal.logreport.AppInstallReportReceiver appInstallReportReceiver) {
        this.f1138a = appInstallReportReceiver;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        super.handleMessage(message);
        this.f1138a.a((java.lang.String) message.obj, message.what);
    }
}
