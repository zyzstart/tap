package com.unisound.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {
    private static java.lang.String A = "[REDACTED_HEX_CONSTANT]";
    private static android.content.Context B = null;
    private static java.lang.String C = "";
    private static boolean D = false;
    private static boolean E = true;
    private static final java.lang.String F = "DeviceInfoUtil";
    private static java.lang.String G = "00";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.lang.String f1460a = "PN";
    public static final java.lang.String b = "OS";
    public static final java.lang.String c = "CR";
    public static final java.lang.String d = "NT";
    public static final java.lang.String e = "MD";
    public static final java.lang.String f = "SV";
    public static final java.lang.String g = "SID";
    public static final java.lang.String h = "RPT";
    public static final java.lang.String i = "EC";
    public static final java.lang.String j = "NPT";
    public static final java.lang.String k = "IP";
    public static final int l = 0;
    public static final int m = 1;
    public static final int n = 2;
    public static final int o = 3;
    public static final int p = 4;
    public static java.lang.String q = "";
    public static java.lang.String r = "";
    public static java.lang.String s = "";
    public static java.lang.String t = "";
    public static android.telephony.TelephonyManager u = null;
    public static android.net.NetworkInfo v = null;
    public static android.net.ConnectivityManager w = null;
    private static final java.lang.String x = "000000000000000";
    private static boolean y = false;
    private static java.lang.String z = "";

    public static java.lang.String a() {
        return android.os.Build.MODEL;
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        return a(context, str, C);
    }

    private static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.lang.String strD = d(str);
        f("DeviceInfoUtil getUDID deviceSn = " + str2);
        if (strD != null && !strD.equals("")) {
            f("DeviceInfoUtil getUDID from sdcard= " + strD);
            if (!android.text.TextUtils.isEmpty(str2) && !b(str, strD, str2)) {
                return b(context, str, str2);
            }
            c(context, str, strD);
            return strD;
        }
        java.lang.String strB = b(context, str);
        if (strB == null || strB.equals("")) {
            java.lang.String strB2 = b(context, str, str2);
            f("DeviceInfoUtil first getUDID= " + strB2);
            return strB2;
        }
        f("DeviceInfoUtil getUDID from sharedPreferences= " + strB);
        if (!android.text.TextUtils.isEmpty(str2) && !b(str, strB, str2)) {
            return b(context, str, str2);
        }
        a(A, str, strB);
        return strB;
    }

    public static java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(z) || D) {
            z = a(B, str);
            if (D) {
                D = false;
            }
        }
        return z;
    }

    public static java.lang.String a(java.lang.String str, android.content.Context context) throws org.json.JSONException {
        java.lang.String strA = a(str, a(str), context);
        java.lang.String strB = "";
        try {
            strB = b(strA, "v3.1");
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        h("[REDACTED]" + strB);
        return strB;
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2) {
        h("[REDACTED]" + str + "[REDACTED]" + G + "[REDACTED]" + str2);
        int iHashCode = str.hashCode();
        h("[REDACTED]" + iHashCode);
        java.lang.String str3 = iHashCode + G + str2;
        h("build udid by deviceSn, deviceContent = " + str3);
        java.lang.String strReplaceAll = (android.text.TextUtils.isEmpty(str3) ? "" : android.util.Base64.encodeToString(str3.getBytes(), 8)).replaceAll("=", "").replaceAll("\\s", "");
        h("build udid by deviceSn, udid = " + strReplaceAll);
        return strReplaceAll;
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, android.content.Context context) throws org.json.JSONException {
        java.lang.String string = "";
        try {
            java.lang.String string2 = context.getSharedPreferences(A, 0).getString("deviceInfo", "");
            h("[REDACTED]" + string2);
            if (!android.text.TextUtils.isEmpty(string2)) {
                org.json.JSONArray jSONArray = new org.json.JSONObject(string2).getJSONArray("deviceInfo");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    org.json.JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (str.equals(jSONObject.get(com.unisound.sdk.cb.c)) && str2.equals(jSONObject.get("udid"))) {
                        string = jSONObject.getString("[REDACTED]");
                        break;
                    }
                }
            }
        } catch (java.lang.Exception unused) {
        }
        h("[REDACTED]" + string);
        return string;
    }

    private static java.lang.String a(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b2 : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString.toUpperCase());
        }
        return sb.toString();
    }

    public static void a(android.content.Context context) {
        B = context;
        if (y) {
            return;
        }
        w = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        u = (android.telephony.TelephonyManager) context.getSystemService("phone");
        android.net.ConnectivityManager connectivityManager = w;
        if (connectivityManager != null) {
            v = connectivityManager.getNetworkInfo(0);
        }
        s = context.getPackageName();
        r = c(context);
        q = b(context);
        t = android.os.Build.MODEL;
        y = true;
    }

    private static void a(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        java.lang.String string;
        java.lang.String strI = "";
        java.io.RandomAccessFile randomAccessFile = null;
        try {
            try {
                java.lang.String strJ = j();
                java.io.File file = new java.io.File(strJ);
                if (!file.exists()) {
                    file.mkdirs();
                }
                java.io.File file2 = new java.io.File(strJ + java.io.File.separator + str);
                if (file2.exists()) {
                    strI = i();
                    file2.delete();
                }
                file2.createNewFile();
                if (strI.contains("deviceInfo")) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(strI);
                    org.json.JSONArray jSONArray = jSONObject.getJSONArray("deviceInfo");
                    boolean z2 = false;
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        org.json.JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        if (str2.equals(jSONObject2.get(com.unisound.sdk.cb.c))) {
                            jSONObject2.put("udid", str3);
                            z2 = true;
                            break;
                        }
                    }
                    if (!z2) {
                        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                        jSONObject3.put(com.unisound.sdk.cb.c, str2);
                        jSONObject3.put("udid", str3);
                        jSONArray.put(jSONObject3);
                        jSONObject.put("deviceInfo", jSONArray);
                    }
                    string = jSONObject.toString();
                } else {
                    org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                    org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                    org.json.JSONObject jSONObject5 = new org.json.JSONObject();
                    jSONObject5.put(com.unisound.sdk.cb.c, str2);
                    jSONObject5.put("udid", str3);
                    jSONArray2.put(jSONObject5);
                    jSONObject4.put("deviceInfo", jSONArray2);
                    string = jSONObject4.toString();
                }
                f("DeviceInfoUtil setUDIDToSdcard udidContent = " + string);
                java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(strJ + java.io.File.separator + str, "rw");
                try {
                    randomAccessFile2.write(string.getBytes());
                    randomAccessFile2.close();
                } catch (java.lang.Exception unused) {
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (java.lang.Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Exception e3) {
                e3.printStackTrace();
            }
        } catch (java.lang.Exception unused2) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static void a(boolean z2) {
        D = z2;
    }

    public static int b() {
        android.net.NetworkInfo networkInfo = w.getNetworkInfo(1);
        if (networkInfo == null || !networkInfo.isAvailable()) {
            return c();
        }
        return 1;
    }

    public static int b(java.lang.String str) {
        if (str == null) {
            return -1;
        }
        if (str.length() > 24) {
            C = "";
            return -1;
        }
        C = str;
        f("DeviceInfoUtil setDeviceSn = " + C);
        return 0;
    }

    public static java.lang.String b(android.content.Context context) {
        java.lang.String deviceId;
        java.lang.String string = null;
        try {
            deviceId = ((android.telephony.TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (java.lang.Exception unused) {
            deviceId = null;
        }
        if (!android.text.TextUtils.isEmpty(deviceId) && !deviceId.equals(x)) {
            return deviceId;
        }
        try {
            string = android.provider.Settings.Secure.getString(context.getContentResolver(), com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
        } catch (java.lang.Exception unused2) {
        }
        if (!android.text.TextUtils.isEmpty(string) && !string.equals(x)) {
            return string;
        }
        try {
            android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getMacAddress() : x;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return x;
        }
    }

    private static java.lang.String b(android.content.Context context, java.lang.String str) {
        try {
            java.lang.String string = context.getSharedPreferences(A, 0).getString("deviceInfo", "");
            h("DeviceInfoUtil getUDIDFromSb deviceContent = " + string);
            if (android.text.TextUtils.isEmpty(string)) {
                return "";
            }
            org.json.JSONArray jSONArray = new org.json.JSONObject(string).getJSONArray("deviceInfo");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (str.equals(jSONObject.get(com.unisound.sdk.cb.c))) {
                    return jSONObject.getString("udid");
                }
            }
            return "";
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private static java.lang.String b(android.content.Context context, java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.lang.String strA = !android.text.TextUtils.isEmpty(str2) ? a(str, str2) : l();
        c(context, str, strA);
        a(A, str, strA);
        f("DeviceInfoUtil createNewUDID UDID= " + strA);
        return strA;
    }

    private static java.lang.String b(java.lang.String str, java.lang.String str2) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("[REDACTED]", str);
        jSONObject.put("activateVersion", str2);
        return jSONObject.toString();
    }

    public static void b(boolean z2) {
        E = z2;
    }

    private static boolean b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        boolean zEquals = str2.equals(a(str, str3));
        f("DeviceInfoUtil isUdidMatchDeviceSn = " + zEquals);
        return zEquals;
    }

    public static int c() {
        android.net.NetworkInfo networkInfo = v;
        if (networkInfo == null || !networkInfo.isAvailable()) {
            return 0;
        }
        switch (u.getNetworkType()) {
            case 1:
            case 2:
            case 4:
                return 3;
            case 3:
            case 5:
            case 6:
            case 8:
                return 2;
            case 7:
            default:
                return 4;
        }
    }

    public static java.lang.String c(android.content.Context context) {
        java.lang.String networkOperator = ((android.telephony.TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        return (networkOperator == null || "".equals(networkOperator)) ? "0" : networkOperator;
    }

    private static void c(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String string;
        try {
            boolean z2 = false;
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(A, 0);
            java.lang.String string2 = sharedPreferences.getString("deviceInfo", "");
            if (android.text.TextUtils.isEmpty(string2)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put(com.unisound.sdk.cb.c, str);
                jSONObject2.put("udid", str2);
                jSONObject2.put("[REDACTED]", "[REDACTED]");
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                jSONArray.put(jSONObject2);
                jSONObject.put("deviceInfo", jSONArray);
                string = jSONObject.toString();
            } else {
                org.json.JSONObject jSONObject3 = new org.json.JSONObject(string2);
                org.json.JSONArray jSONArray2 = jSONObject3.getJSONArray("deviceInfo");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    org.json.JSONObject jSONObject4 = jSONArray2.getJSONObject(i2);
                    if (str.equals(jSONObject4.get(com.unisound.sdk.cb.c))) {
                        if (!str2.equals(jSONObject4.get("udid"))) {
                            jSONObject4.put("udid", str2);
                            jSONObject4.put("[REDACTED]", "[REDACTED]");
                        }
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    org.json.JSONObject jSONObject5 = new org.json.JSONObject();
                    jSONObject5.put(com.unisound.sdk.cb.c, str);
                    jSONObject5.put("udid", str2);
                    jSONObject5.put("[REDACTED]", "[REDACTED]");
                    jSONArray2.put(jSONObject5);
                    jSONObject3.put("deviceInfo", jSONArray2);
                }
                string = jSONObject3.toString();
            }
            h("DeviceInfoUtil setUDIDToSb deviceContent = " + string);
            android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("deviceInfo", string);
            editorEdit.commit();
        } catch (java.lang.Exception unused) {
        }
    }

    public static void c(java.lang.String str) {
        G = str;
        f("DeviceInfoUtil setOS = " + G);
    }

    public static java.lang.String d() {
        return android.os.Build.PRODUCT;
    }

    private static java.lang.String d(java.lang.String str) {
        java.lang.String string = "";
        try {
            org.json.JSONArray jSONArray = new org.json.JSONObject(i()).getJSONArray("deviceInfo");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (str.equals(jSONObject.get(com.unisound.sdk.cb.c))) {
                    string = jSONObject.getString("udid");
                    break;
                }
            }
        } catch (java.lang.Exception unused) {
        }
        f("[REDACTED]" + str + "[REDACTED]" + string);
        return string;
    }

    public static boolean d(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    public static java.lang.String e() {
        return android.os.Build.MODEL;
    }

    public static java.lang.String e(android.content.Context context) {
        java.lang.String bssid = "";
        try {
            android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                bssid = connectionInfo.getBSSID();
            }
        } catch (java.lang.Exception e2) {
            g(e2.getMessage() + " add permission android.permission.ACCESS_WIFI_STATE");
        }
        if (bssid == null) {
            bssid = "";
        }
        f("DeviceUtil getBSSID= " + bssid);
        return bssid;
    }

    private static java.lang.String e(java.lang.String str) {
        try {
            return a(java.security.MessageDigest.getInstance("SHA-1").digest(str.getBytes("UTF-8")));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String f() {
        return android.os.Build.MANUFACTURER;
    }

    public static java.lang.String f(android.content.Context context) {
        java.lang.String str = "";
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        if (str == null) {
            str = "";
        }
        f("DeviceUtil getAppVersion= " + str);
        return str;
    }

    private static void f(java.lang.String str) {
        if (E) {
            android.util.Log.i(F, str);
        }
    }

    public static java.lang.String g() {
        return android.os.Build.VERSION.RELEASE;
    }

    public static java.lang.String g(android.content.Context context) {
        java.lang.String str = "";
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        if (str == null) {
            str = "";
        }
        f("DeviceUtil getAppPackageName= " + str);
        return str;
    }

    private static void g(java.lang.String str) {
        if (E) {
            android.util.Log.i(F, str);
        }
    }

    public static java.lang.String h() {
        java.lang.String str = j() + java.io.File.separator + m();
        if (!new java.io.File(str).exists()) {
            return "";
        }
        try {
            return new java.io.RandomAccessFile(str, "rw").readLine();
        } catch (java.lang.Exception e2) {
            g(e2.getMessage() + "readSN error");
            return "";
        }
    }

    public static java.lang.String h(android.content.Context context) {
        if (context == null) {
            return x;
        }
        try {
            android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getMacAddress();
            }
        } catch (java.lang.Exception unused) {
        }
        f("DeviceUtil getMac= 000000000000000");
        return x;
    }

    private static void h(java.lang.String str) {
        if (E) {
            android.util.Log.i(F, str);
        }
    }

    private static java.lang.String i() {
        java.io.FileReader fileReader;
        java.lang.String string = "";
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.io.BufferedReader bufferedReader = null;
        try {
            fileReader = new java.io.FileReader(j() + java.io.File.separator + A);
            try {
                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(fileReader);
                while (true) {
                    try {
                        java.lang.String line = bufferedReader2.readLine();
                        if (line == null) {
                            string = sb.toString();
                            f("DeviceInfoUtil udidContent = " + string);
                            return string;
                        }
                        sb.append(line);
                    } catch (java.lang.Exception unused) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                                return string;
                            }
                        }
                        if (fileReader == null) {
                            return string;
                        }
                        fileReader.close();
                        return string;
                    }
                }
            } catch (java.lang.Exception unused2) {
            }
        } catch (java.lang.Exception unused3) {
            fileReader = null;
        }
    }

    public static java.lang.String i(android.content.Context context) {
        java.lang.String ssid;
        java.lang.String strSubstring = "";
        try {
            android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null && (ssid = connectionInfo.getSSID()) != null && !ssid.equals("")) {
                strSubstring = ssid.substring(1, ssid.length() - 1);
            }
        } catch (java.lang.Exception e2) {
            g(e2.getMessage() + " add permission android.permission.ACCESS_WIFI_STATE");
        }
        if (strSubstring == null) {
            strSubstring = "";
        }
        f("DeviceUtil getWifiSSID= " + strSubstring);
        return strSubstring;
    }

    private static java.lang.String j() {
        if (!android.os.Environment.getExternalStorageState().equals("mounted")) {
            return "/mnt/sdcard/unisound/sdk";
        }
        return android.os.Environment.getExternalStorageDirectory().getPath() + java.io.File.separator + "unisound/sdk";
    }

    public static java.lang.String j(android.content.Context context) {
        java.lang.String subscriberId;
        java.lang.String str;
        try {
            subscriberId = ((android.telephony.TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (java.lang.Exception unused) {
            subscriberId = null;
        }
        if (subscriberId == null) {
            str = "没有手机卡";
        } else if (subscriberId.startsWith("46000") || subscriberId.startsWith("46002")) {
            str = com.tencent.ysdk.shell.libware.device.APNUtil.SP_PROVIDER_NAME_CHINA_MOBILE;
        } else if (subscriberId.startsWith("46001")) {
            str = com.tencent.ysdk.shell.libware.device.APNUtil.SP_PROVIDER_NAME_CHINA_UNICOM;
        } else {
            str = subscriberId.startsWith("46003") ? com.tencent.ysdk.shell.libware.device.APNUtil.SP_PROVIDER_NAME_CHINA_TELECOM : "未找到对应运营商";
        }
        f("DeviceUtil operator= " + str);
        return str;
    }

    private static java.lang.String k() {
        java.io.InputStream inputStream;
        java.lang.String strTrim = "[REDACTED_HEX_CONSTANT]";
        try {
            java.lang.Process processExec = java.lang.Runtime.getRuntime().exec("cat /proc/cpuinfo");
            if (processExec != null && (inputStream = processExec.getInputStream()) != null) {
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
                loop0: while (true) {
                    java.lang.String line = bufferedReader.readLine();
                    while (true) {
                        if (line != null) {
                            if (line.indexOf("Serial") > -1) {
                                if (line.length() > 1 && line.contains(":")) {
                                    strTrim = line.substring(line.indexOf(":") + 1, line.length()).trim();
                                    break loop0;
                                }
                            }
                        } else {
                            break loop0;
                        }
                    }
                }
                bufferedReader.close();
                inputStream.close();
            }
        } catch (java.io.IOException unused) {
        }
        return strTrim;
    }

    private static java.lang.String k(android.content.Context context) {
        if (A.equals("")) {
            java.lang.String strB = b(context);
            q = strB;
            A = e(strB + k());
        }
        return A;
    }

    private static java.lang.String l() {
        java.lang.String string = java.util.UUID.randomUUID().toString();
        h("DeviceInfoUtil buildUdidFromUUId udid = " + string);
        return string;
    }

    private static java.lang.String m() {
        return "SN";
    }
}
