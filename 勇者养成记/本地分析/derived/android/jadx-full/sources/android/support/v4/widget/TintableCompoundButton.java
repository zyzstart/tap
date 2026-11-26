package android.support.v4.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface TintableCompoundButton {
    @android.support.annotation.Nullable
    android.content.res.ColorStateList getSupportButtonTintList();

    @android.support.annotation.Nullable
    android.graphics.PorterDuff.Mode getSupportButtonTintMode();

    void setSupportButtonTintList(@android.support.annotation.Nullable android.content.res.ColorStateList colorStateList);

    void setSupportButtonTintMode(@android.support.annotation.Nullable android.graphics.PorterDuff.Mode mode);
}
