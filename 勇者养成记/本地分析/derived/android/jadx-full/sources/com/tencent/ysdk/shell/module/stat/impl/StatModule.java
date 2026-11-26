package com.tencent.ysdk.shell.module.stat.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class StatModule extends com.tencent.ysdk.shell.module.Module implements com.tencent.ysdk.shell.module.stat.StatInterface {
    private static final java.lang.String LIB_YDKQIMEI = "libQimei.so";
    private static final java.lang.String LIB_YDKQMP = "libydkqmp.so";
    public static final java.lang.String TAG = "YSDK SModule";
    public static final java.lang.String TUNNEL_APPKEY = "[REDACTED]";
    private android.content.Context context = null;
    private java.lang.String appId = null;
    private java.lang.String channelId = null;
    private boolean useBeacon = true;

    private class UserInnerLoginListenerImp implements com.tencent.ysdk.shell.module.user.UserInnerLoginListener {
        private UserInnerLoginListenerImp() {
        }

        @Override // com.tencent.ysdk.shell.module.user.UserInnerLoginListener
        public void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
            if (userLoginRet != null) {
                if (com.tencent.ysdk.shell.module.stat.impl.StatModule.this.useBeacon) {
                    com.tencent.beacon.event.UserAction.setUserID(userLoginRet.open_id);
                } else {
                    com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.stat.impl.StatModule.TAG, "beacon module is closed!");
                }
            }
        }
    }

    public StatModule() {
        this.name = com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_STAT;
    }

    private void checkBeaconSo() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "versionName = " + com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
        try {
            com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().loadPluginSo(LIB_YDKQMP);
        } catch (java.lang.UnsatisfiedLinkError e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
            com.tencent.ysdk.shell.framework.verification.UserTips.showBeaconSoSelfCheck(LIB_YDKQMP);
        }
        try {
            com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().loadPluginSo(LIB_YDKQIMEI);
        } catch (java.lang.UnsatisfiedLinkError e2) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e2);
            com.tencent.ysdk.shell.framework.verification.UserTips.showBeaconSoSelfCheck(LIB_YDKQIMEI);
        }
    }

    private void initBeaconReport4ForQimei36() {
        com.tencent.ydkbeacon.event.open.BeaconConfig beaconConfigBuild = com.tencent.ydkbeacon.event.open.BeaconConfig.builder().collectIMEIEnable(false).collectMACEnable(false).collectProcessInfoEnable(false).build();
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDebug()) {
            com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().setLogAble(true);
        } else {
            com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().setLogAble(false);
        }
        com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().setAppVersion(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
        com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().start(this.context, TUNNEL_APPKEY, beaconConfigBuild);
    }

    private void reportTunelData(java.lang.String str, boolean z, long j, long j2, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2, boolean z2) {
        com.tencent.beacon.event.UserAction.onUserActionToTunnel(TUNNEL_APPKEY, str.replace("[REDACTED]", "[REDACTED]").replace(com.tencent.ysdk.shell.module.cloud.tasks.wakeup.WakeUpManager.KEY_YSDK, "[REDACTED]"), z, j, j2, map, z2, false);
    }

    @Override // com.tencent.ysdk.shell.module.stat.StatInterface
    public java.lang.String getIMEI() {
        try {
            return com.tencent.ysdk.shell.libware.device.DeviceUtils.getImei(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.tencent.ysdk.shell.module.Module
    public void init() {
        super.init();
        this.context = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext();
        this.appId = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId();
        this.channelId = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId();
        this.useBeacon = com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.KEY_STAT_BEACON_SWITCH, true);
        switchBeaconStrategy(false);
        if (this.useBeacon) {
            com.tencent.ysdk.shell.framework.verification.UserTips.showBeaconErrorTips();
            if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDebug()) {
                com.tencent.beacon.event.UserAction.setLogAble(true, true);
            } else {
                com.tencent.beacon.event.UserAction.setLogAble(false, false);
            }
            checkBeaconSo();
            com.tencent.beacon.event.UserAction.setCollectImei(false);
            com.tencent.beacon.event.UserAction.setCollectMAC(false);
            com.tencent.beacon.event.UserAction.setCollecProcessInfo(false);
            com.tencent.beacon.event.UserAction.setAppVersion(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
            com.tencent.beacon.event.UserAction.initUserAction(this.context);
            try {
                com.tencent.beacon.event.UserAction.setAppKey(this.appId);
            } catch (java.lang.Exception e) {
                com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "[REDACTED]");
                e.printStackTrace();
            }
            com.tencent.beacon.event.UserAction.setChannelID(this.channelId);
            com.tencent.ysdk.shell.module.user.UserApi.setUserInnerLoginListener(new com.tencent.ysdk.shell.module.stat.impl.StatModule.UserInnerLoginListenerImp());
            com.tencent.beacon.event.UserAction.registerTunnel(new com.tencent.beacon.upload.TunnelInfo(TUNNEL_APPKEY));
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.w(TAG, "stat module is closed!");
        }
        initBeaconReport4ForQimei36();
    }

    @Override // com.tencent.ysdk.shell.module.stat.StatInterface
    public boolean reportEvent(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, boolean z) {
        return reportEvent(str, true, -1L, -1L, map, null, z);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00a2  */
    /* JADX WARN: Instruction removed from duplicated block: B:29:0x00a2, please report this as an issue */
    @Override // com.tencent.ysdk.shell.module.stat.StatInterface
    public boolean reportEvent(java.lang.String str, boolean z, long j, long j2, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2, boolean z2) {
        if (!this.useBeacon) {
            com.tencent.ysdk.shell.libware.file.Logger.w(TAG, "beacon module is closed!");
            return false;
        }
        try {
            if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDebug()) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("eventName:");
                try {
                    sb2.append(str);
                    sb.append(sb2.toString());
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    sb3.append(";elapse:");
                    try {
                        sb3.append(j);
                        sb.append(sb3.toString());
                        if (map != null) {
                            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                                sb.append(";Key = " + entry.getKey() + ", Value = " + entry.getValue());
                            }
                        }
                        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, sb.toString());
                    } catch (java.lang.Exception e) {
                        e = e;
                        e.printStackTrace();
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDebug()) {
                        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "reportEvent: commonparams " + map.toString());
                    }
                    boolean zOnUserAction = com.tencent.beacon.event.UserAction.onUserAction(str, z, j, j2, map, z2);
                    reportTunelData(str, z, j, j2, map, map2, z2);
                    return zOnUserAction;
                }
            }
        } catch (java.lang.Exception e3) {
            e = e3;
        }
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDebug()) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "reportEvent: commonparams " + map.toString());
        }
        boolean zOnUserAction2 = com.tencent.beacon.event.UserAction.onUserAction(str, z, j, j2, map, z2);
        reportTunelData(str, z, j, j2, map, map2, z2);
        return zOnUserAction2;
    }

    @Override // com.tencent.ysdk.shell.module.stat.StatInterface
    public void switchBeaconStrategy(boolean z) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "switchBeaconStrategy " + z);
        com.tencent.beacon.upload.UploadStrategy.IS_COLLECT_MAC = z;
        com.tencent.beacon.upload.UploadStrategy.IS_COLLECT_IMEI = z;
        com.tencent.beacon.upload.UploadStrategy.IS_PROCESS_INFO = z;
        com.tencent.beacon.upload.UploadStrategy.IS_ANDROID_ID = z;
        com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().setCollectMac(z);
        com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().setCollectImei(z);
        com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().setCollectAndroidID(z);
        com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().setCollectProcessInfo(z);
    }
}
