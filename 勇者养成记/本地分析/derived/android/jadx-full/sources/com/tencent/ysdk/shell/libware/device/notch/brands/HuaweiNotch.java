package com.tencent.ysdk.shell.libware.device.notch.brands;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class HuaweiNotch extends com.tencent.ysdk.shell.libware.device.notch.brands.AbstractCommonNotch {
    private int[] getNotchSize(android.content.Context context) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.reflect.InvocationTargetException {
        java.lang.Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
        return (int[]) clsLoadClass.getMethod("getNotchSize", new java.lang.Class[0]).invoke(clsLoadClass, new java.lang.Object[0]);
    }

    @Override // com.tencent.ysdk.shell.libware.device.notch.brands.AbstractCommonNotch
    protected android.graphics.Rect getNotchRect(android.content.Context context) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.reflect.InvocationTargetException {
        int[] notchSize = getNotchSize(context);
        return notchSize == null ? generateCommonRect(context, 0, 0) : generateCommonRect(context, notchSize[0], notchSize[1]);
    }

    @Override // com.tencent.ysdk.shell.libware.device.notch.brands.AbstractCommonNotch
    protected boolean hasNotch(android.content.Context context) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.reflect.InvocationTargetException {
        java.lang.Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
        return ((java.lang.Boolean) clsLoadClass.getMethod("hasNotchInScreen", new java.lang.Class[0]).invoke(clsLoadClass, new java.lang.Object[0])).booleanValue();
    }
}
