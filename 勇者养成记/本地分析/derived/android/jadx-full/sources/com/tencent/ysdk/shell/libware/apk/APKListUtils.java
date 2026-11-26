package com.tencent.ysdk.shell.libware.apk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APKListUtils {
    public static volatile boolean mIsLoadInstalledRunning = false;
    public static volatile boolean mLocalApkDataReady = false;
    private android.content.Context context;
    public java.util.Map<java.lang.String, com.tencent.ysdk.shell.libware.apk.LocalApkInfo> mInstalledApks;

    public APKListUtils(android.content.Context context) {
        this.mInstalledApks = java.util.Collections.synchronizedMap(new java.util.HashMap());
        this.context = context;
        this.mInstalledApks = scanInstalledApkInfos();
    }

    public static android.content.pm.PackageInfo checkAppInstalled(android.content.Context context, java.lang.String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.util.List<java.lang.String> getForGroundPkgName(android.content.Context context) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        if (android.os.Build.VERSION.SDK_INT <= 19) {
            getForGroundPkgNameUnderJKitkat(arrayList, activityManager);
            return arrayList;
        }
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100) {
                    java.lang.String str = runningAppProcessInfo.processName.indexOf(":") == -1 ? runningAppProcessInfo.processName : runningAppProcessInfo.processName.split(":")[0];
                    if (!arrayList.contains(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        return arrayList;
    }

    private static void getForGroundPkgNameUnderJKitkat(java.util.ArrayList<java.lang.String> arrayList, android.app.ActivityManager activityManager) {
        try {
            java.util.List<android.app.ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
            if (runningTasks == null || runningTasks.size() <= 0) {
                return;
            }
            arrayList.add(runningTasks.get(0).topActivity.getPackageName());
        } catch (java.lang.Throwable th) {
            com.tencent.ysdk.shell.libware.file.Logger.e(th.getLocalizedMessage());
        }
    }

    public com.tencent.ysdk.shell.libware.apk.LocalApkInfo getLocalApkInfo(java.lang.String str) {
        java.util.Map<java.lang.String, com.tencent.ysdk.shell.libware.apk.LocalApkInfo> map = this.mInstalledApks;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public java.util.List<com.tencent.ysdk.shell.libware.apk.LocalApkInfo> getLocalApkInfos(android.content.Context context) {
        if (this.context == null) {
            this.context = context;
        }
        if (!mLocalApkDataReady) {
            return null;
        }
        java.util.Map<java.lang.String, com.tencent.ysdk.shell.libware.apk.LocalApkInfo> map = this.mInstalledApks;
        if (map != null && map.size() > 0) {
            return new java.util.ArrayList(this.mInstalledApks.values());
        }
        if (!mIsLoadInstalledRunning) {
            new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.libware.apk.APKListUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.ysdk.shell.libware.apk.APKListUtils aPKListUtils = com.tencent.ysdk.shell.libware.apk.APKListUtils.this;
                    aPKListUtils.mInstalledApks = aPKListUtils.scanInstalledApkInfos();
                }
            }.run();
        }
        return null;
    }

    public java.util.Map<java.lang.String, com.tencent.ysdk.shell.libware.apk.LocalApkInfo> scanInstalledApkInfos() {
        android.content.pm.PackageManager packageManager = this.context.getPackageManager();
        java.util.HashMap map = new java.util.HashMap();
        java.util.List<android.content.pm.PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        if (installedPackages == null) {
            return null;
        }
        for (android.content.pm.PackageInfo packageInfo : installedPackages) {
            com.tencent.ysdk.shell.libware.apk.LocalApkInfo localApkInfo = new com.tencent.ysdk.shell.libware.apk.LocalApkInfo();
            localApkInfo.mPackageName = packageInfo.packageName;
            localApkInfo.mVersionName = packageInfo.versionName == null ? "" : packageInfo.versionName;
            localApkInfo.mVersionCode = packageInfo.versionCode;
            android.content.pm.ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            localApkInfo.mLocalFilePath = applicationInfo.sourceDir;
            localApkInfo.flags = applicationInfo.flags;
            localApkInfo.mUid = applicationInfo.uid;
            localApkInfo.mAppName = applicationInfo.loadLabel(packageManager).toString().trim();
            localApkInfo.mIsEnabled = applicationInfo.enabled;
            localApkInfo.mAppIconRes = applicationInfo.icon;
            localApkInfo.manifestMd5 = com.tencent.ysdk.shell.libware.apk.ManifestMd5Generator.getMd5(localApkInfo.mLocalFilePath);
            map.put(localApkInfo.mPackageName, localApkInfo);
        }
        return map;
    }
}
