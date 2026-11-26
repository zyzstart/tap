package com.dodjoy.dodlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodLib {
    public static boolean isFinish;
    private android.app.Activity mActivity;
    private android.content.Context mAppContext;
    private java.lang.String mDataDir;
    private com.dodjoy.dodlib.ApkDownloadMgr mApkDownloader = null;
    private com.dodjoy.dodlib.DodNative mNative = null;
    private com.dodjoy.dodlib.CdnDownMgr mCdnDownload = null;
    private com.dodjoy.dodlib.BatteryMgr mBatteryMgr = null;
    private com.dodjoy.dodlib.DodRestartMgr mRestartMgr = null;
    private com.dodjoy.dodlib.DodDeviceMgr mDevicedMgr = null;
    private com.dodjoy.dodlib.DodPermission mPermission = null;
    private com.dodjoy.dodlib.DodHotIl2cpp m_hotIl2cpp = null;
    private java.util.ArrayList<com.dodjoy.dodlib.DodLibBaseMgr> mListMgr = new java.util.ArrayList<>();

    private void AddMgr(com.dodjoy.dodlib.DodLibBaseMgr dodLibBaseMgr) {
        this.mListMgr.add(dodLibBaseMgr);
    }

    private boolean CreateAllMgr(android.app.Activity activity, java.lang.String str) {
        if (com.dodjoy.dodlib.DodLibConfig.IsHaveDodNative()) {
            this.mNative = new com.dodjoy.dodlib.DodNative(str);
            AddMgr(this.mNative);
        }
        if (com.dodjoy.dodlib.DodLibConfig.IsHaveCdnDownload()) {
            this.mCdnDownload = new com.dodjoy.dodlib.CdnDownMgr();
            AddMgr(this.mCdnDownload);
        }
        if (com.dodjoy.dodlib.DodLibConfig.HaveHotIl2cpp()) {
            this.m_hotIl2cpp = new com.dodjoy.dodlib.DodHotIl2cpp(str);
            AddMgr(this.m_hotIl2cpp);
        }
        com.dodjoy.dodlib.DodLibConfig.IsHaveLbs();
        this.mBatteryMgr = new com.dodjoy.dodlib.BatteryMgr();
        AddMgr(this.mBatteryMgr);
        this.mApkDownloader = new com.dodjoy.dodlib.ApkDownloadMgr(com.dodjoy.dodlib.DodLibConfig.GetApkTitle());
        AddMgr(this.mApkDownloader);
        this.mRestartMgr = new com.dodjoy.dodlib.DodRestartMgr();
        AddMgr(this.mRestartMgr);
        this.mDevicedMgr = new com.dodjoy.dodlib.DodDeviceMgr(str);
        AddMgr(this.mDevicedMgr);
        this.mPermission = new com.dodjoy.dodlib.DodPermission();
        AddMgr(this.mPermission);
        com.dodjoy.utils.DodLog.i(com.dodjoy.utils.DodLog.TAG, "DodLib init success");
        return true;
    }

    private boolean InitAllMgr() {
        int size = this.mListMgr.size();
        for (int i = 0; i < size; i++) {
            com.dodjoy.dodlib.DodLibBaseMgr dodLibBaseMgr = this.mListMgr.get(i);
            if (!dodLibBaseMgr.Create(this.mActivity)) {
                com.dodjoy.utils.DodLog.e(com.dodjoy.utils.DodLog.TAG, "DodLib create " + dodLibBaseMgr.toString() + " failed");
                return false;
            }
        }
        return true;
    }

    public boolean CheckMicroPhone() {
        com.dodjoy.dodlib.DodPermission dodPermission = this.mPermission;
        if (dodPermission != null) {
            return dodPermission.CheckAndRequesetMicroPhonePermission();
        }
        return false;
    }

    public boolean Create(android.app.Activity activity, java.lang.String str) {
        com.dodjoy.utils.DodLog.i(com.dodjoy.utils.DodLog.TAG, "-------------------DodLib start create, dataDir:" + str);
        this.mAppContext = activity.getApplicationContext();
        this.mActivity = activity;
        this.mDataDir = str;
        if (com.dodjoy.dodlib.DodLibConfig.Init()) {
            return CreateAllMgr(activity, str) && InitAllMgr();
        }
        com.dodjoy.utils.DodLog.e(com.dodjoy.utils.DodLog.TAG, "DodLibConfig init failed");
        return false;
    }

    public void Destroy() {
        int size = this.mListMgr.size();
        for (int i = 0; i < size; i++) {
            this.mListMgr.get(i).Destroy();
        }
    }

    public java.lang.String GetArchName() {
        com.dodjoy.dodlib.DodHotIl2cpp dodHotIl2cpp = this.m_hotIl2cpp;
        return dodHotIl2cpp != null ? dodHotIl2cpp.getArchName() : "";
    }

    public int GetBatteryLevel() {
        com.dodjoy.dodlib.BatteryMgr batteryMgr = this.mBatteryMgr;
        if (batteryMgr != null) {
            return batteryMgr.GetBatteryLevel();
        }
        com.dodjoy.utils.DodLog.e(com.dodjoy.utils.DodLog.TAG, "not support get battery info");
        return 0;
    }

    public int GetChannelId() {
        return com.dodjoy.dodlib.DodLibConfig.GetChannelId();
    }

    public java.lang.String GetDataDir() {
        return this.mDataDir;
    }

    public java.lang.String GetDefaultLanguage() {
        return java.util.Locale.getDefault().getLanguage();
    }

    public java.lang.String GetDefaultRegion() {
        return java.util.Locale.getDefault().getCountry();
    }

    public com.dodjoy.dodlib.DodDeviceMgr GetDeviceMgr() {
        return this.mDevicedMgr;
    }

    public java.lang.String GetDownloadStateData(java.lang.String str) {
        com.dodjoy.dodlib.ApkDownloadMgr apkDownloadMgr = this.mApkDownloader;
        return apkDownloadMgr != null ? apkDownloadMgr.GetDownloadStateData(str) : "";
    }

    public int GetPackageADID() {
        return com.dodjoy.dodlib.DodLibConfig.GetPackageadID();
    }

    public int GetPackageID() {
        return com.dodjoy.dodlib.DodLibConfig.GetPackageID();
    }

    public boolean InstallApk(java.lang.String str) {
        com.dodjoy.dodlib.ApkDownloadMgr apkDownloadMgr = this.mApkDownloader;
        if (apkDownloadMgr != null) {
            return apkDownloadMgr.InstallApk();
        }
        com.dodjoy.utils.DodLog.e(com.dodjoy.utils.DodLog.TAG, "not support apk download");
        return false;
    }

    public boolean IsSDKVersion() {
        return com.dodjoy.dodlib.DodLibConfig.IsSDKVersion();
    }

    public byte[] LoadStreamAssetFile(java.lang.String str) {
        return com.dodjoy.dodlib.DodLibUtil.LoadStreamAssetFile(this.mAppContext, str);
    }

    public boolean ManualDownload(java.lang.String str) {
        com.dodjoy.dodlib.ApkDownloadMgr apkDownloadMgr = this.mApkDownloader;
        if (apkDownloadMgr != null) {
            return apkDownloadMgr.ManualDownload(str);
        }
        com.dodjoy.utils.DodLog.e(com.dodjoy.utils.DodLog.TAG, "not support apk download");
        return false;
    }

    public void RestartApp(int i) {
        com.jakewharton.processphoenix.ProcessPhoenix.triggerRebirth(this.mAppContext);
    }

    public void SaveStringToClipboard(java.lang.String str) {
        ((android.content.ClipboardManager) this.mAppContext.getSystemService("clipboard")).setPrimaryClip(android.content.ClipData.newPlainText("qq", str));
    }

    public boolean StartDownloadProg(java.lang.String str) {
        com.dodjoy.dodlib.ApkDownloadMgr apkDownloadMgr = this.mApkDownloader;
        if (apkDownloadMgr != null) {
            return apkDownloadMgr.StartDownload(str);
        }
        com.dodjoy.utils.DodLog.e(com.dodjoy.utils.DodLog.TAG, "not support apk download");
        return false;
    }

    public void addMedia(java.lang.String str, java.lang.String str2) {
        new com.dodjoy.dodlib.MediaScannerWrapper(this.mAppContext, str, str2).scan();
    }

    public boolean checkPermission(java.lang.String str, java.lang.String str2) {
        com.dodjoy.dodlib.DodPermission dodPermission = this.mPermission;
        if (dodPermission != null) {
            return dodPermission.IsPermissionGranted(str, str2);
        }
        com.dodjoy.utils.DodLog.e(com.dodjoy.utils.DodLog.TAG, "not support permmision mgr");
        return false;
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
    }

    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        com.dodjoy.dodlib.DodPermission dodPermission = this.mPermission;
        if (dodPermission != null) {
            dodPermission.onRequestPermissionsResult(i, strArr, iArr);
        }
    }
}
