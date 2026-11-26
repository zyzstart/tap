package com.tencent.ysdk.shell.module.cloud.tasks.wakeup;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WakeUpManager {
    public static final int DEFAULT_WAKE_RETRY_TIMES = 3;
    public static final int DEFAULT_WAKE_TIMES = 3;
    public static final java.lang.String KEY_FROM = "from";
    public static final java.lang.String KEY_LAST_WAKE_COUNT = "KEY_LAST_WAKE_COUNT";
    public static final java.lang.String KEY_LAST_WAKE_TIME_STAMP = "KEY_LAST_WAKE_TIME_STAMP";
    public static final java.lang.String KEY_VIA = "via";
    public static final java.lang.String KEY_YSDK = "ysdk";
    private static final java.lang.String TAG = "YSDK WakeUp";
    public static final java.lang.String YSDK_WAKE_RETRY_TIMES = "YSDK_WAKE_RETRY_TIMES";
    public static final java.lang.String YSDK_WAKE_SWITCH = "YSDK_WAKE_SWITCH";
    public static final int YSDK_WAKE_SWITCH_CLOSE = 0;
    public static final int YSDK_WAKE_SWITCH_OPEN = 1;
    public static final java.lang.String YSDK_WAKE_TIMES = "YSDK_WAKE_TIMES";
    public static final java.lang.String YSDK_WAKE_YYB_MIN_VER = "YSDK_WAKE_YYB_MIN_VER";
    private static volatile com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager instance;
    private com.tencent.ysdk.shell.libware.thread.YSDKThreadManager threadManager = com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance();

    private WakeUpManager() {
    }

    public static com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager();
                }
            }
        }
        return instance;
    }

    void updateWakeUpInfo(int i) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "update wakeUp info " + i);
        com.tencent.ysdk.shell.libware.util.AppSharePreferenceMgr.put(KEY_LAST_WAKE_TIME_STAMP, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        com.tencent.ysdk.shell.libware.util.AppSharePreferenceMgr.put(KEY_LAST_WAKE_COUNT, java.lang.Integer.valueOf(i));
    }

    public boolean wakeUp(com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpTaskParameter wakeUpTaskParameter) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "wakeUp");
        if (!wakeUpTaskParameter.needWakeUp()) {
            return false;
        }
        updateWakeUpInfo(wakeUpTaskParameter.getLastWakeCount() + 1);
        wakeUpInner(wakeUpTaskParameter);
        return true;
    }

    void wakeUpInner(com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpTaskParameter wakeUpTaskParameter) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "wakeUpInner");
        this.threadManager.start(new com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpTask(wakeUpTaskParameter.getWakeRetryTimes()));
    }
}
