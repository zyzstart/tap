package com.tencent.ysdk.shell.libware.apk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PackageUtils {
    private static java.lang.String mPackageName = "";

    private static int compare(java.lang.String str, java.lang.String str2) {
        java.lang.String strRemoveFrontZero = removeFrontZero(str);
        java.lang.String strRemoveFrontZero2 = removeFrontZero(str2);
        if (strRemoveFrontZero.length() > strRemoveFrontZero2.length()) {
            return 1;
        }
        if (strRemoveFrontZero.length() < strRemoveFrontZero2.length()) {
            return -1;
        }
        for (int i = 0; i < strRemoveFrontZero.length(); i++) {
            int iCharAt = strRemoveFrontZero.charAt(i) - strRemoveFrontZero2.charAt(i);
            if (iCharAt > 0) {
                return 1;
            }
            if (iCharAt < 0) {
                return -1;
            }
        }
        return 0;
    }

    public static int compareVersion(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        java.lang.String[] strArrSplit = str.split("\\.");
        java.lang.String[] strArrSplit2 = str2.split("\\.");
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= strArrSplit.length && i2 >= strArrSplit2.length) {
                return 0;
            }
            int iCompare = compare(i < strArrSplit.length ? strArrSplit[i] : "0", i2 < strArrSplit2.length ? strArrSplit2[i2] : "0");
            if (iCompare != 0) {
                return iCompare;
            }
            i++;
            i2++;
        }
    }

    public static java.lang.String getAppName(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getAppVersionCode(android.content.Context context) {
        return getAppVersionCode(context, context.getPackageName());
    }

    public static int getAppVersionCode(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            android.content.pm.PackageInfo packageInfo = packageManager != null ? packageManager.getPackageInfo(str, 0) : null;
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static java.lang.String getAppVersionName(android.content.Context context) {
        return getAppVersionName(context, context.getPackageName());
    }

    public static java.lang.String getAppVersionName(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            android.content.pm.PackageInfo packageInfo = packageManager != null ? packageManager.getPackageInfo(str, 0) : null;
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String getPackageName(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(mPackageName)) {
            return mPackageName;
        }
        mPackageName = context.getPackageName();
        return mPackageName;
    }

    public static boolean isInstalledApp(android.content.Context context, java.lang.String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private static java.lang.String removeFrontZero(java.lang.String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length() && str.charAt(i2) == '0'; i2++) {
            i++;
        }
        return str.substring(i);
    }
}
