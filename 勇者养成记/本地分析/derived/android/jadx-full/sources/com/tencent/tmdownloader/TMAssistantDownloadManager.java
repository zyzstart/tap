package com.tencent.tmdownloader;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TMAssistantDownloadManager {
    protected static final java.lang.String TAG = "TMAssistantDownloadManager";
    protected static com.tencent.tmdownloader.TMAssistantDownloadManager mInstance;
    protected static java.util.ArrayList mSDKClientList = new java.util.ArrayList();
    protected static com.tencent.tmdownloader.TMAssistantDownloadSettingClient mSDKSettingClient = null;
    protected android.content.Context mContext;

    protected TMAssistantDownloadManager(android.content.Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void closeAllService(android.content.Context context) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        if (context == null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "you must input an application or activity context!");
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
            return;
        }
        if (mInstance == null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "manager minstance == null");
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
            return;
        }
        java.util.ArrayList arrayList = mSDKClientList;
        if (arrayList != null && arrayList.size() > 0) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "mSDKClientList != null && mSDKClientList.size() > 0");
            for (com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient : mSDKClientList) {
                if (tMAssistantDownloadClient != null) {
                    tMAssistantDownloadClient.unInitTMAssistantDownloadSDK();
                }
            }
            mSDKClientList.clear();
        }
        com.tencent.tmdownloader.TMAssistantDownloadSettingClient tMAssistantDownloadSettingClient = mSDKSettingClient;
        if (tMAssistantDownloadSettingClient != null) {
            tMAssistantDownloadSettingClient.unInitTMAssistantDownloadSDK();
            mSDKSettingClient = null;
        }
        mInstance = null;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    public static synchronized com.tencent.tmdownloader.TMAssistantDownloadManager getInstance(android.content.Context context) {
        if (mInstance == null) {
            mInstance = new com.tencent.tmdownloader.TMAssistantDownloadManager(context);
        }
        return mInstance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient getDownloadSDKClient(java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        if (str != null && str.length() > 0) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "clientKey: " + str);
            for (com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient : mSDKClientList) {
                if (tMAssistantDownloadClient.mClientKey.equals(str)) {
                    com.tencent.tmassistantbase.util.TMLog.i(TAG, "SDKClient exists");
                    com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue(clientItem): " + tMAssistantDownloadClient);
                    com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
                    return tMAssistantDownloadClient;
                }
            }
            com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient2 = new com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient(this.mContext, str);
            tMAssistantDownloadClient2.initTMAssistantDownloadSDK();
            mSDKClientList.add(tMAssistantDownloadClient2);
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "add new SDKClient");
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue(client): " + tMAssistantDownloadClient2);
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "TMAssistantDownloadClient PackageInstallReceiverDownload register");
            if (this.mContext == null) {
                this.mContext = com.tencent.tmassistantbase.util.k.a().b();
            }
            com.tencent.tmdownloader.PackageInstallReceiverDownload.a().a(this.mContext);
            return tMAssistantDownloadClient2;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "clientKey == null || clientKey.length() <= 0");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        return null;
    }

    public synchronized com.tencent.tmdownloader.TMAssistantDownloadSettingClient getDownloadSDKSettingClient() {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        if (mSDKSettingClient == null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "mSDKSettingClient is null create a new for TMAssistantDownloadSettingClient");
            com.tencent.tmdownloader.TMAssistantDownloadSettingClient tMAssistantDownloadSettingClient = new com.tencent.tmdownloader.TMAssistantDownloadSettingClient(this.mContext, "TMAssistantDownloadSDKManager");
            mSDKSettingClient = tMAssistantDownloadSettingClient;
            tMAssistantDownloadSettingClient.initTMAssistantDownloadSDK();
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue(settingclient): " + mSDKSettingClient);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        return mSDKSettingClient;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean releaseDownloadSDKClient(java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "clientKey:" + str);
        java.util.Iterator it = mSDKClientList.iterator();
        while (it.hasNext()) {
            com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient = (com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient) it.next();
            if (tMAssistantDownloadClient != null && tMAssistantDownloadClient.mClientKey.equals(str)) {
                tMAssistantDownloadClient.unInitTMAssistantDownloadSDK();
                it.remove();
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "unInitTMAssistantDownloadSDK for TMAssistantDownloadClient");
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: true");
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
                return true;
            }
        }
        com.tencent.tmdownloader.TMAssistantDownloadSettingClient tMAssistantDownloadSettingClient = mSDKSettingClient;
        if (tMAssistantDownloadSettingClient != null && tMAssistantDownloadSettingClient.mClientKey.equals(str)) {
            mSDKSettingClient.unInitTMAssistantDownloadSDK();
            mSDKSettingClient = null;
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "unInitTMAssistantDownloadSDK for TMAssistantDownloadSettingClient");
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: true");
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
            return true;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "no matched SDKClient for clientKey: " + str);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: false");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        return false;
    }
}
