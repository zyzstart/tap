package android.support.v4.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface TintableBackgroundView {
    @android.support.annotation.Nullable
    android.content.res.ColorStateList getSupportBackgroundTintList();

    @android.support.annotation.Nullable
    android.graphics.PorterDuff.Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(@android.support.annotation.Nullable android.content.res.ColorStateList colorStateList);

    void setSupportBackgroundTintMode(@android.support.annotation.Nullable android.graphics.PorterDuff.Mode mode);
}
