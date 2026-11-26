package com.tencent.beacon.core.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class j {
    public static java.lang.String a(java.lang.String str) {
        return str.trim().replace(" ", "").replace("\t", "").replace("&", "").replace(":", "").replace("=", "").replace(";", "");
    }

    public static void a(java.lang.String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == null) {
                strArr[i] = "";
            }
        }
    }

    public static boolean b(java.lang.String str) {
        return str == null || str.equals("");
    }
}
