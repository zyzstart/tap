package com.tencent.mm.opensdk.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d {
    public static boolean b(java.lang.String str) {
        return str == null || str.length() <= 0;
    }

    public static int c(java.lang.String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    return java.lang.Integer.parseInt(str);
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return 0;
    }
}
