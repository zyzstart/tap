package com.tencent.ydkbeacon.a.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {
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
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return java.nio.charset.Charset.forName("ISO-8859-1").newEncoder().canEncode(str);
        } catch (java.lang.Exception e) {
            com.tencent.ydkbeacon.a.e.c.a(e);
            return false;
        }
    }
}
