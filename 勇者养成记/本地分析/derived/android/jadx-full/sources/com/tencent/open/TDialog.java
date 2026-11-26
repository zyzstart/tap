package com.tencent.open;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TDialog extends com.tencent.open.b {
    static final android.widget.FrameLayout.LayoutParams c = new android.widget.FrameLayout.LayoutParams(-1, -1);
    static android.widget.Toast d = null;
    private static java.lang.ref.WeakReference f;
    private java.lang.ref.WeakReference e;
    private java.lang.String g;
    private com.tencent.open.TDialog.OnTimeListener h;
    private com.tencent.tauth.IUiListener i;
    private android.widget.FrameLayout j;
    private com.tencent.open.b.b k;
    private android.os.Handler l;
    private boolean m;
    private com.tencent.connect.auth.QQToken n;

    private class FbWebViewClient extends android.webkit.WebViewClient {
        private FbWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            com.tencent.open.TDialog.this.k.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
            com.tencent.open.log.SLog.v("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            super.onReceivedError(webView, i, str, str2);
            com.tencent.open.TDialog.this.h.onError(new com.tencent.tauth.UiError(i, str, str2));
            if (com.tencent.open.TDialog.this.e != null && com.tencent.open.TDialog.this.e.get() != null) {
                android.widget.Toast.makeText((android.content.Context) com.tencent.open.TDialog.this.e.get(), "网络连接异常或系统错误", 0).show();
            }
            com.tencent.open.TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            com.tencent.open.log.SLog.v("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(com.tencent.open.utils.h.a().a((android.content.Context) com.tencent.open.TDialog.this.e.get(), "auth://tauth.qq.com/"))) {
                com.tencent.open.TDialog.this.h.onComplete(com.tencent.open.utils.l.c(str));
                if (com.tencent.open.TDialog.this.isShowing()) {
                    com.tencent.open.TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(com.tencent.connect.common.Constants.CANCEL_URI)) {
                com.tencent.open.TDialog.this.h.onCancel();
                if (com.tencent.open.TDialog.this.isShowing()) {
                    com.tencent.open.TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(com.tencent.connect.common.Constants.CLOSE_URI)) {
                if (com.tencent.open.TDialog.this.isShowing()) {
                    com.tencent.open.TDialog.this.dismiss();
                }
                return true;
            }
            if (!str.startsWith(com.tencent.connect.common.Constants.DOWNLOAD_URI) && !str.endsWith(".apk")) {
                return str.startsWith("auth://progress");
            }
            try {
                android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str.startsWith(com.tencent.connect.common.Constants.DOWNLOAD_URI) ? android.net.Uri.decode(str.substring(11)) : android.net.Uri.decode(str)));
                intent.addFlags(268435456);
                if (com.tencent.open.TDialog.this.e != null && com.tencent.open.TDialog.this.e.get() != null) {
                    ((android.content.Context) com.tencent.open.TDialog.this.e.get()).startActivity(intent);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    private class JsListener extends com.tencent.open.a.b {
        private JsListener() {
        }

        public void onAddShare(java.lang.String str) {
            com.tencent.open.log.SLog.d("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onCancel(java.lang.String str) {
            com.tencent.open.log.SLog.e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            com.tencent.open.TDialog.this.l.obtainMessage(2, str).sendToTarget();
            com.tencent.open.TDialog.this.dismiss();
        }

        public void onCancelAddShare(java.lang.String str) {
            com.tencent.open.log.SLog.e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
            onCancel(com.unisound.common.y.G);
        }

        public void onCancelInvite() {
            com.tencent.open.log.SLog.e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onComplete(java.lang.String str) {
            com.tencent.open.TDialog.this.l.obtainMessage(1, str).sendToTarget();
            com.tencent.open.log.SLog.e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            com.tencent.open.TDialog.this.dismiss();
        }

        public void onInvite(java.lang.String str) {
            onComplete(str);
        }

        public void onLoad(java.lang.String str) {
            com.tencent.open.TDialog.this.l.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(java.lang.String str) {
            com.tencent.open.TDialog.this.l.obtainMessage(3, str).sendToTarget();
        }
    }

    private static class OnTimeListener extends com.tencent.tauth.DefaultUiListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        java.lang.String f682a;
        java.lang.String b;
        private java.lang.ref.WeakReference c;
        private java.lang.String d;
        private com.tencent.tauth.IUiListener e;

        public OnTimeListener(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.tauth.IUiListener iUiListener) {
            this.c = new java.lang.ref.WeakReference(context);
            this.d = str;
            this.f682a = str2;
            this.b = str3;
            this.e = iUiListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(java.lang.String str) {
            try {
                onComplete(com.tencent.open.utils.l.d(str));
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                onError(new com.tencent.tauth.UiError(-4, com.tencent.connect.common.Constants.MSG_JSON_ERROR, str));
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            com.tencent.tauth.IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(java.lang.Object obj) {
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            com.tencent.open.a.g.a().a(this.d + "_H5", android.os.SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f682a, false);
            com.tencent.tauth.IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            java.lang.String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f682a;
            } else {
                str = this.f682a;
            }
            com.tencent.open.a.g gVarA = com.tencent.open.a.g.a();
            gVarA.a(this.d + "_H5", android.os.SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            com.tencent.tauth.IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.e = null;
            }
        }
    }

    private class THandler extends android.os.Handler {
        private com.tencent.open.TDialog.OnTimeListener b;

        public THandler(com.tencent.open.TDialog.OnTimeListener onTimeListener, android.os.Looper looper) {
            super(looper);
            this.b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.tencent.open.log.SLog.d("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i = message.what;
            if (i == 1) {
                this.b.a((java.lang.String) message.obj);
                return;
            }
            if (i == 2) {
                this.b.onCancel();
                return;
            }
            if (i == 3) {
                if (com.tencent.open.TDialog.this.e == null || com.tencent.open.TDialog.this.e.get() == null) {
                    return;
                }
                com.tencent.open.TDialog.c((android.content.Context) com.tencent.open.TDialog.this.e.get(), (java.lang.String) message.obj);
                return;
            }
            if (i != 5 || com.tencent.open.TDialog.this.e == null || com.tencent.open.TDialog.this.e.get() == null) {
                return;
            }
            com.tencent.open.TDialog.d((android.content.Context) com.tencent.open.TDialog.this.e.get(), (java.lang.String) message.obj);
        }
    }

    public TDialog(android.content.Context context, java.lang.String str, java.lang.String str2, com.tencent.tauth.IUiListener iUiListener, com.tencent.connect.auth.QQToken qQToken) {
        super(context, android.R.style.Theme.Translucent.NoTitleBar);
        this.m = false;
        this.n = null;
        this.e = new java.lang.ref.WeakReference(context);
        this.g = str2;
        this.h = new com.tencent.open.TDialog.OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.l = new com.tencent.open.TDialog.THandler(this.h, context.getMainLooper());
        this.i = iUiListener;
        this.n = qQToken;
    }

    private void a() {
        new android.widget.TextView((android.content.Context) this.e.get()).setText(com.tencent.midas.api.APMidasPayAPI.ENV_TEST);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.b.b bVar = new com.tencent.open.b.b((android.content.Context) this.e.get());
        this.k = bVar;
        bVar.setLayoutParams(layoutParams);
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout((android.content.Context) this.e.get());
        this.j = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.j.addView(this.k);
        setContentView(this.j);
    }

    @android.annotation.SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        this.k.setVerticalScrollBarEnabled(false);
        this.k.setHorizontalScrollBarEnabled(false);
        this.k.setWebViewClient(new com.tencent.open.TDialog.FbWebViewClient());
        this.k.setWebChromeClient(this.b);
        this.k.clearFormData();
        android.webkit.WebSettings settings = this.k.getSettings();
        if (settings == null) {
            return;
        }
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        java.lang.ref.WeakReference weakReference = this.e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(((android.content.Context) this.e.get()).getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f698a.a(new com.tencent.open.TDialog.JsListener(), "sdk_js_if");
        this.k.loadUrl(this.g);
        this.k.setLayoutParams(c);
        this.k.setVisibility(4);
        this.k.getSettings().setSavePassword(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(android.content.Context context, java.lang.String str) {
        try {
            org.json.JSONObject jSONObjectD = com.tencent.open.utils.l.d(str);
            int i = jSONObjectD.getInt(com.tencent.open.SocialConstants.PARAM_TYPE);
            java.lang.String string = jSONObjectD.getString("msg");
            if (i == 0) {
                if (d == null) {
                    d = android.widget.Toast.makeText(context, string, 0);
                } else {
                    d.setView(d.getView());
                    d.setText(string);
                    d.setDuration(0);
                }
            } else {
                if (i != 1) {
                    return;
                }
                if (d == null) {
                    d = android.widget.Toast.makeText(context, string, 1);
                } else {
                    d.setView(d.getView());
                    d.setText(string);
                    d.setDuration(1);
                }
            }
            d.show();
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(android.content.Context context, java.lang.String str) {
        android.app.ProgressDialog progressDialog;
        if (context == null || str == null) {
            return;
        }
        try {
            org.json.JSONObject jSONObjectD = com.tencent.open.utils.l.d(str);
            int i = jSONObjectD.getInt(com.tencent.tauth.AuthActivity.ACTION_KEY);
            java.lang.String string = jSONObjectD.getString("msg");
            if (i != 1) {
                if (i != 0 || f == null || f.get() == null || !((android.app.ProgressDialog) f.get()).isShowing()) {
                    return;
                }
                ((android.app.ProgressDialog) f.get()).dismiss();
                f = null;
                return;
            }
            if (f == null || f.get() == null) {
                android.app.ProgressDialog progressDialog2 = new android.app.ProgressDialog(context);
                progressDialog2.setMessage(string);
                f = new java.lang.ref.WeakReference(progressDialog2);
                progressDialog = progressDialog2;
            } else {
                ((android.app.ProgressDialog) f.get()).setMessage(string);
                if (((android.app.ProgressDialog) f.get()).isShowing()) {
                    return;
                } else {
                    progressDialog = (android.app.ProgressDialog) f.get();
                }
            }
            progressDialog.show();
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.open.b
    protected void a(java.lang.String str) {
        com.tencent.open.log.SLog.d("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.f698a.a(this.k, str);
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        com.tencent.open.TDialog.OnTimeListener onTimeListener = this.h;
        if (onTimeListener != null) {
            onTimeListener.onCancel();
        }
        super.onBackPressed();
    }

    @Override // com.tencent.open.b, android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a();
        new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: com.tencent.open.TDialog.1
            @Override // java.lang.Runnable
            public void run() {
                android.view.View decorView;
                android.view.View childAt;
                android.view.Window window = com.tencent.open.TDialog.this.getWindow();
                if (window == null || (decorView = window.getDecorView()) == null || (childAt = ((android.view.ViewGroup) decorView).getChildAt(0)) == null) {
                    return;
                }
                childAt.setPadding(0, 0, 0, 0);
            }
        });
        b();
    }
}
