package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class ThemeUtils {
    private static final java.lang.ThreadLocal<android.util.TypedValue> TL_TYPED_VALUE = new java.lang.ThreadLocal<>();
    static final int[] DISABLED_STATE_SET = {-16842910};
    static final int[] FOCUSED_STATE_SET = {android.R.attr.state_focused};
    static final int[] ACTIVATED_STATE_SET = {android.R.attr.state_activated};
    static final int[] PRESSED_STATE_SET = {android.R.attr.state_pressed};
    static final int[] CHECKED_STATE_SET = {android.R.attr.state_checked};
    static final int[] SELECTED_STATE_SET = {android.R.attr.state_selected};
    static final int[] NOT_PRESSED_OR_FOCUSED_STATE_SET = {-16842919, -16842908};
    static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] TEMP_ARRAY = new int[1];

    ThemeUtils() {
    }

    public static android.content.res.ColorStateList createDisabledStateList(int i, int i2) {
        return new android.content.res.ColorStateList(new int[][]{DISABLED_STATE_SET, EMPTY_STATE_SET}, new int[]{i2, i});
    }

    public static int getDisabledThemeAttrColor(android.content.Context context, int i) {
        android.content.res.ColorStateList themeAttrColorStateList = getThemeAttrColorStateList(context, i);
        if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
            return themeAttrColorStateList.getColorForState(DISABLED_STATE_SET, themeAttrColorStateList.getDefaultColor());
        }
        android.util.TypedValue typedValue = getTypedValue();
        context.getTheme().resolveAttribute(android.R.attr.disabledAlpha, typedValue, true);
        return getThemeAttrColor(context, i, typedValue.getFloat());
    }

    public static int getThemeAttrColor(android.content.Context context, int i) {
        int[] iArr = TEMP_ARRAY;
        iArr[0] = i;
        android.support.v7.widget.TintTypedArray tintTypedArrayObtainStyledAttributes = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(context, (android.util.AttributeSet) null, iArr);
        try {
            return tintTypedArrayObtainStyledAttributes.getColor(0, 0);
        } finally {
            tintTypedArrayObtainStyledAttributes.recycle();
        }
    }

    static int getThemeAttrColor(android.content.Context context, int i, float f) {
        int themeAttrColor = getThemeAttrColor(context, i);
        return android.support.v4.graphics.ColorUtils.setAlphaComponent(themeAttrColor, java.lang.Math.round(android.graphics.Color.alpha(themeAttrColor) * f));
    }

    public static android.content.res.ColorStateList getThemeAttrColorStateList(android.content.Context context, int i) {
        int[] iArr = TEMP_ARRAY;
        iArr[0] = i;
        android.support.v7.widget.TintTypedArray tintTypedArrayObtainStyledAttributes = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(context, (android.util.AttributeSet) null, iArr);
        try {
            return tintTypedArrayObtainStyledAttributes.getColorStateList(0);
        } finally {
            tintTypedArrayObtainStyledAttributes.recycle();
        }
    }

    private static android.util.TypedValue getTypedValue() {
        android.util.TypedValue typedValue = TL_TYPED_VALUE.get();
        if (typedValue != null) {
            return typedValue;
        }
        android.util.TypedValue typedValue2 = new android.util.TypedValue();
        TL_TYPED_VALUE.set(typedValue2);
        return typedValue2;
    }
}
