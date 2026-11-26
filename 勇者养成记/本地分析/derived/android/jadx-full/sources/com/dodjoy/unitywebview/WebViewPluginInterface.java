package com.dodjoy.unitywebview;

/* JADX INFO: compiled from: WebViewPlugin.java */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class WebViewPluginInterface {
    private java.lang.String mGameObject;

    public WebViewPluginInterface(java.lang.String str) {
        this.mGameObject = str;
    }

    @android.webkit.JavascriptInterface
    public void call(java.lang.String str) {
        com.dodjoy.utilities.DodBaseContext.UnitySendMessage(this.mGameObject, "CallFromJS", str);
    }
}
