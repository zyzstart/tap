package com.tencent.ydkbeacon.a.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1199a = false;
    public static boolean b = true;

    private c() {
    }

    private static int a(java.lang.StackTraceElement[] stackTraceElementArr, java.lang.Class cls) {
        for (int i = 5; i < stackTraceElementArr.length; i++) {
            java.lang.String className = stackTraceElementArr[i].getClassName();
            if (!(cls.equals(android.util.Log.class) && i < stackTraceElementArr.length - 1 && stackTraceElementArr[i + 1].getClassName().equals(android.util.Log.class.getName())) && className.equals(cls.getName())) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void a(java.lang.String str, int i, java.lang.String str2, java.lang.Object... objArr) {
        if (c()) {
            android.util.Log.d("beacon", c(str + " step: " + i + ". " + str2, objArr));
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (c()) {
            android.util.Log.d("beacon", c(str + " " + str2, objArr));
        }
    }

    public static void a(java.lang.String str, java.lang.Object... objArr) {
        if (c()) {
            android.util.Log.d("beacon", c(str, objArr));
        }
    }

    public static void a(java.lang.Throwable th) {
        if (th != null) {
            if (c()) {
                th.printStackTrace();
            } else {
                b(th.getMessage(), new java.lang.Object[0]);
            }
        }
    }

    public static synchronized void a(boolean z) {
        android.util.Log.i("beacon", "beacon logAble: " + z);
        f1199a = z;
    }

    public static synchronized boolean a() {
        return f1199a;
    }

    public static void b(java.lang.String str, java.lang.Object... objArr) {
        if (c()) {
            android.util.Log.e("beacon", c(str, objArr));
        }
    }

    public static synchronized void b(boolean z) {
        b = z;
    }

    public static synchronized boolean b() {
        return b;
    }

    public static java.lang.String c(java.lang.String str, java.lang.Object... objArr) {
        java.lang.String strE = e();
        if (str == null) {
            return strE + "msg is null";
        }
        if (objArr == null || objArr.length == 0) {
            return strE + str;
        }
        return strE + java.lang.String.format(java.util.Locale.US, str, objArr);
    }

    private static boolean c() {
        return a();
    }

    private static java.lang.StackTraceElement d() {
        java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
        int iA = a(stackTrace, com.tencent.ydkbeacon.a.e.c.class);
        if (iA == -1 && (iA = a(stackTrace, android.util.Log.class)) == -1) {
            return null;
        }
        return stackTrace[iA];
    }

    public static void d(java.lang.String str, java.lang.Object... objArr) {
        if (c()) {
            android.util.Log.i("beacon", c(str, objArr));
        }
    }

    private static java.lang.String e() {
        java.lang.StackTraceElement stackTraceElementD;
        if (!b() || (stackTraceElementD = d()) == null) {
            return "";
        }
        java.lang.String fileName = stackTraceElementD.getFileName();
        if (fileName == null) {
            fileName = "";
        }
        java.lang.String methodName = stackTraceElementD.getMethodName();
        if (methodName.contains("$")) {
            methodName = methodName.substring(methodName.indexOf("$") + 1, methodName.lastIndexOf("$") - 2);
        }
        return "(" + fileName + ":" + stackTraceElementD.getLineNumber() + ")" + methodName + " ";
    }

    public static void e(java.lang.String str, java.lang.Object... objArr) {
        if (c()) {
            android.util.Log.w("beacon", c(str, objArr));
        }
    }
}
