package com.tencent.ysdk.framework.dynamic.manager;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PluginLoader {
    private static final java.lang.String TAG = "YSDK_PLUGIN";

    private static void deletePluginInfo(android.content.Context context, @androidx.annotation.NonNull com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo pluginFileInfo) {
        context.getSharedPreferences(com.tencent.ysdk.framework.dynamic.constant.PluginConst.SP_PRELOAD_PLUGIN, 0).edit().clear().commit();
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(com.tencent.ysdk.framework.dynamic.constant.PluginConst.SP_DOWNLOAD_PLUGIN, 0);
        com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo fromSp = new com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo().readFromSp(sharedPreferences);
        if (fromSp == null || fromSp.getVersionCode() != pluginFileInfo.getVersionCode()) {
            return;
        }
        sharedPreferences.edit().clear().commit();
    }

    public static com.tencent.ysdk.framework.dynamic.manager.LoadedPluginInfo load(android.content.Context context, com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo pluginFileInfo, boolean z) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "LoadedPluginInfo load enter...");
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (pluginFileInfo == null) {
            reportLoadFailedEvent(java.lang.System.currentTimeMillis() - jCurrentTimeMillis, z, 1001);
            return null;
        }
        if (!android.text.TextUtils.isEmpty(pluginFileInfo.getFilePath())) {
            java.io.File file = new java.io.File(pluginFileInfo.getFilePath());
            if (file.exists()) {
                return loadPlugin(context, pluginFileInfo, z, file, jCurrentTimeMillis);
            }
            reportLoadFailedEvent(java.lang.System.currentTimeMillis() - jCurrentTimeMillis, z, 1002);
            com.tencent.ysdk.libware.file.Logger.e("YSDK_PLUGIN", "LoadedPluginInfo load return null. Plugin file not exist!");
            return null;
        }
        com.tencent.ysdk.libware.file.Logger.e("YSDK_PLUGIN", "LoadedPluginInfo load return null. packageName=com.tencent.ysdkcore. filePath=" + pluginFileInfo.getFilePath());
        reportLoadFailedEvent(java.lang.System.currentTimeMillis() - jCurrentTimeMillis, z, 1001);
        return null;
    }

    static com.tencent.ysdk.framework.dynamic.manager.LoadedPluginInfo loadPlugin(android.content.Context context, com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo pluginFileInfo, boolean z, java.io.File file, long j) throws java.lang.Throwable {
        java.lang.String fileMD5 = com.tencent.ysdk.framework.dynamic.utils.MD5.getFileMD5(file);
        if (android.text.TextUtils.isEmpty(fileMD5) || !fileMD5.equalsIgnoreCase(pluginFileInfo.getFileMd5())) {
            com.tencent.ysdk.libware.file.Logger.e("YSDK_PLUGIN", "LoadedPluginInfo callable return null. local file MD5 not match! localMd5=" + fileMD5 + ". serverMd5=" + pluginFileInfo.getFileMd5());
            deletePluginInfo(context, pluginFileInfo);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("delete plugin file. filepath:");
            sb.append(pluginFileInfo.getFilePath());
            com.tencent.ysdk.libware.file.Logger.e("YSDK_PLUGIN", sb.toString());
            reportLoadFailedEvent(java.lang.System.currentTimeMillis() - j, z, 1003);
            return null;
        }
        android.content.Context applicationContext = context.getApplicationContext();
        try {
            dalvik.system.DexClassLoader dexClassLoader = new dalvik.system.DexClassLoader(pluginFileInfo.getFilePath(), pluginFileInfo.getDexPath(), pluginFileInfo.getLibPath(), context.getClassLoader());
            try {
                com.tencent.ysdk.framework.dynamic.context.PluginContext pluginContext = new com.tencent.ysdk.framework.dynamic.context.PluginContext(applicationContext, pluginFileInfo, dexClassLoader);
                com.tencent.ysdk.libware.file.Logger.d("YSDK_PLUGIN", "Load plugin end. cost time: " + (java.lang.System.currentTimeMillis() - j) + "ms");
                return new com.tencent.ysdk.framework.dynamic.manager.LoadedPluginInfo(applicationContext, pluginContext, dexClassLoader, pluginFileInfo);
            } catch (java.lang.Throwable unused) {
                com.tencent.ysdk.libware.file.Logger.e("YSDK_PLUGIN", "LoadedPluginInfo callable return null. Create pluginContext exception!");
                reportLoadFailedEvent(java.lang.System.currentTimeMillis() - j, z, 1004);
                return null;
            }
        } catch (java.lang.Throwable unused2) {
            com.tencent.ysdk.libware.file.Logger.e("YSDK_PLUGIN", "LoadedPluginInfo callable return null. Create classloader exception!");
            reportLoadFailedEvent(java.lang.System.currentTimeMillis() - j, z, 1004);
            return null;
        }
    }

    private static void reportLoadFailedEvent(long j, boolean z, int i) {
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_LOAD_RESULT, java.lang.String.valueOf(-1));
        map.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_LOAD_TIME, java.lang.String.valueOf(j));
        map.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_IS_PRELOAD, java.lang.String.valueOf(z));
        map.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_ERROR_CODE, java.lang.String.valueOf(i));
        map.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_PLUGIN_VER, java.lang.String.valueOf(com.tencent.ysdk.framework.dynamic.manager.PluginManager.getInstance().getLoadedPluginVersion()));
        if (z) {
            com.tencent.ysdk.innerapi.DynamicInnerApi.reportApiEventWithDeviceInfo(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PLUGIN_LOAD, -1, "loadFailed", map);
        } else {
            com.tencent.ysdk.framework.YSDKInitProvider.addStatList(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PLUGIN_LOAD, -1, "loadFailed", map);
        }
    }
}
