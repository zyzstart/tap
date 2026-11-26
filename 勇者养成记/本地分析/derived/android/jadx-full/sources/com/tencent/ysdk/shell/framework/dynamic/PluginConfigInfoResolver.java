package com.tencent.ysdk.shell.framework.dynamic;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PluginConfigInfoResolver implements com.tencent.ysdk.shell.module.cloud.newconfig.IConfigSettingsResolver {
    private static final int DISABLED = 1;
    private static final java.lang.String PLUGIN_DISABLE = "plugin_disable";
    private static final java.lang.String PLUGIN_DOWNLOAD_URL = "plugin_download_url";
    private static final java.lang.String PLUGIN_MAX_HOST_VERSION = "plugin_max_host_version";
    private static final java.lang.String PLUGIN_MD5 = "plugin_md5";
    private static final java.lang.String PLUGIN_MIN_HOST_VERSION = "plugin_min_host_version";
    private static final java.lang.String PLUGIN_RANDOM_TIME = "plugin_random_time";
    private static final java.lang.String PLUGIN_VERSION = "plugin_version";
    private static final java.lang.String TAG = "YSDK_PLUGIN";
    private com.tencent.ysdk.shell.framework.dynamic.PluginDownloadInfo mDownloadInfo;

    private boolean checkConfigInfo(org.json.JSONObject jSONObject) {
        return jSONObject.has(PLUGIN_DOWNLOAD_URL) && jSONObject.has(PLUGIN_MD5) && jSONObject.has(PLUGIN_RANDOM_TIME);
    }

    private boolean checkPluginVersion(org.json.JSONObject jSONObject) {
        if (this.mDownloadInfo == null) {
            return true;
        }
        if (jSONObject.has("plugin_version")) {
            return this.mDownloadInfo.getPluginVersion() <= jSONObject.optInt("plugin_version");
        }
        return false;
    }

    private void disablePlugin(org.json.JSONObject jSONObject) {
        if (jSONObject.has("plugin_version")) {
            int iOptInt = jSONObject.optInt("plugin_version");
            reportDisablePluginEvent(iOptInt);
            android.content.Context applicationContext = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext();
            android.content.SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(com.tencent.ysdk.framework.dynamic.constant.PluginConst.SP_PRELOAD_PLUGIN, 0);
            com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo fromSp = new com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo().readFromSp(sharedPreferences);
            if (fromSp != null && fromSp.getVersionCode() == iOptInt) {
                sharedPreferences.edit().clear().commit();
            }
            android.content.SharedPreferences sharedPreferences2 = applicationContext.getSharedPreferences(com.tencent.ysdk.framework.dynamic.constant.PluginConst.SP_DOWNLOAD_PLUGIN, 0);
            com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo fromSp2 = new com.tencent.ysdk.framework.dynamic.manager.PluginFileInfo().readFromSp(sharedPreferences2);
            if (fromSp2 == null || fromSp2.getVersionCode() != iOptInt) {
                return;
            }
            sharedPreferences2.edit().clear().commit();
        }
    }

    private boolean isDisabled(org.json.JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject.has(PLUGIN_DISABLE) && jSONObject.optInt(PLUGIN_DISABLE) == 1) {
            z = true;
        }
        if (z) {
            disablePlugin(jSONObject);
        }
        return z;
    }

    public static boolean isFitHostVersion(int i, int i2) {
        return 1 <= i && 1 >= i2;
    }

    private boolean isFitHostVersion(org.json.JSONObject jSONObject) {
        if (!jSONObject.has(PLUGIN_MAX_HOST_VERSION)) {
            return false;
        }
        int iOptInt = jSONObject.optInt(PLUGIN_MAX_HOST_VERSION);
        if (jSONObject.has(PLUGIN_MIN_HOST_VERSION)) {
            return isFitHostVersion(iOptInt, jSONObject.optInt(PLUGIN_MIN_HOST_VERSION));
        }
        return false;
    }

    private void reportDisablePluginEvent(int i) {
        java.lang.String strValueOf = java.lang.String.valueOf(i);
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_PLUGIN", "reportHotfixEvent disable ver = " + strValueOf + " , ext = ext");
        java.util.HashMap map = new java.util.HashMap();
        map.put("plugin_version", strValueOf);
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PLUGIN_EXT, "ext");
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_PLUGIN_DISABLE, 0, "report disable plugin", map);
    }

    private void resolveConfig(org.json.JSONObject jSONObject) {
        if (isFitHostVersion(jSONObject) && !isDisabled(jSONObject) && checkPluginVersion(jSONObject) && checkConfigInfo(jSONObject)) {
            this.mDownloadInfo = new com.tencent.ysdk.shell.framework.dynamic.PluginDownloadInfo.DownloadInfoBuilder().setMaxHostVersion(jSONObject.optInt(PLUGIN_MAX_HOST_VERSION)).setMinHostVersion(jSONObject.optInt(PLUGIN_MIN_HOST_VERSION)).setPluginVersion(jSONObject.optInt("plugin_version")).setDownloadUrl(jSONObject.optString(PLUGIN_DOWNLOAD_URL)).setPluginMd5(jSONObject.optString(PLUGIN_MD5)).setRandomTime(jSONObject.optInt(PLUGIN_RANDOM_TIME)).build();
            java.util.HashMap map = new java.util.HashMap();
            map.put(com.tencent.open.SocialConstants.PARAM_TYPE, "resolve");
            com.tencent.ysdk.shell.framework.dynamic.PluginStatHelper.reportConfigResolve(map);
        }
    }

    @Override // com.tencent.ysdk.shell.module.cloud.newconfig.IConfigSettingsResolver
    public void resolve(@androidx.annotation.NonNull org.json.JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_PLUGIN", "PluginConfigInfoResolver: " + jSONObject.toString());
                resolveConfig(jSONObject);
                java.util.HashMap map = new java.util.HashMap();
                map.put(com.tencent.open.SocialConstants.PARAM_TYPE, "origin");
                map.put("config", jSONObject.toString());
                com.tencent.ysdk.shell.framework.dynamic.PluginStatHelper.reportConfigResolve(map);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.mDownloadInfo != null) {
            java.util.HashMap map2 = new java.util.HashMap();
            map2.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_PLUGIN_VER, java.lang.String.valueOf(this.mDownloadInfo.getPluginVersion()));
            com.tencent.ysdk.shell.framework.dynamic.PluginStatHelper.reportDownloadEvent(true, com.tencent.ysdk.shell.framework.dynamic.PluginDownloadManager.RESOLVE_SUCCESS, map2);
            com.tencent.ysdk.shell.framework.dynamic.PluginDownloadManager.getInstance().startDownload(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), this.mDownloadInfo);
        }
    }
}
