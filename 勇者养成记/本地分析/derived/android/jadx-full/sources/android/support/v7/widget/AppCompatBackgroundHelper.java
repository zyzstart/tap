package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class AppCompatBackgroundHelper {
    private android.support.v7.widget.TintInfo mBackgroundTint;
    private android.support.v7.widget.TintInfo mInternalBackgroundTint;
    private android.support.v7.widget.TintInfo mTmpInfo;
    private final android.view.View mView;
    private int mBackgroundResId = -1;
    private final android.support.v7.widget.AppCompatDrawableManager mDrawableManager = android.support.v7.widget.AppCompatDrawableManager.get();

    AppCompatBackgroundHelper(android.view.View view) {
        this.mView = view;
    }

    private boolean applyFrameworkTintUsingColorFilter(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        if (this.mTmpInfo == null) {
            this.mTmpInfo = new android.support.v7.widget.TintInfo();
        }
        android.support.v7.widget.TintInfo tintInfo = this.mTmpInfo;
        tintInfo.clear();
        android.content.res.ColorStateList backgroundTintList = android.support.v4.view.ViewCompat.getBackgroundTintList(this.mView);
        if (backgroundTintList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = backgroundTintList;
        }
        android.graphics.PorterDuff.Mode backgroundTintMode = android.support.v4.view.ViewCompat.getBackgroundTintMode(this.mView);
        if (backgroundTintMode != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = backgroundTintMode;
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
            return this.mInternalBackgroundTint != null;
        }
        return i == 21;
    }

    void applySupportBackgroundTint() {
        android.graphics.drawable.Drawable background = this.mView.getBackground();
        if (background != null) {
            if (shouldApplyFrameworkTintUsingColorFilter() && applyFrameworkTintUsingColorFilter(background)) {
                return;
            }
            android.support.v7.widget.TintInfo tintInfo = this.mBackgroundTint;
            if (tintInfo != null) {
                android.support.v7.widget.AppCompatDrawableManager.tintDrawable(background, tintInfo, this.mView.getDrawableState());
                return;
            }
            android.support.v7.widget.TintInfo tintInfo2 = this.mInternalBackgroundTint;
            if (tintInfo2 != null) {
                android.support.v7.widget.AppCompatDrawableManager.tintDrawable(background, tintInfo2, this.mView.getDrawableState());
            }
        }
    }

    android.content.res.ColorStateList getSupportBackgroundTintList() {
        android.support.v7.widget.TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    android.graphics.PorterDuff.Mode getSupportBackgroundTintMode() {
        android.support.v7.widget.TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    void loadFromAttributes(android.util.AttributeSet attributeSet, int i) {
        android.support.v7.widget.TintTypedArray tintTypedArrayObtainStyledAttributes = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, android.support.v7.appcompat.R.styleable.ViewBackgroundHelper, i, 0);
        try {
            if (tintTypedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.ViewBackgroundHelper_android_background)) {
                this.mBackgroundResId = tintTypedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.ViewBackgroundHelper_android_background, -1);
                android.content.res.ColorStateList tintList = this.mDrawableManager.getTintList(this.mView.getContext(), this.mBackgroundResId);
                if (tintList != null) {
                    setInternalBackgroundTint(tintList);
                }
            }
            if (tintTypedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.ViewBackgroundHelper_backgroundTint)) {
                android.support.v4.view.ViewCompat.setBackgroundTintList(this.mView, tintTypedArrayObtainStyledAttributes.getColorStateList(android.support.v7.appcompat.R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (tintTypedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                android.support.v4.view.ViewCompat.setBackgroundTintMode(this.mView, android.support.v7.widget.DrawableUtils.parseTintMode(tintTypedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            tintTypedArrayObtainStyledAttributes.recycle();
        }
    }

    void onSetBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        this.mBackgroundResId = -1;
        setInternalBackgroundTint(null);
        applySupportBackgroundTint();
    }

    void onSetBackgroundResource(int i) {
        this.mBackgroundResId = i;
        android.support.v7.widget.AppCompatDrawableManager appCompatDrawableManager = this.mDrawableManager;
        setInternalBackgroundTint(appCompatDrawableManager != null ? appCompatDrawableManager.getTintList(this.mView.getContext(), i) : null);
        applySupportBackgroundTint();
    }

    void setInternalBackgroundTint(android.content.res.ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.mInternalBackgroundTint == null) {
                this.mInternalBackgroundTint = new android.support.v7.widget.TintInfo();
            }
            android.support.v7.widget.TintInfo tintInfo = this.mInternalBackgroundTint;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
        } else {
            this.mInternalBackgroundTint = null;
        }
        applySupportBackgroundTint();
    }

    void setSupportBackgroundTintList(android.content.res.ColorStateList colorStateList) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new android.support.v7.widget.TintInfo();
        }
        android.support.v7.widget.TintInfo tintInfo = this.mBackgroundTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        applySupportBackgroundTint();
    }

    void setSupportBackgroundTintMode(android.graphics.PorterDuff.Mode mode) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new android.support.v7.widget.TintInfo();
        }
        android.support.v7.widget.TintInfo tintInfo = this.mBackgroundTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        applySupportBackgroundTint();
    }
}
