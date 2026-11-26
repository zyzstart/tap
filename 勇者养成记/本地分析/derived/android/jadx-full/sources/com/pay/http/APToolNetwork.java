package com.pay.http;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APToolNetwork {
    private static final int BASE_16 = 16;
    private static final int IPV6_MAX_HEX_DIGITS_PER_GROUP = 4;
    private static final int IPV6_MAX_HEX_GROUPS = 8;
    private static final int MAX_UNSIGNED_SHORT = 65535;
    private static final java.util.regex.Pattern PATTERN = java.util.regex.Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    public static boolean isIPAddress(java.lang.String str) {
        return validateIPV4(str) || validateIPV6(str);
    }

    public static java.lang.String joinDomainPort(java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb;
        java.lang.String str3;
        if (android.text.TextUtils.isEmpty(str2)) {
            return str;
        }
        if (validateIPV4(str)) {
            sb = new java.lang.StringBuilder();
            sb.append(str);
            str3 = ":";
        } else {
            if (!validateIPV6(str)) {
                return str;
            }
            sb = new java.lang.StringBuilder();
            sb.append("[");
            sb.append(str);
            str3 = "]:";
        }
        sb.append(str3);
        sb.append(str2);
        return sb.toString();
    }

    public static boolean validateIPV4(java.lang.String str) {
        return android.util.Patterns.IP_ADDRESS.matcher(str).matches();
    }

    public static boolean validateIPV6(java.lang.String str) {
        boolean zContains = str.contains("::");
        if (zContains && str.indexOf("::") != str.lastIndexOf("::")) {
            return false;
        }
        if ((str.startsWith(":") && !str.startsWith("::")) || (str.endsWith(":") && !str.endsWith("::"))) {
            return false;
        }
        java.lang.String[] strArrSplit = str.split(":");
        if (zContains) {
            java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(strArrSplit));
            if (str.endsWith("::")) {
                arrayList.add("");
            } else if (str.startsWith("::") && !arrayList.isEmpty()) {
                arrayList.remove(0);
            }
            strArrSplit = (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
        }
        if (strArrSplit.length > 8) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < strArrSplit.length; i3++) {
            java.lang.String str2 = strArrSplit[i3];
            if (str2.length() == 0) {
                i2++;
                if (i2 > 1) {
                    return false;
                }
            } else {
                if (i3 == strArrSplit.length - 1 && str2.contains(".")) {
                    if (!android.util.Patterns.IP_ADDRESS.matcher(str2).matches()) {
                        return false;
                    }
                    i += 2;
                    i2 = 0;
                } else {
                    if (str2.length() > 4) {
                        return false;
                    }
                    try {
                        int i4 = java.lang.Integer.parseInt(str2, 16);
                        if (i4 < 0 || i4 > 65535) {
                            return false;
                        }
                        i2 = 0;
                    } catch (java.lang.NumberFormatException unused) {
                    }
                }
            }
            i++;
        }
        return i <= 8 && (i >= 8 || zContains);
    }
}
