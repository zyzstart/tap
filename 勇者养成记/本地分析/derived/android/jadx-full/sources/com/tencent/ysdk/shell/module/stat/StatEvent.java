package com.tencent.ysdk.shell.module.stat;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class StatEvent {
    public static final java.lang.String EVENT_ADD_FLOATING_WINDOW = "YSDK_Add_Floating_Window";
    public static final java.lang.String EVENT_ANTI_ADDICTION = "YSDK_Anti_Addiction";
    public static final java.lang.String EVENT_BUBBLE_CLICK_FOR_HIDE = "YSDK_Bubble_Click_For_Close";
    public static final java.lang.String EVENT_BUBBLE_SHOW = "YSDK_Bubble_Show";
    public static final java.lang.String EVENT_HTTP_REQUEST = "ysdkHttpRequest";
    public static final java.lang.String EVENT_PAY_CANCEL = "YSDK_Pay_Cancel";
    public static final java.lang.String EVENT_PAY_ERROR = "YSDK_Pay_Error";
    public static final java.lang.String EVENT_PAY_FAIL = "YSDK_Pay_Fail";
    public static final java.lang.String EVENT_PAY_INIT = "YSDK_Pay_Init";
    public static final java.lang.String EVENT_PAY_SUCCESS = "YSDK_Pay_Success";
    public static final java.lang.String EVENT_PLUGIN_DISABLE = "YSDK_Plugin_Disable";
    public static final java.lang.String EVENT_PLUGIN_REPORT = "YSDK_Plugin_Report";
    public static final java.lang.String EVENT_REPORT_ERROR = "YSDK_Report_Error";
    public static final java.lang.String EVENT_REPORT_FAIL = "YSDK_Report_Fail";
    public static final java.lang.String EVENT_ROLE_INFO = "YSDK_User_Role_Info";
    public static final java.lang.String EVENT_SDK_LAUNCH = "YSDK_System_Launch";
    public static final java.lang.String EVENT_SHOW_FLOATING_WINDOW = "YSDK_Show_Floating_Window";
    public static final java.lang.String EVENT_USER_LOGIN_FAIL = "YSDK_User_Login_Fail";
    public static final java.lang.String EVENT_USER_LOGIN_SUCCESS = "YSDK_User_Login_Success";
    public static final java.lang.String EVENT_USER_LOGOUT = "YSDK_User_Logout";
    public static final java.lang.String EVENT_WAKE_UP = "YSDK_Wake_Up";
    public static final java.lang.String EVENT_WEBVIEW_LOAD_ERROR = "YSDK_WEBVIEW_LOAD_ERROR";
    public static final java.lang.String EVENT_WX_LOGIN_RESPONSE = "YSDK_Wx_Login_Response";

    public static class LoginEvent {
        public static final java.lang.String LOGIN_STAT_PARAM_DEFAULT = "0";
        public static final java.lang.String LOGIN_STAT_PARAM_FIRST_LOGIN = "1";
        public static final java.lang.String LOGIN_STAT_PARAM_GUEST_LOGIN = "6";
        public static final java.lang.String LOGIN_STAT_PARAM_LAUNCHER_LOGIN = "4";
        public static final java.lang.String LOGIN_STAT_PARAM_LOCAL_LOGIN = "2";
        public static final java.lang.String LOGIN_STAT_PARAM_SCAN_LOGIN = "5";
        public static final java.lang.String LOGIN_STAT_PARAM_TIMER_LOGIN = "3";
    }

    public static class PayEvent {
        public static final java.lang.String PAY_STAT_PARAM_BUYGOODS = "buygoods";
        public static final java.lang.String PAY_STAT_PARAM_RECHARGE = "recharge";
        private static java.lang.String mBuyType;

        public static java.lang.String getBuyType() {
            return mBuyType;
        }

        public static void setBuyType(java.lang.String str) {
            mBuyType = str;
        }
    }
}
