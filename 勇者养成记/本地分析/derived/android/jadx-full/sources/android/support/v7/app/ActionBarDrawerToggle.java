package android.support.v7.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ActionBarDrawerToggle implements android.support.v4.widget.DrawerLayout.DrawerListener {
    private final android.support.v7.app.ActionBarDrawerToggle.Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    boolean mDrawerIndicatorEnabled;
    private final android.support.v4.widget.DrawerLayout mDrawerLayout;
    private boolean mDrawerSlideAnimationEnabled;
    private boolean mHasCustomUpIndicator;
    private android.graphics.drawable.Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private android.support.v7.graphics.drawable.DrawerArrowDrawable mSlider;
    android.view.View.OnClickListener mToolbarNavigationClickListener;
    private boolean mWarnedForDisplayHomeAsUp;

    public interface Delegate {
        android.content.Context getActionBarThemedContext();

        android.graphics.drawable.Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(@android.support.annotation.StringRes int i);

        void setActionBarUpIndicator(android.graphics.drawable.Drawable drawable, @android.support.annotation.StringRes int i);
    }

    public interface DelegateProvider {
        @android.support.annotation.Nullable
        android.support.v7.app.ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
    }

    static class DummyDelegate implements android.support.v7.app.ActionBarDrawerToggle.Delegate {
        final android.app.Activity mActivity;

        DummyDelegate(android.app.Activity activity) {
            this.mActivity = activity;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public android.content.Context getActionBarThemedContext() {
            return this.mActivity;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public android.graphics.drawable.Drawable getThemeUpIndicator() {
            return null;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            return true;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(@android.support.annotation.StringRes int i) {
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(android.graphics.drawable.Drawable drawable, @android.support.annotation.StringRes int i) {
        }
    }

    @android.support.annotation.RequiresApi(11)
    private static class HoneycombDelegate implements android.support.v7.app.ActionBarDrawerToggle.Delegate {
        final android.app.Activity mActivity;
        android.support.v7.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;

        HoneycombDelegate(android.app.Activity activity) {
            this.mActivity = activity;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public android.content.Context getActionBarThemedContext() {
            return this.mActivity;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public android.graphics.drawable.Drawable getThemeUpIndicator() {
            return android.support.v7.app.ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.mActivity);
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i) {
            this.mSetIndicatorInfo = android.support.v7.app.ActionBarDrawerToggleHoneycomb.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, i);
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(android.graphics.drawable.Drawable drawable, int i) {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                actionBar.setDisplayShowHomeEnabled(true);
                this.mSetIndicatorInfo = android.support.v7.app.ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, drawable, i);
                actionBar.setDisplayShowHomeEnabled(false);
            }
        }
    }

    @android.support.annotation.RequiresApi(14)
    private static class IcsDelegate extends android.support.v7.app.ActionBarDrawerToggle.HoneycombDelegate {
        IcsDelegate(android.app.Activity activity) {
            super(activity);
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.HoneycombDelegate, android.support.v7.app.ActionBarDrawerToggle.Delegate
        public android.content.Context getActionBarThemedContext() {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            return actionBar != null ? actionBar.getThemedContext() : this.mActivity;
        }
    }

    @android.support.annotation.RequiresApi(18)
    private static class JellybeanMr2Delegate implements android.support.v7.app.ActionBarDrawerToggle.Delegate {
        final android.app.Activity mActivity;

        JellybeanMr2Delegate(android.app.Activity activity) {
            this.mActivity = activity;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public android.content.Context getActionBarThemedContext() {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            return actionBar != null ? actionBar.getThemedContext() : this.mActivity;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public android.graphics.drawable.Drawable getThemeUpIndicator() {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getActionBarThemedContext().obtainStyledAttributes(null, new int[]{android.R.attr.homeAsUpIndicator}, android.R.attr.actionBarStyle, 0);
            android.graphics.drawable.Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            typedArrayObtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i) {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i);
            }
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(android.graphics.drawable.Drawable drawable, int i) {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i);
            }
        }
    }

    static class ToolbarCompatDelegate implements android.support.v7.app.ActionBarDrawerToggle.Delegate {
        final java.lang.CharSequence mDefaultContentDescription;
        final android.graphics.drawable.Drawable mDefaultUpIndicator;
        final android.support.v7.widget.Toolbar mToolbar;

        ToolbarCompatDelegate(android.support.v7.widget.Toolbar toolbar) {
            this.mToolbar = toolbar;
            this.mDefaultUpIndicator = toolbar.getNavigationIcon();
            this.mDefaultContentDescription = toolbar.getNavigationContentDescription();
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public android.content.Context getActionBarThemedContext() {
            return this.mToolbar.getContext();
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public android.graphics.drawable.Drawable getThemeUpIndicator() {
            return this.mDefaultUpIndicator;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            return true;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(@android.support.annotation.StringRes int i) {
            if (i == 0) {
                this.mToolbar.setNavigationContentDescription(this.mDefaultContentDescription);
            } else {
                this.mToolbar.setNavigationContentDescription(i);
            }
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(android.graphics.drawable.Drawable drawable, @android.support.annotation.StringRes int i) {
            this.mToolbar.setNavigationIcon(drawable);
            setActionBarDescription(i);
        }
    }

    public ActionBarDrawerToggle(android.app.Activity activity, android.support.v4.widget.DrawerLayout drawerLayout, @android.support.annotation.StringRes int i, @android.support.annotation.StringRes int i2) {
        this(activity, null, drawerLayout, null, i, i2);
    }

    public ActionBarDrawerToggle(android.app.Activity activity, android.support.v4.widget.DrawerLayout drawerLayout, android.support.v7.widget.Toolbar toolbar, @android.support.annotation.StringRes int i, @android.support.annotation.StringRes int i2) {
        this(activity, toolbar, drawerLayout, null, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    ActionBarDrawerToggle(android.app.Activity activity, android.support.v7.widget.Toolbar toolbar, android.support.v4.widget.DrawerLayout drawerLayout, android.support.v7.graphics.drawable.DrawerArrowDrawable drawerArrowDrawable, @android.support.annotation.StringRes int i, @android.support.annotation.StringRes int i2) {
        this.mDrawerSlideAnimationEnabled = true;
        this.mDrawerIndicatorEnabled = true;
        this.mWarnedForDisplayHomeAsUp = false;
        if (toolbar != null) {
            this.mActivityImpl = new android.support.v7.app.ActionBarDrawerToggle.ToolbarCompatDelegate(toolbar);
            toolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() { // from class: android.support.v7.app.ActionBarDrawerToggle.1
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    if (android.support.v7.app.ActionBarDrawerToggle.this.mDrawerIndicatorEnabled) {
                        android.support.v7.app.ActionBarDrawerToggle.this.toggle();
                    } else if (android.support.v7.app.ActionBarDrawerToggle.this.mToolbarNavigationClickListener != null) {
                        android.support.v7.app.ActionBarDrawerToggle.this.mToolbarNavigationClickListener.onClick(view);
                    }
                }
            });
        } else if (activity instanceof android.support.v7.app.ActionBarDrawerToggle.DelegateProvider) {
            this.mActivityImpl = ((android.support.v7.app.ActionBarDrawerToggle.DelegateProvider) activity).getDrawerToggleDelegate();
        } else if (android.os.Build.VERSION.SDK_INT >= 18) {
            this.mActivityImpl = new android.support.v7.app.ActionBarDrawerToggle.JellybeanMr2Delegate(activity);
        } else if (android.os.Build.VERSION.SDK_INT >= 14) {
            this.mActivityImpl = new android.support.v7.app.ActionBarDrawerToggle.IcsDelegate(activity);
        } else if (android.os.Build.VERSION.SDK_INT >= 11) {
            this.mActivityImpl = new android.support.v7.app.ActionBarDrawerToggle.HoneycombDelegate(activity);
        } else {
            this.mActivityImpl = new android.support.v7.app.ActionBarDrawerToggle.DummyDelegate(activity);
        }
        this.mDrawerLayout = drawerLayout;
        this.mOpenDrawerContentDescRes = i;
        this.mCloseDrawerContentDescRes = i2;
        if (drawerArrowDrawable == null) {
            this.mSlider = new android.support.v7.graphics.drawable.DrawerArrowDrawable(this.mActivityImpl.getActionBarThemedContext());
        } else {
            this.mSlider = drawerArrowDrawable;
        }
        this.mHomeAsUpIndicator = getThemeUpIndicator();
    }

    private void setPosition(float f) {
        if (f == 1.0f) {
            this.mSlider.setVerticalMirror(true);
        } else if (f == 0.0f) {
            this.mSlider.setVerticalMirror(false);
        }
        this.mSlider.setProgress(f);
    }

    @android.support.annotation.NonNull
    public android.support.v7.graphics.drawable.DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.mSlider;
    }

    android.graphics.drawable.Drawable getThemeUpIndicator() {
        return this.mActivityImpl.getThemeUpIndicator();
    }

    public android.view.View.OnClickListener getToolbarNavigationClickListener() {
        return this.mToolbarNavigationClickListener;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public boolean isDrawerSlideAnimationEnabled() {
        return this.mDrawerSlideAnimationEnabled;
    }

    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        if (!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
        }
        syncState();
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(android.view.View view) {
        setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(android.view.View view) {
        setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(android.view.View view, float f) {
        if (this.mDrawerSlideAnimationEnabled) {
            setPosition(java.lang.Math.min(1.0f, java.lang.Math.max(0.0f, f)));
        } else {
            setPosition(0.0f);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
    }

    public boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.mDrawerIndicatorEnabled) {
            return false;
        }
        toggle();
        return true;
    }

    void setActionBarDescription(int i) {
        this.mActivityImpl.setActionBarDescription(i);
    }

    void setActionBarUpIndicator(android.graphics.drawable.Drawable drawable, int i) {
        if (!this.mWarnedForDisplayHomeAsUp && !this.mActivityImpl.isNavigationVisible()) {
            android.util.Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.mWarnedForDisplayHomeAsUp = true;
        }
        this.mActivityImpl.setActionBarUpIndicator(drawable, i);
    }

    public void setDrawerArrowDrawable(@android.support.annotation.NonNull android.support.v7.graphics.drawable.DrawerArrowDrawable drawerArrowDrawable) {
        this.mSlider = drawerArrowDrawable;
        syncState();
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.mDrawerIndicatorEnabled) {
            if (z) {
                setActionBarUpIndicator(this.mSlider, this.mDrawerLayout.isDrawerOpen(android.support.v4.view.GravityCompat.START) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes);
            } else {
                setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
            }
            this.mDrawerIndicatorEnabled = z;
        }
    }

    public void setDrawerSlideAnimationEnabled(boolean z) {
        this.mDrawerSlideAnimationEnabled = z;
        if (z) {
            return;
        }
        setPosition(0.0f);
    }

    public void setHomeAsUpIndicator(int i) {
        setHomeAsUpIndicator(i != 0 ? this.mDrawerLayout.getResources().getDrawable(i) : null);
    }

    public void setHomeAsUpIndicator(android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
            this.mHasCustomUpIndicator = false;
        } else {
            this.mHomeAsUpIndicator = drawable;
            this.mHasCustomUpIndicator = true;
        }
        if (this.mDrawerIndicatorEnabled) {
            return;
        }
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
    }

    public void setToolbarNavigationClickListener(android.view.View.OnClickListener onClickListener) {
        this.mToolbarNavigationClickListener = onClickListener;
    }

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(android.support.v4.view.GravityCompat.START)) {
            setPosition(1.0f);
        } else {
            setPosition(0.0f);
        }
        if (this.mDrawerIndicatorEnabled) {
            setActionBarUpIndicator(this.mSlider, this.mDrawerLayout.isDrawerOpen(android.support.v4.view.GravityCompat.START) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes);
        }
    }

    void toggle() {
        int drawerLockMode = this.mDrawerLayout.getDrawerLockMode(android.support.v4.view.GravityCompat.START);
        if (this.mDrawerLayout.isDrawerVisible(android.support.v4.view.GravityCompat.START) && drawerLockMode != 2) {
            this.mDrawerLayout.closeDrawer(android.support.v4.view.GravityCompat.START);
        } else if (drawerLockMode != 1) {
            this.mDrawerLayout.openDrawer(android.support.v4.view.GravityCompat.START);
        }
    }
}
