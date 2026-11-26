package com.tencent.ysdk.shell.framework.web.browser;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YSDKWebBrowserManager {
    public static final int FLOAT_MENU_WEBVIEW_TYPE = 1;
    public static final int LOAD_URL_WEBVIEW_TYPE = 2;
    public static final int POP_WINDOW_WEBVIEW_TYPE = 4;
    public static final int PUSH_MSG_WEBVIEW_TYPE = 8;
    public static final int PUSH_PRE_WEBVIEW_TYPE = 16;
    private static final java.lang.String SW_URL = "https://qzs.qq.com/open/yyb/halo-sw-page/preload.html";
    public static final java.lang.String TAG = "YSDKWebBrowserManager";
    private static com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser swWebview;
    private static java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser> sInstanceMap = new java.util.concurrent.ConcurrentHashMap<>();
    private static volatile boolean isPreloaded = false;

    public @interface WebViewType {
    }

    public static boolean closeForOut(int i) {
        com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser ySDKWebBrowserRemove = sInstanceMap.remove(java.lang.Integer.valueOf(i));
        if (ySDKWebBrowserRemove == null) {
            return false;
        }
        ySDKWebBrowserRemove.closeFromOuter();
        return true;
    }

    public static void destroyByType(@com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowserManager.WebViewType int i) {
        sInstanceMap.remove(java.lang.Integer.valueOf(i));
    }

    @androidx.annotation.Nullable
    public static com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser getInstance(@com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowserManager.WebViewType int i) {
        return sInstanceMap.get(java.lang.Integer.valueOf(i));
    }

    @androidx.annotation.NonNull
    public static synchronized com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser getInstance(@com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowserManager.WebViewType int i, android.content.Context context, float f, float f2) {
        com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser ySDKWebBrowser;
        ySDKWebBrowser = sInstanceMap.get(java.lang.Integer.valueOf(i));
        if (ySDKWebBrowser == null) {
            ySDKWebBrowser = new com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser(context, f, f2, i);
            sInstanceMap.put(java.lang.Integer.valueOf(i), ySDKWebBrowser);
        } else {
            ySDKWebBrowser.setSize(f, f2);
        }
        return ySDKWebBrowser;
    }

    public static synchronized void initPreLoadSW() {
        if (isPreloaded) {
            return;
        }
        android.util.Log.d(TAG, "initPreLoadSW start");
        isPreloaded = true;
        android.os.Looper.myQueue().addIdleHandler(new android.os.MessageQueue.IdleHandler() { // from class: com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowserManager.1
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                try {
                    com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser unused = com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowserManager.swWebview = com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowserManager.getInstance(16, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext(), 1.0f, 1.0f);
                    com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowserManager.swWebview.loadURL(com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowserManager.SW_URL);
                    android.util.Log.d(com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowserManager.TAG, "initPreLoadSW executed");
                    return false;
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        });
        android.util.Log.d(TAG, "initPreLoadSW end");
    }

    public static boolean isHasWebView() {
        return sInstanceMap.size() > 0;
    }

    public static void onPause() {
        java.util.Iterator<java.lang.Integer> it = sInstanceMap.keySet().iterator();
        while (it.hasNext()) {
            com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser ySDKWebBrowser = sInstanceMap.get(it.next());
            if (ySDKWebBrowser != null) {
                ySDKWebBrowser.onPause();
            }
        }
    }

    public static void onResume() {
        java.util.Iterator<java.lang.Integer> it = sInstanceMap.keySet().iterator();
        while (it.hasNext()) {
            com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser ySDKWebBrowser = sInstanceMap.get(it.next());
            if (ySDKWebBrowser != null) {
                ySDKWebBrowser.onResume();
            }
        }
    }
}
