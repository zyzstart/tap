package com.tencent.ysdk.shell.framework.dynamic;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PluginStatHelper {
    private static final java.lang.String EVENT_PLUGIN_CONFIG_REQUEST = "YSDK_PLUGIN_CONFIG_REQUEST";
    private static final java.lang.String EVENT_PLUGIN_CONFIG_RESOLVE = "YSDK_PLUGIN_CONFIG_RESOLVE";
    private static final java.lang.String EVENT_PLUGIN_CONFIG_RESPONSE = "TSDK_PLUGIN_CONFIG_RESPONSE";
    private static final java.lang.String EVENT_PLUGIN_DOWNLOAD = "YSDK_PLUGIN_DOWNLOAD";

    public static void reportConfigRequestEvent() {
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(EVENT_PLUGIN_CONFIG_REQUEST, 0, "config request", null, java.lang.System.currentTimeMillis(), true);
    }

    public static void reportConfigResolve(java.util.Map<java.lang.String, java.lang.String> map) {
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(EVENT_PLUGIN_CONFIG_RESOLVE, 0, "config resolve", map, java.lang.System.currentTimeMillis(), true);
    }

    public static void reportConfigResponse(java.util.Map<java.lang.String, java.lang.String> map) {
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(EVENT_PLUGIN_CONFIG_RESPONSE, 0, "config response", map, java.lang.System.currentTimeMillis(), true);
    }

    public static void reportDownloadEvent(boolean z, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(EVENT_PLUGIN_DOWNLOAD, z ? 0 : -1, str, map, jCurrentTimeMillis, true);
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(EVENT_PLUGIN_DOWNLOAD, z ? 0 : -1, str, map, jCurrentTimeMillis, true);
    }
}
