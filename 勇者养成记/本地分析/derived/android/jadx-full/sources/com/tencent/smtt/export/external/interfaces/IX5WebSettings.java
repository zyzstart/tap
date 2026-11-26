package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IX5WebSettings {
    public static final int DEFAULT_CACHE_CAPACITY = 15;
    public static final int LOAD_CACHE_AD = 100;
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;

    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS
    }

    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }

    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(com.tencent.smtt.sdk.TbsListener.ErrorCode.DOWNLOAD_THROWABLE),
        LARGEST(150);

        int value;

        TextSize(int i) {
            this.value = i;
        }
    }

    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);

        int value;

        ZoomDensity(int i) {
            this.value = i;
        }
    }

    boolean enableSmoothTransition();

    boolean getAllowContentAccess();

    boolean getAllowFileAccess();

    boolean getBlockNetworkImage();

    boolean getBlockNetworkLoads();

    boolean getBuiltInZoomControls();

    int getCacheMode();

    java.lang.String getCursiveFontFamily();

    boolean getDatabaseEnabled();

    java.lang.String getDatabasePath();

    int getDefaultFixedFontSize();

    int getDefaultFontSize();

    java.lang.String getDefaultTextEncodingName();

    com.tencent.smtt.export.external.interfaces.IX5WebSettings.ZoomDensity getDefaultZoom();

    boolean getDisplayZoomControls();

    boolean getDomStorageEnabled();

    java.lang.String getFantasyFontFamily();

    java.lang.String getFixedFontFamily();

    boolean getJavaScriptCanOpenWindowsAutomatically();

    boolean getJavaScriptEnabled();

    com.tencent.smtt.export.external.interfaces.IX5WebSettings.LayoutAlgorithm getLayoutAlgorithm();

    boolean getLightTouchEnabled();

    boolean getLoadWithOverviewMode();

    boolean getLoadsImagesAutomatically();

    boolean getMediaPlaybackRequiresUserGesture();

    int getMinimumFontSize();

    int getMinimumLogicalFontSize();

    int getMixedContentMode();

    boolean getNavDump();

    com.tencent.smtt.export.external.interfaces.IX5WebSettings.PluginState getPluginState();

    boolean getPluginsEnabled();

    java.lang.String getPluginsPath();

    java.lang.String getSansSerifFontFamily();

    boolean getSaveFormData();

    boolean getSavePassword();

    java.lang.String getSerifFontFamily();

    java.lang.String getStandardFontFamily();

    com.tencent.smtt.export.external.interfaces.IX5WebSettings.TextSize getTextSize();

    int getTextZoom();

    boolean getUseWebViewBackgroundForOverscrollBackground();

    boolean getUseWideViewPort();

    java.lang.String getUserAgent();

    java.lang.String getUserAgentString();

    void setAllowContentAccess(boolean z);

    void setAllowFileAccess(boolean z);

    void setAllowFileAccessFromFileURLs(boolean z);

    void setAllowUniversalAccessFromFileURLs(boolean z);

    void setAppCacheEnabled(boolean z);

    void setAppCacheMaxSize(long j);

    void setAppCachePath(java.lang.String str);

    void setBlockNetworkImage(boolean z);

    void setBlockNetworkLoads(boolean z);

    void setBuiltInZoomControls(boolean z);

    void setCacheMode(int i);

    void setCursiveFontFamily(java.lang.String str);

    void setDatabaseEnabled(boolean z);

    void setDatabasePath(java.lang.String str);

    void setDefaultDatabasePath(boolean z);

    void setDefaultFixedFontSize(int i);

    void setDefaultFontSize(int i);

    void setDefaultTextEncodingName(java.lang.String str);

    void setDefaultZoom(com.tencent.smtt.export.external.interfaces.IX5WebSettings.ZoomDensity zoomDensity);

    void setDisplayZoomControls(boolean z);

    void setDomStorageEnabled(boolean z);

    void setEnableSmoothTransition(boolean z);

    void setFantasyFontFamily(java.lang.String str);

    void setFixedFontFamily(java.lang.String str);

    void setGeolocationDatabasePath(java.lang.String str);

    void setGeolocationEnabled(boolean z);

    void setJavaScriptCanOpenWindowsAutomatically(boolean z);

    void setJavaScriptEnabled(boolean z);

    void setLayoutAlgorithm(com.tencent.smtt.export.external.interfaces.IX5WebSettings.LayoutAlgorithm layoutAlgorithm);

    void setLightTouchEnabled(boolean z);

    void setLoadWithOverviewMode(boolean z);

    void setLoadsImagesAutomatically(boolean z);

    void setMediaPlaybackRequiresUserGesture(boolean z);

    void setMinimumFontSize(int i);

    void setMinimumLogicalFontSize(int i);

    void setNavDump(boolean z);

    void setNeedInitialFocus(boolean z);

    void setPluginEnabled(boolean z);

    void setPluginState(com.tencent.smtt.export.external.interfaces.IX5WebSettings.PluginState pluginState);

    void setPluginsEnabled(boolean z);

    void setPluginsPath(java.lang.String str);

    void setRenderPriority(com.tencent.smtt.export.external.interfaces.IX5WebSettings.RenderPriority renderPriority);

    void setSansSerifFontFamily(java.lang.String str);

    void setSaveFormData(boolean z);

    void setSavePassword(boolean z);

    void setSerifFontFamily(java.lang.String str);

    void setStandardFontFamily(java.lang.String str);

    void setSupportMultipleWindows(boolean z);

    void setSupportZoom(boolean z);

    void setTextSize(com.tencent.smtt.export.external.interfaces.IX5WebSettings.TextSize textSize);

    void setTextZoom(int i);

    void setUseWebViewBackgroundForOverscrollBackground(boolean z);

    void setUseWideViewPort(boolean z);

    void setUserAgent(java.lang.String str);

    void setUserAgent(java.lang.String str, boolean z);

    void setUserAgentString(java.lang.String str);

    boolean supportMultipleWindows();

    boolean supportZoom();
}
