package com.tencent.tmselfupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class p {
    public static void a(int i) {
        java.lang.String str = (java.lang.System.currentTimeMillis() / 1000) + "|50801|com.tencent.android.qqdownloader|";
        com.tencent.tmassistantbase.util.TMLog.d("TMSelfUpdateReportUtil", "test0629 installTest type=" + i + ",yybInstallReport.data: " + str);
        com.tencent.tmassistantbase.c.b.b().a(i, str);
    }

    public static void a(int i, int i2, int i3) {
        java.lang.String str;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() / 1000;
        java.lang.String strB = com.tencent.tmassistantbase.util.k.b(com.tencent.tmassistantbase.util.k.a().b());
        if (i3 != 0 || i == 6) {
            str = jCurrentTimeMillis + "||" + strB + "|" + i2 + "|" + i3 + "|";
        } else {
            str = jCurrentTimeMillis + "||" + strB + "|" + i2 + "|";
        }
        com.tencent.tmassistantbase.util.TMLog.d("TMSelfUpdateReportUtil", "test0629 type=" + i + ", status=" + i2 + ",yybInstallReport.data: " + str);
        com.tencent.tmassistantbase.c.b.b().a(i, str);
    }

    public static void a(int i, int i2, java.lang.String str) {
        java.lang.StringBuilder sb;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() / 1000;
        if (i != 6) {
            sb = new java.lang.StringBuilder();
            sb.append(jCurrentTimeMillis);
            sb.append("|");
            sb.append("50801");
            sb.append("|");
            sb.append(str);
            sb.append("|");
            sb.append(i2);
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(jCurrentTimeMillis);
            sb.append("|");
            sb.append("50801");
            sb.append("|");
            sb.append(str);
            sb.append("|");
            sb.append(i2);
            sb.append("|");
            sb.append(0);
        }
        sb.append("|");
        java.lang.String string = sb.toString();
        com.tencent.tmassistantbase.util.TMLog.d("TMSelfUpdateReportUtil", "test0629 type=" + i + ", status=" + i2 + ",yybInstallReport.data: " + string);
        com.tencent.tmassistantbase.c.b.b().a(i, string);
    }

    public static void a(int i, java.lang.String... strArr) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() / 1000;
        java.lang.String strB = com.tencent.tmassistantbase.util.k.b(com.tencent.tmassistantbase.util.k.a().b());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(jCurrentTimeMillis);
        sb.append("|");
        sb.append("");
        sb.append("|");
        sb.append(strB);
        sb.append("|");
        if (strArr != null && strArr.length > 0) {
            for (java.lang.String str : strArr) {
                sb.append(str);
                sb.append("|");
            }
        }
        java.lang.String string = sb.toString();
        com.tencent.tmassistantbase.util.TMLog.d("TMSelfUpdateReportUtil", "type=" + i + ",data = " + string);
        com.tencent.tmassistantbase.c.b.b().a(i, string);
    }
}
