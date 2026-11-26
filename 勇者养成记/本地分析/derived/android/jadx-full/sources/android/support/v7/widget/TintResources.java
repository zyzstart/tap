package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class TintResources extends android.support.v7.widget.ResourcesWrapper {
    private final java.lang.ref.WeakReference<android.content.Context> mContextRef;

    public TintResources(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull android.content.res.Resources resources) {
        super(resources);
        this.mContextRef = new java.lang.ref.WeakReference<>(context);
    }

    @Override // android.support.v7.widget.ResourcesWrapper, android.content.res.Resources
    public android.graphics.drawable.Drawable getDrawable(int i) throws android.content.res.Resources.NotFoundException {
        android.graphics.drawable.Drawable drawable = super.getDrawable(i);
        android.content.Context context = this.mContextRef.get();
        if (drawable != null && context != null) {
            android.support.v7.widget.AppCompatDrawableManager.get();
            android.support.v7.widget.AppCompatDrawableManager.tintDrawableUsingColorFilter(context, i, drawable);
        }
        return drawable;
    }
}
