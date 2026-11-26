package com.tencent.tmdownloader;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TMAssistantDownloadSettingClient extends com.tencent.tmassistantbase.common.download.c {
    protected static final java.lang.String DOWNDLOADSDKSERVICENAME = "com.tencent.tmdownloader.TMAssistantDownloadService";
    protected static final java.lang.String TAG = "TMAssistantDownloadSettingClient";

    public TMAssistantDownloadSettingClient(android.content.Context context, java.lang.String str) {
        super(context, str, DOWNDLOADSDKSERVICENAME);
    }

    @Override // com.tencent.tmassistantbase.common.download.c
    protected android.content.Intent getBindServiceIntent() {
        return new android.content.Intent(this.mContext, java.lang.Class.forName(this.mDwonloadServiceName));
    }

    public synchronized int getVersion() {
        com.tencent.tmassistantbase.aidl.d dVar = (com.tencent.tmassistantbase.aidl.d) super.getServiceInterface();
        if (dVar != null) {
            return dVar.a();
        }
        super.initTMAssistantDownloadSDK();
        return 0;
    }

    public synchronized boolean isAllDownloadFinished() {
        boolean zB;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        zB = false;
        com.tencent.tmassistantbase.aidl.d dVar = (com.tencent.tmassistantbase.aidl.d) super.getServiceInterface();
        if (dVar != null) {
            try {
                zB = dVar.b();
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "isAllDownloadFinished");
            } catch (java.lang.Exception e) {
                com.tencent.tmassistantbase.util.TMLog.w(TAG, "isAllDownloadFinished Exception:", e);
            }
        } else {
            super.initTMAssistantDownloadSDK();
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "initTMAssistantDownloadSDK");
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "isAllDownloadFinished ret:" + zB);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        return zB;
    }

    @Override // com.tencent.tmassistantbase.common.download.c
    protected void onDownloadSDKServiceInvalid() {
    }

    @Override // com.tencent.tmassistantbase.common.download.c
    protected void registerServiceCallback() {
        ((com.tencent.tmassistantbase.aidl.d) this.mServiceInterface).a(this.mClientKey, (com.tencent.tmassistantbase.aidl.a) this.mServiceCallback);
    }

    public synchronized void setDownloadSDKMaxTaskNum(int i) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "maxTaskNum: " + i);
        if (i >= 1 && i <= 10) {
            com.tencent.tmassistantbase.aidl.d dVar = (com.tencent.tmassistantbase.aidl.d) super.getServiceInterface();
            if (dVar != null) {
                try {
                    dVar.a(i);
                    com.tencent.tmassistantbase.util.TMLog.i(TAG, "setServiceSetingMaxTaskNum");
                } catch (java.lang.Exception e) {
                    com.tencent.tmassistantbase.util.TMLog.w(TAG, "setDownloadSDKMaxTaskNum Exception:", e);
                }
            } else {
                super.initTMAssistantDownloadSDK();
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "initTMAssistantDownloadSDK");
            }
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "maxTaskNum < 1 || maxTaskNum > 10");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    public synchronized void setDownloadSDKWifiOnly(boolean z) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "isDownloadWifiOnly: " + z);
        com.tencent.tmassistantbase.aidl.d dVar = (com.tencent.tmassistantbase.aidl.d) super.getServiceInterface();
        if (dVar != null) {
            try {
                dVar.b(z);
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "setDownloadWifiOnly");
            } catch (java.lang.Exception e) {
                com.tencent.tmassistantbase.util.TMLog.w(TAG, "setDownloadSDKWifiOnly Exception:", e);
            }
        } else {
            super.initTMAssistantDownloadSDK();
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "initTMAssistantDownloadSDK");
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    @Override // com.tencent.tmassistantbase.common.download.c
    protected void stubAsInterface(android.os.IBinder iBinder) {
        this.mServiceInterface = com.tencent.tmassistantbase.aidl.e.a(iBinder);
    }

    @Override // com.tencent.tmassistantbase.common.download.c
    protected void unRegisterServiceCallback() {
        ((com.tencent.tmassistantbase.aidl.d) this.mServiceInterface).b(this.mClientKey, (com.tencent.tmassistantbase.aidl.a) this.mServiceCallback);
    }
}
