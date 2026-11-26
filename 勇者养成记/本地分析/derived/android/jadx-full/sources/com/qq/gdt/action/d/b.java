package com.qq.gdt.action.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.qq.gdt.action.d.b f83a;
    private com.qq.gdt.action.d.b.c b;
    private com.qq.gdt.action.d.b.c c;

    private b() {
        a(null);
        b(null);
    }

    public static com.qq.gdt.action.d.b a() {
        if (f83a == null) {
            synchronized (com.qq.gdt.action.d.b.class) {
                if (f83a == null) {
                    f83a = new com.qq.gdt.action.d.b();
                }
            }
        }
        return f83a;
    }

    private void a(com.qq.gdt.action.d.b.c cVar) {
        if (cVar == null) {
            cVar = new com.qq.gdt.action.d.b.c.a().a(new com.qq.gdt.action.d.b.a.d()).a(new com.qq.gdt.action.d.b.a.e(3)).a(new com.qq.gdt.action.d.b.a.f()).a();
        }
        this.b = cVar;
    }

    private void b(com.qq.gdt.action.d.b.c cVar) {
        if (this.c == null) {
            cVar = new com.qq.gdt.action.d.b.c.a().a(new com.qq.gdt.action.d.b.a.d()).a(new com.qq.gdt.action.d.b.a.e(3)).a();
        }
        this.c = cVar;
    }

    public static com.qq.gdt.action.d.e d() {
        return new com.qq.gdt.action.d.e();
    }

    public com.qq.gdt.action.d.b.c b() {
        return this.b;
    }

    public com.qq.gdt.action.d.b.c c() {
        return this.c;
    }
}
