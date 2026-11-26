package com.tencent.ysdk.shell.module.h5game;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class H5GameWebViewClient extends com.tencent.smtt.sdk.WebViewClient {
    private com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeProxy mJsBridge;

    public H5GameWebViewClient(com.tencent.ysdk.shell.module.h5game.H5GameWebCore h5GameWebCore) {
        this.mJsBridge = h5GameWebCore.getJsBridge();
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView webView, java.lang.String str) {
        if (!str.startsWith(com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge.JS_BRIDGE_SCHEME)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeProxy yYBJsBridgeProxy = this.mJsBridge;
        if (yYBJsBridgeProxy == null) {
            return true;
        }
        yYBJsBridgeProxy.invoke(str);
        return true;
    }
}
