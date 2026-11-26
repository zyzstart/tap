package android.support.v4.content;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class PermissionChecker {
    public static final int PERMISSION_DENIED = -1;
    public static final int PERMISSION_DENIED_APP_OP = -2;
    public static final int PERMISSION_GRANTED = 0;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface PermissionResult {
    }

    private PermissionChecker() {
    }

    public static int checkCallingOrSelfPermission(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull java.lang.String str) {
        return checkPermission(context, str, android.os.Binder.getCallingPid(), android.os.Binder.getCallingUid(), android.os.Binder.getCallingPid() == android.os.Process.myPid() ? context.getPackageName() : null);
    }

    public static int checkCallingPermission(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull java.lang.String str, java.lang.String str2) {
        if (android.os.Binder.getCallingPid() == android.os.Process.myPid()) {
            return -1;
        }
        return checkPermission(context, str, android.os.Binder.getCallingPid(), android.os.Binder.getCallingUid(), str2);
    }

    public static int checkPermission(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull java.lang.String str, int i, int i2, java.lang.String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        java.lang.String strPermissionToOp = android.support.v4.app.AppOpsManagerCompat.permissionToOp(str);
        if (strPermissionToOp == null) {
            return 0;
        }
        if (str2 == null) {
            java.lang.String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return android.support.v4.app.AppOpsManagerCompat.noteProxyOp(context, strPermissionToOp, str2) != 0 ? -2 : 0;
    }

    public static int checkSelfPermission(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull java.lang.String str) {
        return checkPermission(context, str, android.os.Process.myPid(), android.os.Process.myUid(), context.getPackageName());
    }
}
