package com.dodjoy.unitywebview;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.annotation.SuppressLint({"JavascriptInterface", "SetJavaScriptEnabled"})
public class DodWebView extends android.app.Activity {
    private static com.dodjoy.unitywebview.DodWebView _instance;
    private android.webkit.WebView mWebView;

    public static com.dodjoy.unitywebview.DodWebView getInstance() {
        if (_instance == null) {
            _instance = new com.dodjoy.unitywebview.DodWebView();
        }
        return _instance;
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getResources().getIdentifier("dod_webview_layout", "layout", getPackageName()));
        java.lang.String stringExtra = getIntent().getStringExtra("gameObject");
        java.lang.String stringExtra2 = getIntent().getStringExtra("url");
        _instance = this;
        this.mWebView = (android.webkit.WebView) findViewById(getResources().getIdentifier("webcontent", "id", getPackageName()));
        this.mWebView.setWebViewClient(new android.webkit.WebViewClient());
        this.mWebView.setBackgroundColor(0);
        this.mWebView.setBackground(null);
        this.mWebView.addJavascriptInterface(new com.dodjoy.unitywebview.JsBridgeUtils(stringExtra, _instance, this.mWebView), "Unity");
        android.webkit.WebSettings settings = this.mWebView.getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            android.util.Log.i("WebViewPlugin", "Build.VERSION.SDK_INT = " + android.os.Build.VERSION.SDK_INT);
            settings.setAllowUniversalAccessFromFileURLs(true);
        }
        settings.setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        settings.setCacheMode(2);
        java.lang.String path = this.mWebView.getContext().getDir("databases", 0).getPath();
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabasePath(path);
        this.mWebView.loadUrl(stringExtra2);
    }

    public void setHiddenWebView(final android.webkit.WebView webView, final com.dodjoy.unitywebview.DodWebView dodWebView) {
        dodWebView.runOnUiThread(new java.lang.Runnable() { // from class: com.dodjoy.unitywebview.DodWebView.1
            @Override // java.lang.Runnable
            public void run() {
                android.webkit.WebView webView2 = webView;
                if (webView2 != null) {
                    webView2.setVisibility(4);
                    dodWebView.finish();
                }
            }
        });
    }
}
