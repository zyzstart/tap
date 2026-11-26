package com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class IconViewTouchStrategyFactory {
    private IconViewTouchStrategyFactory() {
    }

    public static com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy getCommonTouchStrategy(com.tencent.ysdk.shell.framework.YSDKSystem ySDKSystem, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy.IconViewTouchCallback iconViewTouchCallback) {
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewCommonTouchStrategy iconViewCommonTouchStrategy = new com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewCommonTouchStrategy(ySDKSystem.getApplicationContext(), iconViewTouchCallback);
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.notch.AndroidPIconViewInterceptor androidPIconViewInterceptor = new com.tencent.ysdk.shell.module.icon.impl.floatingviews.notch.AndroidPIconViewInterceptor(ySDKSystem);
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.notch.DeviceIconViewInterceptor deviceIconViewInterceptor = new com.tencent.ysdk.shell.module.icon.impl.floatingviews.notch.DeviceIconViewInterceptor(ySDKSystem);
        iconViewCommonTouchStrategy.addInterceptor(androidPIconViewInterceptor);
        iconViewCommonTouchStrategy.addInterceptor(deviceIconViewInterceptor);
        return iconViewCommonTouchStrategy;
    }
}
