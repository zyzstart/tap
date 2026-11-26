package com.tencent.ysdk.shell.libware.ui.res;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Res {
    public static int array(android.content.res.Resources resources, java.lang.String str, java.lang.String str2) {
        return reflectResouce(resources, "array", str, str2);
    }

    public static int array(java.lang.String str) {
        return array(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext().getResources(), str, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext().getPackageName());
    }

    public static int color(android.content.res.Resources resources, java.lang.String str, java.lang.String str2) {
        return reflectResouce(resources, "color", str, str2);
    }

    public static int color(java.lang.String str) {
        return color(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext().getResources(), str, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext().getPackageName());
    }

    public static int drawable(android.content.res.Resources resources, java.lang.String str, java.lang.String str2) {
        return reflectResouce(resources, "drawable", str, str2);
    }

    public static int drawable(java.lang.String str) {
        return drawable(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext().getResources(), str, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext().getPackageName());
    }

    public static int id(android.content.res.Resources resources, java.lang.String str, java.lang.String str2) {
        return reflectResouce(resources, "id", str, str2);
    }

    public static int id(java.lang.String str) {
        return id(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext().getResources(), str, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext().getPackageName());
    }

    public static int layout(android.content.res.Resources resources, java.lang.String str, java.lang.String str2) {
        return reflectResouce(resources, "layout", str, str2);
    }

    public static int layout(java.lang.String str) {
        return layout(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext().getResources(), str, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext().getPackageName());
    }

    private static int reflectResouce(android.content.res.Resources resources, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str == null || str2 == null) {
            com.tencent.ysdk.shell.libware.file.Logger.d("type || name null");
            return -1;
        }
        try {
            return resources.getIdentifier(str2, str, str3);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.ysdk.shell.libware.file.Logger.d("getIdentifier exception");
            return -1;
        }
    }

    public static int string(android.content.res.Resources resources, java.lang.String str, java.lang.String str2) {
        return reflectResouce(resources, "string", str, str2);
    }

    public static int string(java.lang.String str) {
        return string(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext().getResources(), str, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext().getPackageName());
    }

    public static int style(android.content.res.Resources resources, java.lang.String str, java.lang.String str2) {
        return reflectResouce(resources, "style", str, str2);
    }

    public static int style(java.lang.String str) {
        return style(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext().getResources(), str, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext().getPackageName());
    }
}
