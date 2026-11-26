package android.support.v4.content.res;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ResourcesCompat {
    private static final java.lang.String TAG = "ResourcesCompat";

    private ResourcesCompat() {
    }

    @android.support.annotation.ColorInt
    public static int getColor(@android.support.annotation.NonNull android.content.res.Resources resources, @android.support.annotation.ColorRes int i, @android.support.annotation.Nullable android.content.res.Resources.Theme theme) throws android.content.res.Resources.NotFoundException {
        return android.os.Build.VERSION.SDK_INT >= 23 ? resources.getColor(i, theme) : resources.getColor(i);
    }

    @android.support.annotation.Nullable
    public static android.content.res.ColorStateList getColorStateList(@android.support.annotation.NonNull android.content.res.Resources resources, @android.support.annotation.ColorRes int i, @android.support.annotation.Nullable android.content.res.Resources.Theme theme) throws android.content.res.Resources.NotFoundException {
        return android.os.Build.VERSION.SDK_INT >= 23 ? resources.getColorStateList(i, theme) : resources.getColorStateList(i);
    }

    @android.support.annotation.Nullable
    public static android.graphics.drawable.Drawable getDrawable(@android.support.annotation.NonNull android.content.res.Resources resources, @android.support.annotation.DrawableRes int i, @android.support.annotation.Nullable android.content.res.Resources.Theme theme) throws android.content.res.Resources.NotFoundException {
        return android.os.Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }

    @android.support.annotation.Nullable
    public static android.graphics.drawable.Drawable getDrawableForDensity(@android.support.annotation.NonNull android.content.res.Resources resources, @android.support.annotation.DrawableRes int i, int i2, @android.support.annotation.Nullable android.content.res.Resources.Theme theme) throws android.content.res.Resources.NotFoundException {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawableForDensity(i, i2, theme);
        }
        return android.os.Build.VERSION.SDK_INT >= 15 ? resources.getDrawableForDensity(i, i2) : resources.getDrawable(i);
    }

    @android.support.annotation.Nullable
    public static android.graphics.Typeface getFont(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.FontRes int i) throws android.content.res.Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, new android.util.TypedValue(), 0, null);
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static android.graphics.Typeface getFont(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.FontRes int i, android.util.TypedValue typedValue, int i2, @android.support.annotation.Nullable android.widget.TextView textView) throws android.content.res.Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, typedValue, i2, textView);
    }

    private static android.graphics.Typeface loadFont(@android.support.annotation.NonNull android.content.Context context, int i, android.util.TypedValue typedValue, int i2, @android.support.annotation.Nullable android.widget.TextView textView) {
        android.content.res.Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        android.graphics.Typeface typefaceLoadFont = loadFont(context, resources, typedValue, i, i2, textView);
        if (typefaceLoadFont != null) {
            return typefaceLoadFont;
        }
        throw new android.content.res.Resources.NotFoundException("Font resource ID #0x" + java.lang.Integer.toHexString(i));
    }

    private static android.graphics.Typeface loadFont(@android.support.annotation.NonNull android.content.Context context, android.content.res.Resources resources, android.util.TypedValue typedValue, int i, int i2, @android.support.annotation.Nullable android.widget.TextView textView) {
        if (typedValue.string == null) {
            throw new android.content.res.Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + java.lang.Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        java.lang.String string = typedValue.string.toString();
        if (!string.startsWith("res/")) {
            return null;
        }
        android.graphics.Typeface typefaceFindFromCache = android.support.v4.graphics.TypefaceCompat.findFromCache(resources, i, i2);
        if (typefaceFindFromCache != null) {
            return typefaceFindFromCache;
        }
        try {
            if (!string.toLowerCase().endsWith(".xml")) {
                return android.support.v4.graphics.TypefaceCompat.createFromResourcesFontFile(context, resources, i, string, i2);
            }
            android.support.v4.content.res.FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry = android.support.v4.content.res.FontResourcesParserCompat.parse(resources.getXml(i), resources);
            if (familyResourceEntry != null) {
                return android.support.v4.graphics.TypefaceCompat.createFromResourcesFamilyXml(context, familyResourceEntry, resources, i, i2, textView);
            }
            android.util.Log.e(TAG, "Failed to find font-family tag");
            return null;
        } catch (java.io.IOException e) {
            android.util.Log.e(TAG, "Failed to read xml resource " + string, e);
            return null;
        } catch (org.xmlpull.v1.XmlPullParserException e2) {
            android.util.Log.e(TAG, "Failed to parse xml resource " + string, e2);
            return null;
        }
    }
}
