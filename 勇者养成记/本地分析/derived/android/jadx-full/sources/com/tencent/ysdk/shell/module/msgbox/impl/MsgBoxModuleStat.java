package com.tencent.ysdk.shell.module.msgbox.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MsgBoxModuleStat {
    public static final java.lang.String EVENT_H5_SHOW = "YSDK_MsgBox_SHOW_H5";
    public static final java.lang.String EVENT_POP_CLICK = "YSDK_MsgBox_POP_CLICK";
    public static final java.lang.String EVENT_POP_SHOW = "YSDK_MsgBox_POP";
    public static final java.lang.String EVENT_TIPS_CLICK = "YSDK_MsgBox_TIP_CLICK";
    public static final java.lang.String EVENT_TIPS_SHOW = "YSDK_MsgBox_SHOW_TIPS";
    public static final java.lang.String EVENT_TOAST_SHOW = "YSDK_MsgBox_SHOW_TOAST";
    public static final java.lang.String PARA_FLOAT_ITEM_NAME = "iconName";
    public static final java.lang.String PARA_FLOAT_ITEM_URL = "loadH5";
    public static final java.lang.String PARA_POP_BUSINESS_ID = "businessId";
    public static final java.lang.String PARA_POP_PUSH_ID = "pushId";

    public static void reportMsgBoxBasicEvent(java.lang.String str, int i, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        reportMsgBoxEvent(str, i, str2, loginRecord.platform, loginRecord.open_id, map);
    }

    public static void reportMsgBoxEvent(java.lang.String str, int i, java.lang.String str2, int i2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.String> map) {
        (map != null ? map : new java.util.HashMap<>()).put("msg_version", com.tencent.ysdk.shell.module.msgbox.MsgBoxApiImpl.getInstance().getMsgBoxVersion());
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(str, i, str2, i2, str3, map, java.lang.System.currentTimeMillis(), true);
    }

    public static void reportMsgBoxShowEvent(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.util.HashMap map = new java.util.HashMap();
        map.put(PARA_POP_PUSH_ID, str3);
        map.put("loadH5", str4);
        reportMsgBoxBasicEvent(str, i, str2, map);
    }
}
