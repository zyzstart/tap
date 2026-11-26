package com.tencent.smtt.sdk;

import com.tencent.smtt.sdk.WebView.WebViewTransport;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class f extends com.tencent.smtt.export.external.proxy.X5ProxyWebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.smtt.sdk.WebView f920a;
    private com.tencent.smtt.sdk.WebChromeClient b;

    class a implements com.tencent.smtt.sdk.WebStorage.QuotaUpdater {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.tencent.smtt.export.external.interfaces.QuotaUpdater f925a;

        a(com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
            this.f925a = quotaUpdater;
        }

        @Override // com.tencent.smtt.sdk.WebStorage.QuotaUpdater
        public void updateQuota(long j) {
            this.f925a.updateQuota(j);
        }
    }

    public f(com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient, com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.sdk.WebChromeClient webChromeClient) {
        super(iX5WebChromeClient);
        this.f920a = webView;
        this.b = webChromeClient;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public android.graphics.Bitmap getDefaultVideoPoster() {
        return this.b.getDefaultVideoPoster();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void getVisitedHistory(android.webkit.ValueCallback valueCallback) {
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onCloseWindow(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase) {
        this.f920a.a(iX5WebViewBase);
        this.b.onCloseWindow(this.f920a);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onConsoleMessage(java.lang.String str, int i, java.lang.String str2) {
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onConsoleMessage(com.tencent.smtt.export.external.interfaces.ConsoleMessage consoleMessage) {
        return this.b.onConsoleMessage(consoleMessage);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onCreateWindow(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, boolean z, boolean z2, final android.os.Message message) {
        com.tencent.smtt.sdk.WebView webView = this.f920a;
        webView.getClass();
        final com.tencent.smtt.sdk.WebView.WebViewTransport webViewTransport = webView.new WebViewTransport();
        android.os.Message messageObtain = android.os.Message.obtain(message.getTarget(), new java.lang.Runnable() { // from class: com.tencent.smtt.sdk.f.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.smtt.sdk.WebView webView2 = webViewTransport.getWebView();
                if (webView2 != null) {
                    ((com.tencent.smtt.export.external.interfaces.IX5WebViewBase.WebViewTransport) message.obj).setWebView(webView2.c());
                }
                message.sendToTarget();
            }
        });
        messageObtain.obj = webViewTransport;
        return this.b.onCreateWindow(this.f920a, z, z2, messageObtain);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onExceededDatabaseQuota(java.lang.String str, java.lang.String str2, long j, long j2, long j3, com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
        this.b.onExceededDatabaseQuota(str, str2, j, j2, j3, new com.tencent.smtt.sdk.f.a(quotaUpdater));
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        this.b.onGeolocationPermissionsHidePrompt();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationPermissionsShowPrompt(java.lang.String str, com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback geolocationPermissionsCallback) {
        this.b.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onHideCustomView() {
        this.b.onHideCustomView();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsAlert(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult) {
        this.f920a.a(iX5WebViewBase);
        return this.b.onJsAlert(this.f920a, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsBeforeUnload(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult) {
        this.f920a.a(iX5WebViewBase);
        return this.b.onJsBeforeUnload(this.f920a, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsConfirm(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult) {
        this.f920a.a(iX5WebViewBase);
        return this.b.onJsConfirm(this.f920a, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsPrompt(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.smtt.export.external.interfaces.JsPromptResult jsPromptResult) {
        this.f920a.a(iX5WebViewBase);
        return this.b.onJsPrompt(this.f920a, str, str2, str3, jsPromptResult);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsTimeout() {
        return this.b.onJsTimeout();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onProgressChanged(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, int i) {
        this.f920a.a(iX5WebViewBase);
        this.b.onProgressChanged(this.f920a, i);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
        this.b.onReachedMaxAppCacheSize(j, j2, new com.tencent.smtt.sdk.f.a(quotaUpdater));
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedIcon(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.graphics.Bitmap bitmap) {
        this.f920a.a(iX5WebViewBase);
        this.b.onReceivedIcon(this.f920a, bitmap);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedTitle(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str) {
        this.f920a.a(iX5WebViewBase);
        this.b.onReceivedTitle(this.f920a, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedTouchIconUrl(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, boolean z) {
        this.f920a.a(iX5WebViewBase);
        this.b.onReceivedTouchIconUrl(this.f920a, str, z);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onRequestFocus(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase) {
        this.f920a.a(iX5WebViewBase);
        this.b.onRequestFocus(this.f920a);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onShowCustomView(android.view.View view, int i, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback customViewCallback) {
        this.b.onShowCustomView(view, i, customViewCallback);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onShowCustomView(android.view.View view, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback customViewCallback) {
        this.b.onShowCustomView(view, customViewCallback);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onShowFileChooser(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, final android.webkit.ValueCallback valueCallback, final com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams fileChooserParams) {
        com.tencent.smtt.sdk.ValueCallback valueCallback2 = new com.tencent.smtt.sdk.ValueCallback() { // from class: com.tencent.smtt.sdk.f.3
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(android.net.Uri[] uriArr) {
                valueCallback.onReceiveValue(uriArr);
            }
        };
        com.tencent.smtt.sdk.WebChromeClient.FileChooserParams fileChooserParams2 = new com.tencent.smtt.sdk.WebChromeClient.FileChooserParams() { // from class: com.tencent.smtt.sdk.f.4
            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public android.content.Intent createIntent() {
                return fileChooserParams.createIntent();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public java.lang.String[] getAcceptTypes() {
                return fileChooserParams.getAcceptTypes();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public java.lang.String getFilenameHint() {
                return fileChooserParams.getFilenameHint();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public int getMode() {
                return fileChooserParams.getMode();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public java.lang.CharSequence getTitle() {
                return fileChooserParams.getTitle();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public boolean isCaptureEnabled() {
                return fileChooserParams.isCaptureEnabled();
            }
        };
        this.f920a.a(iX5WebViewBase);
        return this.b.onShowFileChooser(this.f920a, valueCallback2, fileChooserParams2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void openFileChooser(final android.webkit.ValueCallback valueCallback, java.lang.String str, java.lang.String str2, boolean z) {
        this.b.openFileChooser(new com.tencent.smtt.sdk.ValueCallback() { // from class: com.tencent.smtt.sdk.f.2
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(android.net.Uri uri) {
                valueCallback.onReceiveValue(new android.net.Uri[]{uri});
            }
        }, str, str2);
    }
}
