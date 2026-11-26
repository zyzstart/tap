package android.support.v7.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(11)
class ActionBarDrawerToggleHoneycomb {
    private static final java.lang.String TAG = "ActionBarDrawerToggleHoneycomb";
    private static final int[] THEME_ATTRS = {android.R.attr.homeAsUpIndicator};

    static class SetIndicatorInfo {
        public java.lang.reflect.Method setHomeActionContentDescription;
        public java.lang.reflect.Method setHomeAsUpIndicator;
        public android.widget.ImageView upIndicatorView;

        SetIndicatorInfo(android.app.Activity activity) {
            try {
                this.setHomeAsUpIndicator = android.app.ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", android.graphics.drawable.Drawable.class);
                this.setHomeActionContentDescription = android.app.ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", java.lang.Integer.TYPE);
            } catch (java.lang.NoSuchMethodException unused) {
                android.view.View viewFindViewById = activity.findViewById(android.R.id.home);
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
                    this.upIndicatorView = (android.widget.ImageView) childAt2;
                }
            }
        }
    }

    ActionBarDrawerToggleHoneycomb() {
    }

    public static android.graphics.drawable.Drawable getThemeUpIndicator(android.app.Activity activity) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = activity.obtainStyledAttributes(THEME_ATTRS);
        android.graphics.drawable.Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        return drawable;
    }

    public static android.support.v7.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo setActionBarDescription(android.support.v7.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo setIndicatorInfo, android.app.Activity activity, int i) {
        if (setIndicatorInfo == null) {
            setIndicatorInfo = new android.support.v7.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo(activity);
        }
        if (setIndicatorInfo.setHomeAsUpIndicator != null) {
            try {
                android.app.ActionBar actionBar = activity.getActionBar();
                setIndicatorInfo.setHomeActionContentDescription.invoke(actionBar, java.lang.Integer.valueOf(i));
                if (android.os.Build.VERSION.SDK_INT <= 19) {
                    actionBar.setSubtitle(actionBar.getSubtitle());
                }
            } catch (java.lang.Exception e) {
                android.util.Log.w(TAG, "Couldn't set content description via JB-MR2 API", e);
            }
        }
        return setIndicatorInfo;
    }

    public static android.support.v7.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo setActionBarUpIndicator(android.support.v7.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo setIndicatorInfo, android.app.Activity activity, android.graphics.drawable.Drawable drawable, int i) {
        android.support.v7.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo setIndicatorInfo2 = new android.support.v7.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo(activity);
        if (setIndicatorInfo2.setHomeAsUpIndicator != null) {
            try {
                android.app.ActionBar actionBar = activity.getActionBar();
                setIndicatorInfo2.setHomeAsUpIndicator.invoke(actionBar, drawable);
                setIndicatorInfo2.setHomeActionContentDescription.invoke(actionBar, java.lang.Integer.valueOf(i));
            } catch (java.lang.Exception e) {
                android.util.Log.w(TAG, "Couldn't set home-as-up indicator via JB-MR2 API", e);
            }
        } else if (setIndicatorInfo2.upIndicatorView != null) {
            setIndicatorInfo2.upIndicatorView.setImageDrawable(drawable);
        } else {
            android.util.Log.w(TAG, "Couldn't set home-as-up indicator");
        }
        return setIndicatorInfo2;
    }
}
