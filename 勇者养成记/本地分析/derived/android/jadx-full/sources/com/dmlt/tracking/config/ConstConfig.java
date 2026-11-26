package com.dmlt.tracking.config;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ConstConfig {
    public static final java.lang.String AD_REPORT_ODDS = "/third/get_ad_report_odds";
    public static final java.lang.String AD_URL = "http://adtrackv3.dodjoy.com";
    public static final java.lang.String APPLE = "APPLE";
    public static final java.lang.String BRL = "BRL";
    public static final java.lang.String CAD = "CAD";
    public static final java.lang.String CNY = "CNY";
    public static final java.lang.String CREATE_ROLE_SERVICE = "/client/createrole";
    public static final java.lang.String DEBUG_URL = "http://192.168.1.184:9002";
    public static boolean DebugMode = false;
    public static final java.lang.String EUR = "EUR";
    public static final java.lang.String FREE = "FREE";
    public static final java.lang.String GBP = "GBP";
    public static final java.lang.String GOOGLE = "GOOGLE";
    public static final java.lang.String HKD = "HKD";
    public static final java.lang.String JPY = "JPY";
    public static final java.lang.String KRW = "KRW";
    public static final java.lang.String LEVEL_UP_SERVICE = "/client/levelup";
    public static final java.lang.String LOGIN_SERVICE = "/client/login";
    public static final java.lang.String REALNAME_SERVICE = "/client/realname";
    public static final java.lang.String RECHARGE_SERVICE = "/client/recharge";
    public static final java.lang.String REGISTER_SERVICE = "/client/register";
    public static final java.lang.String STARTUP_SERVICE = "/client/startup";
    public static final java.lang.String TAG = "Tracking";
    public static final java.lang.String TWD = "TWD";
    public static final java.lang.String UNION_PAY = "UNION_PAY";
    public static final java.lang.String USD = "USD";
    public static final java.lang.String VND = "VND";

    public static java.lang.String getUrl() {
        return DebugMode ? DEBUG_URL : AD_URL;
    }
}
