package com.tencent.tmassistantsdk.internal.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends com.tencent.tmassistantbase.common.download.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f1067a;
    protected int b;
    java.util.ArrayList c;

    public a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        super(context, str, str2);
        this.f1067a = false;
        this.b = 0;
        this.c = new java.util.ArrayList();
        this.mServiceCallback = new com.tencent.tmassistantsdk.internal.b.b(this);
    }

    public void a(com.tencent.tmassistantbase.common.download.a aVar) {
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantDownloadOpenSDKClient", "addAssistantOnActionListener");
        if (aVar == null || this.c.contains(aVar)) {
            return;
        }
        this.c.add(aVar);
    }

    public byte[] a(byte[] bArr) {
        if (android.text.TextUtils.isEmpty(this.mClientKey)) {
            return null;
        }
        com.tencent.assistant.sdk.remote.BaseService baseService = (com.tencent.assistant.sdk.remote.BaseService) super.getServiceInterface();
        if (baseService != null) {
            return baseService.sendSyncData(this.mClientKey, bArr);
        }
        super.initTMAssistantDownloadSDK();
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantDownloadOpenSDKClient", "initTMAssistantDownloadSDK");
        return null;
    }

    public void b(byte[] bArr) {
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantDownloadOpenSDKClient", "sendAsyncData");
        if (android.text.TextUtils.isEmpty(this.mClientKey)) {
            return;
        }
        com.tencent.assistant.sdk.remote.BaseService baseService = (com.tencent.assistant.sdk.remote.BaseService) super.getServiceInterface();
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantDownloadOpenSDKClient", "sendAsyncData baseService:" + baseService);
        if (baseService != null) {
            com.tencent.tmassistantbase.util.TMLog.i("TMAssistantDownloadOpenSDKClient", "baseService sendAsyncData");
            baseService.sendAsyncData(this.mClientKey, bArr);
        } else {
            super.initTMAssistantDownloadSDK();
            com.tencent.tmassistantbase.util.TMLog.i("TMAssistantDownloadOpenSDKClient", "initTMAssistantDownloadSDK");
        }
    }

    @Override // com.tencent.tmassistantbase.common.download.c
    protected android.content.Intent getBindServiceIntent() {
        return new android.content.Intent(this.mDwonloadServiceName).setClassName("com.tencent.android.qqdownloader", com.tencent.ysdk.shell.framework.constant.Constant.MY_APP_CLS);
    }

    @Override // com.tencent.tmassistantbase.common.download.c
    public synchronized boolean initTMAssistantDownloadSDK() {
        boolean zInitTMAssistantDownloadSDK;
        zInitTMAssistantDownloadSDK = super.initTMAssistantDownloadSDK();
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantDownloadOpenSDKClient", "initTMAssistantDownloadSDK bindResult:" + zInitTMAssistantDownloadSDK);
        if (!zInitTMAssistantDownloadSDK) {
            try {
                android.content.Intent intent = new android.content.Intent();
                intent.setClassName("com.tencent.android.qqdownloader", "com.tencent.pangu.link.LinkProxyActivity");
                intent.addFlags(268435456);
                this.mContext.startActivity(intent);
            } catch (java.lang.Exception e) {
                com.tencent.tmassistantbase.util.TMLog.w("TMAssistantDownloadOpenSDKClient", "retry bind service startActivity Exception:", e);
            }
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("retry_thread");
            handlerThread.start();
            android.os.Handler handler = new android.os.Handler(handlerThread.getLooper());
            handler.postDelayed(new com.tencent.tmassistantsdk.internal.b.d(this, handler), 1000L);
        }
        return zInitTMAssistantDownloadSDK;
    }

    @Override // com.tencent.tmassistantbase.common.download.c
    protected void onDownloadSDKServiceInvalid() {
        java.util.ArrayList arrayList = this.c;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (com.tencent.tmassistantbase.common.download.a aVar : this.c) {
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    @Override // com.tencent.tmassistantbase.common.download.c
    protected void registerServiceCallback() {
        new java.lang.Thread(new com.tencent.tmassistantsdk.internal.b.c(this)).start();
    }

    @Override // com.tencent.tmassistantbase.common.download.c
    protected void stubAsInterface(android.os.IBinder iBinder) {
        this.mServiceInterface = com.tencent.assistant.sdk.remote.BaseService.Stub.asInterface(iBinder);
    }

    @Override // com.tencent.tmassistantbase.common.download.c
    protected void unRegisterServiceCallback() {
        if (((com.tencent.assistant.sdk.remote.BaseService) this.mServiceInterface).unregisterActionCallback((com.tencent.assistant.sdk.remote.SDKActionCallback) this.mServiceCallback) == 2) {
            onDownloadSDKServiceInvalid();
        }
    }
}
