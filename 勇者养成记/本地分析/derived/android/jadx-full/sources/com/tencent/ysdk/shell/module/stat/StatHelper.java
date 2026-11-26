package com.tencent.ysdk.shell.module.stat;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class StatHelper {
    public static final java.lang.String EVENT_AD = "YSDK_AD";
    public static final java.lang.String EVENT_CLOUD = "YSDK_CLOUD";
    public static final java.lang.String EVENT_FILE_MONITOR_INFO = "YSDK_FILE_MONITOR_INFO ";
    public static final java.lang.String EVENT_FIRST_LOGIN = "YSDK_User_Login_FirstLogin";
    public static final java.lang.String EVENT_FIRST_SCAN_LOGIN = "YSDK_User_Login_FirstScanLogin";
    public static final java.lang.String EVENT_H5_SHARE_URL = "YSDK_H5_SHARE_URL";
    public static final java.lang.String EVENT_ICON = "YSDK_Icon";
    public static final java.lang.String EVENT_IMMERSIVE_ICON = "YSDK_ImmersiveIcon";
    public static final java.lang.String EVENT_LAUNCHER_LOGIN = "YSDK_User_Login_LauncherLogin";
    public static final java.lang.String EVENT_LOCAL_LOGIN = "YSDK_User_Login_LocalLogin";
    public static final java.lang.String EVENT_MSG_BOX = "YSDK_MsgBox";
    public static final java.lang.String EVENT_MSG_PUSH_RESPONSE = "YSDK_MSG_PUSH_RESPONSE";
    public static final java.lang.String EVENT_PAY_BUYGOODS = "YSDK_Pay_BuyGoods";
    public static final java.lang.String EVENT_PAY_DISABLE = "YSDK_Pay_Disable";
    public static final java.lang.String EVENT_PAY_Notify = "YSDK_Pay_Notify";
    public static final java.lang.String EVENT_PAY_RECHARGE = "YSDK_Pay_ReCharge";
    public static final java.lang.String EVENT_PUSH = "YSDK_PUSH";
    public static final java.lang.String EVENT_SANDBOX_LAUNCH = "YSDK_SANDBOX_LAUNCH";
    public static final java.lang.String EVENT_SANDBOX_LOCAL_INSTALL = "YSDK_Sandbox_local_install";
    public static final java.lang.String EVENT_SDK_FIX = "YSDK_System_Fix";
    public static final java.lang.String EVENT_SDK_INIT = "YSDK_System_Init";
    public static final java.lang.String EVENT_TIMER_LOGIN = "YSDK_User_Login_TimerLogin";
    public static final java.lang.String EVENT_USER_GAME_DURATION = "YSDK_Game_GameTime";
    public static final java.lang.String EVENT_USER_INFO = "YSDK_User_UserInfo";
    public static final int GameEventOnCreate = 1;
    public static final int GameEventOnDestroy = 4;
    public static final int GameEventOnRestart = 2;
    public static final int GameEventOnStop = 3;
    public static final int GameEventTimer = 5;
    private static final java.lang.String LOG_PARAM_GAMETIME = "gameTime";
    private static final java.lang.String LOG_PARAM_LOCALTIME = "localTime";
    private static long sGameStartTime;

    @java.lang.Deprecated
    private static void randomReportApiEvent(java.lang.String str, int i, java.lang.String str2, int i2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.String> map, long j, boolean z, int i3) {
        int i4;
        boolean z2 = i == 0;
        java.lang.String config = com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.framework.config.Config.KEY_STAT_REPORT_FREQUENCE, "");
        if (z2) {
            if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(config)) {
                i4 = 0;
            } else {
                try {
                    i4 = java.lang.Integer.parseInt(config);
                } catch (java.lang.NumberFormatException e) {
                    e.printStackTrace();
                    i4 = 0;
                }
            }
            if (i4 > 0) {
                i3 = i4;
            }
            int randNumByLimit = com.tencent.ysdk.shell.libware.util.Math.getRandNumByLimit(0, i3);
            if (randNumByLimit < i3) {
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.stat.impl.StatModule.TAG, str + " st skiped ,randomNum is:" + randNumByLimit);
                return;
            }
        }
        reportApiEventWithDeviceInfo(str, i, str2, i2, str3, map, j, z);
    }

    public static void reportApiEventWithDeviceInfo(java.lang.String str, int i, java.lang.String str2, int i2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.String> map, long j, boolean z) {
        reportBeaconData(str, i, str2, i2, str3, null, map, j, z);
    }

    public static void reportApiEventWithDeviceInfo(java.lang.String str, int i, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        reportApiEventWithDeviceInfo(str, i, str2, map, java.lang.System.currentTimeMillis(), true);
    }

    public static void reportApiEventWithDeviceInfo(java.lang.String str, int i, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, long j, boolean z) {
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        reportBeaconData(str, i, str2, loginRecord.platform, loginRecord.open_id, null, map, j, z);
    }

    private static void reportBeaconData(java.lang.String str, int i, java.lang.String str2, int i2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2, long j, boolean z) {
        boolean z2 = i == 0;
        long jCurrentTimeMillis = j > 0 ? java.lang.System.currentTimeMillis() - j : -1L;
        java.util.Map<java.lang.String, java.lang.String> map3 = map != null ? map : new java.util.HashMap();
        if (com.tencent.ysdk.shell.module.sandbox.SandboxConfig.isSandboxEnv()) {
            map3.put("qimei", com.tencent.ysdk.shell.module.stat.StatApi.getQImei());
            map3.put("qimei36", com.tencent.ysdk.shell.libware.device.DeviceUtils.getQImei36());
            map3.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ENV, "sandbox");
        }
        if (map2 != null) {
            map3.putAll(map2);
        }
        try {
            com.tencent.ysdk.shell.module.stat.StatCommonParam.addBizId(map3);
            com.tencent.ysdk.shell.module.stat.StatCommonParam.addNormalParam(i, str2, i2, str3, map3);
            com.tencent.ysdk.shell.module.stat.StatCommonParam.addUserLogParams(map3, str3, i2);
            com.tencent.ysdk.shell.module.stat.StatCommonParam.addDeviceLogParams(map3);
            com.tencent.ysdk.shell.module.stat.StatCommonParam.addAppLogParams(map3);
            com.tencent.ysdk.shell.module.stat.StatCommonParam.addSequenceLogParams(map3);
            com.tencent.ysdk.shell.module.stat.StatCommonParam.addEventLogParams(map3, str, j, i, str2, i2, map2);
            com.tencent.ysdk.shell.module.stat.StatCommonParam.addLocationLogParams(map3);
            com.tencent.ysdk.shell.module.stat.StatCommonParam.addPluginParams(map3);
        } catch (java.lang.Throwable th) {
            map3.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_REPORT_FAILED_NAME, str);
            reportStatError(map3, th);
        }
        if (com.tencent.ysdk.shell.module.stat.StatApi.getInstance().reportEvent(str, z2, jCurrentTimeMillis, -1L, map3, map2, z)) {
            return;
        }
        java.util.HashMap map4 = new java.util.HashMap();
        map4.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_REPORT_FAILED_NAME, str);
        com.tencent.beacon.event.UserAction.onUserAction(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_REPORT_FAIL, false, -1L, -1L, map4, true);
        com.tencent.beacon.event.UserAction.onUserActionToTunnel(com.tencent.ysdk.shell.module.stat.impl.StatModule.TUNNEL_APPKEY, com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_REPORT_FAIL.replace("[REDACTED]", "[REDACTED]"), false, -1L, -1L, map4, true, false);
    }

    public static void reportEventData(java.lang.String str, int i, java.lang.String str2, int i2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.String> map, long j, boolean z, com.tencent.ysdk.shell.module.stat.StatConstants.EventType eventType, java.lang.String str4) {
        java.util.HashMap map2 = new java.util.HashMap();
        if (eventType != null) {
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_EVENT_PARAM_EVENT_TYPE, eventType.val());
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_EVENT_PARAM_EVENT_TARGET, str4);
        }
        reportBeaconData(str, i, str2, i2, str3, map2, map, j, z);
    }

    public static void reportEventData(java.lang.String str, int i, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, long j, boolean z, com.tencent.ysdk.shell.module.stat.StatConstants.EventType eventType, java.lang.String str3) {
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        java.util.HashMap map2 = new java.util.HashMap();
        if (eventType != null) {
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_EVENT_PARAM_EVENT_TYPE, eventType.val());
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_EVENT_PARAM_EVENT_TARGET, str3);
        }
        reportBeaconData(str, i, str2, loginRecord.platform, loginRecord.open_id, map2, map, j, z);
    }

    @java.lang.Deprecated
    public static void reportGameDurationEvent(int i) {
        long j;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (i == 1 || i == 2) {
            sGameStartTime = jCurrentTimeMillis;
            j = 0;
        } else {
            j = (jCurrentTimeMillis - sGameStartTime) / 1000;
        }
        if (j < 1) {
            return;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_Game_Duration", "Game duration, duration " + java.lang.String.valueOf(j));
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_GAMETIME_TYPE, java.lang.String.valueOf(i));
        map.put(LOG_PARAM_GAMETIME, java.lang.String.valueOf(j));
        map.put(LOG_PARAM_LOCALTIME, java.lang.String.valueOf(jCurrentTimeMillis));
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        randomReportApiEvent(EVENT_USER_GAME_DURATION, 0, "", loginRecord.platform, loginRecord.open_id, map, java.lang.System.currentTimeMillis(), false, 10);
    }

    public static void reportPageData(java.lang.String str, int i, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, long j, boolean z, com.tencent.ysdk.shell.module.stat.StatConstants.PageType pageType, java.lang.String str3, java.lang.String str4, com.tencent.ysdk.shell.module.stat.StatConstants.EventType eventType, java.lang.String str5) {
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PAGE_PARAM_PAGE_ID, str3);
        map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PAGE_PARAM_PAGE_TYPE, pageType.val());
        map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PAGE_PARAM_PV_ID, str4);
        if (eventType != null) {
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_EVENT_PARAM_EVENT_TYPE, eventType.val());
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_EVENT_PARAM_EVENT_TARGET, str5);
        }
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        reportBeaconData(str, i, str2, loginRecord.platform, loginRecord.open_id, map2, map, j, z);
    }

    public static void reportStatError(java.util.Map<java.lang.String, java.lang.String> map, java.lang.Throwable th) {
        java.util.Map<java.lang.String, java.lang.String> map2 = map == null ? new java.util.HashMap() : map;
        map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_REPORT_FAILED_MESSAGE, android.util.Log.getStackTraceString(th));
        com.tencent.ysdk.shell.module.stat.StatCommonParam.addExceptionParam(map2);
        com.tencent.ysdk.shell.module.stat.StatApi.getInstance().reportEvent(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_REPORT_ERROR, false, -1L, -1L, map2, null, true);
    }
}
