package com.tencent.open.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends android.widget.RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.String f700a = "com.tencent.open.b.a";
    private android.graphics.Rect b;
    private boolean c;
    private com.tencent.open.b.a.InterfaceC0029a d;

    /* JADX INFO: renamed from: com.tencent.open.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0029a {
        void a();

        void a(int i);
    }

    public a(android.content.Context context) {
        super(context);
        this.b = null;
        this.c = false;
        this.d = null;
        this.b = new android.graphics.Rect();
    }

    public void a(com.tencent.open.b.a.InterfaceC0029a interfaceC0029a) {
        this.d = interfaceC0029a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = android.view.View.MeasureSpec.getSize(i2);
        android.app.Activity activity = (android.app.Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.b.top) - size;
        com.tencent.open.b.a.InterfaceC0029a interfaceC0029a = this.d;
        if (interfaceC0029a != null && size != 0) {
            if (height > 100) {
                interfaceC0029a.a((java.lang.Math.abs(this.b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0029a.a();
            }
        }
        super.onMeasure(i, i2);
    }
}
