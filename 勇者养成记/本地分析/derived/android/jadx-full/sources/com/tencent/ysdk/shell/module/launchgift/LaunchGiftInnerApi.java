package com.tencent.ysdk.shell.module.launchgift;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class LaunchGiftInnerApi {
    public static java.lang.String getGameUID() {
        return com.tencent.ysdk.shell.module.launchgift.LaunchGiftApiImpl.getInstance().launchGiftInterface == null ? "" : com.tencent.ysdk.shell.module.launchgift.LaunchGiftApiImpl.getInstance().launchGiftInterface.getGameUID();
    }

    public static java.lang.String getYYB_GUID() {
        return com.tencent.ysdk.shell.module.launchgift.LaunchGiftApiImpl.getInstance().launchGiftInterface == null ? "" : com.tencent.ysdk.shell.module.launchgift.LaunchGiftApiImpl.getInstance().launchGiftInterface.getYYB_GUID();
    }

    public static void handleIntent(android.content.Intent intent) {
        if (com.tencent.ysdk.shell.module.launchgift.LaunchGiftApiImpl.getInstance().launchGiftInterface == null) {
            return;
        }
        com.tencent.ysdk.shell.module.launchgift.LaunchGiftApiImpl.getInstance().launchGiftInterface.handleIntent(intent);
    }

    public static void notifyLaunchGift(com.tencent.ysdk.shell.module.launchgift.impl.LaunchGiftDataEntity launchGiftDataEntity) {
        if (com.tencent.ysdk.shell.module.launchgift.LaunchGiftApiImpl.getInstance().launchGiftInterface == null) {
            return;
        }
        com.tencent.ysdk.shell.module.launchgift.LaunchGiftApiImpl.getInstance().launchGiftInterface.notifyLaunchGift(launchGiftDataEntity);
    }
}
