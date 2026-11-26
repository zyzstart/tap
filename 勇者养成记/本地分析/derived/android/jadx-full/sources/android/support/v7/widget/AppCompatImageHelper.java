package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class AppCompatImageHelper {
    private android.support.v7.widget.TintInfo mImageTint;
    private android.support.v7.widget.TintInfo mInternalImageTint;
    private android.support.v7.widget.TintInfo mTmpInfo;
    private final android.widget.ImageView mView;

    public AppCompatImageHelper(android.widget.ImageView imageView) {
        this.mView = imageView;
    }

    private boolean applyFrameworkTintUsingColorFilter(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        if (this.mTmpInfo == null) {
            this.mTmpInfo = new android.support.v7.widget.TintInfo();
        }
        android.support.v7.widget.TintInfo tintInfo = this.mTmpInfo;
        tintInfo.clear();
        android.content.res.ColorStateList imageTintList = android.support.v4.widget.ImageViewCompat.getImageTintList(this.mView);
        if (imageTintList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = imageTintList;
        }
        android.graphics.PorterDuff.Mode imageTintMode = android.support.v4.widget.ImageViewCompat.getImageTintMode(this.mView);
        if (imageTintMode != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = imageTintMode;
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            return false;
        }
        android.support.v7.widget.AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        return true;
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i > 21) {
            return this.mInternalImageTint != null;
        }
        return i == 21;
    }

    void applySupportImageTint() {
        android.graphics.drawable.Drawable drawable = this.mView.getDrawable();
        if (drawable != null) {
            android.support.v7.widget.DrawableUtils.fixDrawable(drawable);
        }
        if (drawable != null) {
            if (shouldApplyFrameworkTintUsingColorFilter() && applyFrameworkTintUsingColorFilter(drawable)) {
                return;
            }
            android.support.v7.widget.TintInfo tintInfo = this.mImageTint;
            if (tintInfo != null) {
                android.support.v7.widget.AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
                return;
            }
            android.support.v7.widget.TintInfo tintInfo2 = this.mInternalImageTint;
            if (tintInfo2 != null) {
                android.support.v7.widget.AppCompatDrawableManager.tintDrawable(drawable, tintInfo2, this.mView.getDrawableState());
            }
        }
    }

    android.content.res.ColorStateList getSupportImageTintList() {
        android.support.v7.widget.TintInfo tintInfo = this.mImageTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    android.graphics.PorterDuff.Mode getSupportImageTintMode() {
        android.support.v7.widget.TintInfo tintInfo = this.mImageTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    boolean hasOverlappingRendering() {
        return android.os.Build.VERSION.SDK_INT < 21 || !(this.mView.getBackground() instanceof android.graphics.drawable.RippleDrawable);
    }

    public void loadFromAttributes(android.util.AttributeSet attributeSet, int i) {
        int resourceId;
        android.support.v7.widget.TintTypedArray tintTypedArrayObtainStyledAttributes = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, android.support.v7.appcompat.R.styleable.AppCompatImageView, i, 0);
        try {
            android.graphics.drawable.Drawable drawable = this.mView.getDrawable();
            if (drawable == null && (resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = android.support.v7.content.res.AppCompatResources.getDrawable(this.mView.getContext(), resourceId)) != null) {
                this.mView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                android.support.v7.widget.DrawableUtils.fixDrawable(drawable);
            }
            if (tintTypedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatImageView_tint)) {
                android.support.v4.widget.ImageViewCompat.setImageTintList(this.mView, tintTypedArrayObtainStyledAttributes.getColorStateList(android.support.v7.appcompat.R.styleable.AppCompatImageView_tint));
            }
            if (tintTypedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatImageView_tintMode)) {
                android.support.v4.widget.ImageViewCompat.setImageTintMode(this.mView, android.support.v7.widget.DrawableUtils.parseTintMode(tintTypedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            tintTypedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setImageResource(int i) {
        if (i != 0) {
            android.graphics.drawable.Drawable drawable = android.support.v7.content.res.AppCompatResources.getDrawable(this.mView.getContext(), i);
            if (drawable != null) {
                android.support.v7.widget.DrawableUtils.fixDrawable(drawable);
            }
            this.mView.setImageDrawable(drawable);
        } else {
            this.mView.setImageDrawable(null);
        }
        applySupportImageTint();
    }

    void setInternalImageTint(android.content.res.ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.mInternalImageTint == null) {
                this.mInternalImageTint = new android.support.v7.widget.TintInfo();
            }
            android.support.v7.widget.TintInfo tintInfo = this.mInternalImageTint;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
        } else {
            this.mInternalImageTint = null;
        }
        applySupportImageTint();
    }

    void setSupportImageTintList(android.content.res.ColorStateList colorStateList) {
        if (this.mImageTint == null) {
            this.mImageTint = new android.support.v7.widget.TintInfo();
        }
        android.support.v7.widget.TintInfo tintInfo = this.mImageTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        applySupportImageTint();
    }

    void setSupportImageTintMode(android.graphics.PorterDuff.Mode mode) {
        if (this.mImageTint == null) {
            this.mImageTint = new android.support.v7.widget.TintInfo();
        }
        android.support.v7.widget.TintInfo tintInfo = this.mImageTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        applySupportImageTint();
    }
}
