package com.tencent.beacon.core.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.beacon.core.e.g f159a;
    protected boolean b;

    protected g() {
        this.b = c() || b() || a();
    }

    public static boolean a() {
        java.util.ArrayList<java.lang.String> arrayListF = f();
        if (arrayListF == null || arrayListF.size() <= 0) {
            com.tencent.beacon.core.e.d.a("[core] no response}", new java.lang.Object[0]);
            return false;
        }
        for (java.lang.String str : arrayListF) {
            com.tencent.beacon.core.e.d.a(str, new java.lang.Object[0]);
            if (str.contains("not found")) {
                return false;
            }
        }
        com.tencent.beacon.core.e.d.a("[core] sufile}", new java.lang.Object[0]);
        return true;
    }

    public static boolean b() {
        try {
            if (new java.io.File("/system/app/Superuser.apk").exists()) {
                com.tencent.beacon.core.e.d.a("[core] super_apk}", new java.lang.Object[0]);
                return true;
            }
        } catch (java.lang.Exception unused) {
        }
        return false;
    }

    public static boolean c() {
        java.lang.String str = android.os.Build.TAGS;
        if (str == null || !str.contains("test-keys")) {
            return false;
        }
        com.tencent.beacon.core.e.d.a("[core] test-keys}", new java.lang.Object[0]);
        return true;
    }

    public static synchronized com.tencent.beacon.core.e.g d() {
        if (f159a == null) {
            f159a = new com.tencent.beacon.core.e.g();
        }
        return f159a;
    }

    private static java.util.ArrayList f() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.lang.Runtime runtime = java.lang.Runtime.getRuntime();
            java.lang.String[] strArr = new java.lang.String[3];
            strArr[0] = "/system/bin/sh";
            strArr[1] = "-c";
            strArr[2] = "type su";
            java.lang.Process processExec = runtime.exec(strArr);
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(processExec.getInputStream(), java.nio.charset.Charset.forName("UTF-8")));
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                arrayList.add(line);
            }
            java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(processExec.getErrorStream(), java.nio.charset.Charset.forName("UTF-8")));
            while (true) {
                java.lang.String line2 = bufferedReader2.readLine();
                if (line2 == null) {
                    return arrayList;
                }
                arrayList.add(line2);
            }
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            return null;
        }
    }

    public synchronized boolean e() {
        return this.b;
    }
}
