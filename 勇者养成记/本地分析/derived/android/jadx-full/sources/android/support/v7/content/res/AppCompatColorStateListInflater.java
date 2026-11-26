package android.support.v7.content.res;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class AppCompatColorStateListInflater {
    private static final int DEFAULT_COLOR = -65536;

    private AppCompatColorStateListInflater() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @android.support.annotation.NonNull
    public static android.content.res.ColorStateList createFromXml(@android.support.annotation.NonNull android.content.res.Resources resources, @android.support.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @android.support.annotation.Nullable android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int next;
        android.util.AttributeSet attributeSetAsAttributeSet = android.util.Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return createFromXmlInner(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
        }
        throw new org.xmlpull.v1.XmlPullParserException("No start tag found");
    }

    @android.support.annotation.NonNull
    private static android.content.res.ColorStateList createFromXmlInner(@android.support.annotation.NonNull android.content.res.Resources resources, @android.support.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @android.support.annotation.NonNull android.util.AttributeSet attributeSet, @android.support.annotation.Nullable android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.lang.String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return inflate(resources, xmlPullParser, attributeSet, theme);
        }
        throw new org.xmlpull.v1.XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static android.content.res.ColorStateList inflate(@android.support.annotation.NonNull android.content.res.Resources resources, @android.support.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @android.support.annotation.NonNull android.util.AttributeSet attributeSet, @android.support.annotation.Nullable android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int depth;
        int i = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArrAppend = new int[iArr.length];
        int i2 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                android.content.res.TypedArray typedArrayObtainAttributes = obtainAttributes(resources, theme, attributeSet, android.support.v7.appcompat.R.styleable.ColorStateListItem);
                int color = typedArrayObtainAttributes.getColor(android.support.v7.appcompat.R.styleable.ColorStateListItem_android_color, -65281);
                float f = 1.0f;
                if (typedArrayObtainAttributes.hasValue(android.support.v7.appcompat.R.styleable.ColorStateListItem_android_alpha)) {
                    f = typedArrayObtainAttributes.getFloat(android.support.v7.appcompat.R.styleable.ColorStateListItem_android_alpha, 1.0f);
                } else if (typedArrayObtainAttributes.hasValue(android.support.v7.appcompat.R.styleable.ColorStateListItem_alpha)) {
                    f = typedArrayObtainAttributes.getFloat(android.support.v7.appcompat.R.styleable.ColorStateListItem_alpha, 1.0f);
                }
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i3 = 0;
                for (int i4 = 0; i4 < attributeCount; i4++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i4);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != android.support.v7.appcompat.R.attr.alpha) {
                        int i5 = i3 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i3] = attributeNameResource;
                        i3 = i5;
                    }
                }
                int[] iArrTrimStateSet = android.util.StateSet.trimStateSet(iArr2, i3);
                int iModulateColorAlpha = modulateColorAlpha(color, f);
                if (i2 != 0) {
                    int length = iArrTrimStateSet.length;
                }
                iArrAppend = android.support.v7.content.res.GrowingArrayUtils.append(iArrAppend, i2, iModulateColorAlpha);
                iArr = (int[][]) android.support.v7.content.res.GrowingArrayUtils.append(iArr, i2, iArrTrimStateSet);
                i2++;
                i = 1;
            } else {
                i = 1;
            }
        }
        int[] iArr3 = new int[i2];
        int[][] iArr4 = new int[i2][];
        java.lang.System.arraycopy(iArrAppend, 0, iArr3, 0, i2);
        java.lang.System.arraycopy(iArr, 0, iArr4, 0, i2);
        return new android.content.res.ColorStateList(iArr4, iArr3);
    }

    private static int modulateColorAlpha(int i, float f) {
        return android.support.v4.graphics.ColorUtils.setAlphaComponent(i, java.lang.Math.round(android.graphics.Color.alpha(i) * f));
    }

    private static android.content.res.TypedArray obtainAttributes(android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
