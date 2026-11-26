package android.support.v4.os;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class BuildCompat {
    private BuildCompat() {
    }

    @java.lang.Deprecated
    public static boolean isAtLeastN() {
        return android.os.Build.VERSION.SDK_INT >= 24;
    }

    @java.lang.Deprecated
    public static boolean isAtLeastNMR1() {
        return android.os.Build.VERSION.SDK_INT >= 25;
    }

    public static boolean isAtLeastO() {
        return android.os.Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isAtLeastOMR1() {
        return android.os.Build.VERSION.CODENAME.startsWith("OMR") || isAtLeastP();
    }

    public static boolean isAtLeastP() {
        return android.os.Build.VERSION.CODENAME.equals("P");
    }
}
