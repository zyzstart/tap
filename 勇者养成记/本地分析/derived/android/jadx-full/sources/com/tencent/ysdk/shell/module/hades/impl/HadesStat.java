package com.tencent.ysdk.shell.module.hades.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class HadesStat {
    public static void reportHadesEvent(java.lang.String str, int i, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.Map<java.lang.String, java.lang.String> map2 = map != null ? map : new java.util.HashMap<>();
        map2.put(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_ANDROID, android.os.Build.VERSION.SDK_INT + "");
        map2.put(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_MODEL, android.os.Build.MODEL);
        map2.put(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_BRAND, android.os.Build.BRAND);
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(str, i, str2, com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginPlatform().val(), com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().open_id, map, java.lang.System.currentTimeMillis(), true);
    }
}
