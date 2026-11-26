package com.tencent.ysdk.shell.framework.config;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Config {
    public static final java.lang.String KEY_FRAMEWORK_REQUEST_TIME_OUT = "YSDK_TIME_OUT";
    public static final java.lang.String KEY_HTTP_REQ_AUTO_LOGIN_SWITCH = "YSDK_AUTO_LOGIN_SWITCH";
    public static final java.lang.String KEY_HTTP_REQ_DOMAIN = "YSDK_URL";
    public static final java.lang.String KEY_ICON_MAX_NUM = "YSDK_ICON_MAX_NUM";
    public static final java.lang.String KEY_ICON_POP_SHOW_ONCE = "YSDK_ICON_POP_SHOW_ONCE";
    public static final java.lang.String KEY_ICON_SWITCH = "YSDK_ICON_SWITCH";
    public static final java.lang.String KEY_ICON_VERSION = "YSDK_ICON_VERSION";
    public static final java.lang.String KEY_ICON_WEBVIEW_DEBUG_ENABLD = "YSDK_ICON_WEBVIEW_DEBUG";
    public static final java.lang.String KEY_LOG_LEVEL = "YSDK_LOG_LEVEL";
    public static final java.lang.String KEY_OFFER_ID = "OFFER_ID";
    public static final java.lang.String KEY_PAY_LIST = "YSDK_PAY_LIST";
    public static final java.lang.String KEY_QQ_APPID = "QQ_APP_ID";
    public static final java.lang.String KEY_REAL_NAME_SWITCH = "YSDK_REAL_NAME_SWITCH";
    public static final java.lang.String KEY_REPORT_CACHE_MAX = "YSDK_REPORT_CACHE_MAX";
    public static final java.lang.String KEY_REPORT_FREQUENCY_SUCCESS = "YSDK_REPORT_FREQUENCY_SUCCESS";
    public static final java.lang.String KEY_STAT_BEACON_SWITCH = "YSDK_BEACON_SWITCH";
    public static final java.lang.String KEY_STAT_BUGLY_SWITCH = "YSDK_BUGLY_SWITCH";
    public static final java.lang.String KEY_STAT_REPORT_FREQUENCE = "YSDK_STAT_REPORT_FREQUENCE";
    public static final java.lang.String KEY_USER_AUTO_LOGIN_INTERVAL = "YSDK_LOGIN_INTERVAL";
    public static final java.lang.String KEY_USER_NEXT_AUTO_LOGIN_INTERVAL = "YSDK_NEXT_LOGIN_INTERVAL";
    public static final java.lang.String KEY_WX_APPID = "WX_APP_ID";
    public static final java.lang.String VALUE_SWITCH_OFF = "false";
    public static final java.lang.String VALUE_SWITCH_ON = "true";
    public static final java.lang.String YSDK_ANTIADDICTION_SWITCH = "YSDK_ANTIADDICTION_SWITCH";
    public static final java.lang.String YSDK_CLOUD_CONFIG_FILE_ALL = "YSDK_CONFIG";
    public static final java.lang.String YSDK_CLOUD_CONFIG_FILE_OPENID = "YSDK_CONFIG_OPEN_";
    public static final java.lang.String YSDK_CLOUD_CONFIG_FILE_PLAT = "YSDK_CONFIG_PLAT_";
    public static final java.lang.String YSDK_CONFIG_FILE = "ysdkconf.ini";
    public static final java.lang.String YSDK_DEBUG = "YSDK_DEBUG";
    public static final java.lang.String YSDK_FREE_LOGIN_NO_PAY_DEFAULT_NSG = "暂不支持云游戏内充值，请下载游戏完整包体后充值";
    public static final java.lang.String YSDK_FREE_LOGIN_NO_PAY_MSG = "YSDK_FREE_LOGIN_NO_PAY_MSG";
    public static final java.lang.String YSDK_FREE_LOGIN_PAY_SWITCH = "YSDK_FREE_LOGIN_SWITCH";
    public static final java.lang.String YSDK_H5GAME_SWITCH = "YSDK_H5GAME_SWITCH";
    public static final java.lang.String YSDK_H5SHARE_SWITCH = "YSDK_H5SHARE_SWITCH";
    public static final java.lang.String YSDK_ICON_BUBBLE = "YSDK_ICON_BUBBLE";
    public static final java.lang.String YSDK_ICON_CAPTURE = "YSDK_ICON_CAPTURE_SWITCH";
    public static final java.lang.String YSDK_ICON_LOCATION = "YSDK_ICON_LOCATION";
    public static final java.lang.String YSDK_IMMERSIVE_ICON_SWITCH = "YSDK_IMMERSIVE_ICON_SWITCH";
    public static final java.lang.String YSDK_IMMERSIVE_ICON_VERSION = "YSDK_IMMERSIVE_ICON_VERSION";
    public static final java.lang.String YSDK_MSG_BOX_SWITCH = "YSDK_MSG_BOX_SWITCH";
    public static final java.lang.String YSDK_SHARE_SWITCH = "YSDK_SHARE_SWITCH";

    public static void init() {
        com.tencent.ysdk.shell.framework.config.ConfigManager.getInstance().init();
    }

    public static boolean isSwitchEnabled(java.lang.String str, boolean z) {
        try {
            return com.tencent.ysdk.shell.framework.config.ConfigManager.getInstance().isSwitchEnabled(str, z);
        } catch (java.lang.Exception unused) {
            com.tencent.ysdk.libware.file.Logger.e("get SwitchKey Error");
            com.tencent.ysdk.libware.file.Logger.e("YSDK_DOCTOR", "检查配置ysdkconf.ini文件中 Key ：" + str + "的配置是否正常");
            return z;
        }
    }

    public static void printAllConfig() {
        com.tencent.ysdk.shell.framework.config.ConfigManager.getInstance().printAllConfig();
    }

    public static int readConfig(java.lang.String str, int i) {
        return com.tencent.ysdk.shell.framework.config.ConfigManager.getInstance().readConfig(str, i);
    }

    public static java.lang.String readConfig(java.lang.String str, java.lang.String str2) {
        return com.tencent.ysdk.shell.framework.config.ConfigManager.getInstance().readConfig(str, str2);
    }
}
