package com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class b implements com.tencent.tmassistantsdk.internal.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager f1087a;

    b(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager tMAssistantAuthorizedManager) {
        this.f1087a = tMAssistantAuthorizedManager;
    }

    @Override // com.tencent.tmassistantsdk.internal.d.b
    public void a(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.b bVar, int i) {
        java.lang.Object objValueOf;
        android.os.Message message = new android.os.Message();
        if (i != 0) {
            message.what = 5;
            objValueOf = java.lang.Integer.valueOf(i);
        } else {
            if (bVar == null) {
                return;
            }
            message.what = 4;
            objValueOf = bVar;
        }
        message.obj = objValueOf;
        this.f1087a.mMainMessageHandler.sendMessage(message);
    }
}
