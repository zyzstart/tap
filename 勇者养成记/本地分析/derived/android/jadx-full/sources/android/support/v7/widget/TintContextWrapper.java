package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TintContextWrapper extends android.content.ContextWrapper {
    private static final java.lang.Object CACHE_LOCK = new java.lang.Object();
    private static java.util.ArrayList<java.lang.ref.WeakReference<android.support.v7.widget.TintContextWrapper>> sCache;
    private final android.content.res.Resources mResources;
    private final android.content.res.Resources.Theme mTheme;

    private TintContextWrapper(@android.support.annotation.NonNull android.content.Context context) {
        super(context);
        if (!android.support.v7.widget.VectorEnabledTintResources.shouldBeUsed()) {
            this.mResources = new android.support.v7.widget.TintResources(this, context.getResources());
            this.mTheme = null;
        } else {
            this.mResources = new android.support.v7.widget.VectorEnabledTintResources(this, context.getResources());
            this.mTheme = this.mResources.newTheme();
            this.mTheme.setTo(context.getTheme());
        }
    }

    private static boolean shouldWrap(@android.support.annotation.NonNull android.content.Context context) {
        if ((context instanceof android.support.v7.widget.TintContextWrapper) || (context.getResources() instanceof android.support.v7.widget.TintResources) || (context.getResources() instanceof android.support.v7.widget.VectorEnabledTintResources)) {
            return false;
        }
        return android.os.Build.VERSION.SDK_INT < 21 || android.support.v7.widget.VectorEnabledTintResources.shouldBeUsed();
    }

    public static android.content.Context wrap(@android.support.annotation.NonNull android.content.Context context) {
        if (!shouldWrap(context)) {
            return context;
        }
        synchronized (CACHE_LOCK) {
            if (sCache == null) {
                sCache = new java.util.ArrayList<>();
            } else {
                for (int size = sCache.size() - 1; size >= 0; size--) {
                    java.lang.ref.WeakReference<android.support.v7.widget.TintContextWrapper> weakReference = sCache.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        sCache.remove(size);
                    }
                }
                for (int size2 = sCache.size() - 1; size2 >= 0; size2--) {
                    java.lang.ref.WeakReference<android.support.v7.widget.TintContextWrapper> weakReference2 = sCache.get(size2);
                    android.support.v7.widget.TintContextWrapper tintContextWrapper = weakReference2 != null ? weakReference2.get() : null;
                    if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                        return tintContextWrapper;
                    }
                }
            }
            android.support.v7.widget.TintContextWrapper tintContextWrapper2 = new android.support.v7.widget.TintContextWrapper(context);
            sCache.add(new java.lang.ref.WeakReference<>(tintContextWrapper2));
            return tintContextWrapper2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.res.AssetManager getAssets() {
        return this.mResources.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.res.Resources getResources() {
        return this.mResources;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.res.Resources.Theme getTheme() {
        android.content.res.Resources.Theme theme = this.mTheme;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        android.content.res.Resources.Theme theme = this.mTheme;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
