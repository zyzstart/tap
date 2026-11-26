package com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class d implements android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager f1092a;

    d(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager tMAssistantAuthorizedManager) {
        this.f1092a = tMAssistantAuthorizedManager;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager tMAssistantAuthorizedManager = this.f1092a;
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedInfo tMAssistantAuthorizedInfo = tMAssistantAuthorizedManager.mAuthorizedInfo;
        if (tMAssistantAuthorizedInfo == null) {
            return;
        }
        android.content.Context context = tMAssistantAuthorizedManager.mContext;
        if (context != null) {
            tMAssistantAuthorizedManager.getUserAuthorizedInfo(tMAssistantAuthorizedInfo, context);
        }
        this.f1092a.dialog.dismiss();
    }
}
