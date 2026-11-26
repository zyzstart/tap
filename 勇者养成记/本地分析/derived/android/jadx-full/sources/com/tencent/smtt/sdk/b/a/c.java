package com.tencent.smtt.sdk.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c extends android.app.Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static java.lang.ref.WeakReference f914a = null;
    private static float l = -1.0f;
    private android.widget.ListView b;
    private android.widget.TextView c;
    private android.widget.Button d;
    private android.widget.Button e;
    private java.lang.String f;
    private com.tencent.smtt.sdk.b.a.a g;
    private java.lang.String h;
    private java.lang.String i;
    private android.content.Intent j;
    private android.content.SharedPreferences k;

    public c(android.content.Context context, java.lang.String str, android.content.Intent intent, com.tencent.smtt.sdk.ValueCallback valueCallback, java.lang.String str2, java.lang.String str3) {
        super(context, android.R.style.Theme.Dialog);
        this.h = "*/*";
        this.k = null;
        this.i = str3;
        java.util.List<android.content.pm.ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        if ((listQueryIntentActivities == null || listQueryIntentActivities.size() == 0) && com.tencent.smtt.sdk.a.c.b(context)) {
            com.tencent.smtt.sdk.QbSdk.isDefaultDialog = true;
        }
        if ("com.tencent.rtxlite".equalsIgnoreCase(context.getApplicationContext().getPackageName()) && (listQueryIntentActivities == null || (listQueryIntentActivities != null && listQueryIntentActivities.size() == 0))) {
            com.tencent.smtt.sdk.QbSdk.isDefaultDialog = true;
        }
        b(context.getApplicationContext());
        this.f = str;
        this.j = intent;
        f914a = new java.lang.ref.WeakReference(valueCallback);
        this.k = context.getSharedPreferences("tbs_file_open_dialog_config", 0);
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        this.h = str2;
    }

    private android.view.View a(android.content.Context context) {
        getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
        android.view.WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = 0.5f;
        getWindow().setAttributes(attributes);
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(context);
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(a(280.0f), -1);
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setOrientation(1);
        this.c = new android.widget.TextView(context);
        android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, a(65.0f));
        layoutParams2.weight = 0.0f;
        this.c.setGravity(16);
        this.c.setLayoutParams(layoutParams2);
        this.c.setPadding(a(18.0f), 0, 0, 0);
        this.c.setTextColor(android.graphics.Color.rgb(69, 192, 26));
        this.c.setTextSize(1, 18.0f);
        this.c.setText(this.f);
        linearLayout.addView(this.c);
        android.widget.ImageView imageView = new android.widget.ImageView(context);
        android.widget.LinearLayout.LayoutParams layoutParams3 = new android.widget.LinearLayout.LayoutParams(-1, 1);
        layoutParams3.weight = 0.0f;
        imageView.setLayoutParams(layoutParams3);
        imageView.setBackgroundColor(android.graphics.Color.argb(61, 0, 0, 0));
        linearLayout.addView(imageView);
        this.b = new android.widget.ListView(context);
        android.widget.LinearLayout.LayoutParams layoutParams4 = new android.widget.LinearLayout.LayoutParams(-1, -1);
        layoutParams4.weight = 1.0f;
        layoutParams4.gravity = 16;
        this.b.setLayoutParams(layoutParams4);
        this.b.setDivider(new android.graphics.drawable.ColorDrawable(android.graphics.Color.argb(41, 0, 0, 0)));
        this.b.setDividerHeight(1);
        linearLayout.addView(this.b);
        android.widget.ImageView imageView2 = new android.widget.ImageView(context);
        android.widget.LinearLayout.LayoutParams layoutParams5 = new android.widget.LinearLayout.LayoutParams(-1, 1);
        layoutParams5.weight = 0.0f;
        imageView2.setLayoutParams(layoutParams5);
        imageView2.setBackgroundColor(android.graphics.Color.argb(61, 0, 0, 0));
        linearLayout.addView(imageView2);
        android.widget.LinearLayout linearLayout2 = new android.widget.LinearLayout(context);
        android.widget.LinearLayout.LayoutParams layoutParams6 = new android.widget.LinearLayout.LayoutParams(-1, -2);
        layoutParams6.weight = 0.0f;
        linearLayout2.setLayoutParams(layoutParams6);
        linearLayout2.setOrientation(0);
        linearLayout2.setContentDescription("x5_tbs_activity_picker_btn_container");
        this.d = new android.widget.Button(context);
        android.widget.LinearLayout.LayoutParams layoutParams7 = new android.widget.LinearLayout.LayoutParams(-1, a(49.0f));
        layoutParams7.weight = 1.0f;
        this.d.setLayoutParams(layoutParams7);
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, new android.graphics.drawable.ColorDrawable(android.graphics.Color.argb(41, 0, 0, 0)));
        stateListDrawable.addState(new int[]{-16842919}, new android.graphics.drawable.ColorDrawable(0));
        this.d.setBackgroundDrawable(stateListDrawable);
        this.d.setText(com.tencent.smtt.sdk.b.a.d.b("x5_tbs_wechat_activity_picker_label_always"));
        this.d.setTextColor(android.graphics.Color.rgb(29, 29, 29));
        this.d.setTextSize(1, 17.0f);
        linearLayout2.addView(this.d);
        android.widget.ImageView imageView3 = new android.widget.ImageView(context);
        android.widget.LinearLayout.LayoutParams layoutParams8 = new android.widget.LinearLayout.LayoutParams(1, -1);
        layoutParams8.weight = 0.0f;
        imageView3.setLayoutParams(layoutParams8);
        imageView3.setBackgroundColor(android.graphics.Color.rgb(com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_FAIL, com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_FAIL, com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_FAIL));
        linearLayout2.addView(imageView3);
        this.e = new android.widget.Button(context);
        android.widget.LinearLayout.LayoutParams layoutParams9 = new android.widget.LinearLayout.LayoutParams(-1, a(49.0f));
        layoutParams9.weight = 1.0f;
        this.e.setLayoutParams(layoutParams9);
        android.graphics.drawable.StateListDrawable stateListDrawable2 = new android.graphics.drawable.StateListDrawable();
        stateListDrawable2.addState(new int[]{android.R.attr.state_pressed}, new android.graphics.drawable.ColorDrawable(android.graphics.Color.argb(41, 0, 0, 0)));
        stateListDrawable2.addState(new int[]{-16842919}, new android.graphics.drawable.ColorDrawable(0));
        this.e.setBackgroundDrawable(stateListDrawable2);
        this.e.setText(com.tencent.smtt.sdk.b.a.d.b("x5_tbs_wechat_activity_picker_label_once"));
        this.e.setTextColor(android.graphics.Color.rgb(29, 29, 29));
        this.e.setTextSize(1, 17.0f);
        linearLayout2.addView(this.e);
        linearLayout.addView(linearLayout2);
        frameLayout.addView(linearLayout);
        return frameLayout;
    }

    private void b(android.content.Context context) {
        if (l < 0.0f) {
            android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            l = displayMetrics.density;
        }
    }

    private void c() {
        com.tencent.smtt.sdk.b.a.a aVar = this.g;
        com.tencent.smtt.sdk.b.a.a aVar2 = new com.tencent.smtt.sdk.b.a.a(getContext(), this.j, new com.tencent.smtt.sdk.b.a.b(getContext(), com.tencent.smtt.sdk.b.a.d.a("application_icon"), "QQ浏览器", com.tencent.smtt.sdk.TbsConfig.APP_QB), aVar != null ? aVar.a() : null, this, this.b, (com.tencent.smtt.sdk.ValueCallback) f914a.get());
        this.g = aVar2;
        this.b.setAdapter((android.widget.ListAdapter) aVar2);
    }

    public int a(float f) {
        return (int) ((f * l) + 0.5f);
    }

    public java.lang.String a() {
        android.content.SharedPreferences sharedPreferences = this.k;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("key_tbs_picked_default_browser_" + this.h, null);
    }

    public void a(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.k;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("key_tbs_picked_default_browser_" + this.h, str).commit();
        }
    }

    void a(boolean z) {
        android.widget.Button button = this.e;
        if (button != null) {
            button.setEnabled(z);
        }
        android.widget.Button button2 = this.d;
        if (button2 != null) {
            button2.setEnabled(z);
        }
    }

    public void b() {
        setContentView(a(getContext()));
        c();
        this.d.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.smtt.sdk.b.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.tencent.smtt.sdk.b.a.b bVarA = com.tencent.smtt.sdk.b.a.c.this.g.a();
                if (bVarA == null || bVarA.b() == null) {
                    return;
                }
                android.content.Intent intent = com.tencent.smtt.sdk.b.a.c.this.j;
                android.content.Context context = com.tencent.smtt.sdk.b.a.c.this.getContext();
                java.lang.String str = bVarA.b().activityInfo.packageName;
                intent.setPackage(str);
                if (com.tencent.smtt.sdk.TbsConfig.APP_QB.equals(str)) {
                    intent.putExtra(com.tencent.smtt.sdk.QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getPackageName());
                    intent.putExtra(com.tencent.smtt.sdk.QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, "4");
                }
                if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && android.os.Build.VERSION.SDK_INT >= 24) {
                    intent.addFlags(1);
                }
                if (!android.text.TextUtils.isEmpty(com.tencent.smtt.sdk.b.a.c.this.i)) {
                    intent.putExtra("big_brother_source_key", com.tencent.smtt.sdk.b.a.c.this.i);
                }
                context.startActivity(intent);
                if (com.tencent.smtt.sdk.b.a.c.f914a.get() != null) {
                    ((com.tencent.smtt.sdk.ValueCallback) com.tencent.smtt.sdk.b.a.c.f914a.get()).onReceiveValue("always");
                }
                com.tencent.smtt.sdk.b.a.c.this.a(str);
                com.tencent.smtt.sdk.b.a.c.this.dismiss();
            }
        });
        this.e.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.smtt.sdk.b.a.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.tencent.smtt.sdk.b.a.b bVarA = com.tencent.smtt.sdk.b.a.c.this.g.a();
                if (bVarA == null || bVarA.b() == null) {
                    return;
                }
                android.content.Intent intent = com.tencent.smtt.sdk.b.a.c.this.j;
                android.content.Context context = com.tencent.smtt.sdk.b.a.c.this.getContext();
                java.lang.String str = bVarA.b().activityInfo.packageName;
                intent.setPackage(str);
                if (com.tencent.smtt.sdk.TbsConfig.APP_QB.equals(str)) {
                    intent.putExtra(com.tencent.smtt.sdk.QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getPackageName());
                    intent.putExtra(com.tencent.smtt.sdk.QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, "4");
                }
                if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && android.os.Build.VERSION.SDK_INT >= 24) {
                    intent.addFlags(1);
                }
                if (!android.text.TextUtils.isEmpty(com.tencent.smtt.sdk.b.a.c.this.i)) {
                    intent.putExtra("big_brother_source_key", com.tencent.smtt.sdk.b.a.c.this.i);
                }
                context.startActivity(intent);
                if (com.tencent.smtt.sdk.b.a.c.f914a.get() != null) {
                    ((com.tencent.smtt.sdk.ValueCallback) com.tencent.smtt.sdk.b.a.c.f914a.get()).onReceiveValue("once");
                }
                com.tencent.smtt.sdk.b.a.c.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        b();
    }
}
