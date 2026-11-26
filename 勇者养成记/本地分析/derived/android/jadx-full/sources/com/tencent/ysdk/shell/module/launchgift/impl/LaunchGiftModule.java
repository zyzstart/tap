package com.tencent.ysdk.shell.module.launchgift.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class LaunchGiftModule extends com.tencent.ysdk.shell.module.Module implements com.tencent.ysdk.shell.module.launchgift.LaunchGiftInterface {
    private static final java.lang.String ICON_DEFAULT_VERSION = "YSDK_1";
    private static final java.lang.String INTENT_LAUNCH_FROM_YYB = "INTENT_LAUNCH_FROM_YYB";
    private static final java.lang.String INTENT_LAUNCH_FROM_YYB_PARAM = "INTENT_LAUNCH_FROM_YYB_PARAM";
    public static final java.lang.String TAG = "YSDK_LAUNCH_GIFT";
    private com.tencent.ysdk.module.launchgift.OnLaunchGiftListener onLaunchGiftListener;
    private java.lang.String gameUid = "";
    private java.lang.String yybGuid = "";
    private boolean isLaunchFromYYB = false;

    public LaunchGiftModule() {
        this.name = com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_LAUNCH_GIFT;
    }

    @Override // com.tencent.ysdk.shell.module.launchgift.LaunchGiftInterface
    public boolean checkLaunchGift() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "checkLaunchGift isLaunchFromYYB:" + this.isLaunchFromYYB);
        return this.isLaunchFromYYB;
    }

    @Override // com.tencent.ysdk.shell.module.launchgift.LaunchGiftInterface
    public java.lang.String getGameUID() {
        return this.gameUid;
    }

    @Override // com.tencent.ysdk.shell.module.launchgift.LaunchGiftInterface
    public java.lang.String getYYB_GUID() {
        return this.yybGuid;
    }

    @Override // com.tencent.ysdk.shell.module.launchgift.LaunchGiftInterface
    public void handleIntent(android.content.Intent intent) {
        try {
            this.isLaunchFromYYB = intent.getBooleanExtra(INTENT_LAUNCH_FROM_YYB, this.isLaunchFromYYB);
            java.lang.String stringExtra = intent.getStringExtra(INTENT_LAUNCH_FROM_YYB_PARAM);
            if (!android.text.TextUtils.isEmpty(stringExtra)) {
                this.yybGuid = stringExtra;
            }
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "handleIntent isLaunchFromYYB:" + this.isLaunchFromYYB);
        } catch (java.lang.Exception unused) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "handleIntent isLaunchFromYYB fail");
        }
    }

    @Override // com.tencent.ysdk.shell.module.Module
    public void init() {
        super.init();
    }

    @Override // com.tencent.ysdk.shell.module.launchgift.LaunchGiftInterface
    public void notifyLaunchGift(com.tencent.ysdk.shell.module.launchgift.impl.LaunchGiftDataEntity launchGiftDataEntity) {
        try {
            if (this.onLaunchGiftListener == null || launchGiftDataEntity == null) {
                com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "LaunchGift send to game has Exception: onLaunchGiftListener is Null or launchGiftData is Null");
            } else {
                com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "LaunchGift send to game success: onLaunchGiftListener is calling ");
                this.onLaunchGiftListener.notifyLaunchGift(launchGiftDataEntity.conf, launchGiftDataEntity.ts, launchGiftDataEntity.sig);
                com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "LaunchGift send to game success: onLaunchGiftListener is called ");
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "LaunchGift send to game has Exception:" + e.getMessage());
        }
    }

    @Override // com.tencent.ysdk.shell.module.launchgift.LaunchGiftInterface
    public void regOnLaunchGiftListener(com.tencent.ysdk.module.launchgift.OnLaunchGiftListener onLaunchGiftListener) {
        this.onLaunchGiftListener = onLaunchGiftListener;
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "regOnLaunchGiftListener success :" + onLaunchGiftListener.toString());
    }

    @Override // com.tencent.ysdk.shell.module.launchgift.LaunchGiftInterface
    public void setGameUID(java.lang.String str) {
        this.gameUid = str;
    }

    @Override // com.tencent.ysdk.shell.module.launchgift.LaunchGiftInterface
    public void showLaunchGiftView() {
        if (android.text.TextUtils.isEmpty(getGameUID())) {
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_DOCTOR", "showLaunchGiftView send to sdk with extraData uid is null");
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "showLaunchGiftView send to sdk with extraData uid:" + getGameUID());
        }
        com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconApiImpl.getInstance().performFeature(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_LAUNCH_GIFT);
        this.isLaunchFromYYB = false;
    }
}
