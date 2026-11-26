package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TbsPVConfig extends com.tencent.smtt.sdk.TbsBaseConfig {
    private static com.tencent.smtt.sdk.TbsPVConfig b;
    public android.content.SharedPreferences mPreferences;

    public interface TbsPVConfigKey {
        public static final java.lang.String KEY_DISABLED_CORE_VERSION = "disabled_core_version";
        public static final java.lang.String KEY_EMERGENT_CORE_VERSION = "emergent_core_version";
        public static final java.lang.String KEY_ENABLE_NO_SHARE_GRAY = "enable_no_share_gray";
        public static final java.lang.String KEY_GET_LOCALCOREVERSION_MORETIMES = "get_localcoreversion_moretimes";
        public static final java.lang.String KEY_IS_DISABLE_HOST_BACKUP_CORE = "disable_host_backup";
        public static final java.lang.String KEY_READ_APK = "read_apk";
        public static final java.lang.String KEY_TBS_CORE_SANDBOX_MODE_ENABLE = "tbs_core_sandbox_mode_enable";
    }

    private TbsPVConfig() {
    }

    public static synchronized com.tencent.smtt.sdk.TbsPVConfig getInstance(android.content.Context context) {
        if (b == null) {
            com.tencent.smtt.sdk.TbsPVConfig tbsPVConfig = new com.tencent.smtt.sdk.TbsPVConfig();
            b = tbsPVConfig;
            tbsPVConfig.init(context);
        }
        return b;
    }

    public static synchronized void releaseInstance() {
        b = null;
    }

    @Override // com.tencent.smtt.sdk.TbsBaseConfig
    public java.lang.String getConfigFileName() {
        return "tbs_pv_config";
    }

    public synchronized int getDisabledCoreVersion() {
        int i;
        i = 0;
        try {
            java.lang.String str = (java.lang.String) this.f853a.get(com.tencent.smtt.sdk.TbsPVConfig.TbsPVConfigKey.KEY_DISABLED_CORE_VERSION);
            if (!android.text.TextUtils.isEmpty(str)) {
                i = java.lang.Integer.parseInt(str);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public synchronized int getEmergentCoreVersion() {
        int i;
        i = 0;
        try {
            java.lang.String str = (java.lang.String) this.f853a.get(com.tencent.smtt.sdk.TbsPVConfig.TbsPVConfigKey.KEY_EMERGENT_CORE_VERSION);
            if (!android.text.TextUtils.isEmpty(str)) {
                i = java.lang.Integer.parseInt(str);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public synchronized int getLocalCoreVersionMoreTimes() {
        int i;
        i = 0;
        try {
            java.lang.String str = (java.lang.String) this.f853a.get(com.tencent.smtt.sdk.TbsPVConfig.TbsPVConfigKey.KEY_GET_LOCALCOREVERSION_MORETIMES);
            if (!android.text.TextUtils.isEmpty(str)) {
                i = java.lang.Integer.parseInt(str);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public synchronized int getReadApk() {
        int i;
        i = 0;
        try {
            java.lang.String str = (java.lang.String) this.f853a.get(com.tencent.smtt.sdk.TbsPVConfig.TbsPVConfigKey.KEY_READ_APK);
            if (!android.text.TextUtils.isEmpty(str)) {
                i = java.lang.Integer.parseInt(str);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean getTbsCoreSandboxModeEnable() {
        boolean z;
        try {
            z = com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON.equals((java.lang.String) this.f853a.get(com.tencent.smtt.sdk.TbsPVConfig.TbsPVConfigKey.KEY_TBS_CORE_SANDBOX_MODE_ENABLE));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean isDisableHostBackupCore() {
        boolean z;
        try {
            java.lang.String str = (java.lang.String) this.f853a.get(com.tencent.smtt.sdk.TbsPVConfig.TbsPVConfigKey.KEY_IS_DISABLE_HOST_BACKUP_CORE);
            z = !android.text.TextUtils.isEmpty(str) && str.equals(com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean isEnableNoCoreGray() {
        boolean z;
        try {
            java.lang.String str = (java.lang.String) this.f853a.get(com.tencent.smtt.sdk.TbsPVConfig.TbsPVConfigKey.KEY_ENABLE_NO_SHARE_GRAY);
            z = !android.text.TextUtils.isEmpty(str) && str.equals(com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    public synchronized void putData(java.lang.String str, java.lang.String str2) {
        this.f853a.put(str, str2);
    }
}
