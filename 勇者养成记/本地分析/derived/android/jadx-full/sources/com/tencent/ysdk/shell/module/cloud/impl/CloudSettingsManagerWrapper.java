package com.tencent.ysdk.shell.module.cloud.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CloudSettingsManagerWrapper {
    private static final java.lang.String TAG = "YSDK Settings Wrapper";
    private static volatile com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManagerWrapper instance;
    private com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManager cloudSettingsManager = com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManager.getInstance();

    private class UserInnerLoginListenerImp implements com.tencent.ysdk.shell.module.user.UserInnerLoginListener {
        private UserInnerLoginListenerImp() {
        }

        @Override // com.tencent.ysdk.shell.module.user.UserInnerLoginListener
        public void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
            if (userLoginRet.ret == 0 && userLoginRet.flag == 0) {
                com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManagerWrapper.this.pullCloudSettings(1);
            }
        }
    }

    private CloudSettingsManagerWrapper() {
        com.tencent.ysdk.shell.module.user.UserApi.setUserInnerLoginListener(new com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManagerWrapper.UserInnerLoginListenerImp());
    }

    public static com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManagerWrapper getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManagerWrapper.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManagerWrapper();
                }
            }
        }
        return instance;
    }

    private void pullCloudSettingsAfterLogin() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "pullCloudSettingsAfterLogin");
    }

    private void pullCloudSettingsAfterStart() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "pullCloudSettingsAfterStart");
        com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.getInstance().wakeUp(new com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpTaskParameter(com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.YSDK_WAKE_SWITCH, 0) == 1, com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.YSDK_WAKE_TIMES, 3), com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.YSDK_WAKE_RETRY_TIMES, 3), com.tencent.ysdk.shell.libware.util.CommonUtils.parseLong(com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.YSDK_WAKE_YYB_MIN_VER, java.lang.Long.toString(Long.MAX_VALUE)), Long.MAX_VALUE), com.tencent.ysdk.shell.libware.apk.APKListUtils.checkAppInstalled(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), "com.tencent.android.qqdownloader"), new com.tencent.ysdk.shell.module.cloud.tasks.wakeup.LastWakeUpInfo(((java.lang.Long) com.tencent.ysdk.shell.libware.util.AppSharePreferenceMgr.get(com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.KEY_LAST_WAKE_TIME_STAMP, 0L)).longValue(), ((java.lang.Integer) com.tencent.ysdk.shell.libware.util.AppSharePreferenceMgr.get(com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.KEY_LAST_WAKE_COUNT, 0)).intValue())));
    }

    public java.lang.String getSoMd5() {
        return this.cloudSettingsManager.getSoMd5();
    }

    public void pullCloudSettings(int i) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "pullCloudSettings：" + i);
        switch (i) {
            case 0:
                this.cloudSettingsManager.pullCloudSettings(0);
                pullCloudSettingsAfterStart();
                break;
            case 1:
                pullCloudSettingsAfterLogin();
                break;
        }
    }
}
