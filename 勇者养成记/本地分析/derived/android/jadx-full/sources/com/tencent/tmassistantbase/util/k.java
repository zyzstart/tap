package com.tencent.tmassistantbase.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final java.lang.String f1054a = "k";
    protected static com.tencent.tmassistantbase.util.k b;
    protected static int e;
    public static java.lang.String m;
    protected android.content.Context c;
    public java.util.HashMap l;
    private com.tencent.tmassistantbase.jce.TerminalExtra s;
    public java.lang.String d = "";
    public final int f = 0;
    public final int g = 1;
    public final int h = 2;
    public final int i = 3;
    public final int j = 4;
    public final int k = 5;
    public final int n = 6;
    public final int o = 7;
    public final int p = 8;
    public final int q = 9;
    public final int r = 10;

    protected k() {
        this.l = null;
        java.util.HashMap map = new java.util.HashMap();
        this.l = map;
        map.put(1, "ReportLog");
        this.l.put(2, "GetSettings");
        this.l.put(3, "GetAppUpdate");
        this.l.put(4, "GetAuthorized");
        this.l.put(5, "GetAppSimpleDetail");
        this.l.put(7, "GetCallerSetting");
        this.l.put(7, "GetConfig");
        this.l.put(8, "GetPush");
        this.l.put(9, "StatReport");
        this.l.put(10, "GetHalleyUrl");
    }

    public static int a(int i) {
        if (i == 6) {
            return 1;
        }
        if (i == 9) {
            return 6;
        }
        switch (i) {
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 5;
            case 4:
                return 4;
            default:
                return 0;
        }
    }

    public static synchronized com.tencent.tmassistantbase.util.k a() {
        if (b == null) {
            b = new com.tencent.tmassistantbase.util.k();
        }
        return b;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int b(int i) {
        if (i != -1000) {
            if (i == -16) {
                return com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY;
            }
            if (i == -15) {
                return 1;
            }
            if (i == -1) {
                return com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_REDIRECT_TOO_MANY_TIMES;
            }
            if (i == 0) {
                return 0;
            }
            switch (i) {
                case com.pay.tool.APPluginConstants.ERROR_IO_FileNotFoundException /* -28 */:
                    return 701;
                case com.pay.tool.APPluginConstants.ERROR_IO_FileLockInterruptionException /* -27 */:
                    return com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_IO_EXCEPTION;
                case com.pay.tool.APPluginConstants.ERROR_IO_EOFException /* -26 */:
                case com.pay.tool.APPluginConstants.ERROR_IO_ClosedChannelException /* -24 */:
                    break;
                case com.pay.tool.APPluginConstants.ERROR_IO_ConnectionClosedException /* -25 */:
                    return com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SOCKET_TIMEOUT;
                case com.pay.tool.APPluginConstants.ERROR_IO_ClientProtocolException_HttpResponseException /* -23 */:
                    return com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_CONNECT_TIMEOUT;
                case -22:
                    return com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION;
                case -21:
                    return 700;
                default:
                    switch (i) {
                        case -13:
                            return 703;
                        case -12:
                            return com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH;
                        case -11:
                            return com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_HOOK;
                    }
            }
        }
        return com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_UNKNOWN_EXCEPTION;
    }

    public static java.lang.String b(android.content.Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public static java.lang.String b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes();
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bytes, 0, bytes.length);
            byte[] bArrDigest = messageDigest.digest();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            for (byte b2 : bArrDigest) {
                stringBuffer.append(java.lang.Integer.toHexString(b2 & 255));
            }
            return stringBuffer.toString();
        } catch (java.security.NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int c(android.content.Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    public static java.util.ArrayList c(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!android.text.TextUtils.isEmpty(str)) {
            for (java.lang.String str2 : str.split(",")) {
                if (!android.text.TextUtils.isEmpty(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    public static void d(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        java.lang.String parent = file.getParent();
        java.lang.String parent2 = new java.io.File(parent).getParent();
        java.lang.String parent3 = new java.io.File(parent2).getParent();
        try {
            java.lang.Runtime.getRuntime().exec("chmod 777 " + file.getAbsolutePath());
            java.lang.Runtime.getRuntime().exec("chmod 777 " + parent);
            java.lang.Runtime.getRuntime().exec("chmod 777 " + parent2);
            java.lang.Runtime.getRuntime().exec("chmod 777" + parent3);
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
        }
    }

    public static java.lang.String e(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? "empty" : str;
    }

    private java.lang.String f(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (android.text.TextUtils.isEmpty(str)) {
            stringBuffer.append("NA");
            return stringBuffer.toString();
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > ' ' && charArray[i] != '/' && charArray[i] != '_' && charArray[i] != '&' && charArray[i] != '|' && charArray[i] != '-') {
                stringBuffer.append(charArray[i]);
            }
        }
        return stringBuffer.toString();
    }

    public static synchronized int l() {
        int i;
        i = e;
        e = i + 1;
        return i;
    }

    public static synchronized java.lang.String p() {
        android.content.Context contextB = a().b();
        if (contextB == null) {
            return "";
        }
        try {
            if (contextB.checkCallingOrSelfPermission(com.unisound.client.SpeechConstants.PERMISSION_ACCESS_NETWORK_STATE) != 0) {
                return "";
            }
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) contextB.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            java.lang.String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo == null) {
                return "";
            }
            java.lang.String lowerCase = extraInfo.toLowerCase();
            com.tencent.tmassistantbase.util.TMLog.v(f1054a, "netInfo  =  " + lowerCase);
            return lowerCase;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static boolean q() {
        android.net.NetworkInfo activeNetworkInfo;
        android.content.Context contextB = a().b();
        if (contextB == null) {
            com.tencent.tmassistantbase.util.TMLog.w(f1054a, "GlobalUtil.getInstance().getContext() == null.");
            return false;
        }
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) contextB.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnectedOrConnecting();
    }

    public void a(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.c = applicationContext;
        m = applicationContext.getPackageName();
        this.d = new com.tencent.tmassistantbase.util.q(this.c).a();
        s();
        com.tencent.tmassistantbase.util.TMLog.initTMLog(context);
        com.tencent.tmassistantbase.util.TMLog.i(f1054a, "QUA:" + this.d);
    }

    public void a(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences;
        if (this.c == null || android.text.TextUtils.isEmpty(str) || (sharedPreferences = this.c.getSharedPreferences("TMAssistantSDKSharedPreference", 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString("TMAssistantSDKPhoneGUID", str).commit();
    }

    public android.content.Context b() {
        return this.c;
    }

    public void c() {
        this.c = null;
        b = null;
    }

    public java.lang.String d() {
        return m;
    }

    public void d(android.content.Context context) throws com.tencent.tmassistantbase.common.PermissionDeniedException {
        if (android.os.Build.VERSION.SDK_INT < 23) {
            com.tencent.tmassistantbase.util.TMLog.i(f1054a, "There is no need to check permission,Build.VERSION.SDK_INT = " + android.os.Build.VERSION.SDK_INT);
            return;
        }
        if (context == null) {
            com.tencent.tmassistantbase.util.TMLog.e(f1054a, "checkPermission context is null");
            return;
        }
        int iIntValue = 0;
        try {
            java.lang.Class<?> cls = context.getClass();
            com.tencent.tmassistantbase.util.TMLog.i(f1054a, "checkPermission context = " + context);
            iIntValue = ((java.lang.Integer) cls.getMethod("checkSelfPermission", java.lang.String.class).invoke(context, "android.permission.WRITE_EXTERNAL_STORAGE")).intValue();
        } catch (java.lang.Exception e2) {
            com.tencent.tmassistantbase.util.TMLog.e(f1054a, "checkPermission Exception", e2);
        }
        com.tencent.tmassistantbase.util.TMLog.i(f1054a, "checkPermission hasWriteExternalStorage = " + iIntValue);
        if (iIntValue != -1) {
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.e(f1054a, "checkPermission Permission WRITE_EXTERNAL_STORAGE is DENIED");
        throw new com.tencent.tmassistantbase.common.PermissionDeniedException("Permission WRITE_EXTERNAL_STORAGE is DENIED!!Please request permission again");
    }

    public java.lang.String e() {
        try {
            if (this.c == null) {
                return null;
            }
            return android.provider.Settings.Secure.getString(b().getContentResolver(), com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public java.lang.String f() {
        android.content.SharedPreferences sharedPreferences;
        android.content.Context context = this.c;
        return (context == null || (sharedPreferences = context.getSharedPreferences("TMAssistantSDKSharedPreference", 0)) == null) ? "" : sharedPreferences.getString("TMAssistantSDKPhoneGUID", "");
    }

    public java.lang.String g() {
        if (this.c == null) {
            return null;
        }
        try {
            java.lang.String[] dualSimIMEIInfoMethod = !com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI ? com.tencent.tmassistantbase.kapalai.KapalaiAdapterUtil.getKAUInstance().getDualSimIMEIInfoMethod(this.c) : com.tencent.tmassistantbase.kapalai.KapalaiAdapterUtil.getKAUInstance().getDualSimIMEIInfoNormalMethod(this.c);
            return (dualSimIMEIInfoMethod == null || dualSimIMEIInfoMethod.length <= 0) ? ((android.telephony.TelephonyManager) b().getSystemService("phone")).getDeviceId() : dualSimIMEIInfoMethod[0];
        } catch (java.lang.Exception e2) {
            com.tencent.tmassistantbase.util.TMLog.e(f1054a, "getImei Exception", e2);
            return null;
        }
    }

    public java.lang.String h() {
        if (this.c == null) {
            return null;
        }
        try {
            java.lang.String[] dualSimIMSIInfoMethod = !com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI ? com.tencent.tmassistantbase.kapalai.KapalaiAdapterUtil.getKAUInstance().getDualSimIMSIInfoMethod(this.c) : com.tencent.tmassistantbase.kapalai.KapalaiAdapterUtil.getKAUInstance().getDualSimIMSIInfoNormalMethod(this.c);
            return (dualSimIMSIInfoMethod == null || dualSimIMSIInfoMethod.length <= 0) ? ((android.telephony.TelephonyManager) b().getSystemService("phone")).getSubscriberId() : dualSimIMSIInfoMethod[0];
        } catch (java.lang.Exception e2) {
            com.tencent.tmassistantbase.util.TMLog.e(f1054a, "getImsi Exception", e2);
            return null;
        }
    }

    public java.lang.String i() {
        return f(android.os.Build.BRAND);
    }

    public java.lang.String j() {
        return f(android.os.Build.MODEL);
    }

    public java.lang.String k() {
        if (this.c == null) {
            return null;
        }
        try {
            android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) b().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getMacAddress() : "";
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public boolean m() {
        return "wifi".equals(p());
    }

    public int n() {
        if (this.c == null) {
            com.tencent.tmassistantbase.util.TMLog.i("SelfUpdateSDK", "context == null");
            return 0;
        }
        com.tencent.tmassistantbase.util.TMLog.i("SelfUpdateSDK", "getQQDownloaderAPILevel");
        try {
            android.content.pm.ApplicationInfo applicationInfo = this.c.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
            com.tencent.tmassistantbase.util.TMLog.i("SelfUpdateSDK", "appInfo:" + applicationInfo);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return 0;
            }
            int i = applicationInfo.metaData.getInt(com.tencent.assistant.sdk.remote.SDKConst.SDK_APILEVEL);
            com.tencent.tmassistantbase.util.TMLog.i("SelfUpdateSDK", "apiLevel:" + i);
            return i;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public int o() {
        android.content.pm.PackageInfo packageInfo;
        android.content.Context context = this.c;
        if (context == null) {
            return 0;
        }
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (packageInfo = packageManager.getPackageInfo("com.tencent.android.qqdownloader", 0)) == null) {
                return 0;
            }
            return packageInfo.versionCode;
        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public com.tencent.tmassistantbase.jce.TerminalExtra r() {
        if (this.s == null) {
            s();
        }
        if (this.s != null) {
            com.tencent.tmassistantbase.util.TMLog.i(f1054a, ">>getTerminalExtra \n terminalExtra.cpuName = " + this.s.cpuName + "\n  terminalExtra.cpuCoresNum = " + this.s.cpuCoresNum + "\n  terminalExtra.cpuMaxFreq = " + this.s.cpuMaxFreq + "\n  terminalExtra.cpuMinFreq = " + this.s.cpuMinFreq + "\n  terminalExtra.ramTotalSize = " + this.s.ramTotalSize + "\n  terminalExtra.abiList = " + this.s.abiList);
        }
        return this.s;
    }

    public void s() {
        if (this.c == null) {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_GlobalUtil", "<genTerminalExtra()> context == null");
            return;
        }
        if (this.s == null) {
            this.s = new com.tencent.tmassistantbase.jce.TerminalExtra();
        }
        android.content.SharedPreferences sharedPreferences = this.c.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
        if (sharedPreferences != null) {
            this.s.cpuName = sharedPreferences.getString("key_device_cpu_name", "");
            this.s.cpuCoresNum = sharedPreferences.getInt("key_device_cpu_core_num", -1);
            this.s.cpuMaxFreq = sharedPreferences.getInt("key_device_cpu_max_freq", -1);
            this.s.cpuMinFreq = sharedPreferences.getInt("key_device_cpu_min_freq", -1);
            this.s.ramTotalSize = sharedPreferences.getLong("key_device_ram_total_size", -1L);
            this.s.romName = sharedPreferences.getString("key_device_rom_name", "");
            this.s.romVersion = sharedPreferences.getString("key_device_rom_version", "");
            this.s.abiList = sharedPreferences.getString("key_cpu_abilists", "");
            android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            com.tencent.tmassistantbase.jce.TerminalExtra terminalExtra = this.s;
            if (terminalExtra.cpuCoresNum < 0) {
                terminalExtra.cpuCoresNum = com.tencent.tmassistantbase.util.h.a();
                editorEdit.putInt("key_device_cpu_core_num", this.s.cpuCoresNum);
            }
            com.tencent.tmassistantbase.jce.TerminalExtra terminalExtra2 = this.s;
            if (terminalExtra2.cpuMaxFreq < 0) {
                terminalExtra2.cpuMaxFreq = com.tencent.tmassistantbase.util.h.b();
                editorEdit.putInt("key_device_cpu_max_freq", this.s.cpuMaxFreq);
            }
            com.tencent.tmassistantbase.jce.TerminalExtra terminalExtra3 = this.s;
            if (terminalExtra3.cpuMinFreq < 0) {
                terminalExtra3.cpuMinFreq = com.tencent.tmassistantbase.util.h.c();
                editorEdit.putInt("key_device_cpu_min_freq", this.s.cpuMinFreq);
            }
            com.tencent.tmassistantbase.jce.TerminalExtra terminalExtra4 = this.s;
            if (terminalExtra4.ramTotalSize < 0) {
                terminalExtra4.ramTotalSize = com.tencent.tmassistantbase.util.h.d();
                editorEdit.putLong("key_device_ram_total_size", this.s.ramTotalSize);
            }
            if (android.text.TextUtils.isEmpty(this.s.cpuName)) {
                this.s.cpuName = com.tencent.tmassistantbase.util.h.e();
                editorEdit.putString("key_device_cpu_name", this.s.cpuName);
            }
            com.tencent.tmassistantbase.jce.TerminalExtra terminalExtra5 = this.s;
            terminalExtra5.fingerprint = android.os.Build.FINGERPRINT;
            if (android.text.TextUtils.isEmpty(terminalExtra5.abiList)) {
                this.s.abiList = com.tencent.tmassistantbase.util.h.f();
                editorEdit.putString("key_cpu_abilists", this.s.abiList);
            }
        }
    }
}
