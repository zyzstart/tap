package com.tencent.ysdk.shell.framework.web;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WebViewStatHelper {
    private static final java.lang.String BUSSINESS_ID = "bussinessId";
    private static final java.lang.String BUSSINESS_ID_TYPE = "bussinessId=";
    public static final int CLOSE_BY_CLICK_BACK = 3;
    public static final int CLOSE_BY_CLICK_BUTTON = 1;
    public static final int CLOSE_BY_CLICK_OUT = 2;
    public static final int CLOSE_BY_OTHERS = 4;
    private static final java.lang.String ID = "id";
    private static final java.lang.String ID_TYPE = "pushId=";
    private static final java.lang.String PUSH_ID = "pushId";
    private static final java.lang.String SCENE = "scene";
    private static final java.lang.String SCENE_TYPE = "scene=";
    private static final java.lang.String WEBVIEW_ERROR_CODE = "errorCode";
    private static final java.lang.String WEBVIEW_ERROR_TYPE = "errorType";
    private static final java.lang.String WEBVIEW_ERROR_URL = "errorUrl";
    private static final java.lang.String WEBVIEW_LOAD_FINISH = "loadFinish";
    private static final int WEBVIEW_LOAD_FINISH_CONSTANT = 1;
    private static final int WEBVIEW_LOAD_NOT_FINISH_CONSTANT = 0;
    public static final int WINDOW_SCENE_AFTER_LOGIN = 2;
    public static final int WINDOW_SCENE_AFTER_PAY = 3;
    public static final int WINDOW_SCENE_LAUNCH = 1;
    private static final java.lang.String WINDOW_TYPE = "type";
    public static final java.lang.String WINDOW_TYPE_FORCE = "2";
    public static final java.lang.String WINDOW_TYPE_H5 = "3";
    public static final java.lang.String WINDOW_TYPE_TOP_BAR = "4";
    public static final java.lang.String WINDOW_TYPE_TRANCE = "1";
    private static int mWebviewLoadFinish = -1;

    public static java.lang.String appendPushID(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.lang.String str4 = str.contains(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START) ? "&" : com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START;
        if (!str.contains(ID_TYPE) && !android.text.TextUtils.isEmpty(str2)) {
            str = str + str4 + "pushId=" + str2;
            str4 = "&";
        }
        if (str.contains(BUSSINESS_ID) || !android.text.TextUtils.isEmpty(str3)) {
            return str;
        }
        return str + str4 + BUSSINESS_ID + "=" + str3;
    }

    private static java.util.Map<java.lang.String, java.lang.String> fillParams(java.lang.String str, java.lang.String str2) {
        if (str2 == null) {
            str2 = getWindowTypeByUrl(str);
        }
        java.lang.String windowSceneByUrl = getWindowSceneByUrl(str);
        java.lang.String windowIdByUrl = getWindowIdByUrl(str);
        java.lang.String bussinessIdByUrl = getBussinessIdByUrl(str);
        java.util.HashMap map = new java.util.HashMap();
        map.put("type", str2);
        map.put("scene", windowSceneByUrl);
        map.put(ID, windowIdByUrl);
        map.put(BUSSINESS_ID, bussinessIdByUrl);
        map.put("url", str);
        return map;
    }

    private static java.lang.String getBussinessIdByUrl(java.lang.String str) {
        return (android.text.TextUtils.isEmpty(str) || !str.contains(BUSSINESS_ID_TYPE)) ? "" : subStringFromObject(str, BUSSINESS_ID_TYPE);
    }

    private static java.lang.String getWindowIdByUrl(java.lang.String str) {
        return (android.text.TextUtils.isEmpty(str) || !str.contains(ID_TYPE)) ? "" : subStringFromObject(str, ID_TYPE);
    }

    private static java.lang.String getWindowSceneByUrl(java.lang.String str) {
        return (android.text.TextUtils.isEmpty(str) || !str.contains(SCENE_TYPE)) ? "" : subStringFromObject(str, SCENE_TYPE);
    }

    private static java.lang.String getWindowTypeByUrl(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        return str.contains("alpha=0") ? "1" : "3";
    }

    private static void reportDuration(java.lang.String str, long j, java.util.Map<java.lang.String, java.lang.String> map) {
        map.put("duration", java.lang.String.valueOf(j));
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(str, 0, "", map, java.lang.System.currentTimeMillis(), true);
    }

    public static void reportOtherWindowClose(java.lang.String str, int i, java.lang.String str2) {
        if (i > 4) {
            i = 4;
        }
        java.util.Map<java.lang.String, java.lang.String> mapFillParams = fillParams(str, str2);
        mapFillParams.put("closeType", java.lang.String.valueOf(i));
        int i2 = mWebviewLoadFinish;
        if (i2 != -1) {
            mapFillParams.put(WEBVIEW_LOAD_FINISH, java.lang.String.valueOf(i2));
            mWebviewLoadFinish = -1;
        }
        com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData("ysdkMsgBoxExposure", 0, "", mapFillParams, java.lang.System.currentTimeMillis(), true, com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Click, mapFillParams.get("type"));
    }

    public static void reportOtherWindowLoadTime(long j, java.lang.String str, java.lang.String str2) {
        reportDuration("ysdkMsgBoxLoadDuration", j, fillParams(str, str2));
    }

    public static void reportWebViewClose(java.lang.String str, boolean z, int i, boolean z2) {
        if (z) {
            return;
        }
        mWebviewLoadFinish = z2 ? 1 : 0;
        reportOtherWindowClose(str, i, null);
    }

    public static void reportWebViewDurationTime(long j, java.lang.String str, boolean z) {
        if (z) {
            return;
        }
        reportDuration("ysdkMsgBoxDuration", j, fillParams(str, null));
    }

    public static void reportWebViewLoadError(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.HashMap map = new java.util.HashMap();
        map.put(WEBVIEW_ERROR_URL, str);
        map.put("errorCode", str2);
        map.put(WEBVIEW_ERROR_TYPE, str3);
        fillParams(str, null);
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_WEBVIEW_LOAD_ERROR, 0, "", map, java.lang.System.currentTimeMillis(), true);
    }

    public static void reportWebViewLoadTime(long j, java.lang.String str, boolean z) {
        if (z) {
            return;
        }
        reportOtherWindowLoadTime(j, str, null);
    }

    public static void reportWebViewPreLoadTime(long j, java.lang.String str, java.lang.String str2, boolean z) {
        if (z) {
            return;
        }
        java.util.Map<java.lang.String, java.lang.String> mapFillParams = fillParams(str, str2);
        mapFillParams.put("duration", java.lang.String.valueOf(j));
        com.tencent.ysdk.shell.module.stat.StatHelper.reportPageData("ysdkMsgBoxPreLoadDuration", 0, "", mapFillParams, java.lang.System.currentTimeMillis(), true, com.tencent.ysdk.shell.module.stat.StatConstants.PageType.PopWindow, mapFillParams.get("type"), java.util.UUID.randomUUID().toString().replace("-", ""), com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Show, mapFillParams.get("type"));
    }

    public static void reportWebviewLoadStart(java.lang.String str, boolean z, java.lang.String str2) {
        if (z) {
            return;
        }
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo("ysdkMsgBoxLoadStart", 0, "webview load start", fillParams(str, str2), java.lang.System.currentTimeMillis(), true);
    }

    private static java.lang.String subStringFromObject(java.lang.String str, java.lang.String str2) {
        java.lang.String strSubstring = str.substring(str.indexOf(str2) + str2.length());
        return strSubstring.contains("&") ? strSubstring.substring(0, strSubstring.indexOf("&")) : strSubstring;
    }
}
