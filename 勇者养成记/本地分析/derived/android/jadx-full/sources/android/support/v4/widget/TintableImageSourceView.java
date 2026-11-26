package android.support.v4.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public interface TintableImageSourceView {
    @android.support.annotation.Nullable
    android.content.res.ColorStateList getSupportImageTintList();

    @android.support.annotation.Nullable
    android.graphics.PorterDuff.Mode getSupportImageTintMode();

    void setSupportImageTintList(@android.support.annotation.Nullable android.content.res.ColorStateList colorStateList);

    void setSupportImageTintMode(@android.support.annotation.Nullable android.graphics.PorterDuff.Mode mode);
}
