package android.support.v4.content;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ContextCompat {
    private static final java.lang.String TAG = "ContextCompat";
    private static final java.lang.Object sLock = new java.lang.Object();
    private static android.util.TypedValue sTempValue;

    protected ContextCompat() {
    }

    private static java.io.File buildPath(java.io.File file, java.lang.String... strArr) {
        for (java.lang.String str : strArr) {
            if (file == null) {
                file = new java.io.File(str);
            } else if (str != null) {
                file = new java.io.File(file, str);
            }
        }
        return file;
    }

    public static int checkSelfPermission(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull java.lang.String str) {
        if (str != null) {
            return context.checkPermission(str, android.os.Process.myPid(), android.os.Process.myUid());
        }
        throw new java.lang.IllegalArgumentException("permission is null");
    }

    public static android.content.Context createDeviceProtectedStorageContext(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext();
        }
        return null;
    }

    private static synchronized java.io.File createFilesDir(java.io.File file) {
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        if (file.exists()) {
            return file;
        }
        android.util.Log.w(TAG, "Unable to create files subdir " + file.getPath());
        return null;
    }

    public static java.io.File getCodeCacheDir(android.content.Context context) {
        return android.os.Build.VERSION.SDK_INT >= 21 ? context.getCodeCacheDir() : createFilesDir(new java.io.File(context.getApplicationInfo().dataDir, "code_cache"));
    }

    @android.support.annotation.ColorInt
    public static final int getColor(android.content.Context context, @android.support.annotation.ColorRes int i) {
        return android.os.Build.VERSION.SDK_INT >= 23 ? context.getColor(i) : context.getResources().getColor(i);
    }

    public static final android.content.res.ColorStateList getColorStateList(android.content.Context context, @android.support.annotation.ColorRes int i) {
        return android.os.Build.VERSION.SDK_INT >= 23 ? context.getColorStateList(i) : context.getResources().getColorStateList(i);
    }

    public static java.io.File getDataDir(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return context.getDataDir();
        }
        java.lang.String str = context.getApplicationInfo().dataDir;
        if (str != null) {
            return new java.io.File(str);
        }
        return null;
    }

    public static final android.graphics.drawable.Drawable getDrawable(android.content.Context context, @android.support.annotation.DrawableRes int i) {
        int i2;
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (sLock) {
            if (sTempValue == null) {
                sTempValue = new android.util.TypedValue();
            }
            context.getResources().getValue(i, sTempValue, true);
            i2 = sTempValue.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    public static java.io.File[] getExternalCacheDirs(android.content.Context context) {
        return android.os.Build.VERSION.SDK_INT >= 19 ? context.getExternalCacheDirs() : new java.io.File[]{context.getExternalCacheDir()};
    }

    public static java.io.File[] getExternalFilesDirs(android.content.Context context, java.lang.String str) {
        return android.os.Build.VERSION.SDK_INT >= 19 ? context.getExternalFilesDirs(str) : new java.io.File[]{context.getExternalFilesDir(str)};
    }

    public static final java.io.File getNoBackupFilesDir(android.content.Context context) {
        return android.os.Build.VERSION.SDK_INT >= 21 ? context.getNoBackupFilesDir() : createFilesDir(new java.io.File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    public static java.io.File[] getObbDirs(android.content.Context context) {
        return android.os.Build.VERSION.SDK_INT >= 19 ? context.getObbDirs() : new java.io.File[]{context.getObbDir()};
    }

    public static boolean isDeviceProtectedStorage(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return context.isDeviceProtectedStorage();
        }
        return false;
    }

    public static boolean startActivities(android.content.Context context, android.content.Intent[] intentArr) {
        return startActivities(context, intentArr, null);
    }

    public static boolean startActivities(android.content.Context context, android.content.Intent[] intentArr, android.os.Bundle bundle) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, bundle);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }

    public static void startActivity(android.content.Context context, android.content.Intent intent, @android.support.annotation.Nullable android.os.Bundle bundle) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            context.startActivity(intent, bundle);
        } else {
            context.startActivity(intent);
        }
    }

    public static void startForegroundService(android.content.Context context, android.content.Intent intent) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}
