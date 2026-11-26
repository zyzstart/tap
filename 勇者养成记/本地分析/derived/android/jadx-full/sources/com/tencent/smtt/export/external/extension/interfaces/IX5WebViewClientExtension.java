package com.tencent.smtt.export.external.extension.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IX5WebViewClientExtension {
    public static final int FRAME_LOADTYPE_BACK = 1;
    public static final int FRAME_LOADTYPE_BACKWMLDECKNOTACCESSIBLE = 10;
    public static final int FRAME_LOADTYPE_FORWARD = 2;
    public static final int FRAME_LOADTYPE_INDEXEDBACKFORWARD = 3;
    public static final int FRAME_LOADTYPE_PREREAD = 11;
    public static final int FRAME_LOADTYPE_REDIRECT = 7;
    public static final int FRAME_LOADTYPE_RELOAD = 4;
    public static final int FRAME_LOADTYPE_RELOADALLOWINGSTALEDATA = 5;
    public static final int FRAME_LOADTYPE_RELOADFROMORIGIN = 9;
    public static final int FRAME_LOADTYPE_REPLACE = 8;
    public static final int FRAME_LOADTYPE_SAME = 6;
    public static final int FRAME_LOADTYPE_STANDARD = 0;
    public static final int HTMLTYPE_JS_SCROLLTO = 1;

    boolean allowJavaScriptOpenWindowAutomatically(java.lang.String str, java.lang.String str2);

    void computeScroll(android.view.View view);

    void didFirstVisuallyNonEmptyPaint();

    boolean dispatchTouchEvent(android.view.MotionEvent motionEvent, android.view.View view);

    void documentAvailableInMainFrame();

    void handlePluginTag(java.lang.String str, java.lang.String str2, boolean z, java.lang.String str3);

    void hideAddressBar();

    void invalidate();

    boolean notifyAutoAudioPlay(java.lang.String str, com.tencent.smtt.export.external.interfaces.JsResult jsResult);

    boolean notifyJavaScriptOpenWindowsBlocked(java.lang.String str, java.lang.String[] strArr, android.webkit.ValueCallback valueCallback, boolean z);

    void onDoubleTapStart();

    void onFakeLoginRecognised(android.os.Bundle bundle);

    void onFlingScrollBegin(int i, int i2, int i3);

    void onFlingScrollEnd();

    void onHideListBox();

    void onHistoryItemChanged();

    void onInputBoxTextChanged(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension iX5WebViewExtension, java.lang.String str);

    boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent, android.view.View view);

    void onMetricsSavedCountReceived(java.lang.String str, boolean z, long j, java.lang.String str2, int i);

    java.lang.Object onMiscCallBack(java.lang.String str, android.os.Bundle bundle);

    java.lang.Object onMiscCallBack(java.lang.String str, android.os.Bundle bundle, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4);

    void onMissingPluginClicked(java.lang.String str, java.lang.String str2, java.lang.String str3, int i);

    void onNativeCrashReport(int i, java.lang.String str);

    void onOverScrolled(int i, int i2, boolean z, boolean z2, android.view.View view);

    void onPinchToZoomStart();

    void onPreReadFinished();

    void onPrefetchResourceHit(boolean z);

    void onPreloadCallback(int i, java.lang.String str);

    void onPromptScaleSaved();

    void onReceivedSslErrorCancel();

    void onReceivedViewSource(java.lang.String str);

    void onReportAdFilterInfo(int i, int i2, java.lang.String str, boolean z);

    void onReportHtmlInfo(int i, java.lang.String str);

    void onReportResponseHeaders(java.lang.String str, int i, java.util.HashMap map);

    void onResponseReceived(com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest, com.tencent.smtt.export.external.interfaces.WebResourceResponse webResourceResponse, int i);

    void onScrollChanged(int i, int i2, int i3, int i4);

    void onScrollChanged(int i, int i2, int i3, int i4, android.view.View view);

    void onSetButtonStatus(boolean z, boolean z2);

    void onShowListBox(java.lang.String[] strArr, int[] iArr, int[] iArr2, int i);

    boolean onShowLongClickPopupMenu();

    void onShowMutilListBox(java.lang.String[] strArr, int[] iArr, int[] iArr2, int[] iArr3);

    void onSlidingTitleOffScreen(int i, int i2);

    void onSoftKeyBoardHide(int i);

    void onSoftKeyBoardShow();

    boolean onTouchEvent(android.view.MotionEvent motionEvent, android.view.View view);

    void onTransitionToCommitted();

    void onUploadProgressChange(int i, int i2, java.lang.String str);

    void onUploadProgressStart(int i);

    void onUrlChange(java.lang.String str, java.lang.String str2);

    boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, android.view.View view);

    boolean preShouldOverrideUrlLoading(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension iX5WebViewExtension, java.lang.String str);

    void showTranslateBubble(int i, java.lang.String str, java.lang.String str2, int i2);
}
