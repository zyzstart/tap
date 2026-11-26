package android.support.v4.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class TextViewCompat {
    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;
    static final android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl IMPL;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AutoSizeTextType {
    }

    @android.support.annotation.RequiresApi(16)
    static class TextViewCompatApi16Impl extends android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl {
        TextViewCompatApi16Impl() {
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public int getMaxLines(android.widget.TextView textView) {
            return textView.getMaxLines();
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public int getMinLines(android.widget.TextView textView) {
            return textView.getMinLines();
        }
    }

    @android.support.annotation.RequiresApi(17)
    static class TextViewCompatApi17Impl extends android.support.v4.widget.TextViewCompat.TextViewCompatApi16Impl {
        TextViewCompatApi17Impl() {
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public android.graphics.drawable.Drawable[] getCompoundDrawablesRelative(@android.support.annotation.NonNull android.widget.TextView textView) {
            boolean z = textView.getLayoutDirection() == 1;
            android.graphics.drawable.Drawable[] compoundDrawables = textView.getCompoundDrawables();
            if (z) {
                android.graphics.drawable.Drawable drawable = compoundDrawables[2];
                android.graphics.drawable.Drawable drawable2 = compoundDrawables[0];
                compoundDrawables[0] = drawable;
                compoundDrawables[2] = drawable2;
            }
            return compoundDrawables;
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setCompoundDrawablesRelative(@android.support.annotation.NonNull android.widget.TextView textView, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable2, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable3, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable4) {
            boolean z = textView.getLayoutDirection() == 1;
            android.graphics.drawable.Drawable drawable5 = z ? drawable3 : drawable;
            if (!z) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@android.support.annotation.NonNull android.widget.TextView textView, @android.support.annotation.DrawableRes int i, @android.support.annotation.DrawableRes int i2, @android.support.annotation.DrawableRes int i3, @android.support.annotation.DrawableRes int i4) {
            boolean z = textView.getLayoutDirection() == 1;
            int i5 = z ? i3 : i;
            if (!z) {
                i = i3;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(i5, i2, i, i4);
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@android.support.annotation.NonNull android.widget.TextView textView, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable2, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable3, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable4) {
            boolean z = textView.getLayoutDirection() == 1;
            android.graphics.drawable.Drawable drawable5 = z ? drawable3 : drawable;
            if (!z) {
                drawable = drawable3;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable5, drawable2, drawable, drawable4);
        }
    }

    @android.support.annotation.RequiresApi(18)
    static class TextViewCompatApi18Impl extends android.support.v4.widget.TextViewCompat.TextViewCompatApi17Impl {
        TextViewCompatApi18Impl() {
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatApi17Impl, android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public android.graphics.drawable.Drawable[] getCompoundDrawablesRelative(@android.support.annotation.NonNull android.widget.TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatApi17Impl, android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setCompoundDrawablesRelative(@android.support.annotation.NonNull android.widget.TextView textView, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable2, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable3, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatApi17Impl, android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@android.support.annotation.NonNull android.widget.TextView textView, @android.support.annotation.DrawableRes int i, @android.support.annotation.DrawableRes int i2, @android.support.annotation.DrawableRes int i3, @android.support.annotation.DrawableRes int i4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatApi17Impl, android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@android.support.annotation.NonNull android.widget.TextView textView, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable2, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable3, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    @android.support.annotation.RequiresApi(23)
    static class TextViewCompatApi23Impl extends android.support.v4.widget.TextViewCompat.TextViewCompatApi18Impl {
        TextViewCompatApi23Impl() {
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setTextAppearance(@android.support.annotation.NonNull android.widget.TextView textView, @android.support.annotation.StyleRes int i) {
            textView.setTextAppearance(i);
        }
    }

    @android.support.annotation.RequiresApi(26)
    static class TextViewCompatApi26Impl extends android.support.v4.widget.TextViewCompat.TextViewCompatApi23Impl {
        TextViewCompatApi26Impl() {
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public int getAutoSizeMaxTextSize(android.widget.TextView textView) {
            return textView.getAutoSizeMaxTextSize();
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public int getAutoSizeMinTextSize(android.widget.TextView textView) {
            return textView.getAutoSizeMinTextSize();
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public int getAutoSizeStepGranularity(android.widget.TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public int[] getAutoSizeTextAvailableSizes(android.widget.TextView textView) {
            return textView.getAutoSizeTextAvailableSizes();
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public int getAutoSizeTextType(android.widget.TextView textView) {
            return textView.getAutoSizeTextType();
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setAutoSizeTextTypeUniformWithConfiguration(android.widget.TextView textView, int i, int i2, int i3, int i4) throws java.lang.IllegalArgumentException {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setAutoSizeTextTypeUniformWithPresetSizes(android.widget.TextView textView, @android.support.annotation.NonNull int[] iArr, int i) throws java.lang.IllegalArgumentException {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        public void setAutoSizeTextTypeWithDefaults(android.widget.TextView textView, int i) {
            textView.setAutoSizeTextTypeWithDefaults(i);
        }
    }

    static class TextViewCompatBaseImpl {
        private static final int LINES = 1;
        private static final java.lang.String LOG_TAG = "TextViewCompatBase";
        private static java.lang.reflect.Field sMaxModeField;
        private static boolean sMaxModeFieldFetched;
        private static java.lang.reflect.Field sMaximumField;
        private static boolean sMaximumFieldFetched;
        private static java.lang.reflect.Field sMinModeField;
        private static boolean sMinModeFieldFetched;
        private static java.lang.reflect.Field sMinimumField;
        private static boolean sMinimumFieldFetched;

        TextViewCompatBaseImpl() {
        }

        private static java.lang.reflect.Field retrieveField(java.lang.String str) {
            java.lang.reflect.Field declaredField = null;
            try {
                declaredField = android.widget.TextView.class.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (java.lang.NoSuchFieldException unused) {
                android.util.Log.e(LOG_TAG, "Could not retrieve " + str + " field.");
                return declaredField;
            }
        }

        private static int retrieveIntFromField(java.lang.reflect.Field field, android.widget.TextView textView) {
            try {
                return field.getInt(textView);
            } catch (java.lang.IllegalAccessException unused) {
                android.util.Log.d(LOG_TAG, "Could not retrieve value of " + field.getName() + " field.");
                return -1;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int getAutoSizeMaxTextSize(android.widget.TextView textView) {
            if (textView instanceof android.support.v4.widget.AutoSizeableTextView) {
                return ((android.support.v4.widget.AutoSizeableTextView) textView).getAutoSizeMaxTextSize();
            }
            return -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int getAutoSizeMinTextSize(android.widget.TextView textView) {
            if (textView instanceof android.support.v4.widget.AutoSizeableTextView) {
                return ((android.support.v4.widget.AutoSizeableTextView) textView).getAutoSizeMinTextSize();
            }
            return -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int getAutoSizeStepGranularity(android.widget.TextView textView) {
            if (textView instanceof android.support.v4.widget.AutoSizeableTextView) {
                return ((android.support.v4.widget.AutoSizeableTextView) textView).getAutoSizeStepGranularity();
            }
            return -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int[] getAutoSizeTextAvailableSizes(android.widget.TextView textView) {
            return textView instanceof android.support.v4.widget.AutoSizeableTextView ? ((android.support.v4.widget.AutoSizeableTextView) textView).getAutoSizeTextAvailableSizes() : new int[0];
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int getAutoSizeTextType(android.widget.TextView textView) {
            if (textView instanceof android.support.v4.widget.AutoSizeableTextView) {
                return ((android.support.v4.widget.AutoSizeableTextView) textView).getAutoSizeTextType();
            }
            return 0;
        }

        public android.graphics.drawable.Drawable[] getCompoundDrawablesRelative(@android.support.annotation.NonNull android.widget.TextView textView) {
            return textView.getCompoundDrawables();
        }

        public int getMaxLines(android.widget.TextView textView) {
            if (!sMaxModeFieldFetched) {
                sMaxModeField = retrieveField("mMaxMode");
                sMaxModeFieldFetched = true;
            }
            java.lang.reflect.Field field = sMaxModeField;
            if (field == null || retrieveIntFromField(field, textView) != 1) {
                return -1;
            }
            if (!sMaximumFieldFetched) {
                sMaximumField = retrieveField("mMaximum");
                sMaximumFieldFetched = true;
            }
            java.lang.reflect.Field field2 = sMaximumField;
            if (field2 != null) {
                return retrieveIntFromField(field2, textView);
            }
            return -1;
        }

        public int getMinLines(android.widget.TextView textView) {
            if (!sMinModeFieldFetched) {
                sMinModeField = retrieveField("mMinMode");
                sMinModeFieldFetched = true;
            }
            java.lang.reflect.Field field = sMinModeField;
            if (field == null || retrieveIntFromField(field, textView) != 1) {
                return -1;
            }
            if (!sMinimumFieldFetched) {
                sMinimumField = retrieveField("mMinimum");
                sMinimumFieldFetched = true;
            }
            java.lang.reflect.Field field2 = sMinimumField;
            if (field2 != null) {
                return retrieveIntFromField(field2, textView);
            }
            return -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setAutoSizeTextTypeUniformWithConfiguration(android.widget.TextView textView, int i, int i2, int i3, int i4) throws java.lang.IllegalArgumentException {
            if (textView instanceof android.support.v4.widget.AutoSizeableTextView) {
                ((android.support.v4.widget.AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setAutoSizeTextTypeUniformWithPresetSizes(android.widget.TextView textView, @android.support.annotation.NonNull int[] iArr, int i) throws java.lang.IllegalArgumentException {
            if (textView instanceof android.support.v4.widget.AutoSizeableTextView) {
                ((android.support.v4.widget.AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setAutoSizeTextTypeWithDefaults(android.widget.TextView textView, int i) {
            if (textView instanceof android.support.v4.widget.AutoSizeableTextView) {
                ((android.support.v4.widget.AutoSizeableTextView) textView).setAutoSizeTextTypeWithDefaults(i);
            }
        }

        public void setCompoundDrawablesRelative(@android.support.annotation.NonNull android.widget.TextView textView, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable2, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable3, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }

        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@android.support.annotation.NonNull android.widget.TextView textView, @android.support.annotation.DrawableRes int i, @android.support.annotation.DrawableRes int i2, @android.support.annotation.DrawableRes int i3, @android.support.annotation.DrawableRes int i4) {
            textView.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        }

        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@android.support.annotation.NonNull android.widget.TextView textView, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable2, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable3, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable4) {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        public void setTextAppearance(android.widget.TextView textView, @android.support.annotation.StyleRes int i) {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            IMPL = new android.support.v4.widget.TextViewCompat.TextViewCompatApi26Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            IMPL = new android.support.v4.widget.TextViewCompat.TextViewCompatApi23Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            IMPL = new android.support.v4.widget.TextViewCompat.TextViewCompatApi18Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            IMPL = new android.support.v4.widget.TextViewCompat.TextViewCompatApi17Impl();
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            IMPL = new android.support.v4.widget.TextViewCompat.TextViewCompatApi16Impl();
        } else {
            IMPL = new android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl();
        }
    }

    private TextViewCompat() {
    }

    public static int getAutoSizeMaxTextSize(android.widget.TextView textView) {
        return IMPL.getAutoSizeMaxTextSize(textView);
    }

    public static int getAutoSizeMinTextSize(android.widget.TextView textView) {
        return IMPL.getAutoSizeMinTextSize(textView);
    }

    public static int getAutoSizeStepGranularity(android.widget.TextView textView) {
        return IMPL.getAutoSizeStepGranularity(textView);
    }

    public static int[] getAutoSizeTextAvailableSizes(android.widget.TextView textView) {
        return IMPL.getAutoSizeTextAvailableSizes(textView);
    }

    public static int getAutoSizeTextType(android.widget.TextView textView) {
        return IMPL.getAutoSizeTextType(textView);
    }

    public static android.graphics.drawable.Drawable[] getCompoundDrawablesRelative(@android.support.annotation.NonNull android.widget.TextView textView) {
        return IMPL.getCompoundDrawablesRelative(textView);
    }

    public static int getMaxLines(@android.support.annotation.NonNull android.widget.TextView textView) {
        return IMPL.getMaxLines(textView);
    }

    public static int getMinLines(@android.support.annotation.NonNull android.widget.TextView textView) {
        return IMPL.getMinLines(textView);
    }

    public static void setAutoSizeTextTypeUniformWithConfiguration(android.widget.TextView textView, int i, int i2, int i3, int i4) throws java.lang.IllegalArgumentException {
        IMPL.setAutoSizeTextTypeUniformWithConfiguration(textView, i, i2, i3, i4);
    }

    public static void setAutoSizeTextTypeUniformWithPresetSizes(android.widget.TextView textView, @android.support.annotation.NonNull int[] iArr, int i) throws java.lang.IllegalArgumentException {
        IMPL.setAutoSizeTextTypeUniformWithPresetSizes(textView, iArr, i);
    }

    public static void setAutoSizeTextTypeWithDefaults(android.widget.TextView textView, int i) {
        IMPL.setAutoSizeTextTypeWithDefaults(textView, i);
    }

    public static void setCompoundDrawablesRelative(@android.support.annotation.NonNull android.widget.TextView textView, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable2, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable3, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable4) {
        IMPL.setCompoundDrawablesRelative(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@android.support.annotation.NonNull android.widget.TextView textView, @android.support.annotation.DrawableRes int i, @android.support.annotation.DrawableRes int i2, @android.support.annotation.DrawableRes int i3, @android.support.annotation.DrawableRes int i4) {
        IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, i, i2, i3, i4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@android.support.annotation.NonNull android.widget.TextView textView, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable2, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable3, @android.support.annotation.Nullable android.graphics.drawable.Drawable drawable4) {
        IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static void setTextAppearance(@android.support.annotation.NonNull android.widget.TextView textView, @android.support.annotation.StyleRes int i) {
        IMPL.setTextAppearance(textView, i);
    }
}
