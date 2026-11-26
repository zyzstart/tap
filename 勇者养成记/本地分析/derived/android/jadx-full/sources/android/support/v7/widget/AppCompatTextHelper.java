package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(9)
class AppCompatTextHelper {

    @android.support.annotation.NonNull
    private final android.support.v7.widget.AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private android.support.v7.widget.TintInfo mDrawableBottomTint;
    private android.support.v7.widget.TintInfo mDrawableLeftTint;
    private android.support.v7.widget.TintInfo mDrawableRightTint;
    private android.support.v7.widget.TintInfo mDrawableTopTint;
    private android.graphics.Typeface mFontTypeface;
    private int mStyle = 0;
    final android.widget.TextView mView;

    AppCompatTextHelper(android.widget.TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new android.support.v7.widget.AppCompatTextViewAutoSizeHelper(this.mView);
    }

    static android.support.v7.widget.AppCompatTextHelper create(android.widget.TextView textView) {
        return android.os.Build.VERSION.SDK_INT >= 17 ? new android.support.v7.widget.AppCompatTextHelperV17(textView) : new android.support.v7.widget.AppCompatTextHelper(textView);
    }

    protected static android.support.v7.widget.TintInfo createTintInfo(android.content.Context context, android.support.v7.widget.AppCompatDrawableManager appCompatDrawableManager, int i) {
        android.content.res.ColorStateList tintList = appCompatDrawableManager.getTintList(context, i);
        if (tintList == null) {
            return null;
        }
        android.support.v7.widget.TintInfo tintInfo = new android.support.v7.widget.TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = tintList;
        return tintInfo;
    }

    private void setTextSizeInternal(int i, float f) {
        this.mAutoSizeTextHelper.setTextSizeInternal(i, f);
    }

    private void updateTypefaceAndStyle(android.content.Context context, android.support.v7.widget.TintTypedArray tintTypedArray) {
        this.mStyle = tintTypedArray.getInt(android.support.v7.appcompat.R.styleable.TextAppearance_android_textStyle, this.mStyle);
        if (tintTypedArray.hasValue(android.support.v7.appcompat.R.styleable.TextAppearance_android_fontFamily) || tintTypedArray.hasValue(android.support.v7.appcompat.R.styleable.TextAppearance_fontFamily)) {
            this.mFontTypeface = null;
            int i = tintTypedArray.hasValue(android.support.v7.appcompat.R.styleable.TextAppearance_android_fontFamily) ? android.support.v7.appcompat.R.styleable.TextAppearance_android_fontFamily : android.support.v7.appcompat.R.styleable.TextAppearance_fontFamily;
            if (!context.isRestricted()) {
                try {
                    this.mFontTypeface = tintTypedArray.getFont(i, this.mStyle, this.mView);
                } catch (android.content.res.Resources.NotFoundException | java.lang.UnsupportedOperationException unused) {
                }
            }
            if (this.mFontTypeface == null) {
                this.mFontTypeface = android.graphics.Typeface.create(tintTypedArray.getString(i), this.mStyle);
            }
        }
    }

    final void applyCompoundDrawableTint(android.graphics.drawable.Drawable drawable, android.support.v7.widget.TintInfo tintInfo) {
        if (drawable == null || tintInfo == null) {
            return;
        }
        android.support.v7.widget.AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
    }

    void applyCompoundDrawablesTints() {
        if (this.mDrawableLeftTint == null && this.mDrawableTopTint == null && this.mDrawableRightTint == null && this.mDrawableBottomTint == null) {
            return;
        }
        android.graphics.drawable.Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
        applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
        applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
        applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
        applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    void loadFromAttributes(android.util.AttributeSet attributeSet, int i) {
        android.content.res.ColorStateList colorStateList;
        android.content.res.ColorStateList colorStateList2;
        boolean z;
        boolean z2;
        android.content.Context context = this.mView.getContext();
        android.support.v7.widget.AppCompatDrawableManager appCompatDrawableManager = android.support.v7.widget.AppCompatDrawableManager.get();
        android.support.v7.widget.TintTypedArray tintTypedArrayObtainStyledAttributes = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, android.support.v7.appcompat.R.styleable.AppCompatTextHelper, i, 0);
        int resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (tintTypedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager, tintTypedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTextHelper_android_drawableTop)) {
            this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager, tintTypedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTextHelper_android_drawableRight)) {
            this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager, tintTypedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager, tintTypedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        tintTypedArrayObtainStyledAttributes.recycle();
        boolean z3 = this.mView.getTransformationMethod() instanceof android.text.method.PasswordTransformationMethod;
        boolean z4 = true;
        android.content.res.ColorStateList colorStateList3 = null;
        if (resourceId != -1) {
            android.support.v7.widget.TintTypedArray tintTypedArrayObtainStyledAttributes2 = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(context, resourceId, android.support.v7.appcompat.R.styleable.TextAppearance);
            if (z3 || !tintTypedArrayObtainStyledAttributes2.hasValue(android.support.v7.appcompat.R.styleable.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z2 = tintTypedArrayObtainStyledAttributes2.getBoolean(android.support.v7.appcompat.R.styleable.TextAppearance_textAllCaps, false);
                z = true;
            }
            updateTypefaceAndStyle(context, tintTypedArrayObtainStyledAttributes2);
            if (android.os.Build.VERSION.SDK_INT < 23) {
                android.content.res.ColorStateList colorStateList4 = tintTypedArrayObtainStyledAttributes2.hasValue(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor) ? tintTypedArrayObtainStyledAttributes2.getColorStateList(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor) : null;
                colorStateList2 = tintTypedArrayObtainStyledAttributes2.hasValue(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColorHint) ? tintTypedArrayObtainStyledAttributes2.getColorStateList(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColorHint) : null;
                if (tintTypedArrayObtainStyledAttributes2.hasValue(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColorLink)) {
                    android.content.res.ColorStateList colorStateList5 = colorStateList4;
                    colorStateList = tintTypedArrayObtainStyledAttributes2.getColorStateList(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColorLink);
                    colorStateList3 = colorStateList5;
                } else {
                    android.content.res.ColorStateList colorStateList6 = colorStateList4;
                    colorStateList = null;
                    colorStateList3 = colorStateList6;
                }
            } else {
                colorStateList = null;
                colorStateList2 = null;
            }
            tintTypedArrayObtainStyledAttributes2.recycle();
        } else {
            colorStateList = null;
            colorStateList2 = null;
            z = false;
            z2 = false;
        }
        android.support.v7.widget.TintTypedArray tintTypedArrayObtainStyledAttributes3 = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, android.support.v7.appcompat.R.styleable.TextAppearance, i, 0);
        if (z3 || !tintTypedArrayObtainStyledAttributes3.hasValue(android.support.v7.appcompat.R.styleable.TextAppearance_textAllCaps)) {
            z4 = z;
        } else {
            z2 = tintTypedArrayObtainStyledAttributes3.getBoolean(android.support.v7.appcompat.R.styleable.TextAppearance_textAllCaps, false);
        }
        if (android.os.Build.VERSION.SDK_INT < 23) {
            if (tintTypedArrayObtainStyledAttributes3.hasValue(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor)) {
                colorStateList3 = tintTypedArrayObtainStyledAttributes3.getColorStateList(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor);
            }
            if (tintTypedArrayObtainStyledAttributes3.hasValue(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColorHint)) {
                colorStateList2 = tintTypedArrayObtainStyledAttributes3.getColorStateList(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColorHint);
            }
            if (tintTypedArrayObtainStyledAttributes3.hasValue(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColorLink)) {
                colorStateList = tintTypedArrayObtainStyledAttributes3.getColorStateList(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColorLink);
            }
        }
        updateTypefaceAndStyle(context, tintTypedArrayObtainStyledAttributes3);
        tintTypedArrayObtainStyledAttributes3.recycle();
        if (colorStateList3 != null) {
            this.mView.setTextColor(colorStateList3);
        }
        if (colorStateList2 != null) {
            this.mView.setHintTextColor(colorStateList2);
        }
        if (colorStateList != null) {
            this.mView.setLinkTextColor(colorStateList);
        }
        if (!z3 && z4) {
            setAllCaps(z2);
        }
        android.graphics.Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            this.mView.setTypeface(typeface, this.mStyle);
        }
        this.mAutoSizeTextHelper.loadFromAttributes(attributeSet, i);
        if (android.os.Build.VERSION.SDK_INT < 26 || this.mAutoSizeTextHelper.getAutoSizeTextType() == 0) {
            return;
        }
        int[] autoSizeTextAvailableSizes = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
        if (autoSizeTextAvailableSizes.length > 0) {
            if (this.mView.getAutoSizeStepGranularity() != -1.0f) {
                this.mView.setAutoSizeTextTypeUniformWithConfiguration(this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
            } else {
                this.mView.setAutoSizeTextTypeUniformWithPresetSizes(autoSizeTextAvailableSizes, 0);
            }
        }
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (android.os.Build.VERSION.SDK_INT < 26) {
            autoSizeText();
        }
    }

    void onSetTextAppearance(android.content.Context context, int i) {
        android.content.res.ColorStateList colorStateList;
        android.support.v7.widget.TintTypedArray tintTypedArrayObtainStyledAttributes = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(context, i, android.support.v7.appcompat.R.styleable.TextAppearance);
        if (tintTypedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.TextAppearance_textAllCaps)) {
            setAllCaps(tintTypedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.TextAppearance_textAllCaps, false));
        }
        if (android.os.Build.VERSION.SDK_INT < 23 && tintTypedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor) && (colorStateList = tintTypedArrayObtainStyledAttributes.getColorStateList(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor)) != null) {
            this.mView.setTextColor(colorStateList);
        }
        updateTypefaceAndStyle(context, tintTypedArrayObtainStyledAttributes);
        tintTypedArrayObtainStyledAttributes.recycle();
        android.graphics.Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            this.mView.setTypeface(typeface, this.mStyle);
        }
    }

    void setAllCaps(boolean z) {
        this.mView.setAllCaps(z);
    }

    void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws java.lang.IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
    }

    void setAutoSizeTextTypeUniformWithPresetSizes(@android.support.annotation.NonNull int[] iArr, int i) throws java.lang.IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
    }

    void setAutoSizeTextTypeWithDefaults(int i) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(i);
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    void setTextSize(int i, float f) {
        if (android.os.Build.VERSION.SDK_INT >= 26 || isAutoSizeEnabled()) {
            return;
        }
        setTextSizeInternal(i, f);
    }
}
