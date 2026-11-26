package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class q {
    public static long a(android.content.Context context) {
        return 2592000000L;
    }

    private static long a(android.content.Context context, java.lang.String str) {
        return context.getApplicationContext().getSharedPreferences("com.qq.gdt.action.SessionTimePref", 0).getLong(str, 0L);
    }

    private static java.lang.String a() {
        return "com.qq.gdt.action.SessionTimePref_" + com.qq.gdt.action.h.r.a(com.qq.gdt.action.e.a().k());
    }

    public static void a(android.content.Context context, long j) {
        android.content.SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(a(), 0).edit();
        editorEdit.putLong("SessionStartTimeV1", j);
        editorEdit.apply();
    }

    public static void a(android.content.Context context, long j, long j2) {
        android.content.SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(a(), 0).edit();
        editorEdit.putLong("AppStartTime", j);
        if (j2 > 0) {
            editorEdit.putLong("AppStartTimeRevised", j2);
        }
        editorEdit.apply();
    }

    public static void a(android.content.Context context, boolean z, long j, long j2) {
        android.content.SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(a(), 0).edit();
        editorEdit.putLong("ActivateTime", j);
        editorEdit.putBoolean("ActivateWithImei", z);
        if (j2 > 0) {
            editorEdit.putLong("ActivateTimeRevised", j2);
        }
        editorEdit.apply();
    }

    public static long b(android.content.Context context) {
        return context.getApplicationContext().getSharedPreferences(a(), 0).getLong("ActivateTime", -1L);
    }

    public static void b(android.content.Context context, long j) {
        android.content.SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(a(), 0).edit();
        editorEdit.putLong("SessionEndTimeV1", j);
        editorEdit.apply();
    }

    public static boolean c(android.content.Context context) {
        return context.getApplicationContext().getSharedPreferences(a(), 0).getBoolean("ActivateWithImei", false);
    }

    public static long d(android.content.Context context) {
        return context.getApplicationContext().getSharedPreferences(a(), 0).getLong("ActivateTimeRevised", -1L);
    }

    public static long e(android.content.Context context) {
        return context.getApplicationContext().getSharedPreferences(a(), 0).getLong("AppStartTime", -1L);
    }

    public static long f(android.content.Context context) {
        return context.getApplicationContext().getSharedPreferences(a(), 0).getLong("AppStartTimeRevised", -1L);
    }

    public static synchronized void g(android.content.Context context) {
        try {
            android.content.SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a(), 0);
            if (sharedPreferences.getInt(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION, 0) == 0) {
                long jA = a(context, "SessionStartTime");
                long jA2 = a(context, "ActivateTime");
                android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putInt(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION, 1);
                if (jA > 0) {
                    editorEdit.putLong("AppStartTime", jA);
                    if (jA2 <= 0) {
                        editorEdit.putLong("ActivateTime", jA);
                    }
                    editorEdit.putBoolean("ActivateWithImei", true);
                }
                editorEdit.apply();
            }
        } catch (java.lang.Throwable unused) {
            com.qq.gdt.action.h.l.c("Exception while upgrade preference");
        }
    }
}
