package android.support.v4.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ScaleGestureDetectorCompat {
    private ScaleGestureDetectorCompat() {
    }

    public static boolean isQuickScaleEnabled(android.view.ScaleGestureDetector scaleGestureDetector) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return scaleGestureDetector.isQuickScaleEnabled();
        }
        return false;
    }

    @java.lang.Deprecated
    public static boolean isQuickScaleEnabled(java.lang.Object obj) {
        return isQuickScaleEnabled((android.view.ScaleGestureDetector) obj);
    }

    public static void setQuickScaleEnabled(android.view.ScaleGestureDetector scaleGestureDetector, boolean z) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            scaleGestureDetector.setQuickScaleEnabled(z);
        }
    }

    @java.lang.Deprecated
    public static void setQuickScaleEnabled(java.lang.Object obj, boolean z) {
        setQuickScaleEnabled((android.view.ScaleGestureDetector) obj, z);
    }
}
