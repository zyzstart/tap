package com.soundcloud.android.crop;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class RotateBitmap {
    private android.graphics.Bitmap bitmap;
    private int rotation;

    public RotateBitmap(android.graphics.Bitmap bitmap, int i) {
        this.bitmap = bitmap;
        this.rotation = i % 360;
    }

    public android.graphics.Bitmap getBitmap() {
        return this.bitmap;
    }

    public int getHeight() {
        if (this.bitmap == null) {
            return 0;
        }
        return isOrientationChanged() ? this.bitmap.getWidth() : this.bitmap.getHeight();
    }

    public android.graphics.Matrix getRotateMatrix() {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        android.graphics.Bitmap bitmap = this.bitmap;
        if (bitmap != null && this.rotation != 0) {
            matrix.preTranslate(-(bitmap.getWidth() / 2), -(this.bitmap.getHeight() / 2));
            matrix.postRotate(this.rotation);
            matrix.postTranslate(getWidth() / 2, getHeight() / 2);
        }
        return matrix;
    }

    public int getRotation() {
        return this.rotation;
    }

    public int getWidth() {
        if (this.bitmap == null) {
            return 0;
        }
        return isOrientationChanged() ? this.bitmap.getHeight() : this.bitmap.getWidth();
    }

    public boolean isOrientationChanged() {
        return (this.rotation / 90) % 2 != 0;
    }

    public void recycle() {
        android.graphics.Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.bitmap = null;
        }
    }

    public void setBitmap(android.graphics.Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setRotation(int i) {
        this.rotation = i;
    }
}
