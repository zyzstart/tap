package com.tencent.smtt.sdk.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends android.widget.ArrayAdapter implements android.view.View.OnClickListener, android.widget.ListAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.ArrayList f909a;
    private com.tencent.smtt.sdk.b.a.b b;
    private android.content.Intent c;
    private java.lang.ref.WeakReference d;
    private java.lang.ref.WeakReference e;
    private com.tencent.smtt.sdk.b.a.b f;
    private android.os.Handler g;
    private java.lang.String[] h;
    private com.tencent.smtt.sdk.b.a.a i;
    private com.tencent.smtt.sdk.ValueCallback j;
    private java.util.Map k;

    public a(android.content.Context context, android.content.Intent intent, com.tencent.smtt.sdk.b.a.b bVar, com.tencent.smtt.sdk.b.a.b bVar2, com.tencent.smtt.sdk.b.a.c cVar, android.widget.ListView listView, com.tencent.smtt.sdk.ValueCallback valueCallback) {
        super(context, 0);
        this.b = null;
        this.c = null;
        this.h = null;
        this.i = this;
        a(cVar);
        a(listView);
        this.c = intent;
        if ("com.tencent.rtxlite".equalsIgnoreCase(context.getApplicationContext().getPackageName()) || com.tencent.smtt.sdk.a.c.b(context)) {
            this.f = null;
        } else {
            this.f = bVar;
        }
        this.j = valueCallback;
        this.g = new android.os.Handler() { // from class: com.tencent.smtt.sdk.b.a.a.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what != 1) {
                    return;
                }
                com.tencent.smtt.sdk.b.a.a.this.b();
            }
        };
        java.lang.String[] strArr = new java.lang.String[2];
        this.h = strArr;
        strArr[0] = com.tencent.smtt.sdk.b.a.d.b("x5_tbs_activity_picker_recommend_to_trim");
        this.h[1] = com.tencent.smtt.sdk.b.a.d.b("x5_tbs_activity_picker_recommend_with_chinese_brace_to_trim");
        a(context, bVar2);
    }

    private int a(float f) {
        com.tencent.smtt.sdk.b.a.c cVar = (com.tencent.smtt.sdk.b.a.c) this.e.get();
        return cVar == null ? (int) f : cVar.a(f);
    }

    private android.view.View a(android.content.Context context) {
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
        linearLayout.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, new android.graphics.drawable.ColorDrawable(android.graphics.Color.argb(41, 0, 0, 0)));
        stateListDrawable.addState(new int[]{-16842919}, new android.graphics.drawable.ColorDrawable(0));
        linearLayout.setBackgroundDrawable(stateListDrawable);
        android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(context);
        relativeLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, a(64.0f)));
        android.widget.ImageView imageView = new android.widget.ImageView(context);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(a(48.0f), a(48.0f));
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        int iA = a(8.0f);
        layoutParams.setMargins(iA, iA, iA, iA);
        imageView.setLayoutParams(layoutParams);
        imageView.setId(101);
        relativeLayout.addView(imageView);
        android.widget.LinearLayout linearLayout2 = new android.widget.LinearLayout(context);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, 101);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setOrientation(1);
        android.widget.TextView textView = new android.widget.TextView(context);
        textView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
        textView.setMaxLines(1);
        textView.setTextColor(android.graphics.Color.rgb(29, 29, 29));
        textView.setTextSize(1, 17.0f);
        textView.setId(102);
        linearLayout2.addView(textView);
        android.widget.TextView textView2 = new android.widget.TextView(context);
        textView2.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
        textView2.setText(com.tencent.smtt.sdk.b.a.d.b("x5_tbs_wechat_activity_picker_label_recommend"));
        textView2.setTextColor(android.graphics.Color.rgb(com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_FAIL, com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_FAIL, com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_FAIL));
        textView2.setTextSize(1, 14.0f);
        textView2.setId(103);
        linearLayout2.addView(textView2);
        relativeLayout.addView(linearLayout2);
        android.widget.ImageView imageView2 = new android.widget.ImageView(context);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(a(24.0f), a(24.0f));
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        layoutParams3.setMargins(0, 0, a(14.0f), 0);
        imageView2.setLayoutParams(layoutParams3);
        imageView2.setImageDrawable(com.tencent.smtt.sdk.b.a.d.a("x5_tbs_activity_picker_check"));
        imageView2.setId(104);
        relativeLayout.addView(imageView2);
        android.widget.Button button = new android.widget.Button(context);
        android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(-2, a(31.0f));
        layoutParams4.addRule(11);
        layoutParams4.addRule(15);
        layoutParams4.setMargins(0, 0, a(8.0f), 0);
        button.setLayoutParams(layoutParams4);
        button.setTextColor(android.graphics.Color.rgb(50, 50, 50));
        button.setTextSize(1, 14.0f);
        android.graphics.drawable.StateListDrawable stateListDrawable2 = new android.graphics.drawable.StateListDrawable();
        float fA = a(2.0f);
        android.graphics.drawable.shapes.RoundRectShape roundRectShape = new android.graphics.drawable.shapes.RoundRectShape(new float[]{fA, fA, fA, fA, fA, fA, fA, fA}, null, null);
        android.graphics.drawable.ShapeDrawable shapeDrawable = new android.graphics.drawable.ShapeDrawable(roundRectShape);
        shapeDrawable.getPaint().setColor(android.graphics.Color.argb(128, 69, 192, 26));
        stateListDrawable2.addState(new int[]{-16842910}, shapeDrawable);
        android.graphics.drawable.ShapeDrawable shapeDrawable2 = new android.graphics.drawable.ShapeDrawable(roundRectShape);
        shapeDrawable2.getPaint().setColor(android.graphics.Color.rgb(41, 132, 9));
        stateListDrawable2.addState(new int[]{android.R.attr.state_pressed}, shapeDrawable2);
        android.graphics.drawable.ShapeDrawable shapeDrawable3 = new android.graphics.drawable.ShapeDrawable(roundRectShape);
        shapeDrawable3.getPaint().setColor(android.graphics.Color.rgb(69, 192, 26));
        stateListDrawable2.addState(new int[]{-16842919}, shapeDrawable3);
        button.setBackgroundDrawable(stateListDrawable2);
        button.setId(107);
        button.setPadding(a(8.0f), 0, a(8.0f), 0);
        relativeLayout.addView(button);
        relativeLayout.setId(105);
        linearLayout.addView(relativeLayout);
        return linearLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v17 */
    private void a(com.tencent.smtt.sdk.b.a.b bVar, android.view.View view) {
        ?? r3;
        if (view == null || bVar == null) {
            return;
        }
        android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(101);
        android.widget.TextView textView = (android.widget.TextView) view.findViewById(102);
        android.widget.TextView textView2 = (android.widget.TextView) view.findViewById(103);
        android.widget.ImageView imageView2 = (android.widget.ImageView) view.findViewById(104);
        android.view.View viewFindViewById = view.findViewById(105);
        android.view.View viewFindViewById2 = view.findViewById(106);
        android.widget.Button button = (android.widget.Button) view.findViewById(107);
        android.widget.ProgressBar progressBar = (android.widget.ProgressBar) view.findViewById(108);
        imageView.setImageDrawable(bVar.a(this.k));
        java.lang.String strReplaceAll = bVar.a().trim().replaceAll(" ", "");
        java.lang.String strReplaceAll2 = strReplaceAll;
        for (java.lang.String str : this.h) {
            if (str != null && str.length() > 0) {
                strReplaceAll2 = strReplaceAll2.replaceAll(str, "");
            }
        }
        textView.setText(strReplaceAll2);
        if (bVar.b() == null) {
            for (android.content.pm.ResolveInfo resolveInfo : getContext().getPackageManager().queryIntentActivities(this.c, 65536)) {
                if (bVar.c().equals(resolveInfo.activityInfo.packageName)) {
                    bVar.a(resolveInfo);
                    break;
                }
            }
        }
        viewFindViewById.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.smtt.sdk.b.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view2) {
                java.lang.Object parent = view2.getParent();
                if (parent == null || !(parent instanceof android.view.View)) {
                    return;
                }
                android.view.View view3 = (android.view.View) parent;
                if (view3.getTag() == com.tencent.smtt.sdk.b.a.a.this.f) {
                    com.tencent.smtt.sdk.b.a.a.this.onClick(view3);
                }
            }
        });
        if (com.tencent.smtt.sdk.TbsConfig.APP_QB.equals(bVar.c())) {
            r3 = 0;
            textView2.setVisibility(0);
        } else {
            r3 = 0;
            textView2.setVisibility(8);
        }
        if (bVar.b() != null) {
            viewFindViewById.setClickable(r3);
            viewFindViewById.setEnabled(r3);
            if (bVar == this.b) {
                imageView2.setVisibility(r3);
                if (viewFindViewById2 != 0) {
                    viewFindViewById2.setVisibility(r3);
                }
            } else {
                imageView2.setVisibility(8);
                if (viewFindViewById2 != 0) {
                    viewFindViewById2.setVisibility(8);
                }
            }
            button.setVisibility(8);
            button.setOnClickListener(null);
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        } else {
            viewFindViewById.setClickable(true);
            viewFindViewById.setEnabled(true);
            imageView2.setVisibility(8);
            if (viewFindViewById2 != 0) {
                viewFindViewById2.setVisibility(8);
            }
            button.setVisibility(0);
            button.setText(com.tencent.smtt.sdk.b.a.d.b("x5_tbs_wechat_activity_picker_label_download"));
            button.setEnabled(true);
            button.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.smtt.sdk.b.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view2) {
                    if ("com.tencent.mobileqq".equals(com.tencent.smtt.sdk.b.a.a.this.getContext().getApplicationContext().getPackageName())) {
                        if (com.tencent.smtt.sdk.b.a.a.this.j != null) {
                            com.tencent.smtt.sdk.b.a.a.this.j.onReceiveValue("http://mdc.html5.qq.com/d/directdown.jsp?[REDACTED]");
                        }
                        ((com.tencent.smtt.sdk.b.a.c) com.tencent.smtt.sdk.b.a.a.this.e.get()).dismiss();
                    } else {
                        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse("http://mdc.html5.qq.com/d/directdown.jsp?[REDACTED]"));
                        intent.addFlags(268435456);
                        com.tencent.smtt.sdk.b.a.a.this.getContext().startActivity(intent);
                    }
                }
            });
        }
        view.setTag(bVar);
        view.setOnClickListener(this);
    }

    private void a(boolean z) {
        com.tencent.smtt.sdk.b.a.c cVar;
        java.lang.ref.WeakReference weakReference = this.e;
        if (weakReference == null || (cVar = (com.tencent.smtt.sdk.b.a.c) weakReference.get()) == null) {
            return;
        }
        cVar.a(z);
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        if (str != null && !"".equals(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    private void b(android.content.Context context, com.tencent.smtt.sdk.b.a.b bVar) {
        this.b = bVar;
        a(bVar != null && a(context, bVar.c()));
    }

    public com.tencent.smtt.sdk.b.a.b a() {
        return this.b;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.smtt.sdk.b.a.b getItem(int i) {
        if (i < 0 || i >= this.f909a.size()) {
            return null;
        }
        return (com.tencent.smtt.sdk.b.a.b) this.f909a.get(i);
    }

    void a(android.content.Context context, com.tencent.smtt.sdk.b.a.b bVar) {
        com.tencent.smtt.sdk.b.a.b bVar2;
        this.f909a = new java.util.ArrayList();
        boolean z = false;
        boolean z2 = false;
        for (android.content.pm.ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(this.c, 65536)) {
            if (com.tencent.smtt.sdk.b.a.b.a(context, resolveInfo.activityInfo.packageName) != null || resolveInfo.loadIcon(context.getPackageManager()) != null) {
                com.tencent.smtt.sdk.b.a.b bVar3 = new com.tencent.smtt.sdk.b.a.b(context, resolveInfo);
                com.tencent.smtt.sdk.b.a.b bVar4 = this.f;
                if (bVar4 != null && bVar4.c().equals(resolveInfo.activityInfo.packageName)) {
                    this.f909a.add(0, bVar3);
                    z = true;
                } else if (com.tencent.smtt.sdk.TbsConfig.APP_QB.equals(resolveInfo.activityInfo.packageName)) {
                    this.f909a.add(0, bVar3);
                } else {
                    this.f909a.add(bVar3);
                }
                if (!z2 && bVar != null && bVar3.c().equals(bVar.c())) {
                    b(context, bVar3);
                    z2 = true;
                }
            }
        }
        if (!z && (bVar2 = this.f) != null) {
            this.f909a.add(0, bVar2);
        }
        if (z2 || this.f909a.size() <= 0) {
            return;
        }
        b(context, (com.tencent.smtt.sdk.b.a.b) this.f909a.get(0));
    }

    void a(android.widget.ListView listView) {
        this.d = new java.lang.ref.WeakReference(listView);
    }

    void a(com.tencent.smtt.sdk.b.a.c cVar) {
        this.e = new java.lang.ref.WeakReference(cVar);
    }

    void b() {
        android.view.View viewFindViewWithTag;
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            this.g.obtainMessage(1).sendToTarget();
            return;
        }
        android.widget.ListView listView = (android.widget.ListView) this.d.get();
        if (listView == null || (viewFindViewWithTag = listView.findViewWithTag(this.f)) == null) {
            return;
        }
        a(this.f, viewFindViewWithTag);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f909a.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        com.tencent.smtt.sdk.b.a.b item = getItem(i);
        if (item == null) {
            return null;
        }
        if (view == null) {
            view = a(getContext());
        }
        a(item, view);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        com.tencent.smtt.sdk.b.a.b bVar;
        java.lang.Object tag = view.getTag();
        if (tag == null || !(tag instanceof com.tencent.smtt.sdk.b.a.b) || (bVar = (com.tencent.smtt.sdk.b.a.b) tag) == this.b) {
            return;
        }
        java.lang.Object parent = view.getParent();
        android.view.View view2 = parent instanceof android.view.View ? (android.view.View) parent : null;
        com.tencent.smtt.sdk.b.a.b bVar2 = this.b;
        b(view.getContext(), bVar);
        a(bVar2, view2.findViewWithTag(bVar2));
        a(this.b, view);
    }
}
