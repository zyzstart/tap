package com.tencent.ysdk.shell.framework.web.browser;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class WebBrowserPresenter implements com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.Presenter {
    protected static final int REQUEST_CODE_FILE_PICKER = 51426;
    private static final java.lang.String TAG = "WebBrowserPresenter";
    private static final java.lang.String URL_PARA_YSDK_VERSION = "YSDKVersion";
    private static final java.lang.String URL_USER_AGENT_ICON_VERSION = "GameIcon";
    private static final java.lang.String URL_USER_AGENT_JSBRIDGE_VERSION = "JVersion";
    private com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener listener;
    private android.content.Context mContext;
    protected com.tencent.smtt.sdk.ValueCallback<android.net.Uri> mFileUploadCallbackFirst;
    protected com.tencent.smtt.sdk.ValueCallback<android.net.Uri[]> mFileUploadCallbackSecond;
    private boolean mIsShowedDelay = false;
    private com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeProxy mJsBridge;
    private int mType;
    private final com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.View mWebBrowserView;
    private boolean needClearHistory;

    final class MyWebChromeClient extends com.tencent.smtt.sdk.WebChromeClient {
        public android.content.Context mContext;
        public com.tencent.ysdk.shell.framework.web.jsbridge.BaseJsBridgeProxy mJsBridgeProxy;

        public MyWebChromeClient(com.tencent.ysdk.shell.framework.web.jsbridge.BaseJsBridgeProxy baseJsBridgeProxy, android.content.Context context) {
            this.mJsBridgeProxy = null;
            this.mJsBridgeProxy = baseJsBridgeProxy;
            this.mContext = context;
        }

        public boolean handleConsoleMessage(java.lang.String str) {
            if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str) || str.startsWith("http") || str.startsWith("https")) {
                return false;
            }
            if (!str.startsWith(com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge.JS_BRIDGE_SCHEME)) {
                return (str.equals("about:blank;") || str.equals("about:blank")) && android.os.Build.VERSION.SDK_INT < 11;
            }
            com.tencent.ysdk.shell.framework.web.jsbridge.BaseJsBridgeProxy baseJsBridgeProxy = this.mJsBridgeProxy;
            if (baseJsBridgeProxy != null) {
                baseJsBridgeProxy.invoke(str);
            }
            return true;
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onConsoleMessage(com.tencent.smtt.export.external.interfaces.ConsoleMessage consoleMessage) {
            if (consoleMessage == null) {
                return false;
            }
            handleConsoleMessage(consoleMessage.message());
            return true;
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onJsAlert(com.tencent.smtt.sdk.WebView webView, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult) {
            jsResult.confirm();
            return true;
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onJsPrompt(com.tencent.smtt.sdk.WebView webView, java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.smtt.export.external.interfaces.JsPromptResult jsPromptResult) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onShowFileChooser(com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.sdk.ValueCallback<android.net.Uri[]> valueCallback, com.tencent.smtt.sdk.WebChromeClient.FileChooserParams fileChooserParams) {
            openFileInput(null, valueCallback, false);
            return true;
        }

        public void openFileChooser(com.tencent.smtt.sdk.ValueCallback<android.net.Uri> valueCallback) {
            openFileChooser(valueCallback, null);
        }

        public void openFileChooser(com.tencent.smtt.sdk.ValueCallback<android.net.Uri> valueCallback, java.lang.String str) {
            openFileChooser(valueCallback, str, null);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void openFileChooser(com.tencent.smtt.sdk.ValueCallback<android.net.Uri> valueCallback, java.lang.String str, java.lang.String str2) {
            openFileInput(valueCallback, null, false);
        }

        protected void openFileInput(com.tencent.smtt.sdk.ValueCallback<android.net.Uri> valueCallback, com.tencent.smtt.sdk.ValueCallback<android.net.Uri[]> valueCallback2, boolean z) {
            try {
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.TAG, "Open File for Select");
                if (com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mFileUploadCallbackFirst != null) {
                    com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mFileUploadCallbackFirst.onReceiveValue(null);
                }
                com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mFileUploadCallbackFirst = valueCallback;
                if (com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mFileUploadCallbackSecond != null) {
                    com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mFileUploadCallbackSecond.onReceiveValue(null);
                }
                com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mFileUploadCallbackSecond = valueCallback2;
                android.content.Intent intent = new android.content.Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("*/*");
                com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().startActivityForResult(android.content.Intent.createChooser(intent, ""), com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.REQUEST_CODE_FILE_PICKER);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class MyWebViewClient extends com.tencent.smtt.sdk.WebViewClient {
        long startLoadTime;

        private MyWebViewClient() {
            this.startLoadTime = -1L;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void doUpdateVisitedHistory(com.tencent.smtt.sdk.WebView webView, java.lang.String str, boolean z) {
            super.doUpdateVisitedHistory(webView, str, z);
            if (com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.needClearHistory) {
                com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.needClearHistory = false;
                com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mWebBrowserView.getWebView().clearHistory();
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(com.tencent.smtt.sdk.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            if ((com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mType == 8 || com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mIsShowedDelay) && com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mWebBrowserView.getView().getVisibility() == 8) {
                com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mWebBrowserView.getView().setVisibility(0);
                com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mWebBrowserView.getView().requestFocus();
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.TAG, "page show less than 3s:" + (android.os.SystemClock.elapsedRealtime() - this.startLoadTime));
            }
            if (this.startLoadTime > -1) {
                com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mWebBrowserView.pageLoadFinish(android.os.SystemClock.elapsedRealtime() - this.startLoadTime);
                this.startLoadTime = -1L;
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(com.tencent.smtt.sdk.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.startLoadTime = android.os.SystemClock.elapsedRealtime();
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.TAG, "pageStart:" + this.startLoadTime);
            if (com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mType == 8 || com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mIsShowedDelay) {
                com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mWebBrowserView.getView().setVisibility(8);
                new android.os.Handler().postDelayed(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.MyWebViewClient.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mWebBrowserView.getView().getVisibility() == 8) {
                            com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mWebBrowserView.getView().setVisibility(0);
                            com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mWebBrowserView.getView().requestFocus();
                            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.TAG, "page show over 3s:" + (android.os.SystemClock.elapsedRealtime() - com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.MyWebViewClient.this.startLoadTime));
                        }
                    }
                }, 3000L);
            }
            com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mWebBrowserView.pageLoadStart(str);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedError(com.tencent.smtt.sdk.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mWebBrowserView.showErrorPage(true);
            com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mWebBrowserView.setFailingUrl(webView, str2);
            super.onReceivedError(webView, i, str, str2);
            com.tencent.ysdk.shell.framework.web.WebViewStatHelper.reportWebViewLoadError(webView.getOriginalUrl(), java.lang.String.valueOf(i), str);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedError(com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest, com.tencent.smtt.export.external.interfaces.WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            com.tencent.ysdk.shell.framework.web.WebViewStatHelper.reportWebViewLoadError(webView.getOriginalUrl(), java.lang.String.valueOf(webResourceError.getErrorCode()), "WebResourceError");
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedHttpError(com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest, com.tencent.smtt.export.external.interfaces.WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest.isForMainFrame()) {
                com.tencent.ysdk.shell.framework.web.WebViewStatHelper.reportWebViewLoadError(webResourceRequest.getUrl().toString(), java.lang.String.valueOf(webResourceResponse.getStatusCode()), "HttpError");
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedSslError(com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.export.external.interfaces.SslErrorHandler sslErrorHandler, com.tencent.smtt.export.external.interfaces.SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            com.tencent.ysdk.shell.framework.web.WebViewStatHelper.reportWebViewLoadError(webView.getOriginalUrl(), java.lang.String.valueOf(sslError.getPrimaryError()), "SslError");
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView webView, java.lang.String str) {
            com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mWebBrowserView.setFailingUrl(webView, str);
            if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str) || str.startsWith("http") || str.startsWith("https")) {
                return false;
            }
            if (str.startsWith(com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge.JS_BRIDGE_SCHEME)) {
                if (com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mJsBridge != null) {
                    com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mJsBridge.invoke(str);
                }
                return true;
            }
            if (str.equals("about:blank;") || str.equals("about:blank")) {
                return android.os.Build.VERSION.SDK_INT < 11;
            }
            com.tencent.ysdk.shell.framework.web.router.IntentRouter.tmastJump(com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mContext, str);
            return true;
        }
    }

    private class MyWebViewDownloadListener implements com.tencent.smtt.sdk.DownloadListener {
        private MyWebViewDownloadListener() {
        }

        @Override // com.tencent.smtt.sdk.DownloadListener
        public void onDownloadStart(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j) {
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
            intent.setFlags(268435456);
            com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.this.mWebBrowserView.getWebView().getContext().startActivity(intent);
        }
    }

    public WebBrowserPresenter(@androidx.annotation.NonNull com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.View view, int i) {
        this.mWebBrowserView = view;
        this.mContext = view.getContext();
        this.mType = i;
        view.setPresenter(this);
    }

    private void asyncClearHistory() {
        this.needClearHistory = true;
    }

    private static java.lang.String getSetCookieSring(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4 = str + "=" + str2;
        if (str3 == null) {
            return str4;
        }
        return (str4 + "; path=/") + "; domain=" + str3;
    }

    private void handleFilePickerFail() {
        com.tencent.smtt.sdk.ValueCallback<android.net.Uri> valueCallback = this.mFileUploadCallbackFirst;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.mFileUploadCallbackFirst = null;
            return;
        }
        com.tencent.smtt.sdk.ValueCallback<android.net.Uri[]> valueCallback2 = this.mFileUploadCallbackSecond;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue(null);
            this.mFileUploadCallbackSecond = null;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void handleFilePickerSucc(android.content.Intent intent) {
        android.net.Uri[] uriArr;
        if (intent != null) {
            com.tencent.smtt.sdk.ValueCallback<android.net.Uri> valueCallback = this.mFileUploadCallbackFirst;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(intent.getData());
                this.mFileUploadCallbackFirst = null;
                return;
            }
            if (this.mFileUploadCallbackSecond != null) {
                try {
                    if (intent.getDataString() != null) {
                        uriArr = new android.net.Uri[]{android.net.Uri.parse(intent.getDataString())};
                    } else if (android.os.Build.VERSION.SDK_INT < 16 || intent.getClipData() == null) {
                        uriArr = null;
                    } else {
                        int itemCount = intent.getClipData().getItemCount();
                        android.net.Uri[] uriArr2 = new android.net.Uri[itemCount];
                        for (int i = 0; i < itemCount; i++) {
                            try {
                                uriArr2[i] = intent.getClipData().getItemAt(i).getUri();
                            } catch (java.lang.Exception unused) {
                                uriArr = uriArr2;
                            }
                        }
                        uriArr = uriArr2;
                    }
                } catch (java.lang.Exception unused2) {
                    uriArr = null;
                }
                this.mFileUploadCallbackSecond.onReceiveValue(uriArr);
                this.mFileUploadCallbackSecond = null;
            }
        }
    }

    private void synCookies(android.content.Context context, java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map) {
        java.lang.String str2;
        java.lang.String qQAppId;
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            return;
        }
        com.tencent.smtt.sdk.CookieSyncManager.createInstance(context);
        com.tencent.smtt.sdk.CookieManager cookieManager = com.tencent.smtt.sdk.CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setAcceptThirdPartyCookies(this.mWebBrowserView.getWebView(), true);
        android.net.Uri uri = android.net.Uri.parse(str);
        if (uri.getHost() == null) {
            return;
        }
        if (!uri.getHost().toLowerCase().endsWith(".qq.com")) {
            com.tencent.ysdk.shell.libware.file.Logger.d("host is not qq.com");
            return;
        }
        java.lang.String packageName = context.getPackageName();
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        if (1 != loginRecord.platform && 2 == loginRecord.platform) {
            str2 = "WX";
            qQAppId = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getWXAppId();
        } else {
            str2 = "MOBILEQ";
            qQAppId = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId();
        }
        if (map != null) {
            for (java.lang.String str3 : map.keySet()) {
                java.lang.String str4 = map.get(str3);
                if (!android.text.TextUtils.isEmpty(str3) && !android.text.TextUtils.isEmpty(str4)) {
                    cookieManager.setCookie(str, getSetCookieSring(str3, str4, ".qq.com"));
                }
            }
        }
        cookieManager.setCookie(str, getSetCookieSring("yyb_guid", java.lang.String.valueOf(com.tencent.ysdk.shell.module.launchgift.LaunchGiftInnerApi.getYYB_GUID()), ".qq.com"));
        cookieManager.setCookie(str, getSetCookieSring("game_uid", java.lang.String.valueOf(com.tencent.ysdk.shell.module.launchgift.LaunchGiftInnerApi.getGameUID()), ".qq.com"));
        cookieManager.setCookie(str, getSetCookieSring("pf", java.lang.String.valueOf(loginRecord.platform), ".qq.com"));
        cookieManager.setCookie(str, getSetCookieSring("logintype", str2, ".qq.com"));
        cookieManager.setCookie(str, getSetCookieSring("openid", loginRecord.open_id, ".qq.com"));
        cookieManager.setCookie(str, getSetCookieSring(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN, loginRecord.getAccessToken(), "[REDACTED]"));
        cookieManager.setCookie(str, getSetCookieSring("pkg_name", packageName, ".qq.com"));
        cookieManager.setCookie(str, getSetCookieSring("appid", qQAppId, ".qq.com"));
        com.tencent.smtt.sdk.CookieSyncManager.getInstance().sync();
    }

    public com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeProxy getJsBridge() {
        return this.mJsBridge;
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.Presenter
    public int getWebViewType() {
        return this.mType;
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.Presenter
    public void initJSBridge() {
        this.mJsBridge = new com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeProxy(this.mWebBrowserView.getWebView(), this.mContext, this.mType);
        this.mWebBrowserView.getWebView().setWebChromeClient(new com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.MyWebChromeClient(this.mJsBridge, this.mContext));
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            this.mWebBrowserView.getWebView().removeJavascriptInterface("searchBoxJavaBridge_");
            this.mWebBrowserView.getWebView().removeJavascriptInterface("accessibility");
            this.mWebBrowserView.getWebView().removeJavascriptInterface("accessibilityTraversal");
        }
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.Presenter
    public void initWebViewSettings() {
        com.tencent.smtt.sdk.WebSettings settings = this.mWebBrowserView.getWebView().getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAllowFileAccess(false);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDatabasePath(this.mWebBrowserView.getWebView().getContext().getApplicationContext().getDir("database", 0).getPath());
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setAppCacheMaxSize(8388608L);
        settings.setAppCachePath(this.mWebBrowserView.getWebView().getContext().getApplicationContext().getCacheDir().getAbsolutePath());
        settings.setAppCacheEnabled(true);
        this.mWebBrowserView.getWebView().setWebViewClient(new com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.MyWebViewClient());
        this.mWebBrowserView.getWebView().setDownloadListener(new com.tencent.ysdk.shell.framework.web.browser.WebBrowserPresenter.MyWebViewDownloadListener());
        if (android.os.Build.VERSION.SDK_INT > 19) {
            if (com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.KEY_ICON_WEBVIEW_DEBUG_ENABLD, false)) {
                this.mWebBrowserView.getWebView();
                com.tencent.smtt.sdk.WebView.setWebContentsDebuggingEnabled(true);
                com.tencent.ysdk.shell.framework.verification.UserTips.showIconJSDebug();
            } else {
                this.mWebBrowserView.getWebView();
                com.tencent.smtt.sdk.WebView.setWebContentsDebuggingEnabled(false);
            }
        }
        this.mWebBrowserView.getWebView().getSettings().setCacheMode(-1);
        this.mWebBrowserView.getWebView().getSettings().setAppCacheEnabled(true);
        this.mWebBrowserView.getWebView().getSettings().setAllowFileAccess(true);
        java.lang.String userAgentString = this.mWebBrowserView.getWebView().getSettings().getUserAgentString();
        java.lang.String str = "YSDKVersion/" + com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion() + "/" + URL_USER_AGENT_ICON_VERSION + "/" + com.tencent.ysdk.shell.module.icon.IconApiImpl.getInstance().getIconVersion() + "/" + URL_USER_AGENT_JSBRIDGE_VERSION + "/" + com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeProxy.VERSION_NAME;
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(userAgentString)) {
            str = userAgentString + str;
        }
        this.mWebBrowserView.getWebView().getSettings().setUserAgentString(str);
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.Presenter
    public void loadURL(java.lang.String str) {
        loadURL(str, null);
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.Presenter
    public void loadURL(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map) {
        loadURL(str, map, null);
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.Presenter
    public void loadURL(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map, java.util.HashMap<java.lang.String, java.lang.String> map2) {
        boolean z = !android.text.TextUtils.isEmpty(str) && str.contains("alpha=0");
        if (z) {
            this.mWebBrowserView.setSize(-1.0f, -1.0f);
        }
        this.mWebBrowserView.buildWindow();
        synCookies(this.mWebBrowserView.getWebView().getContext(), str, map);
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDebug()) {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.TAG, str);
        }
        this.mWebBrowserView.setExtraData(map2);
        if (map2 != null && map2.containsKey(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_WEBVIEW_SHOWED_DELAY)) {
            this.mIsShowedDelay = java.lang.Boolean.valueOf(map2.get(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_WEBVIEW_SHOWED_DELAY)).booleanValue();
        }
        this.mWebBrowserView.getWebView().setBackgroundColor(z ? 0 : -1);
        if (this.mType == 8 || this.mIsShowedDelay) {
            this.mWebBrowserView.getView().setVisibility(8);
        }
        this.mWebBrowserView.getWebView().loadUrl(str);
        asyncClearHistory();
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.TAG, "onActivityResult");
        if (i == REQUEST_CODE_FILE_PICKER) {
            try {
                if (i2 == -1) {
                    handleFilePickerSucc(intent);
                } else {
                    handleFilePickerFail();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.Presenter
    public void onBrowserClose() {
        try {
            com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowserManager.destroyByType(this.mType);
            this.mJsBridge.onWebViewClose();
            if (this.listener != null) {
                this.listener.onClose();
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.Presenter
    public void onPause() {
        this.mJsBridge.onPause();
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.Presenter
    public void onResume() {
        this.mJsBridge.onResume();
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.Presenter
    public void regOnBrowserStateChangeListener(com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener onBrowserStateChangeListener) {
        this.listener = onBrowserStateChangeListener;
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.WebBrowserContract.Presenter
    public void removeCookie(android.content.Context context) {
        com.tencent.smtt.sdk.CookieSyncManager.createInstance(context);
        com.tencent.smtt.sdk.CookieManager.getInstance().removeAllCookie();
        com.tencent.smtt.sdk.CookieSyncManager.getInstance().sync();
    }

    @Override // com.tencent.ysdk.shell.framework.mvp.BasePresenter
    public void start() {
        initWebViewSettings();
        initJSBridge();
    }
}
