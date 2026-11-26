package com.tencent.tmassistantsdk.internal.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class b extends com.tencent.assistant.sdk.remote.SDKActionCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantsdk.internal.b.a f1068a;

    b(com.tencent.tmassistantsdk.internal.b.a aVar) {
        this.f1068a = aVar;
    }

    @Override // com.tencent.assistant.sdk.remote.SDKActionCallback
    public void onActionResult(byte[] bArr) {
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantDownloadOpenSDKClient", "onActionResult  callBack data:" + bArr + "  mListeners.size:" + this.f1068a.c.size());
        com.tencent.tmassistantbase.common.download.e.a().a(bArr, this.f1068a.c);
    }
}
