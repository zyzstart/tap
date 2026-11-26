package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class g extends com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient {
    private static java.lang.String c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.smtt.sdk.WebViewClient f926a;
    private com.tencent.smtt.sdk.WebView b;

    public g(com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient, com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.sdk.WebViewClient webViewClient) {
        super(iX5WebViewClient);
        this.b = webView;
        this.f926a = webViewClient;
        webViewClient.f898a = this;
    }

    public void a(com.tencent.smtt.sdk.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
        super.onPageStarted(this.b.c(), 0, 0, str, bitmap);
    }

    public void a(java.lang.String str) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.DIAL", android.net.Uri.parse(str));
        intent.addFlags(268435456);
        try {
            if (this.b.getContext() != null) {
                this.b.getContext().startActivity(intent);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void countPVContentCacheCallBack(java.lang.String str) {
        this.b.f887a++;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void doUpdateVisitedHistory(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, boolean z) {
        this.b.a(iX5WebViewBase);
        this.f926a.doUpdateVisitedHistory(this.b, str, z);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onDetectedBlankScreen(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, int i) {
        this.b.a(iX5WebViewBase);
        this.f926a.onDetectedBlankScreen(str, i);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onFormResubmission(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.os.Message message, android.os.Message message2) {
        this.b.a(iX5WebViewBase);
        this.f926a.onFormResubmission(this.b, message, message2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onLoadResource(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str) {
        this.b.a(iX5WebViewBase);
        this.f926a.onLoadResource(this.b, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageCommitVisible(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str) {
        this.b.a(iX5WebViewBase);
        this.f926a.onPageCommitVisible(this.b, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageFinished(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, int i, int i2, java.lang.String str) throws java.lang.Throwable {
        com.tencent.smtt.utils.o oVarA;
        if (c == null && (oVarA = com.tencent.smtt.utils.o.a()) != null) {
            oVarA.a(false);
            c = java.lang.Boolean.toString(false);
        }
        this.b.a(iX5WebViewBase);
        com.tencent.smtt.sdk.WebView webView = this.b;
        webView.f887a++;
        this.f926a.onPageFinished(webView, str);
        if ("com.qzone".equals(iX5WebViewBase.getView().getContext().getApplicationInfo().packageName)) {
            this.b.a(iX5WebViewBase.getView().getContext());
        }
        com.tencent.smtt.utils.TbsLog.app_extra("SmttWebViewClient", iX5WebViewBase.getView().getContext());
        try {
            super.onPageFinished(iX5WebViewBase, i, i2, str);
        } catch (java.lang.Exception unused) {
        }
        com.tencent.smtt.sdk.WebView.d();
        if (!com.tencent.smtt.sdk.TbsShareManager.mHasQueryed && this.b.getContext() != null && com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(this.b.getContext())) {
            com.tencent.smtt.sdk.TbsShareManager.mHasQueryed = true;
            new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.smtt.sdk.g.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.tencent.smtt.sdk.TbsShareManager.forceLoadX5FromTBSDemo(com.tencent.smtt.sdk.g.this.b.getContext()) || !com.tencent.smtt.sdk.TbsDownloader.needDownload(com.tencent.smtt.sdk.g.this.b.getContext(), false)) {
                        return;
                    }
                    com.tencent.smtt.sdk.TbsDownloader.startDownload(com.tencent.smtt.sdk.g.this.b.getContext());
                }
            }).start();
        }
        if (this.b.getContext() == null || com.tencent.smtt.sdk.TbsLogReport.getInstance(this.b.getContext()).getShouldUploadEventReport()) {
            return;
        }
        com.tencent.smtt.sdk.TbsLogReport.getInstance(this.b.getContext()).setShouldUploadEventReport(true);
        com.tencent.smtt.sdk.TbsLogReport.getInstance(this.b.getContext()).dailyReport();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageFinished(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str) throws java.lang.Throwable {
        onPageFinished(iX5WebViewBase, 0, 0, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageStarted(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, int i, int i2, java.lang.String str, android.graphics.Bitmap bitmap) {
        this.b.a(iX5WebViewBase);
        this.f926a.onPageStarted(this.b, str, bitmap);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageStarted(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, android.graphics.Bitmap bitmap) {
        onPageStarted(iX5WebViewBase, 0, 0, str, bitmap);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedClientCertRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.ClientCertRequest clientCertRequest) {
        this.b.a(iX5WebViewBase);
        this.f926a.onReceivedClientCertRequest(this.b, clientCertRequest);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedError(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, int i, java.lang.String str, java.lang.String str2) {
        if (i < -15) {
            if (i != -17) {
                return;
            } else {
                i = -1;
            }
        }
        this.b.a(iX5WebViewBase);
        this.f926a.onReceivedError(this.b, i, str, str2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedError(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest, com.tencent.smtt.export.external.interfaces.WebResourceError webResourceError) {
        this.b.a(iX5WebViewBase);
        this.f926a.onReceivedError(this.b, webResourceRequest, webResourceError);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedHttpAuthRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.HttpAuthHandler httpAuthHandler, java.lang.String str, java.lang.String str2) {
        this.b.a(iX5WebViewBase);
        this.f926a.onReceivedHttpAuthRequest(this.b, httpAuthHandler, str, str2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedHttpError(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest, com.tencent.smtt.export.external.interfaces.WebResourceResponse webResourceResponse) {
        this.b.a(iX5WebViewBase);
        this.f926a.onReceivedHttpError(this.b, webResourceRequest, webResourceResponse);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedLoginRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.b.a(iX5WebViewBase);
        this.f926a.onReceivedLoginRequest(this.b, str, str2, str3);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedSslError(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.SslErrorHandler sslErrorHandler, com.tencent.smtt.export.external.interfaces.SslError sslError) {
        this.b.a(iX5WebViewBase);
        this.f926a.onReceivedSslError(this.b, sslErrorHandler, sslError);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onScaleChanged(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, float f, float f2) {
        this.b.a(iX5WebViewBase);
        this.f926a.onScaleChanged(this.b, f, f2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onTooManyRedirects(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.os.Message message, android.os.Message message2) {
        this.b.a(iX5WebViewBase);
        this.f926a.onTooManyRedirects(this.b, message, message2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onUnhandledKeyEvent(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.view.KeyEvent keyEvent) {
        this.b.a(iX5WebViewBase);
        this.f926a.onUnhandledKeyEvent(this.b, keyEvent);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest) {
        this.b.a(iX5WebViewBase);
        return this.f926a.shouldInterceptRequest(this.b, webResourceRequest);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest, android.os.Bundle bundle) {
        this.b.a(iX5WebViewBase);
        return this.f926a.shouldInterceptRequest(this.b, webResourceRequest, bundle);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str) {
        this.b.a(iX5WebViewBase);
        return this.f926a.shouldInterceptRequest(this.b, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideKeyEvent(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.view.KeyEvent keyEvent) {
        this.b.a(iX5WebViewBase);
        return this.f926a.shouldOverrideKeyEvent(this.b, keyEvent);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideUrlLoading(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest) {
        java.lang.String string = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
        if (string == null || this.b.showDebugView(string)) {
            return true;
        }
        this.b.a(iX5WebViewBase);
        boolean zShouldOverrideUrlLoading = this.f926a.shouldOverrideUrlLoading(this.b, webResourceRequest);
        if (!zShouldOverrideUrlLoading) {
            if (string.startsWith("wtai://wp/mc;")) {
                this.b.getContext().startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(com.tencent.smtt.sdk.WebView.SCHEME_TEL + string.substring(13))));
                return true;
            }
            if (string.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_TEL)) {
                a(string);
                return true;
            }
        }
        return zShouldOverrideUrlLoading;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideUrlLoading(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str) {
        if (str == null || this.b.showDebugView(str)) {
            return true;
        }
        this.b.a(iX5WebViewBase);
        boolean zShouldOverrideUrlLoading = this.f926a.shouldOverrideUrlLoading(this.b, str);
        if (!zShouldOverrideUrlLoading) {
            if (str.startsWith("wtai://wp/mc;")) {
                this.b.getContext().startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(com.tencent.smtt.sdk.WebView.SCHEME_TEL + str.substring(13))));
                return true;
            }
            if (str.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_TEL)) {
                a(str);
                return true;
            }
        }
        return zShouldOverrideUrlLoading;
    }
}
