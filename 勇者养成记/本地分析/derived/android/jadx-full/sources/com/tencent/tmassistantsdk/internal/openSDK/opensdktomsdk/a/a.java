package com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends android.app.Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected android.content.Context f1086a;
    protected int b;
    protected android.widget.TextView c;
    protected android.widget.RelativeLayout d;
    protected android.widget.TextView e;
    protected android.widget.Button f;
    protected android.widget.FrameLayout g;
    public android.widget.ProgressBar h;
    public android.widget.TextView i;
    public com.tencent.tmassistantbase.util.r j;
    protected android.widget.Button k;

    public a(android.content.Context context, int i, int i2) {
        super(context, i);
        this.f1086a = null;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.f1086a = context;
        this.b = i2;
    }

    private int b(int i) {
        int iB = b();
        int iA = a();
        com.tencent.tmassistantbase.util.TMLog.i("PopDialog", " width = " + iA + "  height = " + iB);
        if (iB <= iA) {
            iB = iA;
        }
        int i2 = (int) ((i * (iB + 0.0f)) / 1280.0f);
        com.tencent.tmassistantbase.util.TMLog.i("PopDialog", "rtn" + i + ":" + i2);
        return i2;
    }

    private void c() {
        d();
        int i = this.b;
        if (i == 1) {
            e();
        } else {
            if (i != 2) {
                return;
            }
            f();
        }
    }

    private void d() {
        this.c.setPadding(b(30), 0, b(30), 0);
        this.d.setPadding(b(30), 0, b(30), b(30));
        this.e.setPadding(0, b(30), 0, b(30));
    }

    private void e() {
        this.g.setVisibility(8);
        this.k.setHeight(b(78));
        this.k.setText(this.f1086a.getString(this.j.a("white_list_submit")));
    }

    private void f() {
        this.k.setHeight(b(78));
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) this.k.getLayoutParams();
        marginLayoutParams.setMargins(0, 0, b(30), 0);
        this.k.setLayoutParams(marginLayoutParams);
        this.f.setHeight(b(78));
        this.f.setTextSize(b(30));
        this.h.setMinimumHeight(b(78));
        this.i.setHeight(b(78));
    }

    public int a() {
        android.content.Context context = this.f1086a;
        if (context != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        return 0;
    }

    public void a(int i) {
        if (i != 0) {
            this.f.setBackgroundResource(i);
        }
    }

    public void a(android.view.View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f.setOnClickListener(onClickListener);
        }
    }

    public void a(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.a aVar) {
        if (aVar != null) {
            this.f.setTag(aVar);
        }
    }

    public void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.c.setText(str);
    }

    public void a(boolean z) {
        android.widget.Button button = this.f;
        if (button != null) {
            button.setEnabled(z);
        }
    }

    public int b() {
        android.content.Context context = this.f1086a;
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        return 0;
    }

    public void b(android.view.View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.k.setOnClickListener(onClickListener);
        }
    }

    public void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.e.setText(str);
    }

    public void c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.i.setText(str);
    }

    public void d(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.k.setText(str);
    }

    @Override // android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.tmassistantbase.util.r rVar = new com.tencent.tmassistantbase.util.r(this.f1086a);
        this.j = rVar;
        super.setContentView(rVar.c("com_tencent_tmassistant_sdk_white_list_dlg"));
        super.getWindow().setLayout(b(662), b(662));
        setCancelable(false);
        this.c = (android.widget.TextView) findViewById(this.j.d("dlg_title_tv"));
        this.d = (android.widget.RelativeLayout) findViewById(this.j.d("content"));
        this.e = (android.widget.TextView) findViewById(this.j.d("dlg_body_tv"));
        this.f = (android.widget.Button) findViewById(this.j.d("positive_btn"));
        this.g = (android.widget.FrameLayout) findViewById(this.j.d("positive_btn_frame_layout"));
        this.h = (android.widget.ProgressBar) findViewById(this.j.d("download_pb"));
        this.i = (android.widget.TextView) findViewById(this.j.d("progress_txt_tv"));
        this.k = (android.widget.Button) findViewById(this.j.d("negtive_btn"));
        c();
    }
}
