package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class l extends android.view.View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f1636a;
    final int b;
    android.graphics.Bitmap c;
    android.graphics.Bitmap d;

    /* JADX INFO: renamed from: com.unity3d.player.l$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1637a = new int[com.unity3d.player.l.a.a().length];

        static {
            try {
                f1637a[com.unity3d.player.l.a.f1638a - 1] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f1637a[com.unity3d.player.l.a.b - 1] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f1637a[com.unity3d.player.l.a.c - 1] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f1638a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = {f1638a, b, c};

        public static int[] a() {
            return (int[]) d.clone();
        }
    }

    public l(android.content.Context context, int i) {
        super(context);
        this.f1636a = i;
        this.b = getResources().getIdentifier("unity_static_splash", "drawable", getContext().getPackageName());
        if (this.b != 0) {
            forceLayout();
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        android.graphics.Bitmap bitmap = this.c;
        if (bitmap != null) {
            bitmap.recycle();
            this.c = null;
        }
        android.graphics.Bitmap bitmap2 = this.d;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.d = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0067  */
    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.b == 0) {
            return;
        }
        if (this.c == null) {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inScaled = false;
            this.c = android.graphics.BitmapFactory.decodeResource(getResources(), this.b, options);
        }
        int width = this.c.getWidth();
        int height = this.c.getHeight();
        int width2 = getWidth();
        int height2 = getHeight();
        if (width2 == 0 || height2 == 0) {
            return;
        }
        float f = width / height;
        float f2 = width2;
        float f3 = height2;
        boolean z2 = f2 / f3 <= f;
        int[] iArr = com.unity3d.player.l.AnonymousClass1.f1637a;
        int i5 = this.f1636a;
        switch (iArr[i5 - 1]) {
            case 1:
                if (width2 < width) {
                    height = (int) (f2 / f);
                    width = width2;
                }
                if (height2 < height) {
                    width = (int) (f3 * f);
                    height = height2;
                }
                break;
            case 2:
            case 3:
                if (!((i5 == com.unity3d.player.l.a.c) ^ z2)) {
                    width = (int) (f3 * f);
                    height = height2;
                } else {
                    height = (int) (f2 / f);
                    width = width2;
                }
                break;
        }
        android.graphics.Bitmap bitmap = this.d;
        if (bitmap != null) {
            if (bitmap.getWidth() == width && this.d.getHeight() == height) {
                return;
            }
            android.graphics.Bitmap bitmap2 = this.d;
            if (bitmap2 != this.c) {
                bitmap2.recycle();
                this.d = null;
            }
        }
        this.d = android.graphics.Bitmap.createScaledBitmap(this.c, width, height, true);
        this.d.setDensity(getResources().getDisplayMetrics().densityDpi);
        android.graphics.drawable.ColorDrawable colorDrawable = new android.graphics.drawable.ColorDrawable(-16777216);
        android.graphics.drawable.BitmapDrawable bitmapDrawable = new android.graphics.drawable.BitmapDrawable(getResources(), this.d);
        bitmapDrawable.setGravity(17);
        setBackground(new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{colorDrawable, bitmapDrawable}));
    }
}
