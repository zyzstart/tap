package com.unisound.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class k {
    public static long a(long j) {
        return j / 1000;
    }

    public static java.lang.String a(java.lang.String str) throws java.lang.Exception {
        try {
            return a(java.security.MessageDigest.getInstance("SHA-1").digest(str.getBytes("UTF-8")));
        } catch (java.lang.Exception e) {
            throw e;
        }
    }

    public static java.lang.String a(java.util.List<java.lang.String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        java.util.Collections.sort(list);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str : list) {
            if (str == null) {
                str = "";
            }
            sb.append(str);
        }
        return a(sb.toString());
    }

    private static java.lang.String a(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString.toUpperCase());
        }
        return sb.toString();
    }
}
