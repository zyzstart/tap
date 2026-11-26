package com.tencent.hlyyb.common.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f596a = "";
    private static java.lang.String b = "";
    private static java.lang.String c = "";
    private static java.lang.String d = "";

    public static int a() {
        return (int) (java.lang.Math.random() * 2.147483647E9d);
    }

    public static int a(int i, int i2, int i3) {
        return java.lang.Math.min(java.lang.Math.max(i, i2), i3);
    }

    public static int a(int i, int i2, int i3, int i4) {
        return ((i < i2 || i > i3) && i4 >= i2 && i4 <= i3) ? i4 : java.lang.Math.min(java.lang.Math.max(i, i2), i3);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static java.lang.String a(int i) throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/proc/" + i + "/cmdline"));
            try {
                try {
                    java.lang.String line = bufferedReader.readLine();
                    if (!android.text.TextUtils.isEmpty(line)) {
                        line = line.trim();
                    }
                    try {
                        bufferedReader.close();
                    } catch (java.io.IOException unused) {
                    }
                    return line;
                } catch (java.lang.Exception e) {
                    e = e;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    return null;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
    }

    public static java.lang.String a(long j, java.lang.String str) {
        try {
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(str);
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTimeInMillis(j);
            return simpleDateFormat.format(calendar.getTime());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static java.lang.String a(android.content.Context context, int i) {
        android.app.ActivityManager activityManager;
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        java.lang.Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            try {
                activityManager = (android.app.ActivityManager) systemService;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                activityManager = null;
            }
        } else {
            activityManager = null;
        }
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || runningAppProcesses.size() <= 0) {
            return null;
        }
        int size = runningAppProcesses.size();
        for (int i2 = 0; i2 < size; i2++) {
            android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i2);
            if (runningAppProcessInfo != null && runningAppProcessInfo.pid == i) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            java.net.URL url = new java.net.URL(str);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(url.getProtocol());
            sb.append("://");
            sb.append(str2);
            if (url.getPort() != -1) {
                sb.append(":" + url.getPort());
            }
            sb.append(url.getPath());
            if (!android.text.TextUtils.isEmpty(url.getQuery())) {
                sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START + url.getQuery());
            }
            if (!android.text.TextUtils.isEmpty(url.getRef())) {
                sb.append("#" + url.getRef());
            }
            return sb.toString();
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static java.lang.String a(java.lang.String str, boolean z) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        if (z) {
            try {
                if (str.length() > 30) {
                    str = str.substring(0, 30);
                }
            } catch (java.lang.Throwable unused) {
                return "";
            }
        }
        return java.net.URLEncoder.encode(str, "UTF-8");
    }

    private static java.lang.String a(java.net.InetAddress inetAddress) {
        try {
            byte[] address = inetAddress.getAddress();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (int i = 0; i < address.length; i++) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(".");
                sb2.append(address[i] < 0 ? address[i] + 256 : address[i]);
                sb.append(sb2.toString());
            }
            return sb.substring(1);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static boolean a(java.lang.String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a(byte[] bArr) {
        return bArr == null || bArr.length <= 0;
    }

    public static java.lang.String b() {
        android.telephony.TelephonyManager telephonyManager;
        try {
            java.lang.String str = f596a;
            if ((str == null || str.trim().length() == 0) && (telephonyManager = (android.telephony.TelephonyManager) com.tencent.hlyyb.common.a.a().getSystemService("phone")) != null) {
                java.lang.String deviceId = telephonyManager.getDeviceId();
                if (deviceId == null) {
                    deviceId = "NOIMEI";
                }
                f596a = deviceId;
            }
        } catch (java.lang.Throwable unused) {
        }
        return f596a;
    }

    public static java.lang.String b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return java.net.URLEncoder.encode(str, "UTF-8");
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String c() {
        android.telephony.TelephonyManager telephonyManager;
        try {
            java.lang.String str = b;
            if ((str == null || str.trim().length() == 0) && (telephonyManager = (android.telephony.TelephonyManager) com.tencent.hlyyb.common.a.a().getSystemService("phone")) != null) {
                java.lang.String subscriberId = telephonyManager.getSubscriberId();
                if (subscriberId == null) {
                    subscriberId = "NOIMSI";
                }
                b = subscriberId;
            }
        } catch (java.lang.Throwable unused) {
        }
        return b;
    }

    public static java.lang.String c(java.lang.String str) {
        try {
            return a(java.net.InetAddress.getByName(str));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static java.lang.String d() {
        android.net.wifi.WifiManager wifiManager;
        android.net.wifi.WifiInfo connectionInfo;
        try {
            java.lang.String str = c;
            if ((str == null || str.trim().length() == 0) && (wifiManager = (android.net.wifi.WifiManager) com.tencent.hlyyb.common.a.a().getSystemService("wifi")) != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                java.lang.String macAddress = connectionInfo.getMacAddress();
                if (macAddress == null) {
                    macAddress = "NOMAC";
                }
                c = macAddress;
            }
        } catch (java.lang.Throwable unused) {
        }
        return c;
    }

    public static boolean d(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.lang.String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length != 4) {
            return false;
        }
        for (java.lang.String str2 : strArrSplit) {
            try {
                int i = java.lang.Integer.parseInt(str2);
                if (i < 0 || i > 255) {
                    return false;
                }
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        return true;
    }

    public static java.lang.String e() {
        android.content.Context contextA = com.tencent.hlyyb.common.a.a();
        if (contextA == null) {
            return null;
        }
        return contextA.getPackageName();
    }

    public static java.lang.String f() {
        return com.tencent.hlyyb.common.f.a.a("" + b() + d() + java.lang.System.currentTimeMillis() + c() + ((int) (java.lang.Math.random() * 2.147483647E9d)));
    }

    public static java.lang.String g() {
        try {
            java.lang.String str = d;
            if (str == null || str.trim().length() == 0) {
                d = android.provider.Settings.Secure.getString(com.tencent.hlyyb.common.a.a().getContentResolver(), com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
            }
            return d;
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String h() {
        try {
            return "35" + (android.os.Build.BOARD.length() % 10) + (android.os.Build.BRAND.length() % 10) + (android.os.Build.CPU_ABI.length() % 10) + (android.os.Build.DEVICE.length() % 10) + (android.os.Build.DISPLAY.length() % 10) + (android.os.Build.HOST.length() % 10) + (android.os.Build.ID.length() % 10) + (android.os.Build.MANUFACTURER.length() % 10) + (android.os.Build.MODEL.length() % 10) + (android.os.Build.PRODUCT.length() % 10) + (android.os.Build.TAGS.length() % 10) + (android.os.Build.TYPE.length() % 10) + (android.os.Build.USER.length() % 10);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }
}
