package com.tencent.beacon.core.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {
    public static java.lang.String a(java.lang.String str) {
        if (str != null && str.trim().length() != 0) {
            if (e(str.trim())) {
                java.lang.String strTrim = str.trim();
                return strTrim.length() > 16 ? strTrim.substring(0, 16) : strTrim;
            }
            com.tencent.beacon.core.e.d.i("[core] channelID should be Numeric! channelID:" + str, new java.lang.Object[0]);
        }
        return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static java.lang.String a(java.lang.String str, java.util.Map map) {
        java.lang.String strB = b(str, map);
        if (strB.length() <= 46080) {
            return strB;
        }
        java.lang.String str2 = "[event] eventName: " + str + " params > 45K";
        com.tencent.beacon.core.d.i.a().a("104", str2);
        com.tencent.beacon.core.e.i.a(str2);
        return null;
    }

    public static java.lang.String a(java.util.Map map) {
        return b(null, map);
    }

    public static java.lang.String b(java.lang.String str) {
        if (com.tencent.beacon.core.e.j.b(str)) {
            return null;
        }
        java.lang.String strTrim = str.replace('|', '_').trim();
        if (strTrim.length() == 0) {
            com.tencent.beacon.core.e.d.b("[core] eventName is invalid!! eventName length == 0!", new java.lang.Object[0]);
            return null;
        }
        if (!e(strTrim)) {
            com.tencent.beacon.core.e.d.b("[core] eventName should be ASCII code in 32-126! eventName:" + str, new java.lang.Object[0]);
            return null;
        }
        if (strTrim.length() <= 128) {
            return strTrim;
        }
        com.tencent.beacon.core.e.d.i("[core] eventName length should be less than 128! eventName:" + str, new java.lang.Object[0]);
        return strTrim.substring(0, 128);
    }

    public static java.lang.String b(java.lang.String str, java.util.Map map) {
        if (map == null) {
            return "";
        }
        java.util.Set<java.lang.String> setKeySet = map.keySet();
        if (setKeySet.size() > 50) {
            com.tencent.beacon.core.e.d.i("[core] map size should <= 50!", new java.lang.Object[0]);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        for (java.lang.String str2 : setKeySet) {
            int length = str2.trim().length();
            if (length <= 0 || !e(str2)) {
                com.tencent.beacon.core.e.d.i("[core] '%s' should be ASCII code in 32-126!", str2);
                if (str != null) {
                    com.tencent.beacon.core.d.i.a().a("102", "[event] eventName: " + str + ", key: " + str2 + " should be ASCII code in 32-126!");
                }
            } else {
                java.lang.String strTrim = str2.trim();
                if (length > 64) {
                    strTrim = strTrim.substring(0, 64);
                    if (str != null) {
                        com.tencent.beacon.core.d.i.a().a("102", "[event] eventName: " + str + ", key: " + str2 + " should be less than 64!");
                    }
                }
                sb.append("&");
                sb.append(strTrim.replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
                sb.append("=");
                java.lang.String str3 = (java.lang.String) map.get(str2);
                if (str3 != null) {
                    java.lang.String strTrim2 = str3.trim();
                    if (strTrim2.length() > 10240) {
                        sb2.append(str2);
                        sb2.append(",");
                        strTrim2 = strTrim2.substring(0, 10240);
                    }
                    sb.append(strTrim2.replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
                }
            }
        }
        if (!sb2.toString().isEmpty()) {
            java.lang.String str4 = "[event] eventName: " + str + ", key: " + sb2.toString() + "'s value > 10K.";
            com.tencent.beacon.core.d.i.a().a("103", str4);
            com.tencent.beacon.core.e.i.a(str4);
        }
        java.lang.String strSubstring = sb.length() > 0 ? sb.substring(1) : "";
        sb.setLength(0);
        return strSubstring;
    }

    public static java.lang.String c(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return "DefaultPageID";
        }
        return str.length() > 50 ? str.substring(0, 50) : str;
    }

    public static java.lang.String d(java.lang.String str) {
        java.lang.String strTrim = str.replace('|', '_').trim();
        if (e(strTrim)) {
            if (strTrim.length() < 5) {
                com.tencent.beacon.core.e.d.i("[core] userID length should < 5!", new java.lang.Object[0]);
            }
            return strTrim.length() > 128 ? strTrim.substring(0, 128) : strTrim;
        }
        com.tencent.beacon.core.e.d.i("[core] userID should be ASCII code in 32-126! userID:" + str, new java.lang.Object[0]);
        return "10000";
    }

    public static boolean e(java.lang.String str) {
        int length = str.length();
        boolean z = true;
        while (true) {
            length--;
            if (length < 0) {
                return z;
            }
            char cCharAt = str.charAt(length);
            if (cCharAt < ' ' || cCharAt >= 127) {
                z = false;
            }
        }
    }
}
