package com.tencent.tmdownloader;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TMAssistantDownloadService extends android.app.Service implements com.tencent.tmdownloader.internal.downloadservice.a.a {
    protected static final java.lang.String TAG = "TMSelfUpdate_TMAssistantDownloadService";
    protected final com.tencent.tmdownloader.b downloadSDKServiceImpl = new com.tencent.tmdownloader.b(this);
    protected final android.os.RemoteCallbackList mCallbacks = new android.os.RemoteCallbackList();
    protected final java.util.HashMap mCallbackHashMap = new java.util.HashMap();
    com.tencent.tmdownloader.internal.downloadservice.a.c mServiceDownloadTaskManager = null;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.tmdownloader.internal.downloadservice.a.a
    public void OnDownloadProgressChanged(java.lang.String str, java.lang.String str2, long j, long j2) {
        synchronized (this.mCallbacks) {
            try {
                int iBeginBroadcast = this.mCallbacks.beginBroadcast();
                for (int i = 0; i < iBeginBroadcast; i++) {
                    try {
                        com.tencent.tmassistantbase.aidl.a aVar = (com.tencent.tmassistantbase.aidl.a) this.mCallbacks.getBroadcastItem(i);
                        java.lang.String str3 = (java.lang.String) this.mCallbackHashMap.get(aVar);
                        if (str3 != null) {
                            try {
                                if (str3.equals(str)) {
                                    aVar.a(str, str2, j, j2);
                                }
                            } catch (android.os.RemoteException e) {
                                e = e;
                                com.tencent.tmassistantbase.util.TMLog.e(TAG, "exception: ", e);
                            }
                        }
                    } catch (android.os.RemoteException e2) {
                        e = e2;
                    }
                }
                this.mCallbacks.finishBroadcast();
            } catch (java.lang.Throwable th) {
                android.util.Log.e(TAG, "exception: ", th);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.tmdownloader.internal.downloadservice.a.a
    public void OnDownloadStateChanged(java.lang.String str, java.lang.String str2, int i, int i2, java.lang.String str3) {
        synchronized (this.mCallbacks) {
            try {
                int iBeginBroadcast = this.mCallbacks.beginBroadcast();
                for (int i3 = 0; i3 < iBeginBroadcast; i3++) {
                    try {
                        com.tencent.tmassistantbase.aidl.a aVar = (com.tencent.tmassistantbase.aidl.a) this.mCallbacks.getBroadcastItem(i3);
                        java.lang.String str4 = (java.lang.String) this.mCallbackHashMap.get(aVar);
                        if (str4 != null && str4.equals(str)) {
                            aVar.a(str, str2, i, i2, str3);
                        }
                    } catch (android.os.RemoteException e) {
                        android.util.Log.e(TAG, "exception: ", e);
                    }
                }
                this.mCallbacks.finishBroadcast();
            } catch (java.lang.Throwable th) {
                com.tencent.tmassistantbase.util.TMLog.e(TAG, "exception: ", th);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "intent:" + intent);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: " + this.downloadSDKServiceImpl);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        return this.downloadSDKServiceImpl;
    }

    @Override // android.app.Service
    public void onCreate() {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        super.onCreate();
        com.tencent.tmassistantbase.util.k.a().a(this);
        com.tencent.tmassistantbase.network.NetworkMonitorReceiver.a().b();
        com.tencent.tmdownloader.internal.logreport.AppInstallReportReceiver.a().b();
        com.tencent.tmdownloader.internal.downloadservice.a.c cVar = new com.tencent.tmdownloader.internal.downloadservice.a.c(com.tencent.tmdownloader.internal.b.a.a().c());
        this.mServiceDownloadTaskManager = cVar;
        cVar.a(this);
        this.mServiceDownloadTaskManager.a();
        com.tencent.tmdownloader.internal.downloadservice.a.b().c();
        com.tencent.tmdownloader.internal.a.a.b().c();
        new java.lang.Thread(new com.tencent.tmdownloader.a(this)).start();
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        super.onDestroy();
        com.tencent.tmdownloader.internal.downloadservice.a.b().d();
        com.tencent.tmdownloader.internal.logreport.i.a().d();
        com.tencent.tmdownloader.internal.logreport.i.a().b();
        this.mServiceDownloadTaskManager.b();
        this.mServiceDownloadTaskManager.a((com.tencent.tmdownloader.internal.downloadservice.a.a) null);
        this.mServiceDownloadTaskManager = null;
        com.tencent.tmassistantbase.network.NetworkMonitorReceiver.a().c();
        com.tencent.tmdownloader.internal.logreport.AppInstallReportReceiver.a().c();
        com.tencent.tmassistantbase.util.k.a().c();
        android.os.SystemClock.sleep(300L);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver.a().b(this);
    }

    @Override // android.app.Service
    public boolean onUnbind(android.content.Intent intent) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "intent:" + intent);
        boolean zOnUnbind = super.onUnbind(intent);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: " + zOnUnbind);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        return zOnUnbind;
    }
}
