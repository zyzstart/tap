package com.tencent.ysdk.shell.framework.floatingwindow;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FloatingWindowManager {
    private static final java.lang.String TAG = "FloatingWindowManager";
    private static volatile com.tencent.ysdk.shell.framework.floatingwindow.FloatingWindowManager instance;
    private java.util.Queue<com.tencent.ysdk.shell.framework.floatingwindow.IShowFloatingWindowCommand> mCommandQueue = new java.util.ArrayDeque();

    private FloatingWindowManager() {
    }

    private void executeCommand(android.app.Activity activity, final com.tencent.ysdk.shell.framework.floatingwindow.IShowFloatingWindowCommand iShowFloatingWindowCommand) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "executeCommand " + activity.toString());
        activity.getWindow().getDecorView().post(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.floatingwindow.FloatingWindowManager.1
            @Override // java.lang.Runnable
            public void run() {
                iShowFloatingWindowCommand.execute();
            }
        });
    }

    public static com.tencent.ysdk.shell.framework.floatingwindow.FloatingWindowManager getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.framework.floatingwindow.FloatingWindowManager.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.framework.floatingwindow.FloatingWindowManager();
                }
            }
        }
        return instance;
    }

    private void reportAddFloatingWindow(int i) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("app_name", com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppName(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()));
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_TYPE, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getAppPkgName());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_VERSION, com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppVersionName(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()));
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_CHANNEL, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_LOG_VERSION, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.FLOATING_WINDOW_TYPE, java.lang.String.valueOf(i));
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_ADD_FLOATING_WINDOW, 0, "add floating window", loginRecord.platform, loginRecord.open_id, map, java.lang.System.currentTimeMillis(), true);
    }

    private void reportShowFloatingWindow(int i, int i2) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("app_name", com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppName(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()));
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_TYPE, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getAppPkgName());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_VERSION, com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppVersionName(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()));
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MEDIA_CHANNEL, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_LOG_VERSION, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.FLOATING_WINDOW_TYPE, java.lang.String.valueOf(i));
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.FLOATING_WINDOW_DISPLAY_TYPE, java.lang.String.valueOf(i2));
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_SHOW_FLOATING_WINDOW, 0, "show floating window", loginRecord.platform, loginRecord.open_id, map, java.lang.System.currentTimeMillis(), true);
    }

    public void addCommand(com.tencent.ysdk.shell.framework.floatingwindow.IShowFloatingWindowCommand iShowFloatingWindowCommand) {
        boolean zCheckCurActivityIsMain = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().checkCurActivityIsMain();
        android.app.Activity activity = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity();
        reportAddFloatingWindow(iShowFloatingWindowCommand.getFloatingWindowType());
        if (!zCheckCurActivityIsMain || activity == null || activity.isFinishing()) {
            this.mCommandQueue.add(iShowFloatingWindowCommand);
        } else {
            reportShowFloatingWindow(iShowFloatingWindowCommand.getFloatingWindowType(), 0);
            executeCommand(activity, iShowFloatingWindowCommand);
        }
    }

    public void onResume(android.app.Activity activity) {
        if (activity == null || activity.isFinishing()) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "onResume act is null or finishing");
            return;
        }
        if (com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().ret != 0) {
            this.mCommandQueue.clear();
        }
        while (!this.mCommandQueue.isEmpty()) {
            com.tencent.ysdk.shell.framework.floatingwindow.IShowFloatingWindowCommand iShowFloatingWindowCommandPoll = this.mCommandQueue.poll();
            if (iShowFloatingWindowCommandPoll != null) {
                executeCommand(activity, iShowFloatingWindowCommandPoll);
                reportShowFloatingWindow(iShowFloatingWindowCommandPoll.getFloatingWindowType(), 1);
            }
        }
    }
}
