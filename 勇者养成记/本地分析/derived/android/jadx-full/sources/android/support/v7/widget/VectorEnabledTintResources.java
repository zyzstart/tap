package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class VectorEnabledTintResources extends android.content.res.Resources {
    public static final int MAX_SDK_WHERE_REQUIRED = 20;
    private final java.lang.ref.WeakReference<android.content.Context> mContextRef;

    public VectorEnabledTintResources(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull android.content.res.Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mContextRef = new java.lang.ref.WeakReference<>(context);
    }

    public static boolean shouldBeUsed() {
        return android.support.v7.app.AppCompatDelegate.isCompatVectorFromResourcesEnabled() && android.os.Build.VERSION.SDK_INT <= 20;
    }

    @Override // android.content.res.Resources
    public android.graphics.drawable.Drawable getDrawable(int i) throws android.content.res.Resources.NotFoundException {
        android.content.Context context = this.mContextRef.get();
        return context != null ? android.support.v7.widget.AppCompatDrawableManager.get().onDrawableLoadedFromResources(context, this, i) : super.getDrawable(i);
    }

    final android.graphics.drawable.Drawable superGetDrawable(int i) {
        return super.getDrawable(i);
    }
}
