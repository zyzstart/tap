package android.support.v7.content.res;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class AppCompatResources {
    private static final java.lang.String LOG_TAG = "AppCompatResources";
    private static final java.lang.ThreadLocal<android.util.TypedValue> TL_TYPED_VALUE = new java.lang.ThreadLocal<>();
    private static final java.util.WeakHashMap<android.content.Context, android.util.SparseArray<android.support.v7.content.res.AppCompatResources.ColorStateListCacheEntry>> sColorStateCaches = new java.util.WeakHashMap<>(0);
    private static final java.lang.Object sColorStateCacheLock = new java.lang.Object();

    private static class ColorStateListCacheEntry {
        final android.content.res.Configuration configuration;
        final android.content.res.ColorStateList value;

        ColorStateListCacheEntry(@android.support.annotation.NonNull android.content.res.ColorStateList colorStateList, @android.support.annotation.NonNull android.content.res.Configuration configuration) {
            this.value = colorStateList;
            this.configuration = configuration;
        }
    }

    private AppCompatResources() {
    }

    private static void addColorStateListToCache(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.ColorRes int i, @android.support.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        synchronized (sColorStateCacheLock) {
            android.util.SparseArray<android.support.v7.content.res.AppCompatResources.ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(context);
            if (sparseArray == null) {
                sparseArray = new android.util.SparseArray<>();
                sColorStateCaches.put(context, sparseArray);
            }
            sparseArray.append(i, new android.support.v7.content.res.AppCompatResources.ColorStateListCacheEntry(colorStateList, context.getResources().getConfiguration()));
        }
    }

    @android.support.annotation.Nullable
    private static android.content.res.ColorStateList getCachedColorStateList(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.ColorRes int i) {
        android.support.v7.content.res.AppCompatResources.ColorStateListCacheEntry colorStateListCacheEntry;
        synchronized (sColorStateCacheLock) {
            android.util.SparseArray<android.support.v7.content.res.AppCompatResources.ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (colorStateListCacheEntry = sparseArray.get(i)) != null) {
                if (colorStateListCacheEntry.configuration.equals(context.getResources().getConfiguration())) {
                    return colorStateListCacheEntry.value;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    public static android.content.res.ColorStateList getColorStateList(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.ColorRes int i) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        android.content.res.ColorStateList cachedColorStateList = getCachedColorStateList(context, i);
        if (cachedColorStateList != null) {
            return cachedColorStateList;
        }
        android.content.res.ColorStateList colorStateListInflateColorStateList = inflateColorStateList(context, i);
        if (colorStateListInflateColorStateList == null) {
            return android.support.v4.content.ContextCompat.getColorStateList(context, i);
        }
        addColorStateListToCache(context, i, colorStateListInflateColorStateList);
        return colorStateListInflateColorStateList;
    }

    @android.support.annotation.Nullable
    public static android.graphics.drawable.Drawable getDrawable(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.DrawableRes int i) {
        return android.support.v7.widget.AppCompatDrawableManager.get().getDrawable(context, i);
    }

    @android.support.annotation.NonNull
    private static android.util.TypedValue getTypedValue() {
        android.util.TypedValue typedValue = TL_TYPED_VALUE.get();
        if (typedValue != null) {
            return typedValue;
        }
        android.util.TypedValue typedValue2 = new android.util.TypedValue();
        TL_TYPED_VALUE.set(typedValue2);
        return typedValue2;
    }

    @android.support.annotation.Nullable
    private static android.content.res.ColorStateList inflateColorStateList(android.content.Context context, int i) {
        if (isColorInt(context, i)) {
            return null;
        }
        android.content.res.Resources resources = context.getResources();
        try {
            return android.support.v7.content.res.AppCompatColorStateListInflater.createFromXml(resources, resources.getXml(i), context.getTheme());
        } catch (java.lang.Exception e) {
            android.util.Log.e(LOG_TAG, "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    private static boolean isColorInt(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.ColorRes int i) {
        android.content.res.Resources resources = context.getResources();
        android.util.TypedValue typedValue = getTypedValue();
        resources.getValue(i, typedValue, true);
        return typedValue.type >= 28 && typedValue.type <= 31;
    }
}
