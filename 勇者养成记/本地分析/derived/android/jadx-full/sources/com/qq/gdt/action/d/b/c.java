package com.qq.gdt.action.d.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.qq.gdt.action.d.b.d f88a;
    private java.util.List<com.qq.gdt.action.d.b.a.b> b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.qq.gdt.action.d.b.d f89a = new com.qq.gdt.action.d.b.d();
        private final java.util.List<com.qq.gdt.action.d.b.a.b> b = new java.util.ArrayList();

        public com.qq.gdt.action.d.b.c.a a(com.qq.gdt.action.d.b.a.b bVar) {
            if (bVar == null) {
                com.qq.gdt.action.h.l.b("interceptor == null");
                return this;
            }
            this.b.add(bVar);
            return this;
        }

        public com.qq.gdt.action.d.b.c a() {
            return new com.qq.gdt.action.d.b.c(this);
        }
    }

    c(com.qq.gdt.action.d.b.c.a aVar) {
        this.b = new java.util.ArrayList();
        this.f88a = aVar.f89a;
        this.b = com.qq.gdt.action.d.b.k.a(aVar.b);
    }

    public com.qq.gdt.action.d.b.a a(com.qq.gdt.action.d.b.g gVar) {
        return new com.qq.gdt.action.d.b.a(new com.qq.gdt.action.d.b.e(this.f88a), gVar, this);
    }

    public java.util.List<com.qq.gdt.action.d.b.a.b> a() {
        return this.b;
    }
}
