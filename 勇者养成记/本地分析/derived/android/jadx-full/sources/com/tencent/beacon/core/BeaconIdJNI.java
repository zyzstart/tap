package com.tencent.beacon.core;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class BeaconIdJNI {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized java.lang.String a(android.content.Context context, int i) {
        java.lang.String str;
        try {
            if (!com.tencent.beacon.core.d.k.a(context).f() || !com.tencent.beacon.upload.UploadStrategy.DEFAULT_BEACON_ID_ENABLE) {
                return "";
            }
            java.lang.String[] strArrC = null;
            try {
                try {
                    a();
                    strArrC = c(i);
                } catch (java.lang.Throwable unused) {
                    com.tencent.beacon.core.e.d.b("[beaconId] libBeacon.so load failed!", new java.lang.Object[0]);
                }
            } catch (java.lang.UnsatisfiedLinkError unused2) {
                a();
                strArrC = c(i);
            } catch (java.lang.Throwable th) {
                com.tencent.beacon.core.e.d.b("[beaconId] libBeacon.so load failed!", new java.lang.Object[0]);
                com.tencent.beacon.core.d.i.a(context).a("501", "[beaconId] jni load so fail!", th);
            }
            if (strArrC == null) {
                com.tencent.beacon.core.d.i.a(context).a("500", "[beaconId] jni execute error! ");
                return "";
            }
            com.tencent.beacon.core.e.j.a(strArrC);
            for (int i2 = 0; i2 < strArrC.length; i2++) {
                strArrC[i2] = com.tencent.beacon.core.e.j.a(strArrC[i2]);
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i3 = 0;
            while (i3 < strArrC.length) {
                int i4 = i3 + 1;
                if (i4 == 10) {
                    sb.append("k10:");
                    sb.append(1);
                    sb.append(";");
                    sb.append("k11:");
                    sb.append(strArrC[i3]);
                    str = ";";
                } else if (i4 > 10) {
                    sb.append("k");
                    sb.append(i3 + 2);
                    sb.append(":");
                    sb.append(strArrC[i3]);
                    str = ";";
                } else {
                    sb.append("k");
                    sb.append(i4);
                    sb.append(":");
                    sb.append(strArrC[i3]);
                    str = ";";
                }
                sb.append(str);
                i3 = i4;
            }
            java.lang.String strSubstring = sb.substring(0, sb.length() - 1);
            if (!strSubstring.contains("k10")) {
                strSubstring = strSubstring + ";k10:1";
            }
            com.tencent.beacon.core.e.d.a("[BeaconId] %s", strSubstring);
            return strSubstring;
        } catch (java.lang.Throwable th2) {
            throw th2;
        }
    }

    @android.annotation.SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private static void a() {
        try {
            java.lang.System.loadLibrary("Qimei");
        } catch (java.lang.Throwable unused) {
            com.tencent.beacon.core.e.d.b("[beaconId] no libQimei.so!", new java.lang.Object[0]);
            java.lang.System.loadLibrary("Beacon");
        }
    }

    public static native java.lang.String[] c(int i);
}
