package com.tencent.yybsdk.apkpatch.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.yybsdk.apkpatch.d.f f1408a;
    private static int b;
    private java.util.concurrent.ConcurrentHashMap c = new java.util.concurrent.ConcurrentHashMap();

    private f() {
    }

    private int a(java.lang.String str) {
        if (str.contains("patch32")) {
            return 32;
        }
        if (str.contains("patch64")) {
            return 64;
        }
        return str.contains("patch") ? 2 : -1;
    }

    public static com.tencent.yybsdk.apkpatch.d.f a() {
        if (f1408a == null) {
            f1408a = new com.tencent.yybsdk.apkpatch.d.f();
        }
        return f1408a;
    }

    private synchronized java.lang.String b() {
        java.lang.StringBuilder sb;
        sb = new java.lang.StringBuilder();
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        sb.append(com.tencent.yybsdk.apkpatch.p.f);
        sb.append("_");
        sb.append(jCurrentTimeMillis);
        sb.append("-");
        int i = b;
        b = i + 1;
        sb.append(i);
        return sb.toString();
    }

    private java.util.HashMap b(com.tencent.yybsdk.apkpatch.d.h hVar) throws java.lang.Throwable {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put("B1", hVar.f1410a);
        linkedHashMap.put("B2", com.tencent.yybsdk.apkpatch.p.d + "");
        if (!android.text.TextUtils.isEmpty(com.tencent.yybsdk.apkpatch.p.e)) {
            try {
                linkedHashMap.put("B3", java.net.URLEncoder.encode(com.tencent.yybsdk.apkpatch.p.e, "UTF-8"));
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        linkedHashMap.put("B4", "v1.8.5");
        if (!android.text.TextUtils.isEmpty(com.tencent.yybsdk.apkpatch.f.c.a().e())) {
            try {
                linkedHashMap.put("B5", java.net.URLEncoder.encode(com.tencent.yybsdk.apkpatch.f.c.a().e(), "UTF-8"));
            } catch (java.io.UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        linkedHashMap.put("B6", hVar.b);
        linkedHashMap.put("B7", "" + hVar.c);
        linkedHashMap.put("B8", "" + hVar.d);
        linkedHashMap.put("B9", "" + hVar.e);
        linkedHashMap.put("B10", hVar.f);
        linkedHashMap.put("B11", "" + hVar.g);
        linkedHashMap.put("B12", hVar.h);
        linkedHashMap.put("B13", "" + hVar.u);
        linkedHashMap.put("B14", "" + hVar.v);
        linkedHashMap.put("B15", "" + hVar.w);
        linkedHashMap.put("B16", "" + hVar.x);
        linkedHashMap.put("B17", "" + hVar.z);
        linkedHashMap.put("B18", "" + hVar.A);
        linkedHashMap.put("B19", "" + hVar.B);
        linkedHashMap.put("B20", "" + hVar.C);
        linkedHashMap.put("B21", "" + hVar.D);
        linkedHashMap.put("B22", "" + hVar.E);
        linkedHashMap.put("B23", "" + hVar.F);
        linkedHashMap.put("B24", "" + hVar.G);
        linkedHashMap.put("B25", "" + hVar.I);
        java.lang.String strEncode = "";
        if (!android.text.TextUtils.isEmpty(hVar.J)) {
            try {
                strEncode = java.net.URLEncoder.encode(hVar.J, "UTF-8");
                if (strEncode.length() > 1000) {
                    strEncode = strEncode.substring(0, 1000);
                }
                linkedHashMap.put("B26", strEncode);
            } catch (java.io.UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
        }
        if (hVar.K == -1) {
            hVar.K = a(hVar.y);
        }
        linkedHashMap.put("B27", hVar.K + "");
        linkedHashMap.put("B29", com.tencent.yybsdk.apkpatch.f.c.a().b() + "");
        linkedHashMap.put("B31", hVar.H + "");
        linkedHashMap.put("B32", hVar.M);
        if (!android.text.TextUtils.isEmpty(com.tencent.yybsdk.apkpatch.p.f)) {
            try {
                linkedHashMap.put("B33", java.net.URLEncoder.encode(com.tencent.yybsdk.apkpatch.p.f, "UTF-8"));
            } catch (java.io.UnsupportedEncodingException e4) {
                e4.printStackTrace();
            }
        }
        linkedHashMap.put("B34", hVar.i);
        linkedHashMap.put("B37", hVar.y);
        java.lang.String strB = "";
        if (hVar.H == 0) {
            strB = com.tencent.yybsdk.apkpatch.f.e.b(hVar.n);
            if (android.text.TextUtils.isEmpty(strB)) {
                strB = "cutEocdMd5New empty,exists:" + new java.io.File(hVar.n).exists();
            }
            linkedHashMap.put("B38", strB);
            linkedHashMap.put("B46", (hVar.D - hVar.C) + "");
            linkedHashMap.put("B47", (hVar.D - hVar.v) + "");
        }
        linkedHashMap.put("B45", hVar.L);
        linkedHashMap.put("B48", hVar.j);
        if (hVar.H == 0) {
            linkedHashMap.put("B49", hVar.j.equals(strB) ? "1" : "0");
        }
        if (hVar.K == 64) {
            linkedHashMap.put("B50", hVar.u + "," + hVar.P + "," + hVar.S + "," + hVar.Q + "," + hVar.R + "," + hVar.T + "," + hVar.U);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(android.os.Build.HARDWARE);
            sb.append(",");
            sb.append(com.tencent.yybsdk.apkpatch.f.a.b.m);
            sb.append(",");
            sb.append(com.tencent.yybsdk.apkpatch.f.a.b.n);
            sb.append(",");
            sb.append(com.tencent.yybsdk.apkpatch.f.a.b.o);
            linkedHashMap.put("B51", sb.toString());
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(com.tencent.yybsdk.apkpatch.f.a.b.p);
            sb2.append("");
            linkedHashMap.put("B52", sb2.toString());
            linkedHashMap.put("B54", hVar.V + "");
            linkedHashMap.put("B55", hVar.O + "");
            linkedHashMap.put("B56", hVar.q + "," + hVar.t + "," + hVar.r + "," + hVar.s);
        }
        linkedHashMap.put("B53", hVar.N + "");
        linkedHashMap.put("B57", com.tencent.yybsdk.apkpatch.f.c.a().d());
        if (hVar.I < 0) {
            linkedHashMap.put("B58", com.tencent.yybsdk.apkpatch.f.d.a(hVar.m));
        }
        com.tencent.yybsdk.apkpatch.f.a.a("StatisticsManager", linkedHashMap.toString());
        com.tencent.yybsdk.apkpatch.f.a.a("TMUpdateSDKTaskInfo", "apkupdate.log", "ApkPatchLog :\n {mPackageName:" + hVar.b + ",\n mAlgorithm:" + hVar.K + ",\n mDownloadStartTime:" + new java.util.Date(hVar.u) + ",\n mDownloadEndTime:" + new java.util.Date(hVar.v) + ",\n mStartTime:" + new java.util.Date(hVar.C) + ",\n mEndTime:" + new java.util.Date(hVar.D) + ",\n costTime:" + (hVar.D - hVar.C) + ",\n feelTime:" + (hVar.D - hVar.v) + ",\n SeverApkCutEocdMd5:" + hVar.j + ",\n PatchApkCutEocdMd5:" + strB + ",\n MD5Check:" + hVar.j.equals(strB) + ",\n url:" + hVar.y + ",\n mErrorCode:" + hVar.I + ",\n mResultCode:" + hVar.H + ",\n encodeMsg:" + strEncode + ",}");
        return linkedHashMap;
    }

    public com.tencent.yybsdk.apkpatch.d.h a(com.tencent.yybsdk.apkpatch.d.g gVar) {
        com.tencent.yybsdk.apkpatch.d.h hVar = new com.tencent.yybsdk.apkpatch.d.h();
        if (gVar != null) {
            hVar.f1410a = gVar.f1409a;
            hVar.b = gVar.b;
            hVar.c = gVar.c;
            hVar.d = gVar.d;
            hVar.e = gVar.e;
            hVar.f = gVar.f;
            hVar.g = gVar.g;
            hVar.h = gVar.h;
            hVar.B = gVar.i;
            long j = gVar.j;
            hVar.A = j;
            hVar.w = j;
            hVar.M = gVar.k;
            hVar.i = gVar.l;
            hVar.y = gVar.m;
            hVar.L = gVar.n;
        } else {
            hVar.f1410a = b();
        }
        this.c.put(hVar.f1410a, hVar);
        return hVar;
    }

    public void a(com.tencent.yybsdk.apkpatch.d.h hVar) {
        if (hVar != null) {
            try {
                java.lang.Class.forName("com.tencent.beacon.event.UserAction").getDeclaredMethod("onUserAction", java.lang.String.class, java.lang.Boolean.TYPE, java.lang.Long.TYPE, java.lang.Long.TYPE, java.util.Map.class, java.lang.Boolean.TYPE).invoke(null, "TMUpdateSDKTaskInfo", java.lang.Boolean.TRUE, 0, 0, b(hVar), java.lang.Boolean.valueOf(hVar.H == 0));
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            this.c.remove(hVar.f1410a);
        }
    }
}
