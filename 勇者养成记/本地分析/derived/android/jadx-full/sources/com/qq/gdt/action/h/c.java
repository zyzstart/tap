package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {
    private static boolean a(long j, android.content.Context context) {
        if (!com.qq.gdt.action.h.u.a()) {
            return false;
        }
        long jB = com.qq.gdt.action.h.u.b();
        long jD = com.qq.gdt.action.h.q.d(context);
        long jF = com.qq.gdt.action.h.q.f(context);
        long j2 = 0;
        long j3 = (jB <= 0 || jD <= 0) ? 0L : jB - jD;
        if (jB > 0 && jF > 0) {
            j2 = jB - jF;
        }
        return j3 >= j && j2 >= j;
    }

    public static boolean a(android.content.Context context) {
        if (!com.qq.gdt.action.h.q.c(context) && !com.qq.gdt.action.h.t.a(com.qq.gdt.action.h.g.b())) {
            return true;
        }
        long jA = com.qq.gdt.action.h.q.a(context);
        return b(jA, context) || a(jA, context);
    }

    private static boolean b(long j, android.content.Context context) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        return jCurrentTimeMillis - com.qq.gdt.action.h.q.b(context) >= j && jCurrentTimeMillis - com.qq.gdt.action.h.q.e(context) >= j;
    }
}
