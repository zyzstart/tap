package com.tencent.ysdk.shell.module.cloud;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class CloudSettingsWrapper {
    private static volatile com.tencent.ysdk.shell.module.cloud.CloudSettingsWrapper instance;

    private class UserInnerLoginListenerImp implements com.tencent.ysdk.shell.module.user.UserInnerLoginListener {
        private UserInnerLoginListenerImp() {
        }

        @Override // com.tencent.ysdk.shell.module.user.UserInnerLoginListener
        public void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
            if (userLoginRet.ret == 0 && userLoginRet.flag == 0) {
                com.tencent.ysdk.shell.module.cloud.CloudSettingsWrapper.this.pullCloudSettings(1);
            }
        }
    }

    private CloudSettingsWrapper() {
        com.tencent.ysdk.shell.module.user.UserApi.setUserInnerLoginListener(new com.tencent.ysdk.shell.module.cloud.CloudSettingsWrapper.UserInnerLoginListenerImp());
    }

    static com.tencent.ysdk.shell.module.cloud.CloudSettingsWrapper getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.cloud.CloudSettingsWrapper.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.cloud.CloudSettingsWrapper();
                }
            }
        }
        return instance;
    }

    protected void pullCloudSettings(int i) {
        com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManager.getInstance().pullCloudSettings(i);
        com.tencent.ysdk.shell.module.cloud.newconfig.ConfigSettingsManager.getInstance().pullCloudSettings(i);
    }
}
