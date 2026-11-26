package com.tencent.smtt.export.external.proxy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class ProxyWebViewClient implements com.tencent.smtt.export.external.interfaces.IX5WebViewClient {
    private boolean mCompatibleOnPageStartedOrFinishedMethod = false;
    protected com.tencent.smtt.export.external.interfaces.IX5WebViewClient mWebViewClient;

    public void countPVContentCacheCallBack(java.lang.String str) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void doUpdateVisitedHistory(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, boolean z) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            iX5WebViewClient.doUpdateVisitedHistory(iX5WebViewBase, str, z);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onContentSizeChanged(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, int i, int i2) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            iX5WebViewClient.onContentSizeChanged(iX5WebViewBase, i, i2);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onDetectedBlankScreen(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, int i) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onFormResubmission(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.os.Message message, android.os.Message message2) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            iX5WebViewClient.onFormResubmission(iX5WebViewBase, message, message2);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onLoadResource(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            iX5WebViewClient.onLoadResource(iX5WebViewBase, str);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageCommitVisible(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageFinished(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, int i, int i2, java.lang.String str) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageFinished(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            iX5WebViewClient.onPageFinished(iX5WebViewBase, str);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageStarted(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, int i, int i2, java.lang.String str, android.graphics.Bitmap bitmap) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageStarted(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, android.graphics.Bitmap bitmap) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            iX5WebViewClient.onPageStarted(iX5WebViewBase, str, bitmap);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedClientCertRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.ClientCertRequest clientCertRequest) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            iX5WebViewClient.onReceivedClientCertRequest(iX5WebViewBase, clientCertRequest);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedError(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            iX5WebViewClient.onReceivedError(iX5WebViewBase, i, str, str2);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedError(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest, com.tencent.smtt.export.external.interfaces.WebResourceError webResourceError) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            iX5WebViewClient.onReceivedError(iX5WebViewBase, webResourceRequest, webResourceError);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedHttpAuthRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.HttpAuthHandler httpAuthHandler, java.lang.String str, java.lang.String str2) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            iX5WebViewClient.onReceivedHttpAuthRequest(iX5WebViewBase, httpAuthHandler, str, str2);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedHttpError(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest, com.tencent.smtt.export.external.interfaces.WebResourceResponse webResourceResponse) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            iX5WebViewClient.onReceivedHttpError(iX5WebViewBase, webResourceRequest, webResourceResponse);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedLoginRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            iX5WebViewClient.onReceivedLoginRequest(iX5WebViewBase, str, str2, str3);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedSslError(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.SslErrorHandler sslErrorHandler, com.tencent.smtt.export.external.interfaces.SslError sslError) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            iX5WebViewClient.onReceivedSslError(iX5WebViewBase, sslErrorHandler, sslError);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onScaleChanged(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, float f, float f2) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            iX5WebViewClient.onScaleChanged(iX5WebViewBase, f, f2);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onTooManyRedirects(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.os.Message message, android.os.Message message2) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            iX5WebViewClient.onTooManyRedirects(iX5WebViewBase, message, message2);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onUnhandledKeyEvent(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.view.KeyEvent keyEvent) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            iX5WebViewClient.onUnhandledKeyEvent(iX5WebViewBase, keyEvent);
        }
    }

    public void setWebViewClient(com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient) {
        this.mWebViewClient = iX5WebViewClient;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            return iX5WebViewClient.shouldInterceptRequest(iX5WebViewBase, webResourceRequest);
        }
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest, android.os.Bundle bundle) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            return iX5WebViewClient.shouldInterceptRequest(iX5WebViewBase, webResourceRequest, bundle);
        }
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        if (iX5WebViewClient != null) {
            return iX5WebViewClient.shouldInterceptRequest(iX5WebViewBase, str);
        }
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideKeyEvent(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.view.KeyEvent keyEvent) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        return iX5WebViewClient != null && iX5WebViewClient.shouldOverrideKeyEvent(iX5WebViewBase, keyEvent);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideUrlLoading(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        return iX5WebViewClient != null && iX5WebViewClient.shouldOverrideUrlLoading(iX5WebViewBase, webResourceRequest);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideUrlLoading(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewClient iX5WebViewClient = this.mWebViewClient;
        return iX5WebViewClient != null && iX5WebViewClient.shouldOverrideUrlLoading(iX5WebViewBase, str);
    }
}
