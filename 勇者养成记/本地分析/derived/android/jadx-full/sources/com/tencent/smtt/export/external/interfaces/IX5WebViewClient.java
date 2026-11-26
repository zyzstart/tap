package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IX5WebViewClient {
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

    void doUpdateVisitedHistory(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, boolean z);

    void onContentSizeChanged(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, int i, int i2);

    void onDetectedBlankScreen(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, int i);

    void onFormResubmission(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.os.Message message, android.os.Message message2);

    void onLoadResource(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str);

    void onPageCommitVisible(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str);

    void onPageFinished(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, int i, int i2, java.lang.String str);

    void onPageFinished(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str);

    void onPageStarted(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, int i, int i2, java.lang.String str, android.graphics.Bitmap bitmap);

    void onPageStarted(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, android.graphics.Bitmap bitmap);

    void onReceivedClientCertRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.ClientCertRequest clientCertRequest);

    void onReceivedError(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, int i, java.lang.String str, java.lang.String str2);

    void onReceivedError(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest, com.tencent.smtt.export.external.interfaces.WebResourceError webResourceError);

    void onReceivedHttpAuthRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.HttpAuthHandler httpAuthHandler, java.lang.String str, java.lang.String str2);

    void onReceivedHttpError(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest, com.tencent.smtt.export.external.interfaces.WebResourceResponse webResourceResponse);

    void onReceivedLoginRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str, java.lang.String str2, java.lang.String str3);

    void onReceivedSslError(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.SslErrorHandler sslErrorHandler, com.tencent.smtt.export.external.interfaces.SslError sslError);

    void onScaleChanged(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, float f, float f2);

    @java.lang.Deprecated
    void onTooManyRedirects(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.os.Message message, android.os.Message message2);

    void onUnhandledKeyEvent(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.view.KeyEvent keyEvent);

    com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest);

    com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest, android.os.Bundle bundle);

    com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str);

    boolean shouldOverrideKeyEvent(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, android.view.KeyEvent keyEvent);

    boolean shouldOverrideUrlLoading(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest);

    boolean shouldOverrideUrlLoading(com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase, java.lang.String str);
}
