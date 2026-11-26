package com.tencent.tmassistantsdk.internal.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class d implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.os.Handler f1070a;
    final /* synthetic */ com.tencent.tmassistantsdk.internal.b.a b;

    d(com.tencent.tmassistantsdk.internal.b.a aVar, android.os.Handler handler) {
        this.b = aVar;
        this.f1070a = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.b.f1067a = ((com.tencent.tmassistantbase.common.download.c) this.b).mContext.bindService(this.b.getBindServiceIntent(), this.b, 1);
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e("TMAssistantDownloadOpenSDKClient", "retry bind service Exception:", e);
        }
        this.b.b++;
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantDownloadOpenSDKClient", "retry bind service! retryBindResult:" + this.b.f1067a + ",retryCount:" + this.b.b);
        com.tencent.tmassistantsdk.internal.b.a aVar = this.b;
        if (aVar.f1067a || aVar.b >= 3) {
            return;
        }
        this.f1070a.postDelayed(this, 1000L);
    }
}
