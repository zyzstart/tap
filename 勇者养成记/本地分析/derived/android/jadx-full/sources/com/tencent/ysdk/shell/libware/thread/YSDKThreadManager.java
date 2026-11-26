package com.tencent.ysdk.shell.libware.thread;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YSDKThreadManager {
    private static final java.lang.String EXECUTOR_NAME_YSDK_TEMP = "YSDK_TEMP_THREADS";
    public static final int LOOPER_TYPE_ANDROID_MAIN = 0;
    public static final int LOOPER_TYPE_YSDK_BG = 1;
    public static final int LOOPER_TYPE_YSDK_REQUEST = 2;
    public static final int LOOPER_TYPE_YSDK_TEMP = 3;
    private static final int MAX_RUNNING_THREAD = 3;
    private static final java.lang.String THREAD_NAME_YSDK_BG = "YSDK_BG";
    private static final java.lang.String THREAD_NAME_YSDK_REQUEST = "YSDK_REQUEST";
    private static final java.lang.String THREAD_NAME_YSDK_TEMP = "YSDK_TEMP";
    private static volatile com.tencent.ysdk.shell.libware.thread.YSDKThreadManager instance;
    private java.util.concurrent.ExecutorService executor;
    private android.os.Handler mPostDelayTempHandler;
    private android.os.Handler mPostDelayUIHandler;
    private android.os.HandlerThread mYSDKBgHandlerThread = null;
    private android.os.HandlerThread mYSDKRequestHandlerThread = null;
    private android.os.HandlerThread mYSDKTempHandlerThread = null;

    private static class CommonThreadFactory implements java.util.concurrent.ThreadFactory {
        private final java.lang.ThreadGroup group;
        private final java.lang.String namePrefix;
        private final java.util.concurrent.atomic.AtomicInteger poolNumber = new java.util.concurrent.atomic.AtomicInteger(1);
        private final java.util.concurrent.atomic.AtomicInteger threadNumber = new java.util.concurrent.atomic.AtomicInteger(1);

        public CommonThreadFactory() {
            java.lang.SecurityManager securityManager = java.lang.System.getSecurityManager();
            this.group = securityManager != null ? securityManager.getThreadGroup() : java.lang.Thread.currentThread().getThreadGroup();
            this.namePrefix = "YSDK_TEMP_THREADS- pool-" + this.poolNumber.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 1) {
                thread.setPriority(1);
            }
            return thread;
        }
    }

    private YSDKThreadManager() {
    }

    public static com.tencent.ysdk.shell.libware.thread.YSDKThreadManager getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.libware.thread.YSDKThreadManager();
                }
            }
        }
        return instance;
    }

    public android.os.Looper getLooper(int i) {
        if (i == 0) {
            return android.os.Looper.getMainLooper();
        }
        if (i == 1) {
            if (this.mYSDKBgHandlerThread == null) {
                this.mYSDKBgHandlerThread = new android.os.HandlerThread(THREAD_NAME_YSDK_BG);
                this.mYSDKBgHandlerThread.start();
            }
            return this.mYSDKBgHandlerThread.getLooper();
        }
        if (i == 2) {
            if (this.mYSDKRequestHandlerThread == null) {
                this.mYSDKRequestHandlerThread = new android.os.HandlerThread("YSDK_REQUEST");
                this.mYSDKRequestHandlerThread.start();
            }
            return this.mYSDKRequestHandlerThread.getLooper();
        }
        if (this.mYSDKTempHandlerThread == null) {
            this.mYSDKTempHandlerThread = new android.os.HandlerThread(THREAD_NAME_YSDK_TEMP);
            this.mYSDKTempHandlerThread.start();
        }
        return this.mYSDKTempHandlerThread.getLooper();
    }

    public void postDelayOnUIThread(java.lang.Runnable runnable, int i) {
        if (this.mPostDelayUIHandler == null) {
            this.mPostDelayUIHandler = new android.os.Handler(getLooper(0));
        }
        this.mPostDelayUIHandler.postDelayed(runnable, i);
    }

    public void runOnUIThread(java.lang.Runnable runnable) {
        try {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(runnable);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void start(java.lang.Runnable runnable) {
        if (this.executor == null) {
            try {
                this.executor = java.util.concurrent.Executors.newFixedThreadPool(3, new com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.CommonThreadFactory());
            } catch (java.lang.Throwable unused) {
                this.executor = java.util.concurrent.Executors.newCachedThreadPool(new com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.CommonThreadFactory());
            }
        }
        try {
            this.executor.submit(runnable);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void start(java.lang.Runnable runnable, int i) {
        if (this.mPostDelayTempHandler == null) {
            this.mPostDelayTempHandler = new android.os.Handler(getLooper(3));
        }
        this.mPostDelayTempHandler.postDelayed(runnable, i * 1000);
    }
}
