package com.tencent.beacon.core.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f158a = false;
    private static boolean b = false;
    public static boolean c = false;

    private static int a(java.lang.StackTraceElement[] stackTraceElementArr, java.lang.Class cls) {
        for (int i = 5; i < stackTraceElementArr.length; i++) {
            java.lang.String className = stackTraceElementArr[i].getClassName();
            if (!(cls.equals(android.util.Log.class) && i < stackTraceElementArr.length - 1 && stackTraceElementArr[i + 1].getClassName().equals(android.util.Log.class.getName())) && className.equals(cls.getName())) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void a(java.lang.String str, java.lang.Object... objArr) {
        if (d()) {
            android.util.Log.d("beacon", c(str, objArr));
        }
    }

    public static void a(java.lang.Throwable th) {
        if (th != null) {
            if (d()) {
                th.printStackTrace();
            } else {
                b(th.getMessage(), new java.lang.Object[0]);
            }
        }
    }

    public static synchronized void a(boolean z) {
        b = z;
    }

    public static synchronized boolean a() {
        return b;
    }

    public static void b(java.lang.String str, java.lang.Object... objArr) {
        if (d()) {
            android.util.Log.e("beacon", c(str, objArr));
        }
    }

    public static synchronized void b(boolean z) {
        f158a = z;
    }

    public static synchronized boolean b() {
        return f158a;
    }

    protected static java.lang.String c(java.lang.String str, java.lang.Object... objArr) {
        java.lang.String strF = f();
        if (str == null) {
            return strF + "msg is null";
        }
        if (objArr == null || objArr.length == 0) {
            return strF + str;
        }
        return strF + java.lang.String.format(java.util.Locale.US, str, objArr);
    }

    public static synchronized void c(boolean z) {
        c = z;
    }

    public static synchronized boolean c() {
        return c;
    }

    public static void d(java.lang.String str, java.lang.Object... objArr) {
        if (d()) {
            android.util.Log.i("beacon", c(str, objArr));
        }
    }

    private static boolean d() {
        return b();
    }

    private static java.lang.StackTraceElement e() {
        java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
        int iA = a(stackTrace, com.tencent.beacon.core.e.d.class);
        if (iA == -1 && (iA = a(stackTrace, android.util.Log.class)) == -1) {
            return null;
        }
        return stackTrace[iA];
    }

    public static void e(java.lang.String str, java.lang.Object... objArr) {
        if (d()) {
            android.util.Log.d("beacon_step_api", c(str, objArr));
        }
    }

    private static java.lang.String f() {
        java.lang.StackTraceElement stackTraceElementE;
        if (!c() || (stackTraceElementE = e()) == null) {
            return "";
        }
        java.lang.String fileName = stackTraceElementE.getFileName();
        if (fileName == null) {
            fileName = "";
        }
        return "(" + fileName + ":" + stackTraceElementE.getLineNumber() + ")" + stackTraceElementE.getMethodName() + " ";
    }

    public static void f(java.lang.String str, java.lang.Object... objArr) {
        if (d()) {
            android.util.Log.d("beacon_step_buffer", c(str, objArr));
        }
    }

    public static void g(java.lang.String str, java.lang.Object... objArr) {
        if (d()) {
            android.util.Log.d("beacon_step_db", c(str, objArr));
        }
    }

    public static void h(java.lang.String str, java.lang.Object... objArr) {
        if (d()) {
            android.util.Log.d("beacon_step_upload", c(str, objArr));
        }
    }

    public static void i(java.lang.String str, java.lang.Object... objArr) {
        if (d()) {
            android.util.Log.w("beacon", c(str, objArr));
        }
    }
}
