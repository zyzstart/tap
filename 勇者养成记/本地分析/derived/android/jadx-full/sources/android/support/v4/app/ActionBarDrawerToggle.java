package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@java.lang.Deprecated
public class ActionBarDrawerToggle implements android.support.v4.widget.DrawerLayout.DrawerListener {
    private static final int ID_HOME = 16908332;
    private static final java.lang.String TAG = "ActionBarDrawerToggle";
    private static final int[] THEME_ATTRS = {android.R.attr.homeAsUpIndicator};
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334f;
    final android.app.Activity mActivity;
    private final android.support.v4.app.ActionBarDrawerToggle.Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private android.graphics.drawable.Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final android.support.v4.widget.DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private android.graphics.drawable.Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private android.support.v4.app.ActionBarDrawerToggle.SetIndicatorInfo mSetIndicatorInfo;
    private android.support.v4.app.ActionBarDrawerToggle.SlideDrawable mSlider;

    @java.lang.Deprecated
    public interface Delegate {
        @android.support.annotation.Nullable
        android.graphics.drawable.Drawable getThemeUpIndicator();

        void setActionBarDescription(@android.support.annotation.StringRes int i);

        void setActionBarUpIndicator(android.graphics.drawable.Drawable drawable, @android.support.annotation.StringRes int i);
    }

    @java.lang.Deprecated
    public interface DelegateProvider {
        @android.support.annotation.Nullable
        android.support.v4.app.ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
    }

    private static class SetIndicatorInfo {
        java.lang.reflect.Method mSetHomeActionContentDescription;
        java.lang.reflect.Method mSetHomeAsUpIndicator;
        android.widget.ImageView mUpIndicatorView;

        SetIndicatorInfo(android.app.Activity activity) {
            try {
                this.mSetHomeAsUpIndicator = android.app.ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", android.graphics.drawable.Drawable.class);
                this.mSetHomeActionContentDescription = android.app.ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", java.lang.Integer.TYPE);
            } catch (java.lang.NoSuchMethodException unused) {
                android.view.View viewFindViewById = activity.findViewById(16908332);
                if (viewFindViewById == null) {
                    return;
                }
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) viewFindViewById.getParent();
                if (viewGroup.getChildCount() != 2) {
                    return;
                }
                android.view.View childAt = viewGroup.getChildAt(0);
                android.view.View childAt2 = childAt.getId() != 16908332 ? childAt : viewGroup.getChildAt(1);
                if (childAt2 instanceof android.widget.ImageView) {
                    this.mUpIndicatorView = (android.widget.ImageView) childAt2;
                }
            }
        }
    }

    private class SlideDrawable extends android.graphics.drawable.InsetDrawable implements android.graphics.drawable.Drawable.Callback {
        private final boolean mHasMirroring;
        private float mOffset;
        private float mPosition;
        private final android.graphics.Rect mTmpRect;

        SlideDrawable(android.graphics.drawable.Drawable drawable) {
            super(drawable, 0);
            this.mHasMirroring = android.os.Build.VERSION.SDK_INT > 18;
            this.mTmpRect = new android.graphics.Rect();
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(@android.support.annotation.NonNull android.graphics.Canvas canvas) {
            copyBounds(this.mTmpRect);
            canvas.save();
            boolean z = android.support.v4.view.ViewCompat.getLayoutDirection(android.support.v4.app.ActionBarDrawerToggle.this.mActivity.getWindow().getDecorView()) == 1;
            int i = z ? -1 : 1;
            float fWidth = this.mTmpRect.width();
            canvas.translate((-this.mOffset) * fWidth * this.mPosition * i, 0.0f);
            if (z && !this.mHasMirroring) {
                canvas.translate(fWidth, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }

        public float getPosition() {
            return this.mPosition;
        }

        public void setOffset(float f) {
            this.mOffset = f;
            invalidateSelf();
        }

        public void setPosition(float f) {
            this.mPosition = f;
            invalidateSelf();
        }
    }

    public ActionBarDrawerToggle(android.app.Activity activity, android.support.v4.widget.DrawerLayout drawerLayout, @android.support.annotation.DrawableRes int i, @android.support.annotation.StringRes int i2, @android.support.annotation.StringRes int i3) {
        this(activity, drawerLayout, !assumeMaterial(activity), i, i2, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionBarDrawerToggle(android.app.Activity activity, android.support.v4.widget.DrawerLayout drawerLayout, boolean z, @android.support.annotation.DrawableRes int i, @android.support.annotation.StringRes int i2, @android.support.annotation.StringRes int i3) {
        this.mDrawerIndicatorEnabled = true;
        this.mActivity = activity;
        if (activity instanceof android.support.v4.app.ActionBarDrawerToggle.DelegateProvider) {
            this.mActivityImpl = ((android.support.v4.app.ActionBarDrawerToggle.DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.mActivityImpl = null;
        }
        this.mDrawerLayout = drawerLayout;
        this.mDrawerImageResource = i;
        this.mOpenDrawerContentDescRes = i2;
        this.mCloseDrawerContentDescRes = i3;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mDrawerImage = android.support.v4.content.ContextCompat.getDrawable(activity, i);
        this.mSlider = new android.support.v4.app.ActionBarDrawerToggle.SlideDrawable(this.mDrawerImage);
        this.mSlider.setOffset(z ? TOGGLE_DRAWABLE_OFFSET : 0.0f);
    }

    private static boolean assumeMaterial(android.content.Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21 && android.os.Build.VERSION.SDK_INT >= 21;
    }

    private android.graphics.drawable.Drawable getThemeUpIndicator() {
        android.support.v4.app.ActionBarDrawerToggle.Delegate delegate = this.mActivityImpl;
        if (delegate != null) {
            return delegate.getThemeUpIndicator();
        }
        if (android.os.Build.VERSION.SDK_INT < 18) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = this.mActivity.obtainStyledAttributes(THEME_ATTRS);
            android.graphics.drawable.Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            typedArrayObtainStyledAttributes.recycle();
            return drawable;
        }
        android.app.ActionBar actionBar = this.mActivity.getActionBar();
        android.content.res.TypedArray typedArrayObtainStyledAttributes2 = (actionBar != null ? actionBar.getThemedContext() : this.mActivity).obtainStyledAttributes(null, THEME_ATTRS, android.R.attr.actionBarStyle, 0);
        android.graphics.drawable.Drawable drawable2 = typedArrayObtainStyledAttributes2.getDrawable(0);
        typedArrayObtainStyledAttributes2.recycle();
        return drawable2;
    }

    private void setActionBarDescription(int i) {
        android.support.v4.app.ActionBarDrawerToggle.Delegate delegate = this.mActivityImpl;
        if (delegate != null) {
            delegate.setActionBarDescription(i);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i);
                return;
            }
            return;
        }
        if (this.mSetIndicatorInfo == null) {
            this.mSetIndicatorInfo = new android.support.v4.app.ActionBarDrawerToggle.SetIndicatorInfo(this.mActivity);
        }
        if (this.mSetIndicatorInfo.mSetHomeAsUpIndicator != null) {
            try {
                android.app.ActionBar actionBar2 = this.mActivity.getActionBar();
                this.mSetIndicatorInfo.mSetHomeActionContentDescription.invoke(actionBar2, java.lang.Integer.valueOf(i));
                actionBar2.setSubtitle(actionBar2.getSubtitle());
            } catch (java.lang.Exception e) {
                android.util.Log.w(TAG, "Couldn't set content description via JB-MR2 API", e);
            }
        }
    }

    private void setActionBarUpIndicator(android.graphics.drawable.Drawable drawable, int i) {
        android.support.v4.app.ActionBarDrawerToggle.Delegate delegate = this.mActivityImpl;
        if (delegate != null) {
            delegate.setActionBarUpIndicator(drawable, i);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i);
                return;
            }
            return;
        }
        if (this.mSetIndicatorInfo == null) {
            this.mSetIndicatorInfo = new android.support.v4.app.ActionBarDrawerToggle.SetIndicatorInfo(this.mActivity);
        }
        if (this.mSetIndicatorInfo.mSetHomeAsUpIndicator == null) {
            if (this.mSetIndicatorInfo.mUpIndicatorView != null) {
                this.mSetIndicatorInfo.mUpIndicatorView.setImageDrawable(drawable);
                return;
            } else {
                android.util.Log.w(TAG, "Couldn't set home-as-up indicator");
                return;
            }
        }
        try {
            android.app.ActionBar actionBar2 = this.mActivity.getActionBar();
            this.mSetIndicatorInfo.mSetHomeAsUpIndicator.invoke(actionBar2, drawable);
            this.mSetIndicatorInfo.mSetHomeActionContentDescription.invoke(actionBar2, java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception e) {
            android.util.Log.w(TAG, "Couldn't set home-as-up indicator via JB-MR2 API", e);
        }
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        if (!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
        }
        this.mDrawerImage = android.support.v4.content.ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
        syncState();
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(android.view.View view) {
        this.mSlider.setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(android.view.View view) {
        this.mSlider.setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(android.view.View view, float f) {
        float position = this.mSlider.getPosition();
        this.mSlider.setPosition(f > 0.5f ? java.lang.Math.max(position, java.lang.Math.max(0.0f, f - 0.5f) * 2.0f) : java.lang.Math.min(position, f * 2.0f));
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
    }

    public boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.mDrawerIndicatorEnabled) {
            return false;
        }
        if (this.mDrawerLayout.isDrawerVisible(android.support.v4.view.GravityCompat.START)) {
            this.mDrawerLayout.closeDrawer(android.support.v4.view.GravityCompat.START);
            return true;
        }
        this.mDrawerLayout.openDrawer(android.support.v4.view.GravityCompat.START);
        return true;
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

    public void setHomeAsUpIndicator(int i) {
        setHomeAsUpIndicator(i != 0 ? android.support.v4.content.ContextCompat.getDrawable(this.mActivity, i) : null);
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

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(android.support.v4.view.GravityCompat.START)) {
            this.mSlider.setPosition(1.0f);
        } else {
            this.mSlider.setPosition(0.0f);
        }
        if (this.mDrawerIndicatorEnabled) {
            setActionBarUpIndicator(this.mSlider, this.mDrawerLayout.isDrawerOpen(android.support.v4.view.GravityCompat.START) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes);
        }
    }
}
