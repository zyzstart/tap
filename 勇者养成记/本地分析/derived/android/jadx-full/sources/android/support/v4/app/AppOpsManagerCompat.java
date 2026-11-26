package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_IGNORED = 1;

    private AppOpsManagerCompat() {
    }

    public static int noteOp(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull java.lang.String str, int i, @android.support.annotation.NonNull java.lang.String str2) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return ((android.app.AppOpsManager) context.getSystemService(android.app.AppOpsManager.class)).noteOp(str, i, str2);
        }
        return 1;
    }

    public static int noteProxyOp(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull java.lang.String str2) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return ((android.app.AppOpsManager) context.getSystemService(android.app.AppOpsManager.class)).noteProxyOp(str, str2);
        }
        return 1;
    }

    public static java.lang.String permissionToOp(@android.support.annotation.NonNull java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return android.app.AppOpsManager.permissionToOp(str);
        }
        return null;
    }
}
