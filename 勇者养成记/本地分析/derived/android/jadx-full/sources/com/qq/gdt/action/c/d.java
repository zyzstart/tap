package com.qq.gdt.action.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.util.Map<java.lang.String, com.qq.gdt.action.c.h> f76a = new java.util.concurrent.ConcurrentHashMap();

    public static <T extends com.qq.gdt.action.c.a> com.qq.gdt.action.c.h a(java.lang.String str, java.lang.Class<T> cls, boolean z) {
        java.lang.StringBuilder sb;
        java.lang.String str2;
        if (z) {
            sb = new java.lang.StringBuilder();
            sb.append(str);
            str2 = "_c";
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(str);
            str2 = "_n";
        }
        sb.append(str2);
        java.lang.String string = sb.toString();
        com.qq.gdt.action.c.h eVar = f76a.get(string);
        if (eVar == null) {
            synchronized (com.qq.gdt.action.c.d.class) {
                eVar = f76a.get(string);
                if (eVar == null) {
                    try {
                        eVar = z ? new com.qq.gdt.action.c.e(string, cls) : new com.qq.gdt.action.c.h(string, cls);
                        f76a.put(string, eVar);
                    } catch (java.io.IOException e) {
                        com.qq.gdt.action.h.l.b("construct buffer: " + string + " failed !", e);
                    }
                }
            }
        }
        return eVar;
    }
}
