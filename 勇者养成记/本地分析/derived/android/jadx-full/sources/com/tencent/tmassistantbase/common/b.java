package com.tencent.tmassistantbase.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class b extends android.os.Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantbase.common.PackageInstallReceiver f1019a;

    b(com.tencent.tmassistantbase.common.PackageInstallReceiver packageInstallReceiver) {
        this.f1019a = packageInstallReceiver;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        super.handleMessage(message);
        this.f1019a.a((java.lang.String) message.obj, message.what);
    }
}
