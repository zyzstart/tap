package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class l {
    public static void a(java.lang.String str) {
        android.util.Log.i("gdt_action", str);
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
    }

    public static void a(java.lang.String str, java.lang.Throwable th) {
        if (th == null) {
            b(str);
        } else {
            android.util.Log.w("gdt_action", str, th);
        }
    }

    public static void a(java.lang.String str, java.lang.Object... objArr) {
    }

    public static void b(java.lang.String str) {
        android.util.Log.w("gdt_action", str);
    }

    public static void b(java.lang.String str, java.lang.Throwable th) {
        if (th == null) {
            c(str);
        } else {
            android.util.Log.e("gdt_action", str, th);
        }
    }

    public static void c(java.lang.String str) {
        android.util.Log.e("gdt_action", str);
    }
}
