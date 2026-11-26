package android.support.v4.graphics.drawable;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class DrawableCompat {
    static final android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl IMPL;

    @android.support.annotation.RequiresApi(17)
    static class DrawableCompatApi17Impl extends android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl {
        private static final java.lang.String TAG = "DrawableCompatApi17";
        private static java.lang.reflect.Method sGetLayoutDirectionMethod;
        private static boolean sGetLayoutDirectionMethodFetched;
        private static java.lang.reflect.Method sSetLayoutDirectionMethod;
        private static boolean sSetLayoutDirectionMethodFetched;

        DrawableCompatApi17Impl() {
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public int getLayoutDirection(android.graphics.drawable.Drawable drawable) {
            if (!sGetLayoutDirectionMethodFetched) {
                try {
                    sGetLayoutDirectionMethod = android.graphics.drawable.Drawable.class.getDeclaredMethod("getLayoutDirection", new java.lang.Class[0]);
                    sGetLayoutDirectionMethod.setAccessible(true);
                } catch (java.lang.NoSuchMethodException e) {
                    android.util.Log.i(TAG, "Failed to retrieve getLayoutDirection() method", e);
                }
                sGetLayoutDirectionMethodFetched = true;
            }
            java.lang.reflect.Method method = sGetLayoutDirectionMethod;
            if (method != null) {
                try {
                    return ((java.lang.Integer) method.invoke(drawable, new java.lang.Object[0])).intValue();
                } catch (java.lang.Exception e2) {
                    android.util.Log.i(TAG, "Failed to invoke getLayoutDirection() via reflection", e2);
                    sGetLayoutDirectionMethod = null;
                }
            }
            return 0;
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public boolean setLayoutDirection(android.graphics.drawable.Drawable drawable, int i) {
            if (!sSetLayoutDirectionMethodFetched) {
                try {
                    sSetLayoutDirectionMethod = android.graphics.drawable.Drawable.class.getDeclaredMethod("setLayoutDirection", java.lang.Integer.TYPE);
                    sSetLayoutDirectionMethod.setAccessible(true);
                } catch (java.lang.NoSuchMethodException e) {
                    android.util.Log.i(TAG, "Failed to retrieve setLayoutDirection(int) method", e);
                }
                sSetLayoutDirectionMethodFetched = true;
            }
            java.lang.reflect.Method method = sSetLayoutDirectionMethod;
            if (method != null) {
                try {
                    method.invoke(drawable, java.lang.Integer.valueOf(i));
                    return true;
                } catch (java.lang.Exception e2) {
                    android.util.Log.i(TAG, "Failed to invoke setLayoutDirection(int) via reflection", e2);
                    sSetLayoutDirectionMethod = null;
                }
            }
            return false;
        }
    }

    @android.support.annotation.RequiresApi(19)
    static class DrawableCompatApi19Impl extends android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatApi17Impl {
        DrawableCompatApi19Impl() {
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public int getAlpha(android.graphics.drawable.Drawable drawable) {
            return drawable.getAlpha();
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public boolean isAutoMirrored(android.graphics.drawable.Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public void setAutoMirrored(android.graphics.drawable.Drawable drawable, boolean z) {
            drawable.setAutoMirrored(z);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public android.graphics.drawable.Drawable wrap(android.graphics.drawable.Drawable drawable) {
            return !(drawable instanceof android.support.v4.graphics.drawable.TintAwareDrawable) ? new android.support.v4.graphics.drawable.DrawableWrapperApi19(drawable) : drawable;
        }
    }

    @android.support.annotation.RequiresApi(21)
    static class DrawableCompatApi21Impl extends android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatApi19Impl {
        DrawableCompatApi21Impl() {
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public void applyTheme(android.graphics.drawable.Drawable drawable, android.content.res.Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public boolean canApplyTheme(android.graphics.drawable.Drawable drawable) {
            return drawable.canApplyTheme();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public void clearColorFilter(android.graphics.drawable.Drawable drawable) {
            android.graphics.drawable.DrawableContainer.DrawableContainerState drawableContainerState;
            drawable.clearColorFilter();
            if (drawable instanceof android.graphics.drawable.InsetDrawable) {
                clearColorFilter(((android.graphics.drawable.InsetDrawable) drawable).getDrawable());
                return;
            }
            if (drawable instanceof android.support.v4.graphics.drawable.DrawableWrapper) {
                clearColorFilter(((android.support.v4.graphics.drawable.DrawableWrapper) drawable).getWrappedDrawable());
                return;
            }
            if (!(drawable instanceof android.graphics.drawable.DrawableContainer) || (drawableContainerState = (android.graphics.drawable.DrawableContainer.DrawableContainerState) ((android.graphics.drawable.DrawableContainer) drawable).getConstantState()) == null) {
                return;
            }
            int childCount = drawableContainerState.getChildCount();
            for (int i = 0; i < childCount; i++) {
                android.graphics.drawable.Drawable child = drawableContainerState.getChild(i);
                if (child != null) {
                    clearColorFilter(child);
                }
            }
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public android.graphics.ColorFilter getColorFilter(android.graphics.drawable.Drawable drawable) {
            return drawable.getColorFilter();
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public void inflate(android.graphics.drawable.Drawable drawable, android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public void setHotspot(android.graphics.drawable.Drawable drawable, float f, float f2) {
            drawable.setHotspot(f, f2);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public void setHotspotBounds(android.graphics.drawable.Drawable drawable, int i, int i2, int i3, int i4) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public void setTint(android.graphics.drawable.Drawable drawable, int i) {
            drawable.setTint(i);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public void setTintList(android.graphics.drawable.Drawable drawable, android.content.res.ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public void setTintMode(android.graphics.drawable.Drawable drawable, android.graphics.PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatApi19Impl, android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public android.graphics.drawable.Drawable wrap(android.graphics.drawable.Drawable drawable) {
            return !(drawable instanceof android.support.v4.graphics.drawable.TintAwareDrawable) ? new android.support.v4.graphics.drawable.DrawableWrapperApi21(drawable) : drawable;
        }
    }

    @android.support.annotation.RequiresApi(23)
    static class DrawableCompatApi23Impl extends android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatApi21Impl {
        DrawableCompatApi23Impl() {
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatApi21Impl, android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public void clearColorFilter(android.graphics.drawable.Drawable drawable) {
            drawable.clearColorFilter();
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatApi17Impl, android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public int getLayoutDirection(android.graphics.drawable.Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatApi17Impl, android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public boolean setLayoutDirection(android.graphics.drawable.Drawable drawable, int i) {
            return drawable.setLayoutDirection(i);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatApi21Impl, android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatApi19Impl, android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl
        public android.graphics.drawable.Drawable wrap(android.graphics.drawable.Drawable drawable) {
            return drawable;
        }
    }

    static class DrawableCompatBaseImpl {
        DrawableCompatBaseImpl() {
        }

        public void applyTheme(android.graphics.drawable.Drawable drawable, android.content.res.Resources.Theme theme) {
        }

        public boolean canApplyTheme(android.graphics.drawable.Drawable drawable) {
            return false;
        }

        public void clearColorFilter(android.graphics.drawable.Drawable drawable) {
            drawable.clearColorFilter();
        }

        public int getAlpha(android.graphics.drawable.Drawable drawable) {
            return 0;
        }

        public android.graphics.ColorFilter getColorFilter(android.graphics.drawable.Drawable drawable) {
            return null;
        }

        public int getLayoutDirection(android.graphics.drawable.Drawable drawable) {
            return 0;
        }

        public void inflate(android.graphics.drawable.Drawable drawable, android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }

        public boolean isAutoMirrored(android.graphics.drawable.Drawable drawable) {
            return false;
        }

        public void jumpToCurrentState(android.graphics.drawable.Drawable drawable) {
            drawable.jumpToCurrentState();
        }

        public void setAutoMirrored(android.graphics.drawable.Drawable drawable, boolean z) {
        }

        public void setHotspot(android.graphics.drawable.Drawable drawable, float f, float f2) {
        }

        public void setHotspotBounds(android.graphics.drawable.Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public boolean setLayoutDirection(android.graphics.drawable.Drawable drawable, int i) {
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setTint(android.graphics.drawable.Drawable drawable, int i) {
            if (drawable instanceof android.support.v4.graphics.drawable.TintAwareDrawable) {
                ((android.support.v4.graphics.drawable.TintAwareDrawable) drawable).setTint(i);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setTintList(android.graphics.drawable.Drawable drawable, android.content.res.ColorStateList colorStateList) {
            if (drawable instanceof android.support.v4.graphics.drawable.TintAwareDrawable) {
                ((android.support.v4.graphics.drawable.TintAwareDrawable) drawable).setTintList(colorStateList);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setTintMode(android.graphics.drawable.Drawable drawable, android.graphics.PorterDuff.Mode mode) {
            if (drawable instanceof android.support.v4.graphics.drawable.TintAwareDrawable) {
                ((android.support.v4.graphics.drawable.TintAwareDrawable) drawable).setTintMode(mode);
            }
        }

        public android.graphics.drawable.Drawable wrap(android.graphics.drawable.Drawable drawable) {
            return !(drawable instanceof android.support.v4.graphics.drawable.TintAwareDrawable) ? new android.support.v4.graphics.drawable.DrawableWrapperApi14(drawable) : drawable;
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            IMPL = new android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatApi23Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            IMPL = new android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatApi21Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            IMPL = new android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatApi19Impl();
        } else if (android.os.Build.VERSION.SDK_INT >= 17) {
            IMPL = new android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatApi17Impl();
        } else {
            IMPL = new android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatBaseImpl();
        }
    }

    private DrawableCompat() {
    }

    public static void applyTheme(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable, @android.support.annotation.NonNull android.content.res.Resources.Theme theme) {
        IMPL.applyTheme(drawable, theme);
    }

    public static boolean canApplyTheme(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        return IMPL.canApplyTheme(drawable);
    }

    public static void clearColorFilter(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        IMPL.clearColorFilter(drawable);
    }

    public static int getAlpha(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        return IMPL.getAlpha(drawable);
    }

    public static android.graphics.ColorFilter getColorFilter(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        return IMPL.getColorFilter(drawable);
    }

    public static int getLayoutDirection(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        return IMPL.getLayoutDirection(drawable);
    }

    public static void inflate(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable, @android.support.annotation.NonNull android.content.res.Resources resources, @android.support.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @android.support.annotation.NonNull android.util.AttributeSet attributeSet, @android.support.annotation.Nullable android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        IMPL.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean isAutoMirrored(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        return IMPL.isAutoMirrored(drawable);
    }

    public static void jumpToCurrentState(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        IMPL.jumpToCurrentState(drawable);
    }

    public static void setAutoMirrored(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable, boolean z) {
        IMPL.setAutoMirrored(drawable, z);
    }

    public static void setHotspot(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable, float f, float f2) {
        IMPL.setHotspot(drawable, f, f2);
    }

    public static void setHotspotBounds(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable, int i, int i2, int i3, int i4) {
        IMPL.setHotspotBounds(drawable, i, i2, i3, i4);
    }

    public static boolean setLayoutDirection(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable, int i) {
        return IMPL.setLayoutDirection(drawable, i);
    }

    public static void setTint(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable, @android.support.annotation.ColorInt int i) {
        IMPL.setTint(drawable, i);
    }

    public static void setTintList(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable, @android.support.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        IMPL.setTintList(drawable, colorStateList);
    }

    public static void setTintMode(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable, @android.support.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        IMPL.setTintMode(drawable, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends android.graphics.drawable.Drawable> T unwrap(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        return drawable instanceof android.support.v4.graphics.drawable.DrawableWrapper ? (T) ((android.support.v4.graphics.drawable.DrawableWrapper) drawable).getWrappedDrawable() : drawable;
    }

    public static android.graphics.drawable.Drawable wrap(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        return IMPL.wrap(drawable);
    }
}
