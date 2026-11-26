package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class DrawableUtils {
    public static final android.graphics.Rect INSETS_NONE = new android.graphics.Rect();
    private static final java.lang.String TAG = "DrawableUtils";
    private static final java.lang.String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
    private static java.lang.Class<?> sInsetsClazz;

    static {
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            try {
                sInsetsClazz = java.lang.Class.forName("android.graphics.Insets");
            } catch (java.lang.ClassNotFoundException unused) {
            }
        }
    }

    private DrawableUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean canSafelyMutateDrawable(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        if (android.os.Build.VERSION.SDK_INT < 15 && (drawable instanceof android.graphics.drawable.InsetDrawable)) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT < 15 && (drawable instanceof android.graphics.drawable.GradientDrawable)) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT < 17 && (drawable instanceof android.graphics.drawable.LayerDrawable)) {
            return false;
        }
        if (!(drawable instanceof android.graphics.drawable.DrawableContainer)) {
            if (drawable instanceof android.support.v4.graphics.drawable.DrawableWrapper) {
                return canSafelyMutateDrawable(((android.support.v4.graphics.drawable.DrawableWrapper) drawable).getWrappedDrawable());
            }
            if (drawable instanceof android.support.v7.graphics.drawable.DrawableWrapper) {
                return canSafelyMutateDrawable(((android.support.v7.graphics.drawable.DrawableWrapper) drawable).getWrappedDrawable());
            }
            if (drawable instanceof android.graphics.drawable.ScaleDrawable) {
                return canSafelyMutateDrawable(((android.graphics.drawable.ScaleDrawable) drawable).getDrawable());
            }
            return true;
        }
        android.graphics.drawable.Drawable.ConstantState constantState = drawable.getConstantState();
        if (!(constantState instanceof android.graphics.drawable.DrawableContainer.DrawableContainerState)) {
            return true;
        }
        for (android.graphics.drawable.Drawable drawable2 : ((android.graphics.drawable.DrawableContainer.DrawableContainerState) constantState).getChildren()) {
            if (!canSafelyMutateDrawable(drawable2)) {
                return false;
            }
        }
        return true;
    }

    static void fixDrawable(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        if (android.os.Build.VERSION.SDK_INT == 21 && VECTOR_DRAWABLE_CLAZZ_NAME.equals(drawable.getClass().getName())) {
            fixVectorDrawableTinting(drawable);
        }
    }

    private static void fixVectorDrawableTinting(android.graphics.drawable.Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(android.support.v7.widget.ThemeUtils.CHECKED_STATE_SET);
        } else {
            drawable.setState(android.support.v7.widget.ThemeUtils.EMPTY_STATE_SET);
        }
        drawable.setState(state);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0074  */
    public static android.graphics.Rect getOpticalBounds(android.graphics.drawable.Drawable drawable) {
        if (sInsetsClazz != null) {
            try {
                android.graphics.drawable.Drawable drawableUnwrap = android.support.v4.graphics.drawable.DrawableCompat.unwrap(drawable);
                java.lang.Object objInvoke = drawableUnwrap.getClass().getMethod("getOpticalInsets", new java.lang.Class[0]).invoke(drawableUnwrap, new java.lang.Object[0]);
                if (objInvoke != null) {
                    android.graphics.Rect rect = new android.graphics.Rect();
                    for (java.lang.reflect.Field field : sInsetsClazz.getFields()) {
                        switch (field.getName()) {
                            case "left":
                                rect.left = field.getInt(objInvoke);
                                break;
                            case "top":
                                rect.top = field.getInt(objInvoke);
                                break;
                            case "right":
                                rect.right = field.getInt(objInvoke);
                                break;
                            case "bottom":
                                rect.bottom = field.getInt(objInvoke);
                                break;
                        }
                    }
                    return rect;
                }
            } catch (java.lang.Exception unused) {
                android.util.Log.e(TAG, "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return INSETS_NONE;
    }

    public static android.graphics.PorterDuff.Mode parseTintMode(int i, android.graphics.PorterDuff.Mode mode) {
        if (i == 3) {
            return android.graphics.PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return android.graphics.PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return android.graphics.PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return android.graphics.PorterDuff.Mode.MULTIPLY;
            case 15:
                return android.graphics.PorterDuff.Mode.SCREEN;
            case 16:
                return android.os.Build.VERSION.SDK_INT >= 11 ? android.graphics.PorterDuff.Mode.valueOf("ADD") : mode;
            default:
                return mode;
        }
    }
}
