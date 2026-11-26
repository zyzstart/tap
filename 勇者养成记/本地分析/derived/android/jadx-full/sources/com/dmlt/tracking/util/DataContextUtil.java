package com.dmlt.tracking.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DataContextUtil {
    public static java.lang.String getAndroid(android.content.Context context) {
        java.lang.String string = android.provider.Settings.Secure.getString(context.getContentResolver(), com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
        com.dmlt.tracking.util.LogUtil.i("android: " + string);
        return string;
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public static java.lang.String getImei(android.content.Context context) {
        java.lang.String deviceId = "";
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    deviceId = telephonyManager.getImei();
                } else {
                    deviceId = android.os.Build.VERSION.SDK_INT >= 23 ? telephonyManager.getDeviceId() : telephonyManager.getDeviceId();
                }
            }
        } catch (java.lang.Exception e) {
            com.dmlt.tracking.util.LogUtil.e("getImei: " + e.getMessage());
        }
        return deviceId;
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public static java.lang.String getIp(android.content.Context context) {
        android.net.wifi.WifiInfo connectionInfo;
        java.lang.String strInt2ip = "";
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        android.net.NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        android.net.NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        try {
            if (networkInfo.isConnected()) {
                java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    java.util.Enumeration<java.net.InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        java.net.InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof java.net.Inet4Address)) {
                            strInt2ip = inetAddressNextElement.getHostAddress();
                            break;
                        }
                    }
                }
            } else if (networkInfo2.isConnected() && (connectionInfo = ((android.net.wifi.WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo()) != null) {
                strInt2ip = int2ip(connectionInfo.getIpAddress());
            }
        } catch (java.lang.Exception e) {
            com.dmlt.tracking.util.LogUtil.e("getIp: " + e.getMessage());
        }
        com.dmlt.tracking.util.LogUtil.i("ip: " + strInt2ip);
        return strInt2ip;
    }

    public static java.lang.String getMac(android.content.Context context) {
        java.lang.String macAddress1 = getMacAddress1();
        if (!com.dmlt.tracking.util.ObjectUtil.isEmpty(macAddress1)) {
            return macAddress1;
        }
        java.lang.String macAddress3 = getMacAddress3();
        return !com.dmlt.tracking.util.ObjectUtil.isEmpty(macAddress3) ? macAddress3 : getMacAddress2();
    }

    public static java.lang.String getMacAddress1() {
        byte[] hardwareAddress;
        java.lang.String str = null;
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                java.net.NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement != null && (hardwareAddress = networkInterfaceNextElement.getHardwareAddress()) != null && hardwareAddress.length != 0) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    for (byte b : hardwareAddress) {
                        sb.append(java.lang.String.format("%02X:", java.lang.Byte.valueOf(b)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    java.lang.String string = sb.toString();
                    if (networkInterfaceNextElement.getName().equals("wlan0")) {
                        str = string;
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.dmlt.tracking.util.LogUtil.e("getMacAddress1: " + e.getMessage());
        }
        return str;
    }

    public static java.lang.String getMacAddress2() {
        java.lang.String strTrim = "";
        java.lang.String line = "";
        try {
            java.io.LineNumberReader lineNumberReader = new java.io.LineNumberReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address").getInputStream()));
            while (line != null) {
                line = lineNumberReader.readLine();
                if (line != null) {
                    strTrim = line.trim();
                    break;
                }
            }
            return !com.dmlt.tracking.util.ObjectUtil.isEmpty(strTrim) ? strTrim : loadFileAsString("/sys/class/net/eth0/address").toUpperCase(java.util.Locale.getDefault()).substring(0, 17);
        } catch (java.lang.Exception e) {
            com.dmlt.tracking.util.LogUtil.e("getMacAddress2: " + e.getMessage());
            return "";
        }
    }

    public static java.lang.String getMacAddress3() {
        try {
            java.net.NetworkInterface byName = java.net.NetworkInterface.getByName("wlan0");
            if (byName == null) {
                return null;
            }
            return new java.lang.String(byName.getHardwareAddress());
        } catch (java.lang.Exception e) {
            com.dmlt.tracking.util.LogUtil.e("getMacAddress3: " + e.getMessage());
            return null;
        }
    }

    public static java.lang.String getUa(android.content.Context context) {
        java.lang.String defaultUserAgent = android.os.Build.VERSION.SDK_INT >= 17 ? android.webkit.WebSettings.getDefaultUserAgent(context) : new android.webkit.WebView(context).getSettings().getUserAgentString();
        com.dmlt.tracking.util.LogUtil.i("ua: " + defaultUserAgent);
        return defaultUserAgent;
    }

    public static java.lang.String int2ip(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public static java.lang.String loadFileAsString(java.lang.String str) throws java.lang.Exception {
        java.io.FileReader fileReader = new java.io.FileReader(str);
        java.lang.String strLoadReaderAsString = loadReaderAsString(fileReader);
        fileReader.close();
        return strLoadReaderAsString;
    }

    public static java.lang.String loadReaderAsString(java.io.Reader reader) throws java.lang.Exception {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        char[] cArr = new char[4096];
        while (true) {
            int i = reader.read(cArr);
            if (i < 0) {
                return sb.toString();
            }
            sb.append(cArr, 0, i);
        }
    }
}
