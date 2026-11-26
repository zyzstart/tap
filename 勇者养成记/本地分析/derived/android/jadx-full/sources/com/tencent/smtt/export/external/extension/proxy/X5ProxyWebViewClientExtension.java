package com.tencent.smtt.export.external.extension.proxy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class X5ProxyWebViewClientExtension extends com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension {
    public X5ProxyWebViewClientExtension(com.tencent.smtt.export.external.WebViewWizardBase webViewWizardBase) {
        this.mWebViewClientExt = (com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension) webViewWizardBase.newInstance("com.tencent.smtt.webkit.WebViewClientExtension");
    }

    public X5ProxyWebViewClientExtension(com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension iX5WebViewClientExtension) {
        this.mWebViewClientExt = iX5WebViewClientExtension;
    }
}
