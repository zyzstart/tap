package com.tencent.ysdk.shell.module.launchgift;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface LaunchGiftInterface {
    boolean checkLaunchGift();

    java.lang.String getGameUID();

    java.lang.String getYYB_GUID();

    void handleIntent(android.content.Intent intent);

    void notifyLaunchGift(com.tencent.ysdk.shell.module.launchgift.impl.LaunchGiftDataEntity launchGiftDataEntity);

    void regOnLaunchGiftListener(com.tencent.ysdk.module.launchgift.OnLaunchGiftListener onLaunchGiftListener);

    void setGameUID(java.lang.String str);

    void showLaunchGiftView();
}
