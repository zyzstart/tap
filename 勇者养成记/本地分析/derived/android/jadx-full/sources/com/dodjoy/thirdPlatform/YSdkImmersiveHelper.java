package com.dodjoy.thirdPlatform;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YSdkImmersiveHelper {
    public static void performFeature(final java.lang.String str) {
        com.dodjoy.platform.PlatformInterface.getCurActivity().runOnUiThread(new java.lang.Runnable() { // from class: com.dodjoy.thirdPlatform.YSdkImmersiveHelper.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ysdk.module.immersiveicon.ImmersiveIconApi.getInstance().performFeature(str);
            }
        });
    }
}
