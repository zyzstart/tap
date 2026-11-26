package com.dodjoy.dodlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodDeviceMgr extends com.dodjoy.dodlib.DodLibBaseMgr {
    public static android.app.Activity mActivity;
    android.content.Context mContext;
    public java.lang.String mDataDir;

    public DodDeviceMgr(java.lang.String str) {
        this.mDataDir = str;
    }

    private long GetAvailSpaceSize(java.lang.String str) {
        android.os.StatFs statFs = new android.os.StatFs(str);
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }

    private boolean checkPermission(java.lang.String str) {
        try {
            return this.mContext.getPackageManager().checkPermission(str, this.mContext.getPackageName()) == 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean checkPhoneState() {
        return checkPermission("android.permission.READ_PHONE_STATE");
    }

    private boolean checkRootMethod1() {
        java.lang.String str = android.os.Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private boolean checkRootMethod2() {
        for (java.lang.String str : new java.lang.String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"}) {
            if (new java.io.File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRootMethod3() {
        java.lang.Process processExec = null;
        try {
            processExec = java.lang.Runtime.getRuntime().exec(new java.lang.String[]{"/system/xbin/which", "su"});
            if (new java.io.BufferedReader(new java.io.InputStreamReader(processExec.getInputStream())).readLine() != null) {
                if (processExec != null) {
                    processExec.destroy();
                }
                return true;
            }
            if (processExec != null) {
                processExec.destroy();
            }
            return false;
        } catch (java.lang.Throwable th) {
            if (processExec != null) {
                processExec.destroy();
            }
            throw th;
        }
    }

    private boolean checkRootMethod4() {
        return findBinary("su");
    }

    public static java.lang.String intIP2StringIP(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    @Override // com.dodjoy.dodlib.DodLibBaseMgr
    public boolean Create(android.app.Activity activity) {
        this.mContext = activity.getApplicationContext();
        mActivity = activity;
        return true;
    }

    public java.lang.String GetDeviceID() {
        java.lang.String deviceId = "";
        int i = this.mContext.getApplicationInfo().targetSdkVersion;
        if (checkPhoneState() && i < 29 && (deviceId = ((android.telephony.TelephonyManager) this.mContext.getSystemService("phone")).getDeviceId()) == null) {
            deviceId = android.provider.Settings.Secure.getString(this.mContext.getContentResolver(), com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
        }
        return (deviceId == null || deviceId.isEmpty()) ? android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN : deviceId;
    }

    public java.lang.String GetDeviceType() {
        return android.os.Build.MANUFACTURER + "|" + android.os.Build.BRAND + "|" + android.os.Build.MODEL;
    }

    public java.lang.String GetGAID() {
        try {
            return com.dodjoy.dodlib.AdvertisingIdClient.getGoogleAdId(this.mContext);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public java.lang.String GetImei() {
        return GetDeviceID();
    }

    public boolean GetIsEmulator() {
        return com.dodjoy.dodlib.EmulatorDetector.isSimulator(this.mContext);
    }

    public java.lang.String GetMac() {
        android.net.wifi.WifiInfo connectionInfo;
        android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) this.mContext.getSystemService("wifi");
        return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null || connectionInfo.getMacAddress() == null) ? "NO MAC ADDRESS" : connectionInfo.getMacAddress();
    }

    @android.annotation.TargetApi(16)
    public java.lang.String GetMemoryInfo() {
        android.app.ActivityManager activityManager = (android.app.ActivityManager) this.mContext.getSystemService("activity");
        if (activityManager == null) {
            return "";
        }
        java.lang.String str = "{";
        java.lang.String str2 = "";
        android.os.Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{android.os.Process.myPid()});
        if (processMemoryInfo != null && processMemoryInfo[0] != null) {
            java.lang.String str3 = ("{") + "\"pss\":";
            str = str3 + (processMemoryInfo[0].getTotalPss() * 1024);
            str2 = ",";
        }
        android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            str = ((str + str2) + "\"total\":") + memoryInfo.totalMem;
            str2 = ",";
        }
        return ((((((str + str2) + "\"free\":") + memoryInfo.availMem) + ",") + "\"threshold\":") + memoryInfo.threshold) + "}";
    }

    public java.lang.String GetOS() {
        if (android.os.Build.VERSION.RELEASE == null) {
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
        return "Android " + android.os.Build.VERSION.RELEASE;
    }

    public java.lang.String GetOperatorName() {
        java.lang.String simOperatorName;
        return (!checkPermission("android.permission.READ_PHONE_STATE") || (simOperatorName = ((android.telephony.TelephonyManager) this.mContext.getSystemService("phone")).getSimOperatorName()) == null || simOperatorName.equals("")) ? android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN : simOperatorName;
    }

    public java.lang.String GetPhoneResolution() {
        android.view.WindowManager windowManager = (android.view.WindowManager) this.mContext.getSystemService("window");
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
    }

    public long GetStorageFreeSpaceSize() {
        java.lang.String str = this.mDataDir;
        if (str != null && str.length() > 0) {
            return GetAvailSpaceSize(this.mDataDir);
        }
        android.util.Log.e("Unity", "Java GetStorageFreeSpaceSize dataDir is null");
        return 0L;
    }

    public java.lang.String GetSystemModel() {
        java.lang.String str = android.os.Build.MODEL;
        return (str == null || str.isEmpty()) ? android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN : str;
    }

    public java.lang.String GetSystemVersion() {
        java.lang.String str = android.os.Build.VERSION.RELEASE;
        return (str == null || str.isEmpty()) ? android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN : str;
    }

    public boolean HasNotchInScreen() {
        android.util.Log.e("unity", "HasNotchInScreen :" + com.dodjoy.dodlib.NotchInScreenHelper.hasNotchInScreen(mActivity));
        return com.dodjoy.dodlib.NotchInScreenHelper.hasNotchInScreen(mActivity);
    }

    public boolean IsDeviceRooted() {
        return checkRootMethod1() || checkRootMethod2() || checkRootMethod3() || checkRootMethod4();
    }

    public void checkHavePackageName(java.lang.String str) {
        java.util.List<android.content.pm.PackageInfo> installedPackages = this.mContext.getPackageManager().getInstalledPackages(0);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                arrayList.add(installedPackages.get(i).packageName);
            }
        }
        java.util.List listAsList = java.util.Arrays.asList(str.split(","));
        if (listAsList != null) {
            for (int i2 = 0; i2 < listAsList.size(); i2++) {
                java.lang.String str2 = (java.lang.String) listAsList.get(i2);
                if (arrayList.contains(str2)) {
                    showQuitTip(this.mContext, str2);
                }
            }
        }
    }

    public boolean findBinary(java.lang.String str) {
        for (java.lang.String str2 : new java.lang.String[]{"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"}) {
            if (new java.io.File(str2 + str).exists()) {
                return true;
            }
        }
        return false;
    }

    public java.lang.String getIPAddress() {
        android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "1";
        }
        if (activeNetworkInfo.getType() != 0 && activeNetworkInfo.getType() != 1) {
            return "1";
        }
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                java.util.Enumeration<java.net.InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    java.net.InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof java.net.Inet4Address)) {
                        return inetAddressNextElement.getHostAddress();
                    }
                }
            }
            return "1";
        } catch (java.net.SocketException e) {
            e.printStackTrace();
            return "1";
        }
    }

    public void showQuitTip(android.content.Context context, java.lang.String str) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setMessage("检测到软件有异常 :" + str + ",程序需关闭 ");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new android.content.DialogInterface.OnClickListener() { // from class: com.dodjoy.dodlib.DodDeviceMgr.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                java.lang.System.exit(0);
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }
}
