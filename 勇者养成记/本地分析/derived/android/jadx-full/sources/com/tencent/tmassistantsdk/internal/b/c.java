package com.tencent.tmassistantsdk.internal.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantsdk.internal.b.a f1069a;

    c(com.tencent.tmassistantsdk.internal.b.a aVar) {
        this.f1069a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int iRegisterActionCallback;
        java.lang.String strB = com.tencent.tmassistantbase.util.b.b(new com.tencent.tmassistantbase.util.g().b(java.lang.String.valueOf(java.lang.System.currentTimeMillis()).getBytes(), this.f1069a.mClientKey.getBytes()), 0);
        if (((com.tencent.tmassistantbase.common.download.c) this.f1069a).mServiceInterface != null) {
            try {
                iRegisterActionCallback = ((com.tencent.assistant.sdk.remote.BaseService) ((com.tencent.tmassistantbase.common.download.c) this.f1069a).mServiceInterface).registerActionCallback(this.f1069a.mClientKey, strB, (com.tencent.assistant.sdk.remote.SDKActionCallback) ((com.tencent.tmassistantbase.common.download.c) this.f1069a).mServiceCallback);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
                iRegisterActionCallback = 2;
            }
        } else {
            iRegisterActionCallback = 2;
        }
        com.tencent.tmassistantbase.util.TMLog.i("[REDACTED]", "[REDACTED]" + this.f1069a.mClientKey + "[REDACTED]" + strB + "[REDACTED]" + java.lang.Thread.currentThread().getId() + "[REDACTED]" + ((com.tencent.tmassistantbase.common.download.c) this.f1069a).mServiceCallback + "[REDACTED]" + iRegisterActionCallback);
        if (iRegisterActionCallback == 2) {
            this.f1069a.onDownloadSDKServiceInvalid();
        }
    }
}
