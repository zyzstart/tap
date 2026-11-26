package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WebSettings {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.smtt.export.external.interfaces.IX5WebSettings f885a;
    private android.webkit.WebSettings b;
    private boolean c;

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

    WebSettings(android.webkit.WebSettings webSettings) {
        this.f885a = null;
        this.b = null;
        this.c = false;
        this.f885a = null;
        this.b = webSettings;
        this.c = false;
    }

    WebSettings(com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings) {
        this.f885a = null;
        this.b = null;
        this.c = false;
        this.f885a = iX5WebSettings;
        this.b = null;
        this.c = true;
    }

    @android.annotation.TargetApi(17)
    public static java.lang.String getDefaultUserAgent(android.content.Context context) {
        java.lang.Object objA;
        if (com.tencent.smtt.sdk.u.a().b()) {
            return com.tencent.smtt.sdk.u.a().c().i(context);
        }
        if (android.os.Build.VERSION.SDK_INT >= 17 && (objA = com.tencent.smtt.utils.k.a(android.webkit.WebSettings.class, "getDefaultUserAgent", new java.lang.Class[]{android.content.Context.class}, context)) != null) {
            return (java.lang.String) objA;
        }
        return null;
    }

    @java.lang.Deprecated
    public boolean enableSmoothTransition() {
        android.webkit.WebSettings webSettings;
        java.lang.Object objA;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.enableSmoothTransition();
        }
        if (this.c || (webSettings = this.b) == null || android.os.Build.VERSION.SDK_INT < 11 || (objA = com.tencent.smtt.utils.k.a(webSettings, "enableSmoothTransition")) == null) {
            return false;
        }
        return ((java.lang.Boolean) objA).booleanValue();
    }

    @android.annotation.TargetApi(11)
    public boolean getAllowContentAccess() {
        android.webkit.WebSettings webSettings;
        java.lang.Object objA;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getAllowContentAccess();
        }
        if (this.c || (webSettings = this.b) == null || android.os.Build.VERSION.SDK_INT < 11 || (objA = com.tencent.smtt.utils.k.a(webSettings, "getAllowContentAccess")) == null) {
            return false;
        }
        return ((java.lang.Boolean) objA).booleanValue();
    }

    @android.annotation.TargetApi(3)
    public boolean getAllowFileAccess() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getAllowFileAccess();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getAllowFileAccess();
    }

    public synchronized boolean getBlockNetworkImage() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getBlockNetworkImage();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getBlockNetworkImage();
    }

    @android.annotation.TargetApi(8)
    public synchronized boolean getBlockNetworkLoads() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getBlockNetworkLoads();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT >= 8) {
            return webSettings.getBlockNetworkLoads();
        }
        return false;
    }

    @android.annotation.TargetApi(3)
    public boolean getBuiltInZoomControls() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getBuiltInZoomControls();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getBuiltInZoomControls();
    }

    public int getCacheMode() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getCacheMode();
        }
        if (this.c || (webSettings = this.b) == null) {
            return 0;
        }
        return webSettings.getCacheMode();
    }

    public synchronized java.lang.String getCursiveFontFamily() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (!this.c || (iX5WebSettings = this.f885a) == null) {
            return (this.c || (webSettings = this.b) == null) ? "" : webSettings.getCursiveFontFamily();
        }
        return iX5WebSettings.getCursiveFontFamily();
    }

    @android.annotation.TargetApi(5)
    public synchronized boolean getDatabaseEnabled() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getDatabaseEnabled();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getDatabaseEnabled();
    }

    @android.annotation.TargetApi(5)
    public synchronized java.lang.String getDatabasePath() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (!this.c || (iX5WebSettings = this.f885a) == null) {
            return (this.c || (webSettings = this.b) == null) ? "" : webSettings.getDatabasePath();
        }
        return iX5WebSettings.getDatabasePath();
    }

    public synchronized int getDefaultFixedFontSize() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getDefaultFixedFontSize();
        }
        if (this.c || (webSettings = this.b) == null) {
            return 0;
        }
        return webSettings.getDefaultFixedFontSize();
    }

    public synchronized int getDefaultFontSize() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getDefaultFontSize();
        }
        if (this.c || (webSettings = this.b) == null) {
            return 0;
        }
        return webSettings.getDefaultFontSize();
    }

    public synchronized java.lang.String getDefaultTextEncodingName() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (!this.c || (iX5WebSettings = this.f885a) == null) {
            return (this.c || (webSettings = this.b) == null) ? "" : webSettings.getDefaultTextEncodingName();
        }
        return iX5WebSettings.getDefaultTextEncodingName();
    }

    @android.annotation.TargetApi(7)
    public com.tencent.smtt.sdk.WebSettings.ZoomDensity getDefaultZoom() {
        android.webkit.WebSettings webSettings;
        java.lang.String strName;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            strName = iX5WebSettings.getDefaultZoom().name();
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return null;
            }
            strName = webSettings.getDefaultZoom().name();
        }
        return com.tencent.smtt.sdk.WebSettings.ZoomDensity.valueOf(strName);
    }

    @android.annotation.TargetApi(11)
    public boolean getDisplayZoomControls() {
        android.webkit.WebSettings webSettings;
        java.lang.Object objA;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getDisplayZoomControls();
        }
        if (this.c || (webSettings = this.b) == null || android.os.Build.VERSION.SDK_INT < 11 || (objA = com.tencent.smtt.utils.k.a(webSettings, "getDisplayZoomControls")) == null) {
            return false;
        }
        return ((java.lang.Boolean) objA).booleanValue();
    }

    @android.annotation.TargetApi(7)
    public synchronized boolean getDomStorageEnabled() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getDomStorageEnabled();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getDomStorageEnabled();
    }

    public synchronized java.lang.String getFantasyFontFamily() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (!this.c || (iX5WebSettings = this.f885a) == null) {
            return (this.c || (webSettings = this.b) == null) ? "" : webSettings.getFantasyFontFamily();
        }
        return iX5WebSettings.getFantasyFontFamily();
    }

    public synchronized java.lang.String getFixedFontFamily() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (!this.c || (iX5WebSettings = this.f885a) == null) {
            return (this.c || (webSettings = this.b) == null) ? "" : webSettings.getFixedFontFamily();
        }
        return iX5WebSettings.getFixedFontFamily();
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getJavaScriptCanOpenWindowsAutomatically();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getJavaScriptCanOpenWindowsAutomatically();
    }

    public synchronized boolean getJavaScriptEnabled() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getJavaScriptEnabled();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getJavaScriptEnabled();
    }

    public synchronized com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm.valueOf(iX5WebSettings.getLayoutAlgorithm().name());
        }
        if (this.c || (webSettings = this.b) == null) {
            return null;
        }
        return com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm.valueOf(webSettings.getLayoutAlgorithm().name());
    }

    public boolean getLightTouchEnabled() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getLightTouchEnabled();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getLightTouchEnabled();
    }

    @android.annotation.TargetApi(7)
    public boolean getLoadWithOverviewMode() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getLoadWithOverviewMode();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getLoadWithOverviewMode();
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getLoadsImagesAutomatically();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getLoadsImagesAutomatically();
    }

    @android.annotation.TargetApi(17)
    public boolean getMediaPlaybackRequiresUserGesture() {
        android.webkit.WebSettings webSettings;
        java.lang.Object objA;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getMediaPlaybackRequiresUserGesture();
        }
        if (this.c || (webSettings = this.b) == null || android.os.Build.VERSION.SDK_INT < 17 || (objA = com.tencent.smtt.utils.k.a(webSettings, "getMediaPlaybackRequiresUserGesture")) == null) {
            return false;
        }
        return ((java.lang.Boolean) objA).booleanValue();
    }

    public synchronized int getMinimumFontSize() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getMinimumFontSize();
        }
        if (this.c || (webSettings = this.b) == null) {
            return 0;
        }
        return webSettings.getMinimumFontSize();
    }

    public synchronized int getMinimumLogicalFontSize() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getMinimumLogicalFontSize();
        }
        if (this.c || (webSettings = this.b) == null) {
            return 0;
        }
        return webSettings.getMinimumLogicalFontSize();
    }

    public synchronized int getMixedContentMode() {
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        int iIntValue = -1;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            try {
                return iX5WebSettings.getMixedContentMode();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return -1;
            }
        }
        if (android.os.Build.VERSION.SDK_INT < 21) {
            return -1;
        }
        java.lang.Object objA = com.tencent.smtt.utils.k.a(this.b, "getMixedContentMode", new java.lang.Class[0], new java.lang.Object[0]);
        if (objA != null) {
            iIntValue = ((java.lang.Integer) objA).intValue();
        }
        return iIntValue;
    }

    public boolean getNavDump() {
        android.webkit.WebSettings webSettings;
        java.lang.Object objA;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getNavDump();
        }
        if (this.c || (webSettings = this.b) == null || (objA = com.tencent.smtt.utils.k.a(webSettings, "getNavDump")) == null) {
            return false;
        }
        return ((java.lang.Boolean) objA).booleanValue();
    }

    @android.annotation.TargetApi(8)
    @java.lang.Deprecated
    public synchronized com.tencent.smtt.sdk.WebSettings.PluginState getPluginState() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return com.tencent.smtt.sdk.WebSettings.PluginState.valueOf(iX5WebSettings.getPluginState().name());
        }
        if (this.c || (webSettings = this.b) == null) {
            return null;
        }
        if (android.os.Build.VERSION.SDK_INT < 8) {
            return null;
        }
        java.lang.Object objA = com.tencent.smtt.utils.k.a(webSettings, "getPluginState");
        if (objA == null) {
            return null;
        }
        return com.tencent.smtt.sdk.WebSettings.PluginState.valueOf(((android.webkit.WebSettings.PluginState) objA).name());
    }

    @android.annotation.TargetApi(8)
    @java.lang.Deprecated
    public synchronized boolean getPluginsEnabled() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getPluginsEnabled();
        }
        boolean zBooleanValue = false;
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        int i = android.os.Build.VERSION.SDK_INT;
        if (i > 17) {
            if (i == 18) {
                return android.webkit.WebSettings.PluginState.ON == webSettings.getPluginState();
            }
            return false;
        }
        java.lang.Object objA = com.tencent.smtt.utils.k.a(webSettings, "getPluginsEnabled");
        if (objA != null) {
            zBooleanValue = ((java.lang.Boolean) objA).booleanValue();
        }
        return zBooleanValue;
    }

    @java.lang.Deprecated
    public synchronized java.lang.String getPluginsPath() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getPluginsPath();
        }
        if (this.c || (webSettings = this.b) == null) {
            return "";
        }
        if (android.os.Build.VERSION.SDK_INT > 17) {
            return "";
        }
        java.lang.Object objA = com.tencent.smtt.utils.k.a(webSettings, "getPluginsPath");
        return objA == null ? null : (java.lang.String) objA;
    }

    public synchronized java.lang.String getSansSerifFontFamily() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (!this.c || (iX5WebSettings = this.f885a) == null) {
            return (this.c || (webSettings = this.b) == null) ? "" : webSettings.getSansSerifFontFamily();
        }
        return iX5WebSettings.getSansSerifFontFamily();
    }

    public boolean getSaveFormData() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getSaveFormData();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getSaveFormData();
    }

    public boolean getSavePassword() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getSavePassword();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getSavePassword();
    }

    public synchronized java.lang.String getSerifFontFamily() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (!this.c || (iX5WebSettings = this.f885a) == null) {
            return (this.c || (webSettings = this.b) == null) ? "" : webSettings.getSerifFontFamily();
        }
        return iX5WebSettings.getSerifFontFamily();
    }

    public synchronized java.lang.String getStandardFontFamily() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (!this.c || (iX5WebSettings = this.f885a) == null) {
            return (this.c || (webSettings = this.b) == null) ? "" : webSettings.getStandardFontFamily();
        }
        return iX5WebSettings.getStandardFontFamily();
    }

    public com.tencent.smtt.sdk.WebSettings.TextSize getTextSize() {
        android.webkit.WebSettings webSettings;
        java.lang.String strName;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            strName = iX5WebSettings.getTextSize().name();
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return null;
            }
            strName = webSettings.getTextSize().name();
        }
        return com.tencent.smtt.sdk.WebSettings.TextSize.valueOf(strName);
    }

    @android.annotation.TargetApi(14)
    public synchronized int getTextZoom() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getTextZoom();
        }
        if (this.c || (webSettings = this.b) == null) {
            return 0;
        }
        if (android.os.Build.VERSION.SDK_INT < 14) {
            return 0;
        }
        try {
            return webSettings.getTextZoom();
        } catch (java.lang.Exception unused) {
            java.lang.Object objA = com.tencent.smtt.utils.k.a(this.b, "getTextZoom");
            if (objA == null) {
                return 0;
            }
            return ((java.lang.Integer) objA).intValue();
        }
    }

    @java.lang.Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        android.webkit.WebSettings webSettings;
        java.lang.Object objA;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getUseWebViewBackgroundForOverscrollBackground();
        }
        if (this.c || (webSettings = this.b) == null || (objA = com.tencent.smtt.utils.k.a(webSettings, "getUseWebViewBackgroundForOverscrollBackground")) == null) {
            return false;
        }
        return ((java.lang.Boolean) objA).booleanValue();
    }

    public synchronized boolean getUseWideViewPort() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.getUseWideViewPort();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getUseWideViewPort();
    }

    @android.annotation.TargetApi(3)
    public java.lang.String getUserAgentString() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (!this.c || (iX5WebSettings = this.f885a) == null) {
            return (this.c || (webSettings = this.b) == null) ? "" : webSettings.getUserAgentString();
        }
        return iX5WebSettings.getUserAgentString();
    }

    @android.annotation.TargetApi(11)
    public void setAllowContentAccess(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setAllowContentAccess(z);
        } else {
            if (this.c || (webSettings = this.b) == null || android.os.Build.VERSION.SDK_INT < 11) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setAllowContentAccess", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }

    @android.annotation.TargetApi(3)
    public void setAllowFileAccess(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setAllowFileAccess(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setAllowFileAccess(z);
        }
    }

    @android.annotation.TargetApi(16)
    public void setAllowFileAccessFromFileURLs(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setAllowFileAccessFromFileURLs(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setAllowFileAccessFromFileURLs", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }

    @android.annotation.TargetApi(16)
    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setAllowUniversalAccessFromFileURLs(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setAllowUniversalAccessFromFileURLs", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }

    @android.annotation.TargetApi(7)
    public void setAppCacheEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setAppCacheEnabled(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setAppCacheEnabled(z);
        }
    }

    @android.annotation.TargetApi(7)
    public void setAppCacheMaxSize(long j) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setAppCacheMaxSize(j);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setAppCacheMaxSize(j);
        }
    }

    @android.annotation.TargetApi(7)
    public void setAppCachePath(java.lang.String str) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setAppCachePath(str);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setAppCachePath(str);
        }
    }

    public void setBlockNetworkImage(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setBlockNetworkImage(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setBlockNetworkImage(z);
        }
    }

    @android.annotation.TargetApi(8)
    public synchronized void setBlockNetworkLoads(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setBlockNetworkLoads(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            if (android.os.Build.VERSION.SDK_INT >= 8) {
                webSettings.setBlockNetworkLoads(z);
            }
        }
    }

    @android.annotation.TargetApi(3)
    public void setBuiltInZoomControls(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setBuiltInZoomControls(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setBuiltInZoomControls(z);
        }
    }

    public void setCacheMode(int i) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setCacheMode(i);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setCacheMode(i);
        }
    }

    public synchronized void setCursiveFontFamily(java.lang.String str) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setCursiveFontFamily(str);
        } else if (this.c || (webSettings = this.b) == null) {
        } else {
            webSettings.setCursiveFontFamily(str);
        }
    }

    @android.annotation.TargetApi(5)
    public void setDatabaseEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setDatabaseEnabled(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setDatabaseEnabled(z);
        }
    }

    @android.annotation.TargetApi(5)
    @java.lang.Deprecated
    public void setDatabasePath(java.lang.String str) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setDatabasePath(str);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setDatabasePath", new java.lang.Class[]{java.lang.String.class}, str);
        }
    }

    public synchronized void setDefaultFixedFontSize(int i) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setDefaultFixedFontSize(i);
        } else if (this.c || (webSettings = this.b) == null) {
        } else {
            webSettings.setDefaultFixedFontSize(i);
        }
    }

    public synchronized void setDefaultFontSize(int i) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setDefaultFontSize(i);
        } else if (this.c || (webSettings = this.b) == null) {
        } else {
            webSettings.setDefaultFontSize(i);
        }
    }

    public synchronized void setDefaultTextEncodingName(java.lang.String str) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setDefaultTextEncodingName(str);
        } else if (this.c || (webSettings = this.b) == null) {
        } else {
            webSettings.setDefaultTextEncodingName(str);
        }
    }

    @android.annotation.TargetApi(7)
    public void setDefaultZoom(com.tencent.smtt.sdk.WebSettings.ZoomDensity zoomDensity) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setDefaultZoom(com.tencent.smtt.export.external.interfaces.IX5WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setDefaultZoom(android.webkit.WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        }
    }

    @android.annotation.TargetApi(11)
    public void setDisplayZoomControls(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setDisplayZoomControls(z);
        } else {
            if (this.c || (webSettings = this.b) == null || android.os.Build.VERSION.SDK_INT < 11) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setDisplayZoomControls", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }

    @android.annotation.TargetApi(7)
    public void setDomStorageEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setDomStorageEnabled(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setDomStorageEnabled(z);
        }
    }

    @android.annotation.TargetApi(11)
    @java.lang.Deprecated
    public void setEnableSmoothTransition(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setEnableSmoothTransition(z);
        } else {
            if (this.c || (webSettings = this.b) == null || android.os.Build.VERSION.SDK_INT < 11) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setEnableSmoothTransition", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }

    public synchronized void setFantasyFontFamily(java.lang.String str) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setFantasyFontFamily(str);
        } else if (this.c || (webSettings = this.b) == null) {
        } else {
            webSettings.setFantasyFontFamily(str);
        }
    }

    public synchronized void setFixedFontFamily(java.lang.String str) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setFixedFontFamily(str);
        } else if (this.c || (webSettings = this.b) == null) {
        } else {
            webSettings.setFixedFontFamily(str);
        }
    }

    @android.annotation.TargetApi(5)
    public void setGeolocationDatabasePath(java.lang.String str) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setGeolocationDatabasePath(str);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setGeolocationDatabasePath(str);
        }
    }

    @android.annotation.TargetApi(5)
    public void setGeolocationEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setGeolocationEnabled(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setGeolocationEnabled(z);
        }
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setJavaScriptCanOpenWindowsAutomatically(z);
        } else if (this.c || (webSettings = this.b) == null) {
        } else {
            webSettings.setJavaScriptCanOpenWindowsAutomatically(z);
        }
    }

    @java.lang.Deprecated
    public void setJavaScriptEnabled(boolean z) {
        try {
            if (this.c && this.f885a != null) {
                this.f885a.setJavaScriptEnabled(z);
            } else if (this.c || this.b == null) {
            } else {
                this.b.setJavaScriptEnabled(z);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLayoutAlgorithm(com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm layoutAlgorithm) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setLayoutAlgorithm(com.tencent.smtt.export.external.interfaces.IX5WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        }
    }

    public void setLightTouchEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setLightTouchEnabled(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setLightTouchEnabled(z);
        }
    }

    @android.annotation.TargetApi(7)
    public void setLoadWithOverviewMode(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setLoadWithOverviewMode(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setLoadWithOverviewMode(z);
        }
    }

    public void setLoadsImagesAutomatically(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setLoadsImagesAutomatically(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setLoadsImagesAutomatically(z);
        }
    }

    @android.annotation.TargetApi(17)
    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setMediaPlaybackRequiresUserGesture(z);
        } else {
            if (this.c || (webSettings = this.b) == null || android.os.Build.VERSION.SDK_INT < 17) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setMediaPlaybackRequiresUserGesture", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }

    public synchronized void setMinimumFontSize(int i) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setMinimumFontSize(i);
        } else if (this.c || (webSettings = this.b) == null) {
        } else {
            webSettings.setMinimumFontSize(i);
        }
    }

    public synchronized void setMinimumLogicalFontSize(int i) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setMinimumLogicalFontSize(i);
        } else if (this.c || (webSettings = this.b) == null) {
        } else {
            webSettings.setMinimumLogicalFontSize(i);
        }
    }

    @android.annotation.TargetApi(21)
    public void setMixedContentMode(int i) {
        android.webkit.WebSettings webSettings;
        if ((!this.c || this.f885a == null) && !this.c && (webSettings = this.b) != null && android.os.Build.VERSION.SDK_INT >= 21) {
            com.tencent.smtt.utils.k.a(webSettings, "setMixedContentMode", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
        }
    }

    public void setNavDump(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setNavDump(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setNavDump", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }

    public void setNeedInitialFocus(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setNeedInitialFocus(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setNeedInitialFocus(z);
        }
    }

    @android.annotation.TargetApi(8)
    @java.lang.Deprecated
    public synchronized void setPluginState(com.tencent.smtt.sdk.WebSettings.PluginState pluginState) {
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setPluginState(com.tencent.smtt.export.external.interfaces.IX5WebSettings.PluginState.valueOf(pluginState.name()));
        } else {
            if (this.c || this.b == null) {
                return;
            }
            if (android.os.Build.VERSION.SDK_INT >= 8) {
                com.tencent.smtt.utils.k.a(this.b, "setPluginState", new java.lang.Class[]{android.webkit.WebSettings.PluginState.class}, android.webkit.WebSettings.PluginState.valueOf(pluginState.name()));
            }
        }
    }

    @java.lang.Deprecated
    public void setPluginsEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setPluginsEnabled(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setPluginsEnabled", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }

    @java.lang.Deprecated
    public synchronized void setPluginsPath(java.lang.String str) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setPluginsPath(str);
        } else if (this.c || (webSettings = this.b) == null) {
        } else {
            com.tencent.smtt.utils.k.a(webSettings, "setPluginsPath", new java.lang.Class[]{java.lang.String.class}, str);
        }
    }

    public void setRenderPriority(com.tencent.smtt.sdk.WebSettings.RenderPriority renderPriority) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setRenderPriority(com.tencent.smtt.export.external.interfaces.IX5WebSettings.RenderPriority.valueOf(renderPriority.name()));
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setRenderPriority(android.webkit.WebSettings.RenderPriority.valueOf(renderPriority.name()));
        }
    }

    public synchronized void setSansSerifFontFamily(java.lang.String str) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setSansSerifFontFamily(str);
        } else if (this.c || (webSettings = this.b) == null) {
        } else {
            webSettings.setSansSerifFontFamily(str);
        }
    }

    public void setSaveFormData(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setSaveFormData(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setSaveFormData(z);
        }
    }

    public void setSavePassword(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setSavePassword(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setSavePassword(z);
        }
    }

    public synchronized void setSerifFontFamily(java.lang.String str) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setSerifFontFamily(str);
        } else if (this.c || (webSettings = this.b) == null) {
        } else {
            webSettings.setSerifFontFamily(str);
        }
    }

    public synchronized void setStandardFontFamily(java.lang.String str) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setStandardFontFamily(str);
        } else if (this.c || (webSettings = this.b) == null) {
        } else {
            webSettings.setStandardFontFamily(str);
        }
    }

    public void setSupportMultipleWindows(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setSupportMultipleWindows(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setSupportMultipleWindows(z);
        }
    }

    public void setSupportZoom(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setSupportZoom(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setSupportZoom(z);
        }
    }

    public void setTextSize(com.tencent.smtt.sdk.WebSettings.TextSize textSize) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setTextSize(com.tencent.smtt.export.external.interfaces.IX5WebSettings.TextSize.valueOf(textSize.name()));
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setTextSize(android.webkit.WebSettings.TextSize.valueOf(textSize.name()));
        }
    }

    @android.annotation.TargetApi(14)
    public synchronized void setTextZoom(int i) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        try {
            if (this.c && (iX5WebSettings = this.f885a) != null) {
                iX5WebSettings.setTextZoom(i);
            } else if (!this.c && (webSettings = this.b) != null) {
                if (android.os.Build.VERSION.SDK_INT < 14) {
                    return;
                }
                try {
                    webSettings.setTextZoom(i);
                } catch (java.lang.Exception unused) {
                    com.tencent.smtt.utils.k.a(this.b, "setTextZoom", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
                }
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    @java.lang.Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setUseWebViewBackgroundForOverscrollBackground(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setUseWebViewBackgroundForOverscrollBackground", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }

    public void setUseWideViewPort(boolean z) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setUseWideViewPort(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setUseWideViewPort(z);
        }
    }

    public void setUserAgent(java.lang.String str) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setUserAgent(str);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setUserAgentString(str);
        }
    }

    @android.annotation.TargetApi(3)
    public void setUserAgentString(java.lang.String str) {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            iX5WebSettings.setUserAgentString(str);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setUserAgentString(str);
        }
    }

    public synchronized boolean supportMultipleWindows() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.supportMultipleWindows();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.supportMultipleWindows();
    }

    public boolean supportZoom() {
        android.webkit.WebSettings webSettings;
        com.tencent.smtt.export.external.interfaces.IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f885a) != null) {
            return iX5WebSettings.supportZoom();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.supportZoom();
    }
}
