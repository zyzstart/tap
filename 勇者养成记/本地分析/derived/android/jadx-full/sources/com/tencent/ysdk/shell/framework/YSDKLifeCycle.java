package com.tencent.ysdk.shell.framework;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YSDKLifeCycle implements android.app.Application.ActivityLifecycleCallbacks {
    private static final java.lang.String APP_LAUNCH = "app launch";
    private static final java.lang.String LAUNCH_TYPE_COLD = "cold";
    private static final java.lang.String LAUNCH_TYPE_WARM = "warm";
    private static final java.lang.String MAIN_ACTIVITY_TAG = "MAIN_ACTIVITY";
    private static final java.lang.String TAG = "YSDK_INIT";
    private static final long TIME_INTERVAL = 60000;
    private static int mActivityCount = 0;
    private static long mBackgroundTime = 0;
    private static long mForegroundTime = 0;
    private static boolean mHasInit = false;
    private static boolean mHasRegister = false;
    private static boolean mIsForeground = false;
    private static boolean mIsOpen = false;
    private static java.lang.String mLastSessionId = "";
    private static java.lang.String mSessionId = "";

    public static java.lang.String getLastSessionId() {
        return mLastSessionId;
    }

    public static java.lang.String getSessionId() {
        return mSessionId;
    }

    public static java.lang.String getSessionStartTime() {
        return java.lang.String.valueOf(mForegroundTime);
    }

    public static boolean isForeground() {
        return mIsForeground;
    }

    public static void register(android.app.Application application) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_INIT", "YSDK register");
        if (mHasRegister) {
            return;
        }
        application.registerActivityLifecycleCallbacks(new com.tencent.ysdk.shell.framework.YSDKLifeCycle());
        mHasRegister = true;
        try {
            java.lang.String string = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData.getString(MAIN_ACTIVITY_TAG);
            com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().setupApplicationContext(application);
            com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().setMainActivity(string);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    void doBackground() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isInit()) {
            mBackgroundTime = java.lang.System.currentTimeMillis();
            com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().setGameBackground();
            com.tencent.ysdk.shell.framework.timertask.TaskManager.getInstance().removeTask(com.tencent.ysdk.shell.module.user.impl.UserDurationTask.TASK_NAME);
            com.tencent.ysdk.shell.libware.file.Logger.debug("YSDK_INIT", "应用进入后台");
        }
    }

    void doForeground() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isInit()) {
            com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().resetGameStartFromBackground();
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (jCurrentTimeMillis - mBackgroundTime >= TIME_INTERVAL) {
                com.tencent.ysdk.shell.module.stat.StatConstants.EventType eventType = com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Media;
                java.util.HashMap map = new java.util.HashMap();
                if (mIsOpen) {
                    map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LAUNCH_TYPE, LAUNCH_TYPE_WARM);
                    com.tencent.ysdk.shell.module.stat.StatCommonParam.resetSequenceId();
                    com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_SDK_LAUNCH, 0, APP_LAUNCH, map, jCurrentTimeMillis, true, eventType, "");
                    mLastSessionId = mSessionId;
                    mSessionId = java.util.UUID.randomUUID().toString().replace("-", "");
                    mForegroundTime = jCurrentTimeMillis;
                } else {
                    mIsOpen = true;
                }
            }
            com.tencent.ysdk.shell.framework.timertask.TaskManager.getInstance().addTask(new com.tencent.ysdk.shell.module.user.impl.UserDurationTask());
            com.tencent.ysdk.shell.libware.file.Logger.debug("YSDK_INIT", "应用回到前台");
        }
    }

    java.lang.String getActivityName(android.app.Activity activity) {
        if (activity != null) {
            return activity.getClass().getName();
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable android.os.Bundle bundle) {
        if (mHasInit) {
            return;
        }
        mHasInit = true;
        com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().onCreate(activity);
        com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().handleIntent(activity.getIntent());
        com.tencent.ysdk.shell.module.stat.delayreport.DelayReportManager.getInstance().addDelayReport(new com.tencent.ysdk.module.stat.DelayReport(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.YSDKLifeCycle.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ysdk.shell.module.stat.StatConstants.EventType eventType = com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Media;
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                java.util.HashMap map = new java.util.HashMap();
                map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LAUNCH_TYPE, com.tencent.ysdk.shell.framework.YSDKLifeCycle.LAUNCH_TYPE_COLD);
                boolean unused = com.tencent.ysdk.shell.framework.YSDKLifeCycle.mIsOpen = true;
                com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_SDK_LAUNCH, 0, com.tencent.ysdk.shell.framework.YSDKLifeCycle.APP_LAUNCH, map, jCurrentTimeMillis, true, eventType, "");
                com.tencent.ysdk.framework.YSDKInitProvider.reportStatList();
            }
        }));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@androidx.annotation.NonNull android.app.Activity activity) {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().checkActivityIsMain(activity)) {
            com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().onDestroy(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@androidx.annotation.NonNull android.app.Activity activity) {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().checkActivityIsMain(activity)) {
            com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().onPause(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@androidx.annotation.NonNull android.app.Activity activity) {
        if (android.text.TextUtils.isEmpty(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getMainActivityClzName())) {
            com.tencent.ysdk.shell.module.BaseModuleSelfCheck.printConfigErrorInfo("1、请检查AndroidManifest.xml文件中是否配置了MAIN_ACTIVITY属性");
            com.tencent.ysdk.shell.module.BaseModuleSelfCheck.printConfigErrorInfo("2、如果AndroidManifest.xml配置无效，可手动在Application的onCreate()中调用YSDKApi.setMainActivity()接口设置游戏的MainActivity");
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_INIT", "请检查AndroidManifest.xml文件中是否配置了MAIN_ACTIVITY属性");
        } else if (!com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().checkIsMainActivityValid()) {
            com.tencent.ysdk.shell.module.BaseModuleSelfCheck.printConfigErrorInfo("请检查设置的MAIN_ACTIVITY:" + com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getMainActivityClzName() + " 是否是项目中的activity");
        }
        com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().onResume(activity);
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isInit() && com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().checkActivityIsMain(activity)) {
            com.tencent.ysdk.shell.libware.file.Logger.d("FloatingWindowManager", "onActivityResumed " + activity.toString());
            com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().checkFreeLoginActivity();
            com.tencent.ysdk.shell.framework.floatingwindow.FloatingWindowManager.getInstance().onResume(activity);
        }
        com.tencent.ysdk.shell.module.stat.delayreport.DelayReportManager.getInstance().report();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@androidx.annotation.NonNull android.app.Activity activity) {
        mActivityCount++;
        com.tencent.ysdk.shell.module.launchgift.LaunchGiftInnerApi.handleIntent(activity.getIntent());
        if (mActivityCount > 0) {
            if (!mIsForeground) {
                doForeground();
            }
            mIsForeground = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@androidx.annotation.NonNull android.app.Activity activity) {
        mActivityCount--;
        if (mActivityCount == 0) {
            mIsForeground = false;
            doBackground();
        }
    }
}
