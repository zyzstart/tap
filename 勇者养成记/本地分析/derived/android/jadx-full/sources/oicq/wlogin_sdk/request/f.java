package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class f implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ oicq.wlogin_sdk.request.e f1680a;

    f(oicq.wlogin_sdk.request.e eVar) {
        this.f1680a = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.widget.Toast toast, int i) {
        if (i > 5) {
            return;
        }
        toast.show();
        b(toast, i);
    }

    private void b(android.widget.Toast toast, int i) {
        new java.util.Timer().schedule(new oicq.wlogin_sdk.request.g(this, toast, i), 30L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1680a.b == null || this.f1680a.c == null) {
            return;
        }
        try {
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(this.f1680a.b);
            linearLayout.setOrientation(1);
            linearLayout.setBackgroundColor(-7829368);
            linearLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
            android.widget.TextView textView = new android.widget.TextView(this.f1680a.b);
            textView.getPaint().setFakeBoldText(true);
            textView.setText(this.f1680a.c.getTitle());
            linearLayout.addView(textView, 0, new android.widget.LinearLayout.LayoutParams(-1, -2));
            android.widget.TextView textView2 = new android.widget.TextView(this.f1680a.b);
            textView2.setText(this.f1680a.c.getMessage());
            linearLayout.addView(textView2, 1, new android.widget.LinearLayout.LayoutParams(-1, -2));
            android.widget.Toast toast = new android.widget.Toast(this.f1680a.b);
            toast.setGravity(17, 0, 0);
            toast.setDuration(1);
            toast.setView(linearLayout);
            a(toast, 0);
        } catch (java.lang.Exception e) {
            oicq.wlogin_sdk.tools.util.printException(e);
        }
    }
}
