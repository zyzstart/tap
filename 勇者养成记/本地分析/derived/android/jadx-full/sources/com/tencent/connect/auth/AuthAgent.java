package com.tencent.connect.auth;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AuthAgent extends com.tencent.connect.common.BaseApi {
    public static final java.lang.String KEY_FORCE_QR_LOGIN = "KEY_FORCE_QR_LOGIN";
    public static final java.lang.String SECURE_LIB_ARM64_FILE_NAME = "libwbsafeedit_64";
    public static final java.lang.String SECURE_LIB_ARM_FILE_NAME = "libwbsafeedit";
    public static java.lang.String SECURE_LIB_FILE_NAME = "libwbsafeedit";
    public static java.lang.String SECURE_LIB_NAME = null;
    public static final int SECURE_LIB_VERSION = 5;
    public static final java.lang.String SECURE_LIB_X86_64_FILE_NAME = "libwbsafeedit_x86_64";
    public static final java.lang.String SECURE_LIB_X86_FILE_NAME = "libwbsafeedit_x86";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.tauth.IUiListener f459a;
    private java.lang.String d;
    private java.lang.ref.WeakReference e;

    private class a extends com.tencent.tauth.DefaultUiListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.tencent.tauth.IUiListener f462a;

        public a(com.tencent.tauth.IUiListener iUiListener) {
            this.f462a = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            com.tencent.tauth.IUiListener iUiListener = this.f462a;
            if (iUiListener != null) {
                iUiListener.onCancel();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(java.lang.Object obj) {
            if (obj == null) {
                com.tencent.open.log.SLog.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data is null");
                return;
            }
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            try {
                int i = jSONObject.getInt("ret");
                java.lang.String string = i == 0 ? com.unisound.common.y.J : jSONObject.getString("msg");
                if (this.f462a != null) {
                    this.f462a.onComplete(new org.json.JSONObject().put("ret", i).put("msg", string));
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                com.tencent.open.log.SLog.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data format error");
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            com.tencent.tauth.IUiListener iUiListener = this.f462a;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
            }
        }
    }

    private class b extends com.tencent.tauth.DefaultUiListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        java.lang.ref.WeakReference f463a;
        private final java.lang.String c = "sendinstall";
        private final java.lang.String d = "installwording";
        private final java.lang.String e = "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";

        private abstract class a implements android.view.View.OnClickListener {
            android.app.Dialog d;

            a(android.app.Dialog dialog) {
                this.d = dialog;
            }
        }

        public b(com.tencent.tauth.IUiListener iUiListener) {
            this.f463a = new java.lang.ref.WeakReference(iUiListener);
        }

        private android.graphics.drawable.Drawable a(java.lang.String str, android.content.Context context) {
            android.graphics.Bitmap bitmapDecodeStream;
            try {
                java.io.InputStream inputStreamOpen = context.getApplicationContext().getAssets().open(str);
                if (inputStreamOpen == null) {
                    return null;
                }
                if (!str.endsWith(".9.png")) {
                    android.graphics.drawable.Drawable drawableCreateFromStream = android.graphics.drawable.Drawable.createFromStream(inputStreamOpen, str);
                    inputStreamOpen.close();
                    return drawableCreateFromStream;
                }
                try {
                    bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(inputStreamOpen);
                } catch (java.lang.OutOfMemoryError e) {
                    e.printStackTrace();
                    bitmapDecodeStream = null;
                }
                if (bitmapDecodeStream == null) {
                    return null;
                }
                byte[] ninePatchChunk = bitmapDecodeStream.getNinePatchChunk();
                android.graphics.NinePatch.isNinePatchChunk(ninePatchChunk);
                return new android.graphics.drawable.NinePatchDrawable(bitmapDecodeStream, ninePatchChunk, new android.graphics.Rect(), null);
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        private android.view.View a(android.content.Context context, android.graphics.drawable.Drawable drawable, java.lang.String str, android.view.View.OnClickListener onClickListener, android.view.View.OnClickListener onClickListener2) {
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            float f = displayMetrics.density;
            android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(context);
            android.widget.ImageView imageView = new android.widget.ImageView(context);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            imageView.setId(1);
            int i = (int) (60.0f * f);
            int i2 = (int) (f * 14.0f);
            int i3 = (int) (18.0f * f);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(i, i);
            layoutParams.addRule(9);
            layoutParams.setMargins(0, i3, (int) (6.0f * f), i3);
            relativeLayout.addView(imageView, layoutParams);
            android.widget.TextView textView = new android.widget.TextView(context);
            textView.setText(str);
            textView.setTextSize(14.0f);
            textView.setGravity(3);
            textView.setIncludeFontPadding(false);
            textView.setPadding(0, 0, 0, 0);
            textView.setLines(2);
            textView.setId(5);
            textView.setMinWidth((int) (185.0f * f));
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, 1);
            layoutParams2.addRule(6, 1);
            float f2 = 5.0f * f;
            layoutParams2.setMargins(0, 0, (int) f2, 0);
            relativeLayout.addView(textView, layoutParams2);
            android.view.View view = new android.view.View(context);
            view.setBackgroundColor(android.graphics.Color.rgb(com.tencent.smtt.sdk.TbsListener.ErrorCode.COPY_TMPDIR_ERROR, com.tencent.smtt.sdk.TbsListener.ErrorCode.COPY_TMPDIR_ERROR, com.tencent.smtt.sdk.TbsListener.ErrorCode.COPY_TMPDIR_ERROR));
            view.setId(3);
            android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-2, 2);
            layoutParams3.addRule(3, 1);
            layoutParams3.addRule(5, 1);
            layoutParams3.addRule(7, 5);
            int i4 = (int) (12.0f * f);
            layoutParams3.setMargins(0, 0, 0, i4);
            relativeLayout.addView(view, layoutParams3);
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
            android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(5, 1);
            layoutParams4.addRule(7, 5);
            layoutParams4.addRule(3, 3);
            android.widget.Button button = new android.widget.Button(context);
            button.setText("跳过");
            button.setBackgroundDrawable(a("buttonNegt.png", context));
            button.setTextColor(android.graphics.Color.rgb(36, 97, 131));
            button.setTextSize(20.0f);
            button.setOnClickListener(onClickListener2);
            button.setId(4);
            int i5 = (int) (45.0f * f);
            android.widget.LinearLayout.LayoutParams layoutParams5 = new android.widget.LinearLayout.LayoutParams(0, i5);
            layoutParams5.rightMargin = i2;
            int i6 = (int) (4.0f * f);
            layoutParams5.leftMargin = i6;
            layoutParams5.weight = 1.0f;
            linearLayout.addView(button, layoutParams5);
            android.widget.Button button2 = new android.widget.Button(context);
            button2.setText("确定");
            button2.setTextSize(20.0f);
            button2.setTextColor(android.graphics.Color.rgb(255, 255, 255));
            button2.setBackgroundDrawable(a("buttonPost.png", context));
            button2.setOnClickListener(onClickListener);
            android.widget.LinearLayout.LayoutParams layoutParams6 = new android.widget.LinearLayout.LayoutParams(0, i5);
            layoutParams6.weight = 1.0f;
            layoutParams6.rightMargin = i6;
            linearLayout.addView(button2, layoutParams6);
            relativeLayout.addView(linearLayout, layoutParams4);
            android.view.ViewGroup.LayoutParams layoutParams7 = new android.widget.FrameLayout.LayoutParams((int) (279.0f * f), (int) (f * 163.0f));
            relativeLayout.setPadding(i2, 0, i4, i4);
            relativeLayout.setLayoutParams(layoutParams7);
            relativeLayout.setBackgroundColor(android.graphics.Color.rgb(247, 251, 247));
            android.graphics.drawable.PaintDrawable paintDrawable = new android.graphics.drawable.PaintDrawable(android.graphics.Color.rgb(247, 251, 247));
            paintDrawable.setCornerRadius(f2);
            relativeLayout.setBackgroundDrawable(paintDrawable);
            return relativeLayout;
        }

        private void a(java.lang.String str, final com.tencent.tauth.IUiListener iUiListener, final java.lang.Object obj) {
            android.content.pm.PackageInfo packageInfo;
            java.lang.String str2;
            java.lang.String str3;
            if (com.tencent.connect.auth.AuthAgent.this.e == null) {
                str2 = "openSDK_LOG.AuthAgent";
                str3 = "showFeedConfrimDialog mActivity null and return";
            } else {
                android.app.Activity activity = (android.app.Activity) com.tencent.connect.auth.AuthAgent.this.e.get();
                if (activity != null) {
                    android.app.Dialog dialog = new android.app.Dialog(activity);
                    dialog.requestWindowFeature(1);
                    android.content.pm.PackageManager packageManager = activity.getPackageManager();
                    try {
                        packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
                    } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                        com.tencent.open.log.SLog.e("openSDK_LOG.AuthAgent", "showFeedConfrimDialog exception:" + e.getStackTrace().toString());
                        packageInfo = null;
                    }
                    android.graphics.drawable.Drawable drawableLoadIcon = packageInfo != null ? packageInfo.applicationInfo.loadIcon(packageManager) : null;
                    android.view.View.OnClickListener onClickListener = new com.tencent.connect.auth.AuthAgent.b.a(dialog) { // from class: com.tencent.connect.auth.AuthAgent.b.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(android.view.View view) {
                            com.tencent.connect.auth.AuthAgent.b.this.a();
                            android.app.Dialog dialog2 = this.d;
                            if (dialog2 != null && dialog2.isShowing()) {
                                this.d.dismiss();
                            }
                            com.tencent.tauth.IUiListener iUiListener2 = iUiListener;
                            if (iUiListener2 != null) {
                                iUiListener2.onComplete(obj);
                            }
                        }
                    };
                    android.view.View.OnClickListener onClickListener2 = new com.tencent.connect.auth.AuthAgent.b.a(dialog) { // from class: com.tencent.connect.auth.AuthAgent.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(android.view.View view) {
                            android.app.Dialog dialog2 = this.d;
                            if (dialog2 != null && dialog2.isShowing()) {
                                this.d.dismiss();
                            }
                            com.tencent.tauth.IUiListener iUiListener2 = iUiListener;
                            if (iUiListener2 != null) {
                                iUiListener2.onComplete(obj);
                            }
                        }
                    };
                    android.graphics.drawable.ColorDrawable colorDrawable = new android.graphics.drawable.ColorDrawable();
                    colorDrawable.setAlpha(0);
                    dialog.getWindow().setBackgroundDrawable(colorDrawable);
                    dialog.setContentView(a(activity, drawableLoadIcon, str, onClickListener, onClickListener2));
                    dialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() { // from class: com.tencent.connect.auth.AuthAgent.b.3
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(android.content.DialogInterface dialogInterface) {
                            com.tencent.tauth.IUiListener iUiListener2 = iUiListener;
                            if (iUiListener2 != null) {
                                iUiListener2.onComplete(obj);
                            }
                        }
                    });
                    if (activity == null || activity.isFinishing()) {
                        return;
                    }
                    dialog.show();
                    return;
                }
                str2 = "openSDK_LOG.AuthAgent";
                str3 = "showFeedConfrimDialog mActivity.get() null and return";
            }
            com.tencent.open.log.SLog.i(str2, str3);
        }

        protected void a() {
            android.app.Activity activity;
            android.os.Bundle bundleB = com.tencent.connect.auth.AuthAgent.this.b();
            if (com.tencent.connect.auth.AuthAgent.this.e == null || (activity = (android.app.Activity) com.tencent.connect.auth.AuthAgent.this.e.get()) == null) {
                return;
            }
            com.tencent.open.utils.HttpUtils.requestAsync(((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c, activity, "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", bundleB, com.tencent.connect.common.Constants.HTTP_POST, null);
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.f463a.get() != null) {
                ((com.tencent.tauth.IUiListener) this.f463a.get()).onCancel();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(java.lang.Object obj) {
            org.json.JSONObject jSONObject;
            boolean z;
            if (obj == null || (jSONObject = (org.json.JSONObject) obj) == null) {
                return;
            }
            java.lang.String string = "";
            boolean zSaveSession = false;
            try {
                z = jSONObject.getInt("sendinstall") == 1;
                try {
                    string = jSONObject.getString("installwording");
                } catch (org.json.JSONException unused) {
                    com.tencent.open.log.SLog.w("openSDK_LOG.AuthAgent", "FeedConfirmListener onComplete There is no value for sendinstall.");
                }
            } catch (org.json.JSONException unused2) {
                z = false;
            }
            java.lang.String strDecode = java.net.URLDecoder.decode(string);
            com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", " WORDING = " + strDecode + "xx,showConfirmDialog=" + z);
            if (z && !android.text.TextUtils.isEmpty(strDecode)) {
                a(strDecode, (com.tencent.tauth.IUiListener) this.f463a.get(), obj);
                com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", " WORDING is not empty and return");
                return;
            }
            com.tencent.tauth.IUiListener iUiListener = (com.tencent.tauth.IUiListener) this.f463a.get();
            if (iUiListener == null) {
                com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", " userListener is null");
                return;
            }
            if (((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c != null) {
                zSaveSession = ((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c.saveSession(jSONObject);
                com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", " saveSession saveSuccess=" + zSaveSession);
            }
            if (zSaveSession) {
                iUiListener.onComplete(obj);
            } else {
                iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PERSISTENCE_FAIL, null));
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            if (this.f463a.get() != null) {
                ((com.tencent.tauth.IUiListener) this.f463a.get()).onError(uiError);
            }
        }
    }

    private class c extends com.tencent.tauth.DefaultUiListener {
        private final com.tencent.tauth.IUiListener b;
        private final boolean c;
        private final android.content.Context d;

        public c(android.content.Context context, com.tencent.tauth.IUiListener iUiListener, boolean z, boolean z2) {
            this.d = context;
            this.b = iUiListener;
            this.c = z;
            com.tencent.open.log.SLog.d("[REDACTED]", "[REDACTED]");
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            com.tencent.open.log.SLog.d("[REDACTED]", "[REDACTED]");
            this.b.onCancel();
            com.tencent.open.log.SLog.release();
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0072 A[Catch: JSONException -> 0x007a, TRY_LEAVE, TryCatch #0 {JSONException -> 0x007a, blocks: (B:3:0x0009, B:5:0x001d, B:8:0x0027, B:9:0x0044, B:15:0x006e, B:17:0x0072, B:14:0x0064, B:11:0x004c), top: B:23:0x0009, inners: #1 }] */
        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(java.lang.Object obj) {
            com.tencent.open.log.SLog.d("[REDACTED]", "[REDACTED]");
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            try {
                java.lang.String string = jSONObject.getString(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN);
                java.lang.String string2 = jSONObject.getString(com.tencent.connect.common.Constants.PARAM_EXPIRES_IN);
                java.lang.String string3 = jSONObject.getString("openid");
                if (string != null && ((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c != null && string3 != null) {
                    ((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c.setAccessToken(string, string2);
                    ((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c.setOpenId(string3);
                    com.tencent.connect.a.a.d(this.d, ((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c);
                }
                java.lang.String string4 = jSONObject.getString("pf");
                if (string4 != null) {
                    try {
                        this.d.getSharedPreferences(com.tencent.connect.common.Constants.PREFERENCE_PF, 0).edit().putString("pf", string4).commit();
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        com.tencent.open.log.SLog.e("[REDACTED]", "[REDACTED]", e);
                    }
                    if (this.c) {
                        android.webkit.CookieSyncManager.getInstance().sync();
                    }
                } else if (this.c) {
                    android.webkit.CookieSyncManager.getInstance().sync();
                }
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
                com.tencent.open.log.SLog.e("[REDACTED]", "[REDACTED]", e2);
            }
            this.b.onComplete(jSONObject);
            com.tencent.connect.auth.AuthAgent.this.releaseResource();
            com.tencent.open.log.SLog.release();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            com.tencent.open.log.SLog.d("[REDACTED]", "[REDACTED]");
            this.b.onError(uiError);
            com.tencent.open.log.SLog.release();
        }
    }

    static {
        java.lang.StringBuilder sb;
        java.lang.String str;
        java.lang.String str2;
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        java.lang.String str3 = android.os.Build.CPU_ABI;
        if (str3 != null && !str3.equals("")) {
            if (str3.equalsIgnoreCase("arm64-v8a")) {
                SECURE_LIB_FILE_NAME = SECURE_LIB_ARM64_FILE_NAME;
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                str = "openSDK_LOG.AuthAgent";
                str2 = "is arm64-v8a architecture";
            } else if (str3.equalsIgnoreCase(com.bun.miitmdid.core.Utils.CPU_ABI_X86)) {
                SECURE_LIB_FILE_NAME = SECURE_LIB_X86_FILE_NAME;
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                str = "openSDK_LOG.AuthAgent";
                str2 = "is x86 architecture";
            } else if (str3.equalsIgnoreCase("x86_64")) {
                SECURE_LIB_FILE_NAME = SECURE_LIB_X86_64_FILE_NAME;
                SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
                str = "openSDK_LOG.AuthAgent";
                str2 = "is x86_64 architecture";
            } else {
                SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
                sb = new java.lang.StringBuilder();
            }
            com.tencent.open.log.SLog.i(str, str2);
        }
        SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
        sb = new java.lang.StringBuilder();
        sb.append(SECURE_LIB_FILE_NAME);
        sb.append(".so");
        SECURE_LIB_NAME = sb.toString();
        str = "openSDK_LOG.AuthAgent";
        str2 = "is arm(default) architecture";
        com.tencent.open.log.SLog.i(str, str2);
    }

    public AuthAgent(com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
    }

    private int a(boolean z, com.tencent.tauth.IUiListener iUiListener, boolean z2) {
        com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- start");
        android.webkit.CookieSyncManager.createInstance(com.tencent.open.utils.f.a());
        android.os.Bundle bundleA = a();
        if (z) {
            bundleA.putString("isadd", "1");
        }
        bundleA.putString(com.tencent.connect.common.Constants.PARAM_SCOPE, this.d);
        bundleA.putString(com.tencent.connect.common.Constants.PARAM_CLIENT_ID, this.c.getAppId());
        if (com.tencent.connect.common.BaseApi.isOEM) {
            bundleA.putString("pf", "desktop_m_qq-" + com.tencent.connect.common.BaseApi.installChannel + "-android-" + com.tencent.connect.common.BaseApi.registerChannel + "-" + com.tencent.connect.common.BaseApi.businessId);
        } else {
            bundleA.putString("pf", com.tencent.connect.common.Constants.DEFAULT_PF);
        }
        java.lang.String str = (java.lang.System.currentTimeMillis() / 1000) + "";
        bundleA.putString("sign", com.tencent.open.utils.i.b(com.tencent.open.utils.f.a(), str));
        bundleA.putString("time", str);
        bundleA.putString("display", "mobile");
        bundleA.putString("[REDACTED]", "[REDACTED]");
        bundleA.putString("redirect_uri", "auth://tauth.qq.com/");
        bundleA.putString("cancel_display", "1");
        bundleA.putString("switch", "1");
        bundleA.putString("compat_v", "1");
        if (z2) {
            bundleA.putString("style", "qr");
        }
        final java.lang.String str2 = com.tencent.open.utils.h.a().a(com.tencent.open.utils.f.a(), "https://openmobile.qq.com/oauth2.0/m_authorize") + com.tencent.open.utils.HttpUtils.encodeUrl(bundleA);
        final com.tencent.connect.auth.AuthAgent.c cVar = new com.tencent.connect.auth.AuthAgent.c(com.tencent.open.utils.f.a(), iUiListener, true, false);
        com.tencent.open.log.SLog.d("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
        com.tencent.open.utils.j.a(new java.lang.Runnable() { // from class: com.tencent.connect.auth.AuthAgent.1
            @Override // java.lang.Runnable
            public void run() {
                final android.app.Activity activity;
                com.tencent.open.utils.i.a(com.tencent.connect.auth.AuthAgent.SECURE_LIB_FILE_NAME, com.tencent.connect.auth.AuthAgent.SECURE_LIB_NAME, 5);
                com.tencent.open.web.security.JniInterface.loadSo();
                if (com.tencent.connect.auth.AuthAgent.this.e == null || (activity = (android.app.Activity) com.tencent.connect.auth.AuthAgent.this.e.get()) == null) {
                    return;
                }
                activity.runOnUiThread(new java.lang.Runnable() { // from class: com.tencent.connect.auth.AuthAgent.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        android.app.Dialog tDialog;
                        if (com.tencent.open.web.security.JniInterface.isJniOk) {
                            android.app.Activity activity2 = activity;
                            com.tencent.connect.auth.AuthAgent.AnonymousClass1 anonymousClass1 = com.tencent.connect.auth.AuthAgent.AnonymousClass1.this;
                            tDialog = new com.tencent.connect.auth.a(activity2, "action_login", str2, cVar, ((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c);
                            if (activity.isFinishing()) {
                                return;
                            }
                        } else {
                            com.tencent.open.log.SLog.w("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                            android.app.Activity activity3 = activity;
                            java.lang.String strA = com.tencent.connect.auth.AuthAgent.this.a("");
                            com.tencent.connect.auth.AuthAgent.AnonymousClass1 anonymousClass2 = com.tencent.connect.auth.AuthAgent.AnonymousClass1.this;
                            tDialog = new com.tencent.open.TDialog(activity3, "", strA, cVar, ((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c);
                            if (activity.isFinishing()) {
                                return;
                            }
                        }
                        tDialog.show();
                    }
                });
            }
        });
        com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
        return 2;
    }

    private java.lang.String a(android.os.Bundle bundle) {
        java.lang.String string = bundle.getString("status_os");
        java.lang.String string2 = bundle.getString("status_machine");
        java.lang.String string3 = bundle.getString("status_version");
        java.lang.String string4 = bundle.getString("sdkv");
        java.lang.String string5 = bundle.getString(com.tencent.connect.common.Constants.PARAM_CLIENT_ID);
        java.lang.String string6 = bundle.getString("need_pay");
        java.lang.String string7 = bundle.getString("pf");
        com.tencent.open.log.SLog.d("openSDK_LOG.AuthAgent", "os=" + string + ", machine=" + string2 + ", version=" + string3 + ", sdkv=" + string4 + ", appId=" + string5 + ", needPay=" + string6 + ", pf=" + string7);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (string == null) {
            string = "";
        }
        sb.append(string);
        if (string2 == null) {
            string2 = "";
        }
        sb.append(string2);
        if (string3 == null) {
            string3 = "";
        }
        sb.append(string3);
        if (string4 == null) {
            string4 = "";
        }
        sb.append(string4);
        if (string5 == null) {
            string5 = "";
        }
        sb.append(string5);
        if (string6 == null) {
            string6 = "";
        }
        sb.append(string6);
        if (string7 == null) {
            string7 = "";
        }
        sb.append(string7);
        return sb.toString();
    }

    private void a(android.os.Bundle bundle, java.util.Map map) {
    }

    private boolean a(android.app.Activity activity, android.support.v4.app.Fragment fragment, java.util.Map map, boolean z, java.lang.Object[] objArr) {
        com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- start");
        android.content.Intent intentB = b("com.tencent.open.agent.AgentActivity");
        if (intentB != null) {
            android.os.Bundle bundleA = a();
            if (z) {
                bundleA.putString("isadd", "1");
            }
            bundleA.putString(com.tencent.connect.common.Constants.PARAM_SCOPE, this.d);
            bundleA.putString(com.tencent.connect.common.Constants.PARAM_CLIENT_ID, this.c.getAppId());
            if (com.tencent.connect.common.BaseApi.isOEM) {
                bundleA.putString("pf", "desktop_m_qq-" + com.tencent.connect.common.BaseApi.installChannel + "-android-" + com.tencent.connect.common.BaseApi.registerChannel + "-" + com.tencent.connect.common.BaseApi.businessId);
            } else {
                bundleA.putString("pf", com.tencent.connect.common.Constants.DEFAULT_PF);
            }
            bundleA.putString("need_pay", "1");
            a(bundleA, map);
            bundleA.putString(com.tencent.connect.common.Constants.KEY_APP_NAME, com.tencent.open.utils.i.a(com.tencent.open.utils.f.a()));
            intentB.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_login");
            intentB.putExtra(com.tencent.connect.common.Constants.KEY_PARAMS, bundleA);
            intentB.putExtra("appid", this.c.getAppId());
            bundleA.putString(com.tencent.connect.common.Constants.KEY_PPSTS, com.tencent.open.utils.i.a(activity, a(bundleA)));
            if (a(intentB)) {
                this.f459a = new com.tencent.connect.auth.AuthAgent.b(this.f459a);
                com.tencent.connect.common.UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_LOGIN, this.f459a);
                if (fragment != null) {
                    com.tencent.open.log.SLog.d("openSDK_LOG.AuthAgent", "startAssitActivity fragment");
                    a(fragment, intentB, com.tencent.connect.common.Constants.REQUEST_LOGIN, map);
                } else {
                    com.tencent.open.log.SLog.d("openSDK_LOG.AuthAgent", "startAssitActivity activity");
                    a(activity, intentB, com.tencent.connect.common.Constants.REQUEST_LOGIN, map);
                }
                com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- end, found activity for loginIntent");
                com.tencent.open.a.d.a().a(0, "LOGIN_CHECK_SDK", "1000", this.c.getAppId(), "", java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "");
                objArr[0] = "0";
                objArr[1] = 1;
                return true;
            }
        }
        com.tencent.open.a.d.a().a(1, "LOGIN_CHECK_SDK", "1000", this.c.getAppId(), "", java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
        com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- end, no target activity for loginIntent");
        return false;
    }

    int a(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, boolean z, android.support.v4.app.Fragment fragment, boolean z2) {
        return doLogin(activity, str, iUiListener, z, fragment, z2, null);
    }

    protected void a(com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "reportDAU() -- start");
        java.lang.String accessToken = this.c.getAccessToken();
        java.lang.String openId = this.c.getOpenId();
        java.lang.String appId = this.c.getAppId();
        java.lang.String strF = "";
        if (!android.text.TextUtils.isEmpty(accessToken) && !android.text.TextUtils.isEmpty(openId) && !android.text.TextUtils.isEmpty(appId)) {
            strF = com.tencent.open.utils.l.f("[REDACTED]" + accessToken + appId + openId + "[REDACTED]");
        }
        if (android.text.TextUtils.isEmpty(strF)) {
            com.tencent.open.log.SLog.e("[REDACTED]", "[REDACTED]");
            return;
        }
        android.os.Bundle bundleA = a();
        bundleA.putString("[REDACTED]", strF);
        com.tencent.open.utils.HttpUtils.requestAsync(this.c, com.tencent.open.utils.f.a(), "https://openmobile.qq.com/user/user_login_statis", bundleA, com.tencent.connect.common.Constants.HTTP_POST, null);
        com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "reportDAU() -- end");
    }

    protected void b(com.tencent.tauth.IUiListener iUiListener) {
        android.os.Bundle bundleA = a();
        bundleA.putString("reqType", "checkLogin");
        com.tencent.open.utils.HttpUtils.requestAsync(this.c, com.tencent.open.utils.f.a(), "https://openmobile.qq.com/v3/user/get_info", bundleA, com.tencent.connect.common.Constants.HTTP_GET, new com.tencent.connect.common.BaseApi.TempRequestListener(new com.tencent.connect.auth.AuthAgent.a(iUiListener)));
    }

    public int doLogin(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, boolean z, android.support.v4.app.Fragment fragment, boolean z2, java.util.Map map) {
        this.d = str;
        this.e = new java.lang.ref.WeakReference(activity);
        this.f459a = iUiListener;
        java.lang.Object[] objArr = new java.lang.Object[2];
        if (!activity.getIntent().getBooleanExtra(KEY_FORCE_QR_LOGIN, false) && !com.tencent.open.utils.g.a(activity, this.c.getAppId()).b("C_LoginWeb") && a(activity, fragment, map, z, objArr)) {
            com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showUi, return Constants.UI_ACTIVITY");
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), "2", "1", "5", (java.lang.String) objArr[0], "0", "0");
            return ((java.lang.Integer) objArr[1]).intValue();
        }
        com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), "2", "1", "5", "1", "0", "0");
        com.tencent.open.log.SLog.w("openSDK_LOG.AuthAgent", "doLogin startActivity fail show dialog.");
        com.tencent.connect.auth.AuthAgent.b bVar = new com.tencent.connect.auth.AuthAgent.b(this.f459a);
        this.f459a = bVar;
        return a(z, bVar, z2);
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
        this.f459a = null;
    }
}
