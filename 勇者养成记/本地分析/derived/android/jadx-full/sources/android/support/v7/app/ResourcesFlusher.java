package android.support.v7.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class ResourcesFlusher {
    private static final java.lang.String TAG = "ResourcesFlusher";
    private static java.lang.reflect.Field sDrawableCacheField;
    private static boolean sDrawableCacheFieldFetched;
    private static java.lang.reflect.Field sResourcesImplField;
    private static boolean sResourcesImplFieldFetched;
    private static java.lang.Class sThemedResourceCacheClazz;
    private static boolean sThemedResourceCacheClazzFetched;
    private static java.lang.reflect.Field sThemedResourceCache_mUnthemedEntriesField;
    private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    ResourcesFlusher() {
    }

    static boolean flush(@android.support.annotation.NonNull android.content.res.Resources resources) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return flushNougats(resources);
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return flushMarshmallows(resources);
        }
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return flushLollipops(resources);
        }
        return false;
    }

    @android.support.annotation.RequiresApi(21)
    private static boolean flushLollipops(@android.support.annotation.NonNull android.content.res.Resources resources) {
        java.util.Map map;
        if (!sDrawableCacheFieldFetched) {
            try {
                sDrawableCacheField = android.content.res.Resources.class.getDeclaredField("mDrawableCache");
                sDrawableCacheField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException e) {
                android.util.Log.e(TAG, "Could not retrieve Resources#mDrawableCache field", e);
            }
            sDrawableCacheFieldFetched = true;
        }
        java.lang.reflect.Field field = sDrawableCacheField;
        if (field == null) {
            return false;
        }
        try {
            map = (java.util.Map) field.get(resources);
        } catch (java.lang.IllegalAccessException e2) {
            android.util.Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e2);
            map = null;
        }
        if (map == null) {
            return false;
        }
        map.clear();
        return true;
    }

    @android.support.annotation.RequiresApi(23)
    private static boolean flushMarshmallows(@android.support.annotation.NonNull android.content.res.Resources resources) {
        if (!sDrawableCacheFieldFetched) {
            try {
                sDrawableCacheField = android.content.res.Resources.class.getDeclaredField("mDrawableCache");
                sDrawableCacheField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException e) {
                android.util.Log.e(TAG, "Could not retrieve Resources#mDrawableCache field", e);
            }
            sDrawableCacheFieldFetched = true;
        }
        java.lang.Object obj = null;
        java.lang.reflect.Field field = sDrawableCacheField;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (java.lang.IllegalAccessException e2) {
                android.util.Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e2);
            }
        }
        return (obj == null || obj == null || !flushThemedResourcesCache(obj)) ? false : true;
    }

    @android.support.annotation.RequiresApi(24)
    private static boolean flushNougats(@android.support.annotation.NonNull android.content.res.Resources resources) {
        java.lang.Object obj;
        if (!sResourcesImplFieldFetched) {
            try {
                sResourcesImplField = android.content.res.Resources.class.getDeclaredField("mResourcesImpl");
                sResourcesImplField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException e) {
                android.util.Log.e(TAG, "Could not retrieve Resources#mResourcesImpl field", e);
            }
            sResourcesImplFieldFetched = true;
        }
        java.lang.reflect.Field field = sResourcesImplField;
        if (field == null) {
            return false;
        }
        java.lang.Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (java.lang.IllegalAccessException e2) {
            android.util.Log.e(TAG, "Could not retrieve value from Resources#mResourcesImpl", e2);
            obj = null;
        }
        if (obj == null) {
            return false;
        }
        if (!sDrawableCacheFieldFetched) {
            try {
                sDrawableCacheField = obj.getClass().getDeclaredField("mDrawableCache");
                sDrawableCacheField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException e3) {
                android.util.Log.e(TAG, "Could not retrieve ResourcesImpl#mDrawableCache field", e3);
            }
            sDrawableCacheFieldFetched = true;
        }
        java.lang.reflect.Field field2 = sDrawableCacheField;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (java.lang.IllegalAccessException e4) {
                android.util.Log.e(TAG, "Could not retrieve value from ResourcesImpl#mDrawableCache", e4);
            }
        }
        return obj2 != null && flushThemedResourcesCache(obj2);
    }

    @android.support.annotation.RequiresApi(16)
    private static boolean flushThemedResourcesCache(@android.support.annotation.NonNull java.lang.Object obj) {
        android.util.LongSparseArray longSparseArray;
        if (!sThemedResourceCacheClazzFetched) {
            try {
                sThemedResourceCacheClazz = java.lang.Class.forName("android.content.res.ThemedResourceCache");
            } catch (java.lang.ClassNotFoundException e) {
                android.util.Log.e(TAG, "Could not find ThemedResourceCache class", e);
            }
            sThemedResourceCacheClazzFetched = true;
        }
        java.lang.Class cls = sThemedResourceCacheClazz;
        if (cls == null) {
            return false;
        }
        if (!sThemedResourceCache_mUnthemedEntriesFieldFetched) {
            try {
                sThemedResourceCache_mUnthemedEntriesField = cls.getDeclaredField("mUnthemedEntries");
                sThemedResourceCache_mUnthemedEntriesField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException e2) {
                android.util.Log.e(TAG, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
        }
        java.lang.reflect.Field field = sThemedResourceCache_mUnthemedEntriesField;
        if (field == null) {
            return false;
        }
        try {
            longSparseArray = (android.util.LongSparseArray) field.get(obj);
        } catch (java.lang.IllegalAccessException e3) {
            android.util.Log.e(TAG, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
            longSparseArray = null;
        }
        if (longSparseArray == null) {
            return false;
        }
        longSparseArray.clear();
        return true;
    }
}
