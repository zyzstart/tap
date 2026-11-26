package com.tencent.ydkbeacon.a.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f implements com.tencent.ydkbeacon.base.net.c.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.ydkbeacon.a.c.f f1190a = new com.tencent.ydkbeacon.a.c.f();
    private final android.content.Context b;
    private java.lang.String c = "";
    private java.lang.String d = "";
    private java.lang.String e = "";
    private java.lang.String f = "";
    private java.lang.String g = "";
    private java.lang.String h = "";
    private java.lang.String i = "";
    private java.lang.String j = "";
    private java.lang.String k = "";
    private java.lang.String l = "";
    private java.lang.String m = "";

    private f() {
        android.content.Context contextC = com.tencent.ydkbeacon.a.c.c.d().c();
        this.b = contextC;
        com.tencent.ydkbeacon.base.net.c.e.a(contextC, this);
        P();
        O();
    }

    private void O() {
        try {
            com.tencent.ydkqmsp.sdk.u.U.init_o(this.b, com.tencent.ydkbeacon.a.e.b.a(com.tencent.ydkbeacon.d.a.a().a("storageOAID"), true), com.tencent.ydkbeacon.a.e.c.a());
            com.tencent.ydkqmsp.sdk.u.U.getOAID(new com.tencent.ydkbeacon.a.c.d(this));
            this.m = com.tencent.ydkqmsp.sdk.u.U.getOAIDSync(this.b);
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.e.c.a(th);
        }
    }

    private void P() {
        this.l = Q();
    }

    private java.lang.String Q() {
        android.net.NetworkInfo activeNetworkInfo;
        android.telephony.TelephonyManager telephonyManager;
        java.lang.String string = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) this.b.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.getType() != 1) {
                    if (activeNetworkInfo.getType() == 0 && (telephonyManager = (android.telephony.TelephonyManager) this.b.getSystemService("phone")) != null) {
                        switch (telephonyManager.getNetworkType()) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                string = "2G";
                                break;
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                string = "3G";
                                break;
                            case 13:
                                string = "4G";
                                break;
                            default:
                                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                sb.append("unknown_");
                                sb.append(telephonyManager.getNetworkType());
                                string = sb.toString();
                                break;
                        }
                    }
                } else {
                    string = "wifi";
                }
            } else {
                return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
        } catch (java.lang.Exception e) {
            com.tencent.ydkbeacon.a.e.c.a(e);
        }
        com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] NetWork Type:" + string, new java.lang.Object[0]);
        return string;
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

    public static synchronized com.tencent.ydkbeacon.a.c.f p() {
        return f1190a;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0098 A[Catch: all -> 0x0094, TRY_LEAVE, TryCatch #2 {all -> 0x0094, blocks: (B:37:0x0090, B:41:0x0098), top: B:48:0x0090 }] */
    public java.lang.String A() {
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
                                com.tencent.ydkbeacon.a.e.c.b("[model] IO close error!", new java.lang.Object[0]);
                                com.tencent.ydkbeacon.a.e.c.a(th2);
                            }
                            return string;
                        }
                        bufferedReader.close();
                        fileReader.close();
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        try {
                            com.tencent.ydkbeacon.a.e.c.b("[model] get free RAM error!", new java.lang.Object[0]);
                            com.tencent.ydkbeacon.a.e.c.a(th);
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
                                    com.tencent.ydkbeacon.a.e.c.b("[model] IO close error!", new java.lang.Object[0]);
                                    com.tencent.ydkbeacon.a.e.c.a(th5);
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
                com.tencent.ydkbeacon.a.e.c.b("[model] IO close error!", new java.lang.Object[0]);
                com.tencent.ydkbeacon.a.e.c.a(th7);
            }
        } catch (java.lang.Throwable th8) {
            th = th8;
            bufferedReader = null;
            fileReader = null;
        }
        return null;
    }

    public java.lang.String B() {
        android.util.DisplayMetrics displayMetricsJ = j();
        if (displayMetricsJ == null) {
            return "";
        }
        return displayMetricsJ.widthPixels + "*" + displayMetricsJ.heightPixels;
    }

    public java.lang.String C() {
        java.util.ArrayList arrayListA = com.tencent.ydkbeacon.a.e.b.a(new java.lang.String[]{"/system/bin/sh", "-c", "getprop ro.build.fingerprint"});
        return (arrayListA == null || arrayListA.size() <= 0) ? "" : (java.lang.String) arrayListA.get(0);
    }

    public java.lang.String D() {
        if (!android.text.TextUtils.isEmpty(this.k)) {
            return this.k;
        }
        android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
        long blockSize = statFs.getBlockSize();
        this.k = (((statFs.getBlockCount() * blockSize) / 1024) / 1024) + "";
        com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] Rom Size:" + this.k, new java.lang.Object[0]);
        return this.k;
    }

    public long E() {
        if (!c()) {
            return 0L;
        }
        try {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
            return ((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1024) / 1024;
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.e.c.a(th);
            return 0L;
        }
    }

    public int F() {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        android.view.WindowManager windowManager = (android.view.WindowManager) this.b.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            double d = displayMetrics.density;
            java.lang.Double.isNaN(d);
            if (d - 0.75d <= 1.0E-6d) {
                return 120;
            }
            java.lang.Double.isNaN(d);
            if (d - 1.5d <= 1.0E-6d) {
                return com.tencent.smtt.sdk.TbsListener.ErrorCode.TPATCH_VERSION_FAILED;
            }
            java.lang.Double.isNaN(d);
            if (d - 2.0d <= 1.0E-6d) {
                return cn.yunzhisheng.asr.JniUscClient.au;
            }
            java.lang.Double.isNaN(d);
            if (d - 3.0d <= 1.0E-6d) {
                return 480;
            }
        }
        return 160;
    }

    public java.lang.String G() {
        int i;
        java.lang.reflect.Method method;
        java.lang.String str;
        char c = 0;
        com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] getSensor start", new java.lang.Object[0]);
        java.lang.String str2 = "X";
        java.lang.String str3 = "X";
        java.lang.String str4 = "X";
        java.lang.String str5 = "X";
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (java.lang.Integer.parseInt(android.os.Build.VERSION.SDK) >= 10) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("android.hardware.Camera");
                int iIntValue = ((java.lang.Integer) cls.getMethod("getNumberOfCameras", new java.lang.Class[0]).invoke(cls, new java.lang.Object[0])).intValue();
                if (iIntValue == 0) {
                    str3 = "N";
                    str2 = "N";
                } else {
                    java.lang.Class<?> cls2 = java.lang.Class.forName("android.hardware.Camera$CameraInfo");
                    java.lang.Object objNewInstance = cls2.newInstance();
                    java.lang.reflect.Method[] methods = cls.getMethods();
                    int length = methods.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            method = null;
                            break;
                        }
                        try {
                            method = methods[i2];
                            if (method.getName().equals("getCameraInfo")) {
                                break;
                            }
                            i2++;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            i = 0;
                            com.tencent.ydkbeacon.a.e.c.b("[model] getSensor error!", new java.lang.Object[i]);
                            com.tencent.ydkbeacon.a.e.c.a(th);
                            sb.append(str2);
                            sb.append(str3);
                            sb.append(str4);
                            sb.append(str5);
                            return sb.toString();
                        }
                    }
                    java.lang.reflect.Field field = cls2.getField("facing");
                    java.lang.reflect.Field field2 = cls2.getField("CAMERA_FACING_BACK");
                    java.lang.reflect.Field field3 = cls2.getField("CAMERA_FACING_FRONT");
                    if (method != null) {
                        java.lang.String str6 = "X";
                        java.lang.String str7 = "X";
                        int i3 = 0;
                        while (i3 < iIntValue) {
                            try {
                                java.lang.Object[] objArr = new java.lang.Object[2];
                                objArr[c] = java.lang.Integer.valueOf(i3);
                                objArr[1] = objNewInstance;
                                method.invoke(cls, objArr);
                                int i4 = field.getInt(objNewInstance);
                                int i5 = field2.getInt(objNewInstance);
                                int i6 = field3.getInt(objNewInstance);
                                if (i4 == i5) {
                                    str = "Y";
                                    if (iIntValue == 1) {
                                        str6 = "N";
                                    }
                                } else {
                                    if (i4 == i6) {
                                        str6 = "Y";
                                        if (iIntValue == 1) {
                                            str = "N";
                                        }
                                    }
                                    i3++;
                                    c = 0;
                                }
                                str7 = str;
                                i3++;
                                c = 0;
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                i = 0;
                                str2 = str7;
                                str3 = str6;
                                com.tencent.ydkbeacon.a.e.c.b("[model] getSensor error!", new java.lang.Object[i]);
                                com.tencent.ydkbeacon.a.e.c.a(th);
                                sb.append(str2);
                                sb.append(str3);
                                sb.append(str4);
                                sb.append(str5);
                                return sb.toString();
                            }
                        }
                        str2 = str7;
                        str3 = str6;
                    }
                }
                try {
                    android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) this.b.getSystemService("sensor");
                    if (sensorManager != null) {
                        str4 = sensorManager.getDefaultSensor(9) != null ? "Y" : "N";
                        str5 = sensorManager.getDefaultSensor(4) != null ? "Y" : "N";
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    i = 0;
                    com.tencent.ydkbeacon.a.e.c.b("[model] getSensor error!", new java.lang.Object[i]);
                    com.tencent.ydkbeacon.a.e.c.a(th);
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
            }
        }
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb.toString();
    }

    public java.lang.String H() {
        com.tencent.ydkbeacon.a.e.c.a("[model] getSensor2 start", new java.lang.Object[0]);
        java.lang.String str = "X";
        java.lang.String str2 = "X";
        java.lang.String str3 = "X";
        java.lang.String str4 = "X";
        java.lang.String str5 = M() ? "Y" : "N";
        if (java.lang.Integer.parseInt(android.os.Build.VERSION.SDK) >= 10) {
            try {
                android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) this.b.getSystemService("sensor");
                str = sensorManager.getDefaultSensor(1) != null ? "Y" : "N";
                str2 = sensorManager.getDefaultSensor(5) != null ? "Y" : "N";
                str3 = android.bluetooth.BluetoothAdapter.getDefaultAdapter() == null ? "N" : "Y";
                str4 = this.b.getPackageManager().hasSystemFeature("android.hardware.nfc") ? "Y" : "N";
            } catch (java.lang.Throwable unused) {
                com.tencent.ydkbeacon.a.e.c.b("[model] getSensor2 error!", new java.lang.Object[0]);
            }
        }
        return str5 + str + str2 + str3 + str4;
    }

    public java.lang.String I() {
        java.lang.String bssid = "";
        android.content.Context context = this.b;
        if (context == null) {
            com.tencent.ydkbeacon.a.e.c.b("[core] getWifiSSID but context == null!", new java.lang.Object[0]);
            return "";
        }
        try {
            android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo.getBSSID() != null) {
                bssid = connectionInfo.getBSSID();
            }
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.e.c.a(th);
            com.tencent.ydkbeacon.a.e.c.b("getWifiSSID error!", new java.lang.Object[0]);
        }
        com.tencent.ydkbeacon.a.e.c.a("[core] Wifi SSID:" + bssid, new java.lang.Object[0]);
        return bssid;
    }

    public java.lang.String J() {
        android.net.wifi.WifiInfo connectionInfo;
        if (!com.tencent.ydkbeacon.d.b.a().h()) {
            com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] current collect mac be refused! isCollectMAC: %s", java.lang.Boolean.FALSE);
        } else {
            if (!android.text.TextUtils.isEmpty(this.i)) {
                return this.i;
            }
            android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) this.b.getSystemService("wifi");
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                this.i = connectionInfo.getBSSID();
            }
            com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] Wifi BSSID:" + this.i, new java.lang.Object[0]);
        }
        return this.i;
    }

    public java.lang.String K() {
        android.net.wifi.WifiInfo connectionInfo;
        if (!com.tencent.ydkbeacon.d.b.a().h()) {
            com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] current collect mac be refused! isCollectMAC: %s", java.lang.Boolean.FALSE);
        } else {
            if (!android.text.TextUtils.isEmpty(this.j)) {
                return this.j;
            }
            android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) this.b.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null && connectionInfo.getBSSID() != null) {
                this.j = connectionInfo.getSSID();
            }
            com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] Wifi SSID:" + this.j, new java.lang.Object[0]);
        }
        return this.j;
    }

    public java.lang.String L() {
        java.util.List<java.lang.String> allProviders;
        android.location.LocationManager locationManager = (android.location.LocationManager) this.b.getSystemService("location");
        return (locationManager == null || (allProviders = locationManager.getAllProviders()) == null || !allProviders.contains("gps")) ? "N" : "Y";
    }

    public boolean M() {
        return ((android.net.wifi.WifiManager) this.b.getSystemService("wifi")) != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean N() {
        java.io.BufferedReader bufferedReader;
        java.lang.String line;
        boolean z;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec(new java.lang.String[]{"/system/bin/cat", "/proc/cpuinfo"}).getInputStream(), java.nio.charset.Charset.defaultCharset()));
            do {
                try {
                    line = bufferedReader.readLine();
                    if (line == null) {
                        z = false;
                    }
                    com.tencent.ydkbeacon.a.e.b.a(bufferedReader);
                    return z;
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        com.tencent.ydkbeacon.a.e.c.a(th);
                        com.tencent.ydkbeacon.a.e.b.a(bufferedReader);
                        return false;
                    } catch (java.lang.Throwable th2) {
                        com.tencent.ydkbeacon.a.e.b.a(bufferedReader);
                        throw th2;
                    }
                }
            } while (-1 == line.toLowerCase().indexOf("armv7"));
            z = true;
            com.tencent.ydkbeacon.a.e.b.a(bufferedReader);
            return z;
        } catch (java.lang.Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }

    public java.lang.String a(android.content.Context context) {
        try {
            if (java.lang.Integer.parseInt(android.os.Build.VERSION.SDK) < 9) {
                com.tencent.ydkbeacon.a.e.c.b("[audit] Api level < 9;return null!", new java.lang.Object[0]);
                return "";
            }
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("[audit] get app_last_updated_time:");
            sb.append(java.lang.String.valueOf(packageInfo.lastUpdateTime));
            com.tencent.ydkbeacon.a.e.c.a(sb.toString(), new java.lang.Object[0]);
            return java.lang.String.valueOf(packageInfo.lastUpdateTime);
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.e.c.a(th);
            com.tencent.ydkbeacon.a.e.c.b("[audit] get app_last_updated_time failed!", new java.lang.Object[0]);
            return "";
        }
    }

    @Override // com.tencent.ydkbeacon.base.net.c.e.a
    public void a() {
        P();
    }

    @Override // com.tencent.ydkbeacon.base.net.c.e.a
    public void b() {
        P();
    }

    public boolean c() {
        return android.os.Environment.getExternalStorageState().equals("mounted");
    }

    public java.lang.String d() {
        if (!com.tencent.ydkbeacon.d.b.a().h()) {
            com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] current collect allMacAddress be refused! isCollectMAC: %s", java.lang.Boolean.FALSE);
        } else {
            if (!android.text.TextUtils.isEmpty(this.h)) {
                return this.h;
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
                    this.h = sb.toString();
                }
            } catch (java.lang.Throwable th) {
                com.tencent.ydkbeacon.a.e.c.a(th);
            }
            com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] Mac Address:" + this.h, new java.lang.Object[0]);
        }
        return this.h;
    }

    public java.lang.String e() {
        if (!android.text.TextUtils.isEmpty(this.c)) {
            return this.c;
        }
        if (com.tencent.ydkbeacon.d.b.a().d()) {
            java.lang.String string = android.provider.Settings.Secure.getString(this.b.getContentResolver(), com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
            this.c = string;
            this.c = string != null ? string.toLowerCase() : "";
            com.tencent.ydkbeacon.a.e.c.d("[DeviceInfo] Android ID:" + this.c, new java.lang.Object[0]);
        } else {
            com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] current collect androidId be refused! isAndroidId: %s", java.lang.Boolean.FALSE);
        }
        return this.c;
    }

    public int f() {
        java.io.BufferedReader bufferedReader;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec(new java.lang.String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).getInputStream(), java.nio.charset.Charset.forName("UTF-8")));
            try {
                java.lang.String line = bufferedReader.readLine();
                int i = line != null ? java.lang.Integer.parseInt(line.trim()) / 1000 : 0;
                com.tencent.ydkbeacon.a.e.b.a(bufferedReader);
                return i;
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    com.tencent.ydkbeacon.a.e.c.a(th);
                    com.tencent.ydkbeacon.a.e.b.a(bufferedReader);
                    return 0;
                } catch (java.lang.Throwable th2) {
                    com.tencent.ydkbeacon.a.e.b.a(bufferedReader);
                    throw th2;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public java.lang.String g() {
        java.io.BufferedReader bufferedReader;
        java.io.Closeable[] closeableArr;
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
                        com.tencent.ydkbeacon.a.e.c.a(th);
                        closeableArr = new java.io.Closeable[]{bufferedReader};
                    } catch (java.lang.Throwable th2) {
                        com.tencent.ydkbeacon.a.e.b.a(bufferedReader);
                        throw th2;
                    }
                }
            }
            closeableArr = new java.io.Closeable[]{bufferedReader};
        } catch (java.lang.Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        com.tencent.ydkbeacon.a.e.b.a(closeableArr);
        return strTrim;
    }

    public java.lang.String h() {
        return java.util.Locale.getDefault().getCountry();
    }

    public java.lang.String i() {
        return android.os.Build.HARDWARE;
    }

    public android.util.DisplayMetrics j() {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        android.view.WindowManager windowManager = (android.view.WindowManager) this.b.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public long k() {
        android.app.ActivityManager activityManager = (android.app.ActivityManager) this.b.getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
        if (activityManager == null) {
            return -1L;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public java.lang.String l() {
        long jK = k();
        if (jK <= 0) {
            return "0";
        }
        return ((jK / 1024) / 1024) + "";
    }

    public java.lang.String m() {
        android.telephony.TelephonyManager telephonyManager;
        if (!com.tencent.ydkbeacon.d.b.a().f()) {
            com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] current collect imei be refused! isCollect Imei: %s", java.lang.Boolean.FALSE);
        } else if (this.b == null) {
            com.tencent.ydkbeacon.a.e.c.b("[DeviceInfo] getImei but context is null!", new java.lang.Object[0]);
        } else {
            if (!android.text.TextUtils.isEmpty(this.e)) {
                return this.e;
            }
            if (com.tencent.ydkbeacon.a.c.b.f(this.b) && (telephonyManager = (android.telephony.TelephonyManager) this.b.getSystemService("phone")) != null) {
                try {
                    java.lang.String deviceId = telephonyManager.getDeviceId();
                    this.e = deviceId;
                    this.e = deviceId != null ? deviceId.toLowerCase() : "";
                } catch (java.lang.Throwable th) {
                    com.tencent.ydkbeacon.a.e.c.d("[DeviceInfo] getDeviceId error!", new java.lang.Object[0]);
                    com.tencent.ydkbeacon.a.e.c.a(th);
                }
            }
            com.tencent.ydkbeacon.a.e.c.d("[DeviceInfo] IMEI:" + this.e, new java.lang.Object[0]);
        }
        return this.e;
    }

    public java.lang.String n() {
        if (!com.tencent.ydkbeacon.d.b.a().f()) {
            com.tencent.ydkbeacon.a.e.c.a("[core] current collect imei2 be refused! isCollectImei2: %s", java.lang.Boolean.FALSE);
            return "";
        }
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return m();
        }
        try {
            return com.tencent.ydkbeacon.a.c.b.f(this.b) ? ((android.telephony.TelephonyManager) this.b.getSystemService("phone")).getImei(1) : "";
        } catch (java.lang.Throwable unused) {
            com.tencent.ydkbeacon.a.e.c.b("[core] getImei error!", new java.lang.Object[0]);
            return "";
        }
    }

    public java.lang.String o() {
        android.telephony.TelephonyManager telephonyManager;
        if (!com.tencent.ydkbeacon.d.b.a().f()) {
            com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] current collect imei be refused! isCollectImei: %s", java.lang.Boolean.FALSE);
        } else if (this.b == null) {
            com.tencent.ydkbeacon.a.e.c.b("[DeviceInfo] getImsi but context == null!", new java.lang.Object[0]);
        } else {
            if (!android.text.TextUtils.isEmpty(this.f)) {
                return this.f;
            }
            if (com.tencent.ydkbeacon.a.c.b.f(this.b) && (telephonyManager = (android.telephony.TelephonyManager) this.b.getSystemService("phone")) != null) {
                try {
                    java.lang.String subscriberId = telephonyManager.getSubscriberId();
                    this.f = subscriberId;
                    this.f = subscriberId != null ? subscriberId.toLowerCase() : "";
                } catch (java.lang.Throwable th) {
                    com.tencent.ydkbeacon.a.e.c.d("[DeviceInfo] getSubscriberId error!", new java.lang.Object[0]);
                    com.tencent.ydkbeacon.a.e.c.a(th);
                }
            }
            com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] imsi:" + this.f, new java.lang.Object[0]);
        }
        return this.f;
    }

    public boolean q() {
        return com.tencent.ydkbeacon.a.e.d.d();
    }

    public java.lang.String r() {
        return java.util.Locale.getDefault().getLanguage();
    }

    public java.lang.String s() {
        java.util.Enumeration<java.net.NetworkInterface> networkInterfaces;
        java.lang.String string;
        if (!com.tencent.ydkbeacon.d.b.a().h()) {
            com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] current collect mac be refused! isCollectMAC: %s", java.lang.Boolean.FALSE);
        } else {
            if (!android.text.TextUtils.isEmpty(this.g)) {
                return this.g;
            }
            try {
                if (java.lang.Integer.valueOf(android.os.Build.VERSION.SDK).intValue() < 23) {
                    android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) this.b.getSystemService("wifi");
                    if (wifiManager != null) {
                        android.net.wifi.WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                        if (this.g != null && connectionInfo != null) {
                            java.lang.String macAddress = connectionInfo.getMacAddress();
                            this.g = macAddress;
                            string = macAddress.toLowerCase();
                            this.g = string;
                            break;
                        }
                    }
                } else {
                    java.lang.String[] strArr = new java.lang.String[2];
                    strArr[0] = "/sys/class/net/wlan0/address";
                    strArr[1] = "/sys/devices/virtual/net/wlan0/address";
                    for (int i = 0; i < 2; i++) {
                        java.lang.String strTrim = com.tencent.ydkbeacon.a.e.b.e(strArr[i]).trim();
                        this.g = strTrim;
                        if (strTrim.length() > 0) {
                            this.g = this.g.toLowerCase();
                            break;
                        }
                    }
                    if ("".equals(this.g) && (networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces()) != null) {
                        while (networkInterfaces.hasMoreElements()) {
                            java.net.NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                            byte[] hardwareAddress = networkInterfaceNextElement.getHardwareAddress();
                            if ("wlan0".equals(networkInterfaceNextElement.getName()) && hardwareAddress != null && hardwareAddress.length != 0) {
                                string = a(hardwareAddress).toString();
                                this.g = string;
                                break;
                            }
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                com.tencent.ydkbeacon.a.e.c.a(th);
            }
            com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] Mac Address:" + this.g, new java.lang.Object[0]);
        }
        return this.g;
    }

    public java.lang.String t() {
        return android.os.Build.MANUFACTURER;
    }

    public java.lang.String u() {
        java.lang.String meid;
        if (!com.tencent.ydkbeacon.d.b.a().f()) {
            com.tencent.ydkbeacon.a.e.c.a("[core] current collect meid be refused! isCollectMeid: %s", java.lang.Boolean.FALSE);
            return "";
        }
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return m();
        }
        try {
            return (!com.tencent.ydkbeacon.a.c.b.f(this.b) || (meid = ((android.telephony.TelephonyManager) this.b.getSystemService("phone")).getMeid()) == null) ? "" : meid.toLowerCase();
        } catch (java.lang.Throwable unused) {
            com.tencent.ydkbeacon.a.e.c.b("[core] getImei error!", new java.lang.Object[0]);
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public java.lang.String v() throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.io.Closeable[] closeableArr;
        java.io.BufferedReader bufferedReader2;
        java.io.Closeable[] closeableArr2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        ?? r1 = 0;
        java.io.BufferedReader bufferedReader3 = null;
        ?? r2 = 0;
        java.io.BufferedReader bufferedReader4 = null;
        int i = 1;
        i = 1;
        try {
            try {
                bufferedReader = new java.io.BufferedReader(new java.io.FileReader(new java.io.File("/sys/block/mmcblk0/device/type")));
                try {
                    sb.append(bufferedReader.readLine());
                    closeableArr = new java.io.Closeable[]{bufferedReader};
                } catch (java.lang.Exception unused) {
                    com.tencent.ydkbeacon.a.e.c.b("getNandInfo error", new java.lang.Object[0]);
                    closeableArr = new java.io.Closeable[]{bufferedReader};
                }
            } catch (java.lang.Throwable th) {
                th = th;
                r1 = "/sys/block/mmcblk0/device/name";
                com.tencent.ydkbeacon.a.e.b.a((java.io.Closeable[]) new java.io.Closeable[]{r1});
                throw th;
            }
        } catch (java.lang.Exception unused2) {
            bufferedReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            com.tencent.ydkbeacon.a.e.b.a((java.io.Closeable[]) new java.io.Closeable[]{r1});
            throw th;
        }
        com.tencent.ydkbeacon.a.e.b.a(closeableArr);
        sb.append(",");
        try {
            bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader(new java.io.File("/sys/block/mmcblk0/device/name")));
            try {
                try {
                    sb.append(bufferedReader2.readLine());
                    closeableArr2 = new java.io.Closeable[]{bufferedReader2};
                } catch (java.lang.Exception unused3) {
                    com.tencent.ydkbeacon.a.e.c.b("getNandInfo error", new java.lang.Object[0]);
                    closeableArr2 = new java.io.Closeable[]{bufferedReader2};
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                bufferedReader4 = bufferedReader2;
                com.tencent.ydkbeacon.a.e.b.a(bufferedReader4);
                throw th;
            }
        } catch (java.lang.Exception unused4) {
            bufferedReader2 = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            com.tencent.ydkbeacon.a.e.b.a(bufferedReader4);
            throw th;
        }
        com.tencent.ydkbeacon.a.e.b.a(closeableArr2);
        sb.append(",");
        try {
            try {
                java.io.BufferedReader bufferedReader5 = new java.io.BufferedReader(new java.io.FileReader(new java.io.File("/sys/block/mmcblk0/device/cid")));
                try {
                    sb.append(bufferedReader5.readLine());
                    com.tencent.ydkbeacon.a.e.b.a(bufferedReader5);
                } catch (java.lang.Exception unused5) {
                    bufferedReader3 = bufferedReader5;
                    com.tencent.ydkbeacon.a.e.c.b("getNandInfo error", new java.lang.Object[0]);
                    com.tencent.ydkbeacon.a.e.b.a((java.io.Closeable[]) new java.io.Closeable[]{bufferedReader3});
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    r2 = bufferedReader5;
                    ?? r3 = new java.io.Closeable[i];
                    r3[0] = r2;
                    com.tencent.ydkbeacon.a.e.b.a((java.io.Closeable[]) r3);
                    throw th;
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
            }
        } catch (java.lang.Exception unused6) {
        }
        java.lang.String string = sb.toString();
        r2 = "[DeviceInfo] Nand Info:" + string;
        i = new java.lang.Object[0];
        com.tencent.ydkbeacon.a.e.c.a((java.lang.String) r2, (java.lang.Object[]) i);
        return string;
    }

    public java.lang.String w() {
        return this.l;
    }

    public int x() {
        try {
            java.io.File[] fileArrListFiles = new java.io.File("/sys/devices/system/cpu/").listFiles(new com.tencent.ydkbeacon.a.c.e(this));
            if (fileArrListFiles == null) {
                return 1;
            }
            return fileArrListFiles.length;
        } catch (java.lang.Exception e) {
            com.tencent.ydkbeacon.a.e.c.b("[model] CPU Count: Failed.", new java.lang.Object[0]);
            com.tencent.ydkbeacon.a.e.c.a(e);
            return 1;
        }
    }

    public java.lang.String y() {
        return this.m;
    }

    public java.lang.String z() {
        if (!android.text.TextUtils.isEmpty(this.d)) {
            return this.d;
        }
        java.lang.String str = "Android " + android.os.Build.VERSION.RELEASE + ",level " + android.os.Build.VERSION.SDK;
        this.d = str;
        com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] os version: %s", str);
        return this.d;
    }
}
