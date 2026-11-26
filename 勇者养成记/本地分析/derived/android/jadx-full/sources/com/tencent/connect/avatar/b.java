package com.tencent.connect.avatar;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b extends android.view.View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.graphics.Rect f496a;
    private android.graphics.Paint b;

    public b(android.content.Context context) {
        super(context);
        b();
    }

    private void b() {
        this.b = new android.graphics.Paint();
    }

    public android.graphics.Rect a() {
        if (this.f496a == null) {
            this.f496a = new android.graphics.Rect();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int iMin = java.lang.Math.min(java.lang.Math.min((measuredHeight - 60) - 80, measuredWidth), 640);
            int i = (measuredWidth - iMin) / 2;
            int i2 = (measuredHeight - iMin) / 2;
            this.f496a.set(i, i2, i + iMin, iMin + i2);
        }
        return this.f496a;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        android.graphics.Rect rectA = a();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.b.setStyle(android.graphics.Paint.Style.FILL);
        this.b.setColor(android.graphics.Color.argb(100, 0, 0, 0));
        float f = measuredWidth;
        canvas.drawRect(0.0f, 0.0f, f, rectA.top, this.b);
        canvas.drawRect(0.0f, rectA.bottom, f, measuredHeight, this.b);
        canvas.drawRect(0.0f, rectA.top, rectA.left, rectA.bottom, this.b);
        canvas.drawRect(rectA.right, rectA.top, f, rectA.bottom, this.b);
        canvas.drawColor(android.graphics.Color.argb(100, 0, 0, 0));
        this.b.setStyle(android.graphics.Paint.Style.STROKE);
        this.b.setColor(-1);
        canvas.drawRect(rectA.left, rectA.top, rectA.right - 1, rectA.bottom, this.b);
    }
}
