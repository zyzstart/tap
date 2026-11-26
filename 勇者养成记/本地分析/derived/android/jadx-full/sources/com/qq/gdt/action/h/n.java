package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String[] f120a = {com.unisound.client.SpeechConstants.PERMISSION_INTERNET, com.unisound.client.SpeechConstants.PERMISSION_ACCESS_NETWORK_STATE, com.unisound.client.SpeechConstants.PERMISSION_ACCESS_WIFI_STATE};
    private static java.lang.String[] b = {"android.permission.READ_PHONE_STATE"};
    private static java.lang.String[] c = {com.unisound.client.SpeechConstants.PERMISSION_INTERNET, com.unisound.client.SpeechConstants.PERMISSION_ACCESS_NETWORK_STATE, com.unisound.client.SpeechConstants.PERMISSION_ACCESS_WIFI_STATE, "android.permission.READ_PHONE_STATE"};

    public static boolean a(android.content.Context context) {
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            java.lang.String[] strArr = packageInfo != null ? packageInfo.requestedPermissions : null;
            if (strArr == null || strArr.length <= 0) {
                return false;
            }
            return java.util.Arrays.asList(strArr).containsAll(java.util.Arrays.asList(c));
        } catch (java.lang.Exception e) {
            com.qq.gdt.action.h.l.b(e.getMessage());
            return false;
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        java.lang.Class<?> cls;
        try {
            cls = java.lang.Class.forName("android.support.v4.content.ContextCompat");
        } catch (java.lang.Exception unused) {
            cls = null;
        }
        if (cls == null) {
            try {
                cls = java.lang.Class.forName("androidx.core.content.ContextCompat");
            } catch (java.lang.Exception unused2) {
            }
        }
        if (cls == null) {
            return true;
        }
        try {
            if (((java.lang.Integer) cls.getMethod("checkSelfPermission", android.content.Context.class, java.lang.String.class).invoke(null, context, str)).intValue() == 0) {
                return true;
            }
            com.qq.gdt.action.h.l.c("请在AndroidManifest.xml文件中添加:\n<uses-permission android:name=\"" + str + "\" />");
            return false;
        } catch (java.lang.Exception e) {
            com.qq.gdt.action.h.l.a("Exception while check has permission " + str, e);
            return true;
        }
    }

    public static boolean b(android.content.Context context) {
        for (java.lang.String str : b) {
            if (!a(context, str)) {
                return false;
            }
        }
        return true;
    }
}
