package com.tencent.midas.jsbridge;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APWebProtocol {
    public static java.lang.String URL_KEY_HEAD_CONTROL = "midasheader";
    public static java.lang.String URL_KEY_HEAD_TITLE = "midastitle";
    public static java.lang.String WEBACTION_CLOSE = "closeWeb";
    public static java.lang.String WEBACTION_GETCGIEXTEND = "getCgiExtend";
    public static java.lang.String WEBACTION_HEAD = "setHead";

    protected static void AnalyzeWebEntry(android.app.Activity activity, java.lang.Object obj, com.tencent.midas.jsbridge.IAPWebPage iAPWebPage, java.lang.String str) {
        java.util.HashMap mapUrl2Map = com.tencent.midas.plugin.APPluginUtils.url2Map(str);
        java.lang.String str2 = (java.lang.String) mapUrl2Map.get(com.tencent.tauth.AuthActivity.ACTION_KEY);
        java.lang.String str3 = (java.lang.String) mapUrl2Map.get("callback");
        if (WEBACTION_GETCGIEXTEND.equals(str2)) {
            java.lang.String reserv = com.tencent.midas.data.APPluginDataInterface.singleton().getReserv();
            com.tencent.midas.comm.APLog.d("APWebResultPage", "sendCgiExtends() callback=" + str3 + ", extendStr=" + reserv);
            if (!android.text.TextUtils.isEmpty(reserv)) {
                try {
                    reserv = java.net.URLEncoder.encode(reserv, "UTF-8");
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            H5CallBack(obj, str3, reserv);
            return;
        }
        if (!WEBACTION_CLOSE.equals(str2)) {
            if (WEBACTION_HEAD.equals(str2)) {
                try {
                    iAPWebPage.initHead(activity, (java.lang.String) mapUrl2Map.get(URL_KEY_HEAD_CONTROL), (java.lang.String) mapUrl2Map.get(URL_KEY_HEAD_TITLE));
                    return;
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        com.tencent.midas.data.APPluginReportManager.getInstance().insertData(com.tencent.midas.data.APPluginDataInterface.singleton().getLaunchInterface(), com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_WEBPAGE_WEBCLOSE, "", "");
        com.tencent.midas.api.APMidasResponse aPMidasResponse = new com.tencent.midas.api.APMidasResponse();
        aPMidasResponse.resultCode = 100;
        aPMidasResponse.resultMsg = "关闭";
        com.tencent.midas.control.APMidasPayHelper.midasCallBack(aPMidasResponse);
        if (activity != null) {
            activity.finish();
        }
    }

    public static void H5CallBack(java.lang.Object obj, java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        java.lang.Object[] objArr;
        java.lang.Object objNextValue;
        try {
            objNextValue = new org.json.JSONTokener(str2).nextValue();
        } catch (org.json.JSONException | java.lang.Exception unused) {
        }
        try {
            if (objNextValue != null && ((objNextValue instanceof org.json.JSONObject) || (objNextValue instanceof org.json.JSONArray))) {
                str3 = "typeof window[\"%s\"]==='function' && window[\"%s\"](%s);";
                objArr = new java.lang.Object[]{str, str, str2};
            } else {
                str3 = "typeof window[\"%s\"]==='function' && window[\"%s\"](\"%s\");";
                objArr = new java.lang.Object[]{str, str, str2};
            }
            java.lang.String str4 = java.lang.String.format(str3, objArr);
            com.tencent.midas.comm.APLog.i("callback", str);
            com.tencent.midas.comm.APLog.i("cb", str4);
            if (obj instanceof android.webkit.WebView) {
                ((android.webkit.WebView) obj).loadUrl("javascript:" + str4);
                return;
            }
            if (obj instanceof com.tencent.smtt.sdk.WebView) {
                ((com.tencent.smtt.sdk.WebView) obj).loadUrl("javascript:" + str4);
            }
        } catch (java.lang.Exception e) {
            com.tencent.midas.comm.APLog.d("H5CallBack", "H5CallBack() ex = " + e.toString());
        }
    }

    protected static boolean hookH5Method(android.app.Activity activity, android.webkit.WebView webView, java.lang.String str, java.lang.String str2, android.webkit.JsResult jsResult, com.tencent.midas.jsbridge.IAPWebViewCallback iAPWebViewCallback) {
        if (android.text.TextUtils.isEmpty(str2) || !str2.startsWith("http://unipay.sdk.android/")) {
            return false;
        }
        iAPWebViewCallback.WebChromeClientJsAlert(webView, str, str2, jsResult);
        return true;
    }

    protected static boolean hookH5Method(android.app.Activity activity, com.tencent.smtt.sdk.WebView webView, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult, com.tencent.midas.jsbridge.IAPX5WebViewCallback iAPX5WebViewCallback) {
        if (android.text.TextUtils.isEmpty(str2) || !str2.startsWith("http://unipay.sdk.android/")) {
            return false;
        }
        iAPX5WebViewCallback.WebChromeClientJsAlert(webView, str, str2, jsResult);
        return true;
    }
}
