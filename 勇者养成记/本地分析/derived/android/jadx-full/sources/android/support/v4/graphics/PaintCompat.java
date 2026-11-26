package android.support.v4.graphics;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class PaintCompat {
    private PaintCompat() {
    }

    public static boolean hasGlyph(@android.support.annotation.NonNull android.graphics.Paint paint, @android.support.annotation.NonNull java.lang.String str) {
        return android.os.Build.VERSION.SDK_INT >= 23 ? paint.hasGlyph(str) : android.support.v4.graphics.PaintCompatApi14.hasGlyph(paint, str);
    }
}
