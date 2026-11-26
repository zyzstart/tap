package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WebViewClient {
    public static final int ERROR_AUTHENTICATION = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_IO = -7;
    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    public static final int INTERCEPT_BY_ISP = -16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.tencent.smtt.sdk.g f898a;

    public void doUpdateVisitedHistory(com.tencent.smtt.sdk.WebView webView, java.lang.String str, boolean z) {
    }

    public void onDetectedBlankScreen(java.lang.String str, int i) {
    }

    public void onFormResubmission(com.tencent.smtt.sdk.WebView webView, android.os.Message message, android.os.Message message2) {
        message.sendToTarget();
    }

    public void onLoadResource(com.tencent.smtt.sdk.WebView webView, java.lang.String str) {
    }

    public void onPageCommitVisible(com.tencent.smtt.sdk.WebView webView, java.lang.String str) {
    }

    public void onPageFinished(com.tencent.smtt.sdk.WebView webView, java.lang.String str) {
    }

    public void onPageStarted(com.tencent.smtt.sdk.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
        com.tencent.smtt.sdk.g gVar = this.f898a;
        if (gVar != null) {
            gVar.a(webView, str, bitmap);
        }
    }

    public void onReceivedClientCertRequest(com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.export.external.interfaces.ClientCertRequest clientCertRequest) {
        clientCertRequest.cancel();
    }

    public void onReceivedError(com.tencent.smtt.sdk.WebView webView, int i, java.lang.String str, java.lang.String str2) {
    }

    public void onReceivedError(com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest, com.tencent.smtt.export.external.interfaces.WebResourceError webResourceError) {
        if (this.f898a != null) {
            if (webResourceRequest.isForMainFrame()) {
                this.f898a.onReceivedError(webView.c(), webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
            }
        } else if (webResourceRequest.isForMainFrame()) {
            onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }

    public void onReceivedHttpAuthRequest(com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.export.external.interfaces.HttpAuthHandler httpAuthHandler, java.lang.String str, java.lang.String str2) {
        httpAuthHandler.cancel();
    }

    public void onReceivedHttpError(com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest, com.tencent.smtt.export.external.interfaces.WebResourceResponse webResourceResponse) {
    }

    public void onReceivedLoginRequest(com.tencent.smtt.sdk.WebView webView, java.lang.String str, java.lang.String str2, java.lang.String str3) {
    }

    public void onReceivedSslError(com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.export.external.interfaces.SslErrorHandler sslErrorHandler, com.tencent.smtt.export.external.interfaces.SslError sslError) {
        sslErrorHandler.cancel();
    }

    public void onScaleChanged(com.tencent.smtt.sdk.WebView webView, float f, float f2) {
    }

    public void onTooManyRedirects(com.tencent.smtt.sdk.WebView webView, android.os.Message message, android.os.Message message2) {
    }

    public void onUnhandledKeyEvent(com.tencent.smtt.sdk.WebView webView, android.view.KeyEvent keyEvent) {
    }

    public com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest) {
        com.tencent.smtt.sdk.g gVar = this.f898a;
        return gVar != null ? gVar.shouldInterceptRequest(webView.c(), webResourceRequest.getUrl().toString()) : shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
    }

    public com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest, android.os.Bundle bundle) {
        com.tencent.smtt.sdk.g gVar = this.f898a;
        if (gVar != null) {
            return gVar.shouldInterceptRequest(webView.c(), webResourceRequest);
        }
        return null;
    }

    public com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView webView, java.lang.String str) {
        return null;
    }

    public boolean shouldOverrideKeyEvent(com.tencent.smtt.sdk.WebView webView, android.view.KeyEvent keyEvent) {
        return false;
    }

    public boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest) {
        com.tencent.smtt.sdk.g gVar = this.f898a;
        return gVar != null ? gVar.shouldOverrideUrlLoading(webView.c(), webResourceRequest.getUrl().toString()) : shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }

    public boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView webView, java.lang.String str) {
        return false;
    }
}
