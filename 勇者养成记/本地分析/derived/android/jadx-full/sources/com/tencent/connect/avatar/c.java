package com.tencent.connect.avatar;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c extends android.widget.ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final java.lang.String f497a;
    public boolean b;
    private android.graphics.Matrix c;
    private android.graphics.Matrix d;
    private int e;
    private float f;
    private float g;
    private android.graphics.Bitmap h;
    private boolean i;
    private float j;
    private float k;
    private android.graphics.PointF l;
    private android.graphics.PointF m;
    private float n;
    private float o;
    private android.graphics.Rect p;

    public c(android.content.Context context) {
        super(context);
        this.c = new android.graphics.Matrix();
        this.d = new android.graphics.Matrix();
        this.e = 0;
        this.f = 1.0f;
        this.g = 1.0f;
        this.i = false;
        this.f497a = "TouchView";
        this.l = new android.graphics.PointF();
        this.m = new android.graphics.PointF();
        this.n = 1.0f;
        this.o = 0.0f;
        this.b = false;
        android.graphics.Rect rect = new android.graphics.Rect();
        this.p = rect;
        getDrawingRect(rect);
        a();
    }

    private float a(android.view.MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) java.lang.Math.sqrt((x * x) + (y * y));
    }

    private void a() {
    }

    private void a(android.graphics.PointF pointF) {
        if (this.h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float width = this.h.getWidth() * f3;
        float height = this.h.getHeight() * f3;
        float f4 = this.p.left - f;
        if (f4 <= 1.0f) {
            f4 = 1.0f;
        }
        float f5 = (f + width) - this.p.right;
        if (f5 <= 1.0f) {
            f5 = 1.0f;
        }
        float fWidth = (this.p.width() * f4) / (f5 + f4);
        android.graphics.Rect rect = this.p;
        float f6 = fWidth + rect.left;
        float f7 = rect.top - f2;
        float f8 = (f2 + height) - rect.bottom;
        if (f7 <= 1.0f) {
            f7 = 1.0f;
        }
        if (f8 <= 1.0f) {
            f8 = 1.0f;
        }
        pointF.set(f6, ((this.p.height() * f7) / (f8 + f7)) + this.p.top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        boolean z;
        android.view.animation.Animation scaleAnimation;
        if (this.h == null) {
            return;
        }
        float fWidth = this.p.width();
        float fHeight = this.p.height();
        float[] fArr = new float[9];
        this.c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        android.view.animation.TranslateAnimation translateAnimation = null;
        float f4 = this.f;
        if (f3 > f4) {
            float f5 = f4 / f3;
            this.o = f5;
            android.graphics.Matrix matrix = this.c;
            android.graphics.PointF pointF = this.m;
            matrix.postScale(f5, f5, pointF.x, pointF.y);
            setImageMatrix(this.c);
            float f6 = 1.0f / this.o;
            android.graphics.PointF pointF2 = this.m;
            scaleAnimation = new android.view.animation.ScaleAnimation(f6, 1.0f, f6, 1.0f, pointF2.x, pointF2.y);
        } else {
            float f7 = this.g;
            if (f3 < f7) {
                float f8 = f7 / f3;
                this.o = f8;
                android.graphics.Matrix matrix2 = this.c;
                android.graphics.PointF pointF3 = this.m;
                matrix2.postScale(f8, f8, pointF3.x, pointF3.y);
                float f9 = this.o;
                android.graphics.PointF pointF4 = this.m;
                scaleAnimation = new android.view.animation.ScaleAnimation(1.0f, f9, 1.0f, f9, pointF4.x, pointF4.y);
            } else {
                float width = this.h.getWidth() * f3;
                float height = this.h.getHeight() * f3;
                android.graphics.Rect rect = this.p;
                float f10 = rect.left;
                float f11 = f10 - f;
                float f12 = rect.top - f2;
                if (f11 < 0.0f) {
                    f = f10;
                    z = true;
                } else {
                    z = false;
                }
                if (f12 < 0.0f) {
                    f2 = this.p.top;
                    z = true;
                }
                float f13 = height - f12;
                if (width - f11 < fWidth) {
                    f = this.p.left - (width - fWidth);
                    z = true;
                }
                if (f13 < fHeight) {
                    f2 = this.p.top - (height - fHeight);
                    z = true;
                }
                if (z) {
                    float f14 = fArr[2] - f;
                    float f15 = fArr[5] - f2;
                    fArr[2] = f;
                    fArr[5] = f2;
                    this.c.setValues(fArr);
                    setImageMatrix(this.c);
                    translateAnimation = new android.view.animation.TranslateAnimation(f14, 0.0f, f15, 0.0f);
                } else {
                    setImageMatrix(this.c);
                }
                scaleAnimation = translateAnimation;
            }
        }
        if (scaleAnimation != null) {
            this.i = true;
            scaleAnimation.setDuration(300L);
            startAnimation(scaleAnimation);
            new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.connect.avatar.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        java.lang.Thread.sleep(300L);
                    } catch (java.lang.InterruptedException e) {
                        e.printStackTrace();
                    }
                    com.tencent.connect.avatar.c.this.post(new java.lang.Runnable() { // from class: com.tencent.connect.avatar.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.connect.avatar.c.this.clearAnimation();
                            com.tencent.connect.avatar.c.this.b();
                        }
                    });
                    com.tencent.connect.avatar.c.this.i = false;
                }
            }).start();
        }
    }

    private void c() {
        if (this.h == null) {
            return;
        }
        float[] fArr = {fMax, 0.0f, this.j, 0.0f, fMax, height, 0.0f, 0.0f, 0.0f};
        this.c.getValues(fArr);
        float fMax = java.lang.Math.max(this.p.width() / this.h.getWidth(), this.p.height() / this.h.getHeight());
        this.j = this.p.left - (((this.h.getWidth() * fMax) - this.p.width()) / 2.0f);
        float height = this.p.top - (((this.h.getHeight() * fMax) - this.p.height()) / 2.0f);
        this.k = height;
        this.c.setValues(fArr);
        float fMin = java.lang.Math.min(2048.0f / this.h.getWidth(), 2048.0f / this.h.getHeight());
        this.f = fMin;
        this.g = fMax;
        if (fMin < fMax) {
            this.f = fMax;
        }
        setImageMatrix(this.c);
    }

    public void a(android.graphics.Rect rect) {
        this.p = rect;
        if (this.h != null) {
            c();
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0083  */
    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.i) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.c.set(getImageMatrix());
            this.d.set(this.c);
            this.l.set(motionEvent.getX(), motionEvent.getY());
            this.e = 1;
        } else if (action == 1) {
            b();
            this.e = 0;
        } else if (action == 2) {
            int i = this.e;
            if (i == 1) {
                this.c.set(this.d);
                this.c.postTranslate(motionEvent.getX() - this.l.x, motionEvent.getY() - this.l.y);
            } else if (i == 2) {
                android.graphics.Matrix matrix = this.c;
                matrix.set(matrix);
                float fA = a(motionEvent);
                if (fA > 10.0f) {
                    this.c.set(this.d);
                    float f = fA / this.n;
                    android.graphics.Matrix matrix2 = this.c;
                    android.graphics.PointF pointF = this.m;
                    matrix2.postScale(f, f, pointF.x, pointF.y);
                }
            }
            setImageMatrix(this.c);
        } else if (action == 5) {
            float fA2 = a(motionEvent);
            this.n = fA2;
            if (fA2 > 10.0f) {
                this.d.set(this.c);
                a(this.m);
                this.e = 2;
            }
        } else if (action == 6) {
            b();
            this.e = 0;
        }
        this.b = true;
        return true;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.h = bitmap;
        if (bitmap != null) {
            this.h = bitmap;
        }
    }
}
