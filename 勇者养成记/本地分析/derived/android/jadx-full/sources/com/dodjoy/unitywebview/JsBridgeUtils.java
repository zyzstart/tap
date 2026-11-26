package com.dodjoy.unitywebview;

/* JADX INFO: compiled from: DodWebView.java */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class JsBridgeUtils {
    private android.webkit.WebView jsWebview;
    private com.dodjoy.unitywebview.DodWebView mDodWebView;
    private java.lang.String mGameObject;

    public JsBridgeUtils(java.lang.String str, com.dodjoy.unitywebview.DodWebView dodWebView, android.webkit.WebView webView) {
        this.mGameObject = str;
        this.mDodWebView = dodWebView;
        this.jsWebview = webView;
    }

    @android.webkit.JavascriptInterface
    public void call(java.lang.String str) {
        android.util.Log.e("unity", "js to android call funtion");
        com.dodjoy.utilities.DodBaseContext.UnitySendMessage(this.mGameObject, "CallFromJS", str);
        com.dodjoy.unitywebview.DodWebView dodWebView = this.mDodWebView;
        if (dodWebView != null) {
            dodWebView.setHiddenWebView(this.jsWebview, dodWebView);
        }
    }
}
