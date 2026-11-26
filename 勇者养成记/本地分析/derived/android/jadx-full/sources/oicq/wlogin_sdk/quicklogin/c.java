package oicq.wlogin_sdk.quicklogin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class c extends android.webkit.WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.Activity f1670a;
    final /* synthetic */ android.webkit.WebView b;
    final /* synthetic */ java.lang.String c;

    c(android.app.Activity activity, android.webkit.WebView webView, java.lang.String str) {
        this.f1670a = activity;
        this.b = webView;
        this.c = str;
    }

    private boolean a(android.net.http.SslCertificate sslCertificate) {
        byte[] bArr = {51, -65, -44, 0, 73, 7, 89, -98, 112, -76, -112, -125, 58, 25, -96, -8, -40, -51, 57, -89, -92, -47, 9, -16, -108, 34, -93, -30, -1, -123, -89, -98};
        byte[] byteArray = android.net.http.SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray == null) {
            return false;
        }
        try {
            return java.util.Arrays.equals(java.security.MessageDigest.getInstance("SHA-256").digest(((java.security.cert.X509Certificate) java.security.cert.CertificateFactory.getInstance("X.509").generateCertificate(new java.io.ByteArrayInputStream(byteArray))).getEncoded()), bArr);
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
        if (17 <= android.os.Build.VERSION.SDK_INT) {
            this.b.loadUrl(this.c);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        try {
            oicq.wlogin_sdk.tools.util.LOGI("ssl error " + sslError.getUrl() + ":" + sslError.getPrimaryError());
        } catch (java.lang.Error unused) {
        }
        if (true == oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader.sslErrorProcessed) {
            sslErrorHandler.proceed();
            return;
        }
        if ((sslError.getPrimaryError() == 4 || sslError.getPrimaryError() == 1 || sslError.getPrimaryError() == 5 || sslError.getPrimaryError() == 3) && sslError.getUrl().startsWith("https://xui.ptlogin2.qq.com") && a(sslError.getCertificate())) {
            sslErrorHandler.proceed();
            oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader.sslErrorProcessed = true;
            return;
        }
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this.f1670a);
        builder.setMessage("页面证书错误(" + sslError.getPrimaryError() + ")，是否继续？");
        builder.setPositiveButton("继续", new oicq.wlogin_sdk.quicklogin.d(this, sslErrorHandler));
        builder.setNegativeButton("取消", new oicq.wlogin_sdk.quicklogin.e(this, sslErrorHandler));
        builder.setOnCancelListener(new oicq.wlogin_sdk.quicklogin.f(this, sslErrorHandler));
        try {
            builder.create().show();
        } catch (java.lang.Exception unused2) {
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
        if (str == null) {
            return false;
        }
        try {
            webView.getContext().startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str)));
            return true;
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("load url ");
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append(" failed ");
            sb.append(e.getMessage());
            oicq.wlogin_sdk.tools.util.LOGI(sb.toString(), "");
            return true;
        }
    }
}
