package com.tencent.beacon.core.info;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.beacon.core.info.e f187a;

    private e() {
    }

    private java.lang.String a(java.lang.String str) {
        return str == null ? "" : str.toLowerCase();
    }

    private java.lang.StringBuilder a(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : bArr) {
            sb.append(java.lang.String.format("%02X:", java.lang.Byte.valueOf(b)));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb;
    }

    public static synchronized com.tencent.beacon.core.info.e d(android.content.Context context) {
        if (f187a == null && context != null) {
            f187a = new com.tencent.beacon.core.info.e();
        }
        return f187a;
    }

    public static java.lang.String l(android.content.Context context) {
        java.lang.String strK = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        com.tencent.beacon.core.info.e eVar = f187a;
        if (eVar != null) {
            strK = eVar.k(context);
        }
        com.tencent.beacon.core.e.d.a("[core] NetWork Types:" + strK, new java.lang.Object[0]);
        return strK;
    }

    private android.util.DisplayMetrics r(android.content.Context context) {
        try {
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics;
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.b("[model] getDisplayMetrics error!", new java.lang.Object[0]);
            com.tencent.beacon.core.e.d.a(th);
            return null;
        }
    }

    public java.lang.String a(android.content.Context context) {
        java.lang.String string = "";
        if (!com.tencent.beacon.upload.UploadStrategy.IS_COLLECT_MAC) {
            com.tencent.beacon.core.e.d.a("[core] current collect mac be refused! isCollectMAC: %s", java.lang.Boolean.FALSE);
            return "";
        }
        if (context == null) {
            com.tencent.beacon.core.e.d.b("[core] getMacAddress but context is null!", new java.lang.Object[0]);
            return "";
        }
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                while (networkInterfaces.hasMoreElements()) {
                    java.net.NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                    byte[] hardwareAddress = networkInterfaceNextElement.getHardwareAddress();
                    if (hardwareAddress != null && hardwareAddress.length != 0) {
                        sb.append(networkInterfaceNextElement.getName());
                        sb.append(":");
                        sb.append((java.lang.CharSequence) a(hardwareAddress));
                        sb.append(",");
                    }
                }
                string = sb.toString();
            }
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
        }
        com.tencent.beacon.core.e.d.a("[core] Mac Address:" + string, new java.lang.Object[0]);
        return string;
    }

    public boolean a() {
        return android.os.Environment.getExternalStorageState().equals("mounted");
    }

    public java.lang.String b() {
        java.lang.String str = "";
        try {
            str = android.os.Build.VERSION.SDK;
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.b("[core] getApiLevel error", new java.lang.Object[0]);
            com.tencent.beacon.core.e.d.a(th);
        }
        com.tencent.beacon.core.e.d.a("[core] apiLevel: %s", str);
        return str;
    }

    public java.lang.String b(android.content.Context context) {
        java.lang.String lowerCase;
        if (context == null) {
            com.tencent.beacon.core.e.d.b("[core] getAndroidId but context is null!", new java.lang.Object[0]);
            return "";
        }
        if (!com.tencent.beacon.upload.UploadStrategy.IS_ANDROID_ID) {
            com.tencent.beacon.core.e.d.a("[core] current collect androidID be refused! isCollectAndroidID: %s", java.lang.Boolean.FALSE);
            return "";
        }
        try {
            java.lang.String string = android.provider.Settings.Secure.getString(context.getContentResolver(), com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
            lowerCase = string == null ? "" : string.toLowerCase();
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.b("[core] getAndroidId error!", new java.lang.Object[0]);
            com.tencent.beacon.core.e.d.a(th);
            lowerCase = "";
        }
        com.tencent.beacon.core.e.d.d("[core] Android ID:" + lowerCase, new java.lang.Object[0]);
        return lowerCase;
    }

    public int c() {
        return java.lang.Integer.parseInt(b());
    }

    public java.lang.String c(android.content.Context context) {
        try {
            if (java.lang.Integer.parseInt(android.os.Build.VERSION.SDK) < 9) {
                com.tencent.beacon.core.e.d.b("[audit] Api level < 9;return null!", new java.lang.Object[0]);
                return "";
            }
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("[audit] get app_last_updated_time:");
            sb.append(java.lang.String.valueOf(packageInfo.lastUpdateTime));
            com.tencent.beacon.core.e.d.a(sb.toString(), new java.lang.Object[0]);
            return java.lang.String.valueOf(packageInfo.lastUpdateTime);
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            com.tencent.beacon.core.e.d.b("[audit] get app_last_updated_time failed!", new java.lang.Object[0]);
            return "";
        }
    }

    public java.lang.String d() {
        java.lang.String str = "";
        try {
            str = android.os.Build.BRAND;
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.b("getBrand error!", new java.lang.Object[0]);
            com.tencent.beacon.core.e.d.a(th);
        }
        com.tencent.beacon.core.e.d.a("[core] Brand:" + str, new java.lang.Object[0]);
        return str;
    }

    public int e() {
        java.io.BufferedReader bufferedReader;
        int i = 0;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec(new java.lang.String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).getInputStream(), java.nio.charset.Charset.forName("UTF-8")));
            try {
                java.lang.String line = bufferedReader.readLine();
                if (line != null) {
                    i = java.lang.Integer.parseInt(line.trim()) / 1000;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    com.tencent.beacon.core.e.d.a(th);
                    return i;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e) {
                            com.tencent.beacon.core.e.d.a(e);
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        return i;
    }

    public java.lang.String e(android.content.Context context) throws java.lang.Throwable {
        if (!com.tencent.beacon.upload.UploadStrategy.IS_COLLECT_MAC) {
            com.tencent.beacon.core.e.d.a("[core] current collect mac be refused! isCollectMAC: %s", java.lang.Boolean.FALSE);
            return "";
        }
        java.lang.String strE = com.tencent.beacon.core.e.b.e("/sys/class/net/eth0/address");
        java.lang.String strSubstring = (strE.trim().equals("") || strE.length() < 17) ? "" : strE.toLowerCase().substring(0, 17);
        com.tencent.beacon.core.e.d.a("[core] Ethernet Mac Address:" + strSubstring, new java.lang.Object[0]);
        return strSubstring;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public java.lang.String f() {
        java.io.BufferedReader bufferedReader;
        java.lang.String strTrim = "";
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec(new java.lang.String[]{"/system/bin/cat", "/proc/cpuinfo"}).getInputStream(), java.nio.charset.Charset.forName("UTF-8")));
            while (true) {
                try {
                    java.lang.String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.contains("Processor")) {
                        strTrim = line.substring(line.indexOf(":") + 1).trim();
                        break;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        com.tencent.beacon.core.e.d.a(th);
                        if (bufferedReader != null) {
                            break;
                        }
                        return strTrim;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e) {
                                com.tencent.beacon.core.e.d.a(e);
                            }
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        return strTrim;
    }

    public java.lang.String f(android.content.Context context) {
        java.lang.String lowerCase = "";
        if (!com.tencent.beacon.upload.UploadStrategy.IS_COLLECT_IMEI) {
            com.tencent.beacon.core.e.d.a("[core] current collect imei be refused! isCollectImei: %s", java.lang.Boolean.FALSE);
            return "";
        }
        if (context == null) {
            com.tencent.beacon.core.e.d.b("[core] getImei but context is null!", new java.lang.Object[0]);
            return "";
        }
        try {
            if (com.tencent.beacon.core.info.a.i(context)) {
                java.lang.String deviceId = ((android.telephony.TelephonyManager) context.getSystemService("phone")).getDeviceId();
                lowerCase = deviceId == null ? "" : deviceId.toLowerCase();
            }
        } catch (java.lang.Throwable unused) {
            com.tencent.beacon.core.e.d.b("[core] getImei error!", new java.lang.Object[0]);
        }
        com.tencent.beacon.core.e.d.d("[core] IMEI:" + lowerCase, new java.lang.Object[0]);
        return lowerCase;
    }

    public java.lang.String g() {
        try {
            return java.util.Locale.getDefault().getCountry();
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.b("[model] getCountry error!", new java.lang.Object[0]);
            com.tencent.beacon.core.e.d.a(th);
            return null;
        }
    }

    public java.lang.String g(android.content.Context context) {
        java.lang.String imei;
        if (!com.tencent.beacon.upload.UploadStrategy.IS_COLLECT_IMEI) {
            com.tencent.beacon.core.e.d.a("[core] current collect imei2 be refused! isCollectImei2: %s", java.lang.Boolean.FALSE);
        } else {
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                try {
                    imei = com.tencent.beacon.core.info.a.i(context) ? ((android.telephony.TelephonyManager) context.getSystemService("phone")).getImei(1) : null;
                } catch (java.lang.Throwable unused) {
                    com.tencent.beacon.core.e.d.b("[core] getImei error!", new java.lang.Object[0]);
                }
                return a(imei);
            }
            f(context);
        }
        return a(imei);
    }

    public java.lang.String h() {
        java.lang.String str = "";
        try {
            str = android.os.Build.MODEL;
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.b("[core] getDeviceName error", new java.lang.Object[0]);
            com.tencent.beacon.core.e.d.a(th);
        }
        com.tencent.beacon.core.e.d.a("[core] model name: %s", str);
        return str;
    }

    public java.lang.String h(android.content.Context context) {
        java.lang.String lowerCase = "";
        if (!com.tencent.beacon.upload.UploadStrategy.IS_COLLECT_IMEI) {
            com.tencent.beacon.core.e.d.a("[core] current collect imei be refused! isCollectImei: %s", java.lang.Boolean.FALSE);
            return "";
        }
        if (context == null) {
            com.tencent.beacon.core.e.d.b("[core] getImsi but context == null!", new java.lang.Object[0]);
            return "";
        }
        try {
            if (com.tencent.beacon.core.info.a.i(context)) {
                java.lang.String subscriberId = ((android.telephony.TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                lowerCase = subscriberId == null ? "" : subscriberId.toLowerCase();
            }
        } catch (java.lang.Throwable unused) {
            com.tencent.beacon.core.e.d.b("[core] getImsi error!", new java.lang.Object[0]);
        }
        com.tencent.beacon.core.e.d.a("[core] IMSI:" + lowerCase, new java.lang.Object[0]);
        return lowerCase;
    }

    public java.lang.String i(android.content.Context context) {
        java.lang.Throwable th;
        java.lang.String string;
        java.util.Enumeration<java.net.NetworkInterface> networkInterfaces;
        java.lang.String lowerCase = "";
        if (!com.tencent.beacon.upload.UploadStrategy.IS_COLLECT_MAC) {
            com.tencent.beacon.core.e.d.a("[core] current collect mac be refused! isCollectMAC: %s", java.lang.Boolean.FALSE);
            return "";
        }
        if (context == null) {
            com.tencent.beacon.core.e.d.b("[core] getMacAddress but context is null!", new java.lang.Object[0]);
            return "";
        }
        try {
            if (java.lang.Integer.valueOf(android.os.Build.VERSION.SDK).intValue() >= 23) {
                java.lang.String[] strArr = new java.lang.String[2];
                strArr[0] = "/sys/class/net/wlan0/address";
                strArr[1] = "/sys/devices/virtual/net/wlan0/address";
                java.lang.String strTrim = "";
                int i = 0;
                while (true) {
                    if (i >= 2) {
                        lowerCase = strTrim;
                        break;
                    }
                    try {
                        strTrim = com.tencent.beacon.core.e.b.e(strArr[i]).toString().trim();
                        if (strTrim != null && strTrim.length() > 0) {
                            lowerCase = strTrim.toLowerCase();
                            break;
                        }
                        i++;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        string = strTrim;
                        com.tencent.beacon.core.e.d.a(th);
                    }
                }
                if ("".equals(lowerCase) && (networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces()) != null) {
                    while (true) {
                        if (!networkInterfaces.hasMoreElements()) {
                            string = lowerCase;
                            break;
                        }
                        java.net.NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                        byte[] hardwareAddress = networkInterfaceNextElement.getHardwareAddress();
                        if ("wlan0".equals(networkInterfaceNextElement.getName()) && hardwareAddress != null && hardwareAddress.length != 0) {
                            string = a(hardwareAddress).toString();
                            break;
                        }
                    }
                } else {
                    string = lowerCase;
                    break;
                }
            } else {
                string = ((android.net.wifi.WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
                if (string == null) {
                    string = "";
                } else {
                    try {
                        string = string.toLowerCase();
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        com.tencent.beacon.core.e.d.a(th);
                    }
                }
            }
        } catch (java.lang.Throwable th4) {
            java.lang.String str = lowerCase;
            th = th4;
            string = str;
        }
        com.tencent.beacon.core.e.d.a("[core] Mac Address:" + string, new java.lang.Object[0]);
        return string;
    }

    public boolean i() {
        return com.tencent.beacon.core.e.g.d().e();
    }

    public java.lang.String j() {
        try {
            return java.util.Locale.getDefault().getLanguage();
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.b("[model] getLanguage error!", new java.lang.Object[0]);
            com.tencent.beacon.core.e.d.a(th);
            return null;
        }
    }

    public java.lang.String j(android.content.Context context) {
        java.lang.String lowerCase = null;
        if (!com.tencent.beacon.upload.UploadStrategy.IS_COLLECT_IMEI) {
            com.tencent.beacon.core.e.d.a("[core] current collect meid be refused! isCollectMeid: %s", java.lang.Boolean.FALSE);
        } else if (android.os.Build.VERSION.SDK_INT < 26) {
            lowerCase = f(context);
        } else {
            try {
                if (com.tencent.beacon.core.info.a.i(context)) {
                    java.lang.String meid = ((android.telephony.TelephonyManager) context.getSystemService("phone")).getMeid();
                    lowerCase = meid == null ? "" : meid.toLowerCase();
                }
            } catch (java.lang.Throwable unused) {
                com.tencent.beacon.core.e.d.b("[core] getImei error!", new java.lang.Object[0]);
            }
        }
        return a(lowerCase);
    }

    public java.lang.String k() {
        return android.os.Build.MANUFACTURER;
    }

    public java.lang.String k(android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager;
        java.lang.String str;
        java.lang.String str2 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            if (activeNetworkInfo.getType() != 1) {
                if (activeNetworkInfo.getType() == 0 && (telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone")) != null) {
                    switch (telephonyManager.getNetworkType()) {
                        case 1:
                            str = "GPRS";
                            break;
                        case 2:
                            str = "EDGE";
                            break;
                        case 3:
                            str = "UMTS";
                            break;
                        case 4:
                            str = "CDMA";
                            break;
                        case 5:
                            str = "EVDO_0";
                            break;
                        case 6:
                            str = "EVDO_A";
                            break;
                        case 7:
                            str = "1xRTT";
                            break;
                        case 8:
                            str = "HSDPA";
                            break;
                        case 9:
                            str = "HSUPA";
                            break;
                        case 10:
                            str = "HSPA";
                            break;
                        case 11:
                            str = "iDen";
                            break;
                        case 12:
                            str = "EVDO_B";
                            break;
                        case 13:
                            str = "LTE";
                            break;
                        case 14:
                            str = "eHRPD";
                            break;
                        case 15:
                            str = "HSPA+";
                            break;
                        default:
                            str = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
                            break;
                    }
                }
            } else {
                str = "wifi";
            }
            str2 = str;
        } catch (java.lang.Exception e) {
            com.tencent.beacon.core.e.d.a(e);
        }
        com.tencent.beacon.core.e.d.a("[core] NetWork Type:" + str2, new java.lang.Object[0]);
        return str2;
    }

    public java.lang.String l() throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.io.BufferedReader bufferedReader3 = null;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.FileReader(new java.io.File("/sys/block/mmcblk0/device/type")));
            try {
                sb.append(bufferedReader.readLine());
            } catch (java.lang.Exception unused) {
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedReader3 = bufferedReader;
                com.tencent.beacon.core.e.b.a((java.io.Closeable) bufferedReader3);
                throw th;
            }
        } catch (java.lang.Exception unused2) {
            bufferedReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        com.tencent.beacon.core.e.b.a((java.io.Closeable) bufferedReader);
        sb.append(",");
        try {
            bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader(new java.io.File("/sys/block/mmcblk0/device/name")));
            try {
                sb.append(bufferedReader2.readLine());
            } catch (java.lang.Exception unused3) {
            } catch (java.lang.Throwable th3) {
                th = th3;
                bufferedReader3 = bufferedReader2;
                com.tencent.beacon.core.e.b.a((java.io.Closeable) bufferedReader3);
                throw th;
            }
        } catch (java.lang.Exception unused4) {
            bufferedReader2 = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
        com.tencent.beacon.core.e.b.a((java.io.Closeable) bufferedReader2);
        sb.append(",");
        try {
            java.io.BufferedReader bufferedReader4 = new java.io.BufferedReader(new java.io.FileReader(new java.io.File("/sys/block/mmcblk0/device/cid")));
            try {
                sb.append(bufferedReader4.readLine());
                com.tencent.beacon.core.e.b.a((java.io.Closeable) bufferedReader4);
            } catch (java.lang.Exception unused5) {
                bufferedReader3 = bufferedReader4;
                com.tencent.beacon.core.e.b.a((java.io.Closeable) bufferedReader3);
            } catch (java.lang.Throwable th5) {
                th = th5;
                bufferedReader3 = bufferedReader4;
                com.tencent.beacon.core.e.b.a((java.io.Closeable) bufferedReader3);
                throw th;
            }
        } catch (java.lang.Exception unused6) {
        } catch (java.lang.Throwable th6) {
            th = th6;
        }
        java.lang.String string = sb.toString();
        com.tencent.beacon.core.e.d.a("[core]Nand Info:" + string, new java.lang.Object[0]);
        return string;
    }

    public int m() {
        try {
            java.io.File[] fileArrListFiles = new java.io.File("/sys/devices/system/cpu/").listFiles(new com.tencent.beacon.core.info.d(this));
            if (fileArrListFiles == null) {
                return 1;
            }
            return fileArrListFiles.length;
        } catch (java.lang.Exception e) {
            com.tencent.beacon.core.e.d.b("[model] CPU Count: Failed.", new java.lang.Object[0]);
            com.tencent.beacon.core.e.d.a(e);
            return 1;
        }
    }

    public java.lang.String m(android.content.Context context) {
        android.util.DisplayMetrics displayMetricsR = r(context);
        if (displayMetricsR == null) {
            return "";
        }
        return displayMetricsR.widthPixels + "*" + displayMetricsR.heightPixels;
    }

    public int n(android.content.Context context) {
        try {
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return 160;
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            if (displayMetrics.density - 1.0f <= 1.0E-6d) {
                return 160;
            }
            double d = displayMetrics.density;
            java.lang.Double.isNaN(d);
            if (d - 0.75d <= 1.0E-6d) {
                return 120;
            }
            double d2 = displayMetrics.density;
            java.lang.Double.isNaN(d2);
            if (d2 - 1.5d <= 1.0E-6d) {
                return com.tencent.smtt.sdk.TbsListener.ErrorCode.TPATCH_VERSION_FAILED;
            }
            double d3 = displayMetrics.density;
            java.lang.Double.isNaN(d3);
            if (d3 - 2.0d <= 1.0E-6d) {
                return cn.yunzhisheng.asr.JniUscClient.au;
            }
            double d4 = displayMetrics.density;
            java.lang.Double.isNaN(d4);
            return d4 - 3.0d <= 1.0E-6d ? 480 : 160;
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            return 160;
        }
    }

    public java.lang.String n() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("Android ");
        stringBuffer.append(r());
        stringBuffer.append(",level ");
        stringBuffer.append(b());
        java.lang.String string = stringBuffer.toString();
        com.tencent.beacon.core.e.d.a("[core] os version: %s", string);
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0098 A[Catch: all -> 0x0094, TRY_LEAVE, TryCatch #2 {all -> 0x0094, blocks: (B:37:0x0090, B:41:0x0098), top: B:48:0x0090 }] */
    public java.lang.String o() {
        java.lang.Throwable th;
        java.io.BufferedReader bufferedReader;
        java.io.FileReader fileReader;
        try {
            try {
                fileReader = new java.io.FileReader("/proc/meminfo");
                try {
                    bufferedReader = new java.io.BufferedReader(fileReader, 8192);
                    try {
                        java.lang.String line = bufferedReader.readLine();
                        if (line != null) {
                            long j = java.lang.Long.parseLong(line.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) / 1024;
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append(j);
                            sb.append("");
                            java.lang.String string = sb.toString();
                            try {
                                bufferedReader.close();
                                fileReader.close();
                            } catch (java.lang.Throwable th2) {
                                com.tencent.beacon.core.e.d.b("[model] IO close error!", new java.lang.Object[0]);
                                com.tencent.beacon.core.e.d.a(th2);
                            }
                            return string;
                        }
                        bufferedReader.close();
                        fileReader.close();
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        try {
                            com.tencent.beacon.core.e.d.b("[model] get free RAM error!", new java.lang.Object[0]);
                            com.tencent.beacon.core.e.d.a(th);
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                        } catch (java.lang.Throwable th4) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    if (fileReader != null) {
                                        fileReader.close();
                                    }
                                } catch (java.lang.Throwable th5) {
                                    com.tencent.beacon.core.e.d.b("[model] IO close error!", new java.lang.Object[0]);
                                    com.tencent.beacon.core.e.d.a(th5);
                                    throw th4;
                                }
                            } else if (fileReader != null) {
                                fileReader.close();
                            }
                            throw th4;
                        }
                    }
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    bufferedReader = null;
                }
            } catch (java.lang.Throwable th7) {
                com.tencent.beacon.core.e.d.b("[model] IO close error!", new java.lang.Object[0]);
                com.tencent.beacon.core.e.d.a(th7);
            }
        } catch (java.lang.Throwable th8) {
            th = th8;
            bufferedReader = null;
            fileReader = null;
        }
        return null;
    }

    public java.lang.String o(android.content.Context context) {
        java.lang.String bssid = "";
        if (context == null) {
            com.tencent.beacon.core.e.d.b("[core] getWifiSSID but context == null!", new java.lang.Object[0]);
            return "";
        }
        try {
            android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo.getBSSID() != null) {
                bssid = connectionInfo.getBSSID();
            }
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            com.tencent.beacon.core.e.d.b("getWifiSSID error!", new java.lang.Object[0]);
        }
        com.tencent.beacon.core.e.d.a("[core] Wifi SSID:" + bssid, new java.lang.Object[0]);
        return bssid;
    }

    public java.lang.String p() {
        java.util.ArrayList arrayListA = com.tencent.beacon.core.e.b.a(new java.lang.String[]{"/system/bin/sh", "-c", "getprop ro.build.fingerprint"});
        return (arrayListA == null || arrayListA.size() <= 0) ? "" : (java.lang.String) arrayListA.get(0);
    }

    public java.lang.String p(android.content.Context context) {
        java.lang.String bssid = "";
        if (!com.tencent.beacon.upload.UploadStrategy.IS_COLLECT_MAC) {
            com.tencent.beacon.core.e.d.a("[core] current collect mac be refused! isCollectMAC: %s", java.lang.Boolean.FALSE);
            return "";
        }
        if (context == null) {
            com.tencent.beacon.core.e.d.b("[core] getMacAddress but context == null!", new java.lang.Object[0]);
            return "";
        }
        try {
            bssid = ((android.net.wifi.WifiManager) context.getSystemService("wifi")).getConnectionInfo().getBSSID();
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            com.tencent.beacon.core.e.d.b("getMacAddress error!", new java.lang.Object[0]);
        }
        com.tencent.beacon.core.e.d.a("[core] Wifi BSSID:" + bssid, new java.lang.Object[0]);
        return bssid;
    }

    public java.lang.String q() {
        java.lang.String string;
        try {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
            long blockSize = statFs.getBlockSize();
            long blockCount = statFs.getBlockCount();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(((blockCount * blockSize) / 1024) / 1024);
            sb.append("");
            string = sb.toString();
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.b("getDisplayMetrics error!", new java.lang.Object[0]);
            com.tencent.beacon.core.e.d.a(th);
            string = null;
        }
        com.tencent.beacon.core.e.d.a("[core] Rom Size:" + string, new java.lang.Object[0]);
        return string;
    }

    public java.lang.String q(android.content.Context context) {
        java.lang.String ssid = "";
        if (context == null) {
            com.tencent.beacon.core.e.d.b("[core] getWifiSSID but context == null!", new java.lang.Object[0]);
            return "";
        }
        try {
            android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo.getSSID() != null) {
                ssid = connectionInfo.getSSID();
            }
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            com.tencent.beacon.core.e.d.b("getWifiSSID error!", new java.lang.Object[0]);
        }
        com.tencent.beacon.core.e.d.a("[core] Wifi SSID:" + ssid, new java.lang.Object[0]);
        return ssid;
    }

    public java.lang.String r() {
        java.lang.String str = "";
        try {
            str = android.os.Build.VERSION.RELEASE;
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.b("[core] getVersion error", new java.lang.Object[0]);
            com.tencent.beacon.core.e.d.a(th);
        }
        com.tencent.beacon.core.e.d.a("[core] version: %s", str);
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean s() {
        java.io.BufferedReader bufferedReader;
        boolean z = false;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec(new java.lang.String[]{"/system/bin/cat", "/proc/cpuinfo"}).getInputStream(), java.nio.charset.Charset.defaultCharset()));
            while (true) {
                try {
                    java.lang.String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.toLowerCase().contains("armv7")) {
                        z = true;
                        break;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        com.tencent.beacon.core.e.d.a(th);
                        if (bufferedReader != null) {
                            break;
                        }
                        return z;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e) {
                                com.tencent.beacon.core.e.d.a(e);
                            }
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        return z;
    }
}
