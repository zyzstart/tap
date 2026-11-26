package android.support.v4.graphics;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class PaintCompatApi14 {
    private static final java.lang.String EM_STRING = "m";
    private static final java.lang.String TOFU_STRING = "\udfffd";
    private static final java.lang.ThreadLocal<android.support.v4.util.Pair<android.graphics.Rect, android.graphics.Rect>> sRectThreadLocal = new java.lang.ThreadLocal<>();

    PaintCompatApi14() {
    }

    static boolean hasGlyph(@android.support.annotation.NonNull android.graphics.Paint paint, @android.support.annotation.NonNull java.lang.String str) {
        int length = str.length();
        if (length == 1 && java.lang.Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float fMeasureText = paint.measureText(TOFU_STRING);
        float fMeasureText2 = paint.measureText(EM_STRING);
        float fMeasureText3 = paint.measureText(str);
        float fMeasureText4 = 0.0f;
        if (fMeasureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (fMeasureText3 > fMeasureText2 * 2.0f) {
                return false;
            }
            int i = 0;
            while (i < length) {
                int iCharCount = java.lang.Character.charCount(str.codePointAt(i)) + i;
                fMeasureText4 += paint.measureText(str, i, iCharCount);
                i = iCharCount;
            }
            if (fMeasureText3 >= fMeasureText4) {
                return false;
            }
        }
        if (fMeasureText3 != fMeasureText) {
            return true;
        }
        android.support.v4.util.Pair<android.graphics.Rect, android.graphics.Rect> pairObtainEmptyRects = obtainEmptyRects();
        paint.getTextBounds(TOFU_STRING, 0, 2, pairObtainEmptyRects.first);
        paint.getTextBounds(str, 0, length, pairObtainEmptyRects.second);
        return !pairObtainEmptyRects.first.equals(pairObtainEmptyRects.second);
    }

    private static android.support.v4.util.Pair<android.graphics.Rect, android.graphics.Rect> obtainEmptyRects() {
        android.support.v4.util.Pair<android.graphics.Rect, android.graphics.Rect> pair = sRectThreadLocal.get();
        if (pair == null) {
            android.support.v4.util.Pair<android.graphics.Rect, android.graphics.Rect> pair2 = new android.support.v4.util.Pair<>(new android.graphics.Rect(), new android.graphics.Rect());
            sRectThreadLocal.set(pair2);
            return pair2;
        }
        pair.first.setEmpty();
        pair.second.setEmpty();
        return pair;
    }
}
