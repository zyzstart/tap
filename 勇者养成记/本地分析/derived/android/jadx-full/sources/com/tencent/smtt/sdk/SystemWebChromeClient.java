package com.tencent.smtt.sdk;

import com.tencent.smtt.sdk.WebView.WebViewTransport;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class SystemWebChromeClient extends android.webkit.WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.smtt.sdk.WebView f829a;
    private com.tencent.smtt.sdk.WebChromeClient b;

    private static class a implements com.tencent.smtt.export.external.interfaces.ConsoleMessage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel f837a;
        private java.lang.String b;
        private java.lang.String c;
        private int d;

        a(android.webkit.ConsoleMessage consoleMessage) {
            this.f837a = com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel.valueOf(consoleMessage.messageLevel().name());
            this.b = consoleMessage.message();
            this.c = consoleMessage.sourceId();
            this.d = consoleMessage.lineNumber();
        }

        a(java.lang.String str, java.lang.String str2, int i) {
            this.f837a = com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel.LOG;
            this.b = str;
            this.c = str2;
            this.d = i;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public int lineNumber() {
            return this.d;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public java.lang.String message() {
            return this.b;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel messageLevel() {
            return this.f837a;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public java.lang.String sourceId() {
            return this.c;
        }
    }

    class b implements com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        android.webkit.WebChromeClient.CustomViewCallback f838a;

        b(android.webkit.WebChromeClient.CustomViewCallback customViewCallback) {
            this.f838a = customViewCallback;
        }

        @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback
        public void onCustomViewHidden() {
            this.f838a.onCustomViewHidden();
        }
    }

    class c implements com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        android.webkit.GeolocationPermissions.Callback f839a;

        c(android.webkit.GeolocationPermissions.Callback callback) {
            this.f839a = callback;
        }

        @Override // com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback
        public void invoke(java.lang.String str, boolean z, boolean z2) {
            this.f839a.invoke(str, z, z2);
        }
    }

    private class d implements com.tencent.smtt.export.external.interfaces.JsPromptResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        android.webkit.JsPromptResult f840a;

        d(android.webkit.JsPromptResult jsPromptResult) {
            this.f840a = jsPromptResult;
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void cancel() {
            this.f840a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void confirm() {
            this.f840a.confirm();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsPromptResult
        public void confirm(java.lang.String str) {
            this.f840a.confirm(str);
        }
    }

    private class e implements com.tencent.smtt.export.external.interfaces.JsResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        android.webkit.JsResult f841a;

        e(android.webkit.JsResult jsResult) {
            this.f841a = jsResult;
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void cancel() {
            this.f841a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void confirm() {
            this.f841a.confirm();
        }
    }

    class f implements com.tencent.smtt.sdk.WebStorage.QuotaUpdater {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        android.webkit.WebStorage.QuotaUpdater f842a;

        f(android.webkit.WebStorage.QuotaUpdater quotaUpdater) {
            this.f842a = quotaUpdater;
        }

        @Override // com.tencent.smtt.sdk.WebStorage.QuotaUpdater
        public void updateQuota(long j) {
            this.f842a.updateQuota(j);
        }
    }

    SystemWebChromeClient(com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.sdk.WebChromeClient webChromeClient) {
        this.f829a = webView;
        this.b = webChromeClient;
    }

    @Override // android.webkit.WebChromeClient
    @android.annotation.TargetApi(7)
    public android.graphics.Bitmap getDefaultVideoPoster() {
        android.graphics.Bitmap defaultVideoPoster = this.b.getDefaultVideoPoster();
        if (defaultVideoPoster != null) {
            return defaultVideoPoster;
        }
        try {
            return android.os.Build.VERSION.SDK_INT >= 24 ? android.graphics.BitmapFactory.decodeResource(this.f829a.getResources(), android.R.drawable.ic_media_play) : defaultVideoPoster;
        } catch (java.lang.Exception unused) {
            return defaultVideoPoster;
        }
    }

    @Override // android.webkit.WebChromeClient
    @android.annotation.TargetApi(7)
    public android.view.View getVideoLoadingProgressView() {
        return this.b.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(final android.webkit.ValueCallback valueCallback) {
        this.b.getVisitedHistory(new com.tencent.smtt.sdk.ValueCallback() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.1
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(java.lang.String[] strArr) {
                valueCallback.onReceiveValue(strArr);
            }
        });
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(android.webkit.WebView webView) {
        this.f829a.a(webView);
        this.b.onCloseWindow(this.f829a);
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(java.lang.String str, int i, java.lang.String str2) {
        this.b.onConsoleMessage(new com.tencent.smtt.sdk.SystemWebChromeClient.a(str, str2, i));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
        return this.b.onConsoleMessage(new com.tencent.smtt.sdk.SystemWebChromeClient.a(consoleMessage));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(android.webkit.WebView webView, boolean z, boolean z2, final android.os.Message message) {
        com.tencent.smtt.sdk.WebView webView2 = this.f829a;
        webView2.getClass();
        final com.tencent.smtt.sdk.WebView.WebViewTransport webViewTransport = webView2.new WebViewTransport();
        android.os.Message messageObtain = android.os.Message.obtain(message.getTarget(), new java.lang.Runnable() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.2
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.smtt.sdk.WebView webView3 = webViewTransport.getWebView();
                if (webView3 != null) {
                    ((android.webkit.WebView.WebViewTransport) message.obj).setWebView(webView3.b());
                }
                message.sendToTarget();
            }
        });
        messageObtain.obj = webViewTransport;
        return this.b.onCreateWindow(this.f829a, z, z2, messageObtain);
    }

    @Override // android.webkit.WebChromeClient
    @android.annotation.TargetApi(5)
    @java.lang.Deprecated
    public void onExceededDatabaseQuota(java.lang.String str, java.lang.String str2, long j, long j2, long j3, android.webkit.WebStorage.QuotaUpdater quotaUpdater) {
        this.b.onExceededDatabaseQuota(str, str2, j, j2, j3, new com.tencent.smtt.sdk.SystemWebChromeClient.f(quotaUpdater));
    }

    @Override // android.webkit.WebChromeClient
    @android.annotation.TargetApi(5)
    public void onGeolocationPermissionsHidePrompt() {
        this.b.onGeolocationPermissionsHidePrompt();
    }

    @Override // android.webkit.WebChromeClient
    @android.annotation.TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(java.lang.String str, android.webkit.GeolocationPermissions.Callback callback) {
        this.b.onGeolocationPermissionsShowPrompt(str, new com.tencent.smtt.sdk.SystemWebChromeClient.c(callback));
    }

    @Override // android.webkit.WebChromeClient
    @android.annotation.TargetApi(7)
    public void onHideCustomView() {
        this.b.onHideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, android.webkit.JsResult jsResult) {
        this.f829a.a(webView);
        return this.b.onJsAlert(this.f829a, str, str2, new com.tencent.smtt.sdk.SystemWebChromeClient.e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, android.webkit.JsResult jsResult) {
        this.f829a.a(webView);
        return this.b.onJsBeforeUnload(this.f829a, str, str2, new com.tencent.smtt.sdk.SystemWebChromeClient.e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, android.webkit.JsResult jsResult) {
        this.f829a.a(webView);
        return this.b.onJsConfirm(this.f829a, str, str2, new com.tencent.smtt.sdk.SystemWebChromeClient.e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, java.lang.String str3, android.webkit.JsPromptResult jsPromptResult) {
        this.f829a.a(webView);
        return this.b.onJsPrompt(this.f829a, str, str2, str3, new com.tencent.smtt.sdk.SystemWebChromeClient.d(jsPromptResult));
    }

    @Override // android.webkit.WebChromeClient
    @android.annotation.TargetApi(7)
    public boolean onJsTimeout() {
        return this.b.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(final android.webkit.PermissionRequest permissionRequest) {
        this.b.onPermissionRequest(new com.tencent.smtt.export.external.interfaces.PermissionRequest() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.6
            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public void deny() {
                if (android.os.Build.VERSION.SDK_INT >= 21) {
                    permissionRequest.deny();
                }
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public android.net.Uri getOrigin() {
                if (android.os.Build.VERSION.SDK_INT >= 21) {
                    return permissionRequest.getOrigin();
                }
                return null;
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public java.lang.String[] getResources() {
                return android.os.Build.VERSION.SDK_INT >= 21 ? permissionRequest.getResources() : new java.lang.String[0];
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public void grant(java.lang.String[] strArr) {
                if (android.os.Build.VERSION.SDK_INT >= 21) {
                    permissionRequest.grant(strArr);
                }
            }
        });
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(final android.webkit.PermissionRequest permissionRequest) {
        this.b.onPermissionRequestCanceled(new com.tencent.smtt.export.external.interfaces.PermissionRequest() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.7
            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public void deny() {
                if (android.os.Build.VERSION.SDK_INT >= 21) {
                    permissionRequest.deny();
                }
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public android.net.Uri getOrigin() {
                if (android.os.Build.VERSION.SDK_INT >= 21) {
                    return permissionRequest.getOrigin();
                }
                return null;
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public java.lang.String[] getResources() {
                return android.os.Build.VERSION.SDK_INT >= 21 ? permissionRequest.getResources() : new java.lang.String[0];
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public void grant(java.lang.String[] strArr) {
                if (android.os.Build.VERSION.SDK_INT >= 21) {
                    permissionRequest.grant(strArr);
                }
            }
        });
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(android.webkit.WebView webView, int i) {
        this.f829a.a(webView);
        this.b.onProgressChanged(this.f829a, i);
    }

    @android.annotation.TargetApi(7)
    @java.lang.Deprecated
    public void onReachedMaxAppCacheSize(long j, long j2, android.webkit.WebStorage.QuotaUpdater quotaUpdater) {
        this.b.onReachedMaxAppCacheSize(j, j2, new com.tencent.smtt.sdk.SystemWebChromeClient.f(quotaUpdater));
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(android.webkit.WebView webView, android.graphics.Bitmap bitmap) {
        this.f829a.a(webView);
        this.b.onReceivedIcon(this.f829a, bitmap);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(android.webkit.WebView webView, java.lang.String str) {
        this.f829a.a(webView);
        this.b.onReceivedTitle(this.f829a, str);
    }

    @Override // android.webkit.WebChromeClient
    @android.annotation.TargetApi(7)
    public void onReceivedTouchIconUrl(android.webkit.WebView webView, java.lang.String str, boolean z) {
        this.f829a.a(webView);
        this.b.onReceivedTouchIconUrl(this.f829a, str, z);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(android.webkit.WebView webView) {
        this.f829a.a(webView);
        this.b.onRequestFocus(this.f829a);
    }

    @Override // android.webkit.WebChromeClient
    @android.annotation.TargetApi(14)
    @java.lang.Deprecated
    public void onShowCustomView(android.view.View view, int i, android.webkit.WebChromeClient.CustomViewCallback customViewCallback) {
        this.b.onShowCustomView(view, i, new com.tencent.smtt.sdk.SystemWebChromeClient.b(customViewCallback));
    }

    @Override // android.webkit.WebChromeClient
    @android.annotation.TargetApi(7)
    public void onShowCustomView(android.view.View view, android.webkit.WebChromeClient.CustomViewCallback customViewCallback) {
        this.b.onShowCustomView(view, new com.tencent.smtt.sdk.SystemWebChromeClient.b(customViewCallback));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(android.webkit.WebView webView, final android.webkit.ValueCallback valueCallback, final android.webkit.WebChromeClient.FileChooserParams fileChooserParams) {
        com.tencent.smtt.sdk.ValueCallback valueCallback2 = new com.tencent.smtt.sdk.ValueCallback() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.4
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(android.net.Uri[] uriArr) {
                valueCallback.onReceiveValue(uriArr);
            }
        };
        com.tencent.smtt.sdk.WebChromeClient.FileChooserParams fileChooserParams2 = new com.tencent.smtt.sdk.WebChromeClient.FileChooserParams() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.5
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
        this.f829a.a(webView);
        return this.b.onShowFileChooser(this.f829a, valueCallback2, fileChooserParams2);
    }

    public void openFileChooser(android.webkit.ValueCallback valueCallback) {
        openFileChooser(valueCallback, null, null);
    }

    public void openFileChooser(android.webkit.ValueCallback valueCallback, java.lang.String str) {
        openFileChooser(valueCallback, str, null);
    }

    public void openFileChooser(final android.webkit.ValueCallback valueCallback, java.lang.String str, java.lang.String str2) {
        this.b.openFileChooser(new com.tencent.smtt.sdk.ValueCallback() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.3
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(android.net.Uri uri) {
                valueCallback.onReceiveValue(uri);
            }
        }, str, str2);
    }

    public void setupAutoFill(android.os.Message message) {
    }
}
