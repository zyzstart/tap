package com.soundcloud.android.crop;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CropImageView extends com.soundcloud.android.crop.ImageViewTouchBase {
    android.content.Context context;
    java.util.ArrayList<com.soundcloud.android.crop.HighlightView> highlightViews;
    private float lastX;
    private float lastY;
    private int motionEdge;
    com.soundcloud.android.crop.HighlightView motionHighlightView;
    private int validPointerId;

    public CropImageView(android.content.Context context) {
        super(context);
        this.highlightViews = new java.util.ArrayList<>();
    }

    public CropImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.highlightViews = new java.util.ArrayList<>();
    }

    public CropImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.highlightViews = new java.util.ArrayList<>();
    }

    private void centerBasedOnHighlightView(com.soundcloud.android.crop.HighlightView highlightView) {
        android.graphics.Rect rect = highlightView.drawRect;
        float fMax = java.lang.Math.max(1.0f, java.lang.Math.min((getWidth() / rect.width()) * 0.6f, (getHeight() / rect.height()) * 0.6f) * getScale());
        if (java.lang.Math.abs(fMax - getScale()) / fMax > 0.1d) {
            float[] fArr = {highlightView.cropRect.centerX(), highlightView.cropRect.centerY()};
            getUnrotatedMatrix().mapPoints(fArr);
            zoomTo(fMax, fArr[0], fArr[1], 300.0f);
        }
        ensureVisible(highlightView);
    }

    private void ensureVisible(com.soundcloud.android.crop.HighlightView highlightView) {
        android.graphics.Rect rect = highlightView.drawRect;
        int iMax = java.lang.Math.max(0, getLeft() - rect.left);
        int iMin = java.lang.Math.min(0, getRight() - rect.right);
        int iMax2 = java.lang.Math.max(0, getTop() - rect.top);
        int iMin2 = java.lang.Math.min(0, getBottom() - rect.bottom);
        if (iMax == 0) {
            iMax = iMin;
        }
        if (iMax2 != 0) {
            iMin2 = iMax2;
        }
        if (iMax == 0 && iMin2 == 0) {
            return;
        }
        panBy(iMax, iMin2);
    }

    public void add(com.soundcloud.android.crop.HighlightView highlightView) {
        this.highlightViews.add(highlightView);
        invalidate();
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ android.graphics.Matrix getUnrotatedMatrix() {
        return super.getUnrotatedMatrix();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@android.support.annotation.NonNull android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        java.util.Iterator<com.soundcloud.android.crop.HighlightView> it = this.highlightViews.iterator();
        while (it.hasNext()) {
            it.next().draw(canvas);
        }
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase, android.view.View, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase, android.view.View, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bitmapDisplayed.getBitmap() != null) {
            for (com.soundcloud.android.crop.HighlightView highlightView : this.highlightViews) {
                highlightView.matrix.set(getUnrotatedMatrix());
                highlightView.invalidate();
                if (highlightView.hasFocus()) {
                    centerBasedOnHighlightView(highlightView);
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(@android.support.annotation.NonNull android.view.MotionEvent motionEvent) {
        if (((com.soundcloud.android.crop.CropImageActivity) this.context).isSaving()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                for (com.soundcloud.android.crop.HighlightView highlightView : this.highlightViews) {
                    int hit = highlightView.getHit(motionEvent.getX(), motionEvent.getY());
                    if (hit != 1) {
                        this.motionEdge = hit;
                        this.motionHighlightView = highlightView;
                        this.lastX = motionEvent.getX();
                        this.lastY = motionEvent.getY();
                        this.validPointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.motionHighlightView.setMode(hit == 32 ? com.soundcloud.android.crop.HighlightView.ModifyMode.Move : com.soundcloud.android.crop.HighlightView.ModifyMode.Grow);
                        return true;
                    }
                }
                return true;
            case 1:
                com.soundcloud.android.crop.HighlightView highlightView2 = this.motionHighlightView;
                if (highlightView2 != null) {
                    centerBasedOnHighlightView(highlightView2);
                    this.motionHighlightView.setMode(com.soundcloud.android.crop.HighlightView.ModifyMode.None);
                }
                this.motionHighlightView = null;
                center();
                return true;
            case 2:
                if (this.motionHighlightView != null && motionEvent.getPointerId(motionEvent.getActionIndex()) == this.validPointerId) {
                    this.motionHighlightView.handleMotion(this.motionEdge, motionEvent.getX() - this.lastX, motionEvent.getY() - this.lastY);
                    this.lastX = motionEvent.getX();
                    this.lastY = motionEvent.getY();
                }
                if (getScale() == 1.0f) {
                    center();
                }
                return true;
            default:
                return true;
        }
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    protected void postTranslate(float f, float f2) {
        super.postTranslate(f, f2);
        for (com.soundcloud.android.crop.HighlightView highlightView : this.highlightViews) {
            highlightView.matrix.postTranslate(f, f2);
            highlightView.invalidate();
        }
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase, android.widget.ImageView
    public /* bridge */ /* synthetic */ void setImageBitmap(android.graphics.Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setImageBitmapResetBase(android.graphics.Bitmap bitmap, boolean z) {
        super.setImageBitmapResetBase(bitmap, z);
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setImageRotateBitmapResetBase(com.soundcloud.android.crop.RotateBitmap rotateBitmap, boolean z) {
        super.setImageRotateBitmapResetBase(rotateBitmap, z);
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setRecycler(com.soundcloud.android.crop.ImageViewTouchBase.Recycler recycler) {
        super.setRecycler(recycler);
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    protected void zoomIn() {
        super.zoomIn();
        for (com.soundcloud.android.crop.HighlightView highlightView : this.highlightViews) {
            highlightView.matrix.set(getUnrotatedMatrix());
            highlightView.invalidate();
        }
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    protected void zoomOut() {
        super.zoomOut();
        for (com.soundcloud.android.crop.HighlightView highlightView : this.highlightViews) {
            highlightView.matrix.set(getUnrotatedMatrix());
            highlightView.invalidate();
        }
    }

    @Override // com.soundcloud.android.crop.ImageViewTouchBase
    protected void zoomTo(float f, float f2, float f3) {
        super.zoomTo(f, f2, f3);
        for (com.soundcloud.android.crop.HighlightView highlightView : this.highlightViews) {
            highlightView.matrix.set(getUnrotatedMatrix());
            highlightView.invalidate();
        }
    }
}
