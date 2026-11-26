package com.tencent.qqdownloader.pay.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends android.app.Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.widget.Button f764a;
    private android.widget.TextView b;
    private android.widget.TextView c;
    private android.widget.ImageView d;
    private android.content.Context e;
    private com.tencent.qqdownloader.pay.d.a.InterfaceC0034a f;

    /* JADX INFO: renamed from: com.tencent.qqdownloader.pay.d.a$a, reason: collision with other inner class name */
    public interface InterfaceC0034a {
        void a();

        void b();
    }

    public a(android.content.Context context) {
        super(context);
        setCanceledOnTouchOutside(false);
        this.e = context;
    }

    public void a() {
        getWindow().requestFeature(1);
        android.view.View viewInflate = android.view.LayoutInflater.from(this.e).inflate(com.tencent.qqdownloader.pay.utils.h.a(this.e, "layout", "com_tencent_ysdk_auth_result_dialog"), (android.view.ViewGroup) null);
        setContentView(viewInflate);
        android.view.Window window = getWindow();
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        double d = this.e.getResources().getDisplayMetrics().widthPixels;
        java.lang.Double.isNaN(d);
        attributes.width = (int) (d * 0.8d);
        attributes.gravity = 17;
        window.setAttributes(attributes);
        this.b = (android.widget.TextView) viewInflate.findViewById(com.tencent.qqdownloader.pay.utils.h.a(this.e, "id", "title"));
        this.c = (android.widget.TextView) viewInflate.findViewById(com.tencent.qqdownloader.pay.utils.h.a(this.e, "id", "msg"));
        this.f764a = (android.widget.Button) viewInflate.findViewById(com.tencent.qqdownloader.pay.utils.h.a(this.e, "id", "comfirm_button"));
        this.d = (android.widget.ImageView) viewInflate.findViewById(com.tencent.qqdownloader.pay.utils.h.a(this.e, "id", com.unisound.common.y.G));
        this.f764a.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.qqdownloader.pay.d.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.tencent.qqdownloader.pay.d.a.this.dismiss();
                if (com.tencent.qqdownloader.pay.d.a.this.f != null) {
                    com.tencent.qqdownloader.pay.d.a.this.f.a();
                }
            }
        });
        this.d.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.qqdownloader.pay.d.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.tencent.qqdownloader.pay.d.a.this.dismiss();
                if (com.tencent.qqdownloader.pay.d.a.this.f != null) {
                    com.tencent.qqdownloader.pay.d.a.this.f.b();
                }
            }
        });
    }

    public void a(com.tencent.qqdownloader.pay.d.a.InterfaceC0034a interfaceC0034a) {
        this.f = interfaceC0034a;
    }

    public void a(java.lang.String str) {
        this.b.setText(str);
    }

    public void b(java.lang.String str) {
        android.widget.TextView textView;
        int i;
        if (android.text.TextUtils.isEmpty(str)) {
            textView = this.c;
            i = 8;
        } else {
            this.c.setText(str);
            textView = this.c;
            i = 0;
        }
        textView.setVisibility(i);
    }

    public void c(java.lang.String str) {
        android.widget.Button button;
        int i;
        if (android.text.TextUtils.isEmpty(str)) {
            button = this.f764a;
            i = 8;
        } else {
            this.f764a.setText(str);
            button = this.f764a;
            i = 0;
        }
        button.setVisibility(i);
    }

    @Override // android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        a();
    }
}
