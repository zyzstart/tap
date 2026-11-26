package com.tencent.ysdk.shell.libware.device.notch.brands;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class VivoNotch extends com.tencent.ysdk.shell.libware.device.notch.brands.AbstractCommonNotch {
    private static final int VIVO_NOTCH_SUPPORT = 32;

    private float getDensity(android.content.Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    private int getNotchHeight(android.content.Context context) {
        return (int) (context.getResources().getDisplayMetrics().density * 27.0f);
    }

    private int getNotchWidth(android.content.Context context) {
        return (int) (getDensity(context) * 100.0f);
    }

    @Override // com.tencent.ysdk.shell.libware.device.notch.brands.AbstractCommonNotch
    protected android.graphics.Rect getNotchRect(android.content.Context context) {
        return generateCommonRect(context, getNotchWidth(context), getNotchHeight(context));
    }

    @Override // com.tencent.ysdk.shell.libware.device.notch.brands.AbstractCommonNotch
    protected boolean hasNotch(android.content.Context context) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.reflect.InvocationTargetException {
        java.lang.Class<?> clsLoadClass = context.getClassLoader().loadClass("VIVO_NOTCH");
        return ((java.lang.Boolean) clsLoadClass.getMethod("isFeatureSupport", java.lang.Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
    }
}
