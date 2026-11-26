package com.tencent.ysdk.shell.framework.web.browser;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YSDKWebBrowser {
    public static java.lang.String TAG = "YSDK_Browser";
    private com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter mPresenter;
    private com.tencent.ysdk.shell.framework.web.browser.WebBrowserView mView;

    public enum BrowserScene {
        NORMAL,
        FLOAT_MENU
    }

    public interface OnBrowserStateChangeListener {
        void onClose();

        void onPageFinish();

        void onPageStart();
    }

    YSDKWebBrowser(android.content.Context context, float f, float f2, int i) {
        this.mView = new com.tencent.ysdk.shell.framework.web.browser.WebBrowserView(context, f, f2);
        this.mPresenter = new com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter(this.mView, i);
    }

    public void closeFromOuter() {
        com.tencent.ysdk.shell.framework.web.browser.WebBrowserView webBrowserView = this.mView;
        if (webBrowserView != null) {
            webBrowserView.closeH5(4);
        }
    }

    public android.view.View getView() {
        return this.mView;
    }

    public void hideCloseButton() {
        this.mView.hideCloseButton();
    }

    public void loadURL(java.lang.String str) {
        loadURL(str, null);
    }

    public void loadURL(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map) {
        loadURL(str, map, null);
    }

    public void loadURL(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map, java.util.HashMap<java.lang.String, java.lang.String> map2) {
        this.mPresenter.loadURL(str, map, map2);
    }

    void onActivityResult(int i, int i2, android.content.Intent intent) {
        this.mPresenter.onActivityResult(i, i2, intent);
    }

    void onPause() {
        this.mPresenter.onPause();
    }

    void onResume() {
        this.mPresenter.onResume();
    }

    public void regOnBrowserStateChangeListener(com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener onBrowserStateChangeListener) {
        this.mPresenter.regOnBrowserStateChangeListener(onBrowserStateChangeListener);
    }

    public void regOnShareSceneManager(com.tencent.ysdk.shell.module.share.impl.ShareManagerBBS shareManagerBBS) {
        this.mPresenter.getJsBridge().regShareManagerBBS(shareManagerBBS);
    }

    public void setScene(com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.BrowserScene browserScene) {
        com.tencent.ysdk.shell.framework.web.browser.WebBrowserView webBrowserView = this.mView;
        if (webBrowserView != null) {
            webBrowserView.setScene(browserScene);
        }
    }

    public void setSize(float f, float f2) {
        com.tencent.ysdk.shell.framework.web.browser.WebBrowserView webBrowserView = this.mView;
        if (webBrowserView != null) {
            webBrowserView.setSize(f, f2);
        }
    }

    public void setVisibility(int i) {
        this.mView.setVisibility(i);
    }

    public void showErrorPage(boolean z) {
        this.mView.showErrorPage(z);
    }
}
