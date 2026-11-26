package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class s {
    public static boolean a() {
        for (java.lang.StackTraceElement stackTraceElement : new java.lang.Throwable().getStackTrace()) {
            if (stackTraceElement.getClassName().equals("android.app.Instrumentation") && stackTraceElement.getMethodName().equals("callApplicationOnCreate")) {
                return true;
            }
        }
        return false;
    }
}
