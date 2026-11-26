package com.tencent.ysdk.shell.framework.web.browser;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class WebBrowserView extends android.widget.RelativeLayout implements com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.View, android.view.View.OnClickListener {
    protected static final int FULL_SCREEN_WEBVIEW_SIZE = -1;
    private static final java.lang.String UI_ID_ERROR_PAGE = "com_tencent_ysdk_icon_errorpage";
    private static final java.lang.String UI_ID_H5_CLOSE = "com_tencent_ysdk_icon_h5_xx";
    private static final java.lang.String UI_ID_H5_CONTAINER = "com_tencent_ysdk_icon_h5_container";
    private static final java.lang.String UI_ID_WEBVIEW = "com_tencent_ysdk_icon_webView";
    private static final java.lang.String UI_LAYOUT_SAMPLE = "com_tencent_ysdk_icon_sample";
    private int height;
    private boolean isFullScreen;
    private android.widget.Button mCloseBtn;
    private android.widget.RelativeLayout mContainer;
    private android.content.Context mContext;
    private com.tencent.ysdk.shell.framework.web.browser.ErrorPageView mErrorPageView;
    private java.util.HashMap<java.lang.String, java.lang.String> mExtraData;
    private boolean mIsWebviewLoadFinished;
    private int mMarginLeft;
    private int mMarginTop;
    private com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.Presenter mPresenter;
    private com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.BrowserScene mScene;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mStatusBarHeight;
    public com.tencent.smtt.sdk.WebView mWebView;
    private android.view.WindowManager mWindowManager;
    private long webviewLoadFinishTime;
    private int width;

    public WebBrowserView(android.content.Context context, float f, float f2) {
        super(context);
        this.webviewLoadFinishTime = -1L;
        this.mIsWebviewLoadFinished = false;
        this.isFullScreen = false;
        this.mContext = context;
        initView();
        setSize(f, f2);
    }

    private int getNavigationBarHeight() {
        try {
            android.content.res.Resources resources = getContext().getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
                java.lang.String str = (java.lang.String) cls.getMethod("get", java.lang.String.class).invoke(cls, "qemu.hw.mainkeys");
                if ("1".equals(str)) {
                    z = false;
                } else if ("0".equals(str)) {
                    z = true;
                }
            } catch (java.lang.Exception e) {
                com.tencent.ysdk.shell.libware.file.Logger.w("Browser", e.toString());
            }
            if (!z) {
                com.tencent.ysdk.shell.libware.file.Logger.w("Browser", "No Navigation Bar");
                return 0;
            }
            int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
            com.tencent.ysdk.shell.libware.file.Logger.w("Browser", "navigation_bar_height:" + dimensionPixelSize);
            return dimensionPixelSize;
        } catch (java.lang.Exception e2) {
            com.tencent.ysdk.shell.libware.file.Logger.e("Browser", e2.toString());
            return 0;
        }
    }

    private int getScreenHeight() {
        return getResources().getDisplayMetrics().heightPixels;
    }

    private int getScreenWidth() {
        android.content.Context context = this.mContext;
        return context instanceof android.app.Activity ? com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenWindowWidth((android.app.Activity) context) : com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenWidth(context);
    }

    private int getStatusBarHeight() {
        int i = 0;
        try {
            android.content.res.Resources resources = getContext().getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
            try {
                i = (((android.app.Activity) this.mContext).getWindow().getAttributes().flags & 1024) != 1024 ? dimensionPixelSize : 0;
                com.tencent.ysdk.shell.libware.file.Logger.w("Browser", "status_bar_height:" + i);
            } catch (java.lang.Exception e) {
                e = e;
                i = dimensionPixelSize;
                com.tencent.ysdk.shell.libware.file.Logger.e("Browser", e.toString());
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getUrl() {
        com.tencent.smtt.sdk.WebView webView = this.mWebView;
        if (webView == null) {
            return "";
        }
        java.lang.String originalUrl = webView.getOriginalUrl();
        java.util.HashMap<java.lang.String, java.lang.String> map = this.mExtraData;
        return map != null ? com.tencent.ysdk.shell.framework.web.WebViewStatHelper.appendPushID(originalUrl, map.get(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.PARA_POP_PUSH_ID), this.mExtraData.get(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.PARA_POP_BUSINESS_ID)) : originalUrl;
    }

    private android.view.WindowManager getWindowManager() {
        if (this.mWindowManager == null) {
            this.mWindowManager = (android.view.WindowManager) com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().getSystemService("window");
        }
        return this.mWindowManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWebViewClose() {
        if (this.webviewLoadFinishTime == -1) {
            return;
        }
        com.tencent.ysdk.shell.framework.web.WebViewStatHelper.reportWebViewDurationTime(android.os.SystemClock.elapsedRealtime() - this.webviewLoadFinishTime, getUrl(), com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.BrowserScene.FLOAT_MENU == this.mScene);
        this.webviewLoadFinishTime = -1L;
        this.mIsWebviewLoadFinished = false;
        this.mExtraData = null;
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.View
    public void buildWindow() {
        this.mWindowManager = getWindowManager();
        android.view.WindowManager.LayoutParams layoutParams = new android.view.WindowManager.LayoutParams(1000);
        if (com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.BrowserScene.FLOAT_MENU == this.mScene) {
            layoutParams.width = this.width;
            layoutParams.height = -1;
            layoutParams.flags = 544;
        } else {
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.mCloseBtn.setVisibility(0);
        }
        layoutParams.format = -3;
        layoutParams.gravity = 8388627;
        layoutParams.x = this.mMarginLeft;
        layoutParams.y = this.mMarginTop;
        if (getParent() != null) {
            this.mWindowManager.updateViewLayout(this, layoutParams);
        } else if (this.mPresenter.getWebViewType() != 16) {
            this.mWindowManager.addView(this, layoutParams);
        }
        android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) this.mContainer.getLayoutParams();
        layoutParams2.width = this.width;
        int i = this.height;
        layoutParams2.height = i;
        if (i == this.mScreenHeight) {
            layoutParams2.topMargin = this.mStatusBarHeight;
        } else {
            layoutParams2.addRule(15);
        }
        layoutParams2.addRule(5);
        this.mContainer.setLayoutParams(layoutParams2);
        setVisibility(0);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.View
    public void closeH5(final int i) {
        com.tencent.smtt.sdk.WebView webView = this.mWebView;
        if (webView == null) {
            return;
        }
        webView.post(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.web.browser.WebBrowserView.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tencent.ysdk.shell.framework.web.WebViewStatHelper.reportWebViewClose(com.tencent.ysdk.shell.framework.web.browser.WebBrowserView.this.getUrl(), com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.BrowserScene.FLOAT_MENU == com.tencent.ysdk.shell.framework.web.browser.WebBrowserView.this.mScene, i, com.tencent.ysdk.shell.framework.web.browser.WebBrowserView.this.mIsWebviewLoadFinished);
                    com.tencent.ysdk.shell.framework.web.browser.WebBrowserView.this.onWebViewClose();
                    com.tencent.ysdk.shell.framework.web.browser.WebBrowserView.this.mWebView.stopLoading();
                    com.tencent.ysdk.shell.framework.web.browser.WebBrowserView.this.mWebView.clearHistory();
                    try {
                        if (android.os.Build.VERSION.SDK_INT < 16) {
                            java.lang.reflect.Field declaredField = com.tencent.smtt.sdk.WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
                            declaredField.setAccessible(true);
                            declaredField.set(null, null);
                        } else {
                            java.lang.reflect.Field declaredField2 = java.lang.Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                            if (declaredField2 != null) {
                                declaredField2.setAccessible(true);
                                declaredField2.set(null, null);
                            }
                        }
                    } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.NoSuchFieldException unused) {
                    }
                    com.tencent.ysdk.shell.framework.web.browser.WebBrowserView.this.mPresenter.onBrowserClose();
                    com.tencent.ysdk.shell.framework.web.browser.WebBrowserView.this.mWindowManager.removeView(com.tencent.ysdk.shell.framework.web.browser.WebBrowserView.this);
                    com.tencent.ysdk.shell.framework.web.browser.WebBrowserView.this.mWebView.destroy();
                    com.tencent.ysdk.shell.framework.web.browser.WebBrowserView.this.mWebView = null;
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            try {
                if (this.mWebView != null) {
                    if (this.mWebView.canGoBack()) {
                        this.mWebView.goBack();
                        return true;
                    }
                    closeH5(3);
                    return true;
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.View
    public android.view.View getView() {
        return this;
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.View
    public com.tencent.smtt.sdk.WebView getWebView() {
        return this.mWebView;
    }

    public void hideCloseButton() {
        this.mCloseBtn.post(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.web.browser.WebBrowserView.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ysdk.shell.framework.web.browser.WebBrowserView.this.mCloseBtn.setVisibility(8);
            }
        });
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.View
    public void initView() {
        android.view.LayoutInflater.from(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext()).inflate(com.tencent.ysdk.shell.libware.ui.res.Res.layout(UI_LAYOUT_SAMPLE), this);
        this.mContainer = (android.widget.RelativeLayout) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_H5_CONTAINER));
        this.mErrorPageView = (com.tencent.ysdk.shell.framework.web.browser.ErrorPageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_ERROR_PAGE));
        this.mCloseBtn = (android.widget.Button) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_H5_CLOSE));
        this.mCloseBtn.setOnClickListener(this);
        setOnClickListener(this);
        this.mContainer.setOnClickListener(this);
        this.mWebView = (com.tencent.smtt.sdk.WebView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_WEBVIEW));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        boolean zBooleanValue = true;
        if (view == this.mCloseBtn) {
            if (android.os.Build.VERSION.SDK_INT > 10) {
                this.mCloseBtn.setAlpha(0.6f);
                closeH5(1);
                return;
            }
            return;
        }
        if (view == this.mContainer) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> map = this.mExtraData;
        if (map != null && map.containsKey(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_CLOSE_BY_CLICK_OUTER)) {
            zBooleanValue = java.lang.Boolean.valueOf(this.mExtraData.get(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_CLOSE_BY_CLICK_OUTER)).booleanValue();
        }
        if (zBooleanValue) {
            closeH5(2);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.View
    public void pageLoadFinish(long j) {
        this.webviewLoadFinishTime = android.os.SystemClock.elapsedRealtime();
        this.mIsWebviewLoadFinished = true;
        com.tencent.ysdk.shell.framework.web.WebViewStatHelper.reportWebViewLoadTime(j, getUrl(), com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.BrowserScene.FLOAT_MENU == this.mScene);
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.View
    public void pageLoadStart(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.String> map = this.mExtraData;
        if (map != null) {
            str = com.tencent.ysdk.shell.framework.web.WebViewStatHelper.appendPushID(str, map.get(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.PARA_POP_PUSH_ID), this.mExtraData.get(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.PARA_POP_BUSINESS_ID));
        }
        com.tencent.ysdk.shell.framework.web.WebViewStatHelper.reportWebviewLoadStart(str, com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.BrowserScene.FLOAT_MENU == this.mScene, "3");
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.View
    public void setExtraData(java.util.HashMap<java.lang.String, java.lang.String> map) {
        this.mExtraData = map;
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.View
    public void setFailingUrl(com.tencent.smtt.sdk.WebView webView, java.lang.String str) {
        this.mErrorPageView.setFailingUrl(webView, str);
    }

    @Override // com.tencent.ysdk.shell.framework.mvp.BaseView
    public void setPresenter(com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.Presenter presenter) {
        this.mPresenter = presenter;
        presenter.start();
    }

    public void setScene(com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.BrowserScene browserScene) {
        this.mScene = browserScene;
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.View
    public void setSize(float f, float f2) {
        this.mScreenWidth = getScreenWidth();
        this.mStatusBarHeight = getStatusBarHeight();
        this.mScreenHeight = com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenWindowHeight(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity());
        if (f == 0.0f || f2 == 0.0f) {
            if (this.mContext.getResources().getConfiguration().orientation == 1) {
                f = 90.0f;
                f2 = 70.0f;
            } else {
                f2 = 85.0f;
                f = 70.0f;
            }
        }
        if (f == -1.0f || f2 == -1.0f) {
            this.width = this.mScreenWidth;
            this.height = this.mScreenHeight;
            this.isFullScreen = true;
            this.mMarginLeft = 0;
            this.mMarginTop = 0;
            return;
        }
        int i = this.mScreenWidth;
        this.width = (int) ((i * f) / 100.0f);
        int i2 = this.mScreenHeight;
        this.height = (int) ((i2 * f2) / 100.0f);
        this.isFullScreen = false;
        this.mMarginLeft = (int) ((i * (100.0f - f)) / 200.0f);
        this.mMarginTop = (int) ((i2 * (100.0f - f2)) / 200.0f);
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.View
    public void showErrorPage(boolean z) {
        com.tencent.smtt.sdk.WebView webView = this.mWebView;
        if (webView != null) {
            webView.setVisibility(!z ? 0 : 4);
        }
        com.tencent.ysdk.shell.framework.web.browser.ErrorPageView errorPageView = this.mErrorPageView;
        if (errorPageView != null) {
            errorPageView.setVisibility(z ? 0 : 8);
        }
    }
}
