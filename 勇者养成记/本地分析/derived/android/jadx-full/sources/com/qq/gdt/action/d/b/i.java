package com.qq.gdt.action.d.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.qq.gdt.action.d.b.j f97a;
    private final com.qq.gdt.action.d.b.g b;
    private final int c;
    private final java.lang.String d;
    private final java.util.Map<java.lang.String, java.util.List<java.lang.String>> e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.qq.gdt.action.d.b.j f98a;
        private com.qq.gdt.action.d.b.g b;
        private int c;
        private java.lang.String d;
        private java.util.Map<java.lang.String, java.util.List<java.lang.String>> e;

        public com.qq.gdt.action.d.b.i.a a(int i) {
            this.c = i;
            return this;
        }

        public com.qq.gdt.action.d.b.i.a a(com.qq.gdt.action.d.b.g gVar) {
            this.b = gVar;
            return this;
        }

        public com.qq.gdt.action.d.b.i.a a(com.qq.gdt.action.d.b.j jVar) {
            this.f98a = jVar;
            return this;
        }

        public com.qq.gdt.action.d.b.i.a a(java.lang.String str) {
            this.d = str;
            return this;
        }

        public com.qq.gdt.action.d.b.i.a a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
            this.e = map;
            return this;
        }

        public com.qq.gdt.action.d.b.i a() {
            return new com.qq.gdt.action.d.b.i(this);
        }
    }

    i(com.qq.gdt.action.d.b.i.a aVar) {
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f97a = aVar.f98a;
    }

    public com.qq.gdt.action.d.b.g a() {
        return this.b;
    }

    public boolean b() {
        return this.c / 100 == 2;
    }

    public int c() {
        return this.c;
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> d() {
        return this.e;
    }

    public com.qq.gdt.action.d.b.j e() {
        return this.f97a;
    }
}
