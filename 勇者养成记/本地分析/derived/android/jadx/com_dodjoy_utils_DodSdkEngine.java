package com.dodjoy.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodSdkEngine {
    private static android.os.Handler dodApiHandler;
    private static com.dodjoy.utils.DodSdkEngine dodSdkEngine;
    private static android.os.HandlerThread ht;
    private static java.util.Random random = new java.util.Random();
    private static byte[] sync = new byte[0];
    private static volatile long total;
    private static volatile long total2;
    private volatile int count = 0;

    private DodSdkEngine() {
        com.dodjoy.utils.DodLog.i(com.dodjoy.utils.DodLog.TAG, "This is DodSdkEngine");
    }

    public static android.os.Handler getDodApiHandler() {
        return dodApiHandler;
    }

    public static com.dodjoy.utils.DodSdkEngine getInstance() {
        if (dodSdkEngine == null) {
            synchronized (sync) {
                com.dodjoy.utils.DodLog.i(com.dodjoy.utils.DodLog.TAG, "dodSdkEngine is null");
                dodSdkEngine = new com.dodjoy.utils.DodSdkEngine();
            }
        }
        com.dodjoy.utils.DodLog.i(com.dodjoy.utils.DodLog.TAG, "dodSdkEngine is ok");
        return dodSdkEngine;
    }

    public static void post(java.lang.Runnable runnable) {
        synchronized (sync) {
            java.lang.String str = com.dodjoy.utils.DodLog.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("DodSdkEngine post was invoked totally:");
            long j = total;
            total = 1 + j;
            sb.append(j);
            com.dodjoy.utils.DodLog.d(str, sb.toString());
            if (dodApiHandler == null) {
                throw new java.lang.RuntimeException("dodApiHandler should not be null!");
            }
            dodApiHandler.post(runnable);
        }
    }

    public static void postDelayed(java.lang.Runnable runnable, long j) {
        synchronized (sync) {
            java.lang.String str = com.dodjoy.utils.DodLog.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("DodSdkEngine postDelayed was invoked totally:");
            long j2 = total2;
            total2 = 1 + j2;
            sb.append(j2);
            com.dodjoy.utils.DodLog.d(str, sb.toString());
            if (dodApiHandler == null) {
                throw new java.lang.RuntimeException("dodApiHandler should not be null!");
            }
            int iNextInt = random.nextInt(10) + 1;
            int iNextInt2 = random.nextInt(10) + 1;
            com.dodjoy.utils.DodLog.d(com.dodjoy.utils.DodLog.TAG, "radomNumb:" + iNextInt);
            com.dodjoy.utils.DodLog.d(com.dodjoy.utils.DodLog.TAG, "radomNumb:" + iNextInt2);
            dodApiHandler.postDelayed(runnable, ((long) (iNextInt * iNextInt2)) * j);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void destory() {
        try {
            try {
                if (dodApiHandler != null) {
                    dodApiHandler.getLooper().quit();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        } finally {
            dodApiHandler = null;
            ht = null;
        }
    }

    public synchronized android.os.Handler start() {
        this.count++;
        try {
            if (ht == null) {
                ht = new android.os.HandlerThread("api_call_thread", 10);
                ht.start();
            }
            if (dodApiHandler == null) {
                dodApiHandler = new android.os.Handler(ht.getLooper());
            }
            dodApiHandler.post(new java.lang.Runnable() { // from class: com.dodjoy.utils.DodSdkEngine.1
                @Override // java.lang.Runnable
                public void run() {
                    com.dodjoy.utils.DodLog.i(com.dodjoy.utils.DodLog.TAG, "count:->" + com.dodjoy.utils.DodSdkEngine.this.count);
                    com.dodjoy.utils.DodSdkEngine.this.count = 0;
                }
            });
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            destory();
            start();
            if (this.count > 10) {
                com.dodjoy.utils.DodLog.i(com.dodjoy.utils.DodLog.TAG, "DodSdkEngine is over!");
                this.count = 0;
                java.lang.System.exit(0);
            }
        }
        return dodApiHandler;
    }
}
