package android.support.v4.graphics.drawable;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public interface TintAwareDrawable {
    void setTint(@android.support.annotation.ColorInt int i);

    void setTintList(android.content.res.ColorStateList colorStateList);

    void setTintMode(android.graphics.PorterDuff.Mode mode);
}
