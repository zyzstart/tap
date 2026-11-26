package com.tencent.yybsdk.apkpatch.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.yybsdk.apkpatch.f.c f1421a = null;
    private static java.lang.String c = "";
    private static int d;
    private android.content.Context b;
    private boolean e = false;

    private c() {
    }

    public static synchronized com.tencent.yybsdk.apkpatch.f.c a() {
        if (f1421a == null) {
            f1421a = new com.tencent.yybsdk.apkpatch.f.c();
        }
        return f1421a;
    }

    private boolean b(android.content.Context context) {
        if (context == null) {
            return false;
        }
        if (!this.e) {
            com.tencent.yybsdk.apkpatch.f.a.b.a(context);
            c = new com.tencent.yybsdk.apkpatch.f.a.h().a(context, "100", "TMUpdateSDK", "100", "", "NA", com.tencent.yybsdk.apkpatch.f.a.b.c.ordinal());
            d = 0;
            this.e = true;
        }
        return true;
    }

    public void a(android.content.Context context) {
        this.b = context;
        b(context);
    }

    public int b() {
        android.net.NetworkInfo activeNetworkInfo;
        try {
            if (this.b == null || this.b.checkCallingOrSelfPermission(com.unisound.client.SpeechConstants.PERMISSION_ACCESS_NETWORK_STATE) == -1 || (activeNetworkInfo = ((android.net.ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
                return 0;
            }
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return 1;
            }
            if (type == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype == 1 || subtype == 2 || subtype == 4) {
                    return 2;
                }
                return (subtype == 13 || subtype == 19) ? 4 : 3;
            }
        } catch (java.lang.Exception unused) {
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0088  */
    public java.lang.String c() {
        int i;
        int i2;
        android.telephony.cdma.CdmaCellLocation cdmaCellLocation;
        int baseStationId;
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) this.b.getSystemService("phone");
        java.lang.String networkOperator = telephonyManager.getNetworkOperator();
        int networkId = -1;
        if (android.text.TextUtils.isEmpty(networkOperator) || networkOperator.length() <= 3) {
            i = -1;
            i2 = -1;
        } else {
            i2 = java.lang.Integer.parseInt(networkOperator.substring(0, 3));
            i = java.lang.Integer.parseInt(networkOperator.substring(3));
        }
        if (b() == 4) {
            java.util.List<android.telephony.CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                baseStationId = -1;
            } else {
                android.telephony.CellInfo cellInfo = allCellInfo.get(0);
                if (cellInfo instanceof android.telephony.CellInfoLte) {
                    android.telephony.CellIdentityLte cellIdentity = ((android.telephony.CellInfoLte) cellInfo).getCellIdentity();
                    networkId = cellIdentity.getTac();
                    baseStationId = cellIdentity.getCi();
                } else {
                    baseStationId = -1;
                }
            }
        } else {
            int phoneType = telephonyManager.getPhoneType();
            if (phoneType == 1) {
                android.telephony.gsm.GsmCellLocation gsmCellLocation = (android.telephony.gsm.GsmCellLocation) telephonyManager.getCellLocation();
                if (gsmCellLocation != null) {
                    networkId = gsmCellLocation.getLac();
                    baseStationId = gsmCellLocation.getCid();
                } else {
                    baseStationId = -1;
                }
            } else if (phoneType != 2 || (cdmaCellLocation = (android.telephony.cdma.CdmaCellLocation) telephonyManager.getCellLocation()) == null) {
                baseStationId = -1;
            } else {
                networkId = cdmaCellLocation.getNetworkId();
                baseStationId = cdmaCellLocation.getBaseStationId();
            }
        }
        return i2 + ":" + i + ":" + networkId + ":" + baseStationId;
    }

    public java.lang.String d() {
        java.lang.StringBuilder sb;
        java.lang.String strC;
        int iB = b();
        if (iB == 0) {
            return "";
        }
        if (iB == 1) {
            android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) this.b.getSystemService("wifi")).getConnectionInfo();
            java.lang.String ssid = connectionInfo != null ? connectionInfo.getSSID() : "";
            sb = new java.lang.StringBuilder();
            sb.append(iB);
            sb.append(":");
            strC = ssid.replace("\"", "");
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(iB);
            sb.append(":");
            strC = c();
        }
        sb.append(strC);
        return sb.toString();
    }

    public java.lang.String e() {
        return c;
    }
}
