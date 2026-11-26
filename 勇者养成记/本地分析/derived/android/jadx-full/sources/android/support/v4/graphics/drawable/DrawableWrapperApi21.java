package android.support.v4.graphics.drawable;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(21)
class DrawableWrapperApi21 extends android.support.v4.graphics.drawable.DrawableWrapperApi19 {
    private static final java.lang.String TAG = "DrawableWrapperApi21";
    private static java.lang.reflect.Method sIsProjectedDrawableMethod;

    private static class DrawableWrapperStateLollipop extends android.support.v4.graphics.drawable.DrawableWrapperApi14.DrawableWrapperState {
        DrawableWrapperStateLollipop(@android.support.annotation.Nullable android.support.v4.graphics.drawable.DrawableWrapperApi14.DrawableWrapperState drawableWrapperState, @android.support.annotation.Nullable android.content.res.Resources resources) {
            super(drawableWrapperState, resources);
        }

        @Override // android.support.v4.graphics.drawable.DrawableWrapperApi14.DrawableWrapperState, android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable(@android.support.annotation.Nullable android.content.res.Resources resources) {
            return new android.support.v4.graphics.drawable.DrawableWrapperApi21(this, resources);
        }
    }

    DrawableWrapperApi21(android.graphics.drawable.Drawable drawable) {
        super(drawable);
        findAndCacheIsProjectedDrawableMethod();
    }

    DrawableWrapperApi21(android.support.v4.graphics.drawable.DrawableWrapperApi14.DrawableWrapperState drawableWrapperState, android.content.res.Resources resources) {
        super(drawableWrapperState, resources);
        findAndCacheIsProjectedDrawableMethod();
    }

    private void findAndCacheIsProjectedDrawableMethod() {
        if (sIsProjectedDrawableMethod == null) {
            try {
                sIsProjectedDrawableMethod = android.graphics.drawable.Drawable.class.getDeclaredMethod("isProjected", new java.lang.Class[0]);
            } catch (java.lang.Exception e) {
                android.util.Log.w(TAG, "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(android.graphics.Outline outline) {
        this.mDrawable.getOutline(outline);
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapperApi14
    protected boolean isCompatTintEnabled() {
        if (android.os.Build.VERSION.SDK_INT != 21) {
            return false;
        }
        android.graphics.drawable.Drawable drawable = this.mDrawable;
        return (drawable instanceof android.graphics.drawable.GradientDrawable) || (drawable instanceof android.graphics.drawable.DrawableContainer) || (drawable instanceof android.graphics.drawable.InsetDrawable) || (drawable instanceof android.graphics.drawable.RippleDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isProjected() {
        java.lang.reflect.Method method;
        if (this.mDrawable != null && (method = sIsProjectedDrawableMethod) != null) {
            try {
                return ((java.lang.Boolean) method.invoke(this.mDrawable, new java.lang.Object[0])).booleanValue();
            } catch (java.lang.Exception e) {
                android.util.Log.w(TAG, "Error calling Drawable#isProjected() method", e);
            }
        }
        return false;
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapperApi19, android.support.v4.graphics.drawable.DrawableWrapperApi14
    @android.support.annotation.NonNull
    android.support.v4.graphics.drawable.DrawableWrapperApi14.DrawableWrapperState mutateConstantState() {
        return new android.support.v4.graphics.drawable.DrawableWrapperApi21.DrawableWrapperStateLollipop(this.mState, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        this.mDrawable.setHotspot(f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.mDrawable.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapperApi14, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapperApi14, android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        if (isCompatTintEnabled()) {
            super.setTint(i);
        } else {
            this.mDrawable.setTint(i);
        }
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapperApi14, android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(android.content.res.ColorStateList colorStateList) {
        if (isCompatTintEnabled()) {
            super.setTintList(colorStateList);
        } else {
            this.mDrawable.setTintList(colorStateList);
        }
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapperApi14, android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(android.graphics.PorterDuff.Mode mode) {
        if (isCompatTintEnabled()) {
            super.setTintMode(mode);
        } else {
            this.mDrawable.setTintMode(mode);
        }
    }
}
