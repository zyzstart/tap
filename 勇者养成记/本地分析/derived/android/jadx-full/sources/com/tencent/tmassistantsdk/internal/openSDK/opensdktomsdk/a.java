package com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class a implements android.os.Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager f1085a;

    a(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager tMAssistantAuthorizedManager) {
        this.f1085a = tMAssistantAuthorizedManager;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        switch (message.what) {
            case 0:
                int i = message.arg1;
                this.f1085a.handleInstall(message.obj.toString(), i);
                break;
            case 1:
                android.os.Bundle data = message.getData();
                if (data != null) {
                    this.f1085a.handleDownloading(data.getLong("receiveDataLen"), data.getLong("totalDataLen"));
                }
                break;
            case 3:
                this.f1085a.handleDownloadFailed();
                break;
            case 4:
                com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.b bVar = (com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.b) message.obj;
                if (bVar != null) {
                    this.f1085a.onNetworkFinishedSuccess(bVar);
                }
                break;
            case 5:
                this.f1085a.onNetworkFinishedFailed(((java.lang.Integer) message.obj).intValue());
                break;
            case 6:
                android.os.Bundle data2 = message.getData();
                if (data2 != null) {
                    this.f1085a.handleDownloadContinue(data2.getLong("receiveDataLen"), data2.getLong("totalDataLen"));
                }
                break;
        }
        return false;
    }
}
