package android.support.v4.content.res;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ConfigurationHelper {
    private ConfigurationHelper() {
    }

    public static int getDensityDpi(@android.support.annotation.NonNull android.content.res.Resources resources) {
        return android.os.Build.VERSION.SDK_INT >= 17 ? resources.getConfiguration().densityDpi : resources.getDisplayMetrics().densityDpi;
    }

    @java.lang.Deprecated
    public static int getScreenHeightDp(@android.support.annotation.NonNull android.content.res.Resources resources) {
        return resources.getConfiguration().screenHeightDp;
    }

    @java.lang.Deprecated
    public static int getScreenWidthDp(@android.support.annotation.NonNull android.content.res.Resources resources) {
        return resources.getConfiguration().screenWidthDp;
    }

    @java.lang.Deprecated
    public static int getSmallestScreenWidthDp(@android.support.annotation.NonNull android.content.res.Resources resources) {
        return resources.getConfiguration().smallestScreenWidthDp;
    }
}
