package com.soundcloud.android.crop;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class HighlightView {
    private static final int DEFAULT_HIGHLIGHT_COLOR = -13388315;
    public static final int GROW_BOTTOM_EDGE = 16;
    public static final int GROW_LEFT_EDGE = 2;
    public static final int GROW_NONE = 1;
    public static final int GROW_RIGHT_EDGE = 4;
    public static final int GROW_TOP_EDGE = 8;
    private static final float HANDLE_RADIUS_DP = 12.0f;
    public static final int MOVE = 32;
    private static final float OUTLINE_DP = 2.0f;
    android.graphics.RectF cropRect;
    android.graphics.Rect drawRect;
    private float handleRadius;
    private int highlightColor;
    private android.graphics.RectF imageRect;
    private float initialAspectRatio;
    private boolean isFocused;
    private boolean maintainAspectRatio;
    android.graphics.Matrix matrix;
    private float outlineWidth;
    private boolean showCircle;
    private boolean showThirds;
    private android.view.View viewContext;
    private final android.graphics.Paint outsidePaint = new android.graphics.Paint();
    private final android.graphics.Paint outlinePaint = new android.graphics.Paint();
    private final android.graphics.Paint handlePaint = new android.graphics.Paint();
    private com.soundcloud.android.crop.HighlightView.ModifyMode modifyMode = com.soundcloud.android.crop.HighlightView.ModifyMode.None;
    private com.soundcloud.android.crop.HighlightView.HandleMode handleMode = com.soundcloud.android.crop.HighlightView.HandleMode.Changing;

    enum HandleMode {
        Changing,
        Always,
        Never
    }

    enum ModifyMode {
        None,
        Move,
        Grow
    }

    public HighlightView(android.view.View view) {
        this.viewContext = view;
        initStyles(view.getContext());
    }

    private android.graphics.Rect computeLayout() {
        android.graphics.RectF rectF = new android.graphics.RectF(this.cropRect.left, this.cropRect.top, this.cropRect.right, this.cropRect.bottom);
        this.matrix.mapRect(rectF);
        return new android.graphics.Rect(java.lang.Math.round(rectF.left), java.lang.Math.round(rectF.top), java.lang.Math.round(rectF.right), java.lang.Math.round(rectF.bottom));
    }

    private float dpToPx(float f) {
        return f * this.viewContext.getResources().getDisplayMetrics().density;
    }

    private void drawCircle(android.graphics.Canvas canvas) {
        this.outlinePaint.setStrokeWidth(1.0f);
        canvas.drawOval(new android.graphics.RectF(this.drawRect), this.outlinePaint);
    }

    private void drawHandles(android.graphics.Canvas canvas) {
        int i = this.drawRect.left + ((this.drawRect.right - this.drawRect.left) / 2);
        float f = this.drawRect.top + ((this.drawRect.bottom - this.drawRect.top) / 2);
        canvas.drawCircle(this.drawRect.left, f, this.handleRadius, this.handlePaint);
        float f2 = i;
        canvas.drawCircle(f2, this.drawRect.top, this.handleRadius, this.handlePaint);
        canvas.drawCircle(this.drawRect.right, f, this.handleRadius, this.handlePaint);
        canvas.drawCircle(f2, this.drawRect.bottom, this.handleRadius, this.handlePaint);
    }

    private void drawOutsideFallback(android.graphics.Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), this.drawRect.top, this.outsidePaint);
        canvas.drawRect(0.0f, this.drawRect.bottom, canvas.getWidth(), canvas.getHeight(), this.outsidePaint);
        canvas.drawRect(0.0f, this.drawRect.top, this.drawRect.left, this.drawRect.bottom, this.outsidePaint);
        canvas.drawRect(this.drawRect.right, this.drawRect.top, canvas.getWidth(), this.drawRect.bottom, this.outsidePaint);
    }

    private void drawThirds(android.graphics.Canvas canvas) {
        this.outlinePaint.setStrokeWidth(1.0f);
        float f = (this.drawRect.right - this.drawRect.left) / 3;
        float f2 = (this.drawRect.bottom - this.drawRect.top) / 3;
        canvas.drawLine(this.drawRect.left + f, this.drawRect.top, this.drawRect.left + f, this.drawRect.bottom, this.outlinePaint);
        float f3 = this.drawRect.left;
        float f4 = f * OUTLINE_DP;
        canvas.drawLine(f3 + f4, this.drawRect.top, this.drawRect.left + f4, this.drawRect.bottom, this.outlinePaint);
        canvas.drawLine(this.drawRect.left, this.drawRect.top + f2, this.drawRect.right, this.drawRect.top + f2, this.outlinePaint);
        float f5 = this.drawRect.left;
        float f6 = this.drawRect.top;
        float f7 = f2 * OUTLINE_DP;
        canvas.drawLine(f5, f6 + f7, this.drawRect.right, this.drawRect.top + f7, this.outlinePaint);
    }

    private void initStyles(android.content.Context context) {
        context.getTheme().resolveAttribute(getAttrId("cropImageStyle"), new android.util.TypedValue(), true);
        this.showThirds = false;
        this.showCircle = false;
        this.highlightColor = DEFAULT_HIGHLIGHT_COLOR;
        this.handleMode = com.soundcloud.android.crop.HighlightView.HandleMode.values()[1];
    }

    @android.annotation.SuppressLint({"NewApi"})
    private boolean isClipPathSupported(android.graphics.Canvas canvas) {
        if (android.os.Build.VERSION.SDK_INT == 17) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT < 14 || android.os.Build.VERSION.SDK_INT > 15) {
            return true;
        }
        return !canvas.isHardwareAccelerated();
    }

    protected void draw(android.graphics.Canvas canvas) {
        canvas.save();
        android.graphics.Path path = new android.graphics.Path();
        this.outlinePaint.setStrokeWidth(this.outlineWidth);
        if (!hasFocus()) {
            this.outlinePaint.setColor(-16777216);
            canvas.drawRect(this.drawRect, this.outlinePaint);
            return;
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        this.viewContext.getDrawingRect(rect);
        path.addRect(new android.graphics.RectF(this.drawRect), android.graphics.Path.Direction.CW);
        this.outlinePaint.setColor(this.highlightColor);
        if (isClipPathSupported(canvas)) {
            canvas.clipPath(path, android.graphics.Region.Op.DIFFERENCE);
            canvas.drawRect(rect, this.outsidePaint);
        } else {
            drawOutsideFallback(canvas);
        }
        canvas.restore();
        canvas.drawPath(path, this.outlinePaint);
        if (this.showThirds) {
            drawThirds(canvas);
        }
        if (this.showCircle) {
            drawCircle(canvas);
        }
        if (this.handleMode == com.soundcloud.android.crop.HighlightView.HandleMode.Always || (this.handleMode == com.soundcloud.android.crop.HighlightView.HandleMode.Changing && this.modifyMode == com.soundcloud.android.crop.HighlightView.ModifyMode.Grow)) {
            drawHandles(canvas);
        }
    }

    public int getAttrId(java.lang.String str) {
        try {
            java.lang.Class<?>[] classes = this.viewContext.getContext().getClassLoader().loadClass(this.viewContext.getContext().getPackageName() + ".R").getClasses();
            for (int i = 0; i < classes.length; i++) {
                if (classes[i].getName().equals(this.viewContext.getContext().getPackageName() + ".R$attr")) {
                    return classes[i].getField(str).getInt(null);
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getHit(float f, float f2) {
        android.graphics.Rect rectComputeLayout = computeLayout();
        boolean z = false;
        boolean z2 = f2 >= ((float) rectComputeLayout.top) - 20.0f && f2 < ((float) rectComputeLayout.bottom) + 20.0f;
        if (f >= rectComputeLayout.left - 20.0f && f < rectComputeLayout.right + 20.0f) {
            z = true;
        }
        int i = (java.lang.Math.abs(((float) rectComputeLayout.left) - f) >= 20.0f || !z2) ? 1 : 3;
        if (java.lang.Math.abs(rectComputeLayout.right - f) < 20.0f && z2) {
            i |= 4;
        }
        if (java.lang.Math.abs(rectComputeLayout.top - f2) < 20.0f && z) {
            i |= 8;
        }
        if (java.lang.Math.abs(rectComputeLayout.bottom - f2) < 20.0f && z) {
            i |= 16;
        }
        if (i == 1 && rectComputeLayout.contains((int) f, (int) f2)) {
            return 32;
        }
        return i;
    }

    public android.graphics.Rect getScaledCropRect(float f) {
        return new android.graphics.Rect((int) (this.cropRect.left * f), (int) (this.cropRect.top * f), (int) (this.cropRect.right * f), (int) (this.cropRect.bottom * f));
    }

    void growBy(float f, float f2) {
        if (this.maintainAspectRatio) {
            if (f != 0.0f) {
                f2 = f / this.initialAspectRatio;
            } else if (f2 != 0.0f) {
                f = this.initialAspectRatio * f2;
            }
        }
        android.graphics.RectF rectF = new android.graphics.RectF(this.cropRect);
        if (f > 0.0f && rectF.width() + (f * OUTLINE_DP) > this.imageRect.width()) {
            f = (this.imageRect.width() - rectF.width()) / OUTLINE_DP;
            if (this.maintainAspectRatio) {
                f2 = f / this.initialAspectRatio;
            }
        }
        if (f2 > 0.0f && rectF.height() + (f2 * OUTLINE_DP) > this.imageRect.height()) {
            f2 = (this.imageRect.height() - rectF.height()) / OUTLINE_DP;
            if (this.maintainAspectRatio) {
                f = this.initialAspectRatio * f2;
            }
        }
        rectF.inset(-f, -f2);
        if (rectF.width() < 25.0f) {
            rectF.inset((-(25.0f - rectF.width())) / OUTLINE_DP, 0.0f);
        }
        float f3 = this.maintainAspectRatio ? 25.0f / this.initialAspectRatio : 25.0f;
        if (rectF.height() < f3) {
            rectF.inset(0.0f, (-(f3 - rectF.height())) / OUTLINE_DP);
        }
        if (rectF.left < this.imageRect.left) {
            rectF.offset(this.imageRect.left - rectF.left, 0.0f);
        } else if (rectF.right > this.imageRect.right) {
            rectF.offset(-(rectF.right - this.imageRect.right), 0.0f);
        }
        if (rectF.top < this.imageRect.top) {
            rectF.offset(0.0f, this.imageRect.top - rectF.top);
        } else if (rectF.bottom > this.imageRect.bottom) {
            rectF.offset(0.0f, -(rectF.bottom - this.imageRect.bottom));
        }
        this.cropRect.set(rectF);
        this.drawRect = computeLayout();
        this.viewContext.invalidate();
    }

    void handleMotion(int i, float f, float f2) {
        android.graphics.Rect rectComputeLayout = computeLayout();
        if (i == 32) {
            moveBy(f * (this.cropRect.width() / rectComputeLayout.width()), f2 * (this.cropRect.height() / rectComputeLayout.height()));
            return;
        }
        if ((i & 6) == 0) {
            f = 0.0f;
        }
        if ((i & 24) == 0) {
            f2 = 0.0f;
        }
        growBy(((i & 2) != 0 ? -1 : 1) * f * (this.cropRect.width() / rectComputeLayout.width()), ((i & 8) == 0 ? 1 : -1) * f2 * (this.cropRect.height() / rectComputeLayout.height()));
    }

    public boolean hasFocus() {
        return this.isFocused;
    }

    public void invalidate() {
        this.drawRect = computeLayout();
    }

    void moveBy(float f, float f2) {
        android.graphics.Rect rect = new android.graphics.Rect(this.drawRect);
        this.cropRect.offset(f, f2);
        this.cropRect.offset(java.lang.Math.max(0.0f, this.imageRect.left - this.cropRect.left), java.lang.Math.max(0.0f, this.imageRect.top - this.cropRect.top));
        this.cropRect.offset(java.lang.Math.min(0.0f, this.imageRect.right - this.cropRect.right), java.lang.Math.min(0.0f, this.imageRect.bottom - this.cropRect.bottom));
        this.drawRect = computeLayout();
        rect.union(this.drawRect);
        float f3 = this.handleRadius;
        rect.inset(-((int) f3), -((int) f3));
        this.viewContext.invalidate(rect);
    }

    public void setFocus(boolean z) {
        this.isFocused = z;
    }

    public void setMode(com.soundcloud.android.crop.HighlightView.ModifyMode modifyMode) {
        if (modifyMode != this.modifyMode) {
            this.modifyMode = modifyMode;
            this.viewContext.invalidate();
        }
    }

    public void setup(android.graphics.Matrix matrix, android.graphics.Rect rect, android.graphics.RectF rectF, boolean z) {
        this.matrix = new android.graphics.Matrix(matrix);
        this.cropRect = rectF;
        this.imageRect = new android.graphics.RectF(rect);
        this.maintainAspectRatio = z;
        this.initialAspectRatio = this.cropRect.width() / this.cropRect.height();
        this.drawRect = computeLayout();
        this.outsidePaint.setARGB(com.tencent.smtt.sdk.TbsListener.ErrorCode.DOWNLOAD_THROWABLE, 50, 50, 50);
        this.outlinePaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.outlinePaint.setAntiAlias(true);
        this.outlineWidth = dpToPx(OUTLINE_DP);
        this.handlePaint.setColor(this.highlightColor);
        this.handlePaint.setStyle(android.graphics.Paint.Style.FILL);
        this.handlePaint.setAntiAlias(true);
        this.handleRadius = dpToPx(HANDLE_RADIUS_DP);
        this.modifyMode = com.soundcloud.android.crop.HighlightView.ModifyMode.None;
    }
}
