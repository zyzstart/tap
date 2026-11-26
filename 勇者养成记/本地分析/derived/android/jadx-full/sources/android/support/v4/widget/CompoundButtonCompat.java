package android.support.v4.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class CompoundButtonCompat {
    private static final android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatBaseImpl IMPL;

    @android.support.annotation.RequiresApi(21)
    static class CompoundButtonCompatApi21Impl extends android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatBaseImpl {
        CompoundButtonCompatApi21Impl() {
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatBaseImpl
        public android.content.res.ColorStateList getButtonTintList(android.widget.CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatBaseImpl
        public android.graphics.PorterDuff.Mode getButtonTintMode(android.widget.CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatBaseImpl
        public void setButtonTintList(android.widget.CompoundButton compoundButton, android.content.res.ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatBaseImpl
        public void setButtonTintMode(android.widget.CompoundButton compoundButton, android.graphics.PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    @android.support.annotation.RequiresApi(23)
    static class CompoundButtonCompatApi23Impl extends android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatApi21Impl {
        CompoundButtonCompatApi23Impl() {
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatBaseImpl
        public android.graphics.drawable.Drawable getButtonDrawable(android.widget.CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    static class CompoundButtonCompatBaseImpl {
        private static final java.lang.String TAG = "CompoundButtonCompat";
        private static java.lang.reflect.Field sButtonDrawableField;
        private static boolean sButtonDrawableFieldFetched;

        CompoundButtonCompatBaseImpl() {
        }

        public android.graphics.drawable.Drawable getButtonDrawable(android.widget.CompoundButton compoundButton) {
            if (!sButtonDrawableFieldFetched) {
                try {
                    sButtonDrawableField = android.widget.CompoundButton.class.getDeclaredField("mButtonDrawable");
                    sButtonDrawableField.setAccessible(true);
                } catch (java.lang.NoSuchFieldException e) {
                    android.util.Log.i(TAG, "Failed to retrieve mButtonDrawable field", e);
                }
                sButtonDrawableFieldFetched = true;
            }
            java.lang.reflect.Field field = sButtonDrawableField;
            if (field != null) {
                try {
                    return (android.graphics.drawable.Drawable) field.get(compoundButton);
                } catch (java.lang.IllegalAccessException e2) {
                    android.util.Log.i(TAG, "Failed to get button drawable via reflection", e2);
                    sButtonDrawableField = null;
                }
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public android.content.res.ColorStateList getButtonTintList(android.widget.CompoundButton compoundButton) {
            if (compoundButton instanceof android.support.v4.widget.TintableCompoundButton) {
                return ((android.support.v4.widget.TintableCompoundButton) compoundButton).getSupportButtonTintList();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public android.graphics.PorterDuff.Mode getButtonTintMode(android.widget.CompoundButton compoundButton) {
            if (compoundButton instanceof android.support.v4.widget.TintableCompoundButton) {
                return ((android.support.v4.widget.TintableCompoundButton) compoundButton).getSupportButtonTintMode();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setButtonTintList(android.widget.CompoundButton compoundButton, android.content.res.ColorStateList colorStateList) {
            if (compoundButton instanceof android.support.v4.widget.TintableCompoundButton) {
                ((android.support.v4.widget.TintableCompoundButton) compoundButton).setSupportButtonTintList(colorStateList);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setButtonTintMode(android.widget.CompoundButton compoundButton, android.graphics.PorterDuff.Mode mode) {
            if (compoundButton instanceof android.support.v4.widget.TintableCompoundButton) {
                ((android.support.v4.widget.TintableCompoundButton) compoundButton).setSupportButtonTintMode(mode);
            }
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            IMPL = new android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatApi23Impl();
        } else if (android.os.Build.VERSION.SDK_INT >= 21) {
            IMPL = new android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatApi21Impl();
        } else {
            IMPL = new android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatBaseImpl();
        }
    }

    private CompoundButtonCompat() {
    }

    @android.support.annotation.Nullable
    public static android.graphics.drawable.Drawable getButtonDrawable(@android.support.annotation.NonNull android.widget.CompoundButton compoundButton) {
        return IMPL.getButtonDrawable(compoundButton);
    }

    @android.support.annotation.Nullable
    public static android.content.res.ColorStateList getButtonTintList(@android.support.annotation.NonNull android.widget.CompoundButton compoundButton) {
        return IMPL.getButtonTintList(compoundButton);
    }

    @android.support.annotation.Nullable
    public static android.graphics.PorterDuff.Mode getButtonTintMode(@android.support.annotation.NonNull android.widget.CompoundButton compoundButton) {
        return IMPL.getButtonTintMode(compoundButton);
    }

    public static void setButtonTintList(@android.support.annotation.NonNull android.widget.CompoundButton compoundButton, @android.support.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        IMPL.setButtonTintList(compoundButton, colorStateList);
    }

    public static void setButtonTintMode(@android.support.annotation.NonNull android.widget.CompoundButton compoundButton, @android.support.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        IMPL.setButtonTintMode(compoundButton, mode);
    }
}
