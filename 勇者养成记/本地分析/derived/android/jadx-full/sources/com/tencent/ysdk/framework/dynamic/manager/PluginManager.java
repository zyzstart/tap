package com.tencent.ysdk.framework.dynamic.manager;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PluginManager {
    public static final boolean IS_DEBUG = false;
    public static final int LOCAL_PLUGIN_VERSION = 1;
    public static final int PLUGIN_HOST_VERSION = 1;
    private static final java.lang.String TAG = "YSDK_PLUGIN_PluginManager";
    private static final int UN_LOADED_VERSION = -1;
    private static java.lang.String mPluginBaseDir;
    private static com.tencent.ysdk.framework.dynamic.manager.PluginManager sInstance;
    private com.tencent.ysdk.framework.dynamic.manager.LoadedPluginInfo mLoadedPluginInfo = null;

    private PluginManager() {
    }

    private boolean checkHostVersion(com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo pluginFileInfo) {
        return 1 <= pluginFileInfo.getMaxHostVersion() && 1 >= pluginFileInfo.getMinHostVersion();
    }

    public static com.tencent.ysdk.framework.dynamic.manager.PluginManager getInstance() {
        if (sInstance == null) {
            synchronized (com.tencent.ysdk.framework.dynamic.manager.PluginManager.class) {
                if (sInstance == null) {
                    sInstance = new com.tencent.ysdk.framework.dynamic.manager.PluginManager();
                }
            }
        }
        return sInstance;
    }

    public static java.lang.String getPluginBaseDir(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(mPluginBaseDir)) {
            return mPluginBaseDir;
        }
        java.io.File dir = context.getDir(com.tencent.ysdk.framework.dynamic.constant.PluginConst.PLUGIN_BASE_DIR, 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        java.lang.String str = dir.getAbsolutePath() + java.io.File.separator + "com.tencent.ysdkcore";
        mPluginBaseDir = str;
        return str;
    }

    private com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo getPreLoadPluginInfo(android.content.Context context) {
        if (context == null) {
            return null;
        }
        return new com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo().readFromSp(context.getSharedPreferences(com.tencent.ysdk.framework.dynamic.constant.PluginConst.SP_PRELOAD_PLUGIN, 0));
    }

    public static java.lang.String makePluginDir(int i, java.lang.String str) {
        java.lang.String str2 = getPluginBaseDir(com.tencent.ysdk.framework.YSDKInitProvider.getApplicationContext()) + java.io.File.separator + i + java.io.File.separator + str;
        java.io.File file = new java.io.File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2;
    }

    private void preload(android.content.Context context, com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo pluginFileInfo) {
        com.tencent.ysdk.framework.dynamic.manager.PluginDownloadApi.getPluginDownloadApi().pluginOdex(context, pluginFileInfo);
    }

    public com.tencent.ysdk.framework.dynamic.manager.LoadedPluginInfo getLoadedPluginInfo() {
        return this.mLoadedPluginInfo;
    }

    public int getLoadedPluginVersion() {
        com.tencent.ysdk.framework.dynamic.manager.LoadedPluginInfo loadedPluginInfo = this.mLoadedPluginInfo;
        if (loadedPluginInfo != null) {
            return loadedPluginInfo.getPluginFileInfo().getVersionCode();
        }
        return -1;
    }

    public boolean load(android.content.Context context) {
        com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo preLoadPluginInfo = getPreLoadPluginInfo(context);
        if (preLoadPluginInfo != null) {
            return loadPlugin(context, preLoadPluginInfo, false);
        }
        return false;
    }

    public boolean loadPlugin(android.content.Context context, com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo pluginFileInfo, boolean z) {
        com.tencent.ysdk.libware.file.Logger.d(TAG, "loadPluginAsync enter...");
        boolean z2 = false;
        if (context == null || pluginFileInfo == null) {
            com.tencent.ysdk.libware.file.Logger.e(TAG, "loadPlugin return. context=" + context + ". pluginInfo=" + pluginFileInfo);
            return false;
        }
        if (!checkHostVersion(pluginFileInfo) || pluginFileInfo.getVersionCode() <= 1) {
            return false;
        }
        try {
            com.tencent.ysdk.framework.dynamic.manager.LoadedPluginInfo loadedPluginInfoLoad = com.tencent.ysdk.framework.dynamic.manager.PluginLoader.load(context, pluginFileInfo, z);
            if (loadedPluginInfoLoad != null) {
                if (!z) {
                    this.mLoadedPluginInfo = loadedPluginInfoLoad;
                    com.tencent.ysdk.libware.file.Logger.d(TAG, "loadSuccess plugin=" + loadedPluginInfoLoad.getPluginFileInfo().getVersionCode());
                }
                z2 = true;
            }
            com.tencent.ysdk.libware.file.Logger.d(TAG, "LoadPlugin done. result:" + z2);
            return z2;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
