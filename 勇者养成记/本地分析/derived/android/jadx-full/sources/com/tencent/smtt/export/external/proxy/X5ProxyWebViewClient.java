package com.tencent.smtt.export.external.proxy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class X5ProxyWebViewClient extends com.tencent.smtt.export.external.proxy.ProxyWebViewClient {
    public X5ProxyWebViewClient(com.tencent.smtt.export.external.WebViewWizardBase webViewWizardBase) {
        this.mWebViewClient = (com.tencent.smtt.export.external.interfaces.IX5WebViewClient) webViewWizardBase.newInstance("com.tencent.smtt.webkit.WebViewClient");
    }

    public X5ProxyWebViewClient(com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient) {
        this.mWebViewClient = iX5WebViewClient;
    }
}
