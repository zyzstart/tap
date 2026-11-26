package com.tencent.hlyyb.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f518a = "null";
    public static java.lang.String b = "";
    public static int c = 0;
    public static java.lang.String d = "";
    public static java.lang.String e = "";
    public static int f = -1;
    public static volatile boolean g = false;
    public static boolean h = true;
    private static android.content.Context i = null;
    private static java.lang.String j = null;
    private static long k = 0;
    private static int l = 0;
    private static boolean m = false;
    private static java.lang.String n = "";
    private static java.lang.String o = "3.4.2.13";
    private static android.os.Handler p = null;
    private static java.lang.String q = "";
    private static boolean r = false;
    private static java.lang.String s = "";
    private static android.os.Handler t = null;
    private static boolean u = false;

    public static android.content.Context a() {
        return i;
    }

    public static void a(boolean z, int i2, com.tencent.hlyyb.a aVar, java.lang.String str, int i3) {
        u = z;
        k = android.os.SystemClock.elapsedRealtime();
        f = android.os.Process.myPid();
        android.content.Context contextA = aVar.a();
        i = contextA.getApplicationContext();
        n = contextA.getPackageName();
        l = i2;
        m = aVar.d();
        java.lang.String strC = aVar.c();
        if (com.tencent.hlyyb.common.f.c.a(strC)) {
            strC = "";
        }
        d = strC;
        java.lang.String strB = aVar.b();
        if (com.tencent.hlyyb.common.f.c.a(strB)) {
            strB = "";
        }
        e = strB;
        o = "3.4.2.13";
        p = new android.os.Handler(i.getMainLooper());
        try {
            android.content.pm.PackageInfo packageInfo = contextA.getPackageManager().getPackageInfo(contextA.getPackageName(), 0);
            f518a = packageInfo.versionName;
            c = packageInfo.versionCode;
            b = packageInfo.applicationInfo.loadLabel(contextA.getPackageManager()).toString();
        } catch (java.lang.Throwable unused) {
        }
        q = str;
        r = n.equals(str);
        j = com.tencent.hlyyb.common.f.c.f();
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("HalleyTempTaskThread", 10);
        handlerThread.start();
        t = new android.os.Handler(handlerThread.getLooper());
        com.tencent.hlyyb.common.a.f.a();
        com.tencent.hlyyb.common.b bVar = new com.tencent.hlyyb.common.b("after initSDKBaseInfo");
        android.os.Handler handler = t;
        if (handler == null) {
            bVar.run();
        } else {
            try {
                handler.post(bVar);
            } catch (java.lang.Throwable unused2) {
            }
        }
    }

    public static boolean b() {
        return u;
    }

    public static int c() {
        return l;
    }

    public static java.lang.String d() {
        return j;
    }

    public static int e() {
        return (int) (android.os.SystemClock.elapsedRealtime() - k);
    }

    public static java.lang.String f() {
        return n;
    }

    public static boolean g() {
        return m;
    }

    public static java.lang.String h() {
        return o;
    }

    public static android.os.Handler i() {
        return p;
    }

    public static java.lang.String j() {
        if (!com.tencent.hlyyb.common.f.c.a(s)) {
            return s;
        }
        if (com.tencent.hlyyb.common.f.c.a(q) || !q.contains(":")) {
            return "";
        }
        return q.substring(q.indexOf(":") + 1);
    }

    public static android.os.Handler k() {
        return t;
    }
}
