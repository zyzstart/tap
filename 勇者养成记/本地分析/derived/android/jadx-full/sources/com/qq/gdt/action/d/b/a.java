package com.qq.gdt.action.d.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.qq.gdt.action.d.b.g f84a;
    private final com.qq.gdt.action.d.b.e b;
    private com.qq.gdt.action.d.b.c c;

    a(com.qq.gdt.action.d.b.e eVar, com.qq.gdt.action.d.b.g gVar, com.qq.gdt.action.d.b.c cVar) {
        this.b = eVar;
        this.f84a = gVar;
        this.c = cVar;
    }

    private com.qq.gdt.action.d.b.i b() throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(this.c.a());
        arrayList.add(new com.qq.gdt.action.d.b.a.a());
        return new com.qq.gdt.action.d.b.a.c(this.b, arrayList, 0, this.f84a, this).a(this.f84a);
    }

    public com.qq.gdt.action.d.b.i a() throws java.io.IOException {
        try {
            return b();
        } catch (java.io.IOException e) {
            throw new java.io.IOException(e);
        }
    }

    public void a(final com.qq.gdt.action.d.b.b bVar) {
        this.b.a().execute(new java.lang.Runnable() { // from class: com.qq.gdt.action.d.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.qq.gdt.action.d.b.i iVarA = com.qq.gdt.action.d.b.a.this.a();
                    if (bVar != null) {
                        bVar.a(iVarA);
                    }
                } catch (java.lang.Throwable th) {
                    com.qq.gdt.action.d.b.b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(th);
                    }
                }
            }
        });
    }
}
