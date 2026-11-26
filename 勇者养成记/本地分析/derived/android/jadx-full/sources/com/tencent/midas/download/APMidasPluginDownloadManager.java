package com.tencent.midas.download;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APMidasPluginDownloadManager {
    private static final int MAX_CURRENCY_DOWNLOAD_THREAD = 1;
    private static final java.lang.String TAG = "APMidasPluginDownloadManager";
    private java.util.concurrent.ExecutorService executorService = getExecutorService();

    private APMidasPluginDownloadManager() {
    }

    private synchronized void enqueue(com.tencent.midas.download.APMidasPluginDownloadWorker aPMidasPluginDownloadWorker) {
        try {
            if (aPMidasPluginDownloadWorker == null) {
                com.tencent.midas.comm.APLog.e(TAG, "Cannot enqueue null worker!");
            } else {
                this.executorService.execute(aPMidasPluginDownloadWorker);
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    private java.util.concurrent.ExecutorService getExecutorService() {
        if (this.executorService == null) {
            this.executorService = java.util.concurrent.Executors.newFixedThreadPool(1, threadFactory("Plugin Download Thread", false));
        }
        return this.executorService;
    }

    static void startDownload(android.content.Context context, java.util.ArrayList arrayList, com.tencent.midas.download.IAPMidasPluginDownListener iAPMidasPluginDownListener) {
        new com.tencent.midas.download.APMidasPluginDownloadManager().enqueue(new com.tencent.midas.download.APMidasPluginDownloadWorker(context, arrayList, context.getApplicationContext().getDir("midaspluginsTemp", 0), iAPMidasPluginDownListener));
    }

    private static java.util.concurrent.ThreadFactory threadFactory(final java.lang.String str, final boolean z) {
        return new java.util.concurrent.ThreadFactory() { // from class: com.tencent.midas.download.APMidasPluginDownloadManager.1
            private java.util.concurrent.atomic.AtomicInteger netThreadCount = new java.util.concurrent.atomic.AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public java.lang.Thread newThread(java.lang.Runnable runnable) {
                java.lang.Thread thread = new java.lang.Thread(runnable, str + " " + this.netThreadCount.getAndIncrement());
                thread.setPriority(10);
                thread.setDaemon(z);
                return thread;
            }
        };
    }
}
