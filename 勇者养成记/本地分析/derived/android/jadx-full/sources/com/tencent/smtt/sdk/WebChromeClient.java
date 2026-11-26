package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WebChromeClient {

    public static abstract class FileChooserParams {
        public static final int MODE_OPEN = 0;
        public static final int MODE_OPEN_FOLDER = 2;
        public static final int MODE_OPEN_MULTIPLE = 1;
        public static final int MODE_SAVE = 3;

        public static android.net.Uri[] parseResult(int i, android.content.Intent intent) {
            try {
                com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
                if (uVarA != null && uVarA.b()) {
                    return uVarA.c().a(i, intent);
                }
                if (android.os.Build.VERSION.SDK_INT >= 21) {
                    return android.webkit.WebChromeClient.FileChooserParams.parseResult(i, intent);
                }
                return null;
            } catch (java.lang.Exception e) {
                com.tencent.smtt.utils.TbsLog.i("WebChromeClient", "parseResult:" + e.toString());
                return null;
            }
        }

        public abstract android.content.Intent createIntent();

        public abstract java.lang.String[] getAcceptTypes();

        public abstract java.lang.String getFilenameHint();

        public abstract int getMode();

        public abstract java.lang.CharSequence getTitle();

        public abstract boolean isCaptureEnabled();
    }

    public android.graphics.Bitmap getDefaultVideoPoster() {
        return null;
    }

    public android.view.View getVideoLoadingProgressView() {
        return null;
    }

    public void getVisitedHistory(com.tencent.smtt.sdk.ValueCallback valueCallback) {
    }

    public void onCloseWindow(com.tencent.smtt.sdk.WebView webView) {
    }

    public boolean onConsoleMessage(com.tencent.smtt.export.external.interfaces.ConsoleMessage consoleMessage) {
        return false;
    }

    public boolean onCreateWindow(com.tencent.smtt.sdk.WebView webView, boolean z, boolean z2, android.os.Message message) {
        return false;
    }

    public void onExceededDatabaseQuota(java.lang.String str, java.lang.String str2, long j, long j2, long j3, com.tencent.smtt.sdk.WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(j2);
    }

    public void onGeolocationPermissionsHidePrompt() {
    }

    public void onGeolocationPermissionsShowPrompt(java.lang.String str, com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback geolocationPermissionsCallback) {
        geolocationPermissionsCallback.invoke(str, true, true);
    }

    public void onHideCustomView() {
    }

    public boolean onJsAlert(com.tencent.smtt.sdk.WebView webView, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult) {
        return false;
    }

    public boolean onJsBeforeUnload(com.tencent.smtt.sdk.WebView webView, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult) {
        return false;
    }

    public boolean onJsConfirm(com.tencent.smtt.sdk.WebView webView, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult) {
        return false;
    }

    public boolean onJsPrompt(com.tencent.smtt.sdk.WebView webView, java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.smtt.export.external.interfaces.JsPromptResult jsPromptResult) {
        return false;
    }

    public boolean onJsTimeout() {
        return true;
    }

    public void onPermissionRequest(com.tencent.smtt.export.external.interfaces.PermissionRequest permissionRequest) {
    }

    public void onPermissionRequestCanceled(com.tencent.smtt.export.external.interfaces.PermissionRequest permissionRequest) {
    }

    public void onProgressChanged(com.tencent.smtt.sdk.WebView webView, int i) {
    }

    public void onReachedMaxAppCacheSize(long j, long j2, com.tencent.smtt.sdk.WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(j2);
    }

    public void onReceivedIcon(com.tencent.smtt.sdk.WebView webView, android.graphics.Bitmap bitmap) {
    }

    public void onReceivedTitle(com.tencent.smtt.sdk.WebView webView, java.lang.String str) {
    }

    public void onReceivedTouchIconUrl(com.tencent.smtt.sdk.WebView webView, java.lang.String str, boolean z) {
    }

    public void onRequestFocus(com.tencent.smtt.sdk.WebView webView) {
    }

    public void onShowCustomView(android.view.View view, int i, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback customViewCallback) {
    }

    public void onShowCustomView(android.view.View view, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback customViewCallback) {
    }

    public boolean onShowFileChooser(com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.sdk.ValueCallback valueCallback, com.tencent.smtt.sdk.WebChromeClient.FileChooserParams fileChooserParams) {
        return false;
    }

    public void openFileChooser(com.tencent.smtt.sdk.ValueCallback valueCallback, java.lang.String str, java.lang.String str2) {
        valueCallback.onReceiveValue(null);
    }
}
