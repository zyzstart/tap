package com.tencent.tmassistantbase.common.download;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class d implements android.os.IBinder.DeathRecipient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantbase.common.download.c f1021a;

    d(com.tencent.tmassistantbase.common.download.c cVar) {
        this.f1021a = cVar;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantDownloadClientBase", "IBinder.DeathRecipient binderDied");
        synchronized (this.f1021a) {
            this.f1021a.mServiceInterface = null;
            this.f1021a.connectState = com.tencent.tmassistantbase.common.download.c.CONNTECTSTATE_INIT;
            synchronized (this.f1021a.mThreadlock) {
                this.f1021a.mThreadlock.notifyAll();
            }
            this.f1021a.onDownloadSDKServiceInvalid();
        }
    }
}
