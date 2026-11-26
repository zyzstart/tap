package android.support.v7.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class AppCompatDelegate {
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_SUPPORT_ACTION_BAR = 108;
    public static final int FEATURE_SUPPORT_ACTION_BAR_OVERLAY = 109;
    public static final int MODE_NIGHT_AUTO = 0;
    public static final int MODE_NIGHT_FOLLOW_SYSTEM = -1;
    public static final int MODE_NIGHT_NO = 1;
    static final int MODE_NIGHT_UNSPECIFIED = -100;
    public static final int MODE_NIGHT_YES = 2;
    static final java.lang.String TAG = "AppCompatDelegate";
    private static boolean sCompatVectorFromResourcesEnabled = false;
    private static int sDefaultNightMode = -1;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @interface ApplyableNightMode {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface NightMode {
    }

    AppCompatDelegate() {
    }

    public static android.support.v7.app.AppCompatDelegate create(android.app.Activity activity, android.support.v7.app.AppCompatCallback appCompatCallback) {
        return create(activity, activity.getWindow(), appCompatCallback);
    }

    public static android.support.v7.app.AppCompatDelegate create(android.app.Dialog dialog, android.support.v7.app.AppCompatCallback appCompatCallback) {
        return create(dialog.getContext(), dialog.getWindow(), appCompatCallback);
    }

    private static android.support.v7.app.AppCompatDelegate create(android.content.Context context, android.view.Window window, android.support.v7.app.AppCompatCallback appCompatCallback) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return new android.support.v7.app.AppCompatDelegateImplN(context, window, appCompatCallback);
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return new android.support.v7.app.AppCompatDelegateImplV23(context, window, appCompatCallback);
        }
        if (android.os.Build.VERSION.SDK_INT >= 14) {
            return new android.support.v7.app.AppCompatDelegateImplV14(context, window, appCompatCallback);
        }
        return android.os.Build.VERSION.SDK_INT >= 11 ? new android.support.v7.app.AppCompatDelegateImplV11(context, window, appCompatCallback) : new android.support.v7.app.AppCompatDelegateImplV9(context, window, appCompatCallback);
    }

    public static int getDefaultNightMode() {
        return sDefaultNightMode;
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return sCompatVectorFromResourcesEnabled;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean z) {
        sCompatVectorFromResourcesEnabled = z;
    }

    public static void setDefaultNightMode(int i) {
        switch (i) {
            case -1:
            case 0:
            case 1:
            case 2:
                sDefaultNightMode = i;
                break;
            default:
                android.util.Log.d(TAG, "setDefaultNightMode() called with an unknown mode");
                break;
        }
    }

    public abstract void addContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams);

    public abstract boolean applyDayNight();

    public abstract android.view.View createView(@android.support.annotation.Nullable android.view.View view, java.lang.String str, @android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull android.util.AttributeSet attributeSet);

    @android.support.annotation.Nullable
    public abstract <T extends android.view.View> T findViewById(@android.support.annotation.IdRes int i);

    @android.support.annotation.Nullable
    public abstract android.support.v7.app.ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

    public abstract android.view.MenuInflater getMenuInflater();

    @android.support.annotation.Nullable
    public abstract android.support.v7.app.ActionBar getSupportActionBar();

    public abstract boolean hasWindowFeature(int i);

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract boolean isHandleNativeActionModesEnabled();

    public abstract void onConfigurationChanged(android.content.res.Configuration configuration);

    public abstract void onCreate(android.os.Bundle bundle);

    public abstract void onDestroy();

    public abstract void onPostCreate(android.os.Bundle bundle);

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(android.os.Bundle bundle);

    public abstract void onStart();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int i);

    public abstract void setContentView(@android.support.annotation.LayoutRes int i);

    public abstract void setContentView(android.view.View view);

    public abstract void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams);

    public abstract void setHandleNativeActionModesEnabled(boolean z);

    public abstract void setLocalNightMode(int i);

    public abstract void setSupportActionBar(@android.support.annotation.Nullable android.support.v7.widget.Toolbar toolbar);

    public abstract void setTitle(@android.support.annotation.Nullable java.lang.CharSequence charSequence);

    @android.support.annotation.Nullable
    public abstract android.support.v7.view.ActionMode startSupportActionMode(@android.support.annotation.NonNull android.support.v7.view.ActionMode.Callback callback);
}
