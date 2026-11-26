package com.tencent.ysdk.shell.module.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ADManagerStat {
    public static final java.lang.String EVENT_AD_CACHE = "YSDK_AD_CACHE_AD";
    public static final java.lang.String EVENT_AD_CLICK = "YSDK_AD_CLICK_AD";
    public static final java.lang.String EVENT_AD_JUMP = "YSDK_AD_JUMP_OVER_AD";
    public static final java.lang.String EVENT_AD_SHOW = "YSDK_AD_SHOW_AD";
    public static final java.lang.String PARAM_AD_ACTION_URL = "ACTION_URL";
    public static final java.lang.String PARAM_AD_IMAGE_URL = "IMAGE_URL";

    public static void reportADEvent(java.lang.String str, int i, java.lang.String str2, int i2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.String> map) {
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(str, i, str2, i2, str3, map != null ? map : new java.util.HashMap(), java.lang.System.currentTimeMillis(), true);
    }

    public static void reportIconBasicEvent(java.lang.String str, int i, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        reportADEvent(str, i, str2, loginRecord.platform, loginRecord.open_id, map);
    }
}
