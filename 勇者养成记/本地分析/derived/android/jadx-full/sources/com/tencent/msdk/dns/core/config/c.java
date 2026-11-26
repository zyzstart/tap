package com.tencent.msdk.dns.core.config;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class c {
    static java.lang.String a(boolean z, java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return "";
        }
        java.util.Locale locale = java.util.Locale.US;
        java.lang.Object[] objArr = new java.lang.Object[5];
        objArr[0] = z ? "119.29.29.29" : "182.254.116.117";
        objArr[1] = str;
        objArr[2] = "1";
        objArr[3] = "1";
        objArr[4] = str2;
        return java.lang.String.format(locale, "http://%s/d?[REDACTED]", objArr);
    }

    static java.lang.String b(boolean z, java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return "";
        }
        java.util.Locale locale = java.util.Locale.US;
        java.lang.Object[] objArr = new java.lang.Object[5];
        objArr[0] = z ? "119.29.29.29" : "182.254.116.117";
        objArr[1] = str;
        objArr[2] = "1";
        objArr[3] = "1";
        objArr[4] = str2;
        return java.lang.String.format(locale, "http://%s/d?[REDACTED]", objArr);
    }
}
