package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IX5WebViewBase {
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;

    public interface FindListener {
        void onFindResultReceived(int i, int i2, boolean z);
    }

    public static class HitTestResult {

        @java.lang.Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int BUTTON_TYPE = 10;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;

        @java.lang.Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;
        private java.lang.Object mData;
        private java.lang.String mExtra;
        private android.graphics.Point mPoint;
        private boolean mIsFromSinglePress = false;
        private int mType = 0;

        public class AnchorData {
            public java.lang.String mAnchorTitle;
            public java.lang.String mAnchorUrl;

            public AnchorData() {
            }
        }

        public class EditableData {
            public java.lang.String mEditableText;
            public boolean mIsPassword;

            public EditableData() {
            }
        }

        public class ImageAnchorData {
            public java.lang.String mAHref;
            public android.graphics.Bitmap mBmp;
            public java.lang.String mPicUrl;
            public long mRawDataSize;

            public ImageAnchorData() {
            }

            public android.graphics.Bitmap getBitmap() {
                return com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult.this.getBitmapData();
            }
        }

        public class ImageData {
            public android.graphics.Bitmap mBmp;
            public int mImgHeight;
            public int mImgWidth;
            public java.lang.String mPicUrl;
            public long mRawDataSize;

            public ImageData() {
            }

            public android.graphics.Bitmap getBitmap() {
                return com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult.this.getBitmapData();
            }
        }

        protected android.graphics.Bitmap getBitmapData() {
            return null;
        }

        public java.lang.Object getData() {
            return this.mData;
        }

        public java.lang.String getExtra() {
            return this.mExtra;
        }

        public android.graphics.Point getHitTestPoint() {
            return new android.graphics.Point(this.mPoint);
        }

        public int getType() {
            return this.mType;
        }

        public boolean isFromSinglePress() {
            return this.mIsFromSinglePress;
        }

        public void setData(java.lang.Object obj) {
            this.mData = obj;
        }

        public void setExtra(java.lang.String str) {
            this.mExtra = str;
        }

        public void setHitTestPoint(android.graphics.Point point) {
            this.mPoint = point;
        }

        public void setIsFromSinglePress(boolean z) {
            this.mIsFromSinglePress = z;
        }

        public void setType(int i) {
            this.mType = i;
        }
    }

    public static class ImageInfo {
        public boolean mIsGif;
        public java.lang.String mPicUrl;
        public long mRawDataSize;

        public long getPicSize() {
            return this.mRawDataSize;
        }

        public java.lang.String getPicUrl() {
            return this.mPicUrl;
        }

        public boolean isGif() {
            return this.mIsGif;
        }
    }

    @java.lang.Deprecated
    public interface PictureListener {
        @java.lang.Deprecated
        void onNewPicture(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.graphics.Picture picture, boolean z);

        void onNewPictureIfHaveContent(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.graphics.Picture picture);
    }

    public static class WebViewTransport {
        private com.tencent.smtt.export.external.interfaces.IX5WebViewBase mWebview;

        public synchronized com.tencent.smtt.export.external.interfaces.IX5WebViewBase getWebView() {
            return this.mWebview;
        }

        public synchronized void setWebView(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase) {
            this.mWebview = iX5WebViewBase;
        }
    }

    void addJavascriptInterface(java.lang.Object obj, java.lang.String str);

    boolean canGoBack();

    boolean canGoBackOrForward(int i);

    boolean canGoForward();

    @java.lang.Deprecated
    boolean canZoomIn();

    @java.lang.Deprecated
    boolean canZoomOut();

    android.graphics.Picture capturePicture();

    void clearCache(boolean z);

    void clearFormData();

    void clearHistory();

    void clearMatches();

    void clearSslPreferences();

    @java.lang.Deprecated
    void clearView();

    void computeScroll();

    com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList copyBackForwardList();

    java.lang.Object createPrintDocumentAdapter(java.lang.String str);

    void destroy();

    void documentHasImages(android.os.Message message);

    void dumpViewHierarchyWithProperties(java.io.BufferedWriter bufferedWriter, int i);

    @java.lang.Deprecated
    int findAll(java.lang.String str);

    void findAllAsync(java.lang.String str);

    android.view.View findHierarchyView(java.lang.String str, int i);

    void findNext(boolean z);

    void flingScroll(int i, int i2);

    void freeMemory();

    android.net.http.SslCertificate getCertificate();

    int getContentHeight();

    int getContentWidth();

    android.graphics.Bitmap getFavicon();

    com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult getHitTestResult();

    java.lang.String[] getHttpAuthUsernamePassword(java.lang.String str, java.lang.String str2);

    java.lang.String getOriginalUrl();

    int getProgress();

    @java.lang.Deprecated
    float getScale();

    com.tencent.smtt.export.external.interfaces.IX5WebSettings getSettings();

    java.lang.String getTitle();

    java.lang.String getUrl();

    android.view.View getView();

    int getVisibleTitleHeight();

    com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension getX5WebViewExtension();

    @java.lang.Deprecated
    android.view.View getZoomControls();

    void goBack();

    void goBackOrForward(int i);

    void goForward();

    void invokeZoomPicker();

    boolean isPrivateBrowsingEnable();

    void loadData(java.lang.String str, java.lang.String str2, java.lang.String str3);

    void loadDataWithBaseURL(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5);

    void loadUrl(java.lang.String str);

    void loadUrl(java.lang.String str, java.util.Map map);

    void onPause();

    void onResume();

    boolean overlayHorizontalScrollbar();

    boolean overlayVerticalScrollbar();

    boolean pageDown(boolean z, int i);

    boolean pageUp(boolean z, int i);

    void pauseTimers();

    void postUrl(java.lang.String str, byte[] bArr);

    void refreshPlugins(boolean z);

    void reload();

    void removeJavascriptInterface(java.lang.String str);

    void requestFocusNodeHref(android.os.Message message);

    void requestImageRef(android.os.Message message);

    @java.lang.Deprecated
    boolean restorePicture(android.os.Bundle bundle, java.io.File file);

    com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList restoreState(android.os.Bundle bundle);

    void resumeTimers();

    @java.lang.Deprecated
    void savePassword(java.lang.String str, java.lang.String str2, java.lang.String str3);

    @java.lang.Deprecated
    boolean savePicture(android.os.Bundle bundle, java.io.File file);

    com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList saveState(android.os.Bundle bundle);

    void saveWebArchive(java.lang.String str);

    void saveWebArchive(java.lang.String str, boolean z, android.webkit.ValueCallback valueCallback);

    void setBackgroundColor(int i);

    void setCertificate(android.net.http.SslCertificate sslCertificate);

    void setDownloadListener(com.tencent.smtt.export.external.interfaces.DownloadListener downloadListener);

    void setFindListener(com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener findListener);

    void setHorizontalScrollbarOverlay(boolean z);

    void setHttpAuthUsernamePassword(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

    void setInitialScale(int i);

    @java.lang.Deprecated
    void setMapTrackballToArrowKeys(boolean z);

    void setNetworkAvailable(boolean z);

    void setPictureListener(com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener pictureListener);

    void setVerticalScrollbarOverlay(boolean z);

    void setWebChromeClient(com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient);

    void setWebViewClient(com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient);

    @java.lang.Deprecated
    boolean showFindDialog(java.lang.String str, boolean z);

    void stopLoading();

    boolean zoomIn();

    boolean zoomOut();
}
