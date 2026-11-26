package com.tencent.ysdk.innerapi;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DynamicInnerApi {
    public static com.tencent.ysdk.module.cloud.ICloudSettingApi getCloudSettingApiInstance() {
        return (com.tencent.ysdk.module.cloud.ICloudSettingApi) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getCloudSettingApiInstance", new java.lang.Object[0]);
    }

    public static com.tencent.ysdk.module.stat.IDelayReportApi getDelayReportApiInstance() {
        return (com.tencent.ysdk.module.stat.IDelayReportApi) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getDelayReportApiInstance", new java.lang.Object[0]);
    }

    public static com.tencent.ysdk.module.immersiveicon.IImmersiveIconApi getImmersiveIconApiInstance() {
        return (com.tencent.ysdk.module.immersiveicon.IImmersiveIconApi) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getImmersiveIconApiInstance", new java.lang.Object[0]);
    }

    public static com.tencent.ysdk.module.launchgift.ILaunchGiftApi getLaunchGiftApiInstance() {
        return (com.tencent.ysdk.module.launchgift.ILaunchGiftApi) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getLaunchGiftApiInstance", new java.lang.Object[0]);
    }

    public static com.tencent.ysdk.module.msgbox.IMsgBoxApi getMsgBoxApiInstance() {
        return (com.tencent.ysdk.module.msgbox.IMsgBoxApi) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getMsgBoxApiInstance", new java.lang.Object[0]);
    }

    public static com.tencent.ysdk.module.share.IShareApi getShareApiInstance() {
        return (com.tencent.ysdk.module.share.IShareApi) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getShareApiInstance", new java.lang.Object[0]);
    }

    public static void handleIntent(android.content.Intent intent) {
        com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("handleIntent", intent);
    }

    public static boolean isDebugVersion() {
        return ((java.lang.Boolean) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("isDebugVersion", new java.lang.Object[0])).booleanValue();
    }

    public static boolean isExternalStorageAvailable(android.content.Context context) {
        return ((java.lang.Boolean) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("isExternalStorageAvailable", context)).booleanValue();
    }

    public static java.util.Map pipeEventDispatchEvent(int i, java.util.Map map) {
        return (java.util.Map) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("pipeEventDispatchEvent", java.lang.Integer.valueOf(i), map);
    }

    public static void reportApiEventWithDeviceInfo(java.lang.String str, int i, java.lang.String str2, java.util.Map map) {
        com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("reportApiEventWithDeviceInfo", str, java.lang.Integer.valueOf(i), str2, map);
    }

    public static void reportStatError(java.util.Map map, java.lang.Throwable th) {
        com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("reportStatError", map, th);
    }
}
