package com.dodjoy.unitywebview;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WebViewPlugin {
    public static boolean IgnoreSSLError = false;
    private static android.widget.FrameLayout layout;
    private java.lang.String mCallGameObj;
    private long mDownTime;
    private android.webkit.WebView mWebView;

    public void Destroy() {
        com.dodjoy.utilities.DodBaseContext.GetGameActivity().runOnUiThread(new java.lang.Runnable() { // from class: com.dodjoy.unitywebview.WebViewPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.dodjoy.unitywebview.WebViewPlugin.this.mWebView != null) {
                    com.dodjoy.unitywebview.WebViewPlugin.layout.removeView(com.dodjoy.unitywebview.WebViewPlugin.this.mWebView);
                    com.dodjoy.unitywebview.WebViewPlugin.this.mWebView = null;
                }
            }
        });
    }

    public void EvaluateJS(final java.lang.String str) {
        com.dodjoy.utilities.DodBaseContext.GetGameActivity().runOnUiThread(new java.lang.Runnable() { // from class: com.dodjoy.unitywebview.WebViewPlugin.6
            @Override // java.lang.Runnable
            public void run() {
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.loadUrl("javascript:" + str);
            }
        });
    }

    @android.annotation.SuppressLint({"NewApi"})
    public void Init(final java.lang.String str) {
        final android.app.Activity activityGetGameActivity = com.dodjoy.utilities.DodBaseContext.GetGameActivity();
        activityGetGameActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.dodjoy.unitywebview.WebViewPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                com.dodjoy.unitywebview.WebViewPlugin.this.mCallGameObj = str;
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView = new android.webkit.WebView(activityGetGameActivity);
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.setVisibility(8);
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.setFocusable(true);
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.setFocusableInTouchMode(true);
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.setBackgroundColor(0);
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.setBackground(null);
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.setLayerType(1, new android.graphics.Paint());
                if (com.dodjoy.unitywebview.WebViewPlugin.layout == null) {
                    android.widget.FrameLayout unused = com.dodjoy.unitywebview.WebViewPlugin.layout = new android.widget.FrameLayout(activityGetGameActivity);
                    activityGetGameActivity.addContentView(com.dodjoy.unitywebview.WebViewPlugin.layout, new android.view.ViewGroup.LayoutParams(-1, -1));
                    com.dodjoy.unitywebview.WebViewPlugin.layout.setFocusable(true);
                    com.dodjoy.unitywebview.WebViewPlugin.layout.setFocusableInTouchMode(true);
                }
                com.dodjoy.unitywebview.WebViewPlugin.layout.addView(com.dodjoy.unitywebview.WebViewPlugin.this.mWebView, new android.widget.FrameLayout.LayoutParams(-1, -1, 0));
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.setWebChromeClient(new android.webkit.WebChromeClient() { // from class: com.dodjoy.unitywebview.WebViewPlugin.1.1
                    @Override // android.webkit.WebChromeClient
                    public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
                        android.util.Log.d("Webview", consoleMessage.message());
                        return true;
                    }
                });
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.setWebViewClient(new android.webkit.WebViewClient() { // from class: com.dodjoy.unitywebview.WebViewPlugin.1.2
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(android.webkit.WebView webView, java.lang.String str2) {
                        com.dodjoy.utilities.DodBaseContext.UnitySendMessage(str, "OnPageFinished", str2);
                        super.onPageFinished(webView, str2);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedSslError(android.webkit.WebView webView, final android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
                        if (com.dodjoy.unitywebview.WebViewPlugin.IgnoreSSLError) {
                            sslErrorHandler.proceed();
                            return;
                        }
                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activityGetGameActivity);
                        builder.setMessage("SSL error occurred. Would you like to proceed?");
                        builder.setPositiveButton("continue", new android.content.DialogInterface.OnClickListener() { // from class: com.dodjoy.unitywebview.WebViewPlugin.1.2.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                                sslErrorHandler.proceed();
                            }
                        });
                        builder.setNegativeButton(com.unisound.common.y.G, new android.content.DialogInterface.OnClickListener() { // from class: com.dodjoy.unitywebview.WebViewPlugin.1.2.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                                sslErrorHandler.cancel();
                            }
                        });
                        builder.create().show();
                    }

                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str2) {
                        if ((str2.startsWith("http://") || str2.startsWith("https://") || str2.startsWith("file://") || str2.startsWith("javascript:")) && !str2.contains("open_in_browser")) {
                            return false;
                        }
                        try {
                            webView.getContext().startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str2)));
                            return true;
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                            return false;
                        }
                    }
                });
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.addJavascriptInterface(new com.dodjoy.unitywebview.WebViewPluginInterface(str), "Unity");
                android.webkit.WebSettings settings = com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.getSettings();
                settings.setSupportZoom(false);
                settings.setJavaScriptEnabled(true);
                if (android.os.Build.VERSION.SDK_INT >= 16) {
                    android.util.Log.i("WebViewPlugin", "Build.VERSION.SDK_INT = " + android.os.Build.VERSION.SDK_INT);
                    settings.setAllowUniversalAccessFromFileURLs(true);
                }
                settings.setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
                settings.setCacheMode(2);
                java.lang.String path = com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.getContext().getDir("databases", 0).getPath();
                settings.setDatabaseEnabled(true);
                settings.setDomStorageEnabled(true);
                settings.setDatabasePath(path);
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.getSettings().setDomStorageEnabled(true);
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.getSettings().setAppCacheMaxSize(8388608L);
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.getSettings().setAppCachePath(activityGetGameActivity.getApplicationContext().getCacheDir().getAbsolutePath());
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.getSettings().setAllowFileAccess(true);
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.getSettings().setAppCacheEnabled(true);
            }
        });
        final android.view.View rootView = activityGetGameActivity.getWindow().getDecorView().getRootView();
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.dodjoy.unitywebview.WebViewPlugin.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                android.graphics.Rect rect = new android.graphics.Rect();
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rootView.getRootView().getHeight() - (rect.bottom - rect.top) > activityGetGameActivity.getWindowManager().getDefaultDisplay().getHeight() / 3) {
                    com.dodjoy.utilities.DodBaseContext.UnitySendMessage(str, "SetKeyboardVisible", com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON);
                } else {
                    com.dodjoy.utilities.DodBaseContext.UnitySendMessage(str, "SetKeyboardVisible", "false");
                }
            }
        });
    }

    public void LoadH5GameURL(final java.lang.String str) {
        android.util.Log.e("unity", "LoadH5GameURL " + str);
        final android.app.Activity activityGetGameActivity = com.dodjoy.utilities.DodBaseContext.GetGameActivity();
        activityGetGameActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.dodjoy.unitywebview.WebViewPlugin.5
            @Override // java.lang.Runnable
            public void run() {
                android.content.Intent intent = new android.content.Intent(activityGetGameActivity, (java.lang.Class<?>) com.dodjoy.unitywebview.DodWebView.class);
                intent.putExtra("gameObject", com.dodjoy.unitywebview.WebViewPlugin.this.mCallGameObj);
                intent.putExtra("url", str);
                activityGetGameActivity.startActivity(intent);
            }
        });
    }

    public void LoadURL(final java.lang.String str) {
        com.dodjoy.utilities.DodBaseContext.GetGameActivity().runOnUiThread(new java.lang.Runnable() { // from class: com.dodjoy.unitywebview.WebViewPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.loadUrl(str);
            }
        });
    }

    public void NavBack() {
        this.mWebView.goBack();
    }

    public void NavForward() {
        this.mWebView.goForward();
    }

    public void OpenInBrowser() {
        this.mWebView.getContext().startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(this.mWebView.getUrl())));
    }

    public void Refresh() {
        this.mWebView.reload();
    }

    public void SetBackgroundColor() {
        this.mWebView.setBackgroundColor(0);
    }

    public void SetIgnoreSllError(boolean z) {
        IgnoreSSLError = z;
    }

    public void SetMargins(int i, int i2, int i3, int i4) {
        final android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1, 0);
        layoutParams.setMargins(i, i2, i3, i4);
        com.dodjoy.utilities.DodBaseContext.GetGameActivity().runOnUiThread(new java.lang.Runnable() { // from class: com.dodjoy.unitywebview.WebViewPlugin.7
            @Override // java.lang.Runnable
            public void run() {
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.setLayoutParams(layoutParams);
            }
        });
    }

    public void SetVisibility(final boolean z) {
        com.dodjoy.utilities.DodBaseContext.GetGameActivity().runOnUiThread(new java.lang.Runnable() { // from class: com.dodjoy.unitywebview.WebViewPlugin.8
            @Override // java.lang.Runnable
            public void run() {
                if (!z) {
                    com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.setVisibility(8);
                    return;
                }
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.setVisibility(0);
                com.dodjoy.unitywebview.WebViewPlugin.layout.requestFocus();
                com.dodjoy.unitywebview.WebViewPlugin.this.mWebView.requestFocus();
            }
        });
    }
}
