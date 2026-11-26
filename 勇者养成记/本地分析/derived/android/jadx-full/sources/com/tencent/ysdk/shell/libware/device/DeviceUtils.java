package com.tencent.ysdk.shell.libware.device;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DeviceUtils {
    private static final java.lang.String ANDROID_ID = "ANDROID_ID";
    private static final java.lang.String APN_PROP_PROXY = "proxy";
    private static final java.lang.String DEFAULT_MAC_ADDRESS = "02:00:00:00:00:00";
    private static final int GET_DEVICE_INFO_MAX_TRY_COUNT = 5;
    private static final java.lang.String IMEI = "IMEI";
    private static final java.lang.String IMSI = "IMSI";
    private static final int OS_ANDROID = 1;
    private static final int OS_IOS = 2;
    private static android.net.Uri PREFERRED_APN_URI = android.net.Uri.parse("content://telephony/carriers/preferapn");
    private static final java.util.Map<java.lang.String, java.lang.String> DEVICE_INFO_CACHE = new java.util.concurrent.ConcurrentHashMap();
    private static final java.util.Map<java.lang.String, java.lang.Integer> GET_DEVICE_INFO_TRY_COUNT_MAP = new java.util.concurrent.ConcurrentHashMap();
    private static java.lang.String mCPUName = "";
    private static float mDpi = 0.0f;
    private static int mCpuCoreNumber = 0;
    private static int mIs64bit = -1;
    private static java.lang.String mCPUArchitecture = "";
    private static long mTotalMemory = -1;
    private static int mScreenHeight = 0;
    private static int mScreenWidth = 0;
    private static boolean sIsSensitivePermissionSwitchOpen = false;
    private static java.lang.String deviceinfo = null;
    public static java.lang.String devOAID = "";

    private static java.lang.String base64(byte[] bArr) {
        return android.util.Base64.encodeToString(bArr, 0);
    }

    public static java.lang.String buildImei2(android.content.Context context) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String[] imeis = getImeis(context);
        if (imeis != null && imeis.length > 0) {
            if (!android.text.TextUtils.isEmpty(imeis[0])) {
                sb.append(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_IMEI1);
                sb.append("=");
                sb.append(imeis[0]);
                sb.append(";");
            }
            if (imeis.length > 1 && !android.text.TextUtils.isEmpty(imeis[1])) {
                sb.append("imei2");
                sb.append("=");
                sb.append(imeis[1]);
                sb.append(";");
            }
        }
        java.lang.String androidId = getAndroidId(context);
        if (!android.text.TextUtils.isEmpty(androidId)) {
            sb.append(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
            sb.append("=");
            sb.append(androidId);
            sb.append(";");
        }
        java.lang.String macAddress = getMacAddress(context);
        if (!android.text.TextUtils.isEmpty(macAddress)) {
            sb.append(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_MAC);
            sb.append("=");
            sb.append(macAddress);
            sb.append(";");
        }
        java.lang.String ipAddress = getIpAddress(context);
        if (!android.text.TextUtils.isEmpty(ipAddress)) {
            sb.append(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_IP);
            sb.append("=");
            sb.append(ipAddress);
            sb.append(";");
        }
        java.lang.String qImei = getQImei();
        if (!android.text.TextUtils.isEmpty(ipAddress)) {
            sb.append("qimei");
            sb.append("=");
            sb.append(qImei);
            sb.append(";");
        }
        java.lang.String qImei36 = getQImei36();
        if (!android.text.TextUtils.isEmpty(qImei36)) {
            sb.append("qimei36");
            sb.append("=");
            sb.append(qImei36);
            sb.append(";");
        }
        return sb.toString();
    }

    public static java.lang.String buildImei2WithOAID(android.content.Context context) {
        try {
            if (android.text.TextUtils.isEmpty(getOAID())) {
                return buildImei2(context);
            }
            return buildImei2(context) + "oaid=" + getOAID() + ";";
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK buildImei2WithOAID 设备信息错误");
            return "";
        }
    }

    private static java.lang.String encodeUA(java.lang.String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            ";".equals(java.lang.Character.valueOf(str.charAt(i)));
        }
        try {
            return java.net.URLEncoder.encode(str, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static java.lang.String getAbsolutelyResolution(android.content.Context context) {
        try {
            if (mScreenWidth == 0 || mScreenHeight == 0) {
                android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                if (displayMetrics == null || context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
                    return "";
                }
                if (context.getResources().getConfiguration().orientation != 2) {
                    mScreenWidth = displayMetrics.widthPixels;
                    mScreenHeight = displayMetrics.heightPixels;
                } else {
                    mScreenHeight = displayMetrics.widthPixels;
                    mScreenWidth = displayMetrics.heightPixels;
                }
            }
            return mScreenWidth + "*" + mScreenHeight;
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static org.json.JSONObject getAllDeviceInfo(android.content.Context context) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("qImei", getQImei());
            jSONObject.put("appVersion", com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppVersionName(context));
            jSONObject.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_GAME_VERSION_CODE, com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppVersionCode(context));
            jSONObject.put("osSystem", "android");
            jSONObject.put("deviceResolution", getResolution(context));
            jSONObject.put("deviceApn", com.tencent.ysdk.shell.libware.device.APNUtil.getApnName(context));
            jSONObject.put("mobileService", com.tencent.ysdk.shell.libware.device.APNUtil.getSimOperator(context));
            jSONObject.put("deviceTradeMark", getBrand());
            jSONObject.put("deviceManufacturer", getManufacturer());
            jSONObject.put("deviceModel", getModel());
            jSONObject.put("deviceImei", getImei(context));
            jSONObject.put("deviceName", getModel());
            jSONObject.put("deviceRom", getROMInfo());
            jSONObject.put("deviceRam", getRAMInfo());
            jSONObject.put("deviceCPU", getCpuInfo());
            return jSONObject;
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public static java.lang.String getAndroidId(android.content.Context context) {
        return getAndroidIdInPhone(context);
    }

    public static java.lang.String getAndroidIdInPhone(android.content.Context context) {
        java.lang.String valueFromCacheIfExistAndNotNull = getValueFromCacheIfExistAndNotNull(ANDROID_ID);
        if (!android.text.TextUtils.isEmpty(valueFromCacheIfExistAndNotNull)) {
            return valueFromCacheIfExistAndNotNull;
        }
        if (isGetDeviceInfoOutOfLimit(ANDROID_ID)) {
            return "";
        }
        java.lang.String string = "";
        try {
            string = android.provider.Settings.Secure.getString(context.getContentResolver(), com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
        } catch (java.lang.Throwable th) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, th);
        }
        if (android.text.TextUtils.isEmpty(string)) {
            return "";
        }
        DEVICE_INFO_CACHE.put(ANDROID_ID, string);
        return string;
    }

    public static java.lang.String getAndroidIdInSdCard(android.content.Context context) {
        return com.tencent.ysdk.shell.libware.file.FileUtil.read(com.tencent.ysdk.shell.libware.file.FileUtil.getCommonRootDir(context) + "/.aid");
    }

    public static long getAvailableExternalMemorySize() {
        if (!com.tencent.ysdk.shell.libware.file.FileUtil.isSDCardExistAndCanWrite()) {
            return -1L;
        }
        java.io.File externalStorageDirectory = android.os.Environment.getExternalStorageDirectory();
        if (!externalStorageDirectory.exists()) {
            return -1L;
        }
        try {
            android.os.StatFs statFs = new android.os.StatFs(externalStorageDirectory.getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (java.lang.Throwable unused) {
            return -1L;
        }
    }

    public static long getAvailableInternalMemorySize() {
        java.io.File dataDirectory = android.os.Environment.getDataDirectory();
        if (!dataDirectory.exists()) {
            return -1L;
        }
        android.os.StatFs statFs = new android.os.StatFs(dataDirectory.getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static java.lang.String getBrand() {
        return android.os.Build.BRAND;
    }

    public static java.lang.String getCPUArchitecture() {
        if (!android.text.TextUtils.isEmpty(mCPUArchitecture)) {
            return mCPUArchitecture;
        }
        queryCPUInfo();
        return mCPUArchitecture;
    }

    public static long getCpuCoreNumber() {
        int i = mCpuCoreNumber;
        if (i > 0) {
            return i;
        }
        try {
            mCpuCoreNumber = java.lang.Runtime.getRuntime().availableProcessors();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return mCpuCoreNumber;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String getCpuInfo() throws java.lang.Throwable {
        java.io.RandomAccessFile randomAccessFile;
        java.io.IOException e;
        int i;
        int i2 = -1;
        java.io.RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                try {
                    randomAccessFile = new java.io.RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/stats/time_in_state", "r");
                    while (true) {
                        try {
                            java.lang.String line = randomAccessFile.readLine();
                            if (line == null) {
                                break;
                            }
                            java.lang.String[] strArrSplit = line.split("\\s+");
                            if (strArrSplit.length >= 2 && java.lang.Integer.parseInt(strArrSplit[1]) > 0 && (i = java.lang.Integer.parseInt(strArrSplit[0]) / 1000) > i2) {
                                i2 = i;
                            }
                        } catch (java.io.IOException e2) {
                            e = e2;
                            e.printStackTrace();
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            return "" + i2;
                        }
                    }
                    randomAccessFile.close();
                    randomAccessFile.close();
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            randomAccessFile2.close();
                        } catch (java.lang.Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (java.io.IOException e4) {
                randomAccessFile = null;
                e = e4;
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (0 != 0) {
                    randomAccessFile2.close();
                }
                throw th;
            }
        } catch (java.lang.Exception e5) {
            e5.printStackTrace();
        }
        return "" + i2;
    }

    public static java.lang.String getCpuName() {
        if (!android.text.TextUtils.isEmpty(mCPUName)) {
            return mCPUName;
        }
        queryCPUInfo();
        return mCPUName;
    }

    public static java.lang.String getDeviceinfoForCgiReport(android.content.Context context) {
        try {
            if (deviceinfo == null) {
                android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
                android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("imei=");
                sb.append(getImei(context));
                sb.append('&');
                sb.append("model=");
                sb.append(android.os.Build.MODEL);
                sb.append('&');
                sb.append("os=");
                sb.append(android.os.Build.VERSION.RELEASE);
                sb.append('&');
                sb.append("apilevel=");
                sb.append(android.os.Build.VERSION.SDK_INT);
                sb.append('&');
                java.lang.String apnName = com.tencent.ysdk.shell.libware.device.APNUtil.getApnName(context);
                if (apnName == null) {
                    apnName = "";
                }
                sb.append("network=");
                sb.append(apnName);
                sb.append('&');
                sb.append("sdcard=");
                sb.append(android.os.Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                sb.append('&');
                sb.append("display=");
                sb.append(displayMetrics.widthPixels);
                sb.append('*');
                sb.append(displayMetrics.heightPixels);
                sb.append('&');
                sb.append("manu=");
                sb.append(android.os.Build.MANUFACTURER);
                sb.append("&");
                sb.append("wifi=");
                sb.append(com.tencent.ysdk.shell.libware.device.APNUtil.getNetWorkName(context));
                deviceinfo = sb.toString();
            }
            return deviceinfo;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static float getDpi(android.content.Context context) {
        float f = mDpi;
        if (f != 0.0f) {
            return f;
        }
        android.util.DisplayMetrics displayMetrics = context != null ? context.getResources().getDisplayMetrics() : null;
        if (displayMetrics == null) {
            return 0.0f;
        }
        mDpi = displayMetrics.density;
        return mDpi;
    }

    private static java.lang.String getHardwareAddress() {
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return "";
            }
            java.lang.reflect.Method method = java.lang.Class.forName("java.net.NetworkInterface").getMethod("getHardwareAddress", new java.lang.Class[0]);
            while (networkInterfaces.hasMoreElements()) {
                java.net.NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                java.lang.Object objInvoke = method.invoke(networkInterfaceNextElement, new java.lang.Object[0]);
                if ((objInvoke instanceof byte[]) && networkInterfaceNextElement.getName().equalsIgnoreCase("wlan0")) {
                    byte[] bArr = (byte[]) objInvoke;
                    java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                    for (int i = 0; i < bArr.length - 1; i++) {
                        stringBuffer.append(getMAChex(bArr[i]));
                        stringBuffer.append(":");
                    }
                    stringBuffer.append(getMAChex(bArr[bArr.length - 1]));
                    com.tencent.ysdk.shell.libware.file.Logger.d("address", "getHardwareAddress name:" + networkInterfaceNextElement.getDisplayName() + " " + stringBuffer.toString());
                    return stringBuffer.toString();
                }
            }
            return "";
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static java.lang.String getIPAddress() {
        java.util.ArrayList list;
        java.lang.String upperCase = "";
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null && (list = java.util.Collections.list(networkInterfaces)) != null) {
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    for (java.net.InetAddress inetAddress : java.util.Collections.list(((java.net.NetworkInterface) it.next()).getInetAddresses())) {
                        if (!inetAddress.isLoopbackAddress()) {
                            upperCase = inetAddress.getHostAddress().toUpperCase();
                        }
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return upperCase;
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public static java.lang.String getImei(android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager;
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        java.lang.String valueFromCacheIfExistAndNotNull = getValueFromCacheIfExistAndNotNull(IMEI);
        if (!android.text.TextUtils.isEmpty(valueFromCacheIfExistAndNotNull)) {
            return valueFromCacheIfExistAndNotNull;
        }
        java.lang.String deviceId = "";
        try {
            if (!com.tencent.ysdk.shell.libware.apk.PermissionUtils.hasReadPhoneStatePermission(context) || isGetDeviceInfoOutOfLimit(IMEI) || (telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone")) == null) {
                return "";
            }
            deviceId = telephonyManager.getDeviceId();
            if (!android.text.TextUtils.isEmpty(deviceId)) {
                DEVICE_INFO_CACHE.put(IMEI, deviceId);
            }
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
        }
        return deviceId;
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public static java.lang.String getImei2(android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager;
        if (!com.tencent.ysdk.shell.libware.apk.PermissionUtils.hasReadPhoneStatePermission(context)) {
            return "";
        }
        try {
            if (android.os.Build.VERSION.SDK_INT < 23 || (telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone")) == null) {
                return "";
            }
            java.lang.String deviceId = telephonyManager.getDeviceId(1);
            return android.text.TextUtils.isEmpty(deviceId) ? "" : deviceId;
        } catch (java.lang.Exception unused) {
            com.tencent.ysdk.shell.libware.file.Logger.e("get imei2 err");
            return "";
        }
    }

    public static java.lang.String[] getImeis(android.content.Context context) {
        if (!com.tencent.ysdk.shell.libware.apk.PermissionUtils.hasReadPhoneStatePermission(context)) {
            return new java.lang.String[2];
        }
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return new java.lang.String[2];
        }
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return new java.lang.String[2];
        }
        java.lang.String[] imeisInner = getImeisInner(context, telephonyManager);
        if (imeisInner.length == 2 && !android.text.TextUtils.isEmpty(imeisInner[0]) && !android.text.TextUtils.isEmpty(imeisInner[1]) && imeisInner[0].equals(imeisInner[1])) {
            imeisInner[1] = "";
        }
        return imeisInner;
    }

    private static java.lang.String[] getImeisByInvoke(android.content.Context context) {
        try {
            if (!com.tencent.ysdk.shell.libware.apk.PermissionUtils.hasReadPhoneStatePermission(context)) {
                return new java.lang.String[2];
            }
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return new java.lang.String[2];
            }
            java.lang.reflect.Method declaredMethod = telephonyManager.getClass().getDeclaredMethod("getImei", java.lang.Integer.TYPE);
            declaredMethod.setAccessible(true);
            return new java.lang.String[]{(java.lang.String) declaredMethod.invoke(telephonyManager, 0), (java.lang.String) declaredMethod.invoke(telephonyManager, 1)};
        } catch (java.lang.Throwable th) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, th);
            return new java.lang.String[2];
        }
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    private static java.lang.String[] getImeisInner(android.content.Context context, android.telephony.TelephonyManager telephonyManager) {
        java.lang.String[] imeisByInvoke = new java.lang.String[2];
        try {
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                imeisByInvoke[0] = telephonyManager.getImei(0);
                imeisByInvoke[1] = telephonyManager.getImei(1);
            } else if (android.os.Build.VERSION.SDK_INT >= 23) {
                imeisByInvoke[0] = telephonyManager.getDeviceId(0);
                imeisByInvoke[1] = telephonyManager.getDeviceId(1);
            } else {
                imeisByInvoke = getImeisByInvoke(context);
            }
            if (android.text.TextUtils.isEmpty(imeisByInvoke[0]) && android.text.TextUtils.isEmpty(imeisByInvoke[1])) {
                imeisByInvoke[0] = telephonyManager.getDeviceId();
            }
        } catch (java.lang.Throwable th) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, th);
        }
        return imeisByInvoke;
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public static java.lang.String getImsi(android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager;
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        java.lang.String valueFromCacheIfExistAndNotNull = getValueFromCacheIfExistAndNotNull(IMSI);
        if (!android.text.TextUtils.isEmpty(valueFromCacheIfExistAndNotNull)) {
            return valueFromCacheIfExistAndNotNull;
        }
        java.lang.String subscriberId = "";
        try {
            if (!com.tencent.ysdk.shell.libware.apk.PermissionUtils.hasReadPhoneStatePermission(context) || isGetDeviceInfoOutOfLimit(IMSI) || (telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone")) == null) {
                return "";
            }
            subscriberId = telephonyManager.getSubscriberId();
            if (!android.text.TextUtils.isEmpty(subscriberId)) {
                DEVICE_INFO_CACHE.put(IMSI, subscriberId);
            }
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
        }
        return subscriberId;
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public static java.lang.String getIpAddress(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        if (!com.tencent.ysdk.shell.libware.apk.PermissionUtils.hasAccessNetworkStatePermission(context) || (activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return "";
        }
        if (activeNetworkInfo.getType() == 0) {
            return getIpAddressIn3Or4G();
        }
        if (activeNetworkInfo.getType() == 1) {
            return getIpAddressInWifi(context);
        }
        return activeNetworkInfo.getType() == 9 ? getLocalIp() : "";
    }

    private static java.lang.String getIpAddressIn3Or4G() {
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
            return "";
        } catch (java.net.SocketException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static java.lang.String getIpAddressInWifi(android.content.Context context) {
        return intIP2StringIP(((android.net.wifi.WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress());
    }

    public static int getIs64bit() {
        int i = mIs64bit;
        if (i != -1) {
            return i;
        }
        queryCPUInfo();
        return mIs64bit;
    }

    private static java.lang.String getLocalIp() {
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
            return "0.0.0.0";
        } catch (java.net.SocketException unused) {
            return "0.0.0.0";
        }
    }

    public static java.lang.String getLocalMacAddress(android.content.Context context) {
        if (!sIsSensitivePermissionSwitchOpen) {
            return "";
        }
        java.lang.String macAddressByWifiInfo = getMacAddressByWifiInfo(context);
        if (!DEFAULT_MAC_ADDRESS.equals(macAddressByWifiInfo)) {
            return macAddressByWifiInfo;
        }
        java.lang.String macAddressByNetworkInterface = getMacAddressByNetworkInterface();
        return !DEFAULT_MAC_ADDRESS.equals(macAddressByNetworkInterface) ? macAddressByNetworkInterface : "please open wifi";
    }

    private static java.lang.String getMAChex(byte b) {
        java.lang.String str = "00" + java.lang.Integer.toHexString(b);
        int length = str.length();
        return str.substring(length - 2, length);
    }

    public static java.lang.String getMacAddress(android.content.Context context) {
        if (!sIsSensitivePermissionSwitchOpen) {
            return "";
        }
        try {
            android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            android.net.wifi.WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            return (connectionInfo == null || android.text.TextUtils.isEmpty(connectionInfo.getMacAddress()) || connectionInfo.getMacAddress().equals(DEFAULT_MAC_ADDRESS)) ? getHardwareAddress() : connectionInfo.getMacAddress();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static java.lang.String getMacAddressByNetworkInterface() {
        java.util.ArrayList<java.net.NetworkInterface> list;
        byte[] hardwareAddress;
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null || (list = java.util.Collections.list(networkInterfaces)) == null) {
                return DEFAULT_MAC_ADDRESS;
            }
            for (java.net.NetworkInterface networkInterface : list) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0") && (hardwareAddress = networkInterface.getHardwareAddress()) != null && hardwareAddress.length > 0) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    for (byte b : hardwareAddress) {
                        sb.append(java.lang.String.format("%02x:", java.lang.Byte.valueOf(b)));
                    }
                    return sb.deleteCharAt(sb.length() - 1).toString();
                }
            }
            return DEFAULT_MAC_ADDRESS;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return DEFAULT_MAC_ADDRESS;
        }
    }

    @android.annotation.SuppressLint({"HardwareIds"})
    private static java.lang.String getMacAddressByWifiInfo(android.content.Context context) {
        android.net.wifi.WifiInfo connectionInfo;
        try {
            android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getSystemService("wifi");
            return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? DEFAULT_MAC_ADDRESS : connectionInfo.getMacAddress();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return DEFAULT_MAC_ADDRESS;
        }
    }

    public static java.lang.String getManufacturer() {
        return android.os.Build.MANUFACTURER;
    }

    public static java.lang.String getModel() {
        return android.os.Build.MODEL;
    }

    public static java.lang.String getOAID() {
        return devOAID;
    }

    public static int getOS() {
        return 1;
    }

    public static int getOrientation(android.content.Context context) {
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return 0;
        }
        return context.getResources().getConfiguration().orientation;
    }

    public static java.lang.String getPhoneName() {
        return android.os.Build.MODEL;
    }

    public static java.lang.String getQImei() {
        java.lang.String qimei = "";
        try {
            qimei = com.tencent.beacon.event.UserAction.getQIMEI();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(qimei) ? "" : qimei;
    }

    public static java.lang.String getQImei36() {
        java.lang.String qimeiNew = "";
        com.tencent.ydkbeacon.qimei.Qimei qimei = com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().getQimei();
        if (qimei == null) {
            return "";
        }
        try {
            qimeiNew = qimei.getQimeiNew();
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
        }
        return android.text.TextUtils.isEmpty(qimeiNew) ? "" : qimeiNew;
    }

    public static java.lang.String getRAMInfo() {
        try {
            java.io.FileReader fileReader = new java.io.FileReader("/proc/meminfo");
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(fileReader, 8192);
            fileReader.close();
            java.lang.String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                return "";
            }
            long jIntValue = ((long) java.lang.Integer.valueOf(line.split("\\s+")[1]).intValue()) * 1024;
            bufferedReader.close();
            return "" + jIntValue;
        } catch (java.io.IOException unused) {
            return "";
        }
    }

    public static java.lang.String getROMInfo() {
        android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
        long blockSize = statFs.getBlockSize();
        return "" + (statFs.getBlockCount() * blockSize);
    }

    public static java.lang.String getResolution(android.content.Context context) {
        try {
            android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics == null) {
                return "";
            }
            return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    public static long getTotalExternalMemorySize() {
        if (!com.tencent.ysdk.shell.libware.file.FileUtil.isSDCardExistAndCanWrite()) {
            return -1L;
        }
        java.io.File externalStorageDirectory = android.os.Environment.getExternalStorageDirectory();
        if (!externalStorageDirectory.exists()) {
            return -1L;
        }
        try {
            android.os.StatFs statFs = new android.os.StatFs(externalStorageDirectory.getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (java.lang.Exception unused) {
            return -1L;
        }
    }

    public static long getTotalInternalMemorySize() {
        java.io.File dataDirectory = android.os.Environment.getDataDirectory();
        if (!dataDirectory.exists()) {
            return -1L;
        }
        android.os.StatFs statFs = new android.os.StatFs(dataDirectory.getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    public static long getTotalMemory(android.content.Context context) {
        long j = mTotalMemory;
        if (j != -1) {
            return j;
        }
        try {
            android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
            android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            if (android.os.Build.VERSION.SDK_INT < 16) {
                return -1L;
            }
            mTotalMemory = memoryInfo.totalMem;
            return mTotalMemory;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public static java.lang.String getUserAgent(android.content.Context context) {
        java.lang.String property;
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            try {
                property = com.tencent.smtt.sdk.WebSettings.getDefaultUserAgent(context);
            } catch (java.lang.Exception unused) {
                property = java.lang.System.getProperty("http.agent");
            }
        } else {
            property = java.lang.System.getProperty("http.agent");
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        int length = property.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = property.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                stringBuffer.append(java.lang.String.format("\\u%04x", java.lang.Integer.valueOf(cCharAt)));
            } else {
                stringBuffer.append(cCharAt);
            }
        }
        return stringBuffer.toString();
    }

    private static java.lang.String getValueFromCacheIfExistAndNotNull(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || !DEVICE_INFO_CACHE.containsKey(str)) {
            return "";
        }
        java.lang.String str2 = DEVICE_INFO_CACHE.get(str);
        return android.text.TextUtils.isEmpty(str2) ? "" : str2;
    }

    private static java.lang.String intIP2StringIP(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    private static boolean isGetDeviceInfoOutOfLimit(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        if (!GET_DEVICE_INFO_TRY_COUNT_MAP.containsKey(str)) {
            updateGetDeviceInfoCount(str, 1);
            return false;
        }
        java.lang.Integer num = GET_DEVICE_INFO_TRY_COUNT_MAP.get(str);
        if (num == null) {
            updateGetDeviceInfoCount(str, 1);
            return false;
        }
        if (num.intValue() >= 5) {
            return true;
        }
        updateGetDeviceInfoCount(str, java.lang.Integer.valueOf(num.intValue() + 1).intValue());
        return false;
    }

    public static boolean isSdCardEmulated() {
        if (android.os.Build.VERSION.SDK_INT < 11) {
            return false;
        }
        try {
            return ((java.lang.Boolean) android.os.Environment.class.getMethod("isExternalStorageEmulated", new java.lang.Class[0]).invoke(null, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void queryCPUInfo() {
        try {
            queryCpuInfoInner();
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e("queryCPUInfo error", e);
        }
    }

    private static void queryCpuInfoInner() throws java.io.IOException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.lang.ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start().getInputStream(), com.unisound.b.f.b));
        java.lang.StringBuilder sb2 = sb;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            java.lang.String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            java.lang.String[] strArrSplit = line.split(":");
            if (!z2 && strArrSplit[0].toLowerCase().contains("processor")) {
                sb2 = new java.lang.StringBuilder(strArrSplit[1].replace("\t", ""));
                z2 = true;
            } else if (strArrSplit[0].equals("model name")) {
                sb2.append("_");
                sb2.append(strArrSplit[1]);
            }
            if (!z3 && strArrSplit[0].toLowerCase().contains("cpu architecture")) {
                mCPUArchitecture = strArrSplit[1].replace("\t", "");
                z3 = true;
            }
            if (!z && line.toLowerCase().contains("arch64")) {
                mIs64bit = 1;
                z = true;
            }
        }
        if (!z) {
            mIs64bit = 0;
        }
        mCPUName = sb2.toString();
        bufferedReader.close();
    }

    public static void setSensitivePermissionSwitchStatus(boolean z) {
        sIsSensitivePermissionSwitchOpen = z;
    }

    private static void updateGetDeviceInfoCount(java.lang.String str, int i) {
        GET_DEVICE_INFO_TRY_COUNT_MAP.put(str, java.lang.Integer.valueOf(i));
    }
}
