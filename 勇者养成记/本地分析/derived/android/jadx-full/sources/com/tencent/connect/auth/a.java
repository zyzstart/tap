package com.tencent.connect.auth;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends android.app.Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f469a;
    private com.tencent.connect.auth.a.b b;
    private com.tencent.tauth.IUiListener c;
    private android.os.Handler d;
    private android.widget.FrameLayout e;
    private android.widget.LinearLayout f;
    private android.widget.FrameLayout g;
    private android.widget.ProgressBar h;
    private android.widget.Button i;
    private java.lang.String j;
    private com.tencent.open.b.c k;
    private android.content.Context l;
    private com.tencent.open.web.security.b m;
    private boolean n;
    private int o;
    private java.lang.String p;
    private java.lang.String q;
    private long r;
    private long s;
    private java.util.HashMap t;

    /* JADX INFO: renamed from: com.tencent.connect.auth.a$a, reason: collision with other inner class name */
    private class C0024a extends android.webkit.WebViewClient {
        private C0024a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            com.tencent.open.log.SLog.v("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            com.tencent.connect.auth.a.this.g.setVisibility(8);
            if (com.tencent.connect.auth.a.this.k != null) {
                com.tencent.connect.auth.a.this.k.setVisibility(0);
            }
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            com.tencent.connect.auth.a.this.d.removeCallbacks((java.lang.Runnable) com.tencent.connect.auth.a.this.t.remove(str));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
            com.tencent.open.log.SLog.v("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            com.tencent.connect.auth.a.this.g.setVisibility(0);
            com.tencent.connect.auth.a.this.r = android.os.SystemClock.elapsedRealtime();
            if (!android.text.TextUtils.isEmpty(com.tencent.connect.auth.a.this.p)) {
                com.tencent.connect.auth.a.this.d.removeCallbacks((java.lang.Runnable) com.tencent.connect.auth.a.this.t.remove(com.tencent.connect.auth.a.this.p));
            }
            com.tencent.connect.auth.a.this.p = str;
            com.tencent.connect.auth.a aVar = com.tencent.connect.auth.a.this;
            com.tencent.connect.auth.a.d dVar = aVar.new d(aVar.p);
            com.tencent.connect.auth.a.this.t.put(str, dVar);
            com.tencent.connect.auth.a.this.d.postDelayed(dVar, 120000L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            super.onReceivedError(webView, i, str, str2);
            com.tencent.open.log.SLog.i("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i + " | description: " + str);
            if (!com.tencent.open.utils.l.b(com.tencent.connect.auth.a.this.l)) {
                com.tencent.connect.auth.a.this.b.onError(new com.tencent.tauth.UiError(9001, "当前网络不可用，请稍后重试！", str2));
            } else {
                if (!com.tencent.connect.auth.a.this.p.startsWith("https://login.imgcache.qq.com/ptlogin/static/qzsjump.html")) {
                    long jElapsedRealtime = android.os.SystemClock.elapsedRealtime() - com.tencent.connect.auth.a.this.r;
                    if (com.tencent.connect.auth.a.this.o >= 1 || jElapsedRealtime >= com.tencent.connect.auth.a.this.s) {
                        com.tencent.connect.auth.a.this.k.loadUrl(com.tencent.connect.auth.a.this.a());
                        return;
                    } else {
                        com.tencent.connect.auth.a.m(com.tencent.connect.auth.a.this);
                        com.tencent.connect.auth.a.this.d.postDelayed(new java.lang.Runnable() { // from class: com.tencent.connect.auth.a.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.tencent.connect.auth.a.this.k.loadUrl(com.tencent.connect.auth.a.this.p);
                            }
                        }, 500L);
                        return;
                    }
                }
                com.tencent.connect.auth.a.this.b.onError(new com.tencent.tauth.UiError(i, str, str2));
            }
            com.tencent.connect.auth.a.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        @android.annotation.TargetApi(8)
        public void onReceivedSslError(android.webkit.WebView webView, final android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
            com.tencent.open.log.SLog.e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
            java.lang.String language = java.util.Locale.getDefault().getLanguage();
            java.lang.String str = "The SSL certificate is invalid,do you countinue?";
            java.lang.String str2 = "yes";
            java.lang.String str3 = cn.yunzhisheng.asr.JniUscClient.aA;
            if (language.equals("zh")) {
                str = "ssl证书无效，是否继续访问？";
                str2 = "是";
                str3 = "否";
            }
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(com.tencent.connect.auth.a.this.l);
            builder.setMessage(str);
            builder.setPositiveButton(str2, new android.content.DialogInterface.OnClickListener() { // from class: com.tencent.connect.auth.a.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i) {
                    sslErrorHandler.proceed();
                }
            });
            builder.setNegativeButton(str3, new android.content.DialogInterface.OnClickListener() { // from class: com.tencent.connect.auth.a.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i) {
                    sslErrorHandler.cancel();
                    com.tencent.connect.auth.a.this.dismiss();
                }
            });
            builder.create().show();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            com.tencent.open.log.SLog.v("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                org.json.JSONObject jSONObjectC = com.tencent.open.utils.l.c(str);
                com.tencent.connect.auth.a aVar = com.tencent.connect.auth.a.this;
                aVar.n = aVar.f();
                if (!com.tencent.connect.auth.a.this.n) {
                    if (jSONObjectC.optString("fail_cb", null) != null) {
                        com.tencent.connect.auth.a.this.a(jSONObjectC.optString("fail_cb"), "");
                    } else if (jSONObjectC.optInt("fall_to_wv") == 1) {
                        com.tencent.connect.auth.a aVar2 = com.tencent.connect.auth.a.this;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(com.tencent.connect.auth.a.this.f469a);
                        sb.append(com.tencent.connect.auth.a.this.f469a.indexOf(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START) > -1 ? "&" : com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
                        aVar2.f469a = sb.toString();
                        com.tencent.connect.auth.a.this.f469a = com.tencent.connect.auth.a.this.f469a + "browser_error=1";
                        com.tencent.connect.auth.a.this.k.loadUrl(com.tencent.connect.auth.a.this.f469a);
                    } else {
                        java.lang.String strOptString = jSONObjectC.optString("redir", null);
                        if (strOptString != null) {
                            com.tencent.connect.auth.a.this.k.loadUrl(strOptString);
                        }
                    }
                }
                return true;
            }
            if (str.startsWith("auth://tauth.qq.com/")) {
                com.tencent.connect.auth.a.this.b.onComplete(com.tencent.open.utils.l.c(str));
            } else if (str.startsWith(com.tencent.connect.common.Constants.CANCEL_URI)) {
                com.tencent.connect.auth.a.this.b.onCancel();
            } else if (!str.startsWith(com.tencent.connect.common.Constants.CLOSE_URI)) {
                if (str.startsWith(com.tencent.connect.common.Constants.DOWNLOAD_URI) || str.endsWith(".apk")) {
                    try {
                        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str.startsWith(com.tencent.connect.common.Constants.DOWNLOAD_URI) ? android.net.Uri.decode(str.substring(11)) : android.net.Uri.decode(str)));
                        intent.addFlags(268435456);
                        com.tencent.connect.auth.a.this.l.startActivity(intent);
                    } catch (java.lang.Exception e) {
                        com.tencent.open.log.SLog.e("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e);
                    }
                    return true;
                }
                if (!str.startsWith("auth://progress")) {
                    if (str.startsWith("auth://onLoginSubmit")) {
                        try {
                            java.util.List<java.lang.String> pathSegments = android.net.Uri.parse(str).getPathSegments();
                            if (!pathSegments.isEmpty()) {
                                com.tencent.connect.auth.a.this.q = pathSegments.get(0);
                            }
                        } catch (java.lang.Exception unused) {
                        }
                        return true;
                    }
                    if (com.tencent.connect.auth.a.this.m.a(com.tencent.connect.auth.a.this.k, str)) {
                        return true;
                    }
                    com.tencent.open.log.SLog.i("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                    return false;
                }
                try {
                    java.util.List<java.lang.String> pathSegments2 = android.net.Uri.parse(str).getPathSegments();
                    if (pathSegments2.isEmpty()) {
                        return true;
                    }
                    int iIntValue = java.lang.Integer.valueOf(pathSegments2.get(0)).intValue();
                    if (iIntValue == 0) {
                        com.tencent.connect.auth.a.this.g.setVisibility(8);
                        com.tencent.connect.auth.a.this.k.setVisibility(0);
                    } else if (iIntValue == 1) {
                        com.tencent.connect.auth.a.this.g.setVisibility(0);
                    }
                } catch (java.lang.Exception unused2) {
                }
                return true;
            }
            com.tencent.connect.auth.a.this.dismiss();
            return true;
        }
    }

    private class b extends com.tencent.tauth.DefaultUiListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        java.lang.String f478a;
        java.lang.String b;
        private java.lang.String d;
        private com.tencent.tauth.IUiListener e;

        public b(java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.tauth.IUiListener iUiListener) {
            this.d = str;
            this.f478a = str2;
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
            com.tencent.open.a.g.a().a(this.d + "_H5", android.os.SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f478a, false);
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
                str = uiError.errorMessage + this.f478a;
            } else {
                str = this.f478a;
            }
            com.tencent.open.a.g.a().a(this.d + "_H5", android.os.SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            com.tencent.connect.auth.a.this.a(str);
            com.tencent.tauth.IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.e = null;
            }
        }
    }

    private class c extends android.os.Handler {
        private com.tencent.connect.auth.a.b b;

        public c(com.tencent.connect.auth.a.b bVar, android.os.Looper looper) {
            super(looper);
            this.b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 1) {
                this.b.a((java.lang.String) message.obj);
            } else if (i == 2) {
                this.b.onCancel();
            } else {
                if (i != 3) {
                    return;
                }
                com.tencent.connect.auth.a.b(com.tencent.connect.auth.a.this.l, (java.lang.String) message.obj);
            }
        }
    }

    class d implements java.lang.Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        java.lang.String f480a;

        public d(java.lang.String str) {
            this.f480a = "";
            this.f480a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.open.log.SLog.v("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f480a + " | mRetryUrl: " + com.tencent.connect.auth.a.this.p);
            if (this.f480a.equals(com.tencent.connect.auth.a.this.p)) {
                com.tencent.connect.auth.a.this.b.onError(new com.tencent.tauth.UiError(9002, "请求页面超时，请稍后重试！", com.tencent.connect.auth.a.this.p));
                com.tencent.connect.auth.a.this.dismiss();
            }
        }
    }

    public a(android.content.Context context, java.lang.String str, java.lang.String str2, com.tencent.tauth.IUiListener iUiListener, com.tencent.connect.auth.QQToken qQToken) {
        super(context, android.R.style.Theme.Translucent.NoTitleBar);
        this.n = false;
        this.r = 0L;
        this.s = 30000L;
        this.l = context;
        this.f469a = str2;
        this.b = new com.tencent.connect.auth.a.b(str, str2, qQToken.getAppId(), iUiListener);
        this.d = new com.tencent.connect.auth.a.c(this.b, context.getMainLooper());
        this.c = iUiListener;
        this.j = str;
        this.m = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String a() {
        java.lang.String str = this.f469a;
        java.lang.String str2 = "https://login.imgcache.qq.com/ptlogin/static/qzsjump.html" + str.substring(str.indexOf(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START) + 1);
        com.tencent.open.log.SLog.i("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: https://login.imgcache.qq.com/ptlogin/static/qzsjump.html");
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String a(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str);
        if (!android.text.TextUtils.isEmpty(this.q) && this.q.length() >= 4) {
            java.lang.String str2 = this.q;
            java.lang.String strSubstring = str2.substring(str2.length() - 4);
            sb.append("_u_");
            sb.append(strSubstring);
        }
        return sb.toString();
    }

    private void b() {
        d();
        c();
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.b.c cVar = new com.tencent.open.b.c(this.l);
        this.k = cVar;
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            cVar.setLayerType(1, null);
        }
        this.k.setLayoutParams(layoutParams);
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(this.l);
        this.e = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.e.addView(this.k);
        this.e.addView(this.g);
        java.lang.String string = com.tencent.open.utils.l.b(this.f469a).getString("style");
        if (string != null && "qr".equals(string)) {
            this.e.addView(this.i);
        }
        setContentView(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(android.content.Context context, java.lang.String str) {
        try {
            org.json.JSONObject jSONObjectD = com.tencent.open.utils.l.d(str);
            int i = jSONObjectD.getInt(com.tencent.open.SocialConstants.PARAM_TYPE);
            android.widget.Toast.makeText(context.getApplicationContext(), jSONObjectD.getString("msg"), i).show();
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    private void c() {
        android.widget.Button button = new android.widget.Button(this.l);
        this.i = button;
        button.setBackgroundDrawable(com.tencent.open.utils.l.a("h5_qr_back.png", this.l));
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = com.tencent.connect.avatar.a.a(this.l, 20.0f);
        layoutParams.topMargin = com.tencent.connect.avatar.a.a(this.l, 10.0f);
        this.i.setLayoutParams(layoutParams);
        this.i.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.connect.auth.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.tencent.connect.auth.a.this.dismiss();
                if (com.tencent.connect.auth.a.this.n || com.tencent.connect.auth.a.this.b == null) {
                    return;
                }
                com.tencent.connect.auth.a.this.b.onCancel();
            }
        });
    }

    private void d() {
        android.widget.TextView textView;
        this.h = new android.widget.ProgressBar(this.l);
        this.h.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
        this.f = new android.widget.LinearLayout(this.l);
        if (this.j.equals("action_login")) {
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new android.widget.TextView(this.l);
            textView.setText(java.util.Locale.getDefault().getLanguage().equals("zh") ? "登录中..." : "Logging in...");
            textView.setTextColor(android.graphics.Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = null;
        }
        android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f.setLayoutParams(layoutParams2);
        this.f.addView(this.h);
        if (textView != null) {
            this.f.addView(textView);
        }
        this.g = new android.widget.FrameLayout(this.l);
        android.widget.FrameLayout.LayoutParams layoutParams3 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        this.g.setLayoutParams(layoutParams3);
        this.g.setBackgroundColor(android.graphics.Color.parseColor("#B3000000"));
        this.g.addView(this.f);
    }

    @android.annotation.SuppressLint({"SetJavaScriptEnabled"})
    private void e() {
        this.k.setVerticalScrollBarEnabled(false);
        this.k.setHorizontalScrollBarEnabled(false);
        this.k.setWebViewClient(new com.tencent.connect.auth.a.C0024a());
        this.k.setWebChromeClient(new android.webkit.WebChromeClient());
        this.k.clearFormData();
        this.k.clearSslPreferences();
        this.k.setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: com.tencent.connect.auth.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(android.view.View view) {
                return true;
            }
        });
        this.k.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.tencent.connect.auth.a.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        android.webkit.WebSettings settings = this.k.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.l.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        com.tencent.open.log.SLog.v("openSDK_LOG.AuthDialog", "-->mUrl : " + this.f469a);
        java.lang.String str = this.f469a;
        this.p = str;
        this.k.loadUrl(str);
        this.k.setVisibility(4);
        this.k.getSettings().setSavePassword(false);
        this.m.a(new com.tencent.open.web.security.SecureJsInterface(), "SecureJsInterface");
        com.tencent.open.web.security.SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.tencent.connect.auth.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(android.content.DialogInterface dialogInterface) {
                try {
                    if (com.tencent.open.web.security.JniInterface.isJniOk) {
                        com.tencent.open.web.security.JniInterface.clearAllPWD();
                    }
                } catch (java.lang.Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        com.tencent.connect.auth.b bVarA = com.tencent.connect.auth.b.a();
        java.lang.String strC = bVarA.c();
        com.tencent.connect.auth.b.a aVar = new com.tencent.connect.auth.b.a();
        aVar.f482a = this.c;
        aVar.b = this;
        aVar.c = strC;
        java.lang.String strA = bVarA.a(aVar);
        java.lang.String str = this.f469a;
        java.lang.String strSubstring = str.substring(0, str.indexOf(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START));
        android.os.Bundle bundleB = com.tencent.open.utils.l.b(this.f469a);
        bundleB.putString("[REDACTED]", strC);
        bundleB.putString("serial", strA);
        bundleB.putString("browser", "1");
        java.lang.String str2 = strSubstring + com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START + com.tencent.open.utils.HttpUtils.encodeUrl(bundleB);
        this.f469a = str2;
        return com.tencent.open.utils.l.a(this.l, str2);
    }

    static /* synthetic */ int m(com.tencent.connect.auth.a aVar) {
        int i = aVar.o;
        aVar.o = i + 1;
        return i;
    }

    public void a(java.lang.String str, java.lang.String str2) {
        this.k.loadUrl("javascript:" + str + "(" + str2 + ");void(" + java.lang.System.currentTimeMillis() + ");");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.t.clear();
        this.d.removeCallbacksAndMessages(null);
        try {
            if ((this.l instanceof android.app.Activity) && !((android.app.Activity) this.l).isFinishing() && isShowing()) {
                super.dismiss();
                com.tencent.open.log.SLog.i("openSDK_LOG.AuthDialog", "-->dismiss dialog");
            }
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.AuthDialog", "-->dismiss dialog exception:", e);
        }
        com.tencent.open.b.c cVar = this.k;
        if (cVar != null) {
            cVar.destroy();
            this.k = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.n) {
            this.b.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        requestWindowFeature(1);
        android.view.Window window = getWindow();
        if (window != null) {
            window.setFlags(1024, 1024);
        }
        super.onCreate(bundle);
        if (window != null) {
            android.view.View decorView = window.getDecorView();
            if (android.os.Build.VERSION.SDK_INT >= 16) {
                decorView.setSystemUiVisibility(1280);
            }
        }
        b();
        e();
        this.t = new java.util.HashMap();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }
}
