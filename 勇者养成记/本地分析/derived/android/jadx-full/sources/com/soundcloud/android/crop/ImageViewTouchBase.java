package com.soundcloud.android.crop;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
abstract class ImageViewTouchBase extends android.widget.ImageView {
    private static final float SCALE_RATE = 1.25f;
    protected android.graphics.Matrix baseMatrix;
    protected final com.soundcloud.android.crop.RotateBitmap bitmapDisplayed;
    private final android.graphics.Matrix displayMatrix;
    protected android.os.Handler handler;
    private final float[] matrixValues;
    float maxZoom;
    private java.lang.Runnable onLayoutRunnable;
    private com.soundcloud.android.crop.ImageViewTouchBase.Recycler recycler;
    protected android.graphics.Matrix suppMatrix;
    int thisHeight;
    int thisWidth;

    public interface Recycler {
        void recycle(android.graphics.Bitmap bitmap);
    }

    public ImageViewTouchBase(android.content.Context context) {
        super(context);
        this.baseMatrix = new android.graphics.Matrix();
        this.suppMatrix = new android.graphics.Matrix();
        this.displayMatrix = new android.graphics.Matrix();
        this.matrixValues = new float[9];
        this.bitmapDisplayed = new com.soundcloud.android.crop.RotateBitmap(null, 0);
        this.thisWidth = -1;
        this.thisHeight = -1;
        this.handler = new android.os.Handler();
        init();
    }

    public ImageViewTouchBase(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baseMatrix = new android.graphics.Matrix();
        this.suppMatrix = new android.graphics.Matrix();
        this.displayMatrix = new android.graphics.Matrix();
        this.matrixValues = new float[9];
        this.bitmapDisplayed = new com.soundcloud.android.crop.RotateBitmap(null, 0);
        this.thisWidth = -1;
        this.thisHeight = -1;
        this.handler = new android.os.Handler();
        init();
    }

    public ImageViewTouchBase(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baseMatrix = new android.graphics.Matrix();
        this.suppMatrix = new android.graphics.Matrix();
        this.displayMatrix = new android.graphics.Matrix();
        this.matrixValues = new float[9];
        this.bitmapDisplayed = new com.soundcloud.android.crop.RotateBitmap(null, 0);
        this.thisWidth = -1;
        this.thisHeight = -1;
        this.handler = new android.os.Handler();
        init();
    }

    private float centerHorizontal(android.graphics.RectF rectF, float f, float f2) {
        float width = getWidth();
        if (f < width) {
            return ((width - f) / 2.0f) - rectF.left;
        }
        if (rectF.left > 0.0f) {
            return -rectF.left;
        }
        return rectF.right < width ? width - rectF.right : f2;
    }

    private float centerVertical(android.graphics.RectF rectF, float f, float f2) {
        float height = getHeight();
        if (f < height) {
            return ((height - f) / 2.0f) - rectF.top;
        }
        if (rectF.top > 0.0f) {
            return -rectF.top;
        }
        return rectF.bottom < height ? getHeight() - rectF.bottom : f2;
    }

    private void getProperBaseMatrix(com.soundcloud.android.crop.RotateBitmap rotateBitmap, android.graphics.Matrix matrix, boolean z) {
        float width = getWidth();
        float height = getHeight();
        float width2 = rotateBitmap.getWidth();
        float height2 = rotateBitmap.getHeight();
        matrix.reset();
        float fMin = java.lang.Math.min(java.lang.Math.min(width / width2, 3.0f), java.lang.Math.min(height / height2, 3.0f));
        if (z) {
            matrix.postConcat(rotateBitmap.getRotateMatrix());
        }
        matrix.postScale(fMin, fMin);
        matrix.postTranslate((width - (width2 * fMin)) / 2.0f, (height - (height2 * fMin)) / 2.0f);
    }

    private void init() {
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    private void setImageBitmap(android.graphics.Bitmap bitmap, int i) {
        com.soundcloud.android.crop.ImageViewTouchBase.Recycler recycler;
        super.setImageBitmap(bitmap);
        android.graphics.drawable.Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        android.graphics.Bitmap bitmap2 = this.bitmapDisplayed.getBitmap();
        this.bitmapDisplayed.setBitmap(bitmap);
        this.bitmapDisplayed.setRotation(i);
        if (bitmap2 == null || bitmap2 == bitmap || (recycler = this.recycler) == null) {
            return;
        }
        recycler.recycle(bitmap2);
    }

    protected float calculateMaxZoom() {
        if (this.bitmapDisplayed.getBitmap() == null) {
            return 1.0f;
        }
        return java.lang.Math.max(this.bitmapDisplayed.getWidth() / this.thisWidth, this.bitmapDisplayed.getHeight() / this.thisHeight) * 4.0f;
    }

    protected void center() {
        android.graphics.Bitmap bitmap = this.bitmapDisplayed.getBitmap();
        if (bitmap == null) {
            return;
        }
        android.graphics.Matrix imageViewMatrix = getImageViewMatrix();
        android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        imageViewMatrix.mapRect(rectF);
        float fHeight = rectF.height();
        postTranslate(centerHorizontal(rectF, rectF.width(), 0.0f), centerVertical(rectF, fHeight, 0.0f));
        setImageMatrix(getImageViewMatrix());
    }

    public void clear() {
        setImageBitmapResetBase(null, true);
    }

    protected android.graphics.Matrix getImageViewMatrix() {
        this.displayMatrix.set(this.baseMatrix);
        this.displayMatrix.postConcat(this.suppMatrix);
        return this.displayMatrix;
    }

    protected float getScale() {
        return getScale(this.suppMatrix);
    }

    protected float getScale(android.graphics.Matrix matrix) {
        return getValue(matrix, 0);
    }

    public android.graphics.Matrix getUnrotatedMatrix() {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        getProperBaseMatrix(this.bitmapDisplayed, matrix, false);
        matrix.postConcat(this.suppMatrix);
        return matrix;
    }

    protected float getValue(android.graphics.Matrix matrix, int i) {
        matrix.getValues(this.matrixValues);
        return this.matrixValues[i];
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        if (i != 4 || !keyEvent.isTracking() || keyEvent.isCanceled() || getScale() <= 1.0f) {
            return super.onKeyUp(i, keyEvent);
        }
        zoomTo(1.0f);
        return true;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.thisWidth = i3 - i;
        this.thisHeight = i4 - i2;
        java.lang.Runnable runnable = this.onLayoutRunnable;
        if (runnable != null) {
            this.onLayoutRunnable = null;
            runnable.run();
        }
        if (this.bitmapDisplayed.getBitmap() != null) {
            getProperBaseMatrix(this.bitmapDisplayed, this.baseMatrix, true);
            setImageMatrix(getImageViewMatrix());
        }
    }

    protected void panBy(float f, float f2) {
        postTranslate(f, f2);
        setImageMatrix(getImageViewMatrix());
    }

    protected void postTranslate(float f, float f2) {
        this.suppMatrix.postTranslate(f, f2);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        setImageBitmap(bitmap, 0);
    }

    public void setImageBitmapResetBase(android.graphics.Bitmap bitmap, boolean z) {
        setImageRotateBitmapResetBase(new com.soundcloud.android.crop.RotateBitmap(bitmap, 0), z);
    }

    public void setImageRotateBitmapResetBase(final com.soundcloud.android.crop.RotateBitmap rotateBitmap, final boolean z) {
        if (getWidth() <= 0) {
            this.onLayoutRunnable = new java.lang.Runnable() { // from class: com.soundcloud.android.crop.ImageViewTouchBase.1
                @Override // java.lang.Runnable
                public void run() {
                    com.soundcloud.android.crop.ImageViewTouchBase.this.setImageRotateBitmapResetBase(rotateBitmap, z);
                }
            };
            return;
        }
        if (rotateBitmap.getBitmap() != null) {
            getProperBaseMatrix(rotateBitmap, this.baseMatrix, true);
            setImageBitmap(rotateBitmap.getBitmap(), rotateBitmap.getRotation());
        } else {
            this.baseMatrix.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.suppMatrix.reset();
        }
        setImageMatrix(getImageViewMatrix());
        this.maxZoom = calculateMaxZoom();
    }

    public void setRecycler(com.soundcloud.android.crop.ImageViewTouchBase.Recycler recycler) {
        this.recycler = recycler;
    }

    protected void zoomIn() {
        zoomIn(SCALE_RATE);
    }

    protected void zoomIn(float f) {
        if (getScale() < this.maxZoom && this.bitmapDisplayed.getBitmap() != null) {
            this.suppMatrix.postScale(f, f, getWidth() / 2.0f, getHeight() / 2.0f);
            setImageMatrix(getImageViewMatrix());
        }
    }

    protected void zoomOut() {
        zoomOut(SCALE_RATE);
    }

    protected void zoomOut(float f) {
        if (this.bitmapDisplayed.getBitmap() == null) {
            return;
        }
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        android.graphics.Matrix matrix = new android.graphics.Matrix(this.suppMatrix);
        float f2 = 1.0f / f;
        matrix.postScale(f2, f2, width, height);
        if (getScale(matrix) < 1.0f) {
            this.suppMatrix.setScale(1.0f, 1.0f, width, height);
        } else {
            this.suppMatrix.postScale(f2, f2, width, height);
        }
        setImageMatrix(getImageViewMatrix());
        center();
    }

    protected void zoomTo(float f) {
        zoomTo(f, getWidth() / 2.0f, getHeight() / 2.0f);
    }

    protected void zoomTo(float f, float f2, float f3) {
        float f4 = this.maxZoom;
        if (f > f4) {
            f = f4;
        }
        float scale = f / getScale();
        this.suppMatrix.postScale(scale, scale, f2, f3);
        setImageMatrix(getImageViewMatrix());
        center();
    }

    protected void zoomTo(float f, final float f2, final float f3, final float f4) {
        final float scale = (f - getScale()) / f4;
        final float scale2 = getScale();
        final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        this.handler.post(new java.lang.Runnable() { // from class: com.soundcloud.android.crop.ImageViewTouchBase.2
            @Override // java.lang.Runnable
            public void run() {
                float fMin = java.lang.Math.min(f4, java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
                com.soundcloud.android.crop.ImageViewTouchBase.this.zoomTo(scale2 + (scale * fMin), f2, f3);
                if (fMin < f4) {
                    com.soundcloud.android.crop.ImageViewTouchBase.this.handler.post(this);
                }
            }
        });
    }
}
