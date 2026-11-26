package com.tencent.ysdk.shell.module.share.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ShareModuleStat {
    public static final java.lang.String EVENT_SHARE_H5_URL_NATIVE_CHANNEL_CLICK = "YSDK_H5_SHARE_URL_NATIVE_CHANNEL_CLICK";
    public static final java.lang.String EVENT_SHARE_H5_URL_NATIVE_SHARE_STATUS = "YSDK_H5_SHARE_URL_NATIVE_SHARE_STATUS";
    public static final java.lang.String PARA_SHARE_CHANNEL = "shareChannel";
    public static final java.lang.String PARA_SHARE_ERR_CODE = "errCode";
    public static final java.lang.String PARA_SHARE_ERR_MSG = "errMsg";
    public static final java.lang.String PARA_SHARE_RESULT = "shareResult";
    public static final java.lang.String PARA_SHARE_URL = "shareURL";

    private static void h5Report(java.lang.String str, int i, java.lang.String str2, com.tencent.ysdk.module.share.impl.ShareRet.ShareType shareType, java.lang.String str3, java.lang.String str4) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("shareChannel", shareType.name());
        map.put(PARA_SHARE_URL, str2);
        map.put("errCode", str3);
        map.put("errMsg", str4);
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(str, i, "", loginRecord.platform, loginRecord.open_id, map, java.lang.System.currentTimeMillis(), true);
    }

    protected static boolean isURLShareType(com.tencent.ysdk.module.share.impl.ShareRet shareRet) {
        if (shareRet == null) {
            return false;
        }
        return shareRet.shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.WXTimeLineURL || shareRet.shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.WXFriendURL || shareRet.shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.QQFriendURL || shareRet.shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.QZoneURL;
    }

    protected static void reportH5URLshareEnd(int i, java.lang.String str, com.tencent.ysdk.module.share.impl.ShareRet.ShareType shareType, java.lang.String str2, java.lang.String str3) {
        h5Report(EVENT_SHARE_H5_URL_NATIVE_SHARE_STATUS, i, str, shareType, str2, str3);
    }

    protected static void reportH5URLshareStart(int i, java.lang.String str, com.tencent.ysdk.module.share.impl.ShareRet.ShareType shareType, java.lang.String str2, java.lang.String str3) {
        h5Report(EVENT_SHARE_H5_URL_NATIVE_CHANNEL_CLICK, i, str, shareType, str2, str3);
    }
}
