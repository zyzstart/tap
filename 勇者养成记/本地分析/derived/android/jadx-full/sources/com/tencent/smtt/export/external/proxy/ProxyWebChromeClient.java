package com.tencent.smtt.export.external.proxy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ProxyWebChromeClient implements com.tencent.smtt.export.external.interfaces.IX5WebChromeClient {
    protected com.tencent.smtt.export.external.interfaces.IX5WebChromeClient mWebChromeClient;

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public android.graphics.Bitmap getDefaultVideoPoster() {
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void getVisitedHistory(android.webkit.ValueCallback valueCallback) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.getVisitedHistory(valueCallback);
        }
    }

    public com.tencent.smtt.export.external.interfaces.IX5WebChromeClient getmWebChromeClient() {
        return this.mWebChromeClient;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onCloseWindow(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.onCloseWindow(iX5WebViewBase);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onConsoleMessage(java.lang.String str, int i, java.lang.String str2) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.onConsoleMessage(str, i, str2);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onConsoleMessage(com.tencent.smtt.export.external.interfaces.ConsoleMessage consoleMessage) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            return iX5WebChromeClient.onConsoleMessage(consoleMessage);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onCreateWindow(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, boolean z, boolean z2, android.os.Message message) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            return iX5WebChromeClient.onCreateWindow(iX5WebViewBase, z, z2, message);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onExceededDatabaseQuota(java.lang.String str, java.lang.String str2, long j, long j2, long j3, com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.onGeolocationPermissionsHidePrompt();
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationPermissionsShowPrompt(java.lang.String str, com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback geolocationPermissionsCallback) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationStartUpdating(android.webkit.ValueCallback valueCallback, android.webkit.ValueCallback valueCallback2) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.onGeolocationStartUpdating(valueCallback, valueCallback2);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationStopUpdating() {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.onGeolocationStopUpdating();
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onHideCustomView() {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.onHideCustomView();
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsAlert(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            return iX5WebChromeClient.onJsAlert(iX5WebViewBase, str, str2, jsResult);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsBeforeUnload(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            return iX5WebChromeClient.onJsBeforeUnload(iX5WebViewBase, str, str2, jsResult);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsConfirm(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            return iX5WebChromeClient.onJsConfirm(iX5WebViewBase, str, str2, jsResult);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsPrompt(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.smtt.export.external.interfaces.JsPromptResult jsPromptResult) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            return iX5WebChromeClient.onJsPrompt(iX5WebViewBase, str, str2, str3, jsPromptResult);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsTimeout() {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            return iX5WebChromeClient.onJsTimeout();
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onProgressChanged(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, int i) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.onProgressChanged(iX5WebViewBase, i);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedIcon(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.graphics.Bitmap bitmap) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.onReceivedIcon(iX5WebViewBase, bitmap);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedTitle(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.onReceivedTitle(iX5WebViewBase, str);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedTouchIconUrl(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, boolean z) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.onReceivedTouchIconUrl(iX5WebViewBase, str, z);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onRequestFocus(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.onRequestFocus(iX5WebViewBase);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onShowCustomView(android.view.View view, int i, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback customViewCallback) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.onShowCustomView(view, customViewCallback);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onShowCustomView(android.view.View view, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback customViewCallback) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.onShowCustomView(view, customViewCallback);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onShowFileChooser(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.webkit.ValueCallback valueCallback, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams fileChooserParams) {
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void openFileChooser(android.webkit.ValueCallback valueCallback, java.lang.String str, java.lang.String str2, boolean z) {
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient = this.mWebChromeClient;
        if (iX5WebChromeClient != null) {
            iX5WebChromeClient.openFileChooser(valueCallback, str, str2, z);
        }
    }

    public void setWebChromeClient(com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient) {
        this.mWebChromeClient = iX5WebChromeClient;
    }
}
