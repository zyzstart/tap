package com.tencent.smtt.export.external.proxy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class X5ProxyWebChromeClient extends com.tencent.smtt.export.external.proxy.ProxyWebChromeClient {
    public X5ProxyWebChromeClient(com.tencent.smtt.export.external.WebViewWizardBase webViewWizardBase) {
        this.mWebChromeClient = (com.tencent.smtt.export.external.interfaces.IX5WebChromeClient) webViewWizardBase.newInstance("com.tencent.smtt.webkit.WebChromeClient");
    }

    public X5ProxyWebChromeClient(com.tencent.smtt.export.external.interfaces.IX5WebChromeClient iX5WebChromeClient) {
        setWebChromeClient(iX5WebChromeClient);
    }
}
