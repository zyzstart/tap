package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.annotation.SuppressLint({"NewApi", "Override"})
class SystemWebViewClient extends android.webkit.WebViewClient {
    private static java.lang.String c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.smtt.sdk.WebViewClient f843a;
    private com.tencent.smtt.sdk.WebView b;

    private static class a extends com.tencent.smtt.export.external.interfaces.ClientCertRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private android.webkit.ClientCertRequest f846a;

        public a(android.webkit.ClientCertRequest clientCertRequest) {
            this.f846a = clientCertRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void cancel() {
            this.f846a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public java.lang.String getHost() {
            return this.f846a.getHost();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public java.lang.String[] getKeyTypes() {
            return this.f846a.getKeyTypes();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public int getPort() {
            return this.f846a.getPort();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public java.security.Principal[] getPrincipals() {
            return this.f846a.getPrincipals();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void ignore() {
            this.f846a.ignore();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void proceed(java.security.PrivateKey privateKey, java.security.cert.X509Certificate[] x509CertificateArr) {
            this.f846a.proceed(privateKey, x509CertificateArr);
        }
    }

    private static class b implements com.tencent.smtt.export.external.interfaces.HttpAuthHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private android.webkit.HttpAuthHandler f847a;

        b(android.webkit.HttpAuthHandler httpAuthHandler) {
            this.f847a = httpAuthHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void cancel() {
            this.f847a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void proceed(java.lang.String str, java.lang.String str2) {
            this.f847a.proceed(str, str2);
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public boolean useHttpAuthUsernamePassword() {
            return this.f847a.useHttpAuthUsernamePassword();
        }
    }

    private static class c implements com.tencent.smtt.export.external.interfaces.SslErrorHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        android.webkit.SslErrorHandler f848a;

        c(android.webkit.SslErrorHandler sslErrorHandler) {
            this.f848a = sslErrorHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void cancel() {
            this.f848a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void proceed() {
            this.f848a.proceed();
        }
    }

    private static class d implements com.tencent.smtt.export.external.interfaces.SslError {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        android.net.http.SslError f849a;

        d(android.net.http.SslError sslError) {
            this.f849a = sslError;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean addError(int i) {
            return this.f849a.addError(i);
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public android.net.http.SslCertificate getCertificate() {
            return this.f849a.getCertificate();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public int getPrimaryError() {
            return this.f849a.getPrimaryError();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public java.lang.String getUrl() {
            return this.f849a.getUrl();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean hasError(int i) {
            return this.f849a.hasError(i);
        }
    }

    static class e implements com.tencent.smtt.export.external.interfaces.WebResourceRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private java.lang.String f850a;
        private boolean b;
        private boolean c;
        private boolean d;
        private java.lang.String e;
        private java.util.Map f;

        public e(java.lang.String str, boolean z, boolean z2, boolean z3, java.lang.String str2, java.util.Map map) {
            this.f850a = str;
            this.b = z;
            this.c = z2;
            this.d = z3;
            this.e = str2;
            this.f = map;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public java.lang.String getMethod() {
            return this.e;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public java.util.Map getRequestHeaders() {
            return this.f;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public android.net.Uri getUrl() {
            return android.net.Uri.parse(this.f850a);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.d;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.b;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            return this.c;
        }
    }

    private static class f implements com.tencent.smtt.export.external.interfaces.WebResourceRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        android.webkit.WebResourceRequest f851a;

        f(android.webkit.WebResourceRequest webResourceRequest) {
            this.f851a = webResourceRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public java.lang.String getMethod() {
            return this.f851a.getMethod();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public java.util.Map getRequestHeaders() {
            return this.f851a.getRequestHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public android.net.Uri getUrl() {
            return this.f851a.getUrl();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.f851a.hasGesture();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.f851a.isForMainFrame();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                java.lang.Object objA = com.tencent.smtt.utils.k.a(this.f851a, "isRedirect");
                if (objA instanceof java.lang.Boolean) {
                    return ((java.lang.Boolean) objA).booleanValue();
                }
            }
            return false;
        }
    }

    private static class g extends com.tencent.smtt.export.external.interfaces.WebResourceResponse {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        android.webkit.WebResourceResponse f852a;

        public g(android.webkit.WebResourceResponse webResourceResponse) {
            this.f852a = webResourceResponse;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public java.io.InputStream getData() {
            return this.f852a.getData();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public java.lang.String getEncoding() {
            return this.f852a.getEncoding();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public java.lang.String getMimeType() {
            return this.f852a.getMimeType();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public java.lang.String getReasonPhrase() {
            return this.f852a.getReasonPhrase();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public java.util.Map getResponseHeaders() {
            return this.f852a.getResponseHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public int getStatusCode() {
            return this.f852a.getStatusCode();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setData(java.io.InputStream inputStream) {
            this.f852a.setData(inputStream);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setEncoding(java.lang.String str) {
            this.f852a.setEncoding(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setMimeType(java.lang.String str) {
            this.f852a.setMimeType(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setResponseHeaders(java.util.Map map) {
            this.f852a.setResponseHeaders(map);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setStatusCodeAndReasonPhrase(int i, java.lang.String str) {
            this.f852a.setStatusCodeAndReasonPhrase(i, str);
        }
    }

    SystemWebViewClient(com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.sdk.WebViewClient webViewClient) {
        this.b = webView;
        this.f843a = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(android.webkit.WebView webView, java.lang.String str, boolean z) {
        this.b.a(webView);
        this.f843a.doUpdateVisitedHistory(this.b, str, z);
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(android.webkit.WebView webView, android.os.Message message, android.os.Message message2) {
        this.b.a(webView);
        this.f843a.onFormResubmission(this.b, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(android.webkit.WebView webView, java.lang.String str) {
        this.b.a(webView);
        this.f843a.onLoadResource(this.b, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(android.webkit.WebView webView, java.lang.String str) {
        this.b.a(webView);
        this.f843a.onPageCommitVisible(this.b, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(android.webkit.WebView webView, java.lang.String str) throws java.lang.Throwable {
        com.tencent.smtt.utils.o oVarA;
        if (c == null && (oVarA = com.tencent.smtt.utils.o.a()) != null) {
            oVarA.a(true);
            c = java.lang.Boolean.toString(true);
        }
        this.b.a(webView);
        com.tencent.smtt.sdk.WebView webView2 = this.b;
        webView2.f887a++;
        this.f843a.onPageFinished(webView2, str);
        if ("com.qzone".equals(webView.getContext().getApplicationInfo().packageName)) {
            this.b.a(webView.getContext());
        }
        com.tencent.smtt.utils.TbsLog.app_extra("SystemWebViewClient", webView.getContext());
        com.tencent.smtt.sdk.WebView.d();
        if (!com.tencent.smtt.sdk.TbsShareManager.mHasQueryed && this.b.getContext() != null && com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(this.b.getContext())) {
            com.tencent.smtt.sdk.TbsShareManager.mHasQueryed = true;
            new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.tencent.smtt.sdk.TbsShareManager.forceLoadX5FromTBSDemo(com.tencent.smtt.sdk.SystemWebViewClient.this.b.getContext()) || !com.tencent.smtt.sdk.TbsDownloader.needDownload(com.tencent.smtt.sdk.SystemWebViewClient.this.b.getContext(), false)) {
                        return;
                    }
                    com.tencent.smtt.sdk.TbsDownloader.startDownload(com.tencent.smtt.sdk.SystemWebViewClient.this.b.getContext());
                }
            }).start();
        }
        if (this.b.getContext() == null || com.tencent.smtt.sdk.TbsLogReport.getInstance(this.b.getContext()).getShouldUploadEventReport()) {
            return;
        }
        com.tencent.smtt.sdk.TbsLogReport.getInstance(this.b.getContext()).setShouldUploadEventReport(true);
        com.tencent.smtt.sdk.TbsLogReport.getInstance(this.b.getContext()).dailyReport();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
        this.b.a(webView);
        this.f843a.onPageStarted(this.b, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(android.webkit.WebView webView, android.webkit.ClientCertRequest clientCertRequest) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            this.b.a(webView);
            this.f843a.onReceivedClientCertRequest(this.b, new com.tencent.smtt.sdk.SystemWebViewClient.a(clientCertRequest));
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
        this.b.a(webView);
        this.f843a.onReceivedError(this.b, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, final android.webkit.WebResourceError webResourceError) {
        this.b.a(webView);
        this.f843a.onReceivedError(this.b, webResourceRequest != null ? new com.tencent.smtt.sdk.SystemWebViewClient.f(webResourceRequest) : null, webResourceError != null ? new com.tencent.smtt.export.external.interfaces.WebResourceError() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.2
            @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
            public java.lang.CharSequence getDescription() {
                return webResourceError.getDescription();
            }

            @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
            public int getErrorCode() {
                return webResourceError.getErrorCode();
            }
        } : null);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(android.webkit.WebView webView, android.webkit.HttpAuthHandler httpAuthHandler, java.lang.String str, java.lang.String str2) {
        this.b.a(webView);
        this.f843a.onReceivedHttpAuthRequest(this.b, new com.tencent.smtt.sdk.SystemWebViewClient.b(httpAuthHandler), str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
        this.b.a(webView);
        this.f843a.onReceivedHttpError(this.b, new com.tencent.smtt.sdk.SystemWebViewClient.f(webResourceRequest), new com.tencent.smtt.sdk.SystemWebViewClient.g(webResourceResponse));
    }

    @Override // android.webkit.WebViewClient
    @android.annotation.TargetApi(12)
    public void onReceivedLoginRequest(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.os.Build.VERSION.SDK_INT >= 12) {
            this.b.a(webView);
            this.f843a.onReceivedLoginRequest(this.b, str, str2, str3);
        }
    }

    @Override // android.webkit.WebViewClient
    @android.annotation.TargetApi(8)
    public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        if (android.os.Build.VERSION.SDK_INT >= 8) {
            this.b.a(webView);
            this.f843a.onReceivedSslError(this.b, new com.tencent.smtt.sdk.SystemWebViewClient.c(sslErrorHandler), new com.tencent.smtt.sdk.SystemWebViewClient.d(sslError));
        }
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(android.webkit.WebView webView, float f2, float f3) {
        this.b.a(webView);
        this.f843a.onScaleChanged(this.b, f2, f3);
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(android.webkit.WebView webView, android.os.Message message, android.os.Message message2) {
        this.b.a(webView);
        this.f843a.onTooManyRedirects(this.b, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(android.webkit.WebView webView, android.view.KeyEvent keyEvent) {
        this.b.a(webView);
        this.f843a.onUnhandledKeyEvent(this.b, keyEvent);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0022  */
    @Override // android.webkit.WebViewClient
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        boolean zBooleanValue;
        int i = android.os.Build.VERSION.SDK_INT;
        if (i < 21 || webResourceRequest == null) {
            return null;
        }
        if (i >= 24) {
            java.lang.Object objA = com.tencent.smtt.utils.k.a(webResourceRequest, "isRedirect");
            if (objA instanceof java.lang.Boolean) {
                zBooleanValue = ((java.lang.Boolean) objA).booleanValue();
            } else {
                zBooleanValue = false;
            }
        } else {
            zBooleanValue = false;
        }
        com.tencent.smtt.export.external.interfaces.WebResourceResponse webResourceResponseShouldInterceptRequest = this.f843a.shouldInterceptRequest(this.b, new com.tencent.smtt.sdk.SystemWebViewClient.e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), zBooleanValue, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
        if (webResourceResponseShouldInterceptRequest == null) {
            return null;
        }
        android.webkit.WebResourceResponse webResourceResponse = new android.webkit.WebResourceResponse(webResourceResponseShouldInterceptRequest.getMimeType(), webResourceResponseShouldInterceptRequest.getEncoding(), webResourceResponseShouldInterceptRequest.getData());
        webResourceResponse.setResponseHeaders(webResourceResponseShouldInterceptRequest.getResponseHeaders());
        int statusCode = webResourceResponseShouldInterceptRequest.getStatusCode();
        java.lang.String reasonPhrase = webResourceResponseShouldInterceptRequest.getReasonPhrase();
        if (statusCode != webResourceResponse.getStatusCode() || (reasonPhrase != null && !reasonPhrase.equals(webResourceResponse.getReasonPhrase()))) {
            webResourceResponse.setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
        }
        return webResourceResponse;
    }

    @Override // android.webkit.WebViewClient
    @android.annotation.TargetApi(11)
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, java.lang.String str) {
        com.tencent.smtt.export.external.interfaces.WebResourceResponse webResourceResponseShouldInterceptRequest;
        if (android.os.Build.VERSION.SDK_INT >= 11 && (webResourceResponseShouldInterceptRequest = this.f843a.shouldInterceptRequest(this.b, str)) != null) {
            return new android.webkit.WebResourceResponse(webResourceResponseShouldInterceptRequest.getMimeType(), webResourceResponseShouldInterceptRequest.getEncoding(), webResourceResponseShouldInterceptRequest.getData());
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(android.webkit.WebView webView, android.view.KeyEvent keyEvent) {
        this.b.a(webView);
        return this.f843a.shouldOverrideKeyEvent(this.b, keyEvent);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003b  */
    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        boolean zBooleanValue;
        java.lang.String string = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
        if (string == null || this.b.showDebugView(string)) {
            return true;
        }
        this.b.a(webView);
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            java.lang.Object objA = com.tencent.smtt.utils.k.a(webResourceRequest, "isRedirect");
            if (objA instanceof java.lang.Boolean) {
                zBooleanValue = ((java.lang.Boolean) objA).booleanValue();
            } else {
                zBooleanValue = false;
            }
        } else {
            zBooleanValue = false;
        }
        return this.f843a.shouldOverrideUrlLoading(this.b, new com.tencent.smtt.sdk.SystemWebViewClient.e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), zBooleanValue, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
        if (str == null || this.b.showDebugView(str)) {
            return true;
        }
        this.b.a(webView);
        return this.f843a.shouldOverrideUrlLoading(this.b, str);
    }
}
