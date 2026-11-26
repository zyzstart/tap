package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IX5WebChromeClient {

    public interface CustomViewCallback {
        void onCustomViewHidden();
    }

    public static abstract class FileChooserParams {
        public static final int MODE_OPEN = 0;
        public static final int MODE_OPEN_FOLDER = 2;
        public static final int MODE_OPEN_MULTIPLE = 1;
        public static final int MODE_SAVE = 3;

        public static android.net.Uri[] parseResult(int i, android.content.Intent intent) {
            return null;
        }

        public abstract android.content.Intent createIntent();

        public abstract java.lang.String[] getAcceptTypes();

        public abstract java.lang.String getFilenameHint();

        public abstract int getMode();

        public abstract java.lang.CharSequence getTitle();

        public abstract boolean isCaptureEnabled();
    }

    android.graphics.Bitmap getDefaultVideoPoster();

    void getVisitedHistory(android.webkit.ValueCallback valueCallback);

    void onCloseWindow(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase);

    @java.lang.Deprecated
    void onConsoleMessage(java.lang.String str, int i, java.lang.String str2);

    boolean onConsoleMessage(com.tencent.smtt.export.external.interfaces.ConsoleMessage consoleMessage);

    boolean onCreateWindow(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, boolean z, boolean z2, android.os.Message message);

    void onExceededDatabaseQuota(java.lang.String str, java.lang.String str2, long j, long j2, long j3, com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater);

    void onGeolocationPermissionsHidePrompt();

    void onGeolocationPermissionsShowPrompt(java.lang.String str, com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback geolocationPermissionsCallback);

    void onGeolocationStartUpdating(android.webkit.ValueCallback valueCallback, android.webkit.ValueCallback valueCallback2);

    void onGeolocationStopUpdating();

    void onHideCustomView();

    boolean onJsAlert(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult);

    boolean onJsBeforeUnload(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult);

    boolean onJsConfirm(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult);

    boolean onJsPrompt(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.smtt.export.external.interfaces.JsPromptResult jsPromptResult);

    boolean onJsTimeout();

    void onProgressChanged(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, int i);

    void onReachedMaxAppCacheSize(long j, long j2, com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater);

    void onReceivedIcon(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.graphics.Bitmap bitmap);

    void onReceivedTitle(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str);

    void onReceivedTouchIconUrl(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, boolean z);

    void onRequestFocus(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase);

    void onShowCustomView(android.view.View view, int i, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback customViewCallback);

    void onShowCustomView(android.view.View view, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback customViewCallback);

    boolean onShowFileChooser(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.webkit.ValueCallback valueCallback, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams fileChooserParams);

    void openFileChooser(android.webkit.ValueCallback valueCallback, java.lang.String str, java.lang.String str2, boolean z);
}
