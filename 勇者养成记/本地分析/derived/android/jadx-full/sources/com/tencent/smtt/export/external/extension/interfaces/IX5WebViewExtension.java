package com.tencent.smtt.export.external.extension.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IX5WebViewExtension {
    public static final int HANDLEVIEW_ALIGNMENT_CENTER = 1;
    public static final int HANDLEVIEW_ALIGNMENT_RIGHT = 2;
    public static final int HANDLEVIEW_POSITION_CENTER = 1;
    public static final int HANDLEVIEW_POSITION_RIGHT = 2;
    public static final int HANLDEVIEW_ALIGNMENT_LEFT = 0;
    public static final int HANLDEVIEW_POSITION_LEFT = 0;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int RENDER_MODE_DEFAULT = 0;
    public static final int RENDER_MODE_SMOOTHNESS_AGGRESSIVE = 2;
    public static final int RENDER_MODE_SMOOTHNESS_NORMAL = 1;

    void active();

    void cancelLongPress();

    boolean capturePageToFile(android.graphics.Bitmap.Config config, java.lang.String str, boolean z, int i, int i2);

    void clearServiceWorkerCache();

    void clearTextEntry();

    void clearTextFieldLongPressStatus();

    void copyText();

    void cutText(java.lang.CharSequence charSequence);

    void deactive();

    void doFingerSearchIfNeed();

    void doTranslateAction(int i);

    void documentAsText(android.os.Message message);

    void documentDumpRenderTree(android.os.Message message);

    boolean drawPreReadBaseLayer(android.graphics.Canvas canvas, boolean z);

    void dumpDisplayTree();

    void dumpViewportForLayoutTest(android.os.Message message);

    void enterSelectionMode(boolean z);

    void exitPluginFullScreen();

    void focusAndPopupIM(java.lang.String str);

    void forceSyncOffsetToCore();

    java.util.ArrayList getAllImageInfo();

    android.graphics.Bitmap getBitmapByIndex(int i);

    int getCurrentHistoryItemIndex();

    java.lang.String getDocumentOuterHTML();

    boolean getDrawWithBuffer();

    void getFakeLoginStatus(android.os.Bundle bundle, android.webkit.ValueCallback valueCallback);

    java.lang.String getFocusCandidateText();

    com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem getHistoryItem(int i);

    int getQQBrowserVersion();

    int getScrollX();

    int getScrollY();

    android.os.Bundle getSdkQBStatisticsInfo();

    java.lang.String getSelectionText();

    com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension getSettingsExtension();

    int getSharedVideoTime();

    android.graphics.Point getSinglePressPoint();

    int getSniffVideoID();

    java.lang.String getSniffVideoRefer();

    boolean getSolarMode();

    int getTitleHeight();

    com.tencent.smtt.export.external.interfaces.IX5WebChromeClient getWebChromeClient();

    com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension getWebChromeClientExtension();

    int getWebTextScrollDis();

    com.tencent.smtt.export.external.interfaces.IX5WebViewClient getWebViewClient();

    com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension getWebViewClientExtension();

    boolean inFullScreenMode();

    boolean inputNodeIsPasswordType();

    boolean inputNodeIsPhoneType();

    void invalidateContent();

    java.lang.Object invokeMiscMethod(java.lang.String str, android.os.Bundle bundle);

    boolean isActive();

    boolean isEditingMode();

    boolean isEnableSetFont();

    boolean isHorizontalScrollBarEnabled();

    boolean isMobileSite();

    boolean isPluginFullScreen();

    boolean isPreReadCanGoForward();

    boolean isSelectionMode();

    boolean isVerticalScrollBarEnabled();

    boolean isX5CoreSandboxMode();

    void leaveSelectionMode();

    void loadDataWithBaseURLWithHeaders(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.util.Map map);

    void loaddataWithHeaders(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map map);

    boolean needSniff();

    void onAppExit();

    void onFingerSearchResult(java.lang.String str, int i, int i2);

    void onPageTransFormationSettingChanged(boolean z);

    void onPauseActiveDomObject();

    void onPauseNativeVideo();

    void onResumeActiveDomObject();

    void pasteText(java.lang.CharSequence charSequence);

    void pauseAudio();

    void playAudio();

    void preConnectQProxy();

    void preLoad(java.lang.String str, int i, int i2, java.util.Map map);

    void pruneMemoryCache();

    boolean registerEmbeddedWidget(java.lang.String[] strArr, java.lang.Object obj);

    void registerServiceWorkerBackground(java.lang.String str, java.lang.String str2);

    void registerServiceWorkerOffline(java.lang.String str, java.util.List list, boolean z);

    void reloadCustomMetaData();

    void removeHistoryItem(int i);

    void replaceAllInputText(java.lang.String str);

    void replyListBox(int i);

    void replyMultiListBox(int i, boolean[] zArr);

    boolean requestFocusForInputNode(int i);

    void retrieveFingerSearchContext(int i);

    void savePageToDisk(java.lang.String str, android.os.Message message);

    void savePageToDisk(java.lang.String str, boolean z, int i, android.webkit.ValueCallback valueCallback);

    void scrollBy(int i, int i2);

    void scrollTo(int i, int i2);

    int seletionStatus();

    void sendNeverRememberMsg(java.lang.String str, java.lang.String str2, java.lang.String str3, android.os.Message message);

    void sendRememberMsg(java.lang.String str, java.lang.String str2, java.lang.String str3, android.os.Message message);

    void sendRememberMsg(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5);

    void sendResumeMsg(java.lang.String str, java.lang.String str2, java.lang.String str3, android.os.Message message);

    void setAudioAutoPlayNotify(boolean z);

    void setBackFromSystem();

    void setDisableDrawingWhileLosingFocus(boolean z);

    void setDrawWithBuffer(boolean z);

    void setEmbTitleView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams);

    void setFakeLoginParams(android.os.Bundle bundle);

    void setForceEnableZoom(boolean z);

    void setHandleViewBitmap(android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2, int i, int i2);

    void setHandleViewLineColor(int i, int i2);

    void setHandleViewLineIsShowing(boolean z, int i);

    void setHandleViewSelectionColor(int i, int i2);

    void setHorizontalScrollBarDrawable(android.graphics.drawable.Drawable drawable);

    void setHorizontalScrollBarEnabled(boolean z);

    void setHorizontalTrackDrawable(android.graphics.drawable.Drawable drawable);

    void setIsForVideoSniff(boolean z);

    void setLongPressTextExtensionMenu(int i);

    void setOrientation(int i);

    void setOverScrollParams(int i, int i2, int i3, int i4, int i5, int i6, android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2, android.graphics.drawable.Drawable drawable3);

    void setRenderMode(int i);

    void setScreenState(int i);

    void setScrollBarDefaultDelayBeforeFade(int i);

    void setScrollBarFadeDuration(int i);

    void setScrollBarFadingEnabled(boolean z);

    void setScrollBarSize(int i);

    void setScrollListener(com.tencent.smtt.export.external.interfaces.IX5ScrollListener iX5ScrollListener);

    void setSelectListener(com.tencent.smtt.export.external.interfaces.ISelectionInterface iSelectionInterface);

    void setSharedVideoTime(int i);

    void setSniffVideoInfo(java.lang.String str, int i, java.lang.String str2, java.lang.String str3);

    void setTextFieldInLongPressStatus(boolean z);

    void setVerticalScrollBarDrawable(android.graphics.drawable.Drawable drawable);

    void setVerticalScrollBarEnabled(boolean z);

    void setVerticalTrackDrawable(android.graphics.drawable.Drawable drawable);

    void setWebBackForwardListClient(com.tencent.smtt.export.external.interfaces.IX5WebBackForwardListClient iX5WebBackForwardListClient);

    void setWebChromeClientExtension(com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension);

    void setWebViewClientExtension(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension iX5WebViewClientExtension);

    boolean shouldFitScreenLayout();

    void showImage(int i, int i2);

    android.graphics.drawable.Drawable snapshot(int i, boolean z);

    void snapshotVisible(android.graphics.Bitmap bitmap, boolean z, boolean z2, boolean z3, boolean z4, float f, float f2, java.lang.Runnable runnable);

    void snapshotVisible(android.graphics.Canvas canvas, boolean z, boolean z2, boolean z3, boolean z4);

    void snapshotWholePage(android.graphics.Canvas canvas, boolean z, boolean z2);

    void snapshotWholePage(android.graphics.Canvas canvas, boolean z, boolean z2, java.lang.Runnable runnable);

    void stopPreLoad(java.lang.String str);

    void trimMemory(int i);

    void unRegisterServiceWorker(java.lang.String str, boolean z);

    void updateContext(android.content.Context context);

    void updateImageList(int i, int i2, boolean z);

    void updateSelectionPosition();

    void updateServiceWorkerBackground(java.lang.String str);

    void waitSWInstalled(java.lang.String str, android.os.Message message);

    android.graphics.drawable.Drawable wrapDrawableWithNativeBitmap(android.graphics.drawable.Drawable drawable, int i, android.graphics.Bitmap.Config config);
}
