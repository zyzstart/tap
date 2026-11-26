package com.tencent.ysdk.framework;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YSDKInitProvider extends android.content.ContentProvider {
    public static final java.lang.String DYNAMIC_TAG = "YSDK_PLUGIN";
    private static final long MIN_CRASH_INTERVAL = 10000;
    private static final java.lang.String STAT_PARAM_EVENT_NAME = "eventName";
    private static final java.lang.String STAT_PARAM_EVENT_PARAMS = "eventParams";
    private static final java.lang.String STAT_PARAM_FLAG = "flag";
    private static final java.lang.String STAT_PARAM_RET_DETAIL = "retDetail";
    public static final java.lang.String TAG = "YSDK_INIT";
    private static final java.lang.String YSDK_DEFAULT_SO = "YSDK";
    private static android.app.Application mApplication = null;
    private static boolean mHasInitYSDK = false;
    private static boolean mHasLoadPlugin = false;
    private static long mInitStartTime;
    private static java.util.ArrayList mStatList;

    public static void addStatList(java.lang.String str, int i, java.lang.String str2, java.util.Map map) {
        if (mStatList == null) {
            mStatList = new java.util.ArrayList();
        }
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put(STAT_PARAM_EVENT_NAME, str);
        map2.put(STAT_PARAM_FLAG, java.lang.Integer.valueOf(i));
        map2.put(STAT_PARAM_RET_DETAIL, str2);
        map2.put(STAT_PARAM_EVENT_PARAMS, map);
        mStatList.add(map2);
    }

    public static void clearLoadedPlugin(android.content.Context context) {
        context.getSharedPreferences(com.tencent.ysdk.framework.dynamic.constant.PluginConst.SP_PRELOAD_PLUGIN, 0).edit().clear().commit();
    }

    public static void dealWithLaunchCrash() {
        if (java.lang.System.currentTimeMillis() - mInitStartTime <= MIN_CRASH_INTERVAL) {
            clearLoadedPlugin(mApplication);
        }
    }

    public static android.content.Context getApplicationContext() {
        return mApplication;
    }

    public static boolean isLoadPlugin() {
        return mHasLoadPlugin;
    }

    private void registerCrashHandler() {
        java.lang.Thread.setDefaultUncaughtExceptionHandler(new java.lang.Thread.UncaughtExceptionHandler() { // from class: com.tencent.ysdk.framework.YSDKInitProvider.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(@androidx.annotation.NonNull java.lang.Thread thread, @androidx.annotation.NonNull java.lang.Throwable th) {
                com.tencent.ysdk.framework.YSDKInitProvider.dealWithLaunchCrash();
            }
        });
    }

    private void reportLoadSuccess(long j) {
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_LOAD_RESULT, java.lang.String.valueOf(0));
        map.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_LOAD_TIME, java.lang.String.valueOf(j));
        map.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_IS_PRELOAD, java.lang.String.valueOf(false));
        map.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_ERROR_CODE, java.lang.String.valueOf(0));
        map.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_PLUGIN_VER, java.lang.String.valueOf(com.tencent.ysdk.framework.dynamic.manager.PluginManager.getInstance().getLoadedPluginVersion()));
        addStatList(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PLUGIN_LOAD, 0, "loadSuccess", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportPluginLoadEventDelay(final java.lang.String str, final int i, final java.lang.String str2, final java.util.Map map) {
        com.tencent.ysdk.innerapi.DynamicInnerApi.getDelayReportApiInstance().addDelayReport(new com.tencent.ysdk.module.stat.DelayReport(new java.lang.Runnable() { // from class: com.tencent.ysdk.framework.YSDKInitProvider.3
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ysdk.innerapi.DynamicInnerApi.reportApiEventWithDeviceInfo(str, i, str2, map);
            }
        }));
    }

    public static void reportStatList() {
        new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.ysdk.framework.YSDKInitProvider.2
            @Override // java.lang.Runnable
            public void run() {
                if (com.tencent.ysdk.framework.YSDKInitProvider.mStatList == null) {
                    return;
                }
                for (java.util.HashMap map : com.tencent.ysdk.framework.YSDKInitProvider.mStatList) {
                    com.tencent.ysdk.framework.YSDKInitProvider.reportPluginLoadEventDelay((java.lang.String) map.get(com.tencent.ysdk.framework.YSDKInitProvider.STAT_PARAM_EVENT_NAME), ((java.lang.Integer) map.get(com.tencent.ysdk.framework.YSDKInitProvider.STAT_PARAM_FLAG)).intValue(), (java.lang.String) map.get(com.tencent.ysdk.framework.YSDKInitProvider.STAT_PARAM_RET_DETAIL), (java.util.HashMap) map.get(com.tencent.ysdk.framework.YSDKInitProvider.STAT_PARAM_EVENT_PARAMS));
                }
            }
        }).start();
    }

    @Override // android.content.ContentProvider
    public int delete(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public java.lang.String getType(@androidx.annotation.NonNull android.net.Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public android.net.Uri insert(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.content.ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            com.tencent.ysdk.libware.file.Logger.d(TAG, "YSDK init provider");
            mInitStartTime = java.lang.System.currentTimeMillis();
            mApplication = (android.app.Application) getContext();
            registerCrashHandler();
            if (!mHasInitYSDK) {
                mHasLoadPlugin = com.tencent.ysdk.framework.dynamic.manager.PluginManager.getInstance().load(getContext());
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - mInitStartTime;
                com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "load result: " + mHasLoadPlugin);
                com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "load time: " + jCurrentTimeMillis);
                com.tencent.ysdk.framework.dynamic.manager.LoadedPluginInfo loadedPluginInfo = com.tencent.ysdk.framework.dynamic.manager.PluginManager.getInstance().getLoadedPluginInfo();
                com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.loadSo("YSDK");
                com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("init", mApplication, loadedPluginInfo);
                com.tencent.ysdk.libware.file.Logger.d(TAG, "onCreate: YSDK_INIT: " + java.lang.String.valueOf(java.lang.System.currentTimeMillis() - mInitStartTime));
                mHasInitYSDK = true;
                if (mHasLoadPlugin) {
                    reportLoadSuccess(jCurrentTimeMillis);
                }
            }
        } catch (java.lang.Exception unused) {
            clearLoadedPlugin(mApplication);
        }
        return false;
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) {
        return super.query(uri, strArr, bundle, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr2, @androidx.annotation.Nullable java.lang.String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr2, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) {
        return super.query(uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    public int update(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.content.ContentValues contentValues, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr) {
        return 0;
    }
}
