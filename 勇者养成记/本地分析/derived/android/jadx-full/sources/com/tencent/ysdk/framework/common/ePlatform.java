package com.tencent.ysdk.framework.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public enum ePlatform {
    None(0),
    QQ(1),
    WX(2),
    QZone(3),
    MyApp(4),
    QQBrowser(5),
    Game3366(6),
    Guest(7),
    FreeLogin(8);

    public static final java.lang.String PF_STR_3366 = "3366_m";

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.3.3")
    public static final java.lang.String PF_STR_FREE_LOGIN = "freelogin";

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.2.3")
    public static final java.lang.String PF_STR_GUEST = "guest";
    public static final java.lang.String PF_STR_MYAPP = "myapp_m";
    public static final java.lang.String PF_STR_NONE = "desktop_m";
    public static final java.lang.String PF_STR_QQ = "qq_m";
    public static final java.lang.String PF_STR_QQBROWSER = "qqbrowser_m";
    public static final java.lang.String PF_STR_QQHALL = "mobile";
    public static final java.lang.String PF_STR_QZONE = "qzone_m";
    public static final java.lang.String PF_STR_WX = "wechat";
    public static final int PLATFORM_ID_3366 = 6;
    public static final int PLATFORM_ID_FREE_LOGIN = 8;
    public static final int PLATFORM_ID_GUEST = 7;
    public static final int PLATFORM_ID_MYAPP = 4;
    public static final int PLATFORM_ID_NONE = 0;
    public static final int PLATFORM_ID_QQ = 1;
    public static final int PLATFORM_ID_QQBROWER = 5;
    public static final int PLATFORM_ID_QZONE = 3;
    public static final int PLATFORM_ID_WX = 2;
    public static final java.lang.String PLATFORM_STR_3366 = "3366";

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.3.3")
    public static final java.lang.String PLATFORM_STR_FREE_LOGIN = "freelogin";

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.2.3")
    public static final java.lang.String PLATFORM_STR_GUEST = "guest";
    public static final java.lang.String PLATFORM_STR_MYAPP = "myapp";
    public static final java.lang.String PLATFORM_STR_NONE = "desktop";
    public static final java.lang.String PLATFORM_STR_QQ = "qq";
    public static final java.lang.String PLATFORM_STR_QQBROWSER = "qqbrowser";
    public static final java.lang.String PLATFORM_STR_QQHALL = "mobile";
    public static final java.lang.String PLATFORM_STR_QZONE = "qzone";
    public static final java.lang.String PLATFORM_STR_WX = "wx";
    private java.lang.String pfStr;
    private java.lang.String platformStr;
    private int value;

    ePlatform(int i) {
        java.lang.String str;
        this.value = 0;
        this.platformStr = "";
        this.pfStr = "";
        this.value = i;
        switch (i) {
            case 0:
            default:
                this.platformStr = PLATFORM_STR_NONE;
                str = PF_STR_NONE;
                break;
            case 1:
                this.platformStr = "qq";
                str = PF_STR_QQ;
                break;
            case 2:
                this.platformStr = PLATFORM_STR_WX;
                str = "wechat";
                break;
            case 3:
                this.platformStr = "qzone";
                str = PF_STR_QZONE;
                break;
            case 4:
                this.platformStr = PLATFORM_STR_MYAPP;
                str = PF_STR_MYAPP;
                break;
            case 5:
                this.platformStr = PLATFORM_STR_QQBROWSER;
                str = PF_STR_QQBROWSER;
                break;
            case 6:
                this.platformStr = PLATFORM_STR_3366;
                str = PF_STR_3366;
                break;
            case 7:
                this.platformStr = "guest";
                str = "guest";
                break;
            case 8:
                this.platformStr = "freelogin";
                str = "freelogin";
                break;
        }
        this.pfStr = str;
    }

    public static com.tencent.ysdk.framework.common.ePlatform getEnum(int i) {
        switch (i) {
            case 0:
            default:
                return None;
            case 1:
                return QQ;
            case 2:
                return WX;
            case 3:
                return QZone;
            case 4:
                return MyApp;
            case 5:
                return QQBrowser;
            case 6:
                return Game3366;
            case 7:
                return Guest;
            case 8:
                return FreeLogin;
        }
    }

    public static com.tencent.ysdk.framework.common.ePlatform getEnum(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return None;
        }
        if (str.equals(PF_STR_QQ)) {
            return QQ;
        }
        if (str.equals("wechat")) {
            return WX;
        }
        if (str.equals(PF_STR_MYAPP)) {
            return MyApp;
        }
        if (str.equals(PF_STR_QZONE)) {
            return QZone;
        }
        if (str.equals(PF_STR_QQBROWSER)) {
            return QQBrowser;
        }
        if (str.equals(PF_STR_3366)) {
            return Game3366;
        }
        if (str.equals("guest")) {
            return Guest;
        }
        if (str.equals("freelogin")) {
            return FreeLogin;
        }
        com.tencent.ysdk.libware.file.Logger.w("Bad platformStr:" + str);
        return None;
    }

    public java.lang.String pfStr() {
        return this.pfStr;
    }

    public java.lang.String platformStr() {
        return this.platformStr;
    }

    public int val() {
        return this.value;
    }
}
