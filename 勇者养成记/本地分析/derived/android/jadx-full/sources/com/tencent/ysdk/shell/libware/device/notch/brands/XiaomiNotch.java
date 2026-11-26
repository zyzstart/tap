package com.tencent.ysdk.shell.libware.device.notch.brands;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class XiaomiNotch extends com.tencent.ysdk.shell.libware.device.notch.brands.AbstractCommonNotch {
    private int getNotchHeight(android.content.Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private int getNotchWidth(android.content.Context context) {
        int identifier = context.getResources().getIdentifier("notch_width", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @Override // com.tencent.ysdk.shell.libware.device.notch.brands.AbstractCommonNotch
    protected android.graphics.Rect getNotchRect(android.content.Context context) {
        return generateCommonRect(context, getNotchWidth(context), getNotchHeight(context));
    }

    @Override // com.tencent.ysdk.shell.libware.device.notch.brands.AbstractCommonNotch
    protected boolean hasNotch(android.content.Context context) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.reflect.InvocationTargetException {
        java.lang.Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
        return ((java.lang.Integer) clsLoadClass.getMethod("getInt", java.lang.String.class, java.lang.Integer.TYPE).invoke(clsLoadClass, "ro.miui.notch", 0)).intValue() == 1;
    }
}
