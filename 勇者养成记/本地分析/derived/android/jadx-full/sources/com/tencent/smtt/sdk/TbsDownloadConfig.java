package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TbsDownloadConfig {
    public static final int CMD_ID_DOWNLOAD_FILE = 101;
    public static final int CMD_ID_FILE_UPLOAD = 100;
    public static final long DEFAULT_RETRY_INTERVAL_SEC = 86400;
    public static final int ERROR_DOWNLOAD = 2;
    public static final int ERROR_INSTALL = 5;
    public static final int ERROR_LOAD = 6;
    public static final int ERROR_NONE = 1;
    public static final int ERROR_REPORTED = 0;
    public static final int ERROR_UNZIP = 4;
    public static final int ERROR_VERIFY = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.smtt.sdk.TbsDownloadConfig f856a;
    private android.content.Context b;
    public android.content.SharedPreferences mPreferences;
    public java.util.Map mSyncMap = new java.util.HashMap();

    public interface TbsConfigKey {
        public static final java.lang.String KEY_APP_METADATA = "app_metadata";
        public static final java.lang.String KEY_APP_VERSIONCODE = "app_versioncode";
        public static final java.lang.String KEY_APP_VERSIONCODE_FOR_SWITCH = "app_versioncode_for_switch";
        public static final java.lang.String KEY_APP_VERSIONNAME = "app_versionname";
        public static final java.lang.String KEY_BACKUPCORE_DELFILELIST = "backupcore_delfilelist";
        public static final java.lang.String KEY_COUNT_REQUEST_FAIL_IN_24HOURS = "count_request_fail_in_24hours";
        public static final java.lang.String KEY_DECOUPLECOREVERSION = "tbs_decouplecoreversion";
        public static final java.lang.String KEY_DESkEY_TOKEN = "[REDACTED]";
        public static final java.lang.String KEY_DEVICE_CPUABI = "device_cpuabi";
        public static final java.lang.String KEY_DOWNLOADDECOUPLECORE = "tbs_downloaddecouplecore";
        public static final java.lang.String KEY_DOWNLOADURL_LIST = "tbs_downloadurl_list";
        public static final java.lang.String KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES = "tbs_download_failed_max_retrytimes";
        public static final java.lang.String KEY_DOWNLOAD_FAILED_RETRYTIMES = "tbs_download_failed_retrytimes";
        public static final java.lang.String KEY_DOWNLOAD_INTERRUPT_CODE = "tbs_download_interrupt_code";
        public static final java.lang.String KEY_DOWNLOAD_INTERRUPT_CODE_REASON = "tbs_download_interrupt_code_reason";
        public static final java.lang.String KEY_DOWNLOAD_INTERRUPT_TIME = "tbs_download_interrupt_time";
        public static final java.lang.String KEY_DOWNLOAD_MAXFLOW = "tbs_download_maxflow";
        public static final java.lang.String KEY_DOWNLOAD_MIN_FREE_SPACE = "tbs_download_min_free_space";
        public static final java.lang.String KEY_DOWNLOAD_SINGLE_TIMEOUT = "tbs_single_timeout";
        public static final java.lang.String KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES = "tbs_download_success_max_retrytimes";
        public static final java.lang.String KEY_DOWNLOAD_SUCCESS_RETRYTIMES = "tbs_download_success_retrytimes";
        public static final java.lang.String KEY_FULL_PACKAGE = "request_full_package";
        public static final java.lang.String KEY_GUID = "tbs_guid";
        public static final java.lang.String KEY_INSTALL_INTERRUPT_CODE = "tbs_install_interrupt_code";
        public static final java.lang.String KEY_IS_OVERSEA = "is_oversea";
        public static final java.lang.String KEY_LAST_CHECK = "last_check";
        public static final java.lang.String KEY_LAST_DOWNLOAD_DECOUPLE_CORE = "last_download_decouple_core";
        public static final java.lang.String KEY_LAST_REQUEST_SUCCESS = "last_request_success";
        public static final java.lang.String KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION = "last_thirdapp_sendrequest_coreversion";
        public static final java.lang.String KEY_NEEDDOWNLOAD = "tbs_needdownload";
        public static final java.lang.String KEY_REQUEST_FAIL = "request_fail";
        public static final java.lang.String KEY_RESPONSECODE = "tbs_responsecode";
        public static final java.lang.String KEY_RETRY_INTERVAL = "retry_interval";
        public static final java.lang.String KEY_STOP_PRE_OAT = "tbs_stop_preoat";
        public static final java.lang.String KEY_SWITCH_BACKUPCORE_ENABLE = "switch_backupcore_enable";
        public static final java.lang.String KEY_TBSAPKFILESIZE = "tbs_apkfilesize";
        public static final java.lang.String KEY_TBSAPK_MD5 = "tbs_apk_md5";
        public static final java.lang.String KEY_TBSDOWNLOADURL = "tbs_downloadurl";
        public static final java.lang.String KEY_TBSDOWNLOAD_FLOW = "tbs_downloadflow";
        public static final java.lang.String KEY_TBSDOWNLOAD_STARTTIME = "tbs_downloadstarttime";
        public static final java.lang.String KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_ENABLE = "tbs_core_load_rename_file_lock_enable";
        public static final java.lang.String KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_WAIT_ENABLE = "tbs_core_load_rename_file_lock_wait_enable";
        public static final java.lang.String KEY_TBS_DOWNLOAD_V = "tbs_download_version";
        public static final java.lang.String KEY_TBS_DOWNLOAD_V_TYPE = "tbs_download_version_type";
        public static final java.lang.String KEY_USE_BACKUP_VERSION = "use_backup_version";
        public static final java.lang.String KEY_USE_BUGLY = "tbs_use_bugly";
    }

    private TbsDownloadConfig(android.content.Context context) {
        this.mPreferences = context.getSharedPreferences("tbs_download_config", 4);
        android.content.Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        if (applicationContext == null) {
            this.b = context;
        }
    }

    public static synchronized com.tencent.smtt.sdk.TbsDownloadConfig getInstance() {
        return f856a;
    }

    public static synchronized com.tencent.smtt.sdk.TbsDownloadConfig getInstance(android.content.Context context) {
        if (f856a == null) {
            f856a = new com.tencent.smtt.sdk.TbsDownloadConfig(context);
        }
        return f856a;
    }

    public void clear() {
        try {
            this.mSyncMap.clear();
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.clear();
            editorEdit.commit();
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void commit() {
        try {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            for (java.lang.String str : this.mSyncMap.keySet()) {
                java.lang.Object obj = this.mSyncMap.get(str);
                if (obj instanceof java.lang.String) {
                    editorEdit.putString(str, (java.lang.String) obj);
                } else if (obj instanceof java.lang.Boolean) {
                    editorEdit.putBoolean(str, ((java.lang.Boolean) obj).booleanValue());
                } else if (obj instanceof java.lang.Long) {
                    editorEdit.putLong(str, ((java.lang.Long) obj).longValue());
                } else if (obj instanceof java.lang.Integer) {
                    editorEdit.putInt(str, ((java.lang.Integer) obj).intValue());
                } else if (obj instanceof java.lang.Float) {
                    editorEdit.putFloat(str, ((java.lang.Float) obj).floatValue());
                }
            }
            editorEdit.commit();
            this.mSyncMap.clear();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized int getDownloadFailedMaxRetrytimes() {
        int i;
        i = this.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, 0);
        if (i == 0) {
            i = 100;
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized int getDownloadInterruptCode() {
        int i;
        android.content.Context context;
        if (this.mPreferences.contains(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE)) {
            i = this.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE, -99);
            if (i == -119 || i == -121) {
                i = this.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -119);
            }
            if (java.lang.System.currentTimeMillis() - this.mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_TIME, 0L) > 86400000) {
                i -= 98000;
            }
        } else {
            try {
                if (new java.io.File(new java.io.File(this.b.getFilesDir(), "shared_prefs"), "tbs_download_config").exists()) {
                    i = !this.mPreferences.contains(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD) ? -96 : com.tencent.safecloud.device.openlib.DeviceConfig.ERR_AUTHENTICATION;
                } else {
                    i = -97;
                }
            } catch (java.lang.Throwable unused) {
                i = -95;
            }
        }
        context = this.b;
        return (context == null || !"com.tencent.mobileqq".equals(context.getApplicationInfo().packageName) || "CN".equals(java.util.Locale.getDefault().getCountry())) ? (i * 1000) + this.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_INSTALL_INTERRUPT_CODE, -1) : -320;
    }

    public synchronized long getDownloadMaxflow() {
        int i;
        i = this.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, 0);
        if (i == 0) {
            i = 20;
        }
        return ((long) (i * 1024)) * 1024;
    }

    public synchronized long getDownloadMinFreeSpace() {
        int i;
        i = this.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, 0);
        if (i == 0) {
            i = 0;
        }
        return ((long) (i * 1024)) * 1024;
    }

    public synchronized long getDownloadSingleTimeout() {
        long j;
        j = this.mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, 0L);
        if (j == 0) {
            j = 1200000;
        }
        return j;
    }

    public synchronized int getDownloadSuccessMaxRetrytimes() {
        int i;
        i = this.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, 0);
        if (i == 0) {
            i = 3;
        }
        return i;
    }

    public synchronized long getRetryInterval() {
        if (com.tencent.smtt.sdk.TbsDownloader.getRetryIntervalInSeconds() >= 0) {
            return com.tencent.smtt.sdk.TbsDownloader.getRetryIntervalInSeconds();
        }
        return this.mPreferences.getLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RETRY_INTERVAL, DEFAULT_RETRY_INTERVAL_SEC);
    }

    public synchronized boolean getTbsCoreLoadRenameFileLockEnable() {
        boolean z;
        z = true;
        try {
            z = this.mPreferences.getBoolean(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_ENABLE, true);
        } catch (java.lang.Exception unused) {
        }
        return z;
    }

    public synchronized boolean getTbsCoreLoadRenameFileLockWaitEnable() {
        boolean z;
        z = true;
        try {
            z = this.mPreferences.getBoolean(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_WAIT_ENABLE, true);
        } catch (java.lang.Exception unused) {
        }
        return z;
    }

    public synchronized boolean isOverSea() {
        return this.mPreferences.getBoolean(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA, false);
    }

    public synchronized void setDownloadInterruptCode(int i) {
        try {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE, i);
            editorEdit.putLong(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_TIME, java.lang.System.currentTimeMillis());
            editorEdit.commit();
        } catch (java.lang.Exception unused) {
        }
    }

    public synchronized void setInstallInterruptCode(int i) {
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_INSTALL_INTERRUPT_CODE, i);
        editorEdit.commit();
    }

    public synchronized void setTbsCoreLoadRenameFileLockEnable(boolean z) {
        try {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putBoolean(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_ENABLE, z);
            editorEdit.commit();
        } catch (java.lang.Exception unused) {
        }
    }

    public synchronized void setTbsCoreLoadRenameFileLockWaitEnable(boolean z) {
        try {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putBoolean(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_WAIT_ENABLE, z);
            editorEdit.commit();
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized void uploadDownloadInterruptCodeIfNeeded(android.content.Context context) {
        int i;
        if (context != null) {
            try {
                if ("com.tencent.mm".equals(context.getApplicationContext().getApplicationInfo().packageName)) {
                    boolean z = true;
                    if (this.mPreferences.contains(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE)) {
                        i = this.mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE, -99);
                        if ((i > -206 || i < -219) && ((i > -302 || i < -316) && (i > -318 || i < -322))) {
                            z = false;
                        }
                    } else {
                        try {
                            if (new java.io.File(new java.io.File(this.b.getFilesDir(), "shared_prefs"), "tbs_download_config").exists()) {
                                i = !this.mPreferences.contains(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD) ? -96 : com.tencent.safecloud.device.openlib.DeviceConfig.ERR_AUTHENTICATION;
                            } else {
                                i = -97;
                            }
                        } catch (java.lang.Throwable unused) {
                            i = -95;
                        }
                    }
                    if (z) {
                        com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo = com.tencent.smtt.sdk.TbsLogReport.getInstance(context).tbsLogInfo();
                        tbsLogInfo.setErrorCode(128);
                        tbsLogInfo.setFailDetail(" " + i);
                        com.tencent.smtt.sdk.TbsLogReport.getInstance(context).eventReport(com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                    }
                }
            } catch (java.lang.Throwable unused2) {
            }
        }
    }
}
