package android.support.v4.view.animation;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
    }

    public static android.view.animation.Interpolator create(float f, float f2) {
        return android.os.Build.VERSION.SDK_INT >= 21 ? new android.view.animation.PathInterpolator(f, f2) : new android.support.v4.view.animation.PathInterpolatorApi14(f, f2);
    }

    public static android.view.animation.Interpolator create(float f, float f2, float f3, float f4) {
        return android.os.Build.VERSION.SDK_INT >= 21 ? new android.view.animation.PathInterpolator(f, f2, f3, f4) : new android.support.v4.view.animation.PathInterpolatorApi14(f, f2, f3, f4);
    }

    public static android.view.animation.Interpolator create(android.graphics.Path path) {
        return android.os.Build.VERSION.SDK_INT >= 21 ? new android.view.animation.PathInterpolator(path) : new android.support.v4.view.animation.PathInterpolatorApi14(path);
    }
}
