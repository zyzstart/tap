package com.tencent.ysdk.shell.framework.web.router;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class IntentRouter {
    public static void commonJump(android.content.Context context, java.lang.String str, int i) {
        commonJump(context, str, null, i);
    }

    public static void commonJump(android.content.Context context, java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map, int i) {
        commonJump(context, str, map, i, null);
    }

    public static void commonJump(android.content.Context context, java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map, int i, java.util.HashMap<java.lang.String, java.lang.String> map2) {
        commonJump(context, str, map, i, map2, null);
    }

    public static void commonJump(android.content.Context context, java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map, int i, java.util.HashMap<java.lang.String, java.lang.String> map2, com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener onBrowserStateChangeListener) {
        try {
            android.net.Uri uri = android.net.Uri.parse(str);
            java.lang.String scheme = uri.getScheme();
            if (scheme.equals("tmast")) {
                tmastJump(context, str);
                return;
            }
            if (scheme.contains("http")) {
                int[] widthAndHeightFromUri = getWidthAndHeightFromUri(context, uri);
                if (widthAndHeightFromUri[0] == 0 || widthAndHeightFromUri[1] == 0) {
                    widthAndHeightFromUri = getWidthAndHeightFromExtraData(context, map2);
                }
                com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser ySDKWebBrowserManager = com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowserManager.getInstance(i, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext(), widthAndHeightFromUri[0], widthAndHeightFromUri[1]);
                ySDKWebBrowserManager.loadURL(str, map, map2);
                if (onBrowserStateChangeListener != null) {
                    ySDKWebBrowserManager.regOnBrowserStateChangeListener(onBrowserStateChangeListener);
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private static int[] getWidthAndHeightFromExtraData(android.content.Context context, java.util.HashMap<java.lang.String, java.lang.String> map) {
        int i;
        int i2;
        java.lang.String str = "";
        java.lang.String str2 = "";
        if (map != null) {
            if (com.tencent.ysdk.shell.libware.device.DeviceUtils.getOrientation(context) == 1) {
                if (map.containsKey(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_WEBVIEW_PORTRAIT_WIDTH) && map.containsKey(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_WEBVIEW_PORTRAIT_HEIGHT)) {
                    str = map.get(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_WEBVIEW_PORTRAIT_WIDTH);
                    str2 = map.get(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_WEBVIEW_PORTRAIT_HEIGHT);
                }
            } else if (map.containsKey(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_WEBVIEW_LANDSCAPE_WIDTH) && map.containsKey(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_WEBVIEW_LANDSCAPE_HEIGHT)) {
                str = map.get(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_WEBVIEW_LANDSCAPE_WIDTH);
                str2 = map.get(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_WEBVIEW_LANDSCAPE_HEIGHT);
            }
            i = !android.text.TextUtils.isEmpty(str) ? java.lang.Integer.parseInt(str) : 0;
            i2 = !android.text.TextUtils.isEmpty(str2) ? java.lang.Integer.parseInt(str2) : 0;
        } else {
            i = 0;
            i2 = 0;
        }
        return new int[]{i, i2};
    }

    private static int[] getWidthAndHeightFromUri(android.content.Context context, android.net.Uri uri) {
        int i;
        int i2;
        int i3;
        java.lang.String queryParameter;
        java.lang.String queryParameter2;
        try {
            if (context.getResources().getConfiguration().orientation == 1) {
                queryParameter = uri.getQueryParameter("portrait_width");
                queryParameter2 = uri.getQueryParameter("portrait_height");
            } else {
                queryParameter = uri.getQueryParameter("landscape_width");
                queryParameter2 = uri.getQueryParameter("landscape_height");
            }
            i2 = !android.text.TextUtils.isEmpty(queryParameter) ? java.lang.Integer.parseInt(queryParameter) : 0;
            try {
                i3 = !android.text.TextUtils.isEmpty(queryParameter2) ? java.lang.Integer.parseInt(queryParameter2) : 0;
            } catch (java.lang.Exception e) {
                i = i2;
                e = e;
                e.printStackTrace();
                i2 = i;
                i3 = 0;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            i = 0;
        }
        return new int[]{i2, i3};
    }

    public static void tmastJump(android.content.Context context, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
        intent.setFlags(268435456);
        try {
            if (context.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                context.startActivity(intent);
            } else {
                android.widget.Toast.makeText(context, "请下载应用宝后重试", 1).show();
                android.content.Intent intent2 = new android.content.Intent();
                intent2.setAction("android.intent.action.VIEW");
                intent2.setFlags(268435456);
                intent2.setData(android.net.Uri.parse("http://app.qq.com/"));
                context.startActivity(intent2);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
