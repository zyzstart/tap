package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class FragmentManager {
    public static final int POP_BACK_STACK_INCLUSIVE = 1;

    public interface BackStackEntry {
        java.lang.CharSequence getBreadCrumbShortTitle();

        @android.support.annotation.StringRes
        int getBreadCrumbShortTitleRes();

        java.lang.CharSequence getBreadCrumbTitle();

        @android.support.annotation.StringRes
        int getBreadCrumbTitleRes();

        int getId();

        java.lang.String getName();
    }

    public static abstract class FragmentLifecycleCallbacks {
        public void onFragmentActivityCreated(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment fragment, android.os.Bundle bundle) {
        }

        public void onFragmentAttached(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment fragment, android.content.Context context) {
        }

        public void onFragmentCreated(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment fragment, android.os.Bundle bundle) {
        }

        public void onFragmentDestroyed(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment fragment) {
        }

        public void onFragmentDetached(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment fragment) {
        }

        public void onFragmentPaused(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment fragment) {
        }

        public void onFragmentPreAttached(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment fragment, android.content.Context context) {
        }

        public void onFragmentPreCreated(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment fragment, android.os.Bundle bundle) {
        }

        public void onFragmentResumed(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment fragment, android.os.Bundle bundle) {
        }

        public void onFragmentStarted(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment fragment) {
        }

        public void onFragmentStopped(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment fragment) {
        }

        public void onFragmentViewCreated(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment fragment, android.view.View view, android.os.Bundle bundle) {
        }

        public void onFragmentViewDestroyed(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment fragment) {
        }
    }

    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }

    public static void enableDebugLogging(boolean z) {
        android.support.v4.app.FragmentManagerImpl.DEBUG = z;
    }

    public abstract void addOnBackStackChangedListener(android.support.v4.app.FragmentManager.OnBackStackChangedListener onBackStackChangedListener);

    public abstract android.support.v4.app.FragmentTransaction beginTransaction();

    public abstract void dump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr);

    public abstract boolean executePendingTransactions();

    public abstract android.support.v4.app.Fragment findFragmentById(@android.support.annotation.IdRes int i);

    public abstract android.support.v4.app.Fragment findFragmentByTag(java.lang.String str);

    public abstract android.support.v4.app.FragmentManager.BackStackEntry getBackStackEntryAt(int i);

    public abstract int getBackStackEntryCount();

    public abstract android.support.v4.app.Fragment getFragment(android.os.Bundle bundle, java.lang.String str);

    public abstract java.util.List<android.support.v4.app.Fragment> getFragments();

    public abstract android.support.v4.app.Fragment getPrimaryNavigationFragment();

    public abstract boolean isDestroyed();

    public abstract boolean isStateSaved();

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    @java.lang.Deprecated
    public android.support.v4.app.FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    public abstract void popBackStack();

    public abstract void popBackStack(int i, int i2);

    public abstract void popBackStack(java.lang.String str, int i);

    public abstract boolean popBackStackImmediate();

    public abstract boolean popBackStackImmediate(int i, int i2);

    public abstract boolean popBackStackImmediate(java.lang.String str, int i);

    public abstract void putFragment(android.os.Bundle bundle, java.lang.String str, android.support.v4.app.Fragment fragment);

    public abstract void registerFragmentLifecycleCallbacks(android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z);

    public abstract void removeOnBackStackChangedListener(android.support.v4.app.FragmentManager.OnBackStackChangedListener onBackStackChangedListener);

    public abstract android.support.v4.app.Fragment.SavedState saveFragmentInstanceState(android.support.v4.app.Fragment fragment);

    public abstract void unregisterFragmentLifecycleCallbacks(android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks);
}
