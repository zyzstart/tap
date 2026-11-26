package com.tencent.tmassistantsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.tmassistantsdk.b f1063a;
    protected static java.util.ArrayList c = new java.util.ArrayList();
    protected static java.util.ArrayList d = new java.util.ArrayList();
    protected android.content.Context b;

    protected b(android.content.Context context) {
        this.b = null;
        this.b = context;
    }

    public static synchronized com.tencent.tmassistantsdk.b a(android.content.Context context) {
        if (f1063a == null) {
            f1063a = new com.tencent.tmassistantsdk.b(context);
        }
        return f1063a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void b(android.content.Context context) {
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantDownloadSDKManager", "closeAllService method!");
        if (f1063a == null) {
            com.tencent.tmassistantbase.util.TMLog.i("TMAssistantDownloadSDKManager", "manager minstance == null");
            return;
        }
        java.util.ArrayList arrayList = c;
        if (arrayList != null && arrayList.size() > 0) {
            for (com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient : c) {
                if (tMAssistantDownloadClient != null) {
                    tMAssistantDownloadClient.unInitTMAssistantDownloadSDK();
                }
            }
            c.clear();
        }
        f1063a = null;
    }

    public synchronized com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient a(java.lang.String str) {
        if (str != null) {
            if (str.length() > 0) {
                for (com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient : c) {
                    if (tMAssistantDownloadClient.mClientKey.equals(str)) {
                        return tMAssistantDownloadClient;
                    }
                }
                com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient2 = new com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient(this.b, str);
                tMAssistantDownloadClient2.initTMAssistantDownloadSDK();
                c.add(tMAssistantDownloadClient2);
                return tMAssistantDownloadClient2;
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized com.tencent.tmassistantsdk.internal.b.a b(java.lang.String str) {
        for (com.tencent.tmassistantsdk.internal.b.a aVar : d) {
            if (aVar.mClientKey.equals(str)) {
                return aVar;
            }
        }
        com.tencent.tmassistantsdk.internal.b.a aVar2 = new com.tencent.tmassistantsdk.internal.b.a(this.b, str, com.tencent.assistant.sdk.remote.SDKConst.SERVICE_NAME);
        if (!aVar2.initTMAssistantDownloadSDK()) {
            return null;
        }
        d.add(aVar2);
        return aVar2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean c(java.lang.String str) {
        java.util.Iterator it = c.iterator();
        while (it.hasNext()) {
            com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient = (com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient) it.next();
            if (tMAssistantDownloadClient != null && tMAssistantDownloadClient.mClientKey.equals(str)) {
                tMAssistantDownloadClient.unInitTMAssistantDownloadSDK();
                it.remove();
                return true;
            }
        }
        return false;
    }
}
