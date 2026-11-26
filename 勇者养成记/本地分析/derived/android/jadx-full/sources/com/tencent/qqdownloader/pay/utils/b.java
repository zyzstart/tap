package com.tencent.qqdownloader.pay.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {
    public static java.lang.String a() {
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
                        stringBuffer.append(a(bArr[i]));
                        stringBuffer.append("-");
                    }
                    stringBuffer.append(a(bArr[bArr.length - 1]));
                    return stringBuffer.toString();
                }
            }
            return "";
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static java.lang.String a(byte b) {
        java.lang.String str = "00" + java.lang.Integer.toHexString(b).toUpperCase();
        int length = str.length();
        return str.substring(length - 2, length);
    }

    public static java.lang.String a(android.content.Context context) {
        int iCheckCallingOrSelfPermission;
        try {
            iCheckCallingOrSelfPermission = context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
        } catch (java.lang.Exception unused) {
            iCheckCallingOrSelfPermission = -1;
        }
        if (iCheckCallingOrSelfPermission != 0) {
            return "";
        }
        try {
            java.lang.String deviceId = ((android.telephony.TelephonyManager) context.getSystemService("phone")).getDeviceId();
            return android.text.TextUtils.isEmpty(deviceId) ? "" : deviceId;
        } catch (java.lang.Throwable unused2) {
            return "";
        }
    }

    public static boolean a(java.lang.String[] strArr, int i) {
        try {
            return (strArr[i] == null || android.text.TextUtils.isEmpty(strArr[i])) ? false : true;
        } catch (java.lang.Exception unused) {
        }
    }

    public static java.lang.String b(android.content.Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return "";
        }
        try {
            java.lang.String subscriberId = ((android.telephony.TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            return android.text.TextUtils.isEmpty(subscriberId) ? "" : subscriberId;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String[] c(android.content.Context context) {
        int iCheckCallingOrSelfPermission;
        try {
            iCheckCallingOrSelfPermission = context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
        } catch (java.lang.Exception unused) {
            iCheckCallingOrSelfPermission = -1;
        }
        if (iCheckCallingOrSelfPermission != 0) {
            return null;
        }
        try {
            java.lang.String[] strArrA = !com.tencent.qqdownloader.pay.utils.kapalaiadapter.b.f ? com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.a().a(context) : com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.a().b(context);
            if (strArrA == null || strArrA.length == 0) {
                return null;
            }
            return strArrA;
        } catch (java.lang.Exception unused2) {
        }
    }
}
