package com.tencent.ysdk.shell.libware.apk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PermissionUtils {
    private PermissionUtils() {
    }

    public static boolean checkPermissions(android.content.Context context, java.lang.String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                return true;
            }
            java.lang.String str = strArr[i];
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            if (!(context.checkCallingOrSelfPermission(str) == 0)) {
                return false;
            }
            i++;
        }
    }

    public static boolean hasAccessNetworkStatePermission(android.content.Context context) {
        if (context == null) {
            return false;
        }
        return checkPermissions(context, com.unisound.client.SpeechConstants.PERMISSION_ACCESS_NETWORK_STATE);
    }

    public static boolean hasReadPhoneStatePermission(android.content.Context context) {
        return checkPermissions(context, "android.permission.READ_PHONE_STATE");
    }

    public static boolean hasReadWriteExternalPermission(android.content.Context context) {
        if (context == null) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT < 16 || android.os.Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return checkPermissions(context, com.dodjoy.permissions.Permission.READ_EXTERNAL_STORAGE, "android.permission.WRITE_EXTERNAL_STORAGE");
    }
}
