package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class y {
    public static final java.lang.String A = "initVPR";
    public static final java.lang.String B = "initNLU";
    public static final java.lang.String C = "collectedInfo";
    public static final java.lang.String D = "start";
    public static final java.lang.String E = "recognition";
    public static final java.lang.String F = "stop";
    public static final java.lang.String G = "cancel";
    public static final java.lang.String H = "getResult";
    public static final java.lang.String I = "error";
    public static final java.lang.String J = "success";
    public static final java.lang.String K = "partial";
    public static final java.lang.String L = "last";
    private static com.unisound.common.ar M = null;
    private static final java.lang.String N = "USCLOG";
    private static java.lang.String O = "";
    private static java.lang.String P = "";
    private static java.lang.StringBuffer Q = new java.lang.StringBuffer();
    private static boolean R = true;
    private static int S = 0;
    private static java.lang.Object T = new java.lang.Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1503a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static boolean k = false;
    public static boolean l = false;
    public static boolean m = false;
    public static boolean n = false;
    public static boolean o = false;
    public static boolean p = false;
    public static boolean q = false;
    public static boolean r = false;
    public static boolean s = false;
    public static boolean t = true;
    public static boolean u = true;
    public static final java.lang.String v = "USC";
    public static final java.lang.String w = "USC_THREAD";
    public static int x = 0;
    public static final java.lang.String y = "init";
    public static final java.lang.String z = "create";

    private static java.lang.String a(long j2) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date(j2));
    }

    public static java.lang.String a(cn.yunzhisheng.asr.JniUscClient jniUscClient) {
        O = jniUscClient.c(54);
        return O;
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i2, java.lang.String str4, android.content.Context context, java.lang.String str5, java.lang.String str6, long j2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.unisound.common.x.f1502a, str);
            jSONObject.put("imei", str2);
            jSONObject.put(com.unisound.common.x.c, str3);
            jSONObject.put(com.unisound.common.x.e, b(j2));
            jSONObject.put("packageName", context.getPackageName());
            jSONObject.put("status", i2);
            jSONObject.put(com.unisound.common.x.h, str4);
            jSONObject.put(com.unisound.common.x.i, str5);
            jSONObject.put(com.unisound.common.x.j, str6);
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static void a() {
        java.lang.StringBuffer stringBuffer = Q;
        stringBuffer.delete(0, stringBuffer.length());
        O = "";
        P = "";
    }

    public static void a(android.content.Context context) {
        if (u) {
            new java.lang.Thread(new com.unisound.common.z(context.getCacheDir().getAbsolutePath() + "/errorlog/")).start();
        }
    }

    public static void a(android.content.Context context, boolean z2, java.lang.String str, java.lang.String str2, int i2, java.lang.String str3) {
        java.lang.String str4;
        if (t) {
            try {
                java.lang.String str5 = context.getCacheDir().getAbsolutePath() + "/javalog";
                java.lang.String str6 = context.getCacheDir().getAbsolutePath() + "/clog";
                java.lang.String str7 = context.getCacheDir().getAbsolutePath() + "/errorlog";
                java.lang.String str8 = context.getCacheDir().getAbsolutePath() + "/errorlog/" + java.lang.System.currentTimeMillis();
                java.lang.String str9 = context.getCacheDir().getAbsolutePath() + "/javalogbk";
                java.lang.String str10 = context.getCacheDir().getAbsolutePath() + "/clogbk";
                java.io.File file = new java.io.File(str5);
                java.io.File file2 = new java.io.File(str6);
                if (file.exists() && file.length() > 1000000) {
                    java.io.File file3 = new java.io.File(str9);
                    if (file3.exists()) {
                        file3.delete();
                    }
                    file.renameTo(file3);
                }
                if (file2.exists() && file2.length() > 1000000) {
                    java.io.File file4 = new java.io.File(str10);
                    if (file4.exists()) {
                        file4.delete();
                    }
                    file.renameTo(file4);
                }
                a(str5, new java.lang.String(Q));
                c(str6, O);
                if (z2) {
                    java.io.File file5 = new java.io.File(str8);
                    if (!file5.getParentFile().exists()) {
                        file5.getParentFile().mkdirs();
                    }
                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                    if (str2.equals("")) {
                        str4 = com.unisound.c.a.q + jCurrentTimeMillis;
                    } else {
                        str4 = str2;
                    }
                    c(str7);
                    c(str8, a(str, com.unisound.c.a.a(str), str4, i2, str3, context, P, O, jCurrentTimeMillis));
                }
            } catch (java.io.IOException e2) {
                a(e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    public static void a(com.unisound.common.ar arVar) {
        M = arVar;
    }

    public static void a(java.lang.String str) {
        android.util.Log.e(v, str);
        b(str);
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        java.io.FileWriter fileWriter = new java.io.FileWriter(str, true);
        new java.io.BufferedWriter(fileWriter);
        fileWriter.write(str2);
        fileWriter.flush();
        fileWriter.close();
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (k) {
            android.util.Log.e(str, str2, th);
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        if (k) {
            java.lang.String str6 = "Time=" + a(java.lang.System.currentTimeMillis());
            if (str != null) {
                str6 = str6 + "&Action=" + str;
            }
            if (str2 != null) {
                str6 = str6 + "&Status=" + str2;
            }
            if (map != null) {
                java.lang.String str7 = "{";
                for (java.lang.String str8 : map.keySet()) {
                    str7 = str7 + str8 + ":" + map.get(str8) + "#";
                }
                str6 = str6 + "&Params=" + (str7 + "}");
            }
            if (str3 != null) {
                str6 = str6 + "&Result=" + str3;
            }
            if (str4 != null) {
                str6 = str6 + "&Errno=" + str4;
            }
            if (str5 != null) {
                str6 = str6 + "&Message=" + str5;
            }
            java.lang.String str9 = str6 + "%";
            P = str9;
            Q.append(str9);
        }
    }

    public static void a(java.lang.String str, java.lang.Throwable th) {
        a(v, str, th);
    }

    public static void a(java.lang.String str, java.lang.String... strArr) {
        if (k) {
            java.lang.String strH = h(strArr);
            android.util.Log.e(str, strH);
            b(strH);
        }
    }

    public static void a(java.lang.Object... objArr) {
        if (k) {
            java.lang.String strH = h(objArr);
            android.util.Log.v(v, strH);
            b(strH);
        }
    }

    private static java.lang.String b(long j2) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date(j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String b(java.io.File file) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (!file.exists()) {
            return null;
        }
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader(file));
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer.append(line);
            }
            bufferedReader.close();
        } catch (java.io.IOException e2) {
            e2.getStackTrace();
        }
        return new java.lang.String(stringBuffer);
    }

    private static void b(java.lang.String str) {
        com.unisound.common.ar arVar = M;
        if (arVar != null) {
            arVar.a(5, 2, str);
        }
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        java.io.FileWriter fileWriter = new java.io.FileWriter(str, true);
        new java.io.BufferedWriter(fileWriter);
        fileWriter.write(str2);
        fileWriter.flush();
        fileWriter.close();
    }

    public static void b(java.lang.Object... objArr) {
        if (k) {
            java.lang.String strH = h(objArr);
            android.util.Log.i(v, strH);
            b(strH);
        }
    }

    private static void c(java.lang.String str) {
        java.io.File[] fileArrListFiles = new java.io.File(str).listFiles();
        if (fileArrListFiles.length >= 10) {
            if (fileArrListFiles.length >= 10) {
                for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                    int i3 = 0;
                    while (i3 < fileArrListFiles.length - 1) {
                        int i4 = i3 + 1;
                        if (fileArrListFiles[i3].lastModified() > fileArrListFiles[i4].lastModified()) {
                            java.io.File file = fileArrListFiles[i3];
                            fileArrListFiles[i3] = fileArrListFiles[i4];
                            fileArrListFiles[i4] = file;
                        }
                        i3 = i4;
                    }
                }
            }
            if (fileArrListFiles[0].exists()) {
                fileArrListFiles[0].delete();
            }
            c(str);
        }
    }

    public static void c(java.lang.String str, java.lang.String str2) {
        java.io.FileWriter fileWriter = new java.io.FileWriter(str, true);
        new java.io.BufferedWriter(fileWriter);
        fileWriter.write(str2);
        fileWriter.flush();
        fileWriter.close();
    }

    public static void c(java.lang.Object... objArr) {
        if (k) {
            java.lang.String strH = h(objArr);
            android.util.Log.d(v, strH);
            b(strH);
        }
    }

    static /* synthetic */ int d() {
        int i2 = S;
        S = i2 + 1;
        return i2;
    }

    public static void d(java.lang.Object... objArr) {
        if (l) {
            android.util.Log.d(w, h(objArr));
        }
    }

    public static void e(java.lang.Object... objArr) {
        if (k) {
            java.lang.String strH = h(objArr);
            android.util.Log.w(v, strH);
            b(strH);
        }
    }

    public static void f(java.lang.Object... objArr) {
        if (m) {
            java.lang.String strH = h(objArr);
            android.util.Log.d("USC_TIME_TRACE", strH + ": " + a(java.lang.System.currentTimeMillis()));
            b(strH);
        }
    }

    public static void g(java.lang.Object... objArr) {
        if (n) {
            java.lang.String strH = h(objArr);
            android.util.Log.e(v, strH);
            b(strH);
        }
    }

    private static java.lang.String h(java.lang.Object... objArr) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.lang.Object obj : objArr) {
                if (!android.text.TextUtils.isEmpty(java.lang.String.valueOf(obj))) {
                    sb.append(obj);
                }
            }
            return sb.toString();
        } catch (java.lang.Exception unused) {
            android.util.Log.e(v, "getLog error");
            return "getLog error";
        }
    }
}
