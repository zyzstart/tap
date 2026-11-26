package com.qq.gdt.action.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class d<T extends com.qq.gdt.action.d.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected java.lang.String f102a;
    protected java.util.Map<java.lang.String, java.lang.String> b;
    protected final com.qq.gdt.action.d.b.g.a c = new com.qq.gdt.action.d.b.g.a();

    public T a(java.lang.String str) {
        this.f102a = str;
        return this;
    }

    protected void a() {
        this.c.a("User-Agent", com.qq.gdt.action.h.h.a("GDTActionSDK-[" + java.lang.System.getProperty("http.agent") + "]"));
        java.util.Map<java.lang.String, java.lang.String> map = this.b;
        if (map == null || map.isEmpty()) {
            return;
        }
        for (java.lang.String str : this.b.keySet()) {
            this.c.a(str, this.b.get(str));
        }
    }
}
