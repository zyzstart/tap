package oicq.wlogin_sdk.quicklogin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class g implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.webkit.WebView f1674a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ java.lang.String c;

    g(android.webkit.WebView webView, java.lang.String str, java.lang.String str2) {
        this.f1674a = webView;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.webkit.WebView webView;
        java.lang.String str;
        java.lang.StringBuilder sb;
        java.lang.String message;
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            this.f1674a.loadUrl(this.b);
            try {
                this.f1674a.evaluateJavascript(this.c, null);
                return;
            } catch (java.lang.Error e) {
                sb = new java.lang.StringBuilder();
                sb.append("evaluateJavascript function can't use:");
                sb.append(android.os.Build.VERSION.SDK_INT);
                sb.append(" message ");
                message = e.getMessage();
                sb.append(message);
                oicq.wlogin_sdk.tools.util.LOGI(sb.toString(), "");
                webView = this.f1674a;
                str = this.c;
                webView.loadUrl(str);
            } catch (java.lang.Exception e2) {
                sb = new java.lang.StringBuilder();
                sb.append("evaluateJavascript function can't use:");
                sb.append(android.os.Build.VERSION.SDK_INT);
                sb.append(" message ");
                message = e2.getMessage();
                sb.append(message);
                oicq.wlogin_sdk.tools.util.LOGI(sb.toString(), "");
                webView = this.f1674a;
                str = this.c;
                webView.loadUrl(str);
            }
        }
        this.f1674a.loadUrl(this.c);
        webView = this.f1674a;
        str = this.b;
        webView.loadUrl(str);
    }
}
