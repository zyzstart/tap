package com.dodjoy.dodlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class NotchInScreenHelper {
    public static final int NOTCH_IN_SCREEN_VOIO = 32;
    public static final int ROUNDED_IN_SCREEN_VOIO = 8;

    public static boolean hasNotchInScreen(android.app.Activity activity) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            try {
                if (activity.getWindow().getDecorView().getRootWindowInsets().getDisplayCutout() != null) {
                    return true;
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return hasNotchInScreenAtHuawei(activity) || hasNotchInScreenAtOppo(activity) || hasNotchInScreenAtVoio(activity);
    }

    public static boolean hasNotchInScreenAtHuawei(android.content.Context context) {
        try {
            try {
                try {
                    java.lang.Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                    return ((java.lang.Boolean) clsLoadClass.getMethod("hasNotchInScreen", new java.lang.Class[0]).invoke(clsLoadClass, new java.lang.Object[0])).booleanValue();
                } catch (java.lang.ClassNotFoundException unused) {
                    android.util.Log.e(com.tencent.midas.api.APMidasPayAPI.ENV_TEST, "hasNotchInScreen ClassNotFoundException");
                    return false;
                }
            } catch (java.lang.NoSuchMethodException unused2) {
                android.util.Log.e(com.tencent.midas.api.APMidasPayAPI.ENV_TEST, "hasNotchInScreen NoSuchMethodException");
                return false;
            } catch (java.lang.Exception unused3) {
                android.util.Log.e(com.tencent.midas.api.APMidasPayAPI.ENV_TEST, "hasNotchInScreen Exception");
                return false;
            }
        } catch (java.lang.Throwable unused4) {
            return false;
        }
    }

    public static boolean hasNotchInScreenAtOppo(android.content.Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean hasNotchInScreenAtVoio(android.content.Context context) {
        try {
            try {
                try {
                    java.lang.Class<?> clsLoadClass = context.getClassLoader().loadClass("com.util.FtFeature");
                    return ((java.lang.Boolean) clsLoadClass.getMethod("isFeatureSupport", java.lang.Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
                } catch (java.lang.ClassNotFoundException unused) {
                    android.util.Log.e(com.tencent.midas.api.APMidasPayAPI.ENV_TEST, "hasNotchInScreen ClassNotFoundException");
                    return false;
                }
            } catch (java.lang.NoSuchMethodException unused2) {
                android.util.Log.e(com.tencent.midas.api.APMidasPayAPI.ENV_TEST, "hasNotchInScreen NoSuchMethodException");
                return false;
            } catch (java.lang.Exception unused3) {
                android.util.Log.e(com.tencent.midas.api.APMidasPayAPI.ENV_TEST, "hasNotchInScreen Exception");
                return false;
            }
        } catch (java.lang.Throwable unused4) {
            return false;
        }
    }
}
