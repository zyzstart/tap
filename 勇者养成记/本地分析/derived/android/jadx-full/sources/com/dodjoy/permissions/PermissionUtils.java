package com.dodjoy.permissions;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class PermissionUtils {
    PermissionUtils() {
    }

    static boolean checkMorePermissionPermanentDenied(android.app.Activity activity, java.util.List<java.lang.String> list) {
        for (java.lang.String str : list) {
            if (!str.equals(com.dodjoy.permissions.Permission.REQUEST_INSTALL_PACKAGES) && !str.equals(com.dodjoy.permissions.Permission.SYSTEM_ALERT_WINDOW) && checkSinglePermissionPermanentDenied(activity, str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void checkPermissions(android.app.Activity activity, java.util.List<java.lang.String> list) {
        java.util.List<java.lang.String> manifestPermissions = getManifestPermissions(activity);
        if (manifestPermissions == null || manifestPermissions.isEmpty()) {
            throw new com.dodjoy.permissions.ManifestRegisterException(null);
        }
        for (java.lang.String str : list) {
            if (!manifestPermissions.contains(str)) {
                throw new com.dodjoy.permissions.ManifestRegisterException(str);
            }
        }
    }

    private static boolean checkSinglePermissionPermanentDenied(android.app.Activity activity, java.lang.String str) {
        return (!(str.equals(com.dodjoy.permissions.Permission.ANSWER_PHONE_CALLS) || str.equals(com.dodjoy.permissions.Permission.READ_PHONE_NUMBERS)) || isOverOreo()) && isOverMarshmallow() && activity.checkSelfPermission(str) == -1 && !activity.shouldShowRequestPermissionRationale(str);
    }

    static void checkTargetSdkVersion(android.content.Context context, java.util.List<java.lang.String> list) {
        if (list.contains(com.dodjoy.permissions.Permission.REQUEST_INSTALL_PACKAGES) || list.contains(com.dodjoy.permissions.Permission.ANSWER_PHONE_CALLS) || list.contains(com.dodjoy.permissions.Permission.READ_PHONE_NUMBERS)) {
            if (context.getApplicationInfo().targetSdkVersion < 26) {
                throw new java.lang.RuntimeException("The targetSdkVersion SDK must be 26 or more");
            }
        } else if (context.getApplicationInfo().targetSdkVersion < 23) {
            throw new java.lang.RuntimeException("The targetSdkVersion SDK must be 23 or more");
        }
    }

    static java.util.ArrayList<java.lang.String> getFailPermissions(android.content.Context context, java.util.List<java.lang.String> list) {
        java.util.ArrayList<java.lang.String> arrayList = null;
        if (!isOverMarshmallow()) {
            return null;
        }
        for (java.lang.String str : list) {
            if (str.equals(com.dodjoy.permissions.Permission.REQUEST_INSTALL_PACKAGES)) {
                if (!isHasInstallPermission(context)) {
                    if (arrayList == null) {
                        arrayList = new java.util.ArrayList<>();
                    }
                    arrayList.add(str);
                }
            } else if (str.equals(com.dodjoy.permissions.Permission.SYSTEM_ALERT_WINDOW)) {
                if (!isHasOverlaysPermission(context)) {
                    if (arrayList == null) {
                        arrayList = new java.util.ArrayList<>();
                    }
                    arrayList.add(str);
                }
            } else if ((!str.equals(com.dodjoy.permissions.Permission.ANSWER_PHONE_CALLS) && !str.equals(com.dodjoy.permissions.Permission.READ_PHONE_NUMBERS)) || isOverOreo()) {
                if (context.checkSelfPermission(str) == -1) {
                    if (arrayList == null) {
                        arrayList = new java.util.ArrayList<>();
                    }
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    static java.util.List<java.lang.String> getFailPermissions(java.lang.String[] strArr, int[] iArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == -1) {
                arrayList.add(strArr[i]);
            }
        }
        return arrayList;
    }

    static java.util.List<java.lang.String> getManifestPermissions(android.content.Context context) {
        try {
            return java.util.Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    static java.util.List<java.lang.String> getSucceedPermissions(java.lang.String[] strArr, int[] iArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == 0) {
                arrayList.add(strArr[i]);
            }
        }
        return arrayList;
    }

    static boolean isHasInstallPermission(android.content.Context context) {
        if (isOverOreo()) {
            return context.getPackageManager().canRequestPackageInstalls();
        }
        return true;
    }

    static boolean isHasOverlaysPermission(android.content.Context context) {
        if (isOverMarshmallow()) {
            return android.provider.Settings.canDrawOverlays(context);
        }
        return true;
    }

    static boolean isOverMarshmallow() {
        return android.os.Build.VERSION.SDK_INT >= 23;
    }

    static boolean isOverOreo() {
        return android.os.Build.VERSION.SDK_INT >= 26;
    }

    static boolean isRequestDeniedPermission(android.app.Activity activity, java.util.List<java.lang.String> list) {
        for (java.lang.String str : list) {
            if (!str.equals(com.dodjoy.permissions.Permission.REQUEST_INSTALL_PACKAGES) && !str.equals(com.dodjoy.permissions.Permission.SYSTEM_ALERT_WINDOW) && !checkSinglePermissionPermanentDenied(activity, str)) {
                return true;
            }
        }
        return false;
    }
}
