package android.support.v4.content.res;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TypedArrayUtils {
    private static final java.lang.String NAMESPACE = "http://schemas.android.com/apk/res/android";

    public static int getAttr(android.content.Context context, int i, int i2) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId != 0 ? i : i2;
    }

    public static boolean getBoolean(android.content.res.TypedArray typedArray, @android.support.annotation.StyleableRes int i, @android.support.annotation.StyleableRes int i2, boolean z) {
        return typedArray.getBoolean(i, typedArray.getBoolean(i2, z));
    }

    public static android.graphics.drawable.Drawable getDrawable(android.content.res.TypedArray typedArray, @android.support.annotation.StyleableRes int i, @android.support.annotation.StyleableRes int i2) {
        android.graphics.drawable.Drawable drawable = typedArray.getDrawable(i);
        return drawable == null ? typedArray.getDrawable(i2) : drawable;
    }

    public static int getInt(android.content.res.TypedArray typedArray, @android.support.annotation.StyleableRes int i, @android.support.annotation.StyleableRes int i2, int i3) {
        return typedArray.getInt(i, typedArray.getInt(i2, i3));
    }

    public static boolean getNamedBoolean(@android.support.annotation.NonNull android.content.res.TypedArray typedArray, @android.support.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, @android.support.annotation.StyleableRes int i, boolean z) {
        return !hasAttribute(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    @android.support.annotation.ColorInt
    public static int getNamedColor(@android.support.annotation.NonNull android.content.res.TypedArray typedArray, @android.support.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, @android.support.annotation.StyleableRes int i, @android.support.annotation.ColorInt int i2) {
        return !hasAttribute(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }

    public static float getNamedFloat(@android.support.annotation.NonNull android.content.res.TypedArray typedArray, @android.support.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @android.support.annotation.NonNull java.lang.String str, @android.support.annotation.StyleableRes int i, float f) {
        return !hasAttribute(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    public static int getNamedInt(@android.support.annotation.NonNull android.content.res.TypedArray typedArray, @android.support.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, @android.support.annotation.StyleableRes int i, int i2) {
        return !hasAttribute(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    @android.support.annotation.AnyRes
    public static int getNamedResourceId(@android.support.annotation.NonNull android.content.res.TypedArray typedArray, @android.support.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, @android.support.annotation.StyleableRes int i, @android.support.annotation.AnyRes int i2) {
        return !hasAttribute(xmlPullParser, str) ? i2 : typedArray.getResourceId(i, i2);
    }

    public static java.lang.String getNamedString(@android.support.annotation.NonNull android.content.res.TypedArray typedArray, @android.support.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, @android.support.annotation.StyleableRes int i) {
        if (hasAttribute(xmlPullParser, str)) {
            return typedArray.getString(i);
        }
        return null;
    }

    @android.support.annotation.AnyRes
    public static int getResourceId(android.content.res.TypedArray typedArray, @android.support.annotation.StyleableRes int i, @android.support.annotation.StyleableRes int i2, @android.support.annotation.AnyRes int i3) {
        return typedArray.getResourceId(i, typedArray.getResourceId(i2, i3));
    }

    public static java.lang.String getString(android.content.res.TypedArray typedArray, @android.support.annotation.StyleableRes int i, @android.support.annotation.StyleableRes int i2) {
        java.lang.String string = typedArray.getString(i);
        return string == null ? typedArray.getString(i2) : string;
    }

    public static java.lang.CharSequence getText(android.content.res.TypedArray typedArray, @android.support.annotation.StyleableRes int i, @android.support.annotation.StyleableRes int i2) {
        java.lang.CharSequence text = typedArray.getText(i);
        return text == null ? typedArray.getText(i2) : text;
    }

    public static java.lang.CharSequence[] getTextArray(android.content.res.TypedArray typedArray, @android.support.annotation.StyleableRes int i, @android.support.annotation.StyleableRes int i2) {
        java.lang.CharSequence[] textArray = typedArray.getTextArray(i);
        return textArray == null ? typedArray.getTextArray(i2) : textArray;
    }

    public static boolean hasAttribute(@android.support.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @android.support.annotation.NonNull java.lang.String str) {
        return xmlPullParser.getAttributeValue(NAMESPACE, str) != null;
    }

    public static android.content.res.TypedArray obtainAttributes(android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static android.util.TypedValue peekNamedValue(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, int i) {
        if (hasAttribute(xmlPullParser, str)) {
            return typedArray.peekValue(i);
        }
        return null;
    }
}
