package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class AppCompatCompoundButtonHelper {
    private android.content.res.ColorStateList mButtonTintList = null;
    private android.graphics.PorterDuff.Mode mButtonTintMode = null;
    private boolean mHasButtonTint = false;
    private boolean mHasButtonTintMode = false;
    private boolean mSkipNextApply;
    private final android.widget.CompoundButton mView;

    interface DirectSetButtonDrawableInterface {
        void setButtonDrawable(android.graphics.drawable.Drawable drawable);
    }

    AppCompatCompoundButtonHelper(android.widget.CompoundButton compoundButton) {
        this.mView = compoundButton;
    }

    void applyButtonTint() {
        android.graphics.drawable.Drawable buttonDrawable = android.support.v4.widget.CompoundButtonCompat.getButtonDrawable(this.mView);
        if (buttonDrawable != null) {
            if (this.mHasButtonTint || this.mHasButtonTintMode) {
                android.graphics.drawable.Drawable drawableMutate = android.support.v4.graphics.drawable.DrawableCompat.wrap(buttonDrawable).mutate();
                if (this.mHasButtonTint) {
                    android.support.v4.graphics.drawable.DrawableCompat.setTintList(drawableMutate, this.mButtonTintList);
                }
                if (this.mHasButtonTintMode) {
                    android.support.v4.graphics.drawable.DrawableCompat.setTintMode(drawableMutate, this.mButtonTintMode);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.mView.getDrawableState());
                }
                this.mView.setButtonDrawable(drawableMutate);
            }
        }
    }

    int getCompoundPaddingLeft(int i) {
        android.graphics.drawable.Drawable buttonDrawable;
        return (android.os.Build.VERSION.SDK_INT >= 17 || (buttonDrawable = android.support.v4.widget.CompoundButtonCompat.getButtonDrawable(this.mView)) == null) ? i : i + buttonDrawable.getIntrinsicWidth();
    }

    android.content.res.ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    android.graphics.PorterDuff.Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    void loadFromAttributes(android.util.AttributeSet attributeSet, int i) {
        int resourceId;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, android.support.v7.appcompat.R.styleable.CompoundButton, i, 0);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.CompoundButton_android_button) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.CompoundButton_android_button, 0)) != 0) {
                this.mView.setButtonDrawable(android.support.v7.content.res.AppCompatResources.getDrawable(this.mView.getContext(), resourceId));
            }
            if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.CompoundButton_buttonTint)) {
                android.support.v4.widget.CompoundButtonCompat.setButtonTintList(this.mView, typedArrayObtainStyledAttributes.getColorStateList(android.support.v7.appcompat.R.styleable.CompoundButton_buttonTint));
            }
            if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.CompoundButton_buttonTintMode)) {
                android.support.v4.widget.CompoundButtonCompat.setButtonTintMode(this.mView, android.support.v7.widget.DrawableUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    void onSetButtonDrawable() {
        if (this.mSkipNextApply) {
            this.mSkipNextApply = false;
        } else {
            this.mSkipNextApply = true;
            applyButtonTint();
        }
    }

    void setSupportButtonTintList(android.content.res.ColorStateList colorStateList) {
        this.mButtonTintList = colorStateList;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    void setSupportButtonTintMode(@android.support.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        this.mButtonTintMode = mode;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }
}
