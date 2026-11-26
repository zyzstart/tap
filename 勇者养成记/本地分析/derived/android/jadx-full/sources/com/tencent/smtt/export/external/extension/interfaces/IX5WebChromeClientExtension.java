package com.tencent.smtt.export.external.extension.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IX5WebChromeClientExtension {
    public static final int AUDIO_BUFFERING_DISABLE = -3;
    public static final int AUDIO_BUFFERING_END = -1;
    public static final int AUDIO_BUFFERING_START = -2;

    void acquireWakeLock();

    void addFlashView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams);

    void exitFullScreenFlash();

    android.content.Context getApplicationContex();

    android.view.View getVideoLoadingProgressView();

    java.lang.Object getX5WebChromeClientInstance();

    void h5videoExitFullScreen(java.lang.String str);

    void h5videoRequestFullScreen(java.lang.String str);

    void jsExitFullScreen();

    void jsRequestFullScreen();

    boolean onAddFavorite(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension iX5WebViewExtension, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult);

    void onAllMetaDataFinished(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension iX5WebViewExtension, java.util.HashMap map);

    void onBackforwardFinished(int i);

    void onColorModeChanged(long j);

    void onHitTestResultFinished(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension iX5WebViewExtension, com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult hitTestResult);

    void onHitTestResultForPluginFinished(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension iX5WebViewExtension, com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult hitTestResult, android.os.Bundle bundle);

    java.lang.Object onMiscCallBack(java.lang.String str, android.os.Bundle bundle);

    boolean onPageNotResponding(java.lang.Runnable runnable);

    boolean onPermissionRequest(java.lang.String str, long j, com.tencent.smtt.export.external.interfaces.MediaAccessPermissionsCallback mediaAccessPermissionsCallback);

    void onPrepareX5ReadPageDataFinished(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension iX5WebViewExtension, java.util.HashMap map);

    void onPrintPage();

    void onPromptNotScalable(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension iX5WebViewExtension);

    void onPromptScaleSaved(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension iX5WebViewExtension);

    boolean onSavePassword(android.webkit.ValueCallback valueCallback, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, boolean z);

    boolean onSavePassword(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z, android.os.Message message);

    void onX5ReadModeAvailableChecked(java.util.HashMap map);

    void openFileChooser(android.webkit.ValueCallback valueCallback, java.lang.String str, java.lang.String str2);

    void releaseWakeLock();

    void requestFullScreenFlash();
}
