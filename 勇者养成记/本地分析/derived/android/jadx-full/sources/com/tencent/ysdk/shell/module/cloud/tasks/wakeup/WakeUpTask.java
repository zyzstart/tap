package com.tencent.ysdk.shell.module.cloud.tasks.wakeup;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WakeUpTask implements java.lang.Runnable {
    private static final java.lang.String TAG = "YSDK WakeUpTask";
    private int retryCount;
    private int retryTimes;
    private android.content.Context context = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext();
    private com.tencent.ysdk.shell.libware.thread.YSDKThreadManager threadManager = com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance();

    public WakeUpTask(int i) {
        this.retryTimes = i;
    }

    android.content.Intent getMyAppIntent(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra(com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.KEY_FROM, context.getPackageName());
        intent.putExtra("via", com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.KEY_YSDK);
        intent.setComponent(new android.content.ComponentName("com.tencent.android.qqdownloader", com.tencent.ysdk.shell.framework.constant.Constant.MY_APP_CLS));
        return intent;
    }

    boolean realWakeUp(android.content.Context context) {
        int i;
        android.content.ServiceConnection serviceConnection = new android.content.ServiceConnection() { // from class: com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpTask.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(android.content.ComponentName componentName) {
            }
        };
        if (context.bindService(getMyAppIntent(context), serviceConnection, 1)) {
            context.unbindService(serviceConnection);
            java.util.HashMap map = new java.util.HashMap();
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_WAKE_UP_TYPE, java.lang.Integer.toString(0));
            reportWakeUpEvent(0, map);
            return true;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString(com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.KEY_FROM, context.getPackageName());
        bundle.putString("via", com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.KEY_YSDK);
        boolean zStartInstrumentation = context.startInstrumentation(new android.content.ComponentName("com.tencent.android.qqdownloader", com.tencent.ysdk.shell.framework.constant.Constant.MY_APP_INSTRUMENTATION), null, bundle);
        if (!zStartInstrumentation && (i = this.retryCount) < this.retryTimes) {
            this.retryCount = i + 1;
            this.threadManager.start(this);
            return false;
        }
        int i2 = zStartInstrumentation ? 0 : -1;
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_WAKE_UP_TYPE, java.lang.Integer.toString(1));
        reportWakeUpEvent(i2, map2);
        return zStartInstrumentation;
    }

    void reportWakeUpEvent(int i) {
        reportWakeUpEvent(i, null);
    }

    void reportWakeUpEvent(int i, java.util.Map<java.lang.String, java.lang.String> map) {
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_WAKE_UP, i, "ysdk wake up yyb", loginRecord.platform, loginRecord.open_id, map, java.lang.System.currentTimeMillis(), true);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.context == null) {
                return;
            }
            this.context.startService(getMyAppIntent(this.context));
            realWakeUp(this.context);
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
        }
    }
}
