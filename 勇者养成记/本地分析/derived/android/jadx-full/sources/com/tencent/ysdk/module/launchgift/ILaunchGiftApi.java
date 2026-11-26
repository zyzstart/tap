package com.tencent.ysdk.module.launchgift;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface ILaunchGiftApi {
    boolean checkLaunchGift();

    void regOnLaunchGiftListener(com.tencent.ysdk.module.launchgift.OnLaunchGiftListener onLaunchGiftListener);

    void setGameUID(java.lang.String str);

    void showLaunchGiftView();
}
