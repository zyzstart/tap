package com.tencent.ysdk.shell.libware.device;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APNUtil {
    public static final byte GROUP_NETTYPE_2G = 1;
    public static final byte GROUP_NETTYPE_3G = 2;
    public static final byte GROUP_NETTYPE_4G = 5;
    public static final byte GROUP_NETTYPE_UNKNOWN = 4;
    public static final byte GROUP_NETTYPE_WIFI = 3;
    public static final int IMSI_CODE_CHINA_MOBILE = 46007;
    public static final int IMSI_CODE_CHINA_MOBILE_GSM = 46000;
    public static final int IMSI_CODE_CHINA_MOBILE_SCDMA = 46002;
    public static final int IMSI_CODE_CHINA_TELCOM = 46005;
    public static final int IMSI_CODE_CHINA_TELCOM_CDMA = 46003;
    public static final int IMSI_CODE_CHINA_TELCOM_SCDMA = 46011;
    public static final int IMSI_CODE_CHINA_TIETONG_SDM_R = 46020;
    public static final int IMSI_CODE_CHINA_UNICOM = 46006;
    public static final int IMSI_CODE_CHINA_UNICOM_GSM = 46001;
    public static final int OPERATOR_CHINA_MOBILE = 0;
    public static final int OPERATOR_CHINA_TELECOM = 2;
    public static final int OPERATOR_CHINA_TIETONG = 3;
    public static final int OPERATOR_CHINA_UNICOM = 1;
    public static final int OPERATOR_UNKNOWN = -1;
    public static final java.lang.String SP_PROVIDER_NAME_CHINA_MOBILE = "中国移动";
    public static final java.lang.String SP_PROVIDER_NAME_CHINA_TELECOM = "中国电信";
    public static final java.lang.String SP_PROVIDER_NAME_CHINA_TIETONG = "中国网通";
    public static final java.lang.String SP_PROVIDER_NAME_CHINA_UNICOM = "中国联通";
    public static boolean isNetworkActive = true;
    public static com.tencent.ysdk.shell.libware.device.NetInfo netInfo = new com.tencent.ysdk.shell.libware.device.NetInfo();

    public static com.tencent.ysdk.shell.libware.device.APN getApn(android.content.Context context) {
        return getNetInfo(context).apn;
    }

    public static java.lang.String getApnName(android.content.Context context) {
        return getNetInfo(context).apn.getStringValue();
    }

    public static byte getApnType(android.content.Context context) {
        return getNetInfo(context).apn.getByteValue();
    }

    public static java.lang.String getBssid(android.content.Context context) {
        com.tencent.ysdk.shell.libware.device.NetInfo netInfo2;
        return (context == null || (netInfo2 = getNetInfo(context)) == null) ? "" : netInfo2.bssid;
    }

    public static int getConnectedTypeINT(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().checkCallingOrSelfPermission(com.unisound.client.SpeechConstants.PERMISSION_ACCESS_NETWORK_STATE) == 0 && (activeNetworkInfo = getConnectivityManager(context).getActiveNetworkInfo()) != null) {
            return activeNetworkInfo.getType();
        }
        return -1;
    }

    public static android.net.ConnectivityManager getConnectivityManager(android.content.Context context) {
        return (android.net.ConnectivityManager) context.getSystemService("connectivity");
    }

    public static int getGroupNetType(android.content.Context context) {
        if (isWifi(context)) {
            return 3;
        }
        if (is4G(context)) {
            return 5;
        }
        if (is3G(context)) {
            return 2;
        }
        return is2G(context) ? 1 : 4;
    }

    public static java.lang.String getGroupNetTypeDesc(android.content.Context context) {
        if (isWifi(context)) {
            return "WIFI";
        }
        if (is4G(context)) {
            return "4G";
        }
        if (is3G(context)) {
            return "3G";
        }
        return is2G(context) ? "2G" : "UNKNOWN";
    }

    public static com.tencent.ysdk.shell.libware.device.NetInfo getMobileNetInfo(android.content.Context context) {
        if (!com.tencent.ysdk.shell.libware.apk.PermissionUtils.hasReadPhoneStatePermission(context)) {
            return new com.tencent.ysdk.shell.libware.device.NetInfo();
        }
        com.tencent.ysdk.shell.libware.device.NetInfo netInfo2 = new com.tencent.ysdk.shell.libware.device.NetInfo();
        boolean zIsWap = isWap();
        netInfo2.isWap = zIsWap;
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
        java.lang.String networkOperator = telephonyManager.getNetworkOperator();
        netInfo2.networkOperator = networkOperator;
        int networkType = telephonyManager.getNetworkType();
        netInfo2.networkType = networkType;
        switch (getSimOperator(networkOperator)) {
            case 0:
                operateMobileChina(networkType, netInfo2, zIsWap);
                return netInfo2;
            case 1:
                operateUnionChina(networkType, netInfo2, zIsWap);
                return netInfo2;
            case 2:
                operaTeteleconChina(networkType, netInfo2, zIsWap);
                return netInfo2;
            default:
                if (zIsWap) {
                    netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.UNKNOW_WAP;
                } else {
                    netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.UNKNOWN;
                }
                return netInfo2;
        }
    }

    public static com.tencent.ysdk.shell.libware.device.NetInfo getNetInfo(android.content.Context context) {
        android.net.wifi.WifiInfo connectionInfo;
        com.tencent.ysdk.shell.libware.device.NetInfo netInfo2 = new com.tencent.ysdk.shell.libware.device.NetInfo();
        android.net.NetworkInfo activeNetworkInfo = null;
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                isNetworkActive = false;
                netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.NO_NETWORK;
                return netInfo2;
            }
        } catch (java.lang.Throwable th) {
            com.tencent.ysdk.shell.libware.file.Logger.e(th.getLocalizedMessage());
        }
        isNetworkActive = true;
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            return getMobileNetInfo(context);
        }
        netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.WIFI;
        try {
            android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getSystemService("wifi");
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                netInfo2.bssid = connectionInfo.getBSSID();
                netInfo2.ssid = connectionInfo.getSSID();
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
        return netInfo2;
    }

    public static java.lang.String getNetWorkName(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) ? "MOBILE" : activeNetworkInfo.getTypeName();
    }

    public static java.lang.String getNetworkType(android.content.Context context) {
        if (context == null) {
            return "context is null";
        }
        switch (getConnectedTypeINT(context)) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
                switch (getTelephonyManager(context).getNetworkType()) {
                    case 1:
                        return "GPRS";
                    case 2:
                        return "EDGE";
                    case 3:
                        return "UMTS";
                    case 4:
                        return "CDMA";
                    case 5:
                        return "EVDO0";
                    case 6:
                        return "EVDOA";
                    case 7:
                        return "1xRTT";
                    case 8:
                        return "HSDPA";
                    case 9:
                        return "HSUPA";
                    case 10:
                        return "HSPA";
                    case 11:
                        return "iDen";
                    case 12:
                        return "EVDO_B";
                    case 13:
                        return "LTE";
                    case 14:
                        return "eHRPD";
                    case 15:
                        return "HSPA+";
                    default:
                        return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
                }
            case 1:
                return "wifi";
            default:
                return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x0019 A[RETURN] */
    public static int getSimOperator(java.lang.String str) {
        int i = com.tencent.ysdk.shell.libware.util.CommonUtils.parseInt(str, 0);
        if (i == 46011) {
            return 2;
        }
        if (i == 46020) {
            return 3;
        }
        switch (i) {
            case IMSI_CODE_CHINA_MOBILE_GSM /* 46000 */:
            case IMSI_CODE_CHINA_MOBILE_SCDMA /* 46002 */:
                return 0;
            case IMSI_CODE_CHINA_UNICOM_GSM /* 46001 */:
                return 1;
            case IMSI_CODE_CHINA_TELCOM_CDMA /* 46003 */:
                return 2;
            default:
                switch (i) {
                    case IMSI_CODE_CHINA_TELCOM /* 46005 */:
                        return 2;
                    case IMSI_CODE_CHINA_UNICOM /* 46006 */:
                        return 1;
                    case IMSI_CODE_CHINA_MOBILE /* 46007 */:
                        return 0;
                    default:
                        return -1;
                }
        }
    }

    public static java.lang.String getSimOperator(android.content.Context context) {
        if (!com.tencent.ysdk.shell.libware.apk.PermissionUtils.hasReadPhoneStatePermission(context)) {
            return "";
        }
        switch (getSimOperator(((android.telephony.TelephonyManager) context.getSystemService("phone")).getNetworkOperator())) {
            case 0:
                return SP_PROVIDER_NAME_CHINA_MOBILE;
            case 1:
                return SP_PROVIDER_NAME_CHINA_UNICOM;
            case 2:
                return SP_PROVIDER_NAME_CHINA_TELECOM;
            case 3:
                return SP_PROVIDER_NAME_CHINA_TIETONG;
            default:
                return "";
        }
    }

    public static android.telephony.TelephonyManager getTelephonyManager(android.content.Context context) {
        return (android.telephony.TelephonyManager) context.getSystemService("phone");
    }

    public static boolean is2G(android.content.Context context) {
        com.tencent.ysdk.shell.libware.device.APN apn = getApn(context);
        return apn == com.tencent.ysdk.shell.libware.device.APN.CMNET || apn == com.tencent.ysdk.shell.libware.device.APN.CMWAP || apn == com.tencent.ysdk.shell.libware.device.APN.UNINET || apn == com.tencent.ysdk.shell.libware.device.APN.UNIWAP;
    }

    public static boolean is3G(android.content.Context context) {
        com.tencent.ysdk.shell.libware.device.APN apn = getApn(context);
        return apn == com.tencent.ysdk.shell.libware.device.APN.CTWAP || apn == com.tencent.ysdk.shell.libware.device.APN.CTNET || apn == com.tencent.ysdk.shell.libware.device.APN.WAP3G || apn == com.tencent.ysdk.shell.libware.device.APN.NET3G;
    }

    public static boolean is4G(android.content.Context context) {
        com.tencent.ysdk.shell.libware.device.APN apn = getApn(context);
        return apn == com.tencent.ysdk.shell.libware.device.APN.WAP4G || apn == com.tencent.ysdk.shell.libware.device.APN.NET4G;
    }

    public static boolean isNetworkActive(android.content.Context context) {
        if (netInfo.apn == com.tencent.ysdk.shell.libware.device.APN.UN_DETECT) {
            refreshNetwork(context);
        }
        return isNetworkActive;
    }

    public static boolean isWap() {
        return !com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(android.net.Proxy.getDefaultHost());
    }

    public static boolean isWifi(android.content.Context context) {
        return getApn(context) == com.tencent.ysdk.shell.libware.device.APN.WIFI;
    }

    private static void operaTeteleconChina(int i, com.tencent.ysdk.shell.libware.device.NetInfo netInfo2, boolean z) {
        if (i != 13) {
            if (z) {
                netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.CTWAP;
                return;
            } else {
                netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.CTNET;
                return;
            }
        }
        if (z) {
            netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.WAP4G;
        } else {
            netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.NET4G;
        }
    }

    private static void operateMobileChina(int i, com.tencent.ysdk.shell.libware.device.NetInfo netInfo2, boolean z) {
        if (i == 13) {
            if (z) {
                netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.WAP4G;
                return;
            }
            netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.NET4G;
        }
        switch (i) {
            case 1:
            case 2:
                if (!z) {
                    netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.CMNET;
                } else {
                    netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.CMWAP;
                }
                break;
            default:
                if (!z) {
                    netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.UNKNOWN;
                } else {
                    netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.UNKNOW_WAP;
                }
                break;
        }
    }

    private static void operateUnionChina(int i, com.tencent.ysdk.shell.libware.device.NetInfo netInfo2, boolean z) {
        if (i != 8 && i != 10) {
            if (i == 13) {
                if (z) {
                    netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.WAP4G;
                    return;
                } else {
                    netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.NET4G;
                    return;
                }
            }
            if (i != 15) {
                switch (i) {
                    case 1:
                    case 2:
                        if (!z) {
                            netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.UNINET;
                        } else {
                            netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.UNIWAP;
                        }
                        break;
                    case 3:
                        break;
                    default:
                        if (!z) {
                            netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.UNKNOWN;
                        } else {
                            netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.UNKNOW_WAP;
                        }
                        break;
                }
            }
        }
        if (z) {
            netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.WAP3G;
        } else {
            netInfo2.apn = com.tencent.ysdk.shell.libware.device.APN.NET3G;
        }
    }

    public static void refreshNetwork(android.content.Context context) {
        netInfo = getNetInfo(context);
    }
}
