package com.tencent.ysdk.shell.module.cloud.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CloudSettingsManager {
    private static final java.lang.String TAG = "YSDK Settings";
    private static final java.lang.String YSDK_SO_NAME = "YSDK";
    private static volatile com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManager instance;
    private final java.lang.String[] mLibPaths = initLibPaths();

    private class PullConfigResponesHandler implements com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigResponse> {
        private com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigRequestPara mRequestPara;

        public PullConfigResponesHandler(com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigRequestPara pullConfigRequestPara) {
            this.mRequestPara = null;
            this.mRequestPara = pullConfigRequestPara;
        }

        @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
        public void onResponse(com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigResponse pullConfigResponse) {
            com.tencent.ysdk.shell.libware.file.Logger.d(pullConfigResponse.toString());
            if (pullConfigResponse.ret == 0 && !com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(pullConfigResponse.mConfigInfo)) {
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManager.TAG, "parse config");
                com.tencent.ysdk.shell.framework.config.ConfigManager.getInstance().initSpecialConfig(this.mRequestPara.platform, this.mRequestPara.openid);
                com.tencent.ysdk.shell.framework.config.ConfigManager.getInstance().parseCloudConf(pullConfigResponse.mConfigInfo);
            }
            java.util.HashMap map = new java.util.HashMap();
            map.put(com.tencent.tmselfupdatesdk.TMSelfUpdateConst.BUNDLE_KEY_SCENE, java.lang.String.valueOf(this.mRequestPara.scene));
            com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
            if (loginRecord.flag == 0) {
                com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.stat.StatHelper.EVENT_CLOUD, pullConfigResponse.flag, pullConfigResponse.msg, loginRecord.platform, loginRecord.open_id, map, java.lang.System.currentTimeMillis(), false);
            } else {
                com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.stat.StatHelper.EVENT_CLOUD, pullConfigResponse.flag, pullConfigResponse.msg, this.mRequestPara.platform, "", map, java.lang.System.currentTimeMillis(), false);
            }
        }
    }

    private class UserInnerLoginListenerImp implements com.tencent.ysdk.shell.module.user.UserInnerLoginListener {
        private UserInnerLoginListenerImp() {
        }

        @Override // com.tencent.ysdk.shell.module.user.UserInnerLoginListener
        public void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
            if (userLoginRet.ret == 0 && userLoginRet.flag == 0) {
                com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManager.this.pullCloudSettings(1);
            }
        }
    }

    private CloudSettingsManager() {
        com.tencent.ysdk.shell.module.user.UserApi.setUserInnerLoginListener(new com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManager.UserInnerLoginListenerImp());
    }

    public static com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManager getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManager.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManager();
                }
            }
        }
        return instance;
    }

    private static java.lang.String[] initLibPaths() {
        java.lang.String property = java.lang.System.getProperty("java.library.path");
        if (property == null) {
            return null;
        }
        java.lang.String[] strArrSplit = property.split(":");
        for (int i = 0; i < strArrSplit.length; i++) {
            if (!strArrSplit[i].endsWith("/")) {
                strArrSplit[i] = strArrSplit[i] + "/";
            }
        }
        return strArrSplit;
    }

    private void pullCloudSettingsAfterStart() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "pullCloudSettingsAfterStart");
        com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.getInstance().wakeUp(new com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpTaskParameter(com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.YSDK_WAKE_SWITCH, 0) == 1, com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.YSDK_WAKE_TIMES, 3), com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.YSDK_WAKE_RETRY_TIMES, 3), com.tencent.ysdk.shell.libware.util.CommonUtils.parseLong(com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.YSDK_WAKE_YYB_MIN_VER, java.lang.Long.toString(Long.MAX_VALUE)), Long.MAX_VALUE), com.tencent.ysdk.shell.libware.apk.APKListUtils.checkAppInstalled(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), "com.tencent.android.qqdownloader"), new com.tencent.ysdk.shell.module.cloud.tasks.wakeup.LastWakeUpInfo(((java.lang.Long) com.tencent.ysdk.shell.libware.util.AppSharePreferenceMgr.get(com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.KEY_LAST_WAKE_TIME_STAMP, 0L)).longValue(), ((java.lang.Integer) com.tencent.ysdk.shell.libware.util.AppSharePreferenceMgr.get(com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.KEY_LAST_WAKE_COUNT, 0)).intValue())));
    }

    public java.lang.String getSoMd5() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "getSoMd5");
        java.lang.String str = "";
        try {
            if (android.os.Build.VERSION.SDK_INT > 8) {
                str = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getApplicationInfo().nativeLibraryDir;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            str = "";
        }
        java.io.File file = new java.io.File((str == null || str.equals("")) ? ((dalvik.system.PathClassLoader) com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().getClassLoader()).findLibrary("YSDK") : str + "/" + java.lang.System.mapLibraryName("YSDK"));
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, java.lang.Boolean.valueOf(file.exists()));
        if (!file.exists()) {
            java.lang.String strMapLibraryName = java.lang.System.mapLibraryName("YSDK");
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, strMapLibraryName.toString());
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.String str2 : this.mLibPaths) {
                java.lang.String str3 = str2 + strMapLibraryName;
                arrayList.add(str3);
                if (new java.io.File(str3).exists()) {
                    file = new java.io.File(str3);
                    break;
                }
            }
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, file.toString());
        java.lang.String fileMD5 = file.exists() ? com.tencent.ysdk.shell.libware.encrypt.MD5.getFileMD5(file) : "";
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, fileMD5);
        return fileMD5;
    }

    public void pullCloudSettings(int i) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "pullCloudSettings：" + i);
        com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigRequestPara pullConfigRequestPara = new com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigRequestPara();
        pullConfigRequestPara.appid = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId();
        switch (i) {
            case 0:
                pullConfigRequestPara.scene = 0;
                pullConfigRequestPara.soMd5 = getSoMd5();
                pullConfigRequestPara.channel = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId();
                pullConfigRequestPara.productModel = com.tencent.ysdk.shell.libware.device.DeviceUtils.getModel();
                pullConfigRequestPara.qimei = com.tencent.ysdk.shell.module.stat.StatApi.getQImei();
                pullConfigRequestPara.qimei36 = com.tencent.ysdk.shell.libware.device.DeviceUtils.getQImei36();
                pullConfigRequestPara.os = java.lang.String.valueOf(com.tencent.ysdk.shell.libware.device.DeviceUtils.getOS());
                pullConfigRequestPara.osVersion = com.tencent.ysdk.shell.libware.device.DeviceUtils.getSystemVersion();
                pullConfigRequestPara.sdkVersion = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion();
                pullConfigRequestPara.appVersionName = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getGameVersionName();
                pullConfigRequestPara.appVersionCode = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getGameVersionCode();
                pullConfigRequestPara.apn = com.tencent.ysdk.shell.libware.device.APNUtil.getApnName(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext());
                com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigRequest(pullConfigRequestPara, new com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManager.PullConfigResponesHandler(pullConfigRequestPara)));
                pullCloudSettingsAfterStart();
                break;
            case 1:
                pullConfigRequestPara.scene = 1;
                com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
                if (loginRecord.flag == 0) {
                    pullConfigRequestPara.openid = loginRecord.open_id;
                    pullConfigRequestPara.platform = loginRecord.platform;
                    pullConfigRequestPara.regChannel = loginRecord.getRegChannel();
                    com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigRequest(pullConfigRequestPara, new com.tencent.ysdk.shell.module.cloud.impl.CloudSettingsManager.PullConfigResponesHandler(pullConfigRequestPara)));
                }
                break;
        }
    }
}
