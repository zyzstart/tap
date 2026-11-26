package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(17)
class AppCompatTextHelperV17 extends android.support.v7.widget.AppCompatTextHelper {
    private android.support.v7.widget.TintInfo mDrawableEndTint;
    private android.support.v7.widget.TintInfo mDrawableStartTint;

    AppCompatTextHelperV17(android.widget.TextView textView) {
        super(textView);
    }

    @Override // android.support.v7.widget.AppCompatTextHelper
    void applyCompoundDrawablesTints() {
        super.applyCompoundDrawablesTints();
        if (this.mDrawableStartTint == null && this.mDrawableEndTint == null) {
            return;
        }
        android.graphics.drawable.Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
        applyCompoundDrawableTint(compoundDrawablesRelative[0], this.mDrawableStartTint);
        applyCompoundDrawableTint(compoundDrawablesRelative[2], this.mDrawableEndTint);
    }

    @Override // android.support.v7.widget.AppCompatTextHelper
    void loadFromAttributes(android.util.AttributeSet attributeSet, int i) {
        super.loadFromAttributes(attributeSet, i);
        android.content.Context context = this.mView.getContext();
        android.support.v7.widget.AppCompatDrawableManager appCompatDrawableManager = android.support.v7.widget.AppCompatDrawableManager.get();
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.appcompat.R.styleable.AppCompatTextHelper, i, 0);
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTextHelper_android_drawableStart)) {
            this.mDrawableStartTint = createTintInfo(context, appCompatDrawableManager, typedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTextHelper_android_drawableEnd)) {
            this.mDrawableEndTint = createTintInfo(context, appCompatDrawableManager, typedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
