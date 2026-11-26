package com.tencent.ydkbeacon.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1202a = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized java.lang.String a(int i) {
        java.lang.String[] strArrC;
        java.lang.String str;
        if (!com.tencent.ydkbeacon.d.b.a().e()) {
            return "";
        }
        try {
            try {
                strArrC = com.tencent.ydkqmsp.sdk.u.U.c(i);
            } catch (java.lang.Throwable unused) {
                strArrC = com.tencent.ydkqmsp.sdk.u.U.c(i);
            }
        } catch (java.lang.Throwable th) {
            java.lang.String strG = com.tencent.ydkbeacon.a.c.f.p().g();
            if (!f1202a) {
                com.tencent.ydkbeacon.a.b.d.b().a("501", "[beaconId] get bid from qmsp fail! cpuInfo: " + strG, th);
                f1202a = true;
            }
            com.tencent.ydkbeacon.a.e.c.b("[beaconId] get bid from qmsp fail! cpuInfo: " + strG, new java.lang.Object[0]);
            com.tencent.ydkbeacon.a.e.c.a(th);
            strArrC = null;
        }
        if (strArrC == null) {
            if (!f1202a) {
                com.tencent.ydkbeacon.a.b.d.b().a("501", "[beaconId] jni execute error or load so fail!");
                f1202a = true;
            }
            return "";
        }
        com.tencent.ydkbeacon.a.e.f.a(strArrC);
        for (int i2 = 0; i2 < strArrC.length; i2++) {
            strArrC[i2] = com.tencent.ydkbeacon.a.e.f.a(strArrC[i2]);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i3 = 0; i3 < strArrC.length; i3++) {
            if (i3 >= 9) {
                sb.append("k");
                sb.append(i3 + 2);
                sb.append(":");
                sb.append(strArrC[i3]);
                str = ";";
            } else {
                sb.append("k");
                sb.append(i3 + 1);
                sb.append(":");
                sb.append(strArrC[i3]);
                str = ";";
            }
            sb.append(str);
        }
        sb.append("k10:");
        sb.append(1);
        com.tencent.ydkbeacon.a.e.c.a("[BeaconId] %s", sb);
        return sb.toString();
    }
}
