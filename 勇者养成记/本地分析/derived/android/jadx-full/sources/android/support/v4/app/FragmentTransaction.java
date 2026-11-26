package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class FragmentTransaction {
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    private @interface Transit {
    }

    public abstract android.support.v4.app.FragmentTransaction add(@android.support.annotation.IdRes int i, android.support.v4.app.Fragment fragment);

    public abstract android.support.v4.app.FragmentTransaction add(@android.support.annotation.IdRes int i, android.support.v4.app.Fragment fragment, @android.support.annotation.Nullable java.lang.String str);

    public abstract android.support.v4.app.FragmentTransaction add(android.support.v4.app.Fragment fragment, java.lang.String str);

    public abstract android.support.v4.app.FragmentTransaction addSharedElement(android.view.View view, java.lang.String str);

    public abstract android.support.v4.app.FragmentTransaction addToBackStack(@android.support.annotation.Nullable java.lang.String str);

    public abstract android.support.v4.app.FragmentTransaction attach(android.support.v4.app.Fragment fragment);

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    public abstract android.support.v4.app.FragmentTransaction detach(android.support.v4.app.Fragment fragment);

    public abstract android.support.v4.app.FragmentTransaction disallowAddToBackStack();

    public abstract android.support.v4.app.FragmentTransaction hide(android.support.v4.app.Fragment fragment);

    public abstract boolean isAddToBackStackAllowed();

    public abstract boolean isEmpty();

    public abstract android.support.v4.app.FragmentTransaction remove(android.support.v4.app.Fragment fragment);

    public abstract android.support.v4.app.FragmentTransaction replace(@android.support.annotation.IdRes int i, android.support.v4.app.Fragment fragment);

    public abstract android.support.v4.app.FragmentTransaction replace(@android.support.annotation.IdRes int i, android.support.v4.app.Fragment fragment, @android.support.annotation.Nullable java.lang.String str);

    public abstract android.support.v4.app.FragmentTransaction runOnCommit(java.lang.Runnable runnable);

    @java.lang.Deprecated
    public abstract android.support.v4.app.FragmentTransaction setAllowOptimization(boolean z);

    public abstract android.support.v4.app.FragmentTransaction setBreadCrumbShortTitle(@android.support.annotation.StringRes int i);

    public abstract android.support.v4.app.FragmentTransaction setBreadCrumbShortTitle(java.lang.CharSequence charSequence);

    public abstract android.support.v4.app.FragmentTransaction setBreadCrumbTitle(@android.support.annotation.StringRes int i);

    public abstract android.support.v4.app.FragmentTransaction setBreadCrumbTitle(java.lang.CharSequence charSequence);

    public abstract android.support.v4.app.FragmentTransaction setCustomAnimations(@android.support.annotation.AnimRes @android.support.annotation.AnimatorRes int i, @android.support.annotation.AnimRes @android.support.annotation.AnimatorRes int i2);

    public abstract android.support.v4.app.FragmentTransaction setCustomAnimations(@android.support.annotation.AnimRes @android.support.annotation.AnimatorRes int i, @android.support.annotation.AnimRes @android.support.annotation.AnimatorRes int i2, @android.support.annotation.AnimRes @android.support.annotation.AnimatorRes int i3, @android.support.annotation.AnimRes @android.support.annotation.AnimatorRes int i4);

    public abstract android.support.v4.app.FragmentTransaction setPrimaryNavigationFragment(android.support.v4.app.Fragment fragment);

    public abstract android.support.v4.app.FragmentTransaction setReorderingAllowed(boolean z);

    public abstract android.support.v4.app.FragmentTransaction setTransition(int i);

    public abstract android.support.v4.app.FragmentTransaction setTransitionStyle(@android.support.annotation.StyleRes int i);

    public abstract android.support.v4.app.FragmentTransaction show(android.support.v4.app.Fragment fragment);
}
