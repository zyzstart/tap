package com.tencent.midas.jsbridge;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APWebView {
    private static final java.lang.String TAG = "APWebView";
    private com.tencent.midas.jsbridge.IAPWebViewCallback callback;
    private android.app.Activity mContext;
    private android.webkit.WebView mWebview;
    private android.webkit.WebChromeClient mChromeClient = new android.webkit.WebChromeClient() { // from class: com.tencent.midas.jsbridge.APWebView.1
        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, android.webkit.JsResult jsResult) {
            java.lang.String str3;
            java.lang.String str4;
            com.tencent.midas.comm.APLog.e("inner onJsAlert message", str2);
            com.tencent.midas.comm.APLog.e(com.tencent.midas.jsbridge.APWebView.TAG, " url = " + str);
            com.tencent.midas.comm.APLog.e(com.tencent.midas.jsbridge.APWebView.TAG, " message = " + str2);
            if (!com.tencent.midas.download.APMidasPluginDownloadUtils.handlePureH5UpdateJsAlertLogic(com.tencent.midas.jsbridge.APWebView.this.mContext, str2)) {
                com.tencent.midas.comm.APLog.d(com.tencent.midas.jsbridge.APWebView.TAG, "onJsAlert not pure h5 update!");
                if (com.tencent.midas.jsbridge.APWebProtocol.hookH5Method(com.tencent.midas.jsbridge.APWebView.this.mContext, com.tencent.midas.jsbridge.APWebView.this.mWebview, str, str2, jsResult, com.tencent.midas.jsbridge.APWebView.this.callback)) {
                    str3 = com.tencent.midas.jsbridge.APWebView.TAG;
                    str4 = "hookH5Method is processed";
                } else {
                    if (com.tencent.midas.api.APMidasPayAPI.h5PayHook(com.tencent.midas.jsbridge.APWebView.this.mContext, com.tencent.midas.jsbridge.APWebView.this.mWebview, str, str2, jsResult) != 0) {
                        return super.onJsAlert(webView, str, str2, jsResult);
                    }
                    com.tencent.midas.jsbridge.APWebView.this.callback.WebChromeClientJsAlert(webView, str, str2, jsResult);
                }
                jsResult.cancel();
                return true;
            }
            str3 = com.tencent.midas.jsbridge.APWebView.TAG;
            str4 = "onJsAlert is pure h5 update! Cancel alert!";
            com.tencent.midas.comm.APLog.d(str3, str4);
            jsResult.cancel();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, java.lang.String str3, android.webkit.JsPromptResult jsPromptResult) {
            return com.tencent.midas.jsbridge.APWebView.this.callback.WebChromeClientJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
    };
    private android.webkit.WebViewClient mWebViewClient = new android.webkit.WebViewClient() { // from class: com.tencent.midas.jsbridge.APWebView.2
        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            com.tencent.midas.comm.APLog.d(com.tencent.midas.jsbridge.APWebView.TAG, "onPageFinished!");
            com.tencent.midas.comm.APLog.i("APWebView url == ", str);
            com.tencent.midas.jsbridge.APWebView.this.mWebview.setVisibility(0);
            com.tencent.midas.api.APMidasPayAPI.InnerH5PayInit(com.tencent.midas.jsbridge.APWebView.this.mContext, com.tencent.midas.jsbridge.APWebView.this.mWebview);
            com.tencent.midas.jsbridge.APWebView.this.callback.WebViewClientPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            com.tencent.midas.comm.APLog.d(com.tencent.midas.jsbridge.APWebView.TAG, "onPageStarted!");
            com.tencent.midas.jsbridge.APWebView.this.callback.WebViewClientPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            super.onReceivedError(webView, i, str, str2);
            com.tencent.midas.comm.APLog.d(com.tencent.midas.jsbridge.APWebView.TAG, "onReceivedError!");
            com.tencent.midas.jsbridge.APWebView.this.callback.WebViewClientReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            com.tencent.midas.comm.APLog.d(com.tencent.midas.jsbridge.APWebView.TAG, "shouldOverrideUrlLoading url = " + str);
            if (!str.startsWith("http://unipay.sdk.android/") && !str.startsWith("wsj://") && !str.startsWith("mqqapi://") && !str.startsWith("weixin://") && !str.startsWith("sms://")) {
                webView.loadUrl(str);
                com.tencent.midas.comm.APLog.d(com.tencent.midas.jsbridge.APWebView.TAG, "shouldOverrideUrlLoading loadUrl = ");
            }
            if (!str.startsWith("mqqapi://") && !str.startsWith("weixin://") && !str.startsWith("sms://")) {
                return true;
            }
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
            if (intent.resolveActivity(com.tencent.midas.jsbridge.APWebView.this.mContext.getPackageManager()) != null) {
                webView.getContext().startActivity(intent);
                return true;
            }
            android.widget.Toast.makeText(com.tencent.midas.jsbridge.APWebView.this.mContext, "抱歉，你未安装相应客户端", 1).show();
            com.tencent.midas.comm.APLog.w(com.tencent.midas.jsbridge.APWebView.TAG, "shouldOverrideUrlLoading() intent.resolveActivity == Null ");
            return false;
        }
    };

    public APWebView(android.app.Activity activity, android.webkit.WebView webView, com.tencent.midas.jsbridge.IAPWebViewCallback iAPWebViewCallback) {
        this.mWebview = null;
        this.mContext = null;
        this.callback = null;
        this.mContext = activity;
        this.mWebview = webView;
        this.callback = iAPWebViewCallback;
        InitWebView();
    }

    @android.annotation.SuppressLint({"NewApi"})
    private void InitWebView() {
        android.webkit.WebSettings settings = this.mWebview.getSettings();
        settings.setJavaScriptEnabled(true);
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            com.tencent.midas.api.APMidasPayAPI.env.equals(com.tencent.midas.api.APMidasPayAPI.ENV_TEST);
        }
        settings.setDomStorageEnabled(true);
        settings.setAppCachePath(this.mContext.getApplicationContext().getDir("cache", 0).getPath());
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(-1);
        this.mWebview.setScrollBarStyle(0);
        this.mWebview.setWebChromeClient(this.mChromeClient);
        this.mWebview.setWebViewClient(this.mWebViewClient);
        removeInterface();
    }

    private void removeInterface() {
        try {
            java.lang.reflect.Method method = this.mWebview.getClass().getMethod("removeJavascriptInterface", java.lang.String.class);
            if (method != null) {
                method.invoke(this.mWebview, "searchBoxJavaBridge_");
                method.invoke(this.mWebview, "accessibility");
                method.invoke(this.mWebview, "accessibilityTraversal");
            }
        } catch (java.lang.Exception e) {
            com.tencent.midas.comm.APLog.i("removeJavascriptInterface", e.toString());
        }
    }

    public android.webkit.WebView getWebView() {
        return this.mWebview;
    }

    public void loadUrl(java.lang.String str) {
        this.mWebview.loadUrl(str);
    }
}
