package android.support.v7.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class ActionBar {
    public static final int DISPLAY_HOME_AS_UP = 4;
    public static final int DISPLAY_SHOW_CUSTOM = 16;
    public static final int DISPLAY_SHOW_HOME = 2;
    public static final int DISPLAY_SHOW_TITLE = 8;
    public static final int DISPLAY_USE_LOGO = 1;

    @java.lang.Deprecated
    public static final int NAVIGATION_MODE_LIST = 1;

    @java.lang.Deprecated
    public static final int NAVIGATION_MODE_STANDARD = 0;

    @java.lang.Deprecated
    public static final int NAVIGATION_MODE_TABS = 2;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface DisplayOptions {
    }

    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {
        public int gravity;

        public LayoutParams(int i) {
            this(-2, -1, i);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.gravity = 0;
            this.gravity = i3;
        }

        public LayoutParams(@android.support.annotation.NonNull android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.appcompat.R.styleable.ActionBarLayout);
            this.gravity = typedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(android.support.v7.app.ActionBar.LayoutParams layoutParams) {
            super((android.view.ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface NavigationMode {
    }

    public interface OnMenuVisibilityListener {
        void onMenuVisibilityChanged(boolean z);
    }

    @java.lang.Deprecated
    public interface OnNavigationListener {
        boolean onNavigationItemSelected(int i, long j);
    }

    @java.lang.Deprecated
    public static abstract class Tab {
        public static final int INVALID_POSITION = -1;

        public abstract java.lang.CharSequence getContentDescription();

        public abstract android.view.View getCustomView();

        public abstract android.graphics.drawable.Drawable getIcon();

        public abstract int getPosition();

        public abstract java.lang.Object getTag();

        public abstract java.lang.CharSequence getText();

        public abstract void select();

        public abstract android.support.v7.app.ActionBar.Tab setContentDescription(@android.support.annotation.StringRes int i);

        public abstract android.support.v7.app.ActionBar.Tab setContentDescription(java.lang.CharSequence charSequence);

        public abstract android.support.v7.app.ActionBar.Tab setCustomView(int i);

        public abstract android.support.v7.app.ActionBar.Tab setCustomView(android.view.View view);

        public abstract android.support.v7.app.ActionBar.Tab setIcon(@android.support.annotation.DrawableRes int i);

        public abstract android.support.v7.app.ActionBar.Tab setIcon(android.graphics.drawable.Drawable drawable);

        public abstract android.support.v7.app.ActionBar.Tab setTabListener(android.support.v7.app.ActionBar.TabListener tabListener);

        public abstract android.support.v7.app.ActionBar.Tab setTag(java.lang.Object obj);

        public abstract android.support.v7.app.ActionBar.Tab setText(int i);

        public abstract android.support.v7.app.ActionBar.Tab setText(java.lang.CharSequence charSequence);
    }

    @java.lang.Deprecated
    public interface TabListener {
        void onTabReselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction);

        void onTabSelected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction);

        void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction);
    }

    public abstract void addOnMenuVisibilityListener(android.support.v7.app.ActionBar.OnMenuVisibilityListener onMenuVisibilityListener);

    @java.lang.Deprecated
    public abstract void addTab(android.support.v7.app.ActionBar.Tab tab);

    @java.lang.Deprecated
    public abstract void addTab(android.support.v7.app.ActionBar.Tab tab, int i);

    @java.lang.Deprecated
    public abstract void addTab(android.support.v7.app.ActionBar.Tab tab, int i, boolean z);

    @java.lang.Deprecated
    public abstract void addTab(android.support.v7.app.ActionBar.Tab tab, boolean z);

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean closeOptionsMenu() {
        return false;
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean collapseActionView() {
        return false;
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void dispatchMenuVisibilityChanged(boolean z) {
    }

    public abstract android.view.View getCustomView();

    public abstract int getDisplayOptions();

    public float getElevation() {
        return 0.0f;
    }

    public abstract int getHeight();

    public int getHideOffset() {
        return 0;
    }

    @java.lang.Deprecated
    public abstract int getNavigationItemCount();

    @java.lang.Deprecated
    public abstract int getNavigationMode();

    @java.lang.Deprecated
    public abstract int getSelectedNavigationIndex();

    @android.support.annotation.Nullable
    @java.lang.Deprecated
    public abstract android.support.v7.app.ActionBar.Tab getSelectedTab();

    @android.support.annotation.Nullable
    public abstract java.lang.CharSequence getSubtitle();

    @java.lang.Deprecated
    public abstract android.support.v7.app.ActionBar.Tab getTabAt(int i);

    @java.lang.Deprecated
    public abstract int getTabCount();

    public android.content.Context getThemedContext() {
        return null;
    }

    @android.support.annotation.Nullable
    public abstract java.lang.CharSequence getTitle();

    public abstract void hide();

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean invalidateOptionsMenu() {
        return false;
    }

    public boolean isHideOnContentScrollEnabled() {
        return false;
    }

    public abstract boolean isShowing();

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isTitleTruncated() {
        return false;
    }

    @java.lang.Deprecated
    public abstract android.support.v7.app.ActionBar.Tab newTab();

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
    }

    void onDestroy() {
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean onKeyShortcut(int i, android.view.KeyEvent keyEvent) {
        return false;
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean onMenuKeyEvent(android.view.KeyEvent keyEvent) {
        return false;
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean openOptionsMenu() {
        return false;
    }

    @java.lang.Deprecated
    public abstract void removeAllTabs();

    public abstract void removeOnMenuVisibilityListener(android.support.v7.app.ActionBar.OnMenuVisibilityListener onMenuVisibilityListener);

    @java.lang.Deprecated
    public abstract void removeTab(android.support.v7.app.ActionBar.Tab tab);

    @java.lang.Deprecated
    public abstract void removeTabAt(int i);

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    boolean requestFocus() {
        return false;
    }

    @java.lang.Deprecated
    public abstract void selectTab(android.support.v7.app.ActionBar.Tab tab);

    public abstract void setBackgroundDrawable(@android.support.annotation.Nullable android.graphics.drawable.Drawable drawable);

    public abstract void setCustomView(int i);

    public abstract void setCustomView(android.view.View view);

    public abstract void setCustomView(android.view.View view, android.support.v7.app.ActionBar.LayoutParams layoutParams);

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
    }

    public abstract void setDisplayHomeAsUpEnabled(boolean z);

    public abstract void setDisplayOptions(int i);

    public abstract void setDisplayOptions(int i, int i2);

    public abstract void setDisplayShowCustomEnabled(boolean z);

    public abstract void setDisplayShowHomeEnabled(boolean z);

    public abstract void setDisplayShowTitleEnabled(boolean z);

    public abstract void setDisplayUseLogoEnabled(boolean z);

    public void setElevation(float f) {
        if (f != 0.0f) {
            throw new java.lang.UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void setHideOffset(int i) {
        if (i != 0) {
            throw new java.lang.UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
        }
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z) {
            throw new java.lang.UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public void setHomeActionContentDescription(@android.support.annotation.StringRes int i) {
    }

    public void setHomeActionContentDescription(@android.support.annotation.Nullable java.lang.CharSequence charSequence) {
    }

    public void setHomeAsUpIndicator(@android.support.annotation.DrawableRes int i) {
    }

    public void setHomeAsUpIndicator(@android.support.annotation.Nullable android.graphics.drawable.Drawable drawable) {
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public abstract void setIcon(@android.support.annotation.DrawableRes int i);

    public abstract void setIcon(android.graphics.drawable.Drawable drawable);

    @java.lang.Deprecated
    public abstract void setListNavigationCallbacks(android.widget.SpinnerAdapter spinnerAdapter, android.support.v7.app.ActionBar.OnNavigationListener onNavigationListener);

    public abstract void setLogo(@android.support.annotation.DrawableRes int i);

    public abstract void setLogo(android.graphics.drawable.Drawable drawable);

    @java.lang.Deprecated
    public abstract void setNavigationMode(int i);

    @java.lang.Deprecated
    public abstract void setSelectedNavigationItem(int i);

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void setShowHideAnimationEnabled(boolean z) {
    }

    public void setSplitBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
    }

    public abstract void setSubtitle(int i);

    public abstract void setSubtitle(java.lang.CharSequence charSequence);

    public abstract void setTitle(@android.support.annotation.StringRes int i);

    public abstract void setTitle(java.lang.CharSequence charSequence);

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void setWindowTitle(java.lang.CharSequence charSequence) {
    }

    public abstract void show();

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public android.support.v7.view.ActionMode startActionMode(android.support.v7.view.ActionMode.Callback callback) {
        return null;
    }
}
