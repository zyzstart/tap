package com.tencent.ysdk.shell.module.stat;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
public class StatApi {
    private static volatile com.tencent.ysdk.shell.module.stat.StatApi instance;
    private com.tencent.ysdk.shell.module.stat.StatInterface statInterfaceImp;

    private StatApi() {
    }

    public static com.tencent.ysdk.shell.module.stat.StatApi getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.stat.StatApi.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.stat.StatApi();
                }
            }
        }
        return instance;
    }

    private com.tencent.ysdk.shell.module.stat.StatInterface getOrLoadStatInnerInterface() {
        com.tencent.ysdk.shell.module.stat.StatInterface statInterface = this.statInterfaceImp;
        if (statInterface != null) {
            return statInterface;
        }
        com.tencent.ysdk.shell.module.ModuleManager moduleManager = com.tencent.ysdk.shell.module.ModuleManager.getInstance();
        if (moduleManager != null) {
            java.lang.Object moduleByName = moduleManager.getModuleByName(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_STAT);
            if (moduleByName instanceof com.tencent.ysdk.shell.module.stat.StatInterface) {
                this.statInterfaceImp = (com.tencent.ysdk.shell.module.stat.StatInterface) moduleByName;
            }
        }
        return this.statInterfaceImp;
    }

    public static java.lang.String getQImei() {
        try {
            return com.tencent.ysdk.shell.libware.device.DeviceUtils.getQImei();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static java.lang.String getSN() {
        try {
            return android.os.Build.SERIAL;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static java.lang.String getYYBInstallState() {
        try {
            return com.tencent.ysdk.shell.libware.apk.YYBUtils.getInstalledYYBInfo() != null ? java.lang.String.valueOf(1) : java.lang.String.valueOf(0);
        } catch (java.lang.Throwable th) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, th);
            return java.lang.String.valueOf(0);
        }
    }

    public java.lang.String getIMEI() {
        com.tencent.ysdk.shell.module.stat.StatInterface orLoadStatInnerInterface = getOrLoadStatInnerInterface();
        java.lang.String imei = orLoadStatInnerInterface != null ? orLoadStatInnerInterface.getIMEI() : "";
        return com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(imei) ? "" : imei;
    }

    public void reportEvent(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, boolean z) {
        com.tencent.ysdk.shell.module.stat.StatInterface orLoadStatInnerInterface = getOrLoadStatInnerInterface();
        if (orLoadStatInnerInterface != null) {
            orLoadStatInnerInterface.reportEvent(str, map, z);
        }
    }

    public boolean reportEvent(java.lang.String str, boolean z, long j, long j2, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2, boolean z2) {
        com.tencent.ysdk.shell.module.stat.StatInterface orLoadStatInnerInterface = getOrLoadStatInnerInterface();
        if (orLoadStatInnerInterface != null) {
            return orLoadStatInnerInterface.reportEvent(str, z, j, j2, map, map2, z2);
        }
        return false;
    }

    public void switchBeaconStrategy(boolean z) {
        com.tencent.ysdk.shell.module.stat.StatInterface orLoadStatInnerInterface = getOrLoadStatInnerInterface();
        if (orLoadStatInnerInterface != null) {
            orLoadStatInnerInterface.switchBeaconStrategy(z);
        }
    }
}
