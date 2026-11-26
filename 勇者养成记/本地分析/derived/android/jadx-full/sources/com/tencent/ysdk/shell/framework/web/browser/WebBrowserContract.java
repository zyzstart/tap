package com.tencent.ysdk.shell.framework.web.browser;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface WebBrowserContract {

    public interface Presenter extends com.tencent.ysdk.shell.framework.mvp.BasePresenter {
        int getWebViewType();

        void initJSBridge();

        void initWebViewSettings();

        void loadURL(java.lang.String str);

        void loadURL(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map);

        void loadURL(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map, java.util.HashMap<java.lang.String, java.lang.String> map2);

        void onBrowserClose();

        void onPause();

        void onResume();

        void regOnBrowserStateChangeListener(com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener onBrowserStateChangeListener);

        void removeCookie(android.content.Context context);
    }

    public interface View extends com.tencent.ysdk.shell.framework.mvp.BaseView<com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.Presenter> {
        void buildWindow();

        void closeH5(int i);

        android.content.Context getContext();

        android.view.View getView();

        com.tencent.smtt.sdk.WebView getWebView();

        void initView();

        void pageLoadFinish(long j);

        void pageLoadStart(java.lang.String str);

        void setExtraData(java.util.HashMap<java.lang.String, java.lang.String> map);

        void setFailingUrl(com.tencent.smtt.sdk.WebView webView, java.lang.String str);

        void setSize(float f, float f2);

        void showErrorPage(boolean z);
    }
}
