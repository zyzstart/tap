package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f918a = 5;
    static int b = 16;
    static char[] c = new char[16];
    static java.lang.String d = "dex2oat-cmdline";
    static long e = 4096;

    public static java.lang.String a(android.content.Context context, java.lang.String str) throws java.io.IOException {
        com.tencent.smtt.utils.c cVar = new com.tencent.smtt.utils.c(str);
        cVar.a(c);
        cVar.a(c[f918a] == 1);
        cVar.a(e);
        return a(new java.lang.String(a(cVar)));
    }

    private static java.lang.String a(java.lang.String str) {
        java.lang.String[] strArrSplit = str.split(new java.lang.String("\u0000"));
        int i = 0;
        while (i < strArrSplit.length) {
            int i2 = i + 1;
            java.lang.String str2 = strArrSplit[i];
            int i3 = i2 + 1;
            java.lang.String str3 = strArrSplit[i2];
            if (str2.equals(d)) {
                return str3;
            }
            i = i3;
        }
        return "";
    }

    public static char[] a(com.tencent.smtt.utils.c cVar) throws java.io.IOException {
        char[] cArr = new char[4];
        char[] cArr2 = new char[4];
        cVar.a(cArr);
        if (cArr[0] != 'o' || cArr[1] != 'a' || cArr[2] != 't') {
            throw new java.util.UnknownFormatConversionException(java.lang.String.format("Invalid art magic %c%c%c", java.lang.Character.valueOf(cArr[0]), java.lang.Character.valueOf(cArr[1]), java.lang.Character.valueOf(cArr[2])));
        }
        cVar.a(cArr2);
        cVar.b();
        cVar.b();
        cVar.b();
        cVar.b();
        cVar.b();
        cVar.b();
        cVar.b();
        cVar.b();
        if (cArr2[1] <= '4') {
            cVar.b();
            cVar.b();
            cVar.b();
        }
        cVar.b();
        cVar.b();
        cVar.b();
        cVar.b();
        cVar.b();
        cVar.b();
        cVar.b();
        char[] cArr3 = new char[cVar.b()];
        cVar.a(cArr3);
        return cArr3;
    }
}
