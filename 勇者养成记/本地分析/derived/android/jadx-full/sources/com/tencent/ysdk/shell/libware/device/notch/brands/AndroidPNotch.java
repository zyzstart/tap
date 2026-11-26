package com.tencent.ysdk.shell.libware.device.notch.brands;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AndroidPNotch implements com.tencent.ysdk.shell.libware.device.notch.INotch {
    private static final java.lang.String TAG = "AndroidPNotch";
    private com.tencent.ysdk.shell.libware.device.notch.NotchInfo mNotchInfo;

    @androidx.annotation.RequiresApi(api = 28)
    private com.tencent.ysdk.shell.libware.device.notch.NotchInfo getNotchInfoInner(android.content.Context context) {
        android.view.DisplayCutout displayCutout;
        if (!(context instanceof android.app.Activity)) {
            return null;
        }
        android.view.View decorView = ((android.app.Activity) context).getWindow().getDecorView();
        if (decorView.getWidth() == 0) {
            return null;
        }
        android.view.WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
        if (rootWindowInsets != null && (displayCutout = rootWindowInsets.getDisplayCutout()) != null) {
            java.util.List<android.graphics.Rect> boundingRects = displayCutout.getBoundingRects();
            return boundingRects.isEmpty() ? new com.tencent.ysdk.shell.libware.device.notch.NotchInfo() : new com.tencent.ysdk.shell.libware.device.notch.NotchInfo(boundingRects.get(0));
        }
        return new com.tencent.ysdk.shell.libware.device.notch.NotchInfo();
    }

    @Override // com.tencent.ysdk.shell.libware.device.notch.INotch
    public com.tencent.ysdk.shell.libware.device.notch.NotchInfo getNotchInfo(android.content.Context context) {
        com.tencent.ysdk.shell.libware.device.notch.NotchInfo notchInfo = this.mNotchInfo;
        if (notchInfo != null) {
            return notchInfo;
        }
        if (android.os.Build.VERSION.SDK_INT < 28) {
            this.mNotchInfo = new com.tencent.ysdk.shell.libware.device.notch.NotchInfo();
            return this.mNotchInfo;
        }
        try {
            com.tencent.ysdk.shell.libware.device.notch.NotchInfo notchInfoInner = getNotchInfoInner(context);
            if (notchInfoInner == null) {
                return new com.tencent.ysdk.shell.libware.device.notch.NotchInfo();
            }
            return !notchInfoInner.hasNotch() ? notchInfoInner : notchInfoInner;
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
            return new com.tencent.ysdk.shell.libware.device.notch.NotchInfo();
        }
    }
}
