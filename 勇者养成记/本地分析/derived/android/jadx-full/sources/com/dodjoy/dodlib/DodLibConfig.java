package com.dodjoy.dodlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodLibConfig {
    private static java.lang.String mApkTitle = "";
    private static int mChannelId = 0;
    private static java.lang.String mChannnelName = "";
    private static org.json.JSONObject mConfigBytesConfig = null;
    private static boolean mHaveCdnDownload = false;
    private static boolean mHaveDodNative = true;
    private static boolean mHaveHotIl2cpp = false;
    private static boolean mHaveLbs = false;
    private static boolean mIsSDKVersion = false;
    private static int mPackageADID = 0;
    private static int mPackageID = 0;
    private static java.lang.String mPlatformName = "";

    public static java.lang.String GetApkTitle() {
        return mApkTitle;
    }

    public static int GetChannelId() {
        return mChannelId;
    }

    public static java.lang.String GetChannelName() {
        return mChannnelName;
    }

    public static org.json.JSONObject GetConfigBytesConfig() {
        if (mConfigBytesConfig == null) {
            try {
                java.lang.String str = GetPlatformName().isEmpty() ? "Config.bytes" : java.lang.String.format("Config_%s.bytes", GetPlatformName());
                android.app.Activity activityGetGameActivity = com.dodjoy.utilities.DodBaseContext.GetGameActivity();
                if (activityGetGameActivity == null) {
                    return null;
                }
                mConfigBytesConfig = new org.json.JSONObject(com.dodjoy.dodlib.DodLibUtil.ReadText(activityGetGameActivity.getResources().getAssets().open(str)));
            } catch (java.lang.Exception e) {
                com.dodjoy.utils.DodLog.e(com.dodjoy.utils.DodLog.TAG, "read asset failed: " + e.toString());
                mConfigBytesConfig = null;
            }
        }
        return mConfigBytesConfig;
    }

    public static int GetPackageID() {
        return mPackageID;
    }

    public static int GetPackageadID() {
        return mPackageADID;
    }

    public static java.lang.String GetPlatformName() {
        return mPlatformName;
    }

    public static boolean HaveHotIl2cpp() {
        return mHaveHotIl2cpp;
    }

    public static boolean Init() {
        android.os.Bundle bundleGetMetaData = com.dodjoy.platform.PlatformConfig.GetMetaData();
        if (bundleGetMetaData == null) {
            return false;
        }
        try {
            if (bundleGetMetaData.containsKey(com.dodjoy.dodlib.DodLibMeta.DOD_PLATFORM_NAME)) {
                mPlatformName = bundleGetMetaData.getString(com.dodjoy.dodlib.DodLibMeta.DOD_PLATFORM_NAME);
            }
            if (bundleGetMetaData.containsKey(com.dodjoy.dodlib.DodLibMeta.DOD_CHANNEL_NAME)) {
                mChannnelName = bundleGetMetaData.getString(com.dodjoy.dodlib.DodLibMeta.DOD_CHANNEL_NAME);
            }
            if (bundleGetMetaData.containsKey(com.dodjoy.dodlib.DodLibMeta.isSDKVersion)) {
                mIsSDKVersion = bundleGetMetaData.getBoolean(com.dodjoy.dodlib.DodLibMeta.isSDKVersion);
            }
            if (bundleGetMetaData.containsKey(com.dodjoy.dodlib.DodLibMeta.PackageID)) {
                mPackageID = bundleGetMetaData.getInt(com.dodjoy.dodlib.DodLibMeta.PackageID);
            }
            if (bundleGetMetaData.containsKey(com.dodjoy.dodlib.DodLibMeta.PackageADID)) {
                mPackageADID = bundleGetMetaData.getInt(com.dodjoy.dodlib.DodLibMeta.PackageADID);
            }
            if (bundleGetMetaData.containsKey(com.dodjoy.dodlib.DodLibMeta.ChannelId)) {
                mChannelId = bundleGetMetaData.getInt(com.dodjoy.dodlib.DodLibMeta.ChannelId);
            }
            ReadModuleOpen(bundleGetMetaData);
            LoadApkTitle();
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean IsHaveCdnDownload() {
        return mHaveCdnDownload;
    }

    public static boolean IsHaveDodNative() {
        return mHaveDodNative;
    }

    public static boolean IsHaveLbs() {
        return mHaveLbs;
    }

    public static boolean IsSDKVersion() {
        return mIsSDKVersion;
    }

    private static void LoadApkTitle() {
        android.content.pm.PackageManager packageManager;
        android.content.pm.ApplicationInfo applicationInfo;
        mApkTitle = "";
        try {
            android.content.Context contextGetApplicationContext = com.dodjoy.utilities.DodBaseContext.GetApplicationContext();
            if (contextGetApplicationContext == null || (applicationInfo = (packageManager = contextGetApplicationContext.getPackageManager()).getApplicationInfo(contextGetApplicationContext.getPackageName(), 0)) == null) {
                return;
            }
            mApkTitle = (java.lang.String) packageManager.getApplicationLabel(applicationInfo);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
        }
    }

    private static void ReadModuleOpen(android.os.Bundle bundle) {
        if (bundle.containsKey(com.dodjoy.dodlib.DodLibMeta.HaveDodNative)) {
            mHaveDodNative = bundle.getBoolean(com.dodjoy.dodlib.DodLibMeta.HaveDodNative);
        }
        if (bundle.containsKey(com.dodjoy.dodlib.DodLibMeta.HaveLbs)) {
            mHaveLbs = bundle.getBoolean(com.dodjoy.dodlib.DodLibMeta.HaveLbs);
        }
        if (bundle.containsKey(com.dodjoy.dodlib.DodLibMeta.HaveHotIl2cpp)) {
            mHaveHotIl2cpp = bundle.getBoolean(com.dodjoy.dodlib.DodLibMeta.HaveHotIl2cpp);
        }
    }
}
