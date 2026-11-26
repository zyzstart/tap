package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WebView extends android.widget.FrameLayout implements android.view.View.OnLongClickListener {
    public static final int GETPVERROR = -1;
    public static final int NIGHT_MODE_COLOR = -16777216;
    public static final int NORMAL_MODE_ALPHA = 255;
    public static final java.lang.String SCHEME_GEO = "geo:0,0?q=";
    public static final java.lang.String SCHEME_MAILTO = "mailto:";
    public static final java.lang.String SCHEME_TEL = "tel:";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f887a;
    private final java.lang.String b;
    private boolean e;
    private com.tencent.smtt.export.external.interfaces.IX5WebViewBase f;
    private com.tencent.smtt.sdk.WebView.a g;
    private com.tencent.smtt.sdk.WebSettings h;
    private android.content.Context i;
    private boolean k;
    public com.tencent.smtt.sdk.WebViewCallbackClient mWebViewCallbackClient;
    private com.tencent.smtt.sdk.WebViewClient n;
    private com.tencent.smtt.sdk.WebChromeClient o;
    private final int q;
    private final int r;
    private final int s;
    private final java.lang.String t;
    private final java.lang.String u;
    private java.lang.Object x;
    private android.view.View.OnLongClickListener y;
    private static final java.util.concurrent.locks.Lock c = new java.util.concurrent.locks.ReentrantLock();
    private static java.io.OutputStream d = null;
    private static android.content.Context j = null;
    public static boolean mWebViewCreated = false;
    private static com.tencent.smtt.utils.o l = null;
    private static java.lang.reflect.Method m = null;
    private static java.lang.String p = null;
    public static boolean mSysWebviewCreated = false;
    private static android.graphics.Paint v = null;
    private static boolean w = true;
    public static int NIGHT_MODE_ALPHA = 153;

    public static class HitTestResult {

        @java.lang.Deprecated
        public static final int ANCHOR_TYPE = 1;
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult f895a;
        private android.webkit.WebView.HitTestResult b;

        public HitTestResult() {
            this.b = null;
            this.f895a = null;
            this.b = null;
        }

        public HitTestResult(android.webkit.WebView.HitTestResult hitTestResult) {
            this.b = null;
            this.f895a = null;
            this.b = hitTestResult;
        }

        public HitTestResult(com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult hitTestResult) {
            this.b = null;
            this.f895a = hitTestResult;
            this.b = null;
        }

        public java.lang.String getExtra() {
            com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult hitTestResult = this.f895a;
            if (hitTestResult != null) {
                return hitTestResult.getExtra();
            }
            android.webkit.WebView.HitTestResult hitTestResult2 = this.b;
            return hitTestResult2 != null ? hitTestResult2.getExtra() : "";
        }

        public int getType() {
            com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult hitTestResult = this.f895a;
            if (hitTestResult != null) {
                return hitTestResult.getType();
            }
            android.webkit.WebView.HitTestResult hitTestResult2 = this.b;
            if (hitTestResult2 != null) {
                return hitTestResult2.getType();
            }
            return 0;
        }
    }

    public interface PictureListener {
        void onNewPicture(com.tencent.smtt.sdk.WebView webView, android.graphics.Picture picture);
    }

    public class WebViewTransport {
        private com.tencent.smtt.sdk.WebView b;

        public WebViewTransport() {
        }

        public synchronized com.tencent.smtt.sdk.WebView getWebView() {
            return this.b;
        }

        public synchronized void setWebView(com.tencent.smtt.sdk.WebView webView) {
            this.b = webView;
        }
    }

    private class a extends android.webkit.WebView {
        public a(com.tencent.smtt.sdk.WebView webView, android.content.Context context) {
            this(context, null);
        }

        public a(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(com.tencent.smtt.sdk.WebView.this.d(context), attributeSet);
            if (com.tencent.smtt.sdk.QbSdk.getIsSysWebViewForcedByOuter() && com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                return;
            }
            com.tencent.smtt.sdk.CookieSyncManager.createInstance(com.tencent.smtt.sdk.WebView.this.i).startSync();
            try {
                java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new java.lang.Class[0]);
                declaredMethod.setAccessible(true);
                ((android.os.Handler) declaredMethod.invoke(null, new java.lang.Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new com.tencent.smtt.sdk.e());
                com.tencent.smtt.sdk.WebView.mSysWebviewCreated = true;
            } catch (java.lang.Exception unused) {
            }
        }

        public void a() {
            super.computeScroll();
        }

        public void a(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
        }

        @android.annotation.TargetApi(9)
        public void a(int i, int i2, boolean z, boolean z2) {
            if (android.os.Build.VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        @android.annotation.TargetApi(9)
        public boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            if (android.os.Build.VERSION.SDK_INT >= 9) {
                return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            }
            return false;
        }

        public boolean a(android.view.MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public boolean b(android.view.MotionEvent motionEvent) {
            return super.dispatchTouchEvent(motionEvent);
        }

        public boolean c(android.view.MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView, android.view.View
        public void computeScroll() {
            com.tencent.smtt.sdk.WebViewCallbackClient webViewCallbackClient = com.tencent.smtt.sdk.WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.computeScroll(this);
            } else {
                super.computeScroll();
            }
        }

        @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
        protected void dispatchDraw(android.graphics.Canvas canvas) {
            try {
                super.dispatchDraw(canvas);
                if (com.tencent.smtt.sdk.WebView.w || com.tencent.smtt.sdk.WebView.v == null) {
                    return;
                }
                canvas.save();
                canvas.drawPaint(com.tencent.smtt.sdk.WebView.v);
                canvas.restore();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
            com.tencent.smtt.sdk.WebViewCallbackClient webViewCallbackClient = com.tencent.smtt.sdk.WebView.this.mWebViewCallbackClient;
            return webViewCallbackClient != null ? webViewCallbackClient.dispatchTouchEvent(motionEvent, this) : super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView
        public android.webkit.WebSettings getSettings() {
            try {
                return super.getSettings();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            com.tencent.smtt.sdk.WebViewCallbackClient webViewCallbackClient = com.tencent.smtt.sdk.WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.invalidate();
            }
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
            com.tencent.smtt.sdk.WebViewCallbackClient webViewCallbackClient = com.tencent.smtt.sdk.WebView.this.mWebViewCallbackClient;
            return webViewCallbackClient != null ? webViewCallbackClient.onInterceptTouchEvent(motionEvent, this) : super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView, android.view.View
        @android.annotation.TargetApi(9)
        public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            com.tencent.smtt.sdk.WebViewCallbackClient webViewCallbackClient = com.tencent.smtt.sdk.WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.onOverScrolled(i, i2, z, z2, this);
            } else if (android.os.Build.VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        @Override // android.webkit.WebView, android.view.View
        protected void onScrollChanged(int i, int i2, int i3, int i4) {
            com.tencent.smtt.sdk.WebViewCallbackClient webViewCallbackClient = com.tencent.smtt.sdk.WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.onScrollChanged(i, i2, i3, i4, this);
            } else {
                super.onScrollChanged(i, i2, i3, i4);
                com.tencent.smtt.sdk.WebView.this.onScrollChanged(i, i2, i3, i4);
            }
        }

        @Override // android.webkit.WebView, android.view.View
        @android.annotation.SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
            if (!hasFocus()) {
                requestFocus();
            }
            com.tencent.smtt.sdk.WebViewCallbackClient webViewCallbackClient = com.tencent.smtt.sdk.WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                return webViewCallbackClient.onTouchEvent(motionEvent, this);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override // android.view.View
        @android.annotation.TargetApi(9)
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            com.tencent.smtt.sdk.WebViewCallbackClient webViewCallbackClient = com.tencent.smtt.sdk.WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                return webViewCallbackClient.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, this);
            }
            if (android.os.Build.VERSION.SDK_INT >= 9) {
                return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            }
            return false;
        }

        @Override // android.webkit.WebView, android.view.View
        public void setOverScrollMode(int i) {
            try {
                super.setOverScrollMode(i);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public WebView(android.content.Context context) {
        this(context, (android.util.AttributeSet) null);
    }

    public WebView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false);
    }

    @android.annotation.TargetApi(11)
    public WebView(android.content.Context context, android.util.AttributeSet attributeSet, int i, java.util.Map map, boolean z) {
        super(context, attributeSet, i);
        this.b = "WebView";
        this.e = false;
        this.h = null;
        this.i = null;
        this.f887a = 0;
        this.k = false;
        this.n = null;
        this.o = null;
        this.q = 1;
        this.r = 2;
        this.s = 3;
        this.t = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.u = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.x = null;
        this.y = null;
        mWebViewCreated = true;
        if (com.tencent.smtt.sdk.QbSdk.getIsSysWebViewForcedByOuter() && com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
            this.i = context;
            this.f = null;
            this.e = false;
            com.tencent.smtt.sdk.QbSdk.a(context, "failed to createTBSWebview!");
            this.g = new com.tencent.smtt.sdk.WebView.a(context, attributeSet);
            com.tencent.smtt.sdk.CookieManager.getInstance().a(context, true, false);
            com.tencent.smtt.sdk.CookieSyncManager.createInstance(this.i).startSync();
            try {
                java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new java.lang.Class[0]);
                declaredMethod.setAccessible(true);
                ((android.os.Handler) declaredMethod.invoke(null, new java.lang.Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new com.tencent.smtt.sdk.e());
                mSysWebviewCreated = true;
            } catch (java.lang.Exception unused) {
            }
            com.tencent.smtt.sdk.CookieManager.getInstance().a();
            this.g.setFocusableInTouchMode(true);
            addView(this.g, new android.widget.FrameLayout.LayoutParams(-1, -1));
            com.tencent.smtt.utils.TbsLog.i("WebView", "SystemWebView Created Success! #3");
            com.tencent.smtt.utils.TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, 402, new java.lang.Throwable());
            return;
        }
        if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
            com.tencent.smtt.utils.TbsLog.setWriteLogJIT(true);
        } else {
            com.tencent.smtt.utils.TbsLog.setWriteLogJIT(false);
        }
        com.tencent.smtt.utils.TbsLog.initIfNeed(context);
        if (context == null) {
            throw new java.lang.IllegalArgumentException("Invalid context argument");
        }
        if (l == null) {
            l = com.tencent.smtt.utils.o.a(context);
        }
        if (l.f982a) {
            com.tencent.smtt.utils.TbsLog.e("WebView", "sys WebView: debug.conf force syswebview", true);
            com.tencent.smtt.sdk.QbSdk.a(context, "debug.conf force syswebview!");
        }
        c(context);
        this.i = context;
        if (context != null) {
            j = context.getApplicationContext();
        }
        if (!this.e || com.tencent.smtt.sdk.QbSdk.f818a) {
            this.f = null;
            if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(this.i)) {
                this.g = new com.tencent.smtt.sdk.WebView.a(context, attributeSet);
            } else {
                this.g = new com.tencent.smtt.sdk.WebView.a(this, context);
            }
            com.tencent.smtt.utils.TbsLog.i("WebView", "SystemWebView Created Success! #2");
            com.tencent.smtt.sdk.CookieManager.getInstance().a(context, true, false);
            com.tencent.smtt.sdk.CookieManager.getInstance().a();
            this.g.setFocusableInTouchMode(true);
            addView(this.g, new android.widget.FrameLayout.LayoutParams(-1, -1));
            setDownloadListener(null);
            com.tencent.smtt.utils.TbsLog.writeLogToDisk();
            com.tencent.smtt.sdk.m.a(context);
        } else {
            com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBaseA = com.tencent.smtt.sdk.u.a().a(true).a(context);
            this.f = iX5WebViewBaseA;
            if (iX5WebViewBaseA == null || iX5WebViewBaseA.getView() == null) {
                com.tencent.smtt.utils.TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
                this.f = null;
                this.e = false;
                com.tencent.smtt.sdk.QbSdk.a(context, "failed to createTBSWebview!");
                c(context);
                if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(this.i)) {
                    this.g = new com.tencent.smtt.sdk.WebView.a(context, attributeSet);
                } else {
                    this.g = new com.tencent.smtt.sdk.WebView.a(this, context);
                }
                com.tencent.smtt.utils.TbsLog.i("WebView", "SystemWebView Created Success! #1");
                com.tencent.smtt.sdk.CookieManager.getInstance().a(context, true, false);
                com.tencent.smtt.sdk.CookieManager.getInstance().a();
                this.g.setFocusableInTouchMode(true);
                addView(this.g, new android.widget.FrameLayout.LayoutParams(-1, -1));
                try {
                    if (android.os.Build.VERSION.SDK_INT >= 11) {
                        removeJavascriptInterface("searchBoxJavaBridge_");
                        removeJavascriptInterface("accessibility");
                        removeJavascriptInterface("accessibilityTraversal");
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                com.tencent.smtt.utils.TbsLog.writeLogToDisk();
                com.tencent.smtt.sdk.m.a(context);
                return;
            }
            com.tencent.smtt.utils.TbsLog.i("WebView", "X5 WebView Created Success!!");
            this.f.getView().setFocusableInTouchMode(true);
            a(attributeSet);
            addView(this.f.getView(), new android.widget.FrameLayout.LayoutParams(-1, -1));
            this.f.setDownloadListener(new com.tencent.smtt.sdk.b(this, null, this.e));
            this.f.getX5WebViewExtension().setWebViewClientExtension(new com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension(com.tencent.smtt.sdk.u.a().a(true).k()) { // from class: com.tencent.smtt.sdk.WebView.1
                @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
                public void invalidate() {
                }

                @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
                public void onScrollChanged(int i2, int i3, int i4, int i5) {
                    super.onScrollChanged(i2, i3, i4, i5);
                    com.tencent.smtt.sdk.WebView.this.onScrollChanged(i4, i5, i2, i3);
                }
            });
        }
        try {
            if (android.os.Build.VERSION.SDK_INT >= 11) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
        if (("com.tencent.mobileqq".equals(this.i.getApplicationInfo().packageName) || "com.tencent.mm".equals(this.i.getApplicationInfo().packageName)) && com.tencent.smtt.sdk.d.a(true).h() && android.os.Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        if (this.f != null) {
            com.tencent.smtt.utils.TbsLog.writeLogToDisk();
            if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                int i2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                if (i2 <= 0 || i2 == com.tencent.smtt.sdk.m.a().h(context) || i2 != com.tencent.smtt.sdk.m.a().i(context)) {
                    com.tencent.smtt.utils.TbsLog.i("WebView", "webview construction #1 deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + com.tencent.smtt.sdk.m.a().h(context) + " getTbsCoreInstalledVerInNolock is " + com.tencent.smtt.sdk.m.a().i(context));
                } else {
                    com.tencent.smtt.sdk.m.a().n(context);
                }
            }
        }
        com.tencent.smtt.sdk.QbSdk.continueLoadSo(context);
    }

    public WebView(android.content.Context context, android.util.AttributeSet attributeSet, int i, boolean z) {
        this(context, attributeSet, i, null, z);
    }

    public WebView(android.content.Context context, boolean z) {
        super(context);
        this.b = "WebView";
        this.e = false;
        this.h = null;
        this.i = null;
        this.f887a = 0;
        this.k = false;
        this.n = null;
        this.o = null;
        this.q = 1;
        this.r = 2;
        this.s = 3;
        this.t = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.u = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.x = null;
        this.y = null;
    }

    private void a(android.util.AttributeSet attributeSet) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase;
        if (attributeSet != null) {
            try {
                int attributeCount = attributeSet.getAttributeCount();
                for (int i = 0; i < attributeCount; i++) {
                    if (attributeSet.getAttributeName(i).equalsIgnoreCase("scrollbars")) {
                        int[] intArray = getResources().getIntArray(android.R.attr.scrollbars);
                        int attributeIntValue = attributeSet.getAttributeIntValue(i, -1);
                        if (attributeIntValue == intArray[1]) {
                            this.f.getView().setVerticalScrollBarEnabled(false);
                            iX5WebViewBase = this.f;
                        } else if (attributeIntValue == intArray[2]) {
                            this.f.getView().setVerticalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[3]) {
                            iX5WebViewBase = this.f;
                        }
                        iX5WebViewBase.getView().setHorizontalScrollBarEnabled(false);
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean a(android.view.View view) {
        java.lang.Object objA;
        android.content.Context context = this.i;
        if ((context == null || getTbsCoreVersion(context) <= 36200) && (objA = com.tencent.smtt.utils.k.a(this.x, "onLongClick", new java.lang.Class[]{android.view.View.class}, view)) != null) {
            return ((java.lang.Boolean) objA).booleanValue();
        }
        return false;
    }

    private boolean b(android.content.Context context) {
        try {
            return context.getPackageName().indexOf("com.tencent.mobileqq") >= 0;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private void c(android.content.Context context) {
        if (com.tencent.smtt.sdk.QbSdk.i && com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
            com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(context);
        }
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        uVarA.a(context);
        this.e = uVarA.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.content.Context d(android.content.Context context) {
        int i = android.os.Build.VERSION.SDK_INT;
        return (i < 21 || i > 22) ? context : context.createConfigurationContext(new android.content.res.Configuration());
    }

    static void d() {
        try {
            new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.smtt.sdk.WebView.8
                @Override // java.lang.Runnable
                public void run() {
                    if (com.tencent.smtt.sdk.WebView.j == null) {
                        com.tencent.smtt.utils.TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
                        return;
                    }
                    com.tencent.smtt.sdk.d dVarA = com.tencent.smtt.sdk.d.a(true);
                    if (com.tencent.smtt.sdk.d.b) {
                        com.tencent.smtt.utils.TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
                        return;
                    }
                    com.tencent.smtt.sdk.k kVarA = com.tencent.smtt.sdk.k.a(com.tencent.smtt.sdk.WebView.j);
                    int iC = kVarA.c();
                    com.tencent.smtt.utils.TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + iC);
                    if (iC == 2) {
                        com.tencent.smtt.utils.TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
                        dVarA.a(java.lang.String.valueOf(kVarA.b()));
                        dVarA.b(true);
                        return;
                    }
                    int iB = kVarA.b("copy_status");
                    com.tencent.smtt.utils.TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + iB);
                    if (iB == 1) {
                        com.tencent.smtt.utils.TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
                        dVarA.a(java.lang.String.valueOf(kVarA.c("copy_core_ver")));
                        dVarA.b(true);
                    } else {
                        if (com.tencent.smtt.sdk.u.a().b()) {
                            return;
                        }
                        if (iC == 3 || iB == 3) {
                            com.tencent.smtt.utils.TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
                            dVarA.a(java.lang.String.valueOf(com.tencent.smtt.sdk.d.d()));
                            dVarA.b(true);
                        }
                    }
                }
            }).start();
        } catch (java.lang.Throwable th) {
            com.tencent.smtt.utils.TbsLog.e("webview", "updateRebootStatus excpetion: " + th);
        }
    }

    @java.lang.Deprecated
    public static void disablePlatformNotifications() {
        if (com.tencent.smtt.sdk.u.a().b()) {
            return;
        }
        com.tencent.smtt.utils.k.a("android.webkit.WebView", "disablePlatformNotifications");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.FileInputStream] */
    private int e(android.content.Context context) throws java.lang.Throwable {
        java.nio.channels.FileLock fileLockA;
        java.lang.StringBuilder sb;
        java.io.FileOutputStream fileOutputStreamB = com.tencent.smtt.utils.f.b(context, true, "tbslock.txt");
        if (fileOutputStreamB == null || (fileLockA = com.tencent.smtt.utils.f.a(context, fileOutputStreamB)) == null) {
            return -1;
        }
        if (!c.tryLock()) {
            com.tencent.smtt.utils.f.a(fileLockA, fileOutputStreamB);
            return -1;
        }
        ?? r3 = 0;
        r3 = 0;
        java.io.FileInputStream fileInputStream = null;
        try {
            try {
                java.io.File file = new java.io.File(com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context) + java.io.File.separator + "core_private", "pv.db");
                if (file.exists()) {
                    java.util.Properties properties = new java.util.Properties();
                    java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
                    try {
                        properties.load(fileInputStream2);
                        fileInputStream2.close();
                        java.lang.String str = "PV";
                        java.lang.String property = properties.getProperty("PV");
                        if (property != null) {
                            int i = java.lang.Integer.parseInt(property);
                            try {
                                fileInputStream2.close();
                            } catch (java.io.IOException e) {
                                com.tencent.smtt.utils.TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e.toString());
                            }
                            c.unlock();
                            com.tencent.smtt.utils.f.a(fileLockA, fileOutputStreamB);
                            return i;
                        }
                        try {
                            fileInputStream2.close();
                            r3 = str;
                        } catch (java.io.IOException e2) {
                            e = e2;
                            sb = new java.lang.StringBuilder();
                            sb.append("TbsInstaller--getTbsCorePV IOException=");
                            sb.append(e.toString());
                            com.tencent.smtt.utils.TbsLog.e("getTbsCorePV", sb.toString());
                        }
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        fileInputStream = fileInputStream2;
                        com.tencent.smtt.utils.TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
                        r3 = fileInputStream;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                r3 = fileInputStream;
                            } catch (java.io.IOException e4) {
                                e = e4;
                                sb = new java.lang.StringBuilder();
                                sb.append("TbsInstaller--getTbsCorePV IOException=");
                                sb.append(e.toString());
                                com.tencent.smtt.utils.TbsLog.e("getTbsCorePV", sb.toString());
                            }
                        }
                        c.unlock();
                        com.tencent.smtt.utils.f.a(fileLockA, fileOutputStreamB);
                        return -1;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        r3 = fileInputStream2;
                        if (r3 != 0) {
                            try {
                                r3.close();
                            } catch (java.io.IOException e5) {
                                com.tencent.smtt.utils.TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e5.toString());
                            }
                        }
                        c.unlock();
                        com.tencent.smtt.utils.f.a(fileLockA, fileOutputStreamB);
                        throw th;
                    }
                    sb.append("TbsInstaller--getTbsCorePV IOException=");
                    sb.append(e.toString());
                    com.tencent.smtt.utils.TbsLog.e("getTbsCorePV", sb.toString());
                    c.unlock();
                    com.tencent.smtt.utils.f.a(fileLockA, fileOutputStreamB);
                    return -1;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e6) {
            e = e6;
        }
        c.unlock();
        com.tencent.smtt.utils.f.a(fileLockA, fileOutputStreamB);
        return -1;
    }

    @java.lang.Deprecated
    public static void enablePlatformNotifications() {
        if (com.tencent.smtt.sdk.u.a().b()) {
            return;
        }
        com.tencent.smtt.utils.k.a("android.webkit.WebView", "enablePlatformNotifications");
    }

    private void f(android.content.Context context) {
        try {
            java.io.File file = new java.io.File(com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context) + java.io.File.separator + "core_private", "pv.db");
            if (file.exists()) {
                file.delete();
            }
        } catch (java.lang.Exception e) {
            com.tencent.smtt.utils.TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
        }
    }

    public static java.lang.String findAddress(java.lang.String str) {
        if (com.tencent.smtt.sdk.u.a().b()) {
            return null;
        }
        return android.webkit.WebView.findAddress(str);
    }

    public static java.lang.String getCrashExtraMessage(android.content.Context context) {
        java.util.Map map;
        if (context == null) {
            return "";
        }
        java.lang.String str = "tbs_core_version:" + com.tencent.smtt.sdk.QbSdk.getTbsVersionForCrash(context) + ";tbs_sdk_version:43903;";
        boolean z = false;
        if ("com.tencent.mm".equals(context.getApplicationInfo().packageName)) {
            try {
                java.lang.Class.forName("de.robv.android.xposed.XposedBridge");
                z = true;
            } catch (java.lang.ClassNotFoundException unused) {
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        if (z) {
            return str + "isXposed=true;";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.tencent.smtt.sdk.d.a(true).e());
        sb.append("\n");
        sb.append(str);
        if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context) && (map = com.tencent.smtt.sdk.QbSdk.n) != null && map.containsKey(com.tencent.smtt.export.external.TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && com.tencent.smtt.sdk.QbSdk.n.containsKey(com.tencent.smtt.export.external.TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            java.lang.String str2 = "weapp_id:" + com.tencent.smtt.sdk.QbSdk.n.get(com.tencent.smtt.export.external.TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) + ";" + com.tencent.smtt.export.external.TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY + ":" + com.tencent.smtt.sdk.QbSdk.n.get(com.tencent.smtt.export.external.TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY) + ";";
            sb.append("\n");
            sb.append(str2);
        }
        return sb.length() > 8192 ? sb.substring(sb.length() - 8192) : sb.toString();
    }

    public static android.content.pm.PackageInfo getCurrentWebViewPackage() {
        if (com.tencent.smtt.sdk.u.a().b() || android.os.Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            return (android.content.pm.PackageInfo) com.tencent.smtt.utils.k.a("android.webkit.WebView", "getCurrentWebViewPackage");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @java.lang.Deprecated
    public static synchronized java.lang.Object getPluginList() {
        if (com.tencent.smtt.sdk.u.a().b()) {
            return null;
        }
        return com.tencent.smtt.utils.k.a("android.webkit.WebView", "getPluginList");
    }

    public static int getTbsCoreVersion(android.content.Context context) {
        return com.tencent.smtt.sdk.QbSdk.getTbsVersion(context);
    }

    public static boolean getTbsNeedReboot() {
        d();
        return com.tencent.smtt.sdk.d.a(true).f();
    }

    public static int getTbsSDKVersion(android.content.Context context) {
        return 43903;
    }

    private long h() {
        long j2;
        synchronized (com.tencent.smtt.sdk.QbSdk.h) {
            if (com.tencent.smtt.sdk.QbSdk.e) {
                com.tencent.smtt.sdk.QbSdk.g += java.lang.System.currentTimeMillis() - com.tencent.smtt.sdk.QbSdk.f;
                com.tencent.smtt.utils.TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + com.tencent.smtt.sdk.QbSdk.g);
            }
            j2 = com.tencent.smtt.sdk.QbSdk.g / 1000;
            com.tencent.smtt.sdk.QbSdk.g = 0L;
            com.tencent.smtt.sdk.QbSdk.f = java.lang.System.currentTimeMillis();
        }
        return j2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void setSysDayOrNight(boolean z) {
        int i;
        android.graphics.Paint paint;
        if (z == w) {
            return;
        }
        w = z;
        if (v == null) {
            android.graphics.Paint paint2 = new android.graphics.Paint();
            v = paint2;
            paint2.setColor(-16777216);
        }
        if (z) {
            i = 255;
            if (v.getAlpha() != 255) {
                paint = v;
                paint.setAlpha(i);
            }
        } else {
            int alpha = v.getAlpha();
            i = NIGHT_MODE_ALPHA;
            if (alpha != i) {
                paint = v;
                paint.setAlpha(i);
            }
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA != null && uVarA.b()) {
            uVarA.c().a(z);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            try {
                java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", java.lang.Boolean.TYPE);
                m = declaredMethod;
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    m.invoke(null, java.lang.Boolean.valueOf(z));
                }
            } catch (java.lang.Exception e) {
                com.tencent.smtt.utils.TbsLog.e("QbSdk", "Exception:" + e.getStackTrace());
                e.printStackTrace();
            }
        }
    }

    protected void a() throws java.lang.Throwable {
        boolean zIsX5CoreSandboxMode;
        android.os.Bundle sdkQBStatisticsInfo;
        if (!this.k && this.f887a != 0) {
            this.k = true;
            java.lang.String string = "";
            java.lang.String string2 = "";
            java.lang.String string3 = "";
            if (this.e && (sdkQBStatisticsInfo = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo()) != null) {
                string = sdkQBStatisticsInfo.getString(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_GUID);
                string2 = sdkQBStatisticsInfo.getString("qua2");
                string3 = sdkQBStatisticsInfo.getString("lc");
            }
            java.lang.String str = string;
            java.lang.String str2 = string2;
            java.lang.String str3 = string3;
            if ("com.qzone".equals(this.i.getApplicationInfo().packageName)) {
                int iE = e(this.i);
                if (iE == -1) {
                    iE = this.f887a;
                }
                this.f887a = iE;
                f(this.i);
            }
            try {
                zIsX5CoreSandboxMode = this.f.getX5WebViewExtension().isX5CoreSandboxMode();
            } catch (java.lang.Throwable th) {
                com.tencent.smtt.utils.TbsLog.w("tbsOnDetachedFromWindow", "exception: " + th);
                zIsX5CoreSandboxMode = false;
            }
            com.tencent.smtt.sdk.a.b.a(this.i, str, str2, str3, this.f887a, this.e, h(), zIsX5CoreSandboxMode);
            this.f887a = 0;
            this.k = false;
        }
        super.onDetachedFromWindow();
    }

    void a(android.content.Context context) throws java.lang.Throwable {
        java.lang.String str;
        int iE = e(context);
        if (iE != -1) {
            str = "PV=" + java.lang.String.valueOf(iE + 1);
        } else {
            str = "PV=1";
        }
        java.io.File file = new java.io.File(com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context) + java.io.File.separator + "core_private", "pv.db");
        try {
            try {
                file.getParentFile().mkdirs();
                if (!file.isFile() || !file.exists()) {
                    file.createNewFile();
                }
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file, false);
                d = fileOutputStream;
                fileOutputStream.write(str.getBytes());
            } finally {
                if (d != null) {
                    d.flush();
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    void a(android.webkit.WebView webView) {
    }

    void a(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase) {
        this.f = iX5WebViewBase;
    }

    public void addJavascriptInterface(java.lang.Object obj, java.lang.String str) {
        if (this.e) {
            this.f.addJavascriptInterface(obj, str);
        } else {
            this.g.addJavascriptInterface(obj, str);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view) {
        if (!this.e) {
            this.g.addView(view);
            return;
        }
        android.view.View view2 = this.f.getView();
        try {
            java.lang.reflect.Method methodA = com.tencent.smtt.utils.k.a(view2, "addView", android.view.View.class);
            methodA.setAccessible(true);
            methodA.invoke(view2, view);
        } catch (java.lang.Throwable unused) {
        }
    }

    android.webkit.WebView b() {
        if (this.e) {
            return null;
        }
        return this.g;
    }

    com.tencent.smtt.export.external.interfaces.IX5WebViewBase c() {
        return this.f;
    }

    public boolean canGoBack() {
        return !this.e ? this.g.canGoBack() : this.f.canGoBack();
    }

    public boolean canGoBackOrForward(int i) {
        return !this.e ? this.g.canGoBackOrForward(i) : this.f.canGoBackOrForward(i);
    }

    public boolean canGoForward() {
        return !this.e ? this.g.canGoForward() : this.f.canGoForward();
    }

    @java.lang.Deprecated
    public boolean canZoomIn() {
        java.lang.Object objA;
        if (this.e) {
            return this.f.canZoomIn();
        }
        if (android.os.Build.VERSION.SDK_INT < 11 || (objA = com.tencent.smtt.utils.k.a(this.g, "canZoomIn")) == null) {
            return false;
        }
        return ((java.lang.Boolean) objA).booleanValue();
    }

    @java.lang.Deprecated
    public boolean canZoomOut() {
        java.lang.Object objA;
        if (this.e) {
            return this.f.canZoomOut();
        }
        if (android.os.Build.VERSION.SDK_INT < 11 || (objA = com.tencent.smtt.utils.k.a(this.g, "canZoomOut")) == null) {
            return false;
        }
        return ((java.lang.Boolean) objA).booleanValue();
    }

    @java.lang.Deprecated
    public android.graphics.Picture capturePicture() {
        if (this.e) {
            return this.f.capturePicture();
        }
        java.lang.Object objA = com.tencent.smtt.utils.k.a(this.g, "capturePicture");
        if (objA == null) {
            return null;
        }
        return (android.graphics.Picture) objA;
    }

    public void clearCache(boolean z) {
        if (this.e) {
            this.f.clearCache(z);
        } else {
            this.g.clearCache(z);
        }
    }

    public void clearFormData() {
        if (this.e) {
            this.f.clearFormData();
        } else {
            this.g.clearFormData();
        }
    }

    public void clearHistory() {
        if (this.e) {
            this.f.clearHistory();
        } else {
            this.g.clearHistory();
        }
    }

    @android.annotation.TargetApi(3)
    public void clearMatches() {
        if (this.e) {
            this.f.clearMatches();
        } else {
            this.g.clearMatches();
        }
    }

    public void clearSslPreferences() {
        if (this.e) {
            this.f.clearSslPreferences();
        } else {
            this.g.clearSslPreferences();
        }
    }

    @java.lang.Deprecated
    public void clearView() {
        if (this.e) {
            this.f.clearView();
        } else {
            com.tencent.smtt.utils.k.a(this.g, "clearView");
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        try {
            if (this.e) {
                java.lang.reflect.Method methodA = com.tencent.smtt.utils.k.a(this.f.getView(), "computeHorizontalScrollExtent", new java.lang.Class[0]);
                methodA.setAccessible(true);
                return ((java.lang.Integer) methodA.invoke(this.f.getView(), new java.lang.Object[0])).intValue();
            }
            java.lang.reflect.Method methodA2 = com.tencent.smtt.utils.k.a(this.g, "computeHorizontalScrollExtent", new java.lang.Class[0]);
            methodA2.setAccessible(true);
            return ((java.lang.Integer) methodA2.invoke(this.g, new java.lang.Object[0])).intValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        try {
            if (this.e) {
                java.lang.reflect.Method methodA = com.tencent.smtt.utils.k.a(this.f.getView(), "computeHorizontalScrollOffset", new java.lang.Class[0]);
                methodA.setAccessible(true);
                return ((java.lang.Integer) methodA.invoke(this.f.getView(), new java.lang.Object[0])).intValue();
            }
            java.lang.reflect.Method methodA2 = com.tencent.smtt.utils.k.a(this.g, "computeHorizontalScrollOffset", new java.lang.Class[0]);
            methodA2.setAccessible(true);
            return ((java.lang.Integer) methodA2.invoke(this.g, new java.lang.Object[0])).intValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        try {
            if (this.e) {
                return ((java.lang.Integer) com.tencent.smtt.utils.k.a(this.f.getView(), "computeHorizontalScrollRange", new java.lang.Class[0], new java.lang.Object[0])).intValue();
            }
            java.lang.reflect.Method methodA = com.tencent.smtt.utils.k.a(this.g, "computeHorizontalScrollRange", new java.lang.Class[0]);
            methodA.setAccessible(true);
            return ((java.lang.Integer) methodA.invoke(this.g, new java.lang.Object[0])).intValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.e) {
            this.f.computeScroll();
        } else {
            this.g.computeScroll();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        try {
            if (this.e) {
                java.lang.reflect.Method methodA = com.tencent.smtt.utils.k.a(this.f.getView(), "computeVerticalScrollExtent", new java.lang.Class[0]);
                methodA.setAccessible(true);
                return ((java.lang.Integer) methodA.invoke(this.f.getView(), new java.lang.Object[0])).intValue();
            }
            java.lang.reflect.Method methodA2 = com.tencent.smtt.utils.k.a(this.g, "computeVerticalScrollExtent", new java.lang.Class[0]);
            methodA2.setAccessible(true);
            return ((java.lang.Integer) methodA2.invoke(this.g, new java.lang.Object[0])).intValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        try {
            if (this.e) {
                java.lang.reflect.Method methodA = com.tencent.smtt.utils.k.a(this.f.getView(), "computeVerticalScrollOffset", new java.lang.Class[0]);
                methodA.setAccessible(true);
                return ((java.lang.Integer) methodA.invoke(this.f.getView(), new java.lang.Object[0])).intValue();
            }
            java.lang.reflect.Method methodA2 = com.tencent.smtt.utils.k.a(this.g, "computeVerticalScrollOffset", new java.lang.Class[0]);
            methodA2.setAccessible(true);
            return ((java.lang.Integer) methodA2.invoke(this.g, new java.lang.Object[0])).intValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        try {
            if (this.e) {
                return ((java.lang.Integer) com.tencent.smtt.utils.k.a(this.f.getView(), "computeVerticalScrollRange", new java.lang.Class[0], new java.lang.Object[0])).intValue();
            }
            java.lang.reflect.Method methodA = com.tencent.smtt.utils.k.a(this.g, "computeVerticalScrollRange", new java.lang.Class[0]);
            methodA.setAccessible(true);
            return ((java.lang.Integer) methodA.invoke(this.g, new java.lang.Object[0])).intValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public com.tencent.smtt.sdk.WebBackForwardList copyBackForwardList() {
        return this.e ? com.tencent.smtt.sdk.WebBackForwardList.a(this.f.copyBackForwardList()) : com.tencent.smtt.sdk.WebBackForwardList.a(this.g.copyBackForwardList());
    }

    public java.lang.Object createPrintDocumentAdapter(java.lang.String str) {
        if (!this.e) {
            if (android.os.Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return com.tencent.smtt.utils.k.a(this.g, "createPrintDocumentAdapter", new java.lang.Class[]{java.lang.String.class}, str);
        }
        try {
            return this.f.createPrintDocumentAdapter(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void customDiskCachePathEnabled(boolean z, java.lang.String str) {
        if (!this.e || getX5WebViewExtension() == null) {
            return;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putBoolean("enabled", z);
        bundle.putString("path", str);
        getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", bundle);
    }

    public void destroy() {
        try {
            if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName)) {
                new java.lang.Thread("WebviewDestroy") { // from class: com.tencent.smtt.sdk.WebView.2
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() throws java.lang.Throwable {
                        com.tencent.smtt.sdk.WebView.this.tbsWebviewDestroy(false);
                    }
                }.start();
                if (this.e) {
                    this.f.destroy();
                } else {
                    this.g.destroy();
                }
            } else {
                tbsWebviewDestroy(true);
            }
        } catch (java.lang.Throwable unused) {
            tbsWebviewDestroy(true);
        }
    }

    public void documentHasImages(android.os.Message message) {
        if (this.e) {
            this.f.documentHasImages(message);
        } else {
            this.g.documentHasImages(message);
        }
    }

    public void dumpViewHierarchyWithProperties(java.io.BufferedWriter bufferedWriter, int i) {
        if (this.e) {
            this.f.dumpViewHierarchyWithProperties(bufferedWriter, i);
        } else {
            com.tencent.smtt.utils.k.a(this.g, "dumpViewHierarchyWithProperties", new java.lang.Class[]{java.io.BufferedWriter.class, java.lang.Integer.TYPE}, bufferedWriter, java.lang.Integer.valueOf(i));
        }
    }

    public void evaluateJavascript(java.lang.String str, com.tencent.smtt.sdk.ValueCallback valueCallback) {
        if (this.e) {
            try {
                java.lang.reflect.Method methodA = com.tencent.smtt.utils.k.a(this.f.getView(), "evaluateJavascript", java.lang.String.class, android.webkit.ValueCallback.class);
                methodA.setAccessible(true);
                methodA.invoke(this.f.getView(), str, valueCallback);
                return;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                loadUrl(str);
                return;
            }
        }
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            try {
                java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", java.lang.String.class, android.webkit.ValueCallback.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.g, str, valueCallback);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @java.lang.Deprecated
    public int findAll(java.lang.String str) {
        if (this.e) {
            return this.f.findAll(str);
        }
        java.lang.Object objA = com.tencent.smtt.utils.k.a(this.g, "findAll", new java.lang.Class[]{java.lang.String.class}, str);
        if (objA == null) {
            return 0;
        }
        return ((java.lang.Integer) objA).intValue();
    }

    @android.annotation.TargetApi(16)
    public void findAllAsync(java.lang.String str) {
        if (this.e) {
            this.f.findAllAsync(str);
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            com.tencent.smtt.utils.k.a(this.g, "findAllAsync", new java.lang.Class[]{java.lang.String.class}, str);
        }
    }

    public android.view.View findHierarchyView(java.lang.String str, int i) {
        return !this.e ? (android.view.View) com.tencent.smtt.utils.k.a(this.g, "findHierarchyView", new java.lang.Class[]{java.lang.String.class, java.lang.Integer.TYPE}, str, java.lang.Integer.valueOf(i)) : this.f.findHierarchyView(str, i);
    }

    @android.annotation.TargetApi(3)
    public void findNext(boolean z) {
        if (this.e) {
            this.f.findNext(z);
        } else {
            this.g.findNext(z);
        }
    }

    public void flingScroll(int i, int i2) {
        if (this.e) {
            this.f.flingScroll(i, i2);
        } else {
            this.g.flingScroll(i, i2);
        }
    }

    @java.lang.Deprecated
    public void freeMemory() {
        if (this.e) {
            this.f.freeMemory();
        } else {
            com.tencent.smtt.utils.k.a(this.g, "freeMemory");
        }
    }

    public android.net.http.SslCertificate getCertificate() {
        return !this.e ? this.g.getCertificate() : this.f.getCertificate();
    }

    public int getContentHeight() {
        return !this.e ? this.g.getContentHeight() : this.f.getContentHeight();
    }

    public int getContentWidth() {
        if (this.e) {
            return this.f.getContentWidth();
        }
        java.lang.Object objA = com.tencent.smtt.utils.k.a(this.g, "getContentWidth");
        if (objA == null) {
            return 0;
        }
        return ((java.lang.Integer) objA).intValue();
    }

    public android.graphics.Bitmap getFavicon() {
        return !this.e ? this.g.getFavicon() : this.f.getFavicon();
    }

    public com.tencent.smtt.sdk.WebView.HitTestResult getHitTestResult() {
        return !this.e ? new com.tencent.smtt.sdk.WebView.HitTestResult(this.g.getHitTestResult()) : new com.tencent.smtt.sdk.WebView.HitTestResult(this.f.getHitTestResult());
    }

    public java.lang.String[] getHttpAuthUsernamePassword(java.lang.String str, java.lang.String str2) {
        return !this.e ? this.g.getHttpAuthUsernamePassword(str, str2) : this.f.getHttpAuthUsernamePassword(str, str2);
    }

    @android.annotation.TargetApi(3)
    public java.lang.String getOriginalUrl() {
        return !this.e ? this.g.getOriginalUrl() : this.f.getOriginalUrl();
    }

    public int getProgress() {
        return !this.e ? this.g.getProgress() : this.f.getProgress();
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        java.lang.Object objA;
        try {
            if (!this.e && android.os.Build.VERSION.SDK_INT >= 26 && (objA = com.tencent.smtt.utils.k.a(this.g, "getRendererPriorityWaivedWhenNotVisible")) != null) {
                return ((java.lang.Boolean) objA).booleanValue();
            }
            return false;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getRendererRequestedPriority() {
        java.lang.Object objA;
        try {
            if (!this.e && android.os.Build.VERSION.SDK_INT >= 26 && (objA = com.tencent.smtt.utils.k.a(this.g, "getRendererRequestedPriority")) != null) {
                return ((java.lang.Integer) objA).intValue();
            }
            return 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @java.lang.Deprecated
    public float getScale() {
        if (this.e) {
            return this.f.getScale();
        }
        java.lang.Object objA = com.tencent.smtt.utils.k.a(this.g, "getScale");
        if (objA == null) {
            return 0.0f;
        }
        return ((java.lang.Float) objA).floatValue();
    }

    @Override // android.view.View
    public int getScrollBarDefaultDelayBeforeFade() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarDefaultDelayBeforeFade();
    }

    @Override // android.view.View
    public int getScrollBarFadeDuration() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarFadeDuration();
    }

    @Override // android.view.View
    public int getScrollBarSize() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarSize();
    }

    @Override // android.view.View
    public int getScrollBarStyle() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarStyle();
    }

    public com.tencent.smtt.sdk.WebSettings getSettings() {
        com.tencent.smtt.sdk.WebSettings webSettings = this.h;
        if (webSettings != null) {
            return webSettings;
        }
        com.tencent.smtt.sdk.WebSettings webSettings2 = this.e ? new com.tencent.smtt.sdk.WebSettings(this.f.getSettings()) : new com.tencent.smtt.sdk.WebSettings(this.g.getSettings());
        this.h = webSettings2;
        return webSettings2;
    }

    public com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension getSettingsExtension() {
        if (this.e) {
            return this.f.getX5WebViewExtension().getSettingsExtension();
        }
        return null;
    }

    public int getSysNightModeAlpha() {
        return NIGHT_MODE_ALPHA;
    }

    public java.lang.String getTitle() {
        return !this.e ? this.g.getTitle() : this.f.getTitle();
    }

    public java.lang.String getUrl() {
        return !this.e ? this.g.getUrl() : this.f.getUrl();
    }

    public android.view.View getView() {
        return !this.e ? this.g : this.f.getView();
    }

    public int getVisibleTitleHeight() {
        if (this.e) {
            return this.f.getVisibleTitleHeight();
        }
        java.lang.Object objA = com.tencent.smtt.utils.k.a(this.g, "getVisibleTitleHeight");
        if (objA == null) {
            return 0;
        }
        return ((java.lang.Integer) objA).intValue();
    }

    public com.tencent.smtt.sdk.WebChromeClient getWebChromeClient() {
        return this.o;
    }

    public com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension getWebChromeClientExtension() {
        if (this.e) {
            return this.f.getX5WebViewExtension().getWebChromeClientExtension();
        }
        return null;
    }

    public int getWebScrollX() {
        return this.e ? this.f.getView().getScrollX() : this.g.getScrollX();
    }

    public int getWebScrollY() {
        return this.e ? this.f.getView().getScrollY() : this.g.getScrollY();
    }

    public com.tencent.smtt.sdk.WebViewClient getWebViewClient() {
        return this.n;
    }

    public com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension getWebViewClientExtension() {
        if (this.e) {
            return this.f.getX5WebViewExtension().getWebViewClientExtension();
        }
        return null;
    }

    public com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult getX5HitTestResult() {
        if (this.e) {
            return this.f.getHitTestResult();
        }
        return null;
    }

    public com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension getX5WebViewExtension() {
        if (this.e) {
            return this.f.getX5WebViewExtension();
        }
        return null;
    }

    @java.lang.Deprecated
    public android.view.View getZoomControls() {
        return !this.e ? (android.view.View) com.tencent.smtt.utils.k.a(this.g, "getZoomControls") : this.f.getZoomControls();
    }

    public void goBack() {
        if (this.e) {
            this.f.goBack();
        } else {
            this.g.goBack();
        }
    }

    public void goBackOrForward(int i) {
        if (this.e) {
            this.f.goBackOrForward(i);
        } else {
            this.g.goBackOrForward(i);
        }
    }

    public void goForward() {
        if (this.e) {
            this.f.goForward();
        } else {
            this.g.goForward();
        }
    }

    public void invokeZoomPicker() {
        if (this.e) {
            this.f.invokeZoomPicker();
        } else {
            this.g.invokeZoomPicker();
        }
    }

    public boolean isDayMode() {
        return w;
    }

    public boolean isPrivateBrowsingEnabled() {
        java.lang.Object objA;
        if (this.e) {
            return this.f.isPrivateBrowsingEnable();
        }
        if (android.os.Build.VERSION.SDK_INT < 11 || (objA = com.tencent.smtt.utils.k.a(this.g, "isPrivateBrowsingEnabled")) == null) {
            return false;
        }
        return ((java.lang.Boolean) objA).booleanValue();
    }

    public void loadData(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (this.e) {
            this.f.loadData(str, str2, str3);
        } else {
            this.g.loadData(str, str2, str3);
        }
    }

    public void loadDataWithBaseURL(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        if (this.e) {
            this.f.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            this.g.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void loadUrl(java.lang.String str) {
        if (str == null || showDebugView(str)) {
            return;
        }
        if (this.e) {
            this.f.loadUrl(str);
        } else {
            this.g.loadUrl(str);
        }
    }

    @android.annotation.TargetApi(8)
    public void loadUrl(java.lang.String str, java.util.Map map) {
        if (str == null || showDebugView(str)) {
            return;
        }
        if (this.e) {
            this.f.loadUrl(str, map);
        } else if (android.os.Build.VERSION.SDK_INT >= 8) {
            this.g.loadUrl(str, map);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() throws java.lang.Throwable {
        try {
            if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName)) {
                new java.lang.Thread("onDetachedFromWindow") { // from class: com.tencent.smtt.sdk.WebView.7
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() throws java.lang.Throwable {
                        try {
                            com.tencent.smtt.sdk.WebView.this.a();
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            } else {
                a();
            }
        } catch (java.lang.Throwable unused) {
            a();
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(android.view.View view) {
        android.view.View.OnLongClickListener onLongClickListener = this.y;
        if (onLongClickListener == null || !onLongClickListener.onLongClick(view)) {
            return a(view);
        }
        return true;
    }

    public void onPause() {
        if (this.e) {
            this.f.onPause();
        } else {
            com.tencent.smtt.utils.k.a(this.g, "onPause");
        }
    }

    public void onResume() {
        if (this.e) {
            this.f.onResume();
        } else {
            com.tencent.smtt.utils.k.a(this.g, "onResume");
        }
    }

    @Override // android.view.View
    @android.annotation.TargetApi(11)
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (android.os.Build.VERSION.SDK_INT < 21 || !b(this.i) || !isHardwareAccelerated() || i <= 0 || i2 <= 0) {
            return;
        }
        getLayerType();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(android.view.View view, int i) throws java.lang.Throwable {
        boolean zIsX5CoreSandboxMode;
        android.os.Bundle sdkQBStatisticsInfo;
        android.content.Context context = this.i;
        if (context == null) {
            super.onVisibilityChanged(view, i);
            return;
        }
        if (p == null) {
            p = context.getApplicationInfo().packageName;
        }
        java.lang.String str = p;
        if (str != null && (str.equals("com.tencent.mm") || p.equals("com.tencent.mobileqq"))) {
            super.onVisibilityChanged(view, i);
            return;
        }
        if (i != 0 && !this.k && this.f887a != 0) {
            this.k = true;
            java.lang.String string = "";
            java.lang.String string2 = "";
            java.lang.String string3 = "";
            if (this.e && (sdkQBStatisticsInfo = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo()) != null) {
                string = sdkQBStatisticsInfo.getString(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_GUID);
                string2 = sdkQBStatisticsInfo.getString("qua2");
                string3 = sdkQBStatisticsInfo.getString("lc");
            }
            java.lang.String str2 = string;
            java.lang.String str3 = string2;
            java.lang.String str4 = string3;
            if ("com.qzone".equals(this.i.getApplicationInfo().packageName)) {
                int iE = e(this.i);
                if (iE == -1) {
                    iE = this.f887a;
                }
                this.f887a = iE;
                f(this.i);
            }
            try {
                zIsX5CoreSandboxMode = this.f.getX5WebViewExtension().isX5CoreSandboxMode();
            } catch (java.lang.Throwable th) {
                com.tencent.smtt.utils.TbsLog.w("onVisibilityChanged", "exception: " + th);
                zIsX5CoreSandboxMode = false;
            }
            com.tencent.smtt.sdk.a.b.a(this.i, str2, str3, str4, this.f887a, this.e, h(), zIsX5CoreSandboxMode);
            this.f887a = 0;
            this.k = false;
        }
        super.onVisibilityChanged(view, i);
    }

    public boolean overlayHorizontalScrollbar() {
        return !this.e ? this.g.overlayHorizontalScrollbar() : this.f.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        return this.e ? this.f.overlayVerticalScrollbar() : this.g.overlayVerticalScrollbar();
    }

    public boolean pageDown(boolean z) {
        return !this.e ? this.g.pageDown(z) : this.f.pageDown(z, -1);
    }

    public boolean pageUp(boolean z) {
        return !this.e ? this.g.pageUp(z) : this.f.pageUp(z, -1);
    }

    public void pauseTimers() {
        if (this.e) {
            this.f.pauseTimers();
        } else {
            this.g.pauseTimers();
        }
    }

    @android.annotation.TargetApi(5)
    public void postUrl(java.lang.String str, byte[] bArr) {
        if (this.e) {
            this.f.postUrl(str, bArr);
        } else {
            this.g.postUrl(str, bArr);
        }
    }

    @java.lang.Deprecated
    public void refreshPlugins(boolean z) {
        if (this.e) {
            this.f.refreshPlugins(z);
        } else {
            com.tencent.smtt.utils.k.a(this.g, "refreshPlugins", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }

    public void reload() {
        if (this.e) {
            this.f.reload();
        } else {
            this.g.reload();
        }
    }

    @android.annotation.TargetApi(11)
    public void removeJavascriptInterface(java.lang.String str) {
        if (this.e) {
            this.f.removeJavascriptInterface(str);
        } else if (android.os.Build.VERSION.SDK_INT >= 11) {
            com.tencent.smtt.utils.k.a(this.g, "removeJavascriptInterface", new java.lang.Class[]{java.lang.String.class}, str);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(android.view.View view) {
        if (!this.e) {
            this.g.removeView(view);
            return;
        }
        android.view.View view2 = this.f.getView();
        try {
            java.lang.reflect.Method methodA = com.tencent.smtt.utils.k.a(view2, "removeView", android.view.View.class);
            methodA.setAccessible(true);
            methodA.invoke(view2, view);
        } catch (java.lang.Throwable unused) {
        }
    }

    public org.json.JSONObject reportInitPerformance(long j2, int i, long j3, long j4) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("IS_X5", this.e);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(android.view.View view, android.graphics.Rect rect, boolean z) {
        android.view.View view2;
        android.view.View view3;
        if (!this.e) {
            com.tencent.smtt.sdk.WebView.a aVar = this.g;
            if (view == this) {
                view2 = view;
                view2 = aVar;
            }
            view2 = view;
            return aVar.requestChildRectangleOnScreen(view2, rect, z);
        }
        android.view.View view4 = this.f.getView();
        if (!(view4 instanceof android.view.ViewGroup)) {
            return false;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view4;
        if (view == this) {
            view3 = view;
            view3 = view4;
        }
        view3 = view;
        return viewGroup.requestChildRectangleOnScreen(view3, rect, z);
    }

    public void requestFocusNodeHref(android.os.Message message) {
        if (this.e) {
            this.f.requestFocusNodeHref(message);
        } else {
            this.g.requestFocusNodeHref(message);
        }
    }

    public void requestImageRef(android.os.Message message) {
        if (this.e) {
            this.f.requestImageRef(message);
        } else {
            this.g.requestImageRef(message);
        }
    }

    @java.lang.Deprecated
    public boolean restorePicture(android.os.Bundle bundle, java.io.File file) {
        if (this.e) {
            return this.f.restorePicture(bundle, file);
        }
        java.lang.Object objA = com.tencent.smtt.utils.k.a(this.g, "restorePicture", new java.lang.Class[]{android.os.Bundle.class, java.io.File.class}, bundle, file);
        if (objA == null) {
            return false;
        }
        return ((java.lang.Boolean) objA).booleanValue();
    }

    public com.tencent.smtt.sdk.WebBackForwardList restoreState(android.os.Bundle bundle) {
        return !this.e ? com.tencent.smtt.sdk.WebBackForwardList.a(this.g.restoreState(bundle)) : com.tencent.smtt.sdk.WebBackForwardList.a(this.f.restoreState(bundle));
    }

    public void resumeTimers() {
        if (this.e) {
            this.f.resumeTimers();
        } else {
            this.g.resumeTimers();
        }
    }

    @java.lang.Deprecated
    public void savePassword(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (this.e) {
            this.f.savePassword(str, str2, str3);
        } else {
            com.tencent.smtt.utils.k.a(this.g, "[REDACTED]", new java.lang.Class[]{java.lang.String.class, java.lang.String.class, java.lang.String.class}, str, str2, str3);
        }
    }

    @java.lang.Deprecated
    public boolean savePicture(android.os.Bundle bundle, java.io.File file) {
        if (this.e) {
            return this.f.savePicture(bundle, file);
        }
        java.lang.Object objA = com.tencent.smtt.utils.k.a(this.g, "savePicture", new java.lang.Class[]{android.os.Bundle.class, java.io.File.class}, bundle, file);
        if (objA == null) {
            return false;
        }
        return ((java.lang.Boolean) objA).booleanValue();
    }

    public com.tencent.smtt.sdk.WebBackForwardList saveState(android.os.Bundle bundle) {
        return !this.e ? com.tencent.smtt.sdk.WebBackForwardList.a(this.g.saveState(bundle)) : com.tencent.smtt.sdk.WebBackForwardList.a(this.f.saveState(bundle));
    }

    @android.annotation.TargetApi(11)
    public void saveWebArchive(java.lang.String str) {
        if (this.e) {
            this.f.saveWebArchive(str);
        } else if (android.os.Build.VERSION.SDK_INT >= 11) {
            com.tencent.smtt.utils.k.a(this.g, "saveWebArchive", new java.lang.Class[]{java.lang.String.class}, str);
        }
    }

    @android.annotation.TargetApi(11)
    public void saveWebArchive(java.lang.String str, boolean z, com.tencent.smtt.sdk.ValueCallback valueCallback) {
        if (this.e) {
            this.f.saveWebArchive(str, z, valueCallback);
        } else if (android.os.Build.VERSION.SDK_INT >= 11) {
            com.tencent.smtt.utils.k.a(this.g, "saveWebArchive", new java.lang.Class[]{java.lang.String.class, java.lang.Boolean.TYPE, android.webkit.ValueCallback.class}, str, java.lang.Boolean.valueOf(z), valueCallback);
        }
    }

    public void setARModeEnable(boolean z) {
        try {
            if (this.e) {
                getSettingsExtension().setARModeEnable(z);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.e) {
            this.f.setBackgroundColor(i);
        } else {
            this.g.setBackgroundColor(i);
        }
        super.setBackgroundColor(i);
    }

    @java.lang.Deprecated
    public void setCertificate(android.net.http.SslCertificate sslCertificate) {
        if (this.e) {
            this.f.setCertificate(sslCertificate);
        } else {
            this.g.setCertificate(sslCertificate);
        }
    }

    public void setDayOrNight(boolean z) {
        try {
            if (this.e) {
                getSettingsExtension().setDayOrNight(z);
            }
            setSysDayOrNight(z);
            getView().postInvalidate();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDownloadListener(final com.tencent.smtt.sdk.DownloadListener downloadListener) {
        boolean z = this.e;
        if (z) {
            this.f.setDownloadListener(new com.tencent.smtt.sdk.b(this, downloadListener, z));
        } else {
            this.g.setDownloadListener(new android.webkit.DownloadListener() { // from class: com.tencent.smtt.sdk.WebView.4
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j2) {
                    com.tencent.smtt.sdk.DownloadListener downloadListener2 = downloadListener;
                    if (downloadListener2 != null) {
                        downloadListener2.onDownloadStart(str, str2, str3, str4, j2);
                        return;
                    }
                    android.content.pm.ApplicationInfo applicationInfo = com.tencent.smtt.sdk.WebView.this.i == null ? null : com.tencent.smtt.sdk.WebView.this.i.getApplicationInfo();
                    if (applicationInfo == null || !"com.tencent.mm".equals(applicationInfo.packageName)) {
                        com.tencent.smtt.sdk.a.c.a(com.tencent.smtt.sdk.WebView.this.i, str, null, null);
                    }
                }
            });
        }
    }

    @android.annotation.TargetApi(16)
    public void setFindListener(final com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener findListener) {
        if (this.e) {
            this.f.setFindListener(findListener);
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            this.g.setFindListener(new android.webkit.WebView.FindListener() { // from class: com.tencent.smtt.sdk.WebView.3
                @Override // android.webkit.WebView.FindListener
                public void onFindResultReceived(int i, int i2, boolean z) {
                    findListener.onFindResultReceived(i, i2, z);
                }
            });
        }
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        if (this.e) {
            this.f.setHorizontalScrollbarOverlay(z);
        } else {
            this.g.setHorizontalScrollbarOverlay(z);
        }
    }

    public void setHttpAuthUsernamePassword(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (this.e) {
            this.f.setHttpAuthUsernamePassword(str, str2, str3, str4);
        } else {
            this.g.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public void setInitialScale(int i) {
        if (this.e) {
            this.f.setInitialScale(i);
        } else {
            this.g.setInitialScale(i);
        }
    }

    @java.lang.Deprecated
    public void setMapTrackballToArrowKeys(boolean z) {
        if (this.e) {
            this.f.setMapTrackballToArrowKeys(z);
        } else {
            com.tencent.smtt.utils.k.a(this.g, "setMapTrackballToArrowKeys", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }

    public void setNetworkAvailable(boolean z) {
        if (this.e) {
            this.f.setNetworkAvailable(z);
        } else if (android.os.Build.VERSION.SDK_INT >= 3) {
            this.g.setNetworkAvailable(z);
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(android.view.View.OnLongClickListener onLongClickListener) {
        if (!this.e) {
            this.g.setOnLongClickListener(onLongClickListener);
            return;
        }
        android.view.View view = this.f.getView();
        try {
            if (this.x == null) {
                java.lang.reflect.Method methodA = com.tencent.smtt.utils.k.a(view, "getListenerInfo", new java.lang.Class[0]);
                methodA.setAccessible(true);
                java.lang.Object objInvoke = methodA.invoke(view, null);
                java.lang.reflect.Field declaredField = objInvoke.getClass().getDeclaredField("mOnLongClickListener");
                declaredField.setAccessible(true);
                this.x = declaredField.get(objInvoke);
            }
            this.y = onLongClickListener;
            getView().setOnLongClickListener(this);
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(android.view.View.OnTouchListener onTouchListener) {
        getView().setOnTouchListener(onTouchListener);
    }

    public void setPictureListener(final com.tencent.smtt.sdk.WebView.PictureListener pictureListener) {
        if (this.e) {
            if (pictureListener == null) {
                this.f.setPictureListener(null);
                return;
            } else {
                this.f.setPictureListener(new com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener() { // from class: com.tencent.smtt.sdk.WebView.6
                    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                    public void onNewPicture(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.graphics.Picture picture, boolean z) {
                        com.tencent.smtt.sdk.WebView.this.a(iX5WebViewBase);
                        pictureListener.onNewPicture(com.tencent.smtt.sdk.WebView.this, picture);
                    }

                    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                    public void onNewPictureIfHaveContent(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.graphics.Picture picture) {
                    }
                });
                return;
            }
        }
        if (pictureListener == null) {
            this.g.setPictureListener(null);
        } else {
            this.g.setPictureListener(new android.webkit.WebView.PictureListener() { // from class: com.tencent.smtt.sdk.WebView.5
                @Override // android.webkit.WebView.PictureListener
                public void onNewPicture(android.webkit.WebView webView, android.graphics.Picture picture) {
                    com.tencent.smtt.sdk.WebView.this.a(webView);
                    pictureListener.onNewPicture(com.tencent.smtt.sdk.WebView.this, picture);
                }
            });
        }
    }

    public void setRendererPriorityPolicy(int i, boolean z) {
        try {
            if (this.e || android.os.Build.VERSION.SDK_INT < 26) {
                return;
            }
            com.tencent.smtt.utils.k.a(this.g, "setRendererPriorityPolicy", new java.lang.Class[]{java.lang.Integer.TYPE, java.lang.Boolean.TYPE}, java.lang.Integer.valueOf(i), java.lang.Boolean.valueOf(z));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i) {
        if (this.e) {
            this.f.getView().setScrollBarStyle(i);
        } else {
            this.g.setScrollBarStyle(i);
        }
    }

    public void setSysNightModeAlpha(int i) {
        NIGHT_MODE_ALPHA = i;
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        if (this.e) {
            this.f.setVerticalScrollbarOverlay(z);
        } else {
            this.g.setVerticalScrollbarOverlay(z);
        }
    }

    public boolean setVideoFullScreen(android.content.Context context, boolean z) {
        if (!context.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader") || this.f == null) {
            return false;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        if (z) {
            bundle.putInt("DefaultVideoScreen", 2);
        } else {
            bundle.putInt("DefaultVideoScreen", 1);
        }
        this.f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", bundle);
        return true;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (getView() == null) {
            return;
        }
        getView().setVisibility(i);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setWebChromeClient(com.tencent.smtt.sdk.WebChromeClient webChromeClient) {
        if (this.e) {
            this.f.setWebChromeClient(webChromeClient != null ? new com.tencent.smtt.sdk.f(com.tencent.smtt.sdk.u.a().a(true).i(), this, webChromeClient) : null);
        } else {
            this.g.setWebChromeClient(webChromeClient != null ? new com.tencent.smtt.sdk.SystemWebChromeClient(this, webChromeClient) : null);
        }
        this.o = webChromeClient;
    }

    public void setWebChromeClientExtension(com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        if (this.e) {
            this.f.getX5WebViewExtension().setWebChromeClientExtension(iX5WebChromeClientExtension);
        }
    }

    public void setWebViewCallbackClient(com.tencent.smtt.sdk.WebViewCallbackClient webViewCallbackClient) {
        this.mWebViewCallbackClient = webViewCallbackClient;
        if (!this.e || getX5WebViewExtension() == null) {
            return;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putBoolean("flag", true);
        getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", bundle);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setWebViewClient(com.tencent.smtt.sdk.WebViewClient webViewClient) {
        if (this.e) {
            this.f.setWebViewClient(webViewClient != null ? new com.tencent.smtt.sdk.g(com.tencent.smtt.sdk.u.a().a(true).j(), this, webViewClient) : null);
        } else {
            this.g.setWebViewClient(webViewClient != null ? new com.tencent.smtt.sdk.SystemWebViewClient(this, webViewClient) : null);
        }
        this.n = webViewClient;
    }

    public void setWebViewClientExtension(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension iX5WebViewClientExtension) {
        if (this.e) {
            this.f.getX5WebViewExtension().setWebViewClientExtension(iX5WebViewClientExtension);
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    public boolean showDebugView(java.lang.String str) {
        java.lang.String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("http://debugtbs.qq.com")) {
            getView().setVisibility(4);
            com.tencent.smtt.utils.d.a(this.i).a(lowerCase, this, this.i, com.tencent.smtt.sdk.l.a().getLooper());
            return true;
        }
        if (!lowerCase.startsWith("http://debugx5.qq.com") || this.e) {
            return false;
        }
        loadDataWithBaseURL(null, "<!DOCTYPE html><html><body><head><title>无法打开debugx5</title><meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" /></head><br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />尝试<a href=\"http://debugtbs.qq.com?[REDACTED]">进入DebugTbs安装或打开X5内核</a></body></html>", "text/html", com.unisound.b.f.b, null);
        return true;
    }

    public boolean showFindDialog(java.lang.String str, boolean z) {
        return false;
    }

    public void stopLoading() {
        if (this.e) {
            this.f.stopLoading();
        } else {
            this.g.stopLoading();
        }
    }

    public void super_computeScroll() {
        if (!this.e) {
            this.g.a();
            return;
        }
        try {
            com.tencent.smtt.utils.k.a(this.f.getView(), "super_computeScroll");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean super_dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (!this.e) {
            return this.g.b(motionEvent);
        }
        try {
            java.lang.Object objA = com.tencent.smtt.utils.k.a(this.f.getView(), "super_dispatchTouchEvent", new java.lang.Class[]{android.view.MotionEvent.class}, motionEvent);
            if (objA == null) {
                return false;
            }
            return ((java.lang.Boolean) objA).booleanValue();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public boolean super_onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (!this.e) {
            return this.g.c(motionEvent);
        }
        try {
            java.lang.Object objA = com.tencent.smtt.utils.k.a(this.f.getView(), "super_onInterceptTouchEvent", new java.lang.Class[]{android.view.MotionEvent.class}, motionEvent);
            if (objA == null) {
                return false;
            }
            return ((java.lang.Boolean) objA).booleanValue();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (!this.e) {
            this.g.a(i, i2, z, z2);
            return;
        }
        try {
            com.tencent.smtt.utils.k.a(this.f.getView(), "super_onOverScrolled", new java.lang.Class[]{java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Boolean.TYPE, java.lang.Boolean.TYPE}, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Boolean.valueOf(z), java.lang.Boolean.valueOf(z2));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        if (!this.e) {
            this.g.a(i, i2, i3, i4);
            return;
        }
        try {
            com.tencent.smtt.utils.k.a(this.f.getView(), "super_onScrollChanged", new java.lang.Class[]{java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean super_onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!this.e) {
            return this.g.a(motionEvent);
        }
        try {
            java.lang.Object objA = com.tencent.smtt.utils.k.a(this.f.getView(), "super_onTouchEvent", new java.lang.Class[]{android.view.MotionEvent.class}, motionEvent);
            if (objA == null) {
                return false;
            }
            return ((java.lang.Boolean) objA).booleanValue();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (!this.e) {
            return this.g.a(i, i2, i3, i4, i5, i6, i7, i8, z);
        }
        try {
            java.lang.Object objA = com.tencent.smtt.utils.k.a(this.f.getView(), "super_overScrollBy", new java.lang.Class[]{java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Boolean.TYPE}, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4), java.lang.Integer.valueOf(i5), java.lang.Integer.valueOf(i6), java.lang.Integer.valueOf(i7), java.lang.Integer.valueOf(i8), java.lang.Boolean.valueOf(z));
            if (objA == null) {
                return false;
            }
            return ((java.lang.Boolean) objA).booleanValue();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public void switchNightMode(boolean z) {
        java.lang.String str;
        if (z == w) {
            return;
        }
        w = z;
        if (z) {
            com.tencent.smtt.utils.TbsLog.e("QB_SDK", "deleteNightMode");
            str = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        } else {
            com.tencent.smtt.utils.TbsLog.e("QB_SDK", "nightMode");
            str = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        }
        loadUrl(str);
    }

    public void switchToNightMode() {
        com.tencent.smtt.utils.TbsLog.e("QB_SDK", "switchToNightMode 01");
        if (w) {
            return;
        }
        com.tencent.smtt.utils.TbsLog.e("QB_SDK", "switchToNightMode");
        loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
    }

    public void tbsWebviewDestroy(boolean z) throws java.lang.Throwable {
        boolean zIsX5CoreSandboxMode;
        android.os.Bundle sdkQBStatisticsInfo;
        if (!this.k && this.f887a != 0) {
            this.k = true;
            java.lang.String string = "";
            java.lang.String string2 = "";
            java.lang.String string3 = "";
            if (this.e && (sdkQBStatisticsInfo = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo()) != null) {
                string = sdkQBStatisticsInfo.getString(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_GUID);
                string2 = sdkQBStatisticsInfo.getString("qua2");
                string3 = sdkQBStatisticsInfo.getString("lc");
            }
            java.lang.String str = string;
            java.lang.String str2 = string2;
            java.lang.String str3 = string3;
            if ("com.qzone".equals(this.i.getApplicationInfo().packageName)) {
                int iE = e(this.i);
                if (iE == -1) {
                    iE = this.f887a;
                }
                this.f887a = iE;
                f(this.i);
            }
            try {
                zIsX5CoreSandboxMode = this.f.getX5WebViewExtension().isX5CoreSandboxMode();
            } catch (java.lang.Throwable th) {
                com.tencent.smtt.utils.TbsLog.w("tbsWebviewDestroy", "exception: " + th);
                zIsX5CoreSandboxMode = false;
            }
            com.tencent.smtt.sdk.a.b.a(this.i, str, str2, str3, this.f887a, this.e, h(), zIsX5CoreSandboxMode);
            this.f887a = 0;
            this.k = false;
        }
        if (!this.e) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("android.webkit.WebViewClassic");
                java.lang.reflect.Method method = cls.getMethod("fromWebView", android.webkit.WebView.class);
                method.setAccessible(true);
                java.lang.Object objInvoke = method.invoke(null, this.g);
                if (objInvoke != null) {
                    java.lang.reflect.Field declaredField = cls.getDeclaredField("mListBoxDialog");
                    declaredField.setAccessible(true);
                    java.lang.Object obj = declaredField.get(objInvoke);
                    if (obj != null) {
                        android.app.Dialog dialog = (android.app.Dialog) obj;
                        dialog.setOnCancelListener(null);
                        java.lang.Class<?> cls2 = java.lang.Class.forName("android.app.Dialog");
                        java.lang.reflect.Field declaredField2 = cls2.getDeclaredField("CANCEL");
                        declaredField2.setAccessible(true);
                        int iIntValue = ((java.lang.Integer) declaredField2.get(dialog)).intValue();
                        java.lang.reflect.Field declaredField3 = cls2.getDeclaredField("mListenersHandler");
                        declaredField3.setAccessible(true);
                        ((android.os.Handler) declaredField3.get(dialog)).removeMessages(iIntValue);
                    }
                }
            } catch (java.lang.Exception unused) {
            }
            if (z) {
                this.g.destroy();
            }
            try {
                java.lang.reflect.Field declaredField4 = java.lang.Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                declaredField4.setAccessible(true);
                android.content.ComponentCallbacks componentCallbacks = (android.content.ComponentCallbacks) declaredField4.get(null);
                if (componentCallbacks != null) {
                    declaredField4.set(null, null);
                    java.lang.reflect.Field declaredField5 = java.lang.Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                    declaredField5.setAccessible(true);
                    java.lang.Object obj2 = declaredField5.get(null);
                    if (obj2 != null) {
                        java.util.List list = (java.util.List) obj2;
                        synchronized (list) {
                            list.remove(componentCallbacks);
                        }
                    }
                }
            } catch (java.lang.Exception unused2) {
            }
        } else if (z) {
            this.f.destroy();
        }
        com.tencent.smtt.utils.TbsLog.i("WebView", "X5 GUID = " + com.tencent.smtt.sdk.QbSdk.b());
    }

    public boolean zoomIn() {
        return !this.e ? this.g.zoomIn() : this.f.zoomIn();
    }

    public boolean zoomOut() {
        return !this.e ? this.g.zoomOut() : this.f.zoomOut();
    }
}
