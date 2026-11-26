package com.tencent.tmassistantbase.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class v extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantbase.util.u f1062a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    v(com.tencent.tmassistantbase.util.u uVar, java.lang.String str) {
        super(str);
        this.f1062a = uVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (com.tencent.tmassistantbase.util.TMLog.isWriteLogToFile() && com.tencent.tmassistantbase.util.TMLog.isInitLogFileDone.compareAndSet(false, true)) {
            try {
                com.tencent.tmassistantbase.util.TMLog.readLocalConfig();
                try {
                    com.tencent.tmassistantbase.util.TMLog.packageName = com.tencent.tmassistantbase.util.TMLog.context.getPackageName();
                } catch (java.lang.Exception unused) {
                    com.tencent.tmassistantbase.util.TMLog.packageName = "unknow";
                }
                com.tencent.tmassistantbase.util.TMLog.f1050a = new java.util.concurrent.LinkedBlockingQueue(15000);
                com.tencent.tmassistantbase.util.TMLog.myProcessId = android.os.Process.myPid();
                android.util.Log.d("TMLog", "TMLog init start ");
                com.tencent.tmassistantbase.util.TMLog.initLogFile();
                com.tencent.tmassistantbase.util.TMLog.d.setName("logWriteThread");
                com.tencent.tmassistantbase.util.TMLog.d.start();
                com.tencent.tmassistantbase.util.TMLog.retryInitHandler.removeCallbacks(com.tencent.tmassistantbase.util.TMLog.acutualInitRunnable);
            } catch (java.lang.Exception e) {
                com.tencent.tmassistantbase.util.TMLog.isInitLogFileDone.set(false);
                e.printStackTrace();
                int i = com.tencent.tmassistantbase.util.TMLog.retryInitTimes.get();
                android.util.Log.d("TMLog", "TMLog init post retry " + i + " times, interval " + com.tencent.tmassistantbase.util.TMLog.INTERVAL_RETRY_INIT[i]);
                com.tencent.tmassistantbase.util.TMLog.retryInitHandler.removeCallbacks(com.tencent.tmassistantbase.util.TMLog.acutualInitRunnable);
                com.tencent.tmassistantbase.util.TMLog.retryInitHandler.postDelayed(com.tencent.tmassistantbase.util.TMLog.acutualInitRunnable, (long) (com.tencent.tmassistantbase.util.TMLog.INTERVAL_RETRY_INIT[i] * com.youme.im.CommonConst.SPEECH_DURATION_MAX));
                int i2 = i + 1;
                if (i2 >= com.tencent.tmassistantbase.util.TMLog.INTERVAL_RETRY_INIT.length) {
                    i2 = 0;
                }
                com.tencent.tmassistantbase.util.TMLog.retryInitTimes.set(i2);
            }
        }
    }
}
