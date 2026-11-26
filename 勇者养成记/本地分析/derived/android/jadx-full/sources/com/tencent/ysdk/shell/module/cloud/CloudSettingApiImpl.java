package com.tencent.ysdk.shell.module.cloud;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.2.4")
public class CloudSettingApiImpl implements com.tencent.ysdk.module.cloud.ICloudSettingApi {
    public static final int PULL_CLOUD_SCENE_LOGIN = 1;
    public static final int PULL_CLOUD_SCENE_START = 0;
    private static volatile com.tencent.ysdk.shell.module.cloud.CloudSettingApiImpl instance;

    public static com.tencent.ysdk.shell.module.cloud.CloudSettingApiImpl getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.bugly.BuglyApi.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.cloud.CloudSettingApiImpl();
                }
            }
        }
        return instance;
    }

    @Override // com.tencent.ysdk.module.cloud.ICloudSettingApi
    public java.lang.String getSoMd5() {
        com.tencent.ysdk.libware.file.Logger.d("getSoMd5");
        return com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManager.getInstance().getSoMd5();
    }

    @Override // com.tencent.ysdk.module.cloud.ICloudSettingApi
    public void printAllConfig() {
        com.tencent.ysdk.shell.framework.config.Config.printAllConfig();
    }

    @Override // com.tencent.ysdk.module.cloud.ICloudSettingApi
    public void pullCloudSettings(int i) {
        com.tencent.ysdk.libware.file.Logger.d("pullCloudSettings");
        com.tencent.ysdk.shell.module.cloud.CloudSettingsWrapper.getInstance().pullCloudSettings(i);
    }
}
